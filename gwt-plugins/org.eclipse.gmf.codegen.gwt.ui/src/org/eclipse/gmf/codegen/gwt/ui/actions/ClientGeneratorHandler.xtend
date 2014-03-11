package org.eclipse.gmf.codegen.gwt.ui.actions

import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gwt.IProjectGenerator
import org.eclipse.gmf.codegen.gwt.client.ClientGenerator

class ClientGeneratorHandler extends AbstractGeneratorHandler {

	@Inject ClientGenerator generator
	@Inject IProjectGenerator projectGenerator

	override protected doGenerate(Resource resource, IProgressMonitor monitor) {
		val editor = resource.contents.get(0) as GenEditorGenerator

		generateClientProject(generator, editor, monitor)
	}

	protected def generateClientProject(ClientGenerator generator, GenEditorGenerator editor, IProgressMonitor monitor) {
//		val moduleName = editor.domainGenModel.modelPluginPackageName + "." + editor.modelID
		val artifactId = editor.plugin.ID + ".client"
		val project = projectGenerator.createProject(artifactId, null, monitor)
		val root = projectGenerator.getFragmentRoot(project, monitor)

		generator.generate(editor, project, root, monitor)

		Status.OK_STATUS
	}

}