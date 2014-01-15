/**
 */
package org.eclipse.gmf.example.lesscode;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.example.lesscode.LesscodePackage
 * @generated
 */
public interface LesscodeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LesscodeFactory eINSTANCE = org.eclipse.gmf.example.lesscode.impl.LesscodeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Root Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Container</em>'.
	 * @generated
	 */
	RootContainer createRootContainer();

	/**
	 * Returns a new object of class '<em>Element Based Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Based Link</em>'.
	 * @generated
	 */
	ElementBasedLink createElementBasedLink();

	/**
	 * Returns a new object of class '<em>Subject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subject</em>'.
	 * @generated
	 */
	Subject createSubject();

	/**
	 * Returns a new object of class '<em>One Containment Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>One Containment Group</em>'.
	 * @generated
	 */
	OneContainmentGroup createOneContainmentGroup();

	/**
	 * Returns a new object of class '<em>Multi Containment Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Containment Group</em>'.
	 * @generated
	 */
	MultiContainmentGroup createMultiContainmentGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LesscodePackage getLesscodePackage();

} //LesscodeFactory
