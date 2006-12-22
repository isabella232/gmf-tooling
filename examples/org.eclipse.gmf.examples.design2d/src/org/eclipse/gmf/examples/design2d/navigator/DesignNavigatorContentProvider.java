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
package org.eclipse.gmf.examples.design2d.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import org.eclipse.gmf.examples.design2d.edit.parts.Design2DEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidEllipse2EditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidEllipseEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidLineEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidRectangle2EditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidRectangleEditPart;

import org.eclipse.gmf.examples.design2d.part.DesignVisualIDRegistry;

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
public class DesignNavigatorContentProvider implements ICommonContentProvider {

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
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), Design2DEditPart.MODEL_ID), file));
			return result.toArray();
		}

		if (parentElement instanceof DesignNavigatorGroup) {
			DesignNavigatorGroup group = (DesignNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof DesignNavigatorItem) {
			DesignNavigatorItem navigatorItem = (DesignNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (DesignVisualIDRegistry.getVisualID(view)) {
		case SolidRectangleEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getNode_2001ToNode_3001Children(view, parentElement));
			result.addAll(getNode_2001ToNode_3002Children(view, parentElement));
			DesignNavigatorGroup incominglinks = new DesignNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getNode_2001ToLink_4001InSource(view, incominglinks));
			DesignNavigatorGroup outgoinglinks = new DesignNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			outgoinglinks.addChildren(getNode_2001ToLink_4001OutTarget(view, outgoinglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}
		case SolidEllipse2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getNode_2002ToNode_3001Children(view, parentElement));
			result.addAll(getNode_2002ToNode_3002Children(view, parentElement));
			DesignNavigatorGroup incominglinks = new DesignNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getNode_2002ToLink_4001InSource(view, incominglinks));
			DesignNavigatorGroup outgoinglinks = new DesignNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			outgoinglinks.addChildren(getNode_2002ToLink_4001OutTarget(view, outgoinglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}
		case SolidRectangle2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getNode_3001ToNode_3001Children(view, parentElement));
			result.addAll(getNode_3001ToNode_3002Children(view, parentElement));
			DesignNavigatorGroup incominglinks = new DesignNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getNode_3001ToLink_4001InSource(view, incominglinks));
			DesignNavigatorGroup outgoinglinks = new DesignNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			outgoinglinks.addChildren(getNode_3001ToLink_4001OutTarget(view, outgoinglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}
		case SolidEllipseEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getNode_3002ToNode_3001Children(view, parentElement));
			result.addAll(getNode_3002ToNode_3002Children(view, parentElement));
			DesignNavigatorGroup incominglinks = new DesignNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getNode_3002ToLink_4001InSource(view, incominglinks));
			DesignNavigatorGroup outgoinglinks = new DesignNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			outgoinglinks.addChildren(getNode_3002ToLink_4001OutTarget(view, outgoinglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}
		case Design2DEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getDiagram_1000ToNode_2001Children(view, parentElement));
			result.addAll(getDiagram_1000ToNode_2002Children(view, parentElement));
			DesignNavigatorGroup links = new DesignNavigatorGroup("links", "icons/linksNavigatorGroup.gif", parentElement);
			links.addChildren(getDiagram_1000ToLink_4001Children(view, links));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}
		case SolidLineEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			DesignNavigatorGroup target = new DesignNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", parentElement);
			target.addChildren(getLink_4001ToNode_2001OutTarget((Edge) view, target));
			target.addChildren(getLink_4001ToNode_2002OutTarget((Edge) view, target));
			target.addChildren(getLink_4001ToNode_3001OutTarget((Edge) view, target));
			target.addChildren(getLink_4001ToNode_3002OutTarget((Edge) view, target));
			DesignNavigatorGroup source = new DesignNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			source.addChildren(getLink_4001ToNode_2001InSource((Edge) view, source));
			source.addChildren(getLink_4001ToNode_2002InSource((Edge) view, source));
			source.addChildren(getLink_4001ToNode_3001InSource((Edge) view, source));
			source.addChildren(getLink_4001ToNode_3002InSource((Edge) view, source));
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
		if (element instanceof DesignAbstractNavigatorItem) {
			DesignAbstractNavigatorItem abstractNavigatorItem = (DesignAbstractNavigatorItem) element;
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
	private Collection getDiagram_1000ToLink_4001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getDiagramLinksByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidLineEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isDiagram_1000ToLink_4001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isDiagram_1000ToLink_4001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getDiagram_1000ToNode_2001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidRectangleEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isDiagram_1000ToNode_2001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isDiagram_1000ToNode_2001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getDiagram_1000ToNode_2002Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidEllipse2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isDiagram_1000ToNode_2002ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isDiagram_1000ToNode_2002ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getLink_4001ToNode_2001InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), DesignVisualIDRegistry.getType(SolidRectangleEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isLink_4001ToNode_2001InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isLink_4001ToNode_2001InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getLink_4001ToNode_2001OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), DesignVisualIDRegistry.getType(SolidRectangleEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isLink_4001ToNode_2001OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isLink_4001ToNode_2001OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getLink_4001ToNode_2002InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), DesignVisualIDRegistry.getType(SolidEllipse2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isLink_4001ToNode_2002InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isLink_4001ToNode_2002InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getLink_4001ToNode_2002OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), DesignVisualIDRegistry.getType(SolidEllipse2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isLink_4001ToNode_2002OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isLink_4001ToNode_2002OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getLink_4001ToNode_3001InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isLink_4001ToNode_3001InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isLink_4001ToNode_3001InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getLink_4001ToNode_3001OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isLink_4001ToNode_3001OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isLink_4001ToNode_3001OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getLink_4001ToNode_3002InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isLink_4001ToNode_3002InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isLink_4001ToNode_3002InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getLink_4001ToNode_3002OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isLink_4001ToNode_3002OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isLink_4001ToNode_3002OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getNode_2001ToLink_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidLineEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2001ToLink_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_2001ToLink_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getNode_2001ToLink_4001OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidLineEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2001ToLink_4001OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_2001ToLink_4001OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getNode_2001ToNode_3001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2001ToNode_3001ChildrenLeaf(view));
		connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2001ToNode_3001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_2001ToNode_3001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getNode_2001ToNode_3002Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2001ToNode_3002ChildrenLeaf(view));
		connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2001ToNode_3002ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_2001ToNode_3002ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getNode_2002ToLink_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidLineEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2002ToLink_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_2002ToLink_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getNode_2002ToLink_4001OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidLineEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2002ToLink_4001OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_2002ToLink_4001OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getNode_2002ToNode_3001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2002ToNode_3001ChildrenLeaf(view));
		connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2002ToNode_3001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_2002ToNode_3001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getNode_2002ToNode_3002Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2002ToNode_3002ChildrenLeaf(view));
		connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_2002ToNode_3002ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_2002ToNode_3002ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getNode_3001ToLink_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidLineEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_3001ToLink_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_3001ToLink_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getNode_3001ToLink_4001OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidLineEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_3001ToLink_4001OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_3001ToLink_4001OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getNode_3001ToNode_3001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_3001ToNode_3001ChildrenLeaf(view));
		connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_3001ToNode_3001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_3001ToNode_3001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getNode_3001ToNode_3002Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_3001ToNode_3002ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_3001ToNode_3002ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getNode_3002ToLink_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidLineEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_3002ToLink_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_3002ToLink_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getNode_3002ToLink_4001OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidLineEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_3002ToLink_4001OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_3002ToLink_4001OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getNode_3002ToNode_3001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_3002ToNode_3001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_3002ToNode_3001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getNode_3002ToNode_3002Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidRectangle2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_3002ToNode_3002ChildrenLeaf(view));
		connectedViews = getChildrenByType(Collections.singleton(view), DesignVisualIDRegistry.getType(SolidEllipseEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isNode_3002ToNode_3002ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isNode_3002ToNode_3002ChildrenLeaf(View view) {
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
			result.add(new DesignNavigatorItem((View) it.next(), parent, isLeafs));
		}
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return Design2DEditPart.MODEL_ID.equals(DesignVisualIDRegistry.getModelID(view));
	}

}
