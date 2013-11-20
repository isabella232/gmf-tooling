/**
 */
package org.eclipse.gmf.tooling.examples.affixednode;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage
 * @generated
 */
public interface AffixedNodeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AffixedNodeFactory eINSTANCE = org.eclipse.gmf.tooling.examples.affixednode.impl.AffixedNodeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Canvas</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Canvas</em>'.
	 * @generated
	 */
	Canvas createCanvas();

	/**
	 * Returns a new object of class '<em>Incoming Communicator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Incoming Communicator</em>'.
	 * @generated
	 */
	IncomingCommunicator createIncomingCommunicator();

	/**
	 * Returns a new object of class '<em>Outcoming Communicator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outcoming Communicator</em>'.
	 * @generated
	 */
	OutcomingCommunicator createOutcomingCommunicator();

	/**
	 * Returns a new object of class '<em>Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bundle</em>'.
	 * @generated
	 */
	Bundle createBundle();

	/**
	 * Returns a new object of class '<em>Communication</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication</em>'.
	 * @generated
	 */
	Communication createCommunication();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AffixedNodePackage getAffixedNodePackage();

} //AffixedNodeFactory
