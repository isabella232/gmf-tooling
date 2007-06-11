package org.eclipse.gmf.examples.mindmap.lite.rcp.view.factories;

import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.parts.RelationshipLabel2EditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.lite.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class RelationshipLabel2ViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static RelationshipLabel2ViewFactory INSTANCE = new RelationshipLabel2ViewFactory();

	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(MindmapVisualIDRegistry
				.getType(RelationshipLabel2EditPart.VISUAL_ID));
		Location location = NotationFactory.eINSTANCE.createLocation();

		location.setY(40);

		((Node) view).setLayoutConstraint(location);
	}
}
