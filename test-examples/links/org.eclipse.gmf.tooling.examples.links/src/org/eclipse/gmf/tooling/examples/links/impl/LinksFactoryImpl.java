/**
 */
package org.eclipse.gmf.tooling.examples.links.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gmf.tooling.examples.links.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LinksFactoryImpl extends EFactoryImpl implements LinksFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LinksFactory init() {
		try {
			LinksFactory theLinksFactory = (LinksFactory)EPackage.Registry.INSTANCE.getEFactory(LinksPackage.eNS_URI);
			if (theLinksFactory != null) {
				return theLinksFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LinksFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinksFactoryImpl() {
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
			case LinksPackage.ROOT: return createRoot();
			case LinksPackage.ROOT_NODE_A: return createRootNodeA();
			case LinksPackage.ROOT_NODE_B: return createRootNodeB();
			case LinksPackage.CHILD_NODE_A: return createChildNodeA();
			case LinksPackage.CHILD_NODE_B: return createChildNodeB();
			case LinksPackage.CHILD_AB_ELEMENT_LINK: return createChild_AB_Element_Link();
			case LinksPackage.ROOT_BA_ELEMENT_LINK: return createRoot_BA_Element_Link();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root createRoot() {
		RootImpl root = new RootImpl();
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootNodeA createRootNodeA() {
		RootNodeAImpl rootNodeA = new RootNodeAImpl();
		return rootNodeA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootNodeB createRootNodeB() {
		RootNodeBImpl rootNodeB = new RootNodeBImpl();
		return rootNodeB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildNodeA createChildNodeA() {
		ChildNodeAImpl childNodeA = new ChildNodeAImpl();
		return childNodeA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildNodeB createChildNodeB() {
		ChildNodeBImpl childNodeB = new ChildNodeBImpl();
		return childNodeB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Child_AB_Element_Link createChild_AB_Element_Link() {
		Child_AB_Element_LinkImpl child_AB_Element_Link = new Child_AB_Element_LinkImpl();
		return child_AB_Element_Link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root_BA_Element_Link createRoot_BA_Element_Link() {
		Root_BA_Element_LinkImpl root_BA_Element_Link = new Root_BA_Element_LinkImpl();
		return root_BA_Element_Link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinksPackage getLinksPackage() {
		return (LinksPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LinksPackage getPackage() {
		return LinksPackage.eINSTANCE;
	}

} //LinksFactoryImpl
