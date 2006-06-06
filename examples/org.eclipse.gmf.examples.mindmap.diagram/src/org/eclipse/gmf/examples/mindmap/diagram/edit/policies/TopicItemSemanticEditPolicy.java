package org.eclipse.gmf.examples.mindmap.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Relationship;
import org.eclipse.gmf.examples.mindmap.Topic;

import org.eclipse.gmf.examples.mindmap.diagram.providers.MindmapElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

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
		if (MindmapElementTypes.TopicSubtopics_3001 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingTopic_Subtopics3001Command(req)
					: getCreateCompleteIncomingTopic_Subtopics3001Command(req);
		}
		if (MindmapElementTypes.Relationship_3002 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRelationship3002Command(req)
					: getCreateCompleteIncomingRelationship3002Command(req);
		}
		if (MindmapElementTypes.Relationship_3003 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRelationship3003Command(req)
					: getCreateCompleteIncomingRelationship3003Command(req);
		}
		if (MindmapElementTypes.Relationship_3004 == req.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingRelationship3004Command(req)
					: getCreateCompleteIncomingRelationship3004Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingTopic_Subtopics3001Command(
			CreateRelationshipRequest req) {
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints.TopicSubtopics_3001
				.canCreateLink(req, false)) {
			return UnexecutableCommand.INSTANCE;
		}

		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingTopic_Subtopics3001Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof Topic)) {
			return UnexecutableCommand.INSTANCE;
		}
		Topic element = (Topic) req.getSource();
		if (element.getSubtopics().contains(req.getTarget())) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!MindmapBaseItemSemanticEditPolicy.LinkConstraints.TopicSubtopics_3001
				.canCreateLink(req, false)) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(req.getSource(),
				MindmapPackage.eINSTANCE.getTopic_Subtopics(), req.getTarget());
		return getMSLWrapper(new SetValueCommand(setReq));
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRelationship3002Command(
			CreateRelationshipRequest req) {
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRelationship3002Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof Topic)) {
			return UnexecutableCommand.INSTANCE;
		}
		final Map element = (Map) getRelationshipContainer(req.getSource(),
				MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (element == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(MindmapPackage.eINSTANCE
					.getMap_Relations());
		}
		return getMSLWrapper(new CreateIncomingRelationship3002Command(req) {

			/**
			 * @generated
			 */
			protected EObject getElementToEdit() {
				return element;
			}
		});
	}

	/**
	 * @generated
	 */
	private static class CreateIncomingRelationship3002Command extends
			CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingRelationship3002Command(
				CreateRelationshipRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return MindmapPackage.eINSTANCE.getMap();
		};

		/**
		 * @generated
		 */
		protected void setElementToEdit(EObject element) {
			throw new UnsupportedOperationException();
		}

		/**
		 * @generated
		 */
		protected EObject doDefaultElementCreation() {
			Relationship newElement = (Relationship) super
					.doDefaultElementCreation();
			if (newElement != null) {
				newElement.setTarget((Topic) getTarget());
				newElement.setSource((Topic) getSource());
				MindmapElementTypes.Initializers.Relationship_3002
						.init(newElement);
			}
			return newElement;
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRelationship3003Command(
			CreateRelationshipRequest req) {
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRelationship3003Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof Topic)) {
			return UnexecutableCommand.INSTANCE;
		}
		final Map element = (Map) getRelationshipContainer(req.getSource(),
				MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (element == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(MindmapPackage.eINSTANCE
					.getMap_Relations());
		}
		return getMSLWrapper(new CreateIncomingRelationship3003Command(req) {

			/**
			 * @generated
			 */
			protected EObject getElementToEdit() {
				return element;
			}
		});
	}

	/**
	 * @generated
	 */
	private static class CreateIncomingRelationship3003Command extends
			CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingRelationship3003Command(
				CreateRelationshipRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return MindmapPackage.eINSTANCE.getMap();
		};

		/**
		 * @generated
		 */
		protected void setElementToEdit(EObject element) {
			throw new UnsupportedOperationException();
		}

		/**
		 * @generated
		 */
		protected EObject doDefaultElementCreation() {
			Relationship newElement = (Relationship) super
					.doDefaultElementCreation();
			if (newElement != null) {
				newElement.setTarget((Topic) getTarget());
				newElement.setSource((Topic) getSource());
				MindmapElementTypes.Initializers.Relationship_3003
						.init(newElement);
			}
			return newElement;
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRelationship3004Command(
			CreateRelationshipRequest req) {
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRelationship3004Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof Topic)) {
			return UnexecutableCommand.INSTANCE;
		}
		final Map element = (Map) getRelationshipContainer(req.getSource(),
				MindmapPackage.eINSTANCE.getMap(), req.getElementType());
		if (element == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(MindmapPackage.eINSTANCE
					.getMap_Relations());
		}
		return getMSLWrapper(new CreateIncomingRelationship3004Command(req) {

			/**
			 * @generated
			 */
			protected EObject getElementToEdit() {
				return element;
			}
		});
	}

	/**
	 * @generated
	 */
	private static class CreateIncomingRelationship3004Command extends
			CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingRelationship3004Command(
				CreateRelationshipRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return MindmapPackage.eINSTANCE.getMap();
		};

		/**
		 * @generated
		 */
		protected void setElementToEdit(EObject element) {
			throw new UnsupportedOperationException();
		}

		/**
		 * @generated
		 */
		protected EObject doDefaultElementCreation() {
			Relationship newElement = (Relationship) super
					.doDefaultElementCreation();
			if (newElement != null) {
				newElement.setTarget((Topic) getTarget());
				newElement.setSource((Topic) getSource());
				MindmapElementTypes.Initializers.Relationship_3004
						.init(newElement);
			}
			return newElement;
		}
	}
}
