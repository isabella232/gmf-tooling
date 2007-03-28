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
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public EscortShipsOrderReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (!(getElementToEdit() instanceof EscortShipsOrder)) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return newEnd instanceof Warship;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return newEnd instanceof Ship;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (false == getElementToEdit() instanceof EscortShipsOrder) {
			return CommandResult.newErrorCommandResult("Incorrect link element: " + getElementToEdit());
		}

		EscortShipsOrder link = (EscortShipsOrder) getElementToEdit();
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			if (false == newEnd instanceof Warship) {
				return CommandResult.newErrorCommandResult("Incorrect new link source: " + newEnd);
			}
			Warship newSource = (Warship) newEnd;
			if (false == getElementToEdit().eContainer() instanceof Warship) {
				return CommandResult.newErrorCommandResult("Incorrect link source: " + getElementToEdit().eContainer());
			}
			Warship source = (Warship) getElementToEdit().eContainer();

			source.setEscortOrder(null);
			newSource.setEscortOrder(link);
			return CommandResult.newOKCommandResult(link);
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			if (false == newEnd instanceof Ship) {
				return CommandResult.newErrorCommandResult("Incorrect new link target: " + newEnd);
			}
			Ship newTarget = (Ship) newEnd;

			link.getShips().clear();
			link.getShips().add(newTarget);
			return CommandResult.newOKCommandResult(link);
		}
		return CommandResult.newErrorCommandResult("Unknown link reorient direction: " + reorientDirection);
	}
}
