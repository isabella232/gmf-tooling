package org.eclipse.gmf.examples.mindmap.diagram.part;

import java.util.List;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;
import java.util.ArrayList;

import org.eclipse.gef.palette.PaletteDrawer;

import org.eclipse.gmf.examples.mindmap.diagram.providers.MindmapElementTypes;

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
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteContainer paletteContainer = new PaletteDrawer("Nodes");
		paletteContainer.add(createTopic1CreationTool());
		paletteContainer.add(createThread2CreationTool());
		paletteContainer.add(createThreadItem3CreationTool());
		paletteContainer.add(createResource4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteContainer paletteContainer = new PaletteDrawer("Links");
		paletteContainer.add(createSubtopic1CreationTool());
		paletteContainer.add(createIncludes2CreationTool());
		paletteContainer.add(createExtends3CreationTool());
		paletteContainer.add(createDependency4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTopic1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.Topic_1001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(MindmapElementTypes.Topic_1001);
		ToolEntry result = new NodeToolEntry("Topic", "Create new Topic",
				smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createThread2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.Thread_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(MindmapElementTypes.Thread_2001);
		ToolEntry result = new NodeToolEntry("Thread", "Create new Thread",
				smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createThreadItem3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.ThreadItem_2002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(MindmapElementTypes.ThreadItem_2002);
		ToolEntry result = new NodeToolEntry("ThreadItem",
				"Create new ThreadItem", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResource4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = MindmapDiagramEditorPlugin
				.findImageDescriptor("/org.eclipse.gmf.examples.mindmap.edit/icons/full/obj16/Resource.gif");

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(MindmapElementTypes.Resource_1002);
		ToolEntry result = new NodeToolEntry("Resource", "Create new Resource",
				smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubtopic1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = MindmapDiagramEditorPlugin
				.findImageDescriptor("/org.eclipse.gmf.examples.mindmap.edit/icons/full/obj16/Subtopic.gif");

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(MindmapElementTypes.TopicSubtopics_3001);
		ToolEntry result = new LinkToolEntry("Subtopic", "Create new Subtopic",
				smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createIncludes2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.Relationship_3004);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(MindmapElementTypes.Relationship_3004);
		ToolEntry result = new LinkToolEntry("Includes",
				"Create new Includes Relationship", smallImage, largeImage,
				relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtends3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.Relationship_3002);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(MindmapElementTypes.Relationship_3002);
		ToolEntry result = new LinkToolEntry("Extends",
				"Create new Extends Relationship", smallImage, largeImage,
				relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = MindmapElementTypes
				.getImageDescriptor(MindmapElementTypes.Relationship_3003);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(MindmapElementTypes.Relationship_3003);
		ToolEntry result = new LinkToolEntry("Dependency",
				"Create new Dependency Relationship", smallImage, largeImage,
				relationshipTypes);

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
		private NodeToolEntry(String title, String description,
				ImageDescriptor smallIcon, ImageDescriptor largeIcon,
				List elementTypes) {
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
		private LinkToolEntry(String title, String description,
				ImageDescriptor smallIcon, ImageDescriptor largeIcon,
				List relationshipTypes) {
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
