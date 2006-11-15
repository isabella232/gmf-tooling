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
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts;

import java.util.Iterator;

import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.PortItemSemanticEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.TaiPanExtNodeLabelHostLayoutEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PortEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public PortEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PortItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());

	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		XYLayoutEditPolicy lep = new XYLayoutEditPolicy() {

			protected void decorateChild(EditPart child) {
				if (isExternalLabel(child)) {
					return;
				}
				super.decorateChild(child);
			}

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = super.createChildEditPolicy(child);
				if (result == null) {
					return new ResizableShapeEditPolicy();
				}
				return result;
			}
		};
		TaiPanExtNodeLabelHostLayoutEditPolicy xlep = new TaiPanExtNodeLabelHostLayoutEditPolicy() {

			protected boolean isExternalLabel(EditPart editPart) {
				return PortEditPart.this.isExternalLabel(editPart);
			}
		};
		xlep.setRealLayoutEditPolicy(lep);
		return xlep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		PortFigure figure = new PortFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public PortFigure getPrimaryShape() {
		return (PortFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(60), getMapMode().DPtoLP(50));
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		ResizableEditPolicy ep = (ResizableEditPolicy) super.getPrimaryDragEditPolicy();

		ep.setResizeDirections(PositionConstants.NONE);

		return ep;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			nodeShape.setLayoutManager(new FreeformLayout() {

				public Object getConstraint(IFigure figure) {
					Object result = constraints.get(figure);
					if (result == null) {
						result = new Rectangle(0, 0, -1, -1);
					}
					return result;
				}
			});
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(TaiPanVisualIDRegistry.getType(PortLocationEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	protected boolean isExternalLabel(EditPart childEditPart) {
		if (childEditPart instanceof PortLocationEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected IFigure getExternalLabelsContainer() {
		LayerManager root = (LayerManager) getRoot();
		return root.getLayer(TaiPanEditPartFactory.EXTERNAL_NODE_LABELS_LAYER);
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (isExternalLabel(childEditPart)) {
			IFigure labelFigure = ((GraphicalEditPart) childEditPart).getFigure();
			getExternalLabelsContainer().add(labelFigure);
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (isExternalLabel(childEditPart)) {
			IFigure labelFigure = ((GraphicalEditPart) childEditPart).getFigure();
			getExternalLabelsContainer().remove(labelFigure);
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	public void removeNotify() {
		for (Iterator it = getChildren().iterator(); it.hasNext();) {
			EditPart childEditPart = (EditPart) it.next();
			if (isExternalLabel(childEditPart)) {
				IFigure labelFigure = ((GraphicalEditPart) childEditPart).getFigure();
				getExternalLabelsContainer().remove(labelFigure);
			}
		}
		super.removeNotify();
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() == getModel() && EcorePackage.eINSTANCE.getEModelElement_EAnnotations().equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
	}

	/**
	 * @generated
	 */
	public class PortFigure extends org.eclipse.draw2d.Layer {

		/**
		 * @generated
		 */
		public PortFigure() {

			this.setLayoutManager(new org.eclipse.draw2d.XYLayout());

			this.setPreferredSize(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(60), getMapMode().DPtoLP(50)));
			this.setMaximumSize(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(60), getMapMode().DPtoLP(50)));
			this.setMinimumSize(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(60), getMapMode().DPtoLP(50)));
			this.setSize(getMapMode().DPtoLP(60), getMapMode().DPtoLP(50));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			org.eclipse.draw2d.RectangleFigure walls0 = new org.eclipse.draw2d.RectangleFigure();
			walls0.setFill(true);
			walls0.setFillXOR(false);
			walls0.setOutline(true);
			walls0.setOutlineXOR(false);
			walls0.setLineWidth(1);
			walls0.setLineStyle(org.eclipse.draw2d.Graphics.LINE_SOLID);
			walls0.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
			walls0.setBackgroundColor(org.eclipse.draw2d.ColorConstants.darkGray);

			this.add(walls0, new org.eclipse.draw2d.geometry.Rectangle(getMapMode().DPtoLP(10), getMapMode().DPtoLP(40), getMapMode().DPtoLP(40), getMapMode().DPtoLP(10)));

			org.eclipse.draw2d.Polygon mainRoof0 = new org.eclipse.draw2d.Polygon();
			mainRoof0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(30), getMapMode().DPtoLP(10)));
			mainRoof0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(60), getMapMode().DPtoLP(40)));
			mainRoof0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(40)));
			mainRoof0.setFill(true);
			mainRoof0.setFillXOR(false);
			mainRoof0.setOutline(true);
			mainRoof0.setOutlineXOR(false);
			mainRoof0.setLineWidth(1);
			mainRoof0.setLineStyle(org.eclipse.draw2d.Graphics.LINE_SOLID);
			mainRoof0.setForegroundColor(org.eclipse.draw2d.ColorConstants.orange);
			mainRoof0.setBackgroundColor(org.eclipse.draw2d.ColorConstants.orange);

			this.add(mainRoof0);

			org.eclipse.draw2d.Polygon topRoof0 = new org.eclipse.draw2d.Polygon();
			topRoof0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(30), getMapMode().DPtoLP(0)));
			topRoof0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(50), getMapMode().DPtoLP(20)));
			topRoof0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(10), getMapMode().DPtoLP(20)));
			topRoof0.setFill(true);
			topRoof0.setFillXOR(false);
			topRoof0.setOutline(true);
			topRoof0.setOutlineXOR(false);
			topRoof0.setLineWidth(1);
			topRoof0.setLineStyle(org.eclipse.draw2d.Graphics.LINE_SOLID);
			topRoof0.setForegroundColor(org.eclipse.draw2d.ColorConstants.orange);
			topRoof0.setBackgroundColor(org.eclipse.draw2d.ColorConstants.orange);

			this.add(topRoof0);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = true;

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

	}

}
