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
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gmf.runtime.diagram.ui.internal.tools.ZoomTool;
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
	private final PaletteRoot root = new PaletteRoot();

	/**
	 * @generated
	 */
	private final Diagram diagram;

	/**
	 * @generated
	 */
	private TaiPanPaletteFactory(Diagram diagram) {
		this.diagram = diagram;
	}

	/**
	 * @generated
	 */
	public static PaletteRoot createPalette(Diagram diagram) {
		TaiPanPaletteFactory factory = new TaiPanPaletteFactory(diagram);
		factory.createCommonTools();
		factory.createTAIPANGroup();
		return factory.root;
	}

	/**
	 * @generated
	 */
	protected Diagram getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	private void createCommonTools() {
		PaletteGroup common = new PaletteGroup("Common");
		ToolEntry selectionTool = new PanningSelectionToolEntry();
		common.add(selectionTool);
		common.add(new MarqueeToolEntry());
		root.add(common);
		root.setDefaultEntry(selectionTool);
	}

	/**
	 * @generated
	 */
	private ImageDescriptor getZoomToolImage() {
		ZoomInAction action = new ZoomInAction(new ZoomManager(null, null));
		return action.getImageDescriptor();
	}

	/**
	 * @generated
	 */
	private void createTAIPANGroup() {
		PaletteContainer paletteContainer = createContainer("TaiPan");
		createPORTNODECreationTool(paletteContainer);
		createSHIPNODECreationTool(paletteContainer);
		createITEMNODECreationTool(paletteContainer);
		paletteContainer.add(new PaletteSeparator());
		createDESTINATIONLINKCreationTool(paletteContainer);
		root.add(paletteContainer);
	}

	/**
	 * @generated
	 */
	private void createPORTNODECreationTool(PaletteContainer paletteContainer) {
		ImageDescriptor image = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Port_1001);
		paletteContainer.add(new ToolEntry("PortNode", "PortNode", image, image) {

			public Tool createTool() {
				Tool tool = new CreationTool(TaiPanElementTypes.Port_1001);
				tool.setProperties(getToolProperties());
				return tool;
			}
		});
	}

	/**
	 * @generated
	 */
	private void createSHIPNODECreationTool(PaletteContainer paletteContainer) {
		ImageDescriptor image = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Ship_1002);
		paletteContainer.add(new ToolEntry("ShipNode", "ShipNode", image, image) {

			public Tool createTool() {
				Tool tool = new CreationTool(TaiPanElementTypes.Ship_1002);
				tool.setProperties(getToolProperties());
				return tool;
			}
		});
	}

	/**
	 * @generated
	 */
	private void createITEMNODECreationTool(PaletteContainer paletteContainer) {
		ImageDescriptor image = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Item_2001);
		paletteContainer.add(new ToolEntry("ItemNode", "ItemNode", image, image) {

			public Tool createTool() {
				Tool tool = new CreationTool(TaiPanElementTypes.Item_2001);
				tool.setProperties(getToolProperties());
				return tool;
			}
		});
	}

	/**
	 * @generated
	 */
	private void createDESTINATIONLINKCreationTool(PaletteContainer paletteContainer) {
		ImageDescriptor image = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.ShipDestination_3001);
		paletteContainer.add(new ToolEntry("DestinationLink", "DestinationLink", image, image) {

			public Tool createTool() {
				Tool tool = new ConnectionCreationTool(TaiPanElementTypes.ShipDestination_3001);
				tool.setProperties(getToolProperties());
				return tool;
			}
		});
	}

	/**
	 * @generated
	 */
	private PaletteContainer createContainer(String title) {
		return new PaletteDrawer(title);
	}
}
