package org.eclipse.gmf.examples.mindmap.rcp.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
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

import org.eclipse.gmf.examples.mindmap.rcp.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.MapViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.Relationship2ViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.Relationship3ViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.RelationshipLabel2ViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.RelationshipLabel3ViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.RelationshipLabelViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.RelationshipViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ResourceNameEmailViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ResourceViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ThreadItemViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ThreadSubjectViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ThreadThreadItemCompartmentViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.ThreadViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.TopicNameViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.TopicSubtopicsViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.TopicThreadCompartmentViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.view.factories.TopicViewFactory;

/**
 * @generated
 */
public class MindmapViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (MapEditPart.MODEL_ID.equals(diagramKind)
				&& MindmapVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return MapViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null
				&& !MindmapElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = MindmapVisualIDRegistry.getNodeVisualID(containerView,
				semanticElement, semanticType, semanticHint);
		switch (nodeVID) {
		case TopicEditPart.VISUAL_ID:
			return TopicViewFactory.class;
		case TopicNameEditPart.VISUAL_ID:
			return TopicNameViewFactory.class;
		case ResourceEditPart.VISUAL_ID:
			return ResourceViewFactory.class;
		case ResourceNameEmailEditPart.VISUAL_ID:
			return ResourceNameEmailViewFactory.class;
		case ThreadEditPart.VISUAL_ID:
			return ThreadViewFactory.class;
		case ThreadSubjectEditPart.VISUAL_ID:
			return ThreadSubjectViewFactory.class;
		case ThreadItemEditPart.VISUAL_ID:
			return ThreadItemViewFactory.class;
		case TopicThreadCompartmentEditPart.VISUAL_ID:
			return TopicThreadCompartmentViewFactory.class;
		case ThreadThreadItemCompartmentEditPart.VISUAL_ID:
			return ThreadThreadItemCompartmentViewFactory.class;
		case RelationshipLabelEditPart.VISUAL_ID:
			return RelationshipLabelViewFactory.class;
		case RelationshipLabel2EditPart.VISUAL_ID:
			return RelationshipLabel2ViewFactory.class;
		case RelationshipLabel3EditPart.VISUAL_ID:
			return RelationshipLabel3ViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null
				&& !MindmapElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		if (MindmapElementTypes.TopicSubtopics_4001.equals(elementType)) {
			return TopicSubtopicsViewFactory.class;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		if (semanticType == null) {
			return null;
		}
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int linkVID = MindmapVisualIDRegistry.getLinkWithClassVisualID(
				semanticElement, semanticType);
		switch (linkVID) {
		case RelationshipEditPart.VISUAL_ID:
			return RelationshipViewFactory.class;
		case Relationship2EditPart.VISUAL_ID:
			return Relationship2ViewFactory.class;
		case Relationship3EditPart.VISUAL_ID:
			return Relationship3ViewFactory.class;
		}
		return getUnrecognizedConnectorViewClass(semanticAdapter,
				containerView, semanticHint);
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		// Handle unrecognized child node classes here
		return null;
	}

}
