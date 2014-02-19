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

import org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link;
import org.eclipse.gmf.tooling.examples.links.LinksPackage;
import org.eclipse.gmf.tooling.examples.links.Root;
import org.eclipse.gmf.tooling.examples.links.RootNodeA;
import org.eclipse.gmf.tooling.examples.links.RootNodeB;
import org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.RootImpl#getChildABElementLinks <em>Child AB Element Links</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.RootImpl#getRootNodeAs <em>Root Node As</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.RootImpl#getRootNodeBs <em>Root Node Bs</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.impl.RootImpl#getRootBALinks <em>Root BA Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootImpl extends MinimalEObjectImpl.Container implements Root {
	/**
	 * The cached value of the '{@link #getChildABElementLinks() <em>Child AB Element Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildABElementLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Child_AB_Element_Link> childABElementLinks;

	/**
	 * The cached value of the '{@link #getRootNodeAs() <em>Root Node As</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootNodeAs()
	 * @generated
	 * @ordered
	 */
	protected EList<RootNodeA> rootNodeAs;

	/**
	 * The cached value of the '{@link #getRootNodeBs() <em>Root Node Bs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootNodeBs()
	 * @generated
	 * @ordered
	 */
	protected EList<RootNodeB> rootNodeBs;

	/**
	 * The cached value of the '{@link #getRootBALinks() <em>Root BA Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootBALinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Root_BA_Element_Link> rootBALinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LinksPackage.Literals.ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Child_AB_Element_Link> getChildABElementLinks() {
		if (childABElementLinks == null) {
			childABElementLinks = new EObjectContainmentEList<Child_AB_Element_Link>(Child_AB_Element_Link.class, this, LinksPackage.ROOT__CHILD_AB_ELEMENT_LINKS);
		}
		return childABElementLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RootNodeA> getRootNodeAs() {
		if (rootNodeAs == null) {
			rootNodeAs = new EObjectContainmentEList<RootNodeA>(RootNodeA.class, this, LinksPackage.ROOT__ROOT_NODE_AS);
		}
		return rootNodeAs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RootNodeB> getRootNodeBs() {
		if (rootNodeBs == null) {
			rootNodeBs = new EObjectContainmentEList<RootNodeB>(RootNodeB.class, this, LinksPackage.ROOT__ROOT_NODE_BS);
		}
		return rootNodeBs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Root_BA_Element_Link> getRootBALinks() {
		if (rootBALinks == null) {
			rootBALinks = new EObjectContainmentEList<Root_BA_Element_Link>(Root_BA_Element_Link.class, this, LinksPackage.ROOT__ROOT_BA_LINKS);
		}
		return rootBALinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LinksPackage.ROOT__CHILD_AB_ELEMENT_LINKS:
				return ((InternalEList<?>)getChildABElementLinks()).basicRemove(otherEnd, msgs);
			case LinksPackage.ROOT__ROOT_NODE_AS:
				return ((InternalEList<?>)getRootNodeAs()).basicRemove(otherEnd, msgs);
			case LinksPackage.ROOT__ROOT_NODE_BS:
				return ((InternalEList<?>)getRootNodeBs()).basicRemove(otherEnd, msgs);
			case LinksPackage.ROOT__ROOT_BA_LINKS:
				return ((InternalEList<?>)getRootBALinks()).basicRemove(otherEnd, msgs);
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
			case LinksPackage.ROOT__CHILD_AB_ELEMENT_LINKS:
				return getChildABElementLinks();
			case LinksPackage.ROOT__ROOT_NODE_AS:
				return getRootNodeAs();
			case LinksPackage.ROOT__ROOT_NODE_BS:
				return getRootNodeBs();
			case LinksPackage.ROOT__ROOT_BA_LINKS:
				return getRootBALinks();
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
			case LinksPackage.ROOT__CHILD_AB_ELEMENT_LINKS:
				getChildABElementLinks().clear();
				getChildABElementLinks().addAll((Collection<? extends Child_AB_Element_Link>)newValue);
				return;
			case LinksPackage.ROOT__ROOT_NODE_AS:
				getRootNodeAs().clear();
				getRootNodeAs().addAll((Collection<? extends RootNodeA>)newValue);
				return;
			case LinksPackage.ROOT__ROOT_NODE_BS:
				getRootNodeBs().clear();
				getRootNodeBs().addAll((Collection<? extends RootNodeB>)newValue);
				return;
			case LinksPackage.ROOT__ROOT_BA_LINKS:
				getRootBALinks().clear();
				getRootBALinks().addAll((Collection<? extends Root_BA_Element_Link>)newValue);
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
			case LinksPackage.ROOT__CHILD_AB_ELEMENT_LINKS:
				getChildABElementLinks().clear();
				return;
			case LinksPackage.ROOT__ROOT_NODE_AS:
				getRootNodeAs().clear();
				return;
			case LinksPackage.ROOT__ROOT_NODE_BS:
				getRootNodeBs().clear();
				return;
			case LinksPackage.ROOT__ROOT_BA_LINKS:
				getRootBALinks().clear();
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
			case LinksPackage.ROOT__CHILD_AB_ELEMENT_LINKS:
				return childABElementLinks != null && !childABElementLinks.isEmpty();
			case LinksPackage.ROOT__ROOT_NODE_AS:
				return rootNodeAs != null && !rootNodeAs.isEmpty();
			case LinksPackage.ROOT__ROOT_NODE_BS:
				return rootNodeBs != null && !rootNodeBs.isEmpty();
			case LinksPackage.ROOT__ROOT_BA_LINKS:
				return rootBALinks != null && !rootBALinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootImpl
