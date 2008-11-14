package org.eclipse.gmf.examples.mindmap.diagram.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import org.eclipse.amalgam.examples.mindmap.Map;
import org.eclipse.amalgam.examples.mindmap.MindmapFactory;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.examples.mindmap.diagram.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;

public class MindmapDiagramEditorUtil extends IDEEditorUtil {

	public static final IFile createAndOpenDiagram(DiagramFileCreator diagramFileCreator,
			IPath containerPath, String fileName, InputStream initialContents, String kind,
			IWorkbenchWindow dWindow, IProgressMonitor progressMonitor, boolean openEditor,
			boolean saveDiagram, String semanticResourcePath) {
		final IFile newFile = createNewDiagramFile(diagramFileCreator, containerPath, fileName,
				initialContents, kind, dWindow.getShell(), progressMonitor, semanticResourcePath);
		if (newFile != null && openEditor) {
			// Call the utility method for opening diagrams
			IDEEditorUtil.openDiagram(newFile, dWindow, saveDiagram, progressMonitor);
		}
		return newFile;
	}

	public static final IFile createNewDiagramFile(DiagramFileCreator diagramFileCreator,
			IPath containerFullPath, String fileName, InputStream initialContents,
			final String kind, Shell shell, final IProgressMonitor progressMonitor,
			final String semanticResourcePath) {
		// Use our custom file creator to create the diagram (.mmd) file
		final IFile newDiagramFile = diagramFileCreator.createNewFile(containerFullPath, fileName,
				initialContents, shell, new IRunnableContext() {
					public void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable)
							throws InvocationTargetException, InterruptedException {
						runnable.run(progressMonitor);
					}
				});

		// Create new TransactionalEditingDomain and obtain resource set
		final TransactionalEditingDomain domain = GMFEditingDomainFactory.getInstance()
				.createEditingDomain();
		final ResourceSet resourceSet = domain.getResourceSet();
		// Use AbstractEMFOperation to create model using our editing domain
		final AbstractEMFOperation op = new AbstractEMFOperation(domain, Messages
				.getString("MindmapDiagramEditorUtil.NewDiagramOperation")) { //$NON-NLS-1$
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				IFile semanticFile = null;
				boolean semanticFileIsNew = false;
				// If splitting semantic (domain) and diagram into separate files, create
				if (semanticResourcePath != null && semanticResourcePath.length() > 0) {
					semanticFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
							new Path(semanticResourcePath));
					if (!semanticFile.exists()) {
						semanticFileIsNew = true;
						try {
							semanticFile.create(new ByteArrayInputStream(new byte[0]), false,
									progressMonitor);
						} catch (CoreException e) {
							Log.error(MindmapDiagramEditorPlugin.getInstance(), IStatus.ERROR, e
									.getMessage(), e);
							return null;
						}
					}
				}
				Resource notationModel = null;
				Map semanticModel = null;

				try {
					newDiagramFile.refreshLocal(IResource.DEPTH_ZERO, null);
					if (semanticFile != null) {
						semanticFile.refreshLocal(IResource.DEPTH_ZERO, null);
					}
					InputStream stream = newDiagramFile.getContents();
					final String completeFileName = newDiagramFile.getLocation().toOSString();
					try {
						// Create diagram file
						notationModel = resourceSet.createResource(URI
								.createFileURI(completeFileName));
						if (semanticFileIsNew) {
							// Create model root (Map), if new/separate domain file
							semanticModel = MindmapFactory.eINSTANCE.createMap();
							Resource semanticResource = resourceSet.createResource(URI
									.createPlatformResourceURI(semanticResourcePath, true));
							semanticResource.getContents().add(semanticModel);
						} else if (semanticFile != null) {
							semanticModel = (Map) resourceSet.getResource(
											URI.createPlatformResourceURI(semanticResourcePath,
													true), true).getContents().get(0);
						}
					} finally {
						stream.close();
					}

				} catch (Exception e) {
					Trace.catching(
						MindmapDiagramEditorPlugin.getInstance(),
						"", MindmapDiagramEditorUtil.class, Messages.getString("MindmapDiagramEditorUtil.ErrorSavingDiagram"), //$NON-NLS-1$ //$NON-NLS-2$
						e);
				}
				if (notationModel != null) {
					if (semanticModel == null) {
						semanticModel = MindmapFactory.eINSTANCE.createMap();
						notationModel.getContents().add(semanticModel);
					}
					Diagram view = ViewService.createDiagram(semanticModel, kind,
							new PreferencesHint(MindmapDiagramEditorPlugin.ID));
					if (view != null) {
						notationModel.getContents().add(0, view);
						view.getDiagram().setName(newDiagramFile.getName());
					}
					try {
						notationModel.save(Collections.EMPTY_MAP);
						semanticModel.eResource().save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						Trace.catching(
							MindmapDiagramEditorPlugin.getInstance(),
							"", MindmapDiagramEditorUtil.class, Messages.getString("MindmapDiagramEditorUtil.ErrorSavingDiagram"), e); //$NON-NLS-1$ //$NON-NLS-2$
						Log.error(MindmapDiagramEditorPlugin.getInstance(), IStatus.ERROR, e
								.getLocalizedMessage());
					}
				}
				return Status.OK_STATUS;
			}
		};
		try {
			op.execute(new NullProgressMonitor(), null);
		} catch (final ExecutionException e) {
			Trace.catching(
				MindmapDiagramEditorPlugin.getInstance(),
				"", MindmapDiagramEditorUtil.class, Messages.getString("MindmapDiagramEditorUtil.ErrorCreatingDiagram"), e); //$NON-NLS-1$ //$NON-NLS-2$
			Log.error(MindmapDiagramEditorPlugin.getInstance(), IStatus.ERROR, e
					.getLocalizedMessage());
		}
		return newDiagramFile;
	}

}
