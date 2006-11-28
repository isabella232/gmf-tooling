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
		PaletteGroup paletteContainer = new PaletteGroup(TaiPanDiagramEditorPlugin.getString("Taipan1Group.title")); //$NON-NLS-1$
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

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Port_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.Port_2001);
		ToolEntry result = new NodeToolEntry(
				TaiPanDiagramEditorPlugin.getString("Port1CreationTool.title"), TaiPanDiagramEditorPlugin.getString("Port1CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShip2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Ship_2002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.Ship_2002);
		ToolEntry result = new NodeToolEntry(
				TaiPanDiagramEditorPlugin.getString("Ship2CreationTool.title"), TaiPanDiagramEditorPlugin.getString("Ship2CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSmallItems3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.SmallItems_3001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.SmallItems_3001);
		ToolEntry result = new NodeToolEntry(
				TaiPanDiagramEditorPlugin.getString("SmallItems3CreationTool.title"), TaiPanDiagramEditorPlugin.getString("SmallItems3CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLargeItem4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.LargeItem_3002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.LargeItem_3002);
		ToolEntry result = new NodeToolEntry(
				TaiPanDiagramEditorPlugin.getString("LargeItem4CreationTool.title"), TaiPanDiagramEditorPlugin.getString("LargeItem4CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEmptyBox5CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.EmptyBox_3003);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(TaiPanElementTypes.EmptyBox_3003);
		ToolEntry result = new NodeToolEntry(
				TaiPanDiagramEditorPlugin.getString("EmptyBox5CreationTool.title"), TaiPanDiagramEditorPlugin.getString("EmptyBox5CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReliableRoute6CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Route_4002);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(TaiPanElementTypes.Route_4002);
		ToolEntry result = new LinkToolEntry(
				TaiPanDiagramEditorPlugin.getString("ReliableRoute6CreationTool.title"), TaiPanDiagramEditorPlugin.getString("ReliableRoute6CreationTool.desc"), smallImage, largeImage, relationshipTypes); //$NON-NLS-1$ $NON-NLS-2$

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUnreliableRoute7CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanElementTypes.getImageDescriptor(TaiPanElementTypes.Route_4003);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(TaiPanElementTypes.Route_4003);
		ToolEntry result = new LinkToolEntry(
				TaiPanDiagramEditorPlugin.getString("UnreliableRoute7CreationTool.title"), TaiPanDiagramEditorPlugin.getString("UnreliableRoute7CreationTool.desc"), smallImage, largeImage, relationshipTypes); //$NON-NLS-1$ $NON-NLS-2$

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShipDestination8CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif"); //$NON-NLS-1$

		largeImage = TaiPanDiagramEditorPlugin.findImageDescriptor("/org.eclipse.gmf.examples.taipan.edit/icons/full/obj16/ShipDestination.gif"); //$NON-NLS-1$

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(TaiPanElementTypes.ShipDestination_4001);
		ToolEntry result = new LinkToolEntry(
				TaiPanDiagramEditorPlugin.getString("ShipDestination8CreationTool.title"), TaiPanDiagramEditorPlugin.getString("ShipDestination8CreationTool.desc"), smallImage, largeImage, relationshipTypes); //$NON-NLS-1$ $NON-NLS-2$

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
