/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.tests.xpand.migration.testModel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.tests.xpand.migration.testModel.Child;
import org.eclipse.gmf.tests.xpand.migration.testModel.Container;
import org.eclipse.gmf.tests.xpand.migration.testModel.DefaultAttributeContainer;
import org.eclipse.gmf.tests.xpand.migration.testModel.Enumeration;
import org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsFactory;
import org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage;
import org.eclipse.gmf.tests.xpand.migration.testModel.SubContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MigrationTestsPackageImpl extends EPackageImpl implements MigrationTestsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultAttributeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enumerationEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.gmf.tests.xpand.migration.testModel.MigrationTestsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MigrationTestsPackageImpl() {
		super(eNS_URI, MigrationTestsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MigrationTestsPackage init() {
		if (isInited) return (MigrationTestsPackage)EPackage.Registry.INSTANCE.getEPackage(MigrationTestsPackage.eNS_URI);

		// Obtain or create and register package
		MigrationTestsPackageImpl theMigrationTestsPackage = (MigrationTestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MigrationTestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MigrationTestsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMigrationTestsPackage.createPackageContents();

		// Initialize created meta-data
		theMigrationTestsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMigrationTestsPackage.freeze();

		return theMigrationTestsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainer() {
		return containerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_SingletonChild() {
		return (EReference)containerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_SingletonChildConstrained() {
		return (EReference)containerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_OrderedChildren() {
		return (EReference)containerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_UniqueChildren() {
		return (EReference)containerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_OrderedUniqueChildren() {
		return (EReference)containerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_Children() {
		return (EReference)containerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContainer_It() {
		return (EAttribute)containerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChild() {
		return childEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubContainer() {
		return subContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultAttributeContainer() {
		return defaultAttributeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefaultAttributeContainer_Default() {
		return (EAttribute)defaultAttributeContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnumeration() {
		return enumerationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationTestsFactory getMigrationTestsFactory() {
		return (MigrationTestsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		containerEClass = createEClass(CONTAINER);
		createEReference(containerEClass, CONTAINER__SINGLETON_CHILD);
		createEReference(containerEClass, CONTAINER__SINGLETON_CHILD_CONSTRAINED);
		createEReference(containerEClass, CONTAINER__ORDERED_CHILDREN);
		createEReference(containerEClass, CONTAINER__UNIQUE_CHILDREN);
		createEReference(containerEClass, CONTAINER__ORDERED_UNIQUE_CHILDREN);
		createEReference(containerEClass, CONTAINER__CHILDREN);
		createEAttribute(containerEClass, CONTAINER__IT);

		childEClass = createEClass(CHILD);

		subContainerEClass = createEClass(SUB_CONTAINER);

		defaultAttributeContainerEClass = createEClass(DEFAULT_ATTRIBUTE_CONTAINER);
		createEAttribute(defaultAttributeContainerEClass, DEFAULT_ATTRIBUTE_CONTAINER__DEFAULT);

		// Create enums
		enumerationEEnum = createEEnum(ENUMERATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		subContainerEClass.getESuperTypes().add(this.getContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(containerEClass, Container.class, "Container", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainer_SingletonChild(), this.getChild(), null, "singletonChild", null, 0, 1, Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getContainer_SingletonChildConstrained(), this.getChild(), null, "singletonChildConstrained", null, 1, 1, Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainer_OrderedChildren(), this.getChild(), null, "orderedChildren", null, 0, -1, Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainer_UniqueChildren(), this.getChild(), null, "uniqueChildren", null, 0, -1, Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getContainer_OrderedUniqueChildren(), this.getChild(), null, "orderedUniqueChildren", null, 0, -1, Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainer_Children(), this.getChild(), null, "children", null, 0, -1, Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContainer_It(), ecorePackage.getEBoolean(), "it", null, 0, 1, Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(containerEClass, this.getChild(), "singletonChildOp", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(containerEClass, this.getChild(), "singletonChildConstrainedOp", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(containerEClass, this.getChild(), "orderedChildrenOp", 1, -1, !IS_UNIQUE, IS_ORDERED);

		addEOperation(containerEClass, this.getChild(), "uniqueChildrenOp", 1, -1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(containerEClass, this.getChild(), "orderedUniqueChildrenOp", 1, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(containerEClass, this.getChild(), "childrenOp", 1, -1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(childEClass, Child.class, "Child", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subContainerEClass, SubContainer.class, "SubContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(defaultAttributeContainerEClass, DefaultAttributeContainer.class, "DefaultAttributeContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefaultAttributeContainer_Default(), ecorePackage.getEBoolean(), "default", null, 0, 1, DefaultAttributeContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(enumerationEEnum, Enumeration.class, "Enumeration");
		addEEnumLiteral(enumerationEEnum, Enumeration.LITERAL_0);
		addEEnumLiteral(enumerationEEnum, Enumeration.LITERAL_1);

		// Create resource
		createResource(eNS_URI);
	}

} //MigrationTestsPackageImpl
