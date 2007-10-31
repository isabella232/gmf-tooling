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

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * @generated
 */
public class MindmapCreationWizard extends Wizard implements INewWizard {
	/**
	 * @generated
	 */
	private URI myCreatedDiagramFileURI;

	/**
	 * @generated
	 */
	private MindmapCreationWizardPage myPage;

	/**
	 * @generated
	 */
	public void addPages() {
		super.addPages();
		if (myPage == null) {
			myPage = new MindmapCreationWizardPage();
		}
		addPage(myPage);
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle(Messages.MindmapCreationWizard_WindowTitle);
		setDefaultPageImageDescriptor(MindmapDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewMindmapWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		boolean retVal = myPage.finish();
		myCreatedDiagramFileURI = myPage.getCreatedDiagramFileURI();
		return retVal;
	}

	/**
	 * returns the diagram file
	 * @generated
	 */
	public final URI getCreatedDiagramFileURI() {
		return myCreatedDiagramFileURI;
	}

}
