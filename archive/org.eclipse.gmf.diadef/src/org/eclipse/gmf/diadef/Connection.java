/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.diadef;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.diadef.Connection#getLineKind <em>Line Kind</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.Connection#getSourceAdornment <em>Source Adornment</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.Connection#getTargetAdornment <em>Target Adornment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends DiagramElement {
	/**
	 * Returns the value of the '<em><b>Line Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gmf.diadef.LineKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Kind</em>' attribute.
	 * @see org.eclipse.gmf.diadef.LineKind
	 * @see #setLineKind(LineKind)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getConnection_LineKind()
	 * @model required="true"
	 * @generated
	 */
	LineKind getLineKind();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.Connection#getLineKind <em>Line Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Kind</em>' attribute.
	 * @see org.eclipse.gmf.diadef.LineKind
	 * @see #getLineKind()
	 * @generated
	 */
	void setLineKind(LineKind value);

	/**
	 * Returns the value of the '<em><b>Source Adornment</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gmf.diadef.AdornmentKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Adornment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Adornment</em>' attribute.
	 * @see org.eclipse.gmf.diadef.AdornmentKind
	 * @see #setSourceAdornment(AdornmentKind)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getConnection_SourceAdornment()
	 * @model
	 * @generated
	 */
	AdornmentKind getSourceAdornment();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.Connection#getSourceAdornment <em>Source Adornment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Adornment</em>' attribute.
	 * @see org.eclipse.gmf.diadef.AdornmentKind
	 * @see #getSourceAdornment()
	 * @generated
	 */
	void setSourceAdornment(AdornmentKind value);

	/**
	 * Returns the value of the '<em><b>Target Adornment</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gmf.diadef.AdornmentKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Adornment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Adornment</em>' attribute.
	 * @see org.eclipse.gmf.diadef.AdornmentKind
	 * @see #setTargetAdornment(AdornmentKind)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getConnection_TargetAdornment()
	 * @model
	 * @generated
	 */
	AdornmentKind getTargetAdornment();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.Connection#getTargetAdornment <em>Target Adornment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Adornment</em>' attribute.
	 * @see org.eclipse.gmf.diadef.AdornmentKind
	 * @see #getTargetAdornment()
	 * @generated
	 */
	void setTargetAdornment(AdornmentKind value);

} // Connection
