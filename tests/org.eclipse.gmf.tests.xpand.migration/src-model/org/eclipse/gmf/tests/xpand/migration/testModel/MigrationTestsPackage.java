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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsFactory
 * @model kind="package"
 * @generated
 */
public interface MigrationTestsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/gmf/2008/org.eclipse.gmf.tests.xpand.migration/testModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MigrationTestsPackage eINSTANCE = org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.ContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.ContainerImpl
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsPackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Singleton Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__SINGLETON_CHILD = 0;

	/**
	 * The feature id for the '<em><b>Singleton Child Constrained</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__SINGLETON_CHILD_CONSTRAINED = 1;

	/**
	 * The feature id for the '<em><b>Ordered Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__ORDERED_CHILDREN = 2;

	/**
	 * The feature id for the '<em><b>Unique Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__UNIQUE_CHILDREN = 3;

	/**
	 * The feature id for the '<em><b>Ordered Unique Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__ORDERED_UNIQUE_CHILDREN = 4;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__CHILDREN = 5;

	/**
	 * The feature id for the '<em><b>It</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__IT = 6;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.ChildImpl <em>Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.ChildImpl
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsPackageImpl#getChild()
	 * @generated
	 */
	int CHILD = 1;

	/**
	 * The number of structural features of the '<em>Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.SubContainerImpl <em>Sub Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.SubContainerImpl
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsPackageImpl#getSubContainer()
	 * @generated
	 */
	int SUB_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Singleton Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTAINER__SINGLETON_CHILD = CONTAINER__SINGLETON_CHILD;

	/**
	 * The feature id for the '<em><b>Singleton Child Constrained</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTAINER__SINGLETON_CHILD_CONSTRAINED = CONTAINER__SINGLETON_CHILD_CONSTRAINED;

	/**
	 * The feature id for the '<em><b>Ordered Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTAINER__ORDERED_CHILDREN = CONTAINER__ORDERED_CHILDREN;

	/**
	 * The feature id for the '<em><b>Unique Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTAINER__UNIQUE_CHILDREN = CONTAINER__UNIQUE_CHILDREN;

	/**
	 * The feature id for the '<em><b>Ordered Unique Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTAINER__ORDERED_UNIQUE_CHILDREN = CONTAINER__ORDERED_UNIQUE_CHILDREN;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTAINER__CHILDREN = CONTAINER__CHILDREN;

	/**
	 * The feature id for the '<em><b>It</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTAINER__IT = CONTAINER__IT;

	/**
	 * The number of structural features of the '<em>Sub Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONTAINER_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.DefaultAttributeContainerImpl <em>Default Attribute Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.DefaultAttributeContainerImpl
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsPackageImpl#getDefaultAttributeContainer()
	 * @generated
	 */
	int DEFAULT_ATTRIBUTE_CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ATTRIBUTE_CONTAINER__DEFAULT = 0;

	/**
	 * The number of structural features of the '<em>Default Attribute Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ATTRIBUTE_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Enumeration <em>Enumeration</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Enumeration
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsPackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getSingletonChild <em>Singleton Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Singleton Child</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Container#getSingletonChild()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_SingletonChild();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getSingletonChildConstrained <em>Singleton Child Constrained</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Singleton Child Constrained</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Container#getSingletonChildConstrained()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_SingletonChildConstrained();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getOrderedChildren <em>Ordered Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ordered Children</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Container#getOrderedChildren()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_OrderedChildren();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getUniqueChildren <em>Unique Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unique Children</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Container#getUniqueChildren()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_UniqueChildren();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getOrderedUniqueChildren <em>Ordered Unique Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ordered Unique Children</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Container#getOrderedUniqueChildren()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_OrderedUniqueChildren();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Container#getChildren()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Container#isIt <em>It</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>It</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Container#isIt()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_It();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Child <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Child
	 * @generated
	 */
	EClass getChild();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tests.xpand.migration.testModel.SubContainer <em>Sub Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Container</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.SubContainer
	 * @generated
	 */
	EClass getSubContainer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tests.xpand.migration.testModel.DefaultAttributeContainer <em>Default Attribute Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Attribute Container</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.DefaultAttributeContainer
	 * @generated
	 */
	EClass getDefaultAttributeContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tests.xpand.migration.testModel.DefaultAttributeContainer#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.DefaultAttributeContainer#isDefault()
	 * @see #getDefaultAttributeContainer()
	 * @generated
	 */
	EAttribute getDefaultAttributeContainer_Default();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enumeration</em>'.
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Enumeration
	 * @generated
	 */
	EEnum getEnumeration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MigrationTestsFactory getMigrationTestsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.ContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.ContainerImpl
		 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsPackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Singleton Child</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__SINGLETON_CHILD = eINSTANCE.getContainer_SingletonChild();

		/**
		 * The meta object literal for the '<em><b>Singleton Child Constrained</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__SINGLETON_CHILD_CONSTRAINED = eINSTANCE.getContainer_SingletonChildConstrained();

		/**
		 * The meta object literal for the '<em><b>Ordered Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__ORDERED_CHILDREN = eINSTANCE.getContainer_OrderedChildren();

		/**
		 * The meta object literal for the '<em><b>Unique Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__UNIQUE_CHILDREN = eINSTANCE.getContainer_UniqueChildren();

		/**
		 * The meta object literal for the '<em><b>Ordered Unique Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__ORDERED_UNIQUE_CHILDREN = eINSTANCE.getContainer_OrderedUniqueChildren();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__CHILDREN = eINSTANCE.getContainer_Children();

		/**
		 * The meta object literal for the '<em><b>It</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__IT = eINSTANCE.getContainer_It();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.ChildImpl <em>Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.ChildImpl
		 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsPackageImpl#getChild()
		 * @generated
		 */
		EClass CHILD = eINSTANCE.getChild();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.SubContainerImpl <em>Sub Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.SubContainerImpl
		 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsPackageImpl#getSubContainer()
		 * @generated
		 */
		EClass SUB_CONTAINER = eINSTANCE.getSubContainer();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.impl.DefaultAttributeContainerImpl <em>Default Attribute Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.DefaultAttributeContainerImpl
		 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsPackageImpl#getDefaultAttributeContainer()
		 * @generated
		 */
		EClass DEFAULT_ATTRIBUTE_CONTAINER = eINSTANCE.getDefaultAttributeContainer();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_ATTRIBUTE_CONTAINER__DEFAULT = eINSTANCE.getDefaultAttributeContainer_Default();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tests.xpand.migration.testModel.Enumeration <em>Enumeration</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tests.xpand.migration.testModel.Enumeration
		 * @see org.eclipse.gmf.tests.xpand.migration.testModel.impl.MigrationTestsPackageImpl#getEnumeration()
		 * @generated
		 */
		EEnum ENUMERATION = eINSTANCE.getEnumeration();

	}

} //MigrationTestsPackage
