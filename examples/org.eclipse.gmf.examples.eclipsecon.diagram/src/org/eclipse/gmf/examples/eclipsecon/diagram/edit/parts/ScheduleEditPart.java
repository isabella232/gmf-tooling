package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.gef.EditPolicy;

import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.ScheduleCanonicalEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.ScheduleGraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.ScheduleItemSemanticEditPolicy;

import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconDiagramEditorPlugin;

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
public class ScheduleEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	public ScheduleEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ScheduleItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new ScheduleGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new ScheduleCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ThickFigure figure = new ThickFigure();
		figure.setUseLocalCoordinates(true);
		return figure;
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
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
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
	public class ThickFigure extends org.eclipse.draw2d.RectangleFigure {

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates;

		/**
		 * @generated
		 */
		public ThickFigure() {

			this.setLineWidth(3);

			org.eclipse.draw2d.IFigure childTitleLabel = createFigureTitleLabel();
			setFigureTitleLabel(childTitleLabel);
			add(childTitleLabel);

		}

		private org.eclipse.draw2d.IFigure fTitleLabel;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.IFigure getFigureTitleLabel() {
			return fTitleLabel;
		}

		/**
		 * @generated
		 */
		protected void setFigureTitleLabel(org.eclipse.draw2d.IFigure figure) {
			fTitleLabel = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.IFigure createFigureTitleLabel() {
			org.eclipse.draw2d.Label rv = new org.eclipse.draw2d.Label();

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
