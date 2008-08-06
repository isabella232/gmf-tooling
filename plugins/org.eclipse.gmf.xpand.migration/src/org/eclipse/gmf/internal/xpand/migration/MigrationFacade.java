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
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
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

public class MigrationFacade {

	static final String LF = System.getProperty("line.separator");

	private static final String OCL_PATH_SEPARATOR = "::";

	private ResourceManager resourceManager;

	private StringBuilder output = new StringBuilder();

	private String resourceName;

	private ModeltypeImports modeltypeImports;

	private boolean injectUnusedImports;

	private ExecutionContext rootExecutionContext;

	private Stack<Expression> expressionsStack = new Stack<Expression>();

	private int returnPosition;

	public MigrationFacade(ResourceManager resourceManager, String xtendResourceName, boolean injectUnusedImports) {
		this(resourceManager, xtendResourceName);
		this.injectUnusedImports = injectUnusedImports;
	}

	public MigrationFacade(ResourceManager resourceManager, String xtendResourceName, ExecutionContext executionContext) {
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
		ExecutionContext ctx = (rootExecutionContext != null ? rootExecutionContext : new ExecutionContextImpl(resourceManager)).cloneWithResource(xtendResource);
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

		for (Extension extension : xtendResource.getExtensions()) {
			migrateExtension(extension, ctx);
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

	private void migrateExtension(Extension extension, ExecutionContext ctx) throws MigrationException {
		try {
			extension.init(ctx);
		} catch (EvaluationException e) {
			throw new MigrationException(Type.ANALYZATION_PROBLEMS, e);
		}

		write("helper ");
		write(extension.getName());
		write("(");

		assert extension.getParameterTypes().size() > 0;
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

	private EClassifier getReturnType(Extension extension, ExecutionContext ctx) throws MigrationException {
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
			}
		}
		if (BuiltinMetaModel.isCollectionType(classifier)) {
			StringBuilder sb = new StringBuilder();
			if (classifier.getName().endsWith(BuiltinMetaModel.SET)) {
				sb.append("Set(");
			} else if (classifier.getName().endsWith(BuiltinMetaModel.LIST)) {
				sb.append("Sequence(");
			} else {
				sb.append("Collection(");
			}
			sb.append(getQvtFQName(BuiltinMetaModel.getInnerType(classifier)));
			return sb.append(")").toString();
		}
		EPackage ePackage = classifier.getEPackage();
		assert ePackage != null;
		String alias = modeltypeImports.getModeltypeAlias(ePackage);
		return alias + OCL_PATH_SEPARATOR + classifier.getName();
	}

	private void migrateExpressionExtension(ExpressionExtensionStatement extension, ExecutionContext ctx) throws MigrationException {
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

	private void migrateExpression(Expression expression, ExecutionContext ctx) throws MigrationException {
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

	private void migrateSwitchExpression(SwitchExpression switchExpression, ExecutionContext ctx) throws MigrationException {
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

	private void migrateStringLiteral(StringLiteral expression, ExecutionContext ctx) {
		write("'");
		write(expression.getValue());
		write("'");
	}

	private void migrateRealLiteral(RealLiteral realLiteral, ExecutionContext ctx) {
		write(new Double(realLiteral.getLiteralValue()).toString());
	}

	private void migrateNullLiteral(NullLiteral expression, ExecutionContext ctx) {
		write("null");
	}

	private void migrateIntegerLiteral(IntegerLiteral integerLiteral, ExecutionContext ctx) {
		write(new Integer(integerLiteral.getLiteralValue()).toString());
	}

	private void migrateBooleanLiteral(BooleanLiteral booleanLiteral, ExecutionContext ctx) {
		write(Boolean.valueOf(booleanLiteral.getLiteralValue()) ? Boolean.TRUE.toString() : Boolean.FALSE.toString());
	}

	private void migrateListLiteral(ListLiteral listLiteral, ExecutionContext ctx) throws MigrationException {
		write("Sequence { ");
		for (int i = 0; i < listLiteral.getElements().length; i++) {
			if (i > 0) {
				write(", ");
			}
			migrateExpression(listLiteral.getElements()[i], ctx);
		}
		write(" }");
	}

	private void migrateLetExpression(LetExpression letExpression, ExecutionContext ctx) throws MigrationException {
		write("let ");
		write(letExpression.getVarName().getValue());
		write(" = ");
		migrateExpression(letExpression.getVarExpression(), ctx);
		write(" in ");
		migrateExpression(letExpression.getTargetExpression(), ctx);
	}

	private void migrateIfExpression(IfExpression ifExpression, ExecutionContext ctx) throws MigrationException {
		write("if ");
		migrateExpression(ifExpression.getCondition(), ctx);
		write(" then ");
		migrateExpression(ifExpression.getThenPart(), ctx);
		write(" else ");
		migrateExpression(ifExpression.getElsePart(), ctx);
		write(" endif");
	}

	private void migrateConstructorCallExpression(ConstructorCallExpression constructorCall, ExecutionContext ctx) throws MigrationException {
		write("object ");
		EClassifier type = ctx.getTypeForName(constructorCall.getType().getValue());
		if (type == null) {
			throw new MigrationException(Type.TYPE_NOT_FOUND, constructorCall.getType().getValue());
		}

		write(getQvtFQName(type));
		write(" {}");
	}

	private void migrateChainExpression(ChainExpression chainExpression, ExecutionContext ctx) throws MigrationException {
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

	private void migrateBooleanOperation(BooleanOperation booleanOperation, ExecutionContext ctx) throws MigrationException {
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

	private void migrateCast(Cast cast, ExecutionContext ctx) throws MigrationException {
		migrateExpression(cast.getTarget(), ctx);
		EClassifier type = ctx.getTypeForName(cast.getType().getValue());
		if (type == null) {
			throw new MigrationException(Type.TYPE_NOT_FOUND, cast.getType().getValue());
		}
		write(".oclAsType(");
		write(getQvtFQName(type));
		write(")");
	}

	private void migrateTypeSelectExpression(TypeSelectExpression typeSelectExpression, ExecutionContext ctx) throws MigrationException {
		migrateExpression(typeSelectExpression.getTarget(), ctx);
		EClassifier type = ctx.getTypeForName(typeSelectExpression.getTypeLiteral().getValue());
		if (type == null) {
			throw new MigrationException(Type.TYPE_NOT_FOUND, typeSelectExpression.getTypeLiteral().getValue());
		}
		write("->select(element | element.oclIsKindOf(");
		write(getQvtFQName(type));
		write("))->collect(element | element.oclAsType(");
		write(getQvtFQName(type));
		write("))");
	}

	private void migrateCollectionExpression(CollectionExpression collectionExpression, ExecutionContext ctx) throws MigrationException {
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

	private void migrateOperationCall(OperationCall operationCall, ExecutionContext ctx) throws MigrationException {
		// TODO: if (target == null) then it can be a call to self.<operation>
		// in this case operation call call should be processed
		// specially (respecting self multiplicity).
		int placeholder = getCurrentPosition();
		if (operationCall.getTarget() != null) {
			// TODO: support different multiplicity of target - different
			// collections have to be created here. (->asList()..)
			migrateExpression(operationCall.getTarget(), ctx);
		}

		if (isInfixOperation(operationCall)) {
			insertInfixOperationCall(operationCall, placeholder);
		} else {
			if (operationCall.getTarget() != null) {
				write(".");
			}
			write(getQVTOperationName(operationCall));
			write("(");
		}

		for (int i = 0; i < operationCall.getParams().length; i++) {
			if (i > 0) {
				write(", ");
			}
			migrateExpression(operationCall.getParams()[i], ctx);
		}
		if (!isInfixOperation(operationCall)) {
			write(")");
		} else if (needsSurroundingBraces(operationCall)) {
			// Currently supported infix operations has 0 or 1 parameter
			// Enclosing with braces for "not" expression here
			addBraces(placeholder);
		}
	}

	private String getQVTOperationName(OperationCall operationCall) {
		String operationName = operationCall.getName().getValue();
		// TODO: In addition check target type (should be one of primitive
		// types) here
		if ("toFirstUpper".equals(operationName)) {
			return "firstToUpper";
		}
		return operationName;
	}

	private boolean needsSurroundingBraces(OperationCall operationCall) {
		return "!".equals(operationCall.getName().getValue());
	}

	private void insertInfixOperationCall(OperationCall operationCall, int placeholder) throws MigrationException {
		// TODO: add other infix operations to this list
		String opName = operationCall.getName().getValue();
		if ("!".equals(opName)) {
			write("not ", placeholder);
		} else if ("-".equals(opName) || "+".equals(opName)) {
			if (operationCall.getParams().length == 0) {
				write(opName, placeholder);
			} else if (operationCall.getParams().length == 1) {
				write(" ");
				write(opName);
				write(" ");
			} else {
				throw new MigrationException(Type.UNSUPPORTED_INFIX_OPERATION_PARAMETER, "\"" + opName + "\" only 0 or 1 parameters supported, passed: " + operationCall.getParams().length);
			}
		} else {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, "Incorrect infix operation: " + opName);
		}
	}

	private boolean isInfixOperation(OperationCall operationCall) {
		// TODO: add other infix operations to this list
		String opName = operationCall.getName().getValue();
		return "!".equals(opName) || "-".equals(opName) || "+".equals(opName);
	}

	private void migrateFeatureCall(FeatureCall featureCall, ExecutionContext ctx) throws MigrationException {
		if (featureCall.getTarget() == null) {
			EEnumLiteral enumLiteral = featureCall.getEnumLiteral(ctx);
			if (enumLiteral != null) {
				String modelType = modeltypeImports.getModeltypeAlias(enumLiteral.getEEnum().getEPackage());
				write(modelType);
				write("::");
				write(enumLiteral.getEEnum().getName());
				write("::");
				write(enumLiteral.getName());
				return;
			}
			// TODO: It could be a call to environment variable or
			// self.<feature> in case of "self" this call should be processed
			// specially (respecting self multiplicity).
		}
		if (featureCall.getTarget() != null) {
			// TODO: support different multiplicity of target - different
			// collections have to be created here. (->asList()..)
			migrateExpression(featureCall.getTarget(), ctx);
			write(".");
		}
		write(featureCall.getName().getValue());
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
