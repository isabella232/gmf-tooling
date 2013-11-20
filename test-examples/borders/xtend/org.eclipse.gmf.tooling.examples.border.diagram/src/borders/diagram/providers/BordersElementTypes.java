package borders.diagram.providers;

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

import borders.BordersPackage;
import borders.diagram.edit.parts.CompoundBorderEditPart;
import borders.diagram.edit.parts.CustomBorderEditPart;
import borders.diagram.edit.parts.DiagramEditPart;
import borders.diagram.edit.parts.LineBorderEditPart;
import borders.diagram.edit.parts.MarginBorderEditPart;
import borders.diagram.part.BordersDiagramEditorPlugin;

/**
 * @generated
 */
public class BordersElementTypes {

	/**
	 * @generated
	 */
	private BordersElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(BordersDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Diagram_1000 = getElementType("org.eclipse.gmf.tooling.examples.border.diagram.Diagram_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MarginBorder_2001 = getElementType("org.eclipse.gmf.tooling.examples.border.diagram.MarginBorder_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CustomBorder_2002 = getElementType("org.eclipse.gmf.tooling.examples.border.diagram.CustomBorder_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CompoundBorder_2003 = getElementType("org.eclipse.gmf.tooling.examples.border.diagram.CompoundBorder_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LineBorder_2004 = getElementType("org.eclipse.gmf.tooling.examples.border.diagram.LineBorder_2004"); //$NON-NLS-1$

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

			elements.put(Diagram_1000, BordersPackage.eINSTANCE.getDiagram());

			elements.put(MarginBorder_2001, BordersPackage.eINSTANCE.getMarginBorder());

			elements.put(CustomBorder_2002, BordersPackage.eINSTANCE.getCustomBorder());

			elements.put(CompoundBorder_2003, BordersPackage.eINSTANCE.getCompoundBorder());

			elements.put(LineBorder_2004, BordersPackage.eINSTANCE.getLineBorder());
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
			KNOWN_ELEMENT_TYPES.add(MarginBorder_2001);
			KNOWN_ELEMENT_TYPES.add(CustomBorder_2002);
			KNOWN_ELEMENT_TYPES.add(CompoundBorder_2003);
			KNOWN_ELEMENT_TYPES.add(LineBorder_2004);
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
		case MarginBorderEditPart.VISUAL_ID:
			return MarginBorder_2001;
		case CustomBorderEditPart.VISUAL_ID:
			return CustomBorder_2002;
		case CompoundBorderEditPart.VISUAL_ID:
			return CompoundBorder_2003;
		case LineBorderEditPart.VISUAL_ID:
			return LineBorder_2004;
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
			return borders.diagram.providers.BordersElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return borders.diagram.providers.BordersElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return borders.diagram.providers.BordersElementTypes.getElement(elementTypeAdapter);
		}
	};

}
