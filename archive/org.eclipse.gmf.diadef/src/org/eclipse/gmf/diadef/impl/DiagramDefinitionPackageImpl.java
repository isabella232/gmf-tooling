/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.diadef.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.diadef.AdornmentKind;
import org.eclipse.gmf.diadef.Canvas;
import org.eclipse.gmf.diadef.CommonBase;
import org.eclipse.gmf.diadef.Compartment;
import org.eclipse.gmf.diadef.Connection;
import org.eclipse.gmf.diadef.DiagramDefinitionFactory;
import org.eclipse.gmf.diadef.DiagramDefinitionPackage;
import org.eclipse.gmf.diadef.DiagramElement;
import org.eclipse.gmf.diadef.Identity;
import org.eclipse.gmf.diadef.LineKind;
import org.eclipse.gmf.diadef.Node;
import org.eclipse.gmf.diadef.RunTimeProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramDefinitionPackageImpl extends EPackageImpl implements DiagramDefinitionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

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
	private EClass runTimePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commonBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum lineKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum adornmentKindEEnum = null;

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
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DiagramDefinitionPackageImpl() {
		super(eNS_URI, DiagramDefinitionFactory.eINSTANCE);
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
	public static DiagramDefinitionPackage init() {
		if (isInited) return (DiagramDefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramDefinitionPackage.eNS_URI);

		// Obtain or create and register package
		DiagramDefinitionPackageImpl theDiagramDefinitionPackage = (DiagramDefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DiagramDefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new DiagramDefinitionPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDiagramDefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theDiagramDefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDiagramDefinitionPackage.freeze();

		return theDiagramDefinitionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagramElement() {
		return diagramElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramElement_NeedsTool() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramElement_ToolGroupID() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramElement_SmallIconPath() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramElement_LargeIconPath() {
		return (EAttribute)diagramElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_MaxWidth() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_MaxHeight() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_DefaultWidth() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_DefaultHeight() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Compartments() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompartment() {
		return compartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompartment_Collapsible() {
		return (EAttribute)compartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompartment_NeedsTitle() {
		return (EAttribute)compartmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnection() {
		return connectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_LineKind() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_SourceAdornment() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_TargetAdornment() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(2);
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
	public EReference getCanvas_Nodes() {
		return (EReference)canvasEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCanvas_Links() {
		return (EReference)canvasEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRunTimeProperty() {
		return runTimePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentity() {
		return identityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentity_Name() {
		return (EAttribute)identityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommonBase() {
		return commonBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommonBase_Properties() {
		return (EReference)commonBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLineKind() {
		return lineKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAdornmentKind() {
		return adornmentKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramDefinitionFactory getDiagramDefinitionFactory() {
		return (DiagramDefinitionFactory)getEFactoryInstance();
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
		diagramElementEClass = createEClass(DIAGRAM_ELEMENT);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__NEEDS_TOOL);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__TOOL_GROUP_ID);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__SMALL_ICON_PATH);
		createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__LARGE_ICON_PATH);

		nodeEClass = createEClass(NODE);
		createEAttribute(nodeEClass, NODE__MAX_WIDTH);
		createEAttribute(nodeEClass, NODE__MAX_HEIGHT);
		createEAttribute(nodeEClass, NODE__DEFAULT_WIDTH);
		createEAttribute(nodeEClass, NODE__DEFAULT_HEIGHT);
		createEReference(nodeEClass, NODE__COMPARTMENTS);

		compartmentEClass = createEClass(COMPARTMENT);
		createEAttribute(compartmentEClass, COMPARTMENT__COLLAPSIBLE);
		createEAttribute(compartmentEClass, COMPARTMENT__NEEDS_TITLE);

		connectionEClass = createEClass(CONNECTION);
		createEAttribute(connectionEClass, CONNECTION__LINE_KIND);
		createEAttribute(connectionEClass, CONNECTION__SOURCE_ADORNMENT);
		createEAttribute(connectionEClass, CONNECTION__TARGET_ADORNMENT);

		canvasEClass = createEClass(CANVAS);
		createEReference(canvasEClass, CANVAS__NODES);
		createEReference(canvasEClass, CANVAS__LINKS);

		runTimePropertyEClass = createEClass(RUN_TIME_PROPERTY);

		identityEClass = createEClass(IDENTITY);
		createEAttribute(identityEClass, IDENTITY__NAME);

		commonBaseEClass = createEClass(COMMON_BASE);
		createEReference(commonBaseEClass, COMMON_BASE__PROPERTIES);

		// Create enums
		lineKindEEnum = createEEnum(LINE_KIND);
		adornmentKindEEnum = createEEnum(ADORNMENT_KIND);
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

		// Add supertypes to classes
		diagramElementEClass.getESuperTypes().add(this.getCommonBase());
		nodeEClass.getESuperTypes().add(this.getDiagramElement());
		compartmentEClass.getESuperTypes().add(this.getIdentity());
		connectionEClass.getESuperTypes().add(this.getDiagramElement());
		canvasEClass.getESuperTypes().add(this.getCommonBase());
		runTimePropertyEClass.getESuperTypes().add(this.getIdentity());
		commonBaseEClass.getESuperTypes().add(this.getIdentity());

		// Initialize classes and features; add operations and parameters
		initEClass(diagramElementEClass, DiagramElement.class, "DiagramElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagramElement_NeedsTool(), ecorePackage.getEBoolean(), "needsTool", "true", 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_ToolGroupID(), ecorePackage.getEString(), "toolGroupID", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_SmallIconPath(), ecorePackage.getEString(), "smallIconPath", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramElement_LargeIconPath(), ecorePackage.getEString(), "largeIconPath", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNode_MaxWidth(), ecorePackage.getEInt(), "maxWidth", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_MaxHeight(), ecorePackage.getEInt(), "maxHeight", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_DefaultWidth(), ecorePackage.getEInt(), "defaultWidth", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_DefaultHeight(), ecorePackage.getEInt(), "defaultHeight", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Compartments(), this.getCompartment(), null, "compartments", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compartmentEClass, Compartment.class, "Compartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompartment_Collapsible(), ecorePackage.getEBoolean(), "collapsible", null, 0, 1, Compartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompartment_NeedsTitle(), ecorePackage.getEBoolean(), "needsTitle", null, 0, 1, Compartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnection_LineKind(), this.getLineKind(), "lineKind", "SOLID", 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_SourceAdornment(), this.getAdornmentKind(), "sourceAdornment", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_TargetAdornment(), this.getAdornmentKind(), "targetAdornment", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(canvasEClass, Canvas.class, "Canvas", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCanvas_Nodes(), this.getNode(), null, "nodes", null, 0, -1, Canvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCanvas_Links(), this.getConnection(), null, "links", null, 0, -1, Canvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runTimePropertyEClass, RunTimeProperty.class, "RunTimeProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(identityEClass, Identity.class, "Identity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentity_Name(), ecorePackage.getEString(), "name", null, 1, 1, Identity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commonBaseEClass, CommonBase.class, "CommonBase", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommonBase_Properties(), this.getRunTimeProperty(), null, "properties", null, 0, -1, CommonBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(lineKindEEnum, LineKind.class, "LineKind");
		addEEnumLiteral(lineKindEEnum, LineKind.SOLID_LITERAL);
		addEEnumLiteral(lineKindEEnum, LineKind.DOT_LITERAL);
		addEEnumLiteral(lineKindEEnum, LineKind.DASH_LITERAL);

		initEEnum(adornmentKindEEnum, AdornmentKind.class, "AdornmentKind");
		addEEnumLiteral(adornmentKindEEnum, AdornmentKind.NONE_LITERAL);
		addEEnumLiteral(adornmentKindEEnum, AdornmentKind.OPEN_TRIANGLE_LITERAL);
		addEEnumLiteral(adornmentKindEEnum, AdornmentKind.FILLED_TRIANGLE_LITERAL);
		addEEnumLiteral(adornmentKindEEnum, AdornmentKind.RHOMB_LITERAL);
		addEEnumLiteral(adornmentKindEEnum, AdornmentKind.FILLED_RHOMB_LITERAL);

		// Create resource
		createResource(eNS_URI);
	}

} //DiagramDefinitionPackageImpl
