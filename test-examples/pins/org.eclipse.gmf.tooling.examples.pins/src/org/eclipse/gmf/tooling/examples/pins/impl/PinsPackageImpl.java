/**
 */
package org.eclipse.gmf.tooling.examples.pins.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.tooling.examples.pins.ChangeableColorPin;
import org.eclipse.gmf.tooling.examples.pins.ColorPin;
import org.eclipse.gmf.tooling.examples.pins.CustomPin;
import org.eclipse.gmf.tooling.examples.pins.Diagram;
import org.eclipse.gmf.tooling.examples.pins.Pin;
import org.eclipse.gmf.tooling.examples.pins.PinsChild;
import org.eclipse.gmf.tooling.examples.pins.PinsFactory;
import org.eclipse.gmf.tooling.examples.pins.PinsPackage;
import org.eclipse.gmf.tooling.examples.pins.VisiblePin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PinsPackageImpl extends EPackageImpl implements PinsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorPinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customPinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visiblePinEClass = null;

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
	private EClass pinsChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeableColorPinEClass = null;

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
	 * @see org.eclipse.gmf.tooling.examples.pins.PinsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PinsPackageImpl() {
		super(eNS_URI, PinsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PinsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PinsPackage init() {
		if (isInited) return (PinsPackage)EPackage.Registry.INSTANCE.getEPackage(PinsPackage.eNS_URI);

		// Obtain or create and register package
		PinsPackageImpl thePinsPackage = (PinsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PinsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PinsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePinsPackage.createPackageContents();

		// Initialize created meta-data
		thePinsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePinsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PinsPackage.eNS_URI, thePinsPackage);
		return thePinsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPin() {
		return pinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColorPin() {
		return colorPinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColorPin_GetChildren() {
		return (EReference)colorPinEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomPin() {
		return customPinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomPin_GetChildren() {
		return (EReference)customPinEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisiblePin() {
		return visiblePinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisiblePin_WarningLabel() {
		return (EAttribute)visiblePinEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisiblePin_GetChildren() {
		return (EReference)visiblePinEClass.getEStructuralFeatures().get(1);
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
	public EReference getDiagram_GetPins() {
		return (EReference)diagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPinsChild() {
		return pinsChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPinsChild_PinsChild() {
		return (EAttribute)pinsChildEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChangeableColorPin() {
		return changeableColorPinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeableColorPin_Red() {
		return (EAttribute)changeableColorPinEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeableColorPin_Green() {
		return (EAttribute)changeableColorPinEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeableColorPin_Blue() {
		return (EAttribute)changeableColorPinEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PinsFactory getPinsFactory() {
		return (PinsFactory)getEFactoryInstance();
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
		pinEClass = createEClass(PIN);

		colorPinEClass = createEClass(COLOR_PIN);
		createEReference(colorPinEClass, COLOR_PIN__GET_CHILDREN);

		customPinEClass = createEClass(CUSTOM_PIN);
		createEReference(customPinEClass, CUSTOM_PIN__GET_CHILDREN);

		visiblePinEClass = createEClass(VISIBLE_PIN);
		createEAttribute(visiblePinEClass, VISIBLE_PIN__WARNING_LABEL);
		createEReference(visiblePinEClass, VISIBLE_PIN__GET_CHILDREN);

		diagramEClass = createEClass(DIAGRAM);
		createEReference(diagramEClass, DIAGRAM__GET_PINS);

		pinsChildEClass = createEClass(PINS_CHILD);
		createEAttribute(pinsChildEClass, PINS_CHILD__PINS_CHILD);

		changeableColorPinEClass = createEClass(CHANGEABLE_COLOR_PIN);
		createEAttribute(changeableColorPinEClass, CHANGEABLE_COLOR_PIN__RED);
		createEAttribute(changeableColorPinEClass, CHANGEABLE_COLOR_PIN__GREEN);
		createEAttribute(changeableColorPinEClass, CHANGEABLE_COLOR_PIN__BLUE);
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
		colorPinEClass.getESuperTypes().add(this.getPin());
		customPinEClass.getESuperTypes().add(this.getPin());
		visiblePinEClass.getESuperTypes().add(this.getPin());
		changeableColorPinEClass.getESuperTypes().add(this.getPin());

		// Initialize classes and features; add operations and parameters
		initEClass(pinEClass, Pin.class, "Pin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(colorPinEClass, ColorPin.class, "ColorPin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getColorPin_GetChildren(), this.getPinsChild(), null, "getChildren", null, 0, -1, ColorPin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customPinEClass, CustomPin.class, "CustomPin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCustomPin_GetChildren(), this.getPinsChild(), null, "getChildren", null, 0, -1, CustomPin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visiblePinEClass, VisiblePin.class, "VisiblePin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVisiblePin_WarningLabel(), ecorePackage.getEString(), "WarningLabel", "Need more children", 0, 1, VisiblePin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisiblePin_GetChildren(), this.getPinsChild(), null, "getChildren", null, 0, -1, VisiblePin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagramEClass, Diagram.class, "Diagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagram_GetPins(), this.getPin(), null, "getPins", null, 0, -1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pinsChildEClass, PinsChild.class, "PinsChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPinsChild_PinsChild(), ecorePackage.getEString(), "PinsChild", null, 0, 1, PinsChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changeableColorPinEClass, ChangeableColorPin.class, "ChangeableColorPin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChangeableColorPin_Red(), ecorePackage.getEInt(), "red", null, 0, 1, ChangeableColorPin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChangeableColorPin_Green(), ecorePackage.getEInt(), "green", null, 0, 1, ChangeableColorPin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChangeableColorPin_Blue(), ecorePackage.getEInt(), "blue", null, 0, 1, ChangeableColorPin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PinsPackageImpl
