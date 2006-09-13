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
package org.eclipse.gmf.ecore.part;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.viewers.LabelProvider;

import org.eclipse.swt.graphics.Image;

import org.eclipse.ui.IMemento;

import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class EcoreNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider {

	/**
	 * @generated
	 */
	private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(EcoreDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof View) {
			View view = (View) element;
			EObject eObject = view.getElement();
			return myAdapterFactoryLabelProvider.getImage(eObject);
		}
		//		 else if (element instanceof EcoreNavigatorGroup) {
		//			return ((EcoreNavigatorGroup) element).getIcon();
		//		}
		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof View) {
			View view = (View) element;
			EObject eObject = view.getElement();
			return myAdapterFactoryLabelProvider.getText(eObject);
		} else if (element instanceof EcoreNavigatorGroup) {
			return ((EcoreNavigatorGroup) element).getGroupName();
		}
		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

}
