/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.internal.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;
import org.eclipse.gmf.tests.setup.RuntimeWorkspaceSetup;
import org.eclipse.gmf.tests.setup.annotated.GenASetup;
import org.eclipse.gmf.tests.setup.annotated.MapDefASetup;

/**
 * @author dstadnik
 */
public class RuntimeCompilationTest extends CompilationTest {

	public RuntimeCompilationTest(String name) {
		super(name);
	}
	@Override
	protected void setUp() throws Exception {
		if (RuntimeWorkspaceSetup.INSTANCE == null) {
			RuntimeWorkspaceSetup.INSTANCE = new RuntimeWorkspaceSetup().initFull();
		}
		super.setUp();
	}

	/**
	 * Pure design diagrams are not supported in lite version.
	 */
	public void testCompilePureDesignDiagram() throws Exception {
		MapDefASetup mmSource = getLibraryMap();
		mmSource.detachFromDomainModel();
		DiaGenSource gmfGenSource = new GenASetup(mmSource.getMapping(), getViewmapProducer(), false);
		gmfGenSource.getGenDiagram().getEditorGen().setPackageNamePrefix("org.eclipse.gmf.examples.library.diagram"); //$NON-NLS-1$
		generateAndCompile(gmfGenSource, NO_MUTATORS);
	}

	protected GeneratorConfiguration getGeneratorConfiguration() {
		return new RuntimeBasedGeneratorConfiguration();
	}

	protected ViewmapProducer getViewmapProducer() {
		return new InnerClassViewmapProducer();
	}
}
