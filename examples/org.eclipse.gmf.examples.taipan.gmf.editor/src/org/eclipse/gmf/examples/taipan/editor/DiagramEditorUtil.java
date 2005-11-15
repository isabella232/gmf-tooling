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
package org.eclipse.gmf.examples.taipan.editor;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.DiagramUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.gmf.runtime.emf.core.edit.MRunnable;
import org.eclipse.gmf.runtime.emf.core.util.EObjectUtil;
import org.eclipse.gmf.runtime.emf.core.util.OperationUtil;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

/**
 * @generated
 */
public class DiagramEditorUtil extends IDEEditorUtil {

	/**
	 * @generated
	 */
	public static final IFile createAndOpenDiagram(DiagramFileCreator diagramFileCreator, IPath containerPath, String fileName,
			InputStream initialContents, String kind, IWorkbenchWindow window, IProgressMonitor progressMonitor,
			boolean openEditor, boolean saveDiagram) {

		IFile diagramFile = DiagramEditorUtil.createNewDiagramFile(diagramFileCreator, containerPath, fileName,
				initialContents, kind, window.getShell(), progressMonitor);
		if (diagramFile != null && openEditor) {
			IDEEditorUtil.openDiagram(diagramFile, window, saveDiagram, progressMonitor);
		}
		return diagramFile;
	}

	/**
	 * Creates a new diagram file resource in the selected container and with
	 * the selected name. Creates any missing resource containers along the
	 * path; does nothing if the container resources already exist.
	 * <p>
	 * In normal usage, this method is invoked after the user has pressed Finish
	 * on the wizard; the enablement of the Finish button implies that all
	 * controls on on this page currently contain valid values.
	 * </p>
	 * <p>
	 * Note that this page caches the new file once it has been successfully
	 * created; subsequent invocations of this method will answer the same file
	 * resource without attempting to create it again.
	 * </p>
	 * <p>
	 * This method should be called within a workspace modify operation since it
	 * creates resources.
	 * </p>
	 * 
	 * @generated
	 * @return the created file resource, or <code>null</code> if the file was
	 *         not created
	 */
	public static final IFile createNewDiagramFile(DiagramFileCreator diagramFileCreator, IPath containerFullPath,
			String fileName, InputStream initialContents, String kind, Shell shell, IProgressMonitor progressMonitor) {

		final IProgressMonitor progressMonitorParam = progressMonitor;
		final IFile newDiagramFile = diagramFileCreator.createNewFile(containerFullPath, fileName, initialContents, shell,
				new IRunnableContext() {

					public void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable)
							throws InvocationTargetException, InterruptedException {
						runnable.run(progressMonitorParam);
					}
				});
		IPath modelFilePath = newDiagramFile.getLocation().removeFileExtension();
		modelFilePath = modelFilePath.addFileExtension("taipan"); //$NON-NLS-1$
		final Resource modelResource = ResourceUtil.create(modelFilePath.toOSString(), null);
		Resource notationModel = null;
		try {
			newDiagramFile.refreshLocal(IResource.DEPTH_ZERO, null);
			String completeFileName = newDiagramFile.getLocation().toOSString();
			notationModel = ResourceUtil.create(completeFileName, null);
		} catch (Exception e) {
			IStatus status = new Status(IStatus.ERROR, TaiPanDiagramEditorPlugin.ID, 0, e.getMessage(), e);
			TaiPanDiagramEditorPlugin.getInstance().getLog().log(status);
		}

		if (notationModel != null) {
			final Resource notationModelParam = notationModel;
			final String kindParam = kind;
			OperationUtil.runAsUnchecked(new MRunnable() {

				public Object run() {
					EObject model = EObjectUtil.create(TaiPanPackage.eINSTANCE.getAquatory());
					Diagram diagram = DiagramUtil.createDiagram(model, kindParam, new PreferencesHint(
							TaiPanDiagramEditorPlugin.EDITOR_ID));
					if (diagram != null) {
						notationModelParam.getContents().add(diagram);
						modelResource.getContents().add(model);
						ResourceUtil.save(modelResource);
						diagram.setName(newDiagramFile.getName());
						diagram.setElement(model);
						ResourceUtil.save(notationModelParam);
					}
					return null;
				}
			});
		}

		return newDiagramFile;
	}
}
