/**
 */
package org.eclipse.gmf.tooling.examples.compartments;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Node A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeA#getChildrenC <em>Children C</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeA#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeA#getChildrenD <em>Children D</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getTopNodeA()
 * @model
 * @generated
 */
public interface TopNodeA extends TopNode {
	/**
	 * Returns the value of the '<em><b>Children C</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.compartments.ChildOfA_C}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children C</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children C</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getTopNodeA_ChildrenC()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChildOfA_C> getChildrenC();

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
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getTopNodeA_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.compartments.TopNodeA#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Children D</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.compartments.ChildOfA_D}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children D</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children D</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getTopNodeA_ChildrenD()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChildOfA_D> getChildrenD();

} // TopNodeA
