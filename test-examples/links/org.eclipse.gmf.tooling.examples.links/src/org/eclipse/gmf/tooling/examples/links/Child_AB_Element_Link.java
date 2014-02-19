/**
 */
package org.eclipse.gmf.tooling.examples.links;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child AB Element Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link#getSource_A <em>Source A</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link#getTarget_B <em>Target B</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getChild_AB_Element_Link()
 * @model
 * @generated
 */
public interface Child_AB_Element_Link extends EObject {
	/**
	 * Returns the value of the '<em><b>Source A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source A</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source A</em>' reference.
	 * @see #setSource_A(ChildNodeA)
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getChild_AB_Element_Link_Source_A()
	 * @model
	 * @generated
	 */
	ChildNodeA getSource_A();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link#getSource_A <em>Source A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source A</em>' reference.
	 * @see #getSource_A()
	 * @generated
	 */
	void setSource_A(ChildNodeA value);

	/**
	 * Returns the value of the '<em><b>Target B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target B</em>' reference.
	 * @see #setTarget_B(ChildNodeB)
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getChild_AB_Element_Link_Target_B()
	 * @model
	 * @generated
	 */
	ChildNodeB getTarget_B();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.links.Child_AB_Element_Link#getTarget_B <em>Target B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target B</em>' reference.
	 * @see #getTarget_B()
	 * @generated
	 */
	void setTarget_B(ChildNodeB value);

} // Child_AB_Element_Link
