/*
 *  Copyright (c) 2006, 2009 Borland Software Corporation and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.graphdef.editor.edit.policies.FigureDescriptorCanonicalEditPolicy;
import org.eclipse.gmf.graphdef.editor.edit.policies.FigureDescriptorItemSemanticEditPolicy;
import org.eclipse.gmf.graphdef.editor.part.GMFGraphVisualIDRegistry;
import org.eclipse.gmf.graphdef.editor.providers.GMFGraphElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class FigureDescriptorEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3009;

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
	public FigureDescriptorEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new FigureDescriptorItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new FigureDescriptorCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;

	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		FigureDescriptorFigure figure = new FigureDescriptorFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public FigureDescriptorFigure getPrimaryShape() {
		return (FigureDescriptorFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof FigureDescriptorNameEditPart) {
			((FigureDescriptorNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureFigureDescriptorFigure_NameLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof FigureDescriptorNameEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
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
	 * @generated NOT
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		FigureDescriptorFigure fdFigure = (FigureDescriptorFigure) nodeShape;
		IFigure contentPane = fdFigure.getFigureFigureDescriptorFigure_ChildContainer();
		if (contentPane.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			contentPane.setLayoutManager(layout);
		}
		return contentPane; // use nodeShape itself as contentPane
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
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(GMFGraphVisualIDRegistry.getType(FigureDescriptorNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(GMFGraphElementTypes.ChildAccess_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof RectangleEditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof Rectangle2EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof EllipseEditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof RoundedRectangleEditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof PolylineEditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof PolygonEditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof LabelEditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof Ellipse2EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof RoundedRectangle2EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof Polyline2EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof Polygon2EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof Label2EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof Rectangle3EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof Ellipse3EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof RoundedRectangle3EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof Polyline3EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof Polygon3EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		if (targetEditPart instanceof Label3EditPart) {
			types.add(GMFGraphElementTypes.ChildAccess_4002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Rectangle_3010);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Rectangle_3011);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Ellipse_3012);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.RoundedRectangle_3013);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Polyline_3014);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Polygon_3023);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Label_3026);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Ellipse_3015);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.RoundedRectangle_3016);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Polyline_3017);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Polygon_3024);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Label_3027);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Rectangle_3018);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Ellipse_3019);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.RoundedRectangle_3020);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Polyline_3021);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Polygon_3025);
		}
		if (relationshipType == GMFGraphElementTypes.ChildAccess_4002) {
			types.add(GMFGraphElementTypes.Label_3028);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(GMFGraphElementTypes.DiagramElementFigure_4005);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == GMFGraphElementTypes.DiagramElementFigure_4005) {
			types.add(GMFGraphElementTypes.Compartment_2005);
		}
		if (relationshipType == GMFGraphElementTypes.DiagramElementFigure_4005) {
			types.add(GMFGraphElementTypes.Node_2006);
		}
		if (relationshipType == GMFGraphElementTypes.DiagramElementFigure_4005) {
			types.add(GMFGraphElementTypes.Connection_2007);
		}
		if (relationshipType == GMFGraphElementTypes.DiagramElementFigure_4005) {
			types.add(GMFGraphElementTypes.DiagramLabel_2009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class FigureDescriptorFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureFigureDescriptorFigure_NameLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureFigureDescriptorFigure_ChildContainer;

		/**
		 * @generated
		 */
		public FigureDescriptorFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
			this.setLineWidth(1);
			this.setLineStyle(Graphics.LINE_DOT);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureFigureDescriptorFigure_NameLabel = new WrappingLabel();
			fFigureFigureDescriptorFigure_NameLabel.setText("");

			this.add(fFigureFigureDescriptorFigure_NameLabel, BorderLayout.TOP);

			fFigureFigureDescriptorFigure_ChildContainer = new RectangleFigure();
			fFigureFigureDescriptorFigure_ChildContainer.setFill(false);
			fFigureFigureDescriptorFigure_ChildContainer.setOutline(false);
			fFigureFigureDescriptorFigure_ChildContainer.setLineWidth(1);

			this.add(fFigureFigureDescriptorFigure_ChildContainer, BorderLayout.CENTER);
			fFigureFigureDescriptorFigure_ChildContainer.setLayoutManager(new StackLayout());

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

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

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFigureDescriptorFigure_NameLabel() {
			return fFigureFigureDescriptorFigure_NameLabel;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureFigureDescriptorFigure_ChildContainer() {
			return fFigureFigureDescriptorFigure_ChildContainer;
		}

	}

}
