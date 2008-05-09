/*
 * Copyright (c) 2008 Borland Software Corporation
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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

/**
 * @author artem
 */
public class CustomCopier extends EcoreUtil.Copier {
	private final HashMap<EStructuralFeature, List<EObject>> myIgnoredFeatures;

	private final EPackage ePack;

	private final EFactory eFact;

	private CustomCopier(EPackage metaPackage) {
		super(false);
		ePack = metaPackage;
		eFact = ePack.getEFactoryInstance();
		myIgnoredFeatures = new HashMap<EStructuralFeature, List<EObject>>();
	}

	private void ignore(EStructuralFeature eFeature) {
		assert eFeature != null;
		assert !myIgnoredFeatures.containsKey(eFeature);
		myIgnoredFeatures.put(eFeature, new LinkedList<EObject>());
	}

	@Override
	public EObject copy(EObject eObject) {
		EObject copyEObject = createCopy(eObject);
		put(eObject, copyEObject);
		EClass eClass = eObject.eClass();
		for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
			EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
			// >>>
			if (myIgnoredFeatures.containsKey(eStructuralFeature)) {
				myIgnoredFeatures.get(eStructuralFeature).add(eObject);
				continue;
			}
			// <<<
			if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived()) {
				if (eStructuralFeature instanceof EAttribute) {
					copyAttribute((EAttribute) eStructuralFeature, eObject, copyEObject);
				} else {
					EReference eReference = (EReference) eStructuralFeature;
					if (eReference.isContainment()) {
						copyContainment(eReference, eObject, copyEObject);
					}
				}
			}
		}

		copyProxyURI(eObject, copyEObject);

		return copyEObject;
	}

	@Override
	protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {
		if (eObject.eIsSet(eAttribute)) {
			if (FeatureMapUtil.isFeatureMap(eAttribute)) {
				FeatureMap featureMap = (FeatureMap) eObject.eGet(eAttribute);
				for (int i = 0, size = featureMap.size(); i < size; ++i) {
					EStructuralFeature feature = featureMap.getEStructuralFeature(i);
					if (feature instanceof EReference && ((EReference) feature).isContainment()) {
						Object value = featureMap.getValue(i);
						if (value != null) {
							copy((EObject) value);
						}
					}
				}
			} else if (eAttribute.isMany()) {
				List<?> source = (List<?>) eObject.eGet(eAttribute);
				@SuppressWarnings("unchecked")
				List<Object> target = (List<Object>) copyEObject.eGet(getTarget(eAttribute));
				if (source.isEmpty()) {
					target.clear();
				} else {
					// >>>
					if (eAttribute.getEAttributeType() instanceof EEnum) {
						for (Object o : source) {
							target.add(transformValue(eAttribute, o));
						}
					} else {
						// <<<
						target.addAll(source);
					}
				}
			} else {
				// >>>
				copyEObject.eSet(getTarget(eAttribute), transformValue(eAttribute, eObject.eGet(eAttribute)));
				//copyEObject.eSet(getTarget(eAttribute), eObject.eGet(eAttribute));
				//
			}
		}
	}

	private Object transformValue(EAttribute eAttr, Object value) {
		if (eAttr.getEType() instanceof EEnum) {
			EFactory f = eAttr.getEContainingClass().getEPackage().getEFactoryInstance();
			String s = f.convertToString(eAttr.getEAttributeType(), value);
			EClassifier newModelEnum = ePack.getEClassifier(eAttr.getEType().getName());
			Object r = eFact.createFromString((EDataType) newModelEnum, s);
			return r;
		}
		return value;
	}

	@Override
	protected EClass getTarget(EClass eClass) {
		EClassifier c = ePack.getEClassifier(eClass.getName());
		if (c instanceof EClass) {
			return (EClass) c;
		}
		return super.getTarget(eClass);
	}

	@Override
	protected EStructuralFeature getTarget(EStructuralFeature structuralFeature) {
		EStructuralFeature sf = getTarget(structuralFeature.getEContainingClass()).getEStructuralFeature(structuralFeature.getName());
		if (sf != null) {
			return sf;
		}
		return super.getTarget(structuralFeature);
	}

	@SuppressWarnings("unchecked")
	public static EObject go(EObject o, EPackage metaPackage) {
		EPackage oldGenModel = o.eClass().getEPackage();
		final EStructuralFeature modelElementSelector = ((EClass) oldGenModel.getEClassifier("TypeModelFacet")).getEStructuralFeature("modelElementSelector");
		final EStructuralFeature valueExprLanguage = ((EClass) oldGenModel.getEClassifier("ValueExpression")).getEStructuralFeature("language");
		final EStructuralFeature gfvsBody = ((EClass) oldGenModel.getEClassifier("GenFeatureValueSpec")).getEStructuralFeature("body");
		final EStructuralFeature lcSourceEnd = ((EClass) oldGenModel.getEClassifier("GenLinkConstraints")).getEStructuralFeature("sourceEnd");
		final EStructuralFeature lcTargetEnd = ((EClass) oldGenModel.getEClassifier("GenLinkConstraints")).getEStructuralFeature("targetEnd");
		final EStructuralFeature auditRule = ((EClass) oldGenModel.getEClassifier("GenAuditRule")).getEStructuralFeature("rule");
		final EStructuralFeature metricRule = ((EClass) oldGenModel.getEClassifier("GenMetricRule")).getEStructuralFeature("rule");
		final EStructuralFeature providers = ((EClass) oldGenModel.getEClassifier("GenExpressionProviderContainer")).getEStructuralFeature("providers");
		//
		CustomCopier cc = new CustomCopier(metaPackage);
		cc.ignore(modelElementSelector);
		cc.ignore(valueExprLanguage);
		cc.ignore(gfvsBody);
		cc.ignore(lcSourceEnd);
		cc.ignore(lcTargetEnd);
		cc.ignore(auditRule);
		cc.ignore(metricRule);
		cc.ignore(providers);
		EObject result = cc.copy(o);
		cc.copyReferences();
		//
		HashMap<EObject, EObject> oldValueExpr2New = new HashMap<EObject, EObject>();
		assert cc.myIgnoredFeatures.get(providers).size() < 2;
		EObject providerContainer = cc.myIgnoredFeatures.get(providers).isEmpty() ? null : cc.myIgnoredFeatures.get(providers).get(0);
		if (providerContainer != null) {
			EObject newProviderContainer = cc.get(providerContainer);
			List<EObject> allNewProviders = (List<EObject>) newProviderContainer.eGet(newProviderContainer.eClass().getEStructuralFeature(providers.getName()));
			for (EObject oldProvider : (List<EObject>) providerContainer.eGet(providers)) {
				EClass newProviderClass = (EClass) metaPackage.getEClassifier(oldProvider.eClass().getName());
				EObject newProvider = metaPackage.getEFactoryInstance().create(newProviderClass);
				if ("GenExpressionInterpreter".equals(oldProvider.eClass().getName())) {
					EStructuralFeature oldLang = oldProvider.eClass().getEStructuralFeature("language");
					EStructuralFeature oldClassName = oldProvider.eClass().getEStructuralFeature("className");
					newProvider.eSet(newProviderClass.getEStructuralFeature(oldLang.getName()), cc.transformValue((EAttribute) oldLang, oldProvider.eGet(oldLang)));
					newProvider.eSet(newProviderClass.getEStructuralFeature(oldClassName.getName()), oldProvider.eGet(oldClassName));
				}
				allNewProviders.add(newProvider);
				EStructuralFeature provBaseExpressions = ((EClass) oldGenModel.getEClassifier("GenExpressionProviderBase")).getEStructuralFeature("expressions");
				List<EObject> newProviderExpressions = (List<EObject>) newProvider.eGet(newProvider.eClass().getEStructuralFeature(provBaseExpressions.getName())); 
				for (EObject oldVE : (List<EObject>) oldProvider.eGet(provBaseExpressions)) {
					EObject newVE;
					if (oldVE.eClass().getName().equals("GenConstraint")) {
						newVE = metaPackage.getEFactoryInstance().create((EClass) metaPackage.getEClassifier("GenConstraint"));
					} else {
						// intentionally transform GenFeatureValueSpec into plain ValueExpression
						newVE = metaPackage.getEFactoryInstance().create((EClass) metaPackage.getEClassifier("ValueExpression"));
					}
					Object bodyValue = oldVE.eGet(oldVE.eClass().getEStructuralFeature("body"));
					newVE.eSet(newVE.eClass().getEStructuralFeature("body"), bodyValue);
					oldValueExpr2New.put(oldVE, newVE);
					newProviderExpressions.add(newVE);
				}
			}
			containment2AssociationCase(cc, modelElementSelector, oldValueExpr2New, allNewProviders);
			containment2AssociationCase(cc, lcSourceEnd, oldValueExpr2New, allNewProviders);
			containment2AssociationCase(cc, lcTargetEnd, oldValueExpr2New, allNewProviders);
			containment2AssociationCase(cc, auditRule, oldValueExpr2New, allNewProviders);
			containment2AssociationCase(cc, metricRule, oldValueExpr2New, allNewProviders);
			for (EObject vs : cc.myIgnoredFeatures.get(gfvsBody)) {
				assert vs.eClass().getName().equals("GenFeatureValueSpec");
				EObject newVS = cc.get(vs);
				EObject newVE = oldValueExpr2New.get(vs);
				if (newVE == null) {
					// isCopy == true, need to match by lang/body
					newVE = matchCopyVE(vs, allNewProviders);
				}
				if (newVE != null) {
					newVS.eSet(newVS.eClass().getEStructuralFeature("value"), newVE);
				}
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private static EObject matchCopyVE(EObject oldVE, List<EObject> allProviders) {
		final EStructuralFeature langFeature = oldVE.eClass().getEStructuralFeature("language");
		final EStructuralFeature bodyFeature = oldVE.eClass().getEStructuralFeature("body");
		if (langFeature == null || bodyFeature == null) {
			return null;
		}
		final Object langValue = oldVE.eClass().getEPackage().getEFactoryInstance().convertToString((EDataType) langFeature.getEType(), oldVE.eGet(langFeature));
		final Object bodyValue = oldVE.eGet(bodyFeature);
		if (bodyValue != null) {
			for (EObject p : allProviders) {
				EStructuralFeature provLangFeat = p.eClass().getEStructuralFeature("language");
				Object providerLang = p.eClass().getEPackage().getEFactoryInstance().convertToString((EDataType) provLangFeat.getEType(), p.eGet(provLangFeat));
				if (providerLang != null && providerLang.equals(langValue)) {
					for (EObject ve : (List<EObject>) p.eGet(p.eClass().getEStructuralFeature("expressions"))) {
						EStructuralFeature veBodyFeature = ve.eClass().getEStructuralFeature("body");
						if (veBodyFeature != null /* just in case */&& bodyValue.equals(ve.eGet(veBodyFeature))) {
							return ve;
						}
					}
				}
			}
		} // body == null, no much sense to match...
		return null;
	}

	private static void containment2AssociationCase(CustomCopier cc, EStructuralFeature oldFeature, HashMap<EObject, EObject> old2newVE, List<EObject> allProviders) {
		for (EObject o : cc.myIgnoredFeatures.get(oldFeature)) {
			EObject n = cc.get(o);
			Object oldVE = o.eGet(oldFeature);
			if (oldVE == null) {
				continue; //nothing to do.
			}
			EObject newVE = old2newVE.get(oldVE);
			if (newVE == null) {
				// isCopy == true, need to match by lang/body
				if (oldVE instanceof EObject) {
					newVE = matchCopyVE((EObject) oldVE, allProviders);
				}
			}
			if (newVE != null) {
				n.eSet(n.eClass().getEStructuralFeature(oldFeature.getName()), newVE);
			}
		}
	}
}
