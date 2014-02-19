/**
 */
package org.eclipse.gmf.tooling.examples.links;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root BA Element Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link#getB <em>B</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link#getA <em>A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRoot_BA_Element_Link()
 * @model
 * @generated
 */
public interface Root_BA_Element_Link extends EObject {
	/**
	 * Returns the value of the '<em><b>B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>B</em>' reference.
	 * @see #setB(RootNodeB)
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRoot_BA_Element_Link_B()
	 * @model
	 * @generated
	 */
	RootNodeB getB();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link#getB <em>B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>B</em>' reference.
	 * @see #getB()
	 * @generated
	 */
	void setB(RootNodeB value);

	/**
	 * Returns the value of the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>A</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>A</em>' reference.
	 * @see #setA(RootNodeA)
	 * @see org.eclipse.gmf.tooling.examples.links.LinksPackage#getRoot_BA_Element_Link_A()
	 * @model
	 * @generated
	 */
	RootNodeA getA();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.links.Root_BA_Element_Link#getA <em>A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>A</em>' reference.
	 * @see #getA()
	 * @generated
	 */
	void setA(RootNodeA value);

} // Root_BA_Element_Link
