/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.eclipsecon.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Presenter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Presenter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.PresenterImpl#getBio <em>Bio</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.PresenterImpl#getPhone <em>Phone</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PresenterImpl extends ParticipantImpl implements Presenter {
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
	 * The default value of the '{@link #getPhone() <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhone()
	 * @generated
	 * @ordered
	 */
	protected static final int PHONE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPhone() <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhone()
	 * @generated
	 * @ordered
	 */
	protected int phone = PHONE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PresenterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EclipseconPackage.Literals.PRESENTER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseconPackage.PRESENTER__BIO, oldBio, bio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhone(int newPhone) {
		int oldPhone = phone;
		phone = newPhone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseconPackage.PRESENTER__PHONE, oldPhone, phone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EclipseconPackage.PRESENTER__BIO:
				return getBio();
			case EclipseconPackage.PRESENTER__PHONE:
				return new Integer(getPhone());
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
			case EclipseconPackage.PRESENTER__BIO:
				setBio((String)newValue);
				return;
			case EclipseconPackage.PRESENTER__PHONE:
				setPhone(((Integer)newValue).intValue());
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
			case EclipseconPackage.PRESENTER__BIO:
				setBio(BIO_EDEFAULT);
				return;
			case EclipseconPackage.PRESENTER__PHONE:
				setPhone(PHONE_EDEFAULT);
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
			case EclipseconPackage.PRESENTER__BIO:
				return BIO_EDEFAULT == null ? bio != null : !BIO_EDEFAULT.equals(bio);
			case EclipseconPackage.PRESENTER__PHONE:
				return phone != PHONE_EDEFAULT;
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
		result.append(", phone: ");
		result.append(phone);
		result.append(')');
		return result.toString();
	}

} //PresenterImpl
