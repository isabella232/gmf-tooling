package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;

import org.eclipse.emf.edit.command.AddCommand;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gmf.examples.mindmap.MindmapFactory;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.ThreadItem;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.DomainElementInitializer;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.ThreadItemViewFactory;

import org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand;

import org.eclipse.gmf.runtime.lite.requests.CreateRequestEx;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class CreateThreadItem3002Command extends AbstractCommand {
	/**
	 * @generated
	 */
	private final CreateNotationalNodeCommand notationAddCommand;

	/**
	 * @generated
	 */
	private final Command domainModelAddCommand;

	/**
	 * @generated
	 */
	public CreateThreadItem3002Command(View parent, CreateRequestEx request) {
		this(parent, request, null);
	}

	/**
	 * @generated
	 */
	public CreateThreadItem3002Command(View parent, CreateRequestEx request,
			Rectangle constraint) {
		TransactionalEditingDomain domainModelEditDomain = TransactionUtil
				.getEditingDomain(parent.getDiagram().getElement());
		ThreadItem createdDomainElement = MindmapFactory.eINSTANCE
				.createThreadItem();

		DomainElementInitializer.ThreadItem_3002
				.initializeElement(createdDomainElement);

		this.domainModelAddCommand = AddCommand.create(domainModelEditDomain,
				parent.getElement(),
				MindmapPackage.eINSTANCE.getThread_Items(),
				createdDomainElement);
		if (constraint != null) {
			constraint = constraint.union(new Dimension(40, 40));
		}
		this.notationAddCommand = new CreateNotationalNodeCommand(parent,
				createdDomainElement, constraint,
				ThreadItemViewFactory.INSTANCE);
		request.setCreatedObject(notationAddCommand.getCreatedView());
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		return domainModelAddCommand != null
				&& domainModelAddCommand.canExecute()
				&& notationAddCommand != null
				&& notationAddCommand.canExecute();
	}

	/**
	 * @generated
	 */
	public boolean canUndo() {
		return domainModelAddCommand != null && domainModelAddCommand.canUndo()
				&& notationAddCommand != null && notationAddCommand.canUndo();
	}

	/**
	 * @generated
	 */
	public void execute() {
		domainModelAddCommand.execute();
		notationAddCommand.execute();
	}

	/**
	 * @generated
	 */
	public void undo() {
		notationAddCommand.undo();
		domainModelAddCommand.undo();
	}

	/**
	 * @generated
	 */
	public void redo() {
		execute();
	}
}
