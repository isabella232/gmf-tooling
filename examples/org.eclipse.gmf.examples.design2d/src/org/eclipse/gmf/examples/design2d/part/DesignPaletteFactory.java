package org.eclipse.gmf.examples.design2d.part;

/*
 *  Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */

/**
 * @generated
 */
public class DesignPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(org.eclipse.gef.palette.PaletteRoot paletteRoot) {
		paletteRoot.add(createPrimaryShapes1Group());
	}

	/**
	 * Creates "Primary Shapes" palette tool group
	 * @generated
	 */
	private org.eclipse.gef.palette.PaletteContainer createPrimaryShapes1Group() {
		org.eclipse.gef.palette.PaletteDrawer paletteContainer = new org.eclipse.gef.palette.PaletteDrawer(org.eclipse.gmf.examples.design2d.part.DesignDiagramEditorPlugin
				.getString("PrimaryShapes1Group.title")); //$NON-NLS-1$
		paletteContainer.add(createSolidRectangle1CreationTool());
		paletteContainer.add(createSolidEllipse2CreationTool());
		paletteContainer.add(createSolidLine3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createSolidRectangle1CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.gmf.examples.design2d.providers.DesignElementTypes.Node_2001);
		types.add(org.eclipse.gmf.examples.design2d.providers.DesignElementTypes.Node_3001);
		NodeToolEntry entry = new NodeToolEntry(
				org.eclipse.gmf.examples.design2d.part.DesignDiagramEditorPlugin.getString("SolidRectangle1CreationTool.title"), org.eclipse.gmf.examples.design2d.part.DesignDiagramEditorPlugin.getString("SolidRectangle1CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.examples.design2d.providers.DesignElementTypes.getImageDescriptor(org.eclipse.gmf.examples.design2d.providers.DesignElementTypes.Node_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createSolidEllipse2CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.gmf.examples.design2d.providers.DesignElementTypes.Node_3002);
		types.add(org.eclipse.gmf.examples.design2d.providers.DesignElementTypes.Node_2002);
		NodeToolEntry entry = new NodeToolEntry(
				org.eclipse.gmf.examples.design2d.part.DesignDiagramEditorPlugin.getString("SolidEllipse2CreationTool.title"), org.eclipse.gmf.examples.design2d.part.DesignDiagramEditorPlugin.getString("SolidEllipse2CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.examples.design2d.providers.DesignElementTypes.getImageDescriptor(org.eclipse.gmf.examples.design2d.providers.DesignElementTypes.Node_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createSolidLine3CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.gmf.examples.design2d.providers.DesignElementTypes.Link_4001);
		LinkToolEntry entry = new LinkToolEntry(
				org.eclipse.gmf.examples.design2d.part.DesignDiagramEditorPlugin.getString("SolidLine3CreationTool.title"), org.eclipse.gmf.examples.design2d.part.DesignDiagramEditorPlugin.getString("SolidLine3CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.examples.design2d.providers.DesignElementTypes.getImageDescriptor(org.eclipse.gmf.examples.design2d.providers.DesignElementTypes.Link_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends org.eclipse.gef.palette.ToolEntry {

		/**
		 * @generated
		 */
		private final java.util.List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, java.util.List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public org.eclipse.gef.Tool createTool() {
			org.eclipse.gef.Tool tool = new org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends org.eclipse.gef.palette.ToolEntry {

		/**
		 * @generated
		 */
		private final java.util.List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, java.util.List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public org.eclipse.gef.Tool createTool() {
			org.eclipse.gef.Tool tool = new org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
