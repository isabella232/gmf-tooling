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

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.tests.setup.DiaGenSource;

public class LiteViewCompilationTest extends LiteCompilationTest {
	public LiteViewCompilationTest(String name) {
		super(name);
	}

	protected void generateAndCompile(DiaGenSource genSource) throws Exception {
		genSource.getGenDiagram().getEditorGen().getEditor().setEclipseEditor(false);
		GenModel genModel = genSource.getGenDiagram().getDomainDiagramElement().getGenModel();
		genModel.setModelPluginID(genModel.getModelPluginID() + ".view");
		genModel.setModelDirectory("/" + genModel.getModelPluginID() + "/src/");
		genModel.setEditDirectory(genModel.getModelDirectory());
		GenPlugin genPlugin = genSource.getGenDiagram().getEditorGen().getPlugin();
		genPlugin.setName(genPlugin.getName() + ".view");
		genPlugin.setID(genPlugin.getID() + ".view");
		super.generateAndCompile(genSource);
	}
}
