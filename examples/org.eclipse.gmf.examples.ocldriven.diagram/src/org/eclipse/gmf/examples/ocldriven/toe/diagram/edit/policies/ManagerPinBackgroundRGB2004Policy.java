package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerEditPart;
import org.eclipse.gmf.tooling.runtime.edit.policies.effect.AbstractOclVisualEffectEditPolicy;
import org.eclipse.ocl.util.Tuple;

/**
 * @generated
 */
public class ManagerPinBackgroundRGB2004Policy extends AbstractOclVisualEffectEditPolicy {

	/**
	* @generated
	*/
	public static final String KEY = "org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.ManagerPinBackgroundRGB2004Policy:KEY";

	/**
	* @generated
	*/
	public ManagerPinBackgroundRGB2004Policy() {
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

		getHostImpl().getPrimaryShape().setBackgroundRGB(red, green, blue);

	}

	/**
	* @generated
	*/
	@Override
	protected ManagerEditPart getHostImpl() {
		return (ManagerEditPart) super.getHostImpl();
	}

	/**
	* @generated
	*/
	@Override
	protected String getExpressionBody() {
		return "if self.leads->size() = 0 \r\nthen Tuple {red: Integer = 0, green: Integer = 0, blue: Integer = 255} \r\nelse Tuple {red: Integer = 255, green: Integer = 255, blue: Integer = 0} \r\nendif"; //$NON-NLS-1$
	}

}
