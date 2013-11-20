/**
 */
package org.eclipse.gmf.tooling.examples.affixednode.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gmf.tooling.examples.affixednode.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AffixedNodeFactoryImpl extends EFactoryImpl implements AffixedNodeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AffixedNodeFactory init() {
		try {
			AffixedNodeFactory theAffixedNodeFactory = (AffixedNodeFactory)EPackage.Registry.INSTANCE.getEFactory(AffixedNodePackage.eNS_URI);
			if (theAffixedNodeFactory != null) {
				return theAffixedNodeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AffixedNodeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffixedNodeFactoryImpl() {
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
			case AffixedNodePackage.CANVAS: return createCanvas();
			case AffixedNodePackage.INCOMING_COMMUNICATOR: return createIncomingCommunicator();
			case AffixedNodePackage.OUTCOMING_COMMUNICATOR: return createOutcomingCommunicator();
			case AffixedNodePackage.BUNDLE: return createBundle();
			case AffixedNodePackage.COMMUNICATION: return createCommunication();
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
	public IncomingCommunicator createIncomingCommunicator() {
		IncomingCommunicatorImpl incomingCommunicator = new IncomingCommunicatorImpl();
		return incomingCommunicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutcomingCommunicator createOutcomingCommunicator() {
		OutcomingCommunicatorImpl outcomingCommunicator = new OutcomingCommunicatorImpl();
		return outcomingCommunicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bundle createBundle() {
		BundleImpl bundle = new BundleImpl();
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Communication createCommunication() {
		CommunicationImpl communication = new CommunicationImpl();
		return communication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffixedNodePackage getAffixedNodePackage() {
		return (AffixedNodePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AffixedNodePackage getPackage() {
		return AffixedNodePackage.eINSTANCE;
	}

} //AffixedNodeFactoryImpl
