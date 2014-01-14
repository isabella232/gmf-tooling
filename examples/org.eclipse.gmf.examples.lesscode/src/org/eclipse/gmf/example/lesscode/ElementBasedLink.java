/**
 */
package org.eclipse.gmf.example.lesscode;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Based Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.example.lesscode.ElementBasedLink#getLinkSource <em>Link Source</em>}</li>
 *   <li>{@link org.eclipse.gmf.example.lesscode.ElementBasedLink#getLinkTarget <em>Link Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getElementBasedLink()
 * @model
 * @generated
 */
public interface ElementBasedLink extends WithSomeAttributes {
	/**
	 * Returns the value of the '<em><b>Link Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Source</em>' reference.
	 * @see #setLinkSource(Subject)
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getElementBasedLink_LinkSource()
	 * @model
	 * @generated
	 */
	Subject getLinkSource();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.example.lesscode.ElementBasedLink#getLinkSource <em>Link Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Source</em>' reference.
	 * @see #getLinkSource()
	 * @generated
	 */
	void setLinkSource(Subject value);

	/**
	 * Returns the value of the '<em><b>Link Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Target</em>' reference.
	 * @see #setLinkTarget(Subject)
	 * @see org.eclipse.gmf.example.lesscode.LesscodePackage#getElementBasedLink_LinkTarget()
	 * @model
	 * @generated
	 */
	Subject getLinkTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.example.lesscode.ElementBasedLink#getLinkTarget <em>Link Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Target</em>' reference.
	 * @see #getLinkTarget()
	 * @generated
	 */
	void setLinkTarget(Subject value);

} // ElementBasedLink
