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

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class TaiPanNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof TaiPanNavigatorItem) {
			TaiPanNavigatorItem item = (TaiPanNavigatorItem) element;
			if (AquatoryEditPart.MODEL_ID.equals(item.getModelID())) {
				return item.getVisualID();
			}
		}
		return GROUP_CATEGORY;
	}

}
