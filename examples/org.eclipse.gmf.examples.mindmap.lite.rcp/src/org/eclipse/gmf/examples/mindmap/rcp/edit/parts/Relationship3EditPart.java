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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.TreeEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.examples.mindmap.rcp.edit.policies.Relationship3ComponentEditPolicy;
import org.eclipse.gmf.examples.mindmap.rcp.edit.policies.Relationship3GraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.lite.edit.parts.decorations.ConnectionDecorationManager;
import org.eclipse.gmf.runtime.lite.edit.parts.decorations.IDecoratableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.decorations.IDecorationManager;
import org.eclipse.gmf.runtime.lite.edit.parts.labels.ILabelTextDisplayer;
import org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.IExternallyUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshersRegistry;
import org.eclipse.gmf.runtime.lite.edit.parts.update.TransactionalUpdateManager;
import org.eclipse.gmf.runtime.lite.edit.parts.update.UpdaterUtil;
import org.eclipse.gmf.runtime.lite.edit.policies.BendpointEditPolicy;
import org.eclipse.gmf.runtime.lite.edit.policies.DelegatingDirectEditPolicy;
import org.eclipse.gmf.runtime.lite.edit.policies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.lite.figures.ConnectionConnectionAnchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Widget;

/**
 * @generated
 */
public class Relationship3EditPart extends AbstractConnectionEditPart implements
		IUpdatableEditPart, IExternallyUpdatableEditPart, IDecoratableEditPart,
		NodeEditPart {
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4004;

	/**
	 * @generated
	 */
	public Relationship3EditPart(View model) {
		assert model instanceof Edge;
		setModel(model);
	}

	/**
	 * @generated
	 */
	public Edge getDiagramEdge() {
		return (Edge) getModel();
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
	protected List getModelChildren() {
		return getDiagramEdge().getVisibleChildren();
	}

	/**
	 * @generated
	 */
	protected List getModelSourceConnections() {
		return getDiagramEdge().getSourceEdges();
	}

	/**
	 * @generated
	 */
	protected List getModelTargetConnections() {
		return getDiagramEdge().getTargetEdges();
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {
		return new ConnectionConnectionAnchor(getConnectionFigure());
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return new ConnectionConnectionAnchor(getConnectionFigure());
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
		return new ConnectionConnectionAnchor(getConnectionFigure());
	}

	/**
	 * @generated
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return new ConnectionConnectionAnchor(getConnectionFigure());
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
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new Relationship3ComponentEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,
				new ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE,
				new BendpointEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new DelegatingDirectEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new Relationship3GraphicalNodeEditPolicy());
	}

	/**
	 * Returns the label which should be direct-edited by default.
	 * @generated
	 */
	private EditPart getPrimaryLabelEditPart() {
		for (Iterator it = getDiagramEdge().getChildren().iterator(); it
				.hasNext();) {
			View nextChild = (View) it.next();
			if (MindmapVisualIDRegistry.getVisualID(nextChild) == RelationshipLabel3EditPart.VISUAL_ID) {
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
			if (getDiagramEdge().getChildren().contains(result.getModel())) {
				View view = (View) result.getModel();
				int visualId = MindmapVisualIDRegistry.getVisualID(view);
				switch (visualId) {
				case RelationshipLabel3EditPart.VISUAL_ID:
					return result;
				}
			}
		}
		return getPrimaryLabelEditPart();
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
				getDiagramEdge().getElement(), this);
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		getTransactionalUpdateManager().removeUpdatableEditPart(
				getDiagramEdge().getElement(), this);
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
					return msg.getNotifier() != getDiagramEdge();
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
					return msg.getNotifier() == getDiagramEdge();
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
		Refresher bendpointsRefresher = new Refresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshBendpoints();
			}
		};
		myRefreshersRegistry.add(
				NotationPackage.eINSTANCE.getEdge_Bendpoints(),
				bendpointsRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getRelativeBendpoints_Points(), bendpointsRefresher);
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
		Refresher foregroundColorRefresher = new IExternallyUpdatableEditPart.ExternalRefresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshForegroundColor();
			}

			public boolean isAffectingEvent(Notification msg) {
				if (NotationPackage.eINSTANCE.getLineStyle_LineColor() == msg
						.getFeature()) {
					return true;
				}
				if (NotationPackage.eINSTANCE.getView_Styles() == msg
						.getFeature()) {
					return UpdaterUtil.affects(msg, NotationPackage.eINSTANCE
							.getLineStyle());
				}
				return false;
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getLineStyle_LineColor(), foregroundColorRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getView_Styles(),
				foregroundColorRefresher);
	}

	/**
	 * @generated
	 */
	protected void refreshVisibility() {
		boolean isVisible = getDiagramEdge().isVisible();
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
	protected void refreshBendpoints() {
		RelativeBendpoints bendpoints = (RelativeBendpoints) getDiagramEdge()
				.getBendpoints();
		if (bendpoints == null) {
			getConnectionFigure().setRoutingConstraint(Collections.EMPTY_LIST);
			return;
		}
		List modelConstraint = bendpoints.getPoints();
		List figureConstraint = new ArrayList();
		for (int i = 0; i < modelConstraint.size(); i++) {
			RelativeBendpoint wbp = (RelativeBendpoint) modelConstraint.get(i);
			org.eclipse.draw2d.RelativeBendpoint rbp = new org.eclipse.draw2d.RelativeBendpoint(
					getConnectionFigure());
			rbp.setRelativeDimensions(new Dimension(wbp.getSourceX(), wbp
					.getSourceY()), new Dimension(wbp.getTargetX(), wbp
					.getTargetY()));
			rbp.setWeight((i + 1) / ((float) modelConstraint.size() + 1));
			figureConstraint.add(rbp);
		}
		getConnectionFigure().setRoutingConstraint(figureConstraint);
	}

	/**
	 * @generated
	 */
	protected void refreshFont() {
		FontStyle style = (FontStyle) getDiagramEdge().getStyle(
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
	protected void refreshBackgroundColor() {
		FillStyle style = (FillStyle) getDiagramEdge().getStyle(
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
	protected void refreshForegroundColor() {
		LineStyle style = (LineStyle) getDiagramEdge().getStyle(
				NotationPackage.eINSTANCE.getLineStyle());
		Color toDispose = createdForegroundColor;
		if (style != null) {
			int foregroundColor = style.getLineColor();
			int red = foregroundColor & 0x000000FF;
			int green = (foregroundColor & 0x0000FF00) >> 8;
			int blue = (foregroundColor & 0x00FF0000) >> 16;
			Color currentColor = getFigure().getForegroundColor();
			if (currentColor != null && currentColor.getRed() == red
					&& currentColor.getGreen() == green
					&& currentColor.getBlue() == blue) {
				return;
			}
			createdForegroundColor = new Color(null, red, green, blue);
			getFigure().setForegroundColor(createdForegroundColor);
		} else {
			getFigure().setForegroundColor(
					getViewer().getControl().getForeground());
			createdForegroundColor = null;
		}
		if (toDispose != null) {
			toDispose.dispose();
		}
	}

	/**
	 * The color (created by {@link #refreshForegroundColor()}) currently assigned to the figure.
	 * Whenever another color is assigned to it, it is safe to dispose the previous one.
	 * @generated
	 */
	private Color createdForegroundColor;

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshVisibility();
		refreshBendpoints();
		refreshFont();
		refreshBackgroundColor();
		refreshForegroundColor();
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
	public void addNotify() {
		super.addNotify();
		getConnectionFigure().setConnectionRouter(
				new BendpointConnectionRouter());
	}

	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		Connection result = primCreateFigure();
		myDecorationManager = createDecorationManager(result);
		return result;
	}

	/**
	 * @generated
	 */
	protected IDecorationManager createDecorationManager(Connection connection) {
		return new ConnectionDecorationManager(connection);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	private Connection primCreateFigure() {
		return new DashedLineOpenArrow();
	}

	/**
	 * @generated
	 */
	public class DashedLineOpenArrow extends PolylineConnection {

		/**
		 * @generated
		 */
		public DashedLineOpenArrow() {
			this.setLineStyle(Graphics.LINE_DASH);

			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			return df;
		}

	}

	/**
	 * @generated
	 */
	private class TreeEditPartAdapter extends BaseTreeEditPart {
		/**
		 * @generated
		 */
		public TreeEditPartAdapter() {
			super(getDiagramEdge(), MindmapDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());
		}

		/**
		 * @generated
		 */
		protected void createEditPolicies() {
			installEditPolicy(EditPolicy.COMPONENT_ROLE,
					new Relationship3ComponentEditPolicy());
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
			RelationshipLabel3EditPart primaryLabelEditPart = getPrimaryLabelEditPart();
			if (primaryLabelEditPart != null) {
				return primaryLabelEditPart.getLabelTextDisplayer();
			}
			return super.createLabelTextDisplayer();
		}

		/**
		 * @generated
		 */
		protected Image getImage() {
			RelationshipLabel3EditPart primaryLabelEditPart = getPrimaryLabelEditPart();
			if (primaryLabelEditPart != null) {
				return primaryLabelEditPart.getLabelIcon();
			}
			return null;
		}

		/**
		 * @generated
		 */
		private RelationshipLabel3EditPart getPrimaryLabelEditPart() {
			for (Iterator it = getDiagramEdge().getChildren().iterator(); it
					.hasNext();) {
				View nextChild = (View) it.next();
				if (MindmapVisualIDRegistry.getVisualID(nextChild) == RelationshipLabel3EditPart.VISUAL_ID) {
					return (RelationshipLabel3EditPart) Relationship3EditPart.this
							.getViewer().getEditPartRegistry().get(nextChild);
				}
			}
			return null;
		}

		/**
		 * Since labels are not selectable edit parts, they are filtered from the overview as well.
		 * @generated
		 */
		protected List getModelChildren() {
			List result = new ArrayList();
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
