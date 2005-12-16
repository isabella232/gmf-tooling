/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.AquatoryViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.DestinationViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ItemViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.PortViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Port_locationViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Ship_CargoCompartmentViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Ship_nameViewFactory;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class TaiPanViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if ("TaiPan".equals(diagramKind) && TaiPanVisualIDRegistry.INSTANCE.getDiagramVisualID(semanticElement) != -1) { //$NON-NLS-1$
			return AquatoryViewFactory.class;
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
		if (!"TaiPan".equals(containerView.getDiagram().getType())) {
			return null;
		}

		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = TaiPanVisualIDRegistry.INSTANCE.getNodeVisualID(containerView, semanticElement, semanticType,
				semanticHint);

		switch (nodeVID) {
		case 1001:
			return PortViewFactory.class;
		case 4001:
			return Port_locationViewFactory.class;
		case 1002:
			return ShipViewFactory.class;
		case 4002:
			return Ship_nameViewFactory.class;
		case 5001:
			return Ship_CargoCompartmentViewFactory.class;
		case 2001:
			return ItemViewFactory.class;
		}
		return getUnrecognizedNodeViewClass(semanticAdapter, containerView, semanticHint);
	}

	/**
	 * @generated
	 */
	private Class getUnrecognizedNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		// Handle unrecognized node classes here
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = (IElementType) semanticAdapter.getAdapter(IElementType.class);
		if (TaiPanElementTypes.ShipDestination_3001.equals(elementType)) {
			return DestinationViewFactory.class;
		}

		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);

		int linkVID = TaiPanVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(semanticElement, semanticType);

		switch (linkVID) {
		}
		return getUnrecognizedConnectorViewClass(semanticAdapter, containerView, semanticHint);
	}

	/**
	 * @generated
	 */
	private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		// Handle unrecognized child node classes here
		return null;
	}

}
