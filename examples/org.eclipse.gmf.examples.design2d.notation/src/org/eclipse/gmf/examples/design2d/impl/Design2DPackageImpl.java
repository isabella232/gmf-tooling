/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.design2d.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.examples.design2d.ClassDesignStyle;
import org.eclipse.gmf.examples.design2d.Design2DFactory;
import org.eclipse.gmf.examples.design2d.Design2DPackage;
import org.eclipse.gmf.examples.design2d.DesignStyle;
import org.eclipse.gmf.examples.design2d.PluginDesignStyle;

import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Design2DPackageImpl extends EPackageImpl implements Design2DPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass designStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classDesignStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pluginDesignStyleEClass = null;

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
	 * @see org.eclipse.gmf.examples.design2d.Design2DPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Design2DPackageImpl() {
		super(eNS_URI, Design2DFactory.eINSTANCE);
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
	public static Design2DPackage init() {
		if (isInited) return (Design2DPackage)EPackage.Registry.INSTANCE.getEPackage(Design2DPackage.eNS_URI);

		// Obtain or create and register package
		Design2DPackageImpl theDesign2DPackage = (Design2DPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof Design2DPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new Design2DPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		NotationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDesign2DPackage.createPackageContents();

		// Initialize created meta-data
		theDesign2DPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDesign2DPackage.freeze();

		return theDesign2DPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDesignStyle() {
		return designStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassDesignStyle() {
		return classDesignStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassDesignStyle_QualifiedClassName() {
		return (EAttribute)classDesignStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPluginDesignStyle() {
		return pluginDesignStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDesignStyle_PluginId() {
		return (EAttribute)pluginDesignStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Design2DFactory getDesign2DFactory() {
		return (Design2DFactory)getEFactoryInstance();
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
		designStyleEClass = createEClass(DESIGN_STYLE);

		classDesignStyleEClass = createEClass(CLASS_DESIGN_STYLE);
		createEAttribute(classDesignStyleEClass, CLASS_DESIGN_STYLE__QUALIFIED_CLASS_NAME);

		pluginDesignStyleEClass = createEClass(PLUGIN_DESIGN_STYLE);
		createEAttribute(pluginDesignStyleEClass, PLUGIN_DESIGN_STYLE__PLUGIN_ID);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		designStyleEClass.getESuperTypes().add(theNotationPackage.getStyle());
		classDesignStyleEClass.getESuperTypes().add(this.getDesignStyle());
		pluginDesignStyleEClass.getESuperTypes().add(this.getDesignStyle());

		// Initialize classes and features; add operations and parameters
		initEClass(designStyleEClass, DesignStyle.class, "DesignStyle", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(classDesignStyleEClass, ClassDesignStyle.class, "ClassDesignStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getClassDesignStyle_QualifiedClassName(), ecorePackage.getEString(), "qualifiedClassName", null, 0, 1, ClassDesignStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(pluginDesignStyleEClass, PluginDesignStyle.class, "PluginDesignStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPluginDesignStyle_PluginId(), ecorePackage.getEString(), "pluginId", null, 0, 1, PluginDesignStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //Design2DPackageImpl
