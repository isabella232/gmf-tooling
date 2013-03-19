package org.eclipse.gmf.example.lesscode.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
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
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createSubject1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(5);
		types.add(LesscodeElementTypes.Subject_2001);
		types.add(LesscodeElementTypes.Subject_3001);
		types.add(LesscodeElementTypes.Subject_3002);
		types.add(LesscodeElementTypes.Subject_3003);
		types.add(LesscodeElementTypes.Subject_3004);
		NodeToolEntry entry = new NodeToolEntry(Messages.Subject1CreationTool_title, Messages.Subject1CreationTool_desc, types);
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
}
