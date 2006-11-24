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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.internal.bridge.wizards.GMFMapGuideModelWizard;
import org.eclipse.gmf.internal.bridge.wizards.pages.NewMapFileCreationPage;
import org.eclipse.gmf.internal.doc.ui.Activator;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.cheatsheets.ICheatSheetAction;
import org.eclipse.ui.cheatsheets.ICheatSheetManager;

public class OpenMapWizardAction extends Action implements ICheatSheetAction {

	private static final int WIZARD_WIDTH = 500;

	private static final int WIZARD_HEIGHT = 500;

	public OpenMapWizardAction() {
		super("OpenMapWizard"); //$NON-NLS-1$
	}

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
		final String modelFolder;
		if (params != null && params.length > 0) {
			modelFolder = params[0];
		} else {
			modelFolder = "org.eclipse.gmf.examples.mindmap/model"; //$NON-NLS-1$
		}
		final String modelName;
		if (params != null && params.length > 1) {
			modelName = params[1];
		} else {
			modelName = "mindmap.gmfmap"; //$NON-NLS-1$
		}
		// other models
		List<URI> uris = new ArrayList<URI>();
		for (int i = 2; i < 5; i++) {
			String param = params[i];
			if (param == null) {
				continue;
			}
			try {
				uris.add(URI.createURI(param));
			} catch (IllegalArgumentException iae) {
				Activator.log(iae);
			}
		}

		// as IWorkbenchWizard
		GMFMapGuideModelWizard wizard = new GMFMapGuideModelWizard();
		wizard.init(PlatformUI.getWorkbench(), new StructuredSelection(uris));

		WizardDialog dialog = new WizardDialog(Activator.getActiveWorkbenchShell(), wizard);
		dialog.create();
		NewMapFileCreationPage filePage = (NewMapFileCreationPage) wizard.getPage("newMapFileCreationPage"); //$NON-NLS-1$
		filePage.setContainerFullPath(new Path(modelFolder));
		filePage.setFileName(modelName);

		dialog.getShell().setSize(Math.max(WIZARD_WIDTH, dialog.getShell().getSize().x), WIZARD_HEIGHT);
		dialog.open();
		notifyResult(dialog.getReturnCode() == Dialog.OK);
	}

}
