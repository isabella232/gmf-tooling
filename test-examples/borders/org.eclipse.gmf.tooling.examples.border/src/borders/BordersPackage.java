/**
 */
package borders;

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
 * @see borders.BordersFactory
 * @model kind="package"
 * @generated
 */
public interface BordersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "borders";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.gmf.tooling.examples.borders";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "borders";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BordersPackage eINSTANCE = borders.impl.BordersPackageImpl.init();

	/**
	 * The meta object id for the '{@link borders.impl.BorderImpl <em>Border</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see borders.impl.BorderImpl
	 * @see borders.impl.BordersPackageImpl#getBorder()
	 * @generated
	 */
	int BORDER = 0;

	/**
	 * The number of structural features of the '<em>Border</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BORDER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Border</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BORDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link borders.impl.LineBorderImpl <em>Line Border</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see borders.impl.LineBorderImpl
	 * @see borders.impl.BordersPackageImpl#getLineBorder()
	 * @generated
	 */
	int LINE_BORDER = 1;

	/**
	 * The number of structural features of the '<em>Line Border</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BORDER_FEATURE_COUNT = BORDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Line Border</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BORDER_OPERATION_COUNT = BORDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link borders.impl.MarginBorderImpl <em>Margin Border</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see borders.impl.MarginBorderImpl
	 * @see borders.impl.BordersPackageImpl#getMarginBorder()
	 * @generated
	 */
	int MARGIN_BORDER = 2;

	/**
	 * The number of structural features of the '<em>Margin Border</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARGIN_BORDER_FEATURE_COUNT = BORDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Margin Border</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARGIN_BORDER_OPERATION_COUNT = BORDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link borders.impl.CompoundBorderImpl <em>Compound Border</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see borders.impl.CompoundBorderImpl
	 * @see borders.impl.BordersPackageImpl#getCompoundBorder()
	 * @generated
	 */
	int COMPOUND_BORDER = 3;

	/**
	 * The number of structural features of the '<em>Compound Border</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_BORDER_FEATURE_COUNT = BORDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Compound Border</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_BORDER_OPERATION_COUNT = BORDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link borders.impl.CustomBorderImpl <em>Custom Border</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see borders.impl.CustomBorderImpl
	 * @see borders.impl.BordersPackageImpl#getCustomBorder()
	 * @generated
	 */
	int CUSTOM_BORDER = 4;

	/**
	 * The number of structural features of the '<em>Custom Border</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_BORDER_FEATURE_COUNT = BORDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Custom Border</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_BORDER_OPERATION_COUNT = BORDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link borders.impl.DiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see borders.impl.DiagramImpl
	 * @see borders.impl.BordersPackageImpl#getDiagram()
	 * @generated
	 */
	int DIAGRAM = 5;

	/**
	 * The feature id for the '<em><b>Borders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__BORDERS = 0;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link borders.Border <em>Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Border</em>'.
	 * @see borders.Border
	 * @generated
	 */
	EClass getBorder();

	/**
	 * Returns the meta object for class '{@link borders.LineBorder <em>Line Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Border</em>'.
	 * @see borders.LineBorder
	 * @generated
	 */
	EClass getLineBorder();

	/**
	 * Returns the meta object for class '{@link borders.MarginBorder <em>Margin Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Margin Border</em>'.
	 * @see borders.MarginBorder
	 * @generated
	 */
	EClass getMarginBorder();

	/**
	 * Returns the meta object for class '{@link borders.CompoundBorder <em>Compound Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Border</em>'.
	 * @see borders.CompoundBorder
	 * @generated
	 */
	EClass getCompoundBorder();

	/**
	 * Returns the meta object for class '{@link borders.CustomBorder <em>Custom Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Border</em>'.
	 * @see borders.CustomBorder
	 * @generated
	 */
	EClass getCustomBorder();

	/**
	 * Returns the meta object for class '{@link borders.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see borders.Diagram
	 * @generated
	 */
	EClass getDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link borders.Diagram#getBorders <em>Borders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Borders</em>'.
	 * @see borders.Diagram#getBorders()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_Borders();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BordersFactory getBordersFactory();

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
		 * The meta object literal for the '{@link borders.impl.BorderImpl <em>Border</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see borders.impl.BorderImpl
		 * @see borders.impl.BordersPackageImpl#getBorder()
		 * @generated
		 */
		EClass BORDER = eINSTANCE.getBorder();

		/**
		 * The meta object literal for the '{@link borders.impl.LineBorderImpl <em>Line Border</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see borders.impl.LineBorderImpl
		 * @see borders.impl.BordersPackageImpl#getLineBorder()
		 * @generated
		 */
		EClass LINE_BORDER = eINSTANCE.getLineBorder();

		/**
		 * The meta object literal for the '{@link borders.impl.MarginBorderImpl <em>Margin Border</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see borders.impl.MarginBorderImpl
		 * @see borders.impl.BordersPackageImpl#getMarginBorder()
		 * @generated
		 */
		EClass MARGIN_BORDER = eINSTANCE.getMarginBorder();

		/**
		 * The meta object literal for the '{@link borders.impl.CompoundBorderImpl <em>Compound Border</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see borders.impl.CompoundBorderImpl
		 * @see borders.impl.BordersPackageImpl#getCompoundBorder()
		 * @generated
		 */
		EClass COMPOUND_BORDER = eINSTANCE.getCompoundBorder();

		/**
		 * The meta object literal for the '{@link borders.impl.CustomBorderImpl <em>Custom Border</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see borders.impl.CustomBorderImpl
		 * @see borders.impl.BordersPackageImpl#getCustomBorder()
		 * @generated
		 */
		EClass CUSTOM_BORDER = eINSTANCE.getCustomBorder();

		/**
		 * The meta object literal for the '{@link borders.impl.DiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see borders.impl.DiagramImpl
		 * @see borders.impl.BordersPackageImpl#getDiagram()
		 * @generated
		 */
		EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Borders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM__BORDERS = eINSTANCE.getDiagram_Borders();

	}

} //BordersPackage
