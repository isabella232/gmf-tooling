package org.eclipse.gmf.tooling.examples.linklf.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.commands.Circle2CreateCommand;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.commands.Container2CreateCommand;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.commands.Rectangle2CreateCommand;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.commands.Rhombus2CreateCommand;
import org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfElementTypes;

/**
 * @generated
 */
public class ContainerContainerCompartment2ItemSemanticEditPolicy extends LinklfBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ContainerContainerCompartment2ItemSemanticEditPolicy() {
		super(LinklfElementTypes.Container_3002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (LinklfElementTypes.Circle_3001 == req.getElementType()) {
			return getGEFWrapper(new Circle2CreateCommand(req));
		}
		if (LinklfElementTypes.Container_3002 == req.getElementType()) {
			return getGEFWrapper(new Container2CreateCommand(req));
		}
		if (LinklfElementTypes.Rectangle_3003 == req.getElementType()) {
			return getGEFWrapper(new Rectangle2CreateCommand(req));
		}
		if (LinklfElementTypes.Rhombus_3004 == req.getElementType()) {
			return getGEFWrapper(new Rhombus2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
