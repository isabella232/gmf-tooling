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
package org.eclipse.gmf.internal.sketch.transformer.reconcile;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.internal.common.reconcile.Matcher;

/**
 * @author dstadnik
 */
public class PropertyMatcher implements Matcher {

	private EAttribute property;

	public PropertyMatcher(EAttribute property) {
		this.property = property;
	}

	public boolean match(EObject newElement, EObject oldElement) {
		Object newValue = getValue(newElement);
		Object oldValue = getValue(oldElement);
		return newValue != null && oldValue != null && newValue.equals(oldValue);
	}

	protected Object getValue(EObject element) {
		if (element.eClass().getEAllAttributes().contains(property)) {
			return element.eGet(property);
		}
		return null;
	}
}
