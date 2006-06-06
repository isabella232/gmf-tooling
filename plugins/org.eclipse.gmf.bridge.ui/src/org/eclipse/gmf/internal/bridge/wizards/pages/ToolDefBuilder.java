/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.wizards.pages;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.internal.bridge.resolver.Resolution;
import org.eclipse.gmf.internal.bridge.resolver.ResolvedItem;
import org.eclipse.gmf.internal.bridge.wizards.WizardUtil;
import org.eclipse.gmf.tooldef.CreationTool;
import org.eclipse.gmf.tooldef.GMFToolFactory;
import org.eclipse.gmf.tooldef.GMFToolPackage;
import org.eclipse.gmf.tooldef.Palette;
import org.eclipse.gmf.tooldef.ToolGroup;
import org.eclipse.gmf.tooldef.ToolRegistry;

/**
 * @author dstadnik
 */
public class ToolDefBuilder {

	protected GMFToolPackage gmfToolPackage = GMFToolPackage.eINSTANCE;

	protected GMFToolFactory gmfToolFactory = gmfToolPackage.getGMFToolFactory();

	public ToolRegistry process(ResolvedItem item) {
		ToolRegistry toolRegistry = gmfToolFactory.createToolRegistry();
		if (item != null) {
			EPackage ePackage = (EPackage) item.getDomainRef();
			Palette palette = gmfToolFactory.createPalette();
			toolRegistry.setPalette(palette);
			ToolGroup group = gmfToolFactory.createToolGroup();
			group.setTitle(ePackage.getName());
			palette.getTools().add(group);
			for (Iterator it = item.getChildren().iterator(); it.hasNext();) {
				process((ResolvedItem) it.next(), toolRegistry, group);
			}
		}
		return toolRegistry;
	}

	protected void process(ResolvedItem item, ToolRegistry toolRegistry, ToolGroup group) {
		boolean descend = false;
		if (item.getDomainRef() instanceof EClass) {
			EClass type = (EClass) item.getDomainRef();
			String baseName = type.getName();
			if (item.getResolution() == Resolution.NODE || item.getResolution() == Resolution.LINK) {
				addCreationTool(baseName, group);
				descend = true;
			}
		} else if (item.getDomainRef() instanceof EReference) {
			EReference ref = (EReference) item.getDomainRef();
			String baseName = WizardUtil.getCapName(ref);
			if (item.getResolution() == Resolution.LINK) {
				addCreationTool(baseName, group);
				descend = true;
			}
		}
		if (descend) {
			for (Iterator it = item.getChildren().iterator(); it.hasNext();) {
				process((ResolvedItem) it.next(), toolRegistry, group);
			}
		}
	}

	protected CreationTool addCreationTool(String baseName, ToolGroup group) {
		CreationTool tool = gmfToolFactory.createCreationTool();
		tool.setTitle(baseName);
		tool.setDescription(Messages.bind(Messages.ToolDefBuilder0, baseName));
		tool.setSmallIcon(gmfToolFactory.createDefaultImage());
		tool.setLargeIcon(gmfToolFactory.createDefaultImage());
		group.getTools().add(tool);
		return tool;
	}
}
