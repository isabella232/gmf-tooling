package org.eclipse.gmf.examples.eclipsecon.diagram.custom.providers;

import org.eclipse.gmf.examples.eclipsecon.diagram.custom.CustomSemanticHints;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.editparts.ImageResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;


public class EditPartProvider extends AbstractEditPartProvider {

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider#getNodeEditPartClass(org.eclipse.gmf.runtime.notation.View)
	 */
	protected Class getNodeEditPartClass(View view) {
		if (view.getType() == CustomSemanticHints.ECLIPSECON_IMAGESHAPECOMPARTMENT)
			return ImageResizableCompartmentEditPart.class;
		
		return super.getNodeEditPartClass(view);
	}

}
