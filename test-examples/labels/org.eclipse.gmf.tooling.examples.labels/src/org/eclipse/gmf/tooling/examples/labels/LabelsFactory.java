/**
 */
package org.eclipse.gmf.tooling.examples.labels;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.labels.LabelsPackage
 * @generated
 */
public interface LabelsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LabelsFactory eINSTANCE = org.eclipse.gmf.tooling.examples.labels.impl.LabelsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Element</em>'.
	 * @generated
	 */
	NamedElement createNamedElement();

	/**
	 * Returns a new object of class '<em>All Labels Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Labels Type</em>'.
	 * @generated
	 */
	AllLabelsType createAllLabelsType();

	/**
	 * Returns a new object of class '<em>Child Label Node Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Label Node Container</em>'.
	 * @generated
	 */
	ChildLabelNodeContainer createChildLabelNodeContainer();

	/**
	 * Returns a new object of class '<em>Child Label Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Label Node</em>'.
	 * @generated
	 */
	ChildLabelNode createChildLabelNode();

	/**
	 * Returns a new object of class '<em>Gen Label Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Label Node</em>'.
	 * @generated
	 */
	GenLabelNode createGenLabelNode();

	/**
	 * Returns a new object of class '<em>Vertical Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vertical Label</em>'.
	 * @generated
	 */
	VerticalLabel createVerticalLabel();

	/**
	 * Returns a new object of class '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagram</em>'.
	 * @generated
	 */
	Diagram createDiagram();

	/**
	 * Returns a new object of class '<em>Link With Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link With Label</em>'.
	 * @generated
	 */
	LinkWithLabel createLinkWithLabel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LabelsPackage getLabelsPackage();

} //LabelsFactory
