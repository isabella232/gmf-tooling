package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part;

import java.io.File;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;

import org.eclipse.gmf.examples.mindmap.DocumentRoot;
import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapFactory;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.MapViewFactory;

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
	private URI createdDiagramFileURI;

	/**
	 * @generated
	 */
	public MindmapCreationWizardPage() {
		super("CreationWizardPage"); //$NON-NLS-1$
		setTitle("Create Mindmap Diagram"); //$NON-NLS-1$
		setDescription("Create a new Mindmap diagram."); //$NON-NLS-1$
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
			resourceURILabel.setText("&File");

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
		resourceURIBrowseFileSystemButton.setText("&Browse");

		resourceURIBrowseFileSystemButton
				.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						String fileExtension = "mmd";
						String filePath = MindmapDiagramEditorUtil
								.openFilePathDialog(getShell(), "*."
										+ fileExtension, SWT.OPEN);
						if (filePath != null) {
							if (!filePath.endsWith("." + fileExtension)) {
								filePath = filePath + "." + fileExtension;
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
				setErrorMessage("Diagram File already exists: " + diagramFile);
				return false;
			}
		}
		String requiredExt = "mmd";
		String enteredExt = diagramFileURI.fileExtension();
		if (enteredExt == null || !enteredExt.equals(requiredExt)) {
			setErrorMessage("The file name must end in " + requiredExt);
			return false;
		}
		URI modelFileURI = getModelFileURI();
		File modelFile = new File(modelFileURI.toFileString());
		if (modelFile.exists()) {
			setErrorMessage("Model File already exists: " + modelFile);
			return false;
		}
		setErrorMessage(null);
		return true;
	}

	/**
	 * @generated
	 */
	public URI getCreatedDiagramFileURI() {
		return createdDiagramFileURI;
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
	 * @generated
	 */
	private URI getModelFileURI() {
		URI diagramFileURI = getDiagramFileURI();
		if (diagramFileURI == null) {
			return null;
		}
		return diagramFileURI.trimFileExtension()
				.appendFileExtension("mindmap");
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
						"Creation Problems", null, // no special message
						((CoreException) e.getTargetException()).getStatus());
			} else {
				// CoreExceptions are handled above, but unexpected runtime exceptions and errors may still occur.
				MindmapDiagramEditorPlugin.getInstance().getLog().log(
						new Status(IStatus.ERROR,
								MindmapDiagramEditorPlugin.ID, 0,
								"Creation failed", e.getTargetException()));
			}
			return false;
		}
		return result[0];
	}

	/**
	 * @param monitor the <code>IProgressMonitor</code> to use to indicate progress and check for cancellation
	 * @return boolean indicating whether the diagram was created and opened successfully
	 * @generated
	 */
	public boolean doFinish(IProgressMonitor monitor) {
		createdDiagramFileURI = createDiagramFile(monitor);
		return createdDiagramFileURI != null;
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
		final Resource modelResource = resourceSet
				.createResource(getModelFileURI());

		if (diagramResource != null && modelResource != null) {
			AbstractEMFOperation saveOperation = new AbstractEMFOperation(
					editingDomain, "Create diagram") {
				public IStatus doExecute(IProgressMonitor monitor,
						IAdaptable info) throws ExecutionException {
					Map model = MindmapFactory.eINSTANCE.createMap();
					modelResource.getContents().add(createInitialRoot(model));
					try {
						modelResource.save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						handleSaveException(e);
					}
					Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
					diagram.setElement(model);
					MapViewFactory.INSTANCE.decorateView(diagram);
					diagramResource.getContents().add(diagram);
					try {
						diagramResource.save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						handleSaveException(e);
					}
					return Status.OK_STATUS;
				}
			};
			try {
				saveOperation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				MindmapDiagramEditorPlugin.getInstance().logError(
						"exception occurred while creating the diagram", e);
				return null;
			}
		}
		boolean result = MindmapDiagramEditorUtil
				.openEditor(getDiagramFileURI()) != null;
		if (!result) {
			return null;
		}
		return getDiagramFileURI();
	}

	/**
	 * @generated
	 */
	private static EObject createInitialRoot(Map model) {
		DocumentRoot docRoot = MindmapFactory.eINSTANCE.createDocumentRoot();
		docRoot.setMap(model);
		return docRoot;
	}

	/**
	 * @generated
	 */
	private void handleSaveException(IOException e) throws ExecutionException {
		throw new ExecutionException("Save failed", e);
	}
}
