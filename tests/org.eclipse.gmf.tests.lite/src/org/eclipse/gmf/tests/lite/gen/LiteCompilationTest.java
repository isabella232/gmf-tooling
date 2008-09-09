/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
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


import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.tests.gen.CompilationTest;
import org.eclipse.gmf.tests.gen.GenDiagramMutator;


public class LiteCompilationTest extends CompilationTest {
	public LiteCompilationTest(String name) {
		super(name, new LiteGeneratorConfiguration(),
			new InnerClassViewmapProducer("lite", MapModeCodeGenStrategy.STATIC, null));
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// used to augment list from superclass, now just a copy
		myGeneralMutators = new GenDiagramMutator[] { 
			SAME_FILE_MUTATOR, SYNCHRONIZED_MUTATOR, SHORTCUT_STUFF_MUTATOR,
			VIEW_MUTATOR
		};
		myRichClientMutators = new GenDiagramMutator[] { 
			SAME_FILE_MUTATOR, SHORTCUT_STUFF_MUTATOR,
			VIEW_MUTATOR
		};
	}

	private final GenDiagramMutator VIEW_MUTATOR = new GenDiagramMutator("view") {
		private boolean myIsEclipseEditor;
		public void doMutation(GenDiagram d) {
			myIsEclipseEditor = d.getEditorGen().getEditor().isEclipseEditor();
			d.getEditorGen().getEditor().setEclipseEditor(!myIsEclipseEditor);
		}
		public void undoMutation(GenDiagram d) {
			d.getEditorGen().getEditor().setEclipseEditor(myIsEclipseEditor);
		}
	};
}
