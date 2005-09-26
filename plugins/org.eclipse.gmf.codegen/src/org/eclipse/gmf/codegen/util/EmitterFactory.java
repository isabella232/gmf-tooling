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
import org.eclipse.gmf.codegen.templates.diacanvas.CanvasEditPartGen;
import org.eclipse.gmf.codegen.templates.diacanvas.EditPartFactoryGen;
import org.eclipse.gmf.codegen.templates.diacanvas.EditorGen;
import org.eclipse.gmf.codegen.templates.diacanvas.InitDiagramFileActionGen;
import org.eclipse.gmf.codegen.templates.diacanvas.LinkEditPartGen;
import org.eclipse.gmf.codegen.templates.diacanvas.NodeEditPartGen;
import org.eclipse.gmf.codegen.templates.diacanvas.PaletteGen;
import org.eclipse.gmf.codegen.templates.diacanvas.PluginGen;
import org.eclipse.gmf.codegen.templates.diacanvas.PluginXML;
import org.eclipse.gmf.codegen.templates.edit.CanvasMetaInfoProviderGenerator;
import org.eclipse.gmf.codegen.templates.edit.LinkMetaInfoProviderGenerator;
import org.eclipse.gmf.codegen.templates.edit.MetaInfoProviderAdapterFactory1Generator;
import org.eclipse.gmf.codegen.templates.edit.MetaInfoProviderAdapterFactory2Generator;
import org.eclipse.gmf.codegen.templates.edit.NodeMetaInfoProviderGenerator;
import org.osgi.framework.Bundle;

/**
 * Provides JET templates
 * @author artem
 */
public class EmitterFactory {
	private static final String TEMPLATES_PLUGIN_ID = "org.eclipse.gmf.codegen";

	private static boolean usePrecompiledTemplates() {
		return true;
	}

	public static URL getJMergeControlFile() {
		return getTemplatesBundle().getEntry("/templates/emf-merge.xml");
	}

	public static JETEmitter getPaletteEmitter() throws JETException {
		return initializeEmitter("/templates/editor/Palette.javajet", PaletteGen.class);
	}

	public static JETEmitter getNodeEditPartEmitter() throws JETException {
		return initializeEmitter("/templates/parts/NodeEditPart.javajet", NodeEditPartGen.class);
	}

	public static JETEmitter getLinkEditPartEmitter() throws JETException {
		return initializeEmitter("/templates/parts/LinkEditPart.javajet", LinkEditPartGen.class);
	}

	public static JETEmitter getCanvasEditPartEmitter() throws JETException {
		return initializeEmitter("/templates/parts/CanvasEditPart.javajet", CanvasEditPartGen.class);
	}

	public static JETEmitter getEditPartFactoryEmitter() throws JETException {
		return initializeEmitter("/templates/parts/EditPartFactory.javajet", EditPartFactoryGen.class);
	}

	public static JETEmitter getEditorEmitter() throws JETException {
		return initializeEmitter("/templates/editor/Editor.javajet", EditorGen.class);
	}

	public static JETEmitter getPluginXmlEmitter() throws JETException {
		return initializeEmitter("/templates/editor/plugin.xmljet", PluginXML.class);
	}
	
	public static JETEmitter getInitDiagramFileActionEmitter() throws JETException {
		return initializeEmitter("/templates/editor/InitDiagramFileAction.javajet", InitDiagramFileActionGen.class);
	}

	public static JETEmitter getPluginClassEmitter() throws JETException {
		return initializeEmitter("/templates/editor/Plugin.javajet", PluginGen.class);
	}

	public static JETEmitter getNodeMetaInfoProviderEmitter() throws JETException {
		return initializeEmitter("/templates/edit/NodeMetaInfoProvider.javajet", NodeMetaInfoProviderGenerator.class);
	}

	public static JETEmitter getLinkMetaInfoProviderEmitter() throws JETException {
		return initializeEmitter("/templates/edit/LinkMetaInfoProvider.javajet", LinkMetaInfoProviderGenerator.class);
	}

	public static JETEmitter getCanvasMetaInfoProviderEmitter() throws JETException {
		return initializeEmitter("/templates/edit/CanvasMetaInfoProvider.javajet", CanvasMetaInfoProviderGenerator.class);
	}

	public static JETEmitter getMetaInfoProviderAF1Emitter() throws JETException {
		return initializeEmitter("/templates/edit/MetaInfoProviderAdapterFactory1.javajet", MetaInfoProviderAdapterFactory1Generator.class);
	}

	public static JETEmitter getMetaInfoProviderAF2Emitter() throws JETException {
		return initializeEmitter("/templates/edit/MetaInfoProviderAdapterFactory2.javajet", MetaInfoProviderAdapterFactory2Generator.class);
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

	private static Bundle getTemplatesBundle() {
		return Platform.getBundle(TEMPLATES_PLUGIN_ID);
	}
}
