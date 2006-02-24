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

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.gmfgraph.presentation.GMFGraphModelWizard;
import org.eclipse.gmf.internal.codegen.resolver.StructureBuilder;
import org.eclipse.gmf.internal.codegen.resolver.StructureResolver;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class GMFGraphSimpleModelWizard extends GMFGraphModelWizard {

	protected DefinitionPage graphicalDefinitionPage;

	protected FileDomainModelSource domainModelSource = new FileDomainModelSource();

	protected EObject createInitialModel() {
		GraphDefBuilder builder = new GraphDefBuilder();
		return builder.process(graphicalDefinitionPage.getModel());
	}

	public void addPages() {
		super.addPages();

		if (selection != null && !selection.isEmpty()) {
			Object selected = selection.getFirstElement();
			if (selected instanceof IFile) {
				newFileCreationPage.setFileName(WizardUtil.getDefaultFileName((IFile) selected, "gmfgraph"));
			}
		}

		initialObjectCreationPage.dispose();
		initialObjectCreationPage = new PredefinedInitialObjectCreationPage("Whatever2");

		DomainModelSelectionPage domainModelSelectionPage = new DomainModelSelectionPage("DomainModelSelectionPage", selection, domainModelSource);
		domainModelSelectionPage.setTitle("Domain Model");
		domainModelSelectionPage.setDescription("Select file with ecore domain model");
		addPage(domainModelSelectionPage);

		graphicalDefinitionPage = new DefinitionPage("GraphicalDefinitionPage", new StructureBuilder(new StructureResolver()), domainModelSource, false);
		graphicalDefinitionPage.setTitle("Graphical Definition");
		graphicalDefinitionPage.setDescription("Specify basic graphical definition of the domain model");
		addPage(graphicalDefinitionPage);
	}

	public void addPage(IWizardPage page) {
		if (page == initialObjectCreationPage) {
			return;
		}
		super.addPage(page);
	}

	public class PredefinedInitialObjectCreationPage extends GMFGraphModelWizardInitialObjectCreationPage {

		public PredefinedInitialObjectCreationPage(String pageId) {
			super(pageId);
		}

		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			setControl(composite);
		}

		protected boolean validatePage() {
			return true;
		}

		public void setVisible(boolean visible) {
			getControl().setVisible(visible);
		}

		public String getInitialObjectName() {
			return gmfGraphPackage.getCanvas().getName();
		}

		public String getEncoding() {
			return "UTF-8";
		}
	}
}
