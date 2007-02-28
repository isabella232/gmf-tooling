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

import java.util.Collection;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.gmfgraph.util.RuntimeLiteFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.internal.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.tests.gen.CompilationTest;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;


public class LiteCompilationTest extends CompilationTest {
	public LiteCompilationTest(String name) {
		super(name);
	}

	protected GeneratorConfiguration getGeneratorConfiguration() {
		return new LiteGeneratorConfiguration();
	}

	protected ViewmapProducer getViewmapProducer() {
		return new InnerClassViewmapProducer(new RuntimeLiteFQNSwitch(), MapModeCodeGenStrategy.STATIC);
	}

	@Override
	protected Collection<IGenDiagramMutator> getMutators() {
		Collection<IGenDiagramMutator> result = super.getMutators();
		result.add(VIEW_MUTATOR);
		return result;
	}

	@Override
	protected Collection<IGenDiagramMutator> getMutatorsForRCP() {
		Collection<IGenDiagramMutator> result = super.getMutatorsForRCP();
		result.add(VIEW_MUTATOR);
		return result;
	}

	private static final IGenDiagramMutator VIEW_MUTATOR = new IGenDiagramMutator() {
		private String myPluginId;
		private boolean myIsEclipseEditor;
		public void doMutation(GenDiagram d) {
			myIsEclipseEditor = d.getEditorGen().getEditor().isEclipseEditor();
			d.getEditorGen().getEditor().setEclipseEditor(!myIsEclipseEditor);
			GenPlugin genPlugin = d.getEditorGen().getPlugin();
			myPluginId = genPlugin.getID();
			genPlugin.setID(myPluginId + ".view");
		}
		public void undoMutation(GenDiagram d) {
			d.getEditorGen().getEditor().setEclipseEditor(myIsEclipseEditor);
			d.getEditorGen().getPlugin().setID(myPluginId);
		}
	};
}
