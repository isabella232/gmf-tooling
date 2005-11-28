/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;

/**
 * @generated
 */
public class TaiPanPaletteFactory {

	/**
	 * @generated
	 */
	private Diagram diagram;

	/**
	 * @generated
	 */
	private TaiPanPaletteFactory(Diagram diagram) {
		this.diagram = diagram;
	}

	/**
	 * @generated
	 */
	protected final Diagram getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public static PaletteRoot createPalette(Diagram diagram) {
		PaletteRoot paletteRoot = new PaletteRoot();
		TaiPanPaletteFactory factory = new TaiPanPaletteFactory(diagram);
		PaletteContainer commonTools = factory.createCommonTools();
		paletteRoot.add(commonTools);
		paletteRoot.setDefaultEntry((ToolEntry) commonTools.getChildren().get(0));
		factory.fillPalette(paletteRoot);
		return paletteRoot;
	}

	/**
	 * @generated
	 */
	public static void fillPalette(PaletteRoot paletteRoot, Diagram diagram) {
		TaiPanPaletteFactory factory = new TaiPanPaletteFactory(diagram);
		factory.fillPalette(paletteRoot);
	}

	/**
	 * @generated
	 */
	private void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createTAIPANGroup());
	}

	/**
	 * @generated
	 */
	private PaletteContainer createCommonTools() {
		PaletteGroup common = new PaletteGroup("Common");
		ToolEntry selectionTool = new PanningSelectionToolEntry();
		common.add(selectionTool);
		common.add(new MarqueeToolEntry());
		return common;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createTAIPANGroup() {
		PaletteContainer paletteContainer = createContainer("TaiPan");
		paletteContainer.add(createPORTNODECreationTool());
		paletteContainer.add(createSHIPNODECreationTool());
		paletteContainer.add(createITEMNODECreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createDESTINATIONLINKCreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPORTNODECreationTool() {
		ImageDescriptor image = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Port_1001);
		return new ToolEntry("PortNode", "PortNode", image, image) {

			public Tool createTool() {
				Tool tool = new CreationTool(TaiPanElementTypes.Port_1001);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createSHIPNODECreationTool() {
		ImageDescriptor image = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Ship_1002);
		return new ToolEntry("ShipNode", "ShipNode", image, image) {

			public Tool createTool() {
				Tool tool = new CreationTool(TaiPanElementTypes.Ship_1002);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createITEMNODECreationTool() {
		ImageDescriptor image = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Item_2001);
		return new ToolEntry("ItemNode", "ItemNode", image, image) {

			public Tool createTool() {
				Tool tool = new CreationTool(TaiPanElementTypes.Item_2001);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createDESTINATIONLINKCreationTool() {
		ImageDescriptor image = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.ShipDestination_3001);
		return new ToolEntry("DestinationLink", "DestinationLink", image, image) {

			public Tool createTool() {
				Tool tool = new ConnectionCreationTool(TaiPanElementTypes.ShipDestination_3001);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private PaletteContainer createContainer(String title) {
		return new PaletteDrawer(title);
	}
}
