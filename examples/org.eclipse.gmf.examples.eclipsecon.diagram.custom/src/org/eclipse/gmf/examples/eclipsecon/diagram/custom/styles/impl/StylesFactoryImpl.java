/**
 * <copyright>
 * </copyright>
 *
 * $Id: StylesFactoryImpl.java,v 1.1 2006/03/10 02:07:13 sshaw Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StylesFactoryImpl extends EFactoryImpl implements StylesFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static StylesFactory init() {
        try {
            StylesFactory theStylesFactory = (StylesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/gmf/examples/eclipsecon/diagram/custom/styles.ecore"); 
            if (theStylesFactory != null) {
                return theStylesFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new StylesFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StylesFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case StylesPackage.PRESENTER_STYLE: return createPresenterStyle();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PresenterStyle createPresenterStyle() {
        PresenterStyleImpl presenterStyle = new PresenterStyleImpl();
        return presenterStyle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StylesPackage getStylesPackage() {
        return (StylesPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    public static StylesPackage getPackage() {
        return StylesPackage.eINSTANCE;
    }

} //StylesFactoryImpl
