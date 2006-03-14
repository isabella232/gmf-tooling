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

import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.TutorialCanonicalEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.TutorialGraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.TutorialItemSemanticEditPolicy;

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
public class TutorialEditPart extends ShapeNodeEditPart {

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
	public TutorialEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new TutorialItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new TutorialGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new TutorialCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		TutorialFigure figure = new TutorialFigure();
		figure.setUseLocalCoordinates(false);
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public TutorialFigure getPrimaryShape() {
		return (TutorialFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof Tutorial_titleEditPart) {
			((Tutorial_titleEditPart) childEditPart)
					.setLabel((Label) getPrimaryShape().getFigureTitleLabel());
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
		return getChildBySemanticHint(EclipseconSemanticHints.Tutorial_1002Labels.TUTORIALTITLE_4002);
	}

	/**
	 * @generated
	 */
	public class TutorialFigure extends org.eclipse.draw2d.RectangleFigure {

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates;

		/**
		 * @generated
		 */
		public TutorialFigure() {

			org.eclipse.draw2d.Label childTag = createFigureTag();
			setFigureTag(childTag);
			add(childTag);

			org.eclipse.draw2d.Label childTitleLabel = createFigureTitleLabel();
			setFigureTitleLabel(childTitleLabel);
			add(childTitleLabel);

		}

		private org.eclipse.draw2d.Label fTag;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.Label getFigureTag() {
			return fTag;
		}

		/**
		 * @generated
		 */
		protected void setFigureTag(org.eclipse.draw2d.Label figure) {
			fTag = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Label createFigureTag() {
			org.eclipse.draw2d.Label rv = new org.eclipse.draw2d.Label();
			rv.setText("<<Tutorial>>");

			return rv;
		}

		private org.eclipse.draw2d.Label fTitleLabel;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.Label getFigureTitleLabel() {
			return fTitleLabel;
		}

		/**
		 * @generated
		 */
		protected void setFigureTitleLabel(org.eclipse.draw2d.Label figure) {
			fTitleLabel = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Label createFigureTitleLabel() {
			org.eclipse.draw2d.Label rv = new org.eclipse.draw2d.Label();
			rv.setText("");

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
