package org.eclipse.gmf.tooling.examples.compartments.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.compartments.Canvas;
import org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_CEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_CNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_DEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_DNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfAffixedEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_EEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_ENameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GAffixedChildrenCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GNumberEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeAEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeANameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeANodeCCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeANodeDCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBNodeECompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBNodeFCompartmentEditPart;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class CompartmentsVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.gmf.tooling.examples.compartments.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (CanvasEditPart.MODEL_ID.equals(view.getType())) {
				return CanvasEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				CompartmentsDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (CompartmentsPackage.eINSTANCE.getCanvas().isSuperTypeOf(domainElement.eClass()) && isDiagram((Canvas) domainElement)) {
			return CanvasEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry.getModelID(containerView);
		if (!CanvasEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (CanvasEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = CanvasEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case CanvasEditPart.VISUAL_ID:
			if (CompartmentsPackage.eINSTANCE.getTopNodeA().isSuperTypeOf(domainElement.eClass())) {
				return TopNodeAEditPart.VISUAL_ID;
			}
			if (CompartmentsPackage.eINSTANCE.getTopNodeB().isSuperTypeOf(domainElement.eClass())) {
				return TopNodeBEditPart.VISUAL_ID;
			}
			break;
		case TopNodeBEditPart.VISUAL_ID:
			if (CompartmentsPackage.eINSTANCE.getChildOfB_G().isSuperTypeOf(domainElement.eClass())) {
				return ChildOfB_GEditPart.VISUAL_ID;
			}
			break;
		case TopNodeANodeCCompartmentEditPart.VISUAL_ID:
			if (CompartmentsPackage.eINSTANCE.getChildOfA_C().isSuperTypeOf(domainElement.eClass())) {
				return ChildOfA_CEditPart.VISUAL_ID;
			}
			break;
		case TopNodeANodeDCompartmentEditPart.VISUAL_ID:
			if (CompartmentsPackage.eINSTANCE.getChildOfA_D().isSuperTypeOf(domainElement.eClass())) {
				return ChildOfA_DEditPart.VISUAL_ID;
			}
			break;
		case TopNodeBNodeECompartmentEditPart.VISUAL_ID:
			if (CompartmentsPackage.eINSTANCE.getChildOfB_E().isSuperTypeOf(domainElement.eClass())) {
				return ChildOfB_EEditPart.VISUAL_ID;
			}
			break;
		case TopNodeBNodeFCompartmentEditPart.VISUAL_ID:
			if (CompartmentsPackage.eINSTANCE.getChildOfB_F().isSuperTypeOf(domainElement.eClass())) {
				return ChildOfB_FEditPart.VISUAL_ID;
			}
			break;
		case ChildOfB_GAffixedChildrenCompartmentEditPart.VISUAL_ID:
			if (CompartmentsPackage.eINSTANCE.getChildOfAffixed().isSuperTypeOf(domainElement.eClass())) {
				return ChildOfAffixedEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry.getModelID(containerView);
		if (!CanvasEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (CanvasEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = CanvasEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case CanvasEditPart.VISUAL_ID:
			if (TopNodeAEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TopNodeBEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TopNodeAEditPart.VISUAL_ID:
			if (TopNodeANameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TopNodeANodeCCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TopNodeANodeDCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TopNodeBEditPart.VISUAL_ID:
			if (TopNodeBNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TopNodeBNodeECompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TopNodeBNodeFCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ChildOfB_GEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ChildOfA_CEditPart.VISUAL_ID:
			if (ChildOfA_CNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ChildOfA_DEditPart.VISUAL_ID:
			if (ChildOfA_DNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ChildOfB_EEditPart.VISUAL_ID:
			if (ChildOfB_ENameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ChildOfB_GEditPart.VISUAL_ID:
			if (ChildOfB_GNumberEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ChildOfB_GAffixedChildrenCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ChildOfB_FEditPart.VISUAL_ID:
			if (ChildOfB_FNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TopNodeANodeCCompartmentEditPart.VISUAL_ID:
			if (ChildOfA_CEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TopNodeANodeDCompartmentEditPart.VISUAL_ID:
			if (ChildOfA_DEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TopNodeBNodeECompartmentEditPart.VISUAL_ID:
			if (ChildOfB_EEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TopNodeBNodeFCompartmentEditPart.VISUAL_ID:
			if (ChildOfB_FEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ChildOfB_GAffixedChildrenCompartmentEditPart.VISUAL_ID:
			if (ChildOfAffixedEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Canvas element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case TopNodeANodeCCompartmentEditPart.VISUAL_ID:
		case TopNodeANodeDCompartmentEditPart.VISUAL_ID:
		case TopNodeBNodeECompartmentEditPart.VISUAL_ID:
		case TopNodeBNodeFCompartmentEditPart.VISUAL_ID:
		case ChildOfB_GAffixedChildrenCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case CanvasEditPart.VISUAL_ID:
			return false;
		case ChildOfA_CEditPart.VISUAL_ID:
		case ChildOfA_DEditPart.VISUAL_ID:
		case ChildOfB_EEditPart.VISUAL_ID:
		case ChildOfAffixedEditPart.VISUAL_ID:
		case ChildOfB_FEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {

		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
