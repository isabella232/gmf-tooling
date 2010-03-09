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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.ExpressionLabelMapping;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.ValueExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Label Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ExpressionLabelMappingImpl#getViewExpression <em>View Expression</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ExpressionLabelMappingImpl#getEditExpression <em>Edit Expression</em>}</li>
 *   <li>{@link org.eclipse.gmf.mappings.impl.ExpressionLabelMappingImpl#getValidateExpression <em>Validate Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionLabelMappingImpl extends LabelMappingImpl implements ExpressionLabelMapping {
	/**
	 * The cached value of the '{@link #getViewExpression() <em>View Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewExpression()
	 * @generated
	 * @ordered
	 */
	protected ValueExpression viewExpression;

	/**
	 * The cached value of the '{@link #getEditExpression() <em>Edit Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditExpression()
	 * @generated
	 * @ordered
	 */
	protected ValueExpression editExpression;

	/**
	 * The cached value of the '{@link #getValidateExpression() <em>Validate Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidateExpression()
	 * @generated
	 * @ordered
	 */
	protected Constraint validateExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionLabelMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getExpressionLabelMapping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression getViewExpression() {
		return viewExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetViewExpression(ValueExpression newViewExpression, NotificationChain msgs) {
		ValueExpression oldViewExpression = viewExpression;
		viewExpression = newViewExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFMapPackage.EXPRESSION_LABEL_MAPPING__VIEW_EXPRESSION, oldViewExpression, newViewExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewExpression(ValueExpression newViewExpression) {
		if (newViewExpression != viewExpression) {
			NotificationChain msgs = null;
			if (viewExpression != null)
				msgs = ((InternalEObject)viewExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.EXPRESSION_LABEL_MAPPING__VIEW_EXPRESSION, null, msgs);
			if (newViewExpression != null)
				msgs = ((InternalEObject)newViewExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.EXPRESSION_LABEL_MAPPING__VIEW_EXPRESSION, null, msgs);
			msgs = basicSetViewExpression(newViewExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.EXPRESSION_LABEL_MAPPING__VIEW_EXPRESSION, newViewExpression, newViewExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression getEditExpression() {
		return editExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEditExpression(ValueExpression newEditExpression, NotificationChain msgs) {
		ValueExpression oldEditExpression = editExpression;
		editExpression = newEditExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFMapPackage.EXPRESSION_LABEL_MAPPING__EDIT_EXPRESSION, oldEditExpression, newEditExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditExpression(ValueExpression newEditExpression) {
		if (newEditExpression != editExpression) {
			NotificationChain msgs = null;
			if (editExpression != null)
				msgs = ((InternalEObject)editExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.EXPRESSION_LABEL_MAPPING__EDIT_EXPRESSION, null, msgs);
			if (newEditExpression != null)
				msgs = ((InternalEObject)newEditExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.EXPRESSION_LABEL_MAPPING__EDIT_EXPRESSION, null, msgs);
			msgs = basicSetEditExpression(newEditExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.EXPRESSION_LABEL_MAPPING__EDIT_EXPRESSION, newEditExpression, newEditExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getValidateExpression() {
		return validateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidateExpression(Constraint newValidateExpression, NotificationChain msgs) {
		Constraint oldValidateExpression = validateExpression;
		validateExpression = newValidateExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFMapPackage.EXPRESSION_LABEL_MAPPING__VALIDATE_EXPRESSION, oldValidateExpression, newValidateExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidateExpression(Constraint newValidateExpression) {
		if (newValidateExpression != validateExpression) {
			NotificationChain msgs = null;
			if (validateExpression != null)
				msgs = ((InternalEObject)validateExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.EXPRESSION_LABEL_MAPPING__VALIDATE_EXPRESSION, null, msgs);
			if (newValidateExpression != null)
				msgs = ((InternalEObject)newValidateExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFMapPackage.EXPRESSION_LABEL_MAPPING__VALIDATE_EXPRESSION, null, msgs);
			msgs = basicSetValidateExpression(newValidateExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.EXPRESSION_LABEL_MAPPING__VALIDATE_EXPRESSION, newValidateExpression, newValidateExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__VIEW_EXPRESSION:
				return basicSetViewExpression(null, msgs);
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__EDIT_EXPRESSION:
				return basicSetEditExpression(null, msgs);
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__VALIDATE_EXPRESSION:
				return basicSetValidateExpression(null, msgs);
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
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__VIEW_EXPRESSION:
				return getViewExpression();
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__EDIT_EXPRESSION:
				return getEditExpression();
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__VALIDATE_EXPRESSION:
				return getValidateExpression();
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
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__VIEW_EXPRESSION:
				setViewExpression((ValueExpression)newValue);
				return;
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__EDIT_EXPRESSION:
				setEditExpression((ValueExpression)newValue);
				return;
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__VALIDATE_EXPRESSION:
				setValidateExpression((Constraint)newValue);
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
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__VIEW_EXPRESSION:
				setViewExpression((ValueExpression)null);
				return;
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__EDIT_EXPRESSION:
				setEditExpression((ValueExpression)null);
				return;
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__VALIDATE_EXPRESSION:
				setValidateExpression((Constraint)null);
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
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__VIEW_EXPRESSION:
				return viewExpression != null;
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__EDIT_EXPRESSION:
				return editExpression != null;
			case GMFMapPackage.EXPRESSION_LABEL_MAPPING__VALIDATE_EXPRESSION:
				return validateExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ExpressionLabelMappingImpl
