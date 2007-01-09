/*
 * 
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Richard Gronback (Borland) - initial API and implementation
 
 */
package org.eclipse.gmf.examples.mindmap.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
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
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(MindmapDiagramEditorPlugin.getString("Nodes1Group.title")); //$NON-NLS-1$
		paletteContainer.setDescription(MindmapDiagramEditorPlugin.getString("Nodes1Group.desc")); //$NON-NLS-1$
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
		PaletteDrawer paletteContainer = new PaletteDrawer(MindmapDiagramEditorPlugin.getString("Links2Group.title")); //$NON-NLS-1$
		paletteContainer.setDescription(MindmapDiagramEditorPlugin.getString("Links2Group.desc")); //$NON-NLS-1$
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
		types.add(MindmapElementTypes.Topic_1001);
		NodeToolEntry entry = new NodeToolEntry(MindmapDiagramEditorPlugin.getString("Topic1CreationTool.title"), MindmapDiagramEditorPlugin.getString("Topic1CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(MindmapElementTypes.getImageDescriptor(MindmapElementTypes.Topic_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createThread2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.Thread_2001);
		NodeToolEntry entry = new NodeToolEntry(MindmapDiagramEditorPlugin.getString("Thread2CreationTool.title"), MindmapDiagramEditorPlugin.getString("Thread2CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(MindmapElementTypes.getImageDescriptor(MindmapElementTypes.Thread_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createThreadItem3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.ThreadItem_2002);
		NodeToolEntry entry = new NodeToolEntry(MindmapDiagramEditorPlugin.getString("ThreadItem3CreationTool.title"), MindmapDiagramEditorPlugin.getString("ThreadItem3CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(MindmapElementTypes.getImageDescriptor(MindmapElementTypes.ThreadItem_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResource4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.Resource_1002);
		NodeToolEntry entry = new NodeToolEntry(MindmapDiagramEditorPlugin.getString("Resource4CreationTool.title"), MindmapDiagramEditorPlugin.getString("Resource4CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(MindmapElementTypes.getImageDescriptor(MindmapElementTypes.Resource_1002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.Relationship_3004);
		LinkToolEntry entry = new LinkToolEntry(MindmapDiagramEditorPlugin.getString("Dependency1CreationTool.title"), MindmapDiagramEditorPlugin.getString("Dependency1CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(MindmapElementTypes.getImageDescriptor(MindmapElementTypes.Relationship_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubtopic2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.TopicSubtopics_3001);
		LinkToolEntry entry = new LinkToolEntry(MindmapDiagramEditorPlugin.getString("Subtopic2CreationTool.title"), MindmapDiagramEditorPlugin.getString("Subtopic2CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(MindmapElementTypes.getImageDescriptor(MindmapElementTypes.TopicSubtopics_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createIncludes3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.Relationship_3003);
		LinkToolEntry entry = new LinkToolEntry(MindmapDiagramEditorPlugin.getString("Includes3CreationTool.title"), MindmapDiagramEditorPlugin.getString("Includes3CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(MindmapElementTypes.getImageDescriptor(MindmapElementTypes.Relationship_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtends4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MindmapElementTypes.Relationship_3002);
		LinkToolEntry entry = new LinkToolEntry(MindmapDiagramEditorPlugin.getString("Extends4CreationTool.title"), MindmapDiagramEditorPlugin.getString("Extends4CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(MindmapElementTypes.getImageDescriptor(MindmapElementTypes.Relationship_3002));
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
