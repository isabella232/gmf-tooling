package org.eclipse.gmf.codegen.gwt.ui.actions

import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gwt.IProjectGenerator
import org.eclipse.gmf.codegen.gwt.impl.Generator

class DiagramGeneratorHandler extends AbstractGeneratorHandler {

	@Inject IProjectGenerator projectGenerator

	protected override doGenerate(Resource resource, IProgressMonitor monitor) {
		val editor = resource.contents.get(0) as GenEditorGenerator
		val injector = editor.getInjector

		generateDiagramProject(injector.getInstance(Generator), editor, monitor)

		Status::OK_STATUS
	}

	protected def generateDiagramProject(Generator generator, GenEditorGenerator editor, IProgressMonitor monitor) {
		val project = projectGenerator.createProject(editor.plugin.ID, null, monitor)
		val root = projectGenerator.getFragmentRoot(project, monitor)

		generator.generate(editor, project, root, monitor)
	}

}
