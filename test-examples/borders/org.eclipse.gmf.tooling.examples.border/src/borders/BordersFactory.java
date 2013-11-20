/**
 */
package borders;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see borders.BordersPackage
 * @generated
 */
public interface BordersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BordersFactory eINSTANCE = borders.impl.BordersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Border</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Border</em>'.
	 * @generated
	 */
	Border createBorder();

	/**
	 * Returns a new object of class '<em>Line Border</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Border</em>'.
	 * @generated
	 */
	LineBorder createLineBorder();

	/**
	 * Returns a new object of class '<em>Margin Border</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Margin Border</em>'.
	 * @generated
	 */
	MarginBorder createMarginBorder();

	/**
	 * Returns a new object of class '<em>Compound Border</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compound Border</em>'.
	 * @generated
	 */
	CompoundBorder createCompoundBorder();

	/**
	 * Returns a new object of class '<em>Custom Border</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Border</em>'.
	 * @generated
	 */
	CustomBorder createCustomBorder();

	/**
	 * Returns a new object of class '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagram</em>'.
	 * @generated
	 */
	Diagram createDiagram();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BordersPackage getBordersPackage();

} //BordersFactory
