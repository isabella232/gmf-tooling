/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Label Model Facet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Model facet of a label calculated with an expression
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ExpressionLabelModelFacet#getViewExpression <em>View Expression</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ExpressionLabelModelFacet#getEditExpression <em>Edit Expression</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ExpressionLabelModelFacet#getValidateExpression <em>Validate Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getExpressionLabelModelFacet()
 * @model
 * @generated
 */
public interface ExpressionLabelModelFacet extends LabelModelFacet {
	/**
	 * Returns the value of the '<em><b>View Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Expression to calculate user-readable label value
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>View Expression</em>' reference.
	 * @see #setViewExpression(ValueExpression)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getExpressionLabelModelFacet_ViewExpression()
	 * @model required="true"
	 * @generated
	 */
	ValueExpression getViewExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ExpressionLabelModelFacet#getViewExpression <em>View Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Expression</em>' reference.
	 * @see #getViewExpression()
	 * @generated
	 */
	void setViewExpression(ValueExpression value);

	/**
	 * Returns the value of the '<em><b>Edit Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional expression to represent value for editing
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Edit Expression</em>' reference.
	 * @see #setEditExpression(ValueExpression)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getExpressionLabelModelFacet_EditExpression()
	 * @model
	 * @generated
	 */
	ValueExpression getEditExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ExpressionLabelModelFacet#getEditExpression <em>Edit Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edit Expression</em>' reference.
	 * @see #getEditExpression()
	 * @generated
	 */
	void setEditExpression(ValueExpression value);

	/**
	 * Returns the value of the '<em><b>Validate Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional expression to answer whether user input is ok for further parsing
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Validate Expression</em>' reference.
	 * @see #setValidateExpression(GenConstraint)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getExpressionLabelModelFacet_ValidateExpression()
	 * @model
	 * @generated
	 */
	GenConstraint getValidateExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ExpressionLabelModelFacet#getValidateExpression <em>Validate Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Expression</em>' reference.
	 * @see #getValidateExpression()
	 * @generated
	 */
	void setValidateExpression(GenConstraint value);

} // ExpressionLabelModelFacet
