package xpt

import com.google.inject.Inject
import plugin.Activator
import org.eclipse.gmf.codegen.gmfgen.GenPlugin
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.editor.ElementChooser
import xpt.editor.DiagramEditorUtil
import impl.actions.PredefinedAction
import org.eclipse.gmf.codegen.gmfgen.GenAction
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel
import diagram.editparts.NodeEditPart
import diagram.editparts.DiagramEditPart
import diagram.editparts.NodeLabelEditPart
import diagram.editparts.LinkEditPart
import diagram.editparts.LinkLabelEditPart
import diagram.editparts.CompartmentEditPart
import diagram.editparts.ExternalNodeLabelEditPart
import xpt.diagram.editpolicies.CompartmentItemSemanticEditPolicy
import xpt.diagram.editpolicies.DiagramItemSemanticEditPolicy
import xpt.diagram.editpolicies.LinkItemSemanticEditPolicy
import xpt.diagram.editpolicies.NodeItemSemanticEditPolicy
import xpt.diagram.editpolicies.TextNonResizableEditPolicy
import xpt.diagram.commands.CreateShortcutDecorationsCommand
import xpt.diagram.editpolicies.TextSelectionEditPolicy
import xpt.diagram.editpolicies.GraphicalNodeEditPolicy
import xpt.providers.ElementTypes
import xpt.diagram.editparts.EditPartFactory
import xpt.diagram.updater.NodeDescriptor
import xpt.diagram.updater.LinkDescriptor
import xpt.diagram.updater.DiagramUpdater
import org.eclipse.gmf.codegen.gmfgen.GenDiagramUpdater
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import diagram.editparts.ChildNodeLabelEditPart
import xpt.editor.CreationWizardPage
import xpt.editor.CreationWizard
import org.eclipse.gmf.codegen.gmfgen.GenApplication
import xpt.application.WorkbenchWindowAdvisor
import xpt.application.WorkbenchAdvisor
import xpt.application.Application
import xpt.application.Perspective
import xpt.application.ActionBarAdvisor
import xpt.diagram.edithelpers.BaseEditHelper
import xpt.diagram.commands.CreateNodeCommand
import xpt.diagram.editpolicies.BaseItemSemanticEditPolicy
import xpt.diagram.commands.ReorientLinkViewCommand
import xpt.diagram.commands.CreateLinkCommand
import xpt.diagram.commands.ReorientLinkCommand
import xpt.editor.Editor
import org.eclipse.gmf.codegen.gmfgen.GenEditorView
import xpt.providers.MetricProvider
import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import xpt.navigator.NavigatorItem
import xpt.editor.InitDiagramFileAction
import xpt.editor.NewDiagramFileWizard
import xpt.editor.DiagramContentInitializer
import xpt.providers.ValidationProvider
import xpt.providers.MarkerNavigationProvider
import xpt.providers.ValidationDecoratorProvider
import xpt.expressions.AbstractExpression
import xpt.navigator.DomainNavigatorItem

class QualifiedClassNameProvider {
	
	@Inject Activator activator;
	
	@Inject DiagramEditorUtil diagramEditorUtil;
	
	@Inject ElementChooser elementChooser;
	
	@Inject PredefinedAction predAction;
	
	@Inject NodeEditPart nodeEditPart;
	@Inject DiagramEditPart diagramEditPart;
	@Inject NodeLabelEditPart nodeLabelEditPart;
	@Inject LinkEditPart linkEditPart;
	@Inject LinkLabelEditPart linkLabelEditPart;
	@Inject CompartmentEditPart compartmentEditPart;
	@Inject ExternalNodeLabelEditPart externalNodeLabelEditPart;
	@Inject ChildNodeLabelEditPart childNodeLabelEditPart;
	
	@Inject BaseItemSemanticEditPolicy baseItemSemantic;
	@Inject CompartmentItemSemanticEditPolicy compItemSemantic;
	@Inject DiagramItemSemanticEditPolicy diagramItemSemantic;
	@Inject LinkItemSemanticEditPolicy linkItemSemantic;
	@Inject NodeItemSemanticEditPolicy nodeItemSemantic;
	
	@Inject GraphicalNodeEditPolicy graphicalEditPolicy;
	
	@Inject TextNonResizableEditPolicy textNonResizable;
	@Inject TextSelectionEditPolicy textSelection;
	
	@Inject CreateShortcutDecorationsCommand createShortcutDecorationCommand;
	
	@Inject ElementTypes elementTypes;
	
	@Inject EditPartFactory editPartFactory;
	
	@Inject NodeDescriptor nodeDescriptor;
	@Inject LinkDescriptor linkDescriptor;
	@Inject DiagramUpdater diagramUpdater;
	
	@Inject CreationWizardPage creationWizardPage;
	@Inject CreationWizard creationWizard;
	@Inject WorkbenchWindowAdvisor workbenchWindowAdvisor
	@Inject WorkbenchAdvisor workbenchAdvisor;
	@Inject Application application;
	@Inject Perspective perspective;
	@Inject ActionBarAdvisor actionBarAdvisor;
	@Inject BaseEditHelper baseEditHelper;
	
	@Inject CreateNodeCommand nodeCommand;
	@Inject CreateLinkCommand linkCommand;
	@Inject ReorientLinkViewCommand reorientLinkViewCommand;
	@Inject ReorientLinkCommand reorientLinkCommand;
	
	@Inject Editor editor;
	@Inject MetricProvider metricProvider;
	@Inject InitDiagramFileAction initDiagramFileAction;
	@Inject NewDiagramFileWizard diagramFileWizard;
	@Inject DiagramContentInitializer diagramContent;
	
	
	@Inject AbstractExpression abstractExpression;
	
	@Inject NavigatorItem navigatorItem;
	@Inject DomainNavigatorItem domainNavigatorItem;
	
	@Inject ValidationProvider validationProvider;
	@Inject MarkerNavigationProvider markerNavigatorProvider;
	@Inject ValidationDecoratorProvider validationDecoratorProvider;
	
	def getActivatorQualifiedClassName(GenPlugin it) '''«activator.qualifiedClassName(it)»'''
	
	def getElementChooserQualifiedClassName(GenDiagram it) '''«elementChooser.qualifiedClassName(it)»'''
	
	def getDiagramEditorUtilQualifiedClassName(GenDiagram it) '''«diagramEditorUtil.qualifiedClassName(it)»'''
	
	def getActionQualifiedClassName(GenAction it) '''«predAction.qualifiedClassName(it)»'''
	
	def getActionClassName(GenAction it) '''«predAction.qualifiedClassName(it)»'''
	
	def dispatch getEditPartQualifiedClassName(GenCommonBase it) ''''''
	def dispatch getEditPartQualifiedClassName(GenNode it) '''«nodeEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenLink it) '''«linkEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenCompartment it) '''«compartmentEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenDiagram it) '''«diagramEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenExternalNodeLabel it) '''«externalNodeLabelEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenNodeLabel it) '''«nodeLabelEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenLinkLabel it) '''«linkLabelEditPart.qualifiedClassName(it)»'''
	def dispatch getEditPartQualifiedClassName(GenChildLabelNode it) '''«childNodeLabelEditPart.qualifiedClassName(it)»'''
	
	def dispatch getEditPartClassName(GenCommonBase it) ''''''
	def dispatch getEditPartClassName(GenNode it) '''«nodeEditPart.className(it)»'''
	def dispatch getEditPartClassName(GenLink it) '''«linkEditPart.className(it)»'''
	def dispatch getEditPartClassName(GenCompartment it) '''«compartmentEditPart.className(it)»'''
	def dispatch getEditPartClassName(GenDiagram it) '''«diagramEditPart.className(it)»'''
	def dispatch getEditPartClassName(GenExternalNodeLabel it) '''«externalNodeLabelEditPart.className(it)»'''
	def dispatch getEditPartClassName(GenNodeLabel it) '''«nodeLabelEditPart.className(it)»'''
	def dispatch getEditPartClassName(GenLinkLabel it) '''«linkLabelEditPart.className(it)»'''
	def dispatch getEditPartClassName(GenChildLabelNode it) '''«childNodeLabelEditPart.className(it)»'''
	
	def getBaseItemSemanticEditPolicyQualifiedClassName(GenDiagram it) '''«baseItemSemantic.qualifiedClassName(it)»'''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenCommonBase it) ''''''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenDiagram it) '''«diagramItemSemantic.qualifiedClassName(it)»'''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenCompartment it) '''«compItemSemantic.qualifiedClassName(it)»'''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenLink it) '''«linkItemSemantic.qualifiedClassName(it)»'''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenNode it) '''«nodeItemSemantic.qualifiedClassName(it)»'''
	
	def dispatch getItemSemanticEditPolicyClassName(GenCommonBase it) ''''''
	def dispatch getItemSemanticEditPolicyClassName(GenDiagram it) '''«diagramItemSemantic.className(it)»'''
	def dispatch getItemSemanticEditPolicyClassName(GenCompartment it) '''«compItemSemantic.className(it)»'''
	def dispatch getItemSemanticEditPolicyClassName(GenLink it) '''«linkItemSemantic.className(it)»'''
	def dispatch getItemSemanticEditPolicyClassName(GenNode it) '''«nodeItemSemantic.className(it)»'''
	
	def graphicalNodeEditPolicyQualifiedClassName(GenNode it) '''«graphicalEditPolicy.qualifiedClassName(it)»'''
	
	def getTextNonResizableEditPolicyQualifiedClassName(GenDiagram it) '''«textNonResizable.qualifiedClassName(it)»'''
	def getTextSelectionEditPolicyQualifiedClassName(GenDiagram it) '''«textSelection.qualifiedClassName(it)»'''
	
	def getCreateShortcutDecorationsCommandQualifiedClassName(GenDiagram it) '''«createShortcutDecorationCommand.qualifiedClassName(it)»'''
	
	def getElementTypesQualifiedClassName(GenDiagram it) '''«elementTypes.qualifiedClassName(it)»'''
	
	def getEditPartFactoryQualifiedClassName(GenDiagram it) '''«editPartFactory.qualifiedClassName(it)»'''
	
	def getNodeDescriptorQualifiedClassName(GenDiagramUpdater it) '''«nodeDescriptor.qualifiedClassName(it)»'''
	def getLinkDescriptorQualifiedClassName(GenDiagramUpdater it) '''«linkDescriptor.qualifiedClassName(it)»'''
	def getDiagramUpdaterQualifiedClassName(GenDiagramUpdater it) '''«diagramUpdater.qualifiedClassName(it)»'''
	
	def getCreationWizardQualifiedClassName(GenDiagram it) '''«creationWizard.qualifiedClassName(it)»'''
	def getCreationWizardPageQualifiedClassName(GenDiagram it) '''«creationWizardPage.qualifiedClassName(it)»'''
	def getWorkbenchAdvisorQualifiedClassName(GenApplication it) '''«workbenchAdvisor.qualifiedClassName(it)»'''
	def getWorkbenchWindowAdvisorQualifiedClassName(GenApplication it) '''«workbenchWindowAdvisor.qualifiedClassName(it)»'''
	def getWorkbenchWindowAdvisorClassName(GenApplication it) '''«workbenchWindowAdvisor.className(it)»'''
	def getApplicationQualifiedClassName(GenApplication it) '''«application.qualifiedClassName(it)»'''
	def getPerspectiveQualifiedClassName(GenApplication it) '''«perspective.qualifiedClassName(it)»'''
	def getActionBarAdvisorQualifiedClassName(GenApplication it) '''«actionBarAdvisor.qualifiedClassName(it)»'''
	def getBaseEditHelperQualifiedClassName(GenDiagram it) '''«baseEditHelper.qualifiedClassName(it)»'''
	
	def dispatch getCreateCommandQualifiedClassName(GenCommonBase it) ''''''
	def dispatch getCreateCommandQualifiedClassName(GenNode it) '''«nodeCommand.qualifiedClassName(it)»'''
	def dispatch getCreateCommandQualifiedClassName(GenLink it) '''«linkCommand.qualifiedClassName(it)»'''
	
	def getReorientCommandQualifiedClassName(GenLink it) '''«reorientLinkCommand.qualifiedClassName(it)»'''
	def getReorientConnectionViewCommandQualifiedClassName(GenDiagram it) '''«reorientLinkViewCommand.qualifiedClassName(it)»'''
	
	def getEditorQualifiedClassName(GenEditorView it) '''«editor.qualifiedClassName(it)»'''
	def getMetricProviderQualifiedClassName(GenDiagram it) '''«metricProvider.qualifiedClassName(it)»'''
	def getInitDiagramFileActionQualifiedClassName(GenDiagram it) '''«initDiagramFileAction.qualifiedClassName(it)»'''
	def getNewDiagramFileWizardQualifiedClassName(GenDiagram it) '''«diagramFileWizard.qualifiedClassName(it)»'''
	def getDiagramContentInitializerQualifiedClassName(GenDiagram it) '''«diagramContent.qualifiedClassName(it)»'''

	def getAbstractExpressionQualifiedClassName(GenDiagram it) '''«abstractExpression.qualifiedClassName(it)»'''
	
	def getNavigatorItemQualifiedClassName(GenNavigator it) '''«navigatorItem.qualifiedClassName(it)»'''
	def getDomainNavigatorItemQualifiedClassName(GenNavigator it) '''«domainNavigatorItem.qualifiedClassName(it)»'''
	
	def getValidationProviderQualifiedClassName(GenDiagram it) '''«validationProvider.qualifiedClassName(it)»'''
	def getMarkerNavigationProviderQualifiedClassName(GenDiagram it) '''«markerNavigatorProvider.qualifiedClassName(it)»'''
	def getValidationDecoratorProviderQualifiedClassName(GenDiagram it) '''«validationDecoratorProvider.qualifiedClassName(it)»'''
}