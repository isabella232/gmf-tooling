package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;

import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.ResourceCanonicalEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.ResourceGraphicalNodeEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.ResourceItemSemanticEditPolicy;

import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconDiagramEditorPlugin;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconSemanticHints;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
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
public class ResourceEditPart extends ShapeNodeEditPart {

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
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ResourceFigure figure = new ResourceFigure();
		figure.setUseLocalCoordinates(false);
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
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof Resource_UnknownEditPart) {
			IFigure labelFigure = ((Resource_UnknownEditPart) childEditPart).getFigure();
			getExternalLabelsContainer().add(labelFigure);
			return;
		}
		if (childEditPart instanceof Resource_nameEditPart) {
			((Resource_nameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureResourceNameLabel());
		}
		if (childEditPart instanceof Resource_locationEditPart) {
			((Resource_locationEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureResourceLocationLabel());
		}
		super.addChildVisual(childEditPart, index > 0 ? index-1 : index);
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
		return getChildBySemanticHint(EclipseconSemanticHints.Resource_1004Labels.RESOURCEUNKNOWN_4006);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (isExternalLabel(childEditPart)) {
			IFigure labelFigure = ((GraphicalEditPart) childEditPart)
					.getFigure();
			getExternalLabelsContainer().remove(labelFigure);
		} else {
			super.removeChildVisual(childEditPart);
		}
	}

	/**
	 * @generated
	 */
	protected boolean isExternalLabel(EditPart childEditPart) {
		if (childEditPart instanceof Resource_UnknownEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected IFigure getExternalLabelsContainer() {
		DiagramRootEditPart root = (DiagramRootEditPart) getRoot();
		return root
				.getLayer(EclipseconEditPartFactory.EXTERNAL_NODE_LABELS_LAYER);
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

			org.eclipse.draw2d.IFigure childResourceNameLabel = createFigureResourceNameLabel();
			setFigureResourceNameLabel(childResourceNameLabel);
			add(childResourceNameLabel);

			org.eclipse.draw2d.IFigure childResourceLocationLabel = createFigureResourceLocationLabel();
			setFigureResourceLocationLabel(childResourceLocationLabel);
			add(childResourceLocationLabel);

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
