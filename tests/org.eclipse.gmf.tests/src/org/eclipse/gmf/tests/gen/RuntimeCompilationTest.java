/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
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

import java.util.LinkedList;

import org.eclipse.gmf.codegen.gmfgen.DynamicModelAccess;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;

/**
 * @author dstadnik
 */
public class RuntimeCompilationTest extends CompilationTest {

	public RuntimeCompilationTest(String name) {
		super(name, new RuntimeBasedGeneratorConfiguration(), new InnerClassViewmapProducer());
	}

	/**
	 * Pure design diagrams are not supported in lite version.
	 */
	public void testCompilePureDesignDiagram() throws Exception {
		myMapSource.detachFromDomainModel();
		DiaGenSource gmfGenSource = createLibraryGen(false);
		gmfGenSource.getGenDiagram().getEditorGen().setPackageNamePrefix("org.eclipse.gmf.examples.library.diagram"); //$NON-NLS-1$
		generateAndCompile(gmfGenSource, NO_MUTATORS);
	}

	public void testCompileDynamicDomainModel() throws Exception {
		DiaGenSource s = createLibraryGen(false);
		final GenEditorGenerator editorGen = s.getGenDiagram().getEditorGen();
		assertNull("prereq", editorGen.getModelAccess());
		DynamicModelAccess dma = GMFGenFactory.eINSTANCE.createDynamicModelAccess();
		editorGen.setModelAccess(dma);
		LinkedList<IGenDiagramMutator> m = new LinkedList<IGenDiagramMutator>();
		// no-op mutator, just to verify defaults
		m.add(new IGenDiagramMutator() {
			public void doMutation(GenDiagram d) {
			}
			public void undoMutation(GenDiagram d) {
			}
		});
		m.add(new IGenDiagramMutator() {
			public void doMutation(GenDiagram d) {
				final DynamicModelAccess modelAccess = d.getEditorGen().getModelAccess();
				modelAccess.setClassName("NonDefaultDynamicAccessorName");
			}
			public void undoMutation(GenDiagram d) {
				final DynamicModelAccess modelAccess = d.getEditorGen().getModelAccess();
				modelAccess.setClassName(null);
			}
		});
		generateAndCompile(s, m);
	}
}
