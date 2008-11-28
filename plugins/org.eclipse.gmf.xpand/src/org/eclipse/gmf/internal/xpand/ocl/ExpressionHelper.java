/*
 * Copyright (c) 2008 Borland Software Corporation
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

import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.parser.OCLProblemHandler;

public class ExpressionHelper {

	private final OCLExpressionCS expressionCS;

	public ExpressionHelper(OCLExpressionCS exprCS) {
		assert exprCS != null;
		this.expressionCS = exprCS;
	}

	public OCLExpressionCS getCST() {
		return expressionCS;
	}

	public EClassifier analyze(ExecutionContext ctx, Set<AnalysationIssue> issues) {
		EcoreEnvironment env = ctx.getOCLEnvironment();
		OCLExpression<EClassifier> expression = new EmbeddedQVTAnalyzer(env).analyzeExpression(expressionCS);
		handleOCLAnalyzationErrors(env.getProblemHandler(), issues);
		return expression.getType();
	}

	/**
	 * Temporary method reporting errors came from QVT expression analysis.
	 * TODO: make it working
	 */
	private void handleOCLAnalyzationErrors(ProblemHandler problemHandler, Set<AnalysationIssue> issues) {
		if (problemHandler instanceof org.eclipse.ocl.parser.OCLProblemHandler) {
			org.eclipse.ocl.parser.OCLProblemHandler oclProblemHandler = (OCLProblemHandler) problemHandler;
			Diagnostic diagnostic = oclProblemHandler.getDiagnostic();
			if (diagnostic != null && diagnostic.getSeverity() == Diagnostic.ERROR) {
				issues.add(new AnalysationIssue(AnalysationIssue.Type.INCOMPATIBLE_TYPES, diagnostic.getMessage(), this));
			}
		}
	}

	public Object evaluate(ExecutionContext ctx) {
		EcoreEnvironment env = ctx.getOCLEnvironment();
		//
		OCLExpression<EClassifier> expression = new EmbeddedQVTAnalyzer(env).analyzeExpression(expressionCS);
		EcoreEvaluationEnvironment evaluationEnv = ctx.createEvaluationEnvironment();
		QvtOperationalEvaluationVisitorImpl visitor = QvtOperationalEvaluationVisitorImpl.createNonTransformationExecutionContextVisitor(QvtOperationalEnvFactory.INSTANCE.createEnvironment(), (QvtOperationalEvaluationEnv) evaluationEnv, ctx.getImportedModules());		
		Object val = visitor.visitExpression(expression);
		if (env.getOCLStandardLibrary().getOclInvalid() == val) {
			throw new EvaluationException("Can't evaluate expression: retured value is OclInvalid", null);
		}
		return val;		
	}
	
}
