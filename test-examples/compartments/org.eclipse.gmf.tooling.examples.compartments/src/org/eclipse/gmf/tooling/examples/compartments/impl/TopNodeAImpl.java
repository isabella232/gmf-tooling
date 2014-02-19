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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.tooling.examples.compartments.ChildOfA_C;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfA_D;
import org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage;
import org.eclipse.gmf.tooling.examples.compartments.TopNodeA;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Node A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeAImpl#getChildrenC <em>Children C</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeAImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeAImpl#getChildrenD <em>Children D</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopNodeAImpl extends TopNodeImpl implements TopNodeA {
	/**
	 * The cached value of the '{@link #getChildrenC() <em>Children C</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenC()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildOfA_C> childrenC;

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
	 * The cached value of the '{@link #getChildrenD() <em>Children D</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenD()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildOfA_D> childrenD;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopNodeAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompartmentsPackage.Literals.TOP_NODE_A;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildOfA_C> getChildrenC() {
		if (childrenC == null) {
			childrenC = new EObjectContainmentEList<ChildOfA_C>(ChildOfA_C.class, this, CompartmentsPackage.TOP_NODE_A__CHILDREN_C);
		}
		return childrenC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CompartmentsPackage.TOP_NODE_A__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildOfA_D> getChildrenD() {
		if (childrenD == null) {
			childrenD = new EObjectContainmentEList<ChildOfA_D>(ChildOfA_D.class, this, CompartmentsPackage.TOP_NODE_A__CHILDREN_D);
		}
		return childrenD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompartmentsPackage.TOP_NODE_A__CHILDREN_C:
				return ((InternalEList<?>)getChildrenC()).basicRemove(otherEnd, msgs);
			case CompartmentsPackage.TOP_NODE_A__CHILDREN_D:
				return ((InternalEList<?>)getChildrenD()).basicRemove(otherEnd, msgs);
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
			case CompartmentsPackage.TOP_NODE_A__CHILDREN_C:
				return getChildrenC();
			case CompartmentsPackage.TOP_NODE_A__NAME:
				return getName();
			case CompartmentsPackage.TOP_NODE_A__CHILDREN_D:
				return getChildrenD();
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
			case CompartmentsPackage.TOP_NODE_A__CHILDREN_C:
				getChildrenC().clear();
				getChildrenC().addAll((Collection<? extends ChildOfA_C>)newValue);
				return;
			case CompartmentsPackage.TOP_NODE_A__NAME:
				setName((String)newValue);
				return;
			case CompartmentsPackage.TOP_NODE_A__CHILDREN_D:
				getChildrenD().clear();
				getChildrenD().addAll((Collection<? extends ChildOfA_D>)newValue);
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
			case CompartmentsPackage.TOP_NODE_A__CHILDREN_C:
				getChildrenC().clear();
				return;
			case CompartmentsPackage.TOP_NODE_A__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CompartmentsPackage.TOP_NODE_A__CHILDREN_D:
				getChildrenD().clear();
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
			case CompartmentsPackage.TOP_NODE_A__CHILDREN_C:
				return childrenC != null && !childrenC.isEmpty();
			case CompartmentsPackage.TOP_NODE_A__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CompartmentsPackage.TOP_NODE_A__CHILDREN_D:
				return childrenD != null && !childrenD.isEmpty();
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

} //TopNodeAImpl
