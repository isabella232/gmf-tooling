package org.eclipse.gmf.tooling.runtime.ocl.impl.activeocl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;

class ContextDataWithAdapter extends org.eclipse.gmf.tooling.runtime.ocl.impl.activeocl.ContextData {

	private final Adapter myAdapter;

	public ContextDataWithAdapter(EObject context, final org.eclipse.gmf.tooling.runtime.ocl.activeocl.ActiveOclListener listener) {
		super(context);
		myAdapter = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification notification) {
				if (getFeatures().contains(notification.getFeature())) {
					listener.onResultChanged();
				}
			}

			@Override
			public boolean isAdapterForType(Object type) {
				return true;
			}
		};

		getContext().eAdapters().add(myAdapter);
	}

	public void dispose() {
		getContext().eAdapters().remove(myAdapter);
	}
}
