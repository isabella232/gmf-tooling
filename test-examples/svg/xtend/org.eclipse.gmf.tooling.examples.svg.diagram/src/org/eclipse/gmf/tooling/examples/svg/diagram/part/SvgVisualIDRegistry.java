package org.eclipse.gmf.tooling.examples.svg.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.svg.Playground;
import org.eclipse.gmf.tooling.examples.svg.SvgPackage;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.GoalEditPart;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.PlayerEditPart;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.PlaygroundEditPart;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class SvgVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.gmf.tooling.examples.svg.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (PlaygroundEditPart.MODEL_ID.equals(view.getType())) {
				return PlaygroundEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry.getVisualID(view.getType());
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
				SvgDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
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
		if (SvgPackage.eINSTANCE.getPlayground().isSuperTypeOf(domainElement.eClass()) && isDiagram((Playground) domainElement)) {
			return PlaygroundEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry.getModelID(containerView);
		if (!PlaygroundEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (PlaygroundEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PlaygroundEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case PlaygroundEditPart.VISUAL_ID:
			if (SvgPackage.eINSTANCE.getGoal().isSuperTypeOf(domainElement.eClass())) {
				return GoalEditPart.VISUAL_ID;
			}
			if (SvgPackage.eINSTANCE.getPlayer().isSuperTypeOf(domainElement.eClass())) {
				return PlayerEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry.getModelID(containerView);
		if (!PlaygroundEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (PlaygroundEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PlaygroundEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case PlaygroundEditPart.VISUAL_ID:
			if (GoalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PlayerEditPart.VISUAL_ID == nodeVisualID) {
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
	private static boolean isDiagram(Playground element) {
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
		case PlaygroundEditPart.VISUAL_ID:
			return false;
		case GoalEditPart.VISUAL_ID:
		case PlayerEditPart.VISUAL_ID:
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
			return org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
