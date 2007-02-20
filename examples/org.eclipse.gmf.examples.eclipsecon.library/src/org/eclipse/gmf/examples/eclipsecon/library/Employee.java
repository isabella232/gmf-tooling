/**
 * <copyright>
 * </copyright>
 *
 * $Id: Employee.java,v 1.1 2007/02/20 01:36:47 ahunter Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.library;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Employee#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Employee#getShelves <em>Shelves</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getEmployee()
 * @model
 * @generated
 */
public interface Employee extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getEmployee_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.library.Employee#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Shelves</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.library.Shelf}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shelves</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shelves</em>' reference list.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getEmployee_Shelves()
	 * @model type="org.eclipse.gmf.examples.eclipsecon.library.Shelf"
	 * @generated
	 */
	EList getShelves();

} // Employee
