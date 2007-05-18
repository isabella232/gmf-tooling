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
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.internal.common.migrate.MigrationHelperDelegateImpl;

class MigrationDelegate extends MigrationHelperDelegateImpl {
	private EReference ourGenEditorGenerator_Audits;
	private EReference ourGenAuditContainer_ChildContainers;
	private EReference ourGenAuditContainer_Audits;
	
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
		ourGenEditorGenerator_Audits = new EReferenceImpl() {};
		ourGenEditorGenerator_Audits.setName("audits"); //$NON-NLS-1$
		ourGenEditorGenerator_Audits.setEType(GMFGenPackage.eINSTANCE.getGenAuditContainer());
		ourGenEditorGenerator_Audits.setContainment(true);
		ourGenEditorGenerator_Audits.setLowerBound(0);
		ourGenEditorGenerator_Audits.setUpperBound(1);
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
		{
			Map<String, EStructuralFeature> renamings = new HashMap<String, EStructuralFeature>();
			renamings.put(ourGenEditorGenerator_Audits.getName(), ourGenEditorGenerator_Audits);
			registerRenamedAttributes(GMFGenPackage.eINSTANCE.getGenEditorGenerator(), renamings);
		}
		{
			Map<String, EStructuralFeature> renamings = new HashMap<String, EStructuralFeature>();
			renamings.put(ourGenAuditContainer_Audits.getName(), ourGenAuditContainer_Audits);
			renamings.put(ourGenAuditContainer_ChildContainers.getName(), ourGenAuditContainer_ChildContainers);
			registerRenamedAttributes(GMFGenPackage.eINSTANCE.getGenAuditContainer(), renamings);
		}
		registerRenamedType("CompositeFeatureLabelModelFacet", GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet()); //$NON-NLS-1$
	}
	
	@Override
	public boolean setValue(EObject object, EStructuralFeature feature, Object value, int position) {
		if (ourGenEditorGenerator_Audits.equals(feature)) {
			GenEditorGenerator generator = (GenEditorGenerator) object;
			GenAuditContainer rootContainer = (GenAuditContainer) value;
			generator.setAudits(getOrCreateRoot(rootContainer));
		} else if (ourGenAuditContainer_ChildContainers.equals(feature)) {
			GenAuditContainer parent = (GenAuditContainer)object;
			GenAuditContainer container = (GenAuditContainer)value;
			container.getPath().addAll(parent.getPath());
			container.getPath().add(parent);
			getOrCreateRoot(parent).getCategories().add(container);
		} else if (ourGenAuditContainer_Audits.equals(feature)) {
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

	private GenAuditRoot getOrCreateRoot(GenAuditContainer auditContainer) {
		GenAuditRoot result = auditContainer.getRoot();
		if (result == null) {
			result = GMFGenFactory.eINSTANCE.createGenAuditRoot();
			result.getCategories().add(auditContainer);
		}
		return result;
	}

}
