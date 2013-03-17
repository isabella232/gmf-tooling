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
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.Department2ItemSemanticEditPolicy;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.DepartmentPinForeground3002Policy;
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
public class Department2EditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 3002;

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
	public Department2EditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Department2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(DepartmentPinForeground3002Policy.KEY, new DepartmentPinForeground3002Policy());
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
		return primaryShape = new DepartmentFigure();
	}

	/**
	* @generated
	*/
	public DepartmentFigure getPrimaryShape() {
		return (DepartmentFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DepartmentName2EditPart) {
			((DepartmentName2EditPart) childEditPart).setLabel(getPrimaryShape().getFigureDepartmentFigure_name());
			return true;
		}
		if (childEditPart instanceof WrappingLabel5EditPart) {
			((WrappingLabel5EditPart) childEditPart).setLabel(getPrimaryShape().getFigureDepartmentFigure_ocl_gmf());
			return true;
		}
		if (childEditPart instanceof WrappingLabel6EditPart) {
			((WrappingLabel6EditPart) childEditPart).setLabel(getPrimaryShape().getFigureDepartmentFigure_ocl_ia());
			return true;
		}
		if (childEditPart instanceof DepartmentDepartment_staff2EditPart) {
			IFigure pane = getPrimaryShape().getFigureDepartmentFigure_content_pane();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((DepartmentDepartment_staff2EditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DepartmentName2EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel5EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel6EditPart) {
			return true;
		}
		if (childEditPart instanceof DepartmentDepartment_staff2EditPart) {
			IFigure pane = getPrimaryShape().getFigureDepartmentFigure_content_pane();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((DepartmentDepartment_staff2EditPart) childEditPart).getFigure());
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
		if (editPart instanceof DepartmentDepartment_staff2EditPart) {
			return getPrimaryShape().getFigureDepartmentFigure_content_pane();
		}
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
		return getChildBySemanticHint(TOEVisualIDRegistry.getType(DepartmentName2EditPart.VISUAL_ID));
	}

	/**
	* @generated
	*/
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(TOEElementTypes.ManagerManagedDepartment_4001);
		return types;
	}

	/**
	* @generated
	*/
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == TOEElementTypes.ManagerManagedDepartment_4001) {
			types.add(TOEElementTypes.Manager_2004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class DepartmentFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fFigureDepartmentFigure_content_pane;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDepartmentFigure_name;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDepartmentFigure_ocl_gmf;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDepartmentFigure_ocl_ia;

		/**
		 * @generated
		 */
		public DepartmentFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure departmentFigure_name_container0 = new RectangleFigure();

			this.add(departmentFigure_name_container0, BorderLayout.TOP);

			ToolbarLayout layoutDepartmentFigure_name_container0 = new ToolbarLayout();
			layoutDepartmentFigure_name_container0.setStretchMinorAxis(false);
			layoutDepartmentFigure_name_container0.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutDepartmentFigure_name_container0.setSpacing(5);
			layoutDepartmentFigure_name_container0.setVertical(true);

			departmentFigure_name_container0.setLayoutManager(layoutDepartmentFigure_name_container0);

			fFigureDepartmentFigure_name = new WrappingLabel();

			fFigureDepartmentFigure_name.setAlignment(PositionConstants.CENTER);

			fFigureDepartmentFigure_name.setBorder(new MarginBorder(getMapMode().DPtoLP(3), getMapMode().DPtoLP(10), getMapMode().DPtoLP(3), getMapMode().DPtoLP(10)));

			departmentFigure_name_container0.add(fFigureDepartmentFigure_name);

			fFigureDepartmentFigure_content_pane = new RectangleFigure();

			this.add(fFigureDepartmentFigure_content_pane, BorderLayout.CENTER);
			fFigureDepartmentFigure_content_pane.setLayoutManager(new StackLayout());

			RectangleFigure departmentFigure_labels_container0 = new RectangleFigure();

			departmentFigure_labels_container0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(2), getMapMode().DPtoLP(2), getMapMode().DPtoLP(2)));

			this.add(departmentFigure_labels_container0, BorderLayout.BOTTOM);

			ToolbarLayout layoutDepartmentFigure_labels_container0 = new ToolbarLayout();
			layoutDepartmentFigure_labels_container0.setStretchMinorAxis(false);
			layoutDepartmentFigure_labels_container0.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutDepartmentFigure_labels_container0.setSpacing(5);
			layoutDepartmentFigure_labels_container0.setVertical(true);

			departmentFigure_labels_container0.setLayoutManager(layoutDepartmentFigure_labels_container0);

			RectangleFigure departmentFigure_firstRow1 = new RectangleFigure();

			departmentFigure_firstRow1.setOutline(false);

			departmentFigure_labels_container0.add(departmentFigure_firstRow1);

			ToolbarLayout layoutDepartmentFigure_firstRow1 = new ToolbarLayout();
			layoutDepartmentFigure_firstRow1.setStretchMinorAxis(false);
			layoutDepartmentFigure_firstRow1.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutDepartmentFigure_firstRow1.setSpacing(5);
			layoutDepartmentFigure_firstRow1.setVertical(false);

			departmentFigure_firstRow1.setLayoutManager(layoutDepartmentFigure_firstRow1);

			WrappingLabel departmentFigure_fixed_total_salary_gmf2 = new WrappingLabel();

			departmentFigure_fixed_total_salary_gmf2.setText("Total Salary (GMF):");

			departmentFigure_fixed_total_salary_gmf2.setBorder(new MarginBorder(getMapMode().DPtoLP(3), getMapMode().DPtoLP(10), getMapMode().DPtoLP(3), getMapMode().DPtoLP(10)));

			departmentFigure_firstRow1.add(departmentFigure_fixed_total_salary_gmf2);

			fFigureDepartmentFigure_ocl_gmf = new WrappingLabel();

			fFigureDepartmentFigure_ocl_gmf.setText("<gmf>");
			fFigureDepartmentFigure_ocl_gmf.setForegroundColor(ColorConstants.red);

			fFigureDepartmentFigure_ocl_gmf.setBorder(new MarginBorder(getMapMode().DPtoLP(3), getMapMode().DPtoLP(10), getMapMode().DPtoLP(3), getMapMode().DPtoLP(10)));

			departmentFigure_firstRow1.add(fFigureDepartmentFigure_ocl_gmf);

			RectangleFigure departmentFigure_secondRow1 = new RectangleFigure();

			departmentFigure_secondRow1.setOutline(false);

			departmentFigure_labels_container0.add(departmentFigure_secondRow1);

			ToolbarLayout layoutDepartmentFigure_secondRow1 = new ToolbarLayout();
			layoutDepartmentFigure_secondRow1.setStretchMinorAxis(false);
			layoutDepartmentFigure_secondRow1.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutDepartmentFigure_secondRow1.setSpacing(5);
			layoutDepartmentFigure_secondRow1.setVertical(false);

			departmentFigure_secondRow1.setLayoutManager(layoutDepartmentFigure_secondRow1);

			WrappingLabel departmentFigure_fixed_total_salary_ia2 = new WrappingLabel();

			departmentFigure_fixed_total_salary_ia2.setText("Total Salary (IA):");

			departmentFigure_fixed_total_salary_ia2.setBorder(new MarginBorder(getMapMode().DPtoLP(3), getMapMode().DPtoLP(10), getMapMode().DPtoLP(3), getMapMode().DPtoLP(10)));

			departmentFigure_secondRow1.add(departmentFigure_fixed_total_salary_ia2);

			fFigureDepartmentFigure_ocl_ia = new WrappingLabel();

			fFigureDepartmentFigure_ocl_ia.setText("<ia>");
			fFigureDepartmentFigure_ocl_ia.setForegroundColor(ColorConstants.yellow);

			fFigureDepartmentFigure_ocl_ia.setBorder(new MarginBorder(getMapMode().DPtoLP(3), getMapMode().DPtoLP(10), getMapMode().DPtoLP(3), getMapMode().DPtoLP(10)));

			departmentFigure_secondRow1.add(fFigureDepartmentFigure_ocl_ia);

		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureDepartmentFigure_content_pane() {
			return fFigureDepartmentFigure_content_pane;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDepartmentFigure_name() {
			return fFigureDepartmentFigure_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDepartmentFigure_ocl_gmf() {
			return fFigureDepartmentFigure_ocl_gmf;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDepartmentFigure_ocl_ia() {
			return fFigureDepartmentFigure_ocl_ia;
		}

	}

}
