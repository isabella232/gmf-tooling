/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.diadef;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.gmf.diadef.DiagramDefinitionFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramDefinitionPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diadef";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/gmf/2005/DiagramDefinition";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "diadef";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramDefinitionPackage eINSTANCE = org.eclipse.gmf.diadef.impl.DiagramDefinitionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.diadef.impl.IdentityImpl <em>Identity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.diadef.impl.IdentityImpl
	 * @see org.eclipse.gmf.diadef.impl.DiagramDefinitionPackageImpl#getIdentity()
	 * @generated
	 */
	int IDENTITY = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY__NAME = 0;

	/**
	 * The number of structural features of the the '<em>Identity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.diadef.impl.CommonBaseImpl <em>Common Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.diadef.impl.CommonBaseImpl
	 * @see org.eclipse.gmf.diadef.impl.DiagramDefinitionPackageImpl#getCommonBase()
	 * @generated
	 */
	int COMMON_BASE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_BASE__NAME = IDENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_BASE__PROPERTIES = IDENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Common Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_BASE_FEATURE_COUNT = IDENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.diadef.impl.DiagramElementImpl <em>Diagram Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.diadef.impl.DiagramElementImpl
	 * @see org.eclipse.gmf.diadef.impl.DiagramDefinitionPackageImpl#getDiagramElement()
	 * @generated
	 */
	int DIAGRAM_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__NAME = COMMON_BASE__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__PROPERTIES = COMMON_BASE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Needs Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__NEEDS_TOOL = COMMON_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tool Group ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__TOOL_GROUP_ID = COMMON_BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Small Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__SMALL_ICON_PATH = COMMON_BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Large Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__LARGE_ICON_PATH = COMMON_BASE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the the '<em>Diagram Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT_FEATURE_COUNT = COMMON_BASE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.diadef.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.diadef.impl.NodeImpl
	 * @see org.eclipse.gmf.diadef.impl.DiagramDefinitionPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = DIAGRAM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PROPERTIES = DIAGRAM_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Needs Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NEEDS_TOOL = DIAGRAM_ELEMENT__NEEDS_TOOL;

	/**
	 * The feature id for the '<em><b>Tool Group ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TOOL_GROUP_ID = DIAGRAM_ELEMENT__TOOL_GROUP_ID;

	/**
	 * The feature id for the '<em><b>Small Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SMALL_ICON_PATH = DIAGRAM_ELEMENT__SMALL_ICON_PATH;

	/**
	 * The feature id for the '<em><b>Large Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__LARGE_ICON_PATH = DIAGRAM_ELEMENT__LARGE_ICON_PATH;

	/**
	 * The feature id for the '<em><b>Max Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__MAX_WIDTH = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__MAX_HEIGHT = DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DEFAULT_WIDTH = DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DEFAULT_HEIGHT = DIAGRAM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Compartments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__COMPARTMENTS = DIAGRAM_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.diadef.impl.CompartmentImpl <em>Compartment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.diadef.impl.CompartmentImpl
	 * @see org.eclipse.gmf.diadef.impl.DiagramDefinitionPackageImpl#getCompartment()
	 * @generated
	 */
	int COMPARTMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT__NAME = IDENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Collapsible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT__COLLAPSIBLE = IDENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Needs Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT__NEEDS_TITLE = IDENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Compartment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_FEATURE_COUNT = IDENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.diadef.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.diadef.impl.ConnectionImpl
	 * @see org.eclipse.gmf.diadef.impl.DiagramDefinitionPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__NAME = DIAGRAM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__PROPERTIES = DIAGRAM_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Needs Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__NEEDS_TOOL = DIAGRAM_ELEMENT__NEEDS_TOOL;

	/**
	 * The feature id for the '<em><b>Tool Group ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__TOOL_GROUP_ID = DIAGRAM_ELEMENT__TOOL_GROUP_ID;

	/**
	 * The feature id for the '<em><b>Small Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SMALL_ICON_PATH = DIAGRAM_ELEMENT__SMALL_ICON_PATH;

	/**
	 * The feature id for the '<em><b>Large Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__LARGE_ICON_PATH = DIAGRAM_ELEMENT__LARGE_ICON_PATH;

	/**
	 * The feature id for the '<em><b>Line Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__LINE_KIND = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Adornment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SOURCE_ADORNMENT = DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Adornment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__TARGET_ADORNMENT = DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.diadef.impl.CanvasImpl <em>Canvas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.diadef.impl.CanvasImpl
	 * @see org.eclipse.gmf.diadef.impl.DiagramDefinitionPackageImpl#getCanvas()
	 * @generated
	 */
	int CANVAS = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS__NAME = COMMON_BASE__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS__PROPERTIES = COMMON_BASE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS__NODES = COMMON_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS__LINKS = COMMON_BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_FEATURE_COUNT = COMMON_BASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.diadef.impl.RunTimePropertyImpl <em>Run Time Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.diadef.impl.RunTimePropertyImpl
	 * @see org.eclipse.gmf.diadef.impl.DiagramDefinitionPackageImpl#getRunTimeProperty()
	 * @generated
	 */
	int RUN_TIME_PROPERTY = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_TIME_PROPERTY__NAME = IDENTITY__NAME;

	/**
	 * The number of structural features of the the '<em>Run Time Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_TIME_PROPERTY_FEATURE_COUNT = IDENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.diadef.LineKind <em>Line Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.diadef.LineKind
	 * @see org.eclipse.gmf.diadef.impl.DiagramDefinitionPackageImpl#getLineKind()
	 * @generated
	 */
	int LINE_KIND = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.diadef.AdornmentKind <em>Adornment Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.diadef.AdornmentKind
	 * @see org.eclipse.gmf.diadef.impl.DiagramDefinitionPackageImpl#getAdornmentKind()
	 * @generated
	 */
	int ADORNMENT_KIND = 9;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.diadef.DiagramElement <em>Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Element</em>'.
	 * @see org.eclipse.gmf.diadef.DiagramElement
	 * @generated
	 */
	EClass getDiagramElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.DiagramElement#isNeedsTool <em>Needs Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Needs Tool</em>'.
	 * @see org.eclipse.gmf.diadef.DiagramElement#isNeedsTool()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_NeedsTool();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.DiagramElement#getToolGroupID <em>Tool Group ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tool Group ID</em>'.
	 * @see org.eclipse.gmf.diadef.DiagramElement#getToolGroupID()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_ToolGroupID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.DiagramElement#getSmallIconPath <em>Small Icon Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Small Icon Path</em>'.
	 * @see org.eclipse.gmf.diadef.DiagramElement#getSmallIconPath()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_SmallIconPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.DiagramElement#getLargeIconPath <em>Large Icon Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Large Icon Path</em>'.
	 * @see org.eclipse.gmf.diadef.DiagramElement#getLargeIconPath()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_LargeIconPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.diadef.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.gmf.diadef.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.Node#getMaxWidth <em>Max Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Width</em>'.
	 * @see org.eclipse.gmf.diadef.Node#getMaxWidth()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_MaxWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.Node#getMaxHeight <em>Max Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Height</em>'.
	 * @see org.eclipse.gmf.diadef.Node#getMaxHeight()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_MaxHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.Node#getDefaultWidth <em>Default Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Width</em>'.
	 * @see org.eclipse.gmf.diadef.Node#getDefaultWidth()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_DefaultWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.Node#getDefaultHeight <em>Default Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Height</em>'.
	 * @see org.eclipse.gmf.diadef.Node#getDefaultHeight()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_DefaultHeight();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.diadef.Node#getCompartments <em>Compartments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compartments</em>'.
	 * @see org.eclipse.gmf.diadef.Node#getCompartments()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Compartments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.diadef.Compartment <em>Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compartment</em>'.
	 * @see org.eclipse.gmf.diadef.Compartment
	 * @generated
	 */
	EClass getCompartment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.Compartment#isCollapsible <em>Collapsible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collapsible</em>'.
	 * @see org.eclipse.gmf.diadef.Compartment#isCollapsible()
	 * @see #getCompartment()
	 * @generated
	 */
	EAttribute getCompartment_Collapsible();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.Compartment#isNeedsTitle <em>Needs Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Needs Title</em>'.
	 * @see org.eclipse.gmf.diadef.Compartment#isNeedsTitle()
	 * @see #getCompartment()
	 * @generated
	 */
	EAttribute getCompartment_NeedsTitle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.diadef.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.eclipse.gmf.diadef.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.Connection#getLineKind <em>Line Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Kind</em>'.
	 * @see org.eclipse.gmf.diadef.Connection#getLineKind()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_LineKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.Connection#getSourceAdornment <em>Source Adornment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Adornment</em>'.
	 * @see org.eclipse.gmf.diadef.Connection#getSourceAdornment()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_SourceAdornment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.Connection#getTargetAdornment <em>Target Adornment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Adornment</em>'.
	 * @see org.eclipse.gmf.diadef.Connection#getTargetAdornment()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_TargetAdornment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.diadef.Canvas <em>Canvas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Canvas</em>'.
	 * @see org.eclipse.gmf.diadef.Canvas
	 * @generated
	 */
	EClass getCanvas();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.diadef.Canvas#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipse.gmf.diadef.Canvas#getNodes()
	 * @see #getCanvas()
	 * @generated
	 */
	EReference getCanvas_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.diadef.Canvas#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.eclipse.gmf.diadef.Canvas#getLinks()
	 * @see #getCanvas()
	 * @generated
	 */
	EReference getCanvas_Links();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.diadef.RunTimeProperty <em>Run Time Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Time Property</em>'.
	 * @see org.eclipse.gmf.diadef.RunTimeProperty
	 * @generated
	 */
	EClass getRunTimeProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.diadef.Identity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identity</em>'.
	 * @see org.eclipse.gmf.diadef.Identity
	 * @generated
	 */
	EClass getIdentity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.diadef.Identity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.diadef.Identity#getName()
	 * @see #getIdentity()
	 * @generated
	 */
	EAttribute getIdentity_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.diadef.CommonBase <em>Common Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Common Base</em>'.
	 * @see org.eclipse.gmf.diadef.CommonBase
	 * @generated
	 */
	EClass getCommonBase();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.diadef.CommonBase#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.gmf.diadef.CommonBase#getProperties()
	 * @see #getCommonBase()
	 * @generated
	 */
	EReference getCommonBase_Properties();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.gmf.diadef.LineKind <em>Line Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Line Kind</em>'.
	 * @see org.eclipse.gmf.diadef.LineKind
	 * @generated
	 */
	EEnum getLineKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.gmf.diadef.AdornmentKind <em>Adornment Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Adornment Kind</em>'.
	 * @see org.eclipse.gmf.diadef.AdornmentKind
	 * @generated
	 */
	EEnum getAdornmentKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramDefinitionFactory getDiagramDefinitionFactory();

} //DiagramDefinitionPackage
