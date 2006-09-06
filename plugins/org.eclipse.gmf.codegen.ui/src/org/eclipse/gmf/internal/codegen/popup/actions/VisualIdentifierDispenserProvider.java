package org.eclipse.gmf.internal.codegen.popup.actions;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.internal.bridge.NaiveIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.StatefulVisualIdentifierDispencer;
import org.eclipse.gmf.internal.bridge.VisualIdentifierDispenser;
import org.eclipse.gmf.internal.codegen.CodeGenUIPlugin;
import org.osgi.framework.Bundle;

/**
 * holds additional logic to pre/post process dispensers
 */
class VisualIdentifierDispenserProvider {
	private VisualIdentifierDispenser dispenser;
	private final URI myStateBaseURI;

	VisualIdentifierDispenserProvider(URI stateBaseURI) {
		myStateBaseURI = stateBaseURI;
	}

	private VisualIdentifierDispenser initialize() {
		Bundle tracePluginBundle = Platform.getBundle("org.eclipse.gmf.bridge.trace");
		if (tracePluginBundle != null) {
			try {
				Class despenserClass = tracePluginBundle.loadClass("org.eclipse.gmf.internal.bridge.trace.MergingIdentifierDispenser");
				return (VisualIdentifierDispenser) despenserClass.newInstance();
			} catch (ClassNotFoundException e) {
				CodeGenUIPlugin.getDefault().getLog().log(CodeGenUIPlugin.createError("MergingIdentifierDispenser was not found in org.eclipse.gmf.bridge.trace bundle", e));
			} catch (InstantiationException e) {
				CodeGenUIPlugin.getDefault().getLog().log(CodeGenUIPlugin.createError("MergingIdentifierDispenser was not instantiated", e));
			} catch (IllegalAccessException e) {
				CodeGenUIPlugin.getDefault().getLog().log(CodeGenUIPlugin.createError("IllegalAccessException while instantiating MergingIdentifierDispenser", e));
			} catch (ClassCastException ex) {
				CodeGenUIPlugin.getDefault().getLog().log(CodeGenUIPlugin.createError("MergingIdentifierDispenser was not instantiated", ex));
			}
		}
		return new NaiveIdentifierDispenser();
	}

	public VisualIdentifierDispenser get() {
		assert dispenser != null;
		return dispenser;
	}

	public void acquire() {
		assert dispenser == null;
		dispenser = initialize();
		if (dispenser instanceof StatefulVisualIdentifierDispencer) {
			StatefulVisualIdentifierDispencer statefulDispencer = (StatefulVisualIdentifierDispencer) dispenser;
			statefulDispencer.loadState(myStateBaseURI);
		}
	}

	public void release() {
		if (dispenser instanceof StatefulVisualIdentifierDispencer) {
			((StatefulVisualIdentifierDispencer) dispenser).saveState();
		}
		dispenser = null;
	}
}