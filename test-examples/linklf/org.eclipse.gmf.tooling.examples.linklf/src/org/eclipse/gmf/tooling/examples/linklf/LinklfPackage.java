/**
 */
package org.eclipse.gmf.tooling.examples.linklf;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.linklf.LinklfFactory
 * @model kind="package"
 * @generated
 */
public interface LinklfPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "linklf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://linklf.gmf.eclipse.org";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "linklf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LinklfPackage eINSTANCE = org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.CanvasElementImpl <em>Canvas Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.CanvasElementImpl
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getCanvasElement()
	 * @generated
	 */
	int CANVAS_ELEMENT = 10;

	/**
	 * The number of structural features of the '<em>Canvas Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Canvas Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.CanvasElementContainerImpl <em>Canvas Element Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.CanvasElementContainerImpl
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getCanvasElementContainer()
	 * @generated
	 */
	int CANVAS_ELEMENT_CONTAINER = 6;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_ELEMENT_CONTAINER__ELEMENTS = CANVAS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Canvas Element Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_ELEMENT_CONTAINER_FEATURE_COUNT = CANVAS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Canvas Element Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_ELEMENT_CONTAINER_OPERATION_COUNT = CANVAS_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.CanvasImpl <em>Canvas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.CanvasImpl
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getCanvas()
	 * @generated
	 */
	int CANVAS = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS__ELEMENTS = CANVAS_ELEMENT_CONTAINER__ELEMENTS;

	/**
	 * The number of structural features of the '<em>Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_FEATURE_COUNT = CANVAS_ELEMENT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_OPERATION_COUNT = CANVAS_ELEMENT_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.ContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.ContainerImpl
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__ELEMENTS = CANVAS_ELEMENT_CONTAINER__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__NAME = CANVAS_ELEMENT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Porst</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__PORST = CANVAS_ELEMENT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = CANVAS_ELEMENT_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_OPERATION_COUNT = CANVAS_ELEMENT_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklf.Node <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklf.Node
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = CANVAS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = CANVAS_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.RectangleImpl <em>Rectangle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.RectangleImpl
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 3;

	/**
	 * The number of structural features of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.CircleImpl <em>Circle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.CircleImpl
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getCircle()
	 * @generated
	 */
	int CIRCLE = 4;

	/**
	 * The number of structural features of the '<em>Circle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCLE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Circle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCLE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.RhombusImpl <em>Rhombus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.RhombusImpl
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getRhombus()
	 * @generated
	 */
	int RHOMBUS = 5;

	/**
	 * The number of structural features of the '<em>Rhombus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHOMBUS_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Rhombus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHOMBUS_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinkImpl
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 7;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SOURCE = CANVAS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TARGET = CANVAS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = CANVAS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_OPERATION_COUNT = CANVAS_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.LabeledLinkImpl <em>Labeled Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LabeledLinkImpl
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getLabeledLink()
	 * @generated
	 */
	int LABELED_LINK = 8;

	/**
	 * The feature id for the '<em><b>Source Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK__SOURCE_NAME = CANVAS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Link Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK__LINK_NAME = CANVAS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK__TARGET_NAME = CANVAS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK__SOURCE = CANVAS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK__TARGET = CANVAS_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Labeled Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK_FEATURE_COUNT = CANVAS_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Labeled Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK_OPERATION_COUNT = CANVAS_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.PortImpl
	 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 9;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklf.Canvas <em>Canvas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Canvas</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Canvas
	 * @generated
	 */
	EClass getCanvas();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklf.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.linklf.Container#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Container#getName()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.linklf.Container#getPorst <em>Porst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Porst</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Container#getPorst()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Porst();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklf.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklf.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangle</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Rectangle
	 * @generated
	 */
	EClass getRectangle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklf.Circle <em>Circle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Circle</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Circle
	 * @generated
	 */
	EClass getCircle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklf.Rhombus <em>Rhombus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rhombus</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Rhombus
	 * @generated
	 */
	EClass getRhombus();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklf.CanvasElementContainer <em>Canvas Element Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Canvas Element Container</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.CanvasElementContainer
	 * @generated
	 */
	EClass getCanvasElementContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.linklf.CanvasElementContainer#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.CanvasElementContainer#getElements()
	 * @see #getCanvasElementContainer()
	 * @generated
	 */
	EReference getCanvasElementContainer_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklf.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.linklf.Link#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Link#getSource()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.linklf.Link#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Link#getTarget()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklf.LabeledLink <em>Labeled Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Labeled Link</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.LabeledLink
	 * @generated
	 */
	EClass getLabeledLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.linklf.LabeledLink#getSourceName <em>Source Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.LabeledLink#getSourceName()
	 * @see #getLabeledLink()
	 * @generated
	 */
	EAttribute getLabeledLink_SourceName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.linklf.LabeledLink#getLinkName <em>Link Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.LabeledLink#getLinkName()
	 * @see #getLabeledLink()
	 * @generated
	 */
	EAttribute getLabeledLink_LinkName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.linklf.LabeledLink#getTargetName <em>Target Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.LabeledLink#getTargetName()
	 * @see #getLabeledLink()
	 * @generated
	 */
	EAttribute getLabeledLink_TargetName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.linklf.LabeledLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.LabeledLink#getSource()
	 * @see #getLabeledLink()
	 * @generated
	 */
	EReference getLabeledLink_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.linklf.LabeledLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.LabeledLink#getTarget()
	 * @see #getLabeledLink()
	 * @generated
	 */
	EReference getLabeledLink_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklf.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklf.CanvasElement <em>Canvas Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Canvas Element</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklf.CanvasElement
	 * @generated
	 */
	EClass getCanvasElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LinklfFactory getLinklfFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.CanvasImpl <em>Canvas</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.CanvasImpl
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getCanvas()
		 * @generated
		 */
		EClass CANVAS = eINSTANCE.getCanvas();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.ContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.ContainerImpl
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__NAME = eINSTANCE.getContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Porst</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__PORST = eINSTANCE.getContainer_Porst();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklf.Node <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklf.Node
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.RectangleImpl <em>Rectangle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.RectangleImpl
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getRectangle()
		 * @generated
		 */
		EClass RECTANGLE = eINSTANCE.getRectangle();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.CircleImpl <em>Circle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.CircleImpl
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getCircle()
		 * @generated
		 */
		EClass CIRCLE = eINSTANCE.getCircle();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.RhombusImpl <em>Rhombus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.RhombusImpl
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getRhombus()
		 * @generated
		 */
		EClass RHOMBUS = eINSTANCE.getRhombus();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.CanvasElementContainerImpl <em>Canvas Element Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.CanvasElementContainerImpl
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getCanvasElementContainer()
		 * @generated
		 */
		EClass CANVAS_ELEMENT_CONTAINER = eINSTANCE.getCanvasElementContainer();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CANVAS_ELEMENT_CONTAINER__ELEMENTS = eINSTANCE.getCanvasElementContainer_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinkImpl
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__SOURCE = eINSTANCE.getLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__TARGET = eINSTANCE.getLink_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.LabeledLinkImpl <em>Labeled Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LabeledLinkImpl
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getLabeledLink()
		 * @generated
		 */
		EClass LABELED_LINK = eINSTANCE.getLabeledLink();

		/**
		 * The meta object literal for the '<em><b>Source Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABELED_LINK__SOURCE_NAME = eINSTANCE.getLabeledLink_SourceName();

		/**
		 * The meta object literal for the '<em><b>Link Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABELED_LINK__LINK_NAME = eINSTANCE.getLabeledLink_LinkName();

		/**
		 * The meta object literal for the '<em><b>Target Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABELED_LINK__TARGET_NAME = eINSTANCE.getLabeledLink_TargetName();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABELED_LINK__SOURCE = eINSTANCE.getLabeledLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABELED_LINK__TARGET = eINSTANCE.getLabeledLink_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.PortImpl
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklf.impl.CanvasElementImpl <em>Canvas Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.CanvasElementImpl
		 * @see org.eclipse.gmf.tooling.examples.linklf.impl.LinklfPackageImpl#getCanvasElement()
		 * @generated
		 */
		EClass CANVAS_ELEMENT = eINSTANCE.getCanvasElement();

	}

} //LinklfPackage
