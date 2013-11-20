/**
 */
package borders.impl;

import borders.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BordersFactoryImpl extends EFactoryImpl implements BordersFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BordersFactory init() {
		try {
			BordersFactory theBordersFactory = (BordersFactory)EPackage.Registry.INSTANCE.getEFactory(BordersPackage.eNS_URI);
			if (theBordersFactory != null) {
				return theBordersFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BordersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BordersFactoryImpl() {
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
			case BordersPackage.BORDER: return createBorder();
			case BordersPackage.LINE_BORDER: return createLineBorder();
			case BordersPackage.MARGIN_BORDER: return createMarginBorder();
			case BordersPackage.COMPOUND_BORDER: return createCompoundBorder();
			case BordersPackage.CUSTOM_BORDER: return createCustomBorder();
			case BordersPackage.DIAGRAM: return createDiagram();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Border createBorder() {
		BorderImpl border = new BorderImpl();
		return border;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineBorder createLineBorder() {
		LineBorderImpl lineBorder = new LineBorderImpl();
		return lineBorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarginBorder createMarginBorder() {
		MarginBorderImpl marginBorder = new MarginBorderImpl();
		return marginBorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundBorder createCompoundBorder() {
		CompoundBorderImpl compoundBorder = new CompoundBorderImpl();
		return compoundBorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomBorder createCustomBorder() {
		CustomBorderImpl customBorder = new CustomBorderImpl();
		return customBorder;
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
	public BordersPackage getBordersPackage() {
		return (BordersPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BordersPackage getPackage() {
		return BordersPackage.eINSTANCE;
	}

} //BordersFactoryImpl
