package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;
import org.eclipse.draw2d.Figure;

import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.TimeSlotCanonicalEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.TimeSlotGraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.TimeSlotItemSemanticEditPolicy;

import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconDiagramEditorPlugin;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

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
		return new SlotFigure();
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
		figure.setBorder(new MarginBorder(3, 5, 2, 5));
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		if (shape.getLayoutManager() == null) {
			shape.setLayoutManager(new StackLayout());
		}

		IFigure shapeContents = new Figure();
		shape.add(shapeContents);
		shapeContents.setLayoutManager(new BorderLayout());
		addContentPane(shapeContents);
		decorateShape(shapeContents);

		return figure;
	}

	/**
	 * @generated
	 */
	private void decorateShape(IFigure shapeContents) {
		View view = (View) getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcutted"); //$NON-NLS-1$
		if (annotation == null) {
			return;
		}

		Figure decorationPane = new Figure();
		decorationPane.setLayoutManager(new BorderLayout());
		shapeContents.add(decorationPane, BorderLayout.BOTTOM);

		ImageFigureEx imageFigure = new ImageFigureEx(
				EclipseconDiagramEditorPlugin.getInstance().getBundledImage(
						"icons/shortcut.gif"));
		decorationPane.add(imageFigure, BorderLayout.RIGHT);
	}

	/**
	 * @generated
	 */
	protected void addContentPane(IFigure shape) {
		contentPane = new Figure();
		shape.add(contentPane, BorderLayout.CENTER);
		ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
		layout.setSpacing(getMapMode().DPtoLP(5));
		contentPane.setLayoutManager(layout);
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
	public class SlotFigure extends org.eclipse.draw2d.RoundedRectangle {
		/**
		 * @generated
		 */
		public SlotFigure() {

			this.setFill(true);
			this.setLineWidth(2);
			this.setForegroundColor(org.eclipse.draw2d.ColorConstants.cyan);
			this.setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(
					getMapMode().DPtoLP(20), getMapMode().DPtoLP(20)));
		}

	}

}
