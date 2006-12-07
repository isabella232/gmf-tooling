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
import org.eclipse.jface.resource.ImageDescriptor;

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
		PaletteGroup paletteContainer = new PaletteGroup(TaiPanDiagramEditorPlugin
				.getString("Taipan1Group.title")); //$NON-NLS-1$
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
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Port_2001);
		NodeToolEntry entry = new NodeToolEntry(
				TaiPanDiagramEditorPlugin.getString("Port1CreationTool.title"), TaiPanDiagramEditorPlugin.getString("Port1CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(TaiPanElementTypes
				.getImageDescriptor(TaiPanElementTypes.Port_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShip2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Ship_2002);
		NodeToolEntry entry = new NodeToolEntry(
				TaiPanDiagramEditorPlugin.getString("Ship2CreationTool.title"), TaiPanDiagramEditorPlugin.getString("Ship2CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(TaiPanElementTypes
				.getImageDescriptor(TaiPanElementTypes.Ship_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSmallItems3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.SmallItems_3001);
		NodeToolEntry entry = new NodeToolEntry(
				TaiPanDiagramEditorPlugin.getString("SmallItems3CreationTool.title"), TaiPanDiagramEditorPlugin.getString("SmallItems3CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(TaiPanElementTypes
				.getImageDescriptor(TaiPanElementTypes.SmallItems_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLargeItem4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.LargeItem_3002);
		NodeToolEntry entry = new NodeToolEntry(
				TaiPanDiagramEditorPlugin.getString("LargeItem4CreationTool.title"), TaiPanDiagramEditorPlugin.getString("LargeItem4CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(TaiPanElementTypes
				.getImageDescriptor(TaiPanElementTypes.LargeItem_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEmptyBox5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.EmptyBox_3003);
		NodeToolEntry entry = new NodeToolEntry(
				TaiPanDiagramEditorPlugin.getString("EmptyBox5CreationTool.title"), TaiPanDiagramEditorPlugin.getString("EmptyBox5CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(TaiPanElementTypes
				.getImageDescriptor(TaiPanElementTypes.EmptyBox_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReliableRoute6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Route_4002);
		LinkToolEntry entry = new LinkToolEntry(
				TaiPanDiagramEditorPlugin.getString("ReliableRoute6CreationTool.title"), TaiPanDiagramEditorPlugin.getString("ReliableRoute6CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(TaiPanElementTypes
				.getImageDescriptor(TaiPanElementTypes.Route_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUnreliableRoute7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.Route_4003);
		LinkToolEntry entry = new LinkToolEntry(
				TaiPanDiagramEditorPlugin.getString("UnreliableRoute7CreationTool.title"), TaiPanDiagramEditorPlugin.getString("UnreliableRoute7CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(TaiPanElementTypes
				.getImageDescriptor(TaiPanElementTypes.Route_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShipDestination8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(TaiPanElementTypes.ShipDestination_4001);
		LinkToolEntry entry = new LinkToolEntry(
				TaiPanDiagramEditorPlugin.getString("ShipDestination8CreationTool.title"), TaiPanDiagramEditorPlugin.getString("ShipDestination8CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif")); //$NON-NLS-1$
		entry.setLargeIcon(TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif")); //$NON-NLS-1$
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
