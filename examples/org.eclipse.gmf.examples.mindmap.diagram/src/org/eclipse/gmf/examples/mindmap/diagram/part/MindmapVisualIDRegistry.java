/*******************************************************************************
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.gmf.examples.mindmap.diagram.part;

import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Relationship;
import org.eclipse.gmf.examples.mindmap.Resource;
import org.eclipse.gmf.examples.mindmap.ThreadItem;
import org.eclipse.gmf.examples.mindmap.Topic;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship_label2EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship_label3EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship_labelEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Resource_name_emailEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Thread_ThreadItemCompartmentEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Thread_subjectEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Topic_ThreadCompartmentEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Topic_nameEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented by
 * a domain model object.
 * 
 * @generated
 */
public class MindmapVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = MindmapDiagramEditorPlugin.getInstance().getBundle().getSymbolicName() + "/debug/visualID"; //$NON-NLS-1$

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
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				MindmapDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
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
	private static int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (MindmapPackage.eINSTANCE.getMap().isSuperTypeOf(domainElementMetaclass) && isDiagramMap_79((Map) domainElement)) {
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
		return getNodeVisualID(containerView, domainElement, domainElementMetaclass, null);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass, String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!MapEditPart.MODEL_ID.equals(containerModelID) && !"mindmap".equals(containerModelID)) {
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
		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint) : -1;
		switch (containerVisualID) {
		case TopicEditPart.VISUAL_ID:
			if (Topic_nameEditPart.VISUAL_ID == nodeVisualID) {
				return Topic_nameEditPart.VISUAL_ID;
			}
			if (Topic_ThreadCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return Topic_ThreadCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedTopic_1001ChildNodeID(domainElement, semanticHint);
		case ResourceEditPart.VISUAL_ID:
			if (Resource_name_emailEditPart.VISUAL_ID == nodeVisualID) {
				return Resource_name_emailEditPart.VISUAL_ID;
			}
			return getUnrecognizedResource_1002ChildNodeID(domainElement, semanticHint);
		case ThreadEditPart.VISUAL_ID:
			if (Thread_subjectEditPart.VISUAL_ID == nodeVisualID) {
				return Thread_subjectEditPart.VISUAL_ID;
			}
			if (Thread_ThreadItemCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return Thread_ThreadItemCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedThread_2001ChildNodeID(domainElement, semanticHint);
		case ThreadItemEditPart.VISUAL_ID:
			return getUnrecognizedThreadItem_2002ChildNodeID(domainElement, semanticHint);
		case Topic_ThreadCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || ThreadEditPart.VISUAL_ID == nodeVisualID) && MindmapPackage.eINSTANCE.getThread().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeThread_2001((org.eclipse.gmf.examples.mindmap.Thread) domainElement))) {
				return ThreadEditPart.VISUAL_ID;
			}
			return getUnrecognizedThreadCompartment_5001ChildNodeID(domainElement, semanticHint);
		case Thread_ThreadItemCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || ThreadItemEditPart.VISUAL_ID == nodeVisualID) && MindmapPackage.eINSTANCE.getThreadItem().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeThreadItem_2002((ThreadItem) domainElement))) {
				return ThreadItemEditPart.VISUAL_ID;
			}
			return getUnrecognizedThreadItemCompartment_5002ChildNodeID(domainElement, semanticHint);
		case MapEditPart.VISUAL_ID:
			if ((semanticHint == null || TopicEditPart.VISUAL_ID == nodeVisualID) && MindmapPackage.eINSTANCE.getTopic().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeTopic_1001((Topic) domainElement))) {
				return TopicEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ResourceEditPart.VISUAL_ID == nodeVisualID) && MindmapPackage.eINSTANCE.getResource().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeResource_1002((Resource) domainElement))) {
				return ResourceEditPart.VISUAL_ID;
			}
			return getUnrecognizedMap_79ChildNodeID(domainElement, semanticHint);
		case RelationshipEditPart.VISUAL_ID:
			if (Relationship_labelEditPart.VISUAL_ID == nodeVisualID) {
				return Relationship_labelEditPart.VISUAL_ID;
			}
			return getUnrecognizedRelationship_3002LinkLabelID(semanticHint);
		case Relationship2EditPart.VISUAL_ID:
			if (Relationship_label2EditPart.VISUAL_ID == nodeVisualID) {
				return Relationship_label2EditPart.VISUAL_ID;
			}
			return getUnrecognizedRelationship_3003LinkLabelID(semanticHint);
		case Relationship3EditPart.VISUAL_ID:
			if (Relationship_label3EditPart.VISUAL_ID == nodeVisualID) {
				return Relationship_label3EditPart.VISUAL_ID;
			}
			return getUnrecognizedRelationship_3004LinkLabelID(semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (MindmapPackage.eINSTANCE.getRelationship().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isLinkWithClassRelationship_3002((Relationship) domainElement))) {
			return RelationshipEditPart.VISUAL_ID;
		} else if (MindmapPackage.eINSTANCE.getRelationship().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isLinkWithClassRelationship_3003((Relationship) domainElement))) {
			return Relationship2EditPart.VISUAL_ID;
		} else if (MindmapPackage.eINSTANCE.getRelationship().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isLinkWithClassRelationship_3004((Relationship) domainElement))) {
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
	private static boolean isDiagramMap_79(Map element) {
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
	private static boolean isNodeTopic_1001(Topic element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional
	 * conditions here.
	 * 
	 * @generated
	 */
	private static boolean isNodeResource_1002(Resource element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional
	 * conditions here.
	 * 
	 * @generated
	 */
	private static boolean isNodeThread_2001(org.eclipse.gmf.examples.mindmap.Thread element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional
	 * conditions here.
	 * 
	 * @generated
	 */
	private static boolean isNodeThreadItem_2002(ThreadItem element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedTopic_1001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedResource_1002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedThread_2001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedThreadItem_2002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedThreadCompartment_5001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedThreadItemCompartment_5002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedMap_79ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedRelationship_3002LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedRelationship_3003LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedRelationship_3004LinkLabelID(String semanticHint) {
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
	private static boolean isLinkWithClassRelationship_3002(Relationship element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional
	 * conditions here.
	 * 
	 * @generated
	 */
	private static boolean isLinkWithClassRelationship_3003(Relationship element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional
	 * conditions here.
	 * 
	 * @generated
	 */
	private static boolean isLinkWithClassRelationship_3004(Relationship element) {
		return true;
	}
}
