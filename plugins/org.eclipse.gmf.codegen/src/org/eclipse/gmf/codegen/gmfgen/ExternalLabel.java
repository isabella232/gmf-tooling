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
 * A representation of the model object '<em><b>External Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Label attached to node/link
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ExternalLabel#getTextEditPartClassName <em>Text Edit Part Class Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ExternalLabel#getTextNotationViewFactoryClassName <em>Text Notation View Factory Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getExternalLabel()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ExternalLabel extends EObject {
	/**
	 * Returns the value of the '<em><b>Text Edit Part Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Edit Part Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Edit Part Class Name</em>' attribute.
	 * @see #setTextEditPartClassName(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getExternalLabel_TextEditPartClassName()
	 * @model
	 * @generated
	 */
	String getTextEditPartClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ExternalLabel#getTextEditPartClassName <em>Text Edit Part Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Edit Part Class Name</em>' attribute.
	 * @see #getTextEditPartClassName()
	 * @generated
	 */
	void setTextEditPartClassName(String value);

	/**
	 * Returns the value of the '<em><b>Text Notation View Factory Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Notation View Factory Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Notation View Factory Class Name</em>' attribute.
	 * @see #setTextNotationViewFactoryClassName(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getExternalLabel_TextNotationViewFactoryClassName()
	 * @model
	 * @generated
	 */
	String getTextNotationViewFactoryClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ExternalLabel#getTextNotationViewFactoryClassName <em>Text Notation View Factory Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Notation View Factory Class Name</em>' attribute.
	 * @see #getTextNotationViewFactoryClassName()
	 * @generated
	 */
	void setTextNotationViewFactoryClassName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getTextEditPartQualifiedClassName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getTextNotationViewFactoryQualifiedClassName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getSemanticHintLabelFieldName();

	public static final String TEXT_EDIT_PART_SUFFIX = "TextEditPart";

	public static final String TEXT_NOTATION_VIEW_FACTORY_SUFFIX = "TextViewFactory";

} // ExternalLabel
