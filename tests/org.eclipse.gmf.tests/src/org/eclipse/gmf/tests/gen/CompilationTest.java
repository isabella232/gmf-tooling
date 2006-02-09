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
package org.eclipse.gmf.tests.gen;

import java.io.IOException;
import java.util.HashSet;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.setup.DiaDefSetup;
import org.eclipse.gmf.tests.setup.DiaGenFileSetup;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.DomainModelSource;
import org.eclipse.gmf.tests.setup.GenProjectBaseSetup;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.MapSetup;
import org.eclipse.gmf.tests.setup.MultiPackageGenSetup;
import org.eclipse.gmf.tests.setup.MultiplePackagesDomainModelSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.gmf.tests.setup.ToolDefSetup;

public class CompilationTest extends TestCase {

	public CompilationTest(String name) {
		super(name);
	}

	// TODO EditPartViewer[Source|Setup]

	protected void setUp() throws Exception {
		super.setUp();
		SessionSetup.getRuntimeWorkspaceSetup();
	}

	public void testCodeCompilation() {
		try {
			URI selected = Plugin.createURI("/models/library/library.gmfgen");
			DiaGenSource gmfGenSource =  new DiaGenFileSetup().init(selected);
			new GenProjectBaseSetup().generateAndCompile(SessionSetup.getRuntimeWorkspaceSetup(), gmfGenSource);
		} catch (IOException ex) {
			fail(ex.getMessage());
		} catch (RuntimeException ex) {
			throw ex;
		} catch (Exception ex) {
			Plugin.logError("Unexpected exception:", ex);
			fail("Hm, looks like unexpected..." + ex.getMessage());
		}
	}

	public void testCompileMultiPackageDomain() throws Exception {
		DomainModelSource ds = new MultiplePackagesDomainModelSetup().init();
		MapDefSource ms = new MapSetup().init(new DiaDefSetup(null).init(), ds, new ToolDefSetup());

		final HashSet additionalPacks = new HashSet(8);
		additionalPacks.add(ds.getNodeA().getEClass().getEPackage());
		additionalPacks.add(ds.getNodeB().getEClass().getEPackage());
		additionalPacks.add(ds.getLinkAsClass().getEClass().getEPackage());

		DiaGenSource gmfGenSource = new MultiPackageGenSetup(additionalPacks).init(ms);

		new GenProjectBaseSetup().generateAndCompile(SessionSetup.getRuntimeWorkspaceSetup(), gmfGenSource);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
