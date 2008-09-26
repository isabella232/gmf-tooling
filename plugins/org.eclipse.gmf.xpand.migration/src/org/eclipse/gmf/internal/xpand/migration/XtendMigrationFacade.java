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
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.migration.MigrationException.Type;
import org.eclipse.gmf.internal.xpand.xtend.ast.CreateExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExpressionExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.Extension;
import org.eclipse.gmf.internal.xpand.xtend.ast.JavaExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.WorkflowSlotExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.XtendResource;

public class XtendMigrationFacade {

	private ResourceManager resourceManager;

	private StringBuilder output = new StringBuilder();

	private String resourceName;

	private StandardLibraryImports stdLibImportsManager;

	private boolean injectUnusedImports;

	private MigrationExecutionContext rootExecutionContext;

	private TypeManager typeManager;

	private ModeltypeImports modeltypeImportsManger;

	private ModelManager modelManager;

	private static String getLastSegment(String string, String separator) {
		int delimeterIndex = string.lastIndexOf(separator);
		if (delimeterIndex > 0) {
			return string.substring(delimeterIndex + separator.length());
		} else {
			return string;
		}
	}

	public XtendMigrationFacade(ResourceManager resourceManager, String xtendResourceName, boolean injectUnusedImports) {
		this(resourceManager, xtendResourceName);
		this.injectUnusedImports = injectUnusedImports;
	}

	public XtendMigrationFacade(ResourceManager resourceManager, String xtendResourceName, MigrationExecutionContext executionContext) {
		this(resourceManager, xtendResourceName);
		rootExecutionContext = executionContext;
	}

	public XtendMigrationFacade(ResourceManager resourceManager, String xtendResourceName) {
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
		if (MigrationException.hasErrors(issues)) {
			throw new MigrationException(issues);
		}

		String shortResourceName = getLastSegment(resourceName, SyntaxConstants.NS_DELIM);
		if (shortResourceName.length() == 0) {
			throw new MigrationException(Type.INCORRECT_RESOURCE_NAME, resourceName);
		}

		stdLibImportsManager = new StandardLibraryImports(output);
		modelManager = new ModelManager(stdLibImportsManager, false);
		addLibraryImports(xtendResource, false);
		if (xtendResource.getImportedExtensions().length > 0) {
			writeln("");
		}

		
		modeltypeImportsManger = new ModeltypeImports(output, injectUnusedImports);
		for (String namespace : xtendResource.getImportedNamespaces()) {
			modeltypeImportsManger.registerModeltype(namespace);
		}
		typeManager = new TypeManager(modeltypeImportsManger);

		writeln("library " + shortResourceName + ";");
		writeln("");

		for (Iterator<Extension> it = xtendResource.getExtensions().iterator(); it.hasNext();) {
			Extension extension = it.next();
			migrateExtension(extension, ctx);
			if (it.hasNext()) {
				writeln("");
			}
		}
		injectModeltypeImports();
		injectStdlibImports();
		return output;
	}

	private void injectStdlibImports() {
		StringBuilder sb = new StringBuilder();
		for (String libraryName : stdLibImportsManager.getLibraries()) {
			sb.append("import library ");
			sb.append(libraryName);
			sb.append(";");
			sb.append(ExpressionMigrationFacade.LF);
		}
		if (sb.length() > 0) {
			sb.append(ExpressionMigrationFacade.LF);
			write(sb, stdLibImportsManager.getPlaceholderIndex());
		}
	}

	private void injectModeltypeImports() {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, String> entry : modeltypeImportsManger.getModelTypes().entrySet()) {
			sb.append("modeltype ");
			sb.append(entry.getValue());
			sb.append(" uses \"");
			sb.append(entry.getKey());
			sb.append("\";");
			sb.append(ExpressionMigrationFacade.LF);
		}
		if (sb.length() > 0) {
			sb.append(ExpressionMigrationFacade.LF);
			write(sb, modeltypeImportsManger.getPlaceholderIndex());
		}
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

		// assert extension.getParameterTypes().size() > 0;
		assert extension.getParameterNames().size() == extension.getParameterTypes().size();
		Iterator<String> parameterNames = extension.getParameterNames().iterator();
		Iterator<EClassifier> parameterTypes = extension.getParameterTypes().iterator();
		while (parameterNames.hasNext()) {
			write(parameterNames.next());
			write(" : ");
			write(typeManager.getQvtFQName(parameterTypes.next()));
			if (parameterNames.hasNext()) {
				write(", ");
			}
		}
		write(") : ");
		write(typeManager.getQvtFQName(getReturnType(extension, ctx)));
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

	private void migrateExpressionExtension(ExpressionExtensionStatement extension, MigrationExecutionContext ctx) throws MigrationException {
		write("\t");
		ExpressionAnalyzeTrace expressionAnalyzeTrace = ctx.getTraces().get(extension);
		// TODO: resolve return type of ExpressionExtensionStatement using
		// corresponding identifier here in this context and use it as a desired
		// return type parameter
		ExpressionMigrationFacade expressionMigrationFacade = new ExpressionMigrationFacade(extension.getExpression(), expressionAnalyzeTrace.getResultType(), typeManager,
				modelManager, new VariableNameDispatcher(extension), ctx);
		StringBuilder expressionContent = expressionMigrationFacade.migrate();
		writeln(expressionContent.insert(expressionMigrationFacade.getReturnPosition(), "return "));
	}

	// TODO: java should be migrated separately from library - java class should
	// be created with the additional declaration in plugin.xml
	private void migrateJavaExtension(JavaExtensionStatement extension) throws MigrationException {
//		throw new MigrationException(Type.UNSUPPORTED_EXTENSION, extension.getClass().getName());
	}

	private void migrateCreateExtension(CreateExtensionStatement extension) throws MigrationException {
		throw new MigrationException(Type.UNSUPPORTED_EXTENSION, extension.getClass().getName());
	}

	private void migrateWorkflowSlotExtension(WorkflowSlotExtensionStatement extension) throws MigrationException {
		throw new MigrationException(Type.UNSUPPORTED_EXTENSION, extension.getClass().getName());
	}

	private void write(CharSequence cs, int index) {
		output.insert(index, cs);
	}
	
	private void write(CharSequence cs) {
		output.append(cs);
	}

	private void writeln(CharSequence line) {
		output.append(line);
		output.append(ExpressionMigrationFacade.LF);
	}

}