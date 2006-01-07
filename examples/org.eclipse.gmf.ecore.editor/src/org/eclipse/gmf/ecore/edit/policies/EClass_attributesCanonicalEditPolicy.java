package org.eclipse.gmf.ecore.edit.policies;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.ecore.editor.EcoreVisualIDRegistry;

/**
 * @generated
 */
public class EClass_attributesCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		EClass modelElement = (EClass) ((View) getHost().getModel()).getElement();
		List result = new LinkedList();
		EObject nextValue;
		int nodeVID;
		for (Iterator it = modelElement.getEAttributes().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, "");
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
		return view.getElement() != ((View) getHost().getModel()).getElement() && super.shouldDeleteView(view);
	}

	/**
	 * @generated
	 */
	protected String getFactoryHint(IAdaptable elementAdapter) {
		return "";
	}
}
