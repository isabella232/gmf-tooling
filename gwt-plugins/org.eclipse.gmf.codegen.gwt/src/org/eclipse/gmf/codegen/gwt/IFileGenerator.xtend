package org.eclipse.gmf.codegen.gwt

import java.io.InputStream
import org.eclipse.core.runtime.IProgressMonitor

interface IFileGenerator {

	def void generateFile(CharSequence content, String path, IProgressMonitor monitor)
	
	def void generateFile(InputStream content, String path, IProgressMonitor monitor)

}