/**
 * <copyright>
 * </copyright>
 *
 * $Id: StylesFactory.java,v 1.1 2006/03/10 02:07:13 sshaw Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.StylesPackage
 * @generated
 */
public interface StylesFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    StylesFactory eINSTANCE = org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.StylesFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Presenter Style</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Presenter Style</em>'.
     * @generated
     */
    PresenterStyle createPresenterStyle();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    StylesPackage getStylesPackage();

} //StylesFactory
