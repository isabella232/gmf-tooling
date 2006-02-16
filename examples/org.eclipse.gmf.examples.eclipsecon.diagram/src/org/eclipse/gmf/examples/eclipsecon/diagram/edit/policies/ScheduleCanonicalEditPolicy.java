package org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.eclipsecon.Schedule;

import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconVisualIDRegistry;

/**
 * @generated
 */
public class ScheduleCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		Schedule modelElement = (Schedule) ((View) getHost().getModel())
				.getElement();
		EObject nextValue;
		int nodeVID;
		for (Iterator it = modelElement.getSlices().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
					(View) getHost().getModel(), nextValue, "");
			if (2001 == nodeVID) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		EObject domainModelElement = view.getElement();
		return domainModelElement != null
				&& domainModelElement != ((View) getHost().getModel())
						.getElement() && super.shouldDeleteView(view);
	}

	/**
	 * @generated
	 */
	protected String getFactoryHint(IAdaptable elementAdapter) {
		return "";
	}

}
