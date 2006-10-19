/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: dvorak - initial API and implementation
 */
package org.eclipse.gmf.mappings.util;

import org.eclipse.gmf.internal.common.migrate.MigrationConfig;
import org.eclipse.gmf.mappings.GMFMapPackage;

public class GMFMapMigration {

	private static final String GMFMAP_FILE_EXT = "gmfmap"; //$NON-NLS-1$

	private static final String eNS_URI_1_0 = "http://www.eclipse.org/gmf/2005/mappings"; //$NON-NLS-1$ 

	public static final MigrationConfig.Descriptor CONFIG = new MigrationConfig.Descriptor() {

		public String getExtension() {
			return GMFMAP_FILE_EXT;
		}

		public MigrationConfig getConfig() {
			MigrationConfig config = new MigrationConfig(GMFMapPackage.eNS_URI, new String[] { eNS_URI_1_0 });
			initialize(config);
			return config;
		}
	};

	static void initialize(MigrationConfig config) {
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=138440
		config.addNarrowReferenceType(GMFMapPackage.eINSTANCE.getFeatureSeqInitializer_Initializers(), GMFMapPackage.eINSTANCE.getFeatureValueSpec());
	}
}
