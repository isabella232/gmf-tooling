/**
 * <copyright>
 * </copyright>
 *
 * $Id: Book.java,v 1.1 2007/02/20 01:36:47 ahunter Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.library;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Book#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.eclipsecon.library.Book#getAuthor <em>Author</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getBook_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.library.Book#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.eclipsecon.library.Author#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' reference.
	 * @see #setAuthor(Author)
	 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage#getBook_Author()
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Author#getBooks
	 * @model opposite="books" required="true"
	 * @generated
	 */
	Author getAuthor();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.library.Book#getAuthor <em>Author</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' reference.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(Author value);

} // Book
