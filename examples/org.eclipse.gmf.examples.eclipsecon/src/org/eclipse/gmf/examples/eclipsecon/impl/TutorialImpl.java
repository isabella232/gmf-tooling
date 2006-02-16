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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Handout;
import org.eclipse.gmf.examples.eclipsecon.Presenter;
import org.eclipse.gmf.examples.eclipsecon.TimeSlot;
import org.eclipse.gmf.examples.eclipsecon.Tutorial;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tutorial</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.TutorialImpl#getPresenters <em>Presenters</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.TutorialImpl#getAssigned <em>Assigned</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.TutorialImpl#getHandouts <em>Handouts</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.TutorialImpl#getTitle <em>Title</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TutorialImpl extends EObjectImpl implements Tutorial {
	/**
	 * The cached value of the '{@link #getPresenters() <em>Presenters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresenters()
	 * @generated
	 * @ordered
	 */
	protected EList presenters = null;

	/**
	 * The cached value of the '{@link #getAssigned() <em>Assigned</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssigned()
	 * @generated
	 * @ordered
	 */
	protected TimeSlot assigned = null;

	/**
	 * The cached value of the '{@link #getHandouts() <em>Handouts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandouts()
	 * @generated
	 * @ordered
	 */
	protected EList handouts = null;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TutorialImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EclipseconPackage.Literals.TUTORIAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPresenters() {
		if (presenters == null) {
			presenters = new EObjectResolvingEList(Presenter.class, this, EclipseconPackage.TUTORIAL__PRESENTERS);
		}
		return presenters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeSlot getAssigned() {
		if (assigned != null && assigned.eIsProxy()) {
			InternalEObject oldAssigned = (InternalEObject)assigned;
			assigned = (TimeSlot)eResolveProxy(oldAssigned);
			if (assigned != oldAssigned) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EclipseconPackage.TUTORIAL__ASSIGNED, oldAssigned, assigned));
			}
		}
		return assigned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeSlot basicGetAssigned() {
		return assigned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssigned(TimeSlot newAssigned) {
		TimeSlot oldAssigned = assigned;
		assigned = newAssigned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseconPackage.TUTORIAL__ASSIGNED, oldAssigned, assigned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getHandouts() {
		if (handouts == null) {
			handouts = new EObjectContainmentEList(Handout.class, this, EclipseconPackage.TUTORIAL__HANDOUTS);
		}
		return handouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseconPackage.TUTORIAL__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EclipseconPackage.TUTORIAL__HANDOUTS:
				return ((InternalEList)getHandouts()).basicRemove(otherEnd, msgs);
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
			case EclipseconPackage.TUTORIAL__PRESENTERS:
				return getPresenters();
			case EclipseconPackage.TUTORIAL__ASSIGNED:
				if (resolve) return getAssigned();
				return basicGetAssigned();
			case EclipseconPackage.TUTORIAL__HANDOUTS:
				return getHandouts();
			case EclipseconPackage.TUTORIAL__TITLE:
				return getTitle();
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
			case EclipseconPackage.TUTORIAL__PRESENTERS:
				getPresenters().clear();
				getPresenters().addAll((Collection)newValue);
				return;
			case EclipseconPackage.TUTORIAL__ASSIGNED:
				setAssigned((TimeSlot)newValue);
				return;
			case EclipseconPackage.TUTORIAL__HANDOUTS:
				getHandouts().clear();
				getHandouts().addAll((Collection)newValue);
				return;
			case EclipseconPackage.TUTORIAL__TITLE:
				setTitle((String)newValue);
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
			case EclipseconPackage.TUTORIAL__PRESENTERS:
				getPresenters().clear();
				return;
			case EclipseconPackage.TUTORIAL__ASSIGNED:
				setAssigned((TimeSlot)null);
				return;
			case EclipseconPackage.TUTORIAL__HANDOUTS:
				getHandouts().clear();
				return;
			case EclipseconPackage.TUTORIAL__TITLE:
				setTitle(TITLE_EDEFAULT);
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
			case EclipseconPackage.TUTORIAL__PRESENTERS:
				return presenters != null && !presenters.isEmpty();
			case EclipseconPackage.TUTORIAL__ASSIGNED:
				return assigned != null;
			case EclipseconPackage.TUTORIAL__HANDOUTS:
				return handouts != null && !handouts.isEmpty();
			case EclipseconPackage.TUTORIAL__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
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
		result.append(" (title: ");
		result.append(title);
		result.append(')');
		return result.toString();
	}

} //TutorialImpl
