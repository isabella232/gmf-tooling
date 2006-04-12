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
 * <!-- begin-model-doc -->
 * Base element type
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ElementType#getDiagramElement <em>Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ElementType#getUniqueIdentifier <em>Unique Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getElementType()
 * @model abstract="true"
 * @generated
 */
public interface ElementType extends EObject {
	/**
	 * Returns the value of the '<em><b>Diagram Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.GenCommonBase#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Element</em>' container reference.
	 * @see #setDiagramElement(GenCommonBase)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getElementType_DiagramElement()
	 * @see org.eclipse.gmf.codegen.gmfgen.GenCommonBase#getElementType
	 * @model opposite="elementType" required="true"
	 * @generated
	 */
	GenCommonBase getDiagramElement();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ElementType#getDiagramElement <em>Diagram Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Element</em>' container reference.
	 * @see #getDiagramElement()
	 * @generated
	 */
	void setDiagramElement(GenCommonBase value);

	/**
	 * Returns the value of the '<em><b>Unique Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Identifier</em>' attribute.
	 * @see #setUniqueIdentifier(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getElementType_UniqueIdentifier()
	 * @model required="true"
	 * @generated
	 */
	String getUniqueIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ElementType#getUniqueIdentifier <em>Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique Identifier</em>' attribute.
	 * @see #getUniqueIdentifier()
	 * @generated
	 */
	void setUniqueIdentifier(String value);

} // ElementType
