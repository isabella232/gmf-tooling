package org.eclipse.gmf.tooling.examples.affixednode.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.BundleEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.CommunicationEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.IncomingCommunicatorEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.OutcomingCommunicatorEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.part.AffixednodeDiagramEditorPlugin;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class AffixednodeElementTypes {

	/**
	 * @generated
	 */
	private AffixednodeElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(AffixednodeDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Canvas_1000 = getElementType("org.eclipse.gmf.tooling.examples.affixednode.diagram.Canvas_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Bundle_2001 = getElementType("org.eclipse.gmf.tooling.examples.affixednode.diagram.Bundle_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType IncomingCommunicator_3001 = getElementType("org.eclipse.gmf.tooling.examples.affixednode.diagram.IncomingCommunicator_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutcomingCommunicator_3002 = getElementType("org.eclipse.gmf.tooling.examples.affixednode.diagram.OutcomingCommunicator_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Communication_4001 = getElementType("org.eclipse.gmf.tooling.examples.affixednode.diagram.Communication_4001"); //$NON-NLS-1$

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

			elements.put(Canvas_1000, AffixedNodePackage.eINSTANCE.getCanvas());

			elements.put(Bundle_2001, AffixedNodePackage.eINSTANCE.getBundle());

			elements.put(IncomingCommunicator_3001, AffixedNodePackage.eINSTANCE.getIncomingCommunicator());

			elements.put(OutcomingCommunicator_3002, AffixedNodePackage.eINSTANCE.getOutcomingCommunicator());

			elements.put(Communication_4001, AffixedNodePackage.eINSTANCE.getCommunication());
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
			KNOWN_ELEMENT_TYPES.add(Bundle_2001);
			KNOWN_ELEMENT_TYPES.add(IncomingCommunicator_3001);
			KNOWN_ELEMENT_TYPES.add(OutcomingCommunicator_3002);
			KNOWN_ELEMENT_TYPES.add(Communication_4001);
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
		case BundleEditPart.VISUAL_ID:
			return Bundle_2001;
		case IncomingCommunicatorEditPart.VISUAL_ID:
			return IncomingCommunicator_3001;
		case OutcomingCommunicatorEditPart.VISUAL_ID:
			return OutcomingCommunicator_3002;
		case CommunicationEditPart.VISUAL_ID:
			return Communication_4001;
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
			return org.eclipse.gmf.tooling.examples.affixednode.diagram.providers.AffixednodeElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.gmf.tooling.examples.affixednode.diagram.providers.AffixednodeElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.gmf.tooling.examples.affixednode.diagram.providers.AffixednodeElementTypes.getElement(elementTypeAdapter);
		}
	};

}
