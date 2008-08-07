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
package org.eclipse.gmf.internal.xpand.ast;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.gmf.internal.xpand.model.XpandIterator;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;
import org.eclipse.ocl.cst.OCLExpressionCS;

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

    public ForEachStatement(final int start, final int end, final int line, final Identifier variable,
            final OCLExpressionCS target, final Statement[] body, final OCLExpressionCS separator, final Identifier iterator) {
        super(start, end, line);
        this.variable = variable;
        this.target = new ExpressionHelper(target);
        this.body = body;
        this.separator = separator == null ? null : new ExpressionHelper(separator);
        iteratorName = iterator;
    }

    public void analyze(ExecutionContext ctx, final Set<AnalysationIssue> issues) {
    	EClassifier t = target.analyze(ctx, issues);
        if (separator != null) {
            final EClassifier sepT = separator.analyze(ctx, issues);
            if (!BuiltinMetaModel.isAssignableFrom(EcorePackage.eINSTANCE.getEString(), sepT)) {
                issues.add(new AnalysationIssue(AnalysationIssue.Type.INCOMPATIBLE_TYPES, "String expected!", target));
            }
        }
        if (t != null) {
            if (BuiltinMetaModel.isCollectionType(t)) {
                if (BuiltinMetaModel.isParameterizedType(t)) {
                    t = BuiltinMetaModel.getInnerType(t);
                } else {
                    t = EcorePackage.eINSTANCE.getEJavaObject();
                }
            } else {
                issues.add(new AnalysationIssue(AnalysationIssue.Type.INCOMPATIBLE_TYPES, "Collection type expected!", target));
                return;
            }
        }
        ctx = ctx.cloneWithVariable(new Variable(variable.getValue(), t));
        if (iteratorName != null) {
            ctx = ctx.cloneWithVariable(new Variable(iteratorName.getValue(), BuiltinMetaModel.ITERATOR_TYPE));
        }
        for (Statement statement : body) {
            statement.analyze(ctx, issues);
        }
    }

    @Override
    public void evaluateInternal(ExecutionContext ctx) {
        final Object o = target.evaluate(ctx);

        if (!(o instanceof Collection)) {
			throw new EvaluationException("Collection expected!", this, target.getCST());
		}
        final Collection<?> col = (Collection<?>) o;
        final String sep = (String) (separator != null ? separator.evaluate(ctx) : null);
        final XpandIterator iterator = new XpandIterator(col.size());

        if (iteratorName != null) {
            ctx = ctx.cloneWithVariable(new Variable(iteratorName.getValue(), iterator));
        }
        for (final Iterator<?> iter = col.iterator(); iter.hasNext();) {
            final Object element = iter.next();
            ctx = ctx.cloneWithVariable(new Variable(variable.getValue(), element));
            for (int i = 0; i < body.length; i++) {
                body[i].evaluate(ctx);
            }
            if ((sep != null) && iter.hasNext()) {
                ctx.getScope().getOutput().write(sep);
            }
            iterator.increment();
        }
    }
}
