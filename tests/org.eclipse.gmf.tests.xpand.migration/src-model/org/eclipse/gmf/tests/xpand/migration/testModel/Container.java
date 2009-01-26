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
package org.eclipse.gmf.tests.xpand.migration.testModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getSingletonChild <em>Singleton Child</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getSingletonChildConstrained <em>Singleton Child Constrained</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getOrderedChildren <em>Ordered Children</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getUniqueChildren <em>Unique Children</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getOrderedUniqueChildren <em>Ordered Unique Children</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#isIt <em>It</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends EObject {
	/**
	 * Returns the value of the '<em><b>Singleton Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleton Child</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singleton Child</em>' reference.
	 * @see #setSingletonChild(Child)
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage#getContainer_SingletonChild()
	 * @model ordered="false"
	 * @generated
	 */
	Child getSingletonChild();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getSingletonChild <em>Singleton Child</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Singleton Child</em>' reference.
	 * @see #getSingletonChild()
	 * @generated
	 */
	void setSingletonChild(Child value);

	/**
	 * Returns the value of the '<em><b>Singleton Child Constrained</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleton Child Constrained</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singleton Child Constrained</em>' reference.
	 * @see #setSingletonChildConstrained(Child)
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage#getContainer_SingletonChildConstrained()
	 * @model required="true"
	 * @generated
	 */
	Child getSingletonChildConstrained();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getSingletonChildConstrained <em>Singleton Child Constrained</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Singleton Child Constrained</em>' reference.
	 * @see #getSingletonChildConstrained()
	 * @generated
	 */
	void setSingletonChildConstrained(Child value);

	/**
	 * Returns the value of the '<em><b>Ordered Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tests.xpand.migration.testModel.Child}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered Children</em>' reference list.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage#getContainer_OrderedChildren()
	 * @model
	 * @generated
	 */
	EList<Child> getOrderedChildren();

	/**
	 * Returns the value of the '<em><b>Unique Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tests.xpand.migration.testModel.Child}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Children</em>' reference list.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage#getContainer_UniqueChildren()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Child> getUniqueChildren();

	/**
	 * Returns the value of the '<em><b>Ordered Unique Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tests.xpand.migration.testModel.Child}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered Unique Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered Unique Children</em>' reference list.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage#getContainer_OrderedUniqueChildren()
	 * @model
	 * @generated
	 */
	EList<Child> getOrderedUniqueChildren();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tests.xpand.migration.testModel.Child}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage#getContainer_Children()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Child> getChildren();

	/**
	 * Returns the value of the '<em><b>It</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>It</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>It</em>' attribute.
	 * @see #setIt(boolean)
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage#getContainer_It()
	 * @model
	 * @generated
	 */
	boolean isIt();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#isIt <em>It</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>It</em>' attribute.
	 * @see #isIt()
	 * @generated
	 */
	void setIt(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Child singletonChildOp();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Child singletonChildConstrainedOp();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<Child> orderedChildrenOp();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Child> uniqueChildrenOp();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	EList<Child> orderedUniqueChildrenOp();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	EList<Child> childrenOp();

} // Container
