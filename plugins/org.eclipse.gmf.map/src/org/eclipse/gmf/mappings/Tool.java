/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.mappings;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.Tool#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.mappings.GMFMapPackage#getTool()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Tool extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.mappings.ToolGroup#getTools <em>Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' reference.
	 * @see #setGroup(ToolGroup)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getTool_Group()
	 * @see org.eclipse.gmf.mappings.ToolGroup#getTools
	 * @model opposite="tools"
	 * @generated
	 */
	ToolGroup getGroup();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.Tool#getGroup <em>Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(ToolGroup value);

} // Tool
