/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.NodeEntry#getGenNode <em>Gen Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.NodeEntry#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getNodeEntry()
 * @model
 * @generated
 */
public interface NodeEntry extends ToolEntry {
	/**
	 * Returns the value of the '<em><b>Gen Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Node</em>' reference.
	 * @see #setGenNode(GenNode)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getNodeEntry_GenNode()
	 * @model required="true"
	 * @generated
	 */
	GenNode getGenNode();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.NodeEntry#getGenNode <em>Gen Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Node</em>' reference.
	 * @see #getGenNode()
	 * @generated
	 */
	void setGenNode(GenNode value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.ToolGroup#getNodeTools <em>Node Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' container reference.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getNodeEntry_Group()
	 * @see org.eclipse.gmf.codegen.gmfgen.ToolGroup#getNodeTools
	 * @model opposite="nodeTools" resolveProxies="false" changeable="false"
	 * @generated
	 */
	ToolGroup getGroup();

} // NodeEntry
