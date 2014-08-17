package org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.policies.ContainerContainerCompartment2CanonicalEditPolicy;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.policies.ContainerContainerCompartment2ItemSemanticEditPolicy;
import org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry;
import org.eclipse.gmf.tooling.examples.linklf.diagram.part.Messages;
import org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfElementTypes;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.gmf.tooling.runtime.linklf.editpolicies.XYLayoutWithFixAnchorsEditPolicy;

/**
 * @generated
 */
public class ContainerContainerCompartment2EditPart extends LinksLFCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7002;

	/**
	 * @generated
	 */
	public ContainerContainerCompartment2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public String getCompartmentName() {
		return Messages.ContainerContainerCompartment2EditPart_title;
	}

	/**
	 * @generated
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(false);
		return result;
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ContainerContainerCompartment2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(LinklfVisualIDRegistry.TYPED_INSTANCE));
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ContainerContainerCompartment2CanonicalEditPolicy());
		//
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutWithFixAnchorsEditPolicy());
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		// nothing to do -- parent layout does not accept Double constraints as ratio
		// super.setRatio(ratio); 
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == LinklfElementTypes.Circle_3001) {
				return this;
			}
			if (type == LinklfElementTypes.Container_3002) {
				return this;
			}
			if (type == LinklfElementTypes.Rectangle_3003) {
				return this;
			}
			if (type == LinklfElementTypes.Rhombus_3004) {
				return this;
			}
			return getParent().getTargetEditPart(request);
		}
		if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
			if (RequestConstants.REQ_CONNECTION_END.equals(request.getType())) {
				for (Object type : ((CreateUnspecifiedTypeConnectionRequest) request).getElementTypes()) {
					if (type instanceof IElementType) {
						IElementType elementType = (IElementType) type;
						if (elementType.equals(LinklfElementTypes.Link_4001) || elementType.equals(LinklfElementTypes.LabeledLink_4002))
							return super.getTargetEditPart(request);
					}
				}
			}
			return getParent().getTargetEditPart(request);
		}
		return super.getTargetEditPart(request);
	}

}
