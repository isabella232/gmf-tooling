package org.eclipse.gmf.tooling.runtime.ocl.activeocl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface ActiveOclDependencyCollector {

	public void registerDependency(EObject context, EStructuralFeature feature);
}
