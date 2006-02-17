package org.eclipse.gmf.examples.eclipsecon.diagram.custom.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.CustomSemanticHints;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.PresenterViewFactory;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;


public class PresenterWithImageViewFactory
	extends PresenterViewFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipViewFactory#decorateView(org.eclipse.gmf.runtime.notation.View, org.eclipse.gmf.runtime.notation.View, org.eclipse.core.runtime.IAdaptable, java.lang.String, int, boolean)
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index,
			persisted);
		
		Node node = getViewService().createNode(semanticAdapter, view, CustomSemanticHints.ECLIPSECON_IMAGESHAPECOMPARTMENT, 0, persisted, getPreferencesHint());
		node.setVisible(false);
	}

}
