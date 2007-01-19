package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.ThreadEditPart;

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
public class ThreadViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static ThreadViewFactory INSTANCE = new ThreadViewFactory();

	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(MindmapVisualIDRegistry.getType(ThreadEditPart.VISUAL_ID));
		ShapeStyle style = NotationFactory.eINSTANCE.createShapeStyle();
		view.getStyles().add(style);
		//XXX: init styles from attributes!!!
		create5001Label(view);
		create7002Compartment(view);

	}

	/**
	 * @generated
	 */
	private void create5001Label(View view) {
		Node label = NotationFactory.eINSTANCE.createNode();
		view.getPersistedChildren().add(label);
		ThreadSubjectViewFactory.INSTANCE.decorateView(label);
	}

	/**
	 * @generated
	 */
	private void create7002Compartment(View view) {
		Node compartment = NotationFactory.eINSTANCE.createNode();
		view.getPersistedChildren().add(compartment);
		ThreadThreadItemCompartmentViewFactory.INSTANCE
				.decorateView(compartment);
	}
}
