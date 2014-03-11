package org.eclipse.gmf.codegen.gwt

import org.eclipse.jdt.core.ICompilationUnit
import java.util.List
import org.eclipse.core.runtime.IProgressMonitor

interface IOrganizeImportService {

	def void organizeImports(ICompilationUnit unit, List<String> imports, IProgressMonitor monitor)

	def void organizeImports(ICompilationUnit unit, IProgressMonitor monitor)

}