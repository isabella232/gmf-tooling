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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EmptyBoxEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.RouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipDestinationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;

import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
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
		if (parentElement instanceof TaiPanAbstractNavigatorItem) {
			TaiPanAbstractNavigatorItem abstractNavigatorItem = (TaiPanAbstractNavigatorItem) parentElement;
			if (!AquatoryEditPart.MODEL_ID.equals(abstractNavigatorItem.getModelID())) {
				return EMPTY_ARRAY;
			}

			if (abstractNavigatorItem instanceof TaiPanNavigatorItem) {
				TaiPanNavigatorItem navigatorItem = (TaiPanNavigatorItem) abstractNavigatorItem;
				switch (navigatorItem.getVisualID()) {
				case PortEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					TaiPanNavigatorGroup incominglinks = new TaiPanNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", AquatoryEditPart.MODEL_ID, navigatorItem.getView());
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(ShipDestinationEditPart.VISUAL_ID), false));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(RouteEditPart.VISUAL_ID), false));
					TaiPanNavigatorGroup outgoinglinks = new TaiPanNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", AquatoryEditPart.MODEL_ID, navigatorItem.getView());
					outgoinglinks.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(RouteEditPart.VISUAL_ID), true));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(Route2EditPart.VISUAL_ID), false));
					outgoinglinks.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(Route2EditPart.VISUAL_ID), true));
					if (!outgoinglinks.isEmpty()) {
						result.add(outgoinglinks);
					}
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case ShipEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), TaiPanVisualIDRegistry.getType(SmallItemsEditPart.VISUAL_ID)));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), TaiPanVisualIDRegistry.getType(LargeItemEditPart.VISUAL_ID)));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), TaiPanVisualIDRegistry.getType(EmptyBoxEditPart.VISUAL_ID)));
					TaiPanNavigatorGroup outgoinglinks = new TaiPanNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", AquatoryEditPart.MODEL_ID, navigatorItem.getView());
					outgoinglinks.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(ShipDestinationEditPart.VISUAL_ID), true));
					if (!outgoinglinks.isEmpty()) {
						result.add(outgoinglinks);
					}
					return result.toArray();
				}
				case AquatoryEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID)));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), TaiPanVisualIDRegistry.getType(ShipEditPart.VISUAL_ID)));
					TaiPanNavigatorGroup links = new TaiPanNavigatorGroup("links", "icons/linksNavigatorGroup.gif", AquatoryEditPart.MODEL_ID, navigatorItem.getView());
					links.addChildren(getViewByType(navigatorItem.getView().getDiagram().getEdges(), TaiPanVisualIDRegistry.getType(ShipDestinationEditPart.VISUAL_ID)));
					links.addChildren(getViewByType(navigatorItem.getView().getDiagram().getEdges(), TaiPanVisualIDRegistry.getType(RouteEditPart.VISUAL_ID)));
					links.addChildren(getViewByType(navigatorItem.getView().getDiagram().getEdges(), TaiPanVisualIDRegistry.getType(Route2EditPart.VISUAL_ID)));
					if (!links.isEmpty()) {
						result.add(links);
					}
					return result.toArray();
				}
				case ShipDestinationEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					TaiPanNavigatorGroup target = new TaiPanNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", AquatoryEditPart.MODEL_ID, navigatorItem.getView());
					target.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID), true));
					TaiPanNavigatorGroup source = new TaiPanNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", AquatoryEditPart.MODEL_ID, navigatorItem.getView());
					source.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(ShipEditPart.VISUAL_ID), false));
					if (!target.isEmpty()) {
						result.add(target);
					}
					if (!source.isEmpty()) {
						result.add(source);
					}
					return result.toArray();
				}
				case RouteEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					TaiPanNavigatorGroup target = new TaiPanNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", AquatoryEditPart.MODEL_ID, navigatorItem.getView());
					target.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID), true));
					TaiPanNavigatorGroup source = new TaiPanNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", AquatoryEditPart.MODEL_ID, navigatorItem.getView());
					source.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID), false));
					if (!target.isEmpty()) {
						result.add(target);
					}
					if (!source.isEmpty()) {
						result.add(source);
					}
					return result.toArray();
				}
				case Route2EditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					TaiPanNavigatorGroup target = new TaiPanNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", AquatoryEditPart.MODEL_ID, navigatorItem.getView());
					target.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID), true));
					TaiPanNavigatorGroup source = new TaiPanNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", AquatoryEditPart.MODEL_ID, navigatorItem.getView());
					source.addChildren(getConnectedViews(navigatorItem.getView(), TaiPanVisualIDRegistry.getType(PortEditPart.VISUAL_ID), false));
					if (!target.isEmpty()) {
						result.add(target);
					}
					if (!source.isEmpty()) {
						result.add(source);
					}
					return result.toArray();
				}
				}
			} else if (abstractNavigatorItem instanceof TaiPanNavigatorGroup) {
				TaiPanNavigatorGroup group = (TaiPanNavigatorGroup) parentElement;
				return group.getChildren();
			}
		} else if (parentElement instanceof IFile) {
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

			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString());
			Resource resource = resourceSet.getResource(fileURI, true);

			Collection result = new ArrayList();
			result.addAll(getViewByType(resource.getContents(), AquatoryEditPart.MODEL_ID));
			return result.toArray();
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof TaiPanAbstractNavigatorItem) {
			TaiPanAbstractNavigatorItem abstractNavigatorItem = (TaiPanAbstractNavigatorItem) element;
			if (!AquatoryEditPart.MODEL_ID.equals(abstractNavigatorItem.getModelID())) {
				return null;
			}

			if (abstractNavigatorItem instanceof TaiPanNavigatorItem) {
				TaiPanNavigatorItem navigatorItem = (TaiPanNavigatorItem) abstractNavigatorItem;
				switch (navigatorItem.getVisualID()) {
				case PortEditPart.VISUAL_ID: {
					return navigatorItem.getView().eContainer();
				}
				case ShipEditPart.VISUAL_ID: {
					return navigatorItem.getView().eContainer();
				}
				case SmallItemsEditPart.VISUAL_ID: {
					return navigatorItem.getView().eContainer();
				}
				case LargeItemEditPart.VISUAL_ID: {
					return navigatorItem.getView().eContainer();
				}
				case EmptyBoxEditPart.VISUAL_ID: {
					return navigatorItem.getView().eContainer();
				}
				case AquatoryEditPart.VISUAL_ID: {
					return WorkspaceSynchronizer.getFile(navigatorItem.getView().eResource());
				}
				}
			} else if (abstractNavigatorItem instanceof TaiPanNavigatorGroup) {
				TaiPanNavigatorGroup group = (TaiPanNavigatorGroup) abstractNavigatorItem;
				return group.getParent();
			}
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
	private Collection getViewByType(Collection childViews, String type) {
		Collection result = new ArrayList();
		for (Iterator it = childViews.iterator(); it.hasNext();) {
			Object next = it.next();
			if (false == next instanceof View) {
				continue;
			}
			View nextView = (View) next;
			if (type.equals(nextView.getType())) {
				result.add(new TaiPanNavigatorItem(nextView));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildByType(Collection childViews, String type) {
		Collection result = new ArrayList();
		List children = new ArrayList(childViews);
		for (int i = 0; i < children.size(); i++) {
			if (false == children.get(i) instanceof View) {
				continue;
			}
			View nextChild = (View) children.get(i);
			if (type.equals(nextChild.getType())) {
				result.add(new TaiPanNavigatorItem(nextChild));
			} else if (!stopGettingChildren(nextChild, type)) {
				children.addAll(nextChild.getChildren());
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean stopGettingChildren(View child, String type) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getConnectedViews(View rootView, String type, boolean isOutTarget) {
		Collection result = new ArrayList();
		List connectedViews = new ArrayList();
		connectedViews.add(rootView);
		Set visitedViews = new HashSet();
		for (int i = 0; i < connectedViews.size(); i++) {
			View nextView = (View) connectedViews.get(i);
			if (visitedViews.contains(nextView)) {
				continue;
			}
			visitedViews.add(nextView);
			if (type.equals(nextView.getType()) && nextView != rootView) {
				result.add(new TaiPanNavigatorItem(nextView));
			} else {
				if (isOutTarget && !stopGettingOutTarget(nextView, rootView, type)) {
					connectedViews.addAll(nextView.getSourceEdges());
					if (nextView instanceof Edge) {
						connectedViews.add(((Edge) nextView).getTarget());
					}
				}
				if (!isOutTarget && !stopGettingInSource(nextView, rootView, type)) {
					connectedViews.addAll(nextView.getTargetEdges());
					if (nextView instanceof Edge) {
						connectedViews.add(((Edge) nextView).getSource());
					}
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean stopGettingInSource(View nextView, View rootView, String type) {
		return !isOneHopConnection(nextView, rootView);
	}

	/**
	 * @generated
	 */
	private boolean stopGettingOutTarget(View nextView, View rootView, String type) {
		return !isOneHopConnection(nextView, rootView);
	}

	/**
	 * @generated
	 */
	private boolean isOneHopConnection(View targetView, View sourceView) {
		if (sourceView == targetView) {
			return true;
		}
		if (sourceView instanceof Node) {
			return targetView instanceof Edge;
		}
		if (sourceView instanceof Edge) {
			return targetView instanceof Node;
		}
		return false;
	}

}
