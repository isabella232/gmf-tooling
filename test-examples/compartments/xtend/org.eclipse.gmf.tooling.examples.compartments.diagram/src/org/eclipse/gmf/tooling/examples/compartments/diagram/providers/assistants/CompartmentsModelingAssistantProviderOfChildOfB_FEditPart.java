package org.eclipse.gmf.tooling.examples.compartments.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_DEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsModelingAssistantProvider;

/**
 * @generated
 */
public class CompartmentsModelingAssistantProviderOfChildOfB_FEditPart extends CompartmentsModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((ChildOfB_FEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(ChildOfB_FEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(CompartmentsElementTypes.ChildOfB_FDNodeRelation_4002);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((ChildOfB_FEditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(ChildOfB_FEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ChildOfA_DEditPart) {
			types.add(CompartmentsElementTypes.ChildOfB_FDNodeRelation_4002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((ChildOfB_FEditPart) sourceEditPart, relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(ChildOfB_FEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == CompartmentsElementTypes.ChildOfB_FDNodeRelation_4002) {
			types.add(CompartmentsElementTypes.ChildOfA_D_3002);
		}
		return types;
	}

}
