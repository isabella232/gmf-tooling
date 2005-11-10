/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * @author dstadnik
 */
public class DevPlugin extends AbstractUIPlugin {

	public static final String TRACE_OPTION = "/debug/trace";
	public static final String IGNORED_REQUESTS_OPTION = "/debug/requests/ignored";

	public static final String COMMAND_IMAGE = "/icons/command.gif";
	public static final String COMMANDX_IMAGE = "/icons/commandx.gif";
	public static final String EDITPART_IMAGE = "/icons/editpart.gif";
	public static final String EVENT_IMAGE = "/icons/event.gif";
	public static final String INFO_IMAGE = "/icons/info.gif";
	public static final String MODEL_IMAGE = "/icons/model.gif";
	public static final String PARAMETER_IMAGE = "/icons/parameter.gif";
	public static final String REQUEST_IMAGE = "/icons/request.gif";

	private static DevPlugin instance;

	public DevPlugin() {
		instance = this;
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		getImageRegistry().put(COMMAND_IMAGE, getImageDescriptor(COMMAND_IMAGE));
		getImageRegistry().put(COMMANDX_IMAGE, getImageDescriptor(COMMANDX_IMAGE));
		getImageRegistry().put(EDITPART_IMAGE, getImageDescriptor(EDITPART_IMAGE));
		getImageRegistry().put(EVENT_IMAGE, getImageDescriptor(EVENT_IMAGE));
		getImageRegistry().put(INFO_IMAGE, getImageDescriptor(INFO_IMAGE));
		getImageRegistry().put(MODEL_IMAGE, getImageDescriptor(MODEL_IMAGE));
		getImageRegistry().put(PARAMETER_IMAGE, getImageDescriptor(PARAMETER_IMAGE));
		getImageRegistry().put(REQUEST_IMAGE, getImageDescriptor(REQUEST_IMAGE));
	}

	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		instance = null;
	}

	public static DevPlugin getInstance() {
		return instance;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.gmf.dev", path);
	}

	public static Image getImage(String name) {
		return instance.getImageRegistry().get(name);
	}

	public static String getOption(String name) {
		if (instance == null) {
			return null;
		}
		String key = instance.getBundle().getSymbolicName() + name;
		return Platform.getDebugOption(key);
	}

	public static boolean isOptionEnabled(String name) {
		return Boolean.valueOf(getOption(name)).booleanValue();
	}

	public boolean isTracing() {
		return isOptionEnabled(TRACE_OPTION);
	}

	public static void logInfo(String text) {
		DevPlugin instance = getInstance();
		if (instance == null) {
			return;
		}
		if (!instance.isDebugging()) {
			return;
		}
		log(IStatus.INFO, text);
	}

	public static void logError(String text) {
		log(IStatus.ERROR, text);
	}

	public static void logError(String text, Throwable cause) {
		log(IStatus.ERROR, text, cause);
	}

	public static void logWarning(String text) {
		log(IStatus.WARNING, text);
	}

	public static void logWarning(String text, Throwable cause) {
		log(IStatus.WARNING, text, cause);
	}

	protected static void log(int type, String text) {
		if (instance != null && instance.isTracing()) {
			log(type, text, new Throwable());
		} else {
			log(type, text, null);
		}
	}

	protected static void log(int type, String text, Throwable cause) {
		if (instance == null) {
			System.err.println(text);
			if (cause != null) {
				cause.printStackTrace(System.err);
			}
		} else {
			String id = instance.getBundle().getSymbolicName();
			IStatus status = new Status(type, id, 0, text, cause);
			instance.getLog().log(status);
		}
	}
}
