package xpt.plugin

import com.google.inject.Inject
import xpt.GenEditorGenerator_qvto
import org.eclipse.gmf.codegen.gmfgen.GenPlugin
import xpt.Common
import org.eclipse.gmf.codegen.gmfgen.GenMetricContainer
import org.eclipse.gmf.codegen.gmfgen.GenDiagram

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

	def plugin(GenPlugin it) '''
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

	def fileTypes(GenPlugin it) '''
«extraLineBreak»
«tripleSpace(1)»<extension point="org.eclipse.team.core.fileTypes" id="repo-ftype">
«tripleSpace(2)»«xmlGeneratedTag»
«tripleSpace(2)»<fileTypes type="text" extension="«editorGen.diagramFileExtension»"/>
«tripleSpace(1)»</extension>
'''

	def extension_parser(GenPlugin it) '''
«extraLineBreak»
«tripleSpace(1)»<extension point="org.eclipse.emf.ecore.extension_parser" id="resource-factory">
«tripleSpace(2)»«xmlGeneratedTag»
«tripleSpace(2)»<parser
«tripleSpace(3)»type="«editorGen.diagramFileExtension»"
«tripleSpace(3)»class="org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory">
«tripleSpace(2)»</parser>
«tripleSpace(1)»</extension>
	'''

	def pluginMenu(GenPlugin it) '''
		«outTab»
		«tripleSpace(1)»<extension point="org.eclipse.gmf.runtime.common.ui.services.action.globalActionHandlerProviders" id="global-actions">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<GlobalActionHandlerProvider
		«tripleSpace(3)»class="org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandlerProvider"
		«tripleSpace(3)»id="«editorGen.modelID»Presentation">
		«tripleSpace(3)»<Priority name="Lowest"/>
		«tripleSpace(3)»<ViewId id="«editorGen.editor.ID»">
		«tripleSpace(4)»<ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart">
		«tripleSpace(5)»<GlobalActionId actionId="delete"/>
		«tripleSpace(4)»</ElementType>
		«tripleSpace(4)»<ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart">
		«tripleSpace(5)»<GlobalActionId actionId="save"/>
		«tripleSpace(4)»</ElementType>
		«tripleSpace(4)»<ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart">
		«tripleSpace(5)»<GlobalActionId actionId="save">
		«tripleSpace(5)»</GlobalActionId>
		«tripleSpace(4)»</ElementType>        
		«tripleSpace(3)»</ViewId>
		«tripleSpace(2)»</GlobalActionHandlerProvider>
		«IF printingEnabled»
			«tripleSpace(2)»<GlobalActionHandlerProvider
			«tripleSpace(3)»class="org.eclipse.gmf.runtime.diagram.ui.printing.render.providers.DiagramWithPrintGlobalActionHandlerProvider"
			«tripleSpace(3)»id="«editorGen.modelID»PresentationPrint">
			«tripleSpace(3)»<Priority name="Lowest"/>
			«tripleSpace(3)»<ViewId id="«editorGen.editor.ID»">
			«tripleSpace(4)»<ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart">
			«tripleSpace(5)»<GlobalActionId actionId="print"/>
			«tripleSpace(4)»</ElementType>
			«tripleSpace(3)»</ViewId>
			«tripleSpace(2)»</GlobalActionHandlerProvider>
		«ENDIF»
		«IF null == editorGen.application»
			«tripleSpace(2)»<GlobalActionHandlerProvider
			«tripleSpace(3)»class="org.eclipse.gmf.runtime.diagram.ui.providers.ide.providers.DiagramIDEGlobalActionHandlerProvider"
			«tripleSpace(3)»id="«editorGen.modelID»PresentationIDE">
			«tripleSpace(3)»<Priority name="Lowest"/>
			«tripleSpace(3)»<ViewId id="«editorGen.editor.ID»">
			«tripleSpace(4)»<ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart">
			«tripleSpace(5)»<GlobalActionId actionId="bookmark"/>
			«tripleSpace(4)»</ElementType>
			«tripleSpace(3)»</ViewId>
			«tripleSpace(2)»</GlobalActionHandlerProvider>
		«ENDIF»
		«tripleSpace(2)»<GlobalActionHandlerProvider
		«tripleSpace(4)»class="org.eclipse.gmf.runtime.diagram.ui.render.providers.DiagramUIRenderGlobalActionHandlerProvider"
		«tripleSpace(4)»id="«editorGen.modelID»Render">
		«tripleSpace(3)»<Priority name="Lowest"/>
		«tripleSpace(3)»<ViewId id="«editorGen.editor.ID»">
		«tripleSpace(4)»<ElementType class="org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart">
		«tripleSpace(5)»<GlobalActionId actionId="cut"/>
		«tripleSpace(5)»<GlobalActionId actionId="copy"/>
		«tripleSpace(5)»<GlobalActionId actionId="paste"/>
		«tripleSpace(4)»</ElementType>
		«tripleSpace(3)»</ViewId>
		«tripleSpace(2)»</GlobalActionHandlerProvider>
		«tripleSpace(1)»</extension>
		
	'''

	def metrics(GenMetricContainer it) '''
		«IF metrics.size() > 0»
		
		«tripleSpace(1)»<extension id="metrics-view" point="org.eclipse.ui.views">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<view class="«editorGen.diagram.getMetricProviderQualifiedClassName()»$ResultView"
		«tripleSpace(4)»id="«editorGen.diagram.getMetricViewID()»"
		«tripleSpace(4)»name="«editorGen.modelID» Diagram Metrics"/>
		«tripleSpace(1)»</extension>
		«ENDIF»
	'''

	def validation(GenDiagram it) '''
	«IF validationEnabled || hasAudits(editorGen)»
		«IF null == editorGen.application»

«tripleSpace(1)»<extension point="org.eclipse.gmf.runtime.common.ui.services.markerNavigationProviders" id="markers-navigation">
«tripleSpace(2)»«xmlGeneratedTag»
«tripleSpace(2)»<MarkerNavigationProvider class="«getMarkerNavigationProviderQualifiedClassName()»">
«tripleSpace(3)»<MarkerType name="«editorGen.plugin.ID + '.' + getValidationDiagnosticMarkerType()»"/>
«tripleSpace(3)»<Priority name="«markerNavigationProviderPriority»"/>
«tripleSpace(2)»</MarkerNavigationProvider>
«tripleSpace(1)»</extension>

«tripleSpace(1)»<extension id="«getValidationDiagnosticMarkerType()»" name="«editorGen.plugin.name» problems" point="org.eclipse.core.resources.markers">
«tripleSpace(2)»«xmlGeneratedTag»
«tripleSpace(2)»<super type="org.eclipse.core.resources.problemmarker"/>
«tripleSpace(2)»<super type="org.eclipse.gmf.runtime.common.ui.services.marker"/>
«tripleSpace(2)»<persistent value="true"/>
«tripleSpace(1)»</extension>   
		«ENDIF»
		«IF validationDecorators»

			«tripleSpace(1)»<extension id="validationDecoratorProvider" name="ValidationDecorations" point="org.eclipse.gmf.runtime.diagram.ui.decoratorProviders">
			«tripleSpace(2)»«xmlGeneratedTag»
			«tripleSpace(2)»<decoratorProvider class="«getValidationDecoratorProviderQualifiedClassName()»">
			«tripleSpace(3)»<Priority name="«validationDecoratorProviderPriority»"/>
			«tripleSpace(3)»<object class="org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart(org.eclipse.gmf.runtime.diagram.ui)" id="PRIMARY_VIEW"/>
			«tripleSpace(3)»<context decoratorTargets="PRIMARY_VIEW"/>
			«tripleSpace(2)»</decoratorProvider>
			«tripleSpace(1)»</extension>
		«ENDIF»
«ENDIF»
	'''

	def additions(GenPlugin it) ''''''
	
	def outTab() {
		return '	';
	}
}
