/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Borland - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.internal.common.migrate.MigrationHelperDelegateImpl;

class MigrationDelegate extends MigrationHelperDelegateImpl {
	private EReference myGenAuditContainer_ChildContainers;
	private EReference myGenAuditContainer_Audits;
	private EAttribute myGenAuditRoot_Id;
	private EAttribute myGenAuditRoot_Name;
	private EAttribute myGenAuditRoot_Description;
	private GenAuditContainer myRootContainer;
	private Collection<String> myBackwardSupportedURIs;
	private Map<GenExpressionInterpreter, Collection<String>> myRequiredPlugins;
	private GenExpressionProviderContainer myProvidersContainer;
	
	MigrationDelegate() {
	}

	void init() {
		registerDeletedAttributes(GMFGenPackage.eINSTANCE.getEditorCandies(),
						"diagramFileCreatorClassName", //$NON-NLS-1$
						"preferenceInitializerClassName" //$NON-NLS-1$
		);
		registerDeletedAttributes(GMFGenPackage.eINSTANCE.getProviderClassNames(), 
						"abstractParserClassName", //$NON-NLS-1$
						"structuralFeatureParserClassName", //$NON-NLS-1$
						"structuralFeaturesParserClassName", //$NON-NLS-1$
						"paletteProviderClassName", //$NON-NLS-1$
						"paletteProviderPriority", //$NON-NLS-1$
						"propertyProviderClassName", //$NON-NLS-1$
						"propertyProviderPriority" //$NON-NLS-1$
		);
		registerDeletedAttributes(GMFGenPackage.eINSTANCE.getEditPartCandies(), 
						"referenceConnectionEditPolicyClassName", //$NON-NLS-1$
						"externalNodeLabelHostLayoutEditPolicyClassName" //$NON-NLS-1$
		);
		registerDeletedAttributes(GMFGenPackage.eINSTANCE.getTypeLinkModelFacet(), "createCommandClassName"); //$NON-NLS-1$
		{
			Map<String, EStructuralFeature> renamings = new HashMap<String, EStructuralFeature>();
			renamings.put("requiredPluginIDs", GMFGenPackage.eINSTANCE.getGenPlugin_RequiredPlugins()); //$NON-NLS-1$
			registerRenamedAttributes(GMFGenPackage.eINSTANCE.getGenExpressionInterpreter(), renamings);
		}
		registerNarrowReferenceType(GMFGenPackage.eINSTANCE.getGenFeatureSeqInitializer_Initializers(),	GMFGenPackage.eINSTANCE.getGenFeatureValueSpec());
		{
			Map<String, EStructuralFeature> renamings = new HashMap<String, EStructuralFeature>();
			renamings.put("metaFeature", GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet_MetaFeatures()); //$NON-NLS-1$
			registerRenamedAttributes(GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet(), renamings);
		}
		registerRenamedType("CompositeFeatureLabelModelFacet", GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet()); //$NON-NLS-1$
		myGenAuditContainer_ChildContainers = createNewReference("childContainers", GMFGenPackage.eINSTANCE.getGenAuditContainer(), true); //$NON-NLS-1$
		myGenAuditContainer_Audits = createNewReference("audits", GMFGenPackage.eINSTANCE.getGenAuditRule(), true); //$NON-NLS-1$
		myGenAuditRoot_Id = (EAttribute) EcoreUtil.copy(GMFGenPackage.eINSTANCE.getGenAuditContainer_Id());
		myGenAuditRoot_Name = (EAttribute) EcoreUtil.copy(GMFGenPackage.eINSTANCE.getGenAuditContainer_Name());
		myGenAuditRoot_Description = (EAttribute) EcoreUtil.copy(GMFGenPackage.eINSTANCE.getGenAuditContainer_Description());
		{
			Map<String, EStructuralFeature> renamings = new HashMap<String, EStructuralFeature>();
			renamings.put(myGenAuditContainer_Audits.getName(), myGenAuditContainer_Audits);
			renamings.put(myGenAuditContainer_ChildContainers.getName(), myGenAuditContainer_ChildContainers);
			registerRenamedAttributes(GMFGenPackage.eINSTANCE.getGenAuditContainer(), renamings);
		}
		{
			Map<String, EStructuralFeature> renamings = new HashMap<String, EStructuralFeature>();
			renamings.put(myGenAuditContainer_Audits.getName(), myGenAuditContainer_Audits);
			renamings.put(myGenAuditContainer_ChildContainers.getName(), myGenAuditContainer_ChildContainers);
			renamings.put(myGenAuditRoot_Id.getName(), myGenAuditRoot_Id);
			renamings.put(myGenAuditRoot_Name.getName(), myGenAuditRoot_Name);
			renamings.put(myGenAuditRoot_Description.getName(), myGenAuditRoot_Description);
			registerRenamedAttributes(GMFGenPackage.eINSTANCE.getGenAuditRoot(), renamings);
		}
		myRootContainer = null;
		myProvidersContainer = null;
		myRequiredPlugins = null;
	}

	@Override
	public boolean isOldVersionDetected(String uriString) {
		return !getMetamodelNsURI().equals(uriString) && getBackwardSupportedURIs().contains(uriString);
	}

	@Override
	public boolean setValue(EObject object, EStructuralFeature feature, Object value, int position) {
		if (myGenAuditRoot_Id.equals(feature)) {
			GenAuditRoot root = (GenAuditRoot) object;
			String id = (String) value;
			GenAuditContainer rootContainer = getOrCreateRootContainerOnce(root);
			rootContainer.setId(id);
		} else if (myGenAuditRoot_Name.equals(feature)) {
			GenAuditRoot root = (GenAuditRoot) object;
			String name = (String) value;
			GenAuditContainer rootContainer = getOrCreateRootContainerOnce(root);
			rootContainer.setName(name);
		} else if (myGenAuditRoot_Description.equals(feature)) {
			GenAuditRoot root = (GenAuditRoot) object;
			String description = (String) value;
			GenAuditContainer rootContainer = getOrCreateRootContainerOnce(root);
			rootContainer.setDescription(description);
		} else if (myGenAuditContainer_ChildContainers.equals(feature) && object instanceof GenAuditRoot) {
			GenAuditRoot root = (GenAuditRoot)object;
			GenAuditContainer container = (GenAuditContainer)value;
			if (myRootContainer != null) {
				container.getPath().add(myRootContainer);
			}
			root.getCategories().add(container);
		} else if (myGenAuditContainer_Audits.equals(feature) && object instanceof GenAuditRoot) {
			GenAuditRoot root = (GenAuditRoot)object;
			GenAuditRule rule = (GenAuditRule)value;
			if (myRootContainer != null) {
				rule.setCategory(myRootContainer);
			}
			root.getRules().add(rule);
		} else if (myGenAuditContainer_ChildContainers.equals(feature) && object instanceof GenAuditContainer) {
			GenAuditContainer parent = (GenAuditContainer)object;
			GenAuditContainer container = (GenAuditContainer)value;
			container.getPath().addAll(parent.getPath());
			container.getPath().add(parent);
			getOrCreateRoot(parent).getCategories().add(container);
		} else if (myGenAuditContainer_Audits.equals(feature) && object instanceof GenAuditContainer) {
			GenAuditContainer container = (GenAuditContainer)object;
			GenAuditRule rule = (GenAuditRule)value;
			rule.setCategory(container);
			getOrCreateRoot(container).getRules().add(rule);
		} else if (GMFGenPackage.eINSTANCE.getGenPlugin_RequiredPlugins().equals(feature) && object instanceof GenExpressionInterpreter) {
			GenExpressionInterpreter expressionInterpreter = (GenExpressionInterpreter) object;
			String requiredPlugin = (String) value;
			saveRequiredPlugin(expressionInterpreter, requiredPlugin);
	    } else {
			// other cases are would be processed as defaults
			return super.setValue(object, feature, value, position);
		}
		return true;
	}

	private void saveRequiredPlugin(GenExpressionInterpreter expressionProvider, String requiredPlugin) {
		if (myRequiredPlugins == null) {
			myRequiredPlugins = new LinkedHashMap<GenExpressionInterpreter, Collection<String>>();
		}
		Collection<String> requiredPlugins = myRequiredPlugins.get(expressionProvider);
		if (requiredPlugins == null) {
			requiredPlugins = new ArrayList<String>();
		}
		requiredPlugins.add(requiredPlugin);
		myRequiredPlugins.put(expressionProvider, requiredPlugins);
	}
	
	private Map<GenExpressionInterpreter, Collection<String>> getSavedRequiredPlugins() {
		return myRequiredPlugins;
	}

	@Override
	public void postProcess() {
		if (getSavedRequiredPlugins() == null) {
			return;
		}
		for (GenExpressionInterpreter expressionProvider : getSavedRequiredPlugins().keySet()) {
			GenExpressionProviderContainer container = expressionProvider.getContainer();
			if (container == null) {
				container = getOrCreateParenlessProvidersContainerOnce(expressionProvider);
				container.getProviders().add(expressionProvider);
			}
			GenEditorGenerator editor = container.getEditorGen();
			if (editor == null) {
				editor = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
				container.eResource().getContents().add(editor);
				editor.setExpressionProviders(container);
			}
			GenPlugin plugin = editor.getPlugin();
			if (plugin == null) {
				plugin = GMFGenFactory.eINSTANCE.createGenPlugin();
				editor.setPlugin(plugin);
			}
			plugin.getRequiredPlugins().addAll(getSavedRequiredPlugins().get(expressionProvider));
		}
		getSavedRequiredPlugins().clear();
	}

	private GenExpressionProviderContainer getOrCreateParenlessProvidersContainerOnce(GenExpressionInterpreter expressionProvider) {
		if (myProvidersContainer == null) {
			myProvidersContainer = GMFGenFactory.eINSTANCE.createGenExpressionProviderContainer();
			expressionProvider.eResource().getContents().add(myProvidersContainer);
		}
		return myProvidersContainer;
	}

	private GenAuditContainer getOrCreateRootContainerOnce(GenAuditRoot root) {
		if (myRootContainer == null) {
			myRootContainer = GMFGenFactory.eINSTANCE.createGenAuditContainer();
			root.getCategories().add(myRootContainer);
		}
		return myRootContainer;
	}

	private GenAuditRoot getOrCreateRoot(GenAuditContainer auditContainer) {
		GenAuditRoot result = auditContainer.getRoot();
		if (result == null) {
			result = GMFGenFactory.eINSTANCE.createGenAuditRoot();
			result.getCategories().add(auditContainer);
		}
		return result;
	}

	protected Collection<String> getBackwardSupportedURIs() {
		if (myBackwardSupportedURIs == null) {
			myBackwardSupportedURIs = Arrays.asList(new String[] {
					"http://www.eclipse.org/gmf/2005/GenModel", //$NON-NLS-1$
					"http://www.eclipse.org/gmf/2005/GenModel/2.0" //$NON-NLS-1$
			});
		}
		return myBackwardSupportedURIs;
	}

	protected String getMetamodelNsURI() {
		return GMFGenPackage.eNS_URI;
	}
}
