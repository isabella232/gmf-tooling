package org.eclipse.gmf.codegen.gwt.module

import com.google.inject.AbstractModule
import org.eclipse.gmf.codegen.gwt.IFileGenerator
import org.eclipse.gmf.codegen.gwt.ISourceGenerator
import org.eclipse.gmf.codegen.gwt.impl.JavaSourceGenerator
import org.eclipse.gmf.codegen.gwt.impl.TextFileGenerator
import org.eclipse.gmf.codegen.gwt.IProjectGenerator
import org.eclipse.gmf.codegen.gwt.impl.DefaultProjectGenerator

abstract class GeneratorModule extends AbstractModule {

	override protected configure() {
		bindIProjectGenerator
		bindISourceGenerator
		bindIFileGenerator
		bindIMergeService
		bindIOrganizeImportService
		bindIFormatService
	}

	def void bindIProjectGenerator() {
		bind(IProjectGenerator).to(DefaultProjectGenerator)
	}

	def void bindISourceGenerator() {
		bind(ISourceGenerator).to(JavaSourceGenerator)
	}

	def void bindIFileGenerator() {
		bind(IFileGenerator).to(TextFileGenerator)
	}
	
	def void bindIMergeService()
	
	def void bindIOrganizeImportService()
	
	def void bindIFormatService()

}