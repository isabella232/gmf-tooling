package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Employee2EditPart;
import org.eclipse.gmf.tooling.runtime.edit.policies.effect.AbstractOclVisualEffectEditPolicy;

/**
 * @generated
 */
public class EmployeePinVisible3001Policy extends AbstractOclVisualEffectEditPolicy {

	/**
	* @generated
	*/
	public static final String KEY = "org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.EmployeePinVisible3001Policy:KEY";

	/**
	* @generated
	*/
	public EmployeePinVisible3001Policy() {
		super();
	}

	/**
	* @generated
	*/
	@Override
	protected void setVisualEffectValue(Object value) {
		getHostImpl().getPrimaryShape().getInnerEmployeeFigure().setVisible((Boolean) value);

	}

	/**
	* @generated
	*/
	@Override
	protected Employee2EditPart getHostImpl() {
		return (Employee2EditPart) super.getHostImpl();
	}

	/**
	* @generated
	*/
	@Override
	protected String getExpressionBody() {
		return "self.projects->size() <> 0"; //$NON-NLS-1$
	}

}
