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
import java.util.Iterator;
import java.util.List;
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
import org.eclipse.ocl.types.VoidType;

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

	private static final String OCL_PATH_SEPARATOR = "::";

	private ResourceManager resourceManager;

	private StringBuilder output = new StringBuilder();

	private String resourceName;

	private ModeltypeImports modeltypeImportsManger;

	private StandardLibraryImports stdLibImportsManager;

	private boolean injectUnusedImports;

	private MigrationExecutionContext rootExecutionContext;

	private Stack<Expression> expressionsStack = new Stack<Expression>();

	private int returnPosition;

	private VariableNameDispatcher variableDispatcher;

	private Stack<AbstractImportsManager> importsManagers = new Stack<AbstractImportsManager>();

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
		
		importsManagers.push(stdLibImportsManager = new StandardLibraryImports(output));
		addLibraryImports(xtendResource, false);
		if (xtendResource.getImportedExtensions().length > 0) {
			writeln("");
		}

		importsManagers.push(modeltypeImportsManger = new ModeltypeImports(output, injectUnusedImports));
		for (String namespace : xtendResource.getImportedNamespaces()) {
			modeltypeImportsManger.registerModeltype(namespace);
		}

		writeln("library " + shortResourceName + ";");
		writeln("");

		for (Iterator<Extension> it = xtendResource.getExtensions().iterator(); it.hasNext();) {
			Extension extension = it.next();
			variableDispatcher = new VariableNameDispatcher(extension);
			migrateExtension(extension, ctx);
			if (it.hasNext()) {
				writeln("");
			}
		}
		while (!importsManagers.isEmpty()) {
			importsManagers.pop().injectImports();
		}
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
		if (classifier == BuiltinMetaModel.VOID) {
			return VoidType.SINGLETON_NAME;
		}
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
		String alias = modeltypeImportsManger.getModeltypeAlias(ePackage);
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
		int placeholder = getCurrentPosition();
		migrateExpression(typeSelectExpression.getTarget(), ctx);
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
		internalMigrateTypeSelectCastingCollectionToBag(trace.getTargetType(), getQvtFQName(type), placeholder);
		if (!isListType(trace.getTargetType())) {
			write("->asSequence()");
		}
	}
	
	private void internalMigrateTypeSelectCastingCollectionToBag(EClassifier collectionType, String typeName, int placeholder) {
		assert BuiltinMetaModel.isCollectionType(collectionType);
		if (isListType(collectionType) || isSetType(collectionType)) {
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

	private void migrateCollectionExpression(CollectionExpression collectionExpression, MigrationExecutionContext ctx) throws MigrationException {
		if (collectionExpression.getTarget() == null) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, "Collection expression without target specified: " + collectionExpression.toString());
		}
		int placeholder = getCurrentPosition();
		boolean hasNegation = false;
		migrateExpression(collectionExpression.getTarget(), ctx);
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
		migrateExpression(collectionExpression.getClosure(), ctx);
		write(")");
		if (trace.getType() == CollectionExpressionTrace.Type.COLLECT_REF && isSetType(trace.getResultType())) {
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
				internalMigrateOperationCall(trace, operationCall, ctx);
				convertTypedElementCallProduct(trace.getEOperation());
			}
			return;
		case IMPLICIT_COLLECT_OPERATION_REF:
			// TODO: Implicit collect of collection operation result is not
			// supported now
			internalMigrateOperationCall(trace, operationCall, ctx);
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
			String iteratorName = variableDispatcher.getNextIteratorName();
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
			throw new MigrationException(Type.UNSUPPORTED_OPERATION_CALL_TRACE, "Incorrect type: " + trace.getType());
		}
	}
	
	private void internalMigrateInfixOperation(OperationCallTrace trace, OperationCall operationCall, MigrationExecutionContext ctx) throws MigrationException {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		int placeholder = getCurrentPosition();
		internalMigrateOperationCallTarget(operationCall, ctx);
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
		internalMigrateOperationCallParameters(operationCall, ctx);
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
		assert BuiltinMetaModel.isCollectionType(targetType);
		EClassifier elementType = BuiltinMetaModel.getInnerType(targetType);
		
		int placeholder = getCurrentPosition();
		if (BuiltinMetaModel.Collection_Clear != eOperation && BuiltinMetaModel.List_WithoutFirst != eOperation && BuiltinMetaModel.List_WithoutLast != eOperation) {
			internalMigrateOperationCallTarget(operationCall, ctx);
		}
		
		if (BuiltinMetaModel.Collection_Add == eOperation) {
			EClassifier commonSuperType = getCommonSuperType(elementType, getSingleParameterType(trace));
			internalMigrateToConcreteCollection(targetType, commonSuperType, placeholder);
			write("->including(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(")");
			internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_AddAll == eOperation) {
			EClassifier commonSuperType = getCommonSuperType(elementType, getSingleCollectionParameterElementType(trace));
			internalMigrateToConcreteCollection(targetType, commonSuperType, placeholder);
			write("->union(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			internalMigrateParameterCollectionToMain(getSingleParameterType(trace), targetType);
			write(")");
			internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_Union == eOperation) {
			EClassifier commonSuperType = getCommonSuperType(elementType, getSingleCollectionParameterElementType(trace));
			internalMigrateToSet(targetType, commonSuperType, placeholder);
			write("->union(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			internalMigrateParameterCollectionToSet(getSingleParameterType(trace));
			write(")");
			internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_Intersect == eOperation) {
			EClassifier commonSuperType = getCommonSuperType(elementType, getSingleCollectionParameterElementType(trace));
			internalMigrateToSet(targetType, commonSuperType, placeholder);
			write("->intersection(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			internalMigrateParameterCollectionToSet(getSingleParameterType(trace));
			write(")");
			internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_Without == eOperation) {
			EClassifier commonSuperType = getCommonSuperType(elementType, getSingleCollectionParameterElementType(trace));
			internalMigrateToSet(targetType, commonSuperType, placeholder);
			write("->-(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			internalMigrateParameterCollectionToSet(getSingleParameterType(trace));
			write(")");
			internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_Contains == eOperation) {
			EClassifier parameterType = getSingleParameterType(trace);
			if (!BuiltinMetaModel.isAssignableFrom(elementType, parameterType)) {
				EClassifier commonSuperType = getCommonSuperType(elementType, parameterType);
				internalMigrateTypeSelect(getQvtFQName(commonSuperType), placeholder);
			}
			write("->includes(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(")");
		} else if (BuiltinMetaModel.Collection_ContainsAll == eOperation) {
			EClassifier parameterElementType = getSingleCollectionParameterElementType(trace);
			if (!BuiltinMetaModel.isAssignableFrom(elementType, parameterElementType)) {
				EClassifier commonSuperType = getCommonSuperType(elementType, parameterElementType);
				internalMigrateTypeSelect(getQvtFQName(commonSuperType), placeholder);
			}
			write("->includesAll(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(")");
		} else if (BuiltinMetaModel.List_IndexOf == eOperation) {
			EClassifier parameterType = getSingleParameterType(trace);
			if (!BuiltinMetaModel.isAssignableFrom(elementType, parameterType)) {
				EClassifier commonSuperType = getCommonSuperType(elementType, parameterType);
				internalMigrateTypeSelectCastingCollectionToBag(targetType, getQvtFQName(commonSuperType), placeholder);
			}
			write("->indexOf(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(")");
			write("(", placeholder);
			write(" - 1)");
		} else if (BuiltinMetaModel.Collection_Clear == eOperation) {
			write("Bag{}");
			if (elementType != EcorePackage.eINSTANCE.getEJavaObject()) {
				write("[");
				write(getQvtFQName(elementType));
				write("]");
			}
		} else if (BuiltinMetaModel.Collection_Flatten == eOperation) {
			internalMigrateToConcreteCollection(targetType, elementType, placeholder);
			write("->flatten()");
			internalMigrateToBag(targetType);
		} else if (BuiltinMetaModel.Collection_ToSet == eOperation) { 
			internalMigrateToSet(targetType, elementType, placeholder);
		} else if (BuiltinMetaModel.Collection_ToList == eOperation) {
			internalMigrateToList(targetType, elementType, placeholder);
		} else if (BuiltinMetaModel.List_Get == eOperation) { 
			write("->at(");
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(" + 1)");
		} else if (BuiltinMetaModel.List_WithoutFirst == eOperation) {
			String varName = variableDispatcher.getNextVariableName();
			write("let ");
			write(varName);
			write(" = ");
			internalMigrateOperationCallTarget(operationCall, ctx);
			write(" in ");
			write("if ");
			write(varName);
			write("->size() < 2 then Sequence{}");
			if (elementType != EcorePackage.eINSTANCE.getEJavaObject()) {
				write("[");
				write(getQvtFQName(elementType));
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
			internalMigrateOperationCallTarget(operationCall, ctx);
			write(" in ");
			write("if ");
			write(varName);
			write("->size() < 2 then Sequence{}");
			if (elementType != EcorePackage.eINSTANCE.getEJavaObject()) {
				write("[");
				write(getQvtFQName(elementType));
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
			internalMigrateOperationCallParameters(operationCall, ctx);
			write(")");
		}
	}
	
	private void internalMigrateToBag(EClassifier collectionType) {
		if (isListType(collectionType) || isSetType(collectionType)) {
			write("->asBag()");
		}
	}
	
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
			internalMigrateTypeSelectCastingCollectionToBag(collectionType, getQvtFQName(elementSuperType), placeholder);	
		} else if (!isListType(collectionType) && !isSetType(collectionType)) {
			internalMigrateCollectionToBag(null);
		}
	}
	
	private void internalMigrateToSet(EClassifier collectionType, EClassifier elementSuperType, int placeholder) throws MigrationException {
		internalMigrateToConcreteCollection(collectionType, elementSuperType, placeholder);
		if (!isSetType(collectionType)) {
			write("->asSet()");
		}
	}
	
	private void internalMigrateToList(EClassifier collectionType, EClassifier elementSuperType, int placeholder) throws MigrationException {
		internalMigrateToConcreteCollection(collectionType, elementSuperType, placeholder);
		if (!isListType(collectionType)) {
			write("->asSequence()");
		}
	}
	
	private void internalMigrateParameterCollectionToMain(EClassifier parameterCollectionType, EClassifier mainCollectionType) {
		assert BuiltinMetaModel.isCollectionType(parameterCollectionType);
		assert BuiltinMetaModel.isCollectionType(mainCollectionType);
		if (isListType(mainCollectionType)) {
			if (isSetType(parameterCollectionType)) {
				write("->asSequence()");
			} else if (!isListType(parameterCollectionType)) {
				internalMigrateCollectionToBag(null);
				write("->asSequence()");
			}
		} else if (isSetType(mainCollectionType)) {
			if (isListType(parameterCollectionType)) {
				write("->asSet()");
			} else if (!isSetType(parameterCollectionType)) {
				internalMigrateCollectionToBag(null);
				write("->asSet()");
			}
		} else {
			if (isSetType(parameterCollectionType) || isListType(parameterCollectionType)) {
				write("->asBag()");
			} else {
				internalMigrateCollectionToBag(null);
			}
		}
	}
	
	private void internalMigrateParameterCollectionToSet(EClassifier parameterCollectionType) {
		assert BuiltinMetaModel.isCollectionType(parameterCollectionType);
		if (isListType(parameterCollectionType)) {
			write("->asSet()");
		} else if (!isSetType(parameterCollectionType)) {
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

	private void internalMigrateOperationCall(OperationCallTrace trace, OperationCall operationCall, MigrationExecutionContext ctx) throws MigrationException {
		EOperation eOperation = trace.getEOperation();
		assert eOperation != null;
		internalMigrateOperationCallTarget(operationCall, ctx);
		write(".");
		write(stdLibImportsManager.getOperationName(eOperation));
		write("(");
		if (BuiltinMetaModel.EString_SubString_StartEnd == eOperation) {
			write("1 + ");
		}
		internalMigrateOperationCallParameters(operationCall, ctx);
		write(")");
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
			String modelType = modeltypeImportsManger.getModeltypeAlias(enumLiteral.getEEnum().getEPackage());
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