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
package org.eclipse.gmf.dev.insider.internal;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class ViewManager {

	public static final String CONTENTS_PROPERTY = "contents"; //$NON-NLS-1$

	public int getViewCount() {
		return myViews.size();
	}

	public View[] getViews() {
		return (View[]) myViews.toArray(new View[myViews.size()]);
	}

	public View getView(int i) {
		return (View) myViews.get(i);
	}

	public View getView(Element element) {
		return (View) myViewElements.get(element);
	}

	public void add(View view) {
		assert view != null;
		View[] oldViews = getViews();
		myViews.add(view);
		Element[] elements = view.getElements();
		for (int i = 0; i < elements.length; i++) {
			myViewElements.put(elements[i], view);
		}
		View[] newViews = getViews();
		myPropertyChangeListeners.firePropertyChange(CONTENTS_PROPERTY, oldViews, newViews);
	}

	public void remove(int i) {
		View[] oldViews = getViews();
		View view = (View) myViews.remove(i);
		if (view != null) {
			Element[] elements = view.getElements();
			for (int j = 0; j < elements.length; j++) {
				myViewElements.remove(elements[j]);
			}
		}
		View[] newViews = getViews();
		myPropertyChangeListeners.firePropertyChange(CONTENTS_PROPERTY, oldViews, newViews);
	}

	public void remove(View view) {
		assert view != null;
		View[] oldViews = getViews();
		myViews.remove(view);
		Element[] elements = view.getElements();
		for (int j = 0; j < elements.length; j++) {
			myViewElements.remove(elements[j]);
		}
		View[] newViews = getViews();
		myPropertyChangeListeners.firePropertyChange(CONTENTS_PROPERTY, oldViews, newViews);
	}

	public void removeAll() {
		View[] oldViews = getViews();
		myViews.clear();
		myViewElements.clear();
		View[] newViews = getViews();
		myPropertyChangeListeners.firePropertyChange(CONTENTS_PROPERTY, oldViews, newViews);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		myPropertyChangeListeners.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		myPropertyChangeListeners.removePropertyChangeListener(listener);
	}

	private List myViews = new ArrayList(); // : View
	private Map myViewElements = new HashMap(); // root view element : Element -> view : View
	private PropertyChangeSupport myPropertyChangeListeners = new PropertyChangeSupport(this);
}
