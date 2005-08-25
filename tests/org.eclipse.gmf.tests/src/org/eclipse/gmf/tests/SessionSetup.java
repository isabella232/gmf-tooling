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
package org.eclipse.gmf.tests;

import org.eclipse.gmf.tests.setup.DiaGenSetup;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.DomainModelSetup;
import org.eclipse.gmf.tests.setup.DomainModelSource;
import org.eclipse.gmf.tests.setup.GenProjectSetup;

/**
 * @author artem
 *
 */
public class SessionSetup {
	private static DomainModelSource myDomainModel;
	private static DiaGenSource myGenModel;
	private static GenProjectSetup myProject;

	public static DomainModelSource getDomainModel() {
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
			myProject.init(getGenModel());
		}
		return myProject;
	}
}
