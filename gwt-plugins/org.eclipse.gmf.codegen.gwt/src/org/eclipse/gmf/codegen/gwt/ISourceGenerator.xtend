package org.eclipse.gmf.codegen.gwt

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.jdt.core.IPackageFragmentRoot

interface ISourceGenerator {

	def void generateFile(CharSequence content, String qualifiedClassName, IProgressMonitor monitor)

	def void setFragmentRoot(IPackageFragmentRoot root)

}