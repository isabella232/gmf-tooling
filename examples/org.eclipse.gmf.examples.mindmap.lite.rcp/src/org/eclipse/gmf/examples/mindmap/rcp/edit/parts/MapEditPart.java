/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */

package org.eclipse.gmf.examples.mindmap.rcp.edit.parts;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.TreeEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Relationship;
import org.eclipse.gmf.examples.mindmap.Resource;
import org.eclipse.gmf.examples.mindmap.Topic;
import org.eclipse.gmf.examples.mindmap.rcp.edit.policies.MapLayoutEditPolicy;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.examples.mindmap.rcp.view.factories.Relationship2ViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.view.factories.Relationship3ViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.view.factories.RelationshipViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.view.factories.ResourceViewFactory;
import org.eclipse.gmf.examples.mindmap.rcp.view.factories.TopicViewFactory;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalEdgeCommand;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.IExternallyUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshersRegistry;
import org.eclipse.gmf.runtime.lite.edit.parts.update.TransactionalUpdateManager;
import org.eclipse.gmf.runtime.lite.edit.parts.update.UpdaterUtil;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.EditPartRegistryBasedViewService;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.OwnedLinksNotationModelRefresher;
import org.eclipse.gmf.runtime.lite.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Widget;

/**
 * @generated
 */
public class MapEditPart extends AbstractGraphicalEditPart implements
		IUpdatableEditPart {
	/**
	 * @generated
	 */
	public static String MODEL_ID = "Mindmap"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public MapEditPart(Diagram model) {
		setModel(model);
	}

	/**
	 * @generated
	 */
	public Diagram getDiagram() {
		return (Diagram) getModel();
	}

	/**
	 * @generated
	 */
	protected void registerModel() {
		super.registerModel();
		View view = (View) getModel();
		if (view != null && view.isSetElement() && view.getElement() != null) {
			getViewer().getEditPartRegistry().put(view.getElement(), this);
		}
	}

	/**
	 * @generated
	 */
	protected void unregisterModel() {
		super.unregisterModel();
		View view = (View) getModel();
		if (view != null
				&& view.isSetElement()
				&& view.getElement() != null
				&& getViewer().getEditPartRegistry().get(view.getElement()) == this) {
			getViewer().getEditPartRegistry().remove(view.getElement());
		}
	}

	/**
	 * @generated
	 */
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new RootComponentEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new MapLayoutEditPolicy());
		installNotationModelRefresher();
		installLinkNotationModelRefresher();
	}

	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		IFigure f = new FreeformLayer();
		f.setBorder(new MarginBorder(5));
		f.setLayoutManager(new FreeformLayout());
		return f;
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class key) {
		if (SnapToHelper.class == key) {
			return new SnapToGrid(this);
		}
		if (TreeEditPart.class == key) {
			return getTreeEditPartAdapter();
		}
		return super.getAdapter(key);
	}

	/**
	 * @generated
	 */
	private TreeEditPartAdapter myTreeEditPartAdapter;

	/**
	 * @generated
	 */
	private TreeEditPartAdapter getTreeEditPartAdapter() {
		if (myTreeEditPartAdapter == null) {
			myTreeEditPartAdapter = new TreeEditPartAdapter();
		}
		return myTreeEditPartAdapter;
	}

	/**
	 * @generated
	 */
	protected List getModelChildren() {
		return getDiagram().getVisibleChildren();
	}

	/**
	 * @generated
	 */
	private RefreshersRegistry myRefreshersRegistry;

	/**
	 * @generated
	 */
	public Refresher getRefresher(EStructuralFeature feature, Notification msg) {
		if (myRefreshersRegistry == null) {
			createRefreshers();
		}
		return myRefreshersRegistry.getRefresher(feature, msg);
	}

	/**
	 * @generated
	 */
	private void createRefreshers() {
		myRefreshersRegistry = new RefreshersRegistry();
		Refresher childrenRefresher = new IExternallyUpdatableEditPart.ExternalRefresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshChildren();
			}

			public boolean isAffectingEvent(Notification msg) {
				if (NotationPackage.eINSTANCE.getView_PersistedChildren() == msg
						.getFeature()
						|| NotationPackage.eINSTANCE
								.getView_TransientChildren() == msg
								.getFeature()
						|| NotationPackage.eINSTANCE.getDrawerStyle_Collapsed() == msg
								.getFeature()) {
					return true;
				}
				if (NotationPackage.eINSTANCE.getView_Styles() == msg
						.getFeature()) {
					return UpdaterUtil.affects(msg, NotationPackage.eINSTANCE
							.getDrawerStyle());
				}
				if (NotationPackage.eINSTANCE.getView_Visible() == msg
						.getFeature()) {
					return msg.getNotifier() != getDiagram();
				}
				return false;
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getView_PersistedChildren(), childrenRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getView_TransientChildren(), childrenRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getView_Styles(),
				childrenRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getDrawerStyle_Collapsed(), childrenRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getView_Visible(),
				childrenRefresher);
	}

	/**
	 * @generated
	 */
	public void activate() {
		super.activate();
		getTransactionalUpdateManager().addUpdatableEditPart(
				getDiagram().getElement(), this);
		installNotationModelRefresher();
		installLinkNotationModelRefresher();
		getTransactionalUpdateManager().install(
				TransactionUtil.getEditingDomain(getDiagram()));
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		getTransactionalUpdateManager().uninstall();
		uninstallLinkNotationModelRefresher();
		uninstallNotationModelRefresher();
		getTransactionalUpdateManager().removeUpdatableEditPart(
				getDiagram().getElement(), this);
		super.deactivate();
	}

	/**
	 * @generated
	 */
	private void installNotationModelRefresher() {
		ChildNotationModelRefresher refresher = getNotationModelRefresher();
		getTransactionalUpdateManager().addNotationModelRefresher(refresher);
	}

	/**
	 * @generated
	 */
	private void uninstallNotationModelRefresher() {
		ChildNotationModelRefresher refresher = getNotationModelRefresher();
		getTransactionalUpdateManager().removeNotationModelRefresher(refresher);
	}

	/**
	 * @generated
	 */
	private ChildNotationModelRefresher notationModelRefresher;

	/**
	 * @generated
	 */
	private ChildNotationModelRefresher getNotationModelRefresher() {
		if (notationModelRefresher == null) {
			notationModelRefresher = new NotationModelRefresher();
		}
		return notationModelRefresher;
	}

	/**
	 * @generated
	 */
	protected void refreshNotationModel() {
		ChildNotationModelRefresher childRefresher = getNotationModelRefresher();
		if (!childRefresher.isInstalled()) {
			return;
		}
		Command command = childRefresher.buildRefreshNotationModelCommand();
		if (command == null) {
			return;
		}
		TransactionalEditingDomain domainModelEditDomain = TransactionUtil
				.getEditingDomain(getDiagram().getElement());
		getViewer().getEditDomain().getCommandStack().execute(
				new WrappingCommand(domainModelEditDomain, command));
	}

	/**
	 * @generated
	 */
	private class NotationModelRefresher extends ChildNotationModelRefresher {
		/**
		 * Creates a notification filter which filters notifications that may possibly affect the notational model
		 * @generated
		 */
		protected NotificationFilter createFilter() {
			NotificationFilter filter = NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getMap_RootTopics());
			filter = filter.or(NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getMap_Resources()));
			filter = filter.and(NotificationFilter
					.createNotifierFilter(getDiagram().getElement()));
			return filter;
		}

		/**
		 * @generated
		 */
		protected CreateNotationalElementCommand getCreateNotationalElementCommand(
				ElementDescriptor descriptor) {
			EObject domainElement = descriptor.getElement();
			int nodeVisualID = descriptor.getVisualID();
			switch (nodeVisualID) {
			case TopicEditPart.VISUAL_ID:
				if (domainElement instanceof Topic) {
					return new CreateNotationalNodeCommand(getHost(),
							domainElement, new Rectangle(0, 0, 40, 40),
							TopicViewFactory.INSTANCE, false);
				}
				return null;
			case ResourceEditPart.VISUAL_ID:
				if (domainElement instanceof Resource) {
					return new CreateNotationalNodeCommand(getHost(),
							domainElement, new Rectangle(0, 0, 40, 60),
							ResourceViewFactory.INSTANCE, false);
				}
				return null;
			default:
				return null;
			}
		}

		/**
		 * @generated
		 */
		protected List getSemanticChildNodes() {
			List result = new LinkedList();
			View viewObject = getHost();
			EObject modelObject = viewObject.getElement();
			EObject nextValue;
			int nodeVID;
			for (Iterator it = ((Map) modelObject).getRootTopics().iterator(); it
					.hasNext();) {
				nextValue = (EObject) it.next();
				nodeVID = MindmapVisualIDRegistry.getNodeVisualID(viewObject,
						nextValue);
				if (TopicEditPart.VISUAL_ID == nodeVID) {
					result.add(new ElementDescriptor(nextValue, nodeVID));
				}
			}
			for (Iterator it = ((Map) modelObject).getResources().iterator(); it
					.hasNext();) {
				nextValue = (EObject) it.next();
				nodeVID = MindmapVisualIDRegistry.getNodeVisualID(viewObject,
						nextValue);
				if (ResourceEditPart.VISUAL_ID == nodeVID) {
					result.add(new ElementDescriptor(nextValue, nodeVID));
				}
			}
			return result;
		}

		/**
		 * Returns whether a notational element should be created for the given domain element. 
		 * The generated code respects canonical style. If the canonycal style is not present, true is always returned. 
		 * User can change implementation of this method to handle a more sophisticated logic.
		 * @generated
		 */
		protected boolean shouldCreateView(ElementDescriptor descriptor) {
			CanonicalStyle style = (CanonicalStyle) getDiagram().getStyle(
					NotationPackage.eINSTANCE.getCanonicalStyle());
			if (style == null) {
				return true;
			}
			return style.isCanonical();
		}

		/**
		 * @generated
		 */
		protected View getHost() {
			return getDiagram();
		}
	}

	/**
	 * @generated
	 */
	private void installLinkNotationModelRefresher() {
		LinkNotationModelRefresher refresher = getLinkNotationModelRefresher();
		getTransactionalUpdateManager().addNotationModelRefresher(refresher);
	}

	/**
	 * @generated
	 */
	private void uninstallLinkNotationModelRefresher() {
		LinkNotationModelRefresher refresher = getLinkNotationModelRefresher();
		getTransactionalUpdateManager().removeNotationModelRefresher(refresher);
	}

	/**
	 * @generated
	 */
	private LinkNotationModelRefresher linkNotationModelRefresher;

	/**
	 * @generated
	 */
	private LinkNotationModelRefresher getLinkNotationModelRefresher() {
		if (linkNotationModelRefresher == null) {
			linkNotationModelRefresher = new LinkNotationModelRefresher(
					getViewService());
		}
		return linkNotationModelRefresher;
	}

	/**
	 * Service to find a notational element that corresponds to the given underlying domain element.
	 * @generated
	 */
	private IViewService viewService;

	/**
	 * @generated
	 */
	private IViewService getViewService() {
		if (viewService == null) {
			viewService = new EditPartRegistryBasedViewService(getViewer());
		}
		return viewService;
	}

	/**
	 * @generated
	 */
	protected void refreshLinkNotationModel() {
		LinkNotationModelRefresher linkRefresher = getLinkNotationModelRefresher();
		if (!linkRefresher.isInstalled()) {
			return;
		}
		Command command = linkRefresher.buildRefreshNotationModelCommand();
		if (command == null) {
			return;
		}
		TransactionalEditingDomain domainModelEditDomain = TransactionUtil
				.getEditingDomain(getDiagram().getElement());
		getViewer().getEditDomain().getCommandStack().execute(
				new WrappingCommand(domainModelEditDomain, command));
	}

	/**
	 * @generated
	 */
	private class LinkNotationModelRefresher extends
			OwnedLinksNotationModelRefresher {
		/**
		 * @generated
		 */
		public LinkNotationModelRefresher(IViewService viewService) {
			super(viewService);
		}

		/**
		 * TODO: Child links of this element are selected based on constraint declared in org.eclipse.gmf.examples.mindmap.rcp.part.MindmapVisualIDRegistry. 
		 * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in 
		 * notational model having to be updated.
		 * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications
		 * result in such an update.
		 * @generated
		 */
		private NotificationFilter getConstrainedChildLinksFilter() {
			return NotificationFilter.NOT_TOUCH;
		}

		/**
		 * Creates a notification filter which filters notifications that may possibly result in uncontained links. 
		 * @generated
		 */
		private NotificationFilter createUncontainedLinksFilter() {
			return NotificationFilter
					.createEventTypeFilter(Notification.SET)
					.or(
							NotificationFilter
									.createEventTypeFilter(Notification.UNSET)
									.or(
											NotificationFilter
													.createEventTypeFilter(
															Notification.REMOVE)
													.or(
															NotificationFilter
																	.createEventTypeFilter(Notification.REMOVE_MANY))));
		}

		/**
		 * Creates a notification filter which filters notifications that may possibly affect the notational model
		 * @generated
		 */
		protected NotificationFilter createFilter() {
			NotificationFilter filter = NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getMap_Relations());
			filter = filter.or(NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getRelationship_Source()));
			filter = filter.or(NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getRelationship_Target()));
			filter = getConstrainedChildLinksFilter().or(filter);
			filter = filter.or(createUncontainedLinksFilter());
			return filter;
		}

		/**
		 * @generated
		 */
		protected List getSemanticChildLinks() {
			List result = new LinkedList();
			EObject modelObject = getHost().getElement();
			EObject nextValue;
			int linkVID;
			for (Iterator it = ((Map) modelObject).getRelations().iterator(); it
					.hasNext();) {
				nextValue = (EObject) it.next();
				linkVID = MindmapVisualIDRegistry
						.getLinkWithClassVisualID(nextValue);
				switch (linkVID) {
				case RelationshipEditPart.VISUAL_ID: {
					EObject source = (EObject) ((Relationship) nextValue)
							.getSource();
					EObject target = (EObject) ((Relationship) nextValue)
							.getTarget();
					if (source != null && target != null) {
						result.add(new LinkDescriptor(source, target,
								nextValue, linkVID));
					}
					break;
				}
				case Relationship2EditPart.VISUAL_ID: {
					EObject source = (EObject) ((Relationship) nextValue)
							.getSource();
					EObject target = (EObject) ((Relationship) nextValue)
							.getTarget();
					if (source != null && target != null) {
						result.add(new LinkDescriptor(source, target,
								nextValue, linkVID));
					}
					break;
				}
				case Relationship3EditPart.VISUAL_ID: {
					EObject source = (EObject) ((Relationship) nextValue)
							.getSource();
					EObject target = (EObject) ((Relationship) nextValue)
							.getTarget();
					if (source != null && target != null) {
						result.add(new LinkDescriptor(source, target,
								nextValue, linkVID));
					}
					break;
				}
				}
			}
			return result;
		}

		/**
		 * @generated
		 */
		protected List getNotationalChildLinks() {
			List result = new LinkedList();
			List allLinks = getDiagram().getEdges();
			for (Iterator it = allLinks.iterator(); it.hasNext();) {
				Edge next = (Edge) it.next();
				if (next.isSetElement() && next.getElement() != null
						&& next.getElement().eResource() == null) {
					result.add(next);
					continue;
				}
				View source = next.getSource();
				if (source == null
						|| (source.isSetElement()
								&& source.getElement() != null && source
								.getElement().eResource() == null)) {
					result.add(next);
					continue;
				}
				View target = next.getTarget();
				if (target == null
						|| (target.isSetElement()
								&& target.getElement() != null && target
								.getElement().eResource() == null)) {
					result.add(next);
					continue;
				}
				if (next.isSetElement() && next.getElement() != null) {
					if (next.getElement().eContainer() == getDiagram()
							.getElement()) {
						int linkVID = MindmapVisualIDRegistry.getVisualID(next);
						switch (linkVID) {
						case RelationshipEditPart.VISUAL_ID:
						case Relationship2EditPart.VISUAL_ID:
						case Relationship3EditPart.VISUAL_ID:
							result.add(next);
							break;
						}
					}
				}
			}
			return result;
		}

		/**
		 * @generated
		 */
		protected CreateNotationalElementCommand getCreateNotationalElementCommand(
				ElementDescriptor descriptor) {
			LinkDescriptor linkDescriptor = (LinkDescriptor) descriptor;
			View sourceView = getViewService().findView(
					linkDescriptor.getSource());
			View targetView = getViewService().findView(
					linkDescriptor.getDestination());
			IViewDecorator decorator = null;
			if (sourceView == null || targetView == null) {
				return null;
			}
			String sourceModelID = MindmapVisualIDRegistry
					.getModelID(sourceView);
			if (!org.eclipse.gmf.examples.mindmap.rcp.edit.parts.MapEditPart.MODEL_ID
					.equals(sourceModelID)) {
				return null;
			}
			String targetModelID = MindmapVisualIDRegistry
					.getModelID(targetView);
			if (!org.eclipse.gmf.examples.mindmap.rcp.edit.parts.MapEditPart.MODEL_ID
					.equals(targetModelID)) {
				return null;
			}
			switch (linkDescriptor.getVisualID()) {
			case RelationshipEditPart.VISUAL_ID:
				if (linkDescriptor.getElement() instanceof Relationship) {
					decorator = RelationshipViewFactory.INSTANCE;
				}
				break;
			case Relationship2EditPart.VISUAL_ID:
				if (linkDescriptor.getElement() instanceof Relationship) {
					decorator = Relationship2ViewFactory.INSTANCE;
				}
				break;
			case Relationship3EditPart.VISUAL_ID:
				if (linkDescriptor.getElement() instanceof Relationship) {
					decorator = Relationship3ViewFactory.INSTANCE;
				}
				break;
			}
			if (decorator == null) {
				return null;
			}
			return new CreateNotationalEdgeCommand(getHost().getDiagram(),
					linkDescriptor.getElement(), sourceView, targetView,
					decorator);
		}

		/**
		 * Returns whether a notational edge should be created for the given domain element. 
		 * The generated code respects canonical style. If the canonycal style is not present, true is always returned. 
		 * User can change implementation of this method to handle a more sophisticated logic.
		 * @generated
		 */
		protected boolean shouldCreateView(ElementDescriptor descriptor) {
			CanonicalStyle style = (CanonicalStyle) getDiagram().getStyle(
					NotationPackage.eINSTANCE.getCanonicalStyle());
			if (style == null) {
				return true;
			}
			return style.isCanonical();
		}

		/**
		 * @generated
		 */
		protected View getHost() {
			return getDiagram();
		}
	}

	/**
	 * @generated
	 */
	private TransactionalUpdateManager getTransactionalUpdateManager() {
		return (TransactionalUpdateManager) getViewer().getProperty(
				TransactionalUpdateManager.class.getName());
	}

	/**
	 * @generated
	 */
	private class TreeEditPartAdapter extends BaseTreeEditPart {
		/**
		 * @generated
		 */
		public TreeEditPartAdapter() {
			super(getDiagram(), MindmapDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());
		}

		/**
		 * @generated
		 */
		protected void createEditPolicies() {
			installEditPolicy(EditPolicy.COMPONENT_ROLE,
					new RootComponentEditPolicy());
		}

		/**
		 * @generated
		 */
		public void activate() {
			myUpdateManager = new TransactionalUpdateManager(getViewer());
			getViewer().setProperty(TransactionalUpdateManager.class.getName(),
					myUpdateManager);
			super.activate();
			getTransactionalUpdateManager().install(
					TransactionUtil.getEditingDomain(getNotationView()));
		}

		/**
		 * @generated
		 */
		public void deactivate() {
			getTransactionalUpdateManager().uninstall();
			super.deactivate();
			TransactionalUpdateManager updateManager = (TransactionalUpdateManager) getViewer()
					.getProperty(TransactionalUpdateManager.class.getName());
			if (updateManager != null) {
				updateManager.dispose();
			}
		}

		/**
		 * @generated
		 */
		protected TransactionalUpdateManager getTransactionalUpdateManager() {
			return myUpdateManager;
		}

		/**
		 * @generated
		 */
		private TransactionalUpdateManager myUpdateManager;

		/**
		 * @generated
		 */
		public void setWidget(Widget widget) {
			if (widget == null) {
				myTreeEditPartAdapter = null;
			}
			super.setWidget(widget);
		}
	}
}
