package org.eclipse.gmf.tooling.runtime.ocl.impl.activeocl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.tooling.runtime.ocl.activeocl.ActiveOclDependencyCollector;
import org.eclipse.gmf.tooling.runtime.ocl.activeocl.ActiveOclEvaluator;
import org.eclipse.gmf.tooling.runtime.ocl.activeocl.ActiveOclResult;
import org.eclipse.ocl.ParserException;

class ActiveOclEvaluatorImpl implements ActiveOclEvaluator {

	@Override
	public ActiveOclResult evaluate(EObject context, String oclExp) throws ParserException {
		return new ActiveOclResultImpl(context, oclExp);
	}

	@Override
	public Object evaluate(EObject context, String oclExp, ActiveOclDependencyCollector dependencyCollector) throws ParserException {
		return new DependencyEvaluator(context, oclExp, dependencyCollector).evaluate();
	}
}
