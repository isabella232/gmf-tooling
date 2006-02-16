/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.eclipsecon.EclipseconFactory
 * @model kind="package"
 * @generated
 */
public interface EclipseconPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "eclipsecon";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "uri://gmf/examples/eclipsecon";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ec";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EclipseconPackage eINSTANCE = org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.ScheduleImpl <em>Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.ScheduleImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getSchedule()
	 * @generated
	 */
	int SCHEDULE = 0;

	/**
	 * The feature id for the '<em><b>Slices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE__SLICES = 0;

	/**
	 * The feature id for the '<em><b>Day No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE__DAY_NO = 1;

	/**
	 * The number of structural features of the '<em>Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.TimeSlotImpl <em>Time Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.TimeSlotImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getTimeSlot()
	 * @generated
	 */
	int TIME_SLOT = 1;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SLOT__START = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SLOT__END = 1;

	/**
	 * The number of structural features of the '<em>Time Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SLOT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.TutorialImpl <em>Tutorial</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.TutorialImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getTutorial()
	 * @generated
	 */
	int TUTORIAL = 2;

	/**
	 * The feature id for the '<em><b>Presenters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUTORIAL__PRESENTERS = 0;

	/**
	 * The feature id for the '<em><b>Assigned</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUTORIAL__ASSIGNED = 1;

	/**
	 * The feature id for the '<em><b>Handouts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUTORIAL__HANDOUTS = 2;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUTORIAL__TITLE = 3;

	/**
	 * The number of structural features of the '<em>Tutorial</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUTORIAL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.ConferenceImpl <em>Conference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.ConferenceImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getConference()
	 * @generated
	 */
	int CONFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Tutorials</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFERENCE__TUTORIALS = 0;

	/**
	 * The feature id for the '<em><b>Attendees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFERENCE__ATTENDEES = 1;

	/**
	 * The feature id for the '<em><b>Days</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFERENCE__DAYS = 2;

	/**
	 * The feature id for the '<em><b>Eclipsezilla</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFERENCE__ECLIPSEZILLA = 3;

	/**
	 * The number of structural features of the '<em>Conference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFERENCE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.ParticipantImpl <em>Participant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.ParticipantImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getParticipant()
	 * @generated
	 */
	int PARTICIPANT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.PresenterImpl <em>Presenter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.PresenterImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getPresenter()
	 * @generated
	 */
	int PRESENTER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTER__NAME = PARTICIPANT__NAME;

	/**
	 * The feature id for the '<em><b>Bio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTER__BIO = PARTICIPANT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTER__PHONE = PARTICIPANT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Presenter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTER_FEATURE_COUNT = PARTICIPANT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.HandoutImpl <em>Handout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.HandoutImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getHandout()
	 * @generated
	 */
	int HANDOUT = 6;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDOUT__KIND = 0;

	/**
	 * The feature id for the '<em><b>Eclipsezilla</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDOUT__ECLIPSEZILLA = 1;

	/**
	 * The number of structural features of the '<em>Handout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDOUT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.ResourceImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__LOCATION = 1;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.HandoutKind <em>Handout Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.HandoutKind
	 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getHandoutKind()
	 * @generated
	 */
	int HANDOUT_KIND = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.Schedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Schedule
	 * @generated
	 */
	EClass getSchedule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.eclipsecon.Schedule#getSlices <em>Slices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slices</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Schedule#getSlices()
	 * @see #getSchedule()
	 * @generated
	 */
	EReference getSchedule_Slices();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.Schedule#getDayNo <em>Day No</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Day No</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Schedule#getDayNo()
	 * @see #getSchedule()
	 * @generated
	 */
	EAttribute getSchedule_DayNo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.TimeSlot <em>Time Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Slot</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.TimeSlot
	 * @generated
	 */
	EClass getTimeSlot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.TimeSlot#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.TimeSlot#getStart()
	 * @see #getTimeSlot()
	 * @generated
	 */
	EAttribute getTimeSlot_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.TimeSlot#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.TimeSlot#getEnd()
	 * @see #getTimeSlot()
	 * @generated
	 */
	EAttribute getTimeSlot_End();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.Tutorial <em>Tutorial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tutorial</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Tutorial
	 * @generated
	 */
	EClass getTutorial();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.examples.eclipsecon.Tutorial#getPresenters <em>Presenters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Presenters</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Tutorial#getPresenters()
	 * @see #getTutorial()
	 * @generated
	 */
	EReference getTutorial_Presenters();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.eclipsecon.Tutorial#getAssigned <em>Assigned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assigned</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Tutorial#getAssigned()
	 * @see #getTutorial()
	 * @generated
	 */
	EReference getTutorial_Assigned();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.eclipsecon.Tutorial#getHandouts <em>Handouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Handouts</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Tutorial#getHandouts()
	 * @see #getTutorial()
	 * @generated
	 */
	EReference getTutorial_Handouts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.Tutorial#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Tutorial#getTitle()
	 * @see #getTutorial()
	 * @generated
	 */
	EAttribute getTutorial_Title();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.Conference <em>Conference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conference</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Conference
	 * @generated
	 */
	EClass getConference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.eclipsecon.Conference#getTutorials <em>Tutorials</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tutorials</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Conference#getTutorials()
	 * @see #getConference()
	 * @generated
	 */
	EReference getConference_Tutorials();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.eclipsecon.Conference#getAttendees <em>Attendees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attendees</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Conference#getAttendees()
	 * @see #getConference()
	 * @generated
	 */
	EReference getConference_Attendees();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.eclipsecon.Conference#getDays <em>Days</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Days</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Conference#getDays()
	 * @see #getConference()
	 * @generated
	 */
	EReference getConference_Days();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.eclipsecon.Conference#getEclipsezilla <em>Eclipsezilla</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Eclipsezilla</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Conference#getEclipsezilla()
	 * @see #getConference()
	 * @generated
	 */
	EReference getConference_Eclipsezilla();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Participant
	 * @generated
	 */
	EClass getParticipant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.Participant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Participant#getName()
	 * @see #getParticipant()
	 * @generated
	 */
	EAttribute getParticipant_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.Presenter <em>Presenter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presenter</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Presenter
	 * @generated
	 */
	EClass getPresenter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.Presenter#getBio <em>Bio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bio</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Presenter#getBio()
	 * @see #getPresenter()
	 * @generated
	 */
	EAttribute getPresenter_Bio();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.Presenter#getPhone <em>Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Presenter#getPhone()
	 * @see #getPresenter()
	 * @generated
	 */
	EAttribute getPresenter_Phone();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.Handout <em>Handout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Handout</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Handout
	 * @generated
	 */
	EClass getHandout();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.Handout#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Handout#getKind()
	 * @see #getHandout()
	 * @generated
	 */
	EAttribute getHandout_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.eclipsecon.Handout#getEclipsezilla <em>Eclipsezilla</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Eclipsezilla</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Handout#getEclipsezilla()
	 * @see #getHandout()
	 * @generated
	 */
	EReference getHandout_Eclipsezilla();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.Resource#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.Resource#getLocation()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Location();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.gmf.examples.eclipsecon.HandoutKind <em>Handout Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Handout Kind</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.HandoutKind
	 * @generated
	 */
	EEnum getHandoutKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EclipseconFactory getEclipseconFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.ScheduleImpl <em>Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.ScheduleImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getSchedule()
		 * @generated
		 */
		EClass SCHEDULE = eINSTANCE.getSchedule();

		/**
		 * The meta object literal for the '<em><b>Slices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE__SLICES = eINSTANCE.getSchedule_Slices();

		/**
		 * The meta object literal for the '<em><b>Day No</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULE__DAY_NO = eINSTANCE.getSchedule_DayNo();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.TimeSlotImpl <em>Time Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.TimeSlotImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getTimeSlot()
		 * @generated
		 */
		EClass TIME_SLOT = eINSTANCE.getTimeSlot();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_SLOT__START = eINSTANCE.getTimeSlot_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_SLOT__END = eINSTANCE.getTimeSlot_End();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.TutorialImpl <em>Tutorial</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.TutorialImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getTutorial()
		 * @generated
		 */
		EClass TUTORIAL = eINSTANCE.getTutorial();

		/**
		 * The meta object literal for the '<em><b>Presenters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUTORIAL__PRESENTERS = eINSTANCE.getTutorial_Presenters();

		/**
		 * The meta object literal for the '<em><b>Assigned</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUTORIAL__ASSIGNED = eINSTANCE.getTutorial_Assigned();

		/**
		 * The meta object literal for the '<em><b>Handouts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUTORIAL__HANDOUTS = eINSTANCE.getTutorial_Handouts();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TUTORIAL__TITLE = eINSTANCE.getTutorial_Title();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.ConferenceImpl <em>Conference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.ConferenceImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getConference()
		 * @generated
		 */
		EClass CONFERENCE = eINSTANCE.getConference();

		/**
		 * The meta object literal for the '<em><b>Tutorials</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFERENCE__TUTORIALS = eINSTANCE.getConference_Tutorials();

		/**
		 * The meta object literal for the '<em><b>Attendees</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFERENCE__ATTENDEES = eINSTANCE.getConference_Attendees();

		/**
		 * The meta object literal for the '<em><b>Days</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFERENCE__DAYS = eINSTANCE.getConference_Days();

		/**
		 * The meta object literal for the '<em><b>Eclipsezilla</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFERENCE__ECLIPSEZILLA = eINSTANCE.getConference_Eclipsezilla();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.ParticipantImpl <em>Participant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.ParticipantImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getParticipant()
		 * @generated
		 */
		EClass PARTICIPANT = eINSTANCE.getParticipant();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTICIPANT__NAME = eINSTANCE.getParticipant_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.PresenterImpl <em>Presenter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.PresenterImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getPresenter()
		 * @generated
		 */
		EClass PRESENTER = eINSTANCE.getPresenter();

		/**
		 * The meta object literal for the '<em><b>Bio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRESENTER__BIO = eINSTANCE.getPresenter_Bio();

		/**
		 * The meta object literal for the '<em><b>Phone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRESENTER__PHONE = eINSTANCE.getPresenter_Phone();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.HandoutImpl <em>Handout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.HandoutImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getHandout()
		 * @generated
		 */
		EClass HANDOUT = eINSTANCE.getHandout();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDOUT__KIND = eINSTANCE.getHandout_Kind();

		/**
		 * The meta object literal for the '<em><b>Eclipsezilla</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HANDOUT__ECLIPSEZILLA = eINSTANCE.getHandout_Eclipsezilla();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.ResourceImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__LOCATION = eINSTANCE.getResource_Location();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.HandoutKind <em>Handout Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.HandoutKind
		 * @see org.eclipse.gmf.examples.eclipsecon.impl.EclipseconPackageImpl#getHandoutKind()
		 * @generated
		 */
		EEnum HANDOUT_KIND = eINSTANCE.getHandoutKind();

	}

} //EclipseconPackage
