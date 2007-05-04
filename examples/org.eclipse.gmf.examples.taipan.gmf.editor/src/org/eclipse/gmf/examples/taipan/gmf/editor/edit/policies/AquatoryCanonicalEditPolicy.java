/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies;

import java.util.List;
import java.util.Collection;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.emf.ecore.EObject;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import java.util.Set;
import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.gef.EditPart;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.BesiegePortOrder;
import org.eclipse.gmf.examples.taipan.EscortShipsOrder;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;
import org.eclipse.gmf.examples.taipan.Warship;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.BesiegePortOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EmptyBoxEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EscortShipsOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortRegisterEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ReliableRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipDestinationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.UnreliableRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipEditPart;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanDiagramUpdater;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanNodeDescriptor;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AquatoryCanonicalEditPolicy extends CanonicalConnectionEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = TaiPanDiagramUpdater.getAquatory_1SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((TaiPanNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		TaiPanDiagramUpdater.isShortcutOrphaned(view);
		int visualID = TaiPanVisualIDRegistry.getVisualID(view);
		return TaiPanDiagramUpdater.isAquatory_1DomainMetaChild(visualID)
				&& (!semanticChildren.contains(view.getElement()) || visualID != TaiPanVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), view.getElement()));
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(TaiPanPackage.eINSTANCE.getAquatory_Ports());
			myFeaturesToSynchronize.add(TaiPanPackage.eINSTANCE.getAquatory_Ships());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * @generated
	 */
	protected List getSemanticConnectionsList() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	protected EObject getSourceElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject getTargetElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected boolean shouldIncludeConnection(Edge connector, Collection children) {
		return false;
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		List createdViews = new LinkedList();
		createdViews.addAll(refreshSemanticChildren());
		List createdConnectionViews = new LinkedList();
		createdConnectionViews.addAll(refreshSemanticConnections());
		createdConnectionViews.addAll(refreshConnections());

		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		createdViews.addAll(createdConnectionViews);
		makeViewsImmutable(createdViews);
	}

	/**
	 * @generated
	 */
	private Collection refreshConnections() {
		Map domain2NotationMap = new HashMap();
		Collection linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
			Edge nextDiagramLink = (Edge) linksIterator.next();
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			int diagramLinkVisualID = TaiPanVisualIDRegistry.getVisualID(nextDiagramLink);
			for (Iterator LinkDescriptorsIterator = linkDescriptors.iterator(); LinkDescriptorsIterator.hasNext();) {
				LinkDescriptor nextLinkDescriptor = (LinkDescriptor) LinkDescriptorsIterator.next();
				if (diagramLinkObject == nextLinkDescriptor.getLinkElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination()
						&& diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
					linksIterator.remove();
					LinkDescriptorsIterator.remove();
				}
			}
		}
		deleteViews(existingLinks.iterator());
		return createConnections(linkDescriptors, domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private Collection collectAllLinks(View view, Map domain2NotationMap) {
		Collection result = new LinkedList();
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case PortEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			Port modelElement = (Port) view.getElement();
			result.addAll(getContainedFeatureModelFacetLinks_Port_Register_4007(modelElement));
			break;
		}
		case ShipEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			Ship modelElement = (Ship) view.getElement();
			result.addAll(getContainedFeatureModelFacetLinks_Ship_Destination_4001(modelElement));
			break;
		}
		case WarshipEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			Warship modelElement = (Warship) view.getElement();
			result.addAll(getContainedFeatureModelFacetLinks_Ship_Destination_4001(modelElement));
			result.addAll(getContainedTypeModelFacetLinks_EscortShipsOrder_4006(modelElement));
			result.addAll(getContainedTypeModelFacetLinks_BesiegePortOrder_4005(modelElement));
			break;
		}
		case SmallItemsEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case LargeItemEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case EmptyBoxEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case ReliableRouteEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case UnreliableRouteEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case EscortShipsOrderEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case BesiegePortOrderEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		}
		for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
			result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
		}
		for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
			result.addAll(collectAllLinks((View) edges.next(), domain2NotationMap));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getContainedFeatureModelFacetLinks_Ship_Destination_4001(Ship container) {
		Collection result = new LinkedList();
		Port destination = container.getDestination();
		result.add(new LinkDescriptor(container, destination, TaiPanElementTypes.ShipDestination_4001, ShipDestinationEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getContainedTypeModelFacetLinks_EscortShipsOrder_4006(Warship container) {
		Collection result = new LinkedList();
		EscortShipsOrder link = (EscortShipsOrder) container.getEscortOrder();
		int linkVID = TaiPanVisualIDRegistry.getLinkWithClassVisualID(link);
		if (linkVID == EscortShipsOrderEditPart.VISUAL_ID) {
			List targets = link.getShips();
			Object target = targets.size() == 1 ? targets.get(0) : null;
			if (target instanceof Ship) {
				Ship dst = (Ship) target;
				result.add(new LinkDescriptor(container, dst, link, TaiPanElementTypes.EscortShipsOrder_4006, linkVID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getContainedTypeModelFacetLinks_BesiegePortOrder_4005(Warship container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getAttackOrders().iterator(); links.hasNext();) {
			BesiegePortOrder link = (BesiegePortOrder) links.next();
			int linkVID = TaiPanVisualIDRegistry.getLinkWithClassVisualID(link);
			if (linkVID == BesiegePortOrderEditPart.VISUAL_ID) {
				Port dst = link.getPort();
				result.add(new LinkDescriptor(container, dst, link, TaiPanElementTypes.BesiegePortOrder_4005, linkVID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getContainedFeatureModelFacetLinks_Port_Register_4007(Port container) {
		Collection result = new LinkedList();
		for (Iterator destinations = container.getRegister().iterator(); destinations.hasNext();) {
			Ship destination = (Ship) destinations.next();
			result.add(new LinkDescriptor(container, destination, TaiPanElementTypes.PortRegister_4007, PortRegisterEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection createConnections(Collection linkDescriptors, Map domain2NotationMap) {
		List adapters = new LinkedList();
		for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
			final LinkDescriptor nextLinkDescriptor = (LinkDescriptor) linkDescriptorsIterator.next();
			EditPart sourceEditPart = getEditPart(nextLinkDescriptor.getSource(), domain2NotationMap);
			EditPart targetEditPart = getEditPart(nextLinkDescriptor.getDestination(), domain2NotationMap);
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), null, ViewUtil.APPEND,
					false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if (cmd != null && cmd.canExecute()) {
				executeCommand(cmd);
				IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
				if (viewAdapter != null) {
					adapters.add(viewAdapter);
				}
			}
		}
		return adapters;
	}

	/**
	 * @generated
	 */
	private EditPart getEditPart(EObject domainModelElement, Map domain2NotationMap) {
		View view = (View) domain2NotationMap.get(domainModelElement);
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private Diagram getDiagram() {
		return ((View) getHost().getModel()).getDiagram();
	}

	/**
	 * @generated
	 */
	private class LinkDescriptor {

		/**
		 * @generated
		 */
		private EObject mySource;

		/**
		 * @generated
		 */
		private EObject myDestination;

		/**
		 * @generated
		 */
		private EObject myLinkElement;

		/**
		 * @generated
		 */
		private int myVisualID;

		/**
		 * @generated
		 */
		private IAdaptable mySemanticAdapter;

		/**
		 * @generated
		 */
		protected LinkDescriptor(EObject source, EObject destination, EObject linkElement, IElementType elementType, int linkVID) {
			this(source, destination, linkVID);
			final IElementType elementTypeCopy = elementType;
			myLinkElement = linkElement;
			mySemanticAdapter = new EObjectAdapter(linkElement) {

				public Object getAdapter(Class adapter) {
					if (IElementType.class.equals(adapter)) {
						return elementTypeCopy;
					}
					return super.getAdapter(adapter);
				}
			};
		}

		/**
		 * @generated
		 */
		protected LinkDescriptor(EObject source, EObject destination, IElementType elementType, int linkVID) {
			this(source, destination, linkVID);
			final IElementType elementTypeCopy = elementType;
			myLinkElement = null;
			mySemanticAdapter = new IAdaptable() {

				public Object getAdapter(Class adapter) {
					if (IElementType.class.equals(adapter)) {
						return elementTypeCopy;
					}
					return null;
				}
			};
		}

		/**
		 * @generated
		 */
		private LinkDescriptor(EObject source, EObject destination, int linkVID) {
			mySource = source;
			myDestination = destination;
			myVisualID = linkVID;
		}

		/**
		 * @generated
		 */
		protected EObject getSource() {
			return mySource;
		}

		/**
		 * @generated
		 */
		protected EObject getDestination() {
			return myDestination;
		}

		/**
		 * @generated
		 */
		protected EObject getLinkElement() {
			return myLinkElement;
		}

		/**
		 * @generated
		 */
		protected int getVisualID() {
			return myVisualID;
		}

		/**
		 * @generated
		 */
		protected IAdaptable getSemanticAdapter() {
			return mySemanticAdapter;
		}
	}

}
