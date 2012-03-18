package org.eclipse.gmf.tooling.runtime.ocl.impl.activeocl;

import org.eclipse.emf.ecore.EObject;

class SimpleDependencyCollector extends ActiveOclDependencyCollectorBase<ContextData> {

	@Override
	protected ContextData createContextData(EObject context) {
		return new ContextData(context);
	}
}
