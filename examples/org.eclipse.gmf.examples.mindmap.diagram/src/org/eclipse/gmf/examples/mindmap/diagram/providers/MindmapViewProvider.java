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
package org.eclipse.gmf.examples.mindmap.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipLabel2EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipLabel3EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipLabelEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ResourceNameEmailEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadSubjectEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadThreadItemCompartmentEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicNameEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicSubtopicsEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicThreadCompartmentEditPart;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.examples.mindmap.diagram.view.factories.MapViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Relationship2ViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Relationship3ViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.RelationshipLabel2ViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.RelationshipLabel3ViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.RelationshipLabelViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.RelationshipViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.ResourceNameEmailViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.ResourceViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.ThreadItemViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.ThreadSubjectViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.ThreadThreadItemCompartmentViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.ThreadViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.TopicNameViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.TopicSubtopicsViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.TopicThreadCompartmentViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.TopicViewFactory;

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
		EObject domainElement = getSemanticElement(semanticAdapter);

		int visualID;
		if (semanticHint == null) {
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = MindmapVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = MindmapVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				if (!MindmapElementTypes.isKnownElementType(elementType)
						|| false == elementType instanceof IHintedType) {
					return null;
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null;
				}
				if (domainElement != null
						&& visualID != MindmapVisualIDRegistry.getNodeVisualID(
								containerView, domainElement)) {
					return null;
				}
			} else {
				switch (visualID) {
				case MapEditPart.VISUAL_ID:
				case TopicEditPart.VISUAL_ID:
				case ResourceEditPart.VISUAL_ID:
				case ThreadEditPart.VISUAL_ID:
				case ThreadItemEditPart.VISUAL_ID:
				case TopicSubtopicsEditPart.VISUAL_ID:
				case RelationshipEditPart.VISUAL_ID:
				case Relationship2EditPart.VISUAL_ID:
				case Relationship3EditPart.VISUAL_ID:
					return null;
				}
			}
		}
		if (!MindmapVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
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
		if (elementType == null) {
			return null;
		}
		if (!MindmapElementTypes.isKnownElementType(elementType)
				|| false == elementType instanceof IHintedType) {
			return null;
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null;
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null;
		}
		int visualID = MindmapVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != MindmapVisualIDRegistry
						.getLinkWithClassVisualID(domainElement)) {
			return null;
		}
		switch (visualID) {
		case TopicSubtopicsEditPart.VISUAL_ID:
			return TopicSubtopicsViewFactory.class;
		case RelationshipEditPart.VISUAL_ID:
			return RelationshipViewFactory.class;
		case Relationship2EditPart.VISUAL_ID:
			return Relationship2ViewFactory.class;
		case Relationship3EditPart.VISUAL_ID:
			return Relationship3ViewFactory.class;
		}
		return null;
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

}
