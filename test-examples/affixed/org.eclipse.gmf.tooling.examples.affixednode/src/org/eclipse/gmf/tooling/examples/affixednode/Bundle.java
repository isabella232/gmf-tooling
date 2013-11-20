/**
 */
package org.eclipse.gmf.tooling.examples.affixednode;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.Bundle#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.Bundle#getOutcomingCommunicator <em>Outcoming Communicator</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.affixednode.Bundle#getIncomingCommunicator <em>Incoming Communicator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage#getBundle()
 * @model
 * @generated
 */
public interface Bundle extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage#getBundle_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.affixednode.Bundle#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Outcoming Communicator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outcoming Communicator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outcoming Communicator</em>' containment reference.
	 * @see #setOutcomingCommunicator(OutcomingCommunicator)
	 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage#getBundle_OutcomingCommunicator()
	 * @model containment="true"
	 * @generated
	 */
	OutcomingCommunicator getOutcomingCommunicator();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.affixednode.Bundle#getOutcomingCommunicator <em>Outcoming Communicator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outcoming Communicator</em>' containment reference.
	 * @see #getOutcomingCommunicator()
	 * @generated
	 */
	void setOutcomingCommunicator(OutcomingCommunicator value);

	/**
	 * Returns the value of the '<em><b>Incoming Communicator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Communicator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Communicator</em>' containment reference.
	 * @see #setIncomingCommunicator(IncomingCommunicator)
	 * @see org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage#getBundle_IncomingCommunicator()
	 * @model containment="true"
	 * @generated
	 */
	IncomingCommunicator getIncomingCommunicator();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.affixednode.Bundle#getIncomingCommunicator <em>Incoming Communicator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming Communicator</em>' containment reference.
	 * @see #getIncomingCommunicator()
	 * @generated
	 */
	void setIncomingCommunicator(IncomingCommunicator value);

} // Bundle
