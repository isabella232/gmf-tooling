package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.RelationshipLabel3EditPart;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.runtime.lite.services.IViewDecorator;

import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class RelationshipLabel3ViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static RelationshipLabel3ViewFactory INSTANCE = new RelationshipLabel3ViewFactory();

	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(MindmapVisualIDRegistry
				.getType(RelationshipLabel3EditPart.VISUAL_ID));
		Location location = NotationFactory.eINSTANCE.createLocation();
		((Node) view).setLayoutConstraint(location);

	}
}
