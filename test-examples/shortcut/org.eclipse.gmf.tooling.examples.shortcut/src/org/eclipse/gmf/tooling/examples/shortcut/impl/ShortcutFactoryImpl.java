/**
 */
package org.eclipse.gmf.tooling.examples.shortcut.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gmf.tooling.examples.shortcut.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ShortcutFactoryImpl extends EFactoryImpl implements ShortcutFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ShortcutFactory init() {
		try {
			ShortcutFactory theShortcutFactory = (ShortcutFactory)EPackage.Registry.INSTANCE.getEFactory(ShortcutPackage.eNS_URI);
			if (theShortcutFactory != null) {
				return theShortcutFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ShortcutFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortcutFactoryImpl() {
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
			case ShortcutPackage.DIAGRAM: return createDiagram();
			case ShortcutPackage.DIAGRAM_NODE: return createDiagramNode();
			case ShortcutPackage.DIAGRAM_LINK: return createDiagramLink();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
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
	public DiagramNode createDiagramNode() {
		DiagramNodeImpl diagramNode = new DiagramNodeImpl();
		return diagramNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramLink createDiagramLink() {
		DiagramLinkImpl diagramLink = new DiagramLinkImpl();
		return diagramLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortcutPackage getShortcutPackage() {
		return (ShortcutPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ShortcutPackage getPackage() {
		return ShortcutPackage.eINSTANCE;
	}

} //ShortcutFactoryImpl
