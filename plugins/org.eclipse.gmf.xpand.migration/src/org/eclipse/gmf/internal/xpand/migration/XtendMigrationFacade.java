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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModelExt;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.expression.ast.DeclaredParameter;
import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.migration.MigrationException.Type;
import org.eclipse.gmf.internal.xpand.xtend.ast.CreateExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExpressionExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.Extension;
import org.eclipse.gmf.internal.xpand.xtend.ast.JavaExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.WorkflowSlotExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.XtendResource;
import org.eclipse.ocl.ecore.VoidType;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;

public class XtendMigrationFacade {

	private static final String JAVA_ARRAY_TYPE_SUFFIX = ".List";

	private static final String JAVA_LANG_PACKAGE_PREFIX = "java.lang.";

	private ResourceManager resourceManager;

	private StringBuilder output = new StringBuilder();
	
	private String resourceName;

	private StandardLibraryImports stdLibImportsManager;

	private boolean injectUnusedImports;

	private MigrationExecutionContext rootExecutionContext;

	private TypeManager typeManager;

	private ModeltypeImports modeltypeImportsManger;

	private ModelManager modelManager;

	private List<JavaExtensionDescriptor> javaExtensionDescriptors = new ArrayList<JavaExtensionDescriptor>();
	
	private List<String> importedMetamodels = new ArrayList<String>();

	private String nativeLibraryClassName;

	private String nativeLibraryPackageName = "";

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
		modelManager = new ModelManager(stdLibImportsManager);
		addLibraryImports(xtendResource, false);
		if (xtendResource.getImportedExtensions().length > 0) {
			writeln("");
		}

		modeltypeImportsManger = new ModeltypeImports(output, injectUnusedImports);
		for (String namespace : xtendResource.getImportedNamespaces()) {
			modeltypeImportsManger.registerModeltype(namespace);
			importedMetamodels.add(namespace);
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
		
		nativeLibraryClassName = resourceName.replaceAll(SyntaxConstants.NS_DELIM, JavaCs.DOT);
		if (nativeLibraryClassName.lastIndexOf(JavaCs.DOT) > 0) {
			nativeLibraryPackageName = nativeLibraryClassName.substring(0, nativeLibraryClassName.lastIndexOf(JavaCs.DOT));
			nativeLibraryClassName = nativeLibraryClassName.substring(nativeLibraryClassName.lastIndexOf(JavaCs.DOT) + 1);
		}
		if (nativeLibraryClassName.length() == 0) {
			throw new MigrationException(Type.UNABLE_TO_DETECT_NATIVE_LIBRARY_CLASS_NAME, "Resource name: \"" + resourceName + "\"");
		}
		return output;
	}
	
	/**
	 * This method should be executed only after migrateXtendResource() one
	 */
	public StringBuilder getNativeLibraryXmlDeclaration() {
		if (javaExtensionDescriptors.size() == 0) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		result.append("<library class=\"");
		String nativeLibraryFullClassName = getNativeLibraryFullClassName();
		result.append(nativeLibraryFullClassName);
		result.append("\" id=\"");
		result.append(getNativeLibraryID(nativeLibraryFullClassName));
		result.append("\">");
		for (String	metamodel : importedMetamodels) {
			result.append("<inMetamodel uri=\"");
			result.append(metamodel);
			result.append("\"/>");
		}
		result.append("</library>");
		result.append(ExpressionMigrationFacade.LF);
		return result;
	}
	
	private String getNativeLibraryID(String nativeLibraryFullClassName) {
		if (nativeLibraryFullClassName.indexOf(".") == -1) {
			return "_" + nativeLibraryClassName;
		}
		return nativeLibraryFullClassName.replaceAll("\\.", "_");
	}

	private String getNativeLibraryFullClassName() {
		return getNativeLibraryPackageName().length() == 0 ? getNativeLibraryClassName() : getNativeLibraryPackageName() + JavaCs.DOT + getNativeLibraryClassName();
	}

	/**
	 * This method should be executed only after migrateXtendResource() one
	 * @throws MigrationException 
	 */
	public StringBuilder getNativeLibraryClassBody() throws MigrationException {
		if (javaExtensionDescriptors.size() == 0) {
			return null;
		}
		String lf = ExpressionMigrationFacade.LF;
		StringBuilder result = new StringBuilder();
		if (getNativeLibraryPackageName().length() > 0) {
			result.append("package ");
			result.append(getNativeLibraryPackageName());
			result.append(";");
			result.append(lf);
		}
		result.append("public class ");
		result.append(getNativeLibraryClassName());
		result.append(" {");
		result.append(lf);
		
		result.append("public static class Metainfo {");
		result.append(lf);
		for (JavaExtensionDescriptor descriptor : javaExtensionDescriptors) {
			addMetainfoMethod(descriptor, result);
			result.append(lf);
		}
		result.append("}");
		result.append(lf);
		
		for (JavaExtensionDescriptor descriptor : javaExtensionDescriptors) {
			addNativeMethod(descriptor, result);
			result.append(lf);
		}
		
		result.append("}");
		return result;
	}
	
	private void addNativeMethod(JavaExtensionDescriptor descriptor, StringBuilder result) throws MigrationException {
		result.append("public ");
		result.append(getJavaType(descriptor.getReturnType()));
		result.append(" ");
		addNativeMethodSignature(descriptor, result);
		result.append(" { return ");
		result.append(descriptor.getClassName());
		result.append(JavaCs.DOT);
		result.append(descriptor.getMethodName());
		result.append("(");
		List<String> parameterNames = descriptor.getParameterNames();
		List<String> javaParameterTypes = descriptor.getJavaParameterTypes();
		for (int i = 0; i < parameterNames.size(); i++) {
			if (i > 0) {
				result.append(", ");
			}
			result.append(parameterNames.get(i));
			String javaParameterType = javaParameterTypes.get(i);
			if (javaParameterType.endsWith(JAVA_ARRAY_TYPE_SUFFIX)) {
				javaParameterType = javaParameterType.substring(0, javaParameterType.length() - JAVA_ARRAY_TYPE_SUFFIX.length());
				result.append(".toArray(new ");
				result.append(suppressJavaLang(javaParameterType));
				result.append("[");
				result.append(parameterNames.get(i));
				result.append(".size()]");
				result.append(")");
			}
		}
		result.append("); ");
		result.append("}");
	}

	private String getJavaType(EClassifier xpandType) throws MigrationException {
		if (xpandType == BuiltinMetaModel.VOID) {
			throw new MigrationException(Type.UNSUPPORTED_NATIVE_EXTENSION_TYPE, "Void type is not supported for native extensions");
		}
		if (xpandType == EcorePackage.eINSTANCE.getEBoolean()) {
			return "Boolean";
		}
		if (xpandType.getInstanceClassName() != null) {
			String instanceClassName = xpandType.getInstanceClassName();
			return suppressJavaLang(instanceClassName);
		}
		if (BuiltinMetaModelExt.isSetType(xpandType)) {
			return "java.util.Set";
		} else if (BuiltinMetaModelExt.isListType(xpandType)) {
			return "java.util.List";
		} else if (BuiltinMetaModelExt.isCollectionType(xpandType)) {
			return "java.util.Collection";
		}
		throw new MigrationException(Type.UNSUPPORTED_NATIVE_EXTENSION_TYPE, "Metamodel types without instanceClassName set are not supported for native extensions: " + xpandType.getName());
	}

	private String suppressJavaLang(String instanceClassName) {
		// Suppressing "java.lang" package.
		if (instanceClassName.startsWith(JAVA_LANG_PACKAGE_PREFIX)) {
			String simpleClassName = instanceClassName.substring(JAVA_LANG_PACKAGE_PREFIX.length());
			if (simpleClassName.indexOf(JavaCs.DOT) == -1) {
				return simpleClassName;
			}
		}
		return instanceClassName;
	}

	private void addMetainfoMethod(JavaExtensionDescriptor descriptor, StringBuilder result) throws MigrationException {
		result.append("public static String[] ");
		addNativeMethodSignature(descriptor, result);
		result.append(" { return new String[] {\"");
		if (descriptor.isStaticQvtoCall()) {
			result.append(OCLStandardLibraryImpl.stdlibPackage.getName());
			result.append(OclCs.PATH_SEPARATOR); 
			result.append(VoidType.SINGLETON_NAME);
			result.append("\", \"");
		}
		
		TypeManager nativeLibrariesTypeManager = new TypeManager();
		nativeLibrariesTypeManager.setUseFQNameForPrimitiveTypes(true);
		for (EClassifier parameterType : descriptor.getParameterTypes()) {
			result.append(nativeLibrariesTypeManager.getQvtFQName(parameterType));
			result.append("\", \"");
		}
		result.append(nativeLibrariesTypeManager.getQvtFQName(descriptor.getReturnType()));
		result.append("\"");
		result.append("}; }");
	}

	private void addNativeMethodSignature(JavaExtensionDescriptor descriptor, StringBuilder result) throws MigrationException {
		result.append(descriptor.getExtensionName());
		result.append("(");
		List<EClassifier> parameterTypes = descriptor.getParameterTypes();
		List<String> parameterNames = descriptor.getParameterNames();
		assert parameterTypes.size() == parameterNames.size();
		for (int i = 0; i < parameterTypes.size(); i++) {
			if (i > 0) {
				result.append(", ");
			}
			result.append(getJavaType(parameterTypes.get(i)));
			result.append(" ");
			result.append(parameterNames.get(i));
		}
		result.append(")");
	}

	public String getNativeLibraryClassName() {
		return nativeLibraryClassName;
	}
	
	public String getNativeLibraryPackageName() {
		return nativeLibraryPackageName;
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
				writeln("import " + extension.replaceAll(SyntaxConstants.NS_DELIM, OclCs.NAMESPACE_SEPARATOR) + ";");
				XtendResource referencedResource = resourceManager.loadXtendResource(extension);
				if (referencedResource == null) {
					throw new MigrationException(Type.RESOURCE_NOT_FOUND, "Unable to load extension file: " + extension);
				}
				addLibraryImports(referencedResource, true);
			}
		}
	}

	private void migrateExtension(Extension extension, MigrationExecutionContext ctx) throws MigrationException {
		if (extension instanceof JavaExtensionStatement) {
			migrateJavaExtension((JavaExtensionStatement) extension, ctx);
			return;
		}
		
		try {
			extension.init(ctx);
		} catch (EvaluationException e) {
			throw new MigrationException(Type.ANALYZATION_PROBLEMS, e);
		}
		
		write("helper ");
		// assert extension.getParameterTypes().size() > 0;
		assert extension.getParameterNames().size() == extension.getParameterTypes().size();
		Iterator<String> parameterNames = extension.getParameterNames().iterator();
		Iterator<EClassifier> parameterTypes = extension.getParameterTypes().iterator();

		String selfParameterName = null;
		if (!OperationCallTrace.isStaticQvtoCall(ctx, extension)) {
			assert parameterNames.hasNext();
			selfParameterName = parameterNames.next();
			EClassifier selfParameterType = parameterTypes.next();
			write(typeManager.getQvtFQName(selfParameterType));
			write(OclCs.PATH_SEPARATOR);
			modelManager.registerSelfAlias(selfParameterName);
		}
		write(extension.getName());
		write("(");
		
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
		} else if (extension instanceof CreateExtensionStatement) {
			migrateCreateExtension((CreateExtensionStatement) extension);
		} else if (extension instanceof WorkflowSlotExtensionStatement) {
			migrateWorkflowSlotExtension((WorkflowSlotExtensionStatement) extension);
		} else {
			throw new MigrationException(Type.UNSUPPORTED_EXTENSION, extension.getClass().getName());
		}
		if (selfParameterName != null) {
			modelManager.unregisterSelfAlias(selfParameterName);
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
	private void migrateJavaExtension(JavaExtensionStatement extension, MigrationExecutionContext ctx) throws MigrationException {
		javaExtensionDescriptors.add(new JavaExtensionDescriptor(extension, ctx));
	}

	private void migrateCreateExtension(CreateExtensionStatement extension) throws MigrationException {
		throw new MigrationException(Type.UNSUPPORTED_EXTENSION, extension.getClass().getName());
	}

	private void migrateWorkflowSlotExtension(WorkflowSlotExtensionStatement extension) throws MigrationException {
		write("return ");
		writeln(extension.getSlotName().getValue());
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
	
	class JavaExtensionDescriptor {

		private String extensionName;

		private String className;

		private String methodName;

		private EClassifier returnType;

		private List<EClassifier> parameterTypes = new ArrayList<EClassifier>();
		
		private List<String> parameterNames = new ArrayList<String>();
		
		private List<String> javaParameterTypes = new ArrayList<String>();

		private boolean staticQvtoCall;

		public JavaExtensionDescriptor(JavaExtensionStatement javaExtension, MigrationExecutionContext ctx) {
			extensionName = javaExtension.getName();
			className = javaExtension.getJavaType().getValue();
			methodName = javaExtension.getJavaMethod().getValue();

			assert javaExtension.getReturnTypeIdentifier() != null;
			returnType = ctx.getTypeForName(javaExtension.getReturnTypeIdentifier().getValue());
			for (DeclaredParameter parameter : javaExtension.getFormalParameters()) {
				parameterTypes.add(ctx.getTypeForName(parameter.getType().getValue()));
				parameterNames.add(parameter.getName().getValue());
			}
			assert javaExtension.getFormalParameters().size() == javaExtension.getJavaParameterTypes().size();
			for (Identifier paramType : javaExtension.getJavaParameterTypes()) {
				javaParameterTypes.add(paramType.getValue());
			}
			staticQvtoCall = OperationCallTrace.isStaticQvtoCall(ctx, javaExtension);
		}

		public String getExtensionName() {
			return extensionName;
		}

		public String getClassName() {
			return className;
		}

		public String getMethodName() {
			return methodName;
		}

		public EClassifier getReturnType() {
			return returnType;
		}

		public List<EClassifier> getParameterTypes() {
			return parameterTypes;
		}
		
		public List<String> getParameterNames() {
			return parameterNames;
		}
		
		public List<String> getJavaParameterTypes() {
			return javaParameterTypes;
		}
		
		public boolean isStaticQvtoCall() {
			return staticQvtoCall;
		}

	}

}