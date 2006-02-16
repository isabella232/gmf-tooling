/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.TimeSlot#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.TimeSlot#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getTimeSlot()
 * @model
 * @generated
 */
public interface TimeSlot extends EObject {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(String)
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getTimeSlot_Start()
	 * @model
	 * @generated
	 */
	String getStart();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.TimeSlot#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(String value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(String)
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getTimeSlot_End()
	 * @model
	 * @generated
	 */
	String getEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.TimeSlot#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(String value);

} // TimeSlot
