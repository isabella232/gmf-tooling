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
 * A representation of the model object '<em><b>Tutorial</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Tutorial#getPresenters <em>Presenters</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Tutorial#getAssigned <em>Assigned</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Tutorial#getHandouts <em>Handouts</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.Tutorial#getTitle <em>Title</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getTutorial()
 * @model
 * @generated
 */
public interface Tutorial extends EObject {
	/**
	 * Returns the value of the '<em><b>Presenters</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.Presenter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Presenters</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presenters</em>' reference list.
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getTutorial_Presenters()
	 * @model type="org.eclipse.gmf.examples.eclipsecon.Presenter" upper="2"
	 * @generated
	 */
	EList getPresenters();

	/**
	 * Returns the value of the '<em><b>Assigned</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned</em>' reference.
	 * @see #setAssigned(TimeSlot)
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getTutorial_Assigned()
	 * @model
	 * @generated
	 */
	TimeSlot getAssigned();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.Tutorial#getAssigned <em>Assigned</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assigned</em>' reference.
	 * @see #getAssigned()
	 * @generated
	 */
	void setAssigned(TimeSlot value);

	/**
	 * Returns the value of the '<em><b>Handouts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.Handout}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handouts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handouts</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getTutorial_Handouts()
	 * @model type="org.eclipse.gmf.examples.eclipsecon.Handout" containment="true"
	 * @generated
	 */
	EList getHandouts();

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage#getTutorial_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.Tutorial#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

} // Tutorial
