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

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;

public class MigrationException extends Exception {

	private static final long serialVersionUID = 8066639467181143331L;

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
		UNSUPPORTED_FEATURE_CALL_TRACE("Unsupported feature call trace"),
		UNSUPPORTED_FEATURE_CALL("Unsupported feature call"),
		UNSUPPORTED_OPERATION_CALL_TRACE("Unsupported operation call trace"),
		UNSUPPORTED_OPERATION_CALL("Unsupported operation call"),
		UNSUPPORTED_COLLECTION_EXPRESSION_TRACE("Unsupported collection expression trace"),
		UNSUPPORTED_COLLECTION_EXPRESSION("Unsupported collection expression"),
		UNSUPPORTED_COLLECTION_OPERATION("Unsupported collection operation"),
		UNSUPPORTED_TYPE_SELECT_EXPRESSION_TRACE("Unsupported type select expression trace"),
		UNSUPPORTED_TYPE_SELECT_EXPRESSION("Unsupported type select expression"),
		
		UNSUPPORTED_ASPECT("Unsupported aspect migration"), 
		UNSUPPORTED_XPAND_RESOURCE("Unsupported xpand resource"),
		UNSUPPORTED_XTEND_RESOURCE("Unsupported xtend resource"),
		UNABLE_TO_APPLY_EDIT("Unable to apply edit"),
		UNABLE_TO_DETECT_NATIVE_LIBRARY_CLASS_NAME("Unable to detect native library class name"),
		UNSUPPORTED_NATIVE_EXTENSION_TYPE("Unsupported native extension type");

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

	private Set<AnalysationIssue> issues = Collections.emptySet();

	private String resourceName;

	private int lineNumber = -1;

	private int startPosition;

	private int endPosition;

	private static final String getMessage(Set<AnalysationIssue> issues) {
		StringBuilder result = new StringBuilder("Following analyzation issues present");
		for (AnalysationIssue issue : getErrors(issues)) {
			result.append(LINE_SEPARATOR);
			result.append(issue.toString());
		}
		return result.toString();
	}
	
	private static final Set<AnalysationIssue> getErrors(Set<AnalysationIssue> issues) {
		Set<AnalysationIssue> result = new LinkedHashSet<AnalysationIssue>();
		for (AnalysationIssue issue : issues) {
			if (!issue.isWarningNotError()) {
				result.add(issue);
			}
		}
		return result;
	}
	
	public static final boolean hasErrors(Set<AnalysationIssue> issues) {
		return getErrors(issues).size() > 0;
	}

	/**
	 * Resource-wide Exception (position was not determined) 
	 */
	public MigrationException(Type type, String resourceName, String message) {
		this(type, resourceName, null, message);
	}
	
	public MigrationException(Type type, String resourceName, SyntaxElement syntaxElement, String message) {
		super(message);
		this.type = type;
		this.resourceName = resourceName;
		if (syntaxElement != null) {
			lineNumber = syntaxElement.getLine();
			startPosition = syntaxElement.getStart();
			endPosition = syntaxElement.getEnd();
		}
	}

	public MigrationException(Set<AnalysationIssue> issues, String resourceName) {
		this(Type.ANALYZATION_PROBLEMS, resourceName, getMessage(issues));
		this.issues = issues;
	}

	public MigrationException(Set<AnalysationIssue> issues, String resourceName, SyntaxElement syntaxElement) {
		this(Type.ANALYZATION_PROBLEMS, resourceName, syntaxElement, getMessage(issues));
		this.issues = issues;
	}

	public MigrationException(Type type, String resourceName, SyntaxElement syntaxElement, EvaluationException e) {
		super(e);
		this.type = type;
		this.resourceName = resourceName;
		if (syntaxElement != null) {
			lineNumber = syntaxElement.getLine();
			startPosition = syntaxElement.getStart();
			endPosition = syntaxElement.getEnd();
		}
	}
	
	public MigrationException(Type type, String resourceName, SyntaxElement syntaxElement, ExpressionAnalyzeTrace trace) {
		this(type, resourceName, syntaxElement, String.valueOf(trace));
	}

	public Type getType() {
		return type;
	}
	
	public Set<AnalysationIssue> getIssues() {
		return issues;
	}

	@Override
	public String getMessage() {
		return "[" + getType().toString() + "] in " + resourceName + getPosition() + " - " + super.getMessage();
	}
	
	private String getPosition() {
		if (lineNumber != -1) {
			return " " + lineNumber + ":" + (startPosition + 1) + " - " + lineNumber + ":" + (endPosition + 1);			
		}
		return "";
	}

}
