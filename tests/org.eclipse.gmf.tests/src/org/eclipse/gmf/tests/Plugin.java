/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.BundleContext;

public class Plugin extends org.eclipse.core.runtime.Plugin {

	private static Plugin ourInstance;
	private BundleContext myContext;

	public Plugin() {
		super();
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		ourInstance = this;
		myContext = context;
	}

	public void stop(BundleContext context) throws Exception {
		ourInstance = null;
		myContext = null;
		super.stop(context);
	}

	public static URI createURI(String bundledFileName) throws IOException {
		URL url = getInstance().getBundle().getEntry(bundledFileName);
		String filePath = Platform.asLocalURL(url).toExternalForm();
		return URI.createURI(filePath);
	}

	public static Plugin getInstance() {
		return ourInstance;
	}

	public static BundleContext getBundleContext() {
		return ourInstance.myContext;
	}

	/**
	 * @param errorsMsg
	 */
	public static void logError(String errorsMsg) {
		logError(errorsMsg, null);
	}

	public static void logError(String errorsMsg, Exception ex) {
		getInstance().getLog().log(new Status(Status.ERROR, getPluginID(), 0, errorsMsg, ex));
	}

	/**
	 * @return
	 */
	public static String getPluginID() {
		return getInstance().getBundle().getSymbolicName();
	}
}
