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

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.internal.codegen.resolver.NodePattern;
import org.eclipse.gmf.internal.codegen.resolver.StructureResolver;
import org.eclipse.gmf.internal.codegen.resolver.TypePattern;
import org.eclipse.gmf.tooldef.CreationTool;
import org.eclipse.gmf.tooldef.Palette;
import org.eclipse.gmf.tooldef.ToolGroup;
import org.eclipse.gmf.tooldef.ToolRegistry;
import org.eclipse.gmf.tooldef.presentation.GMFToolModelWizard;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class GMFToolSimpleModelWizard extends GMFToolModelWizard {

	protected DomainModelSelectionPage domainModelSelectionPage;

	protected ToolDefinitionPage toolDefinitionPage;

	protected StructureResolver resolver;

	protected EObject createInitialModel() {
		ToolRegistry toolRegistry = (ToolRegistry) gmfToolFactory.createToolRegistry();
		CheckboxTreeViewer viewer = toolDefinitionPage.getViewer();
		EPackage ePackage = (EPackage) viewer.getInput();
		if (ePackage != null) {
			Palette palette = gmfToolFactory.createPalette();
			toolRegistry.setPalette(palette);
			ToolGroup group = gmfToolFactory.createToolGroup();
			group.setTitle(ePackage.getName());
			palette.getTools().add(group);
			for (Iterator ePackageIt = ePackage.eAllContents(); ePackageIt.hasNext();) {
				EObject ePackageObj = (EObject) ePackageIt.next();
				if (!viewer.getChecked(ePackageObj)) {
					continue;
				}
				if (ePackageObj instanceof EClass) {
					EClass eClass = (EClass) ePackageObj;
					String baseName = eClass.getName();
					CreationTool tool = gmfToolFactory.createCreationTool();
					tool.setTitle(baseName);
					tool.setDescription("Create new " + baseName);
					tool.setSmallIcon(gmfToolFactory.createDefaultImage());
					tool.setLargeIcon(gmfToolFactory.createDefaultImage());
					group.getTools().add(tool);
				} else if (ePackageObj instanceof EReference) {
					EReference ref = (EReference) ePackageObj;
					TypePattern pattern = resolver.resolve(ref.getEContainingClass());
					String baseName = pattern.getType().getName();
					if (ref.getName().length() > 0) {
						baseName += Character.toUpperCase(ref.getName().charAt(0));
					}
					if (ref.getName().length() > 1) {
						baseName += ref.getName().substring(1);
					}
					if (pattern instanceof NodePattern) {
						CreationTool tool = gmfToolFactory.createCreationTool();
						tool.setTitle(baseName);
						tool.setDescription("Create new " + baseName);
						tool.setSmallIcon(gmfToolFactory.createDefaultImage());
						tool.setLargeIcon(gmfToolFactory.createDefaultImage());
						group.getTools().add(tool);
					}
				}
			}
		}
		return toolRegistry;
	}

	public void addPages() {
		super.addPages();

		if (selection != null && !selection.isEmpty()) {
			Object selected = selection.getFirstElement();
			if (selected instanceof IFile) {
				newFileCreationPage.setFileName(WizardUtil.getDefaultFileName((IFile) selected, "gmftool"));
			}
		}

		initialObjectCreationPage.dispose();
		initialObjectCreationPage = new PredefinedInitialObjectCreationPage("Whatever2");

		domainModelSelectionPage = new DomainModelSelectionPage("DomainModelSelectionPage", selection);
		domainModelSelectionPage.setTitle("Domain Model");
		domainModelSelectionPage.setDescription("Select file with ecore domain model");
		addPage(domainModelSelectionPage);

		toolDefinitionPage = new ToolDefinitionPage("ToolDefinitionPage", resolver = new StructureResolver(), domainModelSelectionPage);
		toolDefinitionPage.setTitle("Tooling Definition");
		toolDefinitionPage.setDescription("Specify basic tooling definition of the domain model");
		addPage(toolDefinitionPage);
	}

	public void addPage(IWizardPage page) {
		if (page == initialObjectCreationPage) {
			return;
		}
		super.addPage(page);
	}

	public class PredefinedInitialObjectCreationPage extends GMFToolModelWizardInitialObjectCreationPage {

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
			return gmfToolPackage.getToolRegistry().getName();
		}

		public String getEncoding() {
			return "UTF-8";
		}
	}

	public class ToolDefinitionPage extends DefinitionPage {

		public ToolDefinitionPage(String pageId, StructureResolver resolver, DomainModelSelectionPage domainModelSelectionPage) {
			super(pageId, resolver, domainModelSelectionPage);
		}

		protected void processNewDomainModel(EPackage contents) {
			CheckboxTreeViewer viewer = getViewer();
			viewer.expandAll();
			viewer.setAllChecked(true);
		}

		public final CheckboxTreeViewer getViewer() {
			return (CheckboxTreeViewer) viewer;
		}
	}
}
