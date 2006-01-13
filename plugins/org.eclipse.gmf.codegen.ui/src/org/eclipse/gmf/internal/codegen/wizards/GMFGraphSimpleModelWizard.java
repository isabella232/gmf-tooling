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
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DecorationFigure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.presentation.GMFGraphModelWizard;
import org.eclipse.gmf.internal.codegen.resolver.NodePattern;
import org.eclipse.gmf.internal.codegen.resolver.StructureResolver;
import org.eclipse.gmf.internal.codegen.resolver.TypeLinkPattern;
import org.eclipse.gmf.internal.codegen.resolver.TypePattern;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class GMFGraphSimpleModelWizard extends GMFGraphModelWizard {

	protected DomainModelSelectionPage domainModelSelectionPage;

	protected GraphicalDefinitionPage graphicalDefinitionPage;

	protected StructureResolver resolver;

	protected EObject createInitialModel() {
		Canvas canvas = (Canvas) gmfGraphFactory.createCanvas();
		CheckboxTreeViewer viewer = graphicalDefinitionPage.getViewer();
		EPackage ePackage = (EPackage) viewer.getInput();
		if (ePackage != null) {
			canvas.setName(ePackage.getName());
			FigureGallery fGallery = gmfGraphFactory.createFigureGallery();
			fGallery.setName("default");
			canvas.getFigures().add(fGallery);
			for (Iterator ePackageIt = ePackage.eAllContents(); ePackageIt.hasNext();) {
				EObject ePackageObj = (EObject) ePackageIt.next();
				if (!viewer.getChecked(ePackageObj)) {
					continue;
				}
				if (ePackageObj instanceof EClass) {
					TypePattern pattern = resolver.resolve((EClass) ePackageObj);
					String baseName = pattern.getType().getName();
					if (pattern instanceof NodePattern) {
						Rectangle figure = gmfGraphFactory.createRectangle();
						figure.setName(baseName + "Figure");
						fGallery.getFigures().add(figure);
						Node dElement = gmfGraphFactory.createNode();
						dElement.setFigure(figure);
						dElement.setName(baseName + "Node");
						canvas.getNodes().add(dElement);
					} else if (pattern instanceof TypeLinkPattern) {
						PolylineConnection figure = gmfGraphFactory.createPolylineConnection();
						figure.setName(baseName + "Figure");
						fGallery.getFigures().add(figure);
						Connection dElement = gmfGraphFactory.createConnection();
						dElement.setFigure(figure);
						dElement.setName(baseName + "Link");
						canvas.getConnections().add(dElement);
					}
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
						PolylineConnection figure = gmfGraphFactory.createPolylineConnection();
						figure.setName(baseName + "Figure");
						DecorationFigure decoration = gmfGraphFactory.createPolylineDecoration();
						decoration.setName(baseName + "TargetDecoration");
						figure.setTargetDecoration(decoration);
						fGallery.getFigures().add(figure);
						Connection dElement = gmfGraphFactory.createConnection();
						dElement.setFigure(figure);
						dElement.setName(baseName + "Link");
						canvas.getConnections().add(dElement);
					}
				}
			}
		}
		return canvas;
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

		domainModelSelectionPage = new DomainModelSelectionPage("DomainModelSelectionPage", selection);
		domainModelSelectionPage.setTitle("Domain Model");
		domainModelSelectionPage.setDescription("Select file with ecore domain model");
		addPage(domainModelSelectionPage);

		graphicalDefinitionPage = new GraphicalDefinitionPage("GraphicalDefinitionPage", resolver = new StructureResolver(), domainModelSelectionPage);
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

	public class GraphicalDefinitionPage extends DefinitionPage {

		public GraphicalDefinitionPage(String pageId, StructureResolver resolver, DomainModelSelectionPage domainModelSelectionPage) {
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
