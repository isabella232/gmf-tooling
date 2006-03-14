/**
 * <copyright>
 * </copyright>
 *
 * $Id: StylesPackageImpl.java,v 1.2 2006/03/14 14:29:45 sshaw Exp $
 */
package org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.StylesFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.StylesPackage;

import org.eclipse.gmf.runtime.notation.Style;

import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StylesPackageImpl extends EPackageImpl implements StylesPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass presenterStyleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass styleEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.StylesPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private StylesPackageImpl() {
        super(eNS_URI, StylesFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static StylesPackage init() {
        if (isInited) return (StylesPackage)EPackage.Registry.INSTANCE.getEPackage(StylesPackage.eNS_URI);

        // Obtain or create and register package
        StylesPackageImpl theStylesPackage = (StylesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof StylesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new StylesPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        NotationPackage.eINSTANCE.eClass();
        EcorePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theStylesPackage.createPackageContents();

        // Initialize created meta-data
        theStylesPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theStylesPackage.freeze();

        return theStylesPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPresenterStyle() {
        return presenterStyleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPresenterStyle_ImageURL() {
        return (EAttribute)presenterStyleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPresenterStyle_Review() {
        return (EAttribute)presenterStyleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPresenterStyle_DisplayAsDefault() {
        return (EAttribute)presenterStyleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStyle() {
        return styleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StylesFactory getStylesFactory() {
        return (StylesFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        presenterStyleEClass = createEClass(PRESENTER_STYLE);
        createEAttribute(presenterStyleEClass, PRESENTER_STYLE__IMAGE_URL);
        createEAttribute(presenterStyleEClass, PRESENTER_STYLE__REVIEW);
        createEAttribute(presenterStyleEClass, PRESENTER_STYLE__DISPLAY_AS_DEFAULT);

        styleEClass = createEClass(STYLE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        NotationPackage theNotationPackage = (NotationPackage)EPackage.Registry.INSTANCE.getEPackage(NotationPackage.eNS_URI);

        // Add supertypes to classes
        presenterStyleEClass.getESuperTypes().add(theNotationPackage.getStyle());

        // Initialize classes and features; add operations and parameters
        initEClass(presenterStyleEClass, PresenterStyle.class, "PresenterStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPresenterStyle_ImageURL(), ecorePackage.getEString(), "imageURL", "", 0, 1, PresenterStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPresenterStyle_Review(), ecorePackage.getEString(), "review", "", 0, 1, PresenterStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPresenterStyle_DisplayAsDefault(), ecorePackage.getEBooleanObject(), "displayAsDefault", "Boolean.TRUE", 0, 1, PresenterStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(styleEClass, Style.class, "Style", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //StylesPackageImpl
