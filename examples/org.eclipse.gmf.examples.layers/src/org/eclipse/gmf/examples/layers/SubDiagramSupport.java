/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.layers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Diagram Support</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.layers.SubDiagramSupport#getLayers <em>Layers</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.layers.SubDiagramSupport#getMainDiagram <em>Main Diagram</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.layers.SubDiagramSupport#getSubDiagrams <em>Sub Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.layers.LayersPackage#getSubDiagramSupport()
 * @model
 * @generated
 */
public interface SubDiagramSupport extends EObject {
	/**
	 * Returns the value of the '<em><b>Layers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.layers.Layer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layers</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.layers.LayersPackage#getSubDiagramSupport_Layers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Layer> getLayers();

	/**
	 * Returns the value of the '<em><b>Main Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Diagram</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Diagram</em>' containment reference.
	 * @see #setMainDiagram(SubDiagramSpec)
	 * @see org.eclipse.gmf.examples.layers.LayersPackage#getSubDiagramSupport_MainDiagram()
	 * @model containment="true"
	 * @generated
	 */
	SubDiagramSpec getMainDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.layers.SubDiagramSupport#getMainDiagram <em>Main Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Diagram</em>' containment reference.
	 * @see #getMainDiagram()
	 * @generated
	 */
	void setMainDiagram(SubDiagramSpec value);

	/**
	 * Returns the value of the '<em><b>Sub Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.layers.SubDiagramSpec}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Diagrams</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.layers.LayersPackage#getSubDiagramSupport_SubDiagrams()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubDiagramSpec> getSubDiagrams();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<SubDiagramSpec> getAllDiagrams();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SubDiagramSpec findDiagramSpec(Diagram diagram);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void ensureAllSubDiagramsHaveEnablementForAllLayers();

} // SubDiagramSupport
