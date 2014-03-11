package org.eclipse.gmf.codegen.gwt.ui

import com.google.inject.Guice
import com.google.inject.Injector
import org.eclipse.gmf.codegen.gwt.client.module.ClientTemplateModule
import org.eclipse.gmf.codegen.gwt.module.TemplateModule
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext

class Activator extends AbstractUIPlugin {
	
	public static val PLUGIN_ID = "org.eclipse.gmf.codegen.gwt.ui" //$NON-NLS-1$

	private static var Activator plugin

	private var Injector injector
	private var BundleContext context 
	
	override def start(BundleContext context) throws Exception {
		super.start(context)
		plugin = this
		this.context = context
	}
	
	override def stop(BundleContext context) throws Exception {
		plugin = null
		super.stop(context)
	}
	
	static def getDefault() { plugin }
	
	def Injector getInjector() {	
		if (injector == null) {
			injector = createInjector()
		}
		injector
	}

	protected def createInjector() {
		try {
			return Guice.createInjector(
				new TemplateModule, 
				new GeneratorUiModule, 
				new ClientTemplateModule
			)
		} catch (Exception e) {
			throw new RuntimeException("Failed to create injector", e);
		}
	}
	
	def getContext() { context }


}