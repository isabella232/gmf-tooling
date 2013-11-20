package org.eclipse.gmf.tooling.examples.svg.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.examples.svg.SvgPackage;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.GoalEditPart;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.PlayerEditPart;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.PlaygroundEditPart;
import org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgDiagramEditorPlugin;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class SvgElementTypes {

	/**
	 * @generated
	 */
	private SvgElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(SvgDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Playground_1000 = getElementType("org.eclipse.gmf.tooling.examples.svg.diagram.Playground_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Goal_2001 = getElementType("org.eclipse.gmf.tooling.examples.svg.diagram.Goal_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Player_2002 = getElementType("org.eclipse.gmf.tooling.examples.svg.diagram.Player_2002"); //$NON-NLS-1$

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

			elements.put(Playground_1000, SvgPackage.eINSTANCE.getPlayground());

			elements.put(Goal_2001, SvgPackage.eINSTANCE.getGoal());

			elements.put(Player_2002, SvgPackage.eINSTANCE.getPlayer());
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
			KNOWN_ELEMENT_TYPES.add(Playground_1000);
			KNOWN_ELEMENT_TYPES.add(Goal_2001);
			KNOWN_ELEMENT_TYPES.add(Player_2002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case PlaygroundEditPart.VISUAL_ID:
			return Playground_1000;
		case GoalEditPart.VISUAL_ID:
			return Goal_2001;
		case PlayerEditPart.VISUAL_ID:
			return Player_2002;
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
			return org.eclipse.gmf.tooling.examples.svg.diagram.providers.SvgElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.gmf.tooling.examples.svg.diagram.providers.SvgElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.gmf.tooling.examples.svg.diagram.providers.SvgElementTypes.getElement(elementTypeAdapter);
		}
	};

}
