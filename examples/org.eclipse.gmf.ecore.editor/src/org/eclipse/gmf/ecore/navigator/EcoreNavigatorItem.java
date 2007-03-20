/*
 *  Copyright (c) 2006, 2007 Borland Software Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EcoreNavigatorItem extends EcoreAbstractNavigatorItem {

	/**
	 * @generated
	 */
	static {
		final Class[] supportedTypes = new Class[] { View.class, EObject.class };
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof org.eclipse.gmf.ecore.navigator.EcoreNavigatorItem && (adapterType == View.class || adapterType == EObject.class)) {
					return ((org.eclipse.gmf.ecore.navigator.EcoreNavigatorItem) adaptableObject).getView();
				}
				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, org.eclipse.gmf.ecore.navigator.EcoreNavigatorItem.class);
	}

	/**
	 * @generated
	 */
	private static org.eclipse.emf.common.util.URI getURI(EObject object) {
		if (object.eIsProxy()) {
			return ((InternalEObject) object).eProxyURI();
		}
		Resource resource = object.eResource();
		return resource.getURI().appendFragment(resource.getURIFragment(object));
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
	public EcoreNavigatorItem(View view, Object parent, boolean isLeaf) {
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
		if (obj instanceof org.eclipse.gmf.ecore.navigator.EcoreNavigatorItem) {
			EObject eObject = getView().getElement();
			EObject anotherEObject = ((org.eclipse.gmf.ecore.navigator.EcoreNavigatorItem) obj).getView().getElement();
			if (eObject == null) {
				return anotherEObject == null;
			} else if (anotherEObject == null) {
				return false;
			}
			return getURI(eObject).equals(getURI(anotherEObject));
		}
		return super.equals(obj);
	}

	/**
	 * @generated
	 */
	public int hashCode() {
		return getURI(getView().getElement()).hashCode();
	}

}
