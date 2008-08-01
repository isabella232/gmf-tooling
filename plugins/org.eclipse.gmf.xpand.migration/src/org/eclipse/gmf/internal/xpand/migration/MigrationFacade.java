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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.expression.ast.BooleanLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.BooleanOperation;
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
	
	public MigrationFacade(ResourceManager resourceManager, String xtendResourceName, boolean injectUnusedImports) {
		this(resourceManager, xtendResourceName);
		this.injectUnusedImports = injectUnusedImports;
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
		ExecutionContext ctx = new ExecutionContextImpl(resourceManager);
		ctx = ctx.cloneWithResource(xtendResource);
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
			migrateExpressionExtension((ExpressionExtensionStatement) extension);
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
			throw new MigrationException(Type.EXTENSION_RETURN_TYPE_NOT_FOUND, extension.getReturnTypeIdentifier().getValue());
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
			}
		}

		EPackage ePackage = classifier.getEPackage();
		assert ePackage != null;
		String alias = modeltypeImports.getModeltypeAlias(ePackage);
		return alias + OCL_PATH_SEPARATOR + classifier.getName();
	}

	private void migrateExpressionExtension(ExpressionExtensionStatement extension) throws MigrationException {
		write("return ");
		migrateExpression(extension.getExpression());
		write(" ");
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
	
	private void migrateExpression(Expression expression) throws MigrationException {
		if (expression instanceof BooleanOperation) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof Cast) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof ChainExpression) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof ConstructorCallExpression) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof CollectionExpression) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof OperationCall) {
			migrateOperationCall((OperationCall) expression);
		} else if (expression instanceof TypeSelectExpression) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof FeatureCall) {
			migrateFeatureCall((FeatureCall) expression);
		} else if (expression instanceof IfExpression) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof LetExpression) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof ListLiteral) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof BooleanLiteral) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof IntegerLiteral) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof NullLiteral) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof RealLiteral) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof StringLiteral) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else if (expression instanceof SwitchExpression) {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		} else {
			throw new MigrationException(Type.UNSUPPORTED_EXPRESSION, expression.getClass().getName());
		}
	}

	private void migrateOperationCall(OperationCall operationCall) throws MigrationException {
		migrateFeatureCall(operationCall);
		write("(");
		for (int i = 0; i < operationCall.getParams().length; i++) {
			if (i > 0) {
				write(", ");
			}
			migrateExpression(operationCall.getParams()[i]);
		}
		write(")");
	}

	private void migrateFeatureCall(FeatureCall featureCall) throws MigrationException {
		if (featureCall.getTarget() != null) {
			migrateExpression(featureCall.getTarget());
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

	private void write(String word) {
		output.append(word);
	}

	private void writeln(String line) {
		output.append(line);
		output.append(LF);
	}

}
