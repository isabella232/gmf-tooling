/**
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Custom Template Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenCustomTemplateInput#getOclType <em>Ocl Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenCustomTemplateInput()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface GenCustomTemplateInput extends EObject {
	/**
	 * Returns the value of the '<em><b>Ocl Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OCL Type for this input, if not set generator will try to compute it
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ocl Type</em>' attribute.
	 * @see #setOclType(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenCustomTemplateInput_OclType()
	 * @model
	 * @generated
	 */
	String getOclType();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenCustomTemplateInput#getOclType <em>Ocl Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Type</em>' attribute.
	 * @see #getOclType()
	 * @generated
	 */
	void setOclType(String value);

} // GenCustomTemplateInput
