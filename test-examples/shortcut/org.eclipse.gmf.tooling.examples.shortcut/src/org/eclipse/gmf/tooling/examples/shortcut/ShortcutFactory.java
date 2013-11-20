/**
 */
package org.eclipse.gmf.tooling.examples.shortcut;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage
 * @generated
 */
public interface ShortcutFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ShortcutFactory eINSTANCE = org.eclipse.gmf.tooling.examples.shortcut.impl.ShortcutFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagram</em>'.
	 * @generated
	 */
	Diagram createDiagram();

	/**
	 * Returns a new object of class '<em>Diagram Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagram Node</em>'.
	 * @generated
	 */
	DiagramNode createDiagramNode();

	/**
	 * Returns a new object of class '<em>Diagram Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagram Link</em>'.
	 * @generated
	 */
	DiagramLink createDiagramLink();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ShortcutPackage getShortcutPackage();

} //ShortcutFactory
