/*
 *  Copyright (c) 2006, 2009 Borland Software Corporation and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gmf.graphdef.editor.part.GMFGraphDiagramEditorPlugin;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		store.setDefault(IPreferenceConstants.PREF_SHOW_CONNECTION_HANDLES, false);
		store.setDefault(IPreferenceConstants.PREF_SHOW_POPUP_BARS, false);
		store.setDefault(IPreferenceConstants.PREF_ENABLE_ANIMATED_LAYOUT, true);
		store.setDefault(IPreferenceConstants.PREF_ENABLE_ANIMATED_ZOOM, true);
		store.setDefault(IPreferenceConstants.PREF_ENABLE_ANTIALIAS, true);
		store.setDefault(IPreferenceConstants.PREF_LINE_STYLE, Routing.MANUAL);
		store.setDefault(IPreferenceConstants.PREF_SHOW_RULERS, false);
		store.setDefault(IPreferenceConstants.PREF_RULER_UNITS, RulerProvider.UNIT_INCHES);
		store.setDefault(IPreferenceConstants.PREF_SHOW_GRID, false);
		store.setDefault(IPreferenceConstants.PREF_SNAP_TO_GRID, true);
		store.setDefault(IPreferenceConstants.PREF_SNAP_TO_GEOMETRY, false);
		store.setDefault(IPreferenceConstants.PREF_GRID_SPACING, 0.125);
		store.setDefault(IPreferenceConstants.PREF_PROMPT_ON_DEL_FROM_MODEL, false);
		store.setDefault(IPreferenceConstants.PREF_PROMPT_ON_DEL_FROM_DIAGRAM, false);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return GMFGraphDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
