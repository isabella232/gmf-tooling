package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;

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
	protected IFigure primaryShape;

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
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ActorFigure getPrimaryShape() {
		return (ActorFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof Presenter_nameEditPart) {
			((Presenter_nameEditPart) childEditPart)
					.setLabel((Label) getPrimaryShape().getFigureLabel());
		} else {
			super.addChildVisual(childEditPart, index);
		}
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
			ToolbarLayout layout = new ToolbarLayout();
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
		return getChildBySemanticHint(EclipseconSemanticHints.Presenter_1001Labels.PRESENTERNAME_4001);
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

			org.eclipse.draw2d.Ellipse childHead = createFigureHead();
			setFigureHead(childHead);
			add(childHead);

			org.eclipse.draw2d.Polygon childBody = createFigureBody();
			setFigureBody(childBody);
			add(childBody);

			org.eclipse.draw2d.Label childLabel = createFigureLabel();
			setFigureLabel(childLabel);
			add(childLabel);

		}

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
		protected void setFigureHead(org.eclipse.draw2d.Ellipse figure) {
			fHead = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Ellipse createFigureHead() {
			org.eclipse.draw2d.Ellipse rv = new org.eclipse.draw2d.Ellipse();

			rv.setLineWidth(2);
			rv.setSize(getMapMode().DPtoLP(60), getMapMode().DPtoLP(60));

			return rv;
		}

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
		protected void setFigureBody(org.eclipse.draw2d.Polygon figure) {
			fBody = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Polygon createFigureBody() {
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

		private org.eclipse.draw2d.Label fLabel;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.Label getFigureLabel() {
			return fLabel;
		}

		/**
		 * @generated
		 */
		protected void setFigureLabel(org.eclipse.draw2d.Label figure) {
			fLabel = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Label createFigureLabel() {
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
