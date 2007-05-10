/*
 * Copyright (c) 2005, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 *               Anna Karjakina (Borland) - support GenAuditContainer migration
 */
package org.eclipse.gmf.codegen.gmfgen.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
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
				private boolean isDefaultAuditCategoryAdded = false;
				private boolean isAuditMigrationApplied = false;

				@Override
				protected void handleResourceLoaded(Resource resource, Map<EObject, Map<String, String>> ignoredAttributes) {
					if (!isAuditMigrationApplied) {
						return;
					}
					List<EObject> initialResourceContents = new ArrayList<EObject>(resource.getContents().size());
					initialResourceContents.addAll(resource.getContents());
					for (Iterator<EObject> it = initialResourceContents.iterator(); it.hasNext();) {
						EObject object = it.next();
						if (object instanceof GenAuditContainer) {
							GenAuditRoot root = GMFGenFactory.eINSTANCE.createGenAuditRoot();
							resource.getContents().add(root);
							GenAuditContainer nextContainer = (GenAuditContainer) object;
							root.getCategories().add(nextContainer);
							moveNestedCategoriesToTheRoot(nextContainer, root);
							nextContainer.getPath().clear();
						}
						if (object instanceof GenEditorGenerator) {
							GenEditorGenerator generator = (GenEditorGenerator) object;
							GenAuditRoot root = generator.getAudits();
							if (root != null && !root.getCategories().isEmpty()) {
								if (isDefaultAuditCategoryAdded) {
									GenAuditContainer defaultCategory = getDefaultAuditContainer(root);
									for (Iterator<GenAuditRule> toplevelRules = root.getRules().iterator(); toplevelRules.hasNext();) {
										GenAuditRule nextFirst = toplevelRules.next();
										nextFirst.setCategory(defaultCategory);
									}
									if (root.getCategories().size() > 1) {
										List<GenAuditContainer> containersList = new ArrayList<GenAuditContainer>(root.getCategories().size());
										containersList.addAll(root.getCategories());
										containersList.remove(defaultCategory);
										for (Iterator<GenAuditContainer> containers = containersList.iterator(); containers.hasNext();) {
											GenAuditContainer nextContainer = containers.next();
											moveNestedCategoriesToTheRoot(nextContainer, root);
											nextContainer.getPath().clear();
											nextContainer.getPath().add(defaultCategory);
										}
									}
								} else {
									List<GenAuditContainer> containersList = new ArrayList<GenAuditContainer>(root.getCategories().size());
									containersList.addAll(root.getCategories());
									for (Iterator<GenAuditContainer> containers = containersList.iterator(); containers.hasNext();) {
										GenAuditContainer nextContainer = containers.next();
										moveNestedCategoriesToTheRoot(nextContainer, root);
										nextContainer.getPath().clear();
									}
								}
							}
						}
					}
					isDefaultAuditCategoryAdded = false;
					isAuditMigrationApplied = false;
				}
				
				private void moveNestedCategoriesToTheRoot(GenAuditContainer nextContainer, GenAuditRoot root) {
					moveNestedAuditsToTheRoot(nextContainer, root);
					for (Iterator<GenAuditContainer> nestedContainers=nextContainer.getPath().iterator(); nestedContainers.hasNext();) {
						GenAuditContainer nextNestedContainer = nestedContainers.next();
						moveNestedCategoriesToTheRoot(nextNestedContainer, root);
						nestedContainers.remove();
						root.getCategories().add(nextNestedContainer);
						nextNestedContainer.getPath().clear();
						nextNestedContainer.getPath().add(nextContainer);
					}
				}

				private void moveNestedAuditsToTheRoot(GenAuditContainer nextContainer, GenAuditRoot root) {
					for (Iterator<GenAuditRule> nestedAudits = nextContainer.getAudits().iterator(); nestedAudits.hasNext();) {
						GenAuditRule nextNestedRule = nestedAudits.next();
						nextNestedRule.setCategory(nextContainer);
						root.getRules().add(nextNestedRule);
					}
				}

				@Override
				public boolean setAttribValue(MigrationHandler handler, EObject peekObject, String name, String value) {
					if (peekObject instanceof GenAuditRoot) {
						if ("id".equals(name)) { //$NON-NLS-1$
							getDefaultAuditContainer((GenAuditRoot) peekObject).setId(value);
							isAuditMigrationApplied = true;
							return true;
						} else if ("name".equals(name)) { //$NON-NLS-1$
							getDefaultAuditContainer((GenAuditRoot) peekObject).setName(value);
							isAuditMigrationApplied = true;
							return true;
						} else if ("description".equals(name)) { //$NON-NLS-1$
							getDefaultAuditContainer((GenAuditRoot) peekObject).setDescription(value);
							isAuditMigrationApplied = true;
							return true;
						}
					}
					return super.setAttribValue(handler, peekObject, name, value);
				}
				
				private GenAuditContainer getDefaultAuditContainer(GenAuditRoot root) {
					/*
					 * As we are mapping first audit category right into audit root,
					 * we should create some instance for that default category parameters
					 * also
					 */
					if (root.getCategories().isEmpty()) {
						root.getCategories().add(0, GMFGenFactory.eINSTANCE.createGenAuditContainer());
						isDefaultAuditCategoryAdded = true;
					}
					return root.getCategories().get(0);
				}

				@Override
				protected boolean handleFeature(MigrationHandler handler, String prefix, String name) {
					EObject object = handler.peekEObject();
					if ("metaFeature".equals(name) && object instanceof FeatureLabelModelFacet) { //$NON-NLS-1$
						name = "metaFeatures"; //$NON-NLS-1$
						handler.handleFeatureHook(prefix, name);
						return true;
					}
					if ("audits".equals(name) && object instanceof GenAuditRoot) { //$NON-NLS-1$
						name = "rules"; //$NON-NLS-1$
						handler.handleFeatureHook(prefix, name);
						isAuditMigrationApplied = true;
						return true;
					}
					if ("childContainers".equals(name) && object instanceof GenAuditRoot) { //$NON-NLS-1$
						name = "categories"; //$NON-NLS-1$
						handler.handleFeatureHook(prefix, name);
						isAuditMigrationApplied = true;
						return true;
					}
					if ("childContainers".equals(name) && object instanceof GenAuditContainer) { //$NON-NLS-1$
						name = "path"; //$NON-NLS-1$
						handler.handleFeatureHook(prefix, name);
						isAuditMigrationApplied = true;
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
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getEditorCandies(), "preferenceInitializerClassName"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet(), "metaFeature"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getProviderClassNames(), "abstractParserClassName"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getProviderClassNames(), "structuralFeatureParserClassName"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getProviderClassNames(), "structuralFeaturesParserClassName"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getProviderClassNames(), "paletteProviderClassName"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getProviderClassNames(), "paletteProviderPriority"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getProviderClassNames(), "propertyProviderClassName"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getProviderClassNames(), "propertyProviderPriority"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getEditPartCandies(), "referenceConnectionEditPolicyClassName"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getEditPartCandies(), "externalNodeLabelHostLayoutEditPolicyClassName"); //$NON-NLS-1$
		config.registerDeletedAttribute(GMFGenPackage.eINSTANCE.getTypeLinkModelFacet(), "createCommandClassName"); //$NON-NLS-1$
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=138440
		config.addNarrowReferenceType(GMFGenPackage.eINSTANCE.getGenFeatureSeqInitializer_Initializers(), GMFGenPackage.eINSTANCE.getGenFeatureValueSpec());
	}
}
