/**
 */
package org.eclipse.gmf.tooling.examples.compartments;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Of BE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E#getCNodeRelation <em>CNode Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getChildOfB_E()
 * @model
 * @generated
 */
public interface ChildOfB_E extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getChildOfB_E_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>CNode Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CNode Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CNode Relation</em>' reference.
	 * @see #setCNodeRelation(ChildOfA_C)
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getChildOfB_E_CNodeRelation()
	 * @model
	 * @generated
	 */
	ChildOfA_C getCNodeRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E#getCNodeRelation <em>CNode Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CNode Relation</em>' reference.
	 * @see #getCNodeRelation()
	 * @generated
	 */
	void setCNodeRelation(ChildOfA_C value);

} // ChildOfB_E
