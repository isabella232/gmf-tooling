/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Schedule;
import org.eclipse.gmf.examples.eclipsecon.TimeSlot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Schedule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.ScheduleImpl#getSlices <em>Slices</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.ScheduleImpl#getDayNo <em>Day No</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScheduleImpl extends EObjectImpl implements Schedule {
	/**
	 * The cached value of the '{@link #getSlices() <em>Slices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlices()
	 * @generated
	 * @ordered
	 */
	protected EList slices = null;

	/**
	 * The default value of the '{@link #getDayNo() <em>Day No</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDayNo()
	 * @generated
	 * @ordered
	 */
	protected static final int DAY_NO_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDayNo() <em>Day No</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDayNo()
	 * @generated
	 * @ordered
	 */
	protected int dayNo = DAY_NO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScheduleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EclipseconPackage.Literals.SCHEDULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSlices() {
		if (slices == null) {
			slices = new EObjectContainmentEList(TimeSlot.class, this, EclipseconPackage.SCHEDULE__SLICES);
		}
		return slices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDayNo() {
		return dayNo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDayNo(int newDayNo) {
		int oldDayNo = dayNo;
		dayNo = newDayNo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseconPackage.SCHEDULE__DAY_NO, oldDayNo, dayNo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EclipseconPackage.SCHEDULE__SLICES:
				return ((InternalEList)getSlices()).basicRemove(otherEnd, msgs);
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
			case EclipseconPackage.SCHEDULE__SLICES:
				return getSlices();
			case EclipseconPackage.SCHEDULE__DAY_NO:
				return new Integer(getDayNo());
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
			case EclipseconPackage.SCHEDULE__SLICES:
				getSlices().clear();
				getSlices().addAll((Collection)newValue);
				return;
			case EclipseconPackage.SCHEDULE__DAY_NO:
				setDayNo(((Integer)newValue).intValue());
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
			case EclipseconPackage.SCHEDULE__SLICES:
				getSlices().clear();
				return;
			case EclipseconPackage.SCHEDULE__DAY_NO:
				setDayNo(DAY_NO_EDEFAULT);
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
			case EclipseconPackage.SCHEDULE__SLICES:
				return slices != null && !slices.isEmpty();
			case EclipseconPackage.SCHEDULE__DAY_NO:
				return dayNo != DAY_NO_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dayNo: ");
		result.append(dayNo);
		result.append(')');
		return result.toString();
	}

} //ScheduleImpl
