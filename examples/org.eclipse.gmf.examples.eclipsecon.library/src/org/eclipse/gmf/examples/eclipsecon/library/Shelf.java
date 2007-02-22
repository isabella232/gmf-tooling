/**
 * <copyright>
 * </copyright>
 *
 * $Id: Shelf.java,v 1.2 2007/02/22 21:48:18 ahunter Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.library;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shelf</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Shelf#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Shelf#getBooks <em>Books</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getShelf()
 * @model
 * @generated
 */
public interface Shelf extends EObject {
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
     * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getShelf_Name()
     * @model
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.library.Shelf#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Books</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.library.Book}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Books</em>' containment reference list.
     * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getShelf_Books()
     * @model type="org.eclipse.gmf.examples.eclipsecon.library.Book" containment="true"
     * @generated
     */
	EList getBooks();

} // Shelf
