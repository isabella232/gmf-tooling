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

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.gmf.internal.xpand.RootManager;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.migration.MigrationException;
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
				int totalNumberOfFiles = calculateFiles(selectedContainer, new SubProgressMonitor(monitor, 1));
				IFolder newFolder = getOutputFolder(selectedContainer);
				monitor.worked(1);
				IProgressMonitor subProgressMonitor = createSubProgressMonitor(monitor, null, 100);
				subProgressMonitor.beginTask("Migrating Xpand Resources", totalNumberOfFiles);
				try {
					selectedContainer.accept(new MigrationVisitor(selectedContainer, newFolder, rootManager, subProgressMonitor));
				} catch (CoreException e) {
					Throwable cause = e.getCause();
					if (cause instanceof InterruptedException) {
						throw (InterruptedException) cause;
					} else if (cause instanceof XpandResourceMigrationException) {
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
			if (cause instanceof XpandResourceMigrationException) {
				reportMigrationException((XpandResourceMigrationException) cause);
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

	private int calculateFiles(IContainer container, SubProgressMonitor monitor) throws CoreException {
		ResourceCountingVisitor visitor = new ResourceCountingVisitor(monitor);
		container.accept(visitor);
		monitor.done();
		return visitor.getNumberOfFiles();
	}

	private void reportMigrationException(XpandResourceMigrationException ex) {
		MigrationException migrationException = ex.getMigrationException();
		StringBuilder sb = new StringBuilder(ex.getTemplateFile().getProjectRelativePath().toString());
		sb.append(" migration error\n");
		switch (migrationException.getType()) {
		case ANALYZATION_PROBLEMS:
			sb.append("Following analyzation problems present:\n\n");
			for (AnalysationIssue issue : migrationException.getIssues()) {
				sb.append(issue.toString());
				sb.append("\n");
			}
			showError("Unable to load xtend resource", sb.toString());
			return;
		default:
			showError("Migration exception", sb.append(migrationException.getMessage()).toString());
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

}
