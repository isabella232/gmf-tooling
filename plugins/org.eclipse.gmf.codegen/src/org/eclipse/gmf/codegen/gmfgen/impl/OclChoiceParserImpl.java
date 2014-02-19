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

import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.OclChoiceParser;
import org.eclipse.gmf.codegen.gmfgen.ValueExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Choice Parser</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.OclChoiceParserImpl#getItemsExpression <em>Items Expression</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.OclChoiceParserImpl#getShowExpression <em>Show Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclChoiceParserImpl extends GenParserImplementationImpl implements OclChoiceParser {
	/**
	 * The cached value of the '{@link #getItemsExpression() <em>Items Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemsExpression()
	 * @generated
	 * @ordered
	 */
	protected ValueExpression itemsExpression;

	/**
	 * The cached value of the '{@link #getShowExpression() <em>Show Expression</em>}' reference.
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
	protected OclChoiceParserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getOclChoiceParser();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression getItemsExpression() {
		if (itemsExpression != null && itemsExpression.eIsProxy()) {
			InternalEObject oldItemsExpression = (InternalEObject)itemsExpression;
			itemsExpression = (ValueExpression)eResolveProxy(oldItemsExpression);
			if (itemsExpression != oldItemsExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.OCL_CHOICE_PARSER__ITEMS_EXPRESSION, oldItemsExpression, itemsExpression));
			}
		}
		return itemsExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression basicGetItemsExpression() {
		return itemsExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemsExpression(ValueExpression newItemsExpression) {
		ValueExpression oldItemsExpression = itemsExpression;
		itemsExpression = newItemsExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.OCL_CHOICE_PARSER__ITEMS_EXPRESSION, oldItemsExpression, itemsExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression getShowExpression() {
		if (showExpression != null && showExpression.eIsProxy()) {
			InternalEObject oldShowExpression = (InternalEObject)showExpression;
			showExpression = (ValueExpression)eResolveProxy(oldShowExpression);
			if (showExpression != oldShowExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.OCL_CHOICE_PARSER__SHOW_EXPRESSION, oldShowExpression, showExpression));
			}
		}
		return showExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression basicGetShowExpression() {
		return showExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowExpression(ValueExpression newShowExpression) {
		ValueExpression oldShowExpression = showExpression;
		showExpression = newShowExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.OCL_CHOICE_PARSER__SHOW_EXPRESSION, oldShowExpression, showExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method returns the FQN of one of the existing classes, in particular, 
	 * either 'org.eclipse.gmf.tooling.runtime.parsers.OclChoiceParser' or 'org.eclipse.gmf.tooling.runtime.parsers.OclTrackerChoiceParser'
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedClassName() {
		final String packageName = "org.eclipse.gmf.tooling.runtime.parsers"; //$NON-NLS-1$
		final String className = getShowExpression() == null ? "OclChoiceParser" : "OclTrackerChoiceParser"; //$NON-NLS-1$ //$NON-NLS-2$
		return packageName + '.' + className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGenPackage.OCL_CHOICE_PARSER__ITEMS_EXPRESSION:
				if (resolve) return getItemsExpression();
				return basicGetItemsExpression();
			case GMFGenPackage.OCL_CHOICE_PARSER__SHOW_EXPRESSION:
				if (resolve) return getShowExpression();
				return basicGetShowExpression();
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
			case GMFGenPackage.OCL_CHOICE_PARSER__ITEMS_EXPRESSION:
				setItemsExpression((ValueExpression)newValue);
				return;
			case GMFGenPackage.OCL_CHOICE_PARSER__SHOW_EXPRESSION:
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
			case GMFGenPackage.OCL_CHOICE_PARSER__ITEMS_EXPRESSION:
				setItemsExpression((ValueExpression)null);
				return;
			case GMFGenPackage.OCL_CHOICE_PARSER__SHOW_EXPRESSION:
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
			case GMFGenPackage.OCL_CHOICE_PARSER__ITEMS_EXPRESSION:
				return itemsExpression != null;
			case GMFGenPackage.OCL_CHOICE_PARSER__SHOW_EXPRESSION:
				return showExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //OclChoiceParserImpl
