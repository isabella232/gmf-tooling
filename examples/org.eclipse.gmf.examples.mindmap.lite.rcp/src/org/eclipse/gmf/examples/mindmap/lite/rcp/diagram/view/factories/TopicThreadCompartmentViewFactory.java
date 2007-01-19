package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.TopicThreadCompartmentEditPart;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.runtime.lite.services.IViewDecorator;

import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TopicThreadCompartmentViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static TopicThreadCompartmentViewFactory INSTANCE = new TopicThreadCompartmentViewFactory();

	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(MindmapVisualIDRegistry
				.getType(TopicThreadCompartmentEditPart.VISUAL_ID));
		DrawerStyle drawerStyle = NotationFactory.eINSTANCE.createDrawerStyle();
		view.getStyles().add(drawerStyle);
		//XXX: init styles from attributes!!!
		TitleStyle titleStyle = NotationFactory.eINSTANCE.createTitleStyle();
		view.getStyles().add(titleStyle);

	}
}
