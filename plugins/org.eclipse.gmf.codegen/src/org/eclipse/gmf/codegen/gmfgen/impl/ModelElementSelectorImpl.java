/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.ModelElementSelector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ModelElementSelectorImpl extends ValueExpressionImpl implements ModelElementSelector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getModelElementSelector();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String[] getRequiredPluginIDs() {
		// For now hardcode only the default support for OCL
		// TODO - to be refactored to plugg-in other languages
		if("ocl".equals(getLanguage())) { //$NON-NLS-1$
			return new String[] { "org.eclipse.emf.query.ocl" }; //$NON-NLS-1$
		}
		return new String[0];		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFGenPackage.MODEL_ELEMENT_SELECTOR__BODY:
				return getBody();
			case GMFGenPackage.MODEL_ELEMENT_SELECTOR__LANGUAGE:
				return getLanguage();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFGenPackage.MODEL_ELEMENT_SELECTOR__BODY:
				setBody((String)newValue);
				return;
			case GMFGenPackage.MODEL_ELEMENT_SELECTOR__LANGUAGE:
				setLanguage((String)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFGenPackage.MODEL_ELEMENT_SELECTOR__BODY:
				setBody(BODY_EDEFAULT);
				return;
			case GMFGenPackage.MODEL_ELEMENT_SELECTOR__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFGenPackage.MODEL_ELEMENT_SELECTOR__BODY:
				return BODY_EDEFAULT == null ? body != null : !BODY_EDEFAULT.equals(body);
			case GMFGenPackage.MODEL_ELEMENT_SELECTOR__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
		}
		return eDynamicIsSet(eFeature);
	}

} //ModelElementSelectorImpl
