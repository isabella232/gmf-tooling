/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.util;

import java.util.Collection;

public class ParserException extends Exception {
	private static final long serialVersionUID = 1L;

	private final ErrorLocationInfo[] errors;
	private final String qualifiedResourceName;

	public ParserException(String qualifiedName, Collection<? extends ErrorLocationInfo> errors) {
		this(qualifiedName, errors.toArray(new ErrorLocationInfo[errors.size()]));
	}

	public ParserException(String qualifiedName, ErrorLocationInfo... errors) {
		assert errors != null && errors.length > 0;
		this.errors = errors;
		this.qualifiedResourceName = qualifiedName;
	}

	public ErrorLocationInfo[] getParsingErrors() {
		return errors;
	}
	
	public String getResourceName() {
		return qualifiedResourceName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName());
		sb.append(", @");
		sb.append(getResourceName());
		for (ErrorLocationInfo l : getParsingErrors()) {
			sb.append('\n');
			sb.append('\t');
			if (l.startLine == -1 || l.startOffset == -1) {
				sb.append("[unspecified location]");
			} else {
				sb.append('[');
				if (l.startLine != -1 && l.endLine != -1) {
					sb.append(l.startLine);
					sb.append(':');
					sb.append(l.startColumn);
					sb.append('-');
					sb.append(l.endLine);
					sb.append(':');
					sb.append(l.endColumn);
				} else {
					sb.append(l.startOffset);
					sb.append('-');
					sb.append(l.endOffset);
				}
				sb.append(']');
			}
			sb.append(' ');
			sb.append(l.message);
		}
		return sb.toString();
	}

	public static class ErrorLocationInfo {
		public final int startLine;
		public final int startColumn;
		public final int endLine;
		public final int endColumn;
		public final String message;
		public final int startOffset;
		public final int endOffset;

		public ErrorLocationInfo(String message) {
			this(message, -1, -1, -1, -1, -1, -1);
		}

		public ErrorLocationInfo(String message, int startLine, int startColumn, int endLine, int endColumn) {
			this(message, startLine, startColumn, endLine, endColumn, -1, -1);
		}

		public ErrorLocationInfo(String message, int startLine, int startColumn, int endLine, int endColumn, int startOffset, int endOffset) {
			this.message = message;
			this.startLine = startLine;
			this.startColumn = startColumn;
			this.endLine = endLine;
			this.endColumn = endColumn;
			this.startOffset = startOffset;
			this.endOffset = endOffset;
		}
	}
}
