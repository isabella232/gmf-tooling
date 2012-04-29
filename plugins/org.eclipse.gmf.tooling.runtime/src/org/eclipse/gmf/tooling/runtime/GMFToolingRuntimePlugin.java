package org.eclipse.gmf.tooling.runtime;

import org.eclipse.gmf.tooling.runtime.impl.ocl.tracker.activeocl.ActiveOclTrackerFactory;
import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTrackerFactory;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class GMFToolingRuntimePlugin extends AbstractUIPlugin {

	public static final String ID = "org.eclipse.gmf.tooling.runtime"; //$NON-NLS-1$

	private static GMFToolingRuntimePlugin ourInstance;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		ourInstance = this;
	}

	public void stop(BundleContext context) throws Exception {
		ourInstance = null;
		super.stop(context);
	}

	public static GMFToolingRuntimePlugin getInstance() {
		return ourInstance;
	}

	/**
	 * This is the main intended way to access the {@link OclTrackerFactory}. 
	 * This method will return the suited implementation based on the available plugins.
	 * Caller should not make any assumptions against the return implementation type.   
	 */
	public OclTrackerFactory getOclTrackerFactory() {
		return new ActiveOclTrackerFactory();
	}

	/**
	 * This is the helper method allowing caller to access the specific {@link OclTrackerFactory} 
	 * implementation without adding an explicit dependency to the containing plugin. 
	 * <p> 
	 * This method will try to return the preferred implementation based on the available plugins, 
	 * but will roll back to default implementation if preferred one is not available.  
	 * Caller still is not recommended to make any assumptions about the returned implementation type.   
	 */
	public OclTrackerFactory getOclTrackerFactory(OclTrackerFactory.Type type) {
		//XXX: without IA included to Eclipse distribution, this method always return the default GMFT implementation.
		return getOclTrackerFactory();
	}

}
