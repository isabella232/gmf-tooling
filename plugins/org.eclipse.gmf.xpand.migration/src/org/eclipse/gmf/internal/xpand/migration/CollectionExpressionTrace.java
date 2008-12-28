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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.expression.ast.CollectionExpression;

public class CollectionExpressionTrace extends ExpressionAnalyzeTrace {

	public enum Type {
		UNDESOLVED_TARGET_TYPE, COLLECT_REF, SELECT_REF, REJECT_REF, EXISTS_REF, NOTEXISTS_REF, FORALL_REF, INCORRECT_EXPRESSION_TYPE
	}

	private Type type;

	public static Type getType(CollectionExpression expression) {
		String expressionName = expression.getName().getValue();
		if (SyntaxConstants.COLLECT.equals(expressionName)) {
			return Type.COLLECT_REF;
		} else if (SyntaxConstants.SELECT.equals(expressionName)) {
			return Type.SELECT_REF;
		} else if (SyntaxConstants.REJECT.equals(expressionName)) {
			return Type.REJECT_REF;
		} else if (SyntaxConstants.EXISTS.equals(expressionName)) {
			return Type.EXISTS_REF;
		} else if (SyntaxConstants.NOT_EXISTS.equals(expressionName)) {
			return Type.NOTEXISTS_REF;
		} else if (SyntaxConstants.FOR_ALL.equals(expressionName)) {
			return Type.FORALL_REF;
		}
		return Type.INCORRECT_EXPRESSION_TYPE;
	}

	public CollectionExpressionTrace(EClassifier result, Type type) {
		super(result);
		this.type = type;
	}

	public Type getType() {
		return type;
	}

}
