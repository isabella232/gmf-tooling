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

import org.eclipse.gmf.tests.TestConfiguration;
import org.osgi.framework.BundleException;

/**
 * @author artem
 */
public class SessionSetup implements TestConfiguration {

	private DomainModelSource myDomainModel;
	private DiaGenSource myGenModel;
	private GenProjectSetup myProject;
	private int myUses;
	private static RuntimeWorkspaceSetup myRuntimeWorkspaceSetup;
	protected static boolean factoryClosed = false;

	/**
	 * Use factory method {@link #newInstance()} instead
	 */
	protected SessionSetup() {
	}

	/**
	 * When running as an all-tests suite, we won't li
	 */
	public static void disallowSingleTestCaseUse() {
		factoryClosed = true;
	}

	/**
	 * @return <code>null</code> if {@link #disallowSingleTestCaseUse()} was called
	 */
	public static SessionSetup newInstance() {
		if (factoryClosed) {
			return null;
		}
		return new SessionSetup();
	}

	public DomainModelSource getDomainModel() {
		if (myDomainModel == null) {
			myDomainModel = createDomainModel();
		}
		return myDomainModel;
	}

	protected DomainModelSource createDomainModel() {
		return new DomainModelSetup().init();
	}

	public DiaGenSource getGenModel() {
		if (myGenModel == null) {
			myGenModel = createGenModel();
		}
		return myGenModel;
	}

	protected DiaGenSource createGenModel() {
		return new DiaGenSetup().init(getDomainModel());
	}

	public GenProjectSetup getGenProject() throws Exception {
		if (myProject == null) {
			myProject = createGenProject();
		}
		return myProject;
	}

	protected GenProjectSetup createGenProject() throws BundleException, Exception {
		return new GenProjectSetup().init(getRuntimeWorkspaceSetup(), getGenModel());
	}

	public static RuntimeWorkspaceSetup getRuntimeWorkspaceSetup() throws Exception {
		if (myRuntimeWorkspaceSetup == null) {
			myRuntimeWorkspaceSetup = new RuntimeWorkspaceSetup();
			myRuntimeWorkspaceSetup.init();
		}
		return myRuntimeWorkspaceSetup;
	}

	public void cleanup() throws Exception {
		System.err.println("SessionSetup:uses:" + myUses);
		if (myProject != null) {
			myProject.uninstall();
		}
	}

	// FUTURE: automatically unload/cleanup when myUses goes to zero.
	public void oneUp() {
		myUses++;
	}

	public void oneDown() {
		myUses--;
	}	
}
