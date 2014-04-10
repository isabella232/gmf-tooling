/**
 */
package org.eclipse.gmf.tooling.examples.links.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.tooling.examples.links.ChildNodeA;
import org.eclipse.gmf.tooling.examples.links.ChildNodeB;
import org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link;
import org.eclipse.gmf.tooling.examples.links.LinksFactory;
import org.eclipse.gmf.tooling.examples.links.LinksPackage;
import org.eclipse.gmf.tooling.examples.links.Root;
import org.eclipse.gmf.tooling.examples.links.RootNodeA;
import org.eclipse.gmf.tooling.examples.links.RootNodeB;
import org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LinksPackageImpl extends EPackageImpl implements LinksPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootNodeAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootNodeBEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childNodeAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childNodeBEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass child_AB_Element_LinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass root_BA_Element_LinkEClass = null;

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
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LinksPackageImpl() {
		super(eNS_URI, LinksFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LinksPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LinksPackage init() {
		if (isInited) return (LinksPackage)EPackage.Registry.INSTANCE.getEPackage(LinksPackage.eNS_URI);

		// Obtain or create and register package
		LinksPackageImpl theLinksPackage = (LinksPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LinksPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LinksPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theLinksPackage.createPackageContents();

		// Initialize created meta-data
		theLinksPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLinksPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LinksPackage.eNS_URI, theLinksPackage);
		return theLinksPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoot() {
		return rootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_ChildABElementLinks() {
		return (EReference)rootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_RootNodeAs() {
		return (EReference)rootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_RootNodeBs() {
		return (EReference)rootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_RootBALinks() {
		return (EReference)rootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootNodeA() {
		return rootNodeAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootNodeA_ChildrenNodeA() {
		return (EReference)rootNodeAEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootNodeB() {
		return rootNodeBEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootNodeB_ChildrenB() {
		return (EReference)rootNodeBEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootNodeB_Root_BA_Feature_Link() {
		return (EReference)rootNodeBEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildNodeA() {
		return childNodeAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChildNodeA_Child_AB_Feature_Link() {
		return (EReference)childNodeAEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildNodeB() {
		return childNodeBEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChild_AB_Element_Link() {
		return child_AB_Element_LinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChild_AB_Element_Link_Source_A() {
		return (EReference)child_AB_Element_LinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChild_AB_Element_Link_Target_B() {
		return (EReference)child_AB_Element_LinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoot_BA_Element_Link() {
		return root_BA_Element_LinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoot_BA_Element_Link_Name() {
		return (EAttribute)root_BA_Element_LinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_BA_Element_Link_B() {
		return (EReference)root_BA_Element_LinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_BA_Element_Link_A() {
		return (EReference)root_BA_Element_LinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinksFactory getLinksFactory() {
		return (LinksFactory)getEFactoryInstance();
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
		rootEClass = createEClass(ROOT);
		createEReference(rootEClass, ROOT__CHILD_AB_ELEMENT_LINKS);
		createEReference(rootEClass, ROOT__ROOT_NODE_AS);
		createEReference(rootEClass, ROOT__ROOT_NODE_BS);
		createEReference(rootEClass, ROOT__ROOT_BA_LINKS);

		rootNodeAEClass = createEClass(ROOT_NODE_A);
		createEReference(rootNodeAEClass, ROOT_NODE_A__CHILDREN_NODE_A);

		rootNodeBEClass = createEClass(ROOT_NODE_B);
		createEReference(rootNodeBEClass, ROOT_NODE_B__CHILDREN_B);
		createEReference(rootNodeBEClass, ROOT_NODE_B__ROOT_BA_FEATURE_LINK);

		childNodeAEClass = createEClass(CHILD_NODE_A);
		createEReference(childNodeAEClass, CHILD_NODE_A__CHILD_AB_FEATURE_LINK);

		childNodeBEClass = createEClass(CHILD_NODE_B);

		child_AB_Element_LinkEClass = createEClass(CHILD_AB_ELEMENT_LINK);
		createEReference(child_AB_Element_LinkEClass, CHILD_AB_ELEMENT_LINK__SOURCE_A);
		createEReference(child_AB_Element_LinkEClass, CHILD_AB_ELEMENT_LINK__TARGET_B);

		root_BA_Element_LinkEClass = createEClass(ROOT_BA_ELEMENT_LINK);
		createEAttribute(root_BA_Element_LinkEClass, ROOT_BA_ELEMENT_LINK__NAME);
		createEReference(root_BA_Element_LinkEClass, ROOT_BA_ELEMENT_LINK__B);
		createEReference(root_BA_Element_LinkEClass, ROOT_BA_ELEMENT_LINK__A);
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

		// Initialize classes, features, and operations; add parameters
		initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoot_ChildABElementLinks(), this.getChild_AB_Element_Link(), null, "childABElementLinks", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_RootNodeAs(), this.getRootNodeA(), null, "rootNodeAs", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_RootNodeBs(), this.getRootNodeB(), null, "rootNodeBs", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_RootBALinks(), this.getRoot_BA_Element_Link(), null, "rootBALinks", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rootNodeAEClass, RootNodeA.class, "RootNodeA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRootNodeA_ChildrenNodeA(), this.getChildNodeA(), null, "ChildrenNodeA", null, 0, -1, RootNodeA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rootNodeBEClass, RootNodeB.class, "RootNodeB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRootNodeB_ChildrenB(), this.getChildNodeB(), null, "ChildrenB", null, 0, -1, RootNodeB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootNodeB_Root_BA_Feature_Link(), this.getRootNodeA(), null, "Root_BA_Feature_Link", null, 0, -1, RootNodeB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childNodeAEClass, ChildNodeA.class, "ChildNodeA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChildNodeA_Child_AB_Feature_Link(), this.getChildNodeB(), null, "Child_AB_Feature_Link", null, 0, -1, ChildNodeA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childNodeBEClass, ChildNodeB.class, "ChildNodeB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(child_AB_Element_LinkEClass, Child_AB_Element_Link.class, "Child_AB_Element_Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChild_AB_Element_Link_Source_A(), this.getChildNodeA(), null, "source_A", null, 0, 1, Child_AB_Element_Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChild_AB_Element_Link_Target_B(), this.getChildNodeB(), null, "target_B", null, 0, 1, Child_AB_Element_Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(root_BA_Element_LinkEClass, Root_BA_Element_Link.class, "Root_BA_Element_Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoot_BA_Element_Link_Name(), ecorePackage.getEString(), "name", null, 0, 1, Root_BA_Element_Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_BA_Element_Link_B(), this.getRootNodeB(), null, "b", null, 0, 1, Root_BA_Element_Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_BA_Element_Link_A(), this.getRootNodeA(), null, "a", null, 0, 1, Root_BA_Element_Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //LinksPackageImpl
