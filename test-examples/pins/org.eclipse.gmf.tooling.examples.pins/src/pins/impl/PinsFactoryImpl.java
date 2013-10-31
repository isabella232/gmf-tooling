/**
 */
package pins.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pins.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PinsFactoryImpl extends EFactoryImpl implements PinsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PinsFactory init() {
		try {
			PinsFactory thePinsFactory = (PinsFactory)EPackage.Registry.INSTANCE.getEFactory(PinsPackage.eNS_URI);
			if (thePinsFactory != null) {
				return thePinsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PinsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PinsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PinsPackage.PIN: return createPin();
			case PinsPackage.COLOR_PIN: return createColorPin();
			case PinsPackage.CUSTOM_PIN: return createCustomPin();
			case PinsPackage.VISIBLE_PIN: return createVisiblePin();
			case PinsPackage.DIAGRAM: return createDiagram();
			case PinsPackage.PINS_CHILD: return createPinsChild();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin createPin() {
		PinImpl pin = new PinImpl();
		return pin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorPin createColorPin() {
		ColorPinImpl colorPin = new ColorPinImpl();
		return colorPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomPin createCustomPin() {
		CustomPinImpl customPin = new CustomPinImpl();
		return customPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisiblePin createVisiblePin() {
		VisiblePinImpl visiblePin = new VisiblePinImpl();
		return visiblePin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram createDiagram() {
		DiagramImpl diagram = new DiagramImpl();
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PinsChild createPinsChild() {
		PinsChildImpl pinsChild = new PinsChildImpl();
		return pinsChild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PinsPackage getPinsPackage() {
		return (PinsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PinsPackage getPackage() {
		return PinsPackage.eINSTANCE;
	}

} //PinsFactoryImpl
