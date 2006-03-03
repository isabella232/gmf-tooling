/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.gmf.internal.doc.ui.actions;

import org.eclipse.gmf.internal.bridge.wizards.GMFToolSimpleModelWizard;
import org.eclipse.gmf.internal.doc.ui.Activator;
import org.eclipse.gmf.tooldef.presentation.GMFToolModelWizard.GMFToolModelWizardNewFileCreationPage;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.cheatsheets.ICheatSheetAction;
import org.eclipse.ui.cheatsheets.ICheatSheetManager;

public class OpenToolWizardAction extends Action implements ICheatSheetAction {
	private static final int WIZARD_WIDTH = 500;

	private static final int WIZARD_HEIGHT = 500;

	/**
	 * @param text
	 */
	public OpenToolWizardAction() {
		super("OpenToolWizard"); //$NON-NLS-1$
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run() {
		run(new String[] {}, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.cheatsheets.ICheatSheetAction#run(java.lang.String[],
	 *      org.eclipse.ui.cheatsheets.ICheatSheetManager)
	 */
	public void run(String[] params, ICheatSheetManager manager) {
		final String modelName;
		if (params != null && params.length > 0) {
			modelName = params[0];
		} else {
			modelName = "mindmap.gmftool";
		}
		final IWizard wizard = new GMFToolSimpleModelWizard();

		if (wizard instanceof IWorkbenchWizard) {
			((IWorkbenchWizard) wizard).init(PlatformUI.getWorkbench(), new StructuredSelection());
		}
		WizardDialog dialog = new WizardDialog(Activator.getActiveWorkbenchShell(), wizard);
		dialog.create();
		GMFToolModelWizardNewFileCreationPage page = (GMFToolModelWizardNewFileCreationPage) wizard.getPage("Whatever");
		page.setFileName(modelName);
		dialog.getShell().setSize(Math.max(WIZARD_WIDTH, dialog.getShell().getSize().x), WIZARD_HEIGHT);
		dialog.open();
		notifyResult(dialog.getReturnCode() == Dialog.OK);
	}

}
