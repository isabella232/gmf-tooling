package org.eclipse.gmf.tooling.examples.shortcut.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramLinkEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramNodeEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutDiagramEditorPlugin;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class ShortcutElementTypes {

	/**
	* @generated
	*/
	private ShortcutElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(ShortcutDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Diagram_1000 = getElementType("org.eclipse.gmf.tooling.examples.shortcut.diagram.Diagram_1000"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType DiagramNode_2001 = getElementType("org.eclipse.gmf.tooling.examples.shortcut.diagram.DiagramNode_2001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType DiagramLink_4001 = getElementType("org.eclipse.gmf.tooling.examples.shortcut.diagram.DiagramLink_4001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
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

			elements.put(Diagram_1000, ShortcutPackage.eINSTANCE.getDiagram());

			elements.put(DiagramNode_2001, ShortcutPackage.eINSTANCE.getDiagramNode());

			elements.put(DiagramLink_4001, ShortcutPackage.eINSTANCE.getDiagramLink());
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
			KNOWN_ELEMENT_TYPES.add(Diagram_1000);
			KNOWN_ELEMENT_TYPES.add(DiagramNode_2001);
			KNOWN_ELEMENT_TYPES.add(DiagramLink_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case DiagramEditPart.VISUAL_ID:
			return Diagram_1000;
		case DiagramNodeEditPart.VISUAL_ID:
			return DiagramNode_2001;
		case DiagramLinkEditPart.VISUAL_ID:
			return DiagramLink_4001;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return org.eclipse.gmf.tooling.examples.shortcut.diagram.providers.ShortcutElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.gmf.tooling.examples.shortcut.diagram.providers.ShortcutElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.gmf.tooling.examples.shortcut.diagram.providers.ShortcutElementTypes.getElement(elementTypeAdapter);
		}
	};

}
