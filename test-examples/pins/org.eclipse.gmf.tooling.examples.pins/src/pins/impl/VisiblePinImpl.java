/**
 */
package pins.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pins.PinsChild;
import pins.PinsPackage;
import pins.VisiblePin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visible Pin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pins.impl.VisiblePinImpl#getWarningLabel <em>Warning Label</em>}</li>
 *   <li>{@link pins.impl.VisiblePinImpl#getGetChildren <em>Get Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VisiblePinImpl extends PinImpl implements VisiblePin {
	/**
	 * The default value of the '{@link #getWarningLabel() <em>Warning Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarningLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String WARNING_LABEL_EDEFAULT = "Need more children";

	/**
	 * The cached value of the '{@link #getWarningLabel() <em>Warning Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarningLabel()
	 * @generated
	 * @ordered
	 */
	protected String warningLabel = WARNING_LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGetChildren() <em>Get Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<PinsChild> getChildren;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisiblePinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PinsPackage.Literals.VISIBLE_PIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWarningLabel() {
		return warningLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarningLabel(String newWarningLabel) {
		String oldWarningLabel = warningLabel;
		warningLabel = newWarningLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PinsPackage.VISIBLE_PIN__WARNING_LABEL, oldWarningLabel, warningLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PinsChild> getGetChildren() {
		if (getChildren == null) {
			getChildren = new EObjectContainmentEList<PinsChild>(PinsChild.class, this, PinsPackage.VISIBLE_PIN__GET_CHILDREN);
		}
		return getChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PinsPackage.VISIBLE_PIN__GET_CHILDREN:
				return ((InternalEList<?>)getGetChildren()).basicRemove(otherEnd, msgs);
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
			case PinsPackage.VISIBLE_PIN__WARNING_LABEL:
				return getWarningLabel();
			case PinsPackage.VISIBLE_PIN__GET_CHILDREN:
				return getGetChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PinsPackage.VISIBLE_PIN__WARNING_LABEL:
				setWarningLabel((String)newValue);
				return;
			case PinsPackage.VISIBLE_PIN__GET_CHILDREN:
				getGetChildren().clear();
				getGetChildren().addAll((Collection<? extends PinsChild>)newValue);
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
			case PinsPackage.VISIBLE_PIN__WARNING_LABEL:
				setWarningLabel(WARNING_LABEL_EDEFAULT);
				return;
			case PinsPackage.VISIBLE_PIN__GET_CHILDREN:
				getGetChildren().clear();
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
			case PinsPackage.VISIBLE_PIN__WARNING_LABEL:
				return WARNING_LABEL_EDEFAULT == null ? warningLabel != null : !WARNING_LABEL_EDEFAULT.equals(warningLabel);
			case PinsPackage.VISIBLE_PIN__GET_CHILDREN:
				return getChildren != null && !getChildren.isEmpty();
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
		result.append(" (WarningLabel: ");
		result.append(warningLabel);
		result.append(')');
		return result.toString();
	}

} //VisiblePinImpl
