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
package org.eclipse.gmf.internal.codegen.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gmf.internal.codegen.wizards.pages.EntriesPage;
import org.eclipse.gmf.internal.codegen.wizards.pages.InputPage;
import org.eclipse.gmf.internal.codegen.wizards.pages.NewMappingFileCreationPage;
import org.eclipse.gmf.internal.codegen.wizards.pages.RootElementPage;
import org.eclipse.gmf.internal.codegen.wizards.pages.WizardInput;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @author artem
 */
public class NewGMFMapModelWizard extends Wizard implements INewWizard {

	private IStructuredSelection selection;

	private WizardInput myHolder;

	public NewGMFMapModelWizard() {
		setNeedsProgressMonitor(true);
		setWindowTitle("Ecore to GMFGraph model");
	}

	public void addPages() {
		final NewMappingFileCreationPage p = new NewMappingFileCreationPage(selection);
		p.setTitle("GMFMap Model");
		p.setDescription("Create a new GMFMap model");
		addPage(p);
		myHolder = new WizardInput(p.getResultContainer());
		InputPage p1 = new InputPage(myHolder);
		p1.setTitle("Source Models");
		p1.setDescription("Select domain, graphical and tooling definition models");
		addPage(p1);
		RootElementPage p2 = new RootElementPage(myHolder);
		p2.setTitle("Diagram Element");
		p2.setDescription("Choose element of domain model to act as top-level container, associated with diagram");
		addPage(p2);
		EntriesPage p3 = new EntriesPage(myHolder);
		p3.setTitle("Mapping");
		p3.setDescription("Map domain model elements");
		addPage(p3);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	public boolean performFinish() {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					Map options = new HashMap();
					options.put(XMLResource.OPTION_ENCODING, "UTF-8");
					myHolder.getMapping().eResource().save(options);
				} catch (Exception ex) {
					IStatus s = new Status(IStatus.ERROR, "org.eclipse.gmf.codegen.ui", 0, ex.getMessage(), ex);
					Platform.getLog(Platform.getBundle("org.eclipse.gmf.codegen.ui")).log(s);
				} finally {
					progressMonitor.done();
				}
			}
		};

		try {
			getContainer().run(false, false, operation);
		} catch (InvocationTargetException ex) {
			return false;
		} catch (InterruptedException ex) {
			return false;
		}
		return true;
	}

}
