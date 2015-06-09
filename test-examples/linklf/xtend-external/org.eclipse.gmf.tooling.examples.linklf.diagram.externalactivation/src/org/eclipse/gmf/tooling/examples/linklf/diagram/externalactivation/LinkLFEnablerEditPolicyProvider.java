package org.eclipse.gmf.tooling.examples.linklf.diagram.externalactivation;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.runtime.linklf.LinkLFShapeNodeAnchorDelegate;
import org.eclipse.gmf.tooling.runtime.linklf.editparts.LinkLFAnchorsDelegatingEditPart;
import org.eclipse.gmf.tooling.runtime.linklf.editparts.LinkLFConnectionNodeEditPart;
import org.eclipse.gmf.tooling.runtime.linklf.policies.AdjustBorderItemAnchorsEditPolicy;
import org.eclipse.gmf.tooling.runtime.linklf.policies.AdjustImplicitlyMovedLinksEditPolicy;
import org.eclipse.gmf.tooling.runtime.linklf.policies.AdjustSyntheticBendpointsEditPolicy;
import org.eclipse.gmf.tooling.runtime.linklf.policies.LinksLFGraphicalNodeEditPolicy;

public class LinkLFEnablerEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	@Override
	public boolean provides(IOperation op) {
		if (false == op instanceof CreateEditPoliciesOperation) {
			return false;
		}
		CreateEditPoliciesOperation operation = (CreateEditPoliciesOperation) op;
		EditPart host = operation.getEditPart();

		if (false == host instanceof IGraphicalEditPart) {
			return false;
		}

		View notationView = ((IGraphicalEditPart) host).getNotationView();
		if (notationView == null) {
			return false;
		}

		Diagram diagram = notationView.getDiagram();
		if (!isSupportedDiagram(diagram)) {
			return false;
		}
		return true;
	}

	private boolean isSupportedDiagram(Diagram diagram) {
		return diagram != null && CanvasEditPart.MODEL_ID.equals(diagram.getType());
	}

	@Override
	public void createEditPolicies(EditPart editPart) {
		if (editPart instanceof LinkLFConnectionNodeEditPart) {
			installLinkEditPolicies((LinkLFConnectionNodeEditPart) editPart);
		} else if (editPart instanceof INodeEditPart) {
			installNodeEditPolicies((INodeEditPart) editPart);
		}
	}

	protected void installLinkEditPolicies(LinkLFConnectionNodeEditPart linkEP) {
		linkEP.setLinkLFEnabled(true);
	}

	protected void installNodeEditPolicies(INodeEditPart nodeEP) {
		if (nodeEP instanceof LinkLFAnchorsDelegatingEditPart) {
			LinkLFAnchorsDelegatingEditPart linklfEP = (LinkLFAnchorsDelegatingEditPart) nodeEP;
			linklfEP.setAnchorDelegate(new LinkLFShapeNodeAnchorDelegate(linklfEP.getNodeFigure()));
		}

		nodeEP.installEditPolicy(AdjustSyntheticBendpointsEditPolicy.ROLE, new AdjustSyntheticBendpointsEditPolicy());
		nodeEP.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new LinksLFGraphicalNodeEditPolicy());
		nodeEP.installEditPolicy(AdjustImplicitlyMovedLinksEditPolicy.ROLE, new AdjustImplicitlyMovedLinksEditPolicy());
		if (nodeEP instanceof IBorderItemEditPart) {
			nodeEP.installEditPolicy(AdjustBorderItemAnchorsEditPolicy.ROLE, new AdjustBorderItemAnchorsEditPolicy());
		}
	}

}
