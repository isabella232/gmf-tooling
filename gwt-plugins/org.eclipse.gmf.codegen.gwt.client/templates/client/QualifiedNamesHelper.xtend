package client

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class QualifiedNamesHelper {

	def baseModulePackage(GenEditorGenerator it) '''«clientPackageName»'''
	def baseClientPackage(GenEditorGenerator it) '''«baseModulePackage».client'''
	def basePresenterPackage(GenEditorGenerator it) '''«baseClientPackage».presenter'''
	def baseViewPackage(GenEditorGenerator it) '''«baseClientPackage».view'''
	def baseEventPackage(GenEditorGenerator it) '''«baseClientPackage».events'''
	def baseIconsPackage(GenEditorGenerator it) '''«baseClientPackage».icons'''

	private def clientPackageName(GenEditorGenerator it) {
		val packageName = 
			if (packageNamePrefix.endsWith(".diagram")) {
				packageNamePrefix.substring(0, packageNamePrefix.length - ".diagram".length)
			}
			packageNamePrefix
		packageName
	}

}