package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentEditPart;
import org.eclipse.gmf.tooling.runtime.edit.policies.effect.AbstractOclVisualEffectEditPolicy;
import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTrackerFactory;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class DepartmentPinForeground2002Policy extends AbstractOclVisualEffectEditPolicy {

	/**
	* @generated
	*/
	public static final String KEY = "org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.DepartmentPinForeground2002Policy:KEY";

	/**
	* @generated
	*/
	public DepartmentPinForeground2002Policy() {
		super(OclTrackerFactory.Type.IMPACT_ANALYZER);
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
	protected DepartmentEditPart getHostImpl() {
		return (DepartmentEditPart) super.getHostImpl();
	}

	/**
	* @generated
	*/
	@Override
	protected String getExpressionBody() {
		return "--IA\r\nlet totalSalary : Integer = self.employees->iterate(\r\ne: Employee; sum : Integer = 0 | \r\nsum + e.salary\r\n) in \r\nif totalSalary > 10000 \r\nthen Tuple {red: Integer = 255, green: Integer = 0, blue: Integer = 0} \r\nelse Tuple {red: Integer = 0, green: Integer = 255, blue: Integer = 0} \r\nendif"; //$NON-NLS-1$
	}

}
