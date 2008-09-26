/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.migration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.gmf.internal.xpand.model.XpandExecutionContextImpl;

public class MigrationExecutionContextImpl extends XpandExecutionContextImpl implements MigrationExecutionContext {

	private final Map<SyntaxElement, ExpressionAnalyzeTrace> traces;

	public MigrationExecutionContextImpl(ResourceManager resourceManager, EPackage... fallbackVisibleModels) {
		super(resourceManager, fallbackVisibleModels);
		traces = new HashMap<SyntaxElement, ExpressionAnalyzeTrace>();
	}

	protected MigrationExecutionContextImpl(MigrationExecutionContextImpl original) {
		super(original);
		traces = original.traces;
	}

	@Override
	public XpandExecutionContextImpl cloneContext() {
		return new MigrationExecutionContextImpl(this);
	}

	public Map<SyntaxElement, ExpressionAnalyzeTrace> getTraces() {
		return traces;
	}

}
