package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.ProjectItemSemanticEditPolicy;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
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
public class ProjectEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2003;

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
	public ProjectEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ProjectItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	* @generated
	*/
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

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
		return primaryShape = new ProjectFigure();
	}

	/**
	* @generated
	*/
	public ProjectFigure getPrimaryShape() {
		return (ProjectFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ProjectNameEditPart) {
			((ProjectNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureProjectFigure_name());
			return true;
		}
		if (childEditPart instanceof WrappingLabel3EditPart) {
			((WrappingLabel3EditPart) childEditPart).setLabel(getPrimaryShape().getFigureProjectFigure_ocl_gmf());
			return true;
		}
		if (childEditPart instanceof WrappingLabel4EditPart) {
			((WrappingLabel4EditPart) childEditPart).setLabel(getPrimaryShape().getFigureProjectFigure_ocl_ia());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ProjectNameEditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel3EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel4EditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(400, 50);
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
		return getChildBySemanticHint(TOEVisualIDRegistry.getType(ProjectNameEditPart.VISUAL_ID));
	}

	/**
	* @generated
	*/
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(TOEElementTypes.ManagerLeads_4002);
		types.add(TOEElementTypes.Contribution_4003);
		return types;
	}

	/**
	* @generated
	*/
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == TOEElementTypes.ManagerLeads_4002) {
			types.add(TOEElementTypes.Manager_2004);
		} else if (relationshipType == TOEElementTypes.Contribution_4003) {
			types.add(TOEElementTypes.Employee_2001);
			types.add(TOEElementTypes.Manager_2004);
			types.add(TOEElementTypes.Employee_3001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class ProjectFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureProjectFigure_name;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureProjectFigure_ocl_gmf;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureProjectFigure_ocl_ia;

		/**
		 * @generated
		 */
		public ProjectFigure() {

			BorderLayout layoutThis = new BorderLayout();
			layoutThis.setHorizontalSpacing(4);// TODO mapMode?
			layoutThis.setVerticalSpacing(4);
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(12), getMapMode().DPtoLP(12)));
			this.setLineWidth(2);
			this.setForegroundColor(ColorConstants.green);

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(12), getMapMode().DPtoLP(12), getMapMode().DPtoLP(12), getMapMode().DPtoLP(12)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure projectFigure_name_container0 = new RectangleFigure();

			projectFigure_name_container0.setOutline(false);

			this.add(projectFigure_name_container0, BorderLayout.TOP);

			ToolbarLayout layoutProjectFigure_name_container0 = new ToolbarLayout();
			layoutProjectFigure_name_container0.setStretchMinorAxis(false);
			layoutProjectFigure_name_container0.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutProjectFigure_name_container0.setSpacing(5);
			layoutProjectFigure_name_container0.setVertical(true);

			projectFigure_name_container0.setLayoutManager(layoutProjectFigure_name_container0);

			fFigureProjectFigure_name = new WrappingLabel();

			fFigureProjectFigure_name.setAlignment(PositionConstants.CENTER);

			fFigureProjectFigure_name.setBorder(new MarginBorder(getMapMode().DPtoLP(3), getMapMode().DPtoLP(10), getMapMode().DPtoLP(3), getMapMode().DPtoLP(10)));

			projectFigure_name_container0.add(fFigureProjectFigure_name);

			RectangleFigure projectFigure_content_pane0 = new RectangleFigure();

			projectFigure_content_pane0.setOutline(false);

			this.add(projectFigure_content_pane0, BorderLayout.CENTER);

			ToolbarLayout layoutProjectFigure_content_pane0 = new ToolbarLayout();
			layoutProjectFigure_content_pane0.setStretchMinorAxis(false);
			layoutProjectFigure_content_pane0.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutProjectFigure_content_pane0.setSpacing(5);
			layoutProjectFigure_content_pane0.setVertical(true);

			projectFigure_content_pane0.setLayoutManager(layoutProjectFigure_content_pane0);

			fFigureProjectFigure_ocl_gmf = new WrappingLabel();

			fFigureProjectFigure_ocl_gmf.setText("<gmf>");

			fFigureProjectFigure_ocl_gmf.setBorder(new MarginBorder(getMapMode().DPtoLP(5), getMapMode().DPtoLP(10), getMapMode().DPtoLP(5), getMapMode().DPtoLP(10)));

			projectFigure_content_pane0.add(fFigureProjectFigure_ocl_gmf);

			fFigureProjectFigure_ocl_ia = new WrappingLabel();

			fFigureProjectFigure_ocl_ia.setText("<ia>");

			fFigureProjectFigure_ocl_ia.setBorder(new MarginBorder(getMapMode().DPtoLP(5), getMapMode().DPtoLP(10), getMapMode().DPtoLP(5), getMapMode().DPtoLP(10)));

			projectFigure_content_pane0.add(fFigureProjectFigure_ocl_ia);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureProjectFigure_name() {
			return fFigureProjectFigure_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureProjectFigure_ocl_gmf() {
			return fFigureProjectFigure_ocl_gmf;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureProjectFigure_ocl_ia() {
			return fFigureProjectFigure_ocl_ia;
		}

	}

}
