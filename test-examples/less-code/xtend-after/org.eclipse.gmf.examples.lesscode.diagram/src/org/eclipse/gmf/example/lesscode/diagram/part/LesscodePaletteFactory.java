package org.eclipse.gmf.example.lesscode.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class LesscodePaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createDefault1Group());
	}

	/**
	 * Creates "Default" palette tool group
	 * @generated
	 */
	private PaletteContainer createDefault1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Default1Group_title);
		paletteContainer.setId("createDefault1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Default1Group_desc);
		paletteContainer.add(createSubject1CreationTool());
		paletteContainer.add(createOneGroup2CreationTool());
		paletteContainer.add(createMultiGroup3CreationTool());
		paletteContainer.add(createElementBasedredLink4CreationTool());
		paletteContainer.add(createRefBasedgreenLink5CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubject1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Subject1CreationTool_title, Messages.Subject1CreationTool_desc, Collections.singletonList(LesscodeElementTypes.Subject_2001));
		entry.setId("createSubject1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LesscodeElementTypes.getImageDescriptor(LesscodeElementTypes.Subject_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOneGroup2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.OneGroup2CreationTool_title, Messages.OneGroup2CreationTool_desc, Collections.singletonList(LesscodeElementTypes.OneContainmentGroup_2002));
		entry.setId("createOneGroup2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LesscodeElementTypes.getImageDescriptor(LesscodeElementTypes.OneContainmentGroup_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMultiGroup3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.MultiGroup3CreationTool_title, Messages.MultiGroup3CreationTool_desc,
				Collections.singletonList(LesscodeElementTypes.MultiContainmentGroup_2003));
		entry.setId("createMultiGroup3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LesscodeElementTypes.getImageDescriptor(LesscodeElementTypes.MultiContainmentGroup_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createElementBasedredLink4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.ElementBasedredLink4CreationTool_title, Messages.ElementBasedredLink4CreationTool_desc,
				Collections.singletonList(LesscodeElementTypes.ElementBasedLink_4001));
		entry.setId("createElementBasedredLink4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LesscodeElementTypes.getImageDescriptor(LesscodeElementTypes.ElementBasedLink_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRefBasedgreenLink5CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.RefBasedgreenLink5CreationTool_title, Messages.RefBasedgreenLink5CreationTool_desc,
				Collections.singletonList(LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002));
		entry.setId("createRefBasedgreenLink5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(LesscodeElementTypes.getImageDescriptor(LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002));
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
