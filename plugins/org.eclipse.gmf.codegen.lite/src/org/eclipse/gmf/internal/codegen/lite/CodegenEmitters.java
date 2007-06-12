/*
 * Copyright (c) 2005, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.lite;

import java.net.URL;
import java.util.HashMap;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.codegen.templates.lite.editor.CreationWizardGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.CreationWizardPageGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.InitDiagramFileActionGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.NewDiagramFileWizardGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.PaletteFactoryGenerator;
import org.eclipse.gmf.codegen.templates.expressions.AbstractExpressionGenerator;
import org.eclipse.gmf.codegen.templates.expressions.OCLExpressionFactoryGenerator;
import org.eclipse.gmf.codegen.templates.expressions.RegexpExpressionFactoryGenerator;
import org.eclipse.gmf.codegen.templates.lite.policies.OpenDiagramPolicyGenerator;
import org.eclipse.gmf.codegen.templates.lite.providers.DomainElementInitializerGenerator;
import org.eclipse.gmf.codegen.templates.lite.providers.MetricProviderGenerator;
import org.eclipse.gmf.codegen.templates.lite.providers.ValidationProviderGenerator;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.codegen.dispatch.CachingEmitterFactory;
import org.eclipse.gmf.internal.codegen.dispatch.EmitterFactory;
import org.eclipse.gmf.internal.codegen.dispatch.EmitterFactoryImpl;
import org.eclipse.gmf.internal.codegen.dispatch.NoSuchTemplateException;
import org.eclipse.gmf.internal.codegen.dispatch.StaticTemplateRegistry;
import org.eclipse.gmf.internal.common.codegen.BinaryEmitter;
import org.eclipse.gmf.internal.common.codegen.DefaultTextMerger;
import org.eclipse.gmf.internal.common.codegen.GIFEmitter;
import org.eclipse.gmf.internal.common.codegen.JETEmitterAdapter;
import org.eclipse.gmf.internal.common.codegen.JETGIFEmitterAdapter;
import org.eclipse.gmf.internal.common.codegen.TextEmitter;
import org.eclipse.gmf.internal.common.codegen.TextMerger;
import org.eclipse.gmf.internal.common.codegen.XpandTextEmitter;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.util.BundleResourceManager;
import org.osgi.framework.Bundle;

/**
 * Provides JET templates.
 * FIXME Merge with {@link org.eclipse.gmf.codegen.util.CodegenEmitters}
 * 
 * @author artem
 */
public class CodegenEmitters {
	private static final String CODEGEN_PLUGIN_ID = "org.eclipse.gmf.codegen";	//$NON-NLS-1$

	private final EmitterFactory myFactory;

	private final String[] myTemplatePath;

	private static StaticTemplateRegistry myRegistry;

	private ResourceManager myResourceManager;
	public CodegenEmitters(boolean usePrecompiled, String templateDirectory) {
		myRegistry = initRegistry();
		String[] variables = new String[] { "org.eclipse.emf.codegen", "org.eclipse.emf.codegen.ecore", "org.eclipse.emf.common", "org.eclipse.emf.ecore", "org.eclipse.gmf.common",
				"org.eclipse.gmf.codegen" };
		URL liteTemplatesPath = getTemplatesBundle().getEntry("/templates/");
		URL runtimeTemplatesPath = Platform.getBundle(CODEGEN_PLUGIN_ID).getEntry("/templates/");
		myTemplatePath = new String[] {
				usePrecompiled ? null : templateDirectory != null && templateDirectory.indexOf(":") == -1 ? URI.createPlatformResourceURI(templateDirectory, true).toString() : templateDirectory,
				liteTemplatesPath.toString(), runtimeTemplatesPath.toString() };
		myFactory = new CachingEmitterFactory(new EmitterFactoryImpl(getTemplatePath(), myRegistry, usePrecompiled, variables));

		myResourceManager = new BundleResourceManager(liteTemplatesPath, runtimeTemplatesPath);
	}

	public TextMerger createMergeService() {
		URL controlFile = getJMergeControlFile();
		if (controlFile != null){
			JControlModel controlModel = new JControlModel();
			controlModel.initialize(CodeGenUtil.instantiateFacadeHelper(JMerger.DEFAULT_FACADE_HELPER_CLASS), controlFile.toString());
			if (!controlModel.canMerge()){
				throw new IllegalStateException("Can not initialize JControlModel");
			}
			return new DefaultTextMerger(controlModel);
		}
		return null;
	}

	private static StaticTemplateRegistry initRegistry() {
		final StaticTemplateRegistry tr = new StaticTemplateRegistry(CodegenEmitters.class.getClassLoader());

		put(tr, "/providers/ValidationProvider.javajet", ValidationProviderGenerator.class);
		put(tr, "/providers/MetricProvider.javajet", MetricProviderGenerator.class); //$NON-NLS-1$		
		put(tr, "/editor/CreationWizard.javajet", CreationWizardGenerator.class);
		put(tr, "/editor/CreationWizardPage.javajet", CreationWizardPageGenerator.class);
		put(tr, "/editor/PaletteFactory.javajet", PaletteFactoryGenerator.class);
		put(tr, "/providers/DomainElementInitializer.javajet", DomainElementInitializerGenerator.class);
		put(tr, "/editor/InitDiagramFileAction.javajet", InitDiagramFileActionGenerator.class);
		put(tr, "/editor/NewDiagramFileWizard.javajet", NewDiagramFileWizardGenerator.class);
		put(tr, "/expressions/AbstractExpression.javajet", AbstractExpressionGenerator.class);
		put(tr, "/expressions/OCLExpressionFactory.javajet", OCLExpressionFactoryGenerator.class);
		put(tr, "/expressions/RegexpExpressionFactory.javajet", RegexpExpressionFactoryGenerator.class);
		put(tr, "/policies/OpenDiagramEditPolicy.javajet", OpenDiagramPolicyGenerator.class);

		return tr;
	}

	public TextEmitter getCreateNodeCommandEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::commands::CreateNodeCommand::CreateNodeCommand");	//$NON-NLS-1$
	}

	public TextEmitter getAddNodeCommandEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::commands::AddNodeCommand::AddNodeCommand");	//$NON-NLS-1$
	}

	public TextEmitter getCloneNodeCommandEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::commands::CloneNodeCommand::CloneNodeCommand");	//$NON-NLS-1$
	}

	public TextEmitter getCreateLinkStartCommandEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::commands::CreateLinkStartCommand::CreateLinkStartCommand");	//$NON-NLS-1$
	}

	public TextEmitter getCreateLinkCompleteCommandEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::commands::CreateLinkCompleteCommand::CreateLinkCompleteCommand");	//$NON-NLS-1$
	}

	public TextEmitter getReconnectLinkSourceCommandEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::commands::ReconnectLinkSourceCommand::ReconnectLinkSourceCommand");	//$NON-NLS-1$
	}

	public TextEmitter getReconnectLinkTargetCommandEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::commands::ReconnectLinkTargetCommand::ReconnectLinkTargetCommand");	//$NON-NLS-1$
	}

	public TextEmitter getViewFactoryGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::viewfactories::ViewFactory::ViewFactory");	//$NON-NLS-1$
	}

	public TextEmitter getComponentEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::diagram::policies::ComponentEditPolicy::ComponentEditPolicy");	//$NON-NLS-1$
	}

	public TextEmitter getLayoutEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::diagram::policies::LayoutEditPolicy::LayoutEditPolicy");	//$NON-NLS-1$
	}

	public TextEmitter getGraphicalEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::diagram::policies::GraphicalNodeEditPolicy::GraphicalNodeEditPolicy");	//$NON-NLS-1$
	}

	public TextEmitter getValidationProviderGenerator() throws UnexpectedBehaviourException {
		return retrieve(ValidationProviderGenerator.class);
	}

	public TextEmitter getMetricProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(MetricProviderGenerator.class);
	}	
	
	public TextEmitter getDomainElementInitializerGenerator() throws UnexpectedBehaviourException {
		return retrieve(DomainElementInitializerGenerator.class);
	}

	public TextEmitter getCompartmentEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::diagram::parts::CompartmentEditPart::CompartmentEditPart");	//$NON-NLS-1$
	}

	public TextEmitter getDiagramEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::diagram::parts::DiagramEditPart::DiagramEditPart");	//$NON-NLS-1$
	}

	public TextEmitter getEditPartFactoryGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::diagram::parts::EditPartFactory::EditPartFactory");	//$NON-NLS-1$
	}

	public TextEmitter getLinkEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::diagram::parts::LinkEditPart::LinkEditPart");	//$NON-NLS-1$
	}

	public TextEmitter getLinkLabelEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::diagram::parts::LinkLabelEditPart::LinkLabelEditPart");	//$NON-NLS-1$
	}

	public TextEmitter getChildNodeEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::diagram::parts::ChildNodeEditPart::ChildNodeEditPart");	//$NON-NLS-1$
	}

	public TextEmitter getNodeEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::diagram::parts::NodeEditPart::NodeEditPart");	//$NON-NLS-1$
	}

	public TextEmitter getNodeLabelEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::diagram::parts::NodeLabelEditPart::NodeLabelEditPart");	//$NON-NLS-1$
	}

	public TextEmitter getPluginGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::editor::Plugin::Plugin");	//$NON-NLS-1$
	}

	public TextEmitter getActionBarContributorGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::editor::ActionBarContributor::ActionBarContributor");	//$NON-NLS-1$
	}

	public TextEmitter getOpenDiagramInViewActionGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::editor::OpenDiagramInViewAction::OpenDiagramInViewAction");	//$NON-NLS-1$
	}

	public TextEmitter getEditorGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::editor::Editor::Editor");	//$NON-NLS-1$
	}

	public TextEmitter getMatchingStrategyEmitter() {
		return retrieveXpand("xpt::editor::MatchingStrategy::MatchingStrategy"); //$NON-NLS-1$
	}
	
	public TextEmitter getCreationWizardGenerator() throws UnexpectedBehaviourException {
		return retrieve(CreationWizardGenerator.class);
	}

	public TextEmitter getCreationWizardPageGenerator() throws UnexpectedBehaviourException {
		return retrieve(CreationWizardPageGenerator.class);
	}

	public TextEmitter getDiagramEditorUtilGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::editor::DiagramEditorUtil::DiagramEditorUtil");	//$NON-NLS-1$
	}

	public TextEmitter getPaletteFactoryGenerator() throws UnexpectedBehaviourException {
		return retrieve(PaletteFactoryGenerator.class);
	}

	public TextEmitter getVisualIDRegistryGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::editor::VisualIDRegistry::VisualIDRegistry");	//$NON-NLS-1$
	}

	public TextEmitter getManifestGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::manifest::manifest");	//$NON-NLS-1$
	}

	public TextEmitter getBuildPropertiesGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::buildProperties::buildProperties");	//$NON-NLS-1$
	}

	public TextEmitter getPluginXML() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::plugin::plugin");	//$NON-NLS-1$
	}

	public TextEmitter getInitDiagramFileActionGenerator() throws UnexpectedBehaviourException {
		return retrieve(InitDiagramFileActionGenerator.class);
	}

	public TextEmitter getNewDiagramFileWizardGenerator() throws UnexpectedBehaviourException {
		return retrieve(NewDiagramFileWizardGenerator.class);
	}

	public TextEmitter getLoadResourceActionGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::editor::LoadResourceAction::LoadResourceAction");	//$NON-NLS-1$
	}

	public TextEmitter getElementTypesGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::providers::ElementTypes::ElementTypes");	//$NON-NLS-1$
	}

	public TextEmitter getPluginPropertiesGenerator() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::properties::properties");	//$NON-NLS-1$
	}

	public TextEmitter getAbstractExpressionEmitter() throws UnexpectedBehaviourException {
		return retrieve(AbstractExpressionGenerator.class);
	}
	
	public TextEmitter getOCLExpressionFactoryEmitter() throws UnexpectedBehaviourException {
		return retrieve(OCLExpressionFactoryGenerator.class);
	}	
	
	public TextEmitter getRegexpExpressionFactoryEmitter() throws UnexpectedBehaviourException {
		return retrieve(RegexpExpressionFactoryGenerator.class);
	}

	public TextEmitter getOpenDiagramEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(OpenDiagramPolicyGenerator.class);
	}

	public BinaryEmitter getDiagramIconEmitter() throws UnexpectedBehaviourException {
		return newGIFEmitterAdapter("/editor/diagram.gif"); //$NON-NLS-1$
	}

	public BinaryEmitter getWizardBannerImageEmitter() throws UnexpectedBehaviourException {
		return newGIFEmitterAdapter("/editor/wizban.gif"); //$NON-NLS-1$
	}

	/**
	 * @see #retrieve(Class)
	 */
	private static void put(StaticTemplateRegistry tr, String path, Class<?> precompiledTemplate) {
		tr.put(precompiledTemplate, path, precompiledTemplate);
	}

	/**
	 * depends on {@link #put(StaticTemplateRegistry, String, Class) } impl -
	 * class object of precompiled template serves as a key
	 */
	private TextEmitter retrieve(Class<?> key) throws UnexpectedBehaviourException {
		try {
			return new JETEmitterAdapter(myFactory.acquireEmitter(key));
		} catch (NoSuchTemplateException ex) {
			throw new UnexpectedBehaviourException(ex.getMessage(), ex);
		}
	}

	private BinaryEmitter newGIFEmitter(String relativePath) throws UnexpectedBehaviourException {
		return new GIFEmitter(checkTemplateLocation(relativePath));
	}

	private BinaryEmitter newGIFEmitterAdapter(String relativePath) throws UnexpectedBehaviourException {
		return new JETGIFEmitterAdapter(new org.eclipse.emf.codegen.util.GIFEmitter(checkTemplateLocation(relativePath)));
	}

	private String checkTemplateLocation(String relativePath) throws UnexpectedBehaviourException {
		String templateLocation = JETCompiler.find(getTemplatePath(), relativePath);
		if (templateLocation == null) {
			throw new UnexpectedBehaviourException("Template " + relativePath +" not found");
		}
		return templateLocation;
	}

	private String[] getTemplatePath() {
		return myTemplatePath;
	}

	private static Bundle getTemplatesBundle() {
		return Activator.getDefault();
	}

	public URL getJMergeControlFile() {
		return getTemplatesBundle().getEntry("/templates/emf-merge.xml");
	}

	public GIFEmitter getShortcutImageEmitter() throws JETException {
		String templateLocation = JETCompiler.find(getTemplatePath(), "/editor/shortcut.gif");
		if (templateLocation == null) {
			throw new JETException("shortcut image template not found");
		}
		return new GIFEmitter(templateLocation);
	}

	public TextEmitter getNavigatorContentProviderEmitter() {
		return retrieveXpand("xpt::navigator::NavigatorContentProvider::NavigatorContentProvider");	//$NON-NLS-1$
	}

	public TextEmitter getDomainNavigatorContentProviderEmitter() {
		return retrieveXpand("xpt::navigator::DomainNavigatorContentProvider::DomainNavigatorContentProvider"); //$NON-NLS-1$
	}
	
	public TextEmitter getDomainNavigatorLabelProviderEmitter() {
		return retrieveXpand("xpt::navigator::DomainNavigatorLabelProvider::DomainNavigatorLabelProvider"); //$NON-NLS-1$
	}
	
	public TextEmitter getDomainNavigatorItemEmitter() {
		return retrieveXpand("xpt::navigator::DomainNavigatorItem::DomainNavigatorItem"); //$NON-NLS-1$
	}
	
	public TextEmitter getDomainModelElementTesterEmitter() {
		return retrieveXpand("xpt::editor::DomainModelElementTester::DomainModelElementTester"); //$NON-NLS-1$
	}
	
	public TextEmitter getURIEditorInputTesterEmitter() {
		return retrieveXpand("xpt::editor::UriEditorInputTester::UriEditorInputTester"); //$NON-NLS-1$
	}

	public TextEmitter getNavigatorLabelProviderEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::navigator::NavigatorLabelProvider::NavigatorLabelProvider"); //$NON-NLS-1$
	}
	
	public TextEmitter getNavigatorLinkHelperEmitter() {
		return retrieveXpand("xpt::navigator::NavigatorLinkHelper::NavigatorLinkHelper"); //$NON-NLS-1$
	}
	
	public TextEmitter getNavigatorSorterEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::navigator::NavigatorSorter::NavigatorSorter");
	}
	
	public TextEmitter getNavigatorActionProviderEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::navigator::NavigatorActionProvider::NavigatorActionProvider"); //$NON-NLS-1$
	}
	
	public TextEmitter getAbstractNavigatorItemEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::navigator::AbstractNavigatorItem::AbstractNavigatorItem");
	}
	
	public TextEmitter getNavigatorGroupEmitter() {
		return retrieveXpand("xpt::navigator::NavigatorGroup::NavigatorGroup"); //$NON-NLS-1$
	}

	public TextEmitter getNavigatorItemEmitter() {
		return retrieveXpand("xpt::navigator::NavigatorItem::NavigatorItem"); //$NON-NLS-1$
	}

	public BinaryEmitter getGroupIconEmitter() throws UnexpectedBehaviourException {
		return newGIFEmitter("/xpt/navigator/navigatorGroup.gif"); //$NON-NLS-1$
	}

	public TextEmitter getPropertySheetLabelProviderEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::propsheet::SheetLabelProvider::SheetLabelProvider");	//$NON-NLS-1$
	}

	public TextEmitter getPropertySectionEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::propsheet::PropertySection::PropertySection");
	}

	public TextEmitter getApplicationEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::application::Application::Application"); //$NON-NLS-1$
	}

	public TextEmitter getActionBarAdvisorEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::application::ActionBarAdvisor::ActionBarAdvisor"); //$NON-NLS-1$
	}

	public TextEmitter getPerspectiveEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::application::Perspective::Perspective"); //$NON-NLS-1$
	}

	public TextEmitter getWorkbenchAdvisorEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::application::WorkbenchAdvisor::WorkbenchAdvisor"); //$NON-NLS-1$
	}

	public TextEmitter getWorkbenchWindowAdvisorEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::application::WorkbenchWindowAdvisor::WorkbenchWindowAdvisor"); //$NON-NLS-1$
	}

	public TextEmitter getMarkerNavigationProviderEmitter() throws UnexpectedBehaviourException {
		return retrieveXpand("xpt::providers::MarkerNavigationProvider::MarkerNavigationProvider");	//$NON-NLS-1$
	}

    public TextEmitter getExternalizeEmitter() {
        return retrieveXpand("xpt::Externalizer::Access"); //$NON-NLS-1$
    }

    public TextEmitter getMessagesEmitter() {
        return retrieveXpand("xpt::Externalizer::Values"); //$NON-NLS-1$
    }

	private TextEmitter retrieveXpand(String templateFQN) {
		TextEmitter result = myCachedXpandEmitters.get(templateFQN);
		if (result == null) {
			result = new XpandTextEmitter(myResourceManager, templateFQN, getClass().getClassLoader());
			myCachedXpandEmitters.put(templateFQN, result);
		}
		return result;
	}

	private HashMap<String, TextEmitter> myCachedXpandEmitters = new HashMap<String, TextEmitter>();
}
