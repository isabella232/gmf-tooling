package org.eclipse.gmf.examples.mindmap.lite.rcp.edit.policies;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.lite.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.lite.commands.RemoveNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ThreadItemComponentEditPolicy extends ComponentEditPolicy {
	/**
	 * @generated
	 */
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(getDiagramNode().getDiagram().getElement());
		CompoundCommand cc = new CompoundCommand();
		cc.append(createDomainModelRemoveCommand(editingDomain));
		cc.append(new RemoveNotationalElementCommand((View) getDiagramNode()
				.eContainer(), getDiagramNode()));
		return new WrappingCommand(editingDomain, cc);
	}

	/**
	 * @generated
	 */
	private org.eclipse.emf.common.command.Command createDomainModelRemoveCommand(
			TransactionalEditingDomain editingDomain) {
		return DestroyElementCommand.create(editingDomain, getDiagramNode()
				.getElement());
	}

	/**
	 * @generated
	 */
	protected Node getDiagramNode() {
		return (Node) getHost().getModel();
	}
}
