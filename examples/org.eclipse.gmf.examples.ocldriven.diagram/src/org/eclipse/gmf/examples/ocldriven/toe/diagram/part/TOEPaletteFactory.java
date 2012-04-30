package org.eclipse.gmf.examples.ocldriven.toe.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class TOEPaletteFactory {

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
		paletteContainer.add(createEmployee1CreationTool());
		paletteContainer.add(createDepartment2CreationTool());
		paletteContainer.add(createProject3CreationTool());
		paletteContainer.add(createManager4CreationTool());
		paletteContainer.add(createManagersLink5CreationTool());
		paletteContainer.add(createContribution6CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createEmployee1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(TOEElementTypes.Employee_2001);
		types.add(TOEElementTypes.Employee_3001);
		NodeToolEntry entry = new NodeToolEntry(Messages.Employee1CreationTool_title, Messages.Employee1CreationTool_desc, types);
		entry.setId("createEmployee1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TOEElementTypes.getImageDescriptor(TOEElementTypes.Employee_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createDepartment2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(TOEElementTypes.Department_2002);
		types.add(TOEElementTypes.Department_3002);
		NodeToolEntry entry = new NodeToolEntry(Messages.Department2CreationTool_title, null, types);
		entry.setId("createDepartment2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TOEElementTypes.getImageDescriptor(TOEElementTypes.Department_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createProject3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Project3CreationTool_title, Messages.Project3CreationTool_desc, Collections.singletonList(TOEElementTypes.Project_2003));
		entry.setId("createProject3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TOEElementTypes.getImageDescriptor(TOEElementTypes.Project_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createManager4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Manager4CreationTool_title, Messages.Manager4CreationTool_desc, Collections.singletonList(TOEElementTypes.Manager_2004));
		entry.setId("createManager4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TOEElementTypes.getImageDescriptor(TOEElementTypes.Manager_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createManagersLink5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(TOEElementTypes.ManagerManagedDepartment_4001);
		types.add(TOEElementTypes.ManagerLeads_4002);
		LinkToolEntry entry = new LinkToolEntry(Messages.ManagersLink5CreationTool_title, Messages.ManagersLink5CreationTool_desc, types);
		entry.setId("createManagersLink5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TOEElementTypes.getImageDescriptor(TOEElementTypes.ManagerManagedDepartment_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createContribution6CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Contribution6CreationTool_title, Messages.Contribution6CreationTool_desc, Collections.singletonList(TOEElementTypes.Contribution_4003));
		entry.setId("createContribution6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TOEElementTypes.getImageDescriptor(TOEElementTypes.Contribution_4003));
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
