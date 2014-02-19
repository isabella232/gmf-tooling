package org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Department2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEModelingAssistantProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class TOEModelingAssistantProviderOfDepartment2EditPart extends TOEModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((Department2EditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(Department2EditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(TOEElementTypes.ManagerManagedDepartment_4001);
		return types;
	}

	/**
	* @generated
	*/
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((Department2EditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(Department2EditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == TOEElementTypes.ManagerManagedDepartment_4001) {
			types.add(TOEElementTypes.Manager_2004);
		}
		return types;
	}

}
