/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage
 * @generated
 */
public interface EclipseconFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EclipseconFactory eINSTANCE = org.eclipse.gmf.examples.eclipsecon.impl.EclipseconFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule</em>'.
	 * @generated
	 */
	Schedule createSchedule();

	/**
	 * Returns a new object of class '<em>Time Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Slot</em>'.
	 * @generated
	 */
	TimeSlot createTimeSlot();

	/**
	 * Returns a new object of class '<em>Tutorial</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tutorial</em>'.
	 * @generated
	 */
	Tutorial createTutorial();

	/**
	 * Returns a new object of class '<em>Conference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conference</em>'.
	 * @generated
	 */
	Conference createConference();

	/**
	 * Returns a new object of class '<em>Participant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Participant</em>'.
	 * @generated
	 */
	Participant createParticipant();

	/**
	 * Returns a new object of class '<em>Presenter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Presenter</em>'.
	 * @generated
	 */
	Presenter createPresenter();

	/**
	 * Returns a new object of class '<em>Handout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Handout</em>'.
	 * @generated
	 */
	Handout createHandout();

	/**
	 * Returns a new object of class '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource</em>'.
	 * @generated
	 */
	Resource createResource();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EclipseconPackage getEclipseconPackage();

} //EclipseconFactory
