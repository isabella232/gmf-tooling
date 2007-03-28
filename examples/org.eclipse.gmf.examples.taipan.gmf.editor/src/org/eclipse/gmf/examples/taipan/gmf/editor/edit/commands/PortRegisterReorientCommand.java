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

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class PortRegisterReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject referenceOwner;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public PortRegisterReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (!(referenceOwner instanceof Port)) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return newEnd instanceof Port;
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
		if (false == referenceOwner instanceof Port) {
			return CommandResult.newErrorCommandResult("Incorrect link source: " + referenceOwner);
		}
		Port source = (Port) referenceOwner;
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			if (false == newEnd instanceof Port) {
				return CommandResult.newErrorCommandResult("Incorrect new link source: " + newEnd);
			}
			Port newSource = (Port) newEnd;

			Collection values = source.getRegister();
			source.getRegister().clear();
			newSource.getRegister().addAll(values);
			return CommandResult.newOKCommandResult(referenceOwner);
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			if (false == newEnd instanceof Ship) {
				return CommandResult.newErrorCommandResult("Incorrect new link target: " + newEnd);
			}
			Ship newTarget = (Ship) newEnd;

			source.getRegister().clear();
			source.getRegister().add(newTarget);
			return CommandResult.newOKCommandResult(referenceOwner);
		}
		return CommandResult.newErrorCommandResult("Unknown link reorient direction: " + reorientDirection);
	}
}
