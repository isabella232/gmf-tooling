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
package org.eclipse.gmf.internal.codegen.wizards;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.internal.codegen.CodeGenUIPlugin;
import org.eclipse.gmf.internal.codegen.resolver.Resolution;
import org.eclipse.gmf.internal.codegen.resolver.ResolvedItem;
import org.eclipse.gmf.internal.codegen.resolver.StructureBuilder;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class DefinitionPage extends WizardPage {

	private StructureBuilder structureBuilder;

	private DomainModelSource domainModelSource;

	protected Label msg;

	protected TreeViewer viewer;

	public DefinitionPage(String pageId, StructureBuilder structureBuilder, DomainModelSource domainModelSource) {
		super(pageId);
		this.structureBuilder = structureBuilder;
		this.domainModelSource = domainModelSource;
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
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

	protected TreeViewer createViewer(Composite parent) {
		Tree tree = new Tree(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		TableLayout layout = new TableLayout();
		tree.setLayout(layout);
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		TreeColumn elementColumn = new TreeColumn(tree, SWT.LEFT);
		elementColumn.setText("Element");
		elementColumn.setResizable(true);
		layout.addColumnData(new ColumnWeightData(5, 32, true));

		addResolutionColumn(tree, Resolution.NODE);
		addResolutionColumn(tree, Resolution.LINK);
		addResolutionColumn(tree, Resolution.LABEL);

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

	protected TreeColumn addResolutionColumn(Tree tree, Resolution resolution) {
		TreeColumn column = new TreeColumn(tree, SWT.LEFT);
		column.setText(resolution.getName());
		column.setResizable(true);
		((TableLayout) tree.getLayout()).addColumnData(new ColumnWeightData(1, 16, true));
		return column;
	}

	protected void createAdditionalControls(Composite parent) {
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
			msg.setText(domainModelSource.getStatus());
			if (contents != null) {
				setPageComplete(validatePage());
			} else {
				setPageComplete(domainModelSource.getError() == null);
			}
		}
	}

	public ResolvedItem getModel() {
		return (ResolvedItem) viewer.getInput();
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
			Image checkedIcon = CodeGenUIPlugin.getDefault().getImageRegistry().get(CodeGenUIPlugin.CHECKED_ICON);
			Image uncheckedIcon = CodeGenUIPlugin.getDefault().getImageRegistry().get(CodeGenUIPlugin.UNCHECKED_ICON);
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
