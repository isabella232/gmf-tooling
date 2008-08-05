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

import java.util.Set;

import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ProtectedRegion;
import org.eclipse.gmf.internal.xpand.model.ProtectedRegionSyntaxException;
import org.eclipse.gmf.internal.xpand.model.XpandExecutionContext;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;
import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * @author Sven Efftinge
 */
public class ProtectStatement extends Statement {

    private final ExpressionHelper commentStart;

    private final ExpressionHelper commentEnd;

    private final Statement[] body;

    private final ExpressionHelper id;

    private final boolean disable;

    public ProtectStatement(final int start, final int end, final int line, final OCLExpressionCS commentStart,
            final OCLExpressionCS commentEnd, final Statement[] body, final OCLExpressionCS id, final boolean disable) {
        super(start, end, line);
        this.commentStart = new ExpressionHelper(commentStart);
        this.commentEnd = new ExpressionHelper(commentEnd);
        this.body = body;
        this.id = new ExpressionHelper(id);
        this.disable = disable;
    }

    public void analyze(final XpandExecutionContext ctx, final Set<AnalysationIssue> issues) {
        commentStart.analyze(ctx, issues);
        commentEnd.analyze(ctx, issues);
        id.analyze(ctx, issues);

        for (int i = 0; i < body.length; i++) {
            body[i].analyze(ctx, issues);
        }
    }

    @Override
    public void evaluateInternal(final XpandExecutionContext ctx) {
    	// FIXME REVISIT!!!
        final String cStart = nullSave(commentStart.evaluate(ctx));
        if (cStart == null) {
			throw new EvaluationException("NullEvaluation!", this, commentStart.getCST());
		}
        final String cEnd = nullSave(commentEnd.evaluate(ctx));
        if (cEnd == null) {
			throw new EvaluationException("NullEvaluation!", this, commentEnd.getCST());
		}
        final String idv = nullSave(id.evaluate(ctx));
        if (idv == null) {
			throw new EvaluationException("NullEvaluation!", this, id.getCST());
		}

        ProtectedRegion region = null;
        if (ctx.getProtectedRegionResolver() != null) {
            region = ctx.getProtectedRegionResolver().getProtectedRegion(idv);
        } else {
            throw new RuntimeException("No protected region resolver configured!");
        }

        if (region == null) {
            region = ctx.getProtectedRegionResolver().createProtectedRegion(idv, disable);
            ctx.getOutput().write(region.getStartString(cStart, cEnd));
            for (int i = 0; i < body.length; i++) {
                body[i].evaluate(ctx);
            }
            ctx.getOutput().write(region.getEndString(cStart, cEnd));
        } else {
            ctx.getOutput().write(region.getStartString(cStart, cEnd));
            try {
                ctx.getOutput().write(region.getBody(cStart, cEnd));
            } catch (final ProtectedRegionSyntaxException e) {
                throw new EvaluationException(e.getMessage(), this, id.getCST());
            }
            ctx.getOutput().write(region.getEndString(cStart, cEnd));
        }

    }

    // FIXME STUPID CODE?! never returns null while each use of the method checks for null
    private String nullSave(final Object string) {
        return string != null ? string.toString() : "";
    }

}
