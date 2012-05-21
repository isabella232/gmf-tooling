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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.internal.bridge.StatefulVisualIdentifierDispencer;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.gmf.tests.tr.TransformationTestSupport.Transformation;

public class QvtGenModelTransformerVisualIDWithTraceTest extends ConfiguredTestCase {
	protected static String testFolder = "platform:/plugin/org.eclipse.gmf.tests/models/tests";  //$NON-NLS-1$
	
	public QvtGenModelTransformerVisualIDWithTraceTest(String name) {
		super(name);
	}

	private Mapping mapping;
	private GenModel genModel;
	private Canvas canvas;
	private ResourceSet resoureSet;
	private IProject myProject;
	private URI projectURI;
	
	public void setUp() throws Exception {
		super.setUp();

		myProject = createProject();
		projectURI = URI.createURI(myProject.getFullPath().toString());
		
		resoureSet = new ResourceSetImpl();
		Resource genModelResource = resoureSet.createResource(URI.createURI(testFolder).appendSegment("test.genmodel"));
		genModelResource.load(null);
		genModel = (GenModel) genModelResource.getContents().get(0);

		Resource graphModelResource = resoureSet.createResource(URI.createURI(testFolder).appendSegment("test.gmfgraph"));
		graphModelResource.load(null);
		canvas = (Canvas) graphModelResource.getContents().get(0);

		mapping = loadMapping();
	}

	public void tearDown() throws Exception {
		deleteProject();
		myProject = null;
		super.tearDown();
	}

	protected Mapping loadMapping() {
		Mapping mapping = GMFMapFactory.eINSTANCE.createMapping();
		CanvasMapping cmap = GMFMapFactory.eINSTANCE.createCanvasMapping();
		cmap.setDiagramCanvas(getCanvas());
		mapping.setDiagram(cmap);

		EPackage ePackage = getGenModel().getGenPackages().get(0).getEcorePackage();
		EClass container = (EClass) ePackage.getEClassifier("UltimateContainer");
		EReference containment = (EReference) container.getEStructuralFeature("all");
		EClass srcA = (EClass) ePackage.getEClassifier("NodeSrcA");
		cmap.setDomainMetaElement(container);
		cmap.setDomainModel(ePackage);

		TopNodeReference top1 = GMFMapFactory.eINSTANCE.createTopNodeReference();
		top1.setContainmentFeature(containment);

		NodeMapping nmap = GMFMapFactory.eINSTANCE.createNodeMapping();
		nmap.setDomainMetaElement(srcA);
		nmap.setDiagramNode(getCanvas().getNodes().get(0));
		top1.setOwnedChild(nmap);

		mapping.getNodes().add(top1);

		return mapping;
	}

	private GenModel getGenModel() {
		return genModel;
	}

	private Canvas getCanvas() {
		return canvas;
	}

	private Mapping getMapping() {
		return mapping;
	}

	protected TopNodeReference createTopNode(String name) {
		TopNodeReference existing = getMapping().getNodes().get(0);
		EPackage ePackage = existing.getOwnedChild().getDomainMetaElement().getEPackage();
		EClass eClass = (EClass) ePackage.getEClassifier(name);

		TopNodeReference node = GMFMapFactory.eINSTANCE.createTopNodeReference();
		node.setContainmentFeature(existing.getContainmentFeature());

		NodeMapping nmap = GMFMapFactory.eINSTANCE.createNodeMapping();
		nmap.setDomainMetaElement(eClass);
		nmap.setDiagramNode(existing.getChild().getDiagramNode());
		node.setOwnedChild(nmap);

		return node;
	}

	public void testVisualIDWithNoTrace() {
		Transformation java = TransformationTestSupport.getJavaTransformation(getGenModel(), getMapping(), false);
		Transformation qvt = TransformationTestSupport.getQvtTransformation(getGenModel(), getMapping(), false);

		GenEditorGenerator expected = java.execute(projectURI.appendSegment("model.java.gmfgen"));
		GenEditorGenerator actual = qvt.execute(projectURI.appendSegment("model.java.gmfgen"));

		EList<GenTopLevelNode> expNodes = expected.getDiagram().getTopLevelNodes();
		EList<GenTopLevelNode> actNodes = actual.getDiagram().getTopLevelNodes();

		assertEquals(1, expNodes.size());
		assertEquals(expNodes.size(), actNodes.size());

//		assertEquals(2001, expNodes.get(0).getVisualID());

		for (int i=0;i<expNodes.size();i++){
			GenTopLevelNode expNode = expNodes.get(i);
			GenTopLevelNode actNode = actNodes.get(i);

//			assertEquals(expNode.getVisualID(), actNode.getVisualID());
		}

		System.out.println(java.getDispencer());
		System.out.println(qvt.getDispencer());
		
		((StatefulVisualIdentifierDispencer) java.getDispencer()).saveState();
		((StatefulVisualIdentifierDispencer) qvt.getDispencer()).saveState();

		TopNodeReference node = createTopNode("NodeTargetB");
		getMapping().getNodes().add(node);

		expected = java.execute(projectURI.appendSegment("model.java.gmfgen"));
		actual = qvt.execute(projectURI.appendSegment("model.java.gmfgen"));

		expNodes = expected.getDiagram().getTopLevelNodes();
		actNodes = actual.getDiagram().getTopLevelNodes();

		assertEquals(2, expNodes.size());
		assertEquals(expNodes.size(), actNodes.size());

		assertEquals(2001, expNodes.get(0).getVisualID());
		assertEquals(2002, expNodes.get(1).getVisualID());

		for (int i=0;i<expNodes.size();i++){
			GenTopLevelNode expNode = expNodes.get(i);
			GenTopLevelNode actNode = actNodes.get(i);

			assertEquals(expNode.getVisualID(), actNode.getVisualID());
		}

		node = createTopNode("NodeTargetC");
		getMapping().getNodes().add(0, node);

		((StatefulVisualIdentifierDispencer) java.getDispencer()).saveState();
		((StatefulVisualIdentifierDispencer) qvt.getDispencer()).saveState();

		expected = java.execute(projectURI.appendSegment("model.java.gmfgen"));
		actual = qvt.execute(projectURI.appendSegment("model.java.gmfgen"));

		expNodes = expected.getDiagram().getTopLevelNodes();
		actNodes = actual.getDiagram().getTopLevelNodes();

		assertEquals(3, expNodes.size());
		assertEquals(expNodes.size(), actNodes.size());

		assertEquals(2003, expNodes.get(0).getVisualID());
		assertEquals(2001, expNodes.get(1).getVisualID());
		assertEquals(2002, expNodes.get(2).getVisualID());

		for (int i=0;i<expNodes.size();i++){
			GenTopLevelNode expNode = expNodes.get(i);
			GenTopLevelNode actNode = actNodes.get(i);

			assertEquals(expNode.getVisualID(), actNode.getVisualID());
		}

		((StatefulVisualIdentifierDispencer) java.getDispencer()).saveState();
		((StatefulVisualIdentifierDispencer) qvt.getDispencer()).saveState();
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
