/**
 */
package org.eclipse.gmf.tooling.examples.linklf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Canvas Element Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklf.CanvasElementContainer#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.linklf.LinklfPackage#getCanvasElementContainer()
 * @model
 * @generated
 */
public interface CanvasElementContainer extends CanvasElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.linklf.CanvasElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.linklf.LinklfPackage#getCanvasElementContainer_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<CanvasElement> getElements();

} // CanvasElementContainer
