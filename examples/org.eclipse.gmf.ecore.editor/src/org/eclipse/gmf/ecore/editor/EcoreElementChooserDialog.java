package org.eclipse.gmf.ecore.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;

/**
 * @generated
 */
public class EcoreElementChooserDialog extends Dialog {

	private AdapterFactory myModelAdapterFactory = null;

	private TreeViewer myTreeViewer;

	private EObject mySelectedModelElement;

	/**
	 * @generated
	 */
	public EcoreElementChooserDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	/**
	 * @generated
	 */
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		createModelBrowser(composite);
		return composite;
	}

	/**
	 * @generated
	 */
	protected Control createButtonBar(Composite parent) {
		Control buttonBar = super.createButtonBar(parent);
		setOkButtonEnabled(false);
		return buttonBar;
	}

	/**
	 * @generated
	 */
	private void createModelBrowser(Composite composite) {
		myTreeViewer = new TreeViewer(composite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.heightHint = 300;
		layoutData.widthHint = 300;
		myTreeViewer.getTree().setLayoutData(layoutData);
		myTreeViewer.setContentProvider(new ModelElementsTreeContentProvider());
		myTreeViewer.setLabelProvider(new ModelElementsTreeLabelProvider());
		myTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
		myTreeViewer.addFilter(new ModelFilesFilter());
		myTreeViewer.addSelectionChangedListener(new OkButtonEnabler());
	}

	/**
	 * @generated
	 */
	private void setOkButtonEnabled(boolean enabled) {
		getButton(IDialogConstants.OK_ID).setEnabled(enabled);
	}

	/**
	 * @generated
	 */
	private boolean isValidModelFile(IFile file) {
		return "ecore".equals(file.getFullPath().getFileExtension());
	}

	/**
	 * @generated
	 */
	private AdapterFactory getModelAdapterFactory() {
		if (myModelAdapterFactory == null) {
			List factories = new ArrayList();
			factories.add(new ResourceItemProviderAdapterFactory());
			factories.add(new EcoreItemProviderAdapterFactory());
			factories.add(new ReflectiveItemProviderAdapterFactory());
			myModelAdapterFactory = new ComposedAdapterFactory(factories);
		}
		return myModelAdapterFactory;
	}

	/**
	 * @generated
	 */
	public EObject getSelectedModelElement() {
		return mySelectedModelElement;
	}

	/**
	 * @generated
	 */
	private class ModelElementsTreeContentProvider implements ITreeContentProvider {

		private ITreeContentProvider myWorkbenchContentProvider = new WorkbenchContentProvider();

		private AdapterFactoryContentProvider myAdapterFctoryContentProvier = new AdapterFactoryContentProvider(getModelAdapterFactory());

		/**
		 * @generated
		 */
		public Object[] getChildren(Object parentElement) {
			Object[] result = myWorkbenchContentProvider.getChildren(parentElement);
			if (result != null && result.length > 0) {
				return result;
			}
			if (parentElement instanceof IFile) {
				IFile modelFile = (IFile) parentElement;
				String resourcePath = modelFile.getLocation().toOSString();
				Resource modelResource = ResourceUtil.findResource(resourcePath);
				if (modelResource == null) {
					modelResource = ResourceUtil.create(resourcePath);
				}
				if (!modelResource.isLoaded()) {
					try {
						ResourceUtil.load(modelResource);
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
				return myAdapterFctoryContentProvier.getChildren(modelResource);
			}
			return myAdapterFctoryContentProvier.getChildren(parentElement);
		}

		/**
		 * @generated
		 */
		public Object getParent(Object element) {
			Object parent = myWorkbenchContentProvider.getParent(element);
			if (parent != null) {
				return parent;
			}
			if (element instanceof EObject) {
				EObject eObject = (EObject) element;
				if (eObject.eContainer() == null && eObject.eResource().getURI().isFile()) {
					String path = eObject.eResource().getURI().path();
					return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(path));
				}
				return myAdapterFctoryContentProvier.getParent(eObject);
			}
			return null;
		}

		/**
		 * @generated
		 */
		public boolean hasChildren(Object element) {
			if (element instanceof IFile) {
				return isValidModelFile((IFile) element);
			}
			return myWorkbenchContentProvider.hasChildren(element) || myAdapterFctoryContentProvier.hasChildren(element);
		}

		/**
		 * @generated
		 */
		public Object[] getElements(Object inputElement) {
			Object[] elements = myWorkbenchContentProvider.getElements(inputElement);
			return elements;
		}

		/**
		 * @generated
		 */
		public void dispose() {
			myWorkbenchContentProvider.dispose();
			myAdapterFctoryContentProvier.dispose();
		}

		/**
		 * @generated
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			myWorkbenchContentProvider.inputChanged(viewer, oldInput, newInput);
			myAdapterFctoryContentProvier.inputChanged(viewer, oldInput, newInput);
		}

	}

	/**
	 * @generated
	 */
	private class ModelElementsTreeLabelProvider implements ILabelProvider {

		private WorkbenchLabelProvider myWorkbenchLabelProvider = new WorkbenchLabelProvider();

		private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(getModelAdapterFactory());

		/**
		 * @generated
		 */
		public Image getImage(Object element) {
			Image result = myWorkbenchLabelProvider.getImage(element);
			return result != null ? result : myAdapterFactoryLabelProvider.getImage(element);
		}

		/**
		 * @generated
		 */
		public String getText(Object element) {
			String result = myWorkbenchLabelProvider.getText(element);
			return result != null && result.length() > 0 ? result : myAdapterFactoryLabelProvider.getText(element);
		}

		/**
		 * @generated
		 */
		public void addListener(ILabelProviderListener listener) {
			myWorkbenchLabelProvider.addListener(listener);
			myAdapterFactoryLabelProvider.addListener(listener);
		}

		/**
		 * @generated
		 */
		public void dispose() {
			myWorkbenchLabelProvider.dispose();
			myAdapterFactoryLabelProvider.dispose();
		}

		/**
		 * @generated
		 */
		public boolean isLabelProperty(Object element, String property) {
			return myWorkbenchLabelProvider.isLabelProperty(element, property) || myAdapterFactoryLabelProvider.isLabelProperty(element, property);
		}

		/**
		 * @generated
		 */
		public void removeListener(ILabelProviderListener listener) {
			myWorkbenchLabelProvider.removeListener(listener);
			myAdapterFactoryLabelProvider.removeListener(listener);
		}

	}

	/**
	 * @generated
	 */
	private class ModelFilesFilter extends ViewerFilter {

		/**
		 * @generated
		 */
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof IContainer) {
				return true;
			}
			if (element instanceof IFile) {
				IFile file = (IFile) element;
				return isValidModelFile(file);
			}
			return true;
		}

	}

	/**
	 * @generated
	 */
	private class OkButtonEnabler implements ISelectionChangedListener {

		/**
		 * @generated
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			if (event.getSelection() instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (selection.size() == 1 && selection.getFirstElement() instanceof EObject) {
					mySelectedModelElement = (EObject) selection.getFirstElement();
					setOkButtonEnabled(true);
					return;
				}
			}
			mySelectedModelElement = null;
			setOkButtonEnabled(false);
		}

	}

}
