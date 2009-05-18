/*
 * Copyright (c) 2005, 2009 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.internal.xpand.ast;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;
import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * @author Sven Efftinge
 */
public class LetStatement extends Statement {

	private final Identifier varName;

	private final ExpressionHelper varValue;

	private final Statement[] body;

	public LetStatement(final int start, final int end, final int line, final Identifier varName, final OCLExpressionCS value, final Statement[] body) {
		super(start, end, line);
		this.varName = varName;
		this.varValue = new ExpressionHelper(value, this);
		this.body = body;
	}

	public void analyze(ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		ctx = ctx.cloneWithVariable(new Variable(varName.getValue(), getVarType(ctx, issues), null));
		for (Statement statement : body) {
			statement.analyze(ctx, issues);
		}
	}

	@Override
	public void evaluateInternal(ExecutionContext ctx) {
		Set<AnalysationIssue> issues = new HashSet<AnalysationIssue>();
		EClassifier varType = getVarType(ctx, issues);
		if (issues.size() > 0) {
			throw new EvaluationException("Can't evaluate LET expression: variable type cannot be defined", varValue);	
		}
		Object evaluatedVarValue = varValue.evaluate(ctx);
		if (!BuiltinMetaModel.isAssignableFrom(ctx, varType, BuiltinMetaModel.getType(ctx, evaluatedVarValue))) {
			throw new EvaluationException("Can't evaluate LET expression: actual variable type is not assignable to declared one", this);
		}
		ctx = ctx.cloneWithVariable(new Variable(varName.getValue(), varType, evaluatedVarValue));
		for (Statement statement : body) {
			statement.evaluate(ctx);
		}
	}
	
	private EClassifier getVarType(ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		EClassifier t = varValue.analyze(ctx, issues);
		return t == null ? t = EcorePackage.eINSTANCE.getEObject() : t;
	}
	
	ExpressionHelper getVarValue() {
		return varValue;
	}
	
	Statement[] getBody() {
		return body;
	}

}
