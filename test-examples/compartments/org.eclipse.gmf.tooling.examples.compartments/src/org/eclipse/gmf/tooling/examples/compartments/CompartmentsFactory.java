/**
 */
package org.eclipse.gmf.tooling.examples.compartments;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage
 * @generated
 */
public interface CompartmentsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompartmentsFactory eINSTANCE = org.eclipse.gmf.tooling.examples.compartments.impl.CompartmentsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Canvas</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Canvas</em>'.
	 * @generated
	 */
	Canvas createCanvas();

	/**
	 * Returns a new object of class '<em>Top Node A</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Node A</em>'.
	 * @generated
	 */
	TopNodeA createTopNodeA();

	/**
	 * Returns a new object of class '<em>Top Node B</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Node B</em>'.
	 * @generated
	 */
	TopNodeB createTopNodeB();

	/**
	 * Returns a new object of class '<em>Child Of BE</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Of BE</em>'.
	 * @generated
	 */
	ChildOfB_E createChildOfB_E();

	/**
	 * Returns a new object of class '<em>Child Of BG</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Of BG</em>'.
	 * @generated
	 */
	ChildOfB_G createChildOfB_G();

	/**
	 * Returns a new object of class '<em>Top Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Node</em>'.
	 * @generated
	 */
	TopNode createTopNode();

	/**
	 * Returns a new object of class '<em>Child Of AC</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Of AC</em>'.
	 * @generated
	 */
	ChildOfA_C createChildOfA_C();

	/**
	 * Returns a new object of class '<em>Child Of BF</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Of BF</em>'.
	 * @generated
	 */
	ChildOfB_F createChildOfB_F();

	/**
	 * Returns a new object of class '<em>Child Of Affixed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Of Affixed</em>'.
	 * @generated
	 */
	ChildOfAffixed createChildOfAffixed();

	/**
	 * Returns a new object of class '<em>Child Of AD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Of AD</em>'.
	 * @generated
	 */
	ChildOfA_D createChildOfA_D();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CompartmentsPackage getCompartmentsPackage();

} //CompartmentsFactory
