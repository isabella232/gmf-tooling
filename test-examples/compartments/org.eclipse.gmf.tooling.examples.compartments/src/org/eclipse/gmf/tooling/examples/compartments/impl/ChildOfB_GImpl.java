/**
 */
package org.eclipse.gmf.tooling.examples.compartments.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.tooling.examples.compartments.ChildOfAffixed;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G;
import org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Of BG</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_GImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_GImpl#getChildrenOfAffixed <em>Children Of Affixed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildOfB_GImpl extends MinimalEObjectImpl.Container implements ChildOfB_G {
	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildrenOfAffixed() <em>Children Of Affixed</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenOfAffixed()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildOfAffixed> childrenOfAffixed;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildOfB_GImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompartmentsPackage.Literals.CHILD_OF_BG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(int newNumber) {
		int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompartmentsPackage.CHILD_OF_BG__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildOfAffixed> getChildrenOfAffixed() {
		if (childrenOfAffixed == null) {
			childrenOfAffixed = new EObjectContainmentEList<ChildOfAffixed>(ChildOfAffixed.class, this, CompartmentsPackage.CHILD_OF_BG__CHILDREN_OF_AFFIXED);
		}
		return childrenOfAffixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompartmentsPackage.CHILD_OF_BG__CHILDREN_OF_AFFIXED:
				return ((InternalEList<?>)getChildrenOfAffixed()).basicRemove(otherEnd, msgs);
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
			case CompartmentsPackage.CHILD_OF_BG__NUMBER:
				return getNumber();
			case CompartmentsPackage.CHILD_OF_BG__CHILDREN_OF_AFFIXED:
				return getChildrenOfAffixed();
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
			case CompartmentsPackage.CHILD_OF_BG__NUMBER:
				setNumber((Integer)newValue);
				return;
			case CompartmentsPackage.CHILD_OF_BG__CHILDREN_OF_AFFIXED:
				getChildrenOfAffixed().clear();
				getChildrenOfAffixed().addAll((Collection<? extends ChildOfAffixed>)newValue);
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
			case CompartmentsPackage.CHILD_OF_BG__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case CompartmentsPackage.CHILD_OF_BG__CHILDREN_OF_AFFIXED:
				getChildrenOfAffixed().clear();
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
			case CompartmentsPackage.CHILD_OF_BG__NUMBER:
				return number != NUMBER_EDEFAULT;
			case CompartmentsPackage.CHILD_OF_BG__CHILDREN_OF_AFFIXED:
				return childrenOfAffixed != null && !childrenOfAffixed.isEmpty();
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
		result.append(" (number: ");
		result.append(number);
		result.append(')');
		return result.toString();
	}

} //ChildOfB_GImpl
