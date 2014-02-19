/**
 */
package org.eclipse.gmf.tooling.examples.pins;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visible Pin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.pins.VisiblePin#getWarningLabel <em>Warning Label</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.pins.VisiblePin#getGetChildren <em>Get Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.pins.PinsPackage#getVisiblePin()
 * @model
 * @generated
 */
public interface VisiblePin extends Pin {
	/**
	 * Returns the value of the '<em><b>Warning Label</b></em>' attribute.
	 * The default value is <code>"Need more children"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warning Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warning Label</em>' attribute.
	 * @see #setWarningLabel(String)
	 * @see org.eclipse.gmf.tooling.examples.pins.PinsPackage#getVisiblePin_WarningLabel()
	 * @model default="Need more children"
	 * @generated
	 */
	String getWarningLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.pins.VisiblePin#getWarningLabel <em>Warning Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warning Label</em>' attribute.
	 * @see #getWarningLabel()
	 * @generated
	 */
	void setWarningLabel(String value);

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
	 * @see org.eclipse.gmf.tooling.examples.pins.PinsPackage#getVisiblePin_GetChildren()
	 * @model containment="true"
	 * @generated
	 */
	EList<PinsChild> getGetChildren();

} // VisiblePin
