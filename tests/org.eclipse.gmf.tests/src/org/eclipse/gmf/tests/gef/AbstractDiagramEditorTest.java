/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.gef;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.gmf.tests.rt.AbstractCanvasTest;
import org.eclipse.gmf.tests.setup.GeneratedDiagramPlugin;
import org.eclipse.gmf.tests.setup.ViewerConfiguration;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Abstract test that operates with open diagram editors instead of fake no-update viewers.
 * Note, distinct subclasses for Full and Lite runtimes are required since 
 * {@link #createViewerConfiguration(EditPartViewer, GeneratedDiagramPlugin)} and
 * {@link #createDiagramView(EObject, GeneratedDiagramPlugin)} need different implementation. 
 */
public abstract class AbstractDiagramEditorTest extends AbstractCanvasTest {
	private IProject myProject;
	private IEditorPart myEditor;
	private IFile myDiagramFile;
	private Boolean mySameModelAndDiagramFile = null;
	private final ViewerConfiguration.Factory myViewerConfigFactory;

	public AbstractDiagramEditorTest(String name, ViewerConfiguration.Factory viewerConfigFactory) {
		super(name);
		assert viewerConfigFactory != null;
		myViewerConfigFactory = viewerConfigFactory;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		myProject = createProject();
		mySameModelAndDiagramFile = null; // use default value (i.e. from gmfgen)
	}
	
	protected IProject getProject() {
		return myProject;
	}
	
	protected IEditorPart getEditor() {
		if (myEditor == null) {
			myEditor = openEditor(getDiagramFile());
			assertNotNull(myEditor);
			assertFalse("Fail fast if not diagram editor is associated with diagram file", "org.eclipse.ui.DefaultTextEditor".equals(myEditor.getEditorSite().getId()));
		}
		return myEditor;
	}
	private IFile getDiagramFile() {
		if (myDiagramFile == null) {
			myDiagramFile = createDiagramFile();
		}
		return myDiagramFile;
	}

	@Override
	protected ViewerConfiguration createViewerConfiguration() {
		IEditorPart editorPart = getEditor();
		GraphicalViewer viewer = (GraphicalViewer) editorPart.getAdapter(GraphicalViewer.class);
		return getViewerConfigurationFactory().createViewerConfiguration(viewer, getSetup());
	}
	
	protected final ViewerConfiguration.Factory getViewerConfigurationFactory() {
		return myViewerConfigFactory;
	}
	
	@Override
	protected void tearDown() throws Exception {
		if (myEditor != null) {
			closeEditor(myEditor);
			myEditor = null;
		}
		// keep project alive for potential workspace investigations
		// deleteProject();
		myProject = null;
		myDiagramFile = null;
		super.tearDown();
	}

	protected static void closeEditor(IEditorPart editor) {
		editor.doSave(new NullProgressMonitor());
		Utils.assertDispatchDisplayMessages(3);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editor, true);
	}
	
	protected IProject createProject() {
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
	
	protected void deleteProject() throws CoreException {
		if (myProject != null) {
			if (getProject().isOpen()) {
				getProject().close(new NullProgressMonitor());
			}
			if (getProject().exists()) {
				getProject().delete(true, new NullProgressMonitor());
			}
		}
	}

	/**
	 * Unless invoked, default value from gmfgen model will be used.
	 * Note, should be called prior to any #getEditor() or #getDiagram() call
	 */
	protected final void useSameFileForDiagramAndModel(boolean sameFile) {
		assertNull("Can't use this method after diagram file has been created", myDiagramFile);
		mySameModelAndDiagramFile = Boolean.valueOf(sameFile);
	}

	private IFile createDiagramFile() {
		boolean sameFileForDiagramAndModel;
		if (mySameModelAndDiagramFile != null) {
			sameFileForDiagramAndModel = mySameModelAndDiagramFile.booleanValue();
		} else {
			sameFileForDiagramAndModel = getSetup().getGenDiagram().getEditorGen().isSameFileForDiagramAndModel();
		}
		// use test name for diagram file name since there should be no more than one diagram file per test 
		// and it's easier to analyze test contents with meaningful names 
		EObject domainElement = createDiagramDomainObject(getSetup());
		Diagram diagramView = createDiagramView(domainElement, getSetup());
		assertNotNull("Diagram was not created", diagramView);
		assertSame(domainElement, diagramView.getElement());
		return createDiagramFile(getProject(), getName(), getSetup().getGenDiagram(), domainElement, diagramView, sameFileForDiagramAndModel);
	}
	
	// XXX full and lite runtimes now need different initialization steps (unless we have common createDiagram code in e.g. DiagramEditorUtil 
	protected abstract Diagram createDiagramView(EObject domainElement, GeneratedDiagramPlugin genPlugin);

	private static IFile createDiagramFile(IProject where, String fileNameStem, GenDiagram genDiagram, EObject domainElement, Diagram diagramView, boolean storeModelInDiagramFile) {
		final String diagramFileName = fileNameStem + "." + genDiagram.getEditorGen().getDiagramFileExtension();
		IFile diagramFile = where.getFile(diagramFileName);
		assertFalse("Diagram file was already created", diagramFile.exists());

		IFile modelFile = null;
		if (!storeModelInDiagramFile) {
			IPath diagramFilePath = diagramFile.getProjectRelativePath();
			IPath modelFilePath = diagramFilePath.removeFileExtension().addFileExtension(genDiagram.getEditorGen().getDomainFileExtension());	
			modelFile = where.getFile(modelFilePath);
			assertFalse("Model file was already created", modelFile.exists());
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFile.getFullPath().toOSString(), true), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		Resource modelResource = modelFile != null ? resourceSet.createResource(URI.createPlatformResourceURI(modelFile.getFullPath().toOSString(), true), ContentHandler.UNSPECIFIED_CONTENT_TYPE) : null;		
		

		if (modelResource != null) {
			modelResource.getContents().add(domainElement);
		} else {
			diagramResource.getContents().add(domainElement);
		}
		assertSame("[sanity]", domainElement, diagramView.getElement());
		diagramResource.getContents().add(diagramView);
		diagramView.setName(fileNameStem);
		try {
			if (modelResource != null) {
				modelResource.save(Collections.EMPTY_MAP);
			}
			diagramResource.save(Collections.EMPTY_MAP);
		} catch (Exception e) {
			fail(e.toString());
		}
		return diagramFile;
	}

	protected static EObject createDiagramDomainObject(GeneratedDiagramPlugin genPlugin) {
		try {
			GenClass diagramElementGenClass = genPlugin.getGenDiagram().getDomainDiagramElement();
			GenPackage domainGenPackage = diagramElementGenClass.getGenPackage();
			Class<?> factoryInterface = genPlugin.loadGeneratedClass(domainGenPackage.getQualifiedFactoryInterfaceName());
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
		} catch (Exception ex) {
			fail(ex.toString());
		}
		return null;
	}

	protected IEditorPart openEditor(IFile diagramFile) {
		try {
	        IEditorDescriptor editorDesc = IDE.getEditorDescriptor(diagramFile, true);
	        IEditorPart result = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new FileEditorInput(diagramFile), editorDesc.getId(), true);
	        return result;
		} catch (PartInitException e) {
			fail(e.getMessage());
		}
		return null;
	}

	protected final String getUniqueString() {
		return "AbstractDiagramEditorTest_" + String.valueOf(System.currentTimeMillis());
	}
}
