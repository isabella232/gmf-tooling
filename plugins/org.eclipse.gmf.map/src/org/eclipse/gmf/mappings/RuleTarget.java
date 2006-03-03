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
 * A representation of the model object '<em><b>Rule Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The target against which a rule can be evaluated
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.mappings.RuleTarget#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.mappings.GMFMapPackage#getRuleTarget()
 * @model abstract="true"
 * @generated
 */
public interface RuleTarget extends EObject {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.mappings.RuleBase#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The rule bound this rule target
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rule</em>' container reference.
	 * @see #setRule(RuleBase)
	 * @see org.eclipse.gmf.mappings.GMFMapPackage#getRuleTarget_Rule()
	 * @see org.eclipse.gmf.mappings.RuleBase#getTarget
	 * @model opposite="target" required="true"
	 * @generated
	 */
	RuleBase getRule();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.mappings.RuleTarget#getRule <em>Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' container reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(RuleBase value);

} // RuleTarget
