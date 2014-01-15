/**
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Template Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenTemplateInvocation#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenTemplateInvocation#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenTemplateInvocation()
 * @model
 * @generated
 */
public interface GenTemplateInvocation extends GenTemplateInvocationBase {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.codegen.gmfgen.GenCustomTemplateInput}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Set of referenced inputs for this invocation, 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenTemplateInvocation_Inputs()
	 * @model
	 * @generated
	 */
	EList<GenCustomTemplateInput> getInputs();

	/**
	 * Returns the value of the '<em><b>Ocl Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OCL expression to be executed against the set of other inputs to compute the inputs for template
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ocl Expression</em>' attribute.
	 * @see #setOclExpression(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenTemplateInvocation_OclExpression()
	 * @model
	 * @generated
	 */
	String getOclExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenTemplateInvocation#getOclExpression <em>Ocl Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression</em>' attribute.
	 * @see #getOclExpression()
	 * @generated
	 */
	void setOclExpression(String value);

} // GenTemplateInvocation
