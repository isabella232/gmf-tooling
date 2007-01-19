package org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.mindmap.Thread;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadItemEditPart;

import org.eclipse.gmf.examples.mindmap.rcp.diagram.part.MindmapVisualIDRegistry;

/**
 * @generated
 */
public class ThreadThreadItemCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Thread) modelObject).getItems().iterator(); values
				.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = MindmapVisualIDRegistry.getNodeVisualID(viewObject,
					nextValue);
			if (ThreadItemEditPart.VISUAL_ID == nodeVID) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		return view.isSetElement() && view.getElement() != null
				&& view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

}
