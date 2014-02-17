/**
 */
package org.eclipse.gmf.tooling.examples.links;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Node A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.RootNodeA#getChildrenNodeA <em>Children Node A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRootNodeA()
 * @model
 * @generated
 */
public interface RootNodeA extends EObject {
	/**
	 * Returns the value of the '<em><b>Children Node A</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.links.ChildNodeA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children Node A</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children Node A</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRootNodeA_ChildrenNodeA()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChildNodeA> getChildrenNodeA();

} // RootNodeA
