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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.internal.common.migrate.MigrationHelperDelegateImpl;

class MigrationDelegate extends MigrationHelperDelegateImpl {
	private EReference ourGenAuditContainer_ChildContainers;
	private EReference ourGenAuditContainer_Audits;
	private EAttributeImpl myGenAuditRoot_Id;
	private EAttributeImpl myGenAuditRoot_Name;
	private EAttributeImpl myGenAuditRoot_Description;
	private GenAuditContainer myRootContainer;
	
	MigrationDelegate() {
	}

	void init() {
		registerDeletedAttributes(GMFGenPackage.eINSTANCE.getEditorCandies(),
						"diagramFileCreatorClassName", //$NON-NLS-1$
						"preferenceInitializerClassName" //$NON-NLS-1$
		);
		registerDeletedAttributes(GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet(), "metaFeature"); //$NON-NLS-1$
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

		registerNarrowReferenceType(GMFGenPackage.eINSTANCE.getGenFeatureSeqInitializer_Initializers(),	GMFGenPackage.eINSTANCE.getGenFeatureValueSpec());
		{
			Map<String, EStructuralFeature> renamings = new HashMap<String, EStructuralFeature>();
			renamings.put("metaFeature", GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet_MetaFeatures()); //$NON-NLS-1$
			registerRenamedAttributes(GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet(), renamings);
		}
		ourGenAuditContainer_ChildContainers = new EReferenceImpl() {};
		ourGenAuditContainer_ChildContainers.setName("childContainers"); //$NON-NLS-1$
		ourGenAuditContainer_ChildContainers.setEType(GMFGenPackage.eINSTANCE.getGenAuditContainer());
		ourGenAuditContainer_ChildContainers.setContainment(true);
		ourGenAuditContainer_ChildContainers.setLowerBound(0);
		ourGenAuditContainer_ChildContainers.setUpperBound(-1);
		ourGenAuditContainer_Audits = new EReferenceImpl() {};
		ourGenAuditContainer_Audits.setName("audits"); //$NON-NLS-1$
		ourGenAuditContainer_Audits.setEType(GMFGenPackage.eINSTANCE.getGenAuditRule());
		ourGenAuditContainer_Audits.setContainment(true);
		ourGenAuditContainer_Audits.setLowerBound(0);
		ourGenAuditContainer_Audits.setUpperBound(-1);
		myGenAuditRoot_Id = (EAttributeImpl) EcoreUtil.copy(GMFGenPackage.eINSTANCE.getGenAuditContainer_Id());
		myGenAuditRoot_Name = (EAttributeImpl) EcoreUtil.copy(GMFGenPackage.eINSTANCE.getGenAuditContainer_Name());
		myGenAuditRoot_Description = (EAttributeImpl) EcoreUtil.copy(GMFGenPackage.eINSTANCE.getGenAuditContainer_Description());
		{
			Map<String, EStructuralFeature> renamings = new HashMap<String, EStructuralFeature>();
			renamings.put(ourGenAuditContainer_Audits.getName(), ourGenAuditContainer_Audits);
			renamings.put(ourGenAuditContainer_ChildContainers.getName(), ourGenAuditContainer_ChildContainers);
			registerRenamedAttributes(GMFGenPackage.eINSTANCE.getGenAuditContainer(), renamings);
		}
		{
			Map<String, EStructuralFeature> renamings = new HashMap<String, EStructuralFeature>();
			renamings.put(ourGenAuditContainer_Audits.getName(), ourGenAuditContainer_Audits);
			renamings.put(ourGenAuditContainer_ChildContainers.getName(), ourGenAuditContainer_ChildContainers);
			renamings.put(myGenAuditRoot_Id.getName(), myGenAuditRoot_Id);
			renamings.put(myGenAuditRoot_Name.getName(), myGenAuditRoot_Name);
			renamings.put(myGenAuditRoot_Description.getName(), myGenAuditRoot_Description);
			registerRenamedAttributes(GMFGenPackage.eINSTANCE.getGenAuditRoot(), renamings);
		}
		registerRenamedType("CompositeFeatureLabelModelFacet", GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet()); //$NON-NLS-1$
		myRootContainer = null;
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
		} else if (ourGenAuditContainer_ChildContainers.equals(feature) && object instanceof GenAuditRoot) {
			GenAuditRoot root = (GenAuditRoot)object;
			GenAuditContainer container = (GenAuditContainer)value;
			if (myRootContainer != null) {
				container.getPath().add(myRootContainer);
			}
			root.getCategories().add(container);
		} else if (ourGenAuditContainer_Audits.equals(feature) && object instanceof GenAuditRoot) {
			GenAuditRoot root = (GenAuditRoot)object;
			GenAuditRule rule = (GenAuditRule)value;
			if (myRootContainer != null) {
				rule.setCategory(myRootContainer);
			}
			root.getRules().add(rule);
		} else if (ourGenAuditContainer_ChildContainers.equals(feature) && object instanceof GenAuditContainer) {
			GenAuditContainer parent = (GenAuditContainer)object;
			GenAuditContainer container = (GenAuditContainer)value;
			container.getPath().addAll(parent.getPath());
			container.getPath().add(parent);
			getOrCreateRoot(parent).getCategories().add(container);
		} else if (ourGenAuditContainer_Audits.equals(feature) && object instanceof GenAuditContainer) {
			GenAuditContainer container = (GenAuditContainer)object;
			GenAuditRule rule = (GenAuditRule)value;
			rule.setCategory(container);
			getOrCreateRoot(container).getRules().add(rule);
		} else {
			// other cases are would be processed as defaults
			return super.setValue(object, feature, value, position);
		}
		return true;
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

}
