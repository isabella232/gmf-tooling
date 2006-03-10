/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Profile;
import org.eclipse.gmf.examples.eclipsecon.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.ProfileImpl#getBio <em>Bio</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.ProfileImpl#getEclipsezilla <em>Eclipsezilla</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfileImpl extends EObjectImpl implements Profile {
	/**
	 * The default value of the '{@link #getBio() <em>Bio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBio()
	 * @generated
	 * @ordered
	 */
	protected static final String BIO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBio() <em>Bio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBio()
	 * @generated
	 * @ordered
	 */
	protected String bio = BIO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEclipsezilla() <em>Eclipsezilla</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEclipsezilla()
	 * @generated
	 * @ordered
	 */
	protected Resource eclipsezilla = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EclipseconPackage.Literals.PROFILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBio(String newBio) {
		String oldBio = bio;
		bio = newBio;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseconPackage.PROFILE__BIO, oldBio, bio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getEclipsezilla() {
		if (eclipsezilla != null && eclipsezilla.eIsProxy()) {
			InternalEObject oldEclipsezilla = (InternalEObject)eclipsezilla;
			eclipsezilla = (Resource)eResolveProxy(oldEclipsezilla);
			if (eclipsezilla != oldEclipsezilla) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EclipseconPackage.PROFILE__ECLIPSEZILLA, oldEclipsezilla, eclipsezilla));
			}
		}
		return eclipsezilla;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetEclipsezilla() {
		return eclipsezilla;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEclipsezilla(Resource newEclipsezilla) {
		Resource oldEclipsezilla = eclipsezilla;
		eclipsezilla = newEclipsezilla;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseconPackage.PROFILE__ECLIPSEZILLA, oldEclipsezilla, eclipsezilla));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EclipseconPackage.PROFILE__BIO:
				return getBio();
			case EclipseconPackage.PROFILE__ECLIPSEZILLA:
				if (resolve) return getEclipsezilla();
				return basicGetEclipsezilla();
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
			case EclipseconPackage.PROFILE__BIO:
				setBio((String)newValue);
				return;
			case EclipseconPackage.PROFILE__ECLIPSEZILLA:
				setEclipsezilla((Resource)newValue);
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
			case EclipseconPackage.PROFILE__BIO:
				setBio(BIO_EDEFAULT);
				return;
			case EclipseconPackage.PROFILE__ECLIPSEZILLA:
				setEclipsezilla((Resource)null);
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
			case EclipseconPackage.PROFILE__BIO:
				return BIO_EDEFAULT == null ? bio != null : !BIO_EDEFAULT.equals(bio);
			case EclipseconPackage.PROFILE__ECLIPSEZILLA:
				return eclipsezilla != null;
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
		result.append(" (bio: ");
		result.append(bio);
		result.append(')');
		return result.toString();
	}

} //ProfileImpl
