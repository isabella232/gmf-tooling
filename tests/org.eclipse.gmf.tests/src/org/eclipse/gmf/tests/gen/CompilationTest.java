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
import org.eclipse.gmf.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.setup.DiaGenSetup;
import org.eclipse.gmf.tests.setup.DomainModelSetup;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;
import org.eclipse.gmf.tests.setup.DiaDefSetup;
import org.eclipse.gmf.tests.setup.DiaGenFileSetup;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.DomainModelSource;
import org.eclipse.gmf.tests.setup.GenProjectBaseSetup;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.MapSetup;
import org.eclipse.gmf.tests.setup.MultiPackageGenSetup;
import org.eclipse.gmf.tests.setup.MultiplePackagesDomainModelSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.gmf.tests.setup.ToolDefSetup;

/**
 * TODO add compilation check for CustomFigure(FigureAccessor(no fqn), FigureAccessor(fqn));  
 */
public class CompilationTest extends TestCase {

	public CompilationTest(String name) {
		super(name);
	}

	// TODO EditPartViewer[Source|Setup]

	protected void setUp() throws Exception {
		super.setUp();
		SessionSetup.getRuntimeWorkspaceSetup();
	}

	public void testCompileDistinctModelAndDiagramFiles() throws Exception {
		DiaGenSource gmfGenSource = loadSource();
		gmfGenSource.getGenDiagram().getEditorGen().setSameFileForDiagramAndModel(false);
		generateAndCompile(gmfGenSource);
	}

	public void testCompileSingleDiagramFile() throws Exception {
		DiaGenSource gmfGenSource = loadSource();
		gmfGenSource.getGenDiagram().getEditorGen().setSameFileForDiagramAndModel(true);
		generateAndCompile(gmfGenSource);
	}

	public void testCompilePotentialNameClashes() throws Exception {
		DomainModelSource domainModel = new DomainModelSetup().init();
		domainModel.getNodeA().getEClass().setName("Node"); // #142211
		domainModel.getNodeB().getEClass().setName("ShapeNode");
		domainModel.getLinkAsClass().getEClass().setName("ConnectionNode");
		domainModel.getNodeA().getNameAttr().setName("attribute");
		domainModel.getNodeB().getNameAttr().setName("class");
		domainModel.getDiagramElement().setName("Diagram");
		MapDefSource mapSource = new MapSetup().init(new DiaDefSetup().init(), domainModel, new ToolDefSetup());
		DiaGenSource gmfGenSource = new DiaGenSetup(getViewmapProducer()).init(mapSource);
		generateAndCompile(gmfGenSource);
	}
	private DiaGenSource loadSource() throws IOException {
		URI selected = Plugin.createURI("/models/library/library.gmfgen");
		DiaGenSource gmfGenSource =  new DiaGenFileSetup().init(selected);
		return gmfGenSource;
	}

	public void testCompileMultiPackageDomain() throws Exception {
		DomainModelSource ds = new MultiplePackagesDomainModelSetup().init();
		MapDefSource ms = new MapSetup().init(new DiaDefSetup().init(), ds, new ToolDefSetup());

		final HashSet additionalPacks = new HashSet(8);
		additionalPacks.add(ds.getNodeA().getEClass().getEPackage());
		additionalPacks.add(ds.getNodeB().getEClass().getEPackage());
		additionalPacks.add(ds.getLinkAsClass().getEClass().getEPackage());

		DiaGenSource gmfGenSource = new MultiPackageGenSetup(additionalPacks).init(ms);

		generateAndCompile(gmfGenSource);
	}

	protected void generateAndCompile(DiaGenSource genSource) throws Exception {
		new GenProjectBaseSetup(getGeneratorConfiguration()).generateAndCompile(SessionSetup.getRuntimeWorkspaceSetup(), genSource);
	}

	protected GeneratorConfiguration getGeneratorConfiguration() {
		return new RuntimeBasedGeneratorConfiguration();
	}

	protected ViewmapProducer getViewmapProducer() {
		return new InnerClassViewmapProducer();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
