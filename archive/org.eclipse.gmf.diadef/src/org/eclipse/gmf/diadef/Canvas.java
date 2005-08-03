/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.diadef;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Canvas</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.diadef.Canvas#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.Canvas#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getCanvas()
 * @model
 * @generated
 */
public interface Canvas extends CommonBase {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.diadef.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getCanvas_Nodes()
	 * @model type="org.eclipse.gmf.diadef.Node" containment="true"
	 * @generated
	 */
	EList getNodes();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.diadef.Connection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getCanvas_Links()
	 * @model type="org.eclipse.gmf.diadef.Connection" containment="true"
	 * @generated
	 */
	EList getLinks();

} // Canvas
