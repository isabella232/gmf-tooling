package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.ResourceEditPart;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.runtime.lite.services.IViewDecorator;

import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ResourceViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static ResourceViewFactory INSTANCE = new ResourceViewFactory();

	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(MindmapVisualIDRegistry
				.getType(ResourceEditPart.VISUAL_ID));
		ShapeStyle style = NotationFactory.eINSTANCE.createShapeStyle();
		view.getStyles().add(style);
		//XXX: init styles from attributes!!!
		create5003Label(view);

	}

	/**
	 * @generated
	 */
	private void create5003Label(View view) {
		Node label = NotationFactory.eINSTANCE.createNode();
		view.getPersistedChildren().add(label);
		ResourceNameEmailViewFactory.INSTANCE.decorateView(label);
	}

}
