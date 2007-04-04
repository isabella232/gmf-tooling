/*
 *  Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.EscortShipsOrder;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.Warship;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.TaiPanBaseItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class EscortShipsOrderReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public EscortShipsOrderReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (!(getElementToEdit() instanceof EscortShipsOrder)) {
			return false;
		}
		EscortShipsOrder link = (EscortShipsOrder) getElementToEdit();
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			if (!(oldEnd instanceof Warship && newEnd instanceof Warship)) {
				return false;
			}
			Warship source = (Warship) newEnd;
			if (link.getShips().size() != 1) {
				return false;
			}
			Ship target = (Ship) link.getShips().get(0);
			return TaiPanBaseItemSemanticEditPolicy.LinkConstraints.canExistEscortShipsOrder_4006(source, target);
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			if (!(oldEnd instanceof Ship && newEnd instanceof Ship)) {
				return false;
			}
			if (!(link.eContainer() instanceof Warship)) {
				return false;
			}
			Warship source = (Warship) link.eContainer();
			Ship target = (Ship) newEnd;
			return TaiPanBaseItemSemanticEditPolicy.LinkConstraints.canExistEscortShipsOrder_4006(source, target);
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	private CommandResult reorientSource() throws ExecutionException {
		EscortShipsOrder link = (EscortShipsOrder) getElementToEdit();
		Warship oldSource = (Warship) oldEnd;
		Warship newSource = (Warship) newEnd;

		oldSource.setEscortOrder(null);
		newSource.setEscortOrder(link);
		return CommandResult.newOKCommandResult(link);
	}

	/**
	 * @generated
	 */
	private CommandResult reorientTarget() throws ExecutionException {
		EscortShipsOrder link = (EscortShipsOrder) getElementToEdit();
		Ship oldTarget = (Ship) oldEnd;
		Ship newTarget = (Ship) newEnd;

		link.getShips().remove(oldTarget);
		link.getShips().add(newTarget);
		return CommandResult.newOKCommandResult(link);
	}
}
