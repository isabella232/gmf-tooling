/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Schedule#getSlices <em>Slices</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Schedule#getDayNo <em>Day No</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getSchedule()
 * @model
 * @generated
 */
public interface Schedule extends EObject {
	/**
	 * Returns the value of the '<em><b>Slices</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.TimeSlot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slices</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slices</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getSchedule_Slices()
	 * @model type="org.eclipse.gmf.examples.eclipsecon.TimeSlot" containment="true" upper="5"
	 * @generated
	 */
	EList getSlices();

	/**
	 * Returns the value of the '<em><b>Day No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Day No</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Day No</em>' attribute.
	 * @see #setDayNo(int)
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getSchedule_DayNo()
	 * @model
	 * @generated
	 */
	int getDayNo();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.Schedule#getDayNo <em>Day No</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day No</em>' attribute.
	 * @see #getDayNo()
	 * @generated
	 */
	void setDayNo(int value);

} // Schedule
