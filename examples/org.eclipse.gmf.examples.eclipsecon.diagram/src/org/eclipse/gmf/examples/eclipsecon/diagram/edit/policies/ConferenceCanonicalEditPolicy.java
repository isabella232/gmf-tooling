package org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.eclipsecon.Conference;
import org.eclipse.gmf.examples.eclipsecon.Handout;

import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconVisualIDRegistry;

/**
 * @generated
 */
public class ConferenceCanonicalEditPolicy extends
		CanonicalConnectionEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		Conference modelElement = (Conference) ((View) getHost().getModel())
				.getElement();
		EObject nextValue;
		int nodeVID;
		for (Iterator it = modelElement.getAttendees().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
					(View) getHost().getModel(), nextValue, "");
			if (1001 == nodeVID) {
				result.add(nextValue);
			}
		}
		for (Iterator it = modelElement.getDays().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
					(View) getHost().getModel(), nextValue, "");
			if (1002 == nodeVID) {
				result.add(nextValue);
			}
		}
		for (Iterator it = modelElement.getTutorials().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
					(View) getHost().getModel(), nextValue, "");
			if (1003 == nodeVID) {
				result.add(nextValue);
			}
		}
		for (Iterator it = modelElement.getEclipsezilla().iterator(); it
				.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
					(View) getHost().getModel(), nextValue, "");
			if (1004 == nodeVID) {
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
	protected List getSemanticConnectionsList() {
		Diagram diagram = (Diagram) getHost().getModel();
		Conference modelElement = (Conference) diagram.getElement();
		List result = new LinkedList();
		for (Iterator diagramElements = modelElement.eContents().iterator(); diagramElements
				.hasNext();) {
			EObject nextDiagramElement = (EObject) diagramElements.next();
			for (Iterator childElements = nextDiagramElement.eContents()
					.iterator(); childElements.hasNext();) {
				EObject nextChild = (EObject) childElements.next();
				if (EclipseconVisualIDRegistry.INSTANCE
						.getLinkWithClassVisualID(nextChild) != -1) {
					result.add(nextChild);
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected EObject getSourceElement(EObject relationship) {
		return relationship.eContainer();
	}

	/**
	 * @generated
	 */
	protected EObject getTargetElement(EObject relationship) {
		int vID = EclipseconVisualIDRegistry.INSTANCE
				.getLinkWithClassVisualID(relationship);
		switch (vID) {
		case 3001:
			return ((Handout) relationship).getEclipsezilla();
		}
		return null;
	}

	/**
	 * For now we are skipping links which was generated based on "GenLinkReferenceOnly" classes
	 * since they do not handle any domain model objects inside, so we can not process them using
	 * CanonicalConnectionEditPolicy class
	 *
	 * @generated
	 */
	protected boolean shouldIncludeConnection(Edge connector,
			Collection children) {
		return super.shouldIncludeConnection(connector, children)
				&& connector.getElement() != null;
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		super.refreshSemantic();
		refreshReferenceOnlyConnections();
	}

	/**
	 * @generated
	 */
	private void refreshReferenceOnlyConnections() {
		// TODO: implement this method
	}

}
