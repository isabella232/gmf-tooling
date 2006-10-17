/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.codegen.gmfgen.util;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.gmf.internal.common.migrate.MigrationConfig;


public class GMFGenMigration {
	private static final String eNS_URI_1_0 = "http://www.eclipse.org/gmf/2005/GenModel"; //$NON-NLS-1$ 

	public static final MigrationConfig.Descriptor CONFIG = new MigrationConfig.Descriptor() {
		public String getExtension() { 	
			return "gmfgen"; //$NON-NLS-1$
		}
		
		public MigrationConfig getConfig() {
			MigrationConfig config = new MigrationConfig(GMFGenPackage.eNS_URI, new String[] { eNS_URI_1_0 }) {

				protected void handleIgnoredAttributes(Resource resource, Map<EObject, Map<String, String>> ignoredAttributes) {
					for (Iterator it = resource.getAllContents(); it.hasNext();) {
						EObject next = (EObject) it.next();
						Map<String, String> attrs = ignoredAttributes.get(next);
						if (attrs == null) {
							continue;
						}
						if (next instanceof GenLabel) {
							GenLabel genLabel = (GenLabel) next;
							boolean readOnly = Boolean.valueOf(attrs.get("readOnly")); //$NON-NLS-1$
							if (genLabel.getModelFacet() != null && readOnly) {
								genLabel.getModelFacet().setReadOnly(readOnly);
							}
						}
						if (next instanceof GenChildLabelNode) {
							GenChildLabelNode genLabel = (GenChildLabelNode) next;
							boolean readOnly = Boolean.valueOf(attrs.get("labelReadOnly")); //$NON-NLS-1$
							if (genLabel.getLabelModelFacet() != null && readOnly) {
								genLabel.getLabelModelFacet().setReadOnly(readOnly);
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
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getGenLabel(), "readOnly"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getGenChildLabelNode(), "labelReadOnly"); //$NON-NLS-1$
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=138440
		config.addNarrowReferenceType(
			GMFGenPackage.eINSTANCE.getGenFeatureSeqInitializer_Initializers(),
			GMFGenPackage.eINSTANCE.getGenFeatureValueSpec()
		);
	}
}
