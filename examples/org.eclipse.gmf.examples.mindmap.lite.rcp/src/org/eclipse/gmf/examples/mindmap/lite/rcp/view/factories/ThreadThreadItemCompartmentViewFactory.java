package org.eclipse.gmf.examples.mindmap.lite.rcp.view.factories;

import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.parts.ThreadThreadItemCompartmentEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.lite.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ThreadThreadItemCompartmentViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static ThreadThreadItemCompartmentViewFactory INSTANCE = new ThreadThreadItemCompartmentViewFactory();

	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(MindmapVisualIDRegistry
				.getType(ThreadThreadItemCompartmentEditPart.VISUAL_ID));
		DrawerStyle drawerStyle = NotationFactory.eINSTANCE.createDrawerStyle();
		view.getStyles().add(drawerStyle);
		TitleStyle titleStyle = NotationFactory.eINSTANCE.createTitleStyle();
		view.getStyles().add(titleStyle);
	}
}
