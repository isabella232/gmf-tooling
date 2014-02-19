/**
 */
package org.eclipse.gmf.tooling.examples.links;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage
 * @generated
 */
public interface LinksFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LinksFactory eINSTANCE = org.eclipse.gmf.tooling.examples.links.impl.LinksFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	Root createRoot();

	/**
	 * Returns a new object of class '<em>Root Node A</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Node A</em>'.
	 * @generated
	 */
	RootNodeA createRootNodeA();

	/**
	 * Returns a new object of class '<em>Root Node B</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Node B</em>'.
	 * @generated
	 */
	RootNodeB createRootNodeB();

	/**
	 * Returns a new object of class '<em>Child Node A</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Node A</em>'.
	 * @generated
	 */
	ChildNodeA createChildNodeA();

	/**
	 * Returns a new object of class '<em>Child Node B</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Node B</em>'.
	 * @generated
	 */
	ChildNodeB createChildNodeB();

	/**
	 * Returns a new object of class '<em>Child AB Element Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child AB Element Link</em>'.
	 * @generated
	 */
	Child_AB_Element_Link createChild_AB_Element_Link();

	/**
	 * Returns a new object of class '<em>Root BA Element Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root BA Element Link</em>'.
	 * @generated
	 */
	Root_BA_Element_Link createRoot_BA_Element_Link();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LinksPackage getLinksPackage();

} //LinksFactory
