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
import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;
import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * @author Sven Efftinge
 */
public class FileStatement extends Statement {

    private final ExpressionHelper fileName;

    private final Statement[] body;

    private final Identifier mode;

    public FileStatement(final int start, final int end, final int line, final OCLExpressionCS fileNameCS, final Statement[] body, final Identifier mode) {
        super(start, end, line);
        this.fileName = new ExpressionHelper(fileNameCS, this);
        this.body = body;
        this.mode = mode;
    }

    /**
	 * FIXME next 3 methods are for tests only, shouldn't I refactor tests to avoid exposing internals?
	 */
    public ExpressionHelper getTargetFileName() {
    	return fileName;
    }
	public Statement[] getBody() {
		return body;
	}
	public Identifier getMode() {
		return mode;
	}

    public void analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        final EClassifier result = fileName.analyze(ctx, issues);
        if (ctx.getOCLEnvironment().getOCLStandardLibrary().getString() != result) {
            issues.add(new AnalysationIssue(AnalysationIssue.Type.INCOMPATIBLE_TYPES, "String expected!", fileName));
        }
        for (Statement element : body) {
            element.analyze(ctx, issues);
        }
    }

    @Override
    public void evaluateInternal(final ExecutionContext ctx) {
        final Object result = fileName.evaluate(ctx);
        if (result == null) {
			throw new EvaluationException("Nullevaluation", fileName);
		}
        final String fileName = result.toString();
        String modeVal = null;
        if (mode != null) {
            modeVal = mode.getValue();
        }
        ctx.getScope().getOutput().openFile(fileName, modeVal);
        for (Statement element : body) {
            element.evaluate(ctx);
        }
        ctx.getScope().getOutput().closeFile();
    }
}
