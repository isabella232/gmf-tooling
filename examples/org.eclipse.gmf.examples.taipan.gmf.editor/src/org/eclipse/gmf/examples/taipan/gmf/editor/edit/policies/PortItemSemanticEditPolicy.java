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
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.BesiegePortOrderCreateCommand;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.BesiegePortOrderReorientCommand;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.PortRegisterCreateCommand;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.PortRegisterReorientCommand;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.ReliableRouteCreateCommand;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.ReliableRouteReorientCommand;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.ShipDestinationCreateCommand;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.ShipDestinationReorientCommand;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.UnreliableRouteCreateCommand;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.UnreliableRouteReorientCommand;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.BesiegePortOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortRegisterEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ReliableRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipDestinationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.UnreliableRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PortItemSemanticEditPolicy extends TaiPanBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (TaiPanElementTypes.ShipDestination_4001 == req.getElementType()) {
			return null;
		}
		if (TaiPanElementTypes.Route_4002 == req.getElementType()) {
			return getGEFWrapper(new ReliableRouteCreateCommand(req));
		}
		if (TaiPanElementTypes.Route_4003 == req.getElementType()) {
			return getGEFWrapper(new UnreliableRouteCreateCommand(req));
		}
		if (TaiPanElementTypes.BesiegePortOrder_4005 == req.getElementType()) {
			req = new CreateRelationshipRequest(req.getEditingDomain(), req.getContainer(), req.getTarget(), req.getSource(), req.getElementType(), req.getContainmentFeature());
			return getGEFWrapper(new BesiegePortOrderCreateCommand(req));
		}
		if (TaiPanElementTypes.PortRegister_4007 == req.getElementType()) {
			return getGEFWrapper(new PortRegisterCreateCommand(req));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (TaiPanElementTypes.ShipDestination_4001 == req.getElementType()) {
			return getGEFWrapper(new ShipDestinationCreateCommand(req));
		}
		if (TaiPanElementTypes.Route_4002 == req.getElementType()) {
			return getGEFWrapper(new ReliableRouteCreateCommand(req));
		}
		if (TaiPanElementTypes.Route_4003 == req.getElementType()) {
			return getGEFWrapper(new UnreliableRouteCreateCommand(req));
		}
		if (TaiPanElementTypes.BesiegePortOrder_4005 == req.getElementType()) {
			return getGEFWrapper(new BesiegePortOrderCreateCommand(req));
		}
		if (TaiPanElementTypes.PortRegister_4007 == req.getElementType()) {
			req = new CreateRelationshipRequest(req.getEditingDomain(), req.getContainer(), req.getTarget(), req.getSource(), req.getElementType(), req.getContainmentFeature());
			return getGEFWrapper(new PortRegisterCreateCommand(req));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ReliableRouteEditPart.VISUAL_ID:
			return getGEFWrapper(new ReliableRouteReorientCommand(req));
		case UnreliableRouteEditPart.VISUAL_ID:
			return getGEFWrapper(new UnreliableRouteReorientCommand(req));
		case BesiegePortOrderEditPart.VISUAL_ID:
			return getGEFWrapper(new BesiegePortOrderReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ShipDestinationEditPart.VISUAL_ID:
			return getGEFWrapper(new ShipDestinationReorientCommand(req));
		case PortRegisterEditPart.VISUAL_ID:
			return getGEFWrapper(new PortRegisterReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
