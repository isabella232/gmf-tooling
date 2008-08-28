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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.ast.BooleanLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.BooleanOperation;
import org.eclipse.gmf.internal.xpand.expression.ast.Case;
import org.eclipse.gmf.internal.xpand.expression.ast.Cast;
import org.eclipse.gmf.internal.xpand.expression.ast.ChainExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.CollectionExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.ConstructorCallExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.Expression;
import org.eclipse.gmf.internal.xpand.expression.ast.FeatureCall;
import org.eclipse.gmf.internal.xpand.expression.ast.IfExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.IntegerLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.LetExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.ListLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.NullLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.OperationCall;
import org.eclipse.gmf.internal.xpand.expression.ast.RealLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.StringLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.SwitchExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.TypeSelectExpression;
import org.eclipse.gmf.internal.xpand.migration.MigrationException.Type;


public class ExpressionMigrationFacade {
	
	static final CharSequence LF = System.getProperty("line.separator");
	
	private static final Set<EOperation> infixOperations = new HashSet<EOperation>(Arrays.asList(new EOperation[] {
			BuiltinMetaModel.Boolean_NE,
			BuiltinMetaModel.Int_Unary_Minus,
			BuiltinMetaModel.Double_Unary_Minus,
			BuiltinMetaModel.Int_Minus_Double, 
			BuiltinMetaModel.Int_Minus_Int, 
			BuiltinMetaModel.Double_Minus_Double, 
			BuiltinMetaModel.Double_Minus_Int,
			BuiltinMetaModel.Int_Plus_Double, 
			BuiltinMetaModel.Int_Plus_Int, 
			BuiltinMetaModel.Double_Plus_Double, 
			BuiltinMetaModel.Double_Plus_Int,
			BuiltinMetaModel.Int_Mult_Double, 
			BuiltinMetaModel.Int_Mult_Int, 
			BuiltinMetaModel.Double_Mult_Double, 
			BuiltinMetaModel.Double_Mult_Int,
			BuiltinMetaModel.Int_Div_Double,
			BuiltinMetaModel.Double_Div_Double,
			BuiltinMetaModel.Double_Div_Int,
			BuiltinMetaModel.Int_Less,
			BuiltinMetaModel.Int_LessOrEqual,
			BuiltinMetaModel.Int_Greater,
			BuiltinMetaModel.Int_GreatOrEqual,
			BuiltinMetaModel.EString_Plus_EJavaObject,
			BuiltinMetaModel.Object_EQ,
			BuiltinMetaModel.Object_NotEQ
		}));
	
	private static final Set<EOperation> collectionOperations = new HashSet<EOperation>(Arrays.asList(new EOperation[] {
			BuiltinMetaModel.Collection_Add,
			BuiltinMetaModel.Collection_AddAll,
			BuiltinMetaModel.Collection_Clear,
			BuiltinMetaModel.Collection_Contains,
			BuiltinMetaModel.Collection_ContainsAll, 
			BuiltinMetaModel.Collection_Flatten,
			BuiltinMetaModel.Collection_Intersect,
			BuiltinMetaModel.Collection_IsEmpty, 
			BuiltinMetaModel.Collection_Size, 
			BuiltinMetaModel.Collection_ToList,
			BuiltinMetaModel.Collection_ToSet,
			BuiltinMetaModel.Collection_Union,
			BuiltinMetaModel.Collection_Without,
			BuiltinMetaModel.List_First,
			BuiltinMetaModel.List_Get,
			BuiltinMetaModel.List_IndexOf,
			BuiltinMetaModel.List_Last,
			BuiltinMetaModel.List_PurgeDups,
			BuiltinMetaModel.List_WithoutFirst,
			BuiltinMetaModel.List_WithoutLast
	}));

	private Stack<Expression> expressionsStack = new Stack<Expression>();

	private StringBuilder output = new StringBuilder();

	private StandardLibraryImports stdLibImportsManager;

	private MigrationExecutionContext ctx;

	private int returnPosition;

	private VariableNameDispatcher variableDispatcher;

	private Expression rootExpression;

	private TypeManager typeManager;

	ExpressionMigrationFacade(Expression expression, TypeManager typeManager, StandardLibraryImports libImports, VariableNameDispatcher variableDispatcher, MigrationExecutionContext context) {
		rootExpression = expression;
		this.typeManager = typeManager;
		stdLibImportsManager = libImports;
		this.variableDispatcher = variableDispatcher;
		ctx = context;
		markReturnPosition();
	}

	StringBuilder migrate() throws MigrationException {
		migrateExpression(rootExpression);
		return output;
	}

	int getReturnPosition() {
		return returnPosition;
	}

	private void migrateExpression(Expression expression) throws MigrationException {
		expressionsStack.push(expression);
		try {
			if (expression instanceof BooleanOperation) {
				migrateBooleanOperation((BooleanOperation) expression);
			} else if (expression instanceof Cast) {
				migrateCast((Cast) expression);
			} else if (expression instanceof ChainExpression) {
				migrateChainExpression((ChainExpression) expression);
			} else if (expression instanceof ConstructorCallExpression) {
				migrateConstructorCallExpression((ConstructorCallExpression) expression);
			} else if (expression instanceof CollectionExpression) {
				migrateCollectionExpression((CollectionExpression) expression);
			} else if (expression instanceof OperationCall) {
				migrateOperationCall((OperationCall) expression);
			} else if (expression instanceof TypeSelectExpression) {
				migrateTypeSelectExpression((TypeSelectExpression) expression);
			} else if (expression instanceof FeatureCall) {
				migrateFeatureCall((FeatureCall) expression);
			} else if (expression instanceof IfExpression) {
				migrateIfExpression((IfExpression) expression);
			} else if (expression instanceof LetExpression) {
				migrateLetExpression((LetExpression) expression);
			} else if (expression instanceof ListLiteral) {
				migrateListLiteral((ListLiteral) expression);
			} else if (expression instanceof BooleanLiteral) {
				migrateBooleanLiteral((BooleanLiteral) expression);
			} else if (expression instanceof IntegerLiteral) {
				migrateIntegerLiteral((IntegerLiteral) expression);
			} else if (expression instanceof NullLiteral) {
				migrateNullLiteral((NullLiteral) expression);
			} else if (expression instanceof RealLiteral) {
				migrateRealLiteral((RealLiteral) expression);
			} else if (expression instanceof StringLiteral) {
				migrateStringLiteral((StringLiteral) expression);
			} else if (expression instanceof SwitchExpression) {
				migrateSwitchExpression((SwitchExpression) expression);
			} else {
				throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
			}
		} finally {
			expressionsStack.pop();
		}
	}

	private void migrateSwitchExpression(SwitchExpression switchExpression) throws MigrationException {
		if (switchExpression.getCases().size() == 0) {
			migrateExpression(switchExpression.getDefaultExpr());
		} else {
			writeln("switch { ");
			for (Case caseExpression : switchExpression.getCases()) {
				write("case (");
				migrateExpression(switchExpression.getSwitchExpr());
				write(" = ");
				migrateExpression(caseExpression.getCondition());
				write(") ");
				migrateExpression(caseExpression.getThenPart());
				writeln(";");
			}
			write("else ");
			migrateExpression(switchExpression.getDefaultExpr());
			writeln(";");
			writeln(" }");
		}
	}

	private void migrateStringLiteral(StringLiteral expression) {
		write("'");
		write(escape(expression.getValue()));
		write("'");
	}

	private String escape(String value) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < value.length(); i++) {
			char nextChar = value.charAt(i);
			if (nextChar == '\'') {
				// escaping single quote mark with one more single quote mark.
				sb.append(nextChar);
			}
			sb.append(nextChar);
		}
		return sb.toString();
	}

	private void migrateRealLiteral(RealLiteral realLiteral) {
		write(new Double(realLiteral.getLiteralValue()).toString());
	}

	private void migrateNullLiteral(NullLiteral expression) {
		write("null");
	}

	private void migrateIntegerLiteral(IntegerLiteral integerLiteral) {
		write(new Integer(integerLiteral.getLiteralValue()).toString());
	}

	private void migrateBooleanLiteral(BooleanLiteral booleanLiteral) {
		write(Boolean.valueOf(booleanLiteral.getLiteralValue()) ? Boolean.TRUE.toString() : Boolean.FALSE.toString());
	}

	private void migrateListLiteral(ListLiteral listLiteral) throws MigrationException {
		write("Sequence { ");
		for (int i = 0; i < listLiteral.getElements().length; i++) {
			if (i > 0) {
				write(", ");
			}
			migrateExpression(listLiteral.getElements()[i]);
		}
		write(" }");
	}

	private void migrateLetExpression(LetExpression letExpression) throws MigrationException {
		write("let ");
		write(letExpression.getVarName().getValue());
		write(" = ");
		migrateExpression(letExpression.getVarExpression());
		write(" in ");
		migrateExpression(letExpression.getTargetExpression());
	}

	private void migrateIfExpression(IfExpression ifExpression) throws MigrationException {
		write("if ");
		migrateExpression(ifExpression.getCondition());
		write(" then ");
		migrateExpression(ifExpression.getThenPart());
		write(" else ");
		migrateExpression(ifExpression.getElsePart());
		write(" endif");
	}

	private void migrateConstructorCallExpression(ConstructorCallExpression constructorCall) throws MigrationException {
		write("object ");
		EClassifier type = ctx.getTypeForName(constructorCall.getType().getValue());
		if (type == null) {
			throw new MigrationException(Type.TYPE_NOT_FOUND, constructorCall.getType().getValue());
		}

		write(typeManager.getQvtFQName(type));
		write(" {}");
	}

	private void migrateChainExpression(ChainExpression chainExpression) throws MigrationException {
		// TODO: currently only top-level chain expressions are supported. We
		// have to develop a way to support inner chain expressions like:
		// if(a.b()->c.d()->e.f) then {...} else {...}
		// for now solution is to use separate helpers for each nested chain
		// expression
		if (expressionsStack.size() > 1 && false == expressionsStack.peek() instanceof ChainExpression) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, "Inner " + chainExpression.getClass().getName());
		}
		migrateExpression(chainExpression.getFirst());
		writeln(";");
		if (expressionsStack.size() == 1) {
			markReturnPosition();
		}
		migrateExpression(chainExpression.getNext());
	}

	private void migrateBooleanOperation(BooleanOperation booleanOperation) throws MigrationException {
		migrateExpression(booleanOperation.getLeft());
		if (booleanOperation.isAndOperation()) {
			write(" and ");
		} else if (booleanOperation.isOrOperation()) {
			write(" or ");
		} else if (booleanOperation.isImpliesOperation()) {
			write(" implies ");
		} else {
			throw new MigrationException(Type.UNSUPPORTED_BOOLEAN_OPERATION, booleanOperation.getOperator());
		}
		migrateExpression(booleanOperation.getRight());
	}

	private void migrateCast(Cast cast) throws MigrationException {
		migrateExpression(cast.getTarget());
		EClassifier type = ctx.getTypeForName(cast.getType().getValue());
		if (type == null) {
			throw new MigrationException(Type.TYPE_NOT_FOUND, cast.getType().getValue());
		}
		write(".oclAsType(");
		write(typeManager.getQvtFQName(type));
		write(")");
	}

	private void migrateTypeSelectExpression(TypeSelectExpression typeSelectExpression) throws MigrationException {
		int placeholder = getCurrentPosition();
		migrateExpression(typeSelectExpression.getTarget());
		EClassifier type = ctx.getTypeForName(typeSelectExpression.getTypeLiteral().getValue());
		if (type == null) {
			throw new MigrationException(Type.TYPE_NOT_FOUND, typeSelectExpression.getTypeLiteral().getValue());
		}
		ExpressionAnalyzeTrace expressionTrace = ctx.getTraces().get(typeSelectExpression);
		if (false == expressionTrace instanceof TypeSelectExpressionTrace) {
			throw new MigrationException(Type.UNSUPPORTED_TYPE_SELECT_EXPRESSION_TRACE, String.valueOf(expressionTrace));
		}
		TypeSelectExpressionTrace trace = (TypeSelectExpressionTrace) expressionTrace;
		if (!trace.isValid()) {
			throw new MigrationException(Type.UNSUPPORTED_TYPE_SELECT_EXPRESSION, trace.toString());
		}
		internalMigrateTypeSelectCastingCollectionToBag(trace.getTargetType(), typeManager.getQvtFQName(type), placeholder);
		if (!TypeManager.isListType(trace.getTargetType())) {
			write("->asSequence()");
		}
	}

	private void internalMigrateTypeSelectCastingCollectionToBag(EClassifier collectionType, String typeName, int placeholder) {
		assert BuiltinMetaModel.isCollectionType(collectionType);
		if (TypeManager.isListType(collectionType) || TypeManager.isSetType(collectionType)) {
			internalMigrateTypeSelect(typeName, placeholder);
		} else {
			internalMigrateCollectionToBag(typeName);
		}
	}

	private void internalMigrateTypeSelect(String typeName, int placeholder) {
		// TODO: This method should write braces around expression starting
		// at placeholder position conditionally depending on the last char
		// in output sequence.
		write("(", placeholder);
		write(")");
		write("[");
		write(typeName);
		write("]");
	}

	// TODO: use ->asSequence() here in addition?
	private void internalMigrateCollectionToBag(String typeName) {
		String iteratorName = variableDispatcher.getNextIteratorName();
		write("->collect(");
		write(iteratorName);
		write(" | ");
		write(iteratorName);
		if (typeName != null) {
			write(".oclAsType(");
			write(typeName);
			write(")");
		}
		write(")");
	}

	private void migrateCollectionExpression(CollectionExpression collectionExpression) throws MigrationException {
		if (collectionExpression.getTarget() == null) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, "Collection expression without target specified: " + collectionExpression.toString());
		}
		int placeholder = getCurrentPosition();
		boolean hasNegation = false;
		migrateExpression(collectionExpression.getTarget());
		write("->");
		ExpressionAnalyzeTrace expressionTrace = ctx.getTraces().get(collectionExpression);
		if (false == expressionTrace instanceof CollectionExpressionTrace) {
			throw new MigrationException(Type.UNSUPPORTED_COLLECTION_EXPRESSION_TRACE, String.valueOf(expressionTrace));
		}
		CollectionExpressionTrace trace = (CollectionExpressionTrace) expressionTrace;
		switch (trace.getType()) {
		case NOTEXISTS_REF:
			hasNegation = true;
			write("not ", placeholder);
			write("exists");
			break;
		case COLLECT_REF:
		case SELECT_REF:
		case REJECT_REF:
		case EXISTS_REF:
		case FORALL_REF:
			write(collectionExpression.getName().getValue());
			break;
		case INCORRECT_EXPRESSION_TYPE:
		case UNDESOLVED_TARGET_TYPE:
			throw new MigrationException(Type.UNSUPPORTED_COLLECTION_EXPRESSION, trace.toString());
		default:
			throw new MigrationException(Type.UNSUPPORTED_COLLECTION_EXPRESSION_TRACE, "Incorrect type: " + trace.getType());
		}
		write("(");
		write(collectionExpression.getElementName());
		write(" | ");
		migrateExpression(collectionExpression.getClosure());
		write(")");
		if (trace.getType() == CollectionExpressionTrace.Type.COLLECT_REF && TypeManager.isSetType(trace.getResultType())) {
			// Does not work now due to the bug in xpand implementation - see
			// "TODO [AS]" comment in CollectionExpression
			write("->asSet()");
		}
		if (hasNegation) {
			addNegationBraces(placeholder);
		}
	}

	private void addNegationBraces(int placeholder) {
		if (expressionsStack.size() == 1) {
			return;
		}
		// TODO: check for the type of parent expression here + add braces
		// conditionaly
		// Expression parentExpression =
		// expressionsStack.get(expressionsStack.size() - 2);
		// check for the type of parent expression;
		write("(", placeholder);
		write(")");
	}

	private void migrateOperationCall(OperationCall operationCall) throws MigrationException {
		ExpressionAnalyzeTrace expressionTrace = ctx.getTraces().get(operationCall);
		if (false == expressionTrace instanceof OperationCallTrace) {
			throw new MigrationException(Type.UNSUPPORTED_OPERATION_CALL_TRACE, String.valueOf(expressionTrace));
		}
		OperationCallTrace trace = (OperationCallTrace) expressionTrace;
		switch (trace.getType()) {
		case UNDESOLVED_PARAMETER_TYPE:
		case UNDESOLVED_TARGET_TYPE:
			throw new MigrationException(Type.UNSUPPORTED_OPERATION_CALL, trace.toString());
		case STATIC_EXTENSION_REF:
			write(operationCall.getName().getValue());
			write("(");
			internalMigrateOperationCallParameters(operationCall);
			write(")");
			return;
		case OPERATION_REF:
			if (isInfixOperation(trace)) {
				internalMigrateInfixOperation(trace, operationCall);
			} else if (isCollectionOperation(trace)) {
				internalMigrateCollectionOperationCall(trace, operationCall);
			} else {
				internalMigrateOperationCall(trace, operationCall);
				convertTypedElementCallProduct(trace.getEOperation());
			}
			return;
		case IMPLICIT_COLLECT_OPERATION_REF:
			// TODO: Implicit collect of collection operation result is not
			// supported now
			internalMigrateOperationCall(trace, operationCall);
			convertImplicitCollectProduct(trace.getTargetType());
			return;
		case EXTENSION_REF:
			assert operationCall.getTarget() != null;
			write(operationCall.getName().getValue());
			write("(");
			migrateExpression(operationCall.getTarget());
			if (operationCall.getParams().length > 0) {
				write(", ");
				internalMigrateOperationCallParameters(operationCall);
			}
			write(")");
			return;
		case IMPLICIT_COLLECT_EXTENSION_REF:
			assert operationCall.getTarget() != null;
			migrateExpression(operationCall.getTarget());
			String iteratorName = variableDispatcher.getNextIteratorName();
			write("->collect(");
			write(iteratorName);
			write(" | ");
			write(operationCall.getName().getValue());
			write("(");
			write(iteratorName);
			if (operationCall.getParams().length > 0) {
				write(", ");
				internalMigrateOperationCallParameters(operationCall);
			}
			write(")");
			write(")");
			convertImplicitCollectProduct(trace.getTargetType());
			return;
		default:
			throw new MigrationException(Type.UNSUPPORTED_OPERATION_CALL_TRACE, "Incorrect type: " + trace.getType());
		}
	}

	private void internalMigrateInfixOperation(OperationCallTrace trace, OperationCall operationCall) throws MigrationException {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		int placeholder = getCurrentPosition();
		internalMigrateOperationCallTarget(operationCall);
		String opName = eOperation.getName();
		if (BuiltinMetaModel.Boolean_NE == eOperation) {
			write("not ", placeholder);
		} else if (BuiltinMetaModel.Int_Unary_Minus == eOperation || BuiltinMetaModel.Double_Unary_Minus == eOperation) {
			write(opName, placeholder);
		} else if (BuiltinMetaModel.Int_Minus_Int == eOperation || BuiltinMetaModel.Int_Minus_Double == eOperation || BuiltinMetaModel.Double_Minus_Int == eOperation
				|| BuiltinMetaModel.Double_Minus_Double == eOperation || BuiltinMetaModel.Int_Plus_Int == eOperation || BuiltinMetaModel.Int_Plus_Double == eOperation
				|| BuiltinMetaModel.Double_Plus_Int == eOperation || BuiltinMetaModel.Double_Plus_Double == eOperation || BuiltinMetaModel.Int_Mult_Int == eOperation
				|| BuiltinMetaModel.Int_Mult_Double == eOperation || BuiltinMetaModel.Double_Mult_Int == eOperation || BuiltinMetaModel.Double_Mult_Double == eOperation
				|| BuiltinMetaModel.Int_Div_Double == eOperation || BuiltinMetaModel.Double_Div_Double == eOperation || BuiltinMetaModel.Double_Div_Int == eOperation
				|| BuiltinMetaModel.Int_Less == eOperation || BuiltinMetaModel.Int_LessOrEqual == eOperation || BuiltinMetaModel.Int_Greater == eOperation
				|| BuiltinMetaModel.Int_GreatOrEqual == eOperation || BuiltinMetaModel.EString_Plus_EJavaObject == eOperation) {
			write(" ");
			write(opName);
			write(" ");
		} else if (BuiltinMetaModel.Object_EQ == eOperation) {
			write(" = ");
		} else if (BuiltinMetaModel.Object_NotEQ == eOperation) {
			write(" <> ");
		} else {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, "Incorrect infix operation: " + opName);
		}
		internalMigrateOperationCallParameters(operationCall);
		if (BuiltinMetaModel.EString_Plus_EJavaObject == eOperation) {
			assert trace.getParamTypes().length == 1;
			if (trace.getParamTypes()[0] != EcorePackage.eINSTANCE.getEString()) {
				write(".repr()");
			}
		} else if (BuiltinMetaModel.Boolean_NE == eOperation || BuiltinMetaModel.Int_Unary_Minus == eOperation || BuiltinMetaModel.Double_Unary_Minus == eOperation) {
			// Enclosing with braces for "not" expression here
			addNegationBraces(placeholder);
		}
	}

	private void internalMigrateOperationCallTarget(OperationCall operationCall) throws MigrationException {
		if (operationCall.getTarget() != null) {
			migrateExpression(operationCall.getTarget());
		} else {
			// getTarget() == null if it is an implicit self operation.
			// TODO: check if it is working with XPand
			write("self");
		}
	}

	private void internalMigrateCollectionOperationCall(OperationCallTrace trace, OperationCall operationCall) throws MigrationException {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		EClassifier targetType = trace.getTargetType();
		assert targetType != null;
		assert BuiltinMetaModel.isCollectionType(targetType);
		EClassifier elementType = BuiltinMetaModel.getInnerType(targetType);

		int placeholder = getCurrentPosition();
		if (BuiltinMetaModel.Collection_Clear != eOperation && BuiltinMetaModel.List_WithoutFirst != eOperation && BuiltinMetaModel.List_WithoutLast != eOperation) {
			internalMigrateOperationCallTarget(operationCall);
		}

		if (BuiltinMetaModel.Collection_Add == eOperation) {
			EClassifier commonSuperType = getCommonSuperType(elementType, getSingleParameterType(trace));
			internalMigrateToConcreteCollection(targetType, commonSuperType, placeholder);
			write("->including(");
			internalMigrateOperationCallParameters(operationCall);
			write(")");
			// internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_AddAll == eOperation) {
			EClassifier commonSuperType = getCommonSuperType(elementType, getSingleCollectionParameterElementType(trace));
			internalMigrateToConcreteCollection(targetType, commonSuperType, placeholder);
			write("->union(");
			internalMigrateOperationCallParameters(operationCall);
			internalMigrateParameterCollectionToMain(getSingleParameterType(trace), targetType);
			write(")");
			// internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_Union == eOperation) {
			EClassifier commonSuperType = getCommonSuperType(elementType, getSingleCollectionParameterElementType(trace));
			internalMigrateToSet(targetType, commonSuperType, placeholder);
			write("->union(");
			internalMigrateOperationCallParameters(operationCall);
			internalMigrateParameterCollectionToSet(getSingleParameterType(trace));
			write(")");
			// internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_Intersect == eOperation) {
			EClassifier commonSuperType = getCommonSuperType(elementType, getSingleCollectionParameterElementType(trace));
			internalMigrateToSet(targetType, commonSuperType, placeholder);
			write("->intersection(");
			internalMigrateOperationCallParameters(operationCall);
			internalMigrateParameterCollectionToSet(getSingleParameterType(trace));
			write(")");
			// internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_Without == eOperation) {
			EClassifier commonSuperType = getCommonSuperType(elementType, getSingleCollectionParameterElementType(trace));
			internalMigrateToSet(targetType, commonSuperType, placeholder);
			write("->-(");
			internalMigrateOperationCallParameters(operationCall);
			internalMigrateParameterCollectionToSet(getSingleParameterType(trace));
			write(")");
			// internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_Contains == eOperation) {
			EClassifier parameterType = getSingleParameterType(trace);
			if (!BuiltinMetaModel.isAssignableFrom(elementType, parameterType)) {
				EClassifier commonSuperType = getCommonSuperType(elementType, parameterType);
				internalMigrateTypeSelect(typeManager.getQvtFQName(commonSuperType), placeholder);
			}
			write("->includes(");
			internalMigrateOperationCallParameters(operationCall);
			write(")");
		} else if (BuiltinMetaModel.Collection_ContainsAll == eOperation) {
			EClassifier parameterElementType = getSingleCollectionParameterElementType(trace);
			if (!BuiltinMetaModel.isAssignableFrom(elementType, parameterElementType)) {
				EClassifier commonSuperType = getCommonSuperType(elementType, parameterElementType);
				internalMigrateTypeSelect(typeManager.getQvtFQName(commonSuperType), placeholder);
			}
			write("->includesAll(");
			internalMigrateOperationCallParameters(operationCall);
			write(")");
		} else if (BuiltinMetaModel.List_IndexOf == eOperation) {
			EClassifier parameterType = getSingleParameterType(trace);
			if (!BuiltinMetaModel.isAssignableFrom(elementType, parameterType)) {
				EClassifier commonSuperType = getCommonSuperType(elementType, parameterType);
				internalMigrateTypeSelectCastingCollectionToBag(targetType, typeManager.getQvtFQName(commonSuperType), placeholder);
			}
			write("->indexOf(");
			internalMigrateOperationCallParameters(operationCall);
			write(")");
			write("(", placeholder);
			write(" - 1)");
		} else if (BuiltinMetaModel.Collection_Clear == eOperation) {
			if (TypeManager.isSetType(targetType)) {
				write("Set{}");
			} else if (TypeManager.isListType(targetType)) {
				write("Sequence{}");
			} else {
				write("Bag{}");
			}
			// write("Bag{}");
			if (elementType != EcorePackage.eINSTANCE.getEJavaObject()) {
				write("[");
				write(typeManager.getQvtFQName(elementType));
				write("]");
			}
		} else if (BuiltinMetaModel.Collection_Flatten == eOperation) {
			internalMigrateToConcreteCollection(targetType, elementType, placeholder);
			write("->flatten()");
			// internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_ToSet == eOperation) {
			internalMigrateToSet(targetType, elementType, placeholder);
		} else if (BuiltinMetaModel.Collection_ToList == eOperation) {
			internalMigrateToList(targetType, elementType, placeholder);
		} else if (BuiltinMetaModel.List_Get == eOperation) {
			write("->at(");
			internalMigrateOperationCallParameters(operationCall);
			write(" + 1)");
		} else if (BuiltinMetaModel.List_WithoutFirst == eOperation) {
			String varName = variableDispatcher.getNextVariableName();
			write("let ");
			write(varName);
			write(" = ");
			internalMigrateOperationCallTarget(operationCall);
			write(" in ");
			write("if ");
			write(varName);
			write("->size() < 2 then Sequence{}");
			if (elementType != EcorePackage.eINSTANCE.getEJavaObject()) {
				write("[");
				write(typeManager.getQvtFQName(elementType));
				write("]");
			}
			write(" else ");
			write(varName);
			write("->subSequence(2, ");
			write(varName);
			write("->size()) endif");
		} else if (BuiltinMetaModel.List_WithoutLast == eOperation) {
			String varName = variableDispatcher.getNextVariableName();
			write("let ");
			write(varName);
			write(" = ");
			internalMigrateOperationCallTarget(operationCall);
			write(" in ");
			write("if ");
			write(varName);
			write("->size() < 2 then Sequence{}");
			if (elementType != EcorePackage.eINSTANCE.getEJavaObject()) {
				write("[");
				write(typeManager.getQvtFQName(elementType));
				write("]");
			}
			write(" else ");
			write(varName);
			write("->subSequence(1, ");
			write(varName);
			write("->size() - 1) endif");
		} else if (BuiltinMetaModel.List_PurgeDups == eOperation) {
			write("->asOrderedSet()->asSequence()");
		} else {
			/**
			 * .isEmpty() .size() .first() .last()
			 */
			assert operationCall.getParams().length == 0;
			write("->");
			write(eOperation.getName());
			write("(");
			internalMigrateOperationCallParameters(operationCall);
			write(")");
		}
	}

//	 private void internalMigrateToBag(EClassifier collectionType) {
//		if (TypeManager.isListType(collectionType) || TypeManager.isSetType(collectionType)) {
//			write("->asBag()");
//		}
//	}

	private EClassifier getCommonSuperType(EClassifier collectionElementType1, EClassifier collectionElementType2) {
		if (BuiltinMetaModel.VOID == collectionElementType1) {
			return EcorePackage.eINSTANCE.getEJavaObject();
		}
		if (BuiltinMetaModel.isAssignableFrom(collectionElementType1, collectionElementType2)) {
			return collectionElementType1;
		}
		if (collectionElementType1 instanceof EClass) {
			EClass eClass = (EClass) collectionElementType1;
			for (EClass nextSuperType : getAllSuperTypes(eClass)) {
				if (BuiltinMetaModel.isAssignableFrom(nextSuperType, collectionElementType2)) {
					return nextSuperType;
				}
			}
		}
		return EcorePackage.eINSTANCE.getEJavaObject();
	}

	private List<EClass> getAllSuperTypes(EClass eClass) {
		List<EClass> result = new ArrayList<EClass>(eClass.getESuperTypes());
		for (int i = 1; i < result.size(); i++) {
			EClass nextSuperType = result.get(i);
			result.addAll(nextSuperType.getESuperTypes());
		}
		return result;
	}

	private EClassifier getSingleParameterType(OperationCallTrace trace) {
		EClassifier[] paramTypes = trace.getParamTypes();
		assert paramTypes != null && paramTypes.length == 1;
		return paramTypes[0];
	}

	private EClassifier getSingleCollectionParameterElementType(OperationCallTrace trace) {
		EClassifier parameterType = getSingleParameterType(trace);
		assert BuiltinMetaModel.isCollectionType(parameterType);
		return BuiltinMetaModel.getInnerType(parameterType);
	}

	private void internalMigrateToConcreteCollection(EClassifier collectionType, EClassifier elementSuperType, int placeholder) throws MigrationException {
		assert BuiltinMetaModel.isCollectionType(collectionType);
		EClassifier elementType = BuiltinMetaModel.getInnerType(collectionType);
		if (elementSuperType != elementType) {
			internalMigrateTypeSelectCastingCollectionToBag(collectionType, typeManager.getQvtFQName(elementSuperType), placeholder);
		} else if (!TypeManager.isListType(collectionType) && !TypeManager.isSetType(collectionType)) {
			internalMigrateCollectionToBag(null);
		}
	}

	private void internalMigrateToSet(EClassifier collectionType, EClassifier elementSuperType, int placeholder) throws MigrationException {
		internalMigrateToConcreteCollection(collectionType, elementSuperType, placeholder);
		if (!TypeManager.isSetType(collectionType)) {
			write("->asSet()");
		}
	}

	private void internalMigrateToList(EClassifier collectionType, EClassifier elementSuperType, int placeholder) throws MigrationException {
		internalMigrateToConcreteCollection(collectionType, elementSuperType, placeholder);
		if (!TypeManager.isListType(collectionType)) {
			write("->asSequence()");
		}
	}

	private void internalMigrateParameterCollectionToMain(EClassifier parameterCollectionType, EClassifier mainCollectionType) {
		assert BuiltinMetaModel.isCollectionType(parameterCollectionType);
		assert BuiltinMetaModel.isCollectionType(mainCollectionType);
		if (TypeManager.isListType(mainCollectionType)) {
			if (TypeManager.isSetType(parameterCollectionType)) {
				write("->asSequence()");
			} else if (!TypeManager.isListType(parameterCollectionType)) {
				internalMigrateCollectionToBag(null);
				write("->asSequence()");
			}
		} else if (TypeManager.isSetType(mainCollectionType)) {
			if (TypeManager.isListType(parameterCollectionType)) {
				write("->asSet()");
			} else if (!TypeManager.isSetType(parameterCollectionType)) {
				internalMigrateCollectionToBag(null);
				write("->asSet()");
			}
		} else {
			if (TypeManager.isSetType(parameterCollectionType) || TypeManager.isListType(parameterCollectionType)) {
				write("->asBag()");
			} else {
				internalMigrateCollectionToBag(null);
			}
		}
	}

	private void internalMigrateParameterCollectionToSet(EClassifier parameterCollectionType) {
		assert BuiltinMetaModel.isCollectionType(parameterCollectionType);
		if (TypeManager.isListType(parameterCollectionType)) {
			write("->asSet()");
		} else if (!TypeManager.isSetType(parameterCollectionType)) {
			internalMigrateCollectionToBag(null);
			write("->asSet()");
		}
	}

	private boolean isCollectionOperation(OperationCallTrace trace) {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		return collectionOperations.contains(eOperation);
	}

	private void convertTypedElementCallProduct(ETypedElement typedElement) {
		assert typedElement != null;
		if (typedElement.isMany() && typedElement.isOrdered() && typedElement.isUnique()) {
			write("->asSequence()");
		}
	}

	private void convertImplicitCollectProduct(EClassifier targetType) {
		assert targetType != null;
		if (!TypeManager.isListType(targetType)) {
			write("->asSequence()");
		}
	}

	private void internalMigrateOperationCallParameters(OperationCall operationCall) throws MigrationException {
		for (int i = 0; i < operationCall.getParams().length; i++) {
			if (i > 0) {
				write(", ");
			}
			migrateExpression(operationCall.getParams()[i]);
		}
	}

	private void internalMigrateOperationCall(OperationCallTrace trace, OperationCall operationCall) throws MigrationException {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		internalMigrateOperationCallTarget(operationCall);
		write(".");
		write(stdLibImportsManager.getOperationName(eOperation));
		write("(");
		if (BuiltinMetaModel.EString_SubString_StartEnd == eOperation) {
			write("1 + ");
		}
		internalMigrateOperationCallParameters(operationCall);
		write(")");
	}

	private boolean isInfixOperation(OperationCallTrace trace) {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		return infixOperations.contains(eOperation);
	}

	private void migrateFeatureCall(FeatureCall featureCall) throws MigrationException {
		ExpressionAnalyzeTrace expressionTrace = ctx.getTraces().get(featureCall);
		if (false == expressionTrace instanceof FeatureCallTrace) {
			throw new MigrationException(Type.UNSUPPORTED_FEATURE_CALL_TRACE, String.valueOf(expressionTrace));
		}
		FeatureCallTrace trace = (FeatureCallTrace) expressionTrace;
		switch (trace.getType()) {
		case ENUM_LITERAL_REF:
			EEnumLiteral enumLiteral = trace.getEnumLiteral();
			assert enumLiteral != null;
			write(typeManager.getQvtFQName(enumLiteral));
			return;
		case ENV_VAR_REF:
			write(featureCall.getName().getValue());
			return;
		case UNDESOLVED_TARGET_TYPE:
		case UNSUPPORTED_CLASSIFIER_REF:
			throw new MigrationException(Type.UNSUPPORTED_FEATURE_CALL, trace.toString());
		}
		// featureCall.getTarget() == null for FeatureCall of implicit variable
		// feature
		if (featureCall.getTarget() != null) {
			migrateExpression(featureCall.getTarget());
			write(".");
		}
		write(featureCall.getName().getValue());
		switch (trace.getType()) {
		case FEATURE_REF:
			EClassifier targetType = trace.getTargetType();
			assert targetType != null;
			if (BuiltinMetaModel.isParameterizedType(targetType)) {
				throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, "Attribute call is not supported for the collection types: " + targetType.toString() + "." + featureCall.getName().getValue());
			}
			convertTypedElementCallProduct(trace.getFeature());
			return;
		case IMPLICIT_COLLECT_FEATURE_REF:
			convertImplicitCollectProduct(trace.getTargetType());
			return;
		default:
			throw new MigrationException(Type.UNSUPPORTED_FEATURE_CALL_TRACE, "Incorrect type: " + trace.getType());
		}
	}
	
	private void markReturnPosition() {
		returnPosition = getCurrentPosition();
	}

	private int getCurrentPosition() {
		return output.length();
	}

	private void write(CharSequence cs, int index) {
		output.insert(index, cs);
	}

	private void write(CharSequence cs) {
		output.append(cs);
	}

	private void writeln(CharSequence cs) {
		output.append(cs);
		output.append(LF);
	}

}
