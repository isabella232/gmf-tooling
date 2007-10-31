/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */

package org.eclipse.gmf.examples.mindmap.rcp.edit.commands;

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
import org.eclipse.gmf.examples.mindmap.rcp.view.factories.DomainElementInitializer;
import org.eclipse.gmf.runtime.lite.commands.ReconnectNotationalEdgeTargetCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ReconnectTopic_Subtopics4001TargetCommand extends CommandWrapper {
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
	public ReconnectTopic_Subtopics4001TargetCommand(ReconnectRequest request) {
		this((Edge) request.getConnectionEditPart().getModel(), (View) request
				.getTarget().getModel());
	}

	/**
	 * @generated
	 */
	public ReconnectTopic_Subtopics4001TargetCommand(Edge edge, View newTarget) {
		this.edge = edge;
		this.newTarget = newTarget;
		this.oldTarget = edge.getTarget();
	}

	/**
	 * @generated
	 */
	protected boolean prepare() {
		final boolean[] resultHolder = new boolean[1];
		//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion.
		final TransactionalEditingDomain domainModelEditDomain = TransactionUtil
				.getEditingDomain(oldTarget.getDiagram().getElement());
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
		if (!DomainElementInitializer.LinkConstraints
				.canExistTopicSubtopics_4001(edge.getSource().getElement(),
						newTarget.getElement())) {
			return false;
		}
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
		result.append(RemoveCommand.create(editingDomain, edge.getSource()
				.getElement(), MindmapPackage.eINSTANCE.getTopic_Subtopics(),
				oldTarget.getElement()));
		result.append(AddCommand.create(editingDomain, edge.getSource()
				.getElement(), MindmapPackage.eINSTANCE.getTopic_Subtopics(),
				newTarget.getElement()));
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
