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

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Thread;
import org.eclipse.gmf.examples.mindmap.Topic;
import org.eclipse.gmf.examples.mindmap.rcp.edit.policies.TopicThreadCompartmentLayoutEditPolicy;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.examples.mindmap.rcp.view.factories.ThreadViewFactory;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.lite.edit.parts.update.IExternallyUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshersRegistry;
import org.eclipse.gmf.runtime.lite.edit.parts.update.TransactionalUpdateManager;
import org.eclipse.gmf.runtime.lite.edit.parts.update.UpdaterUtil;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher;
import org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor;
import org.eclipse.gmf.runtime.lite.figures.CompartmentFigure;
import org.eclipse.gmf.runtime.lite.handles.CompartmentCollapseHandle;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TopicThreadCompartmentEditPart extends AbstractGraphicalEditPart
		implements IUpdatableEditPart {
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7001;

	/**
	 * @generated
	 */
	public TopicThreadCompartmentEditPart(View model) {
		assert model instanceof Node;
		setModel(model);
	}

	/**
	 * @generated
	 */
	public boolean isSelectable() {
		return false;
	}

	/**
	 * @generated
	 */
	protected List getModelChildren() {
		DrawerStyle style = (DrawerStyle) getDiagramNode().getStyle(
				NotationPackage.eINSTANCE.getDrawerStyle());
		if (style != null && style.isCollapsed()) {
			return Collections.EMPTY_LIST;
		}
		return getDiagramNode().getVisibleChildren();
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
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE,
				new TopicThreadCompartmentLayoutEditPolicy());
		installNotationModelRefresher();
	}

	/**
	 * Returns the selection handles that should be contributed to the parent when it becomes selected.
	 * @generated
	 */
	public List createSelectionHandles() {
		return Collections.singletonList(new CompartmentCollapseHandle(this,
				getTitleName()));
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
		super.performRequest(req);
	}

	/**
	 * @generated
	 */
	protected String getTitleName() {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public IFigure createFigure() {
		Figure result = new CompartmentFigure();
		result.setLayoutManager(new StackLayout());
		ScrollPane scrollPane = new ScrollPane();
		result.add(scrollPane);
		Viewport viewport = new FreeformViewport();
		contentPane = new FreeformLayer();
		contentPane.setLayoutManager(new FreeformLayout());
		viewport.setContents(contentPane);
		scrollPane.setViewport(viewport);
		return result;
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class key) {
		if (SnapToHelper.class == key) {
			return new SnapToGrid(this);
		}
		return super.getAdapter(key);
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
	public void activate() {
		super.activate();
		installNotationModelRefresher();
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		uninstallNotationModelRefresher();
		super.deactivate();
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
		org.eclipse.emf.common.command.Command command = childRefresher
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
	private class NotationModelRefresher extends ChildNotationModelRefresher {
		/**
		 * Creates a notification filter which filters notifications that may possibly affect the notational model
		 * @generated
		 */
		protected NotificationFilter createFilter() {
			NotificationFilter filter = NotificationFilter
					.createFeatureFilter(MindmapPackage.eINSTANCE
							.getTopic_Comments());
			filter = filter.and(NotificationFilter
					.createNotifierFilter(getDiagramNode().getElement()));
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
			case ThreadEditPart.VISUAL_ID:
				if (domainElement instanceof Thread) {
					return new CreateNotationalNodeCommand(getHost(),
							domainElement, new Rectangle(0, 0, 40, 40),
							ThreadViewFactory.INSTANCE, false);
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
			for (Iterator it = ((Topic) modelObject).getComments().iterator(); it
					.hasNext();) {
				nextValue = (EObject) it.next();
				nodeVID = MindmapVisualIDRegistry.getNodeVisualID(viewObject,
						nextValue);
				if (ThreadEditPart.VISUAL_ID == nodeVID) {
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
		getFigure().setVisible(isVisible);
		getFigure().revalidate();
	}

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshVisibility();
	}
}
