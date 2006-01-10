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
 * A representation of the model object '<em><b>Model Element Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents an boolean type expression which is criterion for model element match
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getModelElementSelector()
 * @model annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='Constraint'"
 * @generated
 */
public interface ModelElementSelector extends ValueExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="java.lang.String"
	 * @generated
	 */
	EList getRequiredPluginIDs();

} // ModelElementSelector
