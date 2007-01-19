package org.eclipse.gmf.examples.mindmap.rcp.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.providers.MindmapElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class MindmapPaletteFactory {

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
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Nodes1Group_title);
		paletteContainer.setDescription(Messages.Nodes1Group_desc);
		paletteContainer.add(createTopic1CreationTool());
		paletteContainer.add(createThread2CreationTool());
		paletteContainer.add(createThreadItem3CreationTool());
		paletteContainer.add(createResource4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Links2Group_title);
		paletteContainer.setDescription(Messages.Links2Group_desc);
		paletteContainer.add(createDependency1CreationTool());
		paletteContainer.add(createSubtopic2CreationTool());
		paletteContainer.add(createIncludes3CreationTool());
		paletteContainer.add(createExtends4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTopic1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.Topic_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Topic1CreationTool_title,
				Messages.Topic1CreationTool_desc, types);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.Topic_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createThread2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.Thread_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Thread2CreationTool_title,
				Messages.Thread2CreationTool_desc, types);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.Thread_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createThreadItem3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.ThreadItem_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ThreadItem3CreationTool_title,
				Messages.ThreadItem3CreationTool_desc, types);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.ThreadItem_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResource4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.Resource_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Resource4CreationTool_title,
				Messages.Resource4CreationTool_desc, types);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.Resource_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.Relationship_4004);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Dependency1CreationTool_title,
				Messages.Dependency1CreationTool_desc, types);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.Relationship_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubtopic2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.TopicSubtopics_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Subtopic2CreationTool_title,
				Messages.Subtopic2CreationTool_desc, types);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.TopicSubtopics_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createIncludes3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.Relationship_4003);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Includes3CreationTool_title,
				Messages.Includes3CreationTool_desc, types);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.Relationship_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtends4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.Relationship_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Extends4CreationTool_title,
				Messages.Extends4CreationTool_desc, types);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.Relationship_4002));
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
		private NodeToolEntry(String title, String description,
				List elementTypes) {
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
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
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
