package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.RelationshipEditPart;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.runtime.lite.services.IViewDecorator;

import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class RelationshipViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static RelationshipViewFactory INSTANCE = new RelationshipViewFactory();

	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(MindmapVisualIDRegistry
				.getType(RelationshipEditPart.VISUAL_ID));
		//XXX: init styles from attributes!!!
		create6001Label(view);

	}

	/**
	 * @generated
	 */
	private void create6001Label(View view) {
		Node label = NotationFactory.eINSTANCE.createNode();
		view.getPersistedChildren().add(label);
		RelationshipLabelViewFactory.INSTANCE.decorateView(label);
	}
}
