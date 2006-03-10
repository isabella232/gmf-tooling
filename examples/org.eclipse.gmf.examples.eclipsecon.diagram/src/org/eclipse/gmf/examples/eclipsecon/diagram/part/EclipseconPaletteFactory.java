package org.eclipse.gmf.examples.eclipsecon.diagram.part;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.palette.PaletteSeparator;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconElementTypes;

import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class EclipseconPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createnodes1Group());
		paletteRoot.add(createlinks2Group());
	}

	/**
	 * @generated
	 */
	private PaletteContainer createnodes1Group() {
		PaletteContainer paletteContainer = createContainer("nodes");
		paletteContainer.add(createPresenter1001CreationTool());
		paletteContainer.add(createTutorial1002CreationTool());
		paletteContainer.add(createSchedule1003CreationTool());
		paletteContainer.add(createTimeSlot1004CreationTool());
		paletteContainer.add(createResource1005CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createlinks2Group() {
		PaletteContainer paletteContainer = createContainer("links");
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createHandout2001CreationTool());
		paletteContainer.add(createAssigntime2002CreationTool());
		paletteContainer.add(createPresenter2003CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPresenter1001CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EclipseconElementTypes
				.getImageDescriptor(EclipseconElementTypes.Presenter_1001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EclipseconElementTypes.Presenter_1001);
		return new ToolEntry("Presenter", "Create new Presenter", smallImage,
				largeImage) {
			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createTutorial1002CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EclipseconElementTypes
				.getImageDescriptor(EclipseconElementTypes.Tutorial_1002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EclipseconElementTypes.Tutorial_1002);
		return new ToolEntry("Tutorial", "Create new Tutorial", smallImage,
				largeImage) {
			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createSchedule1003CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EclipseconElementTypes
				.getImageDescriptor(EclipseconElementTypes.Schedule_1003);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EclipseconElementTypes.Schedule_1003);
		return new ToolEntry("Schedule", "Create new Schedule", smallImage,
				largeImage) {
			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createTimeSlot1004CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EclipseconElementTypes
				.getImageDescriptor(EclipseconElementTypes.TimeSlot_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EclipseconElementTypes.TimeSlot_2001);
		return new ToolEntry("TimeSlot", "Create new TimeSlot", smallImage,
				largeImage) {
			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createResource1005CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EclipseconElementTypes
				.getImageDescriptor(EclipseconElementTypes.Resource_1004);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EclipseconElementTypes.Resource_1004);
		return new ToolEntry("Resource", "Create new resource", smallImage,
				largeImage) {
			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createHandout2001CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EclipseconElementTypes
				.getImageDescriptor(EclipseconElementTypes.Handout_3001);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EclipseconElementTypes.Handout_3001);
		return new ToolEntry("Handout", "Define hand-out material", smallImage,
				largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssigntime2002CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EclipseconElementTypes
				.getImageDescriptor(EclipseconElementTypes.TutorialAssigned_3002);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EclipseconElementTypes.TutorialAssigned_3002);
		return new ToolEntry("Assign time", "Assign time", smallImage,
				largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createPresenter2003CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EclipseconElementTypes
				.getImageDescriptor(EclipseconElementTypes.TutorialPresenters_3003);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EclipseconElementTypes.TutorialPresenters_3003);
		return new ToolEntry("Presenter", "Connect tutorial with presenter",
				smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private PaletteContainer createContainer(String title) {
		return new PaletteDrawer(title);
	}

}
