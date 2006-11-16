/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gef;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration.ViewerConfiguration;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class DiagramEditorTest extends AbstractDiagramEditorTest {

	public DiagramEditorTest(String name) {
		super(name);
	}

	public void testSaveDiagramChanges() {
		IEditorPart editorPart = getEditor();
		assertFalse("Created Editor is dirty", editorPart.isDirty());
		Diagram diagram = getDiagram();
		Command setNameCommand = getViewerConfiguration().getSetNotationalElementStructuralFeature(diagram, NotationPackage.eINSTANCE.getDiagram_Name(), getUniqueString());
		checkEditorDirtyState(setNameCommand, editorPart, getViewerConfiguration().getViewer());
	}

	private void checkEditorDirtyState(Command setNameCommand, IEditorPart editorPart, EditPartViewer viewer) {
		viewer.getEditDomain().getCommandStack().execute(setNameCommand);
		assertTrue("Editor was not marked as dirty", editorPart.isDirty());
		editorPart.doSave(new NullProgressMonitor());
		assertFalse("Editor was not saved", editorPart.isDirty());
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editorPart, true);
	}

	public void testSaveNotaitonElementChanges() {
		IEditorPart editorPart = getEditor();
		ViewerConfiguration viewerConfiguration = getViewerConfiguration();
		Diagram diagram = getDiagram();
		Node nodeA = createNodeA(diagram, editorPart);
		assertTrue("Created node invisible", nodeA.isVisible());
		Command setNameCommand = viewerConfiguration.getSetNotationalElementStructuralFeature(nodeA, NotationPackage.eINSTANCE.getView_Visible(), Boolean.FALSE);
		checkEditorDirtyState(setNameCommand, editorPart, getViewerConfiguration().getViewer());
	}

	/**
	 * Creating Node, saving editor
	 */
	private Node createNodeA(Diagram diagram, IEditorPart editorPart) {
		Node result = createNode(getSetup().getGenModel().getNodeA(), diagram);
		editorPart.doSave(new NullProgressMonitor());
		assertFalse("Editor was not saved", editorPart.isDirty());
		return result;
	}

	public void testSaveDomainElementChangesSeparateFiles() {
		checkSaveDomainElementChanges(false);
	}

	public void testSaveDomainElementChangesSameFile() {
		checkSaveDomainElementChanges(true);
	}

	private void checkSaveDomainElementChanges(boolean sameFile) {
		try {
			IFile diagramFile = createDiagram(sameFile);
			IEditorPart editorPart = openEditor(diagramFile);
			ViewerConfiguration viewerConfiguration = createViewerConfiguration(editorPart);
			// Substituting viewer configuraration with the custom one
			setViewerConfiguration(viewerConfiguration);
			EditPartViewer viewer = viewerConfiguration.getViewer();
			Diagram diagram = getDiagram();

			Node nodeA = createNodeA(diagram, editorPart);
			Command setLabelCommand = viewerConfiguration.getSetBusinessElementStructuralFeatureCommand(nodeA, "label", getUniqueString());
			checkEditorDirtyState(setLabelCommand, editorPart, viewer);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Testing fix of request:
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=153893
	 */
	public void testSaveWithUnloadedResource() {
		IEditorPart editorPart = getEditor();
		ViewerConfiguration viewerConfiguration = getViewerConfiguration();
		EditPartViewer viewer = viewerConfiguration.getViewer();
		Diagram diagram = getDiagram();

		// Creating arbitratry model resource + unloading it
		URI anotherResourceURI = diagram.eResource().getURI().trimFileExtension().appendFileExtension("additional." + getSetup().getGenModel().getGenDiagram().getEditorGen().getDomainFileExtension());
		createAdditionalModelResource(anotherResourceURI);
		Resource anotherResource = diagram.eResource().getResourceSet().getResource(anotherResourceURI, true);
		anotherResource.unload();

		// Changing + saving editor
		Command setNameCommand = viewerConfiguration.getSetNotationalElementStructuralFeature(diagram, NotationPackage.eINSTANCE.getDiagram_Name(), getUniqueString());
		checkEditorDirtyState(setNameCommand, editorPart, viewer);

		// Checking contents of unloaded resource.
		checkAdditionalModelResource(anotherResourceURI);
	}

	public void testUnspecifiedTypeRequest() {
		IEditorPart editorPart = getEditor();
		EditPartViewer viewer = getViewerConfiguration().getViewer();
		Diagram diagram = getDiagram();
		CreationTool creationTool = getNodeCreationTool(viewer);

		GenNode genNodeA = getSetup().getGenModel().getNodeA();
		Node aNode = checkCreateNode(viewer, diagram, creationTool, genNodeA.getVisualID());

		assertTrue("Incorrect setup passed", genNodeA.getCompartments().size() > 0);
		GenCompartment genCompartment = (GenCompartment) genNodeA.getCompartments().get(0);
		assertTrue("Incorrect setup passed", genCompartment.getChildNodes().size() > 0);
		GenNode childNode = (GenNode) genCompartment.getChildNodes().get(0);
		assertNotNull("Incorrect setup passed", childNode);

		Node compartment = findChildnode(aNode, genCompartment);
		checkCreateNode(viewer, compartment, creationTool, childNode.getVisualID());

		editorPart.doSave(new NullProgressMonitor());
	}

	private Node findChildnode(Node parentNode, GenCommonBase genElement) {
		String visualID = String.valueOf(genElement.getVisualID());
		for (Iterator it = parentNode.getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (nextView.getType().equals(visualID)) {
				assertTrue(nextView instanceof Node);
				return (Node) nextView;
			}
		}
		fail("Node not found" + visualID);
		return null;
	}

	private Node checkCreateNode(EditPartViewer viewer, View parentView, CreationTool creationTool, int newNodeVisualID) {
		Request request = creationTool.createCreateRequest();
		EditPart parentEP = (EditPart) viewer.getEditPartRegistry().get(parentView);
		assertNotNull(parentEP);
		Command createANodeCommand = parentEP.getCommand(request);

		viewer.getEditDomain().getCommandStack().execute(createANodeCommand);
		assertTrue(parentView.getChildren().size() == 1);
		Node aNode = (Node) parentView.getChildren().get(0);
		assertEquals("Node with incorrect visual ID was created.", aNode.getType(), String.valueOf(newNodeVisualID));
		return aNode;
	}

	private CreationTool getNodeCreationTool(EditPartViewer viewer) {
		PaletteRoot paletteRoot = viewer.getEditDomain().getPaletteViewer().getPaletteRoot();
		assertNotNull("Palette root absent", paletteRoot);
		PaletteContainer container = findPaletteContainer(paletteRoot, "Default");
		assertTrue("Incorrect palette was created", container.getChildren().size() > 0);
		assertTrue("Incorrect palette was created", container.getChildren().get(0) instanceof ToolEntry);
		ToolEntry toolEntry = (ToolEntry) container.getChildren().get(0);
		Tool tool = toolEntry.createTool();
		assertTrue("Incorrect palette was created", tool instanceof CreationTool);
		CreationTool creationTool = (CreationTool) tool;
		creationTool.setViewer(viewer);
		creationTool.setEditDomain(viewer.getEditDomain());
		return creationTool;
	}

	private PaletteContainer findPaletteContainer(PaletteRoot paletteRoot, String groupName) {
		for (Iterator it = paletteRoot.getChildren().iterator(); it.hasNext();) {
			PaletteContainer nextContainer = (PaletteContainer) it.next();
			if (groupName.equals(nextContainer.getLabel())) {
				return nextContainer;
			}
		}
		fail("No palette container " + groupName + " fourn in the palette");
		return null;
	}

	private void checkAdditionalModelResource(URI anotherResourceURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(anotherResourceURI, true);
		assertTrue("Unloaded resource was changed while saving editor", resource.getContents().size() == 1);
	}

	private void createAdditionalModelResource(URI anotherResourceURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(anotherResourceURI);
		try {
			EObject domainDiagramElement = createDiagramDomainObject();
			resource.getContents().add(domainDiagramElement);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
}
