package org.eclipse.gmf.codegen.gwt.ui

import org.eclipse.gmf.codegen.gwt.module.GeneratorModule
import org.eclipse.gmf.codegen.gwt.IMergeService
import org.eclipse.gmf.codegen.gwt.ui.services.MergeService
import org.eclipse.gmf.codegen.gwt.IOrganizeImportService
import org.eclipse.gmf.codegen.gwt.ui.services.OrganizeImportService
import org.eclipse.gmf.codegen.gwt.IFormatService
import org.eclipse.gmf.codegen.gwt.ui.services.FormatService

class GeneratorUiModule extends GeneratorModule {

	override bindIMergeService() {
		bind(IMergeService).to(MergeService)
	}

	override bindIOrganizeImportService() {
		bind(IOrganizeImportService).to(OrganizeImportService)
	}

	override bindIFormatService() {
		bind(IFormatService).to(FormatService)
	}

}