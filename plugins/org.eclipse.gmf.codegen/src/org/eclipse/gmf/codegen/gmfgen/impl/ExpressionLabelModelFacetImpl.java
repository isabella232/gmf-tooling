/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmf.codegen.gmfgen.ExpressionLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenConstraint;
import org.eclipse.gmf.codegen.gmfgen.ValueExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Label Model Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.ExpressionLabelModelFacetImpl#getViewExpression <em>View Expression</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.ExpressionLabelModelFacetImpl#getEditExpression <em>Edit Expression</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.ExpressionLabelModelFacetImpl#getValidateExpression <em>Validate Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionLabelModelFacetImpl extends LabelModelFacetImpl implements ExpressionLabelModelFacet {
	/**
	 * The cached value of the '{@link #getViewExpression() <em>View Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewExpression()
	 * @generated
	 * @ordered
	 */
	protected ValueExpression viewExpression;
	/**
	 * The cached value of the '{@link #getEditExpression() <em>Edit Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditExpression()
	 * @generated
	 * @ordered
	 */
	protected ValueExpression editExpression;
	/**
	 * The cached value of the '{@link #getValidateExpression() <em>Validate Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidateExpression()
	 * @generated
	 * @ordered
	 */
	protected GenConstraint validateExpression;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionLabelModelFacetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getExpressionLabelModelFacet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression getViewExpression() {
		if (viewExpression != null && viewExpression.eIsProxy()) {
			InternalEObject oldViewExpression = (InternalEObject)viewExpression;
			viewExpression = (ValueExpression)eResolveProxy(oldViewExpression);
			if (viewExpression != oldViewExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VIEW_EXPRESSION, oldViewExpression, viewExpression));
			}
		}
		return viewExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression basicGetViewExpression() {
		return viewExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewExpression(ValueExpression newViewExpression) {
		ValueExpression oldViewExpression = viewExpression;
		viewExpression = newViewExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VIEW_EXPRESSION, oldViewExpression, viewExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression getEditExpression() {
		if (editExpression != null && editExpression.eIsProxy()) {
			InternalEObject oldEditExpression = (InternalEObject)editExpression;
			editExpression = (ValueExpression)eResolveProxy(oldEditExpression);
			if (editExpression != oldEditExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__EDIT_EXPRESSION, oldEditExpression, editExpression));
			}
		}
		return editExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression basicGetEditExpression() {
		return editExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditExpression(ValueExpression newEditExpression) {
		ValueExpression oldEditExpression = editExpression;
		editExpression = newEditExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__EDIT_EXPRESSION, oldEditExpression, editExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenConstraint getValidateExpression() {
		if (validateExpression != null && validateExpression.eIsProxy()) {
			InternalEObject oldValidateExpression = (InternalEObject)validateExpression;
			validateExpression = (GenConstraint)eResolveProxy(oldValidateExpression);
			if (validateExpression != oldValidateExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VALIDATE_EXPRESSION, oldValidateExpression, validateExpression));
			}
		}
		return validateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenConstraint basicGetValidateExpression() {
		return validateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidateExpression(GenConstraint newValidateExpression) {
		GenConstraint oldValidateExpression = validateExpression;
		validateExpression = newValidateExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VALIDATE_EXPRESSION, oldValidateExpression, validateExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VIEW_EXPRESSION:
				if (resolve) return getViewExpression();
				return basicGetViewExpression();
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__EDIT_EXPRESSION:
				if (resolve) return getEditExpression();
				return basicGetEditExpression();
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VALIDATE_EXPRESSION:
				if (resolve) return getValidateExpression();
				return basicGetValidateExpression();
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
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VIEW_EXPRESSION:
				setViewExpression((ValueExpression)newValue);
				return;
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__EDIT_EXPRESSION:
				setEditExpression((ValueExpression)newValue);
				return;
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VALIDATE_EXPRESSION:
				setValidateExpression((GenConstraint)newValue);
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
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VIEW_EXPRESSION:
				setViewExpression((ValueExpression)null);
				return;
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__EDIT_EXPRESSION:
				setEditExpression((ValueExpression)null);
				return;
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VALIDATE_EXPRESSION:
				setValidateExpression((GenConstraint)null);
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
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VIEW_EXPRESSION:
				return viewExpression != null;
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__EDIT_EXPRESSION:
				return editExpression != null;
			case GMFGenPackage.EXPRESSION_LABEL_MODEL_FACET__VALIDATE_EXPRESSION:
				return validateExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ExpressionLabelModelFacetImpl
