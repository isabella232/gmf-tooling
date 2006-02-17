package org.eclipse.gmf.examples.eclipsecon.diagram.custom.actions;

import org.eclipse.gmf.examples.eclipsecon.diagram.custom.CustomSemanticHints;
import org.eclipse.gmf.runtime.diagram.ui.actions.IndividualCompartmentAction;
import org.eclipse.ui.IWorkbenchPage;


public class ImageCompartmentAction extends IndividualCompartmentAction {

	static public final String ID = "presenterImageCompartmentAction"; //$NON-NLS-1$
	
	public ImageCompartmentAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage, CustomSemanticHints.ECLIPSECON_IMAGESHAPECOMPARTMENT);
		setId(ID); 
		setText("Presenter Picture"); //$NON-NLS-1$ should be translated
		setToolTipText("Picture of the presenter"); //$NON-NLS-1$ should be translated
	}	
}
