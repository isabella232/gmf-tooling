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
 * A representation of the model object '<em><b>Conference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Conference#getTutorials <em>Tutorials</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Conference#getAttendees <em>Attendees</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Conference#getDays <em>Days</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Conference#getEclipsezilla <em>Eclipsezilla</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getConference()
 * @model
 * @generated
 */
public interface Conference extends EObject {
	/**
	 * Returns the value of the '<em><b>Tutorials</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.Tutorial}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tutorials</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tutorials</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getConference_Tutorials()
	 * @model type="org.eclipse.gmf.examples.eclipsecon.Tutorial" containment="true" upper="20"
	 * @generated
	 */
	EList getTutorials();

	/**
	 * Returns the value of the '<em><b>Attendees</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.Participant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attendees</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attendees</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getConference_Attendees()
	 * @model type="org.eclipse.gmf.examples.eclipsecon.Participant" containment="true"
	 * @generated
	 */
	EList getAttendees();

	/**
	 * Returns the value of the '<em><b>Days</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.Schedule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Days</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Days</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getConference_Days()
	 * @model type="org.eclipse.gmf.examples.eclipsecon.Schedule" containment="true" upper="2"
	 * @generated
	 */
	EList getDays();

	/**
	 * Returns the value of the '<em><b>Eclipsezilla</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eclipsezilla</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eclipsezilla</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getConference_Eclipsezilla()
	 * @model type="org.eclipse.gmf.examples.eclipsecon.Resource" containment="true"
	 * @generated
	 */
	EList getEclipsezilla();

} // Conference
