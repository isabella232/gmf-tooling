/**
 */
package org.eclipse.gmf.example.lesscode.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmf.example.lesscode.*;
import org.eclipse.gmf.example.lesscode.LesscodeFactory;
import org.eclipse.gmf.example.lesscode.LesscodePackage;
import org.eclipse.gmf.example.lesscode.MultiContainmentGroup;
import org.eclipse.gmf.example.lesscode.OneContainmentGroup;
import org.eclipse.gmf.example.lesscode.RootContainer;
import org.eclipse.gmf.example.lesscode.Subject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LesscodeFactoryImpl extends EFactoryImpl implements LesscodeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LesscodeFactory init() {
		try {
			LesscodeFactory theLesscodeFactory = (LesscodeFactory)EPackage.Registry.INSTANCE.getEFactory(LesscodePackage.eNS_URI);
			if (theLesscodeFactory != null) {
				return theLesscodeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LesscodeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LesscodeFactoryImpl() {
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
			case LesscodePackage.ROOT_CONTAINER: return createRootContainer();
			case LesscodePackage.ELEMENT_BASED_LINK: return createElementBasedLink();
			case LesscodePackage.SUBJECT: return createSubject();
			case LesscodePackage.ONE_CONTAINMENT_GROUP: return createOneContainmentGroup();
			case LesscodePackage.MULTI_CONTAINMENT_GROUP: return createMultiContainmentGroup();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootContainer createRootContainer() {
		RootContainerImpl rootContainer = new RootContainerImpl();
		return rootContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementBasedLink createElementBasedLink() {
		ElementBasedLinkImpl elementBasedLink = new ElementBasedLinkImpl();
		return elementBasedLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subject createSubject() {
		SubjectImpl subject = new SubjectImpl();
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OneContainmentGroup createOneContainmentGroup() {
		OneContainmentGroupImpl oneContainmentGroup = new OneContainmentGroupImpl();
		return oneContainmentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiContainmentGroup createMultiContainmentGroup() {
		MultiContainmentGroupImpl multiContainmentGroup = new MultiContainmentGroupImpl();
		return multiContainmentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LesscodePackage getLesscodePackage() {
		return (LesscodePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LesscodePackage getPackage() {
		return LesscodePackage.eINSTANCE;
	}

} //LesscodeFactoryImpl
