/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.LinkEntry#getGenLink <em>Gen Link</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.LinkEntry#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getLinkEntry()
 * @model
 * @generated
 */
public interface LinkEntry extends ToolEntry {
	/**
	 * Returns the value of the '<em><b>Gen Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Link</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Link</em>' reference.
	 * @see #setGenLink(GenLink)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getLinkEntry_GenLink()
	 * @model required="true"
	 * @generated
	 */
	GenLink getGenLink();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.LinkEntry#getGenLink <em>Gen Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Link</em>' reference.
	 * @see #getGenLink()
	 * @generated
	 */
	void setGenLink(GenLink value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.ToolGroup#getLinkTools <em>Link Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' container reference.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getLinkEntry_Group()
	 * @see org.eclipse.gmf.codegen.gmfgen.ToolGroup#getLinkTools
	 * @model opposite="linkTools" resolveProxies="false" changeable="false"
	 * @generated
	 */
	ToolGroup getGroup();

} // LinkEntry
