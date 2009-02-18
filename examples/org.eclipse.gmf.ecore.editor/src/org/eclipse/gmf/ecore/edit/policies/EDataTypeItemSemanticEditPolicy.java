/*
 * Copyright (c) 2006, 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.ecore.edit.commands.EAnnotationReferencesCreateCommand;
import org.eclipse.gmf.ecore.edit.commands.EAnnotationReferencesReorientCommand;
import org.eclipse.gmf.ecore.edit.commands.EReference2CreateCommand;
import org.eclipse.gmf.ecore.edit.commands.EReference2ReorientCommand;
import org.eclipse.gmf.ecore.edit.commands.EReferenceCreateCommand;
import org.eclipse.gmf.ecore.edit.commands.EReferenceReorientCommand;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeDataTypeAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.ecore.providers.EcoreElementTypes;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EDataTypeItemSemanticEditPolicy extends EcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EDataTypeItemSemanticEditPolicy() {
		super(EcoreElementTypes.EDataType_2004);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(getEditingDomain(), null);
		cc.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (EcoreVisualIDRegistry.getVisualID(incomingLink) == EAnnotationReferencesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cc.add(new DestroyReferenceCommand(r));
				cc.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (EcoreVisualIDRegistry.getVisualID(incomingLink) == EReferenceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cc.add(new DestroyElementCommand(r));
				cc.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (EcoreVisualIDRegistry.getVisualID(incomingLink) == EReference2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cc.add(new DestroyElementCommand(r));
				cc.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cc);
			addDestroyShortcutsCommand(cc, view);
			// delete host element
			cc.add(new DestroyElementCommand(req));
		} else {
			cc.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cc.reduce());
	}

	/**
	 * @generated
	 */
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (EcoreVisualIDRegistry.getVisualID(node)) {
			case EDataTypeDataTypeAnnotationsEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (EcoreVisualIDRegistry.getVisualID(cnode)) {
					case EAnnotation2EditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			}
		}
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
		if (EcoreElementTypes.EAnnotationReferences_4001 == req.getElementType()) {
			return null;
		}
		if (EcoreElementTypes.EReference_4002 == req.getElementType()) {
			return null;
		}
		if (EcoreElementTypes.EReference_4003 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (EcoreElementTypes.EAnnotationReferences_4001 == req.getElementType()) {
			return getGEFWrapper(new EAnnotationReferencesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (EcoreElementTypes.EReference_4002 == req.getElementType()) {
			return getGEFWrapper(new EReferenceCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (EcoreElementTypes.EReference_4003 == req.getElementType()) {
			return getGEFWrapper(new EReference2CreateCommand(req, req.getSource(), req.getTarget()));
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
		case EReferenceEditPart.VISUAL_ID:
			return getGEFWrapper(new EReferenceReorientCommand(req));
		case EReference2EditPart.VISUAL_ID:
			return getGEFWrapper(new EReference2ReorientCommand(req));
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
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return getGEFWrapper(new EAnnotationReferencesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
