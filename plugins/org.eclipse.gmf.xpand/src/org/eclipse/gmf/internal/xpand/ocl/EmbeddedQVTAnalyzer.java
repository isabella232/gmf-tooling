/*
 * Copyright (c) 2008, 2010 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */

package org.eclipse.gmf.internal.xpand.ocl;

import lpg.runtime.Monitor;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOLexer;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParser;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * @author artem
 *
 */
class EmbeddedQVTAnalyzer extends QvtOperationalVisitorCS {

	EmbeddedQVTAnalyzer(EcoreEnvironment env) {
		super(new QVTOParser(new QVTOLexer(env)) {
			@Override
			public String getTokenKindName(int kind) {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public CSTNode parser(Monitor monitor, int error_repair_count) {
				throw new UnsupportedOperationException();
			}
		}, options());
	}

	public OCLExpression<EClassifier> analyzeExpression(OCLExpressionCS oclExpressionCS) {
		return super.oclExpressionCS(oclExpressionCS, getOCLEnvironment());
	}

	private static QvtCompilerOptions options() {
		QvtCompilerOptions options = new QvtCompilerOptions();
		options.setGenerateCompletionData(false);
		options.setShowAnnotations(false);
		return options;
	}
}
