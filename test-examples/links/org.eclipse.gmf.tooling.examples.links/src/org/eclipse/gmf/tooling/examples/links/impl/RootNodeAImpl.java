/**
 */
package org.eclipse.gmf.tooling.examples.links.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.tooling.examples.links.ChildNodeA;
import org.eclipse.gmf.tooling.examples.links.LinksPackage;
import org.eclipse.gmf.tooling.examples.links.RootNodeA;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Node A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.RootNodeAImpl#getChildrenNodeA <em>Children Node A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootNodeAImpl extends MinimalEObjectImpl.Container implements RootNodeA {
	/**
	 * The cached value of the '{@link #getChildrenNodeA() <em>Children Node A</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenNodeA()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildNodeA> childrenNodeA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootNodeAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LinksPackage.Literals.ROOT_NODE_A;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildNodeA> getChildrenNodeA() {
		if (childrenNodeA == null) {
			childrenNodeA = new EObjectContainmentEList<ChildNodeA>(ChildNodeA.class, this, LinksPackage.ROOT_NODE_A__CHILDREN_NODE_A);
		}
		return childrenNodeA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LinksPackage.ROOT_NODE_A__CHILDREN_NODE_A:
				return ((InternalEList<?>)getChildrenNodeA()).basicRemove(otherEnd, msgs);
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
			case LinksPackage.ROOT_NODE_A__CHILDREN_NODE_A:
				return getChildrenNodeA();
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
			case LinksPackage.ROOT_NODE_A__CHILDREN_NODE_A:
				getChildrenNodeA().clear();
				getChildrenNodeA().addAll((Collection<? extends ChildNodeA>)newValue);
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
			case LinksPackage.ROOT_NODE_A__CHILDREN_NODE_A:
				getChildrenNodeA().clear();
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
			case LinksPackage.ROOT_NODE_A__CHILDREN_NODE_A:
				return childrenNodeA != null && !childrenNodeA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootNodeAImpl
