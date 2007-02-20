/**
 * <copyright>
 * </copyright>
 *
 * $Id: Author.java,v 1.1 2007/02/20 01:36:47 ahunter Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.library;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Author#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Author#getBooks <em>Books</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getAuthor()
 * @model
 * @generated
 */
public interface Author extends EObject {
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
	 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getAuthor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.library.Author#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Books</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.eclipsecon.library.Book}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.eclipsecon.library.Book#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' reference list.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getAuthor_Books()
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Book#getAuthor
	 * @model type="org.eclipse.gmf.examples.eclipsecon.library.Book" opposite="author"
	 * @generated
	 */
	EList getBooks();

} // Author
