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
		EObject result = cc.go(o);
		assert "GenEditorGenerator".equals(result.eClass().getName());

		final EClass newGenParserClass = (EClass) myMetaPackage.getEClassifier("GenParsers");
		EObject newGenParser = null;
		final HashMap<List<?>, EObject> methodsToParserImpl = new HashMap<List<?>, EObject>();
		assert cc.getIgnoredOwners(viewMethod).size() == cc.getIgnoredOwners(editMethod).size();
		for (EObject flmf : cc.getIgnoredOwners(viewMethod)) {
			Object viewMethodEnum = flmf.eGet(viewMethod);
			Object editMethodEnum = flmf.eGet(editMethod);
			ArrayList<Object> keyPair = new ArrayList<Object>(2); // need a pair as a key
			keyPair.set(0, viewMethodEnum);
			keyPair.set(1, editMethodEnum);
			EObject parserImpl = methodsToParserImpl.get(keyPair);
			if (parserImpl == null) {
				EClass prefefinedParser = (EClass) myMetaPackage.getEClassifier("PredefinedParser");
				parserImpl = myMetaPackage.getEFactoryInstance().create(prefefinedParser);
				parserImpl.eSet(prefefinedParser.getEStructuralFeature("viewMethod"), cc.transformValue(viewMethod, viewMethodEnum));
				parserImpl.eSet(prefefinedParser.getEStructuralFeature("editMethod"), cc.transformValue(editMethod, editMethodEnum));
				methodsToParserImpl.put(keyPair, parserImpl);
				if (newGenParser == null) {
					newGenParser = myMetaPackage.getEFactoryInstance().create(newGenParserClass);
				}
				@SuppressWarnings("unchecked")
				List<EObject> implementations = (List<EObject>) newGenParser.eGet(newGenParser.eClass().getEStructuralFeature("implementations"));
				implementations.add(parserImpl);
			}
			EObject new_flmf = cc.get(flmf);
			new_flmf.eSet(new_flmf.eClass().getEStructuralFeature("parser"), parserImpl);
		}
		EObject oldGenDiagram = (EObject) o.eGet(o.eClass().getEStructuralFeature("diagram"));
		
		if (newGenParser != null) { // few FeatureLabelModelFacet found
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
