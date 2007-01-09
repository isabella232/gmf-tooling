/*
 *
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Richard Gronback (Borland) - initial API and implementation
 
 */
package org.eclipse.gmf.examples.mindmap.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Topic;

import org.eclipse.gmf.examples.mindmap.diagram.edit.commands.Relationship2TypeLinkCreateCommand;
import org.eclipse.gmf.examples.mindmap.diagram.edit.commands.Relationship3TypeLinkCreateCommand;
import org.eclipse.gmf.examples.mindmap.diagram.edit.commands.RelationshipTypeLinkCreateCommand;

import org.eclipse.gmf.examples.mindmap.diagram.providers.MindmapElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * @generated
 */
public class TopicItemSemanticEditPolicy extends MindmapBaseItemSemanticEditPolicy {

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
		if (MindmapElementTypes.TopicSubtopics_3001 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingTopic_Subtopics3001Command(req) : getCreateCompleteIncomingTopic_Subtopics3001Command(req);
		}
		if (MindmapElementTypes.Relationship_3002 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRelationship3002Command(req) : getCreateCompleteIncomingRelationship3002Command(req);
		}
		if (MindmapElementTypes.Relationship_3003 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRelationship3003Command(req) : getCreateCompleteIncomingRelationship3003Command(req);
		}
		if (MindmapElementTypes.Relationship_3004 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRelationship3004Command(req) : getCreateCompleteIncomingRelationship3004Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingTopic_Subtopics3001Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic || (targetEObject != null && false == targetEObject instanceof Topic)) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints.canCreateTopicSubtopics_3001(source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingTopic_Subtopics3001Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic || false == targetEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints.canCreateTopicSubtopics_3001(source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(req.getSource(), MindmapPackage.eINSTANCE.getTopic_Subtopics(), req.getTarget());
		return getMSLWrapper(new SetValueCommand(setReq));
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRelationship3002Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic || (targetEObject != null && false == targetEObject instanceof Topic)) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;

		Map container = (Map) getRelationshipContainer(source, MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints.canCreateRelationship_3002(container, source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRelationship3002Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic || false == targetEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;

		Map container = (Map) getRelationshipContainer(source, MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints.canCreateRelationship_3002(container, source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(MindmapPackage.eINSTANCE.getMap_Relations());
		}
		return getMSLWrapper(new RelationshipTypeLinkCreateCommand(req, container, source, target));
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRelationship3003Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic || (targetEObject != null && false == targetEObject instanceof Topic)) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;

		Map container = (Map) getRelationshipContainer(source, MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints.canCreateRelationship_3003(container, source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRelationship3003Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic || false == targetEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;

		Map container = (Map) getRelationshipContainer(source, MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints.canCreateRelationship_3003(container, source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(MindmapPackage.eINSTANCE.getMap_Relations());
		}
		return getMSLWrapper(new Relationship2TypeLinkCreateCommand(req, container, source, target));
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRelationship3004Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic || (targetEObject != null && false == targetEObject instanceof Topic)) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;

		Map container = (Map) getRelationshipContainer(source, MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints.canCreateRelationship_3004(container, source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRelationship3004Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic || false == targetEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;

		Map container = (Map) getRelationshipContainer(source, MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints.canCreateRelationship_3004(container, source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(MindmapPackage.eINSTANCE.getMap_Relations());
		}
		return getMSLWrapper(new Relationship3TypeLinkCreateCommand(req, container, source, target));
	}
}
