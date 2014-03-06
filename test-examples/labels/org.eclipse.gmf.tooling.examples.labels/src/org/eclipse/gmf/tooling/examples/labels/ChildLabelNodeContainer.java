/**
 */
package org.eclipse.gmf.tooling.examples.labels;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Label Node Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.ChildLabelNodeContainer#getGetChildren <em>Get Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.labels.LabelsPackage#getChildLabelNodeContainer()
 * @model
 * @generated
 */
public interface ChildLabelNodeContainer extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Get Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.labels.ChildLabelNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Get Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get Children</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.labels.LabelsPackage#getChildLabelNodeContainer_GetChildren()
	 * @model containment="true" required="true" upper="4"
	 * @generated
	 */
	EList<ChildLabelNode> getGetChildren();

} // ChildLabelNodeContainer
