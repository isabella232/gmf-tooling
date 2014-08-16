package org.eclipse.gmf.tooling.examples.linklf.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.examples.linklf.LinklfPackage;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Circle2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.CircleEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Container2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LabeledLinkEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LinkEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.PortEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Rectangle2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.RectangleEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Rhombus2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.RhombusEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfDiagramEditorPlugin;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class LinklfElementTypes {

	/**
	 * @generated
	 */
	private LinklfElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(LinklfDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Canvas_1000 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.Canvas_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Circle_2001 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.Circle_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Rectangle_2002 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.Rectangle_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Container_2003 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.Container_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Rhombus_2004 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.Rhombus_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Circle_3001 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.Circle_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Container_3002 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.Container_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Rectangle_3003 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.Rectangle_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Rhombus_3004 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.Rhombus_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Port_3005 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.Port_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Link_4001 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.Link_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LabeledLink_4002 = getElementType("org.eclipse.gmf.tooling.examples.linklf.diagram.LabeledLink_4002"); //$NON-NLS-1$

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

			elements.put(Canvas_1000, LinklfPackage.eINSTANCE.getCanvas());

			elements.put(Circle_2001, LinklfPackage.eINSTANCE.getCircle());

			elements.put(Rectangle_2002, LinklfPackage.eINSTANCE.getRectangle());

			elements.put(Container_2003, LinklfPackage.eINSTANCE.getContainer());

			elements.put(Rhombus_2004, LinklfPackage.eINSTANCE.getRhombus());

			elements.put(Circle_3001, LinklfPackage.eINSTANCE.getCircle());

			elements.put(Container_3002, LinklfPackage.eINSTANCE.getContainer());

			elements.put(Rectangle_3003, LinklfPackage.eINSTANCE.getRectangle());

			elements.put(Rhombus_3004, LinklfPackage.eINSTANCE.getRhombus());

			elements.put(Port_3005, LinklfPackage.eINSTANCE.getPort());

			elements.put(Link_4001, LinklfPackage.eINSTANCE.getLink());

			elements.put(LabeledLink_4002, LinklfPackage.eINSTANCE.getLabeledLink());
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
			KNOWN_ELEMENT_TYPES.add(Canvas_1000);
			KNOWN_ELEMENT_TYPES.add(Circle_2001);
			KNOWN_ELEMENT_TYPES.add(Rectangle_2002);
			KNOWN_ELEMENT_TYPES.add(Container_2003);
			KNOWN_ELEMENT_TYPES.add(Rhombus_2004);
			KNOWN_ELEMENT_TYPES.add(Circle_3001);
			KNOWN_ELEMENT_TYPES.add(Container_3002);
			KNOWN_ELEMENT_TYPES.add(Rectangle_3003);
			KNOWN_ELEMENT_TYPES.add(Rhombus_3004);
			KNOWN_ELEMENT_TYPES.add(Port_3005);
			KNOWN_ELEMENT_TYPES.add(Link_4001);
			KNOWN_ELEMENT_TYPES.add(LabeledLink_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case CanvasEditPart.VISUAL_ID:
			return Canvas_1000;
		case CircleEditPart.VISUAL_ID:
			return Circle_2001;
		case RectangleEditPart.VISUAL_ID:
			return Rectangle_2002;
		case ContainerEditPart.VISUAL_ID:
			return Container_2003;
		case RhombusEditPart.VISUAL_ID:
			return Rhombus_2004;
		case Circle2EditPart.VISUAL_ID:
			return Circle_3001;
		case Container2EditPart.VISUAL_ID:
			return Container_3002;
		case Rectangle2EditPart.VISUAL_ID:
			return Rectangle_3003;
		case Rhombus2EditPart.VISUAL_ID:
			return Rhombus_3004;
		case PortEditPart.VISUAL_ID:
			return Port_3005;
		case LinkEditPart.VISUAL_ID:
			return Link_4001;
		case LabeledLinkEditPart.VISUAL_ID:
			return LabeledLink_4002;
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
			return org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfElementTypes.getElement(elementTypeAdapter);
		}
	};

}
