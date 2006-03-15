package org.eclipse.gmf.examples.eclipsecon.diagram.custom.editpolicies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.examples.eclipsecon.Resource;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.swt.program.Program;


public class OpenResourceURLEditPolicy
	extends OpenEditPolicy {

	protected Command getOpenCommand(Request request) {
		return new Command("") { //$NON-NLS-1$

			/* (non-Javadoc)
			 * @see org.eclipse.gef.commands.Command#execute()
			 */
			public void execute() {
				IGraphicalEditPart gep = (IGraphicalEditPart)getHost();
				EObject eobj = gep.resolveSemanticElement();
				if (eobj instanceof Resource) {
					Resource resource = (Resource)eobj;
					String location = resource.getLocation();
					Program.launch(location);
				}
			}
			
		};
	}

}
