package org.eclipse.gmf.codegen.util;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class DefaultActivator extends Plugin {

	private BundleContext myContext = null;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		myContext = context;
	}

	public void stop(BundleContext context) throws Exception {
		myContext = null;
		super.stop(context);
	}

	public BundleContext getContext() {
		return myContext;
	}
}
