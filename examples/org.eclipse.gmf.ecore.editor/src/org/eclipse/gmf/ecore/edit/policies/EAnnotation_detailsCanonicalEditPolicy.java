package org.eclipse.gmf.ecore.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;

import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

/**
 * @generated
 */
public class EAnnotation_detailsCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((EAnnotation) modelObject).getDetails().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue);
			if (EStringToStringMapEntryEditPart.VISUAL_ID == nodeVID) {
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
		return domainModelElement != null && domainModelElement != ((View) getHost().getModel()).getElement() && super.shouldDeleteView(view);
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

}
