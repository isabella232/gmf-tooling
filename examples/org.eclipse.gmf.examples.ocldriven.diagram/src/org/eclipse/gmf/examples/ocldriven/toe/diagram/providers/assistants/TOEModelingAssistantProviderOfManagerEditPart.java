package org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Department2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ProjectEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEModelingAssistantProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class TOEModelingAssistantProviderOfManagerEditPart extends TOEModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((ManagerEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(ManagerEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(TOEElementTypes.ManagerManagedDepartment_4001);
		types.add(TOEElementTypes.ManagerLeads_4002);
		types.add(TOEElementTypes.Contribution_4003);
		return types;
	}

	/**
	* @generated
	*/
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((ManagerEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(ManagerEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof DepartmentEditPart) {
			types.add(TOEElementTypes.ManagerManagedDepartment_4001);
		}
		if (targetEditPart instanceof Department2EditPart) {
			types.add(TOEElementTypes.ManagerManagedDepartment_4001);
		}
		if (targetEditPart instanceof ProjectEditPart) {
			types.add(TOEElementTypes.ManagerLeads_4002);
		}
		if (targetEditPart instanceof ProjectEditPart) {
			types.add(TOEElementTypes.Contribution_4003);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((ManagerEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(ManagerEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == TOEElementTypes.ManagerManagedDepartment_4001) {
			types.add(TOEElementTypes.Department_2002);
			types.add(TOEElementTypes.Department_3002);
		} else if (relationshipType == TOEElementTypes.ManagerLeads_4002) {
			types.add(TOEElementTypes.Project_2003);
		} else if (relationshipType == TOEElementTypes.Contribution_4003) {
			types.add(TOEElementTypes.Project_2003);
		}
		return types;
	}

}
