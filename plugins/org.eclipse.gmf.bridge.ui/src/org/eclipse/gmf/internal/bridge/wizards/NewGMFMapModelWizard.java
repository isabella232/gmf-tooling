/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gmf.internal.bridge.ui.Plugin;
import org.eclipse.gmf.internal.bridge.wizards.pages.EntriesPage;
import org.eclipse.gmf.internal.bridge.wizards.pages.InputPage;
import org.eclipse.gmf.internal.bridge.wizards.pages.Messages;
import org.eclipse.gmf.internal.bridge.wizards.pages.NewMapFileCreationPage;
import org.eclipse.gmf.internal.bridge.wizards.pages.RootElementPage;
import org.eclipse.gmf.internal.bridge.wizards.pages.WizardInput;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @author artem
 */
public class NewGMFMapModelWizard extends Wizard implements INewWizard {

	protected IStructuredSelection mySelection;

	protected final WizardInput myHolder;

	private IWorkbench myWorkbench;

	public NewGMFMapModelWizard() {
		setNeedsProgressMonitor(true);
		setWindowTitle(Messages.wizardTitle);
		myHolder = new WizardInput();
	}

	public void addPages() {
		addNewFilePage();
		addSelectInputPage();
		addSelectRootPage();
		addDoMapPage();
	}

	protected void addNewFilePage() {
		addPage(new NewMapFileCreationPage(mySelection, myHolder));
	}

	protected void addSelectInputPage() {
		addPage(new InputPage(myHolder));
	}

	protected void addSelectRootPage() {
		addPage(new RootElementPage(myHolder));
	}

	protected void addDoMapPage() {
		addPage(new EntriesPage(myHolder));
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		myWorkbench = workbench;
		mySelection = selection;
	}

	public boolean performFinish() {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					Map options = new HashMap();
					options.put(XMLResource.OPTION_ENCODING, "UTF-8");
					myHolder.getMapping().eResource().save(options);
				} catch (Exception ex) {
					Plugin.log(ex);
				} finally {
					progressMonitor.done();
				}
			}
		};

		try {
			getContainer().run(false, false, operation);
			WizardUtil.selectReveal(myWorkbench, new StructuredSelection(getModelFile()));
			WizardUtil.openInEditor(myWorkbench, getModelFile());
		} catch (InvocationTargetException ex) {
			return false;
		} catch (InterruptedException ex) {
			return false;
		} catch (PartInitException ex) {
			Plugin.log(ex);
		}
		return true;
	}

	public IFile getModelFile() {
		return myHolder.getMappingFile();
	}
}
