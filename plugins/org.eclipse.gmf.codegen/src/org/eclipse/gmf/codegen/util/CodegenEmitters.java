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
import org.eclipse.emf.codegen.jet.JETException;
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
import org.eclipse.gmf.codegen.templates.editor.PaletteFactoryGenerator;
import org.eclipse.gmf.codegen.templates.editor.PluginGenerator;
import org.eclipse.gmf.codegen.templates.editor.PluginPropertiesGenerator;
import org.eclipse.gmf.codegen.templates.editor.PluginXML;
import org.eclipse.gmf.codegen.templates.editor.PreferencesInitializerGenerator;
import org.eclipse.gmf.codegen.templates.editor.VisualIDRegistryGenerator;
import org.eclipse.gmf.codegen.templates.parts.ChildNodeEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.CompartmentEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.DiagramEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.DiagramExternalNodeLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.EditPartFactoryGenerator;
import org.eclipse.gmf.codegen.templates.parts.ExternalNodeLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.ITextAwareEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.LinkEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.LinkLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.NodeEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.NodeLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.TextDirectEditManagerGenerator;
import org.eclipse.gmf.codegen.templates.policies.ChildContainerCanonicalEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.CompartmentItemSemanticEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.ConstrainedToolbarLayoutEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.DiagramCanonicalEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.DiagramItemSemanticEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.GraphicalNodeEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.ItemSemanticEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.LabelDirectEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.LinkItemSemanticEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.NodeGraphicalNodeEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.NodeItemSemanticEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.NonResizableTextEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.ReferenceConnectionEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.policies.TextSelectionEditPolicyGenerator;
import org.eclipse.gmf.codegen.templates.providers.AbstractParserGenerator;
import org.eclipse.gmf.codegen.templates.providers.EditPartProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ElementTypesGenerator;
import org.eclipse.gmf.codegen.templates.providers.IconProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.LabelTextViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.providers.LabelViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.providers.MarkerNavigationProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ModelingAssistantProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.PaletteProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ParserProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.PropertyProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.SemanticHintsGenerator;
import org.eclipse.gmf.codegen.templates.providers.StructuralFeatureParserGenerator;
import org.eclipse.gmf.codegen.templates.providers.StructuralFeaturesParserGenerator;
import org.eclipse.gmf.codegen.templates.providers.ValidationProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.providers.ViewProviderGenerator;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.codegen.dispatch.EmitterFactory;
import org.eclipse.gmf.internal.codegen.dispatch.NoSuchTemplateException;
import org.eclipse.gmf.internal.codegen.dispatch.StaticTemplateRegistry;
import org.eclipse.gmf.internal.codegen.dispatch.TemplateRegistry;
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
		put(tr, "/providers/AbstractParser.javajet", AbstractParserGenerator.class);
		put(tr, "/providers/StructuralFeatureParser.javajet", StructuralFeatureParserGenerator.class);
		put(tr, "/providers/StructuralFeaturesParser.javajet", StructuralFeaturesParserGenerator.class);
		put(tr, "/providers/SemanticHints.javajet", SemanticHintsGenerator.class);
		put(tr, "/providers/ViewFactory.javajet", ViewFactoryGenerator.class);
		put(tr, "/providers/LabelViewFactory.javajet", LabelViewFactoryGenerator.class);
		put(tr, "/providers/LabelTextViewFactory.javajet", LabelTextViewFactoryGenerator.class);
		put(tr, "/providers/ElementTypes.javajet", ElementTypesGenerator.class);
		put(tr, "/providers/ViewProvider.javajet", ViewProviderGenerator.class);
		put(tr, "/providers/EditPartProvider.javajet", EditPartProviderGenerator.class);
		put(tr, "/providers/PaletteProvider.javajet", PaletteProviderGenerator.class);
		put(tr, "/providers/ModelingAssistantProvider.javajet", ModelingAssistantProviderGenerator.class);
		put(tr, "/providers/PropertyProvider.javajet", PropertyProviderGenerator.class);
		put(tr, "/providers/IconProvider.javajet", IconProviderGenerator.class);
		put(tr, "/providers/ParserProvider.javajet", ParserProviderGenerator.class);
		put(tr, "/providers/ValidationProvider.javajet", ValidationProviderGenerator.class); //$NON-NLS-1$
		put(tr, "/providers/MarkerNavigationProvider.javajet", MarkerNavigationProviderGenerator.class); //$NON-NLS-1$
		put(tr, "/editor/InitDiagramFileAction.javajet", InitDiagramFileActionGenerator.class);
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
		put(tr, "/editor/manifest.mfjet", ManifestGenerator.class);
		put(tr, "/editor/build.propertiesjet", BuildPropertiesGenerator.class);
		
		// temp
		put(tr, "/parts/ITextAwareEditPart.javajet", ITextAwareEditPartGenerator.class);
		put(tr, "/parts/TextDirectEditManager.javajet", TextDirectEditManagerGenerator.class);
		put(tr, "/policies/ConstrainedToolbarLayoutEditPolicy.javajet", ConstrainedToolbarLayoutEditPolicyGenerator.class);
		put(tr, "/policies/LabelDirectEditPolicy.javajet", LabelDirectEditPolicyGenerator.class);
		put(tr, "/policies/NonResizableTextEditPolicy.javajet", NonResizableTextEditPolicyGenerator.class);
		
		return tr;
	}

	public JETEmitter getITextAwareEditPartEmitter() throws JETException {
		return retrieve(ITextAwareEditPartGenerator.class);
	}

	public JETEmitter getTextDirectEditManagerEmitter() throws JETException {
		return retrieve(TextDirectEditManagerGenerator.class);
	}

	public JETEmitter getConstrainedToolbarLayoutEditPolicyEmitter() throws JETException {
		return retrieve(ConstrainedToolbarLayoutEditPolicyGenerator.class);
	}

	public JETEmitter getLabelDirectEditPolicyEmitter() throws JETException {
		return retrieve(LabelDirectEditPolicyGenerator.class);
	}

	public JETEmitter getNonResizableTextEditPolicyEmitter() throws JETException {
		return retrieve(NonResizableTextEditPolicyGenerator.class);
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
	private JETEmitter retrieve(Class key) throws JETException {
		try {
			return myFactory.acquireEmitter(key);
		} catch (NoSuchTemplateException ex) {
			// FIXME rethrow as UnexpectedBehaviour()
			throw new JETException(ex.getClass().getName(), ex);
		} catch (UnexpectedBehaviourException ex) {
			throw new JETException(ex.getClass().getName(), ex);
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

	public JETEmitter getReorientConnectionViewCommandEmitter() throws JETException {
		return retrieve(ReorientConnectionViewCommandGenerator.class);
	}

	// parts

	public JETEmitter getDiagramEditPartEmitter() throws JETException {
		return retrieve(DiagramEditPartGenerator.class);
	}

	public JETEmitter getDiagramExternalNodeLabelEditPartEmitter() throws JETException {
		return retrieve(DiagramExternalNodeLabelEditPartGenerator.class);
	}

	public JETEmitter getNodeEditPartEmitter() throws JETException {
		return retrieve(NodeEditPartGenerator.class);
	}

	public JETEmitter getNodeLabelEditPartEmitter() throws JETException {
		return retrieve(NodeLabelEditPartGenerator.class);
	}

	public JETEmitter getExternalNodeLabelEditPartEmitter() throws JETException {
		return retrieve(ExternalNodeLabelEditPartGenerator.class);
	}

	public JETEmitter getChildNodeEditPartEmitter() throws JETException {
		return retrieve(ChildNodeEditPartGenerator.class);
	}

	public JETEmitter getCompartmentEditPartEmitter() throws JETException {
		return retrieve(CompartmentEditPartGenerator.class);
	}
	
	public JETEmitter getLinkEditPartEmitter() throws JETException {
		return retrieve(LinkEditPartGenerator.class);
	}

	public JETEmitter getLinkLabelEditPartEmitter() throws JETException {
		return retrieve(LinkLabelEditPartGenerator.class);
	}

	public JETEmitter getEditPartFactoryEmitter() throws JETException {
		return retrieve(EditPartFactoryGenerator.class);
	}
	
	// policies

	public JETEmitter getBaseItemSemanticEditPolicyEmitter() throws JETException {
		return retrieve(ItemSemanticEditPolicyGenerator.class);
	}

	public JETEmitter getBaseGraphicalNodeEditPolicyEmitter() throws JETException {
		return retrieve(GraphicalNodeEditPolicyGenerator.class);
	}

	public JETEmitter getReferenceConnectionEditPolicyEmitter() throws JETException {
		return retrieve(ReferenceConnectionEditPolicyGenerator.class);
	}

	public JETEmitter getDiagramCanonicalEditPolicyEmitter() throws JETException {
		return retrieve(DiagramCanonicalEditPolicyGenerator.class);
	}

	public JETEmitter getChildContainerCanonicalEditPolicyEmitter() throws JETException {
		return retrieve(ChildContainerCanonicalEditPolicyGenerator.class);
	}

	public JETEmitter getDiagramItemSemanticEditPolicyEmitter() throws JETException {
		return retrieve(DiagramItemSemanticEditPolicyGenerator.class);
	}

	public JETEmitter getCompartmentItemSemanticEditPolicyEmitter() throws JETException {
		return retrieve(CompartmentItemSemanticEditPolicyGenerator.class);
	}

	public JETEmitter getNodeGraphicalNodeEditPolicyEmitter() throws JETException {
		return retrieve(NodeGraphicalNodeEditPolicyGenerator.class);
	}

	public JETEmitter getNodeItemSemanticEditPolicyEmitter() throws JETException {
		return retrieve(NodeItemSemanticEditPolicyGenerator.class);
	}

	public JETEmitter getLinkItemSemanticEditPolicyEmitter() throws JETException {
		return retrieve(LinkItemSemanticEditPolicyGenerator.class);
	}

	public JETEmitter getTextSelectionEditPolicyEmitter() throws JETException {
		return retrieve(TextSelectionEditPolicyGenerator.class);
	}

	// providers

	public JETEmitter getAbstractParserEmitter() throws JETException {
		return retrieve(AbstractParserGenerator.class);
	}

	public JETEmitter getStructuralFeatureParserEmitter() throws JETException {
		return retrieve(StructuralFeatureParserGenerator.class);
	}

	public JETEmitter getStructuralFeaturesParserEmitter() throws JETException {
		return retrieve(StructuralFeaturesParserGenerator.class);
	}

	public JETEmitter getSemanticHintsEmitter() throws JETException {
		return retrieve(SemanticHintsGenerator.class);
	}

	public JETEmitter getViewFactoryEmitter() throws JETException {
		return retrieve(ViewFactoryGenerator.class);
	}

	public JETEmitter getLabelViewFactoryEmitter() throws JETException {
		return retrieve(LabelViewFactoryGenerator.class);
	}

	public JETEmitter getLabelTextViewFactoryEmitter() throws JETException {
		return retrieve(LabelTextViewFactoryGenerator.class);
	}
	
	public JETEmitter getElementTypesEmitter() throws JETException {
		return retrieve(ElementTypesGenerator.class);
	}

	public JETEmitter getViewProviderEmitter() throws JETException {
		return retrieve(ViewProviderGenerator.class);
	}

	public JETEmitter getEditPartProviderEmitter() throws JETException {
		return retrieve(EditPartProviderGenerator.class);
	}

	public JETEmitter getPaletteProviderEmitter() throws JETException {
		return retrieve(PaletteProviderGenerator.class);
	}

	public JETEmitter getModelingAssistantProviderEmitter() throws JETException {
		return retrieve(ModelingAssistantProviderGenerator.class);
	}

	public JETEmitter getPropertyProviderEmitter() throws JETException {
		return retrieve(PropertyProviderGenerator.class);
	}

	public JETEmitter getIconProviderEmitter() throws JETException {
		return retrieve(IconProviderGenerator.class);
	}

	public JETEmitter getParserProviderEmitter() throws JETException {
		return retrieve(ParserProviderGenerator.class);
	}

	public JETEmitter getValidationProviderEmitter() throws JETException {
		return retrieve(ValidationProviderGenerator.class); //$NON-NLS-1$
	}
	
	public JETEmitter getMarkerNavigationProviderEmitter() throws JETException {
		return retrieve(MarkerNavigationProviderGenerator.class); //$NON-NLS-1$
	}	

	// editor

	public JETEmitter getInitDiagramFileActionEmitter() throws JETException {
		return retrieve(InitDiagramFileActionGenerator.class);
	}

	public JETEmitter getPaletteEmitter() throws JETException {
		return retrieve(PaletteFactoryGenerator.class);
	}

	public JETEmitter getDiagramEditorUtilEmitter() throws JETException {
		return retrieve(DiagramEditorUtilGenerator.class);
	}

	public JETEmitter getDiagramFileCreatorEmitter() throws JETException {
		return retrieve(DiagramFileCreatorGenerator.class);
	}
	
	public JETEmitter getVisualIDRegistryEmitter() throws JETException {
		return retrieve(VisualIDRegistryGenerator.class);
	}

	public JETEmitter getCreationWizardEmitter() throws JETException {
		return retrieve(CreationWizardGenerator.class);
	}

	public JETEmitter getCreationWizardPageEmitter() throws JETException {
		return retrieve(CreationWizardPageGenerator.class);
	}

	public JETEmitter getEditorEmitter() throws JETException {
		return retrieve(EditorGenerator.class);
	}
	
	public JETEmitter getCreateShortcutActionEmitter() throws JETException {
		return retrieve(CreateShortcutActionGenerator.class);
	}

	public JETEmitter getLoadResourceActionEmitter() throws JETException {
		return retrieve(LoadResourceActionGenerator.class);
	}
	
	public JETEmitter getElementChooserEmitter() throws JETException {
		return retrieve(ElementChooserGenerator.class);
	}
	
	public JETEmitter getDocumentProviderEmitter() throws JETException {
		return retrieve(DocumentProviderGenerator.class);
	}
	
	public JETEmitter getActionBarContributorEmitter() throws JETException {
		return retrieve(ActionBarContributorGenerator.class);
	}

	public JETEmitter getMatchingStrategyEmitter() throws JETException {
		return retrieve(MatchingStrategyGenerator.class);
	}

	public JETEmitter getPreferencesInitializerEmitter() throws JETException {
		return retrieve(PreferencesInitializerGenerator.class);
	}

	public JETEmitter getPluginClassEmitter() throws JETException {
		return retrieve(PluginGenerator.class);
	}

	public JETEmitter getPluginXmlEmitter() throws JETException {
		return retrieve(PluginXML.class);
	}

	public JETEmitter getPluginPropertiesEmitter() throws JETException {
		return retrieve(PluginPropertiesGenerator.class);
	}

	public JETEmitter getBundleManifestEmitter() throws JETException {
		return retrieve(ManifestGenerator.class);
	}

	public JETEmitter getBuildPropertiesEmitter() throws JETException {
		return retrieve(BuildPropertiesGenerator.class);
	}
	
	public GIFEmitter getShortcutImageEmitter() throws JETException {
		String templateLocation = JETCompiler.find(getTemplatePath(), "/editor/shortcut.gif");
		if (templateLocation == null) {
			throw new JETException("shortcut image template not found");
		}
		return new GIFEmitter(templateLocation);
	}
}
