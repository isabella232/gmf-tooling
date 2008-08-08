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
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.expression.ast.Expression;

public class MigrationExecutionContextImpl extends ExecutionContextImpl implements MigrationExecutionContext {

	private final Map<Expression, ExpressionAnalyzeTrace> traces;

	public MigrationExecutionContextImpl(ResourceManager resourceManager, EPackage... fallbackVisibleModels) {
		super(resourceManager, fallbackVisibleModels);
		traces = new HashMap<Expression, ExpressionAnalyzeTrace>();
	}

	protected MigrationExecutionContextImpl(MigrationExecutionContextImpl original) {
		super(original);
		traces = original.traces;
	}

	@Override
	public ExecutionContext cloneContext() {
		return new MigrationExecutionContextImpl(this);
	}

	public Map<Expression, ExpressionAnalyzeTrace> getTraces() {
		return traces;
	}

}
