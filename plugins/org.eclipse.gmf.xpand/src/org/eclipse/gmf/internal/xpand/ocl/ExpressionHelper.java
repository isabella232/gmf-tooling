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

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OCLExpression;

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
		OCLExpression<EClassifier> expression = new EmbeddedOCLAnalyzer(env).analyzeExpression(expressionCS);
		return expression.getType();
	}

	public Object evaluate(ExecutionContext ctx) {
		EcoreEnvironment env = ctx.getOCLEnvironment();
		//
		OCLExpression<EClassifier> expression = new EmbeddedOCLAnalyzer(env).analyzeExpression(expressionCS);
		EcoreEvaluationEnvironment evaluationEnv = ctx.createEvaluationEnvironment();
		Map<? extends EClass, ? extends Set<? extends EObject>> extentMap = Collections.emptyMap();
		EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> visitor = env.getFactory().createEvaluationVisitor(env, evaluationEnv, extentMap);
		Object val = visitor.visitExpression(expression);
		if (env.getOCLStandardLibrary().getOclInvalid() == val) {
			throw new EvaluationException("Can't evaluate expression: retured value is OclInvalid", null);
		}
		return val;
	}
}
