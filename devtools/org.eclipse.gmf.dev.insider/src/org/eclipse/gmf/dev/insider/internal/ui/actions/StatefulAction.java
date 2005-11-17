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
package org.eclipse.gmf.dev.insider.internal.ui.actions;

import org.eclipse.gmf.dev.insider.internal.InsiderPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

/**
 * @author dstadnik
 */
abstract class StatefulAction extends Action {

	public StatefulAction(String text) {
		super(text, AS_CHECK_BOX);
		restoreState();
		addPropertyChangeListener(new IPropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent event) {
				if (CHECKED.equals(event.getProperty())) {
					saveState();
				}
			}
		});
	}

	protected abstract String getKey();

	protected void restoreState() {
		setChecked(getStore().getBoolean(getKey()));
	}

	protected void saveState() {
		getStore().setValue(getKey(), isChecked());
	}

	protected IPreferenceStore getStore() {
		return InsiderPlugin.getInstance().getPreferenceStore();
	}
}
