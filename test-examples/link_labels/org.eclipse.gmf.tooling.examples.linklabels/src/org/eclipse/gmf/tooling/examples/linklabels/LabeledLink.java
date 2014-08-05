/**
 */
package org.eclipse.gmf.tooling.examples.linklabels;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Labeled Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getSemanticLabel <em>Semantic Label</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getFixedLabel <em>Fixed Label</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getOclLabel <em>Ocl Label</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.linklabels.LinklabelsPackage#getLabeledLink()
 * @model
 * @generated
 */
public interface LabeledLink extends CanvasElement {
	/**
	 * Returns the value of the '<em><b>Semantic Label</b></em>' attribute.
	 * The default value is <code>"Semantic"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantic Label</em>' attribute.
	 * @see #setSemanticLabel(String)
	 * @see org.eclipse.gmf.tooling.examples.linklabels.LinklabelsPackage#getLabeledLink_SemanticLabel()
	 * @model default="Semantic"
	 * @generated
	 */
	String getSemanticLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getSemanticLabel <em>Semantic Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantic Label</em>' attribute.
	 * @see #getSemanticLabel()
	 * @generated
	 */
	void setSemanticLabel(String value);

	/**
	 * Returns the value of the '<em><b>Fixed Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Label</em>' attribute.
	 * @see #setFixedLabel(String)
	 * @see org.eclipse.gmf.tooling.examples.linklabels.LinklabelsPackage#getLabeledLink_FixedLabel()
	 * @model
	 * @generated
	 */
	String getFixedLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getFixedLabel <em>Fixed Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Label</em>' attribute.
	 * @see #getFixedLabel()
	 * @generated
	 */
	void setFixedLabel(String value);

	/**
	 * Returns the value of the '<em><b>Ocl Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Label</em>' attribute.
	 * @see #setOclLabel(String)
	 * @see org.eclipse.gmf.tooling.examples.linklabels.LinklabelsPackage#getLabeledLink_OclLabel()
	 * @model
	 * @generated
	 */
	String getOclLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getOclLabel <em>Ocl Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Label</em>' attribute.
	 * @see #getOclLabel()
	 * @generated
	 */
	void setOclLabel(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(CanvasElement)
	 * @see org.eclipse.gmf.tooling.examples.linklabels.LinklabelsPackage#getLabeledLink_Source()
	 * @model
	 * @generated
	 */
	CanvasElement getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(CanvasElement value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(CanvasElement)
	 * @see org.eclipse.gmf.tooling.examples.linklabels.LinklabelsPackage#getLabeledLink_Target()
	 * @model
	 * @generated
	 */
	CanvasElement getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.examples.linklabels.LabeledLink#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(CanvasElement value);

} // LabeledLink
