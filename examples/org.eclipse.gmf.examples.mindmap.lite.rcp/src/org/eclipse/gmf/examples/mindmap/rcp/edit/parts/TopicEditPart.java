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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.TreeEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Topic;
import org.eclipse.gmf.examples.mindmap.rcp.edit.policies.TopicComponentEditPolicy;
import org.eclipse.gmf.examples.mindmap.rcp.edit.policies.TopicGraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.mindmap.rcp.edit.policies.TopicLayoutEditPolicy;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.examples.mindmap.rcp.view.factories.TopicSubtopicsViewFactory;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalEdgeCommand;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.lite.edit.parts.decorations.IDecoratableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.decorations.IDecorationManager;
import org.eclipse.gmf.runtime.lite.edit.parts.decorations.PaneDecorationManager;
import org.eclipse.gmf.runtime.lite.edit.parts.labels.ILabelTextDisplayer;
import org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.IExternallyUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshersRegistry;
import org.eclipse.gmf.runtime.lite.edit.parts.update.TransactionalUpdateManager;
import org.eclipse.gmf.runtime.lite.edit.parts.update.UpdaterUtil;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.EditPartRegistryBasedViewService;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.OwnedLinksNotationModelRefresher;
import org.eclipse.gmf.runtime.lite.edit.policies.DelegatingDirectEditPolicy;
import org.eclipse.gmf.runtime.lite.edit.policies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.lite.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Widget;

/**
 * @generated
 */
public class TopicEditPart extends AbstractGraphicalEditPart implements
		NodeEditPart, IUpdatableEditPart, IExternallyUpdatableEditPart,
		IDecoratableEditPart {
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;
	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public TopicEditPart(View model) {
		assert model instanceof Node;
		setModel(model);
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
				new TopicComponentEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new TopicGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new DelegatingDirectEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new TopicLayoutEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				getPrimaryDragEditPolicy());
		installLinkNotationModelRefresher();
	}

	/**
	 * @generated
	 */
	protected EditPolicy getPrimaryDragEditPolicy() {
		ResizableEditPolicy result = new ResizableEditPolicy() {
			protected List createSelectionHandles() {
				List result = super.createSelectionHandles();
				for (Iterator it = getChildren().iterator(); it.hasNext();) {
					EditPart next = (EditPart) it.next();
					View nextView = (View) next.getModel();
					switch (MindmapVisualIDRegistry.getVisualID(nextView)) {
					case TopicThreadCompartmentEditPart.VISUAL_ID:
						result.addAll(((TopicThreadCompartmentEditPart) next)
								.createSelectionHandles());
						break;
					}
				}
				return result;
			}
		};
		return result;
	}

	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		IFigure invisibleRectangle = new Figure();
		invisibleRectangle.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		invisibleRectangle.add(shape);
		contentPane = setupContentPane(shape);
		IFigure decorationShape = createDecorationPane();
		if (decorationShape != null) {
			myDecorationManager = createDecorationManager(decorationShape);
			invisibleRectangle.add(decorationShape, 0);
		}
		return invisibleRectangle;
	}

	/**
	 * @generated
	 */
	private IFigure createDecorationPane() {
		return new Figure();
	}

	/**
	 * @generated
	 */
	private IDecorationManager myDecorationManager;

	/**
	 * @generated
	 */
	public IDecorationManager getDecorationManager() {
		return myDecorationManager;
	}

	/**
	 * @generated
	 */
	protected IDecorationManager createDecorationManager(IFigure decorationShape) {
		return new PaneDecorationManager(decorationShape);
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		RoundedTopicFigure figure = new RoundedTopicFigure();
		primaryShape = figure;
		return primaryShape;
	}

	/**
	 * @generated
	 */
	public RoundedTopicFigure getPrimaryShape() {
		return (RoundedTopicFigure) primaryShape;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ToolbarLayout layout = new ToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane == null) {
			return super.getContentPane();
		}
		return contentPane;
	}

	/**
	 * @generated
	 */
	public Node getDiagramNode() {
		return (Node) getModel();
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TopicNameEditPart) {
			((TopicNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureTopicNameFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		return false;
	}

	/**
	 * Returns the label which should be direct-edited by default.
	 * @generated
	 */
	private EditPart getPrimaryLabelEditPart() {
		for (Iterator it = getDiagramNode().getChildren().iterator(); it
				.hasNext();) {
			View nextChild = (View) it.next();
			if (MindmapVisualIDRegistry.getVisualID(nextChild) == TopicNameEditPart.VISUAL_ID) {
				return (EditPart) getViewer().getEditPartRegistry().get(
						nextChild);
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public void performRequest(Request req) {
		if (RequestConstants.REQ_OPEN.equals(req.getType())) {
			Command command = getCommand(req);
			if (command != null && command.canExecute()) {
				getViewer().getEditDomain().getCommandStack().execute(command);
			}
			return;
		}
		if (RequestConstants.REQ_DIRECT_EDIT.equals(req.getType())) {
			EditPart labelToEdit;
			if (req instanceof DirectEditRequest) {
				labelToEdit = getLabelEditPart((DirectEditRequest) req);
			} else {
				labelToEdit = getPrimaryLabelEditPart();
			}
			if (labelToEdit != null) {
				labelToEdit.performRequest(req);
			}
		}
		super.performRequest(req);
	}

	/**
	 * @generated
	 */
	private EditPart getLabelEditPart(DirectEditRequest req) {
		EditPart result = getViewer().findObjectAt(req.getLocation());
		if (result != null) {
			if (getDiagramNode().getChildren().contains(result.getModel())) {
				View view = (View) result.getModel();
				int visualId = MindmapVisualIDRegistry.getVisualID(view);
				switch (visualId) {
				case TopicNameEditPart.VISUAL_ID:
					return result;
				}
			}
		}
		return getPrimaryLabelEditPart();
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected List getModelChildren() {
		return getDiagramNode().getVisibleChildren();
	}

	/**
	 * @generated
	 */
	protected List getModelSourceConnections() {
		return getDiagramNode().getSourceEdges();
	}

	/**
	 * @generated
	 */
	protected List getModelTargetConnections() {
		return getDiagramNode().getTargetEdges();
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {
		return new ChopboxAnchor(getFigure());
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return new ChopboxAnchor(getFigure());
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
		return new ChopboxAnchor(getFigure());
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return new ChopboxAnchor(getFigure());
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class key) {
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
	public void activate() {
		super.activate();
		getTransactionalUpdateManager().addUpdatableEditPart(
				getDiagramNode().getElement(), this);
		installLinkNotationModelRefresher();
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		uninstallLinkNotationModelRefresher();
		getTransactionalUpdateManager().removeUpdatableEditPart(
				getDiagramNode().getElement(), this);
		super.deactivate();
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
		org.eclipse.emf.common.command.Command command = linkRefresher
				.buildRefreshNotationModelCommand();
		if (command == null) {
			return;
		}
		TransactionalEditingDomain domainModelEditDomain = TransactionUtil
				.getEditingDomain(getDiagramNode().getDiagram().getElement());
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
		 * Creates a notification filter which filters notifications that may possibly affect the notational model
		 * @generated
		 */
		protected NotificationFilter createFilter() {
			NotificationFilter filter = NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getTopic_Subtopics());
			return filter;
		}

		/**
		 * @generated
		 */
		protected List getSemanticChildLinks() {
			List result = new LinkedList();
			EObject modelObject = getHost().getElement();
			EObject nextValue;
			for (Iterator it = ((Topic) modelObject).getSubtopics().iterator(); it
					.hasNext();) {
				nextValue = (EObject) it.next();
				if (nextValue != null) {
					result.add(new LinkDescriptor(modelObject, nextValue, null,
							TopicSubtopicsEditPart.VISUAL_ID));
				}
			}
			return result;
		}

		/**
		 * @generated
		 */
		protected List getNotationalChildLinks() {
			List result = new LinkedList();
			List allLinks = getDiagramNode().getDiagram().getEdges();
			for (Iterator it = allLinks.iterator(); it.hasNext();) {
				Edge next = (Edge) it.next();
				if (next.isSetElement() && next.getElement() == null) {
					if (next.getSource() == getHost()) {
						int linkVID = MindmapVisualIDRegistry.getVisualID(next);
						switch (linkVID) {
						case TopicSubtopicsEditPart.VISUAL_ID:
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
			if (!MapEditPart.MODEL_ID.equals(sourceModelID)) {
				return null;
			}
			String targetModelID = MindmapVisualIDRegistry
					.getModelID(targetView);
			if (!MapEditPart.MODEL_ID.equals(targetModelID)) {
				return null;
			}
			switch (linkDescriptor.getVisualID()) {
			case TopicSubtopicsEditPart.VISUAL_ID:
				if (linkDescriptor.getElement() == null) {
					decorator = TopicSubtopicsViewFactory.INSTANCE;
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
			CanonicalStyle style = (CanonicalStyle) getDiagramNode().getStyle(
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
			return getDiagramNode();
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
					return msg.getNotifier() != getDiagramNode();
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
		Refresher visibilityRefresher = new IExternallyUpdatableEditPart.ExternalRefresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshVisibility();
			}

			public boolean isAffectingEvent(Notification msg) {
				if (NotationPackage.eINSTANCE.getView_Visible() == msg
						.getFeature()) {
					return msg.getNotifier() == getDiagramNode();
				}
				return false;
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getView_Visible(),
				visibilityRefresher);
		Refresher sourceEdgesRefresher = new Refresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshSourceConnections();
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getView_SourceEdges(), sourceEdgesRefresher);
		Refresher targetEdgesRefresher = new Refresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshTargetConnections();
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getView_TargetEdges(), targetEdgesRefresher);
		Refresher boundsRefresher = new Refresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshBounds();
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getNode_LayoutConstraint(), boundsRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getSize_Width(),
				boundsRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getSize_Height(),
				boundsRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getLocation_X(),
				boundsRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getLocation_Y(),
				boundsRefresher);
		Refresher fontRefresher = new IExternallyUpdatableEditPart.ExternalRefresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshFont();
			}

			public boolean isAffectingEvent(Notification msg) {
				if (NotationPackage.eINSTANCE.getFontStyle()
						.getEStructuralFeatures().contains(msg.getFeature())) {
					return true;
				}
				if (NotationPackage.eINSTANCE.getView_Styles() == msg
						.getFeature()) {
					return UpdaterUtil.affects(msg, NotationPackage.eINSTANCE
							.getFontStyle());
				}
				return false;
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getFontStyle_FontHeight(), fontRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getFontStyle_FontName(), fontRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getFontStyle_Bold(),
				fontRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getFontStyle_Italic(), fontRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getView_Styles(),
				fontRefresher);
		Refresher fontColorRefresher = new Refresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshFontColor();
			}

			public boolean isAffectingEvent(Notification msg) {
				if (NotationPackage.eINSTANCE.getFontStyle_FontColor() == msg
						.getFeature()) {
					return true;
				}
				if (NotationPackage.eINSTANCE.getView_Styles() == msg
						.getFeature()) {
					return UpdaterUtil.affects(msg, NotationPackage.eINSTANCE
							.getFontStyle());
				}
				return false;
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getFontStyle_FontColor(), fontColorRefresher);
		Refresher backgroundColorRefresher = new IExternallyUpdatableEditPart.ExternalRefresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshBackgroundColor();
			}

			public boolean isAffectingEvent(Notification msg) {
				if (NotationPackage.eINSTANCE.getFillStyle_FillColor() == msg
						.getFeature()) {
					return true;
				}
				if (NotationPackage.eINSTANCE.getView_Styles() == msg
						.getFeature()) {
					return UpdaterUtil.affects(msg, NotationPackage.eINSTANCE
							.getFillStyle());
				}
				return false;
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getFillStyle_FillColor(), backgroundColorRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getView_Styles(),
				backgroundColorRefresher);
	}

	/**
	 * @generated
	 */
	protected void refreshVisibility() {
		boolean isVisible = getDiagramNode().isVisible();
		boolean wasVisible = getFigure().isVisible();
		if (isVisible == wasVisible) {
			return;
		}
		if (!isVisible && (getSelected() != SELECTED_NONE)) {
			getViewer().deselect(this);
		}
		getFigure().setVisible(isVisible);
		getFigure().revalidate();
	}

	/**
	 * @generated
	 */
	protected void refreshBounds() {
		Node node = getDiagramNode();
		if (node.getLayoutConstraint() == null) {
			return;
		}
		assert node.getLayoutConstraint() instanceof Bounds;
		Bounds bounds = (Bounds) node.getLayoutConstraint();
		int x = bounds.getX();
		int y = bounds.getY();
		int width = bounds.getWidth();
		int height = bounds.getHeight();
		if (width < 0) {
			x -= width;
			width = -width;
		}
		if (height < 0) {
			y -= height;
			height = -height;
		}
		((GraphicalEditPart) getParent()).setLayoutConstraint(this,
				getFigure(), new Rectangle(x, y, width, height));
	}

	/**
	 * @generated
	 */
	protected void refreshFont() {
		FontStyle style = (FontStyle) getDiagramNode().getStyle(
				NotationPackage.eINSTANCE.getFontStyle());
		Font toDispose = createdFont;
		if (style != null) {
			String fontName = style.getFontName();
			int fontHeight = style.getFontHeight();
			int fontStyle = SWT.NORMAL;
			if (style.isBold()) {
				fontStyle |= SWT.BOLD;
			}
			if (style.isItalic()) {
				fontStyle |= SWT.ITALIC;
			}
			Font currentFont = getFigure().getFont();
			if (currentFont != null) {
				FontData currentFontData = currentFont.getFontData()[0];
				if (currentFontData.getName().equals(fontName)
						&& currentFontData.getHeight() == fontHeight
						&& currentFontData.getStyle() == fontStyle) {
					return;
				}
			}
			createdFont = new Font(null, fontName, fontHeight, fontStyle);
			getFigure().setFont(createdFont);
		} else {
			//revert to the default font
			getFigure().setFont(getViewer().getControl().getFont());
			createdFont = null;
		}
		if (toDispose != null) {
			toDispose.dispose();
		}
	}

	/**
	 * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned).
	 * Whenever another non-default font is assigned to it, it is safe to dispose the previous one.
	 * @generated
	 */
	private Font createdFont;

	/**
	 * @generated
	 */
	protected void refreshFontColor() {
		FontStyle style = (FontStyle) getDiagramNode().getStyle(
				NotationPackage.eINSTANCE.getFontStyle());
		Color toDispose = createdFontColor;
		if (style != null) {
			int fontColor = style.getFontColor();
			int red = fontColor & 0x000000FF;
			int green = (fontColor & 0x0000FF00) >> 8;
			int blue = (fontColor & 0x00FF0000) >> 16;
			Color currentColor = getFigure().getForegroundColor();
			if (currentColor != null && currentColor.getRed() == red
					&& currentColor.getGreen() == green
					&& currentColor.getBlue() == blue) {
				return;
			}
			createdFontColor = new Color(null, red, green, blue);
			getFigure().setForegroundColor(createdFontColor);
		} else {
			getFigure().setForegroundColor(
					getViewer().getControl().getForeground());
			createdFontColor = null;
		}
		if (toDispose != null) {
			toDispose.dispose();
		}
	}

	/**
	 * The color (created by {@link #refreshFontColor()}) currently assigned to the label.
	 * Whenever another color is assigned to it, it is safe to dispose the previous one.
	 * @generated
	 */
	private Color createdFontColor;

	/**
	 * @generated
	 */
	protected void refreshBackgroundColor() {
		FillStyle style = (FillStyle) getDiagramNode().getStyle(
				NotationPackage.eINSTANCE.getFillStyle());
		Color toDispose = createdBackgroundColor;
		if (style != null) {
			int backgroundColor = style.getFillColor();
			int red = backgroundColor & 0x000000FF;
			int green = (backgroundColor & 0x0000FF00) >> 8;
			int blue = (backgroundColor & 0x00FF0000) >> 16;
			Color currentColor = getFigure().getBackgroundColor();
			if (currentColor != null && currentColor.getRed() == red
					&& currentColor.getGreen() == green
					&& currentColor.getBlue() == blue) {
				return;
			}
			createdBackgroundColor = new Color(null, red, green, blue);
			getFigure().setBackgroundColor(createdBackgroundColor);
		} else {
			getFigure().setBackgroundColor(
					getViewer().getControl().getBackground());
		}
		if (toDispose != null) {
			toDispose.dispose();
		}
	}

	/**
	 * The color (created by {@link #refreshBackgroundColor()}) currently assigned to the figure.
	 * Whenever another color is assigned to it, it is safe to dispose the previous one.
	 * @generated
	 */
	private Color createdBackgroundColor;

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshVisibility();
		refreshBounds();
		refreshFont();
		refreshFontColor();
		refreshBackgroundColor();
	}

	/**
	 * @generated
	 */
	private Collection externalRefreshers = new ArrayList();

	/**
	 * @generated
	 */
	public Collection getExternalRefreshers() {
		return externalRefreshers;
	}

	/**
	 * @generated
	 */
	public void addExternalRefresher(
			IExternallyUpdatableEditPart.ExternalRefresher externalRefresher) {
		if (externalRefresher != null
				&& !externalRefreshers.contains(externalRefresher)) {
			externalRefreshers.add(externalRefresher);
		}
	}

	/**
	 * @generated
	 */
	public void removeExternalRefresher(
			IExternallyUpdatableEditPart.ExternalRefresher externalRefresher) {
		externalRefreshers.remove(externalRefresher);
	}

	/**
	 * @generated
	 */
	public class RoundedTopicFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private Label fFigureTopicNameFigure;

		/**
		 * @generated
		 */
		public RoundedTopicFigure() {
			this.setCornerDimensions(new Dimension(12, 12));
			this.setForegroundColor(THIS_FORE);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureTopicNameFigure = new Label();
			fFigureTopicNameFigure.setText("");

			this.add(fFigureTopicNameFigure);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public Label getFigureTopicNameFigure() {
			return fFigureTopicNameFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 220, 220, 250);

	/**
	 * @generated
	 */
	private class TreeEditPartAdapter extends BaseTreeEditPart {
		/**
		 * @generated
		 */
		public TreeEditPartAdapter() {
			super(getDiagramNode(), MindmapDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());
		}

		/**
		 * @generated
		 */
		protected void createEditPolicies() {
			installEditPolicy(EditPolicy.COMPONENT_ROLE,
					new TopicComponentEditPolicy() {
						protected GraphicalEditPart getGraphicalEditPart() {
							return TopicEditPart.this;
						}
					});
			installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
					new LabelDirectEditPolicy());
		}

		/**
		 * @generated
		 */
		public void setWidget(Widget widget) {
			if (widget == null) {
				myTreeEditPartAdapter = null;
			}
			super.setWidget(widget);
		}

		/**
		 * @generated
		 */
		protected ILabelTextDisplayer createLabelTextDisplayer() {
			TopicNameEditPart primaryLabelEditPart = getPrimaryLabelEditPart();
			if (primaryLabelEditPart != null) {
				return primaryLabelEditPart.getLabelTextDisplayer();
			}
			return super.createLabelTextDisplayer();
		}

		/**
		 * @generated
		 */
		protected Image getImage() {
			TopicNameEditPart primaryLabelEditPart = getPrimaryLabelEditPart();
			if (primaryLabelEditPart != null) {
				return primaryLabelEditPart.getLabelIcon();
			}
			return null;
		}

		/**
		 * @generated
		 */
		private TopicNameEditPart getPrimaryLabelEditPart() {
			for (Iterator it = getDiagramNode().getChildren().iterator(); it
					.hasNext();) {
				View nextChild = (View) it.next();
				if (MindmapVisualIDRegistry.getVisualID(nextChild) == TopicNameEditPart.VISUAL_ID) {
					return (TopicNameEditPart) TopicEditPart.this.getViewer()
							.getEditPartRegistry().get(nextChild);
				}
			}
			return null;
		}

		/**
		 * Since compartments and labels are not selectable edit parts, they are filtered from the overview as well.
		 * @generated
		 */
		protected List getModelChildren() {
			List result = new ArrayList();
			for (Iterator it = getNotationView().getVisibleChildren()
					.iterator(); it.hasNext();) {
				View next = (View) it.next();
				switch (MindmapVisualIDRegistry.getVisualID(next)) {
				case TopicThreadCompartmentEditPart.VISUAL_ID: {
					DrawerStyle style = (DrawerStyle) next
							.getStyle(NotationPackage.eINSTANCE
									.getDrawerStyle());
					if (style != null && style.isCollapsed()) {
						break;
					}
					result.addAll(next.getVisibleChildren());
					break;
				}
				}
			}
			for (Iterator it = getNotationView().getSourceEdges().iterator(); it
					.hasNext();) {
				Edge next = (Edge) it.next();
				if (next.isVisible()) {
					result.add(next);
				}
			}
			return result;
		}
	}
}
