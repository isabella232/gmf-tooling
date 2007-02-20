package org.eclipse.gmf.examples.eclipsecon.library.diagram.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class Library07NavigatorItem extends Library07AbstractNavigatorItem {

	/**
	 * @generated
	 */
	static {
		final Class[] supportedTypes = new Class[] { View.class, EObject.class };
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof Library07NavigatorItem
						&& (adapterType == View.class || adapterType == EObject.class)) {
					return ((Library07NavigatorItem) adaptableObject).getView();
				}
				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, Library07NavigatorItem.class);
	}

	/**
	 * @generated
	 */
	private View myView;

	/**
	 * @generated
	 */
	private boolean myLeaf = false;

	/**
	 * @generated
	 */
	public Library07NavigatorItem(View view, Object parent, boolean isLeaf) {
		super(parent);
		myView = view;
		myLeaf = isLeaf;
	}

	/**
	 * @generated
	 */
	public View getView() {
		return myView;
	}

	/**
	 * @generated
	 */
	public boolean isLeaf() {
		return myLeaf;
	}

	/**
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Library07NavigatorItem) {
			EObject eObject = getView().getElement();
			EObject anotherEObject = ((Library07NavigatorItem) obj).getView()
					.getElement();
			if (eObject == null) {
				return anotherEObject == null;
			} else if (anotherEObject == null) {
				return false;
			}
			if (eObject.eResource() != null) {
				return eObject.eResource().getURIFragment(eObject).equals(
						anotherEObject.eResource().getURIFragment(
								anotherEObject));
			}
		}
		return super.equals(obj);
	}

}
