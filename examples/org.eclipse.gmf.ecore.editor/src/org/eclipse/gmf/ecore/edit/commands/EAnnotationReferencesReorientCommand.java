/*
 *  Copyright (c) 2006, 2007 Borland Software Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.edit.commands;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class EAnnotationReferencesReorientCommand extends EditElementCommand {

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
	public EAnnotationReferencesReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (!(referenceOwner instanceof EAnnotation)) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return newEnd instanceof EAnnotation;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return newEnd instanceof EObject;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (false == referenceOwner instanceof EAnnotation) {
			return CommandResult.newErrorCommandResult("Incorrect link source: " + referenceOwner);
		}
		EAnnotation source = (EAnnotation) referenceOwner;
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			if (false == newEnd instanceof EAnnotation) {
				return CommandResult.newErrorCommandResult("Incorrect new link source: " + newEnd);
			}
			EAnnotation newSource = (EAnnotation) newEnd;

			Collection values = source.getReferences();
			source.getReferences().clear();
			newSource.getReferences().addAll(values);
			return CommandResult.newOKCommandResult(referenceOwner);
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			if (false == newEnd instanceof EObject) {
				return CommandResult.newErrorCommandResult("Incorrect new link target: " + newEnd);
			}
			EObject newTarget = (EObject) newEnd;

			source.getReferences().clear();
			source.getReferences().add(newTarget);
			return CommandResult.newOKCommandResult(referenceOwner);
		}
		return CommandResult.newErrorCommandResult("Unknown link reorient direction: " + reorientDirection);
	}
}
