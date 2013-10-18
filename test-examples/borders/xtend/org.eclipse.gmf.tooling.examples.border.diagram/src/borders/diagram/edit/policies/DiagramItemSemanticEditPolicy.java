package borders.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import borders.diagram.edit.commands.CompoundBorderCreateCommand;
import borders.diagram.edit.commands.CustomBorderCreateCommand;
import borders.diagram.edit.commands.LineBorderCreateCommand;
import borders.diagram.edit.commands.MarginBorderCreateCommand;
import borders.diagram.providers.BordersElementTypes;

/**
 * @generated
 */
public class DiagramItemSemanticEditPolicy extends
		BordersBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DiagramItemSemanticEditPolicy() {
		super(BordersElementTypes.Diagram_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (BordersElementTypes.MarginBorder_2001 == req.getElementType()) {
			return getGEFWrapper(new MarginBorderCreateCommand(req));
		}
		if (BordersElementTypes.CustomBorder_2002 == req.getElementType()) {
			return getGEFWrapper(new CustomBorderCreateCommand(req));
		}
		if (BordersElementTypes.CompoundBorder_2003 == req.getElementType()) {
			return getGEFWrapper(new CompoundBorderCreateCommand(req));
		}
		if (BordersElementTypes.LineBorder_2004 == req.getElementType()) {
			return getGEFWrapper(new LineBorderCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
