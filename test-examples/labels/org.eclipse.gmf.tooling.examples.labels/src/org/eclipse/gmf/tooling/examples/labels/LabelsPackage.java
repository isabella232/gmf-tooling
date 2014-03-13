/**
 */
package org.eclipse.gmf.tooling.examples.labels;

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
 * @see org.eclipse.gmf.tooling.examples.labels.LabelsFactory
 * @model kind="package"
 * @generated
 */
public interface LabelsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "labels";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://labels/labels/0.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.gmf.tooling.tests.labels";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LabelsPackage eINSTANCE = org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.NamedElementImpl
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl <em>All Labels Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getAllLabelsType()
	 * @generated
	 */
	int ALL_LABELS_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Big Decimal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__BIG_DECIMAL = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Big Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__BIG_INTEGER = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Boolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__BOOLEAN = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Boolean Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__BOOLEAN_OBJECT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Byte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__BYTE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Byte Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__BYTE_OBJECT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Char</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__CHAR = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Character Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__CHARACTER_OBJECT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__DATE = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Double</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__DOUBLE = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Double Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__DOUBLE_OBJECT = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__FLOAT = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Float Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__FLOAT_OBJECT = NAMED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__INT = NAMED_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Integer Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__INTEGER_OBJECT = NAMED_ELEMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Long</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__LONG = NAMED_ELEMENT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Long Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__LONG_OBJECT = NAMED_ELEMENT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Short</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__SHORT = NAMED_ELEMENT_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Short Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__SHORT_OBJECT = NAMED_ELEMENT_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__STRING = NAMED_ELEMENT_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Side</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE__SIDE = NAMED_ELEMENT_FEATURE_COUNT + 20;

	/**
	 * The number of structural features of the '<em>All Labels Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_LABELS_TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 21;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.ChildLabelNodeContainerImpl <em>Child Label Node Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.ChildLabelNodeContainerImpl
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getChildLabelNodeContainer()
	 * @generated
	 */
	int CHILD_LABEL_NODE_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_LABEL_NODE_CONTAINER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Get Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_LABEL_NODE_CONTAINER__GET_CHILDREN = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Child Label Node Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_LABEL_NODE_CONTAINER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.ChildLabelNodeImpl <em>Child Label Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.ChildLabelNodeImpl
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getChildLabelNode()
	 * @generated
	 */
	int CHILD_LABEL_NODE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_LABEL_NODE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Child Label Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_LABEL_NODE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.GenLabelNodeImpl <em>Gen Label Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.GenLabelNodeImpl
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getGenLabelNode()
	 * @generated
	 */
	int GEN_LABEL_NODE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_LABEL_NODE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Gen Label Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_LABEL_NODE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.VerticalLabelImpl <em>Vertical Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.VerticalLabelImpl
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getVerticalLabel()
	 * @generated
	 */
	int VERTICAL_LABEL = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICAL_LABEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Vertical Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICAL_LABEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.DiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.DiagramImpl
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getDiagram()
	 * @generated
	 */
	int DIAGRAM = 6;

	/**
	 * The feature id for the '<em><b>Get Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__GET_LABELS = 0;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.labels.Side <em>Side</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.labels.Side
	 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getSide()
	 * @generated
	 */
	int SIDE = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.labels.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType <em>All Labels Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Labels Type</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType
	 * @generated
	 */
	EClass getAllLabelsType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getBigDecimal <em>Big Decimal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Decimal</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getBigDecimal()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_BigDecimal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getBigInteger <em>Big Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Integer</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getBigInteger()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_BigInteger();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#isBoolean <em>Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#isBoolean()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_Boolean();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getBooleanObject <em>Boolean Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Object</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getBooleanObject()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_BooleanObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getByte <em>Byte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Byte</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getByte()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_Byte();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getByteObject <em>Byte Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Byte Object</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getByteObject()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_ByteObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getChar <em>Char</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Char</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getChar()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_Char();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getCharacterObject <em>Character Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Character Object</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getCharacterObject()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_CharacterObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getDate()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getDouble <em>Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getDouble()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_Double();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getDoubleObject <em>Double Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double Object</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getDoubleObject()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_DoubleObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getFloat <em>Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Float</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getFloat()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_Float();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getFloatObject <em>Float Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Float Object</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getFloatObject()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_FloatObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getInt <em>Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Int</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getInt()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_Int();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getIntegerObject <em>Integer Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Object</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getIntegerObject()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_IntegerObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getLong <em>Long</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getLong()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_Long();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getLongObject <em>Long Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Object</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getLongObject()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_LongObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getShort <em>Short</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getShort()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_Short();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getShortObject <em>Short Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short Object</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getShortObject()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_ShortObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getString()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_String();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getSide <em>Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Side</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.AllLabelsType#getSide()
	 * @see #getAllLabelsType()
	 * @generated
	 */
	EAttribute getAllLabelsType_Side();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.labels.ChildLabelNodeContainer <em>Child Label Node Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Label Node Container</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.ChildLabelNodeContainer
	 * @generated
	 */
	EClass getChildLabelNodeContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.labels.ChildLabelNodeContainer#getGetChildren <em>Get Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Get Children</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.ChildLabelNodeContainer#getGetChildren()
	 * @see #getChildLabelNodeContainer()
	 * @generated
	 */
	EReference getChildLabelNodeContainer_GetChildren();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.labels.ChildLabelNode <em>Child Label Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Label Node</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.ChildLabelNode
	 * @generated
	 */
	EClass getChildLabelNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.labels.GenLabelNode <em>Gen Label Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Label Node</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.GenLabelNode
	 * @generated
	 */
	EClass getGenLabelNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.labels.VerticalLabel <em>Vertical Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertical Label</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.VerticalLabel
	 * @generated
	 */
	EClass getVerticalLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.labels.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.Diagram
	 * @generated
	 */
	EClass getDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.labels.Diagram#getGetLabels <em>Get Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Get Labels</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.Diagram#getGetLabels()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_GetLabels();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.gmf.tooling.examples.labels.Side <em>Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Side</em>'.
	 * @see org.eclipse.gmf.tooling.examples.labels.Side
	 * @generated
	 */
	EEnum getSide();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LabelsFactory getLabelsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.NamedElementImpl
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl <em>All Labels Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getAllLabelsType()
		 * @generated
		 */
		EClass ALL_LABELS_TYPE = eINSTANCE.getAllLabelsType();

		/**
		 * The meta object literal for the '<em><b>Big Decimal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__BIG_DECIMAL = eINSTANCE.getAllLabelsType_BigDecimal();

		/**
		 * The meta object literal for the '<em><b>Big Integer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__BIG_INTEGER = eINSTANCE.getAllLabelsType_BigInteger();

		/**
		 * The meta object literal for the '<em><b>Boolean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__BOOLEAN = eINSTANCE.getAllLabelsType_Boolean();

		/**
		 * The meta object literal for the '<em><b>Boolean Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__BOOLEAN_OBJECT = eINSTANCE.getAllLabelsType_BooleanObject();

		/**
		 * The meta object literal for the '<em><b>Byte</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__BYTE = eINSTANCE.getAllLabelsType_Byte();

		/**
		 * The meta object literal for the '<em><b>Byte Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__BYTE_OBJECT = eINSTANCE.getAllLabelsType_ByteObject();

		/**
		 * The meta object literal for the '<em><b>Char</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__CHAR = eINSTANCE.getAllLabelsType_Char();

		/**
		 * The meta object literal for the '<em><b>Character Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__CHARACTER_OBJECT = eINSTANCE.getAllLabelsType_CharacterObject();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__DATE = eINSTANCE.getAllLabelsType_Date();

		/**
		 * The meta object literal for the '<em><b>Double</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__DOUBLE = eINSTANCE.getAllLabelsType_Double();

		/**
		 * The meta object literal for the '<em><b>Double Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__DOUBLE_OBJECT = eINSTANCE.getAllLabelsType_DoubleObject();

		/**
		 * The meta object literal for the '<em><b>Float</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__FLOAT = eINSTANCE.getAllLabelsType_Float();

		/**
		 * The meta object literal for the '<em><b>Float Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__FLOAT_OBJECT = eINSTANCE.getAllLabelsType_FloatObject();

		/**
		 * The meta object literal for the '<em><b>Int</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__INT = eINSTANCE.getAllLabelsType_Int();

		/**
		 * The meta object literal for the '<em><b>Integer Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__INTEGER_OBJECT = eINSTANCE.getAllLabelsType_IntegerObject();

		/**
		 * The meta object literal for the '<em><b>Long</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__LONG = eINSTANCE.getAllLabelsType_Long();

		/**
		 * The meta object literal for the '<em><b>Long Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__LONG_OBJECT = eINSTANCE.getAllLabelsType_LongObject();

		/**
		 * The meta object literal for the '<em><b>Short</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__SHORT = eINSTANCE.getAllLabelsType_Short();

		/**
		 * The meta object literal for the '<em><b>Short Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__SHORT_OBJECT = eINSTANCE.getAllLabelsType_ShortObject();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__STRING = eINSTANCE.getAllLabelsType_String();

		/**
		 * The meta object literal for the '<em><b>Side</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL_LABELS_TYPE__SIDE = eINSTANCE.getAllLabelsType_Side();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.ChildLabelNodeContainerImpl <em>Child Label Node Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.ChildLabelNodeContainerImpl
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getChildLabelNodeContainer()
		 * @generated
		 */
		EClass CHILD_LABEL_NODE_CONTAINER = eINSTANCE.getChildLabelNodeContainer();

		/**
		 * The meta object literal for the '<em><b>Get Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILD_LABEL_NODE_CONTAINER__GET_CHILDREN = eINSTANCE.getChildLabelNodeContainer_GetChildren();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.ChildLabelNodeImpl <em>Child Label Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.ChildLabelNodeImpl
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getChildLabelNode()
		 * @generated
		 */
		EClass CHILD_LABEL_NODE = eINSTANCE.getChildLabelNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.GenLabelNodeImpl <em>Gen Label Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.GenLabelNodeImpl
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getGenLabelNode()
		 * @generated
		 */
		EClass GEN_LABEL_NODE = eINSTANCE.getGenLabelNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.VerticalLabelImpl <em>Vertical Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.VerticalLabelImpl
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getVerticalLabel()
		 * @generated
		 */
		EClass VERTICAL_LABEL = eINSTANCE.getVerticalLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.labels.impl.DiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.DiagramImpl
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getDiagram()
		 * @generated
		 */
		EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Get Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM__GET_LABELS = eINSTANCE.getDiagram_GetLabels();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.labels.Side <em>Side</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.labels.Side
		 * @see org.eclipse.gmf.tooling.examples.labels.impl.LabelsPackageImpl#getSide()
		 * @generated
		 */
		EEnum SIDE = eINSTANCE.getSide();

	}

} //LabelsPackage
