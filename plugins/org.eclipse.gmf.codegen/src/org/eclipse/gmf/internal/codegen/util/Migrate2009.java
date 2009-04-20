/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.internal.common.migrate.FilteringCopier;

/**
 * Migrate GMFGen model from year 2008 (GMF release 2.1) to 2009 (release 2.2).
 * @author artem
 */
public class Migrate2009 {

	private final EPackage myMetaPackage;

	public Migrate2009() {
		myMetaPackage = EPackage.Registry.INSTANCE.getEPackage(ModelVersions.GMFGEN_2_2);
	}

	public EObject go(EObject o) {
		assert "GenEditorGenerator".equals(o.eClass().getName());
		EPackage oldGenModel = o.eClass().getEPackage();
		EStructuralFeature validationProviderPriority = ((EClass) oldGenModel.getEClassifier("BatchValidation")).getEStructuralFeature("validationProviderPriority");
		EClass providerClassNames = (EClass) oldGenModel.getEClassifier("ProviderClassNames");
		EStructuralFeature parserProviderClassName = providerClassNames.getEStructuralFeature("parserProviderClassName"); 
		EAttribute parserProviderPriority = (EAttribute) providerClassNames.getEStructuralFeature("parserProviderPriority");
		EStructuralFeature contributionItemProviderClassName = providerClassNames.getEStructuralFeature("contributionItemProviderClassName");
		EStructuralFeature createShortcutActionClassName = ((EClass) oldGenModel.getEClassifier("Shortcuts")).getEStructuralFeature("createShortcutActionClassName");
		EClass packageNames = (EClass) oldGenModel.getEClassifier("PackageNames");
		EStructuralFeature parsersPackageName = packageNames.getEStructuralFeature("parsersPackageName");
		EStructuralFeature notationViewFactoriesPackageName = packageNames.getEStructuralFeature("notationViewFactoriesPackageName");
		EStructuralFeature loadResourceActionClassName = ((EClass) oldGenModel.getEClassifier("EditorCandies")).getEStructuralFeature("loadResourceActionClassName");
		EStructuralFeature baseGraphicalNodeEditPolicyClassName = ((EClass) oldGenModel.getEClassifier("EditPartCandies")).getEStructuralFeature("baseGraphicalNodeEditPolicyClassName");
		EStructuralFeature notationViewFactoryClassName = ((EClass) oldGenModel.getEClassifier("GenCommonBase")).getEStructuralFeature("notationViewFactoryClassName");
		//XXX treeBranch?
		EStructuralFeature labelModelFacet1 = ((EClass) oldGenModel.getEClassifier("GenChildLabelNode")).getEStructuralFeature("labelModelFacet");
		EStructuralFeature labelModelFacet2 = ((EClass) oldGenModel.getEClassifier("GenLabel")).getEStructuralFeature("modelFacet");
		EClass featureLabelModelFacet = (EClass) oldGenModel.getEClassifier("FeatureLabelModelFacet");
		EAttribute viewMethod = (EAttribute) featureLabelModelFacet.getEStructuralFeature("viewMethod");
		EAttribute editMethod = (EAttribute) featureLabelModelFacet.getEStructuralFeature("editMethod");
		// XXX EntryBase#id?
		EStructuralFeature domainModelElementTesterClassName = ((EClass) oldGenModel.getEClassifier("GenDomainModelNavigator")).getEStructuralFeature("domainModelElementTesterClassName");
		
		FilteringCopier cc = new FilteringCopier(myMetaPackage);
		cc.ignore(validationProviderPriority);
		cc.ignore(parserProviderClassName);
		cc.ignore(parserProviderPriority);
		cc.ignore(parsersPackageName);
		cc.ignore(createShortcutActionClassName);
		cc.ignore(loadResourceActionClassName);
		cc.ignore(contributionItemProviderClassName);
		cc.ignore(notationViewFactoriesPackageName);
		cc.ignore(notationViewFactoryClassName);
		cc.ignore(baseGraphicalNodeEditPolicyClassName);
		cc.ignore(viewMethod);
		cc.ignore(editMethod);
		cc.ignore(domainModelElementTesterClassName);
		// we don't really need to ignore model facets, just record all the uses
		cc.ignore(labelModelFacet1);
		cc.ignore(labelModelFacet2);
		EObject result = cc.copy(o); // just structure. It's incomplete at this point, hence don't copy any references.
		assert "GenEditorGenerator".equals(result.eClass().getName());

		final EClass newGenParserClass = (EClass) myMetaPackage.getEClassifier("GenParsers");
		final EObject newGenParser = myMetaPackage.getEFactoryInstance().create(newGenParserClass);
		@SuppressWarnings("unchecked")
		final List<EObject> implementations = (List<EObject>) newGenParser.eGet(newGenParserClass.getEStructuralFeature("implementations"));

		// Approach: one instance, reuse for all not set labelModelFacets - by default uses hint from facet's owner. May alter - e.g. distinct parser per use
		final EObject externalAuxParser = myMetaPackage.getEFactoryInstance().create((EClass) myMetaPackage.getEClassifier("ExternalParser"));
		final EObject externalDesignParser = myMetaPackage.getEFactoryInstance().create(externalAuxParser.eClass());

		// first, need to copy ignored LabelModelFacets
		final EClass newLabelModelFacet = (EClass) myMetaPackage.getEClassifier("LabelModelFacet");
		final EStructuralFeature lmfParser = newLabelModelFacet.getEStructuralFeature("parser");
		for (EObject l : cc.getIgnoredOwners(labelModelFacet1)) {
			EObject newOwner = cc.get(l);
			EObject newValue;
			if (l.eIsSet(labelModelFacet1)) {
				newValue = cc.copy((EObject) l.eGet(labelModelFacet1));
				if ("DesignLabelModelFacet".equals(newValue.eClass().getName())) {
					newValue.eSet(lmfParser, externalDesignParser);
					implementations.add(externalDesignParser);
				} // for FeatureLabelModelFacet, parser would get set later
			} else { // null value used to indicate external parser
				newValue = myMetaPackage.getEFactoryInstance().create(newLabelModelFacet);
				newValue.eSet(lmfParser, externalAuxParser);
				implementations.add(externalAuxParser); // I assume list is unique and won't add same object twice
			}
			newOwner.eSet(newOwner.eClass().getEStructuralFeature(labelModelFacet1.getName()), newValue);
		}
		for (EObject l : cc.getIgnoredOwners(labelModelFacet2)) {
			EObject newOwner = cc.get(l);
			EObject newValue;
			if (l.eIsSet(labelModelFacet2)) {
				newValue = cc.copy((EObject) l.eGet(labelModelFacet2));
				if ("DesignLabelModelFacet".equals(newValue.eClass().getName())) {
					newValue.eSet(lmfParser, externalDesignParser);
					implementations.add(externalDesignParser);
				} // for FeatureLabelModelFacet, parser would get set later
			} else { // null value used to indicate external parser
				newValue = myMetaPackage.getEFactoryInstance().create(newLabelModelFacet);
				newValue.eSet(lmfParser, externalAuxParser);
				implementations.add(externalAuxParser); // I assume list is unique and won't add same object twice
			}
			newOwner.eSet(newOwner.eClass().getEStructuralFeature(labelModelFacet2.getName()), newValue);
		}
		// now, we have whole model copied, hence may proceed with copying internal and external references
		cc.copyReferences();

		EObject oldGenDiagram = (EObject) o.eGet(o.eClass().getEStructuralFeature("diagram"));
		if (oldGenDiagram == null) {
			// although unlikely (the only known place is tests),  
			return result;
		}

		final HashMap<List<?>, EObject> methodsToParserImpl = new HashMap<List<?>, EObject>();
		assert cc.getIgnoredOwners(viewMethod).size() == cc.getIgnoredOwners(editMethod).size();
		for (EObject flmf : cc.getIgnoredOwners(viewMethod)) {
			Object viewMethodEnum = flmf.eGet(viewMethod);
			Object editMethodEnum = flmf.eGet(editMethod);
			ArrayList<Object> keyPair = new ArrayList<Object>(2); // need a pair as a key
			keyPair.add(0, viewMethodEnum);
			keyPair.add(1, editMethodEnum);
			EObject parserImpl = methodsToParserImpl.get(keyPair);
			if (parserImpl == null) {
				EClass prefefinedParser = (EClass) myMetaPackage.getEClassifier("PredefinedParser");
				parserImpl = myMetaPackage.getEFactoryInstance().create(prefefinedParser);
				parserImpl.eSet(prefefinedParser.getEStructuralFeature("viewMethod"), cc.transformValue(viewMethod, viewMethodEnum));
				parserImpl.eSet(prefefinedParser.getEStructuralFeature("editMethod"), cc.transformValue(editMethod, editMethodEnum));
				methodsToParserImpl.put(keyPair, parserImpl);
				implementations.add(parserImpl);
			}
			EObject new_flmf = cc.get(flmf);
			new_flmf.eSet(lmfParser, parserImpl);
		}
		
		if (!implementations.isEmpty()) {
			result.eSet(result.eClass().getEStructuralFeature("labelParsers"), newGenParser);
			// XXX try Proxy&InvocationHandler
			newGenParser.eSet(newGenParserClass.getEStructuralFeature("providerPriority"), cc.transformValue(parserProviderPriority, oldGenDiagram.eGet(parserProviderPriority)));
			newGenParser.eSet(newGenParserClass.getEStructuralFeature("extensibleViaService"), Boolean.TRUE); // override default as old models may rely on default behavior, XXX although may force education with false?
			newGenParser.eSet(newGenParserClass.getEStructuralFeature("packageName"), oldGenDiagram.eGet(oldGenDiagram.eClass().getEStructuralFeature("providersPackageName")));
			newGenParser.eSet(newGenParserClass.getEStructuralFeature("className"), oldGenDiagram.eGet(parserProviderClassName));
			newGenParser.eSet(newGenParserClass.getEStructuralFeature("implPackageName"), oldGenDiagram.eGet(parsersPackageName));
		}
		// loadResource was generated unconditionally
		EObject loadResAction = myMetaPackage.getEFactoryInstance().create((EClass) myMetaPackage.getEClassifier("LoadResourceAction"));
		String editorPackageName = null; // DiagramImpl#getEditorPackageName()
		EStructuralFeature genAction_qualifiedClassName = loadResAction.eClass().getEStructuralFeature("qualifiedClassName");
		loadResAction.eSet(genAction_qualifiedClassName, editorPackageName + '.' + oldGenDiagram.eGet(loadResourceActionClassName));
		EObject diagramCtxMenu = myMetaPackage.getEFactoryInstance().create((EClass) myMetaPackage.getEClassifier("GenContextMenu"));
		@SuppressWarnings("unchecked")
		List<EObject> allContextMenus = (List<EObject>) result.eGet(result.eClass().getEStructuralFeature("contextMenus"));
		allContextMenus.add(diagramCtxMenu);
		@SuppressWarnings("unchecked")
		List<EObject> ctxMenuContext = (List<EObject>) diagramCtxMenu.eGet(diagramCtxMenu.eClass().getEStructuralFeature("context"));
		// genContextMenu.getContext().add(result.getDiagram());
		ctxMenuContext.add((EObject) result.eGet(result.eClass().getEStructuralFeature("diagram")));
		@SuppressWarnings("unchecked")
		List<EObject> ctxMenuItems = (List<EObject>) diagramCtxMenu.eGet(diagramCtxMenu.eClass().getEStructuralFeature("items"));
		ctxMenuItems.add(loadResAction);
		if (/*oldGenDiagram.generateCreateShortcutAction()*/ ((List<?>) oldGenDiagram.eGet(oldGenDiagram.eClass().getEStructuralFeature("containsShortcutsTo"))).size() > 0) {
			EObject createShortcutsAction = myMetaPackage.getEFactoryInstance().create((EClass) myMetaPackage.getEClassifier("CreateShortcutAction"));
			createShortcutsAction.eSet(genAction_qualifiedClassName, editorPackageName + '.' + oldGenDiagram.eGet(createShortcutActionClassName));
			ctxMenuItems.add(createShortcutsAction);
		}
		
		return result;
	}
}
