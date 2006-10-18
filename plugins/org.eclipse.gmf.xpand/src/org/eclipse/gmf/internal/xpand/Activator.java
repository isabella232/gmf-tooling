/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.internal.xpand;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.util.ResourceManagerImpl;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {
	private static Activator anInstance;

	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		anInstance = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		anInstance = null;
		super.stop(context);
	}

	public static String getId() {
		return anInstance.getBundle().getSymbolicName();
	}
	public static void logWarn(String message) {
		log(new Status(IStatus.WARNING, getId(), 0, message, null));
	}
	public static void logError(Exception e) {
		if (e instanceof CoreException) {
			log(((CoreException) e).getStatus());
		} else {
			log(new Status(IStatus.ERROR, getId(), 0, e.getMessage(), e));
		}
	}
	public static void log(IStatus status) {
		anInstance.getLog().log(status);
	}

	public static String getQualifiedName(final IFile file) {
		IPath p = file.getProjectRelativePath().removeFileExtension().makeRelative();
		final String fqn = p.toString().replace("/", SyntaxConstants.NS_DELIM);
		return fqn;
	}

	private final Map<IProject, ResourceManager> resourceManagers = new HashMap<IProject, ResourceManager>();

	public static ResourceManager getResourceManager(IProject context) {
		if (anInstance.resourceManagers.containsKey(context)) {
			return anInstance.resourceManagers.get(context);
		}
		ResourceManagerImpl resourceManager = new ResourceManagerImpl(context);
		anInstance.resourceManagers.put(context, resourceManager);
		try {
			context.setSessionProperty(new QualifiedName("xpand","resourceManager"), resourceManager);
		} catch (CoreException ex) {
			log(ex.getStatus());
		}
		return resourceManager;
	}
}
