/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.layers;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.layers.LayersPackage
 * @generated
 */
public interface LayersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayersFactory eINSTANCE = org.eclipse.gmf.examples.layers.impl.LayersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sub Diagram Support</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Diagram Support</em>'.
	 * @generated
	 */
	SubDiagramSupport createSubDiagramSupport();

	/**
	 * Returns a new object of class '<em>Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer</em>'.
	 * @generated
	 */
	Layer createLayer();

	/**
	 * Returns a new object of class '<em>Sub Diagram Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Diagram Spec</em>'.
	 * @generated
	 */
	SubDiagramSpec createSubDiagramSpec();

	/**
	 * Returns a new object of class '<em>Layer Enablement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Enablement</em>'.
	 * @generated
	 */
	LayerEnablement createLayerEnablement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LayersPackage getLayersPackage();

} //LayersFactory
