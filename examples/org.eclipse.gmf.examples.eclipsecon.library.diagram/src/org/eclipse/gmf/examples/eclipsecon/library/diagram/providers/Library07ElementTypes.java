package org.eclipse.gmf.examples.eclipsecon.library.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.part.Library07DiagramEditorPlugin;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class Library07ElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private Library07ElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return Library07DiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(Library_79, LibraryPackage.eINSTANCE.getLibrary());

			elements.put(Author_1001, LibraryPackage.eINSTANCE.getAuthor());

			elements.put(Shelf_1002, LibraryPackage.eINSTANCE.getShelf());

			elements.put(Employee_1003, LibraryPackage.eINSTANCE.getEmployee());

			elements.put(Book_2001, LibraryPackage.eINSTANCE.getBook());

			elements.put(EmployeeShelves_3001, LibraryPackage.eINSTANCE
					.getEmployee_Shelves());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	public static final IElementType Library_79 = getElementType("org.eclipse.gmf.examples.eclipsecon.library.diagram.Library_79"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Author_1001 = getElementType("org.eclipse.gmf.examples.eclipsecon.library.diagram.Author_1001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Shelf_1002 = getElementType("org.eclipse.gmf.examples.eclipsecon.library.diagram.Shelf_1002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Employee_1003 = getElementType("org.eclipse.gmf.examples.eclipsecon.library.diagram.Employee_1003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Book_2001 = getElementType("org.eclipse.gmf.examples.eclipsecon.library.diagram.Book_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EmployeeShelves_3001 = getElementType("org.eclipse.gmf.examples.eclipsecon.library.diagram.EmployeeShelves_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Library_79);
			KNOWN_ELEMENT_TYPES.add(Author_1001);
			KNOWN_ELEMENT_TYPES.add(Shelf_1002);
			KNOWN_ELEMENT_TYPES.add(Employee_1003);
			KNOWN_ELEMENT_TYPES.add(Book_2001);
			KNOWN_ELEMENT_TYPES.add(EmployeeShelves_3001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}
}
