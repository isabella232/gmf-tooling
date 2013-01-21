package org.eclipse.gmf.tooling.runtime.impl.ocl.tracker.impactanalyzer;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTracker;
import org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTrackerBase;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;

public class ImpactAnalyzerTracker extends OclTrackerBase {

	private OCL myOcl;

	private OCLExpression myExpression;

	private ImpactAnalyzer myImpactAnalyzer;

	private EventFilter myFilter;

	private EventManager myEventManager;

	private Adapter myAdapter;

	private boolean myActual = false;

	private Object myValue;

	private final boolean myCached;

	private boolean myInitialized = false;

	public ImpactAnalyzerTracker(String expressionBody, boolean cached) {
		super(expressionBody);
		myCached = cached;
	}

	@Override
	protected void doInitialize() {
		if (myInitialized) {
			return;
		}

		myInitialized = true;

		myOcl = OCL.newInstance(new EcoreEnvironmentFactory());

		Helper helper = myOcl.createOCLHelper();
		helper.setContext(getContext().eClass());

		try {
			myExpression = helper.createQuery(getExpressionBody());
		} catch (ParserException e) {
			throw new RuntimeException(e);
		}

		myImpactAnalyzer = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(myExpression, // the expression to re-evaluate incrementally
				true, // whether to re-evaluate when new context objects appear
				OCLFactory.getInstance());

		myFilter = myImpactAnalyzer.createFilterForExpression();
	}

	@Override
	public void installListeners(TransactionalEditingDomain domain, final NotificationListener listener, OclTracker.Registrator registrator) {
		myEventManager = EventManagerFactory.eINSTANCE.getEventManagerFor(domain.getResourceSet());
		myAdapter = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				listener.notifyChanged(msg);
			}
		};
		myEventManager.subscribe(myFilter, myAdapter);
	}

	@Override
	public void uninstallListeners() {
		if (myEventManager == null) {
			return;
		}
		myEventManager.unsubscribe(myAdapter);
	}

	@Override
	public final Object getValue() {
		if (!isCached() || !myActual) {
			myValue = doGetValue();
			myActual = true;
		}
		return myValue;
	}

	@Override
	public final boolean handleNotification(Notification notification) {
		if ((!isCached() || myActual) && doHandleNotification(notification)) {
			myActual = false;
			return true;
		}
		return false;
	}

	private Object doGetValue() {
		return myOcl.evaluate(getContext(), myExpression);
	}

	private boolean doHandleNotification(Notification notification) {
		return myImpactAnalyzer.getContextObjects(notification).contains(getContext());
	}

	private boolean isCached() {
		return myCached;
	}
}
