package pins.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import pins.diagram.edit.commands.ColorPinCreateCommand;
import pins.diagram.edit.commands.CustomPinCreateCommand;
import pins.diagram.edit.commands.VisiblePinCreateCommand;
import pins.diagram.providers.PinsElementTypes;

/**
 * @generated
 */
public class DiagramItemSemanticEditPolicy extends PinsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DiagramItemSemanticEditPolicy() {
		super(PinsElementTypes.Diagram_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PinsElementTypes.CustomPin_2001 == req.getElementType()) {
			return getGEFWrapper(new CustomPinCreateCommand(req));
		}
		if (PinsElementTypes.VisiblePin_2002 == req.getElementType()) {
			return getGEFWrapper(new VisiblePinCreateCommand(req));
		}
		if (PinsElementTypes.ColorPin_2003 == req.getElementType()) {
			return getGEFWrapper(new ColorPinCreateCommand(req));
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
