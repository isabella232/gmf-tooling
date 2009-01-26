/**
 * Copyright (c) 2008, 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *
 * $Id$
 */
package org.eclipse.gmf.tests.xpand.migration.testModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.gmf.tests.xpand.migration.testModel.Child;
import org.eclipse.gmf.tests.xpand.migration.testModel.Container;
import org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.ContainerImpl#getSingletonChild <em>Singleton Child</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.ContainerImpl#getSingletonChildConstrained <em>Singleton Child Constrained</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.ContainerImpl#getOrderedChildren <em>Ordered Children</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.ContainerImpl#getUniqueChildren <em>Unique Children</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.ContainerImpl#getOrderedUniqueChildren <em>Ordered Unique Children</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.ContainerImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.ContainerImpl#isIt <em>It</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainerImpl extends EObjectImpl implements Container {
	/**
	 * The cached value of the '{@link #getSingletonChild() <em>Singleton Child</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingletonChild()
	 * @generated
	 * @ordered
	 */
	protected Child singletonChild;

	/**
	 * The cached value of the '{@link #getSingletonChildConstrained() <em>Singleton Child Constrained</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingletonChildConstrained()
	 * @generated
	 * @ordered
	 */
	protected Child singletonChildConstrained;

	/**
	 * The cached value of the '{@link #getOrderedChildren() <em>Ordered Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderedChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Child> orderedChildren;

	/**
	 * The cached value of the '{@link #getUniqueChildren() <em>Unique Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Child> uniqueChildren;

	/**
	 * The cached value of the '{@link #getOrderedUniqueChildren() <em>Ordered Unique Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderedUniqueChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Child> orderedUniqueChildren;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Child> children;

	/**
	 * The default value of the '{@link #isIt() <em>It</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIt()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIt() <em>It</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIt()
	 * @generated
	 * @ordered
	 */
	protected boolean it = IT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MigrationTestsPackage.Literals.CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Child getSingletonChild() {
		if (singletonChild != null && singletonChild.eIsProxy()) {
			InternalEObject oldSingletonChild = (InternalEObject)singletonChild;
			singletonChild = (Child)eResolveProxy(oldSingletonChild);
			if (singletonChild != oldSingletonChild) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MigrationTestsPackage.CONTAINER__SINGLETON_CHILD, oldSingletonChild, singletonChild));
			}
		}
		return singletonChild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Child basicGetSingletonChild() {
		return singletonChild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingletonChild(Child newSingletonChild) {
		Child oldSingletonChild = singletonChild;
		singletonChild = newSingletonChild;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationTestsPackage.CONTAINER__SINGLETON_CHILD, oldSingletonChild, singletonChild));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Child getSingletonChildConstrained() {
		if (singletonChildConstrained != null && singletonChildConstrained.eIsProxy()) {
			InternalEObject oldSingletonChildConstrained = (InternalEObject)singletonChildConstrained;
			singletonChildConstrained = (Child)eResolveProxy(oldSingletonChildConstrained);
			if (singletonChildConstrained != oldSingletonChildConstrained) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MigrationTestsPackage.CONTAINER__SINGLETON_CHILD_CONSTRAINED, oldSingletonChildConstrained, singletonChildConstrained));
			}
		}
		return singletonChildConstrained;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Child basicGetSingletonChildConstrained() {
		return singletonChildConstrained;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingletonChildConstrained(Child newSingletonChildConstrained) {
		Child oldSingletonChildConstrained = singletonChildConstrained;
		singletonChildConstrained = newSingletonChildConstrained;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationTestsPackage.CONTAINER__SINGLETON_CHILD_CONSTRAINED, oldSingletonChildConstrained, singletonChildConstrained));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Child> getOrderedChildren() {
		if (orderedChildren == null) {
			orderedChildren = new EObjectResolvingEList<Child>(Child.class, this, MigrationTestsPackage.CONTAINER__ORDERED_CHILDREN);
		}
		return orderedChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Child> getUniqueChildren() {
		if (uniqueChildren == null) {
			uniqueChildren = new EObjectResolvingEList<Child>(Child.class, this, MigrationTestsPackage.CONTAINER__UNIQUE_CHILDREN);
		}
		return uniqueChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Child> getOrderedUniqueChildren() {
		if (orderedUniqueChildren == null) {
			orderedUniqueChildren = new EObjectResolvingEList<Child>(Child.class, this, MigrationTestsPackage.CONTAINER__ORDERED_UNIQUE_CHILDREN);
		}
		return orderedUniqueChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Child> getChildren() {
		if (children == null) {
			children = new EObjectResolvingEList<Child>(Child.class, this, MigrationTestsPackage.CONTAINER__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIt() {
		return it;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIt(boolean newIt) {
		boolean oldIt = it;
		it = newIt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationTestsPackage.CONTAINER__IT, oldIt, it));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Child singletonChildOp() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Child singletonChildConstrainedOp() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Child> orderedChildrenOp() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Child> uniqueChildrenOp() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Child> orderedUniqueChildrenOp() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Child> childrenOp() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MigrationTestsPackage.CONTAINER__SINGLETON_CHILD:
				if (resolve) return getSingletonChild();
				return basicGetSingletonChild();
			case MigrationTestsPackage.CONTAINER__SINGLETON_CHILD_CONSTRAINED:
				if (resolve) return getSingletonChildConstrained();
				return basicGetSingletonChildConstrained();
			case MigrationTestsPackage.CONTAINER__ORDERED_CHILDREN:
				return getOrderedChildren();
			case MigrationTestsPackage.CONTAINER__UNIQUE_CHILDREN:
				return getUniqueChildren();
			case MigrationTestsPackage.CONTAINER__ORDERED_UNIQUE_CHILDREN:
				return getOrderedUniqueChildren();
			case MigrationTestsPackage.CONTAINER__CHILDREN:
				return getChildren();
			case MigrationTestsPackage.CONTAINER__IT:
				return isIt();
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
			case MigrationTestsPackage.CONTAINER__SINGLETON_CHILD:
				setSingletonChild((Child)newValue);
				return;
			case MigrationTestsPackage.CONTAINER__SINGLETON_CHILD_CONSTRAINED:
				setSingletonChildConstrained((Child)newValue);
				return;
			case MigrationTestsPackage.CONTAINER__ORDERED_CHILDREN:
				getOrderedChildren().clear();
				getOrderedChildren().addAll((Collection<? extends Child>)newValue);
				return;
			case MigrationTestsPackage.CONTAINER__UNIQUE_CHILDREN:
				getUniqueChildren().clear();
				getUniqueChildren().addAll((Collection<? extends Child>)newValue);
				return;
			case MigrationTestsPackage.CONTAINER__ORDERED_UNIQUE_CHILDREN:
				getOrderedUniqueChildren().clear();
				getOrderedUniqueChildren().addAll((Collection<? extends Child>)newValue);
				return;
			case MigrationTestsPackage.CONTAINER__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends Child>)newValue);
				return;
			case MigrationTestsPackage.CONTAINER__IT:
				setIt((Boolean)newValue);
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
			case MigrationTestsPackage.CONTAINER__SINGLETON_CHILD:
				setSingletonChild((Child)null);
				return;
			case MigrationTestsPackage.CONTAINER__SINGLETON_CHILD_CONSTRAINED:
				setSingletonChildConstrained((Child)null);
				return;
			case MigrationTestsPackage.CONTAINER__ORDERED_CHILDREN:
				getOrderedChildren().clear();
				return;
			case MigrationTestsPackage.CONTAINER__UNIQUE_CHILDREN:
				getUniqueChildren().clear();
				return;
			case MigrationTestsPackage.CONTAINER__ORDERED_UNIQUE_CHILDREN:
				getOrderedUniqueChildren().clear();
				return;
			case MigrationTestsPackage.CONTAINER__CHILDREN:
				getChildren().clear();
				return;
			case MigrationTestsPackage.CONTAINER__IT:
				setIt(IT_EDEFAULT);
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
			case MigrationTestsPackage.CONTAINER__SINGLETON_CHILD:
				return singletonChild != null;
			case MigrationTestsPackage.CONTAINER__SINGLETON_CHILD_CONSTRAINED:
				return singletonChildConstrained != null;
			case MigrationTestsPackage.CONTAINER__ORDERED_CHILDREN:
				return orderedChildren != null && !orderedChildren.isEmpty();
			case MigrationTestsPackage.CONTAINER__UNIQUE_CHILDREN:
				return uniqueChildren != null && !uniqueChildren.isEmpty();
			case MigrationTestsPackage.CONTAINER__ORDERED_UNIQUE_CHILDREN:
				return orderedUniqueChildren != null && !orderedUniqueChildren.isEmpty();
			case MigrationTestsPackage.CONTAINER__CHILDREN:
				return children != null && !children.isEmpty();
			case MigrationTestsPackage.CONTAINER__IT:
				return it != IT_EDEFAULT;
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
		result.append(" (it: ");
		result.append(it);
		result.append(')');
		return result.toString();
	}

} //ContainerImpl
