package org.eclipse.gmf.examples.eclipsecon.diagram.custom.editpolicies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;


public class ElementDragDropEditPolicy
	extends DragDropEditPolicy {

	/**
	 * getDropElementCommand
	 * @param dropElement
	 * @return
	 */
	protected Command getDropElementCommand(EObject dropElement, DropObjectsRequest request) {
		
		EObject newParent = ViewUtil.resolveSemanticElement(((IGraphicalEditPart)getHost()).getNotationView());
		MoveRequest moveRequest = new MoveRequest(newParent, dropElement);

		IElementType elementType = ElementTypeRegistry.getInstance()
			.getElementType(moveRequest.getEditHelperContext());
		ICommand cmd = elementType.getEditCommand(moveRequest);
		if (cmd != null)
			return new EtoolsProxyCommand(cmd);
		
		return null;
	}
}
