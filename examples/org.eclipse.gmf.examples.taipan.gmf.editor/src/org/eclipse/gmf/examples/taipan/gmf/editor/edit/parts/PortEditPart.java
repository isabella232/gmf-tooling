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

import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;

import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.PortCanonicalEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.PortGraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.PortItemSemanticEditPolicy;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
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
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new PortGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new PortCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		return new XYLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = super.createChildEditPolicy(child);
				if (result == null) {
					return new ResizableShapeEditPolicy();
				}
				return result;
			}
		};
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
		return new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
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
		return getChildBySemanticHint(TaiPanVisualIDRegistry.getType(Port_locationEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	protected boolean isExternalLabel(EditPart childEditPart) {
		if (childEditPart instanceof Port_locationEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected IFigure getExternalLabelsContainer() {
		DiagramRootEditPart root = (DiagramRootEditPart) getRoot();
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
	public class PortFigure extends org.eclipse.draw2d.Layer {

		/**
		 * @generated
		 */
		public PortFigure() {

			org.eclipse.draw2d.XYLayout myGenLayoutManager = new org.eclipse.draw2d.XYLayout();

			this.setLayoutManager(myGenLayoutManager);

			this.setPreferredSize(getMapMode().DPtoLP(60), getMapMode().DPtoLP(50));
			this.setSize(getMapMode().DPtoLP(60), getMapMode().DPtoLP(50));
			this.setMaximumSize(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(60), getMapMode().DPtoLP(50)));
			this.setMinimumSize(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(60), getMapMode().DPtoLP(50)));

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {
			org.eclipse.draw2d.RectangleFigure fig_0 = new org.eclipse.draw2d.RectangleFigure();
			fig_0.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
			fig_0.setBackgroundColor(org.eclipse.draw2d.ColorConstants.darkGray);

			setFigureWalls(fig_0);
			org.eclipse.draw2d.geometry.Rectangle layData0 = new org.eclipse.draw2d.geometry.Rectangle();
			layData0.x = 10;
			layData0.y = 40;
			layData0.width = 40;
			layData0.height = 10;

			this.add(fig_0, layData0);
			org.eclipse.draw2d.Polygon fig_1 = new org.eclipse.draw2d.Polygon();
			fig_1.setFill(true);
			fig_1.setForegroundColor(org.eclipse.draw2d.ColorConstants.orange);
			fig_1.setBackgroundColor(org.eclipse.draw2d.ColorConstants.orange);
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(30, 10));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(60, 40));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(0, 40));

			setFigureMainRoof(fig_1);

			Object layData1 = null;

			this.add(fig_1, layData1);
			org.eclipse.draw2d.Polygon fig_2 = new org.eclipse.draw2d.Polygon();
			fig_2.setFill(true);
			fig_2.setForegroundColor(org.eclipse.draw2d.ColorConstants.orange);
			fig_2.setBackgroundColor(org.eclipse.draw2d.ColorConstants.orange);
			fig_2.addPoint(new org.eclipse.draw2d.geometry.Point(30, 0));
			fig_2.addPoint(new org.eclipse.draw2d.geometry.Point(50, 20));
			fig_2.addPoint(new org.eclipse.draw2d.geometry.Point(10, 20));

			setFigureTopRoof(fig_2);

			Object layData2 = null;

			this.add(fig_2, layData2);
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.RectangleFigure fWalls;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.RectangleFigure getFigureWalls() {
			return fWalls;
		}

		/**
		 * @generated
		 */
		private void setFigureWalls(org.eclipse.draw2d.RectangleFigure fig) {
			fWalls = fig;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Polygon fMainRoof;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.Polygon getFigureMainRoof() {
			return fMainRoof;
		}

		/**
		 * @generated
		 */
		private void setFigureMainRoof(org.eclipse.draw2d.Polygon fig) {
			fMainRoof = fig;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Polygon fTopRoof;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.Polygon getFigureTopRoof() {
			return fTopRoof;
		}

		/**
		 * @generated
		 */
		private void setFigureTopRoof(org.eclipse.draw2d.Polygon fig) {
			fTopRoof = fig;
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
