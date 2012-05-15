/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.layers.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmf.examples.layers.Layer;
import org.eclipse.gmf.examples.layers.LayerEnablement;
import org.eclipse.gmf.examples.layers.LayersFactory;
import org.eclipse.gmf.examples.layers.LayersPackage;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.examples.layers.SubDiagramSupport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayersFactoryImpl extends EFactoryImpl implements LayersFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LayersFactory init() {
		try {
			LayersFactory theLayersFactory = (LayersFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/examples/gmf/visibility-layers"); 
			if (theLayersFactory != null) {
				return theLayersFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LayersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersFactoryImpl() {
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
			case LayersPackage.SUB_DIAGRAM_SUPPORT: return createSubDiagramSupport();
			case LayersPackage.LAYER: return createLayer();
			case LayersPackage.SUB_DIAGRAM_SPEC: return createSubDiagramSpec();
			case LayersPackage.LAYER_ENABLEMENT: return createLayerEnablement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubDiagramSupport createSubDiagramSupport() {
		SubDiagramSupportImpl subDiagramSupport = new SubDiagramSupportImpl();
		return subDiagramSupport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layer createLayer() {
		LayerImpl layer = new LayerImpl();
		return layer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubDiagramSpec createSubDiagramSpec() {
		SubDiagramSpecImpl subDiagramSpec = new SubDiagramSpecImpl();
		return subDiagramSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerEnablement createLayerEnablement() {
		LayerEnablementImpl layerEnablement = new LayerEnablementImpl();
		return layerEnablement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersPackage getLayersPackage() {
		return (LayersPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LayersPackage getPackage() {
		return LayersPackage.eINSTANCE;
	}

} //LayersFactoryImpl
