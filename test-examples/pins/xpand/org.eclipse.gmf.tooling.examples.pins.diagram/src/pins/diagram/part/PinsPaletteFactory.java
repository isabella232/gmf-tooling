package pins.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import pins.diagram.providers.PinsElementTypes;

/**
 * @generated
 */
public class PinsPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createPins1Group());
	}

	/**
	 * Creates "pins" palette tool group
	 * @generated
	 */
	private PaletteContainer createPins1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Pins1Group_title);
		paletteContainer.setId("createPins1Group"); //$NON-NLS-1$
		paletteContainer.add(createColorPin1CreationTool());
		paletteContainer.add(createCustomPin2CreationTool());
		paletteContainer.add(createVisiblePin3CreationTool());
		paletteContainer.add(createPinsChild4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createColorPin1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.ColorPin1CreationTool_title, Messages.ColorPin1CreationTool_desc, Collections.singletonList(PinsElementTypes.ColorPin_2003));
		entry.setId("createColorPin1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PinsElementTypes.getImageDescriptor(PinsElementTypes.ColorPin_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCustomPin2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.CustomPin2CreationTool_title, Messages.CustomPin2CreationTool_desc, Collections.singletonList(PinsElementTypes.CustomPin_2001));
		entry.setId("createCustomPin2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PinsElementTypes.getImageDescriptor(PinsElementTypes.CustomPin_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVisiblePin3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.VisiblePin3CreationTool_title, Messages.VisiblePin3CreationTool_desc, Collections.singletonList(PinsElementTypes.VisiblePin_2002));
		entry.setId("createVisiblePin3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PinsElementTypes.getImageDescriptor(PinsElementTypes.VisiblePin_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPinsChild4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(PinsElementTypes.PinsChild_3001);
		types.add(PinsElementTypes.PinsChild_3002);
		types.add(PinsElementTypes.PinsChild_3003);
		NodeToolEntry entry = new NodeToolEntry(Messages.PinsChild4CreationTool_title, Messages.PinsChild4CreationTool_desc, types);
		entry.setId("createPinsChild4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PinsElementTypes.getImageDescriptor(PinsElementTypes.PinsChild_3001));
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
