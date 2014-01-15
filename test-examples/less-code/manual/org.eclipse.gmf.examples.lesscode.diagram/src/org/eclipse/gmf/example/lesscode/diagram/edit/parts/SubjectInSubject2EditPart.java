//package org.eclipse.gmf.example.lesscode.diagram.edit.parts;
//
//import org.eclipse.draw2d.IFigure;
//import org.eclipse.gef.EditPart;
//import org.eclipse.gef.Request;
//import org.eclipse.gmf.example.lesscode.diagram.edit.policies.SubjectInSubject2CanonicalEditPolicy;
//import org.eclipse.gmf.example.lesscode.diagram.edit.policies.SubjectInSubject2ItemSemanticEditPolicy;
//import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry;
//import org.eclipse.gmf.example.lesscode.diagram.part.Messages;
//import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
//import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
//import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
//import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
//import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
//import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
//import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
//import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
//import org.eclipse.gmf.runtime.emf.type.core.IElementType;
//import org.eclipse.gmf.runtime.notation.View;
//import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
//
///**
// * @generated
// */
//public class SubjectInSubject2EditPart extends ShapeCompartmentEditPart {
//
//	/**
//	* @generated
//	*/
//	public static final int VISUAL_ID = 7002;
//
//	/**
//	* @generated
//	*/
//	public SubjectInSubject2EditPart(View view) {
//		super(view);
//	}
//
//	/**
//	* @generated
//	*/
//	public String getCompartmentName() {
//		return Messages.SubjectInSubject2EditPart_title;
//	}
//
//	/**
//	* @generated
//	*/
//	public IFigure createFigure() {
//		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
//		result.setTitleVisibility(false);
//		return result;
//	}
//
//	/**
//	* @generated
//	*/
//	protected void createDefaultEditPolicies() {
//		super.createDefaultEditPolicies();
//		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new SubjectInSubject2ItemSemanticEditPolicy());
//		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(LesscodeVisualIDRegistry.TYPED_INSTANCE));
//		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
//		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new SubjectInSubject2CanonicalEditPolicy());
//	}
//
//	/**
//	* @generated
//	*/
//	protected void setRatio(Double ratio) {
//		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
//			super.setRatio(ratio);
//		}
//	}
//
//	/**
//	 * @generated
//	 */
//	public EditPart getTargetEditPart(Request request) {
//		if (request instanceof CreateViewAndElementRequest) {
//			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
//			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
//			if (type == LesscodeElementTypes.Subject_3001) {
//				return this;
//			}
//			return getParent().getTargetEditPart(request);
//		}
//		return super.getTargetEditPart(request);
//	}
//
//}
