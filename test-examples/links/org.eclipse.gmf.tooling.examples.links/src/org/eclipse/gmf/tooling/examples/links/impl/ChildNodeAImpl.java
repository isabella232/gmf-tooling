/**
 */
package org.eclipse.gmf.tooling.examples.links.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.gmf.tooling.examples.links.ChildNodeA;
import org.eclipse.gmf.tooling.examples.links.ChildNodeB;
import org.eclipse.gmf.tooling.examples.links.LinksPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Node A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.ChildNodeAImpl#getChild_AB_Feature_Link <em>Child AB Feature Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildNodeAImpl extends MinimalEObjectImpl.Container implements ChildNodeA {
	/**
	 * The cached value of the '{@link #getChild_AB_Feature_Link() <em>Child AB Feature Link</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChild_AB_Feature_Link()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildNodeB> child_AB_Feature_Link;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildNodeAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LinksPackage.Literals.CHILD_NODE_A;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildNodeB> getChild_AB_Feature_Link() {
		if (child_AB_Feature_Link == null) {
			child_AB_Feature_Link = new EObjectResolvingEList<ChildNodeB>(ChildNodeB.class, this, LinksPackage.CHILD_NODE_A__CHILD_AB_FEATURE_LINK);
		}
		return child_AB_Feature_Link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LinksPackage.CHILD_NODE_A__CHILD_AB_FEATURE_LINK:
				return getChild_AB_Feature_Link();
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
			case LinksPackage.CHILD_NODE_A__CHILD_AB_FEATURE_LINK:
				getChild_AB_Feature_Link().clear();
				getChild_AB_Feature_Link().addAll((Collection<? extends ChildNodeB>)newValue);
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
			case LinksPackage.CHILD_NODE_A__CHILD_AB_FEATURE_LINK:
				getChild_AB_Feature_Link().clear();
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
			case LinksPackage.CHILD_NODE_A__CHILD_AB_FEATURE_LINK:
				return child_AB_Feature_Link != null && !child_AB_Feature_Link.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ChildNodeAImpl
