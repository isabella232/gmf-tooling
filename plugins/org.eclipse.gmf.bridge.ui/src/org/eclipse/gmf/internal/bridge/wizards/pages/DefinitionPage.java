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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.internal.bridge.resolver.Resolution;
import org.eclipse.gmf.internal.bridge.resolver.ResolvedItem;
import org.eclipse.gmf.internal.bridge.resolver.StructureBuilder;
import org.eclipse.gmf.internal.bridge.ui.Plugin;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

/**
 * @author dstadnik
 */
public class DefinitionPage extends WizardPage {

	private StructureBuilder structureBuilder;

	private DomainModelSource domainModelSource;

	private DiagramElementSelector diagramElementSelector;

	private Composite innerPlate;

	private StackLayout innerPlateLayout;

	private TreeViewer viewer;

	private Button deselectAllButton;

	private Button recognizeButton;

	private Text errorDetails;

	public DefinitionPage(String pageId, StructureBuilder structureBuilder, DomainModelSource domainModelSource) {
		super(pageId);
		this.structureBuilder = structureBuilder;
		this.domainModelSource = domainModelSource;
		//diagramElementSelector = new DiagramElementSelector();
	}

	protected GridData createFillBothGridData(int span) {
		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.grabExcessVerticalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = span;
		return data;
	}

	protected GridData createFillHorzGridData(int span) {
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = span;
		return data;
	}

	public void createControl(Composite parent) {
		innerPlate = new Composite(parent, SWT.NONE);
		innerPlate.setLayoutData(createFillBothGridData(1));
		innerPlate.setLayout(innerPlateLayout = new StackLayout());
		innerPlateLayout.topControl = createDomainModelGroup(innerPlate);
		createErrorGroup(innerPlate);
		setPageComplete(false);
		setControl(innerPlate);
	}

	private Composite createDomainModelGroup(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		plate.setLayout(layout);
		if (diagramElementSelector != null) {
			diagramElementSelector.createControl(plate);
		}
		Label domainModelElementsLabel = new Label(plate, SWT.NONE);
		domainModelElementsLabel.setText("Domain model elements to process:");
		domainModelElementsLabel.setLayoutData(createFillHorzGridData(2));
		Composite viewerPlate = createViewerGroup(plate);
		viewerPlate.setLayoutData(createFillBothGridData(2));
		plate.setLayoutData(createFillBothGridData(1));
		return plate;
	}

	private Composite createViewerGroup(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		plate.setLayout(layout);
		viewer = createViewer(plate);
		viewer.getControl().setLayoutData(createFillBothGridData(1));
		Composite buttonsPlate = createDomainModelButtons(plate);
		buttonsPlate.setLayoutData(new GridData(GridData.FILL_VERTICAL));
		return plate;
	}

	private Composite createErrorGroup(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 12;
		plate.setLayout(layout);
		Label errorDescription = new Label(plate, SWT.NONE);
		errorDescription.setText("Error loading domain model:");
		errorDescription.setLayoutData(createFillHorzGridData(1));
		errorDetails = new Text(plate, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		errorDetails.setLayoutData(createFillBothGridData(1));
		return plate;
	}

	private Composite createDomainModelButtons(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 12;
		plate.setLayout(layout);
		deselectAllButton = new Button(plate, SWT.PUSH);
		deselectAllButton.setLayoutData(createFillHorzGridData(1));
		deselectAllButton.setText("Deselect All");
		deselectAllButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				deselectChildren(getModel());
				viewer.refresh(true);
			}

			private void deselectChildren(ResolvedItem item) {
				for (Iterator it = item.getChildren().iterator(); it.hasNext();) {
					ResolvedItem child = (ResolvedItem) it.next();
					child.setResolution(null);
					deselectChildren(child);
				}
			}
		});
		recognizeButton = new Button(plate, SWT.PUSH);
		recognizeButton.setLayoutData(createFillHorzGridData(1));
		recognizeButton.setText("Defaults");
		recognizeButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				EPackage contents = domainModelSource.getContents();
				viewer.setInput(contents == null ? null : structureBuilder.process(contents, null));
				viewer.expandAll();
				if (diagramElementSelector != null) {
					diagramElementSelector.setDomainModel(getModel());
				}
				if (contents != null) {
					setPageComplete(validatePage());
				} else {
					setPageComplete(true);
				}
				showDomainModelControls();
			}
		});
		return plate;
	}

	protected TreeViewer createViewer(Composite parent) {
		Tree tree = new Tree(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		TableLayout layout = new TableLayout() {

			public void layout(Composite c, boolean flush) {
				super.layout(c, flush);
				TreeColumn elementColumn = ((Tree) c).getColumn(0);
				int width = elementColumn.getWidth() - 8; // shrink resizable column by right scroller width
				if (width < 0) {
					width = 0;
				}
				elementColumn.setWidth(width);
			}
		};
		tree.setLayout(layout);
		tree.setHeaderVisible(true);
		// tree.setLinesVisible(true);

		TreeColumn elementColumn = new TreeColumn(tree, SWT.LEFT);
		elementColumn.setText("Element");
		elementColumn.setResizable(true);
		layout.addColumnData(new ColumnWeightData(1, 32, true));

		addResolutionColumn(tree, Resolution.NODE, Plugin.NODE_ICON);
		addResolutionColumn(tree, Resolution.LINK, Plugin.LINK_ICON);
		addResolutionColumn(tree, Resolution.LABEL, Plugin.LABEL_ICON);

		return viewer = DomainModelViewerFactory.createViewer(tree);
	}

	protected TreeColumn addResolutionColumn(Tree tree, Resolution resolution, String iconId) {
		TreeColumn column = new TreeColumn(tree, SWT.CENTER);
		// column.setText(resolution.getName());
		column.setImage(Plugin.getDefault().getImageRegistry().get(iconId));
		column.setResizable(false);
		((TableLayout) tree.getLayout()).addColumnData(new ColumnPixelData(18, false, true));
		return column;
	}

	protected boolean validatePage() {
		return true;
	}

	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible && domainModelSource.update()) {
			EPackage contents = domainModelSource.getContents();
			viewer.setInput(contents == null ? null : structureBuilder.process(contents, null));
			viewer.expandAll();
			viewer.getControl().pack();
			if (contents != null) {
				// domain model is loaded ok
				if (diagramElementSelector != null) {
					diagramElementSelector.setDomainModel(getModel());
				}
				setPageComplete(validatePage());
				showDomainModelControls();
			} else {
				if (domainModelSource.getErrorStatus() == null) {
					// empty domain model
					if (diagramElementSelector != null) {
						diagramElementSelector.setDomainModel(null);
					}
					setPageComplete(true);
					showDomainModelControls();
				} else {
					// error loading domain model
					setPageComplete(false);
					try {
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						domainModelSource.getErrorStatus().getException().printStackTrace(ps);
						ps.flush();
						baos.flush();
						errorDetails.setText(baos.toString());
					} catch (IOException e) {
						// never happens
					}
					showErrorDetailsControls();
				}
			}
			innerPlate.layout(true, true);
		}
	}

	protected void showDomainModelControls() {
		innerPlateLayout.topControl = innerPlate.getChildren()[0];
	}

	protected void showErrorDetailsControls() {
		innerPlateLayout.topControl = innerPlate.getChildren()[1];
	}

	public ResolvedItem getModel() {
		return (ResolvedItem) viewer.getInput();
	}

	public ResolvedItem getDiagramElement() {
		return diagramElementSelector == null ? null : diagramElementSelector.getDiagramElement();
	}
}
