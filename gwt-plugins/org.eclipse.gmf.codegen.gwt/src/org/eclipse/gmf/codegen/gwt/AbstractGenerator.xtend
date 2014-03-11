package org.eclipse.gmf.codegen.gwt

import com.google.inject.Inject
import common.BaseClassTemplate
import common.BaseFileTemplate
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.SubProgressMonitor
import org.eclipse.emf.ecore.EObject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class AbstractGenerator {

	@Inject protected ISourceGenerator sourceGenerator
	@Inject protected IFileGenerator fileGenerator

	private var IProgressMonitor progressMonitor = null

	def protected sourceFilePath(String path) { path }

	def protected setupMonitor(IProgressMonitor monitor) {
		if (monitor == null)
			progressMonitor = new NullProgressMonitor
		else progressMonitor = monitor	
	}

	def protected IProgressMonitor nextMonitor() throws InterruptedException {
		if (progressMonitor.canceled)
			throw new InterruptedException()
		else new SubProgressMonitor(progressMonitor, 1)
	}

	def <T extends EObject> generateClass(T it, BaseClassTemplate<T> template) {
		sourceGenerator.generateFile(template.generate(it), 
			template.qualifiedClassName(it),
			nextMonitor)
	}
	
	def generateFile(GenEditorGenerator genEditor, BaseFileTemplate<GenEditorGenerator> template, IPath basePath) {
		fileGenerator.generateFile(template.generate(genEditor), 
			basePath.append(template.filePath(genEditor)).toString,
			nextMonitor)
	}

}