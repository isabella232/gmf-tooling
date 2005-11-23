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

import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * @generated
 */
public class ShipNodeItemSemanticEditPolicy extends TaiPanItemSemanticEditPolicy {

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
			return req.getTarget() == null ? getCreateStartOutgoingShip_Destination3001Command(req)
					: getCreateCompleteOutgoingShip_Destination3001Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingShip_Destination3001Command(CreateRelationshipRequest req) {
		Ship element = (Ship) getSemanticElement();
		if (element.getDestination() != null) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteOutgoingShip_Destination3001Command(CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof Port)) {
			return UnexecutableCommand.INSTANCE;
		}
		Ship element = (Ship) getSemanticElement();
		if (element.getDestination() != null) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(req.getTarget(), TaiPanPackage.eINSTANCE.getShip_Destination(), req.getSource());
		return getMSLWrapper(new SetValueCommand(setReq));
	}
}
