package xpt.plugin

import com.google.inject.Inject
import xpt.GenEditorGenerator_qvto
import org.eclipse.gmf.codegen.gmfgen.GenPlugin
import xpt.Common

@com.google.inject.Singleton class manifest {

@Inject extension GenEditorGenerator_qvto
@Inject extension Common

def qualifiedClassName(GenPlugin it) '''META-INF/MANIFEST.MF'''
def fullPath(GenPlugin it) '''«qualifiedClassName(it)»'''

def manifest (GenPlugin it)'''
«manifestVersion(it)»
«bundleManifestVersion(it)»
«bundleName(it)»
«symbolicName(it)»
«bundleVersion(it)»
«bundleClassPath(it)»
«bundleActivator(it)»
«bundleVendor(it)»
«bundleLocalization(it)»
«exportPackages()»
«requireBundle()»
«bundleActivatorPolicy(it)»
«executionEnvironment()»
«additions()»
'''
def manifestVersion(GenPlugin it) '''Manifest-Version: 1.0'''
def bundleManifestVersion(GenPlugin it) '''Bundle-ManifestVersion: 2'''
def bundleName(GenPlugin it) '''Bundle-Name: %pluginName'''
def symbolicName(GenPlugin it) '''Bundle-SymbolicName: «ID»; singleton:=true'''
def bundleVersion(GenPlugin it) '''Bundle-Version: «version»'''
def bundleClassPath(GenPlugin it) '''Bundle-ClassPath: .'''
def bundleActivator(GenPlugin it) '''Bundle-Activator: «getActivatorQualifiedClassName()»'''
def bundleVendor(GenPlugin it) '''Bundle-Vendor: %providerName'''
def bundleLocalization(GenPlugin it) '''Bundle-Localization: plugin'''
def bundleActivatorPolicy(GenPlugin it) '''Bundle-ActivationPolicy: lazy'''

def additions(GenPlugin it)''''''

def exportPackages(GenPlugin it)'''
Export-Package: «editorGen.diagram.editPartsPackageName», 
 «editorGen.editor.packageName»,
 «editorGen.diagram.providersPackageName»
'''

def requireBundle(GenPlugin it)'''
Require-Bundle: org.eclipse.core.runtime,
«IF editorGen.application == null» org.eclipse.core.resources,
«ENDIF»
«IF editorGen.diagram.generateShortcutIcon() || (editorGen.navigator != null && editorGen.navigator.generateDomainModelNavigator)» org.eclipse.core.expressions,
«ENDIF» org.eclipse.jface,
«IF editorGen.application == null» org.eclipse.ui.ide,
«ENDIF» org.eclipse.ui.views,
«IF editorGen.navigator != null» org.eclipse.ui.navigator,
 org.eclipse.ui.navigator.resources,
«ENDIF» org.eclipse.emf.ecore,
 org.eclipse.emf.ecore.xmi,
 org.eclipse.emf.edit.ui,
 org.eclipse.gmf.runtime.emf.core,
 org.eclipse.gmf.runtime.emf.commands.core,
 org.eclipse.gmf.runtime.emf.ui.properties,
 org.eclipse.gmf.runtime.diagram.ui,
«IF printingEnabled» org.eclipse.gmf.runtime.diagram.ui.printing,
 org.eclipse.gmf.runtime.diagram.ui.printing.render,
«ENDIF»
«IF editorGen.propertySheet != null» org.eclipse.gmf.runtime.diagram.ui.properties,
«ENDIF» org.eclipse.gmf.runtime.diagram.ui.providers,
«IF editorGen.application == null» org.eclipse.gmf.runtime.diagram.ui.providers.ide,
«ENDIF» org.eclipse.gmf.runtime.diagram.ui.render,
 org.eclipse.gmf.runtime.diagram.ui.resources.editor,
«IF editorGen.application == null» org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide,
«ENDIF»
«var reqPlugins = getAllRequiredPlugins()»
«IF !reqPlugins.contains('org.eclipse.gmf.tooling.runtime')»
«var notUsetBooleanVar = reqPlugins.add('org.eclipse.gmf.tooling.runtime')»
«ENDIF»
«FOR reqId : reqPlugins» «reqId»;visibility:=reexport,«extraLineBreak»
«ENDFOR» org.eclipse.gef;visibility:=reexport
'''

def executionEnvironment(GenPlugin it) '''
Bundle-RequiredExecutionEnvironment: «IF editorGen.jdkComplianceLevel() > 5»JavaSE-1.6«ELSE»J2SE-1.«editorGen.jdkComplianceLevel()»«ENDIF»
'''
}