package org.eclipse.gmf.examples.eclipsecon.library.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.part.Library07DiagramEditorPlugin;
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

		DiagramGeneralPreferencePage.initDefaults(store);

		DiagramAppearancePreferencePage.initDefaults(store);

		DiagramConnectionsPreferencePage.initDefaults(store);

		DiagramPrintingPreferencePage.initDefaults(store);

		DiagramRulersAndGridPreferencePage.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return Library07DiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
