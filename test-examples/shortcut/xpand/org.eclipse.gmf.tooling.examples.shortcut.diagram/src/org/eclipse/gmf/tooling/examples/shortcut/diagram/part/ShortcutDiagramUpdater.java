package org.eclipse.gmf.tooling.examples.shortcut.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.shortcut.Diagram;
import org.eclipse.gmf.tooling.examples.shortcut.DiagramLink;
import org.eclipse.gmf.tooling.examples.shortcut.DiagramNode;
import org.eclipse.gmf.tooling.examples.shortcut.ShortcutPackage;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramLinkEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramNodeEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.providers.ShortcutElementTypes;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
* @generated
*/
public class ShortcutDiagramUpdater {

	/**
	* @generated
	*/
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	* @generated
	*/
	public static List<ShortcutNodeDescriptor> getSemanticChildren(View view) {
		switch (ShortcutVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getDiagram_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ShortcutNodeDescriptor> getDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Diagram modelElement = (Diagram) view.getElement();
		LinkedList<ShortcutNodeDescriptor> result = new LinkedList<ShortcutNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			DiagramNode childElement = (DiagramNode) it.next();
			int visualID = ShortcutVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DiagramNodeEditPart.VISUAL_ID) {
				result.add(new ShortcutNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<ShortcutLinkDescriptor> getContainedLinks(View view) {
		switch (ShortcutVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getDiagram_1000ContainedLinks(view);
		case DiagramNodeEditPart.VISUAL_ID:
			return getDiagramNode_2001ContainedLinks(view);
		case DiagramLinkEditPart.VISUAL_ID:
			return getDiagramLink_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ShortcutLinkDescriptor> getIncomingLinks(View view) {
		switch (ShortcutVisualIDRegistry.getVisualID(view)) {
		case DiagramNodeEditPart.VISUAL_ID:
			return getDiagramNode_2001IncomingLinks(view);
		case DiagramLinkEditPart.VISUAL_ID:
			return getDiagramLink_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ShortcutLinkDescriptor> getOutgoingLinks(View view) {
		switch (ShortcutVisualIDRegistry.getVisualID(view)) {
		case DiagramNodeEditPart.VISUAL_ID:
			return getDiagramNode_2001OutgoingLinks(view);
		case DiagramLinkEditPart.VISUAL_ID:
			return getDiagramLink_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ShortcutLinkDescriptor> getDiagram_1000ContainedLinks(View view) {
		Diagram modelElement = (Diagram) view.getElement();
		LinkedList<ShortcutLinkDescriptor> result = new LinkedList<ShortcutLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_DiagramLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ShortcutLinkDescriptor> getDiagramNode_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ShortcutLinkDescriptor> getDiagramLink_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ShortcutLinkDescriptor> getDiagramNode_2001IncomingLinks(View view) {
		DiagramNode modelElement = (DiagramNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<ShortcutLinkDescriptor> result = new LinkedList<ShortcutLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DiagramLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ShortcutLinkDescriptor> getDiagramLink_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ShortcutLinkDescriptor> getDiagramNode_2001OutgoingLinks(View view) {
		DiagramNode modelElement = (DiagramNode) view.getElement();
		LinkedList<ShortcutLinkDescriptor> result = new LinkedList<ShortcutLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DiagramLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ShortcutLinkDescriptor> getDiagramLink_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<ShortcutLinkDescriptor> getContainedTypeModelFacetLinks_DiagramLink_4001(Diagram container) {
		LinkedList<ShortcutLinkDescriptor> result = new LinkedList<ShortcutLinkDescriptor>();
		for (Iterator<?> links = container.getLinks().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DiagramLink) {
				continue;
			}
			DiagramLink link = (DiagramLink) linkObject;
			if (DiagramLinkEditPart.VISUAL_ID != ShortcutVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DiagramNode dst = link.getTargetNode();
			DiagramNode src = link.getSourceNode();
			result.add(new ShortcutLinkDescriptor(src, dst, link, ShortcutElementTypes.DiagramLink_4001, DiagramLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ShortcutLinkDescriptor> getIncomingTypeModelFacetLinks_DiagramLink_4001(DiagramNode target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ShortcutLinkDescriptor> result = new LinkedList<ShortcutLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != ShortcutPackage.eINSTANCE.getDiagramLink_TargetNode() || false == setting.getEObject() instanceof DiagramLink) {
				continue;
			}
			DiagramLink link = (DiagramLink) setting.getEObject();
			if (DiagramLinkEditPart.VISUAL_ID != ShortcutVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DiagramNode src = link.getSourceNode();
			result.add(new ShortcutLinkDescriptor(src, target, link, ShortcutElementTypes.DiagramLink_4001, DiagramLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ShortcutLinkDescriptor> getOutgoingTypeModelFacetLinks_DiagramLink_4001(DiagramNode source) {
		Diagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Diagram) {
				container = (Diagram) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<ShortcutLinkDescriptor> result = new LinkedList<ShortcutLinkDescriptor>();
		for (Iterator<?> links = container.getLinks().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DiagramLink) {
				continue;
			}
			DiagramLink link = (DiagramLink) linkObject;
			if (DiagramLinkEditPart.VISUAL_ID != ShortcutVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DiagramNode dst = link.getTargetNode();
			DiagramNode src = link.getSourceNode();
			if (src != source) {
				continue;
			}
			result.add(new ShortcutLinkDescriptor(src, dst, link, ShortcutElementTypes.DiagramLink_4001, DiagramLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {

		/**
		* @generated
		*/
		@Override
		public List<ShortcutNodeDescriptor> getSemanticChildren(View view) {
			return ShortcutDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<ShortcutLinkDescriptor> getContainedLinks(View view) {
			return ShortcutDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<ShortcutLinkDescriptor> getIncomingLinks(View view) {
			return ShortcutDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<ShortcutLinkDescriptor> getOutgoingLinks(View view) {
			return ShortcutDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
