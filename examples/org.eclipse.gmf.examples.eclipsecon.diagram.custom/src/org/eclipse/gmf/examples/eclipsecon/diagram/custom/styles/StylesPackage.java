/**
 * <copyright>
 * </copyright>
 *
 * $Id: StylesPackage.java,v 1.2 2006/03/14 14:29:45 sshaw Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.StylesFactory
 * @model kind="package"
 * @generated
 */
public interface StylesPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "styles";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http:///org/eclipse/gmf/examples/eclipsecon/diagram/custom/styles.ecore";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    StylesPackage eINSTANCE = org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.StylesPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.gmf.runtime.notation.Style <em>Style</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.gmf.runtime.notation.Style
     * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.StylesPackageImpl#getStyle()
     * @generated
     */
    int STYLE = 1;

    /**
     * The meta object id for the '{@link org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.PresenterStyleImpl <em>Presenter Style</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.PresenterStyleImpl
     * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.StylesPackageImpl#getPresenterStyle()
     * @generated
     */
    int PRESENTER_STYLE = 0;

    /**
     * The feature id for the '<em><b>Image URL</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRESENTER_STYLE__IMAGE_URL = NotationPackage.STYLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Review</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRESENTER_STYLE__REVIEW = NotationPackage.STYLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Display As Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRESENTER_STYLE__DISPLAY_AS_DEFAULT = NotationPackage.STYLE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Presenter Style</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRESENTER_STYLE_FEATURE_COUNT = NotationPackage.STYLE_FEATURE_COUNT + 3;


    /**
     * The number of structural features of the '<em>Style</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STYLE_FEATURE_COUNT = 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle <em>Presenter Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Presenter Style</em>'.
     * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle
     * @generated
     */
    EClass getPresenterStyle();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle#getImageURL <em>Image URL</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Image URL</em>'.
     * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle#getImageURL()
     * @see #getPresenterStyle()
     * @generated
     */
    EAttribute getPresenterStyle_ImageURL();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle#getReview <em>Review</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Review</em>'.
     * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle#getReview()
     * @see #getPresenterStyle()
     * @generated
     */
    EAttribute getPresenterStyle_Review();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle#getDisplayAsDefault <em>Display As Default</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Display As Default</em>'.
     * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle#getDisplayAsDefault()
     * @see #getPresenterStyle()
     * @generated
     */
    EAttribute getPresenterStyle_DisplayAsDefault();

    /**
     * Returns the meta object for class '{@link org.eclipse.gmf.runtime.notation.Style <em>Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Style</em>'.
     * @see org.eclipse.gmf.runtime.notation.Style
     * @model instanceClass="org.eclipse.gmf.runtime.notation.Style"
     * @generated
     */
    EClass getStyle();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    StylesFactory getStylesFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals  {
        /**
         * The meta object literal for the '{@link org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.PresenterStyleImpl <em>Presenter Style</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.PresenterStyleImpl
         * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.StylesPackageImpl#getPresenterStyle()
         * @generated
         */
        EClass PRESENTER_STYLE = eINSTANCE.getPresenterStyle();

        /**
         * The meta object literal for the '<em><b>Image URL</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRESENTER_STYLE__IMAGE_URL = eINSTANCE.getPresenterStyle_ImageURL();

        /**
         * The meta object literal for the '<em><b>Review</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRESENTER_STYLE__REVIEW = eINSTANCE.getPresenterStyle_Review();

        /**
         * The meta object literal for the '<em><b>Display As Default</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRESENTER_STYLE__DISPLAY_AS_DEFAULT = eINSTANCE.getPresenterStyle_DisplayAsDefault();

        /**
         * The meta object literal for the '{@link org.eclipse.gmf.runtime.notation.Style <em>Style</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.gmf.runtime.notation.Style
         * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl.StylesPackageImpl#getStyle()
         * @generated
         */
        EClass STYLE = eINSTANCE.getStyle();

    }

} //StylesPackage
