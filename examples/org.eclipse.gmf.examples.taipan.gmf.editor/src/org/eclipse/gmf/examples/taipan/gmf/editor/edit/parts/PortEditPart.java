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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;

import org.eclipse.gef.handles.MoveHandle;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.PortCanonicalEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.PortGraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.PortItemSemanticEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.TaiPanTextSelectionEditPolicy;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

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
	public static final int VISUAL_ID = 1001;

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
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new TaiPanTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		});
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
		return new ResizableShapeEditPolicy() {

			protected List createSelectionHandles() {
				final GraphicalEditPart part = (GraphicalEditPart) getHost();
				final List list = new ArrayList();
				addMoveHandle(part, list);

				return list;
			}

			private void addMoveHandle(final GraphicalEditPart part, final List list) {
				MoveHandle moveHandle = new MoveHandle(part);
				list.add(moveHandle);
			}
		};
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
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
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
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (isExternalLabel(childEditPart)) {
			IFigure labelFigure = ((GraphicalEditPart) childEditPart).getFigure();
			getExternalLabelsContainer().add(labelFigure);
		} else {
			super.addChildVisual(childEditPart, -1);
		}
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (isExternalLabel(childEditPart)) {
			IFigure labelFigure = ((GraphicalEditPart) childEditPart).getFigure();
			getExternalLabelsContainer().remove(labelFigure);
		} else {
			super.removeChildVisual(childEditPart);
		}
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

			org.eclipse.draw2d.RectangleFigure childWalls = createFigureWalls();
			setFigureWalls(childWalls);
			add(childWalls);
			org.eclipse.draw2d.geometry.Rectangle layoutDataWalls = new org.eclipse.draw2d.geometry.Rectangle();
			layoutDataWalls.x = 10;
			layoutDataWalls.y = 40;
			layoutDataWalls.width = 40;
			layoutDataWalls.height = 10;
			myGenLayoutManager.setConstraint(childWalls, layoutDataWalls);

			org.eclipse.draw2d.Polygon childMainRoof = createFigureMainRoof();
			setFigureMainRoof(childMainRoof);
			add(childMainRoof);

			org.eclipse.draw2d.Polygon childTopRoof = createFigureTopRoof();
			setFigureTopRoof(childTopRoof);
			add(childTopRoof);

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
		protected void setFigureWalls(org.eclipse.draw2d.RectangleFigure figure) {
			fWalls = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.RectangleFigure createFigureWalls() {
			org.eclipse.draw2d.RectangleFigure Walls = new org.eclipse.draw2d.RectangleFigure();
			Walls.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
			Walls.setBackgroundColor(org.eclipse.draw2d.ColorConstants.darkGray);

			return Walls;
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
		protected void setFigureMainRoof(org.eclipse.draw2d.Polygon figure) {
			fMainRoof = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Polygon createFigureMainRoof() {
			org.eclipse.draw2d.Polygon MainRoof = new org.eclipse.draw2d.Polygon();
			MainRoof.setFill(true);
			MainRoof.setForegroundColor(org.eclipse.draw2d.ColorConstants.orange);
			MainRoof.setBackgroundColor(org.eclipse.draw2d.ColorConstants.orange);
			MainRoof.addPoint(new org.eclipse.draw2d.geometry.Point(30, 10));
			MainRoof.addPoint(new org.eclipse.draw2d.geometry.Point(60, 40));
			MainRoof.addPoint(new org.eclipse.draw2d.geometry.Point(0, 40));

			return MainRoof;
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
		protected void setFigureTopRoof(org.eclipse.draw2d.Polygon figure) {
			fTopRoof = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Polygon createFigureTopRoof() {
			org.eclipse.draw2d.Polygon TopRoof = new org.eclipse.draw2d.Polygon();
			TopRoof.setFill(true);
			TopRoof.setForegroundColor(org.eclipse.draw2d.ColorConstants.orange);
			TopRoof.setBackgroundColor(org.eclipse.draw2d.ColorConstants.orange);
			TopRoof.addPoint(new org.eclipse.draw2d.geometry.Point(30, 0));
			TopRoof.addPoint(new org.eclipse.draw2d.geometry.Point(50, 20));
			TopRoof.addPoint(new org.eclipse.draw2d.geometry.Point(10, 20));

			return TopRoof;
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
