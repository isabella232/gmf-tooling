package org.eclipse.gmf.examples.eclipsecon.diagram.custom.factories;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.StylesFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.StylesPackage;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.PresenterViewFactory;
import org.eclipse.gmf.runtime.notation.View;


public class PresenterWithStyleFactory
	extends PresenterViewFactory {

    /* (non-Javadoc)
     * @see org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory#createStyles(org.eclipse.gmf.runtime.notation.View)
     */
    protected List createStyles(View view) {
        List styles = super.createStyles(view);
        styles.add(StylesFactory.eINSTANCE.createPresenterStyle());
        return styles;
    }

    /* (non-Javadoc)
     * @see org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.PresenterViewFactory#decorateView(org.eclipse.gmf.runtime.notation.View, org.eclipse.gmf.runtime.notation.View, org.eclipse.core.runtime.IAdaptable, java.lang.String, int, boolean)
     */
    protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
        super.decorateView(containerView, view, semanticAdapter, semanticHint, index,
            persisted);
        
        PresenterStyle pStyle = (PresenterStyle)view.getStyle(StylesPackage.eINSTANCE.getPresenterStyle());
        pStyle.setDisplayAsDefault(Boolean.TRUE);
    }
    
    
}
