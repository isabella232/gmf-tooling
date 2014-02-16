/*
* Copyright (c) 2005, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tooling.tests.xtend;

import java.io.IOException;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.emf.type.core.internal.EMFTypePlugin;
import org.eclipse.gmf.tests.Configurator;
import org.osgi.framework.BundleContext;

public class XtendsTestPluginActivator extends org.eclipse.core.runtime.Plugin {

	private static XtendsTestPluginActivator ourInstance;
	private BundleContext myContext;
	private Configurator myConfiguration;

	public XtendsTestPluginActivator() {
		super();
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		ourInstance = this;
		myContext = context;
		EMFTypePlugin.startDynamicAwareMode();
	}

	public void stop(BundleContext context) throws Exception {
		ourInstance = null;
		myContext = null;
		if (myConfiguration != null) {
			myConfiguration.dispose();
			myConfiguration = null;
		}
		super.stop(context);
	}

	public static URI createURI(String bundledFileName) throws IOException {
		assert bundledFileName.charAt(0) == '/';
		return URI.createURI("platform:/plugin/" + getPluginID() + bundledFileName);
	}

	public static XtendsTestPluginActivator getInstance() {
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
	 * Revisit uses of this method - some tests use it as a mere string
	 * @return
	 */
	public static String getPluginID() {
		return getInstance().getBundle().getSymbolicName();
	}

}
