/**
 */
package org.eclipse.gmf.tooling.examples.labels.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.tooling.examples.labels.AllLabelsType;
import org.eclipse.gmf.tooling.examples.labels.ChildLabelNode;
import org.eclipse.gmf.tooling.examples.labels.ChildLabelNodeContainer;
import org.eclipse.gmf.tooling.examples.labels.Diagram;
import org.eclipse.gmf.tooling.examples.labels.GenLabelNode;
import org.eclipse.gmf.tooling.examples.labels.LabelsFactory;
import org.eclipse.gmf.tooling.examples.labels.LabelsPackage;
import org.eclipse.gmf.tooling.examples.labels.LinkWithLabel;
import org.eclipse.gmf.tooling.examples.labels.NamedElement;
import org.eclipse.gmf.tooling.examples.labels.Side;
import org.eclipse.gmf.tooling.examples.labels.VerticalLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LabelsPackageImpl extends EPackageImpl implements LabelsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allLabelsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childLabelNodeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childLabelNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genLabelNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass verticalLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkWithLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sideEEnum = null;

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
	 * @see org.eclipse.gmf.tooling.examples.labels.LabelsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LabelsPackageImpl() {
		super(eNS_URI, LabelsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LabelsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LabelsPackage init() {
		if (isInited) return (LabelsPackage)EPackage.Registry.INSTANCE.getEPackage(LabelsPackage.eNS_URI);

		// Obtain or create and register package
		LabelsPackageImpl theLabelsPackage = (LabelsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LabelsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LabelsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theLabelsPackage.createPackageContents();

		// Initialize created meta-data
		theLabelsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLabelsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LabelsPackage.eNS_URI, theLabelsPackage);
		return theLabelsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllLabelsType() {
		return allLabelsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_BigDecimal() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_BigInteger() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_Boolean() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_BooleanObject() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_Byte() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_ByteObject() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_Char() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_CharacterObject() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_Date() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_Double() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_DoubleObject() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_Float() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_FloatObject() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_Int() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_IntegerObject() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_Long() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_LongObject() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_Short() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_ShortObject() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_String() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllLabelsType_Side() {
		return (EAttribute)allLabelsTypeEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAllLabelsType_FeatureVerticalLabelLinks() {
		return (EReference)allLabelsTypeEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildLabelNodeContainer() {
		return childLabelNodeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChildLabelNodeContainer_GetChildren() {
		return (EReference)childLabelNodeContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildLabelNode() {
		return childLabelNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenLabelNode() {
		return genLabelNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVerticalLabel() {
		return verticalLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagram() {
		return diagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagram_GetLabels() {
		return (EReference)diagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkWithLabel() {
		return linkWithLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkWithLabel_Target() {
		return (EReference)linkWithLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkWithLabel_Source() {
		return (EReference)linkWithLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSide() {
		return sideEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelsFactory getLabelsFactory() {
		return (LabelsFactory)getEFactoryInstance();
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
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		allLabelsTypeEClass = createEClass(ALL_LABELS_TYPE);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__BIG_DECIMAL);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__BIG_INTEGER);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__BOOLEAN);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__BOOLEAN_OBJECT);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__BYTE);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__BYTE_OBJECT);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__CHAR);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__CHARACTER_OBJECT);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__DATE);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__DOUBLE);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__DOUBLE_OBJECT);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__FLOAT);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__FLOAT_OBJECT);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__INT);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__INTEGER_OBJECT);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__LONG);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__LONG_OBJECT);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__SHORT);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__SHORT_OBJECT);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__STRING);
		createEAttribute(allLabelsTypeEClass, ALL_LABELS_TYPE__SIDE);
		createEReference(allLabelsTypeEClass, ALL_LABELS_TYPE__FEATURE_VERTICAL_LABEL_LINKS);

		childLabelNodeContainerEClass = createEClass(CHILD_LABEL_NODE_CONTAINER);
		createEReference(childLabelNodeContainerEClass, CHILD_LABEL_NODE_CONTAINER__GET_CHILDREN);

		childLabelNodeEClass = createEClass(CHILD_LABEL_NODE);

		genLabelNodeEClass = createEClass(GEN_LABEL_NODE);

		verticalLabelEClass = createEClass(VERTICAL_LABEL);

		diagramEClass = createEClass(DIAGRAM);
		createEReference(diagramEClass, DIAGRAM__GET_LABELS);

		linkWithLabelEClass = createEClass(LINK_WITH_LABEL);
		createEReference(linkWithLabelEClass, LINK_WITH_LABEL__TARGET);
		createEReference(linkWithLabelEClass, LINK_WITH_LABEL__SOURCE);

		// Create enums
		sideEEnum = createEEnum(SIDE);
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
		allLabelsTypeEClass.getESuperTypes().add(this.getNamedElement());
		childLabelNodeContainerEClass.getESuperTypes().add(this.getNamedElement());
		childLabelNodeEClass.getESuperTypes().add(this.getNamedElement());
		genLabelNodeEClass.getESuperTypes().add(this.getNamedElement());
		verticalLabelEClass.getESuperTypes().add(this.getNamedElement());
		linkWithLabelEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(allLabelsTypeEClass, AllLabelsType.class, "AllLabelsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAllLabelsType_BigDecimal(), ecorePackage.getEBigDecimal(), "bigDecimal", "0", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_BigInteger(), ecorePackage.getEBigInteger(), "bigInteger", "311", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_Boolean(), ecorePackage.getEBoolean(), "boolean", null, 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_BooleanObject(), ecorePackage.getEBooleanObject(), "booleanObject", "true", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_Byte(), ecorePackage.getEByte(), "byte", "1", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_ByteObject(), ecorePackage.getEByteObject(), "byteObject", "42", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_Char(), ecorePackage.getEChar(), "char", "{", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_CharacterObject(), ecorePackage.getECharacterObject(), "characterObject", "}", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_Date(), ecorePackage.getEDate(), "date", null, 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_Double(), ecorePackage.getEDouble(), "double", "42.42", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_DoubleObject(), ecorePackage.getEDoubleObject(), "doubleObject", "42.42", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_Float(), ecorePackage.getEFloat(), "float", "24.24", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_FloatObject(), ecorePackage.getEFloatObject(), "floatObject", null, 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_Int(), ecorePackage.getEInt(), "int", "36535", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_IntegerObject(), ecorePackage.getEIntegerObject(), "integerObject", null, 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_Long(), ecorePackage.getELong(), "long", "424242", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_LongObject(), ecorePackage.getELongObject(), "longObject", null, 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_Short(), ecorePackage.getEShort(), "short", "13", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_ShortObject(), ecorePackage.getEShortObject(), "shortObject", "42", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_String(), ecorePackage.getEString(), "string", "Hello!", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAllLabelsType_Side(), this.getSide(), "side", "LEFT", 0, 1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAllLabelsType_FeatureVerticalLabelLinks(), this.getVerticalLabel(), null, "featureVerticalLabelLinks", null, 0, -1, AllLabelsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childLabelNodeContainerEClass, ChildLabelNodeContainer.class, "ChildLabelNodeContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChildLabelNodeContainer_GetChildren(), this.getChildLabelNode(), null, "getChildren", null, 1, 4, ChildLabelNodeContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childLabelNodeEClass, ChildLabelNode.class, "ChildLabelNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(genLabelNodeEClass, GenLabelNode.class, "GenLabelNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(verticalLabelEClass, VerticalLabel.class, "VerticalLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(diagramEClass, Diagram.class, "Diagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagram_GetLabels(), this.getNamedElement(), null, "getLabels", null, 0, -1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkWithLabelEClass, LinkWithLabel.class, "LinkWithLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkWithLabel_Target(), this.getGenLabelNode(), null, "target", null, 0, 1, LinkWithLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinkWithLabel_Source(), this.getVerticalLabel(), null, "source", null, 0, 1, LinkWithLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sideEEnum, Side.class, "Side");
		addEEnumLiteral(sideEEnum, Side.LEFT);
		addEEnumLiteral(sideEEnum, Side.RIGHT);

		// Create resource
		createResource(eNS_URI);
	}

} //LabelsPackageImpl
