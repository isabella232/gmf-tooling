/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.gmf.internal.xpand.editor;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		while (myRefQueue.poll() != null) ;
		myState.clear();
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public static String getPluginID() {
		return getDefault().getBundle().getSymbolicName();
	}

	public static void logError(Exception e) {
		if (e instanceof CoreException) {
			log(((CoreException) e).getStatus());
		} else {
			log(new Status(IStatus.ERROR, getPluginID(), 0, e.getClass().getName(), e));
		}
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	private final HashMap<Class<?>, SoftReference<?>> myState = new HashMap<Class<?>, SoftReference<?>>();
	private final ReferenceQueue<Object> myRefQueue = new ReferenceQueue<Object>();

	// State management
	public static <T> T findState(Class<T> kind) {
		@SuppressWarnings("unchecked")
		SoftReference<T> ref = (SoftReference<T>) getDefault().myState.get(kind);
		if (ref == null) {
			return null;
		}
		T rv = ref.get();
		if (rv == null) {
			getDefault().myState.remove(kind);
			return null;
		}
		return rv;
	}

	// for now, decided to allow replace old value (reason: why not)?
	public static <T> void putState(Class<T> kind, T instance) {
		assert instance != null; // XXX or allow any value?
		getDefault().myState.put(kind, new SoftReference<Object>(instance, getDefault().myRefQueue));
	}

	/**
	 * Looks for localized value in standard bundle localization (usually, plugin.properties) file
	 */
	public static String getResourceString(String key) {
		try {
			ResourceBundle rb = Platform.getResourceBundle(getDefault().getBundle());
			if (rb != null) {
				return rb.getString(key);
			}
		} catch (MissingResourceException ex) {
			// FALL-THROUGH, just return key
		}
		return key;
	}
}
