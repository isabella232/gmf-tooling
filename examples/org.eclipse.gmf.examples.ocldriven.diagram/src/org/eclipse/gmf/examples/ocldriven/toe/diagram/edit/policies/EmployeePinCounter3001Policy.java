package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Employee2EditPart;
import org.eclipse.gmf.tooling.runtime.edit.policies.effect.AbstractOclVisualEffectEditPolicy;

/**
 * @generated
 */
public class EmployeePinCounter3001Policy extends AbstractOclVisualEffectEditPolicy {

	/**
	* @generated
	*/
	public static final String KEY = "org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.EmployeePinCounter3001Policy:KEY";

	/**
	* @generated
	*/
	public EmployeePinCounter3001Policy() {
		super();
	}

	/**
	* @generated
	*/
	@Override
	protected void setVisualEffectValue(Object value) {
		getHostImpl().getPrimaryShape().getInnerEmployeeFigure().setCounter((Integer) value);

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
		return "self.projects->size()"; //$NON-NLS-1$
	}

}
