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
package org.eclipse.gmf.sketch;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.sketch.SketchFactory
 * @model kind="package"
 * @generated
 */
public interface SketchPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sketch"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/gmf/2007/sketch"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sketch"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SketchPackage eINSTANCE = org.eclipse.gmf.sketch.impl.SketchPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.sketch.impl.SketchElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.sketch.impl.SketchElementImpl
	 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchElement()
	 * @generated
	 */
	int SKETCH_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_ELEMENT__EANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.sketch.impl.SketchDiagramElementImpl <em>Diagram Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.sketch.impl.SketchDiagramElementImpl
	 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchDiagramElement()
	 * @generated
	 */
	int SKETCH_DIAGRAM_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM_ELEMENT__EANNOTATIONS = SKETCH_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM_ELEMENT__NAME = SKETCH_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM_ELEMENT__SHAPE = SKETCH_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM_ELEMENT__VISUAL_ID = SKETCH_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Diagram Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT = SKETCH_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.sketch.impl.SketchDiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.sketch.impl.SketchDiagramImpl
	 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchDiagram()
	 * @generated
	 */
	int SKETCH_DIAGRAM = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM__EANNOTATIONS = SKETCH_DIAGRAM_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM__NAME = SKETCH_DIAGRAM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM__SHAPE = SKETCH_DIAGRAM_ELEMENT__SHAPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM__VISUAL_ID = SKETCH_DIAGRAM_ELEMENT__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM__NODES = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM__LINKS = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM__TYPE = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_DIAGRAM_FEATURE_COUNT = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.sketch.impl.SketchNodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.sketch.impl.SketchNodeImpl
	 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchNode()
	 * @generated
	 */
	int SKETCH_NODE = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE__EANNOTATIONS = SKETCH_DIAGRAM_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE__NAME = SKETCH_DIAGRAM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE__SHAPE = SKETCH_DIAGRAM_ELEMENT__SHAPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE__VISUAL_ID = SKETCH_DIAGRAM_ELEMENT__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE__NODES = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE__REFERENCED_NODES = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Compartments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE__COMPARTMENTS = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE__LABELS = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE__TYPE = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE__ATTRIBUTES = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>On Border</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE__ON_BORDER = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_NODE_FEATURE_COUNT = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.sketch.impl.SketchCompartmentImpl <em>Compartment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.sketch.impl.SketchCompartmentImpl
	 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchCompartment()
	 * @generated
	 */
	int SKETCH_COMPARTMENT = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_COMPARTMENT__EANNOTATIONS = SKETCH_DIAGRAM_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_COMPARTMENT__NAME = SKETCH_DIAGRAM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_COMPARTMENT__SHAPE = SKETCH_DIAGRAM_ELEMENT__SHAPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_COMPARTMENT__VISUAL_ID = SKETCH_DIAGRAM_ELEMENT__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_COMPARTMENT__NODES = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_COMPARTMENT__REFERENCED_NODES = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Compartment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_COMPARTMENT_FEATURE_COUNT = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.sketch.impl.SketchLinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.sketch.impl.SketchLinkImpl
	 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchLink()
	 * @generated
	 */
	int SKETCH_LINK = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LINK__EANNOTATIONS = SKETCH_DIAGRAM_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LINK__NAME = SKETCH_DIAGRAM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LINK__SHAPE = SKETCH_DIAGRAM_ELEMENT__SHAPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LINK__VISUAL_ID = SKETCH_DIAGRAM_ELEMENT__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LINK__SOURCE = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LINK__TARGET = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LINK__LABELS = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LINK__TYPE = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LINK_FEATURE_COUNT = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.sketch.impl.SketchLabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.sketch.impl.SketchLabelImpl
	 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchLabel()
	 * @generated
	 */
	int SKETCH_LABEL = 6;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LABEL__EANNOTATIONS = SKETCH_DIAGRAM_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LABEL__NAME = SKETCH_DIAGRAM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LABEL__SHAPE = SKETCH_DIAGRAM_ELEMENT__SHAPE;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LABEL__VISUAL_ID = SKETCH_DIAGRAM_ELEMENT__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LABEL__ATTRIBUTES = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LABEL__EXTERNAL = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKETCH_LABEL_FEATURE_COUNT = SKETCH_DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.sketch.SketchElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.gmf.sketch.SketchElement
	 * @generated
	 */
	EClass getSketchElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.sketch.SketchElement#getEAnnotations <em>EAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EAnnotations</em>'.
	 * @see org.eclipse.gmf.sketch.SketchElement#getEAnnotations()
	 * @see #getSketchElement()
	 * @generated
	 */
	EReference getSketchElement_EAnnotations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.sketch.SketchDiagramElement <em>Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Element</em>'.
	 * @see org.eclipse.gmf.sketch.SketchDiagramElement
	 * @generated
	 */
	EClass getSketchDiagramElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.sketch.SketchDiagramElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.sketch.SketchDiagramElement#getName()
	 * @see #getSketchDiagramElement()
	 * @generated
	 */
	EAttribute getSketchDiagramElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.sketch.SketchDiagramElement#getShape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shape</em>'.
	 * @see org.eclipse.gmf.sketch.SketchDiagramElement#getShape()
	 * @see #getSketchDiagramElement()
	 * @generated
	 */
	EAttribute getSketchDiagramElement_Shape();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.sketch.SketchDiagramElement#getVisualID <em>Visual ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visual ID</em>'.
	 * @see org.eclipse.gmf.sketch.SketchDiagramElement#getVisualID()
	 * @see #getSketchDiagramElement()
	 * @generated
	 */
	EAttribute getSketchDiagramElement_VisualID();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.sketch.SketchDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see org.eclipse.gmf.sketch.SketchDiagram
	 * @generated
	 */
	EClass getSketchDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.sketch.SketchDiagram#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipse.gmf.sketch.SketchDiagram#getNodes()
	 * @see #getSketchDiagram()
	 * @generated
	 */
	EReference getSketchDiagram_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.sketch.SketchDiagram#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.eclipse.gmf.sketch.SketchDiagram#getLinks()
	 * @see #getSketchDiagram()
	 * @generated
	 */
	EReference getSketchDiagram_Links();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.sketch.SketchDiagram#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.gmf.sketch.SketchDiagram#getType()
	 * @see #getSketchDiagram()
	 * @generated
	 */
	EReference getSketchDiagram_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.sketch.SketchNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.gmf.sketch.SketchNode
	 * @generated
	 */
	EClass getSketchNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.sketch.SketchNode#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipse.gmf.sketch.SketchNode#getNodes()
	 * @see #getSketchNode()
	 * @generated
	 */
	EReference getSketchNode_Nodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.sketch.SketchNode#getReferencedNodes <em>Referenced Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Nodes</em>'.
	 * @see org.eclipse.gmf.sketch.SketchNode#getReferencedNodes()
	 * @see #getSketchNode()
	 * @generated
	 */
	EReference getSketchNode_ReferencedNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.sketch.SketchNode#getCompartments <em>Compartments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compartments</em>'.
	 * @see org.eclipse.gmf.sketch.SketchNode#getCompartments()
	 * @see #getSketchNode()
	 * @generated
	 */
	EReference getSketchNode_Compartments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.sketch.SketchNode#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see org.eclipse.gmf.sketch.SketchNode#getLabels()
	 * @see #getSketchNode()
	 * @generated
	 */
	EReference getSketchNode_Labels();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.sketch.SketchNode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.gmf.sketch.SketchNode#getType()
	 * @see #getSketchNode()
	 * @generated
	 */
	EReference getSketchNode_Type();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.sketch.SketchNode#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see org.eclipse.gmf.sketch.SketchNode#getAttributes()
	 * @see #getSketchNode()
	 * @generated
	 */
	EReference getSketchNode_Attributes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.sketch.SketchNode#isOnBorder <em>On Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>On Border</em>'.
	 * @see org.eclipse.gmf.sketch.SketchNode#isOnBorder()
	 * @see #getSketchNode()
	 * @generated
	 */
	EAttribute getSketchNode_OnBorder();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.sketch.SketchCompartment <em>Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compartment</em>'.
	 * @see org.eclipse.gmf.sketch.SketchCompartment
	 * @generated
	 */
	EClass getSketchCompartment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.sketch.SketchCompartment#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipse.gmf.sketch.SketchCompartment#getNodes()
	 * @see #getSketchCompartment()
	 * @generated
	 */
	EReference getSketchCompartment_Nodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.sketch.SketchCompartment#getReferencedNodes <em>Referenced Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Nodes</em>'.
	 * @see org.eclipse.gmf.sketch.SketchCompartment#getReferencedNodes()
	 * @see #getSketchCompartment()
	 * @generated
	 */
	EReference getSketchCompartment_ReferencedNodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.sketch.SketchLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.eclipse.gmf.sketch.SketchLink
	 * @generated
	 */
	EClass getSketchLink();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.sketch.SketchLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.gmf.sketch.SketchLink#getSource()
	 * @see #getSketchLink()
	 * @generated
	 */
	EReference getSketchLink_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.sketch.SketchLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.gmf.sketch.SketchLink#getTarget()
	 * @see #getSketchLink()
	 * @generated
	 */
	EReference getSketchLink_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.sketch.SketchLink#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see org.eclipse.gmf.sketch.SketchLink#getLabels()
	 * @see #getSketchLink()
	 * @generated
	 */
	EReference getSketchLink_Labels();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.sketch.SketchLink#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.gmf.sketch.SketchLink#getType()
	 * @see #getSketchLink()
	 * @generated
	 */
	EReference getSketchLink_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.sketch.SketchLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see org.eclipse.gmf.sketch.SketchLabel
	 * @generated
	 */
	EClass getSketchLabel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.sketch.SketchLabel#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see org.eclipse.gmf.sketch.SketchLabel#getAttributes()
	 * @see #getSketchLabel()
	 * @generated
	 */
	EReference getSketchLabel_Attributes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.sketch.SketchLabel#isExternal <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External</em>'.
	 * @see org.eclipse.gmf.sketch.SketchLabel#isExternal()
	 * @see #getSketchLabel()
	 * @generated
	 */
	EAttribute getSketchLabel_External();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SketchFactory getSketchFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.sketch.impl.SketchElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.sketch.impl.SketchElementImpl
		 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchElement()
		 * @generated
		 */
		EClass SKETCH_ELEMENT = eINSTANCE.getSketchElement();

		/**
		 * The meta object literal for the '<em><b>EAnnotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_ELEMENT__EANNOTATIONS = eINSTANCE.getSketchElement_EAnnotations();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.sketch.impl.SketchDiagramElementImpl <em>Diagram Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.sketch.impl.SketchDiagramElementImpl
		 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchDiagramElement()
		 * @generated
		 */
		EClass SKETCH_DIAGRAM_ELEMENT = eINSTANCE.getSketchDiagramElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SKETCH_DIAGRAM_ELEMENT__NAME = eINSTANCE.getSketchDiagramElement_Name();

		/**
		 * The meta object literal for the '<em><b>Shape</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SKETCH_DIAGRAM_ELEMENT__SHAPE = eINSTANCE.getSketchDiagramElement_Shape();

		/**
		 * The meta object literal for the '<em><b>Visual ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SKETCH_DIAGRAM_ELEMENT__VISUAL_ID = eINSTANCE.getSketchDiagramElement_VisualID();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.sketch.impl.SketchDiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.sketch.impl.SketchDiagramImpl
		 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchDiagram()
		 * @generated
		 */
		EClass SKETCH_DIAGRAM = eINSTANCE.getSketchDiagram();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_DIAGRAM__NODES = eINSTANCE.getSketchDiagram_Nodes();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_DIAGRAM__LINKS = eINSTANCE.getSketchDiagram_Links();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_DIAGRAM__TYPE = eINSTANCE.getSketchDiagram_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.sketch.impl.SketchNodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.sketch.impl.SketchNodeImpl
		 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchNode()
		 * @generated
		 */
		EClass SKETCH_NODE = eINSTANCE.getSketchNode();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_NODE__NODES = eINSTANCE.getSketchNode_Nodes();

		/**
		 * The meta object literal for the '<em><b>Referenced Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_NODE__REFERENCED_NODES = eINSTANCE.getSketchNode_ReferencedNodes();

		/**
		 * The meta object literal for the '<em><b>Compartments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_NODE__COMPARTMENTS = eINSTANCE.getSketchNode_Compartments();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_NODE__LABELS = eINSTANCE.getSketchNode_Labels();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_NODE__TYPE = eINSTANCE.getSketchNode_Type();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_NODE__ATTRIBUTES = eINSTANCE.getSketchNode_Attributes();

		/**
		 * The meta object literal for the '<em><b>On Border</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SKETCH_NODE__ON_BORDER = eINSTANCE.getSketchNode_OnBorder();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.sketch.impl.SketchCompartmentImpl <em>Compartment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.sketch.impl.SketchCompartmentImpl
		 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchCompartment()
		 * @generated
		 */
		EClass SKETCH_COMPARTMENT = eINSTANCE.getSketchCompartment();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_COMPARTMENT__NODES = eINSTANCE.getSketchCompartment_Nodes();

		/**
		 * The meta object literal for the '<em><b>Referenced Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_COMPARTMENT__REFERENCED_NODES = eINSTANCE.getSketchCompartment_ReferencedNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.sketch.impl.SketchLinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.sketch.impl.SketchLinkImpl
		 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchLink()
		 * @generated
		 */
		EClass SKETCH_LINK = eINSTANCE.getSketchLink();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_LINK__SOURCE = eINSTANCE.getSketchLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_LINK__TARGET = eINSTANCE.getSketchLink_Target();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_LINK__LABELS = eINSTANCE.getSketchLink_Labels();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_LINK__TYPE = eINSTANCE.getSketchLink_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.sketch.impl.SketchLabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.sketch.impl.SketchLabelImpl
		 * @see org.eclipse.gmf.sketch.impl.SketchPackageImpl#getSketchLabel()
		 * @generated
		 */
		EClass SKETCH_LABEL = eINSTANCE.getSketchLabel();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKETCH_LABEL__ATTRIBUTES = eINSTANCE.getSketchLabel_Attributes();

		/**
		 * The meta object literal for the '<em><b>External</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SKETCH_LABEL__EXTERNAL = eINSTANCE.getSketchLabel_External();

	}

} //SketchPackage
