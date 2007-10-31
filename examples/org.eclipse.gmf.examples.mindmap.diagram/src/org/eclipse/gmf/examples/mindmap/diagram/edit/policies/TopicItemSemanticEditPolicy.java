/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.mindmap.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.examples.mindmap.diagram.edit.commands.Relationship2CreateCommand;
import org.eclipse.gmf.examples.mindmap.diagram.edit.commands.Relationship2ReorientCommand;
import org.eclipse.gmf.examples.mindmap.diagram.edit.commands.Relationship3CreateCommand;
import org.eclipse.gmf.examples.mindmap.diagram.edit.commands.Relationship3ReorientCommand;
import org.eclipse.gmf.examples.mindmap.diagram.edit.commands.RelationshipCreateCommand;
import org.eclipse.gmf.examples.mindmap.diagram.edit.commands.RelationshipReorientCommand;
import org.eclipse.gmf.examples.mindmap.diagram.edit.commands.TopicSubtopicsCreateCommand;
import org.eclipse.gmf.examples.mindmap.diagram.edit.commands.TopicSubtopicsReorientCommand;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicSubtopicsEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicThreadCompartmentEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.examples.mindmap.diagram.providers.MindmapElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TopicItemSemanticEditPolicy extends
		MindmapBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
		addDestroyShortcutsCommand(cc);
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
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (MindmapVisualIDRegistry.getVisualID(node)) {
			case TopicThreadCompartmentEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (MindmapVisualIDRegistry.getVisualID(cnode)) {
					case ThreadEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
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
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (MindmapElementTypes.TopicSubtopics_4001 == req.getElementType()) {
			return getGEFWrapper(new TopicSubtopicsCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (MindmapElementTypes.Relationship_4002 == req.getElementType()) {
			return getGEFWrapper(new RelationshipCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (MindmapElementTypes.Relationship_4003 == req.getElementType()) {
			return getGEFWrapper(new Relationship2CreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (MindmapElementTypes.Relationship_4004 == req.getElementType()) {
			return getGEFWrapper(new Relationship3CreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (MindmapElementTypes.TopicSubtopics_4001 == req.getElementType()) {
			return getGEFWrapper(new TopicSubtopicsCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (MindmapElementTypes.Relationship_4002 == req.getElementType()) {
			return getGEFWrapper(new RelationshipCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (MindmapElementTypes.Relationship_4003 == req.getElementType()) {
			return getGEFWrapper(new Relationship2CreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (MindmapElementTypes.Relationship_4004 == req.getElementType()) {
			return getGEFWrapper(new Relationship3CreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case RelationshipEditPart.VISUAL_ID:
			return getGEFWrapper(new RelationshipReorientCommand(req));
		case Relationship2EditPart.VISUAL_ID:
			return getGEFWrapper(new Relationship2ReorientCommand(req));
		case Relationship3EditPart.VISUAL_ID:
			return getGEFWrapper(new Relationship3ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case TopicSubtopicsEditPart.VISUAL_ID:
			return getGEFWrapper(new TopicSubtopicsReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
