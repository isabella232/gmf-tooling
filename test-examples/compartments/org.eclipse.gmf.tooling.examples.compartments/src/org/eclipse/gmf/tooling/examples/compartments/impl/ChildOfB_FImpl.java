/**
 */
package org.eclipse.gmf.tooling.examples.compartments.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.gmf.tooling.examples.compartments.ChildOfA_D;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F;
import org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Of BF</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_FImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_FImpl#getDNodeRelation <em>DNode Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildOfB_FImpl extends MinimalEObjectImpl.Container implements ChildOfB_F {
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
	 * The cached value of the '{@link #getDNodeRelation() <em>DNode Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDNodeRelation()
	 * @generated
	 * @ordered
	 */
	protected ChildOfA_D dNodeRelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildOfB_FImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompartmentsPackage.Literals.CHILD_OF_BF;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CompartmentsPackage.CHILD_OF_BF__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildOfA_D getDNodeRelation() {
		if (dNodeRelation != null && dNodeRelation.eIsProxy()) {
			InternalEObject oldDNodeRelation = (InternalEObject)dNodeRelation;
			dNodeRelation = (ChildOfA_D)eResolveProxy(oldDNodeRelation);
			if (dNodeRelation != oldDNodeRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompartmentsPackage.CHILD_OF_BF__DNODE_RELATION, oldDNodeRelation, dNodeRelation));
			}
		}
		return dNodeRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildOfA_D basicGetDNodeRelation() {
		return dNodeRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDNodeRelation(ChildOfA_D newDNodeRelation) {
		ChildOfA_D oldDNodeRelation = dNodeRelation;
		dNodeRelation = newDNodeRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompartmentsPackage.CHILD_OF_BF__DNODE_RELATION, oldDNodeRelation, dNodeRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompartmentsPackage.CHILD_OF_BF__NAME:
				return getName();
			case CompartmentsPackage.CHILD_OF_BF__DNODE_RELATION:
				if (resolve) return getDNodeRelation();
				return basicGetDNodeRelation();
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
			case CompartmentsPackage.CHILD_OF_BF__NAME:
				setName((String)newValue);
				return;
			case CompartmentsPackage.CHILD_OF_BF__DNODE_RELATION:
				setDNodeRelation((ChildOfA_D)newValue);
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
			case CompartmentsPackage.CHILD_OF_BF__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CompartmentsPackage.CHILD_OF_BF__DNODE_RELATION:
				setDNodeRelation((ChildOfA_D)null);
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
			case CompartmentsPackage.CHILD_OF_BF__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CompartmentsPackage.CHILD_OF_BF__DNODE_RELATION:
				return dNodeRelation != null;
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

} //ChildOfB_FImpl
