/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */

package org.eclipse.gmf.examples.mindmap.rcp.part;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapFactory;
import org.eclipse.gmf.examples.mindmap.rcp.view.factories.MapViewFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @generated
 */
public class MindmapCreationWizardPage extends WizardPage {
	/**
	 * @generated
	 */
	private Text fileField;
	/**
	 * @generated
	 */
	private URI myCreatedDiagramFileURI;

	/**
	 * @generated
	 */
	public MindmapCreationWizardPage() {
		super(Messages.MindmapCreationWizardPage_PageName);
		setTitle(Messages.MindmapCreationWizardPage_Title);
		setDescription(Messages.MindmapCreationWizardPage_Description);
	}

	/**
	 * @generated
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}
		Label resourceURILabel = new Label(composite, SWT.LEFT);
		{
			resourceURILabel
					.setText(Messages.MindmapCreationWizardPage_ResourceURILabel);

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			resourceURILabel.setLayoutData(data);
		}

		Composite fileComposite = new Composite(composite, SWT.NONE);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			fileComposite.setLayoutData(data);

			GridLayout layout = new GridLayout();
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.numColumns = 2;
			fileComposite.setLayout(layout);
		}
		fileField = new Text(fileComposite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			data.horizontalSpan = 1;
			fileField.setLayoutData(data);
		}

		fileField.addModifyListener(validator);
		Button resourceURIBrowseFileSystemButton = new Button(fileComposite,
				SWT.PUSH);
		resourceURIBrowseFileSystemButton
				.setText(Messages.MindmapCreationWizardPage_BrowseButtonLabel);

		resourceURIBrowseFileSystemButton
				.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						String fileExtension = "mmd";
						String filePath = MindmapDiagramEditorUtil
								.openFilePathDialog(getShell(),
										"*." + fileExtension, SWT.OPEN); //$NON-NLS-1$
						if (filePath != null) {
							if (!filePath.endsWith("." + fileExtension)) { //$NON-NLS-1$
								filePath += "." + fileExtension; //$NON-NLS-1$
							}
							fileField.setText(filePath);
						}
					}
				});
		setPageComplete(validatePage());
		setControl(composite);
	}

	/**
	 * @generated
	 */
	protected ModifyListener validator = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			setPageComplete(validatePage());
		}
	};

	/**
	 * @generated
	 */
	protected boolean validatePage() {
		URI diagramFileURI = getDiagramFileURI();
		if (diagramFileURI == null || diagramFileURI.isEmpty()) {
			setErrorMessage(null);
			return false;
		}

		if (diagramFileURI.isFile()) {
			File diagramFile = new File(diagramFileURI.toFileString());
			if (diagramFile.exists()) {
				setErrorMessage(MessageFormat.format(
						Messages.MindmapCreationWizardPage_DiagramFileExists,
						new Object[] { diagramFile }));
				return false;
			}
		}
		String requiredExt = "mmd"; //$NON-NLS-1$
		String enteredExt = diagramFileURI.fileExtension();
		if (enteredExt == null || !enteredExt.equals(requiredExt)) {
			setErrorMessage(MessageFormat.format(
					Messages.MindmapCreationWizardPage_IncorrectExtension,
					new Object[] { requiredExt }));
			return false;
		}
		setErrorMessage(null);
		return true;
	}

	/**
	 * @generated
	 */
	public URI getCreatedDiagramFileURI() {
		return myCreatedDiagramFileURI;
	}

	/**
	 * @generated
	 */
	private URI getDiagramFileURI() {
		try {
			return URI.createFileURI(fileField.getText());
		} catch (Exception exception) {
		}
		return null;
	}

	/**
	 * Performs the operations necessary to create and open the diagram
	 * @return boolean indicating whether the creation and opening the Diagram was successful 
	 * @generated
	 */
	public boolean finish() {
		final boolean[] result = new boolean[1];
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				result[0] = doFinish(monitor);
			}
		};

		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
						Messages.MindmapCreationWizardPage_CreationFailed,
						null, // no special message
						((CoreException) e.getTargetException()).getStatus());
			} else {
				// CoreExceptions are handled above, but unexpected runtime exceptions and errors may still occur.
				MindmapDiagramEditorPlugin
						.getInstance()
						.getLog()
						.log(
								new Status(
										IStatus.ERROR,
										MindmapDiagramEditorPlugin.ID,
										0,
										Messages.MindmapCreationWizardPage_CreationFailed,
										e.getTargetException()));
			}
			return false;
		}
		return result[0];
	}

	/**
	 * @param monitor the <code>org.eclipse.core.runtime.IProgressMonitor</code> to use to indicate progress and check for cancellation
	 * @return boolean indicating whether the diagram was created and opened successfully
	 * @generated
	 */
	public boolean doFinish(IProgressMonitor monitor) {
		myCreatedDiagramFileURI = createDiagramFile(monitor);
		return myCreatedDiagramFileURI != null;
	}

	/**
	 * @generated
	 */
	private URI createDiagramFile(IProgressMonitor monitor) {
		TransactionalEditingDomain editingDomain = WorkspaceEditingDomainFactory.INSTANCE
				.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();
		final Resource diagramResource = resourceSet
				.createResource(getDiagramFileURI());

		if (diagramResource != null) {
			((XMLResource) diagramResource).getDefaultSaveOptions().put(
					XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
			((XMLResource) diagramResource).getDefaultLoadOptions().put(
					XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
			AbstractEMFOperation saveOperation = new AbstractEMFOperation(
					editingDomain,
					Messages.MindmapCreationWizardPage_CommandLabel) {
				public IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info) throws ExecutionException {
					monitor.beginTask(
							Messages.MindmapCreationWizardPage_TaskName, 1);
					try {
						Map model = MindmapFactory.eINSTANCE.createMap();
						diagramResource.getContents().add(model);
						Diagram diagram = NotationFactory.eINSTANCE
								.createDiagram();
						diagram.setElement(model);
						MapViewFactory.INSTANCE.decorateView(diagram);
						diagramResource.getContents().add(diagram);
						try {
							diagramResource.save(MindmapDiagramEditorUtil
									.getSaveOptions());
						} catch (IOException e) {
							handleSaveException(e);
						}
						return Status.OK_STATUS;
					} finally {
						monitor.done();
					}
				}
			};
			try {
				saveOperation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				MindmapDiagramEditorPlugin.getInstance().logError(
						"Exception occurred while creating the diagram", e); //$NON-NLS-1$
				return null;
			}
			if (MindmapDiagramEditorUtil.openEditor(getDiagramFileURI()) == null) {
				return null;
			}
			return getDiagramFileURI();
		}
		return null;
	}

	/**
	 * @generated
	 */
	private void handleSaveException(IOException e) throws ExecutionException {
		throw new ExecutionException(
				Messages.MindmapCreationWizardPage_SaveFailed, e);
	}

}
