/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.tests.xpand;

import org.eclipse.gmf.internal.xpand.ast.Statement;
import org.eclipse.gmf.internal.xpand.eval.EvaluationListener;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ast.Expression;
import org.eclipse.gmf.internal.xpand.model.XpandExecutionContext;

class DumpEvaluationListener extends EvaluationListener {
	private final StringBuilder sb = new StringBuilder(100);

	private int exprCount = 0;

	private int stmtCount = 0;

//	private int extCount = 0;

	@Override
	public void enter(Expression expr, ExecutionContext context) {
		print(expr.getClass().getSimpleName(), exprCount++, expr.getLine());
		sb.append(' ');
	}

//	@Override
//	public void enter(Extension ext, ExecutionContext context) {
//		print(ext.getClass().getSimpleName(), extCount++, ext.getLine());
//		sb.append(' ');
//	}

	@Override
	public void enter(Statement stmt, XpandExecutionContext context) {
		print(stmt.getClass().getSimpleName(), stmtCount++, stmt.getLine());
		sb.append(' ');
	}

	@Override
	public void leave(Expression expr, ExecutionContext context) {
		sb.setLength(sb.length() - 1);
		print(expr.getClass().getSimpleName(), --exprCount, expr.getLine());
	}

//	@Override
//	public void leave(Extension ext, ExecutionContext context) {
//		sb.setLength(sb.length() - 1);
//		print(ext.getClass().getSimpleName(), --extCount, ext.getLine());
//	}

	@Override
	public void leave(Statement stmt, XpandExecutionContext context) {
		sb.setLength(sb.length() - 1);
		print(stmt.getClass().getSimpleName(), --stmtCount, stmt.getLine());
	}

	private void print(String x, int i, int line) {
		System.err.println(sb.toString() + x + i + ':' + line);
	}
}