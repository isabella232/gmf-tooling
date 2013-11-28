package org.eclipse.gmf.tooling.examples.compartments.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_CEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_DEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfAffixedEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_ECNodeRelationEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_EEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FDNodeRelationEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeAEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsDiagramEditorPlugin;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class CompartmentsElementTypes {

	/**
	* @generated
	*/
	private CompartmentsElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(CompartmentsDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Canvas_1000 = getElementType("org.eclipse.gmf.tooling.examples.compartments.diagram.Canvas_1000"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType TopNodeA_2001 = getElementType("org.eclipse.gmf.tooling.examples.compartments.diagram.TopNodeA_2001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType TopNodeB_2002 = getElementType("org.eclipse.gmf.tooling.examples.compartments.diagram.TopNodeB_2002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ChildOfA_C_3001 = getElementType("org.eclipse.gmf.tooling.examples.compartments.diagram.ChildOfA_C_3001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ChildOfA_D_3002 = getElementType("org.eclipse.gmf.tooling.examples.compartments.diagram.ChildOfA_D_3002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ChildOfB_E_3003 = getElementType("org.eclipse.gmf.tooling.examples.compartments.diagram.ChildOfB_E_3003"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ChildOfB_G_3004 = getElementType("org.eclipse.gmf.tooling.examples.compartments.diagram.ChildOfB_G_3004"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ChildOfAffixed_3005 = getElementType("org.eclipse.gmf.tooling.examples.compartments.diagram.ChildOfAffixed_3005"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ChildOfB_F_3006 = getElementType("org.eclipse.gmf.tooling.examples.compartments.diagram.ChildOfB_F_3006"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ChildOfB_ECNodeRelation_4001 = getElementType("org.eclipse.gmf.tooling.examples.compartments.diagram.ChildOfB_ECNodeRelation_4001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ChildOfB_FDNodeRelation_4002 = getElementType("org.eclipse.gmf.tooling.examples.compartments.diagram.ChildOfB_FDNodeRelation_4002"); //$NON-NLS-1$

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

			elements.put(Canvas_1000, CompartmentsPackage.eINSTANCE.getCanvas());

			elements.put(TopNodeA_2001, CompartmentsPackage.eINSTANCE.getTopNodeA());

			elements.put(TopNodeB_2002, CompartmentsPackage.eINSTANCE.getTopNodeB());

			elements.put(ChildOfA_C_3001, CompartmentsPackage.eINSTANCE.getChildOfA_C());

			elements.put(ChildOfA_D_3002, CompartmentsPackage.eINSTANCE.getChildOfA_D());

			elements.put(ChildOfB_E_3003, CompartmentsPackage.eINSTANCE.getChildOfB_E());

			elements.put(ChildOfB_G_3004, CompartmentsPackage.eINSTANCE.getChildOfB_G());

			elements.put(ChildOfAffixed_3005, CompartmentsPackage.eINSTANCE.getChildOfAffixed());

			elements.put(ChildOfB_F_3006, CompartmentsPackage.eINSTANCE.getChildOfB_F());

			elements.put(ChildOfB_ECNodeRelation_4001, CompartmentsPackage.eINSTANCE.getChildOfB_E_CNodeRelation());

			elements.put(ChildOfB_FDNodeRelation_4002, CompartmentsPackage.eINSTANCE.getChildOfB_F_DNodeRelation());
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
			KNOWN_ELEMENT_TYPES.add(TopNodeA_2001);
			KNOWN_ELEMENT_TYPES.add(TopNodeB_2002);
			KNOWN_ELEMENT_TYPES.add(ChildOfA_C_3001);
			KNOWN_ELEMENT_TYPES.add(ChildOfA_D_3002);
			KNOWN_ELEMENT_TYPES.add(ChildOfB_E_3003);
			KNOWN_ELEMENT_TYPES.add(ChildOfB_G_3004);
			KNOWN_ELEMENT_TYPES.add(ChildOfAffixed_3005);
			KNOWN_ELEMENT_TYPES.add(ChildOfB_F_3006);
			KNOWN_ELEMENT_TYPES.add(ChildOfB_ECNodeRelation_4001);
			KNOWN_ELEMENT_TYPES.add(ChildOfB_FDNodeRelation_4002);
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
		case TopNodeAEditPart.VISUAL_ID:
			return TopNodeA_2001;
		case TopNodeBEditPart.VISUAL_ID:
			return TopNodeB_2002;
		case ChildOfA_CEditPart.VISUAL_ID:
			return ChildOfA_C_3001;
		case ChildOfA_DEditPart.VISUAL_ID:
			return ChildOfA_D_3002;
		case ChildOfB_EEditPart.VISUAL_ID:
			return ChildOfB_E_3003;
		case ChildOfB_GEditPart.VISUAL_ID:
			return ChildOfB_G_3004;
		case ChildOfAffixedEditPart.VISUAL_ID:
			return ChildOfAffixed_3005;
		case ChildOfB_FEditPart.VISUAL_ID:
			return ChildOfB_F_3006;
		case ChildOfB_ECNodeRelationEditPart.VISUAL_ID:
			return ChildOfB_ECNodeRelation_4001;
		case ChildOfB_FDNodeRelationEditPart.VISUAL_ID:
			return ChildOfB_FDNodeRelation_4002;
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
			return org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes.getElement(elementTypeAdapter);
		}
	};

}
