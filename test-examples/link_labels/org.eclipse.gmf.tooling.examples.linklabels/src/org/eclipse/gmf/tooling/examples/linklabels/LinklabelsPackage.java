/**
 */
package org.eclipse.gmf.tooling.examples.linklabels;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.linklabels.LinklabelsFactory
 * @model kind="package"
 * @generated
 */
public interface LinklabelsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "linklabels";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.gmf.tooling.examples.linklabels";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "linklabels";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LinklabelsPackage eINSTANCE = org.eclipse.gmf.tooling.examples.linklabels.impl.LinklabelsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklabels.impl.CanvasImpl <em>Canvas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.CanvasImpl
	 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.LinklabelsPackageImpl#getCanvas()
	 * @generated
	 */
	int CANVAS = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklabels.impl.CanvasElementImpl <em>Canvas Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.CanvasElementImpl
	 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.LinklabelsPackageImpl#getCanvasElement()
	 * @generated
	 */
	int CANVAS_ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Canvas Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Canvas Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANVAS_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklabels.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.NodeImpl
	 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.LinklabelsPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = CANVAS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = CANVAS_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.linklabels.impl.LabeledLinkImpl <em>Labeled Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.LabeledLinkImpl
	 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.LinklabelsPackageImpl#getLabeledLink()
	 * @generated
	 */
	int LABELED_LINK = 3;

	/**
	 * The feature id for the '<em><b>Semantic Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK__SEMANTIC_LABEL = CANVAS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fixed Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK__FIXED_LABEL = CANVAS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ocl Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK__OCL_LABEL = CANVAS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK__SOURCE = CANVAS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK__TARGET = CANVAS_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Labeled Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK_FEATURE_COUNT = CANVAS_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Labeled Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_LINK_OPERATION_COUNT = CANVAS_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklabels.Canvas <em>Canvas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Canvas</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklabels.Canvas
	 * @generated
	 */
	EClass getCanvas();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.linklabels.Canvas#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklabels.Canvas#getElements()
	 * @see #getCanvas()
	 * @generated
	 */
	EReference getCanvas_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklabels.CanvasElement <em>Canvas Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Canvas Element</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklabels.CanvasElement
	 * @generated
	 */
	EClass getCanvasElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklabels.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklabels.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink <em>Labeled Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Labeled Link</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklabels.LabeledLink
	 * @generated
	 */
	EClass getLabeledLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getSemanticLabel <em>Semantic Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Semantic Label</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getSemanticLabel()
	 * @see #getLabeledLink()
	 * @generated
	 */
	EAttribute getLabeledLink_SemanticLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getFixedLabel <em>Fixed Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Label</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getFixedLabel()
	 * @see #getLabeledLink()
	 * @generated
	 */
	EAttribute getLabeledLink_FixedLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getOclLabel <em>Ocl Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ocl Label</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getOclLabel()
	 * @see #getLabeledLink()
	 * @generated
	 */
	EAttribute getLabeledLink_OclLabel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getSource()
	 * @see #getLabeledLink()
	 * @generated
	 */
	EReference getLabeledLink_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getTarget()
	 * @see #getLabeledLink()
	 * @generated
	 */
	EReference getLabeledLink_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LinklabelsFactory getLinklabelsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklabels.impl.CanvasImpl <em>Canvas</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.CanvasImpl
		 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.LinklabelsPackageImpl#getCanvas()
		 * @generated
		 */
		EClass CANVAS = eINSTANCE.getCanvas();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CANVAS__ELEMENTS = eINSTANCE.getCanvas_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklabels.impl.CanvasElementImpl <em>Canvas Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.CanvasElementImpl
		 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.LinklabelsPackageImpl#getCanvasElement()
		 * @generated
		 */
		EClass CANVAS_ELEMENT = eINSTANCE.getCanvasElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklabels.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.NodeImpl
		 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.LinklabelsPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.linklabels.impl.LabeledLinkImpl <em>Labeled Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.LabeledLinkImpl
		 * @see org.eclipse.gmf.tooling.examples.linklabels.impl.LinklabelsPackageImpl#getLabeledLink()
		 * @generated
		 */
		EClass LABELED_LINK = eINSTANCE.getLabeledLink();

		/**
		 * The meta object literal for the '<em><b>Semantic Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABELED_LINK__SEMANTIC_LABEL = eINSTANCE.getLabeledLink_SemanticLabel();

		/**
		 * The meta object literal for the '<em><b>Fixed Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABELED_LINK__FIXED_LABEL = eINSTANCE.getLabeledLink_FixedLabel();

		/**
		 * The meta object literal for the '<em><b>Ocl Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABELED_LINK__OCL_LABEL = eINSTANCE.getLabeledLink_OclLabel();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABELED_LINK__SOURCE = eINSTANCE.getLabeledLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABELED_LINK__TARGET = eINSTANCE.getLabeledLink_Target();

	}

} //LinklabelsPackage
