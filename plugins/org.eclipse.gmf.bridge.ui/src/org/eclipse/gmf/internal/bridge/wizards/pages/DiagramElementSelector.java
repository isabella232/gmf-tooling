/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.wizards.pages;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.internal.bridge.resolver.NodePattern;
import org.eclipse.gmf.internal.bridge.resolver.ResolvedItem;
import org.eclipse.gmf.internal.bridge.resolver.TypeLinkPattern;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author dstadnik
 */
class DiagramElementSelector {

	private ResolvedItem domainModel;

	private Combo diagramElementCombo;

	private Button excludeContainedNodesChoice;

	private Button excludeLinksChoice;

	public void createControl(Composite plate) {
		Label diagramElementLabel = new Label(plate, SWT.NONE);
		diagramElementLabel.setText("Diagram element:");
		diagramElementLabel.setLayoutData(new GridData());
		diagramElementCombo = new Combo(plate, SWT.DROP_DOWN);
		diagramElementCombo.setLayoutData(createFillHorzGridData());
		diagramElementCombo.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				System.err.println(diagramElementCombo.getText());
				// TODO : validate selection
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		excludeContainedNodesChoice = createChoice(plate, "Exclude types that are resolved as nodes and have container");
		excludeLinksChoice = createChoice(plate, "Exclude types that are resolved as links");
	}

	private Button createChoice(Composite plate, String text) {
		Label dummy = new Label(plate, SWT.NONE);
		dummy.setLayoutData(new GridData());
		Button choice = new Button(plate, SWT.CHECK);
		choice.setText(text);
		choice.setLayoutData(createFillHorzGridData());
		choice.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				updateDiagramElements();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		return choice;
	}

	protected GridData createFillHorzGridData() {
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		return data;
	}

	public ResolvedItem getDiagramElement() {
		return domainModel == null ? null : findResolvedItemByTypeName(domainModel, diagramElementCombo.getText());
	}

	public void setDomainModel(ResolvedItem domainModel) {
		this.domainModel = domainModel;
		updateDiagramElements();
	}

	private void updateDiagramElements() {
		Set types = new TreeSet(new Comparator() {

			public int compare(Object arg0, Object arg1) {
				EClass type0 = (EClass) ((ResolvedItem) arg0).getDomainRef();
				EClass type1 = (EClass) ((ResolvedItem) arg1).getDomainRef();
				return type0.getName().compareToIgnoreCase(type1.getName());
			}
		});
		if (domainModel != null) {
			collectResolvedDomainTypes(types, domainModel);
		}
		String contents = diagramElementCombo.getText();
		diagramElementCombo.removeAll();
		for (Iterator it = types.iterator(); it.hasNext();) {
			EClass type = (EClass) ((ResolvedItem) it.next()).getDomainRef();
			diagramElementCombo.add(type.getName());
			if (contents.equals(type.getName())) {
				diagramElementCombo.setText(contents);
			}
		}
		if (diagramElementCombo.getText().length() == 0 && diagramElementCombo.getItemCount() > 0) {
			diagramElementCombo.setText(diagramElementCombo.getItem(0));
		}
		if (!contents.equals(diagramElementCombo.getText())) {
			// TODO : update resolution tree
		}
	}

	private void collectResolvedDomainTypes(Collection types, ResolvedItem item) {
		if (item.getDomainRef() instanceof EClass) {
			boolean ignore = false;
			if (excludeContainedNodesChoice.getSelection()) {
				ignore |= item.getPattern() instanceof NodePattern;
			}
			if (excludeLinksChoice.getSelection()) {
				ignore |= item.getPattern() instanceof TypeLinkPattern;
			}
			if (!ignore) {
				types.add(item);
			}
		}
		for (Iterator it = item.getChildren().iterator(); it.hasNext();) {
			collectResolvedDomainTypes(types, (ResolvedItem) it.next());
		}
	}

	private ResolvedItem findResolvedItemByTypeName(ResolvedItem item, String typeName) {
		if (item.getDomainRef() instanceof EClass && ((EClass) item.getDomainRef()).getName().equals(typeName)) {
			return item;
		}
		for (Iterator it = item.getChildren().iterator(); it.hasNext();) {
			ResolvedItem result = findResolvedItemByTypeName((ResolvedItem) it.next(), typeName);
			if (result != null) {
				return result;
			}
		}
		return null;
	}
}
