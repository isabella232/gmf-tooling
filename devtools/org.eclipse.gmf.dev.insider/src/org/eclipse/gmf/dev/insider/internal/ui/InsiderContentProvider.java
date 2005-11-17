/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev.insider.internal.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.gmf.dev.insider.internal.InsiderAccess;
import org.eclipse.gmf.dev.insider.internal.View;
import org.eclipse.gmf.dev.insider.internal.ViewManager;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class InsiderContentProvider implements ITreeContentProvider {

	public Object getParent(Object object) {
		if (object instanceof Element) {
			Element element = (Element) object;
			View view = InsiderAccess.getViewManager().getView(element);
			if (view != null) {
				return view;
			}
			return InsiderAccess.getContentBuilderManager().getParentContribution(element);
		} else if (object instanceof View) {
			return InsiderAccess.getViewManager();
		}
		return null;
	}

	public Object[] getChildren(Object parentObject) {
		if (parentObject instanceof Element) {
			Element element = (Element) parentObject;
			return InsiderAccess.getContentBuilderManager().getChildContributions(element);
		} else if (parentObject instanceof View) {
			View view = (View) parentObject;
			return view.getElements();
		} else if (parentObject instanceof ViewManager) {
			ViewManager manager = (ViewManager) parentObject;
			return manager.getViews();
		}
		return null;
	}

	public boolean hasChildren(Object parentObject) {
		if (parentObject instanceof Element) {
			Element element = (Element) parentObject;
			return InsiderAccess.getContentBuilderManager().hasChildContributions(element);
		} else if (parentObject instanceof View) {
			View view = (View) parentObject;
			return view.hasElements();
		} else if (parentObject instanceof ViewManager) {
			ViewManager manager = (ViewManager) parentObject;
			return manager.getViewCount() > 0;
		}
		return false;
	}

	public Object[] getElements(Object inputObject) {
		return getChildren(inputObject);
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
		if (oldInput instanceof ViewManager) {
			((ViewManager) oldInput).removePropertyChangeListener(myViewManagerListener);
		}
		if (newInput instanceof ViewManager) {
			((ViewManager) newInput).addPropertyChangeListener(myViewManagerListener);
		}
	}

	public void dispose() {}

	private PropertyChangeListener myViewManagerListener = new PropertyChangeListener() {

		public void propertyChange(PropertyChangeEvent evt) {
			if (ViewManager.CONTENTS_PROPERTY.equals(evt.getPropertyName()) && myViewer != null) {
				myViewer.refresh();
			}
		}
	};

	private Viewer myViewer;
}
