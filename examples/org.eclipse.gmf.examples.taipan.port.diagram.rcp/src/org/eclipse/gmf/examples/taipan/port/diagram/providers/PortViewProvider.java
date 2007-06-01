/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.port.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.BuildingEditPart;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.BuildingInfoEditPart;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.PortEditPart;

import org.eclipse.gmf.examples.taipan.port.diagram.part.PortVisualIDRegistry;

import org.eclipse.gmf.examples.taipan.port.diagram.view.factories.BuildingInfoViewFactory;
import org.eclipse.gmf.examples.taipan.port.diagram.view.factories.BuildingViewFactory;
import org.eclipse.gmf.examples.taipan.port.diagram.view.factories.PortViewFactory;

/**
 * @generated
 */
public class PortViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (PortEditPart.MODEL_ID.equals(diagramKind) && PortVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return PortViewFactory.class;
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
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = PortVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = PortVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				if (!PortElementTypes.isKnownElementType(elementType) || false == elementType instanceof IHintedType) {
					return null;
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null;
				}
				if (domainElement != null && visualID != PortVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
					return null;
				}
			} else {
				switch (visualID) {
				case PortEditPart.VISUAL_ID:
				case BuildingEditPart.VISUAL_ID:
					return null;
				}
			}
		}
		if (!PortVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case BuildingEditPart.VISUAL_ID:
			return BuildingViewFactory.class;
		case BuildingInfoEditPart.VISUAL_ID:
			return BuildingInfoViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType == null) {
			return null;
		}
		if (!PortElementTypes.isKnownElementType(elementType) || false == elementType instanceof IHintedType) {
			return null;
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null;
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null;
		}
		int visualID = PortVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null && visualID != PortVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return null;
		}
		switch (visualID) {
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
