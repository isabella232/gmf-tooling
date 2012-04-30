package org.eclipse.gmf.examples.ocldriven.diagram.custom.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentDepartment_staff2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentDepartment_staffEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry;
import org.eclipse.gmf.runtime.notation.View;

public class TOEVisualIDRegistryImpl implements IVisualIDRegistry {

	@Override
	public int getVisualID(View view) {
		return TOEVisualIDRegistry.getVisualID(view);
	}

	@Override
	public String getModelID(View view) {
		return TOEVisualIDRegistry.getModelID(view);
	}

	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return TOEVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	@Override
	public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		return getNodeVisualID(containerView, domainElement) == candidate;
	}

	@Override
	public boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case DepartmentDepartment_staff2EditPart.VISUAL_ID:
		case DepartmentDepartment_staffEditPart.VISUAL_ID:
			return true;

		default:
			return false;
		}
	}

	@Override
	public boolean isSemanticLeafVisualID(int visualID) {
		return false;
	}

}
