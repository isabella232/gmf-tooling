package org.eclipse.gmf.tooling.examples.linklf.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.linklf.Canvas;
import org.eclipse.gmf.tooling.examples.linklf.LinklfPackage;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Circle2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.CircleEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Container2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerContainerCompartment2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerContainerCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerName2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerNameEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LabeledLinkEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LabeledLinkLinkNameEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LabeledLinkSourceNameEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LabeledLinkTargetNameEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LinkEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.PortEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Rectangle2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.RectangleEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Rhombus2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.RhombusEditPart;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class LinklfVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.gmf.tooling.examples.linklf.diagram/debug/visualID"; //$NON-NLS-1$

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
		return org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry.getVisualID(view.getType());
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
				LinklfDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
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
		if (LinklfPackage.eINSTANCE.getCanvas().isSuperTypeOf(domainElement.eClass()) && isDiagram((Canvas) domainElement)) {
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
		String containerModelID = org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry.getModelID(containerView);
		if (!CanvasEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (CanvasEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = CanvasEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case CanvasEditPart.VISUAL_ID:
			if (LinklfPackage.eINSTANCE.getCircle().isSuperTypeOf(domainElement.eClass())) {
				return CircleEditPart.VISUAL_ID;
			}
			if (LinklfPackage.eINSTANCE.getRectangle().isSuperTypeOf(domainElement.eClass())) {
				return RectangleEditPart.VISUAL_ID;
			}
			if (LinklfPackage.eINSTANCE.getContainer().isSuperTypeOf(domainElement.eClass())) {
				return ContainerEditPart.VISUAL_ID;
			}
			if (LinklfPackage.eINSTANCE.getRhombus().isSuperTypeOf(domainElement.eClass())) {
				return RhombusEditPart.VISUAL_ID;
			}
			break;
		case ContainerEditPart.VISUAL_ID:
			if (LinklfPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case Container2EditPart.VISUAL_ID:
			if (LinklfPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ContainerContainerCompartmentEditPart.VISUAL_ID:
			if (LinklfPackage.eINSTANCE.getCircle().isSuperTypeOf(domainElement.eClass())) {
				return Circle2EditPart.VISUAL_ID;
			}
			if (LinklfPackage.eINSTANCE.getContainer().isSuperTypeOf(domainElement.eClass())) {
				return Container2EditPart.VISUAL_ID;
			}
			if (LinklfPackage.eINSTANCE.getRectangle().isSuperTypeOf(domainElement.eClass())) {
				return Rectangle2EditPart.VISUAL_ID;
			}
			if (LinklfPackage.eINSTANCE.getRhombus().isSuperTypeOf(domainElement.eClass())) {
				return Rhombus2EditPart.VISUAL_ID;
			}
			break;
		case ContainerContainerCompartment2EditPart.VISUAL_ID:
			if (LinklfPackage.eINSTANCE.getCircle().isSuperTypeOf(domainElement.eClass())) {
				return Circle2EditPart.VISUAL_ID;
			}
			if (LinklfPackage.eINSTANCE.getContainer().isSuperTypeOf(domainElement.eClass())) {
				return Container2EditPart.VISUAL_ID;
			}
			if (LinklfPackage.eINSTANCE.getRectangle().isSuperTypeOf(domainElement.eClass())) {
				return Rectangle2EditPart.VISUAL_ID;
			}
			if (LinklfPackage.eINSTANCE.getRhombus().isSuperTypeOf(domainElement.eClass())) {
				return Rhombus2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry.getModelID(containerView);
		if (!CanvasEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (CanvasEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = CanvasEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case CanvasEditPart.VISUAL_ID:
			if (CircleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RectangleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RhombusEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ContainerEditPart.VISUAL_ID:
			if (ContainerNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ContainerContainerCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Container2EditPart.VISUAL_ID:
			if (ContainerName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ContainerContainerCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ContainerContainerCompartmentEditPart.VISUAL_ID:
			if (Circle2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Container2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Rectangle2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Rhombus2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ContainerContainerCompartment2EditPart.VISUAL_ID:
			if (Circle2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Container2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Rectangle2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Rhombus2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LabeledLinkEditPart.VISUAL_ID:
			if (LabeledLinkSourceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LabeledLinkTargetNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LabeledLinkLinkNameEditPart.VISUAL_ID == nodeVisualID) {
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
		if (LinklfPackage.eINSTANCE.getLink().isSuperTypeOf(domainElement.eClass())) {
			return LinkEditPart.VISUAL_ID;
		}
		if (LinklfPackage.eINSTANCE.getLabeledLink().isSuperTypeOf(domainElement.eClass())) {
			return LabeledLinkEditPart.VISUAL_ID;
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
		case ContainerContainerCompartmentEditPart.VISUAL_ID:
		case ContainerContainerCompartment2EditPart.VISUAL_ID:
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
		case CircleEditPart.VISUAL_ID:
		case RectangleEditPart.VISUAL_ID:
		case RhombusEditPart.VISUAL_ID:
		case Circle2EditPart.VISUAL_ID:
		case Rectangle2EditPart.VISUAL_ID:
		case Rhombus2EditPart.VISUAL_ID:
		case PortEditPart.VISUAL_ID:
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
			return org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
