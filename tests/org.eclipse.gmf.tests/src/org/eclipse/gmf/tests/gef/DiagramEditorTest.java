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
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration.ViewerConfiguration;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;


public class DiagramEditorTest extends ConfiguredTestCase {

	private static final String PREFERENCES_HINT_FIELD = "DIAGRAM_PREFERENCES_HINT";

	public DiagramEditorTest(String name) {
		super(name);
	}

	public void testSaveDiagramChanges() {
		IEditorPart editorPart = createAndOpenEditor(createProject(), false);
		assertFalse("Created Editor is dirty", editorPart.isDirty());
		EditPartViewer viewer = getViewer(editorPart);
		Diagram diagram = getDiagram(viewer);
		ViewerConfiguration viewerConfiguration = createViewerConfiguration(viewer);
		
		Command setNameCommand = viewerConfiguration.getSetNotationalElementStructuralFeature(diagram, NotationPackage.eINSTANCE.getDiagram_Name(), getUniqueString());
		checkEditorDirtyState(setNameCommand, editorPart, viewer);
	}

	private void checkEditorDirtyState(Command setNameCommand, IEditorPart editorPart, EditPartViewer viewer) {
		viewer.getEditDomain().getCommandStack().execute(setNameCommand);
		assertTrue("Editor was not marked as dirty", editorPart.isDirty());
		editorPart.doSave(new NullProgressMonitor());
		assertFalse("Editor was not saved", editorPart.isDirty());
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editorPart, true);
	}

	private ViewerConfiguration createViewerConfiguration(EditPartViewer viewer) {
		ViewerConfiguration viewerConfiguration = null;
		try {
			viewerConfiguration = getSetup().getGeneratorConfiguration().createViewerConfiguration(getSetup(), viewer);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		return viewerConfiguration;
	}

	private Diagram getDiagram(EditPartViewer viewer) {
		EditPart diagramEditPart = viewer.getContents();
		assertTrue(diagramEditPart.getModel() instanceof Diagram);
		Diagram diagram = (Diagram) diagramEditPart.getModel();
		assertNotNull(diagram);
		return diagram;
	}
	
	public void testSaveNotaitonElementChanges() {
		IEditorPart editorPart = createAndOpenEditor(createProject(), false);
		EditPartViewer viewer = getViewer(editorPart);
		Diagram diagram = getDiagram(viewer);
		ViewerConfiguration viewerConfiguration = createViewerConfiguration(viewer);
		
		Node nodeA = createNodeA(viewer, viewerConfiguration, diagram);
		Command setNameCommand = viewerConfiguration.getSetNotationalElementStructuralFeature(nodeA, NotationPackage.eINSTANCE.getDiagram_Name(), getUniqueString());
		checkEditorDirtyState(setNameCommand, editorPart, viewer);
	}

	private Node createNodeA(EditPartViewer viewer, ViewerConfiguration viewerConfiguration, Diagram diagram) {
		assertTrue(diagram.getChildren().size() == 0);
		Command createElementCommand = viewerConfiguration.getCreateNodeCommand(diagram, getSetup().getGenModel().getNodeA());
		viewer.getEditDomain().getCommandStack().execute(createElementCommand);
		assertTrue(diagram.getChildren().size() == 1);
		return (Node) diagram.getChildren().get(0);
	}

	public void testSaveDomainElementChangesSeparateFiles() {
		checkSaveDomainElementChanges(false);
	}

	public void testSaveDomainElementChangesSameFile() {
		checkSaveDomainElementChanges(true);	
	}
	
	private void checkSaveDomainElementChanges(boolean sameFile) {
		IEditorPart editorPart = createAndOpenEditor(createProject(), sameFile);
		EditPartViewer viewer = getViewer(editorPart);
		Diagram diagram = getDiagram(viewer);
		ViewerConfiguration viewerConfiguration = createViewerConfiguration(viewer);
		
		Node nodeA = createNodeA(viewer, viewerConfiguration, diagram);
		Command setLabelCommand = viewerConfiguration.getSetBusinessElementStructuralFeatureCommand(nodeA, "label", getUniqueString());
		checkEditorDirtyState(setLabelCommand, editorPart, viewer);
	}
	
	/**
	 * Testing fix of request: https://bugs.eclipse.org/bugs/show_bug.cgi?id=153893
	 */
	public void testSaveWithUnloadedResource() {
		IEditorPart editorPart = createAndOpenEditor(createProject(), false);
		EditPartViewer viewer = getViewer(editorPart);
		Diagram diagram = getDiagram(viewer);
		ViewerConfiguration viewerConfiguration = createViewerConfiguration(viewer);

// Creating arbitratry model resource + unloading it
		URI anotherResourceURI = diagram.eResource().getURI().trimFileExtension().appendFileExtension("additional." + getSetup().getGenModel().getGenDiagram().getEditorGen().getDomainFileExtension());
		createAdditionalModelResource(anotherResourceURI);
		Resource anotherResource = diagram.eResource().getResourceSet().getResource(anotherResourceURI, true);
		anotherResource.unload();

// Changing + saving editor
		Command setNameCommand = viewerConfiguration.getSetNotationalElementStructuralFeature(diagram, NotationPackage.eINSTANCE.getDiagram_Name(), getUniqueString());
		viewer.getEditDomain().getCommandStack().execute(setNameCommand);
		editorPart.doSave(new NullProgressMonitor());

// Checking contents of unloaded resource.
		checkAdditionalModelResource(anotherResourceURI);
	}
	
	private void checkAdditionalModelResource(URI anotherResourceURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(anotherResourceURI, true);
		assertTrue("Unloaded resource was changed while saving editor", resource.getContents().size() == 1);
	}

	private void createAdditionalModelResource(URI anotherResourceURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(anotherResourceURI);
		EObject domainDiagramElement = createDiagramDomainObject();
		resource.getContents().add(domainDiagramElement);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			fail(e.getMessage());
		}	
	}

	// TODO: Move this method to GeneratorConfiguration
	private EditPartViewer getViewer(IEditorPart editorPart) {
		assertTrue("Passed EditorPart is not instance of IDiagramWorkbenchPart", editorPart instanceof IDiagramWorkbenchPart);
		return ((IDiagramWorkbenchPart) editorPart).getDiagramGraphicalViewer();
	}

	private IProject createProject() {
		String projectName = getUniqueString();
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
	
	private String getUniqueString() {
		return "DiagramEditorTest_" + String.valueOf(System.currentTimeMillis());
	}
	
	private IEditorPart createAndOpenEditor(IProject project, final boolean storeModelInDiagramFile) {
		GenDiagram genDiagram = getSetup().getGenModel().getGenDiagram();
		
		String uniqueName = getUniqueString();
		final String diagramFileName = uniqueName + "." + genDiagram.getEditorGen().getDiagramFileExtension();
		IFile diagramFile = project.getFile(diagramFileName);
		assertFalse("Diagram file was already created", diagramFile.exists());

		IFile modelFile = null;
		if (!storeModelInDiagramFile) {
			String modelFileName = uniqueName + "." + genDiagram.getEditorGen().getDomainFileExtension();	
			modelFile = project.getFile(modelFileName);
			assertFalse("Model file was already created", modelFile.exists());
		}
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFile.getFullPath().toOSString()));
		Resource modelResource = modelFile != null ? resourceSet.createResource(URI.createPlatformResourceURI(modelFile.getFullPath().toOSString())) : null;		
		
		EObject domainDiagramElement = createDiagramDomainObject();
		final PreferencesHint hint = getpreferencesHint();

		if (modelResource != null) {
			modelResource.getContents().add(domainDiagramElement);
		} else {
			diagramResource.getContents().add(domainDiagramElement);
		}
		Diagram diagram = ViewService.createDiagram(domainDiagramElement, getSetup().getGenModel().getGenDiagram().getEditorGen().getModelID(), hint);
		if (diagram != null) {
			diagramResource.getContents().add(diagram);
			diagram.setName(diagramFileName);
			diagram.setElement(domainDiagramElement);
		}
		try {
			if (modelResource != null) {
				modelResource.save(Collections.EMPTY_MAP);
			}
			diagramResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			fail(e.getMessage());
		}

		try {
			return IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), diagramFile, true);
		} catch (PartInitException e) {
			fail(e.getMessage());
		}
		return null;
	}

	private EObject createDiagramDomainObject() {
		GenClass diagramElementGenClass = getSetup().getGenModel().getGenDiagram().getDomainDiagramElement();
		GenPackage domainGenPackage = diagramElementGenClass.getGenPackage();
		Class factoryInterface = null;
		try {
			factoryInterface = getSetup().getGenProject().getBundle().loadClass(domainGenPackage.getQualifiedFactoryInterfaceName());
			assertNotNull("Factory interface not found", factoryInterface);
			Field accessor = null;
			accessor = factoryInterface.getField(domainGenPackage.getFactoryInstanceName());
			assertNotNull("Accessor field not found", accessor);
			Object factory = null;
			factory = accessor.get(null);
			assertNotNull("Factory unavailable", factory);
			Method createMethod = null;
			createMethod = factory.getClass().getMethod("create" + diagramElementGenClass.getName(), new Class[0]);
			assertNotNull("Create method unavailable", createMethod);
			EObject domainDiagramElement = null;
			domainDiagramElement = (EObject) createMethod.invoke(factory, new Object[0]);
			assertNotNull("Domain diagram element was not created", domainDiagramElement);
			return domainDiagramElement;
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		} catch (SecurityException e) {
			fail(e.getMessage());
		} catch (NoSuchFieldException e) {
			fail(e.getMessage());
		} catch (IllegalArgumentException e) {
			fail(e.getMessage());
		} catch (IllegalAccessException e) {
			fail(e.getMessage());
		} catch (NoSuchMethodException e) {
			fail(e.getMessage());
		} catch (InvocationTargetException e) {
			fail(e.getMessage());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		return null;
	}

	private PreferencesHint getpreferencesHint() {
		String pluginClassName = getSetup().getGenModel().getGenDiagram().getEditorGen().getPlugin().getActivatorQualifiedClassName();
		Class pluginClass = null;
		try {
			pluginClass = getSetup().getGenProject().getBundle().loadClass(pluginClassName);
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertNotNull("Plugin class not available", pluginClass);
		Field field = null;
		try {
			field = pluginClass.getField(PREFERENCES_HINT_FIELD);
		} catch (SecurityException e) {
			fail(e.getMessage());
		} catch (NoSuchFieldException e) {
			fail(e.getMessage());
		}
		try {
			return (PreferencesHint) field.get(null);
		} catch (IllegalArgumentException e) {
			fail(e.getMessage());
		} catch (IllegalAccessException e) {
			fail(e.getMessage());
		}
		return null;
	}

}
