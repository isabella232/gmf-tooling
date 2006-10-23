package org.eclipse.gmf.examples.mindmap.diagram.navigator;

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

import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicSubtopicsEditPart;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;

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
public class MindmapNavigatorContentProvider implements ICommonContentProvider {

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
		if (parentElement instanceof MindmapAbstractNavigatorItem) {
			MindmapAbstractNavigatorItem abstractNavigatorItem = (MindmapAbstractNavigatorItem) parentElement;
			if (!MapEditPart.MODEL_ID
					.equals(abstractNavigatorItem.getModelID())) {
				return EMPTY_ARRAY;
			}

			if (abstractNavigatorItem instanceof MindmapNavigatorItem) {
				MindmapNavigatorItem navigatorItem = (MindmapNavigatorItem) abstractNavigatorItem;
				switch (navigatorItem.getVisualID()) {
				case TopicEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getChildByType(navigatorItem.getView()
							.getChildren(), MindmapVisualIDRegistry
							.getType(ThreadEditPart.VISUAL_ID), navigatorItem));
					MindmapNavigatorGroup incominglinks = new MindmapNavigatorGroup(
							"incoming links",
							"icons/incomingLinksNavigatorGroup.gif",
							MapEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(TopicSubtopicsEditPart.VISUAL_ID), false,
							incominglinks));
					MindmapNavigatorGroup outgoinglinks = new MindmapNavigatorGroup(
							"outgoing links",
							"icons/outgoingLinksNavigatorGroup.gif",
							MapEditPart.MODEL_ID, navigatorItem);
					outgoinglinks.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(TopicSubtopicsEditPart.VISUAL_ID), true,
							outgoinglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(RelationshipEditPart.VISUAL_ID), false,
							incominglinks));
					outgoinglinks.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(RelationshipEditPart.VISUAL_ID), true,
							outgoinglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(Relationship2EditPart.VISUAL_ID), false,
							incominglinks));
					outgoinglinks.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(Relationship2EditPart.VISUAL_ID), true,
							outgoinglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(Relationship3EditPart.VISUAL_ID), false,
							incominglinks));
					outgoinglinks.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(Relationship3EditPart.VISUAL_ID), true,
							outgoinglinks));
					if (!outgoinglinks.isEmpty()) {
						result.add(outgoinglinks);
					}
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case ThreadEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getChildByType(navigatorItem.getView()
							.getChildren(), MindmapVisualIDRegistry
							.getType(ThreadItemEditPart.VISUAL_ID),
							navigatorItem));
					return result.toArray();
				}
				case MapEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getChildByType(navigatorItem.getView()
							.getChildren(), MindmapVisualIDRegistry
							.getType(TopicEditPart.VISUAL_ID), navigatorItem));
					result
							.addAll(getChildByType(navigatorItem.getView()
									.getChildren(), MindmapVisualIDRegistry
									.getType(ResourceEditPart.VISUAL_ID),
									navigatorItem));
					MindmapNavigatorGroup links = new MindmapNavigatorGroup(
							"links", "icons/linksNavigatorGroup.gif",
							MapEditPart.MODEL_ID, navigatorItem);
					links.addChildren(getViewByType(navigatorItem.getView()
							.getDiagram().getEdges(), MindmapVisualIDRegistry
							.getType(TopicSubtopicsEditPart.VISUAL_ID), links));
					links.addChildren(getViewByType(navigatorItem.getView()
							.getDiagram().getEdges(), MindmapVisualIDRegistry
							.getType(RelationshipEditPart.VISUAL_ID), links));
					links.addChildren(getViewByType(navigatorItem.getView()
							.getDiagram().getEdges(), MindmapVisualIDRegistry
							.getType(Relationship2EditPart.VISUAL_ID), links));
					links.addChildren(getViewByType(navigatorItem.getView()
							.getDiagram().getEdges(), MindmapVisualIDRegistry
							.getType(Relationship3EditPart.VISUAL_ID), links));
					if (!links.isEmpty()) {
						result.add(links);
					}
					return result.toArray();
				}
				case TopicSubtopicsEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					MindmapNavigatorGroup target = new MindmapNavigatorGroup(
							"target", "icons/linkTargetNavigatorGroup.gif",
							MapEditPart.MODEL_ID, navigatorItem);
					target.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(TopicEditPart.VISUAL_ID), true, target));
					MindmapNavigatorGroup source = new MindmapNavigatorGroup(
							"source", "icons/linkSourceNavigatorGroup.gif",
							MapEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(TopicEditPart.VISUAL_ID), false, source));
					if (!target.isEmpty()) {
						result.add(target);
					}
					if (!source.isEmpty()) {
						result.add(source);
					}
					return result.toArray();
				}
				case RelationshipEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					MindmapNavigatorGroup target = new MindmapNavigatorGroup(
							"target", "icons/linkTargetNavigatorGroup.gif",
							MapEditPart.MODEL_ID, navigatorItem);
					target.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(TopicEditPart.VISUAL_ID), true, target));
					MindmapNavigatorGroup source = new MindmapNavigatorGroup(
							"source", "icons/linkSourceNavigatorGroup.gif",
							MapEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(TopicEditPart.VISUAL_ID), false, source));
					if (!target.isEmpty()) {
						result.add(target);
					}
					if (!source.isEmpty()) {
						result.add(source);
					}
					return result.toArray();
				}
				case Relationship2EditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					MindmapNavigatorGroup target = new MindmapNavigatorGroup(
							"target", "icons/linkTargetNavigatorGroup.gif",
							MapEditPart.MODEL_ID, navigatorItem);
					target.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(TopicEditPart.VISUAL_ID), true, target));
					MindmapNavigatorGroup source = new MindmapNavigatorGroup(
							"source", "icons/linkSourceNavigatorGroup.gif",
							MapEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(TopicEditPart.VISUAL_ID), false, source));
					if (!target.isEmpty()) {
						result.add(target);
					}
					if (!source.isEmpty()) {
						result.add(source);
					}
					return result.toArray();
				}
				case Relationship3EditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					MindmapNavigatorGroup target = new MindmapNavigatorGroup(
							"target", "icons/linkTargetNavigatorGroup.gif",
							MapEditPart.MODEL_ID, navigatorItem);
					target.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(TopicEditPart.VISUAL_ID), true, target));
					MindmapNavigatorGroup source = new MindmapNavigatorGroup(
							"source", "icons/linkSourceNavigatorGroup.gif",
							MapEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getConnectedViews(navigatorItem
							.getView(), MindmapVisualIDRegistry
							.getType(TopicEditPart.VISUAL_ID), false, source));
					if (!target.isEmpty()) {
						result.add(target);
					}
					if (!source.isEmpty()) {
						result.add(source);
					}
					return result.toArray();
				}
				}
			} else if (abstractNavigatorItem instanceof MindmapNavigatorGroup) {
				MindmapNavigatorGroup group = (MindmapNavigatorGroup) parentElement;
				return group.getChildren();
			}
		} else if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) GMFEditingDomainFactory.INSTANCE
					.createEditingDomain();
			editingDomain.setResourceToReadOnlyMap(new HashMap() {
				public Object get(Object key) {
					if (!containsKey(key)) {
						put(key, Boolean.TRUE);
					}
					return super.get(key);
				}
			});
			ResourceSet resourceSet = editingDomain.getResourceSet();

			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString());
			Resource resource = resourceSet.getResource(fileURI, true);

			Collection result = new ArrayList();
			result.addAll(getViewByType(resource.getContents(),
					MapEditPart.MODEL_ID, file));
			return result.toArray();
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof MindmapAbstractNavigatorItem) {
			MindmapAbstractNavigatorItem abstractNavigatorItem = (MindmapAbstractNavigatorItem) element;
			if (!MapEditPart.MODEL_ID
					.equals(abstractNavigatorItem.getModelID())) {
				return null;
			}
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
	private Collection getViewByType(Collection childViews, String type,
			Object parent) {
		Collection result = new ArrayList();
		for (Iterator it = childViews.iterator(); it.hasNext();) {
			Object next = it.next();
			if (false == next instanceof View) {
				continue;
			}
			View nextView = (View) next;
			if (type.equals(nextView.getType())) {
				result.add(new MindmapNavigatorItem(nextView, parent));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildByType(Collection childViews, String type,
			Object parent) {
		Collection result = new ArrayList();
		List children = new ArrayList(childViews);
		for (int i = 0; i < children.size(); i++) {
			if (false == children.get(i) instanceof View) {
				continue;
			}
			View nextChild = (View) children.get(i);
			if (type.equals(nextChild.getType())) {
				result.add(new MindmapNavigatorItem(nextChild, parent));
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
	private Collection getConnectedViews(View rootView, String type,
			boolean isOutTarget, Object parent) {
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
				result.add(new MindmapNavigatorItem(nextView, parent));
			} else {
				if (isOutTarget
						&& !stopGettingOutTarget(nextView, rootView, type)) {
					connectedViews.addAll(nextView.getSourceEdges());
					if (nextView instanceof Edge) {
						connectedViews.add(((Edge) nextView).getTarget());
					}
				}
				if (!isOutTarget
						&& !stopGettingInSource(nextView, rootView, type)) {
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
	private boolean stopGettingInSource(View nextView, View rootView,
			String type) {
		return !isOneHopConnection(nextView, rootView);
	}

	/**
	 * @generated
	 */
	private boolean stopGettingOutTarget(View nextView, View rootView,
			String type) {
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
