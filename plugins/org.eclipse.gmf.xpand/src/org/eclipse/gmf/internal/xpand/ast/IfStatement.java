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

import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;
import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * @author Sven Efftinge
 */
public class IfStatement extends Statement {

    private final ExpressionHelper condition;

    private final Statement[] thenPart;

    private IfStatement elseIf;

    public IfStatement(final int start, final int end, final int line, final OCLExpressionCS condition,
            final Statement[] thenPart, final IfStatement elseIf) {
        super(start, end, line);
        this.condition = condition == null ? null : new ExpressionHelper(condition, this);
        this.thenPart = thenPart;
        this.elseIf = elseIf;
    }

    /**
	 * FIXME used in tests only, should I keep it?
	 */
	public ExpressionHelper getCondition() {
		return condition;
	}

	public IfStatement getElseIf() {
		return elseIf;
	}

    // XXX modifiable AST
    public void setElseIf(final IfStatement elseIf) {
        this.elseIf = elseIf;
    }

    public void analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        if (condition != null) {
            final EClassifier conType = condition.analyze(ctx, issues);
            if (conType != ctx.getOCLEnvironment().getOCLStandardLibrary().getBoolean()) {
                issues.add(new AnalysationIssue(AnalysationIssue.Type.INCOMPATIBLE_TYPES, "Boolean expected!", condition));
            }
        }
        for (int i = 0; i < thenPart.length; i++) {
            thenPart[i].analyze(ctx, issues);
        }
        if (elseIf != null) {
            elseIf.analyze(ctx, issues);
        }
    }

    @Override
    public void evaluateInternal(final ExecutionContext ctx) {
        if (condition != null) {
            final Object result = condition.evaluate(ctx);
            if (result == null) {
				throw new EvaluationException("Nullevaluation!", condition);
			}
            if (!(result instanceof Boolean)) {
				throw new EvaluationException("Boolean expected (was: " + result.getClass().getName() + ")!", condition);
			}
            if (((Boolean) result).booleanValue()) {
                for (int i = 0; i < thenPart.length; i++) {
                    thenPart[i].evaluate(ctx);
                }
            } else if (elseIf != null) {
                elseIf.evaluate(ctx);
            }
        } else {
            for (int i = 0; i < thenPart.length; i++) {
                thenPart[i].evaluate(ctx);
            }
        }
    }
    
    Statement[] getThenPart() {
    	return thenPart;
    }

}
