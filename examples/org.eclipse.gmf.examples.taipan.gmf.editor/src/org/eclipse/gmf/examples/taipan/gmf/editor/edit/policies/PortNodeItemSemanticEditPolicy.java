/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.commands.core.commands.MSLDestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * @generated
 */
public class PortNodeItemSemanticEditPolicy extends TaiPanItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getMSLWrapper(new MSLDestroyElementCommand(req));
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (TaiPanElementTypes.ShipDestination_3001 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartIncomingShip_Destination3001Command(req)
					: getCreateCompleteIncomingShip_Destination3001Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartIncomingShip_Destination3001Command(CreateRelationshipRequest req) {
		return new Command() {};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingShip_Destination3001Command(CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof Ship)) {
			return UnexecutableCommand.INSTANCE;
		}
		Ship element = (Ship) req.getSource();
		if (element.getDestination() != null) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(req.getSource(), TaiPanPackage.eINSTANCE.getShip_Destination(), req.getTarget());
		return getMSLWrapper(new SetValueCommand(setReq));
	}
}
