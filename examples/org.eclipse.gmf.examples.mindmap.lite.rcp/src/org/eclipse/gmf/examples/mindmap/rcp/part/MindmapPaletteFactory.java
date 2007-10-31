/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.mindmap.rcp.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.ConnectionCreationTool;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.TopicSubtopicsEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.providers.MindmapElementTypes;
import org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx;
import org.eclipse.gmf.runtime.lite.requests.CreateRequestEx;
import org.eclipse.gmf.runtime.lite.requests.ModelCreationFactory;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * @generated
 */
public class MindmapPaletteFactory {
	/**
	 * @generated
	 */
	public void contributeToPalette(PaletteRoot paletteRoot) {
		PaletteGroup controls = new PaletteGroup("Controls");
		paletteRoot.add(controls);

		ToolEntry tool = new SelectionToolEntry();
		controls.add(tool);
		paletteRoot.setDefaultEntry(tool);

		controls.add(new MarqueeToolEntry());
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
		{
			PaletteEntry paletteEntry = createTopic1CreationTool();
			if (paletteEntry != null) {
				paletteContainer.add(paletteEntry);
			}
		}
		{
			PaletteEntry paletteEntry = createThread2CreationTool();
			if (paletteEntry != null) {
				paletteContainer.add(paletteEntry);
			}
		}
		{
			PaletteEntry paletteEntry = createThreadItem3CreationTool();
			if (paletteEntry != null) {
				paletteContainer.add(paletteEntry);
			}
		}
		{
			PaletteEntry paletteEntry = createResource4CreationTool();
			if (paletteEntry != null) {
				paletteContainer.add(paletteEntry);
			}
		}
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Links2Group_title);
		{
			PaletteEntry paletteEntry = createSubtopic1CreationTool();
			if (paletteEntry != null) {
				paletteContainer.add(paletteEntry);
			}
		}
		{
			PaletteEntry paletteEntry = createDependency2CreationTool();
			if (paletteEntry != null) {
				paletteContainer.add(paletteEntry);
			}
		}
		{
			PaletteEntry paletteEntry = createIncludes3CreationTool();
			if (paletteEntry != null) {
				paletteContainer.add(paletteEntry);
			}
		}
		{
			PaletteEntry paletteEntry = createExtends4CreationTool();
			if (paletteEntry != null) {
				paletteContainer.add(paletteEntry);
			}
		}
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTopic1CreationTool() {
		final int[] visualIds = new int[] { TopicEditPart.VISUAL_ID };
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Topic1CreationTool_title,
				Messages.Topic1CreationTool_desc, visualIds);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapPackage.eINSTANCE.getTopic()));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createThread2CreationTool() {
		final int[] visualIds = new int[] { ThreadEditPart.VISUAL_ID };
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Thread2CreationTool_title,
				Messages.Thread2CreationTool_desc, visualIds);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapPackage.eINSTANCE.getThread()));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createThreadItem3CreationTool() {
		final int[] visualIds = new int[] { ThreadItemEditPart.VISUAL_ID };
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ThreadItem3CreationTool_title,
				Messages.ThreadItem3CreationTool_desc, visualIds);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapPackage.eINSTANCE.getThreadItem()));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResource4CreationTool() {
		final int[] visualIds = new int[] { ResourceEditPart.VISUAL_ID };
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Resource4CreationTool_title,
				Messages.Resource4CreationTool_desc, visualIds);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapPackage.eINSTANCE.getResource()));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubtopic1CreationTool() {
		final int[] visualIds = new int[] { TopicSubtopicsEditPart.VISUAL_ID };
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Subtopic1CreationTool_title,
				Messages.Subtopic1CreationTool_desc, visualIds);
		entry.setSmallIcon(MindmapElementTypes
				.getImageDescriptor(MindmapPackage.eINSTANCE
						.getTopic_Subtopics()));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency2CreationTool() {
		final int[] visualIds = new int[] { Relationship3EditPart.VISUAL_ID };
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Dependency2CreationTool_title,
				Messages.Dependency2CreationTool_desc, visualIds);
		entry
				.setSmallIcon(MindmapElementTypes
						.getImageDescriptor(MindmapPackage.eINSTANCE
								.getRelationship()));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createIncludes3CreationTool() {
		final int[] visualIds = new int[] { Relationship2EditPart.VISUAL_ID };
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Includes3CreationTool_title,
				Messages.Includes3CreationTool_desc, visualIds);
		entry
				.setSmallIcon(MindmapElementTypes
						.getImageDescriptor(MindmapPackage.eINSTANCE
								.getRelationship()));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtends4CreationTool() {
		final int[] visualIds = new int[] { RelationshipEditPart.VISUAL_ID };
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Extends4CreationTool_title,
				Messages.Extends4CreationTool_desc, visualIds);
		entry
				.setSmallIcon(MindmapElementTypes
						.getImageDescriptor(MindmapPackage.eINSTANCE
								.getRelationship()));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends CombinedTemplateCreationEntry {
		/**
		 * @generated
		 */
		private final int[] myVisualIDs;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, int[] visualIDs) {
			super(title, description, new ModelCreationFactory(Node.class),
					null, null);
			myVisualIDs = visualIDs;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool result = new CreationTool() {
				protected Request createTargetRequest() {
					CreateRequestEx request = new CreateRequestEx(
							MapEditPart.MODEL_ID, myVisualIDs);
					request.setFactory(getFactory());
					return request;
				}

				protected void performCreation(int button) {
					super.performCreation(button);
					final EditPart createdEditPart = (EditPart) getCurrentViewer()
							.getEditPartRegistry().get(
									getCreateRequest().getNewObject());
					if (createdEditPart != null) {
						getCurrentViewer().getControl().getDisplay().asyncExec(
								new Runnable() {
									public void run() {
										if (createdEditPart.isActive()) {
											createdEditPart
													.performRequest(new Request(
															RequestConstants.REQ_DIRECT_EDIT));
										}
									}
								});
					}
				}
			};
			result.setProperties(getToolProperties());
			return result;
		}

	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ConnectionCreationToolEntry {
		/**
		 * @generated
		 */
		private final int[] myVisualIDs;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, int[] visualIDs) {
			super(title, description, new ModelCreationFactory(Edge.class),
					null, null);
			myVisualIDs = visualIDs;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool result = new ConnectionCreationTool() {
				{
					setUnloadWhenFinished(true);
				}

				protected Request createTargetRequest() {
					CreateConnectionRequestEx request = new CreateConnectionRequestEx(
							MapEditPart.MODEL_ID, myVisualIDs);
					request.setFactory(getFactory());
					return request;
				}
			};
			result.setProperties(getToolProperties());
			return result;
		}

	}
}
