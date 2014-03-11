package org.eclipse.gmf.codegen.gwt.ui.actions

import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Module
import java.io.IOException
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.IHandler
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gwt.ui.Activator
import org.eclipse.gmf.codegen.gwt.ui.GeneratorUiModule
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil

abstract class AbstractGeneratorHandler extends AbstractHandler implements IHandler {
	
	override execute(ExecutionEvent event) throws ExecutionException {
		switch selection: HandlerUtil.getCurrentSelection(event) {
			IStructuredSelection: switch selected: selection.firstElement {
				IFile: selected.generateFromFile
			}
		}
	}

	protected def getInjector(GenEditorGenerator editor) {
		var Injector injector = null

		val root = ResourcesPlugin.workspace.root
		val mainProject = root.getProject(editor.domainGenModel.modelPluginID)
		val buildProject = root.getProject(editor.plugin.ID + ".gwt.build")

		if (buildProject.exists && buildProject.open) {
			try {
				var mainBundle = Activator.^default.context.installBundle(
					mainProject.location.toFile().toURI().toURL().toExternalForm()
				)
				val bundle = Activator.^default.context.installBundle(
					buildProject.location.toFile().toURI().toURL().toExternalForm()
				)
				val templModule = bundle.loadClass(editor.plugin.ID + "." + editor.modelID + "TemplateModule")
				if (templModule != null) {
					val inst = templModule.newInstance
					injector = Guice.createInjector(inst as Module, new GeneratorUiModule)
				}
				bundle.uninstall
				mainBundle.uninstall
			} catch (Exception e) {
				e.printStackTrace
			}
		}

		if (injector == null) {
			injector = Activator.^default.injector
		}

		injector
	}

	protected def generateFromFile(IFile selected) {
		val uri = URI.createPlatformResourceURI(selected.getFullPath().toString(), false)
		val resource =  new ResourceSetImpl().createResource(uri)
		try {
			resource.load(null)
		} catch (IOException e) {
			e.printStackTrace
		}

		val GeneratrJob job = [IProgressMonitor m |
			doGenerate(resource, m)
		]
		job.setUser(true)
		job.schedule

		null
	}
	
	protected abstract def IStatus doGenerate(Resource resource, IProgressMonitor m)
	
}

abstract class GeneratrJob extends Job {
	new() {
		super("Generate GEF-GWT")
	}
}
