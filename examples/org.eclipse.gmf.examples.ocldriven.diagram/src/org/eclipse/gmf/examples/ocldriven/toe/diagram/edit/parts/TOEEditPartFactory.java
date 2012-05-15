package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class TOEEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (TOEVisualIDRegistry.getVisualID(view)) {

			case AllHolderEditPart.VISUAL_ID:
				return new AllHolderEditPart(view);

			case EmployeeEditPart.VISUAL_ID:
				return new EmployeeEditPart(view);

			case EmployeeNameEditPart.VISUAL_ID:
				return new EmployeeNameEditPart(view);

			case DepartmentEditPart.VISUAL_ID:
				return new DepartmentEditPart(view);

			case DepartmentNameEditPart.VISUAL_ID:
				return new DepartmentNameEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case ProjectEditPart.VISUAL_ID:
				return new ProjectEditPart(view);

			case ProjectNameEditPart.VISUAL_ID:
				return new ProjectNameEditPart(view);

			case WrappingLabel3EditPart.VISUAL_ID:
				return new WrappingLabel3EditPart(view);

			case WrappingLabel4EditPart.VISUAL_ID:
				return new WrappingLabel4EditPart(view);

			case ManagerEditPart.VISUAL_ID:
				return new ManagerEditPart(view);

			case ManagerNameEditPart.VISUAL_ID:
				return new ManagerNameEditPart(view);

			case Employee2EditPart.VISUAL_ID:
				return new Employee2EditPart(view);

			case EmployeeName2EditPart.VISUAL_ID:
				return new EmployeeName2EditPart(view);

			case Department2EditPart.VISUAL_ID:
				return new Department2EditPart(view);

			case DepartmentName2EditPart.VISUAL_ID:
				return new DepartmentName2EditPart(view);

			case WrappingLabel5EditPart.VISUAL_ID:
				return new WrappingLabel5EditPart(view);

			case WrappingLabel6EditPart.VISUAL_ID:
				return new WrappingLabel6EditPart(view);

			case DepartmentDepartment_staffEditPart.VISUAL_ID:
				return new DepartmentDepartment_staffEditPart(view);

			case DepartmentDepartment_staff2EditPart.VISUAL_ID:
				return new DepartmentDepartment_staff2EditPart(view);

			case ManagerManagedDepartmentEditPart.VISUAL_ID:
				return new ManagerManagedDepartmentEditPart(view);

			case ManagerLeadsEditPart.VISUAL_ID:
				return new ManagerLeadsEditPart(view);

			case ContributionEditPart.VISUAL_ID:
				return new ContributionEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	* @generated
	*/
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	* @generated
	*/
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
