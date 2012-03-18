package org.eclipse.gmf.tooling.runtime.ocl.impl.activeocl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.tooling.runtime.ocl.activeocl.ActiveOclListener;

class ListeningDependencyCollector extends ActiveOclDependencyCollectorBase<ContextDataWithAdapter> {

	private final ActiveOclListener myListener;

	public ListeningDependencyCollector(ActiveOclListener listener) {
		myListener = listener;
	}

	@Override
	protected ContextDataWithAdapter createContextData(EObject context) {
		return new ContextDataWithAdapter(context, myListener);
	}

	public void clear() {
		for (ContextDataWithAdapter contextData : getContext2Data().values()) {
			contextData.dispose();
		}
		super.clear();
	}
}
