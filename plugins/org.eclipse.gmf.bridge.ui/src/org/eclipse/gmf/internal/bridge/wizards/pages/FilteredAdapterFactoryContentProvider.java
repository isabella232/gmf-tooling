/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    dstadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.wizards.pages;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

public class FilteredAdapterFactoryContentProvider extends AdapterFactoryContentProvider {

	public FilteredAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Override to hide specific elements.
	 */
	protected boolean isShown(Object element) {
		return true;
	}

	public Object[] getChildren(Object object) {
		Object[] children = super.getChildren(object);
		if (children.length == 0) {
			return children;
		}
		ArrayList shownChildren = new ArrayList(children.length);
		for (int i = 0; i < children.length; i++) {
			if (isShown(children[i])) {
				shownChildren.add(children[i]);
			}
		}
		return shownChildren.toArray(new Object[shownChildren.size()]);
	}

	public boolean hasChildren(Object object) {
		return getChildren(object).length > 0;
	}

	public Object[] getElements(Object object) {
		return getChildren(object);
	}
}
