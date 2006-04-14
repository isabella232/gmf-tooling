package org.eclipse.gmf.graphdef.gmfEditor.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.CanvasEditPart;

import org.eclipse.gmf.graphdef.gmfEditor.part.GMFGraphVisualIDRegistry;

import org.eclipse.gmf.graphdef.gmfEditor.view.factories.CanvasViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.CompartmentViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.Compartment_VisualFacetsViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.Compartment_nameViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.Connection_VisualFacetsViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.Connection_nameViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.Ellipse2ViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.EllipseViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.FigureGalleryViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.FigureGallery_FiguresViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.FigureGallery_nameViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.FigureViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.NodeViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.Node_VisualFacetsViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.Node_nameViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.Polyline2ViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.PolylineViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.Rectangle2ViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.RectangleViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.RoundedRectangle2ViewFactory;
import org.eclipse.gmf.graphdef.gmfEditor.view.factories.RoundedRectangleViewFactory;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class GMFGraphViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (CanvasEditPart.MODEL_ID.equals(diagramKind) && GMFGraphVisualIDRegistry.INSTANCE.getDiagramVisualID(semanticElement) != -1) {
			return CanvasViewFactory.class;
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

		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = GMFGraphVisualIDRegistry.INSTANCE.getNodeVisualID(containerView, semanticElement, semanticType, semanticHint);

		switch (nodeVID) {
		case 1001:
			return CompartmentViewFactory.class;
		case 4001:
			return Compartment_nameViewFactory.class;
		case 1002:
			return NodeViewFactory.class;
		case 4002:
			return Node_nameViewFactory.class;
		case 1003:
			return ConnectionViewFactory.class;
		case 4003:
			return Connection_nameViewFactory.class;
		case 1004:
			return FigureGalleryViewFactory.class;
		case 4004:
			return FigureGallery_nameViewFactory.class;
		case 2001:
			return RectangleViewFactory.class;
		case 2002:
			return Rectangle2ViewFactory.class;
		case 2003:
			return EllipseViewFactory.class;
		case 2004:
			return RoundedRectangleViewFactory.class;
		case 2005:
			return PolylineViewFactory.class;
		case 2006:
			return Ellipse2ViewFactory.class;
		case 2007:
			return RoundedRectangle2ViewFactory.class;
		case 2008:
			return Polyline2ViewFactory.class;
		case 5001:
			return Compartment_VisualFacetsViewFactory.class;
		case 5002:
			return Node_VisualFacetsViewFactory.class;
		case 5003:
			return Connection_VisualFacetsViewFactory.class;
		case 5004:
			return FigureGallery_FiguresViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (GMFGraphElementTypes.DiagramElementFigure_3001.equals(elementType)) {
			return FigureViewFactory.class;
		}

		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);

		int linkVID = GMFGraphVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(semanticElement, semanticType);

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
