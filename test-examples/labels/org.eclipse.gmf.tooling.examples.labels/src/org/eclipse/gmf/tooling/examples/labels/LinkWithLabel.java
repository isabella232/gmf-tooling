/**
 */
package org.eclipse.gmf.tooling.examples.labels;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link With Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.LinkWithLabel#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.LinkWithLabel#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.labels.LabelsPackage#getLinkWithLabel()
 * @model
 * @generated
 */
public interface LinkWithLabel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(GenLabelNode)
	 * @see org.eclipse.gmf.tooling.examples.labels.LabelsPackage#getLinkWithLabel_Target()
	 * @model
	 * @generated
	 */
	GenLabelNode getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.labels.LinkWithLabel#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(GenLabelNode value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(VerticalLabel)
	 * @see org.eclipse.gmf.tooling.examples.labels.LabelsPackage#getLinkWithLabel_Source()
	 * @model
	 * @generated
	 */
	VerticalLabel getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.labels.LinkWithLabel#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(VerticalLabel value);

} // LinkWithLabel
