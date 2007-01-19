package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.MapEditPart;

import org.eclipse.gmf.runtime.lite.services.IViewDecorator;

import org.eclipse.gmf.runtime.notation.DiagramStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MapViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static MapViewFactory INSTANCE = new MapViewFactory();

	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(MapEditPart.MODEL_ID);
		DiagramStyle style = NotationFactory.eINSTANCE.createDiagramStyle();
		view.getStyles().add(style);
		//XXX: init styles from attributes!!!

	}
}
