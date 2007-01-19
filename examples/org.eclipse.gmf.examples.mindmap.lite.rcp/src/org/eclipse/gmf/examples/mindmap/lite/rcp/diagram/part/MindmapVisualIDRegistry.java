package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part;

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

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.ThreadThreadItemCompartmentEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.TopicThreadCompartmentEditPart;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.expressions.MindmapAbstractExpression;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.expressions.MindmapOCLFactory;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object. Note that it only returns semantically complete objects (those who must have an element associated with them).
 *
 * @generated
 */
public class MindmapVisualIDRegistry {

	/**
	 * @generated
	 */
	public static final MindmapVisualIDRegistry INSTANCE = new MindmapVisualIDRegistry();

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
			MindmapDiagramEditorPlugin.getInstance().logInfo(
					"Unable to parse view type as a visualID number: " + type);
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
	public int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public int getDiagramVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (MindmapPackage.eINSTANCE.getMap().equals(domainElementMetaclass)
				&& isDiagramMap_1000((Map) domainElement)) {
			return MapEditPart.VISUAL_ID;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement,
				domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public int getNodeVisualID(View containerView, EObject domainElement,
			EClass domainElementMetaclass) {
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
		switch (containerVisualID) {
		case TopicThreadCompartmentEditPart.VISUAL_ID:
			if (MindmapPackage.eINSTANCE.getThread().isSuperTypeOf(
					domainElementMetaclass)
					&& isNodeThread_3001((Thread) domainElement)) {
				return ThreadEditPart.VISUAL_ID;
			}
			return getUnrecognizedTopicThreadCompartment_7001ChildNodeID(domainElement);
		case ThreadThreadItemCompartmentEditPart.VISUAL_ID:
			if (MindmapPackage.eINSTANCE.getThreadItem().isSuperTypeOf(
					domainElementMetaclass)
					&& isNodeThreadItem_3002((ThreadItem) domainElement)) {
				return ThreadItemEditPart.VISUAL_ID;
			}
			return getUnrecognizedThreadThreadItemCompartment_7002ChildNodeID(domainElement);
		case MapEditPart.VISUAL_ID:
			if (MindmapPackage.eINSTANCE.getTopic().isSuperTypeOf(
					domainElementMetaclass)
					&& isNodeTopic_2001((Topic) domainElement)) {
				return TopicEditPart.VISUAL_ID;
			}
			if (MindmapPackage.eINSTANCE.getResource().isSuperTypeOf(
					domainElementMetaclass)
					&& isNodeResource_2002((Resource) domainElement)) {
				return ResourceEditPart.VISUAL_ID;
			}
			return getUnrecognizedMap_1000ChildNodeID(domainElement);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public int getLinkWithClassVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (MindmapPackage.eINSTANCE.getRelationship().isSuperTypeOf(
				domainElementMetaclass)
				&& isLinkWithClassRelationship_4002((Relationship) domainElement)) {
			return RelationshipEditPart.VISUAL_ID;
		}
		if (MindmapPackage.eINSTANCE.getRelationship().isSuperTypeOf(
				domainElementMetaclass)
				&& isLinkWithClassRelationship_4003((Relationship) domainElement)) {
			return Relationship2EditPart.VISUAL_ID;
		}
		if (MindmapPackage.eINSTANCE.getRelationship().isSuperTypeOf(
				domainElementMetaclass)
				&& isLinkWithClassRelationship_4004((Relationship) domainElement)) {
			return Relationship3EditPart.VISUAL_ID;
		}
		return getUnrecognizedLinkWithClassID(domainElement);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isDiagramMap_1000(Map element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeTopic_2001(Topic element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeResource_2002(Resource element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeThread_3001(Thread element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeThreadItem_3002(ThreadItem element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedTopicThreadCompartment_7001ChildNodeID(
			EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedThreadThreadItemCompartment_7002ChildNodeID(
			EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedMap_1000ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isLinkWithClassRelationship_4002(Relationship element) {
		return Relationship_4002.matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isLinkWithClassRelationship_4003(Relationship element) {
		return Relationship_4003.matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isLinkWithClassRelationship_4004(Relationship element) {
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
