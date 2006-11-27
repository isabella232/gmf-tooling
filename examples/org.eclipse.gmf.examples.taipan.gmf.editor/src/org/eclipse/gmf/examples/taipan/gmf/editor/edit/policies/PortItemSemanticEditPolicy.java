/*
 * Copyright (c) 2006 Borland Software Corporation
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

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.RouteTypeLinkCreateCommand;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PortItemSemanticEditPolicy extends TaiPanBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getMSLWrapper(new DestroyElementCommand(req) {

			protected EObject getElementToDestroy() {
				View view = (View) getHost().getModel();
				EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
				if (annotation != null) {
					return view;
				}
				return super.getElementToDestroy();
			}

		});
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (TaiPanElementTypes.ShipDestination_4001 == req.getElementType()) {
			return req.getTarget() == null ? null : getCreateCompleteIncomingShip_Destination4001Command(req);
		}
		if (TaiPanElementTypes.Route_4002 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRoute4002Command(req) : getCreateCompleteIncomingRoute4002Command(req);
		}
		if (TaiPanElementTypes.Route_4003 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRoute4003Command(req) : getCreateCompleteIncomingRoute4003Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingShip_Destination4001Command(CreateRelationshipRequest req) {
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

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRoute4002Command(CreateRelationshipRequest req) {
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRoute4002Command(CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof Port)) {
			return UnexecutableCommand.INSTANCE;
		}
		final Aquatory element = (Aquatory) getRelationshipContainer(req.getSource(), TaiPanPackage.eINSTANCE.getAquatory(), req.getElementType());
		if (element == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(TaiPanPackage.eINSTANCE.getAquatory_Routes());
		}
		return getMSLWrapper(new RouteTypeLinkCreateCommand(req, element, (Port) req.getSource(), (Port) req.getTarget()));
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRoute4003Command(CreateRelationshipRequest req) {
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRoute4003Command(CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof Port)) {
			return UnexecutableCommand.INSTANCE;
		}
		final Aquatory element = (Aquatory) getRelationshipContainer(req.getSource(), TaiPanPackage.eINSTANCE.getAquatory(), req.getElementType());
		if (element == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(TaiPanPackage.eINSTANCE.getAquatory_Routes());
		}
		return getMSLWrapper(new RouteTypeLinkCreateCommand(req, element, (Port) req.getSource(), (Port) req.getTarget()));
	}
}
