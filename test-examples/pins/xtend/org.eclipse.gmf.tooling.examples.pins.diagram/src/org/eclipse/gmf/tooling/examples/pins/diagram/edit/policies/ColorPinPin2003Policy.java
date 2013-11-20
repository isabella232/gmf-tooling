package org.eclipse.gmf.tooling.examples.pins.diagram.edit.policies;

import org.eclipse.gmf.tooling.examples.pins.diagram.edit.parts.ColorPinEditPart;
import org.eclipse.gmf.tooling.runtime.edit.policies.effect.AbstractOclVisualEffectEditPolicy;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class ColorPinPin2003Policy extends AbstractOclVisualEffectEditPolicy {

	/**
	 * @generated
	 */
	public static final String KEY = "org.eclipse.gmf.tooling.examples.pins.diagram.edit.policies.ColorPinPin2003Policy:KEY";

	/**
	 * @generated
	 */
	public ColorPinPin2003Policy() {
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
		getHostImpl().getPrimaryShape().setBackgroundColor(color);
	}

	/**
	 * @generated
	 */
	@Override
	protected ColorPinEditPart getHostImpl() {
		return (ColorPinEditPart) super.getHostImpl();
	}

	/**
	 * @generated
	 */
	@Override
	protected String getExpressionBody() {
		return "if self.getChildren->size() < 4 then Tuple {red: Integer = 255, green: Integer = 128, blue: Integer = 0} else Tuple {red: Integer = 0, green: Integer = 128, blue: Integer = 0} endif"; //$NON-NLS-1$
	}

}
