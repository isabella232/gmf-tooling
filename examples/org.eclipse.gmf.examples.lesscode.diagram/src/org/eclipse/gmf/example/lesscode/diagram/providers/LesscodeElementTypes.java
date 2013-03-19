package org.eclipse.gmf.example.lesscode.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.example.lesscode.LesscodePackage;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.MultiContainmentGroupEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.OneContainmentGroupEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.RootContainerEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject2EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject3EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject4EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject5EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectEditPart;
import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeDiagramEditorPlugin;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class LesscodeElementTypes {

	/**
	* @generated
	*/
	private LesscodeElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static ImageRegistry imageRegistry;

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType RootContainer_1000 = getElementType("org.eclipse.gmf.examples.lesscode.diagram.RootContainer_1000"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Subject_2001 = getElementType("org.eclipse.gmf.examples.lesscode.diagram.Subject_2001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType OneContainmentGroup_2002 = getElementType("org.eclipse.gmf.examples.lesscode.diagram.OneContainmentGroup_2002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType MultiContainmentGroup_2003 = getElementType("org.eclipse.gmf.examples.lesscode.diagram.MultiContainmentGroup_2003"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Subject_3001 = getElementType("org.eclipse.gmf.examples.lesscode.diagram.Subject_3001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Subject_3002 = getElementType("org.eclipse.gmf.examples.lesscode.diagram.Subject_3002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Subject_3003 = getElementType("org.eclipse.gmf.examples.lesscode.diagram.Subject_3003"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Subject_3004 = getElementType("org.eclipse.gmf.examples.lesscode.diagram.Subject_3004"); //$NON-NLS-1$

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
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return LesscodeDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
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
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(RootContainer_1000, LesscodePackage.eINSTANCE.getRootContainer());

			elements.put(Subject_2001, LesscodePackage.eINSTANCE.getSubject());

			elements.put(OneContainmentGroup_2002, LesscodePackage.eINSTANCE.getOneContainmentGroup());

			elements.put(MultiContainmentGroup_2003, LesscodePackage.eINSTANCE.getMultiContainmentGroup());

			elements.put(Subject_3001, LesscodePackage.eINSTANCE.getSubject());

			elements.put(Subject_3002, LesscodePackage.eINSTANCE.getSubject());

			elements.put(Subject_3003, LesscodePackage.eINSTANCE.getSubject());

			elements.put(Subject_3004, LesscodePackage.eINSTANCE.getSubject());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(RootContainer_1000);
			KNOWN_ELEMENT_TYPES.add(Subject_2001);
			KNOWN_ELEMENT_TYPES.add(OneContainmentGroup_2002);
			KNOWN_ELEMENT_TYPES.add(MultiContainmentGroup_2003);
			KNOWN_ELEMENT_TYPES.add(Subject_3001);
			KNOWN_ELEMENT_TYPES.add(Subject_3002);
			KNOWN_ELEMENT_TYPES.add(Subject_3003);
			KNOWN_ELEMENT_TYPES.add(Subject_3004);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case RootContainerEditPart.VISUAL_ID:
			return RootContainer_1000;
		case SubjectEditPart.VISUAL_ID:
			return Subject_2001;
		case OneContainmentGroupEditPart.VISUAL_ID:
			return OneContainmentGroup_2002;
		case MultiContainmentGroupEditPart.VISUAL_ID:
			return MultiContainmentGroup_2003;
		case Subject2EditPart.VISUAL_ID:
			return Subject_3001;
		case Subject3EditPart.VISUAL_ID:
			return Subject_3002;
		case Subject4EditPart.VISUAL_ID:
			return Subject_3003;
		case Subject5EditPart.VISUAL_ID:
			return Subject_3004;
		}
		return null;
	}

}
