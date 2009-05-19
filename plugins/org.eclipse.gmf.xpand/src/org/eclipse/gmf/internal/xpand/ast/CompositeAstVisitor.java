/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.ast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.gmf.internal.xpand.model.XpandAdvice;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;

public class CompositeAstVisitor implements AstVisitor {

	private AstVisitor[] myVisitors;

	public CompositeAstVisitor(AstVisitor... visitors) {
		myVisitors = visitors;
	}

	public boolean visit(Template template) {
		return visitAll(template, Template.class);
	}

	public boolean visit(XpandAdvice advice) {
		return visitAll(advice, XpandAdvice.class);
	}

	public boolean visit(XpandDefinition definition) {
		return visitAll(definition, XpandDefinition.class);
	}

	public boolean visit(ErrorStatement statement) {
		return visitAll(statement, ErrorStatement.class);
	}

	public boolean visit(ExpandStatement statement) {
		return visitAll(statement, ExpandStatement.class);
	}

	public boolean visit(ExpressionStatement statement) {
		return visitAll(statement, ExpressionStatement.class);
	}

	public boolean visit(FileStatement statement) {
		return visitAll(statement, FileStatement.class);
	}

	public boolean visit(ForEachStatement statement) {
		return visitAll(statement, ForEachStatement.class);
	}

	public boolean visit(IfStatement statement) {
		return visitAll(statement, IfStatement.class);
	}

	public boolean visit(LetStatement statement) {
		return visitAll(statement, LetStatement.class);
	}

	public boolean visit(ProtectStatement statement) {
		return visitAll(statement, ProtectStatement.class);
	}

	public boolean visit(TextStatement statement) {
		return visitAll(statement, TextStatement.class);
	}

	public boolean visit(Statement statement) {
		return visitAll(statement, Statement.class);
	}

	private boolean visitAll(Object astElement, Class<?> parameterType) {
		try {
			Method visitMethod = AstVisitor.class.getMethod("visit", parameterType);
			boolean breakIteration = true;
			for (AstVisitor visitor : myVisitors) {
				Object result = visitMethod.invoke(visitor, astElement);
				assert result instanceof Boolean;
				breakIteration = breakIteration && !((Boolean) result);
			}
			return !breakIteration;
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		}
		assert false : "incorrect parameter type passed";
		return false;
	}

}
