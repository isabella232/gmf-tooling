/**
 */
package org.eclipse.gmf.tooling.examples.linklabels.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gmf.tooling.examples.linklabels.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LinklabelsFactoryImpl extends EFactoryImpl implements LinklabelsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LinklabelsFactory init() {
		try {
			LinklabelsFactory theLinklabelsFactory = (LinklabelsFactory)EPackage.Registry.INSTANCE.getEFactory(LinklabelsPackage.eNS_URI);
			if (theLinklabelsFactory != null) {
				return theLinklabelsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LinklabelsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinklabelsFactoryImpl() {
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
			case LinklabelsPackage.CANVAS: return createCanvas();
			case LinklabelsPackage.CANVAS_ELEMENT: return createCanvasElement();
			case LinklabelsPackage.NODE: return createNode();
			case LinklabelsPackage.LABELED_LINK: return createLabeledLink();
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
	public CanvasElement createCanvasElement() {
		CanvasElementImpl canvasElement = new CanvasElementImpl();
		return canvasElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabeledLink createLabeledLink() {
		LabeledLinkImpl labeledLink = new LabeledLinkImpl();
		return labeledLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinklabelsPackage getLinklabelsPackage() {
		return (LinklabelsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LinklabelsPackage getPackage() {
		return LinklabelsPackage.eINSTANCE;
	}

} //LinklabelsFactoryImpl
