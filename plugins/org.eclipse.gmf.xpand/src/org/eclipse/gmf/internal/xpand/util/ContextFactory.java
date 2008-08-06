/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.gmf.internal.xpand.util;

import java.util.Collection;

import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.model.Output;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.model.Scope;
import org.eclipse.gmf.internal.xpand.model.Variable;

/**
 * TODO remove?
 * @author artem
 */
public class ContextFactory {

	public static ExecutionContext createXpandContext(ResourceManager resourceManager) {
		return createXpandContext(resourceManager, null, null, (ClassLoadContext) null);
	}

	public static ExecutionContext createXpandContext(ResourceManager resourceManager, Output output, Collection<Variable> globalVars) {
		return createXpandContext(resourceManager, output, globalVars, (ClassLoadContext) null);
	}

	public static ExecutionContext createXpandContext(ResourceManager resourceManager, Output output, Collection<Variable> globalVars, ClassLoader context) {
		return createXpandContext(resourceManager, output, globalVars, context == null ? (ClassLoadContext) null : new ClassLoadContext.Naive(context));
	}

	public static ExecutionContext createXpandContext(ResourceManager resourceManager, Output output, Collection<Variable> globalVars, ClassLoadContext context) {
		Scope scope = new Scope(resourceManager, globalVars, output);
		scope.setContextClassLoader(context);
		return new ExecutionContextImpl(scope);
	}
}
