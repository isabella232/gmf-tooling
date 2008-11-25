package org.eclipse.gmf.internal.xpand.qvtlibraries;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.gmf.xpand.qvtlibrary"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	private Map<String, Variable> globalVars = new HashMap<String, Variable>();

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
	
	public void clearGlobalVars() {
		globalVars.clear();
	}
	
	public void addGlobalVar(String name, Variable value) {
		globalVars.put(name, value);
	}
	
	Map<String, Variable> getGlobalVars() {
		return globalVars;
	}

}
