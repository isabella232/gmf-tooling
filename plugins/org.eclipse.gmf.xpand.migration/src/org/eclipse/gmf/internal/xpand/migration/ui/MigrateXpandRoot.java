/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.migration.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.gmf.internal.xpand.RootManager;
import org.eclipse.gmf.internal.xpand.build.WorkspaceResourceManager;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.migration.Activator;
import org.eclipse.gmf.internal.xpand.migration.MigrationException;
import org.eclipse.gmf.internal.xpand.migration.XpandMigrationFacade;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.gmf.internal.xpand.xtend.ast.XtendResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class MigrateXpandRoot implements IObjectActionDelegate {

	private static final String CHARSET = "ISO-8859-1";

	private static final String MIGRATED_ROOT_EXTENSION = "migrated";

	private IContainer selectedContainer;

	private RootManager rootManager;

	private IWorkbenchPart workbenchPart;

	private static IFolder getOutputFolder(IContainer selectedContainer) {
		IContainer parent = selectedContainer.getParent();
		IPath relativePathBasis = selectedContainer.getProjectRelativePath().removeFirstSegments(parent.getProjectRelativePath().segmentCount());
		IPath relativePath = relativePathBasis.addFileExtension(MIGRATED_ROOT_EXTENSION);
		for (int i = 0; parent.getFolder(relativePath).exists(); i++) {
			relativePath = relativePathBasis.addFileExtension(MIGRATED_ROOT_EXTENSION + i);
		}
		return parent.getFolder(relativePath);
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		workbenchPart = targetPart;
	}

	public void run(IAction action) {
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				monitor.setTaskName("Migrating Xpand Resources");
				monitor.beginTask("Migrating Xpand Resources", 102);
				int totalNumberOfFiles = calculateFiles(selectedContainer);
				monitor.worked(1);
				IFolder newFolder = getOutputFolder(selectedContainer);
				monitor.worked(1);
				IProgressMonitor subProgressMonitor = createSubProgressMonitor(monitor, null, 100);
				subProgressMonitor.beginTask("Migrating Xpand Resources", totalNumberOfFiles);
				try {
					selectedContainer.accept(new MigrationVisitor(selectedContainer.getProjectRelativePath(), newFolder, subProgressMonitor));
				} catch (CoreException e) {
					Throwable cause = e.getCause();
					if (cause instanceof InterruptedException) {
						throw (InterruptedException) cause;
					} else if (cause instanceof MigrationException) {
						throw new InvocationTargetException(cause);
					} else if (cause instanceof UnsupportedEncodingException) {
						throw new InvocationTargetException(cause);
					} else {
						throw e;
					}
				}
				monitor.done();
			}
		};

		try {
			new ProgressMonitorDialog(getShell()).run(true, true, op);
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			if (cause instanceof MigrationException) {
				reportMigrationException((MigrationException) cause);
			} else if (cause instanceof UnsupportedEncodingException) {
				showError("Unsupported encoding", "Specified encoding \"" + CHARSET + "\" is not supported by the platform: " + cause.getMessage());
			} else {
				showError("Invocation target exception", e.getMessage());
			}
		} catch (InterruptedException e) {
		}
	}

	protected IProgressMonitor createSubProgressMonitor(IProgressMonitor monitor, String taskName, int numberOfTicks) throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException("Process was canceled");
		}
		SubProgressMonitor spm = new SubProgressMonitor(monitor, numberOfTicks);
		if (taskName != null) {
			spm.setTaskName(taskName);
		}
		return spm;
	}

	private int calculateFiles(IContainer container) throws CoreException {
		CalculateFileNumberVisitor visitor = new CalculateFileNumberVisitor();
		container.accept(visitor);
		return visitor.getNumberOfFiles();
	}

	private void reportMigrationException(MigrationException e) {
		switch (e.getType()) {
		case ANALYZATION_PROBLEMS:
			StringBuilder sb = new StringBuilder("Following analyzation problems present:\n\n");
			for (AnalysationIssue issue : e.getIssues()) {
				sb.append(issue.toString());
				sb.append("\n");
			}
			showError("Unable to load xtend resource", sb.toString());
			return;
		default:
			showError("Migration exception", "Migration exception appears:\n" + e.getMessage());
		}
	}

	private void showError(String title, String contents) {
		MessageDialog.openError(getShell(), title, contents);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof IContainer) {
				selectedContainer = (IContainer) structuredSelection.getFirstElement();
				rootManager = new RootManager(selectedContainer.getProject());
				action.setEnabled(rootManager.isTemplateRoot(selectedContainer));
				return;
			}
		}
		action.setEnabled(false);
	}

	private Shell getShell() {
		return workbenchPart.getSite().getShell();
	}

	private abstract class AbstractMigrationVisitor implements IResourceVisitor {

		public boolean visit(IResource resource) throws CoreException {
			if (resource.getType() == IResource.PROJECT) {
				return true;
			}
			if (resource instanceof IFolder) {
				visitFolder((IFolder) resource);
				return true;
			}
			if (resource instanceof IFile) {
				String extension = resource.getProjectRelativePath().getFileExtension();
				if (XpandResource.TEMPLATE_EXTENSION.equals(extension)) {
					visitXpandResource((IFile) resource);
				} else if (XtendResource.FILE_EXTENSION.equals(extension)) {
					visitXtendResource((IFile) resource);
				}
			}
			return false;
		}

		protected abstract void visitXtendResource(IFile resource) throws CoreException;

		protected abstract void visitXpandResource(IFile resource) throws CoreException;

		protected abstract void visitFolder(IFolder resource) throws CoreException;

	}

	private class CalculateFileNumberVisitor extends AbstractMigrationVisitor {

		private int numberOfFiles = 0;

		public int getNumberOfFiles() {
			return numberOfFiles;
		}

		@Override
		protected void visitFolder(IFolder resource) {
			numberOfFiles++;
		}

		@Override
		protected void visitXpandResource(IFile resource) {
			numberOfFiles++;
		}

		@Override
		protected void visitXtendResource(IFile resource) {
			numberOfFiles++;
		}

	}

	private class MigrationVisitor extends AbstractMigrationVisitor {

		private int srcPathSegmentCount;

		private IFolder dstFolder;

		private IProgressMonitor progressMonitor;

		public MigrationVisitor(IPath srcContainerPath, IFolder dstFolder, IProgressMonitor progressMonitor) {
			srcPathSegmentCount = srcContainerPath.segmentCount();
			this.dstFolder = dstFolder;
			this.progressMonitor = progressMonitor;
		}

		private IPath getRelativePath(IResource resource) {
			return resource.getProjectRelativePath().removeFirstSegments(srcPathSegmentCount);
		}

		private InputStream migrateXtendResource(IFile srcFile) throws CoreException {
			return new ByteArrayInputStream(new byte[0]);
			// String templateFullName =
			// rootManager.getTemplateFullName(srcFile);
			// WorkspaceResourceManager resourceManager =
			// rootManager.getResourceManager(srcFile);
			// XtendMigrationFacade migrationFacade = new
			// XtendMigrationFacade(resourceManager, templateFullName);
			// try {
			// StringBuilder qvtoResourceContent =
			// migrationFacade.migrateXtendResource();
			// return new
			// ByteArrayInputStream(qvtoResourceContent.toString().getBytes(CHARSET));
			// } catch (MigrationException ex) {
			// throw createCoreException(ex);
			// } catch (UnsupportedEncodingException ex) {
			// throw createCoreException(ex);
			// }
		}

		private InputStream migrateXpandResource(IFile srcFile) throws CoreException {
			String templateFullName = rootManager.getTemplateFullName(srcFile);
			WorkspaceResourceManager resourceManager = rootManager.getResourceManager(srcFile);
			XpandMigrationFacade migrationFacade = new XpandMigrationFacade(resourceManager, templateFullName, false);
			try {
				String updatedResourceContent = migrationFacade.migrateXpandResource();
				return new ByteArrayInputStream(updatedResourceContent.getBytes(CHARSET));
			} catch (MigrationException ex) {
				throw createCoreException(ex);
			} catch (UnsupportedEncodingException ex) {
				throw createCoreException(ex);
			}
		}

		private CoreException createCoreException(Throwable th) {
			return new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Exception during migration", th));
		}

		@Override
		protected void visitFolder(IFolder resource) throws CoreException {
			try {
				IPath relativePath = getRelativePath(resource);
				IFolder folder = dstFolder.getFolder(relativePath);
				folder.create(true, true, createSubProgressMonitor(progressMonitor, "Migrating " + resource.getProjectRelativePath().toString(), 1));
				if (relativePath.isEmpty()) {
					folder.setDefaultCharset(CHARSET, null);
				}
			} catch (InterruptedException e) {
				throw createCoreException(e);
			}
		}

		@Override
		protected void visitXpandResource(IFile resource) throws CoreException {
			try {
				dstFolder.getFile(getRelativePath(resource)).create(migrateXpandResource(resource), true,
						createSubProgressMonitor(progressMonitor, "Migrating " + resource.getProjectRelativePath().toString(), 1));
			} catch (InterruptedException e) {
				throw createCoreException(e);
			}
		}

		@Override
		protected void visitXtendResource(IFile resource) throws CoreException {
			try {
				dstFolder.getFile(getRelativePath(resource).removeFileExtension().addFileExtension(MigrateXtendResource.QVTO_EXTENSION)).create(migrateXtendResource(resource), true,
						createSubProgressMonitor(progressMonitor, "Migrating " + resource.getProjectRelativePath().toString(), 1));
			} catch (InterruptedException e) {
				throw createCoreException(e);
			}
		}

	}

}
