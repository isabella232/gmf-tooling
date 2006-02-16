/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.eclipsecon.*;

import org.eclipse.gmf.examples.eclipsecon.Conference;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Handout;
import org.eclipse.gmf.examples.eclipsecon.Participant;
import org.eclipse.gmf.examples.eclipsecon.Presenter;
import org.eclipse.gmf.examples.eclipsecon.Resource;
import org.eclipse.gmf.examples.eclipsecon.Schedule;
import org.eclipse.gmf.examples.eclipsecon.TimeSlot;
import org.eclipse.gmf.examples.eclipsecon.Tutorial;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconPackage
 * @generated
 */
public class EclipseconSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EclipseconPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EclipseconSwitch() {
		if (modelPackage == null) {
			modelPackage = EclipseconPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EclipseconPackage.SCHEDULE: {
				Schedule schedule = (Schedule)theEObject;
				Object result = caseSchedule(schedule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EclipseconPackage.TIME_SLOT: {
				TimeSlot timeSlot = (TimeSlot)theEObject;
				Object result = caseTimeSlot(timeSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EclipseconPackage.TUTORIAL: {
				Tutorial tutorial = (Tutorial)theEObject;
				Object result = caseTutorial(tutorial);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EclipseconPackage.CONFERENCE: {
				Conference conference = (Conference)theEObject;
				Object result = caseConference(conference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EclipseconPackage.PARTICIPANT: {
				Participant participant = (Participant)theEObject;
				Object result = caseParticipant(participant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EclipseconPackage.PRESENTER: {
				Presenter presenter = (Presenter)theEObject;
				Object result = casePresenter(presenter);
				if (result == null) result = caseParticipant(presenter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EclipseconPackage.HANDOUT: {
				Handout handout = (Handout)theEObject;
				Object result = caseHandout(handout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EclipseconPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				Object result = caseResource(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSchedule(Schedule object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Time Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Time Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTimeSlot(TimeSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Tutorial</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Tutorial</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTutorial(Tutorial object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Conference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Conference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConference(Conference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Participant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Participant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseParticipant(Participant object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Presenter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Presenter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePresenter(Presenter object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Handout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Handout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHandout(Handout object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //EclipseconSwitch
