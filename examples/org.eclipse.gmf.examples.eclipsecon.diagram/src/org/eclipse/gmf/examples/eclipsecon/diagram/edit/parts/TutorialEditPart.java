package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;

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

import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

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
		ResourceFigure figure = new ResourceFigure();
		figure.setUseLocalCoordinates(false);
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
		return getChildBySemanticHint(EclipseconSemanticHints.Tutorial_1002Labels.TUTORIALTITLE_4002_TEXT);
	}

	/**
	 * @generated
	 */
	public class ResourceFigure extends org.eclipse.draw2d.RectangleFigure {

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates;

		/**
		 * @generated
		 */
		public ResourceFigure() {

			org.eclipse.draw2d.IFigure childtag = createFiguretag();
			setFiguretag(childtag);
			add(childtag);

			org.eclipse.draw2d.IFigure childResourceNameLabel = createFigureResourceNameLabel();
			setFigureResourceNameLabel(childResourceNameLabel);
			add(childResourceNameLabel);

			org.eclipse.draw2d.IFigure childResourceLocationLabel = createFigureResourceLocationLabel();
			setFigureResourceLocationLabel(childResourceLocationLabel);
			add(childResourceLocationLabel);

		}

		private org.eclipse.draw2d.IFigure ftag;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.IFigure getFiguretag() {
			return ftag;
		}

		/**
		 * @generated
		 */
		protected void setFiguretag(org.eclipse.draw2d.IFigure figure) {
			ftag = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.IFigure createFiguretag() {
			org.eclipse.draw2d.Label rv = new org.eclipse.draw2d.Label();
			rv.setText("<<Resource>>");

			return rv;
		}

		private org.eclipse.draw2d.IFigure fResourceNameLabel;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.IFigure getFigureResourceNameLabel() {
			return fResourceNameLabel;
		}

		/**
		 * @generated
		 */
		protected void setFigureResourceNameLabel(
				org.eclipse.draw2d.IFigure figure) {
			fResourceNameLabel = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.IFigure createFigureResourceNameLabel() {
			org.eclipse.draw2d.Label rv = new org.eclipse.draw2d.Label();
			rv.setText("");

			return rv;
		}

		private org.eclipse.draw2d.IFigure fResourceLocationLabel;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.IFigure getFigureResourceLocationLabel() {
			return fResourceLocationLabel;
		}

		/**
		 * @generated
		 */
		protected void setFigureResourceLocationLabel(
				org.eclipse.draw2d.IFigure figure) {
			fResourceLocationLabel = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.IFigure createFigureResourceLocationLabel() {
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
