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
package org.eclipse.gmf.examples.mindmap.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.MapViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Relationship2ViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Relationship3ViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.RelationshipViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Relationship_label2ViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Relationship_label3ViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Relationship_labelViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.ResourceViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Resource_name_emailViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.SubtopicsViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.ThreadItemViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.ThreadViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Thread_ThreadItemCompartmentViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Thread_subjectViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.TopicViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Topic_ThreadCompartmentViewFactory;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.Topic_nameViewFactory;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MindmapViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (MapEditPart.MODEL_ID.equals(diagramKind) && MindmapVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return MapViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		if (semanticAdapter.getAdapter(IElementType.class) != null && MindmapElementTypes.getElement(semanticAdapter) == null) {
			return null;
		}

		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = MindmapVisualIDRegistry.getNodeVisualID(containerView, semanticElement, semanticType, semanticHint);

		switch (nodeVID) {
		case TopicEditPart.VISUAL_ID:
			return TopicViewFactory.class;
		case Topic_nameEditPart.VISUAL_ID:
			return Topic_nameViewFactory.class;
		case ResourceEditPart.VISUAL_ID:
			return ResourceViewFactory.class;
		case Resource_name_emailEditPart.VISUAL_ID:
			return Resource_name_emailViewFactory.class;
		case ThreadEditPart.VISUAL_ID:
			return ThreadViewFactory.class;
		case Thread_subjectEditPart.VISUAL_ID:
			return Thread_subjectViewFactory.class;
		case ThreadItemEditPart.VISUAL_ID:
			return ThreadItemViewFactory.class;
		case Topic_ThreadCompartmentEditPart.VISUAL_ID:
			return Topic_ThreadCompartmentViewFactory.class;
		case Thread_ThreadItemCompartmentEditPart.VISUAL_ID:
			return Thread_ThreadItemCompartmentViewFactory.class;
		case Relationship_labelEditPart.VISUAL_ID:
			return Relationship_labelViewFactory.class;
		case Relationship_label2EditPart.VISUAL_ID:
			return Relationship_label2ViewFactory.class;
		case Relationship_label3EditPart.VISUAL_ID:
			return Relationship_label3ViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (semanticAdapter.getAdapter(IElementType.class) != null && MindmapElementTypes.getElement(semanticAdapter) == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (MindmapElementTypes.TopicSubtopics_3001.equals(elementType)) {
			return SubtopicsViewFactory.class;
		}

		EClass semanticType = getSemanticEClass(semanticAdapter);
		if (semanticType == null) {
			return null;
		}
		EObject semanticElement = getSemanticElement(semanticAdapter);

		int linkVID = MindmapVisualIDRegistry.getLinkWithClassVisualID(semanticElement, semanticType);

		switch (linkVID) {
		case RelationshipEditPart.VISUAL_ID:
			return RelationshipViewFactory.class;
		case Relationship2EditPart.VISUAL_ID:
			return Relationship2ViewFactory.class;
		case Relationship3EditPart.VISUAL_ID:
			return Relationship3ViewFactory.class;
		}
		return getUnrecognizedConnectorViewClass(semanticAdapter, containerView, semanticHint);
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
	private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		// Handle unrecognized child node classes here
		return null;
	}

}
