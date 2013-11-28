/**
 */
package org.eclipse.gmf.tooling.examples.compartments;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Of BF</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F#getDNodeRelation <em>DNode Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getChildOfB_F()
 * @model
 * @generated
 */
public interface ChildOfB_F extends EObject {
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
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getChildOfB_F_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>DNode Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DNode Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DNode Relation</em>' reference.
	 * @see #setDNodeRelation(ChildOfA_D)
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getChildOfB_F_DNodeRelation()
	 * @model
	 * @generated
	 */
	ChildOfA_D getDNodeRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F#getDNodeRelation <em>DNode Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DNode Relation</em>' reference.
	 * @see #getDNodeRelation()
	 * @generated
	 */
	void setDNodeRelation(ChildOfA_D value);

} // ChildOfB_F
