/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.navigator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TaiPanNavigatorItem extends TaiPanAbstractNavigatorItem {

	/**
	 * @generated
	 */
	private View myView;

	/**
	 * @generated
	 */
	public TaiPanNavigatorItem(View view) {
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
		return TaiPanVisualIDRegistry.getModelID(myView);
	}

	/**
	 * @generated
	 */
	public int getVisualID() {
		return TaiPanVisualIDRegistry.getVisualID(myView);
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

}
