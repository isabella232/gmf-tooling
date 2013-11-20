package org.eclipse.gmf.codegen.util;

import org.osgi.framework.BundleContext;

public class CodegenXtendPlugin extends DefaultActivator {

	private static CodegenXtendPlugin myInstance;

	public static CodegenXtendPlugin getInstance() {
		return myInstance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		myInstance = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		myInstance = null;
		super.stop(context);
	}
}
