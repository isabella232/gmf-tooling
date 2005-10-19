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

import java.lang.reflect.Method;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.gmf.codegen.templates.editor.CreationWizardGenerator;
import org.eclipse.gmf.codegen.templates.editor.CreationWizardPageGenerator;
import org.eclipse.gmf.codegen.templates.editor.DiagramEditorUtilGenerator;
import org.eclipse.gmf.codegen.templates.editor.DiagramFileCreatorGenerator;
import org.eclipse.gmf.codegen.templates.editor.EditorGenerator;
import org.eclipse.gmf.codegen.templates.editor.EditorMatchingStrategyGenerator;
import org.eclipse.gmf.codegen.templates.editor.InitDiagramFileActionGen;
import org.eclipse.gmf.codegen.templates.editor.PaletteFactoryGenerator;
import org.eclipse.gmf.codegen.templates.editor.PluginGenerator;
import org.eclipse.gmf.codegen.templates.editor.PluginXML;
import org.eclipse.gmf.codegen.templates.editor.PreferencesInitializerGenerator;
import org.eclipse.gmf.codegen.templates.editor.VisualIDRegistry;
import org.eclipse.gmf.codegen.templates.parts.ChildNodeEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.DiagramEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.EditPartFactoryGenerator;
import org.eclipse.gmf.codegen.templates.parts.LinkEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.NodeEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.NodeLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.parts.PartSelectorsGenerator;
import org.eclipse.gmf.codegen.templates.providers.EditPartProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ElementTypesGenerator;
import org.eclipse.gmf.codegen.templates.providers.IconProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.LinkLabelViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.providers.MetamodelSupportProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.ModelingAssistantProviderGenerator;
import org.eclipse.gmf.codegen.templates.providers.SemanticHintsGenerator;
import org.eclipse.gmf.codegen.templates.providers.StructuralFeatureParserGenerator;
import org.eclipse.gmf.codegen.templates.providers.ViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.providers.ViewProviderGenerator;
import org.osgi.framework.Bundle;

/**
 * Provides JET templates.
 * 
 * @author artem
 */
public class EmitterFactory {

	private static final String TEMPLATES_PLUGIN_ID = "org.eclipse.gmf.codegen";

	private static Bundle getTemplatesBundle() {
		return Platform.getBundle(TEMPLATES_PLUGIN_ID);
	}

	public static URL getJMergeControlFile() {
		return getTemplatesBundle().getEntry("/templates/emf-merge.xml");
	}

	private static boolean usePrecompiledTemplates() {
		return true;
	}

	// parts

	public static JETEmitter getDiagramEditPartEmitter() throws JETException {
		return initializeEmitter("/templates/parts/DiagramEditPart.javajet", DiagramEditPartGenerator.class);
	}

	public static JETEmitter getNodeEditPartEmitter() throws JETException {
		return initializeEmitter("/templates/parts/NodeEditPart.javajet", NodeEditPartGenerator.class);
	}

	public static JETEmitter getNodeLabelEditPartEmitter() throws JETException {
		return initializeEmitter("/templates/parts/NodeLabelEditPart.javajet", NodeLabelEditPartGenerator.class);
	}

	public static JETEmitter getChildNodeEditPartEmitter() throws JETException {
		return initializeEmitter("/templates/parts/ChildNodeEditPart.javajet", ChildNodeEditPartGenerator.class);
	}

	public static JETEmitter getLinkEditPartEmitter() throws JETException {
		return initializeEmitter("/templates/parts/LinkEditPart.javajet", LinkEditPartGenerator.class);
	}

	public static JETEmitter getEditPartFactoryEmitter() throws JETException {
		return initializeEmitter("/templates/parts/EditPartFactory.javajet", EditPartFactoryGenerator.class);
	}

	public static JETEmitter getEditPartSelectorsEmitter() throws JETException {
		return initializeEmitter("/templates/editor/PartSelectors.xmljet", PartSelectorsGenerator.class);
	}		
	
	// providers

	public static JETEmitter getStructuralFeatureParserEmitter() throws JETException {
		return initializeEmitter("/templates/providers/StructuralFeatureParser.javajet", StructuralFeatureParserGenerator.class);
	}

	public static JETEmitter getSemanticHintsEmitter() throws JETException {
		return initializeEmitter("/templates/providers/SemanticHints.javajet", SemanticHintsGenerator.class);
	}

	public static JETEmitter getViewFactoryEmitter() throws JETException {
		return initializeEmitter("/templates/providers/ViewFactory.javajet", ViewFactoryGenerator.class);
	}

	public static JETEmitter getLinkLabelViewFactoryEmitter() throws JETException {
		return initializeEmitter("/templates/providers/LinkLabelViewFactory.javajet", LinkLabelViewFactoryGenerator.class);
	}

	public static JETEmitter getElementTypesEmitter() throws JETException {
		return initializeEmitter("/templates/providers/ElementTypes.javajet", ElementTypesGenerator.class);
	}

	public static JETEmitter getViewProviderEmitter() throws JETException {
		return initializeEmitter("/templates/providers/ViewProvider.javajet", ViewProviderGenerator.class);
	}

	public static JETEmitter getEditPartProviderEmitter() throws JETException {
		return initializeEmitter("/templates/providers/EditPartProvider.javajet", EditPartProviderGenerator.class);
	}

	public static JETEmitter getMetamodelSupportProviderEmitter() throws JETException {
		return initializeEmitter("/templates/providers/MetamodelSupportProvider.javajet", MetamodelSupportProviderGenerator.class);
	}

	public static JETEmitter getModelingAssistantProviderEmitter() throws JETException {
		return initializeEmitter("/templates/providers/ModelingAssistantProvider.javajet", ModelingAssistantProviderGenerator.class);
	}

	public static JETEmitter getIconProviderEmitter() throws JETException {
		return initializeEmitter("/templates/providers/IconProvider.javajet", IconProviderGenerator.class);
	}

	// editor

	public static JETEmitter getInitDiagramFileActionEmitter() throws JETException {
		return initializeEmitter("/templates/editor/InitDiagramFileAction.javajet", InitDiagramFileActionGen.class);
	}

	public static JETEmitter getPaletteEmitter() throws JETException {
		return initializeEmitter("/templates/editor/Palette.javajet", PaletteFactoryGenerator.class);
	}

	public static JETEmitter getDiagramEditorUtilEmitter() throws JETException {
		return initializeEmitter("/templates/editor/DiagramEditorUtil.javajet", DiagramEditorUtilGenerator.class);
	}

	public static JETEmitter getDiagramFileCreatorEmitter() throws JETException {
		return initializeEmitter("/templates/editor/DiagramFileCreator.javajet", DiagramFileCreatorGenerator.class);
	}
	
	public static JETEmitter getVisualIDRegistryEmitter() throws JETException {
		return initializeEmitter("/templates/editor/VisualIDRegistry.javajet", VisualIDRegistry.class);
	}

	public static JETEmitter getCreationWizardEmitter() throws JETException {
		return initializeEmitter("/templates/editor/CreationWizard.javajet", CreationWizardGenerator.class);
	}

	public static JETEmitter getCreationWizardPageEmitter() throws JETException {
		return initializeEmitter("/templates/editor/CreationWizardPage.javajet", CreationWizardPageGenerator.class);
	}

	public static JETEmitter getEditorEmitter() throws JETException {
		return initializeEmitter("/templates/editor/Editor.javajet", EditorGenerator.class);
	}

	public static JETEmitter getEditorMatchingStrategyEmitter() throws JETException {
		return initializeEmitter("/templates/editor/EditorMatchingStrategy.javajet", EditorMatchingStrategyGenerator.class);
	}

	public static JETEmitter getPreferencesInitializerEmitter() throws JETException {
		return initializeEmitter("/templates/editor/PreferencesInitializer.javajet", PreferencesInitializerGenerator.class);
	}

	public static JETEmitter getPluginClassEmitter() throws JETException {
		return initializeEmitter("/templates/editor/Plugin.javajet", PluginGenerator.class);
	}

	public static JETEmitter getPluginXmlEmitter() throws JETException {
		return initializeEmitter("/templates/editor/plugin.xmljet", PluginXML.class);
	}

	private static JETEmitter initializeEmitter(String relativeTemplatePath, Class precompiledTemplate) throws JETException {
		String path = relativeTemplatePath;
		URL url = getTemplatesBundle().getEntry(relativeTemplatePath);
		if (url != null) {
			path = url.toString();
		} else {
			if (!usePrecompiledTemplates()) {
				throw new JETException("Template " + relativeTemplatePath + " unavailable.");
			}
		}
		JETEmitter emitter = new JETEmitter(path, EmitterFactory.class.getClassLoader());
		try {
	        emitter.addVariable("EMF_CODEGEN", "org.eclipse.emf.codegen");
			emitter.addVariable("EMF_CODEGEN_ECORE", "org.eclipse.emf.codegen.ecore");
			emitter.addVariable("EMF_COMMON", "org.eclipse.emf.common");
			emitter.addVariable("EMF_ECORE", "org.eclipse.emf.ecore");
			emitter.addVariable("DGMM", "org.eclipse.gmf.codegen");

			if (usePrecompiledTemplates()) {
				Method m = precompiledTemplate.getMethod("generate", new Class[] {Object.class});
				emitter.setMethod(m);
			}
		} catch (NoSuchMethodException ex) {
			ex.printStackTrace();
			// FALL-THROUGH. Ignore, rely on template file use
		}
		return emitter;
	}
}
