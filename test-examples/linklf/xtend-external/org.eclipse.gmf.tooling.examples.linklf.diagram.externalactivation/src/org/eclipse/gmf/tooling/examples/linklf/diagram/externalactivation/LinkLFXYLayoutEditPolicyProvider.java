package org.eclipse.gmf.tooling.examples.linklf.diagram.externalactivation;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.runtime.linklf.xylayout.XYLayoutWithFixAnchorsEditPolicy;

/**
 * This provider replaces default XYLayoutEditPolicy with its LinkLF counterpart version.
 * It is separated from "main" {@link LinkLFEnablerEditPolicyProvider} because it is common to replace {@link XYLayoutEditPolicy} 
 * with custom version. 
 * E.g, Papyrus installs advanced XYLayoutWithConstrainedResizedEditPolicy (which does similar trick) by default. 
 */
public class LinkLFXYLayoutEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	@Override
	public boolean provides(IOperation op) {
		if (false == op instanceof CreateEditPoliciesOperation) {
			return false;
		}
		CreateEditPoliciesOperation operation = (CreateEditPoliciesOperation) op;
		EditPart host = operation.getEditPart();

		if (host instanceof ShapeCompartmentEditPart || host instanceof DiagramEditPart) {
			View notationView = ((IGraphicalEditPart) host).getNotationView();
			return notationView != null && isSupportedDiagram(notationView.getDiagram());
		}
		return false;
	}

	private boolean isSupportedDiagram(Diagram diagram) {
		return diagram != null && CanvasEditPart.MODEL_ID.equals(diagram.getType());
	}

	@Override
	public void createEditPolicies(EditPart editPart) {
		EditPolicy defaultEP = editPart.getEditPolicy(EditPolicy.LAYOUT_ROLE);
		if (defaultEP != null && defaultEP.getClass() == XYLayoutEditPolicy.class) {
			editPart.installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutWithFixAnchorsEditPolicy());
		}
	}

}
