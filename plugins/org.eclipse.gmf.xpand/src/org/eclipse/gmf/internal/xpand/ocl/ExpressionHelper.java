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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

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
		Variable v = ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
		if (v != null) {
			env = (EcoreEnvironment) env.getFactory().createClassifierContext(env, (EClassifier) v.getValue());
		}
		OCLExpression expression = new EmbeddedOCLAnalyzer(env).analyzeExpression(expressionCS);
		return expression.getType();
	}

	public Object evaluate(ExecutionContext ctx) {
		EcoreEnvironment env = ctx.getOCLEnvironment();
		// FIXME move context handling with this->self inside ExecutionContextImpl? Or, it's better to have explicit,
		// separate environment for each execution?
		Variable self = ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);  
		if (self != null) {
			env = (EcoreEnvironment) env.getFactory().createInstanceContext(env, self.getValue());
		}
		OCLExpression expression = new EmbeddedOCLAnalyzer(env).analyzeExpression(expressionCS);
		OCL ocl = OCL.newInstance();
		Object val = ocl.evaluate(self == null ? null : self.getValue(), expression);
		if (ocl.isInvalid(val)) {
			// TODO serialize CST to show actual string that's wrong
			throw new EvaluationException("Can't evaluate expression: retured value is OclInvalid", null);
		}
		return val;
	}
}
