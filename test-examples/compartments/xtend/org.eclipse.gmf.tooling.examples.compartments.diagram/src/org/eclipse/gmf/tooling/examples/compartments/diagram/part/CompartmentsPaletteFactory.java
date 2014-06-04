package org.eclipse.gmf.tooling.examples.compartments.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

/**
 * @generated
 */
public class CompartmentsPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createAcs1Group());
	}

	/**
	 * Creates "acs" palette tool group
	 * @generated
	 */
	private PaletteContainer createAcs1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Acs1Group_title);
		paletteContainer.setId("createAcs1Group"); //$NON-NLS-1$
		paletteContainer.add(createTopNodeA1CreationTool());
		paletteContainer.add(createTopNodeB2CreationTool());
		paletteContainer.add(createChildNodeB_E3CreationTool());
		paletteContainer.add(createChildNodeA_C4CreationTool());
		paletteContainer.add(createChildNodeB_G5CreationTool());
		paletteContainer.add(createLinkEtoC6CreationTool());
		paletteContainer.add(createChildNodeB_F7CreationTool());
		paletteContainer.add(createLinkFtoD8CreationTool());
		paletteContainer.add(createChildNodeA_D9CreationTool());
		paletteContainer.add(createChildOfAffixedNode10CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTopNodeA1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.TopNodeA1CreationTool_title, Messages.TopNodeA1CreationTool_desc,
				Collections.singletonList(CompartmentsElementTypes.TopNodeA_2001));
		entry.setId("createTopNodeA1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CompartmentsElementTypes.getImageDescriptor(CompartmentsElementTypes.TopNodeA_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTopNodeB2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.TopNodeB2CreationTool_title, Messages.TopNodeB2CreationTool_desc,
				Collections.singletonList(CompartmentsElementTypes.TopNodeB_2002));
		entry.setId("createTopNodeB2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CompartmentsElementTypes.getImageDescriptor(CompartmentsElementTypes.TopNodeB_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChildNodeB_E3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ChildNodeB_E3CreationTool_title, Messages.ChildNodeB_E3CreationTool_desc,
				Collections.singletonList(CompartmentsElementTypes.ChildOfB_E_3003));
		entry.setId("createChildNodeB_E3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CompartmentsElementTypes.getImageDescriptor(CompartmentsElementTypes.ChildOfB_E_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChildNodeA_C4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ChildNodeA_C4CreationTool_title, Messages.ChildNodeA_C4CreationTool_desc,
				Collections.singletonList(CompartmentsElementTypes.ChildOfA_C_3001));
		entry.setId("createChildNodeA_C4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CompartmentsElementTypes.getImageDescriptor(CompartmentsElementTypes.ChildOfA_C_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChildNodeB_G5CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ChildNodeB_G5CreationTool_title, Messages.ChildNodeB_G5CreationTool_desc,
				Collections.singletonList(CompartmentsElementTypes.ChildOfB_G_3004));
		entry.setId("createChildNodeB_G5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CompartmentsElementTypes.getImageDescriptor(CompartmentsElementTypes.ChildOfB_G_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLinkEtoC6CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.LinkEtoC6CreationTool_title, Messages.LinkEtoC6CreationTool_desc,
				Collections.singletonList(CompartmentsElementTypes.ChildOfB_ECNodeRelation_4001));
		entry.setId("createLinkEtoC6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CompartmentsElementTypes.getImageDescriptor(CompartmentsElementTypes.ChildOfB_ECNodeRelation_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChildNodeB_F7CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ChildNodeB_F7CreationTool_title, Messages.ChildNodeB_F7CreationTool_desc,
				Collections.singletonList(CompartmentsElementTypes.ChildOfB_F_3006));
		entry.setId("createChildNodeB_F7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CompartmentsElementTypes.getImageDescriptor(CompartmentsElementTypes.ChildOfB_F_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLinkFtoD8CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.LinkFtoD8CreationTool_title, Messages.LinkFtoD8CreationTool_desc,
				Collections.singletonList(CompartmentsElementTypes.ChildOfB_FDNodeRelation_4002));
		entry.setId("createLinkFtoD8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CompartmentsElementTypes.getImageDescriptor(CompartmentsElementTypes.ChildOfB_FDNodeRelation_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChildNodeA_D9CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ChildNodeA_D9CreationTool_title, Messages.ChildNodeA_D9CreationTool_desc,
				Collections.singletonList(CompartmentsElementTypes.ChildOfA_D_3002));
		entry.setId("createChildNodeA_D9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CompartmentsElementTypes.getImageDescriptor(CompartmentsElementTypes.ChildOfA_D_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChildOfAffixedNode10CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ChildOfAffixedNode10CreationTool_title, Messages.ChildOfAffixedNode10CreationTool_desc,
				Collections.singletonList(CompartmentsElementTypes.ChildOfAffixed_3005));
		entry.setId("createChildOfAffixedNode10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CompartmentsElementTypes.getImageDescriptor(CompartmentsElementTypes.ChildOfAffixed_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
