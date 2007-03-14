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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.internal.common.migrate.MigrationConfig;
import org.eclipse.gmf.mappings.FeatureLabelMapping;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.MappingEntry;

public class GMFMapMigration {

	private static final String GMFMAP_FILE_EXT = "gmfmap"; //$NON-NLS-1$

	private static final String eNS_URI_1_0 = "http://www.eclipse.org/gmf/2005/mappings"; //$NON-NLS-1$ 

	public static final MigrationConfig.Descriptor CONFIG = new MigrationConfig.Descriptor() {

		public String getExtension() {
			return GMFMAP_FILE_EXT;
		}

		public MigrationConfig getConfig() {
			MigrationConfig config = new MigrationConfig(GMFMapPackage.eNS_URI, new String[] { eNS_URI_1_0 }) {

				@Override
				protected void handleResourceLoaded(Resource resource, Map<EObject, Map<String, String>> ignoredAttributes) {
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=161380
					// replace FeatureLabelMappings without features by LabelMappings
					for (Iterator<EObject> it = resource.getAllContents(); it.hasNext();) {
						EObject object = it.next();
						if (object instanceof MappingEntry) {
							MappingEntry entry = (MappingEntry) object;
							Collection<LabelMapping> mappings = new ArrayList<LabelMapping>(entry.getLabelMappings());
							for (LabelMapping mapping : mappings) {
								if (mapping instanceof FeatureLabelMapping && ((FeatureLabelMapping) mapping).getFeatures().isEmpty()) {
									entry.getLabelMappings().remove(mapping);
									LabelMapping newMapping = GMFMapPackage.eINSTANCE.getGMFMapFactory().createLabelMapping();
									newMapping.setDiagramLabel(mapping.getDiagramLabel());
									if (mapping.isReadOnly()) {
										newMapping.setReadOnly(true);
									}
									entry.getLabelMappings().add(newMapping);
								}
							}
						}
					}
				}
			};
			initialize(config);
			return config;
		}
	};

	static void initialize(MigrationConfig config) {
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=138440
		config.addNarrowReferenceType(GMFMapPackage.eINSTANCE.getFeatureSeqInitializer_Initializers(), GMFMapPackage.eINSTANCE.getFeatureValueSpec());
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=161380
		config.addNarrowReferenceType(GMFMapPackage.eINSTANCE.getMappingEntry_LabelMappings(), GMFMapPackage.eINSTANCE.getFeatureLabelMapping());
	}
}
