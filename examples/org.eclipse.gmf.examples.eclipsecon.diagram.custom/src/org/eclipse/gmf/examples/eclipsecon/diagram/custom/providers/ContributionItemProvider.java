package org.eclipse.gmf.examples.eclipsecon.diagram.custom.providers;

import org.eclipse.gmf.examples.eclipsecon.diagram.custom.actions.ImageCompartmentAction;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;


public class ContributionItemProvider
	extends AbstractContributionItemProvider {

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider#createAction(java.lang.String, org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */
	protected IAction createAction(
		String actionId,
		IWorkbenchPartDescriptor partDescriptor) {
		
		if (actionId.equals(ImageCompartmentAction.ID))
			return new ImageCompartmentAction(partDescriptor.getPartPage());
		
		return super.createAction(actionId, partDescriptor);
	}
}
