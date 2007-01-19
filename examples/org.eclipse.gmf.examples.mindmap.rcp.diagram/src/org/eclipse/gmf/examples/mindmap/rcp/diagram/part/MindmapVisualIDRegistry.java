package org.eclipse.gmf.examples.mindmap.rcp.diagram.part;

import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Relationship;
import org.eclipse.gmf.examples.mindmap.Resource;
import org.eclipse.gmf.examples.mindmap.Thread;
import org.eclipse.gmf.examples.mindmap.ThreadItem;
import org.eclipse.gmf.examples.mindmap.Topic;

import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.RelationshipLabel2EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.RelationshipLabel3EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.RelationshipLabelEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ResourceNameEmailEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadSubjectEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadThreadItemCompartmentEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.TopicNameEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.TopicThreadCompartmentEditPart;

import org.eclipse.gmf.examples.mindmap.rcp.diagram.expressions.MindmapAbstractExpression;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.expressions.MindmapOCLFactory;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object.
 *
 * @generated
 */
public class MindmapVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = MindmapDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (MapEditPart.MODEL_ID.equals(view.getType())) {
				return MapEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				MindmapDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	private static int getDiagramVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (MindmapPackage.eINSTANCE.getMap().isSuperTypeOf(
				domainElementMetaclass)
				&& isDiagramMap_1000((Map) domainElement)) {
			return MapEditPart.VISUAL_ID;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement,
				domainElementMetaclass, null);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView,
			EObject domainElement, EClass domainElementMetaclass,
			String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!MapEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (MapEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = MapEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint)
				: -1;
		switch (containerVisualID) {
		case TopicEditPart.VISUAL_ID:
			if (TopicNameEditPart.VISUAL_ID == nodeVisualID) {
				return TopicNameEditPart.VISUAL_ID;
			}
			if (TopicThreadCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return TopicThreadCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedTopic_2001ChildNodeID(domainElement,
					semanticHint);
		case ResourceEditPart.VISUAL_ID:
			if (ResourceNameEmailEditPart.VISUAL_ID == nodeVisualID) {
				return ResourceNameEmailEditPart.VISUAL_ID;
			}
			return getUnrecognizedResource_2002ChildNodeID(domainElement,
					semanticHint);
		case ThreadEditPart.VISUAL_ID:
			if (ThreadSubjectEditPart.VISUAL_ID == nodeVisualID) {
				return ThreadSubjectEditPart.VISUAL_ID;
			}
			if (ThreadThreadItemCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return ThreadThreadItemCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedThread_3001ChildNodeID(domainElement,
					semanticHint);
		case ThreadItemEditPart.VISUAL_ID:
			return getUnrecognizedThreadItem_3002ChildNodeID(domainElement,
					semanticHint);
		case TopicThreadCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || ThreadEditPart.VISUAL_ID == nodeVisualID)
					&& MindmapPackage.eINSTANCE.getThread().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeThread_3001((Thread) domainElement))) {
				return ThreadEditPart.VISUAL_ID;
			}
			return getUnrecognizedTopicThreadCompartment_7001ChildNodeID(
					domainElement, semanticHint);
		case ThreadThreadItemCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || ThreadItemEditPart.VISUAL_ID == nodeVisualID)
					&& MindmapPackage.eINSTANCE.getThreadItem().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeThreadItem_3002((ThreadItem) domainElement))) {
				return ThreadItemEditPart.VISUAL_ID;
			}
			return getUnrecognizedThreadThreadItemCompartment_7002ChildNodeID(
					domainElement, semanticHint);
		case MapEditPart.VISUAL_ID:
			if ((semanticHint == null || TopicEditPart.VISUAL_ID == nodeVisualID)
					&& MindmapPackage.eINSTANCE.getTopic().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeTopic_2001((Topic) domainElement))) {
				return TopicEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ResourceEditPart.VISUAL_ID == nodeVisualID)
					&& MindmapPackage.eINSTANCE.getResource().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeResource_2002((Resource) domainElement))) {
				return ResourceEditPart.VISUAL_ID;
			}
			return getUnrecognizedMap_1000ChildNodeID(domainElement,
					semanticHint);
		case RelationshipEditPart.VISUAL_ID:
			if (RelationshipLabelEditPart.VISUAL_ID == nodeVisualID) {
				return RelationshipLabelEditPart.VISUAL_ID;
			}
			return getUnrecognizedRelationship_4002LinkLabelID(semanticHint);
		case Relationship2EditPart.VISUAL_ID:
			if (RelationshipLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return RelationshipLabel2EditPart.VISUAL_ID;
			}
			return getUnrecognizedRelationship_4003LinkLabelID(semanticHint);
		case Relationship3EditPart.VISUAL_ID:
			if (RelationshipLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return RelationshipLabel3EditPart.VISUAL_ID;
			}
			return getUnrecognizedRelationship_4004LinkLabelID(semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (MindmapPackage.eINSTANCE.getRelationship().isSuperTypeOf(
				domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassRelationship_4002((Relationship) domainElement))) {
			return RelationshipEditPart.VISUAL_ID;
		} else if (MindmapPackage.eINSTANCE.getRelationship().isSuperTypeOf(
				domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassRelationship_4003((Relationship) domainElement))) {
			return Relationship2EditPart.VISUAL_ID;
		} else if (MindmapPackage.eINSTANCE.getRelationship().isSuperTypeOf(
				domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassRelationship_4004((Relationship) domainElement))) {
			return Relationship3EditPart.VISUAL_ID;
		} else {
			return getUnrecognizedLinkWithClassID(domainElement);
		}
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isDiagramMap_1000(Map element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeTopic_2001(Topic element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeResource_2002(Resource element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeThread_3001(Thread element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeThreadItem_3002(ThreadItem element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedTopic_2001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedResource_2002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedThread_3001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedThreadItem_3002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedTopicThreadCompartment_7001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedThreadThreadItemCompartment_7002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedMap_1000ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRelationship_4002LinkLabelID(
			String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRelationship_4003LinkLabelID(
			String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRelationship_4004LinkLabelID(
			String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassRelationship_4002(Relationship element) {
		return Relationship_4002.matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassRelationship_4003(Relationship element) {
		return Relationship_4003.matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassRelationship_4004(Relationship element) {
		return Relationship_4004.matches(element);
	}

	/**
	 * @generated
	 */
	private static final Matcher Relationship_4002 = new Matcher(
			MindmapOCLFactory.getExpression(
					"self.type = RelationshipType::EXTENDS", //$NON-NLS-1$
					MindmapPackage.eINSTANCE.getRelationship()));

	/**
	 * @generated
	 */
	private static final Matcher Relationship_4003 = new Matcher(
			MindmapOCLFactory.getExpression(
					"self.type = RelationshipType::INCLUDES", //$NON-NLS-1$
					MindmapPackage.eINSTANCE.getRelationship()));

	/**
	 * @generated
	 */
	private static final Matcher Relationship_4004 = new Matcher(
			MindmapOCLFactory.getExpression(
					"self.type = RelationshipType::DEPENDENCY", //$NON-NLS-1$
					MindmapPackage.eINSTANCE.getRelationship()));

	/**
	 * @generated	
	 */
	static class Matcher {

		/**
		 * @generated	
		 */
		private MindmapAbstractExpression condition;

		/**
		 * @generated	
		 */
		Matcher(MindmapAbstractExpression conditionExpression) {
			this.condition = conditionExpression;
		}

		/**
		 * @generated	
		 */
		boolean matches(EObject object) {
			Object result = condition.evaluate(object);
			return result instanceof Boolean
					&& ((Boolean) result).booleanValue();
		}
	}// Matcher
}
