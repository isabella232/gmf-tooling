package org.eclipse.gmf.examples.mindmap.rcp.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadThreadItemCompartmentEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.TopicSubtopicsEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.TopicThreadCompartmentEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.providers.MindmapElementTypes;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MindmapDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (MindmapVisualIDRegistry.getVisualID(view)) {
		case TopicThreadCompartmentEditPart.VISUAL_ID:
			return getTopicThreadCompartment_7001SemanticChildren(view);
		case ThreadThreadItemCompartmentEditPart.VISUAL_ID:
			return getThreadThreadItemCompartment_7002SemanticChildren(view);
		case MapEditPart.VISUAL_ID:
			return getMap_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTopicThreadCompartment_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Topic modelElement = (Topic) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getComments().iterator(); it.hasNext();) {
			Thread childElement = (Thread) it.next();
			int visualID = MindmapVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ThreadEditPart.VISUAL_ID) {
				result.add(new MindmapNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getThreadThreadItemCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Thread modelElement = (Thread) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getItems().iterator(); it.hasNext();) {
			ThreadItem childElement = (ThreadItem) it.next();
			int visualID = MindmapVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ThreadItemEditPart.VISUAL_ID) {
				result.add(new MindmapNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMap_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Map modelElement = (Map) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getRootTopics().iterator(); it
				.hasNext();) {
			Topic childElement = (Topic) it.next();
			int visualID = MindmapVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == TopicEditPart.VISUAL_ID) {
				result.add(new MindmapNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getResources().iterator(); it.hasNext();) {
			Resource childElement = (Resource) it.next();
			int visualID = MindmapVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ResourceEditPart.VISUAL_ID) {
				result.add(new MindmapNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (MindmapVisualIDRegistry.getVisualID(view)) {
		case MapEditPart.VISUAL_ID:
			return getMap_1000ContainedLinks(view);
		case TopicEditPart.VISUAL_ID:
			return getTopic_2001ContainedLinks(view);
		case ResourceEditPart.VISUAL_ID:
			return getResource_2002ContainedLinks(view);
		case ThreadEditPart.VISUAL_ID:
			return getThread_3001ContainedLinks(view);
		case ThreadItemEditPart.VISUAL_ID:
			return getThreadItem_3002ContainedLinks(view);
		case RelationshipEditPart.VISUAL_ID:
			return getRelationship_4002ContainedLinks(view);
		case Relationship2EditPart.VISUAL_ID:
			return getRelationship_4003ContainedLinks(view);
		case Relationship3EditPart.VISUAL_ID:
			return getRelationship_4004ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (MindmapVisualIDRegistry.getVisualID(view)) {
		case TopicEditPart.VISUAL_ID:
			return getTopic_2001IncomingLinks(view);
		case ResourceEditPart.VISUAL_ID:
			return getResource_2002IncomingLinks(view);
		case ThreadEditPart.VISUAL_ID:
			return getThread_3001IncomingLinks(view);
		case ThreadItemEditPart.VISUAL_ID:
			return getThreadItem_3002IncomingLinks(view);
		case RelationshipEditPart.VISUAL_ID:
			return getRelationship_4002IncomingLinks(view);
		case Relationship2EditPart.VISUAL_ID:
			return getRelationship_4003IncomingLinks(view);
		case Relationship3EditPart.VISUAL_ID:
			return getRelationship_4004IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (MindmapVisualIDRegistry.getVisualID(view)) {
		case TopicEditPart.VISUAL_ID:
			return getTopic_2001OutgoingLinks(view);
		case ResourceEditPart.VISUAL_ID:
			return getResource_2002OutgoingLinks(view);
		case ThreadEditPart.VISUAL_ID:
			return getThread_3001OutgoingLinks(view);
		case ThreadItemEditPart.VISUAL_ID:
			return getThreadItem_3002OutgoingLinks(view);
		case RelationshipEditPart.VISUAL_ID:
			return getRelationship_4002OutgoingLinks(view);
		case Relationship2EditPart.VISUAL_ID:
			return getRelationship_4003OutgoingLinks(view);
		case Relationship3EditPart.VISUAL_ID:
			return getRelationship_4004OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMap_1000ContainedLinks(View view) {
		Map modelElement = (Map) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Relationship_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Relationship_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Relationship_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTopic_2001ContainedLinks(View view) {
		Topic modelElement = (Topic) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Topic_Subtopics_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getResource_2002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getThread_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getThreadItem_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRelationship_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRelationship_4003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRelationship_4004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTopic_2001IncomingLinks(View view) {
		Topic modelElement = (Topic) view.getElement();
		java.util.Map crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Topic_Subtopics_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Relationship_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Relationship_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Relationship_4004(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getResource_2002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getThread_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getThreadItem_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRelationship_4002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRelationship_4003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRelationship_4004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTopic_2001OutgoingLinks(View view) {
		Topic modelElement = (Topic) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Topic_Subtopics_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Relationship_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Relationship_4003(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Relationship_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getResource_2002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getThread_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getThreadItem_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRelationship_4002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRelationship_4003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRelationship_4004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Relationship_4002(
			Map container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getRelations().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Relationship) {
				continue;
			}
			Relationship link = (Relationship) linkObject;
			if (RelationshipEditPart.VISUAL_ID != MindmapVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Topic dst = link.getTarget();
			Topic src = link.getSource();
			result.add(new MindmapLinkDescriptor(src, dst, link,
					MindmapElementTypes.Relationship_4002,
					RelationshipEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Relationship_4003(
			Map container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getRelations().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Relationship) {
				continue;
			}
			Relationship link = (Relationship) linkObject;
			if (Relationship2EditPart.VISUAL_ID != MindmapVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Topic dst = link.getTarget();
			Topic src = link.getSource();
			result.add(new MindmapLinkDescriptor(src, dst, link,
					MindmapElementTypes.Relationship_4003,
					Relationship2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Relationship_4004(
			Map container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getRelations().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Relationship) {
				continue;
			}
			Relationship link = (Relationship) linkObject;
			if (Relationship3EditPart.VISUAL_ID != MindmapVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Topic dst = link.getTarget();
			Topic src = link.getSource();
			result.add(new MindmapLinkDescriptor(src, dst, link,
					MindmapElementTypes.Relationship_4004,
					Relationship3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Topic_Subtopics_4001(
			Topic target, java.util.Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == MindmapPackage.eINSTANCE
					.getTopic_Subtopics()) {
				result.add(new MindmapLinkDescriptor(setting.getEObject(),
						target, MindmapElementTypes.TopicSubtopics_4001,
						TopicSubtopicsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Relationship_4002(
			Topic target, java.util.Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != MindmapPackage.eINSTANCE
					.getRelationship_Target()
					|| false == setting.getEObject() instanceof Relationship) {
				continue;
			}
			Relationship link = (Relationship) setting.getEObject();
			if (RelationshipEditPart.VISUAL_ID != MindmapVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Topic src = link.getSource();
			result.add(new MindmapLinkDescriptor(src, target, link,
					MindmapElementTypes.Relationship_4002,
					RelationshipEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Relationship_4003(
			Topic target, java.util.Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != MindmapPackage.eINSTANCE
					.getRelationship_Target()
					|| false == setting.getEObject() instanceof Relationship) {
				continue;
			}
			Relationship link = (Relationship) setting.getEObject();
			if (Relationship2EditPart.VISUAL_ID != MindmapVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Topic src = link.getSource();
			result.add(new MindmapLinkDescriptor(src, target, link,
					MindmapElementTypes.Relationship_4003,
					Relationship2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Relationship_4004(
			Topic target, java.util.Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != MindmapPackage.eINSTANCE
					.getRelationship_Target()
					|| false == setting.getEObject() instanceof Relationship) {
				continue;
			}
			Relationship link = (Relationship) setting.getEObject();
			if (Relationship3EditPart.VISUAL_ID != MindmapVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Topic src = link.getSource();
			result.add(new MindmapLinkDescriptor(src, target, link,
					MindmapElementTypes.Relationship_4004,
					Relationship3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Topic_Subtopics_4001(
			Topic source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getSubtopics().iterator(); destinations
				.hasNext();) {
			Topic destination = (Topic) destinations.next();
			result.add(new MindmapLinkDescriptor(source, destination,
					MindmapElementTypes.TopicSubtopics_4001,
					TopicSubtopicsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Relationship_4002(
			Topic source) {
		Map container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Map) {
				container = (Map) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getRelations().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Relationship) {
				continue;
			}
			Relationship link = (Relationship) linkObject;
			if (RelationshipEditPart.VISUAL_ID != MindmapVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Topic dst = link.getTarget();
			Topic src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new MindmapLinkDescriptor(src, dst, link,
					MindmapElementTypes.Relationship_4002,
					RelationshipEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Relationship_4003(
			Topic source) {
		Map container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Map) {
				container = (Map) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getRelations().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Relationship) {
				continue;
			}
			Relationship link = (Relationship) linkObject;
			if (Relationship2EditPart.VISUAL_ID != MindmapVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Topic dst = link.getTarget();
			Topic src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new MindmapLinkDescriptor(src, dst, link,
					MindmapElementTypes.Relationship_4003,
					Relationship2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Relationship_4004(
			Topic source) {
		Map container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Map) {
				container = (Map) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getRelations().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Relationship) {
				continue;
			}
			Relationship link = (Relationship) linkObject;
			if (Relationship3EditPart.VISUAL_ID != MindmapVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Topic dst = link.getTarget();
			Topic src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new MindmapLinkDescriptor(src, dst, link,
					MindmapElementTypes.Relationship_4004,
					Relationship3EditPart.VISUAL_ID));
		}
		return result;
	}

}
