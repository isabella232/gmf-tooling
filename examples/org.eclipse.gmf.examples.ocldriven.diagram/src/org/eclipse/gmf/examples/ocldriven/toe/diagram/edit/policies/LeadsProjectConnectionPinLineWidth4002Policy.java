package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.ocldriven.toe.Project;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerLeadsEditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.effect.AbstractOclVisualEffectEditPolicy;
import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTrackerFactory;

/**
 * @generated
 */
public class LeadsProjectConnectionPinLineWidth4002Policy extends AbstractOclVisualEffectEditPolicy {

	/**
	* @generated
	*/
	public static final String KEY = "org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.LeadsProjectConnectionPinLineWidth4002Policy:KEY";

	/**
	* @generated
	*/
	public LeadsProjectConnectionPinLineWidth4002Policy() {
		super(OclTrackerFactory.Type.IMPACT_ANALYZER);
	}

	/**
	* @generated
	*/
	@Override
	protected void setVisualEffectValue(Object value) {
		getHostImpl().getPrimaryShape().setLineWidth((Integer) value);

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
				+ "--IA\r\nif _src.leads->size() > 2\r\nthen 3\r\nelse 1\r\nendif"; //$NON-NLS-1$
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
