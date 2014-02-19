/**
 */
package org.eclipse.gmf.tooling.examples.pins;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Pin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.pins.CustomPin#getGetChildren <em>Get Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.pins.PinsPackage#getCustomPin()
 * @model
 * @generated
 */
public interface CustomPin extends Pin {
	/**
	 * Returns the value of the '<em><b>Get Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.pins.PinsChild}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Get Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get Children</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.pins.PinsPackage#getCustomPin_GetChildren()
	 * @model containment="true"
	 * @generated
	 */
	EList<PinsChild> getGetChildren();

} // CustomPin
