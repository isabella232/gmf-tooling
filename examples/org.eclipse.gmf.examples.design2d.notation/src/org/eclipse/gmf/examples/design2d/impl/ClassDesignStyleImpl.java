/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.design2d.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.gmf.examples.design2d.ClassDesignStyle;
import org.eclipse.gmf.examples.design2d.Design2DPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Design Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.design2d.impl.ClassDesignStyleImpl#getQualifiedClassName <em>Qualified Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassDesignStyleImpl extends EObjectImpl implements ClassDesignStyle {
	/**
	 * The default value of the '{@link #getQualifiedClassName() <em>Qualified Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedClassName() <em>Qualified Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedClassName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedClassName = QUALIFIED_CLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDesignStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Design2DPackage.Literals.CLASS_DESIGN_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedClassName() {
		return qualifiedClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedClassName(String newQualifiedClassName) {
		String oldQualifiedClassName = qualifiedClassName;
		qualifiedClassName = newQualifiedClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Design2DPackage.CLASS_DESIGN_STYLE__QUALIFIED_CLASS_NAME, oldQualifiedClassName, qualifiedClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Design2DPackage.CLASS_DESIGN_STYLE__QUALIFIED_CLASS_NAME:
				return getQualifiedClassName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Design2DPackage.CLASS_DESIGN_STYLE__QUALIFIED_CLASS_NAME:
				setQualifiedClassName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Design2DPackage.CLASS_DESIGN_STYLE__QUALIFIED_CLASS_NAME:
				setQualifiedClassName(QUALIFIED_CLASS_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Design2DPackage.CLASS_DESIGN_STYLE__QUALIFIED_CLASS_NAME:
				return QUALIFIED_CLASS_NAME_EDEFAULT == null ? qualifiedClassName != null : !QUALIFIED_CLASS_NAME_EDEFAULT.equals(qualifiedClassName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (qualifiedClassName: "); //$NON-NLS-1$
		result.append(qualifiedClassName);
		result.append(')');
		return result.toString();
	}

} //ClassDesignStyleImpl
