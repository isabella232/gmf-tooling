/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmployeeImpl.java,v 1.2 2007/02/22 21:48:18 ahunter Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.library.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.gmf.examples.eclipsecon.library.Employee;
import org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage;
import org.eclipse.gmf.examples.eclipsecon.library.Shelf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.impl.EmployeeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.impl.EmployeeImpl#getShelves <em>Shelves</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmployeeImpl extends EObjectImpl implements Employee {
	/**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected static final String NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected String name = NAME_EDEFAULT;

	/**
     * The cached value of the '{@link #getShelves() <em>Shelves</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getShelves()
     * @generated
     * @ordered
     */
	protected EList shelves = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EmployeeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return LibraryPackage.Literals.EMPLOYEE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
        return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EMPLOYEE__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getShelves() {
        if (shelves == null) {
            shelves = new EObjectResolvingEList(Shelf.class, this, LibraryPackage.EMPLOYEE__SHELVES);
        }
        return shelves;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case LibraryPackage.EMPLOYEE__NAME:
                return getName();
            case LibraryPackage.EMPLOYEE__SHELVES:
                return getShelves();
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
            case LibraryPackage.EMPLOYEE__NAME:
                setName((String)newValue);
                return;
            case LibraryPackage.EMPLOYEE__SHELVES:
                getShelves().clear();
                getShelves().addAll((Collection)newValue);
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
            case LibraryPackage.EMPLOYEE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case LibraryPackage.EMPLOYEE__SHELVES:
                getShelves().clear();
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
            case LibraryPackage.EMPLOYEE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case LibraryPackage.EMPLOYEE__SHELVES:
                return shelves != null && !shelves.isEmpty();
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //EmployeeImpl
