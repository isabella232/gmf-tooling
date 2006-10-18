/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.internal.xpand.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.xpand.editor";

	// The shared instance
	private static Activator plugin;

	private ColorProvider colorProvider;
	
	/**
	 * The constructor
	 */
	public Activator() {
		plugin = this;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		PreferencesConstants.initializeDefaultValues(getPreferenceStore());
		colorProvider = new ColorProvider();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		colorProvider.dispose();
		colorProvider = null;
		plugin = null;
		super.stop(context);
	}

	public static ColorProvider getColorProvider() {
        return getDefault().colorProvider;
    }

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public static void logError(Exception e) {
		if (e instanceof CoreException) {
			log(((CoreException) e).getStatus());
		} else {
			log(new Status(IStatus.ERROR, PLUGIN_ID, 0, e.getClass().getName(), e));
		}
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}
}
