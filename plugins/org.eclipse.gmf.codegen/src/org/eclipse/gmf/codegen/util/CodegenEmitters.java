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
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
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
import org.eclipse.gmf.codegen.templates.parts.ExternalNodeLabelTextEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.LinkEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.LinkLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.LinkLabelTextEditPartGenerator;
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
import org.eclipse.gmf.codegen.templates.providers.AbstractParserGenerator;
import org.eclipse.gmf.codegen.templates.providers.EditPartProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ElementTypesGenerator;
import org.eclipse.gmf.codegen.templates.providers.IconProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.LabelTextViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.providers.LabelViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.providers.MarkerNavigationProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.MetamodelSupportProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ModelingAssistantProviderGenerator;
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

	public CodegenEmitters(boolean usePrecompiled) {
		TemplateRegistry registry = initRegistry();
		String[] variables = new String[] {
		        "org.eclipse.emf.codegen",
				"org.eclipse.emf.codegen.ecore",
				"org.eclipse.emf.common",
				"org.eclipse.emf.ecore",
				"org.eclipse.gmf.common",
				"org.eclipse.gmf.codegen"
		};
		myFactory = new EmitterFactory(getTemplatesBundle().getEntry("/"), registry, usePrecompiled, variables, true);
	}

	private static TemplateRegistry initRegistry() {
		final StaticTemplateRegistry tr = new StaticTemplateRegistry();
		put(tr, "/templates/commands/ReorientConnectionViewCommand.javajet", ReorientConnectionViewCommandGenerator.class);
		put(tr, "/templates/parts/DiagramEditPart.javajet", DiagramEditPartGenerator.class);
		put(tr, "/templates/parts/DiagramExternalNodeLabelEditPart.javajet", DiagramExternalNodeLabelEditPartGenerator.class);
		put(tr, "/templates/parts/NodeEditPart.javajet", NodeEditPartGenerator.class);
		put(tr, "/templates/parts/NodeLabelEditPart.javajet", NodeLabelEditPartGenerator.class);
		put(tr, "/templates/parts/ExternalNodeLabelEditPart.javajet", ExternalNodeLabelEditPartGenerator.class);
		put(tr, "/templates/parts/ExternalNodeLabelTextEditPart.javajet", ExternalNodeLabelTextEditPartGenerator.class);
		put(tr, "/templates/parts/ChildNodeEditPart.javajet", ChildNodeEditPartGenerator.class);
		put(tr, "/templates/parts/CompartmentEditPart.javajet", CompartmentEditPartGenerator.class);
		put(tr, "/templates/parts/LinkEditPart.javajet", LinkEditPartGenerator.class);
		put(tr, "/templates/parts/LinkLabelEditPart.javajet", LinkLabelEditPartGenerator.class);
		put(tr, "/templates/parts/LinkLabelTextEditPart.javajet", LinkLabelTextEditPartGenerator.class);
		put(tr, "/templates/parts/EditPartFactory.javajet", EditPartFactoryGenerator.class);
		put(tr, "/templates/policies/ItemSemanticEditPolicy.javajet", ItemSemanticEditPolicyGenerator.class);
		put(tr, "/templates/policies/GraphicalNodeEditPolicy.javajet", GraphicalNodeEditPolicyGenerator.class);
		put(tr, "/templates/policies/ReferenceConnectionEditPolicy.javajet", ReferenceConnectionEditPolicyGenerator.class);
		put(tr, "/templates/policies/DiagramCanonicalEditPolicy.javajet", DiagramCanonicalEditPolicyGenerator.class);
		put(tr, "/templates/policies/ChildContainerCanonicalEditPolicy.javajet", ChildContainerCanonicalEditPolicyGenerator.class);
		put(tr, "/templates/policies/DiagramItemSemanticEditPolicy.javajet", DiagramItemSemanticEditPolicyGenerator.class);
		put(tr, "/templates/policies/CompartmentItemSemanticEditPolicy.javajet", CompartmentItemSemanticEditPolicyGenerator.class);
		put(tr, "/templates/policies/NodeGraphicalNodeEditPolicy.javajet", NodeGraphicalNodeEditPolicyGenerator.class);
		put(tr, "/templates/policies/NodeItemSemanticEditPolicy.javajet", NodeItemSemanticEditPolicyGenerator.class);
		put(tr, "/templates/policies/LinkItemSemanticEditPolicy.javajet", LinkItemSemanticEditPolicyGenerator.class);
		put(tr, "/templates/providers/AbstractParser.javajet", AbstractParserGenerator.class);
		put(tr, "/templates/providers/StructuralFeatureParser.javajet", StructuralFeatureParserGenerator.class);
		put(tr, "/templates/providers/StructuralFeaturesParser.javajet", StructuralFeaturesParserGenerator.class);
		put(tr, "/templates/providers/SemanticHints.javajet", SemanticHintsGenerator.class);
		put(tr, "/templates/providers/ViewFactory.javajet", ViewFactoryGenerator.class);
		put(tr, "/templates/providers/LabelViewFactory.javajet", LabelViewFactoryGenerator.class);
		put(tr, "/templates/providers/LabelTextViewFactory.javajet", LabelTextViewFactoryGenerator.class);
		put(tr, "/templates/providers/ElementTypes.javajet", ElementTypesGenerator.class);
		put(tr, "/templates/providers/ViewProvider.javajet", ViewProviderGenerator.class);
		put(tr, "/templates/providers/EditPartProvider.javajet", EditPartProviderGenerator.class);
		put(tr, "/templates/providers/MetamodelSupportProvider.javajet", MetamodelSupportProviderGenerator.class);
		put(tr, "/templates/providers/ModelingAssistantProvider.javajet", ModelingAssistantProviderGenerator.class);
		put(tr, "/templates/providers/PropertyProvider.javajet", PropertyProviderGenerator.class);
		put(tr, "/templates/providers/IconProvider.javajet", IconProviderGenerator.class);
		put(tr, "/templates/providers/ParserProvider.javajet", ParserProviderGenerator.class);
		put(tr, "/templates/providers/ValidationProvider.javajet", ValidationProviderGenerator.class); //$NON-NLS-1$
		put(tr, "/templates/providers/MarkerNavigationProvider.javajet", MarkerNavigationProviderGenerator.class); //$NON-NLS-1$
		put(tr, "/templates/editor/InitDiagramFileAction.javajet", InitDiagramFileActionGenerator.class);
		put(tr, "/templates/editor/PaletteFactory.javajet", PaletteFactoryGenerator.class);
		put(tr, "/templates/editor/DiagramEditorUtil.javajet", DiagramEditorUtilGenerator.class);
		put(tr, "/templates/editor/DiagramFileCreator.javajet", DiagramFileCreatorGenerator.class);
		put(tr, "/templates/editor/VisualIDRegistry.javajet", VisualIDRegistryGenerator.class);
		put(tr, "/templates/editor/CreationWizard.javajet", CreationWizardGenerator.class);
		put(tr, "/templates/editor/CreationWizardPage.javajet", CreationWizardPageGenerator.class);
		put(tr, "/templates/editor/Editor.javajet", EditorGenerator.class);
		put(tr, "/templates/editor/CreateShortcutAction.javajet", CreateShortcutActionGenerator.class);
		put(tr, "/templates/editor/LoadResourceAction.javajet", LoadResourceActionGenerator.class);
		put(tr, "/templates/editor/ElementChooser.javajet", ElementChooserGenerator.class);
		put(tr, "/templates/editor/DocumentProvider.javajet", DocumentProviderGenerator.class);
		put(tr, "/templates/editor/ActionBarContributor.javajet", ActionBarContributorGenerator.class);
		put(tr, "/templates/editor/MatchingStrategy.javajet", MatchingStrategyGenerator.class);
		put(tr, "/templates/editor/PreferenceInitializer.javajet", PreferencesInitializerGenerator.class);
		put(tr, "/templates/editor/Plugin.javajet", PluginGenerator.class);
		put(tr, "/templates/editor/plugin.xmljet", PluginXML.class);
		put(tr, "/templates/editor/plugin.propertiesjet", PluginPropertiesGenerator.class);
		put(tr, "/templates/editor/manifest.mfjet", ManifestGenerator.class);
		put(tr, "/templates/editor/build.propertiesjet", BuildPropertiesGenerator.class);
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
	private JETEmitter retrieve(Class key) throws JETException {
		try {
			return myFactory.acquireEmitter(key);
		} catch (NoSuchTemplateException ex) {
			// FIXME rethrow as UnexpectedBehaviour()
			throw new JETException(ex.getClass().getSimpleName(), ex);
		} catch (UnexpectedBehaviourException ex) {
			throw new JETException(ex.getClass().getSimpleName(), ex);
		}
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

	public JETEmitter getExternalNodeLabelTextEditPartEmitter() throws JETException {
		return retrieve(ExternalNodeLabelTextEditPartGenerator.class);
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

	public JETEmitter getLinkLabelTextEditPartEmitter() throws JETException {
		return retrieve(LinkLabelTextEditPartGenerator.class);
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

	public JETEmitter getMetamodelSupportProviderEmitter() throws JETException {
		return retrieve(MetamodelSupportProviderGenerator.class);
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
	
	public GIFEmitter getShortcutImageEmitter() {
		return new GIFEmitter("/templates/editor/shortcut.gif", getTemplatesBundle());
	}
}
