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
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.internal.bridge.resolver.NodePattern;
import org.eclipse.gmf.internal.bridge.resolver.Resolution;
import org.eclipse.gmf.internal.bridge.resolver.ResolvedItem;
import org.eclipse.gmf.internal.bridge.resolver.StructureBuilder;
import org.eclipse.gmf.internal.bridge.resolver.TypeLinkPattern;
import org.eclipse.gmf.internal.bridge.ui.Plugin;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

/**
 * @author dstadnik
 */
public class DefinitionPage extends WizardPage {

	private StructureBuilder structureBuilder;

	private DomainModelSource domainModelSource;

	private boolean allowDiagramElementSelection;

	private Composite innerPlate;

	private StackLayout innerPlateLayout;

	private Combo diagramElementSelector;

	private Button excludeContainedNodesChoice;

	private Button excludeLinksChoice;

	private TreeViewer viewer;

	private Button deselectAllButton;

	private Button recognizeButton;

	private Text errorDetails;

	public DefinitionPage(String pageId, StructureBuilder structureBuilder, DomainModelSource domainModelSource, boolean allowDiagramElementSelection) {
		super(pageId);
		this.structureBuilder = structureBuilder;
		this.domainModelSource = domainModelSource;
		this.allowDiagramElementSelection = allowDiagramElementSelection;
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
		innerPlateLayout.topControl = createDomainModelGroupEx(innerPlate);
		createErrorGroup(innerPlate);
		setPageComplete(false);
		setControl(innerPlate);
	}

	private Composite createDomainModelGroupEx(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayout(new GridLayout(2, false));
		Composite domainModelPlate = createDomainModelGroup(plate);
		domainModelPlate.setLayoutData(createFillBothGridData(1));
		Composite buttonsPlate = new Composite(plate, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 12;
		buttonsPlate.setLayout(layout);
		deselectAllButton = new Button(buttonsPlate, SWT.PUSH);
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
		recognizeButton = new Button(buttonsPlate, SWT.PUSH);
		recognizeButton.setLayoutData(createFillHorzGridData(1));
		recognizeButton.setText("Restore Defaults");
		recognizeButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				EPackage contents = domainModelSource.getContents();
				viewer.setInput(contents == null ? null : structureBuilder.process(contents));
				viewer.expandAll();
				updateDiagramElementSelector();
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

	private Composite createDomainModelGroup(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		plate.setLayout(layout);
		if (allowDiagramElementSelection) {
			Label diagramElementLabel = new Label(plate, SWT.NONE);
			diagramElementLabel.setText("Diagram element:");
			diagramElementLabel.setLayoutData(new GridData());
			diagramElementSelector = new Combo(plate, SWT.DROP_DOWN);
			diagramElementSelector.setLayoutData(createFillHorzGridData(1));
			diagramElementSelector.addSelectionListener(new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					// TODO : validate selection
				}

				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
			excludeContainedNodesChoice = createChoice(plate, "Exclude types that are resolved as nodes that have a container");
			excludeLinksChoice = createChoice(plate, "Exclude types that are resolved as links");
		}
		Label domainModelElementsLabel = new Label(plate, SWT.NONE);
		domainModelElementsLabel.setText("Domain model elements to process:");
		domainModelElementsLabel.setLayoutData(createFillHorzGridData(2));
		viewer = createViewer(plate);
		viewer.getControl().setLayoutData(createFillBothGridData(2));
		return plate;
	}

	private Button createChoice(Composite plate, String text) {
		Label dummy = new Label(plate, SWT.NONE);
		dummy.setLayoutData(new GridData());
		Button choice = new Button(plate, SWT.CHECK);
		choice.setText(text);
		choice.setLayoutData(createFillHorzGridData(1));
		choice.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				updateDiagramElementSelector();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		return choice;
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

	protected TreeViewer createViewer(Composite parent) {
		Tree tree = new Tree(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		TableLayout layout = new TableLayout();
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

		final TreeViewer viewer = new TreeViewer(tree);
		viewer.setContentProvider(new ResolverContentProvider());
		AdapterFactory adapterFactory = new EcoreItemProviderAdapterFactory();
		viewer.setLabelProvider(new ResolverLabelProvider(new AdapterFactoryLabelProvider(adapterFactory)));

		viewer.setColumnProperties(new String[] { "no", Resolution.NODE.getName(), Resolution.LINK.getName(), Resolution.LABEL.getName() });
		viewer.setCellEditors(new CellEditor[] { null, new CheckboxCellEditor(), new CheckboxCellEditor(), new CheckboxCellEditor() });
		viewer.setCellModifier(new ICellModifier() {

			public Object getValue(Object element, String property) {
				ResolvedItem item = (ResolvedItem) element;
				return Boolean.valueOf(item.getResolution() == Resolution.getByName(property));
			}

			public boolean canModify(Object element, String property) {
				return true;
			}

			public void modify(Object element, String property, Object value) {
				ResolvedItem item = (ResolvedItem) ((TreeItem) element).getData();
				Resolution resolution = Resolution.getByName(property);
				if (!item.isPossibleResolution(resolution)) {
					return;
				}
				item.setResolution(((Boolean) value).booleanValue() ? resolution : null);
				viewer.update(item, new String[] { Resolution.NODE.getName(), Resolution.LINK.getName(), Resolution.LABEL.getName() });
			}
		});

		return viewer;
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
			viewer.setInput(contents == null ? null : structureBuilder.process(contents));
			viewer.expandAll();
			viewer.getControl().pack();
			if (contents != null) {
				// domain model is loaded ok
				updateDiagramElementSelector();
				setPageComplete(validatePage());
				showDomainModelControls();
			} else {
				if (domainModelSource.getErrorStatus() == null) {
					// empty domain model
					updateDiagramElementSelector();
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
		if (!allowDiagramElementSelection) {
			return null;
		}
		return findResolvedItemByTypeName(getModel(), diagramElementSelector.getText());
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

	private void updateDiagramElementSelector() {
		if (!allowDiagramElementSelection) {
			return;
		}
		Set types = new TreeSet(new Comparator() {

			public int compare(Object arg0, Object arg1) {
				EClass type0 = (EClass) ((ResolvedItem) arg0).getDomainRef();
				EClass type1 = (EClass) ((ResolvedItem) arg1).getDomainRef();
				return type0.getName().compareToIgnoreCase(type1.getName());
			}
		});
		if (viewer.getInput() != null) {
			collectResolvedDomainTypes(types, (ResolvedItem) viewer.getInput());
		}
		String contents = diagramElementSelector.getText();
		diagramElementSelector.removeAll();
		for (Iterator it = types.iterator(); it.hasNext();) {
			EClass type = (EClass) ((ResolvedItem) it.next()).getDomainRef();
			diagramElementSelector.add(type.getName());
			if (contents.equals(type.getName())) {
				diagramElementSelector.setText(contents);
			}
		}
		if (diagramElementSelector.getText().length() == 0 && diagramElementSelector.getItemCount() > 0) {
			diagramElementSelector.setText(diagramElementSelector.getItem(0));
		}
		if (!contents.equals(diagramElementSelector.getText())) {
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

	protected static class ResolverContentProvider implements ITreeContentProvider {

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object getParent(Object element) {
			return ((ResolvedItem) element).getParent();
		}

		public Object[] getChildren(Object parentElement) {
			List children = ((ResolvedItem) parentElement).getChildren();
			return children.toArray();
		}

		public boolean hasChildren(Object element) {
			List children = ((ResolvedItem) element).getChildren();
			return !children.isEmpty();
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}
	}

	protected static class ResolverLabelProvider extends LabelProvider implements ITableLabelProvider {

		private ILabelProvider domainLabelProvider;

		public ResolverLabelProvider(ILabelProvider domainLabelProvider) {
			this.domainLabelProvider = domainLabelProvider;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (columnIndex == 0) {
				Object domainRef = ((ResolvedItem) element).getDomainRef();
				return domainLabelProvider.getText(domainRef);
			} else {
				return null;
			}
		}

		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				Object domainRef = ((ResolvedItem) element).getDomainRef();
				return domainLabelProvider.getImage(domainRef);
			}
			ResolvedItem item = (ResolvedItem) element;
			Image checkedIcon = Plugin.getDefault().getImageRegistry().get(Plugin.CHECKED_ICON);
			Image uncheckedIcon = Plugin.getDefault().getImageRegistry().get(Plugin.UNCHECKED_ICON);
			if (columnIndex == 1) {
				if (!item.isPossibleResolution(Resolution.NODE)) {
					return null;
				}
				return Resolution.NODE == item.getResolution() ? checkedIcon : uncheckedIcon;
			} else if (columnIndex == 2) {
				if (!item.isPossibleResolution(Resolution.LINK)) {
					return null;
				}
				return Resolution.LINK == item.getResolution() ? checkedIcon : uncheckedIcon;
			} else if (columnIndex == 3) {
				if (!item.isPossibleResolution(Resolution.LABEL)) {
					return null;
				}
				return Resolution.LABEL == item.getResolution() ? checkedIcon : uncheckedIcon;
			}
			return null;
		}
	}
}
