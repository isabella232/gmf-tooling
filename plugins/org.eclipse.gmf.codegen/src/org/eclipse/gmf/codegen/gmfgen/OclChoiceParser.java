/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Ocl Choice Parser</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.OclChoiceParser#getItemsExpression <em>Items Expression</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.OclChoiceParser#getShowExpression <em>Show Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getOclChoiceParser()
 * @model
 * @generated
 */
public interface OclChoiceParser extends GenParserImplementation {

	/**
	 * Returns the value of the '<em><b>Items Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items Expression</em>' reference.
	 * @see #setItemsExpression(ValueExpression)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getOclChoiceParser_ItemsExpression()
	 * @model
	 * @generated
	 */
	ValueExpression getItemsExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.OclChoiceParser#getItemsExpression <em>Items Expression</em>}' reference.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Items Expression</em>' reference.
	 * @see #getItemsExpression()
	 * @generated
	 */
	void setItemsExpression(ValueExpression value);

	/**
	 * Returns the value of the '<em><b>Show Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Expression</em>' reference.
	 * @see #setShowExpression(ValueExpression)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getOclChoiceParser_ShowExpression()
	 * @model
	 * @generated
	 */
	ValueExpression getShowExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.OclChoiceParser#getShowExpression <em>Show Expression</em>}' reference.
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Expression</em>' reference.
	 * @see #getShowExpression()
	 * @generated
	 */
	void setShowExpression(ValueExpression value);

	/**
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getQualifiedClassName();

} // OclChoiceParser
