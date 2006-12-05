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

import java.util.HashSet;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.internal.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.setup.DiaDefSetup;
import org.eclipse.gmf.tests.setup.DiaDefSource;
import org.eclipse.gmf.tests.setup.DiaGenSetup;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.DomainModelFileSetup;
import org.eclipse.gmf.tests.setup.DomainModelSetup;
import org.eclipse.gmf.tests.setup.DomainModelSetupInstanceClassName;
import org.eclipse.gmf.tests.setup.DomainModelSource;
import org.eclipse.gmf.tests.setup.GenProjectBaseSetup;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.MapSetup;
import org.eclipse.gmf.tests.setup.MultiPackageGenSetup;
import org.eclipse.gmf.tests.setup.MultiplePackagesDomainModelSetup;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;
import org.eclipse.gmf.tests.setup.ToolDefSetup;
import org.eclipse.gmf.tests.setup.ToolDefSource;
import org.eclipse.gmf.tests.setup.annotated.GenASetup;
import org.eclipse.gmf.tests.setup.annotated.GraphDefASetup;
import org.eclipse.gmf.tests.setup.annotated.MapDefASetup;
import org.eclipse.gmf.tests.setup.annotated.ToolDefASetup;

/**
 * TODO add compilation check for CustomFigure(FigureAccessor(no fqn), FigureAccessor(fqn));  
 */
public class CompilationTest extends TestCase {
	
	public CompilationTest(String name) {
		super(name);
	}

	// TODO EditPartViewer[Source|Setup]

	protected DiaGenSource getLibraryGen(boolean rcp) throws Exception {
		URI selected = Plugin.createURI("/models/library/library.ecore"); //$NON-NLS-1$
		DomainModelSource dmSource =  new DomainModelFileSetup().init(selected);
		ToolDefSource tdmSource = new ToolDefASetup(dmSource.getModel());
		DiaDefSource gdmSource = new GraphDefASetup(dmSource.getModel());
		MapDefSource mmSource = new MapDefASetup(dmSource.getModel(), tdmSource.getRegistry(), gdmSource.getCanvasDef());
		return new GenASetup(mmSource.getMapping(), rcp);
	}

	public void testCompileDistinctModelAndDiagramFiles() throws Exception {
		DiaGenSource gmfGenSource = getLibraryGen(false);
		gmfGenSource.getGenDiagram().getEditorGen().setSameFileForDiagramAndModel(false);
		generateAndCompile(gmfGenSource);
	}

	public void testCompileSingleDiagramFile() throws Exception {
		DiaGenSource gmfGenSource = getLibraryGen(false);
		gmfGenSource.getGenDiagram().getEditorGen().setSameFileForDiagramAndModel(true);
		generateAndCompile(gmfGenSource);
	}

	public void testRCPCompileDistinctModelAndDiagramFiles() throws Exception {
		DiaGenSource gmfGenSource = getLibraryGen(true);
		gmfGenSource.getGenDiagram().getEditorGen().setSameFileForDiagramAndModel(false);
		generateAndCompile(gmfGenSource);
	}

	public void testRCPCompileSingleDiagramFile() throws Exception {
		DiaGenSource gmfGenSource = getLibraryGen(true);
		gmfGenSource.getGenDiagram().getEditorGen().setSameFileForDiagramAndModel(true);
		generateAndCompile(gmfGenSource);
	}
	
	public void testCompileNONsynchronizedDiagram() throws Exception {
		DiaGenSource gmfGenSource = getLibraryGen(false);
		gmfGenSource.getGenDiagram().setSynchronized(!gmfGenSource.getGenDiagram().isSynchronized());
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
	
	public void testCompileInstanceClassNames() throws Exception {
		DomainModelSetup domainModelSetup = new DomainModelSetupInstanceClassName().init();
		MapDefSource mapSource = new MapSetup().init(new DiaDefSetup().init(), domainModelSetup, new ToolDefSetup());
		DiaGenSource gmfGenSource = new DiaGenSetup(getViewmapProducer()).init(mapSource);
		generateAndCompile(gmfGenSource);
	}
	
	public void testCompileNONsynchronizedInstanceClassNames() throws Exception {
		DomainModelSetup domainModelSetup = new DomainModelSetupInstanceClassName().init();
		MapDefSource mapSource = new MapSetup().init(new DiaDefSetup().init(), domainModelSetup, new ToolDefSetup());
		DiaGenSource gmfGenSource = new DiaGenSetup(getViewmapProducer()).init(mapSource);
		gmfGenSource.getGenDiagram().setSynchronized(!gmfGenSource.getGenDiagram().isSynchronized());
		generateAndCompile(gmfGenSource);
	}

	public void testCompileMultiPackageDomain() throws Exception {
		DomainModelSource ds = new MultiplePackagesDomainModelSetup().init();
		MapDefSource ms = new MapSetup().init(new DiaDefSetup().init(), ds, new ToolDefSetup());

		final HashSet<EPackage> additionalPacks = new HashSet<EPackage>(8);
		additionalPacks.add(ds.getNodeA().getEClass().getEPackage());
		additionalPacks.add(ds.getNodeB().getEClass().getEPackage());
		additionalPacks.add(ds.getLinkAsClass().getEClass().getEPackage());

		DiaGenSource gmfGenSource = new MultiPackageGenSetup(additionalPacks).init(ms);

		generateAndCompile(gmfGenSource);
	}

	protected void generateAndCompile(DiaGenSource genSource) throws Exception {
		new GenProjectBaseSetup(getGeneratorConfiguration()).generateAndCompile(genSource);
	}

	protected GeneratorConfiguration getGeneratorConfiguration() {
		return new RuntimeBasedGeneratorConfiguration();
	}

	protected ViewmapProducer getViewmapProducer() {
		return new InnerClassViewmapProducer();
	}
}
