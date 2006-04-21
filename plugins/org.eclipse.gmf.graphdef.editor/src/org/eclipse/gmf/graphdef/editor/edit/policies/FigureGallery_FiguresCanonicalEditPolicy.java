package org.eclipse.gmf.graphdef.editor.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.gmfgraph.FigureGallery;

import org.eclipse.gmf.graphdef.editor.edit.parts.Ellipse2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Polyline2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.RectangleEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.RoundedRectangle2EditPart;

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
			nodeVID = GMFGraphVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			switch (nodeVID) {
			case RectangleEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case Ellipse2EditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case RoundedRectangle2EditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case Polyline2EditPart.VISUAL_ID: {
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
