/**
 */
package org.eclipse.gmf.tooling.examples.compartments.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.tooling.examples.compartments.Canvas;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfA_C;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfA_D;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfAffixed;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G;
import org.eclipse.gmf.tooling.examples.compartments.CompartmentsFactory;
import org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage;
import org.eclipse.gmf.tooling.examples.compartments.TopNode;
import org.eclipse.gmf.tooling.examples.compartments.TopNodeA;
import org.eclipse.gmf.tooling.examples.compartments.TopNodeB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompartmentsPackageImpl extends EPackageImpl implements CompartmentsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass canvasEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topNodeAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topNodeBEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childOfB_EEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childOfB_GEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childOfA_CEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childOfB_FEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childOfAffixedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childOfA_DEClass = null;

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
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompartmentsPackageImpl() {
		super(eNS_URI, CompartmentsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CompartmentsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CompartmentsPackage init() {
		if (isInited) return (CompartmentsPackage)EPackage.Registry.INSTANCE.getEPackage(CompartmentsPackage.eNS_URI);

		// Obtain or create and register package
		CompartmentsPackageImpl theCompartmentsPackage = (CompartmentsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CompartmentsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CompartmentsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCompartmentsPackage.createPackageContents();

		// Initialize created meta-data
		theCompartmentsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompartmentsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CompartmentsPackage.eNS_URI, theCompartmentsPackage);
		return theCompartmentsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCanvas() {
		return canvasEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCanvas_Elements() {
		return (EReference)canvasEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopNodeA() {
		return topNodeAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopNodeA_ChildrenC() {
		return (EReference)topNodeAEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopNodeA_Name() {
		return (EAttribute)topNodeAEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopNodeA_ChildrenD() {
		return (EReference)topNodeAEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopNodeB() {
		return topNodeBEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopNodeB_ChildrenE() {
		return (EReference)topNodeBEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopNodeB_ChildrenG() {
		return (EReference)topNodeBEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopNodeB_Name() {
		return (EAttribute)topNodeBEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopNodeB_ChildrenF() {
		return (EReference)topNodeBEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildOfB_E() {
		return childOfB_EEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChildOfB_E_Name() {
		return (EAttribute)childOfB_EEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChildOfB_E_CNodeRelation() {
		return (EReference)childOfB_EEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildOfB_G() {
		return childOfB_GEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChildOfB_G_Number() {
		return (EAttribute)childOfB_GEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChildOfB_G_ChildrenOfAffixed() {
		return (EReference)childOfB_GEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopNode() {
		return topNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildOfA_C() {
		return childOfA_CEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChildOfA_C_Name() {
		return (EAttribute)childOfA_CEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildOfB_F() {
		return childOfB_FEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChildOfB_F_Name() {
		return (EAttribute)childOfB_FEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChildOfB_F_DNodeRelation() {
		return (EReference)childOfB_FEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildOfAffixed() {
		return childOfAffixedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChildOfAffixed_Description() {
		return (EAttribute)childOfAffixedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildOfA_D() {
		return childOfA_DEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChildOfA_D_Name() {
		return (EAttribute)childOfA_DEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentsFactory getCompartmentsFactory() {
		return (CompartmentsFactory)getEFactoryInstance();
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
		canvasEClass = createEClass(CANVAS);
		createEReference(canvasEClass, CANVAS__ELEMENTS);

		topNodeAEClass = createEClass(TOP_NODE_A);
		createEReference(topNodeAEClass, TOP_NODE_A__CHILDREN_C);
		createEAttribute(topNodeAEClass, TOP_NODE_A__NAME);
		createEReference(topNodeAEClass, TOP_NODE_A__CHILDREN_D);

		topNodeBEClass = createEClass(TOP_NODE_B);
		createEReference(topNodeBEClass, TOP_NODE_B__CHILDREN_E);
		createEReference(topNodeBEClass, TOP_NODE_B__CHILDREN_G);
		createEAttribute(topNodeBEClass, TOP_NODE_B__NAME);
		createEReference(topNodeBEClass, TOP_NODE_B__CHILDREN_F);

		childOfB_EEClass = createEClass(CHILD_OF_BE);
		createEAttribute(childOfB_EEClass, CHILD_OF_BE__NAME);
		createEReference(childOfB_EEClass, CHILD_OF_BE__CNODE_RELATION);

		childOfB_GEClass = createEClass(CHILD_OF_BG);
		createEAttribute(childOfB_GEClass, CHILD_OF_BG__NUMBER);
		createEReference(childOfB_GEClass, CHILD_OF_BG__CHILDREN_OF_AFFIXED);

		topNodeEClass = createEClass(TOP_NODE);

		childOfA_CEClass = createEClass(CHILD_OF_AC);
		createEAttribute(childOfA_CEClass, CHILD_OF_AC__NAME);

		childOfB_FEClass = createEClass(CHILD_OF_BF);
		createEAttribute(childOfB_FEClass, CHILD_OF_BF__NAME);
		createEReference(childOfB_FEClass, CHILD_OF_BF__DNODE_RELATION);

		childOfAffixedEClass = createEClass(CHILD_OF_AFFIXED);
		createEAttribute(childOfAffixedEClass, CHILD_OF_AFFIXED__DESCRIPTION);

		childOfA_DEClass = createEClass(CHILD_OF_AD);
		createEAttribute(childOfA_DEClass, CHILD_OF_AD__NAME);
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
		topNodeAEClass.getESuperTypes().add(this.getTopNode());
		topNodeBEClass.getESuperTypes().add(this.getTopNode());

		// Initialize classes, features, and operations; add parameters
		initEClass(canvasEClass, Canvas.class, "Canvas", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCanvas_Elements(), this.getTopNode(), null, "elements", null, 0, -1, Canvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topNodeAEClass, TopNodeA.class, "TopNodeA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopNodeA_ChildrenC(), this.getChildOfA_C(), null, "childrenC", null, 0, -1, TopNodeA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTopNodeA_Name(), ecorePackage.getEString(), "name", null, 0, 1, TopNodeA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopNodeA_ChildrenD(), this.getChildOfA_D(), null, "childrenD", null, 0, -1, TopNodeA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topNodeBEClass, TopNodeB.class, "TopNodeB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopNodeB_ChildrenE(), this.getChildOfB_E(), null, "childrenE", null, 0, -1, TopNodeB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopNodeB_ChildrenG(), this.getChildOfB_G(), null, "childrenG", null, 0, -1, TopNodeB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTopNodeB_Name(), ecorePackage.getEString(), "name", null, 0, 1, TopNodeB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopNodeB_ChildrenF(), this.getChildOfB_F(), null, "childrenF", null, 0, -1, TopNodeB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childOfB_EEClass, ChildOfB_E.class, "ChildOfB_E", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChildOfB_E_Name(), ecorePackage.getEString(), "name", null, 0, 1, ChildOfB_E.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChildOfB_E_CNodeRelation(), this.getChildOfA_C(), null, "cNodeRelation", null, 0, 1, ChildOfB_E.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childOfB_GEClass, ChildOfB_G.class, "ChildOfB_G", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChildOfB_G_Number(), ecorePackage.getEInt(), "number", null, 0, 1, ChildOfB_G.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChildOfB_G_ChildrenOfAffixed(), this.getChildOfAffixed(), null, "childrenOfAffixed", null, 0, -1, ChildOfB_G.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topNodeEClass, TopNode.class, "TopNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(childOfA_CEClass, ChildOfA_C.class, "ChildOfA_C", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChildOfA_C_Name(), ecorePackage.getEString(), "name", null, 0, 1, ChildOfA_C.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childOfB_FEClass, ChildOfB_F.class, "ChildOfB_F", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChildOfB_F_Name(), ecorePackage.getEString(), "name", null, 0, 1, ChildOfB_F.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChildOfB_F_DNodeRelation(), this.getChildOfA_D(), null, "dNodeRelation", null, 0, 1, ChildOfB_F.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childOfAffixedEClass, ChildOfAffixed.class, "ChildOfAffixed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChildOfAffixed_Description(), ecorePackage.getEString(), "description", null, 0, 1, ChildOfAffixed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childOfA_DEClass, ChildOfA_D.class, "ChildOfA_D", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChildOfA_D_Name(), ecorePackage.getEString(), "name", null, 0, 1, ChildOfA_D.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CompartmentsPackageImpl
