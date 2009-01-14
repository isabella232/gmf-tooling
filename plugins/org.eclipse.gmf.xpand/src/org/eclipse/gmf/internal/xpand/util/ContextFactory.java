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
		return createXpandContext(resourceManager, null, null);
	}

	public static ExecutionContext createXpandContext(ResourceManager resourceManager, Output output, Collection<Variable> globalVars) {
		Scope scope = new Scope(resourceManager, globalVars, output);
		return new ExecutionContextImpl(scope);
	}

	/**
	 * @deprecated use {@link #createXpandContext(ResourceManager, Output, Collection)} instead. The class loaders are no longer used in QVT-based Xpand implementation.
	 */
	@Deprecated
	public static ExecutionContext createXpandContext(ResourceManager resourceManager, Output output, Collection<Variable> globalVars, ClassLoader context) {
		return createXpandContext(resourceManager, output, globalVars);
	}

	/**
	 * @deprecated use {@link #createXpandContext(ResourceManager, Output, Collection)} instead. The class loaders are no longer used in QVT-based Xpand implementation.
	 */
	@Deprecated
	public static ExecutionContext createXpandContext(ResourceManager resourceManager, Output output, Collection<Variable> globalVars, ClassLoadContext context) {
		return createXpandContext(resourceManager, output, globalVars);
	}
}
