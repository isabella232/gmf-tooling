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

import java.util.HashSet;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gmf.codegen.gmfgen.DynamicModelAccess;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenCustomPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenStandardPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.StandardPreferencePages;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

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
		generateAndCompile(gmfGenSource);
	}

	public void testCompileDynamicDomainModel() throws Exception {
		DiaGenSource s = createLibraryGen(false);
		final GenEditorGenerator editorGen = s.getGenDiagram().getEditorGen();
		assertNull("prereq", editorGen.getModelAccess());
		DynamicModelAccess dma = GMFGenFactory.eINSTANCE.createDynamicModelAccess();
		editorGen.setModelAccess(dma);
		generateAndCompile(s, new GenDiagramMutator("dynmodel") {
			@Override
			public void doMutation(GenDiagram d) {
				final DynamicModelAccess modelAccess = d.getEditorGen().getModelAccess();
				modelAccess.setClassName("NonDefaultDynamicAccessorName");
			}
			@Override
			public void undoMutation(GenDiagram d) {
				final DynamicModelAccess modelAccess = d.getEditorGen().getModelAccess();
				modelAccess.setClassName(null);
			}
		});
	}

	public void testPreferencePages() throws Exception {
		DiaGenSource s = createLibraryGen(false);
		final GenDiagram gd = s.getGenDiagram();
		// Part 1: compile all standard
		GenStandardPreferencePage[] p = new GenStandardPreferencePage[StandardPreferencePages.values().length];
		assertTrue("sanity", p.length > 5);
		for (int i = 0; i < p.length; i++) {
			p[i] = GMFGenFactory.eINSTANCE.createGenStandardPreferencePage();
			p[i].setClassName("Page" + i);
			p[i].setKind(StandardPreferencePages.values()[i]);
			if (i > 0) {
				p[i-1].getChildren().add(p[i]);
			}
		}
		gd.getPreferencePages().clear();
		gd.getPreferencePages().add(p[0]);
		generateAndCompile(s);
		GenPlugin gp = gd.getEditorGen().getPlugin();
		IProject generatedProject = ResourcesPlugin.getWorkspace().getRoot().getProject(gp.getID());
		IFile generatedManifest = generatedProject.getFile("plugin.xml");
		assertTrue(generatedManifest.exists());
		XPathFactory xf = XPathFactory.newInstance();
		XPathExpression xe = xf.newXPath().compile("/plugin/extension[@point = 'org.eclipse.ui.preferencePages']/page");
		NodeList result = (NodeList) xe.evaluate(new InputSource(generatedManifest.getContents()), XPathConstants.NODESET);
		assertEquals(p.length, result.getLength());
		//
		// Part 2: generateBoilerplate and subset of pages
		gp.setID(gp.getID() + ".boilerplateprefpage");
		gd.getPreferencePages().clear();
		GenCustomPreferencePage cp1 = GMFGenFactory.eINSTANCE.createGenCustomPreferencePage();
		cp1.setQualifiedClassName(gd.getPreferencesPackageName() + ".CustomPageNoCodeGenerated");
		cp1.setGenerateBoilerplate(false);
		GenCustomPreferencePage cp2 = GMFGenFactory.eINSTANCE.createGenCustomPreferencePage();
		cp2.setQualifiedClassName(gd.getPreferencesPackageName() + ".CustomPageWithBoilerplateCode");
		cp2.setGenerateBoilerplate(true);
		GenStandardPreferencePage onePage = GMFGenFactory.eINSTANCE.createGenStandardPreferencePage();
		onePage.setKind(StandardPreferencePages.CONNECTIONS_LITERAL);
		onePage.getChildren().add(cp1);
		onePage.getChildren().add(cp2);
		gd.getPreferencePages().add(onePage);
		generateAndCompile(s);
		generatedProject = ResourcesPlugin.getWorkspace().getRoot().getProject(gp.getID());
		generatedManifest = generatedProject.getFile("plugin.xml");
		assertTrue(generatedManifest.exists());
		// check all three have been registered
		result = (NodeList) xe.evaluate(new InputSource(generatedManifest.getContents()), XPathConstants.NODESET);
		assertEquals(3, result.getLength());
		HashSet<String> names = new HashSet<String>();
		names.add(onePage.getQualifiedClassName());
		names.add(cp1.getQualifiedClassName());
		names.add(cp2.getQualifiedClassName());
		assertTrue("sanity", names.size() == 3);
		for (int i = 0; i < result.getLength(); i++) {
			String className = result.item(i).getAttributes().getNamedItem("class").getNodeValue();
			assertTrue(className, names.remove(className));
		}
		assertTrue(names.isEmpty());
		// check real files
		IFile file_sp = generatedProject.getFile("/src/" + onePage.getQualifiedClassName().replace('.', '/') + ".java");
		IFile file_cp1 = generatedProject.getFile("/src/" + cp1.getQualifiedClassName().replace('.', '/') + ".java");
		IFile file_cp2 = generatedProject.getFile("/src/" + cp2.getQualifiedClassName().replace('.', '/') + ".java");
		assertTrue(file_sp.exists());
		assertTrue(file_cp2.exists());
		assertFalse(file_cp1.exists());
	}
}
