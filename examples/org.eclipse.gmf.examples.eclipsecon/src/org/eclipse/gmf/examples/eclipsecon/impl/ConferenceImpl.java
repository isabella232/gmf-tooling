/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.examples.eclipsecon.Conference;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Participant;
import org.eclipse.gmf.examples.eclipsecon.Resource;
import org.eclipse.gmf.examples.eclipsecon.Schedule;
import org.eclipse.gmf.examples.eclipsecon.Tutorial;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.ConferenceImpl#getTutorials <em>Tutorials</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.ConferenceImpl#getAttendees <em>Attendees</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.ConferenceImpl#getDays <em>Days</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.ConferenceImpl#getEclipsezilla <em>Eclipsezilla</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConferenceImpl extends EObjectImpl implements Conference {
	/**
	 * The cached value of the '{@link #getTutorials() <em>Tutorials</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTutorials()
	 * @generated
	 * @ordered
	 */
	protected EList tutorials = null;

	/**
	 * The cached value of the '{@link #getAttendees() <em>Attendees</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttendees()
	 * @generated
	 * @ordered
	 */
	protected EList attendees = null;

	/**
	 * The cached value of the '{@link #getDays() <em>Days</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDays()
	 * @generated
	 * @ordered
	 */
	protected EList days = null;

	/**
	 * The cached value of the '{@link #getEclipsezilla() <em>Eclipsezilla</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEclipsezilla()
	 * @generated
	 * @ordered
	 */
	protected EList eclipsezilla = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EclipseconPackage.Literals.CONFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTutorials() {
		if (tutorials == null) {
			tutorials = new EObjectContainmentEList(Tutorial.class, this, EclipseconPackage.CONFERENCE__TUTORIALS);
		}
		return tutorials;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAttendees() {
		if (attendees == null) {
			attendees = new EObjectContainmentEList(Participant.class, this, EclipseconPackage.CONFERENCE__ATTENDEES);
		}
		return attendees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDays() {
		if (days == null) {
			days = new EObjectContainmentEList(Schedule.class, this, EclipseconPackage.CONFERENCE__DAYS);
		}
		return days;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEclipsezilla() {
		if (eclipsezilla == null) {
			eclipsezilla = new EObjectContainmentEList(Resource.class, this, EclipseconPackage.CONFERENCE__ECLIPSEZILLA);
		}
		return eclipsezilla;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EclipseconPackage.CONFERENCE__TUTORIALS:
				return ((InternalEList)getTutorials()).basicRemove(otherEnd, msgs);
			case EclipseconPackage.CONFERENCE__ATTENDEES:
				return ((InternalEList)getAttendees()).basicRemove(otherEnd, msgs);
			case EclipseconPackage.CONFERENCE__DAYS:
				return ((InternalEList)getDays()).basicRemove(otherEnd, msgs);
			case EclipseconPackage.CONFERENCE__ECLIPSEZILLA:
				return ((InternalEList)getEclipsezilla()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EclipseconPackage.CONFERENCE__TUTORIALS:
				return getTutorials();
			case EclipseconPackage.CONFERENCE__ATTENDEES:
				return getAttendees();
			case EclipseconPackage.CONFERENCE__DAYS:
				return getDays();
			case EclipseconPackage.CONFERENCE__ECLIPSEZILLA:
				return getEclipsezilla();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EclipseconPackage.CONFERENCE__TUTORIALS:
				getTutorials().clear();
				getTutorials().addAll((Collection)newValue);
				return;
			case EclipseconPackage.CONFERENCE__ATTENDEES:
				getAttendees().clear();
				getAttendees().addAll((Collection)newValue);
				return;
			case EclipseconPackage.CONFERENCE__DAYS:
				getDays().clear();
				getDays().addAll((Collection)newValue);
				return;
			case EclipseconPackage.CONFERENCE__ECLIPSEZILLA:
				getEclipsezilla().clear();
				getEclipsezilla().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case EclipseconPackage.CONFERENCE__TUTORIALS:
				getTutorials().clear();
				return;
			case EclipseconPackage.CONFERENCE__ATTENDEES:
				getAttendees().clear();
				return;
			case EclipseconPackage.CONFERENCE__DAYS:
				getDays().clear();
				return;
			case EclipseconPackage.CONFERENCE__ECLIPSEZILLA:
				getEclipsezilla().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EclipseconPackage.CONFERENCE__TUTORIALS:
				return tutorials != null && !tutorials.isEmpty();
			case EclipseconPackage.CONFERENCE__ATTENDEES:
				return attendees != null && !attendees.isEmpty();
			case EclipseconPackage.CONFERENCE__DAYS:
				return days != null && !days.isEmpty();
			case EclipseconPackage.CONFERENCE__ECLIPSEZILLA:
				return eclipsezilla != null && !eclipsezilla.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConferenceImpl
