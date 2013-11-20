package org.eclipse.gmf.tooling.examples.shortcut.diagram.part;

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
import org.eclipse.gmf.tooling.examples.shortcut.diagram.providers.ShortcutElementTypes;

/**
 * @generated
 */
public class ShortcutPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createShortcut1Group());
	}

	/**
	* Creates "shortcut" palette tool group
	* @generated
	*/
	private PaletteContainer createShortcut1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Shortcut1Group_title);
		paletteContainer.setId("createShortcut1Group"); //$NON-NLS-1$
		paletteContainer.add(createDiagramNode1CreationTool());
		paletteContainer.add(createDiagramLink2CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createDiagramNode1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.DiagramNode1CreationTool_title, Messages.DiagramNode1CreationTool_desc, Collections.singletonList(ShortcutElementTypes.DiagramNode_2001));
		entry.setId("createDiagramNode1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ShortcutElementTypes.getImageDescriptor(ShortcutElementTypes.DiagramNode_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createDiagramLink2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.DiagramLink2CreationTool_title, Messages.DiagramLink2CreationTool_desc, Collections.singletonList(ShortcutElementTypes.DiagramLink_4001));
		entry.setId("createDiagramLink2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ShortcutElementTypes.getImageDescriptor(ShortcutElementTypes.DiagramLink_4001));
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
