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

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.runtime.lite.commands.ExpandDrawerCommand;
import org.eclipse.gmf.runtime.lite.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AddThreadItem3002Command extends CommandWrapper {
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
	private final int newVisualID;
	/**
	 * @generated
	 */
	private final Rectangle constraint;

	/**
	 * @generated
	 */
	public AddThreadItem3002Command(View parentView, Node childNode,
			int newVisualID, Rectangle constraint) {
		this.parentView = parentView;
		this.childNode = childNode;
		this.newVisualID = newVisualID;
		this.constraint = constraint;
	}

	/**
	 * @generated
	 */
	protected Command createCommand() {
		CompoundCommand result = new CompoundCommand();
		EObject element = childNode.getElement();
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(parentView.getDiagram().getElement());
		result.append(RemoveCommand.create(editingDomain, element.eContainer(),
				MindmapPackage.eINSTANCE.getThread_Items(), element));
		result.append(AddCommand.create(editingDomain, parentView.getElement(),
				MindmapPackage.eINSTANCE.getThread_Items(), element));
		result.append(RemoveCommand.create(editingDomain, childNode
				.eContainer(), childNode.eContainmentFeature(), childNode));
		result.append(new ExpandDrawerCommand(parentView));
		result.append(AddCommand.create(editingDomain, parentView,
				NotationPackage.eINSTANCE.getView_PersistedChildren(),
				childNode));
		result.append(new SetBoundsCommand(childNode, constraint));
		return result;
	}
}
