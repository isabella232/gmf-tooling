package org.eclipse.gmf.tooling.runtime.ocl.tracker;


public interface OclTrackerFactory {

	public OclTracker createOclTracker(String expressionBody, boolean cached);

	public Type getImplementationType();

	public static enum Type {
		ANY, DEFAULT_GMFT, IMPACT_ANALYZER
	}

}
