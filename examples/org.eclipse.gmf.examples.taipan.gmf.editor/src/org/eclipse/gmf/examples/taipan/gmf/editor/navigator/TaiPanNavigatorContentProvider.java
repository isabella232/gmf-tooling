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
package org.eclipse.gmf.examples.taipan.gmf.editor.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EmptyBoxEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.RouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipDestinationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipLargeCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipSmallCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @generated
 */
public class TaiPanNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	public void dispose() {
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) GMFEditingDomainFactory.INSTANCE.createEditingDomain();
			editingDomain.setResourceToReadOnlyMap(new HashMap() {

				public Object get(Object key) {
					if (!containsKey(key)) {
						put(key, Boolean.TRUE);
					}
					return super.get(key);
				}
			});
			ResourceSet resourceSet = editingDomain.getResourceSet();

			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = resourceSet.getResource(fileURI, true);

			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), AquatoryEditPart.MODEL_ID), file));
			return result.toArray();
		}

		if (parentElement instanceof TaiPanNavigatorGroup) {
			TaiPanNavigatorGroup group = (TaiPanNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof TaiPanNavigatorItem) {
			TaiPanNavigatorItem navigatorItem = (TaiPanNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		// Due to plugin.xml content will be called only for "own" views
		if (parentElement instanceof IAdaptable) {
			View view = (View) ((IAdaptable) parentElement).getAdapter(View.class);
			if (view != null) {
				return getViewChildren(view, parentElement);
			}
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case PortEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			TaiPanNavigatorGroup incominglinks = new TaiPanNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getPort_2001ToShipDestination_4001InSource(view, incominglinks));
			incominglinks.addChildren(getPort_2001ToRoute_4002InSource(view, incominglinks));
			TaiPanNavigatorGroup outgoinglinks = new TaiPanNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			outgoinglinks.addChildren(getPort_2001ToRoute_4002OutTarget(view, outgoinglinks));
			incominglinks.addChildren(getPort_2001ToRoute_4003InSource(view, incominglinks));
			outgoinglinks.addChildren(getPort_2001ToRoute_4003OutTarget(view, outgoinglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}
		case ShipEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getShip_2002ToSmallItems_3001Children(view, parentElement));
			result.addAll(getShip_2002ToLargeItem_3002Children(view, parentElement));
			result.addAll(getShip_2002ToEmptyBox_3003Children(view, parentElement));
			TaiPanNavigatorGroup outgoinglinks = new TaiPanNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			outgoinglinks.addChildren(getShip_2002ToShipDestination_4001OutTarget(view, outgoinglinks));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}
		case AquatoryEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			result.addAll(getAquatory_1000ToPort_2001Children(view, parentElement));
			result.addAll(getAquatory_1000ToShip_2002Children(view, parentElement));
			TaiPanNavigatorGroup links = new TaiPanNavigatorGroup("links", "icons/linksNavigatorGroup.gif", parentElement);
			links.addChildren(getAquatory_1000ToShipDestination_4001Children(view, links));
			links.addChildren(getAquatory_1000ToRoute_4002Children(view, links));
			links.addChildren(getAquatory_1000ToRoute_4003Children(view, links));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}
		case ShipDestinationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			TaiPanNavigatorGroup target = new TaiPanNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", parentElement);
			target.addChildren(getShipDestination_4001ToPort_2001OutTarget((Edge) view, target));
			TaiPanNavigatorGroup source = new TaiPanNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			source.addChildren(getShipDestination_4001ToShip_2002InSource((Edge) view, source));
			if (!source.isEmpty()) {
				result.add(source);
			}
			if (!target.isEmpty()) {
				result.add(target);
			}
			return result.toArray();
		}
		case RouteEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			TaiPanNavigatorGroup target = new TaiPanNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", parentElement);
			target.addChildren(getRoute_4002ToPort_2001OutTarget((Edge) view, target));
			TaiPanNavigatorGroup source = new TaiPanNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			source.addChildren(getRoute_4002ToPort_2001InSource((Edge) view, source));
			if (!source.isEmpty()) {
				result.add(source);
			}
			if (!target.isEmpty()) {
				result.add(target);
			}
			return result.toArray();
		}
		case Route2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			TaiPanNavigatorGroup target = new TaiPanNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", parentElement);
			target.addChildren(getRoute_4003ToPort_2001OutTarget((Edge) view, target));
			TaiPanNavigatorGroup source = new TaiPanNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			source.addChildren(getRoute_4003ToPort_2001InSource((Edge) view, source));
			if (!source.isEmpty()) {
				result.add(source);
			}
			if (!target.isEmpty()) {
				result.add(target);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof TaiPanAbstractNavigatorItem) {
			TaiPanAbstractNavigatorItem abstractNavigatorItem = (TaiPanAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	private Collection getAquatory_1000ToShipDestination_4001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getDiagramLinksByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(ShipDestinationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isAquatory_1000ToShipDestination_4001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isAquatory_1000ToShipDestination_4001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getAquatory_1000ToRoute_4002Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getDiagramLinksByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(RouteEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isAquatory_1000ToRoute_4002ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isAquatory_1000ToRoute_4002ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getPort_2001ToRoute_4002InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(RouteEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isPort_2001ToRoute_4002InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isPort_2001ToRoute_4002InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getShip_2002ToShipDestination_4001OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(ShipDestinationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isShip_2002ToShipDestination_4001OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isShip_2002ToShipDestination_4001OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getPort_2001ToRoute_4002OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(RouteEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isPort_2001ToRoute_4002OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isPort_2001ToRoute_4002OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getShip_2002ToEmptyBox_3003Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(ShipLargeCargoEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, TaiPanVisualIDRegistry.getType(EmptyBoxEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isShip_2002ToEmptyBox_3003ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isShip_2002ToEmptyBox_3003ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getAquatory_1000ToPort_2001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isAquatory_1000ToPort_2001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isAquatory_1000ToPort_2001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getRoute_4002ToPort_2001InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isRoute_4002ToPort_2001InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isRoute_4002ToPort_2001InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getPort_2001ToRoute_4003OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(Route2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isPort_2001ToRoute_4003OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isPort_2001ToRoute_4003OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getShipDestination_4001ToShip_2002InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), TaiPanVisualIDRegistry.getType(ShipEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isShipDestination_4001ToShip_2002InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isShipDestination_4001ToShip_2002InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getPort_2001ToShipDestination_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(ShipDestinationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isPort_2001ToShipDestination_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isPort_2001ToShipDestination_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getRoute_4003ToPort_2001OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isRoute_4003ToPort_2001OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isRoute_4003ToPort_2001OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getRoute_4002ToPort_2001OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isRoute_4002ToPort_2001OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isRoute_4002ToPort_2001OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getShip_2002ToLargeItem_3002Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(ShipLargeCargoEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, TaiPanVisualIDRegistry.getType(LargeItemEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isShip_2002ToLargeItem_3002ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isShip_2002ToLargeItem_3002ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getShipDestination_4001ToPort_2001OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isShipDestination_4001ToPort_2001OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isShipDestination_4001ToPort_2001OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getPort_2001ToRoute_4003InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(Route2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isPort_2001ToRoute_4003InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isPort_2001ToRoute_4003InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getShip_2002ToSmallItems_3001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(ShipSmallCargoEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, TaiPanVisualIDRegistry.getType(SmallItemsEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isShip_2002ToSmallItems_3001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isShip_2002ToSmallItems_3001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getRoute_4003ToPort_2001InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isRoute_4003ToPort_2001InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isRoute_4003ToPort_2001InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getAquatory_1000ToRoute_4003Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getDiagramLinksByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(Route2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isAquatory_1000ToRoute_4003ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isAquatory_1000ToRoute_4003ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getAquatory_1000ToShip_2002Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), TaiPanVisualIDRegistry.getType(ShipEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isAquatory_1000ToShip_2002ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isAquatory_1000ToShip_2002ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && !isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getTarget();
			if (type.equals(nextEdgeSource.getType()) && !isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, String type) {
		Collection result = new ArrayList();
		for (Iterator it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram) it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent) {
		Collection result = new ArrayList();
		createNavigatorItems(views, parent, result, false);
		return result;
	}

	/**
	 * @generated
	 */
	private void createNavigatorItems(Collection views, Object parent, Collection result, boolean isLeafs) {
		for (Iterator it = views.iterator(); it.hasNext();) {
			result.add(new TaiPanNavigatorItem((View) it.next(), parent, isLeafs));
		}
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return AquatoryEditPart.MODEL_ID.equals(TaiPanVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection getForeignShortcuts(Diagram diagram, Object parent) {
		Collection result = new ArrayList();
		for (Iterator it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (!isOwnView(nextView) && nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent);
	}

}
