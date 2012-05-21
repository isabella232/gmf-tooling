/*******************************************************************************
* Copyright (c) 2011, 2012 Montages A.G.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Guillaume Hillairet (Montages A.G.) : initial implementation
*******************************************************************************/
package org.eclipse.gmf.tests.tr;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.ModeledViewmap;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.gmf.tests.tr.TransformationTestSupport.Transformation;

public class QvtTransformModeledViewmapTest extends ConfiguredTestCase {
	protected static String testFolder = "platform:/plugin/org.eclipse.gmf.tests/models/tests/";  //$NON-NLS-1$
	
	public QvtTransformModeledViewmapTest(String name) {
		super(name);
	}
	
	protected GenEditorGenerator actualGenerator;
	private IProject myProject;
	private Mapping mapping;
	private GenModel genModel;
	private URI myProjectURI;
	
	public void setUp() throws Exception {
		super.setUp();
		myProject = createProject();
		myProjectURI = URI.createURI(myProject.getFullPath().toString());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource mapRes = resourceSet.createResource(URI.createURI(testFolder).appendSegment("test.gmfmap"));
		mapRes.load(null);
		Resource genRes = resourceSet.createResource(URI.createURI(testFolder).appendSegment("test.genmodel"));
		genRes.load(null);

		mapping = (Mapping) mapRes.getContents().get(0);
		genModel = (GenModel) genRes.getContents().get(0);

		Transformation qvt = TransformationTestSupport.getQvtTransformation(genModel, mapping, true);

		actualGenerator = qvt.execute(myProjectURI.appendSegment("test.java.gmfgen"));
	}
	
	public void testTopNodeModeledViewmap() {
		assertNotNull(actualGenerator);
		
		GenDiagram diagram = actualGenerator.getDiagram();
		assertNotNull(diagram);
		
		EList<GenTopLevelNode> nodes = diagram.getTopLevelNodes();
		
		for (GenTopLevelNode node: nodes) {
			Viewmap viewmap = node.getViewmap();
			assertNotNull(viewmap);
			assertTrue(viewmap instanceof ModeledViewmap);
			
			for (GenNodeLabel label: node.getLabels()) {
				Viewmap labelViewmap = label.getViewmap();
				assertNotNull(labelViewmap);
				assertTrue(labelViewmap instanceof ModeledViewmap);
			}
		}
	}
	
	public void testChildNodeModeledViewmap() {
		assertNotNull(actualGenerator);
		
		GenDiagram diagram = actualGenerator.getDiagram();
		assertNotNull(diagram);
		
		EList<GenChildNode> nodes = diagram.getChildNodes();
		
		for (GenChildNode node: nodes) {
			Viewmap viewmap = node.getViewmap();
			assertNotNull(viewmap);
			assertTrue(viewmap instanceof ModeledViewmap);
			
			for (GenNodeLabel label: node.getLabels()) {
				Viewmap labelViewmap = label.getViewmap();
				assertNotNull(labelViewmap);
				assertTrue(labelViewmap instanceof ModeledViewmap);
			}
		}
	}
	
	public void testLinkModeledViewmap() {
		assertNotNull(actualGenerator);
		
		GenDiagram diagram = actualGenerator.getDiagram();
		assertNotNull(diagram);
		
		EList<GenLink> links = diagram.getLinks();
		
		for (GenLink link: links) {
			Viewmap viewmap = link.getViewmap();
			assertNotNull(viewmap);
			assertTrue(viewmap instanceof ModeledViewmap);
			
			for (GenLinkLabel label: link.getLabels()) {
				Viewmap labelViewmap = label.getViewmap();
				assertNotNull(labelViewmap);
				assertTrue(labelViewmap instanceof ModeledViewmap);
			}
		}
	}
	
	public void testCompartmentModeledViewmap() {
		assertNotNull(actualGenerator);
		
		GenDiagram diagram = actualGenerator.getDiagram();
		assertNotNull(diagram);
		
		EList<GenCompartment> compartments = diagram.getCompartments();
		for (GenCompartment compartment: compartments) {
			Viewmap viewmap = compartment.getViewmap();
			assertNotNull(viewmap);
			assertTrue(viewmap instanceof ModeledViewmap);
		}
	}
	
	protected IProject createProject() {
		String projectName = "TransformToGenModelOperationTest_" + String.valueOf(System.currentTimeMillis()); //$NON-NLS-1$
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		assertFalse("Project with this name already present in the workspace: " + projectName, project.exists());
		try {
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());
		} catch (CoreException e) {
			fail(e.getMessage());
		}
		assertTrue("Project was not created: " + projectName, project.exists());
		return project;
	}

	protected void deleteProject() throws CoreException {
		if (getProject() != null) {
			if (getProject().isOpen()) {
				getProject().close(new NullProgressMonitor());
			}
			if (getProject().exists()) {
				getProject().delete(true, new NullProgressMonitor());
			}
		}
	}

	protected IProject getProject() {
		return myProject;
	}
}
