package org.eclipse.gmf.tooling.runtime.impl.ocl.tracker.activeocl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.tooling.runtime.impl.ocl.activeocl.ActiveOclListener;
import org.eclipse.gmf.tooling.runtime.impl.ocl.activeocl.ActiveOclResult;
import org.eclipse.ocl.ParserException;

class ActiveOclResultImpl implements ActiveOclResult, ActiveOclListener {

	private final List<ActiveOclListener> myListeners;

	private Object myResult;

	private final ListeningDependencyCollector myDependencyCollector;

	private final DependencyEvaluator myDependencyEvaluator;

	public ActiveOclResultImpl(EObject context, String oclExp) throws ParserException {
		myListeners = new ArrayList<ActiveOclListener>();

		myDependencyCollector = new ListeningDependencyCollector(this);

		myDependencyEvaluator = new DependencyEvaluator(context, oclExp, myDependencyCollector);

		myResult = myDependencyEvaluator.evaluate();
	}

	@Override
	public void onResultChanged() {
		myDependencyCollector.clear();

		Object newResult = myDependencyEvaluator.evaluate();
		if (myResult == null && newResult == null //
				|| myResult != null && myResult.equals(newResult)) {
			return;
		}
		myResult = newResult;

		for (ActiveOclListener listener : myListeners) {
			listener.onResultChanged();
		}
	}

	@Override
	public void removeListener(ActiveOclListener listener) {
		myListeners.remove(listener);
	}

	@Override
	public Object getResult() {
		return myResult;
	}

	@Override
	public void dispose() {
		myDependencyCollector.clear();
	}

	@Override
	public boolean canListenForChanges() {
		return true;
	}

	@Override
	public void addListener(ActiveOclListener listener) {
		myListeners.add(listener);
	}

	@Override
	public Notifier adaptToEMFNotifier() {
		// TODO Auto-generated method stub
		return null;
	}
}
