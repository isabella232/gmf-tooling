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
import org.eclipse.gmf.examples.eclipsecon.Handout;
import org.eclipse.gmf.examples.eclipsecon.HandoutKind;
import org.eclipse.gmf.examples.eclipsecon.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Handout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.HandoutImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.impl.HandoutImpl#getEclipsezilla <em>Eclipsezilla</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HandoutImpl extends EObjectImpl implements Handout {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final HandoutKind KIND_EDEFAULT = HandoutKind.PRINTED_LITERAL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected HandoutKind kind = KIND_EDEFAULT;

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
	protected HandoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EclipseconPackage.Literals.HANDOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HandoutKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(HandoutKind newKind) {
		HandoutKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseconPackage.HANDOUT__KIND, oldKind, kind));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EclipseconPackage.HANDOUT__ECLIPSEZILLA, oldEclipsezilla, eclipsezilla));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseconPackage.HANDOUT__ECLIPSEZILLA, oldEclipsezilla, eclipsezilla));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EclipseconPackage.HANDOUT__KIND:
				return getKind();
			case EclipseconPackage.HANDOUT__ECLIPSEZILLA:
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
			case EclipseconPackage.HANDOUT__KIND:
				setKind((HandoutKind)newValue);
				return;
			case EclipseconPackage.HANDOUT__ECLIPSEZILLA:
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
			case EclipseconPackage.HANDOUT__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case EclipseconPackage.HANDOUT__ECLIPSEZILLA:
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
			case EclipseconPackage.HANDOUT__KIND:
				return kind != KIND_EDEFAULT;
			case EclipseconPackage.HANDOUT__ECLIPSEZILLA:
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //HandoutImpl
