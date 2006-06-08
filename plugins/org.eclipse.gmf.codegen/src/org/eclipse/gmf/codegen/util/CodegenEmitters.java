/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.codegen.util;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.codegen.templates.commands.ReorientConnectionViewCommandGenerator;
import org.eclipse.gmf.codegen.templates.editor.ActionBarContributorGenerator;
import org.eclipse.gmf.codegen.templates.editor.BuildPropertiesGenerator;
import org.eclipse.gmf.codegen.templates.editor.CreateShortcutActionGenerator;
import org.eclipse.gmf.codegen.templates.editor.CreationWizardGenerator;
import org.eclipse.gmf.codegen.templates.editor.CreationWizardPageGenerator;
import org.eclipse.gmf.codegen.templates.editor.DiagramEditorUtilGenerator;
import org.eclipse.gmf.codegen.templates.editor.DiagramFileCreatorGenerator;
import org.eclipse.gmf.codegen.templates.editor.DocumentProviderGenerator;
import org.eclipse.gmf.codegen.templates.editor.EditorGenerator;
import org.eclipse.gmf.codegen.templates.editor.ElementChooserGenerator;
import org.eclipse.gmf.codegen.templates.editor.InitDiagramFileActionGenerator;
import org.eclipse.gmf.codegen.templates.editor.LoadResourceActionGenerator;
import org.eclipse.gmf.codegen.templates.editor.ManifestGenerator;
import org.eclipse.gmf.codegen.templates.editor.MatchingStrategyGenerator;
import org.eclipse.gmf.codegen.templates.editor.NewDiagramFileWizardGenerator;
import org.eclipse.gmf.codegen.templates.editor.OptionsFileGenerator;
import org.eclipse.gmf.codegen.templates.editor.PaletteFactoryGenerator;
import org.eclipse.gmf.codegen.templates.editor.PluginGenerator;
import org.eclipse.gmf.codegen.templates.editor.PluginPropertiesGenerator;
import org.eclipse.gmf.codegen.templates.editor.PluginXML;
import org.eclipse.gmf.codegen.templates.editor.PreferencesInitializerGenerator;
import org.eclipse.gmf.codegen.templates.editor.VisualIDRegistryGenerator;
import org.eclipse.gmf.codegen.templates.expressions.AbstractExpressionGenerator;
import org.eclipse.gmf.codegen.templates.expressions.OCLExpressionFactoryGenerator;
import org.eclipse.gmf.codegen.templates.expressions.RegexpExpressionFactoryGenerator;
import org.eclipse.gmf.codegen.templates.helpers.BaseEditHelperGenerator;
import org.eclipse.gmf.codegen.templates.helpers.EditHelperAdviceGenerator;
import org.eclipse.gmf.codegen.templates.helpers.EditHelperGenerator;
import org.eclipse.gmf.codegen.templates.parts.ChildNodeEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.CompartmentEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.DiagramEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.DiagramExternalNodeLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.EditPartFactoryGenerator;
import org.eclipse.gmf.codegen.templates.parts.ExternalNodeLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.LinkEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.LinkLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.NodeEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.NodeLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.policies.ChildContainerCanonicalEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.CompartmentItemSemanticEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.DiagramCanonicalEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.DiagramItemSemanticEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.GraphicalNodeEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.ItemSemanticEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.LinkItemSemanticEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.NodeGraphicalNodeEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.NodeItemSemanticEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.ReferenceConnectionEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.TextNonResizableEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.TextSelectionEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.providers.AbstractParserGenerator;
import org.eclipse.gmf.codegen.templates.providers.ContributionItemProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.EditPartProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ElementTypesGenerator;
import org.eclipse.gmf.codegen.templates.providers.IconProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.LabelTextViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.providers.LabelViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.providers.MarkerNavigationProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.MetricProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ModelingAssistantProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.PaletteProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ParserProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.PropertyProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ShortcutsDecoratorProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.StructuralFeatureParserGenerator;
import org.eclipse.gmf.codegen.templates.providers.StructuralFeaturesParserGenerator;
import org.eclipse.gmf.codegen.templates.providers.ValidationDecoratorProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ValidationProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.providers.ViewProviderGenerator;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.codegen.dispatch.EmitterFactory;
import org.eclipse.gmf.internal.codegen.dispatch.NoSuchTemplateException;
import org.eclipse.gmf.internal.codegen.dispatch.StaticTemplateRegistry;
import org.eclipse.gmf.internal.codegen.dispatch.TemplateRegistry;
import org.eclipse.gmf.internal.common.codegen.BinaryEmitter;
import org.eclipse.gmf.internal.common.codegen.GIFEmitter;
import org.eclipse.gmf.internal.common.codegen.JETEmitterAdapter;
import org.eclipse.gmf.internal.common.codegen.JETGIFEmitterAdapter;
import org.eclipse.gmf.internal.common.codegen.TextEmitter;
import org.osgi.framework.Bundle;

/**
 * Provides JET templates.
 * 
 * @author artem
 */
public class CodegenEmitters {
	private static final String TEMPLATES_PLUGIN_ID = "org.eclipse.gmf.codegen";
	private final EmitterFactory myFactory;
	private final String[] myTemplatePath;

	public CodegenEmitters(boolean usePrecompiled, String templateDirectory) {
		TemplateRegistry registry = initRegistry();
		String[] variables = new String[] {
		        "org.eclipse.emf.codegen",
				"org.eclipse.emf.codegen.ecore",
				"org.eclipse.emf.common",
				"org.eclipse.emf.ecore",
				"org.eclipse.gmf.common",
				"org.eclipse.gmf.codegen"
		};
		myTemplatePath = new String[] {
				usePrecompiled ? null : templateDirectory != null && templateDirectory.indexOf(":") == -1 ? URI.createPlatformResourceURI(templateDirectory).toString() : templateDirectory,
				getTemplatesBundle().getEntry("/templates/").toString()
		};
		myFactory = new EmitterFactory(getTemplatePath(), registry, usePrecompiled, variables, true);
	}

	private static TemplateRegistry initRegistry() {
		final StaticTemplateRegistry tr = new StaticTemplateRegistry(CodegenEmitters.class.getClassLoader());
		put(tr, "/commands/ReorientConnectionViewCommand.javajet", ReorientConnectionViewCommandGenerator.class);
		put(tr, "/helpers/BaseEditHelper.javajet", BaseEditHelperGenerator.class);
		put(tr, "/helpers/EditHelper.javajet", EditHelperGenerator.class);
		put(tr, "/helpers/EditHelperAdvice.javajet", EditHelperAdviceGenerator.class);
		put(tr, "/parts/DiagramEditPart.javajet", DiagramEditPartGenerator.class);
		put(tr, "/parts/DiagramExternalNodeLabelEditPart.javajet", DiagramExternalNodeLabelEditPartGenerator.class);
		put(tr, "/parts/NodeEditPart.javajet", NodeEditPartGenerator.class);
		put(tr, "/parts/NodeLabelEditPart.javajet", NodeLabelEditPartGenerator.class);
		put(tr, "/parts/ExternalNodeLabelEditPart.javajet", ExternalNodeLabelEditPartGenerator.class);
		put(tr, "/parts/ChildNodeEditPart.javajet", ChildNodeEditPartGenerator.class);
		put(tr, "/parts/CompartmentEditPart.javajet", CompartmentEditPartGenerator.class);
		put(tr, "/parts/LinkEditPart.javajet", LinkEditPartGenerator.class);
		put(tr, "/parts/LinkLabelEditPart.javajet", LinkLabelEditPartGenerator.class);
		put(tr, "/parts/EditPartFactory.javajet", EditPartFactoryGenerator.class);
		put(tr, "/policies/ItemSemanticEditPolicy.javajet", ItemSemanticEditPolicyGenerator.class);
		put(tr, "/policies/GraphicalNodeEditPolicy.javajet", GraphicalNodeEditPolicyGenerator.class);
		put(tr, "/policies/ReferenceConnectionEditPolicy.javajet", ReferenceConnectionEditPolicyGenerator.class);
		put(tr, "/policies/DiagramCanonicalEditPolicy.javajet", DiagramCanonicalEditPolicyGenerator.class);
		put(tr, "/policies/ChildContainerCanonicalEditPolicy.javajet", ChildContainerCanonicalEditPolicyGenerator.class);
		put(tr, "/policies/DiagramItemSemanticEditPolicy.javajet", DiagramItemSemanticEditPolicyGenerator.class);
		put(tr, "/policies/CompartmentItemSemanticEditPolicy.javajet", CompartmentItemSemanticEditPolicyGenerator.class);
		put(tr, "/policies/NodeGraphicalNodeEditPolicy.javajet", NodeGraphicalNodeEditPolicyGenerator.class);
		put(tr, "/policies/NodeItemSemanticEditPolicy.javajet", NodeItemSemanticEditPolicyGenerator.class);
		put(tr, "/policies/LinkItemSemanticEditPolicy.javajet", LinkItemSemanticEditPolicyGenerator.class);
		put(tr, "/policies/TextSelectionEditPolicy.javajet", TextSelectionEditPolicyGenerator.class);
		put(tr, "/policies/TextNonResizableEditPolicy.javajet", TextNonResizableEditPolicyGenerator.class);
		put(tr, "/providers/AbstractParser.javajet", AbstractParserGenerator.class);
		put(tr, "/providers/StructuralFeatureParser.javajet", StructuralFeatureParserGenerator.class);
		put(tr, "/providers/StructuralFeaturesParser.javajet", StructuralFeaturesParserGenerator.class);
		put(tr, "/providers/ViewFactory.javajet", ViewFactoryGenerator.class);
		put(tr, "/providers/LabelViewFactory.javajet", LabelViewFactoryGenerator.class);
		put(tr, "/providers/LabelTextViewFactory.javajet", LabelTextViewFactoryGenerator.class);
		put(tr, "/providers/ElementTypes.javajet", ElementTypesGenerator.class);
		put(tr, "/providers/ViewProvider.javajet", ViewProviderGenerator.class);
		put(tr, "/providers/EditPartProvider.javajet", EditPartProviderGenerator.class);
		put(tr, "/providers/PaletteProvider.javajet", PaletteProviderGenerator.class);
		put(tr, "/providers/ContributionItemProvider.javajet", ContributionItemProviderGenerator.class);
		put(tr, "/providers/ModelingAssistantProvider.javajet", ModelingAssistantProviderGenerator.class);
		put(tr, "/providers/PropertyProvider.javajet", PropertyProviderGenerator.class);
		put(tr, "/providers/IconProvider.javajet", IconProviderGenerator.class);
		put(tr, "/providers/ParserProvider.javajet", ParserProviderGenerator.class);
		put(tr, "/providers/ValidationProvider.javajet", ValidationProviderGenerator.class); //$NON-NLS-1$
		put(tr, "/providers/ValidationDecoratorProvider.javajet", ValidationDecoratorProviderGenerator.class); //$NON-NLS-1$		
		put(tr, "/providers/ShortcutsDecoratorProvider.javajet", ShortcutsDecoratorProviderGenerator.class); //$NON-NLS-1$
		put(tr, "/providers/MetricProvider.javajet", MetricProviderGenerator.class); //$NON-NLS-1$		
		put(tr, "/providers/MarkerNavigationProvider.javajet", MarkerNavigationProviderGenerator.class); //$NON-NLS-1$
		put(tr, "/editor/InitDiagramFileAction.javajet", InitDiagramFileActionGenerator.class);
		put(tr, "/editor/NewDiagramFileWizard.javajet", NewDiagramFileWizardGenerator.class);
		put(tr, "/editor/PaletteFactory.javajet", PaletteFactoryGenerator.class);
		put(tr, "/editor/DiagramEditorUtil.javajet", DiagramEditorUtilGenerator.class);
		put(tr, "/editor/DiagramFileCreator.javajet", DiagramFileCreatorGenerator.class);
		put(tr, "/editor/VisualIDRegistry.javajet", VisualIDRegistryGenerator.class);
		put(tr, "/editor/CreationWizard.javajet", CreationWizardGenerator.class);
		put(tr, "/editor/CreationWizardPage.javajet", CreationWizardPageGenerator.class);
		put(tr, "/editor/Editor.javajet", EditorGenerator.class);
		put(tr, "/editor/CreateShortcutAction.javajet", CreateShortcutActionGenerator.class);
		put(tr, "/editor/LoadResourceAction.javajet", LoadResourceActionGenerator.class);
		put(tr, "/editor/ElementChooser.javajet", ElementChooserGenerator.class);
		put(tr, "/editor/DocumentProvider.javajet", DocumentProviderGenerator.class);
		put(tr, "/editor/ActionBarContributor.javajet", ActionBarContributorGenerator.class);
		put(tr, "/editor/MatchingStrategy.javajet", MatchingStrategyGenerator.class);
		put(tr, "/editor/PreferenceInitializer.javajet", PreferencesInitializerGenerator.class);
		put(tr, "/editor/Plugin.javajet", PluginGenerator.class);
		put(tr, "/editor/plugin.xmljet", PluginXML.class);
		put(tr, "/editor/plugin.propertiesjet", PluginPropertiesGenerator.class);
		put(tr, "/editor/.optionsjet", OptionsFileGenerator.class);
		put(tr, "/editor/manifest.mfjet", ManifestGenerator.class);
		put(tr, "/editor/build.propertiesjet", BuildPropertiesGenerator.class);
		
		put(tr, "/expressions/AbstractExpression.javajet", AbstractExpressionGenerator.class); //$NON-NLS-1$		
		put(tr, "/expressions/OCLExpressionFactory.javajet", OCLExpressionFactoryGenerator.class); //$NON-NLS-1$		
		put(tr, "/expressions/RegexpExpressionFactory.javajet", RegexpExpressionFactoryGenerator.class); //$NON-NLS-1$
		
		return tr;
	}

	/**
	 * @see #retrieve(Class)
	 */
	private static void put(StaticTemplateRegistry tr, String path, Class precompiledTemplate) {
		tr.put(precompiledTemplate, path, precompiledTemplate);
	}

	/**
	 * depends on {@link #put(StaticTemplateRegistry, String, Class) } impl - class object of
	 * precompiled template serves as a key
	 */
	private JETEmitter retrieve(Class key) throws UnexpectedBehaviourException {
		try {
			return myFactory.acquireEmitter(key);
		} catch (NoSuchTemplateException ex) {
			throw new UnexpectedBehaviourException(ex.getMessage(), ex);
		}
	}

	private String[] getTemplatePath() {
		return myTemplatePath;
	}

	private static Bundle getTemplatesBundle() {
		return Platform.getBundle(TEMPLATES_PLUGIN_ID);
	}

	public URL getJMergeControlFile() {
		return getTemplatesBundle().getEntry("/templates/emf-merge.xml");
	}

	// commands

	public JETEmitter getReorientConnectionViewCommandEmitter() throws UnexpectedBehaviourException {
		return retrieve(ReorientConnectionViewCommandGenerator.class);
	}

	// helpers

	public JETEmitter getBaseEditHelperEmitter() throws UnexpectedBehaviourException {
		return retrieve(BaseEditHelperGenerator.class);
	}

	public JETEmitter getEditHelperEmitter() throws UnexpectedBehaviourException {
		return retrieve(EditHelperGenerator.class);
	}

	public JETEmitter getEditHelperAdviceEmitter() throws UnexpectedBehaviourException {
		return retrieve(EditHelperAdviceGenerator.class);
	}

	// parts

	public JETEmitter getDiagramEditPartEmitter() throws UnexpectedBehaviourException {
		return retrieve(DiagramEditPartGenerator.class);
	}

	public JETEmitter getDiagramExternalNodeLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return retrieve(DiagramExternalNodeLabelEditPartGenerator.class);
	}

	public JETEmitter getNodeEditPartEmitter() throws UnexpectedBehaviourException {
		return retrieve(NodeEditPartGenerator.class);
	}

	public JETEmitter getNodeLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return retrieve(NodeLabelEditPartGenerator.class);
	}

	public JETEmitter getExternalNodeLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return retrieve(ExternalNodeLabelEditPartGenerator.class);
	}

	public JETEmitter getChildNodeEditPartEmitter() throws UnexpectedBehaviourException {
		return retrieve(ChildNodeEditPartGenerator.class);
	}

	public JETEmitter getCompartmentEditPartEmitter() throws UnexpectedBehaviourException {
		return retrieve(CompartmentEditPartGenerator.class);
	}
	
	public JETEmitter getLinkEditPartEmitter() throws UnexpectedBehaviourException {
		return retrieve(LinkEditPartGenerator.class);
	}

	public JETEmitter getLinkLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return retrieve(LinkLabelEditPartGenerator.class);
	}

	public JETEmitter getEditPartFactoryEmitter() throws UnexpectedBehaviourException {
		return retrieve(EditPartFactoryGenerator.class);
	}
	
	// policies

	public JETEmitter getBaseItemSemanticEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(ItemSemanticEditPolicyGenerator.class);
	}

	public JETEmitter getBaseGraphicalNodeEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(GraphicalNodeEditPolicyGenerator.class);
	}
	
	public JETEmitter getReferenceConnectionEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(ReferenceConnectionEditPolicyGenerator.class);
	}

	public JETEmitter getDiagramCanonicalEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(DiagramCanonicalEditPolicyGenerator.class);
	}

	public JETEmitter getChildContainerCanonicalEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(ChildContainerCanonicalEditPolicyGenerator.class);
	}

	public JETEmitter getDiagramItemSemanticEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(DiagramItemSemanticEditPolicyGenerator.class);
	}

	public JETEmitter getCompartmentItemSemanticEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(CompartmentItemSemanticEditPolicyGenerator.class);
	}

	public JETEmitter getNodeGraphicalNodeEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(NodeGraphicalNodeEditPolicyGenerator.class);
	}

	public JETEmitter getNodeItemSemanticEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(NodeItemSemanticEditPolicyGenerator.class);
	}

	public JETEmitter getLinkItemSemanticEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(LinkItemSemanticEditPolicyGenerator.class);
	}

	public JETEmitter getTextSelectionEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(TextSelectionEditPolicyGenerator.class);
	}

	public JETEmitter getTextNonResizableEditPolicyEmitter() throws UnexpectedBehaviourException {
		return retrieve(TextNonResizableEditPolicyGenerator.class);
	}

	// providers

	public JETEmitter getAbstractParserEmitter() throws UnexpectedBehaviourException {
		return retrieve(AbstractParserGenerator.class);
	}

	public JETEmitter getStructuralFeatureParserEmitter() throws UnexpectedBehaviourException {
		return retrieve(StructuralFeatureParserGenerator.class);
	}

	public JETEmitter getStructuralFeaturesParserEmitter() throws UnexpectedBehaviourException {
		return retrieve(StructuralFeaturesParserGenerator.class);
	}

	public JETEmitter getViewFactoryEmitter() throws UnexpectedBehaviourException {
		return retrieve(ViewFactoryGenerator.class);
	}

	public JETEmitter getLabelViewFactoryEmitter() throws UnexpectedBehaviourException {
		return retrieve(LabelViewFactoryGenerator.class);
	}

	public JETEmitter getLabelTextViewFactoryEmitter() throws UnexpectedBehaviourException {
		return retrieve(LabelTextViewFactoryGenerator.class);
	}
	
	public JETEmitter getElementTypesEmitter() throws UnexpectedBehaviourException {
		return retrieve(ElementTypesGenerator.class);
	}

	public JETEmitter getViewProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(ViewProviderGenerator.class);
	}

	public JETEmitter getEditPartProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(EditPartProviderGenerator.class);
	}

	public JETEmitter getPaletteProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(PaletteProviderGenerator.class);
	}
	
	public JETEmitter getContributionItemProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(ContributionItemProviderGenerator.class);
	}

	public JETEmitter getModelingAssistantProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(ModelingAssistantProviderGenerator.class);
	}

	public JETEmitter getPropertyProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(PropertyProviderGenerator.class);
	}

	public JETEmitter getIconProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(IconProviderGenerator.class);
	}

	public JETEmitter getParserProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(ParserProviderGenerator.class);
	}

	public JETEmitter getValidationProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(ValidationProviderGenerator.class);
	}

	public JETEmitter getValidationDecoratorProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(ValidationDecoratorProviderGenerator.class);
	}

	public JETEmitter getShortcutsDecoratorProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(ShortcutsDecoratorProviderGenerator.class);
	}

	public JETEmitter getMetricProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(MetricProviderGenerator.class);
	}	
	
	public JETEmitter getMarkerNavigationProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(MarkerNavigationProviderGenerator.class);
	}	
	
	public JETEmitter getAbstractExpressionEmitter() throws UnexpectedBehaviourException {
		return retrieve(AbstractExpressionGenerator.class);
	}
	
	public JETEmitter getOCLExpressionFactoryEmitter() throws UnexpectedBehaviourException {
		return retrieve(OCLExpressionFactoryGenerator.class);
	}	
	
	public JETEmitter getRegexpExpressionFactoryEmitter() throws UnexpectedBehaviourException {
		return retrieve(RegexpExpressionFactoryGenerator.class);
	}

	// editor

	public JETEmitter getInitDiagramFileActionEmitter() throws UnexpectedBehaviourException {
		return retrieve(InitDiagramFileActionGenerator.class);
	}
	
	public JETEmitter getNewDiagramFileWizardEmitter() throws UnexpectedBehaviourException {
		return retrieve(NewDiagramFileWizardGenerator.class);
	}

	public JETEmitter getPaletteEmitter() throws UnexpectedBehaviourException {
		return retrieve(PaletteFactoryGenerator.class);
	}

	public JETEmitter getDiagramEditorUtilEmitter() throws UnexpectedBehaviourException {
		return retrieve(DiagramEditorUtilGenerator.class);
	}

	public JETEmitter getDiagramFileCreatorEmitter() throws UnexpectedBehaviourException {
		return retrieve(DiagramFileCreatorGenerator.class);
	}
	
	public JETEmitter getVisualIDRegistryEmitter() throws UnexpectedBehaviourException {
		return retrieve(VisualIDRegistryGenerator.class);
	}

	public JETEmitter getCreationWizardEmitter() throws UnexpectedBehaviourException {
		return retrieve(CreationWizardGenerator.class);
	}

	public JETEmitter getCreationWizardPageEmitter() throws UnexpectedBehaviourException {
		return retrieve(CreationWizardPageGenerator.class);
	}

	public JETEmitter getEditorEmitter() throws UnexpectedBehaviourException {
		return retrieve(EditorGenerator.class);
	}
	
	public JETEmitter getCreateShortcutActionEmitter() throws UnexpectedBehaviourException {
		return retrieve(CreateShortcutActionGenerator.class);
	}

	public JETEmitter getLoadResourceActionEmitter() throws UnexpectedBehaviourException {
		return retrieve(LoadResourceActionGenerator.class);
	}
	
	public JETEmitter getElementChooserEmitter() throws UnexpectedBehaviourException {
		return retrieve(ElementChooserGenerator.class);
	}
	
	public JETEmitter getDocumentProviderEmitter() throws UnexpectedBehaviourException {
		return retrieve(DocumentProviderGenerator.class);
	}
	
	public JETEmitter getActionBarContributorEmitter() throws UnexpectedBehaviourException {
		return retrieve(ActionBarContributorGenerator.class);
	}

	public JETEmitter getMatchingStrategyEmitter() throws UnexpectedBehaviourException {
		return retrieve(MatchingStrategyGenerator.class);
	}

	public JETEmitter getPreferencesInitializerEmitter() throws UnexpectedBehaviourException {
		return retrieve(PreferencesInitializerGenerator.class);
	}

	public JETEmitter getPluginClassEmitter() throws UnexpectedBehaviourException {
		return retrieve(PluginGenerator.class);
	}

	public TextEmitter getPluginXmlEmitter() throws UnexpectedBehaviourException {
		return new JETEmitterAdapter(retrieve(PluginXML.class));
	}

	public TextEmitter getPluginPropertiesEmitter() throws UnexpectedBehaviourException {
		return new JETEmitterAdapter(retrieve(PluginPropertiesGenerator.class));
	}
	
	public TextEmitter getOptionsFileEmitter() throws UnexpectedBehaviourException {
		return new JETEmitterAdapter(retrieve(OptionsFileGenerator.class));
	}

	public TextEmitter getBundleManifestEmitter() throws UnexpectedBehaviourException {
		return new JETEmitterAdapter(retrieve(ManifestGenerator.class));
	}

	public TextEmitter getBuildPropertiesEmitter() throws UnexpectedBehaviourException {
		return new JETEmitterAdapter(retrieve(BuildPropertiesGenerator.class));
	}
	
	public BinaryEmitter getShortcutImageEmitter() throws UnexpectedBehaviourException {
		return newGIFEmitter("/editor/shortcut.gif");
	}

	public BinaryEmitter getDiagramIconEmitter() throws UnexpectedBehaviourException {
		return newGIFEmitterAdapter("/editor/diagram.gif");
	}

	public BinaryEmitter getWizardBannerImageEmitter() throws UnexpectedBehaviourException {
		return newGIFEmitterAdapter("/editor/wizban.gif");
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
}
