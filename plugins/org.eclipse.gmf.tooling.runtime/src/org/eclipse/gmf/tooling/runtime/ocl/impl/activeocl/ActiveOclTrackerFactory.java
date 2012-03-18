package org.eclipse.gmf.tooling.runtime.ocl.impl.activeocl;

import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTracker;
import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTrackerFactory;

public class ActiveOclTrackerFactory implements OclTrackerFactory {

	@Override
	public OclTracker createOclTracker(String expressionBody, boolean cached) {
		return new ActiveOclTracker(expressionBody, cached);
	}

	@Override
	public Type getImplementationType() {
		return Type.DEFAULT_GMFT;
	}
}
