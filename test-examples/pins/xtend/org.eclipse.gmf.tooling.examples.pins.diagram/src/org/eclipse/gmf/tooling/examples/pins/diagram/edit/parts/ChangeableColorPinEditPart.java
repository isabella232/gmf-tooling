package org.eclipse.gmf.tooling.examples.pins.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.pins.diagram.edit.policies.ChangeableColorPinItemSemanticEditPolicy;
import org.eclipse.gmf.tooling.examples.pins.diagram.edit.policies.PinChangeableColor2004Policy;
import org.eclipse.gmf.tooling.examples.pins.diagram.edit.policies.PinsTextSelectionEditPolicy;
import org.eclipse.gmf.tooling.examples.pins.diagram.part.PinsVisualIDRegistry;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class ChangeableColorPinEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2004;

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
	public ChangeableColorPinEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ChangeableColorPinItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(PinChangeableColor2004Policy.KEY, new PinChangeableColor2004Policy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new PinsTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new ChangeableColorPinFigure();
	}

	/**
	 * @generated
	 */
	public ChangeableColorPinFigure getPrimaryShape() {
		return (ChangeableColorPinFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ChangeableColorPinRedEditPart) {
			((ChangeableColorPinRedEditPart) childEditPart).setLabel(getPrimaryShape().getFigureRedColorValueFigure());
			return true;
		}
		if (childEditPart instanceof ChangeableColorPinGreenEditPart) {
			((ChangeableColorPinGreenEditPart) childEditPart).setLabel(getPrimaryShape().getFigureGreenColorValueFigure());
			return true;
		}
		if (childEditPart instanceof ChangeableColorPinBlueEditPart) {
			((ChangeableColorPinBlueEditPart) childEditPart).setLabel(getPrimaryShape().getFigureBlueColorValueFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ChangeableColorPinRedEditPart) {
			return true;
		}
		if (childEditPart instanceof ChangeableColorPinGreenEditPart) {
			return true;
		}
		if (childEditPart instanceof ChangeableColorPinBlueEditPart) {
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
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
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
		return getChildBySemanticHint(PinsVisualIDRegistry.getType(ChangeableColorPinRedEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class ChangeableColorPinFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureBlueColorValueFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureGreenColorValueFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureRedColorValueFigure;

		/**
		 * @generated
		 */
		public ChangeableColorPinFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutThis.setSpacing(8);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(8, 8));
			this.setLineWidth(6);

			this.setBorder(new MarginBorder(10, 10, 10, 10));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			WrappingLabel redLabelNameFigure1 = new WrappingLabel();

			redLabelNameFigure1.setText("RED");
			redLabelNameFigure1.setForegroundColor(ColorConstants.red);

			this.add(redLabelNameFigure1);

			fFigureRedColorValueFigure = new WrappingLabel();

			fFigureRedColorValueFigure.setText("0");

			this.add(fFigureRedColorValueFigure);

			WrappingLabel greenLabelNameFigure3 = new WrappingLabel();

			greenLabelNameFigure3.setText("GREEN");
			greenLabelNameFigure3.setForegroundColor(ColorConstants.green);

			this.add(greenLabelNameFigure3);

			fFigureGreenColorValueFigure = new WrappingLabel();

			fFigureGreenColorValueFigure.setText("0");

			this.add(fFigureGreenColorValueFigure);

			WrappingLabel blueColorNameFigure5 = new WrappingLabel();

			blueColorNameFigure5.setText("BLUE");
			blueColorNameFigure5.setForegroundColor(ColorConstants.blue);

			this.add(blueColorNameFigure5);

			fFigureBlueColorValueFigure = new WrappingLabel();

			fFigureBlueColorValueFigure.setText("0");

			this.add(fFigureBlueColorValueFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBlueColorValueFigure() {
			return fFigureBlueColorValueFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureGreenColorValueFigure() {
			return fFigureGreenColorValueFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureRedColorValueFigure() {
			return fFigureRedColorValueFigure;
		}

	}

}
