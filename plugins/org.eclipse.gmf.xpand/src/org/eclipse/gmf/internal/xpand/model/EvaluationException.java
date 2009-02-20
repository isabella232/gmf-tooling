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
package org.eclipse.gmf.internal.xpand.model;

import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;

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
    
    // TODO: review all usages
    public EvaluationException(final String msg) {
        super(msg);
        location = "";
    }

    public EvaluationException(final Throwable ex) {
        super(ex);
        location = "";
    }

    public EvaluationException(final AmbiguousDefinitionException e) {
    	super(e.getMessage());
    	location = location(e);
	}

	public EvaluationException(final String message, ExpressionHelper expressionHelper) {
		super(message);
		location = location(expressionHelper);
	}
	
	private String location(AmbiguousDefinitionException e) {
		// TODO: log line number here?
		String fileName = null;
		if (e.getDefinition1() != null) {
			fileName = e.getDefinition1().getOwner().getFullyQualifiedName();
		} else if (e.getDefinition2() != null) {
			fileName = e.getDefinition2().getOwner().getFullyQualifiedName();
		}
		if (fileName != null) {
			return ":in " + fileName;
		}
		return "";
	}

	private static String location(ExpressionHelper expressionHelper) {
		if (expressionHelper == null) {
			return "";
		}
		return ":in " + expressionHelper.getFileName() + ", line " + expressionHelper.getLine();
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
