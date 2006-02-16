/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmf.examples.eclipsecon.*;

import org.eclipse.gmf.examples.eclipsecon.Conference;
import org.eclipse.gmf.examples.eclipsecon.EclipseconFactory;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Handout;
import org.eclipse.gmf.examples.eclipsecon.HandoutKind;
import org.eclipse.gmf.examples.eclipsecon.Participant;
import org.eclipse.gmf.examples.eclipsecon.Presenter;
import org.eclipse.gmf.examples.eclipsecon.Resource;
import org.eclipse.gmf.examples.eclipsecon.Schedule;
import org.eclipse.gmf.examples.eclipsecon.TimeSlot;
import org.eclipse.gmf.examples.eclipsecon.Tutorial;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EclipseconFactoryImpl extends EFactoryImpl implements EclipseconFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EclipseconFactory init() {
		try {
			EclipseconFactory theEclipseconFactory = (EclipseconFactory)EPackage.Registry.INSTANCE.getEFactory("uri://gmf/examples/eclipsecon"); 
			if (theEclipseconFactory != null) {
				return theEclipseconFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EclipseconFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EclipseconFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EclipseconPackage.SCHEDULE: return createSchedule();
			case EclipseconPackage.TIME_SLOT: return createTimeSlot();
			case EclipseconPackage.TUTORIAL: return createTutorial();
			case EclipseconPackage.CONFERENCE: return createConference();
			case EclipseconPackage.PARTICIPANT: return createParticipant();
			case EclipseconPackage.PRESENTER: return createPresenter();
			case EclipseconPackage.HANDOUT: return createHandout();
			case EclipseconPackage.RESOURCE: return createResource();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EclipseconPackage.HANDOUT_KIND:
				return createHandoutKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EclipseconPackage.HANDOUT_KIND:
				return convertHandoutKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schedule createSchedule() {
		ScheduleImpl schedule = new ScheduleImpl();
		return schedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeSlot createTimeSlot() {
		TimeSlotImpl timeSlot = new TimeSlotImpl();
		return timeSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tutorial createTutorial() {
		TutorialImpl tutorial = new TutorialImpl();
		return tutorial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Conference createConference() {
		ConferenceImpl conference = new ConferenceImpl();
		return conference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant createParticipant() {
		ParticipantImpl participant = new ParticipantImpl();
		return participant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Presenter createPresenter() {
		PresenterImpl presenter = new PresenterImpl();
		return presenter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Handout createHandout() {
		HandoutImpl handout = new HandoutImpl();
		return handout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HandoutKind createHandoutKindFromString(EDataType eDataType, String initialValue) {
		HandoutKind result = HandoutKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHandoutKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EclipseconPackage getEclipseconPackage() {
		return (EclipseconPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static EclipseconPackage getPackage() {
		return EclipseconPackage.eINSTANCE;
	}

} //EclipseconFactoryImpl
