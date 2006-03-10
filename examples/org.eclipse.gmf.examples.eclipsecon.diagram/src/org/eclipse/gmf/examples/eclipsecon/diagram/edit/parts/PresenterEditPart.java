package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;

import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.PresenterCanonicalEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.PresenterGraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.PresenterItemSemanticEditPolicy;

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
public class PresenterEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	public PresenterEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new PresenterItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new PresenterGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new PresenterCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ActorFigure figure = new ActorFigure();
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(EclipseconSemanticHints.Presenter_1001Labels.PRESENTERNAME_4001_TEXT);
	}

	/**
	 * @generated
	 */
	public class ActorFigure extends org.eclipse.draw2d.RectangleFigure {

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates;

		/**
		 * @generated
		 */
		public ActorFigure() {

			org.eclipse.draw2d.ToolbarLayout myGenLayoutManager = new org.eclipse.draw2d.ToolbarLayout();
			myGenLayoutManager.setStretchMinorAxis(false);
			myGenLayoutManager
					.setMinorAlignment(org.eclipse.draw2d.ToolbarLayout.ALIGN_TOPLEFT);
			myGenLayoutManager.setSpacing(5);
			myGenLayoutManager.setVertical(true);

			this.setLayoutManager(myGenLayoutManager);

			this.setFill(false);
			this.setOutline(false);

			org.eclipse.draw2d.IFigure childHead = createFigureHead();
			setFigureHead(childHead);
			add(childHead);

			org.eclipse.draw2d.IFigure childBody = createFigureBody();
			setFigureBody(childBody);
			add(childBody);

			org.eclipse.draw2d.IFigure childLabel = createFigureLabel();
			setFigureLabel(childLabel);
			add(childLabel);

		}

		private org.eclipse.draw2d.IFigure fHead;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.IFigure getFigureHead() {
			return fHead;
		}

		/**
		 * @generated
		 */
		protected void setFigureHead(org.eclipse.draw2d.IFigure figure) {
			fHead = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.IFigure createFigureHead() {
			org.eclipse.draw2d.Ellipse rv = new org.eclipse.draw2d.Ellipse();

			rv.setLineWidth(2);
			rv.setSize(getMapMode().DPtoLP(60), getMapMode().DPtoLP(60));

			return rv;
		}

		private org.eclipse.draw2d.IFigure fBody;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.IFigure getFigureBody() {
			return fBody;
		}

		/**
		 * @generated
		 */
		protected void setFigureBody(org.eclipse.draw2d.IFigure figure) {
			fBody = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.IFigure createFigureBody() {
			org.eclipse.draw2d.Polygon rv = new org.eclipse.draw2d.Polygon();

			rv.addPoint(new org.eclipse.draw2d.geometry.Point(30, 60));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(30, 85));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(0, 85));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(0, 88));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(30, 88));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(30, 130));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(0, 170));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(4, 170));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(31, 133));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(60, 170));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(64, 170));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(33, 130));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(33, 88));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(63, 88));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(63, 85));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(33, 85));
			rv.addPoint(new org.eclipse.draw2d.geometry.Point(33, 60));

			return rv;
		}

		private org.eclipse.draw2d.IFigure fLabel;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.IFigure getFigureLabel() {
			return fLabel;
		}

		/**
		 * @generated
		 */
		protected void setFigureLabel(org.eclipse.draw2d.IFigure figure) {
			fLabel = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.IFigure createFigureLabel() {
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
