package pins.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import pins.ColorPin;
import pins.CustomPin;
import pins.Diagram;
import pins.Pin;
import pins.PinsChild;
import pins.VisiblePin;
import pins.diagram.edit.parts.ColorPinEditPart;
import pins.diagram.edit.parts.CustomPinEditPart;
import pins.diagram.edit.parts.DiagramEditPart;
import pins.diagram.edit.parts.PinsChild2EditPart;
import pins.diagram.edit.parts.PinsChild3EditPart;
import pins.diagram.edit.parts.PinsChildEditPart;
import pins.diagram.edit.parts.VisiblePinEditPart;

/**
 * @generated
 */
public class PinsDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<PinsNodeDescriptor> getSemanticChildren(View view) {
		switch (PinsVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getDiagram_1000SemanticChildren(view);
		case CustomPinEditPart.VISUAL_ID:
			return getCustomPin_2001SemanticChildren(view);
		case VisiblePinEditPart.VISUAL_ID:
			return getVisiblePin_2002SemanticChildren(view);
		case ColorPinEditPart.VISUAL_ID:
			return getColorPin_2003SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsNodeDescriptor> getDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Diagram modelElement = (Diagram) view.getElement();
		LinkedList<PinsNodeDescriptor> result = new LinkedList<PinsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getGetPins().iterator(); it.hasNext();) {
			Pin childElement = (Pin) it.next();
			int visualID = PinsVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CustomPinEditPart.VISUAL_ID) {
				result.add(new PinsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == VisiblePinEditPart.VISUAL_ID) {
				result.add(new PinsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ColorPinEditPart.VISUAL_ID) {
				result.add(new PinsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PinsNodeDescriptor> getCustomPin_2001SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CustomPin modelElement = (CustomPin) view.getElement();
		LinkedList<PinsNodeDescriptor> result = new LinkedList<PinsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getGetChildren().iterator(); it.hasNext();) {
			PinsChild childElement = (PinsChild) it.next();
			int visualID = PinsVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PinsChildEditPart.VISUAL_ID) {
				result.add(new PinsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PinsNodeDescriptor> getVisiblePin_2002SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		VisiblePin modelElement = (VisiblePin) view.getElement();
		LinkedList<PinsNodeDescriptor> result = new LinkedList<PinsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getGetChildren().iterator(); it.hasNext();) {
			PinsChild childElement = (PinsChild) it.next();
			int visualID = PinsVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PinsChild2EditPart.VISUAL_ID) {
				result.add(new PinsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PinsNodeDescriptor> getColorPin_2003SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ColorPin modelElement = (ColorPin) view.getElement();
		LinkedList<PinsNodeDescriptor> result = new LinkedList<PinsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getGetChildren().iterator(); it.hasNext();) {
			PinsChild childElement = (PinsChild) it.next();
			int visualID = PinsVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PinsChild3EditPart.VISUAL_ID) {
				result.add(new PinsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getContainedLinks(View view) {
		switch (PinsVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getDiagram_1000ContainedLinks(view);
		case CustomPinEditPart.VISUAL_ID:
			return getCustomPin_2001ContainedLinks(view);
		case VisiblePinEditPart.VISUAL_ID:
			return getVisiblePin_2002ContainedLinks(view);
		case ColorPinEditPart.VISUAL_ID:
			return getColorPin_2003ContainedLinks(view);
		case PinsChildEditPart.VISUAL_ID:
			return getPinsChild_3001ContainedLinks(view);
		case PinsChild2EditPart.VISUAL_ID:
			return getPinsChild_3002ContainedLinks(view);
		case PinsChild3EditPart.VISUAL_ID:
			return getPinsChild_3003ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getIncomingLinks(View view) {
		switch (PinsVisualIDRegistry.getVisualID(view)) {
		case CustomPinEditPart.VISUAL_ID:
			return getCustomPin_2001IncomingLinks(view);
		case VisiblePinEditPart.VISUAL_ID:
			return getVisiblePin_2002IncomingLinks(view);
		case ColorPinEditPart.VISUAL_ID:
			return getColorPin_2003IncomingLinks(view);
		case PinsChildEditPart.VISUAL_ID:
			return getPinsChild_3001IncomingLinks(view);
		case PinsChild2EditPart.VISUAL_ID:
			return getPinsChild_3002IncomingLinks(view);
		case PinsChild3EditPart.VISUAL_ID:
			return getPinsChild_3003IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getOutgoingLinks(View view) {
		switch (PinsVisualIDRegistry.getVisualID(view)) {
		case CustomPinEditPart.VISUAL_ID:
			return getCustomPin_2001OutgoingLinks(view);
		case VisiblePinEditPart.VISUAL_ID:
			return getVisiblePin_2002OutgoingLinks(view);
		case ColorPinEditPart.VISUAL_ID:
			return getColorPin_2003OutgoingLinks(view);
		case PinsChildEditPart.VISUAL_ID:
			return getPinsChild_3001OutgoingLinks(view);
		case PinsChild2EditPart.VISUAL_ID:
			return getPinsChild_3002OutgoingLinks(view);
		case PinsChild3EditPart.VISUAL_ID:
			return getPinsChild_3003OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getDiagram_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getCustomPin_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getVisiblePin_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getColorPin_2003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getPinsChild_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getPinsChild_3002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getPinsChild_3003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getCustomPin_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getVisiblePin_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getColorPin_2003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getPinsChild_3001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getPinsChild_3002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getPinsChild_3003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getCustomPin_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getVisiblePin_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getColorPin_2003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getPinsChild_3001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getPinsChild_3002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PinsLinkDescriptor> getPinsChild_3003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {

		/**
		 * @generated
		 */
		@Override
		public List<PinsNodeDescriptor> getSemanticChildren(View view) {
			return PinsDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PinsLinkDescriptor> getContainedLinks(View view) {
			return PinsDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PinsLinkDescriptor> getIncomingLinks(View view) {
			return PinsDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PinsLinkDescriptor> getOutgoingLinks(View view) {
			return PinsDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
