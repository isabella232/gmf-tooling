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

	private static DomainModelSetup myDomainModel;
	private static DiaGenSource myGenModel;
	private static GenProjectSetup myProject;
	private static RuntimeWorkspaceSetup myRuntimeWorkspaceSetup;

	public static DomainModelSetup getDomainModel() {
		if (myDomainModel == null) {
			myDomainModel = new DomainModelSetup().init();
		}
		return myDomainModel;
	}

	public static DiaGenSource getGenModel() {
		if (myGenModel == null) {
			myGenModel = new DiaGenSetup().init(getDomainModel());
		}
		return myGenModel;
	}

	public static GenProjectSetup getGenProject() throws Exception {
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

	public static void cleanup() throws Exception {
		if (myProject != null) {
			myProject.uninstall();
		}
	}	
}
