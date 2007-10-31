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

import java.util.Collection;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.rcp.view.factories.TopicViewFactory;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class CloneTopic2001Command extends CommandWrapper {
	/**
	 * @generated
	 */
	private final View parentView;
	/**
	 * @generated
	 */
	private final Node childNode;
	/**
	 * @generated
	 */
	private final Rectangle constraint;
	/**
	 * @generated
	 */
	private final TransactionalEditingDomain editingDomain;
	/**
	 * @generated
	 */
	private Command afterCopyCommand;

	/**
	 * @generated
	 */
	public CloneTopic2001Command(View parentView, Node childNode,
			Rectangle constraint) {
		this.parentView = parentView;
		this.childNode = childNode;
		this.constraint = constraint;
		this.editingDomain = TransactionUtil.getEditingDomain(childNode
				.getDiagram().getElement());
	}

	/**
	 * @generated
	 */
	protected Command createCommand() {
		EObject element = childNode.getElement();
		//We are being optimistic here about whether further commands can be executed.
		//Otherwise, we would have to execute the CopyCommand on every mouse move, which could be much too expensive.
		return CopyCommand.create(editingDomain, element);
	}

	/**
	 * @generated
	 */
	private Command createAfterCopyCommand() {
		final Collection copyResults = super.getResult();
		assert copyResults.size() == 1;
		EObject copyResult = (EObject) copyResults.iterator().next();
		CompoundCommand result = new CompoundCommand();
		result.append(AddCommand.create(editingDomain, parentView.getElement(),
				MindmapPackage.eINSTANCE.getMap_RootTopics(), copyResult));
		if (constraint != null) {
			constraint.union(new Dimension(40, 40));
		}
		result.append(new CreateNotationalNodeCommand(parentView, copyResult,
				constraint, TopicViewFactory.INSTANCE));
		return result;
	}

	/**
	 * @generated
	 */
	public void execute() {
		super.execute();
		afterCopyCommand = createAfterCopyCommand();
		if (afterCopyCommand.canExecute()) {
			afterCopyCommand.execute();
		} else {
			assert false;
		}
	}

	/**
	 * @generated
	 */
	public boolean canUndo() {
		return super.canUndo() && afterCopyCommand != null
				&& afterCopyCommand.canUndo();
	}

	/**
	 * @generated
	 */
	public void undo() {
		afterCopyCommand.undo();
		super.undo();
	}

	/**
	 * @generated
	 */
	public void redo() {
		super.redo();
		afterCopyCommand.redo();
	}

	/**
	 * @generated
	 */
	public void dispose() {
		super.dispose();
		if (afterCopyCommand != null) {
			afterCopyCommand.dispose();
		}
	}
}
