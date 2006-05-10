/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings;

import org.eclipse.gmf.gmfgraph.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shape Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Diagram node represented by arbitrary shape
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.ShapeNodeMapping#getDiagramNode <em>Diagram Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.mappings.GMFMapPackage#getShapeNodeMapping()
 * @model
 * @generated
 */
public interface ShapeNodeMapping extends NodeMapping {
	/**
	 * Returns the value of the '<em><b>Diagram Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Node</em>' reference.
	 * @see #setDiagramNode(Node)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getShapeNodeMapping_DiagramNode()
	 * @model required="true"
	 * @generated
	 */
	Node getDiagramNode();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.ShapeNodeMapping#getDiagramNode <em>Diagram Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Node</em>' reference.
	 * @see #getDiagramNode()
	 * @generated
	 */
	void setDiagramNode(Node value);

} // ShapeNodeMapping