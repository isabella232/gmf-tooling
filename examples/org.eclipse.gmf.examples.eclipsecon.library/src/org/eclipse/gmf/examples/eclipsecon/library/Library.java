/**
 * <copyright>
 * </copyright>
 *
 * $Id: Library.java,v 1.2 2007/02/22 21:48:18 ahunter Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.library;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Library#getShelves <em>Shelves</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Library#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Library#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Library#getEmployees <em>Employees</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends EObject {
	/**
     * Returns the value of the '<em><b>Shelves</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.library.Shelf}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shelves</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Shelves</em>' containment reference list.
     * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getLibrary_Shelves()
     * @model type="org.eclipse.gmf.examples.eclipsecon.library.Shelf" containment="true"
     * @generated
     */
	EList getShelves();

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
     * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getLibrary_Name()
     * @model
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.library.Library#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Authors</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.library.Author}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Authors</em>' containment reference list.
     * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getLibrary_Authors()
     * @model type="org.eclipse.gmf.examples.eclipsecon.library.Author" containment="true"
     * @generated
     */
	EList getAuthors();

	/**
     * Returns the value of the '<em><b>Employees</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.library.Employee}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Employees</em>' containment reference list.
     * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getLibrary_Employees()
     * @model type="org.eclipse.gmf.examples.eclipsecon.library.Employee" containment="true"
     * @generated
     */
	EList getEmployees();

} // Library
