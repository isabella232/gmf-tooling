package org.eclipse.gmf.ecore.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;

import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

/**
 * @generated
 */
public class EClass_classannotationsCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((EModelElement) modelObject).getEAnnotations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = EcoreVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (EAnnotationEditPart.VISUAL_ID == nodeVID) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		return view.isSetElement() && view.getElement() != null;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

}
