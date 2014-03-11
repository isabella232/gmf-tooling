package org.eclipse.gmf.codegen.gwt.impl

import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.SubProgressMonitor
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.gmf.codegen.gwt.IFormatService
import org.eclipse.gmf.codegen.gwt.IMergeService
import org.eclipse.gmf.codegen.gwt.IOrganizeImportService
import org.eclipse.gmf.codegen.gwt.ISourceGenerator
import org.eclipse.jdt.core.ICompilationUnit
import org.eclipse.jdt.core.IPackageFragmentRoot

class JavaSourceGenerator implements ISourceGenerator {

	@Inject IMergeService mergeService
	@Inject IOrganizeImportService importService
	@Inject IFormatService formatService

	private var IPackageFragmentRoot root

	override void setFragmentRoot(IPackageFragmentRoot root) {
		this.root = root
	}

	override generateFile(CharSequence content, String qualifiedClassName, IProgressMonitor monitor) {
		val packageName =  CodeGenUtil.getPackageName(qualifiedClassName)
    	val className = CodeGenUtil.getSimpleClassName(qualifiedClassName)

		monitor.setTaskName(className)

		val pf = root.createPackageFragment(packageName, true, monitor)
		val cu = pf.getCompilationUnit(className + ".java")

		if (cu.exists) {
			val workingCopy = cu.getWorkingCopy(monitor)
			try {
				val oldContents = workingCopy.source
				val declaredImports = workingCopy.imports.map[it | elementName]
	
				workingCopy.buffer.setContents(content.toString)
				workingCopy.reconcile(ICompilationUnit.NO_AST, false, null, null)
				importService.organizeImports(workingCopy, declaredImports, new SubProgressMonitor(monitor, 1))

				val mergedContents = formatService.formatCode(mergeService.mergeJava(oldContents, workingCopy.source))
				if (!mergedContents.equals(oldContents)) {
					workingCopy.buffer.setContents(mergedContents)
					workingCopy.reconcile(ICompilationUnit.NO_AST, false, null, null)
					workingCopy.commitWorkingCopy(true, new SubProgressMonitor(monitor, 1))
				} else {
					monitor.worked(1)
				}
			} finally {
				workingCopy.discardWorkingCopy
			}
		} else {
			val ncu = pf.createCompilationUnit(cu.elementName, content.toString, true, new SubProgressMonitor(monitor, 1))

			importService.organizeImports(ncu, new SubProgressMonitor(monitor, 1))

			val newContents = formatService.formatCode(ncu.source)
			ncu.buffer.setContents(newContents)
			ncu.save(new SubProgressMonitor(monitor, 2), true)
		}
	}

}