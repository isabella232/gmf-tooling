package org.eclipse.gmf.map.edit.ocl;

import org.eclipse.ocl.examples.xtext.essentialocl.ui.internal.EssentialOCLActivator;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLPlugin;

import com.google.inject.Module;

public class OCLActivator extends EssentialOCLActivator {

	private static OCLActivator plugin;

	public static OCLActivator getInstance() {
		return plugin;
	}

	public static String getPluginId() {
		return getInstance().getBundle().getSymbolicName();
	}

	public OCLActivator() {
		super();
		plugin = this;
	}

	@Override
	protected Module getRuntimeModule(String grammar) {
		if (EssentialOCLPlugin.LANGUAGE_ID.equals(grammar)) {
			return new OCLRuntimeModule();
		}

		throw new IllegalArgumentException(grammar);
	}

	@Override
	protected Module getUiModule(String grammar) {
		if (EssentialOCLPlugin.LANGUAGE_ID.equals(grammar)) {
			return new OCLUiModule(this);
		}

		throw new IllegalArgumentException(grammar);
	}

}
