/**
 */
package org.eclipse.gmf.tooling.examples.phantoms.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gmf.tooling.examples.phantoms.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PhantomsFactoryImpl extends EFactoryImpl implements PhantomsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PhantomsFactory init() {
		try {
			PhantomsFactory thePhantomsFactory = (PhantomsFactory)EPackage.Registry.INSTANCE.getEFactory(PhantomsPackage.eNS_URI);
			if (thePhantomsFactory != null) {
				return thePhantomsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PhantomsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhantomsFactoryImpl() {
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
			case PhantomsPackage.ROOT: return createRoot();
			case PhantomsPackage.ROOT_CHILD: return createRootChild();
			case PhantomsPackage.TOP_PARENT: return createTopParent();
			case PhantomsPackage.MEDIUM: return createMedium();
			case PhantomsPackage.TOP_CHILD: return createTopChild();
			case PhantomsPackage.MEDIUM_PARENT: return createMediumParent();
			case PhantomsPackage.MEDIUM_CHILD: return createMediumChild();
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
	public RootChild createRootChild() {
		RootChildImpl rootChild = new RootChildImpl();
		return rootChild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopParent createTopParent() {
		TopParentImpl topParent = new TopParentImpl();
		return topParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Medium createMedium() {
		MediumImpl medium = new MediumImpl();
		return medium;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopChild createTopChild() {
		TopChildImpl topChild = new TopChildImpl();
		return topChild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediumParent createMediumParent() {
		MediumParentImpl mediumParent = new MediumParentImpl();
		return mediumParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediumChild createMediumChild() {
		MediumChildImpl mediumChild = new MediumChildImpl();
		return mediumChild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhantomsPackage getPhantomsPackage() {
		return (PhantomsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PhantomsPackage getPackage() {
		return PhantomsPackage.eINSTANCE;
	}

} //PhantomsFactoryImpl
