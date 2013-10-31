/**
 */
package pins.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import pins.PinsChild;
import pins.PinsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pins.impl.PinsChildImpl#getPinsChild <em>Pins Child</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PinsChildImpl extends EObjectImpl implements PinsChild {
	/**
	 * The default value of the '{@link #getPinsChild() <em>Pins Child</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPinsChild()
	 * @generated
	 * @ordered
	 */
	protected static final String PINS_CHILD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPinsChild() <em>Pins Child</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPinsChild()
	 * @generated
	 * @ordered
	 */
	protected String pinsChild = PINS_CHILD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PinsChildImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PinsPackage.Literals.PINS_CHILD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPinsChild() {
		return pinsChild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPinsChild(String newPinsChild) {
		String oldPinsChild = pinsChild;
		pinsChild = newPinsChild;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PinsPackage.PINS_CHILD__PINS_CHILD, oldPinsChild, pinsChild));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PinsPackage.PINS_CHILD__PINS_CHILD:
				return getPinsChild();
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
			case PinsPackage.PINS_CHILD__PINS_CHILD:
				setPinsChild((String)newValue);
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
			case PinsPackage.PINS_CHILD__PINS_CHILD:
				setPinsChild(PINS_CHILD_EDEFAULT);
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
			case PinsPackage.PINS_CHILD__PINS_CHILD:
				return PINS_CHILD_EDEFAULT == null ? pinsChild != null : !PINS_CHILD_EDEFAULT.equals(pinsChild);
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
		result.append(" (PinsChild: ");
		result.append(pinsChild);
		result.append(')');
		return result.toString();
	}

} //PinsChildImpl
