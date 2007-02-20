package org.eclipse.gmf.examples.eclipsecon.library.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;

import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * @generated
 */
public abstract class Library07AbstractNavigatorItem implements IAdaptable {

	/**
	 * @generated
	 */
	static {
		final Class[] supportedTypes = new Class[] { ITabbedPropertySheetPageContributor.class };
		final ITabbedPropertySheetPageContributor propertySheetPageContributor = new ITabbedPropertySheetPageContributor() {
			public String getContributorId() {
				return "org.eclipse.gmf.examples.eclipsecon.library.diagram"; //$NON-NLS-1$
			}
		};
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof Library07AbstractNavigatorItem
						&& adapterType == ITabbedPropertySheetPageContributor.class) {
					return propertySheetPageContributor;
				}
				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, Library07AbstractNavigatorItem.class);
	}

	/**
	 * @generated
	 */
	private Object myParent;

	/**
	 * @generated
	 */
	protected Library07AbstractNavigatorItem(Object parent) {
		myParent = parent;
	}

	/**
	 * @generated
	 */
	public Object getParent() {
		return myParent;
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

}
