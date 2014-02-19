/**
 */
package org.eclipse.gmf.tooling.examples.links;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Node A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.ChildNodeA#getChild_AB_Feature_Link <em>Child AB Feature Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getChildNodeA()
 * @model
 * @generated
 */
public interface ChildNodeA extends EObject {
	/**
	 * Returns the value of the '<em><b>Child AB Feature Link</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.links.ChildNodeB}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child AB Feature Link</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child AB Feature Link</em>' reference list.
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getChildNodeA_Child_AB_Feature_Link()
	 * @model
	 * @generated
	 */
	EList<ChildNodeB> getChild_AB_Feature_Link();

} // ChildNodeA
