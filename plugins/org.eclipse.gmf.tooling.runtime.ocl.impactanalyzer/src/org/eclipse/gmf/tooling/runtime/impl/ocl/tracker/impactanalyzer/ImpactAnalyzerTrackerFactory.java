package org.eclipse.gmf.tooling.runtime.impl.ocl.tracker.impactanalyzer;

import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTracker;
import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTrackerFactory;

public class ImpactAnalyzerTrackerFactory implements OclTrackerFactory {

	public OclTracker createOclTracker(String expressionBody, boolean cached) {
		return new ImpactAnalyzerTracker(expressionBody, cached);
	}

	public Type getImplementationType() {
		return Type.IMPACT_ANALYZER;
	}

}
