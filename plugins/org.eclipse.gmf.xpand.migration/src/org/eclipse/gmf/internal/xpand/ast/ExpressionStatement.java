/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.gmf.internal.xpand.ast;

import java.util.Set;

import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.ast.Expression;
import org.eclipse.gmf.internal.xpand.migration.ExpressionAnalyzeTrace;
import org.eclipse.gmf.internal.xpand.model.XpandExecutionContext;

/**
 * @author Sven Efftinge
 */
public class ExpressionStatement extends org.eclipse.gmf.internal.xpand.ast.Statement {

    private final Expression expression;

    public ExpressionStatement(final int start, final int end, final int line, final int startOffset, final int endOffset, final Expression expression) {
        super(start, end, line, startOffset, endOffset);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void analyze(final XpandExecutionContext ctx, final Set<AnalysationIssue> issues) {
		createAnalyzeTrace(ctx, new ExpressionAnalyzeTrace(getExpression().analyze(ctx, issues)));
	}

    @Override
    public void evaluateInternal(final XpandExecutionContext ctx) {
        final Object val = getExpression().evaluate(ctx);
        if (val != null) {
            ctx.getOutput().write(val.toString());
        }
    }
}
