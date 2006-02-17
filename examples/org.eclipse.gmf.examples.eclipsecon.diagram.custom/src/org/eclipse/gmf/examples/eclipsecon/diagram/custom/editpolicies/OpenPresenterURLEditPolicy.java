package org.eclipse.gmf.examples.eclipsecon.diagram.custom.editpolicies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.swt.program.Program;


public class OpenPresenterURLEditPolicy
	extends OpenEditPolicy {

	protected Command getOpenCommand(Request request) {
		return new Command() {

			/* (non-Javadoc)
			 * @see org.eclipse.gef.commands.Command#execute()
			 */
			public void execute() {
				Program.launch("http://www.titanic.com");//$NON-NLS-1$
			}
			
		};
	}

}
