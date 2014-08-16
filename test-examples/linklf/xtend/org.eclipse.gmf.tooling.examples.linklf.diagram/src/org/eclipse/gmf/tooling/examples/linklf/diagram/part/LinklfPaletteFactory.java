package org.eclipse.gmf.tooling.examples.linklf.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfElementTypes;

/**
 * @generated
 */
public class LinklfPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createLinklf1Group());
	}

	/**
	 * Creates "linklf" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinklf1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Linklf1Group_title);
		paletteContainer.setId("createLinklf1Group"); //$NON-NLS-1$
		paletteContainer.add(createContainer1CreationTool());
		paletteContainer.add(createRectangle2CreationTool());
		paletteContainer.add(createCircle3CreationTool());
		paletteContainer.add(createRhombus4CreationTool());
		paletteContainer.add(createLink5CreationTool());
		paletteContainer.add(createLabeledLink6CreationTool());
		paletteContainer.add(createPort7CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createContainer1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(LinklfElementTypes.Container_2003);
		types.add(LinklfElementTypes.Container_3002);
		NodeToolEntry entry = new NodeToolEntry(Messages.Container1CreationTool_title, Messages.Container1CreationTool_desc, types);
		entry.setId("createContainer1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LinklfElementTypes.getImageDescriptor(LinklfElementTypes.Container_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRectangle2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(LinklfElementTypes.Rectangle_2002);
		types.add(LinklfElementTypes.Rectangle_3003);
		NodeToolEntry entry = new NodeToolEntry(Messages.Rectangle2CreationTool_title, Messages.Rectangle2CreationTool_desc, types);
		entry.setId("createRectangle2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LinklfElementTypes.getImageDescriptor(LinklfElementTypes.Rectangle_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCircle3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(LinklfElementTypes.Circle_2001);
		types.add(LinklfElementTypes.Circle_3001);
		NodeToolEntry entry = new NodeToolEntry(Messages.Circle3CreationTool_title, Messages.Circle3CreationTool_desc, types);
		entry.setId("createCircle3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LinklfElementTypes.getImageDescriptor(LinklfElementTypes.Circle_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRhombus4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(LinklfElementTypes.Rhombus_3004);
		types.add(LinklfElementTypes.Rhombus_2004);
		NodeToolEntry entry = new NodeToolEntry(Messages.Rhombus4CreationTool_title, Messages.Rhombus4CreationTool_desc, types);
		entry.setId("createRhombus4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LinklfElementTypes.getImageDescriptor(LinklfElementTypes.Rhombus_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLink5CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Link5CreationTool_title, Messages.Link5CreationTool_desc, Collections.singletonList(LinklfElementTypes.Link_4001));
		entry.setId("createLink5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LinklfElementTypes.getImageDescriptor(LinklfElementTypes.Link_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLabeledLink6CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.LabeledLink6CreationTool_title, Messages.LabeledLink6CreationTool_desc, Collections.singletonList(LinklfElementTypes.LabeledLink_4002));
		entry.setId("createLabeledLink6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LinklfElementTypes.getImageDescriptor(LinklfElementTypes.LabeledLink_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPort7CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Port7CreationTool_title, Messages.Port7CreationTool_desc, Collections.singletonList(LinklfElementTypes.Port_3005));
		entry.setId("createPort7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LinklfElementTypes.getImageDescriptor(LinklfElementTypes.Port_3005));
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
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, List<IElementType> elementTypes) {
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
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, List<IElementType> relationshipTypes) {
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
