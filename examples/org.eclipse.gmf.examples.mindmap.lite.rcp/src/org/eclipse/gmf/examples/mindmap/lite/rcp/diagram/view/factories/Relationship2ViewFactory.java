package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.Relationship2EditPart;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.runtime.lite.services.IViewDecorator;

import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class Relationship2ViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static Relationship2ViewFactory INSTANCE = new Relationship2ViewFactory();

	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(MindmapVisualIDRegistry
				.getType(Relationship2EditPart.VISUAL_ID));
		//XXX: init styles from attributes!!!
		create6002Label(view);

	}

	/**
	 * @generated
	 */
	private void create6002Label(View view) {
		Node label = NotationFactory.eINSTANCE.createNode();
		view.getPersistedChildren().add(label);
		RelationshipLabel2ViewFactory.INSTANCE.decorateView(label);
	}
}
