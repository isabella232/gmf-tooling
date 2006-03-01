/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.wizards.pages;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.gmf.internal.bridge.ui.FileSelector;
import org.eclipse.jface.viewers.IStructuredSelection;
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

/**
 * @author dstadnik
 */
public class DomainModelSelectionPage extends WizardPage {

	protected FileDomainModelSource domainModelSource;

	public DomainModelSelectionPage(String pageId, IStructuredSelection selection, FileDomainModelSource domainModelSource) {
		super(pageId);
		assert domainModelSource != null;
		this.domainModelSource = domainModelSource;
		if (selection != null && !selection.isEmpty()) {
			Object selected = selection.getFirstElement();
			if (selected instanceof IFile) {
				domainModelSource.setFile((IFile) selected);
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
		if (domainModelSource.getFile() != null) {
			text.setText(domainModelSource.getFile().getFullPath().toString());
		}
		text.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent me) {
				domainModelSource.setFile(null);
				try {
					Path filePath = new Path(text.getText());
					if (!filePath.isEmpty()) {
						domainModelSource.setFile(createFileHandle(filePath));
					}
				} catch (Exception e) {
				}
				setPageComplete(validatePage());
			}
		});
		Button button = new Button(composite, SWT.PUSH);
		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				domainModelSource.setFile(FileSelector.selectFile(getShell(), "Domain Model File", null, domainModelSource.getFile(), "ecore"));
				if (domainModelSource.getFile() != null) {
					text.setText(domainModelSource.getFile().getFullPath().toString());
				} else {
					text.setText("");
				}
				setPageComplete(validatePage());
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
		return domainModelSource.getFile() != null;
	}
}
