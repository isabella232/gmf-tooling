package org.eclipse.gmf.tests;

import org.eclipse.core.runtime.Status;
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
