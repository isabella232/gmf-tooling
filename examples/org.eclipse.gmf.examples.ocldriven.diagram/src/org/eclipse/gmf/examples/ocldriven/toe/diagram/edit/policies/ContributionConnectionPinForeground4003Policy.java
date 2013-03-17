package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ContributionEditPart;
import org.eclipse.gmf.tooling.runtime.edit.policies.effect.AbstractOclVisualEffectEditPolicy;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class ContributionConnectionPinForeground4003Policy extends AbstractOclVisualEffectEditPolicy {

	/**
	* @generated
	*/
	public static final String KEY = "org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.ContributionConnectionPinForeground4003Policy:KEY";

	/**
	* @generated
	*/
	public ContributionConnectionPinForeground4003Policy() {
		super();
	}

	/**
	* @generated
	*/
	@Override
	protected void setVisualEffectValue(Object value) {
		Tuple<?, ?> tupleValue = (Tuple<?, ?>) value;
		Integer red = (Integer) tupleValue.getValue("red");
		Integer green = (Integer) tupleValue.getValue("green");
		Integer blue = (Integer) tupleValue.getValue("blue");
		Color color = new Color(null, red, green, blue);
		getHostImpl().getPrimaryShape().setForegroundColor(color);
	}

	/**
	* @generated
	*/
	@Override
	protected ContributionEditPart getHostImpl() {
		return (ContributionEditPart) super.getHostImpl();
	}

	/**
	* @generated
	*/
	@Override
	protected String getExpressionBody() {
		return " let _src : Employee = self.employee in " //
				+ " let _dst : Project = self.project in " //
				+ "if _src.contributions->size() > _dst.contributions->size()\r\nthen Tuple {red: Integer = 0, green: Integer = 255, blue: Integer = 0} \r\nelse Tuple {red: Integer = 0, green: Integer =0, blue: Integer = 255} \r\nendif"; //$NON-NLS-1$
	}

}
