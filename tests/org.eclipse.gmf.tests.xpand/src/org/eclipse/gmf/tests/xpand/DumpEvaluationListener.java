/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.gmf.tests.xpand;

import org.eclipse.gmf.internal.xpand.ast.Statement;
import org.eclipse.gmf.internal.xpand.eval.EvaluationListener;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;

class DumpEvaluationListener extends EvaluationListener {
	private final StringBuilder sb = new StringBuilder(100);

	private int stmtCount = 0;


	@Override
	public void enter(Statement stmt, ExecutionContext context) {
		print(stmt.getClass().getSimpleName(), stmtCount++, stmt.getLine());
		sb.append(' ');
	}

	@Override
	public void leave(Statement stmt, ExecutionContext context) {
		sb.setLength(sb.length() - 1);
		print(stmt.getClass().getSimpleName(), --stmtCount, stmt.getLine());
	}

	private void print(String x, int i, int line) {
		System.err.println(sb.toString() + x + i + ':' + line);
	}
}