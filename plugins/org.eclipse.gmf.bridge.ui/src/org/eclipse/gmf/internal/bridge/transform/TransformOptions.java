/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Fedorov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.transform;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.gmf.internal.bridge.ui.Plugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;


public class TransformOptions extends AbstractPreferenceInitializer {
	
	private static final String PREF_GENERATE_RCP = "generate_rcp"; //$NON-NLS-1$
	private static final String PREF_USE_MAP_MODE = "use_map_mode"; //$NON-NLS-1$
	private static final String PREF_USE_RUNTIME_FIGURES = "use_runtime_figures"; //$NON-NLS-1$
	private static final String PREF_IGNORE_MAPMODEL_VALIDATION = "ignore_mapmodel_validation"; //$NON-NLS-1$
	private static final String PREF_IGNORE_GMFGEN_VALIDATION = "ignore_gmfgen_validation"; //$NON-NLS-1$
	private static final String PREF_FIGURE_TEMPLATES = "dynamic_figure_templates"; //$NON-NLS-1$
	
	private static String[] PROP_NAMES = new String[] {
		PREF_GENERATE_RCP, 
		PREF_USE_MAP_MODE, 
		PREF_USE_RUNTIME_FIGURES,
		PREF_IGNORE_MAPMODEL_VALIDATION,
		PREF_IGNORE_GMFGEN_VALIDATION,
		PREF_FIGURE_TEMPLATES
		};
	
	private Preferences myPreferences;
	
	public TransformOptions() {
		reset();
	}

	private Preferences getPreferences() {
		if (myPreferences == null) {
			myPreferences = new InstanceScope().getNode(Plugin.getPluginID());
		}
		return myPreferences;
	}
	
	public void reset() {
		for (String n : PROP_NAMES) {
			// I assume removing a key from InstanceScope leaves us with a value from DefaultScope 
			getPreferences().remove(n);
		}
	}
	
	public void flush() {
		// copied from Plugin.getDefault().savePluginPreferences();
		try {
			getPreferences().flush();
		} catch (BackingStoreException ex) {
			Plugin.log(ex);
		}
	}
	
	public boolean getGenerateRCP() {
		return getPreferences().getBoolean(PREF_GENERATE_RCP, false);
	}

	public boolean getUseMapMode() {
		return getPreferences().getBoolean(PREF_USE_MAP_MODE, true);
	}

	public boolean getUseRuntimeFigures() {
		return getPreferences().getBoolean(PREF_USE_RUNTIME_FIGURES, true);
	}

	public boolean getIgnoreMapModelValidation() {
		return getPreferences().getBoolean(PREF_IGNORE_MAPMODEL_VALIDATION, false);
	}

	public boolean getIgnoreGMFGenValidation() {
		return getPreferences().getBoolean(PREF_IGNORE_GMFGEN_VALIDATION, false);
	}

	public URL getFigureTemplatesPath() {
		final String value = getPreferences().get(PREF_FIGURE_TEMPLATES, null);
		if (value == null || value.length() == 0) {
			return null;
		}
		try {
			return new URL(value);
		} catch (MalformedURLException ex) {
			Plugin.log(ex);
		}
		return null;
	}

	public void setGenerateRCP(boolean value) {
		getPreferences().putBoolean(PREF_GENERATE_RCP, value);
	}

	public void setUseMapMode(boolean value) {
		getPreferences().putBoolean(PREF_USE_MAP_MODE, value);
	}

	public void setUseRuntimeFigures(boolean value) {
		getPreferences().putBoolean(PREF_USE_RUNTIME_FIGURES, value);
	}

	public void setIgnoreMapModelValidation(boolean value) {
		getPreferences().putBoolean(PREF_IGNORE_MAPMODEL_VALIDATION, value);
	}

	public void setIgnoreGMFGenValidation(boolean value) {
		getPreferences().putBoolean(PREF_IGNORE_GMFGEN_VALIDATION, value);
	}

	public void setFigureTemplatesPath(URL path) {
		getPreferences().put(PREF_FIGURE_TEMPLATES, path == null ? "" : path.toString()); //$NON-NLS-1$
	}

	@Override
	public void initializeDefaultPreferences() {
		DefaultScope scope = new DefaultScope();
		IEclipsePreferences node = scope.getNode(Plugin.getPluginID());
		node.putBoolean(PREF_GENERATE_RCP, false);
		node.putBoolean(PREF_USE_MAP_MODE, true);
		node.putBoolean(PREF_USE_RUNTIME_FIGURES, true);
		node.putBoolean(PREF_IGNORE_MAPMODEL_VALIDATION, false);
		node.putBoolean(PREF_IGNORE_GMFGEN_VALIDATION, false);

	}
	
	static boolean checkLiteOptionPresent() {
		return Platform.getBundle("org.eclipse.gmf.codegen.lite") != null; //$NON-NLS-1$
	}
}
