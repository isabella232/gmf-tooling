/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.gmf.runtime.emf.core.edit.MEditingDomain;
import org.eclipse.gmf.runtime.emf.core.edit.MRunnable;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

/**
 * @generated
 */
public class TaiPanDiagramEditorUtil extends IDEEditorUtil {

	/**
	 * @generated
	 */
	public static final IFile createAndOpenDiagram(DiagramFileCreator diagramFileCreator, IPath containerPath, String fileName, InputStream initialContents, String kind, IWorkbenchWindow window,
			IProgressMonitor progressMonitor, boolean openEditor, boolean saveDiagram) {
		IFile diagramFile = TaiPanDiagramEditorUtil.createNewDiagramFile(diagramFileCreator, containerPath, fileName, initialContents, kind, window.getShell(), progressMonitor);
		if (diagramFile != null && openEditor) {
			IDEEditorUtil.openDiagram(diagramFile, window, saveDiagram, progressMonitor);
		}
		return diagramFile;
	}

	/**
	 * <p>
	 * This method should be called within a workspace modify operation since it creates resources.
	 * </p>
	 * @generated
	 * @return the created file resource, or <code>null</code> if the file was not created
	 */
	public static final IFile createNewDiagramFile(DiagramFileCreator diagramFileCreator, IPath containerFullPath, String fileName, InputStream initialContents, String kind, Shell shell,
			IProgressMonitor progressMonitor) {
		final MEditingDomain editingDomain = MEditingDomain.createNewDomain();
		final IProgressMonitor progressMonitorCopy = progressMonitor;
		final IFile diagramFile = diagramFileCreator.createNewFile(containerFullPath, fileName, initialContents, shell, new IRunnableContext() {

			public void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable) throws InvocationTargetException, InterruptedException {
				runnable.run(progressMonitorCopy);
			}
		});

		IPath diagramFilePath = diagramFile.getLocation();
		final Resource diagramResource = editingDomain.createResource(diagramFilePath.toOSString());
		IPath modelFilePath = diagramFilePath.removeFileExtension().addFileExtension("taipan"); //$NON-NLS-1$
		final Resource modelResource = editingDomain.createResource(modelFilePath.toOSString());

		if (diagramResource != null && modelResource != null) {
			final String kindParam = kind;
			editingDomain.runAsUnchecked(new MRunnable() {

				public Object run() {
					EObject model = editingDomain.create(TaiPanPackage.eINSTANCE.getAquatory());
					modelResource.getContents().add(model);
					editingDomain.saveResource(modelResource);
					Diagram diagram = ViewService.createDiagram(model, kindParam, TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
					if (diagram != null) {
						diagramResource.getContents().add(diagram);
						diagram.setName(diagramFile.getName());
						diagram.setElement(model);
						editingDomain.saveResource(diagramResource);
					}
					return null;
				}

			});
		}

		return diagramFile;
	}
}
