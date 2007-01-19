package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gef.requests.ReconnectRequest;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.DomainElementInitializer;

import org.eclipse.gmf.runtime.lite.commands.ReconnectNotationalEdgeSourceCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;

import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ReconnectTopic_Subtopics4001SourceCommand extends CommandWrapper {
	/**
	 * @generated
	 */
	private Edge edge;
	/**
	 * @generated
	 */
	private View newSource;
	/**
	 * @generated
	 */
	private View oldSource;

	/**
	 * @generated
	 */
	public ReconnectTopic_Subtopics4001SourceCommand(ReconnectRequest request) {
		this((Edge) request.getConnectionEditPart().getModel(), (View) request
				.getTarget().getModel());
	}

	/**
	 * @generated
	 */
	public ReconnectTopic_Subtopics4001SourceCommand(Edge edge, View newSource) {
		this.edge = edge;
		this.newSource = newSource;
		this.oldSource = edge.getSource();
	}

	/**
	 * @generated
	 */
	protected boolean prepare() {
		final boolean[] resultHolder = new boolean[1];
		//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion.
		final TransactionalEditingDomain domainModelEditDomain = TransactionUtil
				.getEditingDomain(oldSource.getDiagram().getElement());
		Command command = new AbstractCommand() {
			private Command deleteCommand = createDomainModelRemoveCommand(domainModelEditDomain);

			public boolean canExecute() {
				return deleteCommand.canExecute();
			}

			public boolean canUndo() {
				return true;
			}

			public void redo() {
			}

			public void undo() {
			}

			public void execute() {
				deleteCommand.execute();
				try {
					resultHolder[0] = canReconnect();
				} finally {
					deleteCommand.undo();
				}
			}
		};
		if (!command.canExecute()) {
			return false;
		}
		new WrappingCommand(domainModelEditDomain, command).execute();
		if (!resultHolder[0]) {
			return false;
		}
		return super.prepare();
	}

	/**
	 * @generated
	 */
	private boolean canReconnect() {

		if (!DomainElementInitializer.LinkConstraints.TopicSubtopics_4001
				.canCreateLink(newSource.getElement(), edge.getTarget()
						.getElement(), false)) {
			return false;
		}
		return true;
	}

	/**
	 * @generated
	 */
	protected Command createCommand() {
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(oldSource.getDiagram().getElement());
		CompoundCommand result = new CompoundCommand();
		result
				.append(new ReconnectNotationalEdgeSourceCommand(edge,
						newSource));
		result.append(RemoveCommand.create(editingDomain, oldSource
				.getElement(), MindmapPackage.eINSTANCE.getTopic_Subtopics(),
				edge.getTarget().getElement()));
		result.append(AddCommand.create(editingDomain, newSource.getElement(),
				MindmapPackage.eINSTANCE.getTopic_Subtopics(), edge.getTarget()
						.getElement()));
		return result;
	}

	/**
	 * @generated
	 */

	private Command createDomainModelRemoveCommand(
			TransactionalEditingDomain editingDomain) {
		return RemoveCommand.create(editingDomain, edge.getSource()
				.getElement(), MindmapPackage.eINSTANCE.getTopic_Subtopics(),
				edge.getTarget().getElement());
	}
}
