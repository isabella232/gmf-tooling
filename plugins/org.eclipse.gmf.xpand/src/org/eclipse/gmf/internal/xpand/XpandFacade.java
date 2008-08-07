/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.internal.xpand;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.model.Scope;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.XpandResource;

/**
 * @author Sven Efftinge
 */
public class XpandFacade {
	private final Scope scope;
	private ExecutionContext ctx;

	public XpandFacade(Scope scope) {
		assert scope != null;
		this.scope = scope;
	}

	public XpandFacade(ExecutionContext ctx) {
		this(ctx.getScope());
		this.ctx = ctx;
	}

	public void evaluate(final String definitionName, final Object targetObject, Object[] params) {
		params = params == null ? new Object[0] : params;
		final EClassifier targetType = BuiltinMetaModel.getType(targetObject);
		final EClassifier[] paramTypes = new EClassifier[params.length];
		for (int i = 0; i < paramTypes.length; i++) {
			paramTypes[i] = BuiltinMetaModel.getType(params[i]);
		}

		final XpandDefinition def = getContext().findDefinition(definitionName, targetType, paramTypes);
		if (def == null) {
			throw new EvaluationException("No Definition " + definitionName + getParamString(paramTypes) + " for " + targetType.getName() + " could be found!", null);
		}

		ArrayList<Variable> vars = new ArrayList<Variable>(params.length + 1);
		vars.add(new Variable(ExecutionContext.IMPLICIT_VARIABLE, targetObject));
		for (int i = 0; i < params.length; i++) {
			vars.add(new Variable(def.getParams()[i].getVarName(), params[i]));
		}
		ExecutionContextImpl ctx = new ExecutionContextImpl(scope, def.getOwner(), vars);
		def.evaluate(ctx);
	}

	// FIXME Actually, we don't need the whole context, just currentResource(),
	// but that would be another story to fix.
	private ExecutionContext getContext() {
		if (ctx == null) {
			ctx = new ExecutionContextImpl(scope);
		}
		return ctx;
	}

	private String getParamString(final EClassifier[] paramTypes) {
		if (paramTypes.length == 0) {
			return "";
		}
		final StringBuilder buff = new StringBuilder("(");
		for (int i = 0; i < paramTypes.length; i++) {
			final EClassifier t = paramTypes[i];
			buff.append(t.getName());
			if (i + 1 < paramTypes.length) {
				buff.append(",");
			}
		}
		buff.append(")");
		return buff.toString();
	}

	public AnalysationIssue[] analyze(final String templateName) {
		final Set<AnalysationIssue> issues = new HashSet<AnalysationIssue>();
		final XpandResource tpl = scope.findTemplate(templateName);
		tpl.analyze(new ExecutionContextImpl(scope, tpl, null), issues);
		return issues.toArray(new AnalysationIssue[issues.size()]);
	}
}
