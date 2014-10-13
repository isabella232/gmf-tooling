/**
 */
package org.eclipse.gmf.tooling.examples.phantoms;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.phantoms.PhantomsPackage
 * @generated
 */
public interface PhantomsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PhantomsFactory eINSTANCE = org.eclipse.gmf.tooling.examples.phantoms.impl.PhantomsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	Root createRoot();

	/**
	 * Returns a new object of class '<em>Root Child</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Child</em>'.
	 * @generated
	 */
	RootChild createRootChild();

	/**
	 * Returns a new object of class '<em>Top Parent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Parent</em>'.
	 * @generated
	 */
	TopParent createTopParent();

	/**
	 * Returns a new object of class '<em>Medium</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Medium</em>'.
	 * @generated
	 */
	Medium createMedium();

	/**
	 * Returns a new object of class '<em>Top Child</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Child</em>'.
	 * @generated
	 */
	TopChild createTopChild();

	/**
	 * Returns a new object of class '<em>Medium Parent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Medium Parent</em>'.
	 * @generated
	 */
	MediumParent createMediumParent();

	/**
	 * Returns a new object of class '<em>Medium Child</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Medium Child</em>'.
	 * @generated
	 */
	MediumChild createMediumChild();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PhantomsPackage getPhantomsPackage();

} //PhantomsFactory
