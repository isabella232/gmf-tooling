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
package org.eclipse.gmf.internal.xpand.model;

import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.ocl.cst.CSTNode;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class EvaluationException extends RuntimeException {

	private static final long serialVersionUID = 542684666287282979L;
	private final String location;

    public EvaluationException(final String msg, final SyntaxElement element) {
        super(msg);
        location = location(element);
    }

    public EvaluationException(final Throwable ex, final SyntaxElement element) {
        super(ex);
        location = location(element);
    }

    public EvaluationException(final String msg, final SyntaxElement element, final CSTNode node) {
        super(msg);
        location = location(element) + " [" + node.getStartOffset() + ".." + node.getEndOffset() + "]";
    }

    public EvaluationException(AmbiguousDefinitionException e) {
    	this(e.getMessage(), null);
	}

	private static String location(SyntaxElement element) {
    	if (element == null) {
    		return "";
    	}
    	return ":in " + element.getFileName() + ", line " + element.getLine();
    }

    @Override
    public String getMessage() {
        return super.getMessage() + location;
    }
}
