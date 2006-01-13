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
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.internal.codegen.resolver.NodePattern;
import org.eclipse.gmf.internal.codegen.resolver.StructureResolver;
import org.eclipse.gmf.internal.codegen.resolver.TypeLinkPattern;
import org.eclipse.gmf.internal.codegen.resolver.TypePattern;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DefinitionPage extends WizardPage {

	private StructureResolver resolver;

	private DomainModelSelectionPage domainModelSelectionPage;

	private IFile file;

	protected Label msg;

	protected StructuredViewer viewer;

	public DefinitionPage(String pageId, StructureResolver resolver, DomainModelSelectionPage domainModelSelectionPage) {
		super(pageId);
		this.resolver = resolver;
		this.domainModelSelectionPage = domainModelSelectionPage;
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
		viewer = createViewer(composite);
		{
			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			viewer.getControl().setLayoutData(data);
		}
		createAdditionalControls(composite);
		setPageComplete(validatePage());
		setControl(composite);
	}

	protected StructuredViewer createViewer(Composite parent) {
		StructuredViewer viewer = new CheckboxTreeViewer(parent);
		AdapterFactory adapterFactory = new EcoreItemProviderAdapterFactory();
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory) {

			public String getText(Object object) {
				String label = super.getText(object);
				if (object instanceof EClass) {
					TypePattern pattern = resolver.resolve((EClass) object);
					if (pattern instanceof NodePattern) {
						label += " : Node";
					} else if (pattern instanceof TypeLinkPattern) {
						label += " : Link";
					}
				} else if (object instanceof EReference) {
					label += " : Link";
				}
				return label;
			}
		});
		viewer.setContentProvider(new FilteredAdapterFactoryContentProvider(adapterFactory) {

			protected boolean isShown(Object element) {
				return isDomainElementShown(element);
			}
		});
		return viewer;
	}

	protected boolean isDomainElementShown(Object element) {
		if (element instanceof EPackage) {
			return true;
		} else if (element instanceof EClass) {
			return true;
		} else if (element instanceof EReference) {
			EReference ref = (EReference) element;
			TypePattern pattern = resolver.resolve(ref.getEContainingClass());
			if (pattern instanceof NodePattern) {
				EReference[] refLinks = ((NodePattern) pattern).getRefLinks();
				for (int i = 0; i < refLinks.length; i++) {
					if (refLinks[i] == ref) {
						return true;
					}
				}
			}
		}
		return false;
	}

	protected void createAdditionalControls(Composite parent) {
	}

	protected boolean validatePage() {
		return true;
	}

	public void setVisible(boolean visible) {
		super.setVisible(visible);
		IFile newFile = domainModelSelectionPage.getFile();
		if (visible && (newFile == null || newFile != file)) {
			file = newFile;
			msg.setText(reloadDomainModel());
		}
	}

	protected String reloadDomainModel() {
		if (file == null) {
			viewer.setInput(null);
			setPageComplete(true);
			return "Domain model file is not specified; empty model will be created.";
		}
		EPackage contents;
		try {
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString());
			ResourceSet rs = new ResourceSetImpl();
			Resource r = rs.getResource(uri, true);
			contents = (EPackage) r.getContents().get(0);
			viewer.setInput(contents);
			processNewDomainModel(contents);
			setPageComplete(validatePage());
			return "Domain model elements to process:";
		} catch (Exception e) {
			viewer.setInput(null);
			setPageComplete(false);
			return "Error loading domain model file.";
		}
	}

	protected void processNewDomainModel(EPackage contents) {
	}
}
