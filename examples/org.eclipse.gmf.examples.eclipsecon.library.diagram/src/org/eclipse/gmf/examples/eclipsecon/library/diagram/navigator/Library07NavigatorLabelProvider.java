package org.eclipse.gmf.examples.eclipsecon.library.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.eclipsecon.library.Library;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.AuthorEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.AuthorNameEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.BookEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.EmployeeEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.EmployeeNameEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.EmployeeShelvesEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.LibraryEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.ShelfEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.ShelfNameEditPart;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.part.Library07DiagramEditorPlugin;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.part.Library07VisualIDRegistry;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.providers.Library07ElementTypes;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;

import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;

import org.eclipse.swt.graphics.Image;

import org.eclipse.ui.IMemento;

import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class Library07NavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		Library07DiagramEditorPlugin.getInstance().getImageRegistry().put(
				"Navigator?InvalidElement",
				ImageDescriptor.getMissingImageDescriptor());
		Library07DiagramEditorPlugin.getInstance().getImageRegistry().put(
				"Navigator?UnknownElement",
				ImageDescriptor.getMissingImageDescriptor());
		Library07DiagramEditorPlugin.getInstance().getImageRegistry().put(
				"Navigator?ImageNotFound",
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof Library07NavigatorItem
				&& !isOwnView(((Library07NavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof Library07NavigatorGroup) {
			Library07NavigatorGroup group = (Library07NavigatorGroup) element;
			return Library07DiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof Library07NavigatorItem) {
			Library07NavigatorItem navigatorItem = (Library07NavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (Library07VisualIDRegistry.getVisualID(view)) {
		case AuthorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/eclipse/gmf/examples/library.ecore?Author",
					Library07ElementTypes.Author_1001);
		case ShelfEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/eclipse/gmf/examples/library.ecore?Shelf",
					Library07ElementTypes.Shelf_1002);
		case EmployeeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/eclipse/gmf/examples/library.ecore?Employee",
					Library07ElementTypes.Employee_1003);
		case BookEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/eclipse/gmf/examples/library.ecore?Book",
					Library07ElementTypes.Book_2001);
		case LibraryEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///org/eclipse/gmf/examples/library.ecore?Library",
					Library07ElementTypes.Library_79);
		case EmployeeShelvesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///org/eclipse/gmf/examples/library.ecore?Employee?shelves",
					Library07ElementTypes.EmployeeShelves_3001);
		default:
			return getImage("Navigator?UnknownElement", null);
		}
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = Library07DiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& Library07ElementTypes.isKnownElementType(elementType)) {
			image = Library07ElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound");
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof Library07NavigatorGroup) {
			Library07NavigatorGroup group = (Library07NavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof Library07NavigatorItem) {
			Library07NavigatorItem navigatorItem = (Library07NavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		switch (Library07VisualIDRegistry.getVisualID(view)) {
		case AuthorEditPart.VISUAL_ID:
			return getAuthor_1001Text(view);
		case ShelfEditPart.VISUAL_ID:
			return getShelf_1002Text(view);
		case EmployeeEditPart.VISUAL_ID:
			return getEmployee_1003Text(view);
		case BookEditPart.VISUAL_ID:
			return getBook_2001Text(view);
		case LibraryEditPart.VISUAL_ID:
			return getLibrary_79Text(view);
		case EmployeeShelvesEditPart.VISUAL_ID:
			return getEmployeeShelves_3001Text(view);
		default:
			return getUnknownElementText(view);
		}
	}

	/**
	 * @generated
	 */
	private String getAuthor_1001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return Library07VisualIDRegistry
									.getType(AuthorNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return Library07ElementTypes.Author_1001;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Library07DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getShelf_1002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return Library07VisualIDRegistry
									.getType(ShelfNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return Library07ElementTypes.Shelf_1002;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Library07DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEmployee_1003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return Library07VisualIDRegistry
									.getType(EmployeeNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return Library07ElementTypes.Employee_1003;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Library07DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getBook_2001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return Library07VisualIDRegistry
									.getType(BookEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return Library07ElementTypes.Book_2001;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Library07DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 2001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getLibrary_79Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Library) domainModelElement).getName();
		} else {
			Library07DiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 79);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEmployeeShelves_3001Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">";
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return LibraryEditPart.MODEL_ID.equals(Library07VisualIDRegistry
				.getModelID(view));
	}

}
