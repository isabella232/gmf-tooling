package org.eclipse.gmf.codegen.gwt.ui.services

import org.eclipse.gmf.codegen.gwt.IOrganizeImportService
import org.eclipse.jdt.core.ICompilationUnit
import java.util.List
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.gmf.internal.common.codegen.OrganizeImportsPostprocessor

class OrganizeImportService implements IOrganizeImportService {

	val OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor()

	override organizeImports(ICompilationUnit unit, List<String> imports, IProgressMonitor monitor) {
		processor.organizeImports(unit, imports, monitor)
	}

	override organizeImports(ICompilationUnit unit, IProgressMonitor monitor) {
		processor.organizeImports(unit, monitor)
	}

}