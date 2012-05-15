/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.layers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.gmf.examples.layers.LayersFactory
 * @model kind="package"
 * @generated
 */
public interface LayersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "layers";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/examples/gmf/visibility-layers";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "vlayers";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayersPackage eINSTANCE = org.eclipse.gmf.examples.layers.impl.LayersPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.layers.impl.SubDiagramSupportImpl <em>Sub Diagram Support</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.layers.impl.SubDiagramSupportImpl
	 * @see org.eclipse.gmf.examples.layers.impl.LayersPackageImpl#getSubDiagramSupport()
	 * @generated
	 */
	int SUB_DIAGRAM_SUPPORT = 0;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_DIAGRAM_SUPPORT__LAYERS = 0;

	/**
	 * The feature id for the '<em><b>Main Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM = 1;

	/**
	 * The feature id for the '<em><b>Sub Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_DIAGRAM_SUPPORT__SUB_DIAGRAMS = 2;

	/**
	 * The number of structural features of the '<em>Sub Diagram Support</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_DIAGRAM_SUPPORT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.layers.impl.LayerImpl <em>Layer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.layers.impl.LayerImpl
	 * @see org.eclipse.gmf.examples.layers.impl.LayersPackageImpl#getLayer()
	 * @generated
	 */
	int LAYER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Color Def</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__COLOR_DEF = 1;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__PARTICIPANTS = 2;

	/**
	 * The number of structural features of the '<em>Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.layers.impl.SubDiagramSpecImpl <em>Sub Diagram Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.layers.impl.SubDiagramSpecImpl
	 * @see org.eclipse.gmf.examples.layers.impl.LayersPackageImpl#getSubDiagramSpec()
	 * @generated
	 */
	int SUB_DIAGRAM_SPEC = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_DIAGRAM_SPEC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Showing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_DIAGRAM_SPEC__SHOWING = 1;

	/**
	 * The feature id for the '<em><b>Diagram Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_DIAGRAM_SPEC__DIAGRAM_LAYERS = 2;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_DIAGRAM_SPEC__DIAGRAM = 3;

	/**
	 * The number of structural features of the '<em>Sub Diagram Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_DIAGRAM_SPEC_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.examples.layers.impl.LayerEnablementImpl <em>Layer Enablement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.examples.layers.impl.LayerEnablementImpl
	 * @see org.eclipse.gmf.examples.layers.impl.LayersPackageImpl#getLayerEnablement()
	 * @generated
	 */
	int LAYER_ENABLEMENT = 3;

	/**
	 * The feature id for the '<em><b>Layer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_ENABLEMENT__LAYER = 0;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_ENABLEMENT__VISIBLE = 1;

	/**
	 * The number of structural features of the '<em>Layer Enablement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_ENABLEMENT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.layers.SubDiagramSupport <em>Sub Diagram Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Diagram Support</em>'.
	 * @see org.eclipse.gmf.examples.layers.SubDiagramSupport
	 * @generated
	 */
	EClass getSubDiagramSupport();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.layers.SubDiagramSupport#getLayers <em>Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Layers</em>'.
	 * @see org.eclipse.gmf.examples.layers.SubDiagramSupport#getLayers()
	 * @see #getSubDiagramSupport()
	 * @generated
	 */
	EReference getSubDiagramSupport_Layers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.gmf.examples.layers.SubDiagramSupport#getMainDiagram <em>Main Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Main Diagram</em>'.
	 * @see org.eclipse.gmf.examples.layers.SubDiagramSupport#getMainDiagram()
	 * @see #getSubDiagramSupport()
	 * @generated
	 */
	EReference getSubDiagramSupport_MainDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.layers.SubDiagramSupport#getSubDiagrams <em>Sub Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Diagrams</em>'.
	 * @see org.eclipse.gmf.examples.layers.SubDiagramSupport#getSubDiagrams()
	 * @see #getSubDiagramSupport()
	 * @generated
	 */
	EReference getSubDiagramSupport_SubDiagrams();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.layers.Layer <em>Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer</em>'.
	 * @see org.eclipse.gmf.examples.layers.Layer
	 * @generated
	 */
	EClass getLayer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.layers.Layer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.layers.Layer#getName()
	 * @see #getLayer()
	 * @generated
	 */
	EAttribute getLayer_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.layers.Layer#getColorDef <em>Color Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Def</em>'.
	 * @see org.eclipse.gmf.examples.layers.Layer#getColorDef()
	 * @see #getLayer()
	 * @generated
	 */
	EAttribute getLayer_ColorDef();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmf.examples.layers.Layer#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Participants</em>'.
	 * @see org.eclipse.gmf.examples.layers.Layer#getParticipants()
	 * @see #getLayer()
	 * @generated
	 */
	EReference getLayer_Participants();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.layers.SubDiagramSpec <em>Sub Diagram Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Diagram Spec</em>'.
	 * @see org.eclipse.gmf.examples.layers.SubDiagramSpec
	 * @generated
	 */
	EClass getSubDiagramSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.layers.SubDiagramSpec#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.examples.layers.SubDiagramSpec#getName()
	 * @see #getSubDiagramSpec()
	 * @generated
	 */
	EAttribute getSubDiagramSpec_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.layers.SubDiagramSpec#isShowing <em>Showing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Showing</em>'.
	 * @see org.eclipse.gmf.examples.layers.SubDiagramSpec#isShowing()
	 * @see #getSubDiagramSpec()
	 * @generated
	 */
	EAttribute getSubDiagramSpec_Showing();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.examples.layers.SubDiagramSpec#getDiagramLayers <em>Diagram Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagram Layers</em>'.
	 * @see org.eclipse.gmf.examples.layers.SubDiagramSpec#getDiagramLayers()
	 * @see #getSubDiagramSpec()
	 * @generated
	 */
	EReference getSubDiagramSpec_DiagramLayers();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.layers.SubDiagramSpec#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Diagram</em>'.
	 * @see org.eclipse.gmf.examples.layers.SubDiagramSpec#getDiagram()
	 * @see #getSubDiagramSpec()
	 * @generated
	 */
	EReference getSubDiagramSpec_Diagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.examples.layers.LayerEnablement <em>Layer Enablement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Enablement</em>'.
	 * @see org.eclipse.gmf.examples.layers.LayerEnablement
	 * @generated
	 */
	EClass getLayerEnablement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.examples.layers.LayerEnablement#getLayer <em>Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layer</em>'.
	 * @see org.eclipse.gmf.examples.layers.LayerEnablement#getLayer()
	 * @see #getLayerEnablement()
	 * @generated
	 */
	EReference getLayerEnablement_Layer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.examples.layers.LayerEnablement#isVisible <em>Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible</em>'.
	 * @see org.eclipse.gmf.examples.layers.LayerEnablement#isVisible()
	 * @see #getLayerEnablement()
	 * @generated
	 */
	EAttribute getLayerEnablement_Visible();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LayersFactory getLayersFactory();

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
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.layers.impl.SubDiagramSupportImpl <em>Sub Diagram Support</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.layers.impl.SubDiagramSupportImpl
		 * @see org.eclipse.gmf.examples.layers.impl.LayersPackageImpl#getSubDiagramSupport()
		 * @generated
		 */
		EClass SUB_DIAGRAM_SUPPORT = eINSTANCE.getSubDiagramSupport();

		/**
		 * The meta object literal for the '<em><b>Layers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_DIAGRAM_SUPPORT__LAYERS = eINSTANCE.getSubDiagramSupport_Layers();

		/**
		 * The meta object literal for the '<em><b>Main Diagram</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_DIAGRAM_SUPPORT__MAIN_DIAGRAM = eINSTANCE.getSubDiagramSupport_MainDiagram();

		/**
		 * The meta object literal for the '<em><b>Sub Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_DIAGRAM_SUPPORT__SUB_DIAGRAMS = eINSTANCE.getSubDiagramSupport_SubDiagrams();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.layers.impl.LayerImpl <em>Layer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.layers.impl.LayerImpl
		 * @see org.eclipse.gmf.examples.layers.impl.LayersPackageImpl#getLayer()
		 * @generated
		 */
		EClass LAYER = eINSTANCE.getLayer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER__NAME = eINSTANCE.getLayer_Name();

		/**
		 * The meta object literal for the '<em><b>Color Def</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER__COLOR_DEF = eINSTANCE.getLayer_ColorDef();

		/**
		 * The meta object literal for the '<em><b>Participants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER__PARTICIPANTS = eINSTANCE.getLayer_Participants();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.layers.impl.SubDiagramSpecImpl <em>Sub Diagram Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.layers.impl.SubDiagramSpecImpl
		 * @see org.eclipse.gmf.examples.layers.impl.LayersPackageImpl#getSubDiagramSpec()
		 * @generated
		 */
		EClass SUB_DIAGRAM_SPEC = eINSTANCE.getSubDiagramSpec();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_DIAGRAM_SPEC__NAME = eINSTANCE.getSubDiagramSpec_Name();

		/**
		 * The meta object literal for the '<em><b>Showing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_DIAGRAM_SPEC__SHOWING = eINSTANCE.getSubDiagramSpec_Showing();

		/**
		 * The meta object literal for the '<em><b>Diagram Layers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_DIAGRAM_SPEC__DIAGRAM_LAYERS = eINSTANCE.getSubDiagramSpec_DiagramLayers();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_DIAGRAM_SPEC__DIAGRAM = eINSTANCE.getSubDiagramSpec_Diagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.examples.layers.impl.LayerEnablementImpl <em>Layer Enablement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.examples.layers.impl.LayerEnablementImpl
		 * @see org.eclipse.gmf.examples.layers.impl.LayersPackageImpl#getLayerEnablement()
		 * @generated
		 */
		EClass LAYER_ENABLEMENT = eINSTANCE.getLayerEnablement();

		/**
		 * The meta object literal for the '<em><b>Layer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_ENABLEMENT__LAYER = eINSTANCE.getLayerEnablement_Layer();

		/**
		 * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER_ENABLEMENT__VISIBLE = eINSTANCE.getLayerEnablement_Visible();

	}

} //LayersPackage
