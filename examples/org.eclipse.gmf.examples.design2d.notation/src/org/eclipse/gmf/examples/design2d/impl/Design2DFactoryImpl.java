/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.design2d.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gmf.examples.design2d.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Design2DFactoryImpl extends EFactoryImpl implements Design2DFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Design2DFactory init() {
		try {
			Design2DFactory theDesign2DFactory = (Design2DFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/gmf/1.0.0/design2d"); //$NON-NLS-1$ 
			if (theDesign2DFactory != null) {
				return theDesign2DFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Design2DFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Design2DFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Design2DPackage.CLASS_DESIGN_STYLE: return createClassDesignStyle();
			case Design2DPackage.PLUGIN_DESIGN_STYLE: return createPluginDesignStyle();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDesignStyle createClassDesignStyle() {
		ClassDesignStyleImpl classDesignStyle = new ClassDesignStyleImpl();
		return classDesignStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PluginDesignStyle createPluginDesignStyle() {
		PluginDesignStyleImpl pluginDesignStyle = new PluginDesignStyleImpl();
		return pluginDesignStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Design2DPackage getDesign2DPackage() {
		return (Design2DPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Design2DPackage getPackage() {
		return Design2DPackage.eINSTANCE;
	}

} //Design2DFactoryImpl
