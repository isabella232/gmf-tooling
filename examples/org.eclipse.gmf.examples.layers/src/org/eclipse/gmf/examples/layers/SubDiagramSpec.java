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
 * A representation of the model object '<em><b>Sub Diagram Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.layers.SubDiagramSpec#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.layers.SubDiagramSpec#isShowing <em>Showing</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.layers.SubDiagramSpec#getDiagramLayers <em>Diagram Layers</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.layers.SubDiagramSpec#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.layers.LayersPackage#getSubDiagramSpec()
 * @model
 * @generated
 */
public interface SubDiagramSpec extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.gmf.examples.layers.LayersPackage#getSubDiagramSpec_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.layers.SubDiagramSpec#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Showing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Showing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Showing</em>' attribute.
	 * @see #setShowing(boolean)
	 * @see org.eclipse.gmf.examples.layers.LayersPackage#getSubDiagramSpec_Showing()
	 * @model
	 * @generated
	 */
	boolean isShowing();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.layers.SubDiagramSpec#isShowing <em>Showing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Showing</em>' attribute.
	 * @see #isShowing()
	 * @generated
	 */
	void setShowing(boolean value);

	/**
	 * Returns the value of the '<em><b>Diagram Layers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.layers.LayerEnablement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Layers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Layers</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.layers.LayersPackage#getSubDiagramSpec_DiagramLayers()
	 * @model containment="true"
	 * @generated
	 */
	EList<LayerEnablement> getDiagramLayers();

	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram</em>' reference.
	 * @see #setDiagram(Diagram)
	 * @see org.eclipse.gmf.examples.layers.LayersPackage#getSubDiagramSpec_Diagram()
	 * @model
	 * @generated
	 */
	Diagram getDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.layers.SubDiagramSpec#getDiagram <em>Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram</em>' reference.
	 * @see #getDiagram()
	 * @generated
	 */
	void setDiagram(Diagram value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	LayerEnablement findLayerEnablement(Layer layer);

} // SubDiagramSpec
