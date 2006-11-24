/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.popup.actions;

import org.eclipse.gmf.internal.graphdef.codegen.ui.FigureGeneratorOptionsDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * @author dstadnik
 */
public class TransformToGenModelOptionsDialog extends FigureGeneratorOptionsDialog {

	private Button rcpButton;

	private boolean rcp;

	public TransformToGenModelOptionsDialog(Shell parentShell, String dialogTitle, boolean initialUseRuntimeFigures, boolean initialUseMapMode, boolean initialRCP) {
		super(parentShell, dialogTitle, initialUseRuntimeFigures, initialUseMapMode);
		rcp = initialRCP;
	}

	protected void createControls(Composite parent) {
		super.createControls(parent);
		rcpButton = new Button(parent, SWT.CHECK);
		rcpButton.setText("RCP Application");
		rcpButton.setSelection(rcp);
		rcpButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.VERTICAL_ALIGN_CENTER));
		rcpButton.setSelection(rcp);
	}

	protected void okPressed() {
		rcp = rcpButton.getSelection();
		super.okPressed();
	}
	
	public boolean isRCP() {
		return rcp;
	}
}
