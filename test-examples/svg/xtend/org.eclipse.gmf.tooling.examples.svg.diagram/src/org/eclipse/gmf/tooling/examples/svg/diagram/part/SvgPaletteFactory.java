package org.eclipse.gmf.tooling.examples.svg.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.examples.svg.diagram.providers.SvgElementTypes;

/**
 * @generated
 */
public class SvgPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createSvg1Group());
	}

	/**
	 * Creates "svg" palette tool group
	 * @generated
	 */
	private PaletteContainer createSvg1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Svg1Group_title);
		paletteContainer.setId("createSvg1Group"); //$NON-NLS-1$
		paletteContainer.add(createPlayer1CreationTool());
		paletteContainer.add(createGoal2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPlayer1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Player1CreationTool_title, Messages.Player1CreationTool_desc, Collections.singletonList(SvgElementTypes.Player_2002));
		entry.setId("createPlayer1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(SvgElementTypes.getImageDescriptor(SvgElementTypes.Player_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGoal2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Goal2CreationTool_title, Messages.Goal2CreationTool_desc, Collections.singletonList(SvgElementTypes.Goal_2001));
		entry.setId("createGoal2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(SvgElementTypes.getImageDescriptor(SvgElementTypes.Goal_2001));
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
