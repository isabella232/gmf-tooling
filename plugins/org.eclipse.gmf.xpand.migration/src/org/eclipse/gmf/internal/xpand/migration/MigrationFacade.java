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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
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
import org.eclipse.gmf.internal.xpand.xtend.ast.CreateExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExpressionExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.Extension;
import org.eclipse.gmf.internal.xpand.xtend.ast.JavaExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.WorkflowSlotExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.XtendResource;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.types.AnyType;

public class MigrationFacade {

	static final String LF = System.getProperty("line.separator");
	
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
			BuiltinMetaModel.Double_Plus_Int
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

	private static final String OCL_PATH_SEPARATOR = "::";

	private ResourceManager resourceManager;

	private StringBuilder output = new StringBuilder();

	private String resourceName;

	private ModeltypeImports modeltypeImports;

	private boolean injectUnusedImports;

	private MigrationExecutionContext rootExecutionContext;

	private Stack<Expression> expressionsStack = new Stack<Expression>();

	private int returnPosition;

	private static final boolean isListType(EClassifier classifier) {
		return classifier.getName().endsWith(BuiltinMetaModel.LIST);
	}

	private static final boolean isSetType(EClassifier classifier) {
		return classifier.getName().endsWith(BuiltinMetaModel.SET);
	}

	public MigrationFacade(ResourceManager resourceManager, String xtendResourceName, boolean injectUnusedImports) {
		this(resourceManager, xtendResourceName);
		this.injectUnusedImports = injectUnusedImports;
	}

	public MigrationFacade(ResourceManager resourceManager, String xtendResourceName, MigrationExecutionContext executionContext) {
		this(resourceManager, xtendResourceName);
		rootExecutionContext = executionContext;
	}

	public MigrationFacade(ResourceManager resourceManager, String xtendResourceName) {
		this.resourceManager = resourceManager;
		this.resourceName = xtendResourceName;
	}

	public StringBuilder migrateXtendResource() throws MigrationException {
		XtendResource xtendResource = resourceManager.loadXtendResource(resourceName);
		if (xtendResource == null) {
			throw new MigrationException(Type.RESOURCE_NOT_FOUND, "Unable to load resource: " + resourceName);
		}
		MigrationExecutionContext ctx = (rootExecutionContext != null ? rootExecutionContext : new MigrationExecutionContextImpl(resourceManager)).cloneWithResource(xtendResource);
		Set<AnalysationIssue> issues = new HashSet<AnalysationIssue>();
		xtendResource.analyze(ctx, issues);
		if (issues.size() > 0) {
			throw new MigrationException(issues);
		}

		String shortResourceName = getLastSegment(resourceName, SyntaxConstants.NS_DELIM);
		if (shortResourceName.length() == 0) {
			throw new MigrationException(Type.INCORRECT_RESOURCE_NAME, resourceName);
		}

		modeltypeImports = new ModeltypeImports(output, injectUnusedImports);

		for (String namespace : xtendResource.getImportedNamespaces()) {
			modeltypeImports.registerModeltype(namespace);
		}

		addLibraryImports(xtendResource, false);

		writeln("library " + shortResourceName + ";" + LF);

		for (Iterator<Extension> it = xtendResource.getExtensions().iterator(); it.hasNext();) {
			Extension extension = it.next();
			migrateExtension(extension, ctx);
			if (it.hasNext()) {
				writeln("");
			}
		}
		modeltypeImports.injectImports();
		return output;
	}

	private void addLibraryImports(XtendResource xtendResource, boolean reexportedOnly) throws MigrationException {
		for (String extension : xtendResource.getImportedExtensions()) {
			if (!reexportedOnly || xtendResource.isReexported(extension)) {
				writeln("import " + extension.replaceAll("::", ".") + ";");
				XtendResource referencedResource = resourceManager.loadXtendResource(extension);
				if (referencedResource == null) {
					throw new MigrationException(Type.RESOURCE_NOT_FOUND, "Unable to load extension file: " + extension);
				}
				addLibraryImports(referencedResource, true);
			}
		}
	}

	private void migrateExtension(Extension extension, MigrationExecutionContext ctx) throws MigrationException {
		try {
			extension.init(ctx);
		} catch (EvaluationException e) {
			throw new MigrationException(Type.ANALYZATION_PROBLEMS, e);
		}

		write("helper ");
		write(extension.getName());
		write("(");

//		assert extension.getParameterTypes().size() > 0;
		assert extension.getParameterNames().size() == extension.getParameterTypes().size();
		Iterator<String> parameterNames = extension.getParameterNames().iterator();
		Iterator<EClassifier> parameterTypes = extension.getParameterTypes().iterator();
		while (parameterNames.hasNext()) {
			write(parameterNames.next());
			write(" : ");
			write(getQvtFQName(parameterTypes.next()));
			if (parameterNames.hasNext()) {
				write(", ");
			}
		}
		write(") : ");
		// TODO: check it!
		write(getQvtFQName(getReturnType(extension, ctx)));
		writeln(" {");

		if (extension instanceof ExpressionExtensionStatement) {
			migrateExpressionExtension((ExpressionExtensionStatement) extension, ctx);
		} else if (extension instanceof JavaExtensionStatement) {
			migrateJavaExtension((JavaExtensionStatement) extension);
		} else if (extension instanceof CreateExtensionStatement) {
			migrateCreateExtension((CreateExtensionStatement) extension);
		} else if (extension instanceof WorkflowSlotExtensionStatement) {
			migrateWorkflowSlotExtension((WorkflowSlotExtensionStatement) extension);
		} else {
			throw new MigrationException(Type.UNSUPPORTED_EXTENSION, extension.getClass().getName());
		}
		writeln("}");
	}

	private EClassifier getReturnType(Extension extension, MigrationExecutionContext ctx) throws MigrationException {
		Set<AnalysationIssue> issues = new HashSet<AnalysationIssue>();
		EClassifier returnType = extension.getReturnType(extension.getParameterTypes().toArray(new EClassifier[extension.getParameterNames().size()]), ctx, issues);
		if (issues.size() > 0) {
			throw new MigrationException(issues);
		}
		if (returnType == null) {
			throw new MigrationException(Type.TYPE_NOT_FOUND, extension.getReturnTypeIdentifier().getValue());
		}
		return returnType;
	}

	private String getQvtFQName(EClassifier classifier) throws MigrationException {
		if (classifier instanceof EDataType) {
			/**
			 * Handling QVT primitive types here.
			 */
			if (EcorePackage.eINSTANCE.getEString() == classifier) {
				return PrimitiveType.STRING_NAME;
			} else if (EcorePackage.eINSTANCE.getEBoolean() == classifier) {
				return PrimitiveType.BOOLEAN_NAME;
			} else if (EcorePackage.eINSTANCE.getEInt() == classifier) {
				return PrimitiveType.INTEGER_NAME;
			} else if (EcorePackage.eINSTANCE.getEDouble() == classifier) {
				return PrimitiveType.REAL_NAME;
			} else if (EcorePackage.eINSTANCE.getEJavaObject() == classifier) {
				return AnyType.SINGLETON_NAME;
			}
		}
		if (BuiltinMetaModel.isCollectionType(classifier)) {
			StringBuilder sb = new StringBuilder();
			if (isSetType(classifier)) {
				sb.append("Set(");
			} else if (isListType(classifier)) {
				sb.append("Sequence(");
			} else {
				sb.append("Collection(");
			}
			//was: if (classifier == CollectionTypesSupport.COLLECTION_OF_OBJECT || classifier == CollectionTypesSupport.LIST_OF_OBJECT || classifier == CollectionTypesSupport.SET_OF_OBJECT) {
			sb.append(getQvtFQName(BuiltinMetaModel.getInnerType(classifier)));
			return sb.append(")").toString();
		}
		EPackage ePackage = classifier.getEPackage();
		assert ePackage != null;
		String alias = modeltypeImports.getModeltypeAlias(ePackage);
		return alias + OCL_PATH_SEPARATOR + classifier.getName();
	}

	private void migrateExpressionExtension(ExpressionExtensionStatement extension, MigrationExecutionContext ctx) throws MigrationException {
		write("\t");
		markReturnPosition();
		migrateExpression(extension.getExpression(), ctx);
		injectReturn();
		writeln("");
	}

	private void injectReturn() {
		write("return ", returnPosition);
	}

	private void markReturnPosition() {
		returnPosition = getCurrentPosition();
	}

	// TODO: java should be migrated separately from library - java class should
	// be created with the additional declaration in plugin.xml
	private void migrateJavaExtension(JavaExtensionStatement extension) throws MigrationException {
		throw new MigrationException(Type.UNSUPPORTED_EXTENSION, extension.getClass().getName());
	}

	private void migrateCreateExtension(CreateExtensionStatement extension) throws MigrationException {
		throw new MigrationException(Type.UNSUPPORTED_EXTENSION, extension.getClass().getName());
	}

	private void migrateWorkflowSlotExtension(WorkflowSlotExtensionStatement extension) throws MigrationException {
		throw new MigrationException(Type.UNSUPPORTED_EXTENSION, extension.getClass().getName());
	}

	private void migrateExpression(Expression expression, MigrationExecutionContext ctx) throws MigrationException {
		expressionsStack.push(expression);
		try {
			if (expression instanceof BooleanOperation) {
				migrateBooleanOperation((BooleanOperation) expression, ctx);
			} else if (expression instanceof Cast) {
				migrateCast((Cast) expression, ctx);
			} else if (expression instanceof ChainExpression) {
				migrateChainExpression((ChainExpression) expression, ctx);
			} else if (expression instanceof ConstructorCallExpression) {
				migrateConstructorCallExpression((ConstructorCallExpression) expression, ctx);
			} else if (expression instanceof CollectionExpression) {
				migrateCollectionExpression((CollectionExpression) expression, ctx);
			} else if (expression instanceof OperationCall) {
				migrateOperationCall((OperationCall) expression, ctx);
			} else if (expression instanceof TypeSelectExpression) {
				migrateTypeSelectExpression((TypeSelectExpression) expression, ctx);
			} else if (expression instanceof FeatureCall) {
				migrateFeatureCall((FeatureCall) expression, ctx);
			} else if (expression instanceof IfExpression) {
				migrateIfExpression((IfExpression) expression, ctx);
			} else if (expression instanceof LetExpression) {
				migrateLetExpression((LetExpression) expression, ctx);
			} else if (expression instanceof ListLiteral) {
				migrateListLiteral((ListLiteral) expression, ctx);
			} else if (expression instanceof BooleanLiteral) {
				migrateBooleanLiteral((BooleanLiteral) expression, ctx);
			} else if (expression instanceof IntegerLiteral) {
				migrateIntegerLiteral((IntegerLiteral) expression, ctx);
			} else if (expression instanceof NullLiteral) {
				migrateNullLiteral((NullLiteral) expression, ctx);
			} else if (expression instanceof RealLiteral) {
				migrateRealLiteral((RealLiteral) expression, ctx);
			} else if (expression instanceof StringLiteral) {
				migrateStringLiteral((StringLiteral) expression, ctx);
			} else if (expression instanceof SwitchExpression) {
				migrateSwitchExpression((SwitchExpression) expression, ctx);
			} else {
				throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
			}
		} finally {
			expressionsStack.pop();
		}
	}

	private void migrateSwitchExpression(SwitchExpression switchExpression, MigrationExecutionContext ctx) throws MigrationException {
		if (switchExpression.getCases().size() == 0) {
			migrateExpression(switchExpression.getDefaultExpr(), ctx);
		} else {
			writeln("switch { ");
			for (Case caseExpression : switchExpression.getCases()) {
				write("case (");
				migrateExpression(switchExpression.getSwitchExpr(), ctx);
				write(" = ");
				migrateExpression(caseExpression.getCondition(), ctx);
				write(") ");
				migrateExpression(caseExpression.getThenPart(), ctx);
				writeln(";");
			}
			write("else ");
			migrateExpression(switchExpression.getDefaultExpr(), ctx);
			writeln(";");
			writeln(" }");
		}
	}

	private void migrateStringLiteral(StringLiteral expression, MigrationExecutionContext ctx) {
		write("'");
		write(excape(expression.getValue()));
		write("'");
	}

	private String excape(String value) {
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

	private void migrateRealLiteral(RealLiteral realLiteral, MigrationExecutionContext ctx) {
		write(new Double(realLiteral.getLiteralValue()).toString());
	}

	private void migrateNullLiteral(NullLiteral expression, MigrationExecutionContext ctx) {
		write("null");
	}

	private void migrateIntegerLiteral(IntegerLiteral integerLiteral, MigrationExecutionContext ctx) {
		write(new Integer(integerLiteral.getLiteralValue()).toString());
	}

	private void migrateBooleanLiteral(BooleanLiteral booleanLiteral, MigrationExecutionContext ctx) {
		write(Boolean.valueOf(booleanLiteral.getLiteralValue()) ? Boolean.TRUE.toString() : Boolean.FALSE.toString());
	}

	private void migrateListLiteral(ListLiteral listLiteral, MigrationExecutionContext ctx) throws MigrationException {
		write("Sequence { ");
		for (int i = 0; i < listLiteral.getElements().length; i++) {
			if (i > 0) {
				write(", ");
			}
			migrateExpression(listLiteral.getElements()[i], ctx);
		}
		write(" }");
	}

	private void migrateLetExpression(LetExpression letExpression, MigrationExecutionContext ctx) throws MigrationException {
		write("let ");
		write(letExpression.getVarName().getValue());
		write(" = ");
		migrateExpression(letExpression.getVarExpression(), ctx);
		write(" in ");
		migrateExpression(letExpression.getTargetExpression(), ctx);
	}

	private void migrateIfExpression(IfExpression ifExpression, MigrationExecutionContext ctx) throws MigrationException {
		write("if ");
		migrateExpression(ifExpression.getCondition(), ctx);
		write(" then ");
		migrateExpression(ifExpression.getThenPart(), ctx);
		write(" else ");
		migrateExpression(ifExpression.getElsePart(), ctx);
		write(" endif");
	}

	private void migrateConstructorCallExpression(ConstructorCallExpression constructorCall, MigrationExecutionContext ctx) throws MigrationException {
		write("object ");
		EClassifier type = ctx.getTypeForName(constructorCall.getType().getValue());
		if (type == null) {
			throw new MigrationException(Type.TYPE_NOT_FOUND, constructorCall.getType().getValue());
		}

		write(getQvtFQName(type));
		write(" {}");
	}

	private void migrateChainExpression(ChainExpression chainExpression, MigrationExecutionContext ctx) throws MigrationException {
		// TODO: currently only top-level chain expressions are supported. We
		// have to develop a way to support inner chain expressions like:
		// if(a.b()->c.d()->e.f) then {...} else {...}
		// for now solution is to use separate helpers for each nested chain
		// expression
		if (expressionsStack.size() > 1 && false == expressionsStack.peek() instanceof ChainExpression) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, "Inner " + chainExpression.getClass().getName());
		}
		migrateExpression(chainExpression.getFirst(), ctx);
		writeln(";");
		if (expressionsStack.size() == 1) {
			markReturnPosition();
		}
		migrateExpression(chainExpression.getNext(), ctx);
	}

	private void migrateBooleanOperation(BooleanOperation booleanOperation, MigrationExecutionContext ctx) throws MigrationException {
		migrateExpression(booleanOperation.getLeft(), ctx);
		if (booleanOperation.isAndOperation()) {
			write(" and ");
		} else if (booleanOperation.isOrOperation()) {
			write(" or ");
		} else if (booleanOperation.isImpliesOperation()) {
			write(" implies ");
		} else {
			throw new MigrationException(Type.UNSUPPORTED_BOOLEAN_OPERATION, booleanOperation.getOperator());
		}
		migrateExpression(booleanOperation.getRight(), ctx);
	}

	private void migrateCast(Cast cast, MigrationExecutionContext ctx) throws MigrationException {
		migrateExpression(cast.getTarget(), ctx);
		EClassifier type = ctx.getTypeForName(cast.getType().getValue());
		if (type == null) {
			throw new MigrationException(Type.TYPE_NOT_FOUND, cast.getType().getValue());
		}
		write(".oclAsType(");
		write(getQvtFQName(type));
		write(")");
	}

	private void migrateTypeSelectExpression(TypeSelectExpression typeSelectExpression, MigrationExecutionContext ctx) throws MigrationException {
		migrateExpression(typeSelectExpression.getTarget(), ctx);
		EClassifier type = ctx.getTypeForName(typeSelectExpression.getTypeLiteral().getValue());
		if (type == null) {
			throw new MigrationException(Type.TYPE_NOT_FOUND, typeSelectExpression.getTypeLiteral().getValue());
		}
		write("[");
		write(getQvtFQName(type));
		write("]");
	}

	private void migrateCollectionExpression(CollectionExpression collectionExpression, MigrationExecutionContext ctx) throws MigrationException {
		if (collectionExpression.getTarget() == null) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, "Collection expression without target specified: " + collectionExpression.toString());
		}
		int placeholder = getCurrentPosition();
		boolean hasNegation = false;
		migrateExpression(collectionExpression.getTarget(), ctx);
		write("->");
		// TODO: replace all these if() with single one +
		// write(collectionExpression.getName().getValue())?
		if (collectionExpression.getName().getValue().equals(SyntaxConstants.COLLECT)) {
			write("collect");
		} else if (collectionExpression.getName().getValue().equals(SyntaxConstants.SELECT)) {
			write("select");
		} else if (collectionExpression.getName().getValue().equals(SyntaxConstants.REJECT)) {
			write("reject");
		} else if (collectionExpression.getName().getValue().equals(SyntaxConstants.EXISTS)) {
			write("exists");
		} else if (collectionExpression.getName().getValue().equals(SyntaxConstants.NOT_EXISTS)) {
			hasNegation = true;
			write("not ", placeholder);
			write("exists");
		} else if (collectionExpression.getName().getValue().equals(SyntaxConstants.FOR_ALL)) {
			write("forAll");
		} else {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, collectionExpression.getName().getValue());
		}
		write("(");
		write(collectionExpression.getElementName());
		write(" | ");
		migrateExpression(collectionExpression.getClosure(), ctx);
		write(")");
		if (hasNegation) {
			addBraces(placeholder);
		}
	}

	private void addBraces(int placeholder) {
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

	private void migrateOperationCall(OperationCall operationCall, MigrationExecutionContext ctx) throws MigrationException {
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
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(")");
			return;
		case OPERATION_REF:
			if (isInfixOperation(trace)) {
				internalMigrateInfixOperation(trace, operationCall, ctx);
			} else if (isCollectionOperation(trace)) {
				internalMigrateCollectionOperationCall(trace, operationCall, ctx);
			} else {
				internalMigrateOperationCallTarget(operationCall, ctx);
				write(".");
				write(getQVTOperationName(trace));
				write("(");
				internalMigrateOperationCallParameters(operationCall, ctx);
				write(")");
				convertTypedElementCallProduct(trace.getEOperation());
			}
			return;
		case IMPLICIT_COLLECT_OPERATION_REF:
			internalMigrateOperationCallTarget(operationCall, ctx);
			write(".");
			// TODO: Implicit collect of collection operation result is not
			// supported now
			write(getQVTOperationName(trace));
			write("(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(")");
			convertImplicitCollectProduct(trace.getTargetType());
			return;
		case EXTENSION_REF:
			assert operationCall.getTarget() != null;
			write(operationCall.getName().getValue());
			write("(");
			migrateExpression(operationCall.getTarget(), ctx);
			if (operationCall.getParams().length > 0) {
				write(", ");
				internalMigrateOperationCallParameters(operationCall, ctx);
			}
			write(")");
			return;
		case IMPLICIT_COLLECT_EXTENSION_REF:
			assert operationCall.getTarget() != null;
			migrateExpression(operationCall.getTarget(), ctx);
			String iteratorName = getUniqueVarName(getDefinedVariables(operationCall, ctx));
			write("->collect(");
			write(iteratorName);
			write(" | ");
			write(operationCall.getName().getValue());
			write("(");
			write(iteratorName);
			if (operationCall.getParams().length > 0) {
				write(", ");
				internalMigrateOperationCallParameters(operationCall, ctx);
			}
			write(")");
			write(")");
			convertImplicitCollectProduct(trace.getTargetType());
			return;
		default:
		}
	}
	
	private void internalMigrateInfixOperation(OperationCallTrace trace, OperationCall operationCall, MigrationExecutionContext ctx) throws MigrationException {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		int placeholder = getCurrentPosition();
		internalMigrateOperationCallTarget(operationCall, ctx);
		// TODO: add other infix operations to this list
		String opName = eOperation.getName();
		if (BuiltinMetaModel.Boolean_NE == eOperation) {
			write("not ", placeholder);
		} else if (BuiltinMetaModel.Int_Unary_Minus == eOperation || BuiltinMetaModel.Double_Unary_Minus == eOperation) {
			write(opName, placeholder);
		} else if (BuiltinMetaModel.Int_Minus_Int == eOperation || BuiltinMetaModel.Int_Minus_Double == eOperation || BuiltinMetaModel.Double_Minus_Int == eOperation
				|| BuiltinMetaModel.Double_Minus_Double == eOperation || BuiltinMetaModel.Int_Plus_Int == eOperation || BuiltinMetaModel.Int_Plus_Double == eOperation
				|| BuiltinMetaModel.Double_Plus_Int == eOperation || BuiltinMetaModel.Double_Plus_Double == eOperation) {
			write(" ");
			write(opName);
			write(" ");
		} else {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, "Incorrect infix operation: " + opName);
		}
		internalMigrateOperationCallParameters(operationCall, ctx);
		if (BuiltinMetaModel.Boolean_NE == eOperation || BuiltinMetaModel.Int_Unary_Minus == eOperation || BuiltinMetaModel.Double_Unary_Minus == eOperation) {
			// Enclosing with braces for "not" expression here
			addBraces(placeholder);
		}
	}

	private void internalMigrateOperationCallTarget(OperationCall operationCall, MigrationExecutionContext ctx) throws MigrationException {
		if (operationCall.getTarget() != null) {
			migrateExpression(operationCall.getTarget(), ctx);
		} else {
			// getTarget() == null if it is an implicit self operation.
			// TODO: check if it is working with XPand
			write("self");
		}
	}

	private void internalMigrateCollectionOperationCall(OperationCallTrace trace, OperationCall operationCall, MigrationExecutionContext ctx) throws MigrationException {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		EClassifier targetType = trace.getTargetType();
		assert targetType != null;
		
		if (BuiltinMetaModel.Collection_Clear != eOperation && BuiltinMetaModel.List_WithoutFirst != eOperation && BuiltinMetaModel.List_WithoutLast != eOperation) {
			internalMigrateOperationCallTarget(operationCall, ctx);
		}
		
		if (BuiltinMetaModel.Collection_Add == eOperation) {
			convertCollectionTypes(targetType, targetType, true);
			write("->including(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(")");
		} else if (BuiltinMetaModel.Collection_AddAll == eOperation) {
			convertCollectionTypes(targetType, targetType, true);
			write("->union");
			internalMigrateCollectionOperationCollectionParameter(trace, operationCall, targetType, ctx);
		} else if (BuiltinMetaModel.Collection_Clear == eOperation) {
			if (isSetType(targetType)) {
				write("Set{}");
			} else {
				write("Sequence{}");
			}
		} else if (BuiltinMetaModel.Collection_Flatten == eOperation) {
			convertCollectionTypes(targetType, targetType, true);
			write("->flatten()");
		} else if (BuiltinMetaModel.Collection_Union == eOperation) {
			EClass setType = BuiltinMetaModel.getSetType(EcorePackage.eINSTANCE.getEJavaObject());
			convertCollectionTypes(targetType, setType, true);
			write("->union");
			internalMigrateCollectionOperationCollectionParameter(trace, operationCall, setType, ctx);
		} else if (BuiltinMetaModel.Collection_Intersect == eOperation) {
			EClass setType = BuiltinMetaModel.getSetType(EcorePackage.eINSTANCE.getEJavaObject());
			convertCollectionTypes(targetType, setType, true);
			write("->intersection");
			internalMigrateCollectionOperationCollectionParameter(trace, operationCall, setType, ctx);
		} else if (BuiltinMetaModel.Collection_Without == eOperation) { 
			EClass setType = BuiltinMetaModel.getSetType(EcorePackage.eINSTANCE.getEJavaObject());
			convertCollectionTypes(targetType, setType, true);
			write("->-");
			internalMigrateCollectionOperationCollectionParameter(trace, operationCall, setType, ctx);
		} else if (BuiltinMetaModel.Collection_ToSet == eOperation) { 
			EClass setType = BuiltinMetaModel.getSetType(EcorePackage.eINSTANCE.getEJavaObject());
			convertCollectionTypes(targetType, setType, false);
		} else if (BuiltinMetaModel.Collection_ToList == eOperation) { 
			EClass listType = BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEJavaObject());
			convertCollectionTypes(targetType, listType, false);
		} else if (BuiltinMetaModel.Collection_Contains == eOperation) { 
			write("[OclAny]");
			write("->includes(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(")");
		} else if (BuiltinMetaModel.Collection_ContainsAll == eOperation) { 
			write("[OclAny]");
			write("->includesAll(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(")");
		} else if (BuiltinMetaModel.List_Get == eOperation) { 
			write("->at(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(" + 1)");
		} else if (BuiltinMetaModel.List_WithoutFirst == eOperation) { 
			write("if ");
			internalMigrateOperationCallTarget(operationCall, ctx);
			write("->isEmpty() then Sequence{} else ");
			internalMigrateOperationCallTarget(operationCall, ctx);
			write("->subSequence(2, ");
			internalMigrateOperationCallTarget(operationCall, ctx);
			write("->size()) endif");
		} else if (BuiltinMetaModel.List_WithoutLast == eOperation) { 
			write("if ");
			internalMigrateOperationCallTarget(operationCall, ctx);
			write("->isEmpty() then Sequence{} else ");
			internalMigrateOperationCallTarget(operationCall, ctx);
			write("->subSequence(1, ");
			internalMigrateOperationCallTarget(operationCall, ctx);
			write("->size() - 1) endif");
		} else if (BuiltinMetaModel.List_PurgeDups == eOperation) { 
			write("->asOrderedSet()->asSequence()");
		} else if (BuiltinMetaModel.List_IndexOf == eOperation) {
			write("[OclAny]->indexOf(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(") - 1");
		} else {
			// TODO: remove this branch?
			write("->");
			write(eOperation.getName());
			write("(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(")");
		}
	}

	private void internalMigrateCollectionOperationCollectionParameter(OperationCallTrace trace, OperationCall operationCall, EClassifier targetType, MigrationExecutionContext ctx) throws MigrationException {
		EClassifier[] paramTypes = trace.getParamTypes();
		assert paramTypes != null && paramTypes.length == 1;
		assert operationCall.getParams().length == 1;
		write("(");
		migrateExpression(operationCall.getParams()[0], ctx);
		assert BuiltinMetaModel.isCollectionType(paramTypes[0]);
		convertCollectionTypes(paramTypes[0], targetType, false);
		write(")");
	}

	// TODO: make two separate methods from this one?
	private void convertCollectionTypes(EClassifier originalCollectionType, EClassifier targetType, boolean convertToAnyType) {
		if (isListType(originalCollectionType)) {
			if (convertToAnyType) {
				write("[OclAny]");
			}
			if (isSetType(targetType)) {
				write("->asSet()");
			} else if (!isListType(targetType)) {
				write("->asBag()");
			}
		} else if (isSetType(originalCollectionType)) {
			if (convertToAnyType) {
				write("[OclAny]");
			}
			if (isListType(targetType)) {
				write("->asSequence()");
			}
		} else {
			String iteratorName = "it";
			write("->collect(");
			write(iteratorName);
			write(" | ");
			write(iteratorName);
			if (convertToAnyType) {
				write(".oclAsType(OclAny)");
			}
			write(")");
			if (isListType(targetType)) {
				write("->asSequence()");
			} else if (isSetType(targetType)) {
				write("->asSet()");
			}
		}
	}

	private boolean isCollectionOperation(OperationCallTrace trace) {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		return collectionOperations.contains(eOperation);
	}

	private String getUniqueVarName(Set<String> definedVariables) {
		String prefix = "it";
		String varName = prefix;
		for (int i = 1; definedVariables.contains(varName); i++) {
			varName = prefix + "_" + i;
		}
		return varName;
	}

	private Set<String> getDefinedVariablesForInnerExpression(Expression expression, MigrationExecutionContext ctx) {
		Set<String> definedVariables = getDefinedVariables(expression, ctx);
		ExpressionAnalyzeTrace expressionAnalyzeTrace = ctx.getTraces().get(expression);
		if (expressionAnalyzeTrace instanceof OperationCallTrace) {
			OperationCallTrace trace = (OperationCallTrace) expressionAnalyzeTrace;
			if (trace.getType() == OperationCallTrace.Type.IMPLICIT_COLLECT_EXTENSION_REF) {
				definedVariables.add(getUniqueVarName(definedVariables));
			}
		}
		return definedVariables;
	}

	private Set<String> getDefinedVariables(Expression expression, MigrationExecutionContext ctx) {
		Set<String> result = new HashSet<String>();
		if (expression instanceof BooleanOperation) {
			BooleanOperation booleanOperation = (BooleanOperation) expression;
			result.addAll(getDefinedVariablesForInnerExpression(booleanOperation.getLeft(), ctx));
			result.addAll(getDefinedVariablesForInnerExpression(booleanOperation.getRight(), ctx));
		} else if (expression instanceof Cast) {
			Cast cast = (Cast) expression;
			result.addAll(getDefinedVariablesForInnerExpression(cast.getTarget(), ctx));
		} else if (expression instanceof ChainExpression) {
			ChainExpression chainExpression = (ChainExpression) expression;
			result.addAll(getDefinedVariablesForInnerExpression(chainExpression.getFirst(), ctx));
			result.addAll(getDefinedVariablesForInnerExpression(chainExpression.getNext(), ctx));
		} else if (expression instanceof CollectionExpression) {
			CollectionExpression collectionExpression = (CollectionExpression) expression;
			result.addAll(getDefinedVariablesForInnerExpression(collectionExpression.getClosure(), ctx));
			result.addAll(getDefinedVariablesOfTarget(collectionExpression, ctx));
			result.add(collectionExpression.getElementName());
		} else if (expression instanceof OperationCall) {
			OperationCall operationCall = (OperationCall) expression;
			result.addAll(getDefinedVariablesOfTarget(operationCall, ctx));
			for (int i = 0; i < operationCall.getParams().length; i++) {
				result.addAll(getDefinedVariablesForInnerExpression(operationCall.getParams()[i], ctx));
			}
		} else if (expression instanceof TypeSelectExpression) {
			TypeSelectExpression typeSelect = (TypeSelectExpression) expression;
			result.addAll(getDefinedVariablesOfTarget(typeSelect, ctx));
		} else if (expression instanceof FeatureCall) {
			FeatureCall featureCall = (FeatureCall) expression;
			result.addAll(getDefinedVariablesOfTarget(featureCall, ctx));
			if (featureCall.getTarget() == null) {
				result.add(featureCall.getName().getValue());
			}
		} else if (expression instanceof IfExpression) {
			IfExpression ifExpression = (IfExpression) expression;
			result.addAll(getDefinedVariablesForInnerExpression(ifExpression.getCondition(), ctx));
			result.addAll(getDefinedVariablesForInnerExpression(ifExpression.getThenPart(), ctx));
			result.addAll(getDefinedVariablesForInnerExpression(ifExpression.getElsePart(), ctx));
		} else if (expression instanceof LetExpression) {
			LetExpression letExpression = (LetExpression) expression;
			result.addAll(getDefinedVariablesForInnerExpression(letExpression.getVarExpression(), ctx));
			result.addAll(getDefinedVariablesForInnerExpression(letExpression.getTargetExpression(), ctx));
			result.add(letExpression.getVarName().getValue());
		} else if (expression instanceof ListLiteral) {
			ListLiteral listLiteral = (ListLiteral) expression;
			for (int i = 0; i < listLiteral.getElements().length; i++) {
				result.addAll(getDefinedVariablesForInnerExpression(listLiteral.getElements()[i], ctx));
			}
		} else if (expression instanceof SwitchExpression) {
			SwitchExpression switchExpression = (SwitchExpression) expression;
			result.addAll(getDefinedVariablesForInnerExpression(switchExpression.getSwitchExpr(), ctx));
			result.addAll(getDefinedVariablesForInnerExpression(switchExpression.getDefaultExpr(), ctx));
			for (Case caseExpresion : switchExpression.getCases()) {
				result.addAll(getDefinedVariablesForInnerExpression(caseExpresion.getCondition(), ctx));
				result.addAll(getDefinedVariablesForInnerExpression(caseExpresion.getThenPart(), ctx));
			}
		}
		return result;
	}

	private Set<String> getDefinedVariablesOfTarget(FeatureCall featrueCall, MigrationExecutionContext ctx) {
		if (featrueCall.getTarget() != null) {
			return getDefinedVariablesForInnerExpression(featrueCall.getTarget(), ctx);
		}
		return Collections.emptySet();
	}

	private void convertTypedElementCallProduct(ETypedElement typedElement) {
		assert typedElement != null;
		if (typedElement.isMany() && typedElement.isOrdered() && typedElement.isUnique()) {
			write("->asSequence()");
		}
	}

	private void convertImplicitCollectProduct(EClassifier targetType) {
		assert targetType != null;
		if (!isListType(targetType)) {
			write("->asSequence()");
		}
	}

	private void internalMigrateOperationCallParameters(OperationCall operationCall, MigrationExecutionContext ctx) throws MigrationException {
		for (int i = 0; i < operationCall.getParams().length; i++) {
			if (i > 0) {
				write(", ");
			}
			migrateExpression(operationCall.getParams()[i], ctx);
		}
	}

	private String getQVTOperationName(OperationCallTrace trace) {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		if (BuiltinMetaModel.EString_ToFirstUpper == eOperation) {
			return "firstToUpper";	
		}
		return eOperation.getName();
	}
	
	private boolean isInfixOperation(OperationCallTrace trace) {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		return infixOperations.contains(eOperation);
	}

	private void migrateFeatureCall(FeatureCall featureCall, MigrationExecutionContext ctx) throws MigrationException {
		ExpressionAnalyzeTrace expressionTrace = ctx.getTraces().get(featureCall);
		if (false == expressionTrace instanceof FeatureCallTrace) {
			throw new MigrationException(Type.UNSUPPORTED_FEATURE_CALL_TRACE, String.valueOf(expressionTrace));
		}
		FeatureCallTrace trace = (FeatureCallTrace) expressionTrace;
		switch (trace.getType()) {
		case ENUM_LITERAL_REF:
			EEnumLiteral enumLiteral = trace.getEnumLiteral();
			assert enumLiteral != null;
			String modelType = modeltypeImports.getModeltypeAlias(enumLiteral.getEEnum().getEPackage());
			write(modelType);
			write("::");
			write(enumLiteral.getEEnum().getName());
			write("::");
			write(enumLiteral.getName());
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
			migrateExpression(featureCall.getTarget(), ctx);
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

	private static String getLastSegment(String string, String separator) {
		int delimeterIndex = string.lastIndexOf(separator);
		if (delimeterIndex > 0) {
			return string.substring(delimeterIndex + separator.length());
		} else {
			return string;
		}
	}

	private int getCurrentPosition() {
		return output.length();
	}

	private void write(String word, int index) {
		output.insert(index, word);
	}

	private void write(String word) {
		output.append(word);
	}

	private void writeln(String line) {
		output.append(line);
		output.append(LF);
	}

}