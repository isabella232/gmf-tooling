package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part;

import org.eclipse.emf.common.notify.AdapterFactory;

import org.eclipse.emf.edit.provider.IItemLabelProvider;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;

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

import org.eclipse.gmf.examples.mindmap.MindmapFactory;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.TopicSubtopicsEditPart;

import org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx;
import org.eclipse.gmf.runtime.lite.requests.CreateRequestEx;
import org.eclipse.gmf.runtime.lite.requests.ModelCreationFactory;

import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @generated
 */
public class MindmapPaletteFactory {
	/**
	 * @generated
	 */
	private final AdapterFactory domainAdapterFactory;

	/**
	 * @generated
	 */
	public MindmapPaletteFactory(AdapterFactory domainAdapterFactory) {
		this.domainAdapterFactory = domainAdapterFactory;
	}

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
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteContainer paletteContainer = new PaletteDrawer("Nodes");
		paletteContainer.setDescription("");
		PaletteEntry paletteEntry = createTopic1CreationTool();
		if (paletteEntry != null) {
			paletteContainer.add(paletteEntry);
		}
		paletteEntry = createThread2CreationTool();
		if (paletteEntry != null) {
			paletteContainer.add(paletteEntry);
		}
		paletteEntry = createThreadItem3CreationTool();
		if (paletteEntry != null) {
			paletteContainer.add(paletteEntry);
		}
		paletteEntry = createResource4CreationTool();
		if (paletteEntry != null) {
			paletteContainer.add(paletteEntry);
		}
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteContainer paletteContainer = new PaletteDrawer("Links");
		paletteContainer.setDescription("");
		PaletteEntry paletteEntry = createDependency1CreationTool();
		if (paletteEntry != null) {
			paletteContainer.add(paletteEntry);
		}
		paletteEntry = createSubtopic2CreationTool();
		if (paletteEntry != null) {
			paletteContainer.add(paletteEntry);
		}
		paletteEntry = createIncludes3CreationTool();
		if (paletteEntry != null) {
			paletteContainer.add(paletteEntry);
		}
		paletteEntry = createExtends4CreationTool();
		if (paletteEntry != null) {
			paletteContainer.add(paletteEntry);
		}
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTopic1CreationTool() {

		ImageDescriptor smallImage = getImageDescriptor(MindmapFactory.eINSTANCE
				.createTopic());

		ImageDescriptor largeImage = smallImage;

		final int[] visualIds = new int[] { TopicEditPart.VISUAL_ID };
		ToolEntry result = new NodeToolEntry("Topic", "Create new Topic",
				smallImage, largeImage, visualIds);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createThread2CreationTool() {

		ImageDescriptor smallImage = getImageDescriptor(MindmapFactory.eINSTANCE
				.createThread());

		ImageDescriptor largeImage = smallImage;

		final int[] visualIds = new int[] { ThreadEditPart.VISUAL_ID };
		ToolEntry result = new NodeToolEntry("Thread", "Create new Thread",
				smallImage, largeImage, visualIds);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createThreadItem3CreationTool() {

		ImageDescriptor smallImage = getImageDescriptor(MindmapFactory.eINSTANCE
				.createThreadItem());

		ImageDescriptor largeImage = smallImage;

		final int[] visualIds = new int[] { ThreadItemEditPart.VISUAL_ID };
		ToolEntry result = new NodeToolEntry("ThreadItem",
				"Create new Thread Item", smallImage, largeImage, visualIds);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResource4CreationTool() {

		ImageDescriptor smallImage = getImageDescriptor(MindmapFactory.eINSTANCE
				.createResource());

		ImageDescriptor largeImage = smallImage;

		final int[] visualIds = new int[] { ResourceEditPart.VISUAL_ID };
		ToolEntry result = new NodeToolEntry("Resource", "Create new Resource",
				smallImage, largeImage, visualIds);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency1CreationTool() {

		ImageDescriptor smallImage = getImageDescriptor(MindmapFactory.eINSTANCE
				.createRelationship());

		ImageDescriptor largeImage = smallImage;

		final int[] visualIds = new int[] { Relationship3EditPart.VISUAL_ID };
		ToolEntry result = new LinkToolEntry("Dependency",
				"Create new Dependency", smallImage, largeImage, visualIds);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubtopic2CreationTool() {

		ImageDescriptor smallImage = null;

		ImageDescriptor largeImage = smallImage;

		final int[] visualIds = new int[] { TopicSubtopicsEditPart.VISUAL_ID };
		ToolEntry result = new LinkToolEntry("Subtopic", "Create new Subtopic",
				smallImage, largeImage, visualIds);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createIncludes3CreationTool() {

		ImageDescriptor smallImage = getImageDescriptor(MindmapFactory.eINSTANCE
				.createRelationship());

		ImageDescriptor largeImage = smallImage;

		final int[] visualIds = new int[] { Relationship2EditPart.VISUAL_ID };
		ToolEntry result = new LinkToolEntry("Includes", "Create new Includes",
				smallImage, largeImage, visualIds);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtends4CreationTool() {

		ImageDescriptor smallImage = getImageDescriptor(MindmapFactory.eINSTANCE
				.createRelationship());

		ImageDescriptor largeImage = smallImage;

		final int[] visualIds = new int[] { RelationshipEditPart.VISUAL_ID };
		ToolEntry result = new LinkToolEntry("Extends", "Create new Extends",
				smallImage, largeImage, visualIds);

		return result;
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
		private NodeToolEntry(String title, String description,
				ImageDescriptor smallIcon, ImageDescriptor largeIcon,
				int[] visualIDs) {
			super(title, description, new ModelCreationFactory(Node.class),
					smallIcon, largeIcon);
			myVisualIDs = visualIDs;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool result = new CreationTool() {
				protected Request createTargetRequest() {
					CreateRequestEx request = new CreateRequestEx(myVisualIDs);
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
		private LinkToolEntry(String title, String description,
				ImageDescriptor smallIcon, ImageDescriptor largeIcon,
				int[] visualIDs) {
			super(title, description, new ModelCreationFactory(Edge.class),
					smallIcon, largeIcon);
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
							myVisualIDs);
					request.setFactory(getFactory());
					return request;
				}
			};
			result.setProperties(getToolProperties());
			return result;
		}
	}

	/**
	 * @generated
	 */
	private ImageDescriptor getImageDescriptor(Object o) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) domainAdapterFactory
				.adapt(o, IItemLabelProvider.class);
		if (labelProvider != null) {
			return ExtendedImageRegistry.getInstance().getImageDescriptor(
					labelProvider.getImage(o));
		}
		return null;
	}
}
