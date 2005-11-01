/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import java.net.MalformedURLException;

import junit.framework.Assert;

import org.eclipse.core.resources.IProject;
import org.eclipse.gmf.tests.Plugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * Installs generated GMF plugins to allow invocation of generated code
 * @author artem
 */
public class GenProjectSetup extends GenProjectBaseSetup {

	private Bundle myBundle;

	public GenProjectSetup() {
	}

	/**
	 * Assertion fails on compilation errors.
	 * @return <code>this</code> for convenience
	 * @throws BundleException only when shouldInstallInRuntime is true and bundle install fails
	 */
	public GenProjectSetup init(RuntimeWorkspaceSetup rtWorkspace, DiaGenSource diaGenSource) throws BundleException {
		try {
			myBundle = null;
			super.generateAndCompile(rtWorkspace, diaGenSource);
			myBundle.start();
		} catch (BundleException ex) {
			throw ex;
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}
		return this;
	}


	protected void hookProjectBuild(IProject p) throws Exception {
		super.hookProjectBuild(p);
		try {
			String url = p.getLocation().toFile().toURL().toExternalForm();
			myBundle = Plugin.getBundleContext().installBundle(url);
		} catch (MalformedURLException ex) {
			Assert.fail(ex.getMessage());
		}
	}

	public final Bundle getBundle() {
		assert myBundle != null : "GenProjectSetup was not initialized";
		return myBundle;
	}

	public void uninstall() throws Exception {
		myBundle.uninstall();
	}
}
