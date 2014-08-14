/**
 */
package org.eclipse.gmf.tooling.examples.linklf.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gmf.tooling.examples.linklf.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LinklfFactoryImpl extends EFactoryImpl implements LinklfFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LinklfFactory init() {
		try {
			LinklfFactory theLinklfFactory = (LinklfFactory)EPackage.Registry.INSTANCE.getEFactory(LinklfPackage.eNS_URI);
			if (theLinklfFactory != null) {
				return theLinklfFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LinklfFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinklfFactoryImpl() {
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
			case LinklfPackage.CANVAS: return createCanvas();
			case LinklfPackage.CONTAINER: return createContainer();
			case LinklfPackage.RECTANGLE: return createRectangle();
			case LinklfPackage.CIRCLE: return createCircle();
			case LinklfPackage.RHOMBUS: return createRhombus();
			case LinklfPackage.CANVAS_ELEMENT_CONTAINER: return createCanvasElementContainer();
			case LinklfPackage.LINK: return createLink();
			case LinklfPackage.LABELED_LINK: return createLabeledLink();
			case LinklfPackage.PORT: return createPort();
			case LinklfPackage.CANVAS_ELEMENT: return createCanvasElement();
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
	public org.eclipse.gmf.tooling.examples.linklf.Container createContainer() {
		ContainerImpl container = new ContainerImpl();
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle createRectangle() {
		RectangleImpl rectangle = new RectangleImpl();
		return rectangle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Circle createCircle() {
		CircleImpl circle = new CircleImpl();
		return circle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rhombus createRhombus() {
		RhombusImpl rhombus = new RhombusImpl();
		return rhombus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CanvasElementContainer createCanvasElementContainer() {
		CanvasElementContainerImpl canvasElementContainer = new CanvasElementContainerImpl();
		return canvasElementContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
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
	public Port createPort() {
		PortImpl port = new PortImpl();
		return port;
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
	public LinklfPackage getLinklfPackage() {
		return (LinklfPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LinklfPackage getPackage() {
		return LinklfPackage.eINSTANCE;
	}

} //LinklfFactoryImpl
