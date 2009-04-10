/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.migration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.internal.xpand.migration.ui.MigrateXpandProject;

public class LegacyTemplateRootRegistry implements IRegistryEventListener {

	private static final String MIGRATED_LOCATION_ATTR = "migratedLocation";

	private static final String CURRENT_LOCATION_ATTR = "currentLocation";

	private static final String ORIGINAL_LOCATION_ATTR = "originalLocation";

	private static final String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".templates";

	private Map<IPath, IPath> original2CurrentRootMap;

	private Map<IPath, IPath> original2MigratedMap;

	public IPath getActualRoot(IPath originalRoot) {
		Map<IPath, IPath> map = getOriginal2CurrentRootMap();
		if (map.containsKey(originalRoot)) {
			return map.get(originalRoot);
		}
		return originalRoot;
	}
	
	public IPath getMigratedRoot(IPath originalRoot) {
		// Returning migrated root from the registry if it was specified.
		if (getOriginal2MigratedMap().containsKey(originalRoot)) {
			return getOriginal2MigratedMap().get(originalRoot);
		}
		// Returning original root - migrated one was specified for it, but no
		// migrated root - migrated templates were places into the ex-legacy
		// templates folder
		if (getOriginal2CurrentRootMap().containsKey(originalRoot)) {
			return originalRoot;
		}

		IPath newPath = originalRoot.removeTrailingSeparator();
		newPath = newPath.addFileExtension(MigrateXpandProject.MIGRATED_ROOT_EXTENSION);
		if (originalRoot.hasTrailingSeparator()) {
			newPath = newPath.addTrailingSeparator();
		}
		return newPath;
	}

	private synchronized Map<IPath, IPath> getOriginal2CurrentRootMap() {
		if (original2CurrentRootMap == null) {
			loadExtensions();
		}
		return original2CurrentRootMap;
	}
	
	private synchronized Map<IPath, IPath> getOriginal2MigratedMap() {
		if (original2MigratedMap == null) {
			loadExtensions();
		}
		return original2MigratedMap;
	}

	private void loadExtensions() {
		original2CurrentRootMap = new HashMap<IPath, IPath>();
		original2MigratedMap = new HashMap<IPath, IPath>();
		
		IExtensionPoint templatesExtensionPoint = Platform.getExtensionRegistry().getExtensionPoint(EXTENSION_POINT_ID);
		for (IConfigurationElement configElement : templatesExtensionPoint.getConfigurationElements()) {
			
			String originalLocation = configElement.getAttribute(ORIGINAL_LOCATION_ATTR).trim();
			IPath originalPath = new Path(originalLocation);
			if (!originalPath.isAbsolute()) {
				Activator.logWarn("Only absolute original paths supported: \"" + originalLocation + "\"");
				continue;
			}
			
			String currentLocation = configElement.getAttribute(CURRENT_LOCATION_ATTR).trim();
			IPath currentPath = new Path(currentLocation);
			if (!currentPath.isAbsolute()) {
				Activator.logWarn("Only absolute current paths supported: \"" + currentLocation + "\"");
				continue;
			}
			if (original2CurrentRootMap.containsKey(originalPath)) {
				IPath existingCurrentPath = original2CurrentRootMap.get(originalPath);
				Activator.logWarn("Duplicating template root mapping specified: \"" + originalPath.toString() + "\" -> \"" + existingCurrentPath.toString() + "\" and \"" + originalPath.toString()
						+ "\" -> \"" + currentPath.toString() + "\". Last entry will be skipped.");
				continue;
			}
			original2CurrentRootMap.put(originalPath, currentPath);
			
			String migratedLocation = configElement.getAttribute(MIGRATED_LOCATION_ATTR);
			if (migratedLocation != null) {
				IPath migratedPath = new Path(migratedLocation);
				if (!migratedPath.isAbsolute()) {
					Activator.logWarn("Only absolute migrated paths supported: \"" + migratedLocation + "\"");
					continue;
				}
				original2MigratedMap.put(originalPath, migratedPath);
			}
		}
		Platform.getExtensionRegistry().addListener(this, EXTENSION_POINT_ID);
	}

	public synchronized void added(IExtension[] extensions) {
		original2CurrentRootMap = null;
		original2MigratedMap = null;
	}

	public synchronized void added(IExtensionPoint[] extensionPoints) {
		original2CurrentRootMap = null;
		original2MigratedMap = null;
	}

	public synchronized void removed(IExtension[] extensions) {
		original2CurrentRootMap = null;
		original2MigratedMap = null;
	}

	public synchronized void removed(IExtensionPoint[] extensionPoints) {
		original2CurrentRootMap = null;
		original2MigratedMap = null;
	}

}
