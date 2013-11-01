package org.eclipse.gmf.tooling.examples.svg.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.svg.Goal;
import org.eclipse.gmf.tooling.examples.svg.Player;
import org.eclipse.gmf.tooling.examples.svg.Playground;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.GoalEditPart;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.PlayerEditPart;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.PlaygroundEditPart;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
* @generated
*/
public class SvgDiagramUpdater {

	/**
	* @generated
	*/
	public static List<SvgNodeDescriptor> getSemanticChildren(View view) {
		switch (SvgVisualIDRegistry.getVisualID(view)) {
		case PlaygroundEditPart.VISUAL_ID:
			return getPlayground_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<SvgNodeDescriptor> getPlayground_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Playground modelElement = (Playground) view.getElement();
		LinkedList<SvgNodeDescriptor> result = new LinkedList<SvgNodeDescriptor>();
		for (Iterator<?> it = modelElement.getGoals().iterator(); it.hasNext();) {
			Goal childElement = (Goal) it.next();
			int visualID = SvgVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == GoalEditPart.VISUAL_ID) {
				result.add(new SvgNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getPlayers().iterator(); it.hasNext();) {
			Player childElement = (Player) it.next();
			int visualID = SvgVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PlayerEditPart.VISUAL_ID) {
				result.add(new SvgNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<SvgLinkDescriptor> getContainedLinks(View view) {
		switch (SvgVisualIDRegistry.getVisualID(view)) {
		case PlaygroundEditPart.VISUAL_ID:
			return getPlayground_1000ContainedLinks(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001ContainedLinks(view);
		case PlayerEditPart.VISUAL_ID:
			return getPlayer_2002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<SvgLinkDescriptor> getIncomingLinks(View view) {
		switch (SvgVisualIDRegistry.getVisualID(view)) {
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001IncomingLinks(view);
		case PlayerEditPart.VISUAL_ID:
			return getPlayer_2002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<SvgLinkDescriptor> getOutgoingLinks(View view) {
		switch (SvgVisualIDRegistry.getVisualID(view)) {
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001OutgoingLinks(view);
		case PlayerEditPart.VISUAL_ID:
			return getPlayer_2002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<SvgLinkDescriptor> getPlayground_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<SvgLinkDescriptor> getGoal_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<SvgLinkDescriptor> getPlayer_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<SvgLinkDescriptor> getGoal_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<SvgLinkDescriptor> getPlayer_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<SvgLinkDescriptor> getGoal_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<SvgLinkDescriptor> getPlayer_2002OutgoingLinks(View view) {
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
		public List<SvgNodeDescriptor> getSemanticChildren(View view) {
			return SvgDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<SvgLinkDescriptor> getContainedLinks(View view) {
			return SvgDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<SvgLinkDescriptor> getIncomingLinks(View view) {
			return SvgDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<SvgLinkDescriptor> getOutgoingLinks(View view) {
			return SvgDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
