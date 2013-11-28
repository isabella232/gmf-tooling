/**
 */
package org.eclipse.gmf.tooling.examples.compartments.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.gmf.tooling.examples.compartments.ChildOfA_C;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E;
import org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Of BE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_EImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_EImpl#getCNodeRelation <em>CNode Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildOfB_EImpl extends MinimalEObjectImpl.Container implements ChildOfB_E {
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
	 * The cached value of the '{@link #getCNodeRelation() <em>CNode Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCNodeRelation()
	 * @generated
	 * @ordered
	 */
	protected ChildOfA_C cNodeRelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildOfB_EImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompartmentsPackage.Literals.CHILD_OF_BE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CompartmentsPackage.CHILD_OF_BE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildOfA_C getCNodeRelation() {
		if (cNodeRelation != null && cNodeRelation.eIsProxy()) {
			InternalEObject oldCNodeRelation = (InternalEObject)cNodeRelation;
			cNodeRelation = (ChildOfA_C)eResolveProxy(oldCNodeRelation);
			if (cNodeRelation != oldCNodeRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompartmentsPackage.CHILD_OF_BE__CNODE_RELATION, oldCNodeRelation, cNodeRelation));
			}
		}
		return cNodeRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildOfA_C basicGetCNodeRelation() {
		return cNodeRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCNodeRelation(ChildOfA_C newCNodeRelation) {
		ChildOfA_C oldCNodeRelation = cNodeRelation;
		cNodeRelation = newCNodeRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompartmentsPackage.CHILD_OF_BE__CNODE_RELATION, oldCNodeRelation, cNodeRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompartmentsPackage.CHILD_OF_BE__NAME:
				return getName();
			case CompartmentsPackage.CHILD_OF_BE__CNODE_RELATION:
				if (resolve) return getCNodeRelation();
				return basicGetCNodeRelation();
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
			case CompartmentsPackage.CHILD_OF_BE__NAME:
				setName((String)newValue);
				return;
			case CompartmentsPackage.CHILD_OF_BE__CNODE_RELATION:
				setCNodeRelation((ChildOfA_C)newValue);
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
			case CompartmentsPackage.CHILD_OF_BE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CompartmentsPackage.CHILD_OF_BE__CNODE_RELATION:
				setCNodeRelation((ChildOfA_C)null);
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
			case CompartmentsPackage.CHILD_OF_BE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CompartmentsPackage.CHILD_OF_BE__CNODE_RELATION:
				return cNodeRelation != null;
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
		result.append(')');
		return result.toString();
	}

} //ChildOfB_EImpl
