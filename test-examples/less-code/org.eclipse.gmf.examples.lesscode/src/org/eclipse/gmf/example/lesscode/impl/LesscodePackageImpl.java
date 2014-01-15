/**
 */
package org.eclipse.gmf.example.lesscode.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.example.lesscode.ElementBasedLink;
import org.eclipse.gmf.example.lesscode.LesscodeFactory;
import org.eclipse.gmf.example.lesscode.LesscodePackage;
import org.eclipse.gmf.example.lesscode.MultiContainmentGroup;
import org.eclipse.gmf.example.lesscode.OneContainmentGroup;
import org.eclipse.gmf.example.lesscode.RootContainer;
import org.eclipse.gmf.example.lesscode.Subject;
import org.eclipse.gmf.example.lesscode.WithSomeAttributes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LesscodePackageImpl extends EPackageImpl implements LesscodePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementBasedLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass withSomeAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oneContainmentGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiContainmentGroupEClass = null;

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
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LesscodePackageImpl() {
		super(eNS_URI, LesscodeFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link LesscodePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LesscodePackage init() {
		if (isInited) return (LesscodePackage)EPackage.Registry.INSTANCE.getEPackage(LesscodePackage.eNS_URI);

		// Obtain or create and register package
		LesscodePackageImpl theLesscodePackage = (LesscodePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LesscodePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LesscodePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theLesscodePackage.createPackageContents();

		// Initialize created meta-data
		theLesscodePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLesscodePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LesscodePackage.eNS_URI, theLesscodePackage);
		return theLesscodePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootContainer() {
		return rootContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootContainer_RootSubjects() {
		return (EReference)rootContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootContainer_OneContainmentGroups() {
		return (EReference)rootContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootContainer_MultiContainmentGroups() {
		return (EReference)rootContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootContainer_ElementBasedLinks() {
		return (EReference)rootContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementBasedLink() {
		return elementBasedLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementBasedLink_LinkSource() {
		return (EReference)elementBasedLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementBasedLink_LinkTarget() {
		return (EReference)elementBasedLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWithSomeAttributes() {
		return withSomeAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWithSomeAttributes_Name() {
		return (EAttribute)withSomeAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWithSomeAttributes_Value() {
		return (EAttribute)withSomeAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubject() {
		return subjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubject_RecursiveContainment() {
		return (EReference)subjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubject_ReferenceBasedLinkTarget() {
		return (EReference)subjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOneContainmentGroup() {
		return oneContainmentGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOneContainmentGroup_Subjects() {
		return (EReference)oneContainmentGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiContainmentGroup() {
		return multiContainmentGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiContainmentGroup_SubjectsTypeA() {
		return (EReference)multiContainmentGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiContainmentGroup_SubjectsTypeB() {
		return (EReference)multiContainmentGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LesscodeFactory getLesscodeFactory() {
		return (LesscodeFactory)getEFactoryInstance();
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
		rootContainerEClass = createEClass(ROOT_CONTAINER);
		createEReference(rootContainerEClass, ROOT_CONTAINER__ROOT_SUBJECTS);
		createEReference(rootContainerEClass, ROOT_CONTAINER__ONE_CONTAINMENT_GROUPS);
		createEReference(rootContainerEClass, ROOT_CONTAINER__MULTI_CONTAINMENT_GROUPS);
		createEReference(rootContainerEClass, ROOT_CONTAINER__ELEMENT_BASED_LINKS);

		elementBasedLinkEClass = createEClass(ELEMENT_BASED_LINK);
		createEReference(elementBasedLinkEClass, ELEMENT_BASED_LINK__LINK_SOURCE);
		createEReference(elementBasedLinkEClass, ELEMENT_BASED_LINK__LINK_TARGET);

		withSomeAttributesEClass = createEClass(WITH_SOME_ATTRIBUTES);
		createEAttribute(withSomeAttributesEClass, WITH_SOME_ATTRIBUTES__NAME);
		createEAttribute(withSomeAttributesEClass, WITH_SOME_ATTRIBUTES__VALUE);

		subjectEClass = createEClass(SUBJECT);
		createEReference(subjectEClass, SUBJECT__RECURSIVE_CONTAINMENT);
		createEReference(subjectEClass, SUBJECT__REFERENCE_BASED_LINK_TARGET);

		oneContainmentGroupEClass = createEClass(ONE_CONTAINMENT_GROUP);
		createEReference(oneContainmentGroupEClass, ONE_CONTAINMENT_GROUP__SUBJECTS);

		multiContainmentGroupEClass = createEClass(MULTI_CONTAINMENT_GROUP);
		createEReference(multiContainmentGroupEClass, MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_A);
		createEReference(multiContainmentGroupEClass, MULTI_CONTAINMENT_GROUP__SUBJECTS_TYPE_B);
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
		elementBasedLinkEClass.getESuperTypes().add(this.getWithSomeAttributes());
		subjectEClass.getESuperTypes().add(this.getWithSomeAttributes());
		oneContainmentGroupEClass.getESuperTypes().add(this.getWithSomeAttributes());
		multiContainmentGroupEClass.getESuperTypes().add(this.getWithSomeAttributes());

		// Initialize classes and features; add operations and parameters
		initEClass(rootContainerEClass, RootContainer.class, "RootContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRootContainer_RootSubjects(), this.getSubject(), null, "rootSubjects", null, 0, -1, RootContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootContainer_OneContainmentGroups(), this.getOneContainmentGroup(), null, "oneContainmentGroups", null, 0, -1, RootContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootContainer_MultiContainmentGroups(), this.getMultiContainmentGroup(), null, "multiContainmentGroups", null, 0, -1, RootContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootContainer_ElementBasedLinks(), this.getElementBasedLink(), null, "elementBasedLinks", null, 0, -1, RootContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementBasedLinkEClass, ElementBasedLink.class, "ElementBasedLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementBasedLink_LinkSource(), this.getSubject(), null, "linkSource", null, 0, 1, ElementBasedLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementBasedLink_LinkTarget(), this.getSubject(), null, "linkTarget", null, 0, 1, ElementBasedLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(withSomeAttributesEClass, WithSomeAttributes.class, "WithSomeAttributes", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWithSomeAttributes_Name(), ecorePackage.getEString(), "name", null, 0, 1, WithSomeAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWithSomeAttributes_Value(), ecorePackage.getEString(), "value", null, 0, 1, WithSomeAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subjectEClass, Subject.class, "Subject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubject_RecursiveContainment(), this.getSubject(), null, "recursiveContainment", null, 0, -1, Subject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubject_ReferenceBasedLinkTarget(), this.getSubject(), null, "referenceBasedLinkTarget", null, 0, -1, Subject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oneContainmentGroupEClass, OneContainmentGroup.class, "OneContainmentGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOneContainmentGroup_Subjects(), this.getSubject(), null, "subjects", null, 0, -1, OneContainmentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiContainmentGroupEClass, MultiContainmentGroup.class, "MultiContainmentGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiContainmentGroup_SubjectsTypeA(), this.getSubject(), null, "subjectsTypeA", null, 0, -1, MultiContainmentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiContainmentGroup_SubjectsTypeB(), this.getSubject(), null, "subjectsTypeB", null, 0, -1, MultiContainmentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //LesscodePackageImpl
