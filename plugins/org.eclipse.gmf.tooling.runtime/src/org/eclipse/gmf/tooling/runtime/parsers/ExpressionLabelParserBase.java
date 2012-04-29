package org.eclipse.gmf.tooling.runtime.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.tooling.runtime.GMFToolingRuntimePlugin;
import org.eclipse.gmf.tooling.runtime.ocl.tracker.HasOclTracker;
import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTracker;
import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTrackerFactory;

public abstract class ExpressionLabelParserBase implements HasOclTracker, IParser {

	private final OclTrackerWrapper myDelegate;

	public ExpressionLabelParserBase() {
		this(GMFToolingRuntimePlugin.getInstance().getOclTrackerFactory());
	}

	public ExpressionLabelParserBase(OclTrackerFactory.Type preferredType) {
		this(GMFToolingRuntimePlugin.getInstance().getOclTrackerFactory(preferredType));
	}

	public ExpressionLabelParserBase(OclTrackerFactory oclTrackerFactory) {
		myDelegate = new OclTrackerWrapper(oclTrackerFactory) {

			@Override
			protected String getExpressionBody() {
				return ExpressionLabelParserBase.this.getExpressionBody();
			}
		};
	}

	@Override
	public OclTracker getOclTracker() {
		return myDelegate.getOclTracker();
	}

	public String getPrintString(IAdaptable element, int flags) {
		return myDelegate.getUpdatedString(element, flags);
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return myDelegate.isAffectingEvent(event, flags);
	}

	protected abstract String getExpressionBody();
}
