/**
 */
package org.eclipse.gmf.tooling.examples.links;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Node B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.RootNodeB#getChildrenB <em>Children B</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.RootNodeB#getRoot_BA_Feature_Link <em>Root BA Feature Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRootNodeB()
 * @model
 * @generated
 */
public interface RootNodeB extends EObject {
	/**
	 * Returns the value of the '<em><b>Children B</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.links.ChildNodeB}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children B</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children B</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRootNodeB_ChildrenB()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChildNodeB> getChildrenB();

	/**
	 * Returns the value of the '<em><b>Root BA Feature Link</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.links.RootNodeA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root BA Feature Link</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root BA Feature Link</em>' reference list.
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRootNodeB_Root_BA_Feature_Link()
	 * @model
	 * @generated
	 */
	EList<RootNodeA> getRoot_BA_Feature_Link();

} // RootNodeB
