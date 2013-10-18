package borders.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import borders.Border;
import borders.Diagram;
import borders.diagram.edit.parts.CompoundBorderEditPart;
import borders.diagram.edit.parts.CustomBorderEditPart;
import borders.diagram.edit.parts.DiagramEditPart;
import borders.diagram.edit.parts.LineBorderEditPart;
import borders.diagram.edit.parts.MarginBorderEditPart;

/**
 * @generated
 */
public class BordersDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<BordersNodeDescriptor> getSemanticChildren(View view) {
		switch (BordersVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getDiagram_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersNodeDescriptor> getDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Diagram modelElement = (Diagram) view.getElement();
		LinkedList<BordersNodeDescriptor> result = new LinkedList<BordersNodeDescriptor>();
		for (Iterator<?> it = modelElement.getBorders().iterator(); it.hasNext();) {
			Border childElement = (Border) it.next();
			int visualID = BordersVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MarginBorderEditPart.VISUAL_ID) {
				result.add(new BordersNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CustomBorderEditPart.VISUAL_ID) {
				result.add(new BordersNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CompoundBorderEditPart.VISUAL_ID) {
				result.add(new BordersNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LineBorderEditPart.VISUAL_ID) {
				result.add(new BordersNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getContainedLinks(View view) {
		switch (BordersVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getDiagram_1000ContainedLinks(view);
		case MarginBorderEditPart.VISUAL_ID:
			return getMarginBorder_2001ContainedLinks(view);
		case CustomBorderEditPart.VISUAL_ID:
			return getCustomBorder_2002ContainedLinks(view);
		case CompoundBorderEditPart.VISUAL_ID:
			return getCompoundBorder_2003ContainedLinks(view);
		case LineBorderEditPart.VISUAL_ID:
			return getLineBorder_2004ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getIncomingLinks(View view) {
		switch (BordersVisualIDRegistry.getVisualID(view)) {
		case MarginBorderEditPart.VISUAL_ID:
			return getMarginBorder_2001IncomingLinks(view);
		case CustomBorderEditPart.VISUAL_ID:
			return getCustomBorder_2002IncomingLinks(view);
		case CompoundBorderEditPart.VISUAL_ID:
			return getCompoundBorder_2003IncomingLinks(view);
		case LineBorderEditPart.VISUAL_ID:
			return getLineBorder_2004IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getOutgoingLinks(View view) {
		switch (BordersVisualIDRegistry.getVisualID(view)) {
		case MarginBorderEditPart.VISUAL_ID:
			return getMarginBorder_2001OutgoingLinks(view);
		case CustomBorderEditPart.VISUAL_ID:
			return getCustomBorder_2002OutgoingLinks(view);
		case CompoundBorderEditPart.VISUAL_ID:
			return getCompoundBorder_2003OutgoingLinks(view);
		case LineBorderEditPart.VISUAL_ID:
			return getLineBorder_2004OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getDiagram_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getMarginBorder_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getCustomBorder_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getCompoundBorder_2003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getLineBorder_2004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getMarginBorder_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getCustomBorder_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getCompoundBorder_2003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getLineBorder_2004IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getMarginBorder_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getCustomBorder_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getCompoundBorder_2003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BordersLinkDescriptor> getLineBorder_2004OutgoingLinks(View view) {
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
		public List<BordersNodeDescriptor> getSemanticChildren(View view) {
			return BordersDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<BordersLinkDescriptor> getContainedLinks(View view) {
			return BordersDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<BordersLinkDescriptor> getIncomingLinks(View view) {
			return BordersDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<BordersLinkDescriptor> getOutgoingLinks(View view) {
			return BordersDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
