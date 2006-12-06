/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Boris Blajer (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.gen;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.gmfgraph.util.RuntimeLiteFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.internal.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.tests.gen.CompilationTest;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.GenProjectBaseSetup;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;


public class LiteCompilationTest extends CompilationTest {
	public LiteCompilationTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceDescription description = workspace.getDescription();
		description.setAutoBuilding(false);
		workspace.setDescription(description);
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceDescription description = workspace.getDescription();
		description.setAutoBuilding(true);
		workspace.setDescription(description);
		super.tearDown();
	}

	protected GeneratorConfiguration getGeneratorConfiguration() {
		return new LiteGeneratorConfiguration();
	}

	protected ViewmapProducer getViewmapProducer() {
		return new InnerClassViewmapProducer(new RuntimeLiteFQNSwitch(), MapModeCodeGenStrategy.STATIC);
	}

	@Override
	protected void generateAndCompile(DiaGenSource genSource) throws Exception {
		new GenProjectBaseSetup(getGeneratorConfiguration()) {
			@Override
			protected void generateDiagramPlugin(GenDiagram d) throws Exception {
				//IDE editor
				super.generateDiagramPlugin(d);
				//IDE view
				d.getEditorGen().getEditor().setEclipseEditor(false);
				GenPlugin genPlugin = d.getEditorGen().getPlugin();
				String baseName = genPlugin.getName();
				String baseID = genPlugin.getID();
				genPlugin.setName(baseName + ".view");
				genPlugin.setID(baseID + ".view");
				super.generateDiagramPlugin(d);
				//RCP editor
				d.getEditorGen().getEditor().setEclipseEditor(true);
				GenModel genModel = d.getDomainDiagramElement().getGenModel();
				genModel.setRichClientPlatform(true);
				genPlugin.setName(baseName + ".rcp");
				genPlugin.setID(baseID + ".rcp");
				super.generateDiagramPlugin(d);
				//RCP view
				d.getEditorGen().getEditor().setEclipseEditor(false);
				genPlugin.setName(baseName + ".rcp.view");
				genPlugin.setID(baseID + ".rcp.view");
				super.generateDiagramPlugin(d);
			}
		}.generateAndCompile(genSource);
	}
}
