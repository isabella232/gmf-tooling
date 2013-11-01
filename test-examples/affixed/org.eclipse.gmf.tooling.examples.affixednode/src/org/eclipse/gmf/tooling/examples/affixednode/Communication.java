/**
 */
package org.eclipse.gmf.tooling.examples.affixednode;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.Communication#getOutcomingCommunicator <em>Outcoming Communicator</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.Communication#getIncomingCommunicator <em>Incoming Communicator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage#getCommunication()
 * @model
 * @generated
 */
public interface Communication extends EObject {
	/**
	 * Returns the value of the '<em><b>Outcoming Communicator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outcoming Communicator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outcoming Communicator</em>' reference.
	 * @see #setOutcomingCommunicator(OutcomingCommunicator)
	 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage#getCommunication_OutcomingCommunicator()
	 * @model
	 * @generated
	 */
	OutcomingCommunicator getOutcomingCommunicator();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.affixednode.Communication#getOutcomingCommunicator <em>Outcoming Communicator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outcoming Communicator</em>' reference.
	 * @see #getOutcomingCommunicator()
	 * @generated
	 */
	void setOutcomingCommunicator(OutcomingCommunicator value);

	/**
	 * Returns the value of the '<em><b>Incoming Communicator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Communicator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Communicator</em>' reference.
	 * @see #setIncomingCommunicator(IncomingCommunicator)
	 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage#getCommunication_IncomingCommunicator()
	 * @model
	 * @generated
	 */
	IncomingCommunicator getIncomingCommunicator();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.affixednode.Communication#getIncomingCommunicator <em>Incoming Communicator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming Communicator</em>' reference.
	 * @see #getIncomingCommunicator()
	 * @generated
	 */
	void setIncomingCommunicator(IncomingCommunicator value);

} // Communication
