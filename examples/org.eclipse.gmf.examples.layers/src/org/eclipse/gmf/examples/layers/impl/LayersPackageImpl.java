/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.layers.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.examples.layers.Layer;
import org.eclipse.gmf.examples.layers.LayerEnablement;
import org.eclipse.gmf.examples.layers.LayersFactory;
import org.eclipse.gmf.examples.layers.LayersPackage;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.examples.layers.SubDiagramSupport;
import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayersPackageImpl extends EPackageImpl implements LayersPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subDiagramSupportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subDiagramSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerEnablementEClass = null;

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
	 * @see org.eclipse.gmf.examples.layers.LayersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LayersPackageImpl() {
		super(eNS_URI, LayersFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LayersPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LayersPackage init() {
		if (isInited) return (LayersPackage)EPackage.Registry.INSTANCE.getEPackage(LayersPackage.eNS_URI);

		// Obtain or create and register package
		LayersPackageImpl theLayersPackage = (LayersPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LayersPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LayersPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLayersPackage.createPackageContents();

		// Initialize created meta-data
		theLayersPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLayersPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LayersPackage.eNS_URI, theLayersPackage);
		return theLayersPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubDiagramSupport() {
		return subDiagramSupportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubDiagramSupport_Layers() {
		return (EReference)subDiagramSupportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubDiagramSupport_MainDiagram() {
		return (EReference)subDiagramSupportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubDiagramSupport_SubDiagrams() {
		return (EReference)subDiagramSupportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayer() {
		return layerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayer_Name() {
		return (EAttribute)layerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayer_ColorDef() {
		return (EAttribute)layerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayer_Participants() {
		return (EReference)layerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubDiagramSpec() {
		return subDiagramSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubDiagramSpec_Name() {
		return (EAttribute)subDiagramSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubDiagramSpec_Showing() {
		return (EAttribute)subDiagramSpecEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubDiagramSpec_DiagramLayers() {
		return (EReference)subDiagramSpecEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubDiagramSpec_Diagram() {
		return (EReference)subDiagramSpecEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerEnablement() {
		return layerEnablementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerEnablement_Layer() {
		return (EReference)layerEnablementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerEnablement_Visible() {
		return (EAttribute)layerEnablementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersFactory getLayersFactory() {
		return (LayersFactory)getEFactoryInstance();
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
		subDiagramSupportEClass = createEClass(SUB_DIAGRAM_SUPPORT);
		createEReference(subDiagramSupportEClass, SUB_DIAGRAM_SUPPORT__LAYERS);
		createEReference(subDiagramSupportEClass, SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM);
		createEReference(subDiagramSupportEClass, SUB_DIAGRAM_SUPPORT__SUB_DIAGRAMS);

		layerEClass = createEClass(LAYER);
		createEAttribute(layerEClass, LAYER__NAME);
		createEAttribute(layerEClass, LAYER__COLOR_DEF);
		createEReference(layerEClass, LAYER__PARTICIPANTS);

		subDiagramSpecEClass = createEClass(SUB_DIAGRAM_SPEC);
		createEAttribute(subDiagramSpecEClass, SUB_DIAGRAM_SPEC__NAME);
		createEAttribute(subDiagramSpecEClass, SUB_DIAGRAM_SPEC__SHOWING);
		createEReference(subDiagramSpecEClass, SUB_DIAGRAM_SPEC__DIAGRAM_LAYERS);
		createEReference(subDiagramSpecEClass, SUB_DIAGRAM_SPEC__DIAGRAM);

		layerEnablementEClass = createEClass(LAYER_ENABLEMENT);
		createEReference(layerEnablementEClass, LAYER_ENABLEMENT__LAYER);
		createEAttribute(layerEnablementEClass, LAYER_ENABLEMENT__VISIBLE);
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

		// Obtain other dependent packages
		NotationPackage theNotationPackage = (NotationPackage)EPackage.Registry.INSTANCE.getEPackage(NotationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(subDiagramSupportEClass, SubDiagramSupport.class, "SubDiagramSupport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubDiagramSupport_Layers(), this.getLayer(), null, "layers", null, 0, -1, SubDiagramSupport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubDiagramSupport_MainDiagram(), this.getSubDiagramSpec(), null, "mainDiagram", null, 0, 1, SubDiagramSupport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubDiagramSupport_SubDiagrams(), this.getSubDiagramSpec(), null, "subDiagrams", null, 0, -1, SubDiagramSupport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(subDiagramSupportEClass, this.getSubDiagramSpec(), "getAllDiagrams", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(subDiagramSupportEClass, this.getSubDiagramSpec(), "findDiagramSpec", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theNotationPackage.getDiagram(), "diagram", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(subDiagramSupportEClass, null, "ensureAllSubDiagramsHaveEnablementForAllLayers", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(layerEClass, Layer.class, "Layer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLayer_Name(), ecorePackage.getEString(), "name", null, 0, 1, Layer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayer_ColorDef(), ecorePackage.getEString(), "colorDef", null, 0, 1, Layer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayer_Participants(), ecorePackage.getEObject(), null, "participants", null, 0, -1, Layer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subDiagramSpecEClass, SubDiagramSpec.class, "SubDiagramSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubDiagramSpec_Name(), ecorePackage.getEString(), "name", null, 0, 1, SubDiagramSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubDiagramSpec_Showing(), ecorePackage.getEBoolean(), "showing", null, 0, 1, SubDiagramSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubDiagramSpec_DiagramLayers(), this.getLayerEnablement(), null, "diagramLayers", null, 0, -1, SubDiagramSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubDiagramSpec_Diagram(), theNotationPackage.getDiagram(), null, "diagram", null, 0, 1, SubDiagramSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(subDiagramSpecEClass, this.getLayerEnablement(), "findLayerEnablement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLayer(), "layer", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(layerEnablementEClass, LayerEnablement.class, "LayerEnablement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayerEnablement_Layer(), this.getLayer(), null, "layer", null, 0, 1, LayerEnablement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayerEnablement_Visible(), ecorePackage.getEBoolean(), "visible", null, 0, 1, LayerEnablement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //LayersPackageImpl
