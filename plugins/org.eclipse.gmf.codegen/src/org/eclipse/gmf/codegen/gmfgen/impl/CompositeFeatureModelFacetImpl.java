/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.gmf.codegen.gmfgen.CompositeFeatureModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Feature Model Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.CompositeFeatureModelFacetImpl#getMetaFeatures <em>Meta Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeFeatureModelFacetImpl extends EObjectImpl implements CompositeFeatureModelFacet {
	/**
	 * The cached value of the '{@link #getMetaFeatures() <em>Meta Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList metaFeatures = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeFeatureModelFacetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getCompositeFeatureModelFacet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getMetaFeatures() {
		if (metaFeatures == null) {
			metaFeatures = new EObjectResolvingEList(GenFeature.class, this, GMFGenPackage.COMPOSITE_FEATURE_MODEL_FACET__META_FEATURES);
		}
		return metaFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGenPackage.COMPOSITE_FEATURE_MODEL_FACET__META_FEATURES:
				return getMetaFeatures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GMFGenPackage.COMPOSITE_FEATURE_MODEL_FACET__META_FEATURES:
				getMetaFeatures().clear();
				getMetaFeatures().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case GMFGenPackage.COMPOSITE_FEATURE_MODEL_FACET__META_FEATURES:
				getMetaFeatures().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GMFGenPackage.COMPOSITE_FEATURE_MODEL_FACET__META_FEATURES:
				return metaFeatures != null && !metaFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeFeatureModelFacetImpl
