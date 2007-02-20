package org.eclipse.gmf.examples.eclipsecon.library.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.providers.Library07ElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class Library07PaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createLibrary1Group());
	}

	/**
	 * Creates "library" palette tool group
	 * @generated
	 */
	private PaletteContainer createLibrary1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Library07DiagramEditorPlugin.getString("Library1Group.title")); //$NON-NLS-1$
		paletteContainer.add(createAuthor1CreationTool());
		paletteContainer.add(createBook2CreationTool());
		paletteContainer.add(createEmployee3CreationTool());
		paletteContainer.add(createEmployeeShelves4CreationTool());
		paletteContainer.add(createShelf5CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAuthor1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Library07ElementTypes.Author_1001);
		NodeToolEntry entry = new NodeToolEntry(
				Library07DiagramEditorPlugin
						.getString("Author1CreationTool.title"), Library07DiagramEditorPlugin.getString("Author1CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(Library07ElementTypes
				.getImageDescriptor(Library07ElementTypes.Author_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBook2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Library07ElementTypes.Book_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Library07DiagramEditorPlugin
						.getString("Book2CreationTool.title"), Library07DiagramEditorPlugin.getString("Book2CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(Library07ElementTypes
				.getImageDescriptor(Library07ElementTypes.Book_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEmployee3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Library07ElementTypes.Employee_1003);
		NodeToolEntry entry = new NodeToolEntry(
				Library07DiagramEditorPlugin
						.getString("Employee3CreationTool.title"), Library07DiagramEditorPlugin.getString("Employee3CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(Library07ElementTypes
				.getImageDescriptor(Library07ElementTypes.Employee_1003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEmployeeShelves4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Library07ElementTypes.EmployeeShelves_3001);
		LinkToolEntry entry = new LinkToolEntry(
				Library07DiagramEditorPlugin
						.getString("EmployeeShelves4CreationTool.title"), Library07DiagramEditorPlugin.getString("EmployeeShelves4CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry
				.setSmallIcon(Library07ElementTypes
						.getImageDescriptor(Library07ElementTypes.EmployeeShelves_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShelf5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Library07ElementTypes.Shelf_1002);
		NodeToolEntry entry = new NodeToolEntry(
				Library07DiagramEditorPlugin
						.getString("Shelf5CreationTool.title"), Library07DiagramEditorPlugin.getString("Shelf5CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(Library07ElementTypes
				.getImageDescriptor(Library07ElementTypes.Shelf_1002));
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
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
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
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
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
