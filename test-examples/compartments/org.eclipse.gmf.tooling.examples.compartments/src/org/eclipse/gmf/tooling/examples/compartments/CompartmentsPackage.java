/**
 */
package org.eclipse.gmf.tooling.examples.compartments;

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
 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsFactory
 * @model kind="package"
 * @generated
 */
public interface CompartmentsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "compartments";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.gmf.tooling.examples.compartments";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "compartments";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompartmentsPackage eINSTANCE = org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.CanvasImpl <em>Canvas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CanvasImpl
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getCanvas()
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
	int CANVAS__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeImpl <em>Top Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeImpl
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getTopNode()
	 * @generated
	 */
	int TOP_NODE = 5;

	/**
	 * The number of structural features of the '<em>Top Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Top Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeAImpl <em>Top Node A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeAImpl
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getTopNodeA()
	 * @generated
	 */
	int TOP_NODE_A = 1;

	/**
	 * The feature id for the '<em><b>Children C</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_A__CHILDREN_C = TOP_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_A__NAME = TOP_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Children D</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_A__CHILDREN_D = TOP_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Top Node A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_A_FEATURE_COUNT = TOP_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Top Node A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_A_OPERATION_COUNT = TOP_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeBImpl <em>Top Node B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeBImpl
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getTopNodeB()
	 * @generated
	 */
	int TOP_NODE_B = 2;

	/**
	 * The feature id for the '<em><b>Children E</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_B__CHILDREN_E = TOP_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Children G</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_B__CHILDREN_G = TOP_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_B__NAME = TOP_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Children F</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_B__CHILDREN_F = TOP_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Top Node B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_B_FEATURE_COUNT = TOP_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Top Node B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_NODE_B_OPERATION_COUNT = TOP_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_EImpl <em>Child Of BE</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_EImpl
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfB_E()
	 * @generated
	 */
	int CHILD_OF_BE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BE__NAME = 0;

	/**
	 * The feature id for the '<em><b>CNode Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BE__CNODE_RELATION = 1;

	/**
	 * The number of structural features of the '<em>Child Of BE</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Child Of BE</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_GImpl <em>Child Of BG</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_GImpl
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfB_G()
	 * @generated
	 */
	int CHILD_OF_BG = 4;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BG__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Children Of Affixed</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BG__CHILDREN_OF_AFFIXED = 1;

	/**
	 * The number of structural features of the '<em>Child Of BG</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BG_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Child Of BG</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfA_CImpl <em>Child Of AC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfA_CImpl
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfA_C()
	 * @generated
	 */
	int CHILD_OF_AC = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_AC__NAME = 0;

	/**
	 * The number of structural features of the '<em>Child Of AC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_AC_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Child Of AC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_AC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_FImpl <em>Child Of BF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_FImpl
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfB_F()
	 * @generated
	 */
	int CHILD_OF_BF = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BF__NAME = 0;

	/**
	 * The feature id for the '<em><b>DNode Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BF__DNODE_RELATION = 1;

	/**
	 * The number of structural features of the '<em>Child Of BF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BF_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Child Of BF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_BF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfAffixedImpl <em>Child Of Affixed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfAffixedImpl
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfAffixed()
	 * @generated
	 */
	int CHILD_OF_AFFIXED = 8;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_AFFIXED__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Child Of Affixed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_AFFIXED_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Child Of Affixed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_AFFIXED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfA_DImpl <em>Child Of AD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfA_DImpl
	 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfA_D()
	 * @generated
	 */
	int CHILD_OF_AD = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_AD__NAME = 0;

	/**
	 * The number of structural features of the '<em>Child Of AD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_AD_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Child Of AD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_OF_AD_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.compartments.Canvas <em>Canvas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Canvas</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.Canvas
	 * @generated
	 */
	EClass getCanvas();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.compartments.Canvas#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.Canvas#getElements()
	 * @see #getCanvas()
	 * @generated
	 */
	EReference getCanvas_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeA <em>Top Node A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Node A</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.TopNodeA
	 * @generated
	 */
	EClass getTopNodeA();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeA#getChildrenC <em>Children C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children C</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.TopNodeA#getChildrenC()
	 * @see #getTopNodeA()
	 * @generated
	 */
	EReference getTopNodeA_ChildrenC();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeA#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.TopNodeA#getName()
	 * @see #getTopNodeA()
	 * @generated
	 */
	EAttribute getTopNodeA_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeA#getChildrenD <em>Children D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children D</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.TopNodeA#getChildrenD()
	 * @see #getTopNodeA()
	 * @generated
	 */
	EReference getTopNodeA_ChildrenD();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeB <em>Top Node B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Node B</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.TopNodeB
	 * @generated
	 */
	EClass getTopNodeB();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getChildrenE <em>Children E</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children E</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getChildrenE()
	 * @see #getTopNodeB()
	 * @generated
	 */
	EReference getTopNodeB_ChildrenE();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getChildrenG <em>Children G</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children G</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getChildrenG()
	 * @see #getTopNodeB()
	 * @generated
	 */
	EReference getTopNodeB_ChildrenG();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getName()
	 * @see #getTopNodeB()
	 * @generated
	 */
	EAttribute getTopNodeB_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getChildrenF <em>Children F</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children F</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getChildrenF()
	 * @see #getTopNodeB()
	 * @generated
	 */
	EReference getTopNodeB_ChildrenF();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E <em>Child Of BE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Of BE</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E
	 * @generated
	 */
	EClass getChildOfB_E();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E#getName()
	 * @see #getChildOfB_E()
	 * @generated
	 */
	EAttribute getChildOfB_E_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E#getCNodeRelation <em>CNode Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>CNode Relation</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E#getCNodeRelation()
	 * @see #getChildOfB_E()
	 * @generated
	 */
	EReference getChildOfB_E_CNodeRelation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G <em>Child Of BG</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Of BG</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G
	 * @generated
	 */
	EClass getChildOfB_G();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G#getNumber()
	 * @see #getChildOfB_G()
	 * @generated
	 */
	EAttribute getChildOfB_G_Number();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G#getChildrenOfAffixed <em>Children Of Affixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children Of Affixed</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G#getChildrenOfAffixed()
	 * @see #getChildOfB_G()
	 * @generated
	 */
	EReference getChildOfB_G_ChildrenOfAffixed();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.compartments.TopNode <em>Top Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Node</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.TopNode
	 * @generated
	 */
	EClass getTopNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfA_C <em>Child Of AC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Of AC</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfA_C
	 * @generated
	 */
	EClass getChildOfA_C();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfA_C#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfA_C#getName()
	 * @see #getChildOfA_C()
	 * @generated
	 */
	EAttribute getChildOfA_C_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F <em>Child Of BF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Of BF</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F
	 * @generated
	 */
	EClass getChildOfB_F();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F#getName()
	 * @see #getChildOfB_F()
	 * @generated
	 */
	EAttribute getChildOfB_F_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F#getDNodeRelation <em>DNode Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DNode Relation</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F#getDNodeRelation()
	 * @see #getChildOfB_F()
	 * @generated
	 */
	EReference getChildOfB_F_DNodeRelation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfAffixed <em>Child Of Affixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Of Affixed</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfAffixed
	 * @generated
	 */
	EClass getChildOfAffixed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfAffixed#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfAffixed#getDescription()
	 * @see #getChildOfAffixed()
	 * @generated
	 */
	EAttribute getChildOfAffixed_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfA_D <em>Child Of AD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Of AD</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfA_D
	 * @generated
	 */
	EClass getChildOfA_D();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfA_D#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.compartments.ChildOfA_D#getName()
	 * @see #getChildOfA_D()
	 * @generated
	 */
	EAttribute getChildOfA_D_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompartmentsFactory getCompartmentsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.CanvasImpl <em>Canvas</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CanvasImpl
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getCanvas()
		 * @generated
		 */
		EClass CANVAS = eINSTANCE.getCanvas();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CANVAS__ELEMENTS = eINSTANCE.getCanvas_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeAImpl <em>Top Node A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeAImpl
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getTopNodeA()
		 * @generated
		 */
		EClass TOP_NODE_A = eINSTANCE.getTopNodeA();

		/**
		 * The meta object literal for the '<em><b>Children C</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_NODE_A__CHILDREN_C = eINSTANCE.getTopNodeA_ChildrenC();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOP_NODE_A__NAME = eINSTANCE.getTopNodeA_Name();

		/**
		 * The meta object literal for the '<em><b>Children D</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_NODE_A__CHILDREN_D = eINSTANCE.getTopNodeA_ChildrenD();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeBImpl <em>Top Node B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeBImpl
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getTopNodeB()
		 * @generated
		 */
		EClass TOP_NODE_B = eINSTANCE.getTopNodeB();

		/**
		 * The meta object literal for the '<em><b>Children E</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_NODE_B__CHILDREN_E = eINSTANCE.getTopNodeB_ChildrenE();

		/**
		 * The meta object literal for the '<em><b>Children G</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_NODE_B__CHILDREN_G = eINSTANCE.getTopNodeB_ChildrenG();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOP_NODE_B__NAME = eINSTANCE.getTopNodeB_Name();

		/**
		 * The meta object literal for the '<em><b>Children F</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_NODE_B__CHILDREN_F = eINSTANCE.getTopNodeB_ChildrenF();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_EImpl <em>Child Of BE</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_EImpl
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfB_E()
		 * @generated
		 */
		EClass CHILD_OF_BE = eINSTANCE.getChildOfB_E();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHILD_OF_BE__NAME = eINSTANCE.getChildOfB_E_Name();

		/**
		 * The meta object literal for the '<em><b>CNode Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILD_OF_BE__CNODE_RELATION = eINSTANCE.getChildOfB_E_CNodeRelation();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_GImpl <em>Child Of BG</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_GImpl
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfB_G()
		 * @generated
		 */
		EClass CHILD_OF_BG = eINSTANCE.getChildOfB_G();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHILD_OF_BG__NUMBER = eINSTANCE.getChildOfB_G_Number();

		/**
		 * The meta object literal for the '<em><b>Children Of Affixed</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILD_OF_BG__CHILDREN_OF_AFFIXED = eINSTANCE.getChildOfB_G_ChildrenOfAffixed();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeImpl <em>Top Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.TopNodeImpl
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getTopNode()
		 * @generated
		 */
		EClass TOP_NODE = eINSTANCE.getTopNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfA_CImpl <em>Child Of AC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfA_CImpl
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfA_C()
		 * @generated
		 */
		EClass CHILD_OF_AC = eINSTANCE.getChildOfA_C();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHILD_OF_AC__NAME = eINSTANCE.getChildOfA_C_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_FImpl <em>Child Of BF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfB_FImpl
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfB_F()
		 * @generated
		 */
		EClass CHILD_OF_BF = eINSTANCE.getChildOfB_F();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHILD_OF_BF__NAME = eINSTANCE.getChildOfB_F_Name();

		/**
		 * The meta object literal for the '<em><b>DNode Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILD_OF_BF__DNODE_RELATION = eINSTANCE.getChildOfB_F_DNodeRelation();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfAffixedImpl <em>Child Of Affixed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfAffixedImpl
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfAffixed()
		 * @generated
		 */
		EClass CHILD_OF_AFFIXED = eINSTANCE.getChildOfAffixed();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHILD_OF_AFFIXED__DESCRIPTION = eINSTANCE.getChildOfAffixed_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfA_DImpl <em>Child Of AD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.ChildOfA_DImpl
		 * @see org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsPackageImpl#getChildOfA_D()
		 * @generated
		 */
		EClass CHILD_OF_AD = eINSTANCE.getChildOfA_D();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHILD_OF_AD__NAME = eINSTANCE.getChildOfA_D_Name();

	}

} //CompartmentsPackage
