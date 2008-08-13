/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.migration;

import java.util.Set;

import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;

public class MigrationException extends Exception {

	private static final String LINE_SEPARATOR = "\n";

	public enum Type {

		RESOURCE_NOT_FOUND("Resource not found"),
		ANALYZATION_PROBLEMS("Analyzation problems"),
		INCORRECT_RESOURCE_NAME("Incorrect resource name"),
		UNSUPPORTED_EXTENSION("Incorrect extension"),
		METAMODEL_ALIAS_NOT_FOUND("Metamodel alias was not found"),
		TYPE_NOT_FOUND("Extension return type was not found"),
		UNSUPPORTED_EXPRESSION("Unsupported expression"), 
		UNSUPPORTED_BOOLEAN_OPERATION("Unsupported boolean operation"), 
		UNSUPPORTED_INFIX_OPERATION_PARAMETER("Unsupported infix operation parameter"),
		UNSUPPORTED_FEATURE_CALL_TRACE("Unsupported feature call trace"),
		UNSUPPORTED_FEATURE_CALL("Unsupported feature call"), 
		UNSUPPORTED_OPERATION_CALL_TRACE("Unsupported operation call trace"), 
		UNSUPPORTED_OPERATION_CALL("Unsupported operation call");

		private String name;

		private Type(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	private final Type type;

	private static final String getMessage(Set<AnalysationIssue> issues) {
		StringBuilder result = new StringBuilder("Following analyzation issues present");
		for (AnalysationIssue issue : issues) {
			result.append(LINE_SEPARATOR);
			result.append(issue.toString());
		}
		return result.toString();
	}

	public MigrationException(Type type, String message) {
		super(message);
		this.type = type;
	}

	public MigrationException(Set<AnalysationIssue> issues) {
		this(Type.ANALYZATION_PROBLEMS, getMessage(issues));
	}

	public MigrationException(Type type, EvaluationException e) {
		super(e);
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String getMessage() {
		return "[" + getType().toString() + "] - " + super.getMessage();
	}

}
