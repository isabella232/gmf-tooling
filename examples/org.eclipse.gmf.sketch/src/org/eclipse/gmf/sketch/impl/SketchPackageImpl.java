/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.sketch.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.sketch.SketchCompartment;
import org.eclipse.gmf.sketch.SketchDiagram;
import org.eclipse.gmf.sketch.SketchDiagramElement;
import org.eclipse.gmf.sketch.SketchElement;
import org.eclipse.gmf.sketch.SketchFactory;
import org.eclipse.gmf.sketch.SketchLabel;
import org.eclipse.gmf.sketch.SketchLink;
import org.eclipse.gmf.sketch.SketchNode;
import org.eclipse.gmf.sketch.SketchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SketchPackageImpl extends EPackageImpl implements SketchPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sketchElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sketchDiagramElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sketchDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sketchNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sketchCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sketchLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sketchLabelEClass = null;

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
	 * @see org.eclipse.gmf.sketch.SketchPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SketchPackageImpl() {
		super(eNS_URI, SketchFactory.eINSTANCE);
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
	public static SketchPackage init() {
		if (isInited)
			return (SketchPackage) EPackage.Registry.INSTANCE.getEPackage(SketchPackage.eNS_URI);

		// Obtain or create and register package
		SketchPackageImpl theSketchPackage = (SketchPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SketchPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SketchPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSketchPackage.createPackageContents();

		// Initialize created meta-data
		theSketchPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSketchPackage.freeze();

		return theSketchPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSketchElement() {
		return sketchElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchElement_EAnnotations() {
		return (EReference) sketchElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSketchDiagramElement() {
		return sketchDiagramElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSketchDiagramElement_Name() {
		return (EAttribute) sketchDiagramElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSketchDiagramElement_Shape() {
		return (EAttribute) sketchDiagramElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSketchDiagramElement_VisualID() {
		return (EAttribute) sketchDiagramElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSketchDiagram() {
		return sketchDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchDiagram_Nodes() {
		return (EReference) sketchDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchDiagram_Links() {
		return (EReference) sketchDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchDiagram_Type() {
		return (EReference) sketchDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSketchNode() {
		return sketchNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchNode_Nodes() {
		return (EReference) sketchNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchNode_ReferencedNodes() {
		return (EReference) sketchNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchNode_Compartments() {
		return (EReference) sketchNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchNode_Labels() {
		return (EReference) sketchNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchNode_Type() {
		return (EReference) sketchNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchNode_Attributes() {
		return (EReference) sketchNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSketchNode_OnBorder() {
		return (EAttribute) sketchNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSketchCompartment() {
		return sketchCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchCompartment_Nodes() {
		return (EReference) sketchCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchCompartment_ReferencedNodes() {
		return (EReference) sketchCompartmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSketchLink() {
		return sketchLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchLink_Source() {
		return (EReference) sketchLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchLink_Target() {
		return (EReference) sketchLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchLink_Labels() {
		return (EReference) sketchLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchLink_Type() {
		return (EReference) sketchLinkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSketchLabel() {
		return sketchLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSketchLabel_Attributes() {
		return (EReference) sketchLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSketchLabel_External() {
		return (EAttribute) sketchLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SketchFactory getSketchFactory() {
		return (SketchFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		sketchElementEClass = createEClass(SKETCH_ELEMENT);
		createEReference(sketchElementEClass, SKETCH_ELEMENT__EANNOTATIONS);

		sketchDiagramElementEClass = createEClass(SKETCH_DIAGRAM_ELEMENT);
		createEAttribute(sketchDiagramElementEClass, SKETCH_DIAGRAM_ELEMENT__NAME);
		createEAttribute(sketchDiagramElementEClass, SKETCH_DIAGRAM_ELEMENT__SHAPE);
		createEAttribute(sketchDiagramElementEClass, SKETCH_DIAGRAM_ELEMENT__VISUAL_ID);

		sketchDiagramEClass = createEClass(SKETCH_DIAGRAM);
		createEReference(sketchDiagramEClass, SKETCH_DIAGRAM__NODES);
		createEReference(sketchDiagramEClass, SKETCH_DIAGRAM__LINKS);
		createEReference(sketchDiagramEClass, SKETCH_DIAGRAM__TYPE);

		sketchNodeEClass = createEClass(SKETCH_NODE);
		createEReference(sketchNodeEClass, SKETCH_NODE__NODES);
		createEReference(sketchNodeEClass, SKETCH_NODE__REFERENCED_NODES);
		createEReference(sketchNodeEClass, SKETCH_NODE__COMPARTMENTS);
		createEReference(sketchNodeEClass, SKETCH_NODE__LABELS);
		createEReference(sketchNodeEClass, SKETCH_NODE__TYPE);
		createEReference(sketchNodeEClass, SKETCH_NODE__ATTRIBUTES);
		createEAttribute(sketchNodeEClass, SKETCH_NODE__ON_BORDER);

		sketchCompartmentEClass = createEClass(SKETCH_COMPARTMENT);
		createEReference(sketchCompartmentEClass, SKETCH_COMPARTMENT__NODES);
		createEReference(sketchCompartmentEClass, SKETCH_COMPARTMENT__REFERENCED_NODES);

		sketchLinkEClass = createEClass(SKETCH_LINK);
		createEReference(sketchLinkEClass, SKETCH_LINK__SOURCE);
		createEReference(sketchLinkEClass, SKETCH_LINK__TARGET);
		createEReference(sketchLinkEClass, SKETCH_LINK__LABELS);
		createEReference(sketchLinkEClass, SKETCH_LINK__TYPE);

		sketchLabelEClass = createEClass(SKETCH_LABEL);
		createEReference(sketchLabelEClass, SKETCH_LABEL__ATTRIBUTES);
		createEAttribute(sketchLabelEClass, SKETCH_LABEL__EXTERNAL);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sketchDiagramElementEClass.getESuperTypes().add(this.getSketchElement());
		sketchDiagramEClass.getESuperTypes().add(this.getSketchDiagramElement());
		sketchNodeEClass.getESuperTypes().add(this.getSketchDiagramElement());
		sketchCompartmentEClass.getESuperTypes().add(this.getSketchDiagramElement());
		sketchLinkEClass.getESuperTypes().add(this.getSketchDiagramElement());
		sketchLabelEClass.getESuperTypes().add(this.getSketchDiagramElement());

		// Initialize classes and features; add operations and parameters
		initEClass(sketchElementEClass, SketchElement.class, "SketchElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSketchElement_EAnnotations(), theEcorePackage.getEAnnotation(), null,
				"eAnnotations", null, 0, -1, SketchElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(sketchElementEClass, theEcorePackage.getEAnnotation(), "getEAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEString(), "source", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(sketchDiagramElementEClass, SketchDiagramElement.class, "SketchDiagramElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSketchDiagramElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, SketchDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSketchDiagramElement_Shape(), ecorePackage.getEString(), "shape", null, 0, 1, SketchDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSketchDiagramElement_VisualID(), ecorePackage.getEInt(), "visualID", null, 0, 1, SketchDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(sketchDiagramEClass, SketchDiagram.class, "SketchDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSketchDiagram_Nodes(), this.getSketchNode(), null, "nodes", null, 0, -1, SketchDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSketchDiagram_Links(), this.getSketchLink(), null, "links", null, 0, -1, SketchDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSketchDiagram_Type(), theEcorePackage.getEClass(), null, "type", null, 0, 1, SketchDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(sketchNodeEClass, SketchNode.class, "SketchNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSketchNode_Nodes(), this.getSketchNode(), null, "nodes", null, 0, -1, SketchNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSketchNode_ReferencedNodes(), this.getSketchNode(), null,
				"referencedNodes", null, 0, -1, SketchNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSketchNode_Compartments(), this.getSketchCompartment(), null,
				"compartments", null, 0, -1, SketchNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSketchNode_Labels(), this.getSketchLabel(), null, "labels", null, 0, -1, SketchNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSketchNode_Type(), theEcorePackage.getEClass(), null, "type", null, 0, 1, SketchNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSketchNode_Attributes(), theEcorePackage.getEAttribute(), null,
				"attributes", null, 0, -1, SketchNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSketchNode_OnBorder(), theEcorePackage.getEBoolean(), "onBorder", null, 0, 1, SketchNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(sketchCompartmentEClass, SketchCompartment.class, "SketchCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSketchCompartment_Nodes(), this.getSketchNode(), null,
				"nodes", null, 0, -1, SketchCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSketchCompartment_ReferencedNodes(), this.getSketchNode(), null,
				"referencedNodes", null, 0, -1, SketchCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(sketchLinkEClass, SketchLink.class, "SketchLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSketchLink_Source(), this.getSketchNode(), null, "source", null, 1, 1, SketchLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSketchLink_Target(), this.getSketchNode(), null, "target", null, 1, 1, SketchLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSketchLink_Labels(), this.getSketchLabel(), null, "labels", null, 0, -1, SketchLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSketchLink_Type(), theEcorePackage.getEClass(), null, "type", null, 0, 1, SketchLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(sketchLabelEClass, SketchLabel.class, "SketchLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSketchLabel_Attributes(), theEcorePackage.getEAttribute(), null,
				"attributes", null, 0, -1, SketchLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSketchLabel_External(), theEcorePackage.getEBoolean(), "external", null, 0, 1, SketchLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //SketchPackageImpl
