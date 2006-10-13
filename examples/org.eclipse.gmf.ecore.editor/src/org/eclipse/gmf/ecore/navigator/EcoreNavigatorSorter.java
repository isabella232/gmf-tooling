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

import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class EcoreNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7013;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof EcoreNavigatorItem) {
			EcoreNavigatorItem item = (EcoreNavigatorItem) element;
			if (EPackageEditPart.MODEL_ID.equals(item.getModelID())) {
				return item.getVisualID();
			}
		}
		return GROUP_CATEGORY;
	}

}
