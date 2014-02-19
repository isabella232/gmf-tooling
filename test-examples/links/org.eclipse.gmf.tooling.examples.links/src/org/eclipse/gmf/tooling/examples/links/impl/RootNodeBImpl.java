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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.tooling.examples.links.ChildNodeB;
import org.eclipse.gmf.tooling.examples.links.LinksPackage;
import org.eclipse.gmf.tooling.examples.links.RootNodeA;
import org.eclipse.gmf.tooling.examples.links.RootNodeB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Node B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.RootNodeBImpl#getChildrenB <em>Children B</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.RootNodeBImpl#getRoot_BA_Feature_Link <em>Root BA Feature Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootNodeBImpl extends MinimalEObjectImpl.Container implements RootNodeB {
	/**
	 * The cached value of the '{@link #getChildrenB() <em>Children B</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenB()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildNodeB> childrenB;

	/**
	 * The cached value of the '{@link #getRoot_BA_Feature_Link() <em>Root BA Feature Link</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot_BA_Feature_Link()
	 * @generated
	 * @ordered
	 */
	protected EList<RootNodeA> root_BA_Feature_Link;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootNodeBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LinksPackage.Literals.ROOT_NODE_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildNodeB> getChildrenB() {
		if (childrenB == null) {
			childrenB = new EObjectContainmentEList<ChildNodeB>(ChildNodeB.class, this, LinksPackage.ROOT_NODE_B__CHILDREN_B);
		}
		return childrenB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RootNodeA> getRoot_BA_Feature_Link() {
		if (root_BA_Feature_Link == null) {
			root_BA_Feature_Link = new EObjectResolvingEList<RootNodeA>(RootNodeA.class, this, LinksPackage.ROOT_NODE_B__ROOT_BA_FEATURE_LINK);
		}
		return root_BA_Feature_Link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LinksPackage.ROOT_NODE_B__CHILDREN_B:
				return ((InternalEList<?>)getChildrenB()).basicRemove(otherEnd, msgs);
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
			case LinksPackage.ROOT_NODE_B__CHILDREN_B:
				return getChildrenB();
			case LinksPackage.ROOT_NODE_B__ROOT_BA_FEATURE_LINK:
				return getRoot_BA_Feature_Link();
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
			case LinksPackage.ROOT_NODE_B__CHILDREN_B:
				getChildrenB().clear();
				getChildrenB().addAll((Collection<? extends ChildNodeB>)newValue);
				return;
			case LinksPackage.ROOT_NODE_B__ROOT_BA_FEATURE_LINK:
				getRoot_BA_Feature_Link().clear();
				getRoot_BA_Feature_Link().addAll((Collection<? extends RootNodeA>)newValue);
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
			case LinksPackage.ROOT_NODE_B__CHILDREN_B:
				getChildrenB().clear();
				return;
			case LinksPackage.ROOT_NODE_B__ROOT_BA_FEATURE_LINK:
				getRoot_BA_Feature_Link().clear();
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
			case LinksPackage.ROOT_NODE_B__CHILDREN_B:
				return childrenB != null && !childrenB.isEmpty();
			case LinksPackage.ROOT_NODE_B__ROOT_BA_FEATURE_LINK:
				return root_BA_Feature_Link != null && !root_BA_Feature_Link.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootNodeBImpl
