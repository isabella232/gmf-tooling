package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part;

import java.io.File;
import java.io.IOException;

import java.util.Collections;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.FeatureMap;

import org.eclipse.emf.edit.provider.IWrapperItemProvider;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.MapEditPart;

import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;

import org.eclipse.gmf.runtime.lite.services.IDiagramLayouter;

import org.eclipse.gmf.runtime.notation.Diagram;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;

import org.eclipse.jface.wizard.Wizard;
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

import org.eclipse.ui.IEditorPart;

/**
 * @generated
 */
public class MindmapNewDiagramFileWizard extends Wizard {
	/**
	 * @generated
	 */
	private TransactionalEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private URI mySelectedModelFileURI;

	/**
	 * @generated
	 */
	private DiagramURISelectorPage myDiagramURISelectorPage;

	/**
	 * @generated
	 */
	private EObject myDiagramRoot;

	/**
	 * @generated
	 */
	public MindmapNewDiagramFileWizard(URI selectedModelFileURI,
			EObject diagramRoot, TransactionalEditingDomain editingDomain) {
		assert editingDomain != null : "Null editingDomain in MindmapNewDiagramFileWizard constructor"; //$NON-NLS-1$

		mySelectedModelFileURI = selectedModelFileURI;
		myDiagramRoot = diagramRoot;
		myEditingDomain = editingDomain;
		setDefaultPageImageDescriptor(MindmapDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewMindmapWizard.gif")); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void addPages() {
		if (mySelectedModelFileURI == null) {
			addPage(new SourceURISelectorPage());
		}
		myDiagramURISelectorPage = new DiagramURISelectorPage();
		addPage(myDiagramURISelectorPage);
		addPage(new RootElementSelectorPage());
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		ResourceSet resourceSet = myEditingDomain.getResourceSet();
		URI diagramFileURI = myDiagramURISelectorPage.getNewFileURI();
		final Resource diagramResource = resourceSet
				.createResource(diagramFileURI);
		AbstractCommand command = new AbstractCommand(
				"Initializing diagram contents") { //$NON-NLS-1$
			private Diagram myCreatedDiagram;

			protected boolean prepare() {
				int diagramVID = MindmapVisualIDRegistry.INSTANCE
						.getDiagramVisualID(myDiagramRoot);
				if (diagramVID != MapEditPart.VISUAL_ID) {
					return false;
				}
				return true;
			}

			public void execute() {
				myCreatedDiagram = MindmapDiagramEditorUtil
						.createDiagramFor(myDiagramRoot);
				assert myCreatedDiagram != null;
				diagramResource.getContents().add(myCreatedDiagram);
			}

			public void redo() {
				execute();
			}

			public boolean canUndo() {
				return false;
			}
		};
		try {
			new WrappingCommand(myEditingDomain, command).execute();
			diagramResource.save(Collections.EMPTY_MAP);
			IEditorPart editor = MindmapDiagramEditorUtil
					.openEditor(diagramFileURI);
			if (editor != null) {
				IDiagramLayouter layouter = (IDiagramLayouter) editor
						.getAdapter(IDiagramLayouter.class);
				if (layouter != null) {
					GraphicalViewer graphicalViewer = (GraphicalViewer) editor
							.getAdapter(GraphicalViewer.class);
					if (graphicalViewer != null) {
						Command layoutCommand = layouter
								.layout((GraphicalEditPart) graphicalViewer
										.getContents());
						if (layoutCommand != null && layoutCommand.canExecute()) {
							new WrappingCommand(myEditingDomain, layoutCommand)
									.execute();
						}
					}
				}
			}
		} catch (IOException ex) {
			MindmapDiagramEditorPlugin
					.getInstance()
					.logError(
							"Save operation failed for: " + diagramFileURI.toString(), ex); //$NON-NLS-1$
		}
		return true;
	}

	/**
	 * @generated
	 */
	private abstract class URISelectorPage extends WizardPage {
		/**
		 * @generated
		 */
		private Text fileField;

		/**
		 * @generated
		 */
		protected URISelectorPage(String name) {
			super(name);
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
			Button resourceURIBrowseFileSystemButton = new Button(
					fileComposite, SWT.PUSH);
			resourceURIBrowseFileSystemButton.setText("&Browse");

			resourceURIBrowseFileSystemButton
					.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent event) {
							String fileExtension = getFileExtension();
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
		protected final void setFile(File file) {
			fileField.setText(file.getPath());
		}

		/**
		 * @generated
		 */
		protected boolean validatePage() {
			URI fileURI = getFileURI();
			if (fileURI == null || fileURI.isEmpty()) {
				setErrorMessage(null);
				return false;
			}
			if (fileURI.isFile()) {
				File file = new File(fileURI.toFileString());
				String fileProblem = validateFile(file);
				if (fileProblem != null) {
					setErrorMessage(fileProblem);
					return false;
				}
			}
			String requiredExt = getFileExtension();
			String enteredExt = fileURI.fileExtension();
			if (enteredExt == null || !enteredExt.equals(requiredExt)) {
				setErrorMessage("The file name must end in " + requiredExt);
				return false;
			}
			setErrorMessage(null);
			return true;
		}

		/**
		 * Checks the given file and returns the error message if there are problems or <code>null</code> if the file is OK.
		 * @generated
		 */
		protected abstract String validateFile(File file);

		/**
		 * @generated
		 */
		protected abstract String getFileExtension();

		/**
		 * @generated
		 */
		protected URI getFileURI() {
			try {
				return URI.createFileURI(fileField.getText());
			} catch (Exception exception) {
			}
			return null;
		}
	}

	/**
	 * @generated
	 */
	private class SourceURISelectorPage extends URISelectorPage {
		/**
		 * @generated
		 */
		public SourceURISelectorPage() {
			super("Select source file");
			setTitle("Source file");
			setDescription("Select file with semantic model element to be depicted on diagram");
		}

		/**
		 * @generated
		 */
		protected String getFileExtension() {
			return "mindmap";
		}

		/**
		 * @generated
		 */
		protected boolean validatePage() {
			if (super.validatePage()) {
				mySelectedModelFileURI = getFileURI();
				return true;
			}
			return false;
		}

		/**
		 * @generated
		 */
		protected String validateFile(File file) {
			if (!file.exists()) {
				return "Source file does not exist";
			}
			return null;
		}
	}

	/**
	 * @generated
	 */
	private class DiagramURISelectorPage extends URISelectorPage {
		/**
		 * @generated
		 */
		private URI myNewFileURI;

		/**
		 * @generated
		 */
		public DiagramURISelectorPage() {
			super("Initialize new mmd diagram file");
			setTitle("Diagram file");
			setDescription("Create new diagram based on Mindmap model content");
		}

		/**
		 * @generated
		 */
		protected String getFileExtension() {
			return "mmd";
		}

		/**
		 * @generated
		 */
		public void setVisible(boolean visible) {
			super.setVisible(visible);
			if (visible && mySelectedModelFileURI != null
					&& getFileURI() == null && mySelectedModelFileURI.isFile()) {
				File originalFile = new File(mySelectedModelFileURI
						.toFileString());
				String originalFileName = mySelectedModelFileURI
						.trimFileExtension().lastSegment();
				File parentFile = originalFile.getParentFile();
				File newFile = new File(parentFile, originalFileName
						+ getFileExtension());
				for (int i = 1; i > 0 && newFile.exists(); i++) {
					newFile = new File(parentFile, originalFileName + i
							+ getFileExtension());
				}
				if (newFile.exists()) {
					return; //failed to set name that does not exist, just leave empty.
				}
				setFile(newFile);
			}
		}

		/**
		 * @generated
		 */
		protected boolean validatePage() {
			myNewFileURI = null;
			if (super.validatePage()) {
				myNewFileURI = getFileURI();
				return true;
			}
			return false;
		}

		/**
		 * @generated
		 */
		public URI getNewFileURI() {
			return myNewFileURI;
		}

		/**
		 * @generated
		 */
		protected String validateFile(File file) {
			if (file.exists()) {
				return "Diagram file already exists";
			}
			return null;
		}
	}

	/**
	 * @generated
	 */
	private class RootElementSelectorPage extends WizardPage implements
			ISelectionChangedListener {
		/**
		 * @generated
		 */
		private TreeViewer myTreeViewer;

		/**
		 * @generated
		 */
		protected RootElementSelectorPage() {
			super("Select diagram root element");
			setTitle("Diagram root element");
			setDescription("Select semantic model element to be depicted on diagram");
		}

		/**
		 * @generated
		 */
		public void createControl(Composite parent) {
			initializeDialogUnits(parent);
			Composite topLevel = new Composite(parent, SWT.NONE);
			topLevel.setLayout(new GridLayout());
			topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
					| GridData.HORIZONTAL_ALIGN_FILL));
			topLevel.setFont(parent.getFont());
			setControl(topLevel);
			createModelBrowser(topLevel);
			setPageComplete(validatePage());
		}

		/**
		 * @generated
		 */
		private void createModelBrowser(Composite parent) {
			Composite panel = new Composite(parent, SWT.NONE);
			panel.setLayoutData(new GridData(GridData.FILL_BOTH));
			GridLayout layout = new GridLayout();
			layout.marginWidth = 0;
			panel.setLayout(layout);

			Label label = new Label(panel, SWT.NONE);
			label.setText("Select diagram root element:");
			label.setLayoutData(new GridData(
					GridData.HORIZONTAL_ALIGN_BEGINNING));
			myTreeViewer = new TreeViewer(panel, SWT.SINGLE | SWT.H_SCROLL
					| SWT.V_SCROLL | SWT.BORDER);
			GridData layoutData = new GridData(GridData.FILL_BOTH);
			layoutData.heightHint = 300;
			layoutData.widthHint = 300;
			myTreeViewer.getTree().setLayoutData(layoutData);
			myTreeViewer.setContentProvider(new AdapterFactoryContentProvider(
					MindmapDiagramEditorPlugin.getInstance()
							.getItemProvidersAdapterFactory()));
			myTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(
					MindmapDiagramEditorPlugin.getInstance()
							.getItemProvidersAdapterFactory()));
			myTreeViewer.addSelectionChangedListener(this);
		}

		/**
		 * @generated
		 */
		public void setVisible(boolean visible) {
			if (visible) {
				myTreeViewer.setInput(myEditingDomain.getResourceSet()
						.getResource(mySelectedModelFileURI, true));
				if (myDiagramRoot != null) {
					myTreeViewer.setSelection(new StructuredSelection(
							myDiagramRoot));
				}
			}
			super.setVisible(visible);
		}

		/**
		 * @generated
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			myDiagramRoot = null;
			if (event.getSelection() instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				if (selection.size() == 1) {
					Object selectedElement = selection.getFirstElement();
					if (selectedElement instanceof IWrapperItemProvider) {
						selectedElement = ((IWrapperItemProvider) selectedElement)
								.getValue();
					}
					if (selectedElement instanceof FeatureMap.Entry) {
						selectedElement = ((FeatureMap.Entry) selectedElement)
								.getValue();
					}
					if (selectedElement instanceof EObject) {
						myDiagramRoot = (EObject) selectedElement;
					}
				}
			}
			setPageComplete(validatePage());
		}

		/**
		 * @generated
		 */
		private boolean validatePage() {
			if (myDiagramRoot == null) {
				setErrorMessage("No diagram root element selected");
				return false;
			}
			boolean result = MapEditPart.VISUAL_ID == MindmapVisualIDRegistry.INSTANCE
					.getDiagramVisualID(myDiagramRoot);
			setErrorMessage(result ? null
					: "Invalid diagram root element was selected");
			return result;
		}
	}
}
