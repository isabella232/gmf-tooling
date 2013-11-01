package org.eclipse.gmf.tooling.examples.pins.diagram.edit.policies;

import org.eclipse.gmf.tooling.examples.pins.diagram.edit.parts.ChangeableColorPinEditPart;
import org.eclipse.gmf.tooling.runtime.edit.policies.effect.AbstractOclVisualEffectEditPolicy;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class PinChangeableColor2004Policy extends AbstractOclVisualEffectEditPolicy {

	/**
	* @generated
	*/
	public static final String KEY = "org.eclipse.gmf.tooling.examples.pins.diagram.edit.policies.PinChangeableColor2004Policy:KEY";

	/**
	* @generated
	*/
	public PinChangeableColor2004Policy() {
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
	protected ChangeableColorPinEditPart getHostImpl() {
		return (ChangeableColorPinEditPart) super.getHostImpl();
	}

	/**
	* @generated
	*/
	@Override
	protected String getExpressionBody() {
		return "Tuple {red: Integer = self.red, green: Integer = self.green, blue: Integer = self.blue}"; //$NON-NLS-1$
	}

}
