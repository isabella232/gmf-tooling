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
package org.eclipse.gmf.dev.insider.internal;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class InsiderPlugin extends AbstractUIPlugin {

	public InsiderPlugin() {
		ourInstance = this;
		try {
			myResourceBundle = ResourceBundle.getBundle("org.eclipse.gmf.dev.insider.internal.resources");
		} catch (MissingResourceException x) {
			myResourceBundle = null;
		}
	}

	public static InsiderPlugin getInstance() {
		return ourInstance;
	}

	public static String getResourceString(String key) {
		ResourceBundle bundle = InsiderPlugin.getInstance().getResourceBundle();
		try {
			return bundle != null ? bundle.getString(key) : '!' + key + '!';
		} catch (MissingResourceException e) {
			return key;
		}
	}

	public ResourceBundle getResourceBundle() {
		return myResourceBundle;
	}

	public static void logError(String msg, Throwable exception) {
		if (exception == null) {
			exception = new Exception();
		}
		if (msg == null) {
			msg = exception.toString();
		}
		String id = getInstance().getBundle().getSymbolicName();
		IStatus status = new Status(IStatus.ERROR, id, 0, msg, exception);
		getInstance().getLog().log(status);
	}

	private static InsiderPlugin ourInstance;
	private ResourceBundle myResourceBundle;
}
