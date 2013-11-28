/**
 */
package org.eclipse.gmf.tooling.examples.compartments;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Of BG</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G#getNumber <em>Number</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G#getChildrenOfAffixed <em>Children Of Affixed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getChildOfB_G()
 * @model
 * @generated
 */
public interface ChildOfB_G extends EObject {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getChildOfB_G_Number()
	 * @model
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Children Of Affixed</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.compartments.ChildOfAffixed}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children Of Affixed</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children Of Affixed</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage#getChildOfB_G_ChildrenOfAffixed()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChildOfAffixed> getChildrenOfAffixed();

} // ChildOfB_G
