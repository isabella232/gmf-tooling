/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup.annotated;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.tests.setup.ToolDefSource;
import org.eclipse.gmf.tooldef.AbstractTool;
import org.eclipse.gmf.tooldef.ContextMenu;
import org.eclipse.gmf.tooldef.CreationTool;
import org.eclipse.gmf.tooldef.GMFToolFactory;
import org.eclipse.gmf.tooldef.MainMenu;
import org.eclipse.gmf.tooldef.Palette;
import org.eclipse.gmf.tooldef.ToolGroup;
import org.eclipse.gmf.tooldef.ToolRegistry;

/**
 * Creates tooling definition model from annotated domain model.
 * 
 * @author dstadnik
 */
public class ToolDefASetup extends AbstractASetup implements ToolDefSource {

	protected EPackage ePackage;

	protected ToolRegistry registry;

	protected ToolGroup group;

	public ToolDefASetup(EPackage ePackage) {
		this.ePackage = ePackage;
	}

	protected Iterator getAllDomainModelContents() {
		return ePackage.eAllContents();
	}

	protected void createToolRegistry() {
		registry = GMFToolFactory.eINSTANCE.createToolRegistry();
		Palette palette = GMFToolFactory.eINSTANCE.createPalette();
		palette.setTitle("default"); //$NON-NLS-1$
		registry.setPalette(palette);
		group = GMFToolFactory.eINSTANCE.createToolGroup();
		group.setTitle("default"); //$NON-NLS-1$
		palette.getTools().add(group);
		processDomainModel();
	}

	protected void processNode(EModelElement element, String name, List<Parameter> params) {
		group.getTools().add(createCreationTool(element, name, params));
	}

	protected void processLink(EModelElement element, String name, List<Parameter> params) {
		group.getTools().add(createCreationTool(element, name, params));
	}

	protected CreationTool createCreationTool(EModelElement element, String name, List<Parameter> params) {
		CreationTool tool = GMFToolFactory.eINSTANCE.createCreationTool();
		tool.setTitle(getName(element, name));
		tool.setLargeIcon(GMFToolFactory.eINSTANCE.createDefaultImage());
		tool.setSmallIcon(GMFToolFactory.eINSTANCE.createDefaultImage());
		return tool;
	}

	// source

	public ToolRegistry getRegistry() {
		if (registry == null) {
			createToolRegistry();
			saveModel(registry, "gmftool"); //$NON-NLS-1$
			validate(registry);
		}
		return registry;
	}

	public Palette getPalette() {
		return getRegistry().getPalette();
	}

	public AbstractTool getNodeCreationTool() {
		return null;
	}

	public AbstractTool getLinkCreationTool() {
		return null;
	}

	public MainMenu getMainMenu() {
		return null;
	}

	public ContextMenu getNodeContextMenu() {
		return null;
	}
}
