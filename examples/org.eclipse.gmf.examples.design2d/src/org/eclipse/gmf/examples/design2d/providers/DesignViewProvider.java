/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.design2d.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.design2d.edit.parts.Design2DEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidEllipse2EditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidEllipseEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidLineCommentEditPart;
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
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class DesignViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		if (Design2DEditPart.MODEL_ID.equals(diagramKind)) {
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
		if (elementType != null && !DesignElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = DesignVisualIDRegistry.getNodeVisualID(containerView, semanticElement, semanticType, semanticHint);
		switch (nodeVID) {
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
		if (elementType != null && !DesignElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		if (DesignElementTypes.Link_4001.equals(elementType)) {
			return SolidLineViewFactory.class;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		if (semanticType == null) {
			return null;
		}
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int linkVID = DesignVisualIDRegistry.getLinkWithClassVisualID(semanticElement, semanticType);
		switch (linkVID) {
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
