package org.eclipse.gmf.tooling.runtime.impl.ocl.tracker.activeocl;

import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTracker;
import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTrackerFactory;

public class ActiveOclTrackerFactory implements OclTrackerFactory {

	public OclTracker createOclTracker(String expressionBody, boolean cached) {
		return new ActiveOclTracker(expressionBody, cached);
	}

	public Type getImplementationType() {
		return Type.DEFAULT_GMFT;
	}
}
