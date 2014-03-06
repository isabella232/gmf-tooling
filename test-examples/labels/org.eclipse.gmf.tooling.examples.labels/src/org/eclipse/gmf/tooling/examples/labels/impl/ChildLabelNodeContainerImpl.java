/**
 */
package org.eclipse.gmf.tooling.examples.labels.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.tooling.examples.labels.ChildLabelNode;
import org.eclipse.gmf.tooling.examples.labels.ChildLabelNodeContainer;
import org.eclipse.gmf.tooling.examples.labels.LabelsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Label Node Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.ChildLabelNodeContainerImpl#getGetChildren <em>Get Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildLabelNodeContainerImpl extends NamedElementImpl implements ChildLabelNodeContainer {
	/**
	 * The cached value of the '{@link #getGetChildren() <em>Get Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildLabelNode> getChildren;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildLabelNodeContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.CHILD_LABEL_NODE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildLabelNode> getGetChildren() {
		if (getChildren == null) {
			getChildren = new EObjectContainmentEList<ChildLabelNode>(ChildLabelNode.class, this, LabelsPackage.CHILD_LABEL_NODE_CONTAINER__GET_CHILDREN);
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
			case LabelsPackage.CHILD_LABEL_NODE_CONTAINER__GET_CHILDREN:
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
			case LabelsPackage.CHILD_LABEL_NODE_CONTAINER__GET_CHILDREN:
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
			case LabelsPackage.CHILD_LABEL_NODE_CONTAINER__GET_CHILDREN:
				getGetChildren().clear();
				getGetChildren().addAll((Collection<? extends ChildLabelNode>)newValue);
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
			case LabelsPackage.CHILD_LABEL_NODE_CONTAINER__GET_CHILDREN:
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
			case LabelsPackage.CHILD_LABEL_NODE_CONTAINER__GET_CHILDREN:
				return getChildren != null && !getChildren.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ChildLabelNodeContainerImpl
