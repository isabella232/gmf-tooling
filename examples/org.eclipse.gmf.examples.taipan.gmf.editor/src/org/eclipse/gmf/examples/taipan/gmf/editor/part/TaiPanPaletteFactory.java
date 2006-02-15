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
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.palette.PaletteSeparator;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;

import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class TaiPanPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createTaiPan1Group());
	}

	/**
	 * @generated
	 */
	private PaletteContainer createTaiPan1Group() {
		PaletteContainer paletteContainer = createContainer("TaiPan");
		paletteContainer.add(createPort1001CreationTool());
		paletteContainer.add(createShip1002CreationTool());
		paletteContainer.add(createItem1003CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createDestination2001CreationTool());
		paletteContainer.add(createRoute2002CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPort1001CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Port_1001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.Port_1001);
		return new ToolEntry("Port", "Create Port node", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createShip1002CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Ship_1002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.Ship_1002);
		return new ToolEntry("Ship", "Create Ship node", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createItem1003CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Item_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.Item_2001);
		return new ToolEntry("Item", "Create Item node", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createDestination2001CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.ShipDestination_3001);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(TaiPanElementTypes.ShipDestination_3001);
		return new ToolEntry("Destination", "Create Destination link", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createRoute2002CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Route_3002);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(TaiPanElementTypes.Route_3002);
		return new ToolEntry("Route", "Create Route link", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
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
