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
 * A representation of the model object '<em><b>Gen Rule Container Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base container for rules like audit, metrics...
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenRuleContainerBase#getEditor <em>Editor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenRuleContainerBase()
 * @model abstract="true"
 * @generated
 */
public interface GenRuleContainerBase extends EObject {
	/**
	 * Returns the value of the '<em><b>Editor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The editor generator containing this rule container
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Editor</em>' reference.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenRuleContainerBase_Editor()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	GenEditorGenerator getEditor();

} // GenRuleContainerBase
