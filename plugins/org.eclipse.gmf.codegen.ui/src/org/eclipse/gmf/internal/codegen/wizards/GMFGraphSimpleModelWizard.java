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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.presentation.GMFGraphModelWizard;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

public class GMFGraphSimpleModelWizard extends GMFGraphModelWizard {

	protected DomainModelSelectionPage domainModelSelectionPage;

	protected MappingPage mappingPage;

	protected EObject createInitialModel() {
		Canvas canvas = (Canvas) gmfGraphFactory.createCanvas();
		CheckboxTreeViewer viewer = mappingPage.getViewer();
		EPackage ePackage = (EPackage) viewer.getInput();
		if (ePackage != null) {
			canvas.setName(ePackage.getName());
			FigureGallery fGallery = gmfGraphFactory.createFigureGallery();
			fGallery.setName("default");
			canvas.getFigures().add(fGallery);
			for (Iterator ePackageIt = ePackage.eContents().iterator(); ePackageIt.hasNext();) {
				EObject ePackageObj = (EObject) ePackageIt.next();
				if (!viewer.getChecked(ePackageObj)) {
					continue;
				}
				if (ePackageObj instanceof EClass) {
					EClass eClass = (EClass) ePackageObj;
					Rectangle figure = gmfGraphFactory.createRectangle();
					figure.setName(eClass.getName() + "Figure");
					fGallery.getFigures().add(figure);
					Node dElement = gmfGraphFactory.createNode();
					dElement.setFigure(figure);
					dElement.setName(eClass.getName() + "Node");
					canvas.getNodes().add(dElement);
				}
			}
		}
		return canvas;
	}

	public void addPages() {
		super.addPages();

		initialObjectCreationPage.dispose();
		initialObjectCreationPage = new PredefinedInitialObjectCreationPage("Whatever2");

		domainModelSelectionPage = new DomainModelSelectionPage("DomainModelSelectionPage", selection);
		domainModelSelectionPage.setTitle("Domain Model");
		domainModelSelectionPage.setDescription("Select domain model");
		addPage(domainModelSelectionPage);

		mappingPage = new MappingPage("MappingPage");
		mappingPage.setTitle("Graphical Definition");
		mappingPage.setDescription("Specify basic graphical definition of the domain model");
		addPage(mappingPage);
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

	public class DomainModelSelectionPage extends WizardPage {

		protected IFile file;

		public DomainModelSelectionPage(String pageId, IStructuredSelection selection) {
			super(pageId);
			if (selection != null && !selection.isEmpty()) {
				Object selected = selection.getFirstElement();
				if (selected instanceof IFile) {
					file = (IFile) selected;
				}
			}
		}

		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 3;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}
			Label label = new Label(composite, SWT.NONE);
			label.setText("File name");
			{
				GridData data = new GridData();
				label.setLayoutData(data);
			}
			final Text text = new Text(composite, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				text.setLayoutData(data);
			}
			if (file != null) {
				text.setText(file.getFullPath().toString());
			}
			Button button = new Button(composite, SWT.PUSH);
			button.addSelectionListener(new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					ResourceSelectionDialog fsd = new ResourceSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), "Domain Model File");
					if (file != null) {
						fsd.setInitialElementSelections(Collections.singletonList(file));
					}
					if (fsd.open() == Window.OK) {
						Object[] result = fsd.getResult();
						if (result.length > 0 && result[0] instanceof IFile) {
							file = (IFile) result[0];
							text.setText(file.getFullPath().toString());
						}
					}
				}

				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
			button.setText("Browse");
			{
				GridData data = new GridData();
				button.setLayoutData(data);
			}
			setPageComplete(validatePage());
			setControl(composite);
		}

		protected boolean validatePage() {
			return file != null;
		}

		public IFile getFile() {
			return file;
		}
	}

	public class MappingPage extends WizardPage {

		protected IFile processedFile;

		protected Label msg;

		protected CheckboxTreeViewer domainModelViewer;

		public MappingPage(String pageId) {
			super(pageId);
		}

		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 1;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}
			msg = new Label(composite, SWT.NONE);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				msg.setLayoutData(data);
			}
			domainModelViewer = new CheckboxTreeViewer(composite);
			AdapterFactory adapterFactory = new EcoreItemProviderAdapterFactory();
			domainModelViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory) {

				protected boolean isAccessible(Object element) {
					if (element instanceof EPackage) {
						return true;
					} else if (element instanceof EClass) {
						return true;
					} else if (element instanceof EStructuralFeature) {
						return true;
					}
					return false;
				}

				public Object[] getChildren(Object object) {
					Object[] children = super.getChildren(object);
					if (children.length == 0) {
						return children;
					}
					ArrayList filteredChildren = new ArrayList(children.length);
					for (int i = 0; i < children.length; i++) {
						if (isAccessible(children[i])) {
							filteredChildren.add(children[i]);
						}
					}
					return (Object[]) filteredChildren.toArray(new Object[filteredChildren.size()]);
				}

				public boolean hasChildren(Object object) {
					return getChildren(object).length > 0;
				}

				public Object[] getElements(Object object) {
					return getChildren(object);
				}
			});
			domainModelViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			{
				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				domainModelViewer.getControl().setLayoutData(data);
			}
			setPageComplete(validatePage());
			setControl(composite);
		}

		protected boolean validatePage() {
			return true;
		}

		public void setVisible(boolean visible) {
			super.setVisible(visible);
			IFile file = domainModelSelectionPage.getFile();
			if (visible && (file == null || file != processedFile)) {
				processedFile = file;
				reloadDomainModel();
				domainModelViewer.refresh();
				domainModelViewer.expandAll();
				domainModelViewer.setAllChecked(true);
			}
		}

		protected void reloadDomainModel() {
			if (processedFile == null) {
				msg.setText("Domain model file is not specified; empty model will be created.");
				domainModelViewer.setInput(null);
				setPageComplete(true);
				return;
			}
			EPackage contents;
			try {
				URI uri = URI.createPlatformResourceURI(processedFile.getFullPath().toString());
				ResourceSet rs = new ResourceSetImpl();
				Resource r = rs.getResource(uri, true);
				contents = (EPackage) r.getContents().get(0);
				msg.setText("Select domain model elements to process:");
				domainModelViewer.setInput(contents);
				setPageComplete(true);
			} catch (Exception e) {
				msg.setText("Error loading domain model file.");
				domainModelViewer.setInput(null);
				setPageComplete(false);
			}
		}

		public final CheckboxTreeViewer getViewer() {
			return domainModelViewer;
		}
	}
}
