package org.eclipse.gmf.examples.eclipsecon.diagram.custom.factories;

import java.util.List;

import org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.StylesFactory;
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
}
