/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
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
import org.eclipse.gef.palette.PaletteDrawer;
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
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createLinks2Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Nodes1Group_title);
		paletteContainer.setSmallIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/Port.gif")); //$NON-NLS-1$
		paletteContainer.setLargeIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/Port.gif")); //$NON-NLS-1$
		paletteContainer.add(createPort1CreationTool());
		paletteContainer.add(createShip2CreationTool());
		paletteContainer.add(createWarship3CreationTool());
		paletteContainer.add(createSmallItems4CreationTool());
		paletteContainer.add(createLargeItem5CreationTool());
		paletteContainer.add(createEmptyBox6CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Links2Group_title);
		paletteContainer.setSmallIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/Route.gif")); //$NON-NLS-1$
		paletteContainer.setLargeIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/Route.gif")); //$NON-NLS-1$
		paletteContainer.add(createReliableRoute1CreationTool());
		paletteContainer.add(createUnreliableRoute2CreationTool());
		paletteContainer.add(createRegistration3CreationTool());
		paletteContainer.add(createShipDestination4CreationTool());
		paletteContainer.add(createShipRoute5CreationTool());
		paletteContainer.add(createBesiegePortOrder6CreationTool());
		paletteContainer.add(createEscortShipsOrder7CreationTool());
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
	private ToolEntry createWarship3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Warship_2003);
		NodeToolEntry entry = new NodeToolEntry(Messages.Warship3CreationTool_title, Messages.Warship3CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Warship_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSmallItems4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.SmallItems_3001);
		NodeToolEntry entry = new NodeToolEntry(Messages.SmallItems4CreationTool_title, Messages.SmallItems4CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.SmallItems_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLargeItem5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.LargeItem_3002);
		NodeToolEntry entry = new NodeToolEntry(Messages.LargeItem5CreationTool_title, Messages.LargeItem5CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.LargeItem_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEmptyBox6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.EmptyBox_3003);
		NodeToolEntry entry = new NodeToolEntry(Messages.EmptyBox6CreationTool_title, Messages.EmptyBox6CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.EmptyBox_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReliableRoute1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Route_4002);
		LinkToolEntry entry = new LinkToolEntry(Messages.ReliableRoute1CreationTool_title, Messages.ReliableRoute1CreationTool_desc, types);
		entry.setSmallIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/Route.gif")); //$NON-NLS-1$
		entry.setLargeIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/Route.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUnreliableRoute2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Route_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.UnreliableRoute2CreationTool_title, Messages.UnreliableRoute2CreationTool_desc, types);
		entry.setSmallIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/UnreliableRoute.gif")); //$NON-NLS-1$
		entry.setLargeIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/UnreliableRoute.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRegistration3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.PortRegister_4007);
		LinkToolEntry entry = new LinkToolEntry(Messages.Registration3CreationTool_title, Messages.Registration3CreationTool_desc, types);
		entry.setSmallIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipRegistration.gif")); //$NON-NLS-1$
		entry.setLargeIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipRegistration.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShipDestination4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.ShipDestination_4001);
		LinkToolEntry entry = new LinkToolEntry(Messages.ShipDestination4CreationTool_title, Messages.ShipDestination4CreationTool_desc, types);
		entry.setSmallIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif")); //$NON-NLS-1$
		entry.setLargeIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShipRoute5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.ShipRoute_4004);
		LinkToolEntry entry = new LinkToolEntry(Messages.ShipRoute5CreationTool_title, Messages.ShipRoute5CreationTool_desc, types);
		entry.setSmallIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipRoute.gif")); //$NON-NLS-1$
		entry.setLargeIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipRoute.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBesiegePortOrder6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.BesiegePortOrder_4005);
		LinkToolEntry entry = new LinkToolEntry(Messages.BesiegePortOrder6CreationTool_title, Messages.BesiegePortOrder6CreationTool_desc, types);
		entry.setSmallIcon(TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.BesiegePortOrder_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEscortShipsOrder7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.EscortShipsOrder_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.EscortShipsOrder7CreationTool_title, Messages.EscortShipsOrder7CreationTool_desc, types);
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
