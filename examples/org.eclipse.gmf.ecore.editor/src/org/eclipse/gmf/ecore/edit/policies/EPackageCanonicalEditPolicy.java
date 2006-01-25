package org.eclipse.gmf.ecore.edit.policies;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;

import org.eclipse.gmf.ecore.editor.EcoreVisualIDRegistry;

/**
 * @generated
 */
public class EPackageCanonicalEditPolicy extends CanonicalConnectionEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		EPackage modelElement = (EPackage) ((View) getHost().getModel()).getElement();
		List result = new LinkedList();
		EObject nextValue;
		int nodeVID;
		for (Iterator it = modelElement.getEClassifiers().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, "");
			if (1001 == nodeVID) {
				result.add(nextValue);
			}
		}
		for (Iterator it = modelElement.getESubpackages().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, "");
			if (1002 == nodeVID) {
				result.add(nextValue);
			}
		}
		for (Iterator it = modelElement.getEAnnotations().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, "");
			if (1003 == nodeVID) {
				result.add(nextValue);
			}
		}
		for (Iterator it = modelElement.getEClassifiers().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, "");
			if (1004 == nodeVID) {
				result.add(nextValue);
			}
		}
		for (Iterator it = modelElement.getEClassifiers().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, "");
			if (1005 == nodeVID) {
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
	protected List getSemanticConnectionsList() {
		Diagram diagram = (Diagram) getHost().getModel();
		EPackage modelElement = (EPackage) diagram.getElement();
		List result = new LinkedList();
		for (Iterator diagramElements = modelElement.eContents().iterator(); diagramElements.hasNext();) {
			EObject nextDiagramElement = (EObject) diagramElements.next();
			for (Iterator childElements = nextDiagramElement.eContents().iterator(); childElements.hasNext();) {
				EObject nextChild = (EObject) childElements.next();
				if (EcoreVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(nextChild) != -1) {
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
		int vID = EcoreVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(relationship);
		switch (vID) {
		case 3002:
			return ((ETypedElement) relationship).getEType();
		case 3003:
			return ((ETypedElement) relationship).getEType();
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
	protected boolean shouldIncludeConnection(Edge connector, Collection children) {
		return super.shouldIncludeConnection(connector, children) && connector.getElement() != null;
	}
}
