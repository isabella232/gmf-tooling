/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ElementType#getEditHelperClassName <em>Edit Helper Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getElementType()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ElementType extends EObject {
	/**
	 * Returns the value of the '<em><b>Edit Helper Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Helper Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edit Helper Class Name</em>' attribute.
	 * @see #setEditHelperClassName(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getElementType_EditHelperClassName()
	 * @model
	 * @generated
	 */
	String getEditHelperClassName();

	public static final String EDIT_HELPER_SUFFIX = "EditHelper";

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ElementType#getEditHelperClassName <em>Edit Helper Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edit Helper Class Name</em>' attribute.
	 * @see #getEditHelperClassName()
	 * @generated
	 */
	void setEditHelperClassName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getEditHelperQualifiedClassName();

} // ElementType
