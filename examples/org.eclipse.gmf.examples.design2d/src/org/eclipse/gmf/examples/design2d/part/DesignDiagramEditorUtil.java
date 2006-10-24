/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.design2d.part;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.core.runtime.CoreException;

import org.eclipse.gmf.examples.design2d.edit.parts.Design2DEditPart;

import org.eclipse.ui.ide.IDE;

/**
 * @generated
 */
public class DesignDiagramEditorUtil {

	/**
	 * @generated
	 */
	public static final URI createAndOpenDiagram(IPath containerPath, String fileName, IWorkbenchWindow window, IProgressMonitor progressMonitor, boolean openEditor, boolean saveDiagram) {
		IFile diagramFile = createNewDiagramFile(containerPath, fileName, window.getShell(), progressMonitor);
		if (diagramFile != null && openEditor) {
			openDiagramEditor(window, diagramFile, saveDiagram, progressMonitor);
		}
		return URI.createPlatformResourceURI(diagramFile.getFullPath().toString());
	}

	/**
	 * @generated
	 */
	public static final IEditorPart openDiagramEditor(IWorkbenchWindow window, IFile file, boolean saveDiagram, IProgressMonitor progressMonitor) {
		IEditorPart editorPart = null;
		try {
			IWorkbenchPage page = window.getActivePage();
			if (page != null) {
				editorPart = openDiagramEditor(page, file);
				if (saveDiagram) {
					editorPart.doSave(progressMonitor);
				}
			}
			file.refreshLocal(IResource.DEPTH_ZERO, null);
			return editorPart;
		} catch (Exception e) {
			DesignDiagramEditorPlugin.getInstance().logError("Error opening diagram", e);
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final IEditorPart openDiagramEditor(IWorkbenchPage page, IFile file) throws PartInitException {
		return IDE.openEditor(page, file);
	}

	/**
	 * <p>
	 * This method should be called within a workspace modify operation since it creates resources.
	 * </p>
	 * @generated
	 * @return the created file resource, or <code>null</code> if the file was not created
	 */
	public static final IFile createNewDiagramFile(IPath containerFullPath, String fileName, Shell shell, IProgressMonitor progressMonitor) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();
		progressMonitor.beginTask("Creating diagram and model files", 3); //$NON-NLS-1$
		final IFile diagramFile = DesignDiagramFileCreator.createNewFile(containerFullPath, fileName, shell);
		final Resource diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFile.getFullPath().toString()));
		List affectedFiles = new ArrayList();
		affectedFiles.add(diagramFile);
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, "Creating diagram and model", affectedFiles) { //$NON-NLS-1$

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Diagram diagram = ViewService.createDiagram(Design2DEditPart.MODEL_ID, DesignDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				if (diagram != null) {
					diagramResource.getContents().add(diagram);
					diagram.setName(diagramFile.getName());
				}
				try {
					diagramResource.save(Collections.EMPTY_MAP);
				} catch (IOException e) {

					DesignDiagramEditorPlugin.getInstance().logError("Unable to store model and diagram resources", e); //$NON-NLS-1$
				}
				return CommandResult.newOKCommandResult();
			}
		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new SubProgressMonitor(progressMonitor, 1), null);
		} catch (ExecutionException e) {
			DesignDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
		}

		try {
			diagramFile.setCharset("UTF-8", new SubProgressMonitor(progressMonitor, 1)); //$NON-NLS-1$
		} catch (CoreException e) {
			DesignDiagramEditorPlugin.getInstance().logError("Unable to set charset for diagram file", e); //$NON-NLS-1$
		}

		return diagramFile;
	}
}
