/*
 *  Copyright (c) 2006, 2007 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.FigureHandle;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.graphdef.editor.edit.commands.DiagramElementFigureReorientCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.EllipseCreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.PolylineCreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.Rectangle2CreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.RoundedRectangleCreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.parts.DiagramElementFigureEditPart;
import org.eclipse.gmf.graphdef.editor.providers.GMFGraphElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * @generated
 */
public class RoundedRectangle2ItemSemanticEditPolicy extends GMFGraphBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (GMFGraphElementTypes.Rectangle_3002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigure_Children());
			}
			return getMSLWrapper(new Rectangle2CreateCommand(req));
		}
		if (GMFGraphElementTypes.Ellipse_3003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigure_Children());
			}
			return getMSLWrapper(new EllipseCreateCommand(req));
		}
		if (GMFGraphElementTypes.RoundedRectangle_3004 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigure_Children());
			}
			return getMSLWrapper(new RoundedRectangleCreateCommand(req));
		}
		if (GMFGraphElementTypes.Polyline_3005 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigure_Children());
			}
			return getMSLWrapper(new PolylineCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand(req.isConfirmationRequired());
		cc.add(getMSLWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (GMFGraphElementTypes.DiagramElementFigure_4001 == req.getElementType()) {
			return req.getTarget() == null ? null : getCreateCompleteIncomingDiagramElementFigure_4001Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingDiagramElementFigure_4001Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof DiagramElement || false == targetEObject instanceof FigureHandle) {
			return UnexecutableCommand.INSTANCE;
		}
		DiagramElement source = (DiagramElement) sourceEObject;
		FigureHandle target = (FigureHandle) targetEObject;
		if (!GMFGraphBaseItemSemanticEditPolicy.LinkConstraints.canCreateDiagramElementFigure_4001(source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(sourceEObject, GMFGraphPackage.eINSTANCE.getDiagramElement_Figure(), target);
		return getMSLWrapper(new SetValueCommand(setReq));
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case DiagramElementFigureEditPart.VISUAL_ID:
			return getMSLWrapper(new DiagramElementFigureReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}
}
