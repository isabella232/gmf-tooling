/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Container Edit Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenContainerEditPart#getContainedNodes <em>Contained Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenContainerEditPart()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface GenContainerEditPart extends GenCommonBase {
	/**
	 * Returns the value of the '<em><b>Contained Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.codegen.gmfgen.GenNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Nodes</em>' reference list.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenContainerEditPart_ContainedNodes()
	 * @model type="org.eclipse.gmf.codegen.gmfgen.GenNode" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList getContainedNodes();

} // GenContainerEditPart
