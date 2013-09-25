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
import org.eclipse.gmf.gmfgraph.ColorPin;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Color Pin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.ColorPinImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.ColorPinImpl#isBackgroundNotForeground <em>Background Not Foreground</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColorPinImpl extends EObjectImpl implements ColorPin {
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
	 * The default value of the '{@link #isBackgroundNotForeground() <em>Background Not Foreground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBackgroundNotForeground()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BACKGROUND_NOT_FOREGROUND_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBackgroundNotForeground() <em>Background Not Foreground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBackgroundNotForeground()
	 * @generated
	 * @ordered
	 */
	protected boolean backgroundNotForeground = BACKGROUND_NOT_FOREGROUND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorPinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGraphPackage.eINSTANCE.getColorPin();
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
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.COLOR_PIN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBackgroundNotForeground() {
		return backgroundNotForeground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundNotForeground(boolean newBackgroundNotForeground) {
		boolean oldBackgroundNotForeground = backgroundNotForeground;
		backgroundNotForeground = newBackgroundNotForeground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.COLOR_PIN__BACKGROUND_NOT_FOREGROUND, oldBackgroundNotForeground, backgroundNotForeground));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getOperationName() {
		return isBackgroundNotForeground() ? "setBackgroundColor" : "setForegroundColor";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getOperationType() {
		return "Tuple(red:Integer, green:Integer, blue:Integer)";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGraphPackage.COLOR_PIN__NAME:
				return getName();
			case GMFGraphPackage.COLOR_PIN__BACKGROUND_NOT_FOREGROUND:
				return isBackgroundNotForeground();
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
			case GMFGraphPackage.COLOR_PIN__NAME:
				setName((String)newValue);
				return;
			case GMFGraphPackage.COLOR_PIN__BACKGROUND_NOT_FOREGROUND:
				setBackgroundNotForeground((Boolean)newValue);
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
			case GMFGraphPackage.COLOR_PIN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GMFGraphPackage.COLOR_PIN__BACKGROUND_NOT_FOREGROUND:
				setBackgroundNotForeground(BACKGROUND_NOT_FOREGROUND_EDEFAULT);
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
			case GMFGraphPackage.COLOR_PIN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GMFGraphPackage.COLOR_PIN__BACKGROUND_NOT_FOREGROUND:
				return backgroundNotForeground != BACKGROUND_NOT_FOREGROUND_EDEFAULT;
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
		result.append(", backgroundNotForeground: ");
		result.append(backgroundNotForeground);
		result.append(')');
		return result.toString();
	}

} //ColorPinImpl
