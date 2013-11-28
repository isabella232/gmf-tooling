/**
 */
package org.eclipse.gmf.tooling.examples.compartments.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gmf.tooling.examples.compartments.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompartmentsFactoryImpl extends EFactoryImpl implements CompartmentsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompartmentsFactory init() {
		try {
			CompartmentsFactory theCompartmentsFactory = (CompartmentsFactory)EPackage.Registry.INSTANCE.getEFactory(CompartmentsPackage.eNS_URI);
			if (theCompartmentsFactory != null) {
				return theCompartmentsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompartmentsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentsFactoryImpl() {
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
			case CompartmentsPackage.CANVAS: return createCanvas();
			case CompartmentsPackage.TOP_NODE_A: return createTopNodeA();
			case CompartmentsPackage.TOP_NODE_B: return createTopNodeB();
			case CompartmentsPackage.CHILD_OF_BE: return createChildOfB_E();
			case CompartmentsPackage.CHILD_OF_BG: return createChildOfB_G();
			case CompartmentsPackage.TOP_NODE: return createTopNode();
			case CompartmentsPackage.CHILD_OF_AC: return createChildOfA_C();
			case CompartmentsPackage.CHILD_OF_BF: return createChildOfB_F();
			case CompartmentsPackage.CHILD_OF_AFFIXED: return createChildOfAffixed();
			case CompartmentsPackage.CHILD_OF_AD: return createChildOfA_D();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Canvas createCanvas() {
		CanvasImpl canvas = new CanvasImpl();
		return canvas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopNodeA createTopNodeA() {
		TopNodeAImpl topNodeA = new TopNodeAImpl();
		return topNodeA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopNodeB createTopNodeB() {
		TopNodeBImpl topNodeB = new TopNodeBImpl();
		return topNodeB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildOfB_E createChildOfB_E() {
		ChildOfB_EImpl childOfB_E = new ChildOfB_EImpl();
		return childOfB_E;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildOfB_G createChildOfB_G() {
		ChildOfB_GImpl childOfB_G = new ChildOfB_GImpl();
		return childOfB_G;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopNode createTopNode() {
		TopNodeImpl topNode = new TopNodeImpl();
		return topNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildOfA_C createChildOfA_C() {
		ChildOfA_CImpl childOfA_C = new ChildOfA_CImpl();
		return childOfA_C;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildOfB_F createChildOfB_F() {
		ChildOfB_FImpl childOfB_F = new ChildOfB_FImpl();
		return childOfB_F;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildOfAffixed createChildOfAffixed() {
		ChildOfAffixedImpl childOfAffixed = new ChildOfAffixedImpl();
		return childOfAffixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildOfA_D createChildOfA_D() {
		ChildOfA_DImpl childOfA_D = new ChildOfA_DImpl();
		return childOfA_D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentsPackage getCompartmentsPackage() {
		return (CompartmentsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CompartmentsPackage getPackage() {
		return CompartmentsPackage.eINSTANCE;
	}

} //CompartmentsFactoryImpl
