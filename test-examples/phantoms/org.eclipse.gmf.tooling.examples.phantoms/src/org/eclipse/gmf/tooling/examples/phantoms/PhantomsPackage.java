/**
 */
package org.eclipse.gmf.tooling.examples.phantoms;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.phantoms.PhantomsFactory
 * @model kind="package"
 * @generated
 */
public interface PhantomsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "phantoms";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.gmf.tooling.examples.phantoms";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "phantoms";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PhantomsPackage eINSTANCE = org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.RootImpl
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__CHILDREN = 0;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.RootChildImpl <em>Root Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.RootChildImpl
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getRootChild()
	 * @generated
	 */
	int ROOT_CHILD = 1;

	/**
	 * The number of structural features of the '<em>Root Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CHILD_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Root Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CHILD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.TopParentImpl <em>Top Parent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.TopParentImpl
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getTopParent()
	 * @generated
	 */
	int TOP_PARENT = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_PARENT__CHILDREN = ROOT_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Top Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_PARENT_FEATURE_COUNT = ROOT_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Top Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_PARENT_OPERATION_COUNT = ROOT_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.MediumImpl <em>Medium</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.MediumImpl
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getMedium()
	 * @generated
	 */
	int MEDIUM = 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM__CHILDREN = ROOT_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Medium</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM_FEATURE_COUNT = ROOT_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Medium</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM_OPERATION_COUNT = ROOT_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.TopChildImpl <em>Top Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.TopChildImpl
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getTopChild()
	 * @generated
	 */
	int TOP_CHILD = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_CHILD__NAME = 0;

	/**
	 * The number of structural features of the '<em>Top Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_CHILD_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Top Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_CHILD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.MediumParentImpl <em>Medium Parent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.MediumParentImpl
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getMediumParent()
	 * @generated
	 */
	int MEDIUM_PARENT = 5;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM_PARENT__CHILDREN = 0;

	/**
	 * The number of structural features of the '<em>Medium Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM_PARENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Medium Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM_PARENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.MediumChildImpl <em>Medium Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.MediumChildImpl
	 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getMediumChild()
	 * @generated
	 */
	int MEDIUM_CHILD = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM_CHILD__NAME = 0;

	/**
	 * The number of structural features of the '<em>Medium Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM_CHILD_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Medium Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM_CHILD_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.phantoms.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.phantoms.Root#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.Root#getChildren()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.phantoms.RootChild <em>Root Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Child</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.RootChild
	 * @generated
	 */
	EClass getRootChild();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.phantoms.TopParent <em>Top Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Parent</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.TopParent
	 * @generated
	 */
	EClass getTopParent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.phantoms.TopParent#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.TopParent#getChildren()
	 * @see #getTopParent()
	 * @generated
	 */
	EReference getTopParent_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.phantoms.Medium <em>Medium</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Medium</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.Medium
	 * @generated
	 */
	EClass getMedium();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.phantoms.Medium#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.Medium#getChildren()
	 * @see #getMedium()
	 * @generated
	 */
	EReference getMedium_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.phantoms.TopChild <em>Top Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Child</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.TopChild
	 * @generated
	 */
	EClass getTopChild();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.phantoms.TopChild#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.TopChild#getName()
	 * @see #getTopChild()
	 * @generated
	 */
	EAttribute getTopChild_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.phantoms.MediumParent <em>Medium Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Medium Parent</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.MediumParent
	 * @generated
	 */
	EClass getMediumParent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.phantoms.MediumParent#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.MediumParent#getChildren()
	 * @see #getMediumParent()
	 * @generated
	 */
	EReference getMediumParent_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.phantoms.MediumChild <em>Medium Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Medium Child</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.MediumChild
	 * @generated
	 */
	EClass getMediumChild();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.phantoms.MediumChild#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.MediumChild#getName()
	 * @see #getMediumChild()
	 * @generated
	 */
	EAttribute getMediumChild_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PhantomsFactory getPhantomsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.RootImpl
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__CHILDREN = eINSTANCE.getRoot_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.RootChildImpl <em>Root Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.RootChildImpl
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getRootChild()
		 * @generated
		 */
		EClass ROOT_CHILD = eINSTANCE.getRootChild();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.TopParentImpl <em>Top Parent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.TopParentImpl
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getTopParent()
		 * @generated
		 */
		EClass TOP_PARENT = eINSTANCE.getTopParent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_PARENT__CHILDREN = eINSTANCE.getTopParent_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.MediumImpl <em>Medium</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.MediumImpl
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getMedium()
		 * @generated
		 */
		EClass MEDIUM = eINSTANCE.getMedium();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEDIUM__CHILDREN = eINSTANCE.getMedium_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.TopChildImpl <em>Top Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.TopChildImpl
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getTopChild()
		 * @generated
		 */
		EClass TOP_CHILD = eINSTANCE.getTopChild();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOP_CHILD__NAME = eINSTANCE.getTopChild_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.MediumParentImpl <em>Medium Parent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.MediumParentImpl
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getMediumParent()
		 * @generated
		 */
		EClass MEDIUM_PARENT = eINSTANCE.getMediumParent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEDIUM_PARENT__CHILDREN = eINSTANCE.getMediumParent_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.phantoms.impl.MediumChildImpl <em>Medium Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.MediumChildImpl
		 * @see org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsPackageImpl#getMediumChild()
		 * @generated
		 */
		EClass MEDIUM_CHILD = eINSTANCE.getMediumChild();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIUM_CHILD__NAME = eINSTANCE.getMediumChild_Name();

	}

} //PhantomsPackage
