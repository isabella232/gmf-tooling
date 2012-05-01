package org.eclipse.gmf.examples.ocldriven.diagram.custom.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

public interface IVisualIDRegistry {

	public int getVisualID(View view);

	public String getModelID(View view);

	public int getNodeVisualID(View containerView, EObject domainElement);

	public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate);

	public boolean isCompartmentVisualID(int visualID);

	public boolean isSemanticLeafVisualID(int visualID);
}
