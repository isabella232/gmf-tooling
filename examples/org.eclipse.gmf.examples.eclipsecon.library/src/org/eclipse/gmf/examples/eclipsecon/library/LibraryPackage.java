/**
 * <copyright>
 * </copyright>
 *
 * $Id: LibraryPackage.java,v 1.1 2007/02/20 01:36:47 ahunter Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.library;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.eclipsecon.library.LibraryFactory
 * @model kind="package"
 * @generated
 */
public interface LibraryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "library";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/gmf/examples/library.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.gmf.examples.eclipsecon.library";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LibraryPackage eINSTANCE = org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.library.impl.AuthorImpl <em>Author</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.AuthorImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryPackageImpl#getAuthor()
	 * @generated
	 */
	int AUTHOR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Books</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__BOOKS = 1;

	/**
	 * The number of structural features of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.library.impl.BookImpl <em>Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.BookImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__AUTHOR = 1;

	/**
	 * The number of structural features of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.library.impl.EmployeeImpl <em>Employee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.EmployeeImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryPackageImpl#getEmployee()
	 * @generated
	 */
	int EMPLOYEE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Shelves</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__SHELVES = 1;

	/**
	 * The number of structural features of the '<em>Employee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 3;

	/**
	 * The feature id for the '<em><b>Shelves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__SHELVES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NAME = 1;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__AUTHORS = 2;

	/**
	 * The feature id for the '<em><b>Employees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EMPLOYEES = 3;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.library.impl.ShelfImpl <em>Shelf</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.ShelfImpl
	 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryPackageImpl#getShelf()
	 * @generated
	 */
	int SHELF = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELF__NAME = 0;

	/**
	 * The feature id for the '<em><b>Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELF__BOOKS = 1;

	/**
	 * The number of structural features of the '<em>Shelf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELF_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.library.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Author</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Author
	 * @generated
	 */
	EClass getAuthor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.library.Author#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Author#getName()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.examples.eclipsecon.library.Author#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Books</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Author#getBooks()
	 * @see #getAuthor()
	 * @generated
	 */
	EReference getAuthor_Books();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.library.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.library.Book#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Book#getTitle()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Title();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.eclipsecon.library.Book#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Author</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Book#getAuthor()
	 * @see #getBook()
	 * @generated
	 */
	EReference getBook_Author();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.library.Employee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Employee</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Employee
	 * @generated
	 */
	EClass getEmployee();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.library.Employee#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Employee#getName()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.examples.eclipsecon.library.Employee#getShelves <em>Shelves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shelves</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Employee#getShelves()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Shelves();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.library.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.eclipsecon.library.Library#getShelves <em>Shelves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Shelves</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Library#getShelves()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Shelves();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.library.Library#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Library#getName()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.eclipsecon.library.Library#getAuthors <em>Authors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Authors</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Library#getAuthors()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Authors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.eclipsecon.library.Library#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Employees</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Library#getEmployees()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Employees();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.library.Shelf <em>Shelf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shelf</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Shelf
	 * @generated
	 */
	EClass getShelf();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.library.Shelf#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Shelf#getName()
	 * @see #getShelf()
	 * @generated
	 */
	EAttribute getShelf_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.eclipsecon.library.Shelf#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Books</em>'.
	 * @see org.eclipse.gmf.examples.eclipsecon.library.Shelf#getBooks()
	 * @see #getShelf()
	 * @generated
	 */
	EReference getShelf_Books();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LibraryFactory getLibraryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.library.impl.AuthorImpl <em>Author</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.AuthorImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryPackageImpl#getAuthor()
		 * @generated
		 */
		EClass AUTHOR = eINSTANCE.getAuthor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__NAME = eINSTANCE.getAuthor_Name();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHOR__BOOKS = eINSTANCE.getAuthor_Books();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.library.impl.BookImpl <em>Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.BookImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__TITLE = eINSTANCE.getBook_Title();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK__AUTHOR = eINSTANCE.getBook_Author();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.library.impl.EmployeeImpl <em>Employee</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.EmployeeImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryPackageImpl#getEmployee()
		 * @generated
		 */
		EClass EMPLOYEE = eINSTANCE.getEmployee();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__NAME = eINSTANCE.getEmployee_Name();

		/**
		 * The meta object literal for the '<em><b>Shelves</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__SHELVES = eINSTANCE.getEmployee_Shelves();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Shelves</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__SHELVES = eINSTANCE.getLibrary_Shelves();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__NAME = eINSTANCE.getLibrary_Name();

		/**
		 * The meta object literal for the '<em><b>Authors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__AUTHORS = eINSTANCE.getLibrary_Authors();

		/**
		 * The meta object literal for the '<em><b>Employees</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__EMPLOYEES = eINSTANCE.getLibrary_Employees();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.library.impl.ShelfImpl <em>Shelf</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.ShelfImpl
		 * @see org.eclipse.gmf.examples.eclipsecon.library.impl.LibraryPackageImpl#getShelf()
		 * @generated
		 */
		EClass SHELF = eINSTANCE.getShelf();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHELF__NAME = eINSTANCE.getShelf_Name();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHELF__BOOKS = eINSTANCE.getShelf_Books();

	}

} //LibraryPackage
