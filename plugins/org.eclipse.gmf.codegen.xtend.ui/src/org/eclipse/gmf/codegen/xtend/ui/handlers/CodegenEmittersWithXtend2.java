package org.eclipse.gmf.codegen.xtend.ui.handlers;

import java.net.URL;

import org.eclipse.gmf.codegen.util.CodegenEmitters;
import org.eclipse.gmf.codegen.util.GMFGeneratorModule;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.BinaryEmitter;
import org.eclipse.gmf.internal.common.codegen.TextEmitter;

import com.google.inject.Guice;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class CodegenEmittersWithXtend2 extends CodegenEmitters {

	private final Injector myInjector;

	@Override
	public TextEmitter getDiagramCanonicalEditPolicyEmitter() {
		// TODO Auto-generated method stub
		return super.getDiagramCanonicalEditPolicyEmitter();
	}



	@Override
	public TextEmitter getChildContainerCanonicalEditPolicyEmitter() {
		// TODO Auto-generated method stub
		return super.getChildContainerCanonicalEditPolicyEmitter();
	}



	@Override
	public TextEmitter getParserProviderEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getParserProviderEmitter();
	}



	@Override
	public String getValidateActionName(Object... input) throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getValidateActionName(input);
	}





	@Override
	public String getValidationMarkerName(Object... input) throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getValidationMarkerName(input);
	}



	@Override
	public TextEmitter getDiagramContentInitializerEmitter() {
		// TODO Auto-generated method stub
		return super.getDiagramContentInitializerEmitter();
	}






	@Override
	public String getShortcutCreationWizardName(Object... input) throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getShortcutCreationWizardName(input);
	}




	@Override
	public String getModelElementSelectionPageName(Object... input) throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getModelElementSelectionPageName(input);
	}



	@Override
	public TextEmitter getModelElementSelectionPageEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getModelElementSelectionPageEmitter();
	}



	@Override
	public String getNewDiagramFileWizardName(Object... input) throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getNewDiagramFileWizardName(input);
	}



	@Override
	public TextEmitter getNewDiagramFileWizardEmitter() {
		// TODO Auto-generated method stub
		return super.getNewDiagramFileWizardEmitter();
	}



	@Override
	public TextEmitter getDiagramEditorUtilEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getDiagramEditorUtilEmitter();
	}



	@Override
	public TextEmitter getCreationWizardEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getCreationWizardEmitter();
	}



	@Override
	public TextEmitter getCreationWizardPageEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getCreationWizardPageEmitter();
	}



	@Override
	public TextEmitter getDeleteElementActionEmitter() {
		// TODO Auto-generated method stub
		return super.getDeleteElementActionEmitter();
	}



	@Override
	public String getDeleteElementActionName(Object... input) throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getDeleteElementActionName(input);
	}



	@Override
	public TextEmitter getDiagramEditorContextMenuProviderEmitter() {
		// TODO Auto-generated method stub
		return super.getDiagramEditorContextMenuProviderEmitter();
	}



	@Override
	public String getDiagramEditorContextMenuProviderName(Object... input) throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getDiagramEditorContextMenuProviderName(input);
	}



	@Override
	public TextEmitter getElementChooserEmitter() {
		// TODO Auto-generated method stub
		return super.getElementChooserEmitter();
	}



	@Override
	public TextEmitter getDocumentProviderEmitter() {
		// TODO Auto-generated method stub
		return super.getDocumentProviderEmitter();
	}



	@Override
	public TextEmitter getActionBarContributorEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getActionBarContributorEmitter();
	}



	@Override
	public TextEmitter getMatchingStrategyEmitter() {
		// TODO Auto-generated method stub
		return super.getMatchingStrategyEmitter();
	}



	@Override
	public BinaryEmitter getShortcutImageEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getShortcutImageEmitter();
	}



	@Override
	public BinaryEmitter getDiagramIconEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getDiagramIconEmitter();
	}



	@Override
	public BinaryEmitter getWizardBannerImageEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getWizardBannerImageEmitter();
	}



	@Override
	public TextEmitter getModelAccessFacilityEmitter() {
		// TODO Auto-generated method stub
		return super.getModelAccessFacilityEmitter();
	}



	@Override
	public TextEmitter getNavigatorContentProviderEmitter() {
		// TODO Auto-generated method stub
		return super.getNavigatorContentProviderEmitter();
	}



	@Override
	public TextEmitter getDomainNavigatorContentProviderEmitter() {
		// TODO Auto-generated method stub
		return super.getDomainNavigatorContentProviderEmitter();
	}



	@Override
	public TextEmitter getDomainNavigatorLabelProviderEmitter() {
		// TODO Auto-generated method stub
		return super.getDomainNavigatorLabelProviderEmitter();
	}



	@Override
	public TextEmitter getDomainNavigatorItemEmitter() {
		// TODO Auto-generated method stub
		return super.getDomainNavigatorItemEmitter();
	}



	@Override
	public TextEmitter getNavigatorLabelProviderEmitter() {
		// TODO Auto-generated method stub
		return super.getNavigatorLabelProviderEmitter();
	}



	@Override
	public TextEmitter getNavigatorLinkHelperEmitter() {
		// TODO Auto-generated method stub
		return super.getNavigatorLinkHelperEmitter();
	}



	@Override
	public TextEmitter getNavigatorSorterEmitter() {
		// TODO Auto-generated method stub
		return super.getNavigatorSorterEmitter();
	}



	@Override
	public TextEmitter getNavigatorActionProviderEmitter() {
		// TODO Auto-generated method stub
		return super.getNavigatorActionProviderEmitter();
	}



	@Override
	public TextEmitter getAbstractNavigatorItemEmitter() {
		// TODO Auto-generated method stub
		return super.getAbstractNavigatorItemEmitter();
	}



	@Override
	public TextEmitter getNavigatorGroupEmitter() {
		// TODO Auto-generated method stub
		return super.getNavigatorGroupEmitter();
	}



	@Override
	public TextEmitter getNavigatorItemEmitter() {
		// TODO Auto-generated method stub
		return super.getNavigatorItemEmitter();
	}



	@Override
	public BinaryEmitter getGroupIconEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getGroupIconEmitter();
	}



	@Override
	public String getPreferenceInitializerName(Object... input) throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getPreferenceInitializerName(input);
	}



	@Override
	public TextEmitter getActivatorEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getActivatorEmitter();
	}



	@Override
	public TextEmitter getBundleManifestEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getBundleManifestEmitter();
	}



	@Override
	public TextEmitter getPluginXmlEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getPluginXmlEmitter();
	}



	@Override
	public TextEmitter getPluginPropertiesEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getPluginPropertiesEmitter();
	}



	@Override
	public TextEmitter getBuildPropertiesEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getBuildPropertiesEmitter();
	}



	@Override
	public TextEmitter getOptionsFileEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getOptionsFileEmitter();
	}



	@Override
	public TextEmitter getExternalizeEmitter() {
		// TODO Auto-generated method stub
		return super.getExternalizeEmitter();
	}



	@Override
	public TextEmitter getMessagesEmitter() {
		// TODO Auto-generated method stub
		return super.getMessagesEmitter();
	}






	@Override
	public TextEmitter getPredefinedActionEmitter() {
		// TODO Auto-generated method stub
		return super.getPredefinedActionEmitter();
	}



	public CodegenEmittersWithXtend2(boolean useBaseTemplatesOnly, String templateDirectory, boolean includeDynamicModelTemplates) {
		super(useBaseTemplatesOnly, templateDirectory, includeDynamicModelTemplates);
		myInjector = Guice.createInjector(new GMFGeneratorModule());
	}
	
	//-----------------------------------------------------------------------------------------

	//48 to go
	@Override
	public TextEmitter getShortcutCreationWizardEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::editor::ShortcutCreationWizard"); //$NON-NLS-1$
	}
	
	
	@Override
	public TextEmitter getShortcutPropertyTesterEmitter() {
		return getPrimaryXtendEmitter("xpt::editor::ShortcutPropertyTester"); //$NON-NLS-1$
	}

	
	@Override
	public TextEmitter getURIEditorInputTesterEmitter() {
		return getPrimaryXtendEmitter("xpt::editor::UriEditorInputTester"); //$NON-NLS-1$
	}

	
	@Override
	public TextEmitter getValidateActionEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::editor::ValidateAction"); //$NON-NLS-1$
	}

	
	@Override
	public TextEmitter getValidationMarkerEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::editor::ValidationMarker"); //$NON-NLS-1$
	}


	
	@Override
	public TextEmitter getActionBarAdvisorEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::application::ActionBarAdvisor"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getApplicationEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::application::Application"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getPerspectiveEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::application::Perspective"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getWorkbenchAdvisorEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::application::WorkbenchAdvisor"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getWorkbenchWindowAdvisorEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::application::WorkbenchWindowAdvisor"); //$NON-NLS-1$
	}
	
	@Override
	public TextEmitter getWizardNewFileCreationPageEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::application::WizardNewFileCreationPage"); //$NON-NLS-1$
	}
	
	@Override
	public TextEmitter getPreferenceInitializerEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::preferences::PreferenceInitializer"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCustomPreferencePageEmitter() throws UnexpectedBehaviourException {
		return getXtendEmitter("impl::preferences::CustomPage::Main"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getStandardPreferencePageEmitter() throws UnexpectedBehaviourException {
		return getXtendEmitter("impl::preferences::StandardPage::Main"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getPropertySectionEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::propsheet::PropertySection"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getPropertySheetLabelProviderEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::propsheet::LabelProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getRegexpExpressionFactoryEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::expressions::RegexpExpressionFactory"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getAbstractExpressionEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::expressions::AbstractExpression"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getOCLExpressionFactoryEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::expressions::OCLExpressionFactory"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getPredefinedParserEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("parsers::PredefinedParser"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getExpressionLabelParserEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("parsers::ExpressionLabelParser"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getAbstractParserEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("impl::parsers::AbstractParser"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCustomParserEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("parsers::CustomParser"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getEditPartFactoryEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::editparts::EditPartFactory"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getBaseEditHelperEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::edithelpers::BaseEditHelper"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getEditHelperAdviceEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::edithelpers::EditHelperAdvice"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getEditHelperEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::edithelpers::EditHelper"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getReorientLinkViewCommandEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::commands::ReorientLinkViewCommand"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCreateShortcutDecorationsCommandEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::commands::CreateShortcutDecorationsCommand"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getReorientRefLinkCommandEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::commands::ReorientRefLinkCommand"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getReorientLinkCommandEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::commands::ReorientLinkCommand"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCreateLinkCommandEmitter() throws UnexpectedBehaviourException {
		return getXtendEmitter("xpt::diagram::commands::CreateLinkCommand::Main"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCreateNodeCommandEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::commands::CreateNodeCommand"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCustomActionEmitter() {
		return getXtendEmitter("impl::actions::CustomAction::Main"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNodeItemSemanticEditPolicyEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::NodeItemSemanticEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getBaseItemSemanticEditPolicyEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::BaseItemSemanticEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getLinkItemSemanticEditPolicyEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::LinkItemSemanticEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCompartmentItemSemanticEditPolicyEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::CompartmentItemSemanticEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDiagramItemSemanticEditPolicyEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::DiagramItemSemanticEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNodeEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::NodeEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCompartmentEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::CompartmentEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getChildNodeLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::ChildNodeLabelEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDiagramEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::DiagramEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getExternalNodeLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::ExternalNodeLabelEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getLinkEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::LinkEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getLinkLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::LinkLabelEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNodeLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::NodeLabelEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getVisualIDRegistryEmitter() {
		return getPrimaryXtendEmitter("xpt::editor::VisualIDRegistry"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getGraphicalNodeEditPolicyEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::GraphicalNodeEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getOpenDiagramEditPolicyEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::OpenDiagram"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getTextNonResizableEditPolicyEmitter() throws UnexpectedBehaviourException {
		return getXtendEmitter("xpt::diagram::editpolicies::TextFeedback::TextNonResizableEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getTextSelectionEditPolicyEmitter() throws UnexpectedBehaviourException {
		return getXtendEmitter("xpt::diagram::editpolicies::TextFeedback::TextSelectionEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getVisualEffectEditPolicyEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::VisualEffectEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getPaletteEmitter() throws UnexpectedBehaviourException {
		return getXtendEmitter("xpt::editor::palette::PaletteFactory::Factory"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getElementTypesEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::providers::ElementTypes"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDiagramUpdaterEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::updater::DiagramUpdater"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getLinkDescriptorEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::updater::LinkDescriptor"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNodeDescriptorEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::updater::NodeDescriptor"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getUpdateCommandEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::updater::UpdateCommand"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getEditPartProviderEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::providers::EditPartProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getShortcutsDecoratorProviderEmitter() {
		return getPrimaryXtendEmitter("xpt::providers::ShortcutsDecoratorProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getValidationDecoratorProviderEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::providers::ValidationDecoratorProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getValidationProviderEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::providers::ValidationProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getViewProviderEmitter() {
		return getPrimaryXtendEmitter("xpt::providers::ViewProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getElementInitializersEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::providers::ElementInitializers"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getMarkerNavigationProviderEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::providers::MarkerNavigationProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getIconProviderEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::providers::IconProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getModelingAssistantProviderEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::providers::ModelingAssistantProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getMetricProviderEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::providers::MetricProvider"); //$NON-NLS-1$
	}

	private TextEmitter getMainXtendEmitter(String templateFilePath) {
		return getXtendEmitter(templateFilePath + PATH_SEPARATOR + "Main"); //$NON-NLS-1$
	}

	private Xtend2Emitter getPrimaryXtendEmitter(String templateFqn) {
		String[] parts = templateFqn.split("::");
		String classFqn = templateFqn.replace("::", ".");
		Class<?> clazz;
		try {
			clazz = Class.forName(classFqn);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Can't load: " + classFqn, e);
		}
		return new Xtend2Emitter(myInjector, clazz, parts[parts.length - 1]);
	}

	private Xtend2Emitter getXtendEmitter(String templateFqn) {
		String[] parts = templateFqn.split("::");
		String classFqn = templateFqn.substring(0, templateFqn.lastIndexOf("::")).replace("::", ".");
		Class<?> clazz;
		try {
			clazz = Class.forName(classFqn);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Can't load: " + classFqn, e);
		}
		return new Xtend2Emitter(myInjector, clazz, parts[parts.length - 1]);
	}

}
