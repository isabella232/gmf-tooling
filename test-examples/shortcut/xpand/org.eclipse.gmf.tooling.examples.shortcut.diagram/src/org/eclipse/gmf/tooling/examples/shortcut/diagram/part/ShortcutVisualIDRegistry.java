package org.eclipse.gmf.tooling.examples.shortcut.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramLinkEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramNodeEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramNodeNameEditPart;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
* This registry is used to determine which type of visual object should be
* created for the corresponding Diagram, Node, ChildNode or Link represented
* by a domain model object.
* 
* @generated
*/
public class ShortcutVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "org.eclipse.gmf.tooling.examples.shortcut.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (DiagramEditPart.MODEL_ID.equals(view.getType())) {
				return DiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry.getVisualID(view.getType());
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
				ShortcutDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
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
		if (ShortcutPackage.eINSTANCE.getDiagram().isSuperTypeOf(domainElement.eClass()) && isDiagram((org.eclipse.gmf.tooling.examples.shortcut.Diagram) domainElement)) {
			return DiagramEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry.getModelID(containerView);
		if (!DiagramEditPart.MODEL_ID.equals(containerModelID) && !"Shortcut".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (DiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = DiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case DiagramEditPart.VISUAL_ID:
			if (ShortcutPackage.eINSTANCE.getDiagramNode().isSuperTypeOf(domainElement.eClass())) {
				return DiagramNodeEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry.getModelID(containerView);
		if (!DiagramEditPart.MODEL_ID.equals(containerModelID) && !"Shortcut".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (DiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = DiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case DiagramEditPart.VISUAL_ID:
			if (DiagramNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DiagramNodeEditPart.VISUAL_ID:
			if (DiagramNodeNameEditPart.VISUAL_ID == nodeVisualID) {
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
		if (ShortcutPackage.eINSTANCE.getDiagramLink().isSuperTypeOf(domainElement.eClass())) {
			return DiagramLinkEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(org.eclipse.gmf.tooling.examples.shortcut.Diagram element) {
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
		return false;
	}

	/**
	* @generated
	*/
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case DiagramEditPart.VISUAL_ID:
			return false;
		case DiagramNodeEditPart.VISUAL_ID:
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
			return org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override
		public String getModelID(View view) {
			return org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		* @generated
		*/
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
