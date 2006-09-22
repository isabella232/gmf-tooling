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
package org.eclipse.gmf.internal.bridge.wizards.pages;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.util.Assistant;
import org.eclipse.gmf.internal.bridge.wizards.pages.ModelURISelector.Loader;
import org.eclipse.gmf.tooldef.ToolRegistry;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * @author artem
 */
public class InputPage extends WizardPage implements Loader {

	private ModelURISelector ecoreSelector;
	private ModelURISelector gmfgraphSelector;
	private ModelURISelector tooldefSelector;
	private final OldWizardInput holder;

	public InputPage(OldWizardInput input) {
		super("inputPage"); //$NON-NLS-1$
		holder = input;
		setTitle(Messages.inputPageTitle);
		setDescription(Messages.inputPageDesc);
		setPageComplete(false);
	}

	public void createControl(Composite parent) {
		ecoreSelector = new ModelURISelector(Messages.ecoreSelector, WizardInput.ECORE_FILE_EXT, this);
		gmfgraphSelector = new ModelURISelector(Messages.graphdefSelector, WizardInput.GRAPHDEF_FILE_EXT, this);
		tooldefSelector = new ModelURISelector(Messages.tooldefSelector, WizardInput.TOOLDEF_FILE_EXT, this);
		Composite p = new Composite(parent, SWT.NONE);
		GridLayout l = new GridLayout(1, false);
		l.verticalSpacing = 30;
		p.setLayout(l);
		Control c = ecoreSelector.createControl(p);
		c.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		// TODO define additional get from extpoint
		ecoreSelector.addBrowseMenuSeparator();
		ecoreSelector.addBrowseMenuAction(Messages.useECore, "platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore"); //$NON-NLS-1$
		initializeEcoreFileURI();

		c = gmfgraphSelector.createControl(p);
		c.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		gmfgraphSelector.setURIText(Assistant.getBasicGraphDef());
		gmfgraphSelector.addBrowseMenuSeparator();
		gmfgraphSelector.addBrowseMenuAction(Messages.useBasic, Assistant.getBasicGraphDef().toString());
		initializeGraphFileURI();

		c = tooldefSelector.createControl(p);
		c.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		tooldefSelector.addBrowseMenuSeparator();
		tooldefSelector.addBrowseMenuAction(Messages.createBlank, new NewBlankToolDef());
		initializeToolFileURI();
		setControl(p);
	}

	private void initializeEcoreFileURI() {
		if (holder.getInitialECoreFile() != null) {
			ecoreSelector.setURIText(holder.getInitialECoreFile());
		}
	}
	
	private void initializeGraphFileURI() {
		if (holder.getInitialGraphFile() != null) {
			gmfgraphSelector.setURIText(holder.getInitialGraphFile());
		}
	}
	
	private void initializeToolFileURI() {
		if (holder.getInitialToolFile() != null) {
			tooldefSelector.setURIText(holder.getInitialToolFile());
		}
	}

	public void run(ModelURISelector selector, String uriText) {
		URI uri = URI.createURI(uriText);
		Resource r = holder.getResourceSet().getResource(uri, true);
		if (selector == ecoreSelector) {
			if (r != null && r.getContents().get(0) instanceof EPackage) {
				holder.setDomainModel((EPackage) r.getContents().get(0));
			}
		} else if (selector == gmfgraphSelector) {
			if (r != null && r.getContents().get(0) instanceof Canvas) {
				holder.setGraphDef((Canvas) r.getContents().get(0));
			}
		} else {
			if (r != null && r.getContents().get(0) instanceof ToolRegistry) {
				holder.setToolDef((ToolRegistry) r.getContents().get(0));
			}
		}
		updatePageComplete();
	}

	private void updatePageComplete() {
		IStatus s = holder.isReady2Go();
		if (s.isOK()) {
			setPageComplete(true);
			setMessage(null);
		} else {
			setPageComplete(false);
			setMessage(s.getMessage(), s.getCode());
		}
	}

	private class NewBlankToolDef implements Listener {
		public void handleEvent(Event event) {
			tooldefSelector.setURIText(holder.createBlankToolDef());
			tooldefSelector.disableLoad();
			updatePageComplete();
		}
	}
}
