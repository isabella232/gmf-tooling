/**
 */
package org.eclipse.gmf.tooling.examples.shortcut;

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
 * @see org.eclipse.gmf.tooling.examples.shortcut.ShortcutFactory
 * @model kind="package"
 * @generated
 */
public interface ShortcutPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "shortcut";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.gmf.tooling.examples.shortcut";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.gmf.tooling.examples.shortcut";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ShortcutPackage eINSTANCE = org.eclipse.gmf.tooling.examples.shortcut.impl.ShortcutPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramImpl
	 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.ShortcutPackageImpl#getDiagram()
	 * @generated
	 */
	int DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__LINKS = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__NODES = 1;

	/**
	 * The feature id for the '<em><b>Contains Shortcuts To</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__CONTAINS_SHORTCUTS_TO = 2;

	/**
	 * The feature id for the '<em><b>Shortcuts Provided For</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__SHORTCUTS_PROVIDED_FOR = 3;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramNodeImpl <em>Diagram Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramNodeImpl
	 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.ShortcutPackageImpl#getDiagramNode()
	 * @generated
	 */
	int DIAGRAM_NODE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_NODE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Diagram Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_NODE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Diagram Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramLinkImpl <em>Diagram Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramLinkImpl
	 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.ShortcutPackageImpl#getDiagramLink()
	 * @generated
	 */
	int DIAGRAM_LINK = 2;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LINK__SOURCE_NODE = 0;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LINK__TARGET_NODE = 1;

	/**
	 * The number of structural features of the '<em>Diagram Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LINK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Diagram Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LINK_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.shortcut.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.Diagram
	 * @generated
	 */
	EClass getDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.shortcut.Diagram#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.Diagram#getLinks()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_Links();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.shortcut.Diagram#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.Diagram#getNodes()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_Nodes();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.gmf.tooling.examples.shortcut.Diagram#getContainsShortcutsTo <em>Contains Shortcuts To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Contains Shortcuts To</em>'.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.Diagram#getContainsShortcutsTo()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_ContainsShortcutsTo();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.gmf.tooling.examples.shortcut.Diagram#getShortcutsProvidedFor <em>Shortcuts Provided For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Shortcuts Provided For</em>'.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.Diagram#getShortcutsProvidedFor()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_ShortcutsProvidedFor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.shortcut.DiagramNode <em>Diagram Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Node</em>'.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.DiagramNode
	 * @generated
	 */
	EClass getDiagramNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmf.tooling.examples.shortcut.DiagramNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.DiagramNode#getName()
	 * @see #getDiagramNode()
	 * @generated
	 */
	EAttribute getDiagramNode_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.shortcut.DiagramLink <em>Diagram Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Link</em>'.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.DiagramLink
	 * @generated
	 */
	EClass getDiagramLink();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.shortcut.DiagramLink#getSourceNode <em>Source Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Node</em>'.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.DiagramLink#getSourceNode()
	 * @see #getDiagramLink()
	 * @generated
	 */
	EReference getDiagramLink_SourceNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmf.tooling.examples.shortcut.DiagramLink#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Node</em>'.
	 * @see org.eclipse.gmf.tooling.examples.shortcut.DiagramLink#getTargetNode()
	 * @see #getDiagramLink()
	 * @generated
	 */
	EReference getDiagramLink_TargetNode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ShortcutFactory getShortcutFactory();

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
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramImpl
		 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.ShortcutPackageImpl#getDiagram()
		 * @generated
		 */
		EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM__LINKS = eINSTANCE.getDiagram_Links();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM__NODES = eINSTANCE.getDiagram_Nodes();

		/**
		 * The meta object literal for the '<em><b>Contains Shortcuts To</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM__CONTAINS_SHORTCUTS_TO = eINSTANCE.getDiagram_ContainsShortcutsTo();

		/**
		 * The meta object literal for the '<em><b>Shortcuts Provided For</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM__SHORTCUTS_PROVIDED_FOR = eINSTANCE.getDiagram_ShortcutsProvidedFor();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramNodeImpl <em>Diagram Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramNodeImpl
		 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.ShortcutPackageImpl#getDiagramNode()
		 * @generated
		 */
		EClass DIAGRAM_NODE = eINSTANCE.getDiagramNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_NODE__NAME = eINSTANCE.getDiagramNode_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramLinkImpl <em>Diagram Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.DiagramLinkImpl
		 * @see org.eclipse.gmf.tooling.examples.shortcut.impl.ShortcutPackageImpl#getDiagramLink()
		 * @generated
		 */
		EClass DIAGRAM_LINK = eINSTANCE.getDiagramLink();

		/**
		 * The meta object literal for the '<em><b>Source Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_LINK__SOURCE_NODE = eINSTANCE.getDiagramLink_SourceNode();

		/**
		 * The meta object literal for the '<em><b>Target Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_LINK__TARGET_NODE = eINSTANCE.getDiagramLink_TargetNode();

	}

} //ShortcutPackage
