/*
 *  Copyright (c) 2006, 2007 Borland Software Corporation
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *     Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.design2d.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.design2d.edit.parts.Design2DEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidEllipse2EditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidEllipseEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidLineCommentEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidLineEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidRectangle2EditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidRectangleEditPart;
import org.eclipse.gmf.examples.design2d.part.DesignVisualIDRegistry;
import org.eclipse.gmf.examples.design2d.view.factories.Design2DViewFactory;
import org.eclipse.gmf.examples.design2d.view.factories.SolidEllipse2ViewFactory;
import org.eclipse.gmf.examples.design2d.view.factories.SolidEllipseViewFactory;
import org.eclipse.gmf.examples.design2d.view.factories.SolidLineCommentViewFactory;
import org.eclipse.gmf.examples.design2d.view.factories.SolidLineViewFactory;
import org.eclipse.gmf.examples.design2d.view.factories.SolidRectangle2ViewFactory;
import org.eclipse.gmf.examples.design2d.view.factories.SolidRectangleViewFactory;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class DesignViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (Design2DEditPart.MODEL_ID.equals(diagramKind) && DesignVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return Design2DViewFactory.class;
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
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = DesignVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = DesignVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!DesignElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null && visualID != DesignVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present.
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!Design2DEditPart.MODEL_ID.equals(DesignVisualIDRegistry.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case SolidRectangleEditPart.VISUAL_ID:
				case SolidEllipse2EditPart.VISUAL_ID:
				case SolidRectangle2EditPart.VISUAL_ID:
				case SolidEllipseEditPart.VISUAL_ID:
					if (domainElement == null || visualID != DesignVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case SolidLineCommentEditPart.VISUAL_ID:
					if (SolidLineEditPart.VISUAL_ID != DesignVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null || !DesignVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case SolidRectangleEditPart.VISUAL_ID:
			return SolidRectangleViewFactory.class;
		case SolidEllipse2EditPart.VISUAL_ID:
			return SolidEllipse2ViewFactory.class;
		case SolidRectangle2EditPart.VISUAL_ID:
			return SolidRectangle2ViewFactory.class;
		case SolidEllipseEditPart.VISUAL_ID:
			return SolidEllipseViewFactory.class;
		case SolidLineCommentEditPart.VISUAL_ID:
			return SolidLineCommentViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!DesignElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = DesignVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null && visualID != DesignVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case SolidLineEditPart.VISUAL_ID:
			return SolidLineViewFactory.class;
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
