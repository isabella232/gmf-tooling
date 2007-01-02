/*
 *  Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanDiagramEditorPlugin;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.FontData;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		PreferenceConverter.setDefault(store, IPreferenceConstants.PREF_DEFAULT_FONT, new FontData("monospaced", 12, org.eclipse.swt.SWT.NORMAL));

		PreferenceConverter.setDefault(store, IPreferenceConstants.PREF_FONT_COLOR, DiagramColorConstants.black.getRGB());

		PreferenceConverter.setDefault(store, IPreferenceConstants.PREF_FILL_COLOR, DiagramColorConstants.white.getRGB());

		PreferenceConverter.setDefault(store, IPreferenceConstants.PREF_LINE_COLOR, new org.eclipse.swt.graphics.RGB(64, 64, 64));

		DiagramGeneralPreferencePage.initDefaults(store);

		DiagramConnectionsPreferencePage.initDefaults(store);

		DiagramPrintingPreferencePage.initDefaults(store);

		DiagramRulersAndGridPreferencePage.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return TaiPanDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
