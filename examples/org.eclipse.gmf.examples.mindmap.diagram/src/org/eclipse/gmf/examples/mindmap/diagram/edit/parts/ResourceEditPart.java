package org.eclipse.gmf.examples.mindmap.diagram.edit.parts;

import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;

import org.eclipse.gef.editpolicies.LayoutEditPolicy;

import org.eclipse.gmf.examples.mindmap.diagram.edit.policies.ResourceCanonicalEditPolicy;
import org.eclipse.gmf.examples.mindmap.diagram.edit.policies.ResourceGraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.mindmap.diagram.edit.policies.ResourceItemSemanticEditPolicy;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;

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
public class ResourceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1002;

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
	public ResourceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ResourceItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new ResourceGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new ResourceCanonicalEditPolicy());
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
		ResourceFigure figure = new ResourceFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ResourceFigure getPrimaryShape() {
		return (ResourceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		return new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode()
				.DPtoLP(40));
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
		return getChildBySemanticHint(MindmapVisualIDRegistry
				.getType(Resource_name_emailEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	protected boolean isExternalLabel(EditPart childEditPart) {
		if (childEditPart instanceof Resource_name_emailEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected IFigure getExternalLabelsContainer() {
		DiagramRootEditPart root = (DiagramRootEditPart) getRoot();
		return root.getLayer(MindmapEditPartFactory.EXTERNAL_NODE_LABELS_LAYER);
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (isExternalLabel(childEditPart)) {
			IFigure labelFigure = ((GraphicalEditPart) childEditPart)
					.getFigure();
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
			IFigure labelFigure = ((GraphicalEditPart) childEditPart)
					.getFigure();
			getExternalLabelsContainer().remove(labelFigure);
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	public class ResourceFigure extends org.eclipse.draw2d.RectangleFigure {

		/**
		 * @generated
		 */
		public ResourceFigure() {

			org.eclipse.draw2d.XYLayout myGenLayoutManager = new org.eclipse.draw2d.XYLayout();

			this.setLayoutManager(myGenLayoutManager);

			this.setFill(false);
			this.setOutline(false);
			this.setLineWidth(0);
			this.setPreferredSize(getMapMode().DPtoLP(40), getMapMode().DPtoLP(
					60));
			this.setSize(getMapMode().DPtoLP(40), getMapMode().DPtoLP(60));
			this.setMaximumSize(new org.eclipse.draw2d.geometry.Dimension(
					getMapMode().DPtoLP(40), getMapMode().DPtoLP(60)));
			this.setMinimumSize(new org.eclipse.draw2d.geometry.Dimension(
					getMapMode().DPtoLP(40), getMapMode().DPtoLP(60)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {
			org.eclipse.draw2d.Ellipse fig_0 = new org.eclipse.draw2d.Ellipse();
			fig_0.setForegroundColor(new org.eclipse.swt.graphics.Color(null,
					220, 220, 250));
			fig_0.setBackgroundColor(new org.eclipse.swt.graphics.Color(null,
					230, 230, 255));
			fig_0.setSize(getMapMode().DPtoLP(40), getMapMode().DPtoLP(20));

			setFigureHead(fig_0);

			Object layData0 = null;

			this.add(fig_0, layData0);
			org.eclipse.draw2d.Polygon fig_1 = new org.eclipse.draw2d.Polygon();
			fig_1.setFill(true);
			fig_1.setForegroundColor(new org.eclipse.swt.graphics.Color(null,
					220, 220, 250));
			fig_1.setBackgroundColor(new org.eclipse.swt.graphics.Color(null,
					230, 230, 255));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(23, 19));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(23, 24));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(39, 24));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(39, 29));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(23, 29));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(23, 36));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(39, 48));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(39, 53));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(20, 42));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(1, 53));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(1, 48));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(17, 36));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(17, 29));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(1, 29));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(1, 24));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(17, 24));
			fig_1.addPoint(new org.eclipse.draw2d.geometry.Point(17, 19));

			setFigureBody(fig_1);

			Object layData1 = null;

			this.add(fig_1, layData1);
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Ellipse fHead;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.Ellipse getFigureHead() {
			return fHead;
		}

		/**
		 * @generated
		 */
		private void setFigureHead(org.eclipse.draw2d.Ellipse fig) {
			fHead = fig;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Polygon fBody;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.Polygon getFigureBody() {
			return fBody;
		}

		/**
		 * @generated
		 */
		private void setFigureBody(org.eclipse.draw2d.Polygon fig) {
			fBody = fig;
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
