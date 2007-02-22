/**
 * <copyright>
 * </copyright>
 *
 * $Id: LibraryImpl.java,v 1.2 2007/02/22 21:48:18 ahunter Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.library.impl;

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

import org.eclipse.gmf.examples.eclipsecon.library.Author;
import org.eclipse.gmf.examples.eclipsecon.library.Employee;
import org.eclipse.gmf.examples.eclipsecon.library.Library;
import org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage;
import org.eclipse.gmf.examples.eclipsecon.library.Shelf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryImpl#getShelves <em>Shelves</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryImpl#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryImpl#getEmployees <em>Employees</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends EObjectImpl implements Library {
	/**
     * The cached value of the '{@link #getShelves() <em>Shelves</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getShelves()
     * @generated
     * @ordered
     */
	protected EList shelves = null;

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
     * The cached value of the '{@link #getAuthors() <em>Authors</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAuthors()
     * @generated
     * @ordered
     */
	protected EList authors = null;

	/**
     * The cached value of the '{@link #getEmployees() <em>Employees</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEmployees()
     * @generated
     * @ordered
     */
	protected EList employees = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected LibraryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return LibraryPackage.Literals.LIBRARY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getShelves() {
        if (shelves == null) {
            shelves = new EObjectContainmentEList(Shelf.class, this, LibraryPackage.LIBRARY__SHELVES);
        }
        return shelves;
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
            eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.LIBRARY__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getAuthors() {
        if (authors == null) {
            authors = new EObjectContainmentEList(Author.class, this, LibraryPackage.LIBRARY__AUTHORS);
        }
        return authors;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getEmployees() {
        if (employees == null) {
            employees = new EObjectContainmentEList(Employee.class, this, LibraryPackage.LIBRARY__EMPLOYEES);
        }
        return employees;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case LibraryPackage.LIBRARY__SHELVES:
                return ((InternalEList)getShelves()).basicRemove(otherEnd, msgs);
            case LibraryPackage.LIBRARY__AUTHORS:
                return ((InternalEList)getAuthors()).basicRemove(otherEnd, msgs);
            case LibraryPackage.LIBRARY__EMPLOYEES:
                return ((InternalEList)getEmployees()).basicRemove(otherEnd, msgs);
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
            case LibraryPackage.LIBRARY__SHELVES:
                return getShelves();
            case LibraryPackage.LIBRARY__NAME:
                return getName();
            case LibraryPackage.LIBRARY__AUTHORS:
                return getAuthors();
            case LibraryPackage.LIBRARY__EMPLOYEES:
                return getEmployees();
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
            case LibraryPackage.LIBRARY__SHELVES:
                getShelves().clear();
                getShelves().addAll((Collection)newValue);
                return;
            case LibraryPackage.LIBRARY__NAME:
                setName((String)newValue);
                return;
            case LibraryPackage.LIBRARY__AUTHORS:
                getAuthors().clear();
                getAuthors().addAll((Collection)newValue);
                return;
            case LibraryPackage.LIBRARY__EMPLOYEES:
                getEmployees().clear();
                getEmployees().addAll((Collection)newValue);
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
            case LibraryPackage.LIBRARY__SHELVES:
                getShelves().clear();
                return;
            case LibraryPackage.LIBRARY__NAME:
                setName(NAME_EDEFAULT);
                return;
            case LibraryPackage.LIBRARY__AUTHORS:
                getAuthors().clear();
                return;
            case LibraryPackage.LIBRARY__EMPLOYEES:
                getEmployees().clear();
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
            case LibraryPackage.LIBRARY__SHELVES:
                return shelves != null && !shelves.isEmpty();
            case LibraryPackage.LIBRARY__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case LibraryPackage.LIBRARY__AUTHORS:
                return authors != null && !authors.isEmpty();
            case LibraryPackage.LIBRARY__EMPLOYEES:
                return employees != null && !employees.isEmpty();
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

} //LibraryImpl
