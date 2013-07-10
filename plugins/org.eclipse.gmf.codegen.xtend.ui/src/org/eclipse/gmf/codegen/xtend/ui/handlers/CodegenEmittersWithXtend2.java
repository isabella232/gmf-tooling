package org.eclipse.gmf.codegen.xtend.ui.handlers;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.NullProgressMonitor;
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
	public BinaryEmitter getGroupIconEmitter() throws UnexpectedBehaviourException {
		// TODO Auto-generated method stub
		return super.getGroupIconEmitter();
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

	public CodegenEmittersWithXtend2(boolean useBaseTemplatesOnly, String templateDirectory, boolean includeDynamicModelTemplates) {
		super(useBaseTemplatesOnly, templateDirectory, includeDynamicModelTemplates);
		myInjector = Guice.createInjector(new GMFGeneratorModule());
	}

	//-----------------------------------------------------------------------------------------
	// names emotters 
	@Override
	public String getPreferenceInitializerName(Object... input) throws UnexpectedBehaviourException {
		return getQualifiedClassName("xpt::diagram::preferences::PreferenceInitializer", input); //$NON-NLS-1$
	}

	@Override
	public String getValidateActionName(Object... input) throws UnexpectedBehaviourException {
		return getQualifiedClassName("xpt::editor::ValidateAction", input); //$NON-NLS-1$
	}

	@Override
	public String getValidationMarkerName(Object... input) throws UnexpectedBehaviourException {
		return getQualifiedClassName("xpt::editor::ValidationMarker", input); //$NON-NLS-1$
	}

	@Override
	public String getShortcutCreationWizardName(Object... input) throws UnexpectedBehaviourException {
		return getQualifiedClassName("xpt::editor::ShortcutCreationWizard", input); //$NON-NLS-1$
	}

	@Override
	public String getModelElementSelectionPageName(Object... input) throws UnexpectedBehaviourException {
		return getQualifiedClassName("xpt::editor::ModelElementSelectionPage", input); //$NON-NLS-1$
	}

	@Override
	public String getNewDiagramFileWizardName(Object... input) throws UnexpectedBehaviourException {
		return getQualifiedClassName("xpt::editor::NewDiagramFileWizard", input); //$NON-NLS-1$
	}

	@Override
	public String getDeleteElementActionName(Object... input) throws UnexpectedBehaviourException {
		return getQualifiedClassName("xpt::editor::DeleteElementAction", input); //$NON-NLS-1$
	}

	@Override
	public String getDiagramEditorContextMenuProviderName(Object... input) throws UnexpectedBehaviourException {
		return getQualifiedClassName("xpt::editor::DiagramEditorContextMenuProvider", input); //$NON-NLS-1$
	}
	
	//14 to go

	@Override
	public TextEmitter getDiagramCanonicalEditPolicyEmitter() {
		return getXtendEmitter("diagram::editpolicies::DiagramCanonicalEditPolicy::Main"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getChildContainerCanonicalEditPolicyEmitter() {
		return getXtendEmitter("diagram::editpolicies::ChildContainerCanonicalEditPolicy::Main"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCreationWizardPageEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::editor::CreationWizardPage"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getParserProviderEmitter() throws UnexpectedBehaviourException {
		return getXtendEmitter("parsers::ParserProvider::Main"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getPredefinedActionEmitter() {
		return getXtendEmitter("impl::actions::PredefinedAction::Main"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDomainNavigatorLabelProviderEmitter() {
		return getPrimaryXtendEmitter("xpt::navigator::DomainNavigatorLabelProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDomainNavigatorItemEmitter() {
		return getPrimaryXtendEmitter("xpt::navigator::DomainNavigatorItem"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDomainNavigatorContentProviderEmitter() {
		return getPrimaryXtendEmitter("xpt::navigator::DomainNavigatorContentProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNavigatorContentProviderEmitter() {
		return getPrimaryXtendEmitter("xpt::navigator::NavigatorContentProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getEditorEmitter() {
		return getPrimaryXtendEmitter("xpt::editor::Editor"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNavigatorLinkHelperEmitter() {
		return getPrimaryXtendEmitter("xpt::navigator::NavigatorLinkHelper"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNavigatorLabelProviderEmitter() {
		return getPrimaryXtendEmitter("xpt::navigator::NavigatorLabelProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNavigatorActionProviderEmitter() {
		return getPrimaryXtendEmitter("xpt::navigator::NavigatorActionProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNavigatorItemEmitter() {
		return getPrimaryXtendEmitter("xpt::navigator::NavigatorItem"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNavigatorGroupEmitter() {
		return getPrimaryXtendEmitter("xpt::navigator::NavigatorGroup"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNavigatorSorterEmitter() {
		return getPrimaryXtendEmitter("xpt::navigator::NavigatorSorter"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getAbstractNavigatorItemEmitter() {
		return getPrimaryXtendEmitter("xpt::navigator::AbstractNavigatorItem"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDocumentProviderEmitter() {
		return getPrimaryXtendEmitter("xpt::editor::DocumentProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDiagramContentInitializerEmitter() {
		return getPrimaryXtendEmitter("xpt::editor::DiagramContentInitializer"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDiagramEditorContextMenuProviderEmitter() {
		return getPrimaryXtendEmitter("xpt::editor::DiagramEditorContextMenuProvider"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getActionBarContributorEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::editor::ActionBarContributor"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDiagramEditorUtilEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::editor::DiagramEditorUtil"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getElementChooserEmitter() {
		return getPrimaryXtendEmitter("xpt::editor::ElementChooser"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getMatchingStrategyEmitter() {
		return getPrimaryXtendEmitter("xpt::editor::MatchingStrategy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getModelElementSelectionPageEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::editor::ModelElementSelectionPage"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNewDiagramFileWizardEmitter() {
		return getPrimaryXtendEmitter("xpt::editor::NewDiagramFileWizard"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDeleteElementActionEmitter() {
		return getPrimaryXtendEmitter("xpt::editor::DeleteElementAction"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCreationWizardEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::editor::CreationWizard"); //$NON-NLS-1$
	}

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

	/**
	 * @deprecated copy pasted, make protected in super-class
	 */
	@Deprecated
	private String getQualifiedClassName(String templateName, Object... input) throws UnexpectedBehaviourException {
		TextEmitter emitter = getQualifiedClassNameEmitter(templateName);
		return getText(emitter, input);
	}

	/**
	 * @deprecated copy pasted, make protected in super-class
	 */
	@Deprecated
	private TextEmitter getQualifiedClassNameEmitter(String templateName) throws UnexpectedBehaviourException {
		String definition = templateName + PATH_SEPARATOR + "qualifiedClassName"; //$NON-NLS-1$
		return getXtendEmitter(definition);
	}

	/**
	 * @deprecated copy pasted, make protected in super-class
	 */
	@Deprecated
	private String getText(TextEmitter emitter, Object... input) throws UnexpectedBehaviourException {
		try {
			return emitter.generate(new NullProgressMonitor(), input).trim();
		} catch (InterruptedException ie) {
			return null;
		} catch (InvocationTargetException ite) {
			throw new UnexpectedBehaviourException(ite.getCause());
		}
	}
}
