package org.eclipse.gmf.map.edit.ocl.providers;

import static org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.gmf.map.edit.ocl.editor.OCLEmbeddedEditor;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ConstraintPropertyDescriptor extends PropertyDescriptor {

	public ConstraintPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
	}

	public List<EClassifier> computeContexts(Object object){
		List<EClassifier> contexts = new ArrayList<EClassifier>();

		if (object instanceof Constraint) {
			EObject root = EcoreUtil.getRootContainer(((Constraint)object));
			if (root instanceof Mapping) {
				for (TopNodeReference node: ((Mapping) root).getNodes()) {
					contexts.add( node.getChild().getDomainContext() );
				}
			}
		}

		return contexts;
	}

	private static class OCLInputDialog extends Dialog {

		private OCLEmbeddedEditor editor;
		private List<EClassifier> contexts;
		private Map<String, EClassifier> parameters;
		private String title;
		private String message;
		private String initialValue;

		public OCLInputDialog(Shell parentShell, String title, String message, String initialValue, IInputValidator validator) {
			super(parentShell);
			this.title = title;
			this.message = message;
			this.initialValue = initialValue;
			setShellStyle(parentShell.getStyle() | SWT.RESIZE);
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite composite = (Composite) super.createDialogArea(parent);
			GridData gridData = (GridData) composite.getLayoutData();
			gridData.widthHint = 400;
			gridData.heightHint = 200;

			Composite contextComposite = null;
			ComboViewer contextCombo = null;
			
			if (contexts != null && contexts.size() > 0) {
				contextComposite = new Composite(composite, SWT.NONE);
				GridLayout gridLayout = new GridLayout(2, false);
				contextComposite.setLayout(gridLayout);

				Label label = new Label(contextComposite, SWT.NONE);
				label.setText("Select context:");

				contextCombo = new ComboViewer(contextComposite, SWT.READ_ONLY);
				contextCombo.setContentProvider(ArrayContentProvider.getInstance());
				
				contextCombo.setLabelProvider(new LabelProvider() {
					@Override
					public String getText(Object element) {
						AdapterFactoryEditingDomain editingDomain;
						AdapterFactoryItemDelegator itemDelegator;
						if (element instanceof EObject) {
							editingDomain = (AdapterFactoryEditingDomain) getEditingDomainFor(element);
							if (editingDomain != null) {
								itemDelegator = new AdapterFactoryItemDelegator(editingDomain.getAdapterFactory());
								return itemDelegator.getText(element);
							}
						}
						return super.getText(element);
					}
				});

				contextCombo.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection selection = (IStructuredSelection) event.getSelection();
						Object selected = selection.getFirstElement();
						if (selected instanceof EClassifier) {
							editor.setContext((EClassifier) selected, parameters);
						}
					}
				});
			}

			editor = new OCLEmbeddedEditor(composite);
			parent.getShell().setText(title);
			
			if (contexts != null && contexts.size() > 0) {
				contextCombo.setInput(contexts.toArray());
				contextCombo.setSelection(new StructuredSelection(contexts.get(0)));
			}

			return composite;
		}

		public String getValue() {
			return editor.getValue();
		}

		public void setContexts(List<EClassifier> contexts) {
			this.contexts = contexts;
		}

		public void setParameters(Map<String, EClassifier> parameters) {
			this.parameters = parameters;
		}

	}

	@Override
	protected CellEditor createEDataTypeCellEditor(final EDataType eDataType, Composite composite) {
		return new ExtendedDialogCellEditor(composite, getEditLabelProvider()) {
			protected EDataTypeValueHandler valueHandler = new EDataTypeValueHandler(eDataType);

			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				OCLInputDialog dialog = new OCLInputDialog
						(cellEditorWindow.getShell(),
								EMFEditUIPlugin.INSTANCE.getString
								("_UI_FeatureEditorDialog_title", new Object [] { getDisplayName(), getEditLabelProvider().getText(object) }),
								EMFEditUIPlugin.INSTANCE.getString("_UI_MultiLineInputDialog_message"),
								valueHandler.toString(getValue()),
								valueHandler);

				dialog.setContexts(computeContexts(object));
				dialog.setParameters(Collections.<String, EClassifier>emptyMap());

				return dialog.open() == Window.OK ? valueHandler.toValue(dialog.getValue()) : null;
			}
		};
	}



}
