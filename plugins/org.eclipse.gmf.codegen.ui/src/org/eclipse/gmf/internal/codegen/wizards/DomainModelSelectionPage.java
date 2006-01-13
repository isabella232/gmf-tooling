/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    dstadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.wizards;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

public class DomainModelSelectionPage extends WizardPage {

	protected IFile file;

	public DomainModelSelectionPage(String pageId, IStructuredSelection selection) {
		super(pageId);
		if (selection != null && !selection.isEmpty()) {
			Object selected = selection.getFirstElement();
			if (selected instanceof IFile) {
				file = (IFile) selected;
			}
		}
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 3;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}
		Label label = new Label(composite, SWT.NONE);
		label.setText("File name");
		{
			GridData data = new GridData();
			label.setLayoutData(data);
		}
		final Text text = new Text(composite, SWT.SINGLE | SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			text.setLayoutData(data);
		}
		if (file != null) {
			text.setText(file.getFullPath().toString());
		}
		text.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent me) {
				file = null;
				try {
					Path filePath = new Path(text.getText());
					if (!filePath.isEmpty()) {
						file = createFileHandle(filePath);
					}
				} catch (Exception e) {
				}
			}
		});
		Button button = new Button(composite, SWT.PUSH);
		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				ResourceSelectionDialog fsd = new ResourceSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), "Domain Model File");
				if (file != null) {
					fsd.setInitialElementSelections(Collections.singletonList(file));
				}
				if (fsd.open() == Window.OK) {
					Object[] result = fsd.getResult();
					if (result.length > 0 && result[0] instanceof IFile) {
						file = (IFile) result[0];
						text.setText(file.getFullPath().toString());
					} else {
						file = null;
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		button.setText("Browse");
		{
			GridData data = new GridData();
			button.setLayoutData(data);
		}
		setPageComplete(validatePage());
		setControl(composite);
	}

	protected IFile createFileHandle(IPath filePath) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
	}

	protected boolean validatePage() {
		return file != null;
	}

	public IFile getFile() {
		return file;
	}
}
