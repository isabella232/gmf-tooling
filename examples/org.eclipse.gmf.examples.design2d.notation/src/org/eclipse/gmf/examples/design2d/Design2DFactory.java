/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.design2d;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.design2d.Design2DPackage
 * @generated
 */
public interface Design2DFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Design2DFactory eINSTANCE = org.eclipse.gmf.examples.design2d.impl.Design2DFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Class Design Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Design Style</em>'.
	 * @generated
	 */
	ClassDesignStyle createClassDesignStyle();

	/**
	 * Returns a new object of class '<em>Plugin Design Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugin Design Style</em>'.
	 * @generated
	 */
	PluginDesignStyle createPluginDesignStyle();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Design2DPackage getDesign2DPackage();

} //Design2DFactory
