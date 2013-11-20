/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.gmfgraph.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmf.gmfgraph.CustomPin;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Pin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.CustomPinImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.CustomPinImpl#getCustomOperationName <em>Custom Operation Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.CustomPinImpl#getCustomOperationType <em>Custom Operation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomPinImpl extends EObjectImpl implements CustomPin {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCustomOperationName() <em>Custom Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomOperationName()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOM_OPERATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomOperationName() <em>Custom Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomOperationName()
	 * @generated
	 * @ordered
	 */
	protected String customOperationName = CUSTOM_OPERATION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCustomOperationType() <em>Custom Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomOperationType()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOM_OPERATION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomOperationType() <em>Custom Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomOperationType()
	 * @generated
	 * @ordered
	 */
	protected String customOperationType = CUSTOM_OPERATION_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomPinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGraphPackage.eINSTANCE.getCustomPin();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.CUSTOM_PIN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomOperationName() {
		return customOperationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomOperationName(String newCustomOperationName) {
		String oldCustomOperationName = customOperationName;
		customOperationName = newCustomOperationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.CUSTOM_PIN__CUSTOM_OPERATION_NAME, oldCustomOperationName, customOperationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomOperationType() {
		return customOperationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomOperationType(String newCustomOperationType) {
		String oldCustomOperationType = customOperationType;
		customOperationType = newCustomOperationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.CUSTOM_PIN__CUSTOM_OPERATION_TYPE, oldCustomOperationType, customOperationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getOperationName() {
		return getCustomOperationName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getOperationType() {
		return getCustomOperationType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGraphPackage.CUSTOM_PIN__NAME:
				return getName();
			case GMFGraphPackage.CUSTOM_PIN__CUSTOM_OPERATION_NAME:
				return getCustomOperationName();
			case GMFGraphPackage.CUSTOM_PIN__CUSTOM_OPERATION_TYPE:
				return getCustomOperationType();
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
			case GMFGraphPackage.CUSTOM_PIN__NAME:
				setName((String)newValue);
				return;
			case GMFGraphPackage.CUSTOM_PIN__CUSTOM_OPERATION_NAME:
				setCustomOperationName((String)newValue);
				return;
			case GMFGraphPackage.CUSTOM_PIN__CUSTOM_OPERATION_TYPE:
				setCustomOperationType((String)newValue);
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
			case GMFGraphPackage.CUSTOM_PIN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GMFGraphPackage.CUSTOM_PIN__CUSTOM_OPERATION_NAME:
				setCustomOperationName(CUSTOM_OPERATION_NAME_EDEFAULT);
				return;
			case GMFGraphPackage.CUSTOM_PIN__CUSTOM_OPERATION_TYPE:
				setCustomOperationType(CUSTOM_OPERATION_TYPE_EDEFAULT);
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
			case GMFGraphPackage.CUSTOM_PIN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GMFGraphPackage.CUSTOM_PIN__CUSTOM_OPERATION_NAME:
				return CUSTOM_OPERATION_NAME_EDEFAULT == null ? customOperationName != null : !CUSTOM_OPERATION_NAME_EDEFAULT.equals(customOperationName);
			case GMFGraphPackage.CUSTOM_PIN__CUSTOM_OPERATION_TYPE:
				return CUSTOM_OPERATION_TYPE_EDEFAULT == null ? customOperationType != null : !CUSTOM_OPERATION_TYPE_EDEFAULT.equals(customOperationType);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", customOperationName: ");
		result.append(customOperationName);
		result.append(", customOperationType: ");
		result.append(customOperationType);
		result.append(')');
		return result.toString();
	}

} //CustomPinImpl
