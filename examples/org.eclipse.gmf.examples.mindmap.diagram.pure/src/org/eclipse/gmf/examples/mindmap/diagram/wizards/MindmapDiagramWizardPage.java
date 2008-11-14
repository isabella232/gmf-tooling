package org.eclipse.gmf.examples.mindmap.diagram.wizards;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.examples.mindmap.diagram.editor.MindmapDiagramEditor;
import org.eclipse.gmf.examples.mindmap.diagram.util.MindmapDiagramEditorUtil;
import org.eclipse.gmf.examples.mindmap.diagram.util.MindmapDiagramFileCreator;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

public class MindmapDiagramWizardPage extends EditorWizardPage {

	private Button separateSemantics;
	private Text semanticResource;

	public MindmapDiagramWizardPage(IWorkbench aWorkbench, IStructuredSelection selection) {
		super("MindmapDiagramPage", aWorkbench, selection); //$NON-NLS-1$
		this.setTitle(Messages.getString("MindmapDiagramWizardPage.NewMindmapDiagramWizardTitle")); //$NON-NLS-1$
		this.setDescription(Messages.getString("MindmapDiagramWizardPage.NewDiagramWizardDescription")); //$NON-NLS-1$
	}

	@Override
	public IFile createAndOpenDiagram(IPath containerPath, String fileName, InputStream initialContents, String kind, IWorkbenchWindow dWindow, IProgressMonitor progressMonitor, boolean saveDiagram) {

		String semanticResourcePath = null;

		if (separateSemantics.getSelection() && semanticResource.getText().length() > 0) {

			semanticResourcePath = semanticResource.getText();
		}

		return MindmapDiagramEditorUtil.createAndOpenDiagram(getDiagramFileCreator(), containerPath, fileName, initialContents, kind, dWindow, progressMonitor, isOpenNewlyCreatedDiagramEditor(),
				saveDiagram, semanticResourcePath);
	}

	@Override
	protected String getDefaultFileName() {
		return Messages.getString("MindmapDiagramWizardPage.DefaultFileName"); //$NON-NLS-1$
	}

	@Override
	public DiagramFileCreator getDiagramFileCreator() {
		return MindmapDiagramFileCreator.getInstance();
	}

	@Override
	protected String getDiagramKind() {
		return MindmapDiagramEditor.ID;
	}

	@Override
	protected void createAdvancedControls(Composite parent) {
		super.createAdvancedControls(parent);

		separateSemantics = new Button(parent, SWT.CHECK);
		separateSemantics.setText(Messages.getString("MindmapDiagramWizardPage.SeparateDiagramAndModel")); //$NON-NLS-1$
		separateSemantics.setSelection(false);

		final Composite separateSemanticsGroup = new Composite(parent, SWT.NONE);
		final GridLayout layout = new GridLayout();
		layout.numColumns = 4;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		separateSemanticsGroup.setLayout(layout);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		separateSemanticsGroup.setLayoutData(data);

		semanticResource = new Text(separateSemanticsGroup, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
		data.horizontalSpan = 2;
		semanticResource.setLayoutData(data);
		semanticResource.setEnabled(false);

		final Button browseButton = new Button(separateSemanticsGroup, SWT.PUSH);
		browseButton.setText(Messages.getString("MindmapDiagramWizardPage.BrowseButtonText")); //$NON-NLS-1$
		browseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				handleBrowseButtonPressed();
			}
		});
		browseButton.setEnabled(false);
		setButtonLayoutData(browseButton);

		separateSemantics.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				semanticResource.setEnabled(!semanticResource.getEnabled());
				browseButton.setEnabled(!browseButton.getEnabled());
				semanticResource.setText(getContainerFullPath().append(getFileName()).removeFileExtension().addFileExtension("mindmap").toString()); //$NON-NLS-1$
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// Do nothing
			}
		});
	}

	protected void handleBrowseButtonPressed() {
		final ResourceSelectionDialog dialog = new ResourceSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), Messages.getString("MindmapDiagramWizardPage.BrowseDialogTitle")); //$NON-NLS-1$

		if (dialog.open() == Window.OK) {
			if (dialog.getResult().length == 0) {
				return;
			}

			final IResource r = (IResource) dialog.getResult()[0];
			semanticResource.setText(r.getFullPath().toString());
		}
	}
}
