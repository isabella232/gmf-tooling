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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.gmf.internal.xpand.model.XpandIterator;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.ecore.CollectionType;

/**
 * @author Sven Efftinge
 */
public class ForEachStatement extends Statement {

	public static final String ITERATOR_VAR_NAME = "iterator";

	private final Statement[] body;

	private final ExpressionHelper target;

	private final ExpressionHelper separator;

	private final Identifier variable;

	private final Identifier iteratorName;

	public ForEachStatement(final int start, final int end, final int line, final Identifier variable, final OCLExpressionCS target, final Statement[] body, final OCLExpressionCS separator, final Identifier iterator) {
		super(start, end, line);
		this.variable = variable;
		this.target = new ExpressionHelper(target, this);
		this.body = body;
		this.separator = separator == null ? null : new ExpressionHelper(separator, this);
		iteratorName = iterator;
	}

	public void analyze(ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		EClassifier t = target.analyze(ctx, issues);
		if (separator != null) {
			final EClassifier sepT = separator.analyze(ctx, issues);
			if (ctx.getOCLEnvironment().getOCLStandardLibrary().getString() != sepT) {
				issues.add(new AnalysationIssue(AnalysationIssue.Type.INCOMPATIBLE_TYPES, "String expected!", target));
			}
		}
		if (t != null) {
			if (t instanceof CollectionType) {
				t = ((CollectionType) t).getElementType();
			} else {
				issues.add(new AnalysationIssue(AnalysationIssue.Type.INCOMPATIBLE_TYPES, "Collection type expected!", target));
				return;
			}
		}
		// XXX odd - is t == null ok here?
		ctx = ctx.cloneWithVariable(new Variable(variable.getValue(), t, null));
		if (iteratorName != null) {
			ctx = ctx.cloneWithVariable(new Variable(iteratorName.getValue(), BuiltinMetaModel.ITERATOR_TYPE, null));
		}
		for (Statement statement : body) {
			statement.analyze(ctx, issues);
		}
	}

	@Override
	public void evaluateInternal(ExecutionContext ctx) {
		Set<AnalysationIssue> issues = new HashSet<AnalysationIssue>();
		EClassifier targetType = target.analyze(ctx, issues);
		if (issues.size() > 0 || false == targetType instanceof CollectionType) {
			throw new EvaluationException("Can't evaluate FOREACH expression: target collection type cannot be defined", target);
		}
		EClassifier targetElementType = ((CollectionType) targetType).getElementType();
		final Object o = target.evaluate(ctx);

		if (!(o instanceof Collection<?>)) {
			throw new EvaluationException("Collection expected (was: " + o.getClass().getName() + ")!", target);
		}
		final Collection<?> col = (Collection<?>) o;
		final String sep = (String) (separator != null ? separator.evaluate(ctx) : null);
		final XpandIterator iterator = new XpandIterator(col.size());

		if (iteratorName != null) {
			ctx = ctx.cloneWithVariable(new Variable(iteratorName.getValue(), BuiltinMetaModel.ITERATOR_TYPE, iterator));
		}
		for (final Iterator<?> iter = col.iterator(); iter.hasNext();) {
			final Object element = iter.next();
			if (!BuiltinMetaModel.isAssignableFrom(ctx, targetElementType, BuiltinMetaModel.getType(ctx, element))) {
				throw new EvaluationException("Can't evaluate FOREACH expression: actual collection element type is not assignable to declared collection element type", this);
			}
			ctx = ctx.cloneWithVariable(new Variable(variable.getValue(), targetElementType, element));
			for (int i = 0; i < body.length; i++) {
				body[i].evaluate(ctx);
			}
			if ((sep != null) && iter.hasNext()) {
				ctx.getScope().getOutput().write(sep);
			}
			iterator.increment();
		}
	}
	
	ExpressionHelper getSeparator() {
		return separator;
	}
	
	ExpressionHelper getTarget() {
		return target;
	}
	
	Statement[] getBody() {
		return body;
	}
	
}
