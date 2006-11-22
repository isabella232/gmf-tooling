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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.internal.common.migrate.MigrationConfig;
import org.eclipse.gmf.internal.common.migrate.MigrationResource.MigrationHandler;

public class GMFGenMigration {

	private static final String eNS_URI_1_0 = "http://www.eclipse.org/gmf/2005/GenModel"; //$NON-NLS-1$ 

	public static final MigrationConfig.Descriptor CONFIG = new MigrationConfig.Descriptor() {

		public String getExtension() {
			return "gmfgen"; //$NON-NLS-1$
		}

		public MigrationConfig getConfig() {
			MigrationConfig config = new MigrationConfig(GMFGenPackage.eNS_URI, new String[] { eNS_URI_1_0 }) {

				@Override
				protected boolean handleFeature(MigrationHandler handler, String prefix, String name) {
					if ("metaFeature".equals(name) && handler.peekEObject() instanceof FeatureLabelModelFacet) { //$NON-NLS-1$
						name = "metaFeatures"; //$NON-NLS-1$
						handler.handleFeatureHook(prefix, name);
						return true;
					}
					return false;
				}

				@Override
				protected boolean handleCreateObject(MigrationHandler handler, EObject peekObject, EStructuralFeature feature) {
					if ("gmfgen:CompositeFeatureLabelModelFacet".equals(handler.getXSIType())) { //$NON-NLS-1$
						handler.createObjectFromTypeNameHook(peekObject, "gmfgen:FeatureLabelModelFacet", feature); //$NON-NLS-1$
						return true;
					}
					return false;
				}
			};
			initialize(config);
			return config;
		}
	};

	static void initialize(MigrationConfig config) {
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getEditorCandies(), "diagramFileCreatorClassName"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet(), "metaFeature"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getProviderClassNames(), "paletteProviderClassName"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getProviderClassNames(), "paletteProviderPriority"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getProviderClassNames(), "propertyProviderClassName"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getProviderClassNames(), "propertyProviderPriority"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getEditPartCandies(), "referenceConnectionEditPolicyClassName"); //$NON-NLS-1$
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=138440
		config.addNarrowReferenceType(GMFGenPackage.eINSTANCE.getGenFeatureSeqInitializer_Initializers(), GMFGenPackage.eINSTANCE.getGenFeatureValueSpec());
	}
}
