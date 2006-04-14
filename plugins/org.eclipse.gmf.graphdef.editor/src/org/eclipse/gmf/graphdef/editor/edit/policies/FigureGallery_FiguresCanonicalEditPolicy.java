package org.eclipse.gmf.graphdef.editor.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.gmfgraph.FigureGallery;

import org.eclipse.gmf.graphdef.editor.part.GMFGraphVisualIDRegistry;

/**
 * @generated
 */
public class FigureGallery_FiguresCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((FigureGallery) modelObject).getFigures().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = GMFGraphVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue);
			switch (nodeVID) {
			case 2001: {
				result.add(nextValue);
				break;
			}
			case 2006: {
				result.add(nextValue);
				break;
			}
			case 2007: {
				result.add(nextValue);
				break;
			}
			case 2008: {
				result.add(nextValue);
				break;
			}
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
