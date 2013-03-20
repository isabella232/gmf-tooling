package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.ocldriven.toe.Project;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerLeadsEditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.effect.AbstractOclVisualEffectEditPolicy;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class LeadsProjectConnectionPinForeground4002Policy extends AbstractOclVisualEffectEditPolicy {

	/**
	* @generated
	*/
	public static final String KEY = "org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.LeadsProjectConnectionPinForeground4002Policy:KEY";

	/**
	* @generated
	*/
	public LeadsProjectConnectionPinForeground4002Policy() {
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
	protected ManagerLeadsEditPart getHostImpl() {
		return (ManagerLeadsEditPart) super.getHostImpl();
	}

	/**
	* @generated
	*/
	@Override
	protected String getExpressionBody() {
		return " let _src : Manager = self.lead in " //
				+ " let _dst : Project = self in " //
				+ "if _src.leads->size() > 2\r\nthen Tuple {red: Integer = 255, green: Integer = 128, blue: Integer = 0} \r\nelse Tuple {red: Integer = 255, green: Integer =0, blue: Integer = 0} \r\nendif"; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	@Override
	protected EObject getContext() {
		Edge hostModel = (Edge) host().getModel();
		View targetModel = hostModel.getTarget();
		View sourceModel = hostModel.getSource();

		if (targetModel == null || sourceModel == null) {
			return null;
		}

		EObject targetSemanticModel = ViewUtil.resolveSemanticElement(targetModel);
		// need to check actual opposite of the semantic element, since diagram opposite could be not up to date
		Project targetTypedModel = (Project) targetSemanticModel;
		EObject sourceSemanticModel = targetTypedModel.getLead();

		if (sourceSemanticModel == null) {
			return null;
		}

		return targetSemanticModel;
	}
}
