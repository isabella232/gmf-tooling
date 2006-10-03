/*
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.ecore.navigator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EcoreNavigatorItem extends EcoreAbstractNavigatorItem {

	/**
	 * @generated
	 */
	private View myView;

	/**
	 * @generated
	 */
	public EcoreNavigatorItem(View view, Object parent) {
		super(parent);
		myView = view;
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
	public String getModelID() {
		return EcoreVisualIDRegistry.getModelID(myView);
	}

	/**
	 * @generated
	 */
	public int getVisualID() {
		return EcoreVisualIDRegistry.getVisualID(myView);
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class adapter) {
		if (View.class.isAssignableFrom(adapter) || EObject.class.isAssignableFrom(adapter)) {
			return myView;
		}
		return super.getAdapter(adapter);
	}

	/**
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj instanceof EcoreNavigatorItem) {
			EObject eObject = getView().getElement();
			EObject anotherEObject = ((EcoreNavigatorItem) obj).getView().getElement();
			if (eObject == null) {
				return anotherEObject == null;
			} else if (anotherEObject == null) {
				return false;
			}
			return eObject.eResource().getURIFragment(eObject).equals(anotherEObject.eResource().getURIFragment(anotherEObject));
		}
		return super.equals(obj);
	}

}
