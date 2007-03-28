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
		paletteRoot.add(createTaipan1Group());
	}

	/**
	 * Creates "taipan" palette tool group
	 * @generated
	 */
	private PaletteContainer createTaipan1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Taipan1Group_title);
		paletteContainer.add(createPort1CreationTool());
		paletteContainer.add(createShip2CreationTool());
		paletteContainer.add(createSmallItems3CreationTool());
		paletteContainer.add(createLargeItem4CreationTool());
		paletteContainer.add(createEmptyBox5CreationTool());
		paletteContainer.add(createReliableRoute6CreationTool());
		paletteContainer.add(createUnreliableRoute7CreationTool());
		paletteContainer.add(createShipDestination8CreationTool());
		paletteContainer.add(createWarship9CreationTool());
		paletteContainer.add(createBesiegePortOrder10CreationTool());
		paletteContainer.add(createEscortShipsOrder11CreationTool());
		paletteContainer.add(createRegistration12CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPort1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Port_2001);
		NodeToolEntry entry = new NodeToolEntry(Messages.Port1CreationTool_title, Messages.Port1CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Port_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShip2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Ship_2002);
		NodeToolEntry entry = new NodeToolEntry(Messages.Ship2CreationTool_title, Messages.Ship2CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Ship_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSmallItems3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.SmallItems_3001);
		NodeToolEntry entry = new NodeToolEntry(Messages.SmallItems3CreationTool_title, Messages.SmallItems3CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.SmallItems_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLargeItem4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.LargeItem_3002);
		NodeToolEntry entry = new NodeToolEntry(Messages.LargeItem4CreationTool_title, Messages.LargeItem4CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.LargeItem_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEmptyBox5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.EmptyBox_3003);
		NodeToolEntry entry = new NodeToolEntry(Messages.EmptyBox5CreationTool_title, Messages.EmptyBox5CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.EmptyBox_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReliableRoute6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Route_4002);
		LinkToolEntry entry = new LinkToolEntry(Messages.ReliableRoute6CreationTool_title, Messages.ReliableRoute6CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Route_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUnreliableRoute7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Route_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.UnreliableRoute7CreationTool_title, Messages.UnreliableRoute7CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Route_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShipDestination8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.ShipDestination_4001);
		LinkToolEntry entry = new LinkToolEntry(Messages.ShipDestination8CreationTool_title, Messages.ShipDestination8CreationTool_desc, types);
		entry.setSmallIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif")); //$NON-NLS-1$
		entry.setLargeIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createWarship9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Warship_2003);
		NodeToolEntry entry = new NodeToolEntry(Messages.Warship9CreationTool_title, Messages.Warship9CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Warship_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBesiegePortOrder10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.BesiegePortOrder_4005);
		LinkToolEntry entry = new LinkToolEntry(Messages.BesiegePortOrder10CreationTool_title, Messages.BesiegePortOrder10CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.BesiegePortOrder_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEscortShipsOrder11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.EscortShipsOrder_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.EscortShipsOrder11CreationTool_title, Messages.EscortShipsOrder11CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.EscortShipsOrder_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRegistration12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.PortRegister_4007);
		LinkToolEntry entry = new LinkToolEntry(Messages.Registration12CreationTool_title, Messages.Registration12CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.PortRegister_4007));
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
