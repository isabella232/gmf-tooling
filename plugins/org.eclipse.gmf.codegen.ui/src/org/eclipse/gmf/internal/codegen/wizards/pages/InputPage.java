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
package org.eclipse.gmf.internal.codegen.wizards.pages;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.util.Assistant;
import org.eclipse.gmf.internal.codegen.wizards.pages.ModelURISelector.Loader;
import org.eclipse.gmf.tooldef.ToolRegistry;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MenuItem;

/**
 * @author artem
 */
public class InputPage extends WizardPage implements Loader {
	private ModelURISelector ecoreSelector;
	private ModelURISelector gmfgraphSelector;
	private ModelURISelector tooldefSelector;

	private final WizardInput holder; 
	public InputPage(WizardInput input) {
		super("inputPage");
		holder = input;
		setPageComplete(false);
	}

	public void createControl(Composite parent) {
		ecoreSelector = new ModelURISelector("Domain Model", "ecore", this);
		gmfgraphSelector = new ModelURISelector("Graphical Definition", "gmfgraph", this);
		tooldefSelector = new ModelURISelector("Tooling Definition", "gmftool", this);
		Composite p = new Composite(parent, SWT.NONE);
		GridLayout l = new GridLayout(1, false);
		l.verticalSpacing = 30;
		p.setLayout(l);
		Control c = ecoreSelector.createControl(p);
		final Listener lll = new Listener() {
			public void handleEvent(Event event) {
				ecoreSelector.setURIText((String) event.widget.getData());
			}
		};
		new MenuItem(ecoreSelector.getBrowseMenu(), SWT.SEPARATOR);
		MenuItem ii = new MenuItem(ecoreSelector.getBrowseMenu(), SWT.PUSH);
		ii.setText("Use ECore");
		ii.setData("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore");
		ii.addListener(SWT.Selection, lll);

		c.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		c = gmfgraphSelector.createControl(p);
		c.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		gmfgraphSelector.setURIText(Assistant.getBasicGraphDef());
		new MenuItem(gmfgraphSelector.getBrowseMenu(), SWT.SEPARATOR);
		MenuItem mi = new MenuItem(gmfgraphSelector.getBrowseMenu(), SWT.PUSH);
		mi.setText("Use Basic");
		mi.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				gmfgraphSelector.setURIText(Assistant.getBasicGraphDef());
			}
		});
		c = tooldefSelector.createControl(p);
		c.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		c.setEnabled(false);
		setControl(p);
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
		setPageComplete(holder.isReady2Go());
	}
}
