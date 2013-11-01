/**
 */
package org.eclipse.gmf.tooling.examples.affixednode;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodeFactory
 * @model kind="package"
 * @generated
 */
public interface AffixedNodePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "affixednode";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.gmf.tooling.examples.affixednode";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.gmf.tooling.examples.affixednode";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AffixedNodePackage eINSTANCE = org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.affixednode.impl.CanvasImpl <em>Canvas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.CanvasImpl
	 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodePackageImpl#getCanvas()
	 * @generated
	 */
	int CANVAS = 0;

	/**
	 * The feature id for the '<em><b>Bundles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS__BUNDLES = 0;

	/**
	 * The feature id for the '<em><b>Communications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS__COMMUNICATIONS = 1;

	/**
	 * The number of structural features of the '<em>Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.affixednode.impl.IncomingCommunicatorImpl <em>Incoming Communicator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.IncomingCommunicatorImpl
	 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodePackageImpl#getIncomingCommunicator()
	 * @generated
	 */
	int INCOMING_COMMUNICATOR = 1;

	/**
	 * The number of structural features of the '<em>Incoming Communicator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_COMMUNICATOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Incoming Communicator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCOMING_COMMUNICATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.affixednode.impl.OutcomingCommunicatorImpl <em>Outcoming Communicator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.OutcomingCommunicatorImpl
	 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodePackageImpl#getOutcomingCommunicator()
	 * @generated
	 */
	int OUTCOMING_COMMUNICATOR = 2;

	/**
	 * The number of structural features of the '<em>Outcoming Communicator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTCOMING_COMMUNICATOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Outcoming Communicator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTCOMING_COMMUNICATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.affixednode.impl.BundleImpl <em>Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.BundleImpl
	 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodePackageImpl#getBundle()
	 * @generated
	 */
	int BUNDLE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Outcoming Communicator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__OUTCOMING_COMMUNICATOR = 1;

	/**
	 * The feature id for the '<em><b>Incoming Communicator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__INCOMING_COMMUNICATOR = 2;

	/**
	 * The number of structural features of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.affixednode.impl.CommunicationImpl <em>Communication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.CommunicationImpl
	 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodePackageImpl#getCommunication()
	 * @generated
	 */
	int COMMUNICATION = 4;

	/**
	 * The feature id for the '<em><b>Outcoming Communicator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION__OUTCOMING_COMMUNICATOR = 0;

	/**
	 * The feature id for the '<em><b>Incoming Communicator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION__INCOMING_COMMUNICATOR = 1;

	/**
	 * The number of structural features of the '<em>Communication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Communication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.affixednode.Canvas <em>Canvas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Canvas</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.Canvas
	 * @generated
	 */
	EClass getCanvas();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.affixednode.Canvas#getBundles <em>Bundles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bundles</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.Canvas#getBundles()
	 * @see #getCanvas()
	 * @generated
	 */
	EReference getCanvas_Bundles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.affixednode.Canvas#getCommunications <em>Communications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Communications</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.Canvas#getCommunications()
	 * @see #getCanvas()
	 * @generated
	 */
	EReference getCanvas_Communications();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.affixednode.IncomingCommunicator <em>Incoming Communicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Incoming Communicator</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.IncomingCommunicator
	 * @generated
	 */
	EClass getIncomingCommunicator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.affixednode.OutcomingCommunicator <em>Outcoming Communicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outcoming Communicator</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.OutcomingCommunicator
	 * @generated
	 */
	EClass getOutcomingCommunicator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.affixednode.Bundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.Bundle
	 * @generated
	 */
	EClass getBundle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.affixednode.Bundle#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.Bundle#getName()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.gmf.tooling.examples.affixednode.Bundle#getOutcomingCommunicator <em>Outcoming Communicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Outcoming Communicator</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.Bundle#getOutcomingCommunicator()
	 * @see #getBundle()
	 * @generated
	 */
	EReference getBundle_OutcomingCommunicator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.gmf.tooling.examples.affixednode.Bundle#getIncomingCommunicator <em>Incoming Communicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Incoming Communicator</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.Bundle#getIncomingCommunicator()
	 * @see #getBundle()
	 * @generated
	 */
	EReference getBundle_IncomingCommunicator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.affixednode.Communication <em>Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.Communication
	 * @generated
	 */
	EClass getCommunication();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.affixednode.Communication#getOutcomingCommunicator <em>Outcoming Communicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outcoming Communicator</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.Communication#getOutcomingCommunicator()
	 * @see #getCommunication()
	 * @generated
	 */
	EReference getCommunication_OutcomingCommunicator();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.affixednode.Communication#getIncomingCommunicator <em>Incoming Communicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming Communicator</em>'.
	 * @see org.eclipse.gmf.tooling.examples.affixednode.Communication#getIncomingCommunicator()
	 * @see #getCommunication()
	 * @generated
	 */
	EReference getCommunication_IncomingCommunicator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AffixedNodeFactory getAffixedNodeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.affixednode.impl.CanvasImpl <em>Canvas</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.CanvasImpl
		 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodePackageImpl#getCanvas()
		 * @generated
		 */
		EClass CANVAS = eINSTANCE.getCanvas();

		/**
		 * The meta object literal for the '<em><b>Bundles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CANVAS__BUNDLES = eINSTANCE.getCanvas_Bundles();

		/**
		 * The meta object literal for the '<em><b>Communications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CANVAS__COMMUNICATIONS = eINSTANCE.getCanvas_Communications();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.affixednode.impl.IncomingCommunicatorImpl <em>Incoming Communicator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.IncomingCommunicatorImpl
		 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodePackageImpl#getIncomingCommunicator()
		 * @generated
		 */
		EClass INCOMING_COMMUNICATOR = eINSTANCE.getIncomingCommunicator();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.affixednode.impl.OutcomingCommunicatorImpl <em>Outcoming Communicator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.OutcomingCommunicatorImpl
		 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodePackageImpl#getOutcomingCommunicator()
		 * @generated
		 */
		EClass OUTCOMING_COMMUNICATOR = eINSTANCE.getOutcomingCommunicator();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.affixednode.impl.BundleImpl <em>Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.BundleImpl
		 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodePackageImpl#getBundle()
		 * @generated
		 */
		EClass BUNDLE = eINSTANCE.getBundle();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__NAME = eINSTANCE.getBundle_Name();

		/**
		 * The meta object literal for the '<em><b>Outcoming Communicator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE__OUTCOMING_COMMUNICATOR = eINSTANCE.getBundle_OutcomingCommunicator();

		/**
		 * The meta object literal for the '<em><b>Incoming Communicator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE__INCOMING_COMMUNICATOR = eINSTANCE.getBundle_IncomingCommunicator();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.affixednode.impl.CommunicationImpl <em>Communication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.CommunicationImpl
		 * @see org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodePackageImpl#getCommunication()
		 * @generated
		 */
		EClass COMMUNICATION = eINSTANCE.getCommunication();

		/**
		 * The meta object literal for the '<em><b>Outcoming Communicator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION__OUTCOMING_COMMUNICATOR = eINSTANCE.getCommunication_OutcomingCommunicator();

		/**
		 * The meta object literal for the '<em><b>Incoming Communicator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION__INCOMING_COMMUNICATOR = eINSTANCE.getCommunication_IncomingCommunicator();

	}

} //AffixedNodePackage
