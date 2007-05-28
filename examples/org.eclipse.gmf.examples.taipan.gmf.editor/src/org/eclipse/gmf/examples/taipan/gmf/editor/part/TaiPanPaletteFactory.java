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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
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
		paletteRoot.add(createNodesGroup());
		paletteRoot.add(createLinksGroup());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodesGroup() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.NodesGroup_title);
		paletteContainer.add(createPortTool());
		paletteContainer.add(createShipTool());
		paletteContainer.add(createWarshipTool());
		paletteContainer.add(createSmallItemsTool());
		paletteContainer.add(createLargeItemTool());
		paletteContainer.add(createEmptyBoxTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinksGroup() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.LinksGroup_title);
		paletteContainer.add(createReliableRouteTool());
		paletteContainer.add(createUnreliableRouteTool());
		paletteContainer.add(createRegistrationTool());
		paletteContainer.add(createShipDestinationTool());
		paletteContainer.add(createBesiegePortOrderTool());
		paletteContainer.add(createEscortShipsOrderTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPortTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Port_2001);
		NodeToolEntry entry = new NodeToolEntry(Messages.PortTool_title, Messages.PortTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Port_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShipTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Ship_2002);
		NodeToolEntry entry = new NodeToolEntry(Messages.ShipTool_title, Messages.ShipTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Ship_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createWarshipTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Warship_2003);
		NodeToolEntry entry = new NodeToolEntry(Messages.WarshipTool_title, Messages.WarshipTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Warship_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSmallItemsTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.SmallItems_3001);
		NodeToolEntry entry = new NodeToolEntry(Messages.SmallItemsTool_title, Messages.SmallItemsTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.SmallItems_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLargeItemTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.LargeItem_3002);
		NodeToolEntry entry = new NodeToolEntry(Messages.LargeItemTool_title, Messages.LargeItemTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.LargeItem_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEmptyBoxTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.EmptyBox_3003);
		NodeToolEntry entry = new NodeToolEntry(Messages.EmptyBoxTool_title, Messages.EmptyBoxTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.EmptyBox_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReliableRouteTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Route_4002);
		LinkToolEntry entry = new LinkToolEntry(Messages.ReliableRouteTool_title, Messages.ReliableRouteTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Route_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUnreliableRouteTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Route_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.UnreliableRouteTool_title, Messages.UnreliableRouteTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Route_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRegistrationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.PortRegister_4007);
		LinkToolEntry entry = new LinkToolEntry(Messages.RegistrationTool_title, Messages.RegistrationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.PortRegister_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShipDestinationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.ShipDestination_4001);
		LinkToolEntry entry = new LinkToolEntry(Messages.ShipDestinationTool_title, Messages.ShipDestinationTool_desc, types);
		entry.setSmallIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif")); //$NON-NLS-1$
		entry.setLargeIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBesiegePortOrderTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.BesiegePortOrder_4005);
		LinkToolEntry entry = new LinkToolEntry(Messages.BesiegePortOrderTool_title, Messages.BesiegePortOrderTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.BesiegePortOrder_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEscortShipsOrderTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.EscortShipsOrder_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.EscortShipsOrderTool_title, Messages.EscortShipsOrderTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.EscortShipsOrder_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
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
		private NodeToolEntry(String title, String description, List elementTypes) {
			super(title, description, null, null);
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
		private LinkToolEntry(String title, String description, List relationshipTypes) {
			super(title, description, null, null);
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
