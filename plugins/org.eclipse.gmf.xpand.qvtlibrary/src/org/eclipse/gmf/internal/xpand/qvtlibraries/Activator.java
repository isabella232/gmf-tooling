package org.eclipse.gmf.internal.xpand.qvtlibraries;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.gmf.xpand.qvtlibrary"; //$NON-NLS-1$

	// TODO: substitute this constant with not-internal reference?
	public static final String OCL_LIBRARY_PACKAGE = OCLStandardLibraryImpl.stdlibPackage.getName();

	public static final String OCL_PATH_SEPARATOR = "::"; //$NON-NLS-1$

	// The shared instance
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

}
