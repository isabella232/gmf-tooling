package org.eclipse.gmf.tests;

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

	public static Plugin getInstance() {
		return ourInstance;
	}

	public static BundleContext getBundleContext() {
		return ourInstance.myContext;
	}
}
