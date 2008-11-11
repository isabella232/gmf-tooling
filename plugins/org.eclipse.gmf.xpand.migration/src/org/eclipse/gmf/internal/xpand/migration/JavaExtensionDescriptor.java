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
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.expression.ast.DeclaredParameter;
import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.xtend.ast.JavaExtensionStatement;

public class JavaExtensionDescriptor {

	public static final String NATIVE_LIBRARY_CLASS_PREFIX = "Native";

	private String extensionName;

	private String className;

	private String methodName;

	private EClassifier returnType;

	private List<EClassifier> parameterTypes = new ArrayList<EClassifier>();

	private List<String> parameterNames = new ArrayList<String>();

	private List<String> javaParameterTypes = new ArrayList<String>();

	private boolean staticQvtoCall;

	public static String getNativeLibraryName(JavaExtensionStatement extension) {
		String name = extension.getExtensionFile().getFullyQualifiedName();
		int delimiterIndex = name.lastIndexOf(SyntaxConstants.NS_DELIM);
		if (delimiterIndex < 0) {
			return NATIVE_LIBRARY_CLASS_PREFIX + name;
		}
		String packageName = name.substring(0, delimiterIndex);
		name = name.substring(delimiterIndex + SyntaxConstants.NS_DELIM.length());
		return packageName + SyntaxConstants.NS_DELIM + NATIVE_LIBRARY_CLASS_PREFIX + name;
	}

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
