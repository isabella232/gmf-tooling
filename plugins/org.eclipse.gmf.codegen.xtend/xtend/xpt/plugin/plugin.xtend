package xpt.plugin

import com.google.inject.Inject
import xpt.GenEditorGenerator_qvto
import org.eclipse.gmf.codegen.gmfgen.GenPlugin
import xpt.Common
import org.eclipse.gmf.codegen.gmfgen.GenMetricContainer
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.editor.extensions

@com.google.inject.Singleton class plugin {

@Inject extension GenEditorGenerator_qvto
@Inject extension Common
@Inject extension xpt.plugin.pluginUtils

@Inject xpt.editor.extensions xptEditorExtension
@Inject xpt.diagram.preferences.extensions xptPreferencesExtension
@Inject xpt.propsheet.extensions xptPropsheetExtension
@Inject xpt.navigator.extensions xptNavigatorExtension
@Inject xpt.application.extensions xptApplicationExtension
@Inject xpt.diagram.updater.extensions xptUpdaterExtension
@Inject impl.actions.extensions xptActionExtension
@Inject xpt.providers.extensions xptProvidersExtension

def qualifiedClassName(GenPlugin it) '''plugin.xml'''
def fullPath(GenPlugin it) '''«qualifiedClassName(it)»'''

def plugin(GenPlugin it)'''
<?xml version="1.0" encoding="UTF-8"?>
<?eclipse version="3.0"?>
«it.editorGen.xcopyright»
<plugin>
«fileTypes()»
«extension_parser()»
«xptEditorExtension.extensions(it.editorGen)»
«pluginMenu()»
«validation(it.editorGen.diagram)»
«IF it.editorGen.metrics != null»«metrics(it.editorGen.metrics)»«ENDIF»
«xptPreferencesExtension.extensions(it.editorGen.diagram)»
«IF it.editorGen.propertySheet != null»«xptPropsheetExtension.extensions(it.editorGen.propertySheet)»«ENDIF»
«xptProvidersExtension.extensions(it.editorGen.diagram)»
«IF it.editorGen.navigator != null»«xptNavigatorExtension.extensions(it.editorGen.navigator)»«ENDIF»
«IF it.editorGen.application != null»«xptApplicationExtension.extensions(it.editorGen.application)»«ENDIF»
«extensionsConstraintProviders(it.editorGen)»
«xptUpdaterExtension.extensions(it.editorGen.diagramUpdater)»
«xptActionExtension.Main(it.editorGen)»
«additions»
</plugin>
'''

def fileTypes(GenPlugin it)'''
   <extension point="org.eclipse.team.core.fileTypes" id="repo-ftype">
      «xmlGeneratedTag»
      <fileTypes type="text" extension="«editorGen.diagramFileExtension»"/>
   </extension>
'''

def extension_parser(GenPlugin it)'''
   <extension point="org.eclipse.emf.ecore.extension_parser" id="resource-factory">
      «xmlGeneratedTag»
      <parser
         type="«editorGen.diagramFileExtension»"
         class="org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory">
      </parser>
   </extension>
'''

def pluginMenu(GenPlugin it)'''
   <extension point="org.eclipse.gmf.runtime.common.ui.services.action.globalActionHandlerProviders" id="global-actions">
      «xmlGeneratedTag»
      <GlobalActionHandlerProvider
         class="org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandlerProvider"
         id="«editorGen.modelID»Presentation">
         <Priority name="Lowest"/>
         <ViewId id="«editorGen.editor.ID»">
            <ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart">
               <GlobalActionId actionId="delete"/>
            </ElementType>
            <ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart">
               <GlobalActionId actionId="save"/>
            </ElementType>
            <ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart">
               <GlobalActionId actionId="save">
               </GlobalActionId>
            </ElementType>        
         </ViewId>
      </GlobalActionHandlerProvider>
«IF printingEnabled»
      <GlobalActionHandlerProvider
         class="org.eclipse.gmf.runtime.diagram.ui.printing.render.providers.DiagramWithPrintGlobalActionHandlerProvider"
         id="«editorGen.modelID»PresentationPrint">
         <Priority name="Lowest"/>
         <ViewId id="«editorGen.editor.ID»">
            <ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart">
               <GlobalActionId actionId="print"/>
            </ElementType>
         </ViewId>
      </GlobalActionHandlerProvider>
«ENDIF»
«IF null == editorGen.application»
      <GlobalActionHandlerProvider
         class="org.eclipse.gmf.runtime.diagram.ui.providers.ide.providers.DiagramIDEGlobalActionHandlerProvider"
         id="«editorGen.modelID»PresentationIDE">
         <Priority name="Lowest"/>
         <ViewId id="«editorGen.editor.ID»">
            <ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart">
               <GlobalActionId actionId="bookmark"/>
            </ElementType>
         </ViewId>
      </GlobalActionHandlerProvider>
«ENDIF»
      <GlobalActionHandlerProvider
            class="org.eclipse.gmf.runtime.diagram.ui.render.providers.DiagramUIRenderGlobalActionHandlerProvider"
            id="«editorGen.modelID»Render">
         <Priority name="Lowest"/>
         <ViewId id="«editorGen.editor.ID»">
            <ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart">
               <GlobalActionId actionId="cut"/>
               <GlobalActionId actionId="copy"/>
               <GlobalActionId actionId="paste"/>
            </ElementType>
         </ViewId>
      </GlobalActionHandlerProvider>
   </extension>

'''

def metrics(GenMetricContainer it)'''
«IF metrics.size() > 0»
   <extension id="metrics-view" point="org.eclipse.ui.views">
      «xmlGeneratedTag»
   	  <view class="«editorGen.diagram.getMetricProviderQualifiedClassName()»$ResultView"
			id="«editorGen.diagram.getMetricViewID()»"
			name="«editorGen.modelID» Diagram Metrics"/>
   </extension>
«ENDIF»
'''

def validation (GenDiagram it)'''
«IF validationEnabled || hasAudits(editorGen)»
«IF null == editorGen.application»

   <extension point="org.eclipse.gmf.runtime.common.ui.services.markerNavigationProviders" id="markers-navigation">
      «xmlGeneratedTag»
      <MarkerNavigationProvider class="«getMarkerNavigationProviderQualifiedClassName()»">
         <MarkerType name="«editorGen.plugin.ID + '.' + getValidationDiagnosticMarkerType()»"/>
         <Priority name="«markerNavigationProviderPriority»"/>
      </MarkerNavigationProvider>
   </extension>

   <extension id="«getValidationDiagnosticMarkerType()»" name="«editorGen.plugin.name» problems" point="org.eclipse.core.resources.markers">
      «xmlGeneratedTag»
      <super type="org.eclipse.core.resources.problemmarker"/>
      <super type="org.eclipse.gmf.runtime.common.ui.services.marker"/>
      <persistent value="true"/>
   </extension>   
«ENDIF»
«IF validationDecorators»

   <extension id="validationDecoratorProvider" name="ValidationDecorations" point="org.eclipse.gmf.runtime.diagram.ui.decoratorProviders">
      «xmlGeneratedTag»
      <decoratorProvider class="«getValidationDecoratorProviderQualifiedClassName()»">
         <Priority name="«validationDecoratorProviderPriority»"/>
         <object class="org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart(org.eclipse.gmf.runtime.diagram.ui)" id="PRIMARY_VIEW"/>
         <context decoratorTargets="PRIMARY_VIEW"/>
      </decoratorProvider>
   </extension>
«ENDIF»
«ENDIF»
'''

def additions(GenPlugin it)''''''
	
}