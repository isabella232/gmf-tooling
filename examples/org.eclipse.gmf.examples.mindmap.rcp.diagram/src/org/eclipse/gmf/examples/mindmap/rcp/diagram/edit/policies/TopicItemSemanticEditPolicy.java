package org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.policies;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Topic;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.commands.Relationship2TypeLinkCreateCommand;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.commands.Relationship3TypeLinkCreateCommand;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.commands.RelationshipTypeLinkCreateCommand;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.providers.MindmapElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
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
		if (MindmapElementTypes.TopicSubtopics_4001 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingTopicSubtopics_4001Command(req)
					: getCreateCompleteIncomingTopicSubtopics_4001Command(req);
		}
		if (MindmapElementTypes.Relationship_4002 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRelationship_4002Command(req)
					: getCreateCompleteIncomingRelationship_4002Command(req);
		}
		if (MindmapElementTypes.Relationship_4003 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRelationship_4003Command(req)
					: getCreateCompleteIncomingRelationship_4003Command(req);
		}
		if (MindmapElementTypes.Relationship_4004 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRelationship_4004Command(req)
					: getCreateCompleteIncomingRelationship_4004Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingTopicSubtopics_4001Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		if (false == sourceEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateTopicSubtopics_4001(source, null)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingTopicSubtopics_4001Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic
				|| false == targetEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateTopicSubtopics_4001(source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(sourceEObject,
				MindmapPackage.eINSTANCE.getTopic_Subtopics(), target);
		return getMSLWrapper(new SetValueCommand(setReq));
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRelationship_4002Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		if (false == sourceEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Map container = (Map) getRelationshipContainer(source,
				MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateRelationship_4002(container, source, null)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRelationship_4002Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic
				|| false == targetEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;
		Map container = (Map) getRelationshipContainer(source,
				MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateRelationship_4002(container, source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(MindmapPackage.eINSTANCE
					.getMap_Relations());
		}
		return getMSLWrapper(new RelationshipTypeLinkCreateCommand(req,
				container, source, target));
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRelationship_4003Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		if (false == sourceEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Map container = (Map) getRelationshipContainer(source,
				MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateRelationship_4003(container, source, null)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRelationship_4003Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic
				|| false == targetEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;
		Map container = (Map) getRelationshipContainer(source,
				MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateRelationship_4003(container, source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(MindmapPackage.eINSTANCE
					.getMap_Relations());
		}
		return getMSLWrapper(new Relationship2TypeLinkCreateCommand(req,
				container, source, target));
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRelationship_4004Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		if (false == sourceEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Map container = (Map) getRelationshipContainer(source,
				MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateRelationship_4004(container, source, null)) {
			return UnexecutableCommand.INSTANCE;
		}
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRelationship_4004Command(
			CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof Topic
				|| false == targetEObject instanceof Topic) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic source = (Topic) sourceEObject;
		Topic target = (Topic) targetEObject;
		Map container = (Map) getRelationshipContainer(source,
				MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (container == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateRelationship_4004(container, source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(MindmapPackage.eINSTANCE
					.getMap_Relations());
		}
		return getMSLWrapper(new Relationship3TypeLinkCreateCommand(req,
				container, source, target));
	}

}
