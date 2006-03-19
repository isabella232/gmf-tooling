package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.ecore.edit.policies.EClassCanonicalEditPolicy;
import org.eclipse.gmf.ecore.edit.policies.EClassGraphicalNodeEditPolicy;
import org.eclipse.gmf.ecore.edit.policies.EClassItemSemanticEditPolicy;
import org.eclipse.gmf.ecore.edit.policies.EcoreTextSelectionEditPolicy;

import org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin;

import org.eclipse.gmf.ecore.providers.EcoreElementTypes;
import org.eclipse.gmf.ecore.providers.EcoreSemanticHints;

import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EClassEditPart extends ShapeNodeEditPart {

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
	public EClassEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy() {

			public Command getCommand(Request request) {
				if (understandsRequest(request)) {
					if (request instanceof CreateViewAndElementRequest) {
						CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
						IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
						if (type == EcoreElementTypes.EAttribute_2001) {
							EditPart compartmentEditPart = getChildBySemanticHint(EcoreSemanticHints.EClass_1001Compartments.ATTRIBUTES_5001);
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
						if (type == EcoreElementTypes.EOperation_2002) {
							EditPart compartmentEditPart = getChildBySemanticHint(EcoreSemanticHints.EClass_1001Compartments.OPERATIONS_5002);
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
						if (type == EcoreElementTypes.EAnnotation_2003) {
							EditPart compartmentEditPart = getChildBySemanticHint(EcoreSemanticHints.EClass_1001Compartments.CLASS_ANNOTATIONS_5003);
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
					}
					return super.getCommand(request);
				}
				return null;
			}
		});
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EClassItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new EClassGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new EClassCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new EcoreTextSelectionEditPolicy();
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
		NamedNodeRectangle figure = new NamedNodeRectangle();
		figure.setUseLocalCoordinates(false);
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public NamedNodeRectangle getPrimaryShape() {
		return (NamedNodeRectangle) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof EClass_nameEditPart) {
			((EClass_nameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureNamedNode_NameLabelFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		return new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
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

		ImageFigureEx imageFigure = new ImageFigureEx(EcoreDiagramEditorPlugin.getInstance().getBundledImage("icons/shortcut.gif"), PositionConstants.EAST);
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
		return getChildBySemanticHint(EcoreSemanticHints.EClass_1001Labels.ECLASSNAME_4004);
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (!addFixedChild(childEditPart)) {
			super.addChildVisual(childEditPart, -1);
		}
	}

	/**
	 * @generated
	 */
	public class NamedNodeRectangle extends org.eclipse.draw2d.RectangleFigure {

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates;

		/**
		 * @generated
		 */
		public NamedNodeRectangle() {

			org.eclipse.draw2d.Label childNamedNode_NameLabelFigure = createFigureNamedNode_NameLabelFigure();
			setFigureNamedNode_NameLabelFigure(childNamedNode_NameLabelFigure);
			add(childNamedNode_NameLabelFigure);

		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Label fNamedNode_NameLabelFigure;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.Label getFigureNamedNode_NameLabelFigure() {
			return fNamedNode_NameLabelFigure;
		}

		/**
		 * @generated
		 */
		protected void setFigureNamedNode_NameLabelFigure(org.eclipse.draw2d.Label figure) {
			fNamedNode_NameLabelFigure = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.Label createFigureNamedNode_NameLabelFigure() {
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
