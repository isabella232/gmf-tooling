package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;

import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.TimeSlotCanonicalEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.TimeSlotGraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.TimeSlotItemSemanticEditPolicy;

import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconDiagramEditorPlugin;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconSemanticHints;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;

import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TimeSlotEditPart extends ShapeNodeEditPart {

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
	public TimeSlotEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new TimeSlotItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new TimeSlotGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new TimeSlotCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		SlotFigure figure = new SlotFigure();
		figure.setUseLocalCoordinates(false);
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public SlotFigure getPrimaryShape() {
		return (SlotFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof TimeSlot_startEditPart) {
			((TimeSlot_startEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureLabelStart());
		}
		if (childEditPart instanceof TimeSlot_endEditPart) {
			((TimeSlot_endEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureLabelEnd());
		}
		super.addChildVisual(childEditPart, index);
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

		IFigure decorationShape = createDecorationPane();
		if (decorationShape != null) {
			figure.add(decorationShape);
		}

		return figure;
	}

	/**
	 * @generated
	 */
	private IFigure createDecorationPane() {
		View view = (View) getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			return null;
		}

		Figure decorationPane = new Figure();
		decorationPane.setLayoutManager(new BorderLayout());

		ImageFigureEx imageFigure = new ImageFigureEx(
				EclipseconDiagramEditorPlugin.getInstance().getBundledImage(
						"icons/shortcut.gif"), PositionConstants.EAST);
		decorationPane.add(imageFigure, BorderLayout.BOTTOM);
		return decorationPane;
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
		return getChildBySemanticHint(EclipseconSemanticHints.TimeSlot_2001Labels.TIMESLOTSTART_4003);
	}

	/**
	 * @generated
	 */
	public class SlotFigure extends org.eclipse.draw2d.RoundedRectangle {

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates;

		/**
		 * @generated
		 */
		public SlotFigure() {

			this.setLayoutManager(new ToolbarLayout());

			this.setLineWidth(2);
			this.setForegroundColor(org.eclipse.draw2d.ColorConstants.cyan);
			this.setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(
					getMapMode().DPtoLP(20), getMapMode().DPtoLP(20)));

			org.eclipse.draw2d.IFigure childLabelStart = createFigureLabelStart();
			setFigureLabelStart(childLabelStart);
			add(childLabelStart);

			org.eclipse.draw2d.IFigure childLabelEnd = createFigureLabelEnd();
			setFigureLabelEnd(childLabelEnd);
			add(childLabelEnd);

		}

		private org.eclipse.draw2d.IFigure fLabelStart;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.IFigure getFigureLabelStart() {
			return fLabelStart;
		}

		/**
		 * @generated
		 */
		protected void setFigureLabelStart(org.eclipse.draw2d.IFigure figure) {
			fLabelStart = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.IFigure createFigureLabelStart() {
			org.eclipse.draw2d.Label rv = new org.eclipse.draw2d.Label();

			return rv;
		}

		private org.eclipse.draw2d.IFigure fLabelEnd;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.IFigure getFigureLabelEnd() {
			return fLabelEnd;
		}

		/**
		 * @generated
		 */
		protected void setFigureLabelEnd(org.eclipse.draw2d.IFigure figure) {
			fLabelEnd = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.IFigure createFigureLabelEnd() {
			org.eclipse.draw2d.Label rv = new org.eclipse.draw2d.Label();
			rv.setText("vfsddf");

			return rv;
		}

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
