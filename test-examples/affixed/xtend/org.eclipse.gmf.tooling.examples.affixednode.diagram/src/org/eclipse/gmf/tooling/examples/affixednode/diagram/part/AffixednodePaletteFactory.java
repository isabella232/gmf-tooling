package org.eclipse.gmf.tooling.examples.affixednode.diagram.part;

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
import org.eclipse.gmf.tooling.examples.affixednode.diagram.providers.AffixednodeElementTypes;

/**
 * @generated
 */
public class AffixednodePaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createAffixednode1Group());
	}

	/**
	 * Creates "affixednode" palette tool group
	 * @generated
	 */
	private PaletteContainer createAffixednode1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Affixednode1Group_title);
		paletteContainer.setId("createAffixednode1Group"); //$NON-NLS-1$
		paletteContainer.add(createIncomingCommunicator1CreationTool());
		paletteContainer.add(createOutcomingCommunicator2CreationTool());
		paletteContainer.add(createBundle3CreationTool());
		paletteContainer.add(createCommunication4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createIncomingCommunicator1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.IncomingCommunicator1CreationTool_title, Messages.IncomingCommunicator1CreationTool_desc,
				Collections.singletonList(AffixednodeElementTypes.IncomingCommunicator_3001));
		entry.setId("createIncomingCommunicator1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AffixednodeElementTypes.getImageDescriptor(AffixednodeElementTypes.IncomingCommunicator_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOutcomingCommunicator2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.OutcomingCommunicator2CreationTool_title, Messages.OutcomingCommunicator2CreationTool_desc,
				Collections.singletonList(AffixednodeElementTypes.OutcomingCommunicator_3002));
		entry.setId("createOutcomingCommunicator2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AffixednodeElementTypes.getImageDescriptor(AffixednodeElementTypes.OutcomingCommunicator_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBundle3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Bundle3CreationTool_title, Messages.Bundle3CreationTool_desc, Collections.singletonList(AffixednodeElementTypes.Bundle_2001));
		entry.setId("createBundle3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AffixednodeElementTypes.getImageDescriptor(AffixednodeElementTypes.Bundle_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCommunication4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Communication4CreationTool_title, Messages.Communication4CreationTool_desc,
				Collections.singletonList(AffixednodeElementTypes.Communication_4001));
		entry.setId("createCommunication4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AffixednodeElementTypes.getImageDescriptor(AffixednodeElementTypes.Communication_4001));
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
