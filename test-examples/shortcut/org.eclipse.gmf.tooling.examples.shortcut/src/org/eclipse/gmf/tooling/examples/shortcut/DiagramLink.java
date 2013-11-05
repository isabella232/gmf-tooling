/**
 */
package org.eclipse.gmf.tooling.examples.shortcut;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.shortcut.DiagramLink#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.shortcut.DiagramLink#getTargetNode <em>Target Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage#getDiagramLink()
 * @model
 * @generated
 */
public interface DiagramLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Node</em>' reference.
	 * @see #setSourceNode(DiagramNode)
	 * @see org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage#getDiagramLink_SourceNode()
	 * @model
	 * @generated
	 */
	DiagramNode getSourceNode();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.shortcut.DiagramLink#getSourceNode <em>Source Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Node</em>' reference.
	 * @see #getSourceNode()
	 * @generated
	 */
	void setSourceNode(DiagramNode value);

	/**
	 * Returns the value of the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Node</em>' reference.
	 * @see #setTargetNode(DiagramNode)
	 * @see org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage#getDiagramLink_TargetNode()
	 * @model
	 * @generated
	 */
	DiagramNode getTargetNode();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.shortcut.DiagramLink#getTargetNode <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Node</em>' reference.
	 * @see #getTargetNode()
	 * @generated
	 */
	void setTargetNode(DiagramNode value);

} // DiagramLink
