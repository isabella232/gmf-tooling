/**
 */
package org.eclipse.gmf.tooling.examples.links;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.Root#getChildABElementLinks <em>Child AB Element Links</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.Root#getRootNodeAs <em>Root Node As</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.Root#getRootNodeBs <em>Root Node Bs</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.Root#getRootBALinks <em>Root BA Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject {
	/**
	 * Returns the value of the '<em><b>Child AB Element Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child AB Element Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child AB Element Links</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRoot_ChildABElementLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Child_AB_Element_Link> getChildABElementLinks();

	/**
	 * Returns the value of the '<em><b>Root Node As</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.links.RootNodeA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Node As</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Node As</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRoot_RootNodeAs()
	 * @model containment="true"
	 * @generated
	 */
	EList<RootNodeA> getRootNodeAs();

	/**
	 * Returns the value of the '<em><b>Root Node Bs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.links.RootNodeB}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Node Bs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Node Bs</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRoot_RootNodeBs()
	 * @model containment="true"
	 * @generated
	 */
	EList<RootNodeB> getRootNodeBs();

	/**
	 * Returns the value of the '<em><b>Root BA Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root BA Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root BA Links</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRoot_RootBALinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Root_BA_Element_Link> getRootBALinks();

} // Root
