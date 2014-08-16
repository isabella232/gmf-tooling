package org.eclipse.gmf.tooling.examples.linklf.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.commands.CircleCreateCommand;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.commands.ContainerCreateCommand;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.commands.RectangleCreateCommand;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.commands.RhombusCreateCommand;
import org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfElementTypes;

/**
 * @generated
 */
public class CanvasItemSemanticEditPolicy extends LinklfBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public CanvasItemSemanticEditPolicy() {
		super(LinklfElementTypes.Canvas_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (LinklfElementTypes.Circle_2001 == req.getElementType()) {
			return getGEFWrapper(new CircleCreateCommand(req));
		}
		if (LinklfElementTypes.Rectangle_2002 == req.getElementType()) {
			return getGEFWrapper(new RectangleCreateCommand(req));
		}
		if (LinklfElementTypes.Container_2003 == req.getElementType()) {
			return getGEFWrapper(new ContainerCreateCommand(req));
		}
		if (LinklfElementTypes.Rhombus_2004 == req.getElementType()) {
			return getGEFWrapper(new RhombusCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
