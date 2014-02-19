/**
 */
package org.eclipse.gmf.tooling.examples.compartments;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Node B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getChildrenE <em>Children E</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getChildrenG <em>Children G</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getChildrenF <em>Children F</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getTopNodeB()
 * @model
 * @generated
 */
public interface TopNodeB extends TopNode {
	/**
	 * Returns the value of the '<em><b>Children E</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children E</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children E</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getTopNodeB_ChildrenE()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChildOfB_E> getChildrenE();

	/**
	 * Returns the value of the '<em><b>Children G</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children G</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children G</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getTopNodeB_ChildrenG()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChildOfB_G> getChildrenG();

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
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getTopNodeB_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeB#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Children F</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children F</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children F</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getTopNodeB_ChildrenF()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChildOfB_F> getChildrenF();

} // TopNodeB
