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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.gmf.internal.xpand.expression.ast.BooleanOperation;
import org.eclipse.gmf.internal.xpand.expression.ast.Case;
import org.eclipse.gmf.internal.xpand.expression.ast.Cast;
import org.eclipse.gmf.internal.xpand.expression.ast.ChainExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.CollectionExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.Expression;
import org.eclipse.gmf.internal.xpand.expression.ast.FeatureCall;
import org.eclipse.gmf.internal.xpand.expression.ast.IfExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.LetExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.ListLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.OperationCall;
import org.eclipse.gmf.internal.xpand.expression.ast.SwitchExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.TypeSelectExpression;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExpressionExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.Extension;

public class VariableNameDispatcher {

	private static final String ITERATOR_PREFIX = "it";

	private static final String VARIABLE_PREFIX = "tmpVar";

	private Set<String> definedVariables;

	public VariableNameDispatcher(Extension extension) {
		definedVariables = new HashSet<String>();
		initDefinedVariables(extension);
	}

	private void initDefinedVariables(Extension extension) {
		for (String parameterName : extension.getParameterNames()) {
			definedVariables.add(parameterName);
		}
		if (extension instanceof ExpressionExtensionStatement) {
			initDefinedVariables(((ExpressionExtensionStatement) extension).getExpression());
		}
	}

	private void initDefinedVariables(Expression expression) {
		if (expression instanceof BooleanOperation) {
			BooleanOperation booleanOperation = (BooleanOperation) expression;
			initDefinedVariables(booleanOperation.getLeft());
			initDefinedVariables(booleanOperation.getRight());
		} else if (expression instanceof Cast) {
			Cast cast = (Cast) expression;
			initDefinedVariables(cast.getTarget());
		} else if (expression instanceof ChainExpression) {
			ChainExpression chainExpression = (ChainExpression) expression;
			initDefinedVariables(chainExpression.getFirst());
			initDefinedVariables(chainExpression.getNext());
		} else if (expression instanceof CollectionExpression) {
			CollectionExpression collectionExpression = (CollectionExpression) expression;
			initDefinedVariables(collectionExpression.getClosure());
			initDefinedVariablesOfTarget(collectionExpression);
			definedVariables.add(collectionExpression.getElementName());
		} else if (expression instanceof OperationCall) {
			OperationCall operationCall = (OperationCall) expression;
			initDefinedVariablesOfTarget(operationCall);
			for (int i = 0; i < operationCall.getParams().length; i++) {
				initDefinedVariables(operationCall.getParams()[i]);
			}
		} else if (expression instanceof TypeSelectExpression) {
			TypeSelectExpression typeSelect = (TypeSelectExpression) expression;
			initDefinedVariablesOfTarget(typeSelect);
		} else if (expression instanceof FeatureCall) {
			FeatureCall featureCall = (FeatureCall) expression;
			initDefinedVariablesOfTarget(featureCall);
		} else if (expression instanceof IfExpression) {
			IfExpression ifExpression = (IfExpression) expression;
			initDefinedVariables(ifExpression.getCondition());
			initDefinedVariables(ifExpression.getThenPart());
			initDefinedVariables(ifExpression.getElsePart());
		} else if (expression instanceof LetExpression) {
			LetExpression letExpression = (LetExpression) expression;
			initDefinedVariables(letExpression.getVarExpression());
			initDefinedVariables(letExpression.getTargetExpression());
			definedVariables.add(letExpression.getVarName().getValue());
		} else if (expression instanceof ListLiteral) {
			ListLiteral listLiteral = (ListLiteral) expression;
			for (int i = 0; i < listLiteral.getElements().length; i++) {
				initDefinedVariables(listLiteral.getElements()[i]);
			}
		} else if (expression instanceof SwitchExpression) {
			SwitchExpression switchExpression = (SwitchExpression) expression;
			initDefinedVariables(switchExpression.getSwitchExpr());
			initDefinedVariables(switchExpression.getDefaultExpr());
			for (Case caseExpresion : switchExpression.getCases()) {
				initDefinedVariables(caseExpresion.getCondition());
				initDefinedVariables(caseExpresion.getThenPart());
			}
		}
	}

	private void initDefinedVariablesOfTarget(FeatureCall featrueCall) {
		if (featrueCall.getTarget() != null) {
			initDefinedVariables(featrueCall.getTarget());
		}
	}

	public String getNextIteratorName() {
		return getUniqueName(ITERATOR_PREFIX);
	}

	public String getNextVariableName() {
		return getUniqueName(VARIABLE_PREFIX);
	}

	private String getUniqueName(String prefix) {
		String iteratorName = prefix;
		for (int i = 1; definedVariables.contains(iteratorName); i++) {
			iteratorName = prefix + "_" + i;
		}
		definedVariables.add(iteratorName);
		return iteratorName;
	}

}
