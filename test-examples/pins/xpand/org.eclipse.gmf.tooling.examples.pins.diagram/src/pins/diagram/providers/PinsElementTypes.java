package pins.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import pins.PinsPackage;
import pins.diagram.edit.parts.ColorPinEditPart;
import pins.diagram.edit.parts.CustomPinEditPart;
import pins.diagram.edit.parts.DiagramEditPart;
import pins.diagram.edit.parts.PinsChild2EditPart;
import pins.diagram.edit.parts.PinsChild3EditPart;
import pins.diagram.edit.parts.PinsChildEditPart;
import pins.diagram.edit.parts.VisiblePinEditPart;
import pins.diagram.part.PinsDiagramEditorPlugin;

/**
 * @generated
 */
public class PinsElementTypes {

	/**
	 * @generated
	 */
	private PinsElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(PinsDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Diagram_1000 = getElementType("org.eclipse.gmf.tooling.examples.pins.diagram.Diagram_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CustomPin_2001 = getElementType("org.eclipse.gmf.tooling.examples.pins.diagram.CustomPin_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType VisiblePin_2002 = getElementType("org.eclipse.gmf.tooling.examples.pins.diagram.VisiblePin_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ColorPin_2003 = getElementType("org.eclipse.gmf.tooling.examples.pins.diagram.ColorPin_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PinsChild_3001 = getElementType("org.eclipse.gmf.tooling.examples.pins.diagram.PinsChild_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PinsChild_3002 = getElementType("org.eclipse.gmf.tooling.examples.pins.diagram.PinsChild_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PinsChild_3003 = getElementType("org.eclipse.gmf.tooling.examples.pins.diagram.PinsChild_3003"); //$NON-NLS-1$

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

			elements.put(Diagram_1000, PinsPackage.eINSTANCE.getDiagram());

			elements.put(CustomPin_2001, PinsPackage.eINSTANCE.getCustomPin());

			elements.put(VisiblePin_2002, PinsPackage.eINSTANCE.getVisiblePin());

			elements.put(ColorPin_2003, PinsPackage.eINSTANCE.getColorPin());

			elements.put(PinsChild_3001, PinsPackage.eINSTANCE.getPinsChild());

			elements.put(PinsChild_3002, PinsPackage.eINSTANCE.getPinsChild());

			elements.put(PinsChild_3003, PinsPackage.eINSTANCE.getPinsChild());
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
			KNOWN_ELEMENT_TYPES.add(CustomPin_2001);
			KNOWN_ELEMENT_TYPES.add(VisiblePin_2002);
			KNOWN_ELEMENT_TYPES.add(ColorPin_2003);
			KNOWN_ELEMENT_TYPES.add(PinsChild_3001);
			KNOWN_ELEMENT_TYPES.add(PinsChild_3002);
			KNOWN_ELEMENT_TYPES.add(PinsChild_3003);
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
		case CustomPinEditPart.VISUAL_ID:
			return CustomPin_2001;
		case VisiblePinEditPart.VISUAL_ID:
			return VisiblePin_2002;
		case ColorPinEditPart.VISUAL_ID:
			return ColorPin_2003;
		case PinsChildEditPart.VISUAL_ID:
			return PinsChild_3001;
		case PinsChild2EditPart.VISUAL_ID:
			return PinsChild_3002;
		case PinsChild3EditPart.VISUAL_ID:
			return PinsChild_3003;
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
			return pins.diagram.providers.PinsElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return pins.diagram.providers.PinsElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return pins.diagram.providers.PinsElementTypes.getElement(elementTypeAdapter);
		}
	};

}
