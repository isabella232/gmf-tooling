package xpt.plugin

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenPlugin
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

@com.google.inject.Singleton class properties {

@Inject extension xpt.propsheet.extensions
@Inject extension xpt.providers.extensions
@Inject extension xpt.plugin.propUtils
@Inject extension impl.actions.extensions

def qualifiedClassName(GenPlugin it) '''plugin.properties'''
def fullPath(GenPlugin it) '''«qualifiedClassName(it)»'''

def properties(GenPlugin it)'''
«pluginName»
«providerName»

«editor(editorGen)»

«action(editorGen)»

«application(editorGen)»

«navigator(editorGen)»
«diagramUpdater(editorGen)»

«IF editorGen.propertySheet != null»«i18n(editorGen.propertySheet)»«ENDIF»
«i18n_diagramPreferences(editorGen.diagram)»
«i18n(editorGen.diagram)»
«i18n(editorGen)»
«additions»
'''

def additions(GenPlugin it)''''''

def pluginName(GenPlugin it)'''
pluginName=«name»
'''

def providerName(GenPlugin it)'''
providerName=«provider»
'''

def action(GenEditorGenerator it)'''
«IF diagram.generateInitDiagramAction()»
initDiagramActionLabel=Initialize «diagramFileExtension» diagram file
«ENDIF»
'''

def editor(GenEditorGenerator it)'''
editorName=«modelID» Diagram Editing
context.description=«modelID» Diagram Editing
context.name=In «modelID» Diagram Editor
newWizardName=«modelID» Diagram
newWizardDesc=Creates «modelID» diagram.
'''

def navigator(GenEditorGenerator it)'''
navigatorContentName=*.«diagramFileExtension» diagram contents
«IF null != navigator && navigator.generateDomainModelNavigator»
domainNavigatorContentName=*.«domainFileExtension» model contents
«ENDIF»
'''

def diagramUpdater(GenEditorGenerator it)'''
update.diagram.name=Update «modelID» diagram
update.diagram.description=Perform «modelID» diagram update
'''

def application(GenEditorGenerator it)'''
«IF null != application»
perspectiveName=«modelID» Perspective
applicationActionSetLabel=<«modelID» Actions
newDiagramActionLabel=«modelID» Diagram
aboutActionLabel=«modelID» Diagram About...
openURIActionLabel=Open URI...
openURIActionDescription=Open file by URI
openActionLabel=Open...
openActionDescription=Open file
«ENDIF»
'''
}