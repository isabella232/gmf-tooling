/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.OclChoiceLabelMapping;
import org.eclipse.gmf.mappings.ValueExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Choice Label Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.impl.OclChoiceLabelMappingImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.OclChoiceLabelMappingImpl#getItemsExpression <em>Items Expression</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.OclChoiceLabelMappingImpl#getShowExpression <em>Show Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclChoiceLabelMappingImpl extends LabelMappingImpl implements OclChoiceLabelMapping {
	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature feature;

	/**
	 * The cached value of the '{@link #getItemsExpression() <em>Items Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemsExpression()
	 * @generated
	 * @ordered
	 */
	protected ValueExpression itemsExpression;

	/**
	 * The cached value of the '{@link #getShowExpression() <em>Show Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowExpression()
	 * @generated
	 * @ordered
	 */
	protected ValueExpression showExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclChoiceLabelMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getOclChoiceLabelMapping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (EStructuralFeature)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(EStructuralFeature newFeature) {
		EStructuralFeature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression getItemsExpression() {
		return itemsExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItemsExpression(ValueExpression newItemsExpression, NotificationChain msgs) {
		ValueExpression oldItemsExpression = itemsExpression;
		itemsExpression = newItemsExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__ITEMS_EXPRESSION, oldItemsExpression, newItemsExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemsExpression(ValueExpression newItemsExpression) {
		if (newItemsExpression != itemsExpression) {
			NotificationChain msgs = null;
			if (itemsExpression != null)
				msgs = ((InternalEObject)itemsExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__ITEMS_EXPRESSION, null, msgs);
			if (newItemsExpression != null)
				msgs = ((InternalEObject)newItemsExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__ITEMS_EXPRESSION, null, msgs);
			msgs = basicSetItemsExpression(newItemsExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__ITEMS_EXPRESSION, newItemsExpression, newItemsExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression getShowExpression() {
		return showExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShowExpression(ValueExpression newShowExpression, NotificationChain msgs) {
		ValueExpression oldShowExpression = showExpression;
		showExpression = newShowExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__SHOW_EXPRESSION, oldShowExpression, newShowExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowExpression(ValueExpression newShowExpression) {
		if (newShowExpression != showExpression) {
			NotificationChain msgs = null;
			if (showExpression != null)
				msgs = ((InternalEObject)showExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__SHOW_EXPRESSION, null, msgs);
			if (newShowExpression != null)
				msgs = ((InternalEObject)newShowExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__SHOW_EXPRESSION, null, msgs);
			msgs = basicSetShowExpression(newShowExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__SHOW_EXPRESSION, newShowExpression, newShowExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__ITEMS_EXPRESSION:
				return basicSetItemsExpression(null, msgs);
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__SHOW_EXPRESSION:
				return basicSetShowExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__ITEMS_EXPRESSION:
				return getItemsExpression();
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__SHOW_EXPRESSION:
				return getShowExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__FEATURE:
				setFeature((EStructuralFeature)newValue);
				return;
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__ITEMS_EXPRESSION:
				setItemsExpression((ValueExpression)newValue);
				return;
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__SHOW_EXPRESSION:
				setShowExpression((ValueExpression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__FEATURE:
				setFeature((EStructuralFeature)null);
				return;
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__ITEMS_EXPRESSION:
				setItemsExpression((ValueExpression)null);
				return;
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__SHOW_EXPRESSION:
				setShowExpression((ValueExpression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__FEATURE:
				return feature != null;
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__ITEMS_EXPRESSION:
				return itemsExpression != null;
			case GMFMapPackage.OCL_CHOICE_LABEL_MAPPING__SHOW_EXPRESSION:
				return showExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //OclChoiceLabelMappingImpl
