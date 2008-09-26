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
package org.eclipse.gmf.internal.xpand.expression.ast;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.migration.ExpressionAnalyzeTrace;
import org.eclipse.gmf.internal.xpand.migration.MigrationExecutionContext;

public abstract class SyntaxElement {

	protected final int start;

	protected final int end;

	protected final int line;

	protected int startOffset;

	protected int endOffset;

	public SyntaxElement(final int start, final int end, final int line, final int startOffset, final int endOffset) {
		this.start = start;
		this.end = end;
		this.line = line;
		this.startOffset = startOffset;
		this.endOffset = endOffset;
	}

	public int getLine() {
		return line;
	}

	public int getEnd() {
		return end;
	}

	public int getStart() {
		return start;
	}

	public int getStartOffset() {
		return startOffset;
	}
	
	public void setStartOffset(int startOffset) {
		this.startOffset = startOffset;
	}

	public int getEndOffset() {
		return endOffset;
	}
	
	public void setEndOffset(int endOffset) {
		this.endOffset = endOffset;
	}

	private String fileName;

	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	protected EClassifier createAnalyzeTrace(ExecutionContext ctx, ExpressionAnalyzeTrace trace) {
		if (ctx instanceof MigrationExecutionContext) {
			((MigrationExecutionContext) ctx).getTraces().put(this, trace);
		}
		return trace.getResultType();
	}
}
