package org.eclipse.gmf.codegen.gwt.ui

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory
import org.osgi.framework.Bundle

import com.google.inject.Injector

class GMFExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	override def Bundle getBundle() {
		Activator.getDefault().getBundle()
	}

	override def Injector getInjector() {
		Activator.getDefault().getInjector()
	}

}
