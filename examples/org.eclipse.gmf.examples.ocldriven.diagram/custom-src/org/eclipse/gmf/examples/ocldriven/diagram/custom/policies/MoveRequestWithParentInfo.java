package org.eclipse.gmf.examples.ocldriven.diagram.custom.policies;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

/**
 * @see #237059
 */
public class MoveRequestWithParentInfo extends MoveRequest {

	private final Map<EObject, EObject> myElement2ActualParent = new HashMap<EObject, EObject>();

	public MoveRequestWithParentInfo(TransactionalEditingDomain editingDomain, EObject targetContainer, EObject elementToMove) {
		super(editingDomain, targetContainer, elementToMove);
	}

	public void registerActualContainer(EObject elementToMove, EObject actualContainer) {
		if (actualContainer != null) {
			myElement2ActualParent.put(elementToMove, actualContainer);
		} else {
			myElement2ActualParent.remove(elementToMove);
		}
	}

	public EObject getActualContainer(EObject movedElement) {
		return myElement2ActualParent.get(movedElement);
	}

}
