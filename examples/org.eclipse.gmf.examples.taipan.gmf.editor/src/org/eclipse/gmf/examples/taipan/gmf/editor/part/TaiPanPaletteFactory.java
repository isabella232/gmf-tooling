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
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import java.util.List;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;
import java.util.ArrayList;

import org.eclipse.gef.palette.PaletteGroup;

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
		paletteRoot.add(createtaipan1Group());
	}

	/**
	 * @generated
	 */
	private PaletteContainer createtaipan1Group() {
		PaletteContainer paletteContainer = new PaletteGroup("taipan");
		paletteContainer.add(createPort1CreationTool());
		paletteContainer.add(createShip2CreationTool());
		paletteContainer.add(createSmallItems3CreationTool());
		paletteContainer.add(createLargeItem4CreationTool());
		paletteContainer.add(createEmptyBox5CreationTool());
		paletteContainer.add(createReliableRoute6CreationTool());
		paletteContainer.add(createUnreliableRoute7CreationTool());
		paletteContainer.add(createShipDestination8CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPort1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Port_1001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.Port_1001);
		ToolEntry result = new NodeToolEntry("Port", "Create new Port", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShip2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Ship_1002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.Ship_1002);
		ToolEntry result = new NodeToolEntry("Ship", "Create new Ship", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSmallItems3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.SmallItems_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.SmallItems_2001);
		ToolEntry result = new NodeToolEntry("Small Items", "Add small items", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLargeItem4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.LargeItem_2002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.LargeItem_2002);
		ToolEntry result = new NodeToolEntry("Large Item", "Add large item", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEmptyBox5CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.EmptyBox_2003);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.EmptyBox_2003);
		ToolEntry result = new NodeToolEntry("Empty Box", "Add empty box", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReliableRoute6CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Route_3002);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(TaiPanElementTypes.Route_3002);
		ToolEntry result = new LinkToolEntry("Reliable Route", "Create new Route", smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUnreliableRoute7CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Route_3003);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(TaiPanElementTypes.Route_3003);
		ToolEntry result = new LinkToolEntry("Unreliable Route", "Create new Route", smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShipDestination8CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif");

		largeImage = TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif");

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(TaiPanElementTypes.ShipDestination_3001);
		ToolEntry result = new LinkToolEntry("Ship Destination", "Create new ship destination", smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, List elementTypes) {
			super(title, description, smallIcon, largeIcon);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, List relationshipTypes) {
			super(title, description, smallIcon, largeIcon);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
