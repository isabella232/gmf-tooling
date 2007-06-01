/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.sketch.transformer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * @author dstadnik
 */
public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.gmf.sketch.transformer"; //$NON-NLS-1$

	private static Activator plugin;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static Activator getDefault() {
		return plugin;
	}

	public static void logError(String message, Throwable cause) {
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID, message, cause);
		getDefault().getLog().log(status);
	}

	public static void logWarning(String message) {
		IStatus status = new Status(IStatus.WARNING, PLUGIN_ID, message);
		getDefault().getLog().log(status);
	}
}
