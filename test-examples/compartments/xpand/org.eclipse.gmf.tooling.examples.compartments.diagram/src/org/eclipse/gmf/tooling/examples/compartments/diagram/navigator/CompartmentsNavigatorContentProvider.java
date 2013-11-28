package org.eclipse.gmf.tooling.examples.compartments.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_CEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_DEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfAffixedEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_ECNodeRelationEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_EEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FDNodeRelationEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GAffixedChildrenCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeAEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeANodeCCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeANodeDCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBNodeECompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBNodeFCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry;
import org.eclipse.gmf.tooling.examples.compartments.diagram.part.Messages;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @generated
 */
public class CompartmentsNavigatorContentProvider implements ICommonContentProvider {

	/**
	* @generated
	*/
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	* @generated
	*/
	private Viewer myViewer;

	/**
	* @generated
	*/
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	* @generated
	*/
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	* @generated
	*/
	private Runnable myViewerRefreshRunnable;

	/**
	* @generated
	*/
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public CompartmentsNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {

			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {

			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {

			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}
		});
	}

	/**
	* @generated
	*/
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	* @generated
	*/
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	* @generated
	*/
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet().getResources()) {
			nextResource.unload();
		}
	}

	/**
	* @generated
	*/
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
		}
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
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			ArrayList<CompartmentsNavigatorItem> result = new ArrayList<CompartmentsNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(selectViewsByType(topViews, CanvasEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof CompartmentsNavigatorGroup) {
			CompartmentsNavigatorGroup group = (CompartmentsNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof CompartmentsNavigatorItem) {
			CompartmentsNavigatorItem navigatorItem = (CompartmentsNavigatorItem) parentElement;
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
		switch (CompartmentsVisualIDRegistry.getVisualID(view)) {

		case CanvasEditPart.VISUAL_ID: {
			LinkedList<CompartmentsAbstractNavigatorItem> result = new LinkedList<CompartmentsAbstractNavigatorItem>();
			Diagram sv = (Diagram) view;
			CompartmentsNavigatorGroup links = new CompartmentsNavigatorGroup(Messages.NavigatorGroupName_Canvas_1000_links, "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(TopNodeAEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(TopNodeBEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfB_ECNodeRelationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfB_FDNodeRelationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case TopNodeAEditPart.VISUAL_ID: {
			LinkedList<CompartmentsAbstractNavigatorItem> result = new LinkedList<CompartmentsAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(TopNodeANodeCCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, CompartmentsVisualIDRegistry.getType(ChildOfA_CEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(TopNodeANodeDCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, CompartmentsVisualIDRegistry.getType(ChildOfA_DEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case TopNodeBEditPart.VISUAL_ID: {
			LinkedList<CompartmentsAbstractNavigatorItem> result = new LinkedList<CompartmentsAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(TopNodeBNodeECompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, CompartmentsVisualIDRegistry.getType(ChildOfB_EEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfB_GEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(TopNodeBNodeFCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, CompartmentsVisualIDRegistry.getType(ChildOfB_FEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ChildOfA_CEditPart.VISUAL_ID: {
			LinkedList<CompartmentsAbstractNavigatorItem> result = new LinkedList<CompartmentsAbstractNavigatorItem>();
			Node sv = (Node) view;
			CompartmentsNavigatorGroup incominglinks = new CompartmentsNavigatorGroup(Messages.NavigatorGroupName_ChildOfA_C_3001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfB_ECNodeRelationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ChildOfA_DEditPart.VISUAL_ID: {
			LinkedList<CompartmentsAbstractNavigatorItem> result = new LinkedList<CompartmentsAbstractNavigatorItem>();
			Node sv = (Node) view;
			CompartmentsNavigatorGroup incominglinks = new CompartmentsNavigatorGroup(Messages.NavigatorGroupName_ChildOfA_D_3002_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfB_FDNodeRelationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ChildOfB_EEditPart.VISUAL_ID: {
			LinkedList<CompartmentsAbstractNavigatorItem> result = new LinkedList<CompartmentsAbstractNavigatorItem>();
			Node sv = (Node) view;
			CompartmentsNavigatorGroup outgoinglinks = new CompartmentsNavigatorGroup(Messages.NavigatorGroupName_ChildOfB_E_3003_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfB_ECNodeRelationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ChildOfB_GEditPart.VISUAL_ID: {
			LinkedList<CompartmentsAbstractNavigatorItem> result = new LinkedList<CompartmentsAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfB_GAffixedChildrenCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, CompartmentsVisualIDRegistry.getType(ChildOfAffixedEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ChildOfB_FEditPart.VISUAL_ID: {
			LinkedList<CompartmentsAbstractNavigatorItem> result = new LinkedList<CompartmentsAbstractNavigatorItem>();
			Node sv = (Node) view;
			CompartmentsNavigatorGroup outgoinglinks = new CompartmentsNavigatorGroup(Messages.NavigatorGroupName_ChildOfB_F_3006_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfB_FDNodeRelationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ChildOfB_ECNodeRelationEditPart.VISUAL_ID: {
			LinkedList<CompartmentsAbstractNavigatorItem> result = new LinkedList<CompartmentsAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			CompartmentsNavigatorGroup target = new CompartmentsNavigatorGroup(Messages.NavigatorGroupName_ChildOfB_ECNodeRelation_4001_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			CompartmentsNavigatorGroup source = new CompartmentsNavigatorGroup(Messages.NavigatorGroupName_ChildOfB_ECNodeRelation_4001_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfA_CEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfB_EEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ChildOfB_FDNodeRelationEditPart.VISUAL_ID: {
			LinkedList<CompartmentsAbstractNavigatorItem> result = new LinkedList<CompartmentsAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			CompartmentsNavigatorGroup target = new CompartmentsNavigatorGroup(Messages.NavigatorGroupName_ChildOfB_FDNodeRelation_4002_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			CompartmentsNavigatorGroup source = new CompartmentsNavigatorGroup(Messages.NavigatorGroupName_ChildOfB_FDNodeRelation_4002_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfA_DEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv), CompartmentsVisualIDRegistry.getType(ChildOfB_FEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Collection<View> getLinksSourceByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return CanvasEditPart.MODEL_ID.equals(CompartmentsVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<CompartmentsNavigatorItem> createNavigatorItems(Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<CompartmentsNavigatorItem> result = new ArrayList<CompartmentsNavigatorItem>(views.size());
		for (View nextView : views) {
			result.add(new CompartmentsNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	* @generated
	*/
	public Object getParent(Object element) {
		if (element instanceof CompartmentsAbstractNavigatorItem) {
			CompartmentsAbstractNavigatorItem abstractNavigatorItem = (CompartmentsAbstractNavigatorItem) element;
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

}
