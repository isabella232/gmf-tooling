package borders.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import borders.diagram.providers.BordersElementTypes;

/**
 * @generated
 */
public class BordersPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createBorders1Group());
	}

	/**
	 * Creates "borders" palette tool group
	 * @generated
	 */
	private PaletteContainer createBorders1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Borders1Group_title);
		paletteContainer.setId("createBorders1Group"); //$NON-NLS-1$
		paletteContainer.add(createLineBorder1CreationTool());
		paletteContainer.add(createMarginBorder2CreationTool());
		paletteContainer.add(createCompoundBorder3CreationTool());
		paletteContainer.add(createCustomBorder4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLineBorder1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.LineBorder1CreationTool_title, Messages.LineBorder1CreationTool_desc, Collections.singletonList(BordersElementTypes.LineBorder_2004));
		entry.setId("createLineBorder1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(BordersElementTypes.getImageDescriptor(BordersElementTypes.LineBorder_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMarginBorder2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.MarginBorder2CreationTool_title, Messages.MarginBorder2CreationTool_desc, Collections.singletonList(BordersElementTypes.MarginBorder_2001));
		entry.setId("createMarginBorder2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(BordersElementTypes.getImageDescriptor(BordersElementTypes.MarginBorder_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompoundBorder3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.CompoundBorder3CreationTool_title, Messages.CompoundBorder3CreationTool_desc,
				Collections.singletonList(BordersElementTypes.CompoundBorder_2003));
		entry.setId("createCompoundBorder3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(BordersElementTypes.getImageDescriptor(BordersElementTypes.CompoundBorder_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCustomBorder4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.CustomBorder4CreationTool_title, Messages.CustomBorder4CreationTool_desc, Collections.singletonList(BordersElementTypes.CustomBorder_2002));
		entry.setId("createCustomBorder4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(BordersElementTypes.getImageDescriptor(BordersElementTypes.CustomBorder_2002));
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
