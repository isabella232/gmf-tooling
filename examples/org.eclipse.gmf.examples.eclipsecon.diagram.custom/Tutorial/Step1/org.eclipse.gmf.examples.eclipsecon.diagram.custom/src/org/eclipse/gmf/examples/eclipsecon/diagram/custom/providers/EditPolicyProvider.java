package org.eclipse.gmf.examples.eclipsecon.diagram.custom.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.editpolicies.OpenResourceURLEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.editpolicies.PresenterDragDropEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.TutorialEditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;


public class EditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider#createEditPolicies(org.eclipse.gef.EditPart)
	 */
	public void createEditPolicies(EditPart editPart) {
		if (editPart instanceof ResourceEditPart)
			editPart.installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenResourceURLEditPolicy());
        else if (editPart instanceof TutorialEditPart)
            editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
                new PresenterDragDropEditPolicy());
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation cepOper = (CreateEditPoliciesOperation)operation;
			if (cepOper.getEditPart() instanceof ResourceEditPart)
				return true;
			else if (cepOper.getEditPart() instanceof TutorialEditPart)
				return true;
		}
		return false;
	}

}
