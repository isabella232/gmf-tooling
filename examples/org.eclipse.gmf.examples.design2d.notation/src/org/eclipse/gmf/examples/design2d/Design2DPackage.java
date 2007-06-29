/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.design2d;

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
 * @see org.eclipse.gmf.examples.design2d.Design2DFactory
 * @model kind="package"
 * @generated
 */
public interface Design2DPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "design2d"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/gmf/1.0.0/design2d"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "design2d"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Design2DPackage eINSTANCE = org.eclipse.gmf.examples.design2d.impl.Design2DPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.design2d.DesignStyle <em>Design Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.design2d.DesignStyle
	 * @see org.eclipse.gmf.examples.design2d.impl.Design2DPackageImpl#getDesignStyle()
	 * @generated
	 */
	int DESIGN_STYLE = 0;

	/**
	 * The number of structural features of the '<em>Design Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGN_STYLE_FEATURE_COUNT = NotationPackage.STYLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.design2d.impl.ClassDesignStyleImpl <em>Class Design Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.design2d.impl.ClassDesignStyleImpl
	 * @see org.eclipse.gmf.examples.design2d.impl.Design2DPackageImpl#getClassDesignStyle()
	 * @generated
	 */
	int CLASS_DESIGN_STYLE = 1;

	/**
	 * The feature id for the '<em><b>Qualified Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DESIGN_STYLE__QUALIFIED_CLASS_NAME = DESIGN_STYLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class Design Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DESIGN_STYLE_FEATURE_COUNT = DESIGN_STYLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.design2d.impl.PluginDesignStyleImpl <em>Plugin Design Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.design2d.impl.PluginDesignStyleImpl
	 * @see org.eclipse.gmf.examples.design2d.impl.Design2DPackageImpl#getPluginDesignStyle()
	 * @generated
	 */
	int PLUGIN_DESIGN_STYLE = 2;

	/**
	 * The feature id for the '<em><b>Plugin Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESIGN_STYLE__PLUGIN_ID = DESIGN_STYLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Plugin Design Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESIGN_STYLE_FEATURE_COUNT = DESIGN_STYLE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.design2d.DesignStyle <em>Design Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Design Style</em>'.
	 * @see org.eclipse.gmf.examples.design2d.DesignStyle
	 * @generated
	 */
	EClass getDesignStyle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.design2d.ClassDesignStyle <em>Class Design Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Design Style</em>'.
	 * @see org.eclipse.gmf.examples.design2d.ClassDesignStyle
	 * @generated
	 */
	EClass getClassDesignStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.design2d.ClassDesignStyle#getQualifiedClassName <em>Qualified Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Class Name</em>'.
	 * @see org.eclipse.gmf.examples.design2d.ClassDesignStyle#getQualifiedClassName()
	 * @see #getClassDesignStyle()
	 * @generated
	 */
	EAttribute getClassDesignStyle_QualifiedClassName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.design2d.PluginDesignStyle <em>Plugin Design Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin Design Style</em>'.
	 * @see org.eclipse.gmf.examples.design2d.PluginDesignStyle
	 * @generated
	 */
	EClass getPluginDesignStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.design2d.PluginDesignStyle#getPluginId <em>Plugin Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin Id</em>'.
	 * @see org.eclipse.gmf.examples.design2d.PluginDesignStyle#getPluginId()
	 * @see #getPluginDesignStyle()
	 * @generated
	 */
	EAttribute getPluginDesignStyle_PluginId();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Design2DFactory getDesign2DFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.design2d.DesignStyle <em>Design Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.design2d.DesignStyle
		 * @see org.eclipse.gmf.examples.design2d.impl.Design2DPackageImpl#getDesignStyle()
		 * @generated
		 */
		EClass DESIGN_STYLE = eINSTANCE.getDesignStyle();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.design2d.impl.ClassDesignStyleImpl <em>Class Design Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.design2d.impl.ClassDesignStyleImpl
		 * @see org.eclipse.gmf.examples.design2d.impl.Design2DPackageImpl#getClassDesignStyle()
		 * @generated
		 */
		EClass CLASS_DESIGN_STYLE = eINSTANCE.getClassDesignStyle();

		/**
		 * The meta object literal for the '<em><b>Qualified Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_DESIGN_STYLE__QUALIFIED_CLASS_NAME = eINSTANCE.getClassDesignStyle_QualifiedClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.design2d.impl.PluginDesignStyleImpl <em>Plugin Design Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.design2d.impl.PluginDesignStyleImpl
		 * @see org.eclipse.gmf.examples.design2d.impl.Design2DPackageImpl#getPluginDesignStyle()
		 * @generated
		 */
		EClass PLUGIN_DESIGN_STYLE = eINSTANCE.getPluginDesignStyle();

		/**
		 * The meta object literal for the '<em><b>Plugin Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_DESIGN_STYLE__PLUGIN_ID = eINSTANCE.getPluginDesignStyle_PluginId();

	}

} //Design2DPackage
