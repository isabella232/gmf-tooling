/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.sketch.transformer;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * @author dstadnik
 */
public class TransformSketchAction implements IObjectActionDelegate {

	private IWorkbenchPart part;

	private ISelection selection;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		part = targetPart;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void run(IAction action) {
		if (part == null || !(selection instanceof IStructuredSelection)) {
			return;
		}
		IWorkbenchWizard wizard = new TransformSketchWizard();
		wizard.init(part.getSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection) selection);
		WizardDialog dialog = new WizardDialog(part.getSite().getShell(), wizard);
		dialog.open();
	}
}
