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

import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G;
import org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage;
import org.eclipse.gmf.tooling.examples.compartments.TopNodeB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Node B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeBImpl#getChildrenE <em>Children E</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeBImpl#getChildrenG <em>Children G</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeBImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeBImpl#getChildrenF <em>Children F</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopNodeBImpl extends TopNodeImpl implements TopNodeB {
	/**
	 * The cached value of the '{@link #getChildrenE() <em>Children E</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenE()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildOfB_E> childrenE;

	/**
	 * The cached value of the '{@link #getChildrenG() <em>Children G</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenG()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildOfB_G> childrenG;

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
	 * The cached value of the '{@link #getChildrenF() <em>Children F</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenF()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildOfB_F> childrenF;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopNodeBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompartmentsPackage.Literals.TOP_NODE_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildOfB_E> getChildrenE() {
		if (childrenE == null) {
			childrenE = new EObjectContainmentEList<ChildOfB_E>(ChildOfB_E.class, this, CompartmentsPackage.TOP_NODE_B__CHILDREN_E);
		}
		return childrenE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildOfB_G> getChildrenG() {
		if (childrenG == null) {
			childrenG = new EObjectContainmentEList<ChildOfB_G>(ChildOfB_G.class, this, CompartmentsPackage.TOP_NODE_B__CHILDREN_G);
		}
		return childrenG;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CompartmentsPackage.TOP_NODE_B__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildOfB_F> getChildrenF() {
		if (childrenF == null) {
			childrenF = new EObjectContainmentEList<ChildOfB_F>(ChildOfB_F.class, this, CompartmentsPackage.TOP_NODE_B__CHILDREN_F);
		}
		return childrenF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_E:
				return ((InternalEList<?>)getChildrenE()).basicRemove(otherEnd, msgs);
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_G:
				return ((InternalEList<?>)getChildrenG()).basicRemove(otherEnd, msgs);
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_F:
				return ((InternalEList<?>)getChildrenF()).basicRemove(otherEnd, msgs);
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
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_E:
				return getChildrenE();
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_G:
				return getChildrenG();
			case CompartmentsPackage.TOP_NODE_B__NAME:
				return getName();
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_F:
				return getChildrenF();
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
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_E:
				getChildrenE().clear();
				getChildrenE().addAll((Collection<? extends ChildOfB_E>)newValue);
				return;
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_G:
				getChildrenG().clear();
				getChildrenG().addAll((Collection<? extends ChildOfB_G>)newValue);
				return;
			case CompartmentsPackage.TOP_NODE_B__NAME:
				setName((String)newValue);
				return;
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_F:
				getChildrenF().clear();
				getChildrenF().addAll((Collection<? extends ChildOfB_F>)newValue);
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
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_E:
				getChildrenE().clear();
				return;
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_G:
				getChildrenG().clear();
				return;
			case CompartmentsPackage.TOP_NODE_B__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_F:
				getChildrenF().clear();
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
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_E:
				return childrenE != null && !childrenE.isEmpty();
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_G:
				return childrenG != null && !childrenG.isEmpty();
			case CompartmentsPackage.TOP_NODE_B__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CompartmentsPackage.TOP_NODE_B__CHILDREN_F:
				return childrenF != null && !childrenF.isEmpty();
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

} //TopNodeBImpl
