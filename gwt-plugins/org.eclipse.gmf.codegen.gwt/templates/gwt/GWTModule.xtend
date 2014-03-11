package gwt

import common.BaseFileTemplate
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class GWTModule extends BaseFileTemplate<GenEditorGenerator> {

	def qualifiedModuleName(GenEditorGenerator it) { 
		packageNamePrefix + "." + modelID
	}

	override filePath(GenEditorGenerator it) { qualifiedModuleName.replaceAll("\\.", "/") + ".gwt.xml" }

	override generate(GenEditorGenerator it) {
		'''
			<?xml version="1.0" encoding="UTF-8"?>
			<module>
				<!-- GWT modules -->
				<inherits name="com.google.gwt.user.User" />

				<!-- GEF module -->
				<inherits name="org.eclipse.gef.Gef" />

				<!-- EMF module -->
				<inherits name="org.eclipse.emf.ecore.EcoreEdit" />

				<!-- GMF modules -->
				<inherits name="org.eclipse.gmf.runtime.notation.Notation" />
				<inherits name="org.eclipse.gmf.runtime.gwt.GmfToolGwt" />

				«FOR p: domainGenModel.genPackages»
				<inherits name="«p.basePackage».«p.NSName».«p.prefix»" />
				<inherits name="«p.basePackage».«p.NSName».«p.prefix»Edit" />
				«ENDFOR»

				<source path="edit"/>
				<source path="part"/>
				<source path="view"/>
			</module>
		'''
	}

}