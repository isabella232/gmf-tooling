package org.eclipse.gmf.examples.eclipsecon.diagram.custom.actions;

import org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.StylesPackage;
import org.eclipse.gmf.runtime.diagram.ui.actions.BooleanPropertyAction;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.ui.IWorkbenchPage;


public class PresenterDisplayDefaultAction extends BooleanPropertyAction {

	static public final String ID = "presenterDisplayDefaultAction"; //$NON-NLS-1$
	
	public PresenterDisplayDefaultAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage, PackageUtil.getID(StylesPackage.eINSTANCE.getPresenterStyle_DisplayAsDefault()),
            "Display default image"); //$NON-NLS-1$ should be translated
		
        setId(ID); 
        setText("Display default image");//$NON-NLS-1$ should be translated
		setToolTipText("Use the default image display for the presenter"); //$NON-NLS-1$ should be translated
	}	
}
