/**
 */
package pins;

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
 * @see pins.PinsFactory
 * @model kind="package"
 * @generated
 */
public interface PinsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pins";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.gmf.tooling.examples.pins";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pins";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PinsPackage eINSTANCE = pins.impl.PinsPackageImpl.init();

	/**
	 * The meta object id for the '{@link pins.impl.PinImpl <em>Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pins.impl.PinImpl
	 * @see pins.impl.PinsPackageImpl#getPin()
	 * @generated
	 */
	int PIN = 0;

	/**
	 * The number of structural features of the '<em>Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIN_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link pins.impl.ColorPinImpl <em>Color Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pins.impl.ColorPinImpl
	 * @see pins.impl.PinsPackageImpl#getColorPin()
	 * @generated
	 */
	int COLOR_PIN = 1;

	/**
	 * The feature id for the '<em><b>Get Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_PIN__GET_CHILDREN = PIN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Color Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_PIN_FEATURE_COUNT = PIN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link pins.impl.CustomPinImpl <em>Custom Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pins.impl.CustomPinImpl
	 * @see pins.impl.PinsPackageImpl#getCustomPin()
	 * @generated
	 */
	int CUSTOM_PIN = 2;

	/**
	 * The feature id for the '<em><b>Get Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PIN__GET_CHILDREN = PIN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Custom Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PIN_FEATURE_COUNT = PIN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link pins.impl.VisiblePinImpl <em>Visible Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pins.impl.VisiblePinImpl
	 * @see pins.impl.PinsPackageImpl#getVisiblePin()
	 * @generated
	 */
	int VISIBLE_PIN = 3;

	/**
	 * The feature id for the '<em><b>Warning Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBLE_PIN__WARNING_LABEL = PIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Get Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBLE_PIN__GET_CHILDREN = PIN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Visible Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBLE_PIN_FEATURE_COUNT = PIN_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link pins.impl.DiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pins.impl.DiagramImpl
	 * @see pins.impl.PinsPackageImpl#getDiagram()
	 * @generated
	 */
	int DIAGRAM = 4;

	/**
	 * The feature id for the '<em><b>Get Pins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__GET_PINS = 0;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link pins.impl.PinsChildImpl <em>Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pins.impl.PinsChildImpl
	 * @see pins.impl.PinsPackageImpl#getPinsChild()
	 * @generated
	 */
	int PINS_CHILD = 5;

	/**
	 * The feature id for the '<em><b>Pins Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PINS_CHILD__PINS_CHILD = 0;

	/**
	 * The number of structural features of the '<em>Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PINS_CHILD_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link pins.Pin <em>Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pin</em>'.
	 * @see pins.Pin
	 * @generated
	 */
	EClass getPin();

	/**
	 * Returns the meta object for class '{@link pins.ColorPin <em>Color Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Pin</em>'.
	 * @see pins.ColorPin
	 * @generated
	 */
	EClass getColorPin();

	/**
	 * Returns the meta object for the containment reference list '{@link pins.ColorPin#getGetChildren <em>Get Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Get Children</em>'.
	 * @see pins.ColorPin#getGetChildren()
	 * @see #getColorPin()
	 * @generated
	 */
	EReference getColorPin_GetChildren();

	/**
	 * Returns the meta object for class '{@link pins.CustomPin <em>Custom Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Pin</em>'.
	 * @see pins.CustomPin
	 * @generated
	 */
	EClass getCustomPin();

	/**
	 * Returns the meta object for the containment reference list '{@link pins.CustomPin#getGetChildren <em>Get Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Get Children</em>'.
	 * @see pins.CustomPin#getGetChildren()
	 * @see #getCustomPin()
	 * @generated
	 */
	EReference getCustomPin_GetChildren();

	/**
	 * Returns the meta object for class '{@link pins.VisiblePin <em>Visible Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visible Pin</em>'.
	 * @see pins.VisiblePin
	 * @generated
	 */
	EClass getVisiblePin();

	/**
	 * Returns the meta object for the attribute '{@link pins.VisiblePin#getWarningLabel <em>Warning Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Warning Label</em>'.
	 * @see pins.VisiblePin#getWarningLabel()
	 * @see #getVisiblePin()
	 * @generated
	 */
	EAttribute getVisiblePin_WarningLabel();

	/**
	 * Returns the meta object for the containment reference list '{@link pins.VisiblePin#getGetChildren <em>Get Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Get Children</em>'.
	 * @see pins.VisiblePin#getGetChildren()
	 * @see #getVisiblePin()
	 * @generated
	 */
	EReference getVisiblePin_GetChildren();

	/**
	 * Returns the meta object for class '{@link pins.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see pins.Diagram
	 * @generated
	 */
	EClass getDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link pins.Diagram#getGetPins <em>Get Pins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Get Pins</em>'.
	 * @see pins.Diagram#getGetPins()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_GetPins();

	/**
	 * Returns the meta object for class '{@link pins.PinsChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child</em>'.
	 * @see pins.PinsChild
	 * @generated
	 */
	EClass getPinsChild();

	/**
	 * Returns the meta object for the attribute '{@link pins.PinsChild#getPinsChild <em>Pins Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pins Child</em>'.
	 * @see pins.PinsChild#getPinsChild()
	 * @see #getPinsChild()
	 * @generated
	 */
	EAttribute getPinsChild_PinsChild();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PinsFactory getPinsFactory();

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
		 * The meta object literal for the '{@link pins.impl.PinImpl <em>Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pins.impl.PinImpl
		 * @see pins.impl.PinsPackageImpl#getPin()
		 * @generated
		 */
		EClass PIN = eINSTANCE.getPin();

		/**
		 * The meta object literal for the '{@link pins.impl.ColorPinImpl <em>Color Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pins.impl.ColorPinImpl
		 * @see pins.impl.PinsPackageImpl#getColorPin()
		 * @generated
		 */
		EClass COLOR_PIN = eINSTANCE.getColorPin();

		/**
		 * The meta object literal for the '<em><b>Get Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLOR_PIN__GET_CHILDREN = eINSTANCE.getColorPin_GetChildren();

		/**
		 * The meta object literal for the '{@link pins.impl.CustomPinImpl <em>Custom Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pins.impl.CustomPinImpl
		 * @see pins.impl.PinsPackageImpl#getCustomPin()
		 * @generated
		 */
		EClass CUSTOM_PIN = eINSTANCE.getCustomPin();

		/**
		 * The meta object literal for the '<em><b>Get Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOM_PIN__GET_CHILDREN = eINSTANCE.getCustomPin_GetChildren();

		/**
		 * The meta object literal for the '{@link pins.impl.VisiblePinImpl <em>Visible Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pins.impl.VisiblePinImpl
		 * @see pins.impl.PinsPackageImpl#getVisiblePin()
		 * @generated
		 */
		EClass VISIBLE_PIN = eINSTANCE.getVisiblePin();

		/**
		 * The meta object literal for the '<em><b>Warning Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISIBLE_PIN__WARNING_LABEL = eINSTANCE.getVisiblePin_WarningLabel();

		/**
		 * The meta object literal for the '<em><b>Get Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISIBLE_PIN__GET_CHILDREN = eINSTANCE.getVisiblePin_GetChildren();

		/**
		 * The meta object literal for the '{@link pins.impl.DiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pins.impl.DiagramImpl
		 * @see pins.impl.PinsPackageImpl#getDiagram()
		 * @generated
		 */
		EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Get Pins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM__GET_PINS = eINSTANCE.getDiagram_GetPins();

		/**
		 * The meta object literal for the '{@link pins.impl.PinsChildImpl <em>Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pins.impl.PinsChildImpl
		 * @see pins.impl.PinsPackageImpl#getPinsChild()
		 * @generated
		 */
		EClass PINS_CHILD = eINSTANCE.getPinsChild();

		/**
		 * The meta object literal for the '<em><b>Pins Child</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PINS_CHILD__PINS_CHILD = eINSTANCE.getPinsChild_PinsChild();

	}

} //PinsPackage
