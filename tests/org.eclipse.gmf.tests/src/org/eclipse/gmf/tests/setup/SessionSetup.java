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

/**
 * @author artem
 */
public class SessionSetup {

	private DomainModelSetup myDomainModel;
	private DiaGenSource myGenModel;
	private GenProjectSetup myProject;
	private int myUses;
	private static RuntimeWorkspaceSetup myRuntimeWorkspaceSetup;
	private static boolean factoryClosed = false;

	/**
	 * Use factory method {@link #newInstance()} instead
	 */
	private SessionSetup() {
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

	public DomainModelSetup getDomainModel() {
		if (myDomainModel == null) {
			myDomainModel = new DomainModelSetup().init();
		}
		return myDomainModel;
	}

	public DiaGenSource getGenModel() {
		if (myGenModel == null) {
			myGenModel = new DiaGenSetup().init(getDomainModel());
		}
		return myGenModel;
	}

	public GenProjectSetup getGenProject() throws Exception {
		if (myProject == null) {
			myProject = new GenProjectSetup();
			myProject.init(getRuntimeWorkspaceSetup(), getGenModel());
		}
		return myProject;
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
