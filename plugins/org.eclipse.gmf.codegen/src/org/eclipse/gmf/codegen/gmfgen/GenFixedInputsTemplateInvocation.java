/**
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Fixed Inputs Template Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenFixedInputsTemplateInvocation#getFixedInputs <em>Fixed Inputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenFixedInputsTemplateInvocation()
 * @model
 * @generated
 */
public interface GenFixedInputsTemplateInvocation extends GenTemplateInvocationBase, GenCustomTemplateInput {
	/**
	 * Returns the value of the '<em><b>Fixed Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Predefined set of input elements for template. 
	 * 		Due to reconciling it normally makes sense only for local links inside the same extension or 
	 * 		for extensions created by custom bridge extension (self.extension.fromCustomBridge = true)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fixed Inputs</em>' reference list.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenFixedInputsTemplateInvocation_FixedInputs()
	 * @model
	 * @generated
	 */
	EList<EObject> getFixedInputs();

} // GenFixedInputsTemplateInvocation
