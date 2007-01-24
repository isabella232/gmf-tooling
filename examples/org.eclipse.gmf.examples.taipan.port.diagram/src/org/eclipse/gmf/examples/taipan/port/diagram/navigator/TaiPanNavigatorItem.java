/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.port.diagram.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TaiPanNavigatorItem extends TaiPanAbstractNavigatorItem {

	/**
	 * @generated
	 */
	static {
		final Class[] supportedTypes = new Class[] { View.class, EObject.class };
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof TaiPanNavigatorItem && (adapterType == View.class || adapterType == EObject.class)) {
					return ((TaiPanNavigatorItem) adaptableObject).getView();
				}
				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, TaiPanNavigatorItem.class);
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
	public TaiPanNavigatorItem(View view, Object parent, boolean isLeaf) {
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
		if (obj instanceof TaiPanNavigatorItem) {
			EObject eObject = getView().getElement();
			EObject anotherEObject = ((TaiPanNavigatorItem) obj).getView().getElement();
			if (eObject == null) {
				return anotherEObject == null;
			} else if (anotherEObject == null) {
				return false;
			}
			if (eObject.eResource() != null) {
				return eObject.eResource().getURIFragment(eObject).equals(anotherEObject.eResource().getURIFragment(anotherEObject));
			}
		}
		return super.equals(obj);
	}

}
