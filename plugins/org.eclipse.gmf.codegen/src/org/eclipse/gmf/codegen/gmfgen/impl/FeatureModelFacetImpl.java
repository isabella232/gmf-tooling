/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmf.codegen.gmfgen.FeatureModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Model Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.FeatureModelFacetImpl#getMetaFeature <em>Meta Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureModelFacetImpl extends EObjectImpl implements FeatureModelFacet {
	/**
	 * The cached value of the '{@link #getMetaFeature() <em>Meta Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaFeature()
	 * @generated
	 * @ordered
	 */
	protected GenFeature metaFeature = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureModelFacetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getFeatureModelFacet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature getMetaFeature() {
		if (metaFeature != null && metaFeature.eIsProxy()) {
			GenFeature oldMetaFeature = metaFeature;
			metaFeature = (GenFeature)eResolveProxy((InternalEObject)metaFeature);
			if (metaFeature != oldMetaFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.FEATURE_MODEL_FACET__META_FEATURE, oldMetaFeature, metaFeature));
			}
		}
		return metaFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature basicGetMetaFeature() {
		return metaFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaFeature(GenFeature newMetaFeature) {
		GenFeature oldMetaFeature = metaFeature;
		metaFeature = newMetaFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.FEATURE_MODEL_FACET__META_FEATURE, oldMetaFeature, metaFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFGenPackage.FEATURE_MODEL_FACET__META_FEATURE:
				if (resolve) return getMetaFeature();
				return basicGetMetaFeature();
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
			case GMFGenPackage.FEATURE_MODEL_FACET__META_FEATURE:
				setMetaFeature((GenFeature)newValue);
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
			case GMFGenPackage.FEATURE_MODEL_FACET__META_FEATURE:
				setMetaFeature((GenFeature)null);
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
			case GMFGenPackage.FEATURE_MODEL_FACET__META_FEATURE:
				return metaFeature != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //FeatureModelFacetImpl
