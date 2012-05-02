package org.eclipse.gmf.examples.subdiagrams.popup;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

public class AssignToLayerItemProviderPolicy implements IPopupMenuContributionPolicy {
	
	@Override
	public boolean appliesTo(ISelection selection, IConfigurationElement configuration) {
		if (false == selection instanceof IStructuredSelection) {
			return false;
		}
		List<?> allSelected = ((IStructuredSelection) selection).toList();
		if (allSelected.isEmpty()) {
			return false;
		}
		for (Object next : allSelected) {
			if (!checkSelectedElement(next)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkSelectedElement(Object selected) {
		return selected instanceof IGraphicalEditPart && !(selected instanceof DiagramEditPart);
	}

}
