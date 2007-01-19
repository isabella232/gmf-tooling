package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;

import org.eclipse.emf.edit.command.SetCommand;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gef.requests.ReconnectRequest;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.runtime.lite.commands.ReconnectNotationalEdgeTargetCommand;

import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ReconnectRelationship4002TargetCommand extends CommandWrapper {
	/**
	 * @generated
	 */
	private Edge edge;
	/**
	 * @generated
	 */
	private View newTarget;
	/**
	 * @generated
	 */
	private View oldTarget;

	/**
	 * @generated
	 */
	public ReconnectRelationship4002TargetCommand(ReconnectRequest request) {
		this((Edge) request.getConnectionEditPart().getModel(), (View) request
				.getTarget().getModel());
	}

	/**
	 * @generated
	 */
	public ReconnectRelationship4002TargetCommand(Edge edge, View newTarget) {
		this.edge = edge;
		this.newTarget = newTarget;
		this.oldTarget = edge.getTarget();
	}

	/**
	 * @generated
	 */
	protected boolean prepare() {
		if (!canReconnect()) {
			return false;
		}
		return super.prepare();
	}

	/**
	 * @generated
	 */
	private boolean canReconnect() {

		return true;
	}

	/**
	 * @generated
	 */
	protected Command createCommand() {
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(oldTarget.getDiagram().getElement());
		CompoundCommand result = new CompoundCommand();
		result
				.append(new ReconnectNotationalEdgeTargetCommand(edge,
						newTarget));
		result.append(SetCommand.create(editingDomain, edge.getElement(),
				MindmapPackage.eINSTANCE.getRelationship_Target(), newTarget
						.getElement()));
		return result;
	}

}
