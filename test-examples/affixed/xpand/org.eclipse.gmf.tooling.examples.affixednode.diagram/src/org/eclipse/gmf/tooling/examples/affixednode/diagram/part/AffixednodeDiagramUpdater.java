package org.eclipse.gmf.tooling.examples.affixednode.diagram.part;

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
import org.eclipse.gmf.tooling.examples.affixednode.AffixedNodePackage;
import org.eclipse.gmf.tooling.examples.affixednode.Bundle;
import org.eclipse.gmf.tooling.examples.affixednode.Canvas;
import org.eclipse.gmf.tooling.examples.affixednode.Communication;
import org.eclipse.gmf.tooling.examples.affixednode.IncomingCommunicator;
import org.eclipse.gmf.tooling.examples.affixednode.OutcomingCommunicator;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.BundleEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.CommunicationEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.IncomingCommunicatorEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.OutcomingCommunicatorEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.providers.AffixednodeElementTypes;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
* @generated
*/
public class AffixednodeDiagramUpdater {

	/**
	* @generated
	*/
	public static List<AffixednodeNodeDescriptor> getSemanticChildren(View view) {
		switch (AffixednodeVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getCanvas_1000SemanticChildren(view);
		case BundleEditPart.VISUAL_ID:
			return getBundle_2001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<AffixednodeNodeDescriptor> getCanvas_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Canvas modelElement = (Canvas) view.getElement();
		LinkedList<AffixednodeNodeDescriptor> result = new LinkedList<AffixednodeNodeDescriptor>();
		for (Iterator<?> it = modelElement.getBundles().iterator(); it.hasNext();) {
			Bundle childElement = (Bundle) it.next();
			int visualID = AffixednodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == BundleEditPart.VISUAL_ID) {
				result.add(new AffixednodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<AffixednodeNodeDescriptor> getBundle_2001SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Bundle modelElement = (Bundle) view.getElement();
		LinkedList<AffixednodeNodeDescriptor> result = new LinkedList<AffixednodeNodeDescriptor>();
		{
			IncomingCommunicator childElement = modelElement.getIncomingCommunicator();
			int visualID = AffixednodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == IncomingCommunicatorEditPart.VISUAL_ID) {
				result.add(new AffixednodeNodeDescriptor(childElement, visualID));
			}
		}
		{
			OutcomingCommunicator childElement = modelElement.getOutcomingCommunicator();
			int visualID = AffixednodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutcomingCommunicatorEditPart.VISUAL_ID) {
				result.add(new AffixednodeNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<AffixednodeLinkDescriptor> getContainedLinks(View view) {
		switch (AffixednodeVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getCanvas_1000ContainedLinks(view);
		case BundleEditPart.VISUAL_ID:
			return getBundle_2001ContainedLinks(view);
		case IncomingCommunicatorEditPart.VISUAL_ID:
			return getIncomingCommunicator_3001ContainedLinks(view);
		case OutcomingCommunicatorEditPart.VISUAL_ID:
			return getOutcomingCommunicator_3002ContainedLinks(view);
		case CommunicationEditPart.VISUAL_ID:
			return getCommunication_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<AffixednodeLinkDescriptor> getIncomingLinks(View view) {
		switch (AffixednodeVisualIDRegistry.getVisualID(view)) {
		case BundleEditPart.VISUAL_ID:
			return getBundle_2001IncomingLinks(view);
		case IncomingCommunicatorEditPart.VISUAL_ID:
			return getIncomingCommunicator_3001IncomingLinks(view);
		case OutcomingCommunicatorEditPart.VISUAL_ID:
			return getOutcomingCommunicator_3002IncomingLinks(view);
		case CommunicationEditPart.VISUAL_ID:
			return getCommunication_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<AffixednodeLinkDescriptor> getOutgoingLinks(View view) {
		switch (AffixednodeVisualIDRegistry.getVisualID(view)) {
		case BundleEditPart.VISUAL_ID:
			return getBundle_2001OutgoingLinks(view);
		case IncomingCommunicatorEditPart.VISUAL_ID:
			return getIncomingCommunicator_3001OutgoingLinks(view);
		case OutcomingCommunicatorEditPart.VISUAL_ID:
			return getOutcomingCommunicator_3002OutgoingLinks(view);
		case CommunicationEditPart.VISUAL_ID:
			return getCommunication_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getCanvas_1000ContainedLinks(View view) {
		Canvas modelElement = (Canvas) view.getElement();
		LinkedList<AffixednodeLinkDescriptor> result = new LinkedList<AffixednodeLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Communication_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getBundle_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getIncomingCommunicator_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getOutcomingCommunicator_3002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getCommunication_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getBundle_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getIncomingCommunicator_3001IncomingLinks(View view) {
		IncomingCommunicator modelElement = (IncomingCommunicator) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<AffixednodeLinkDescriptor> result = new LinkedList<AffixednodeLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Communication_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getOutcomingCommunicator_3002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getCommunication_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getBundle_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getIncomingCommunicator_3001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getOutcomingCommunicator_3002OutgoingLinks(View view) {
		OutcomingCommunicator modelElement = (OutcomingCommunicator) view.getElement();
		LinkedList<AffixednodeLinkDescriptor> result = new LinkedList<AffixednodeLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Communication_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AffixednodeLinkDescriptor> getCommunication_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<AffixednodeLinkDescriptor> getContainedTypeModelFacetLinks_Communication_4001(Canvas container) {
		LinkedList<AffixednodeLinkDescriptor> result = new LinkedList<AffixednodeLinkDescriptor>();
		for (Iterator<?> links = container.getCommunications().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Communication) {
				continue;
			}
			Communication link = (Communication) linkObject;
			if (CommunicationEditPart.VISUAL_ID != AffixednodeVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			IncomingCommunicator dst = link.getIncomingCommunicator();
			OutcomingCommunicator src = link.getOutcomingCommunicator();
			result.add(new AffixednodeLinkDescriptor(src, dst, link, AffixednodeElementTypes.Communication_4001, CommunicationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AffixednodeLinkDescriptor> getIncomingTypeModelFacetLinks_Communication_4001(IncomingCommunicator target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AffixednodeLinkDescriptor> result = new LinkedList<AffixednodeLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != AffixedNodePackage.eINSTANCE.getCommunication_IncomingCommunicator() || false == setting.getEObject() instanceof Communication) {
				continue;
			}
			Communication link = (Communication) setting.getEObject();
			if (CommunicationEditPart.VISUAL_ID != AffixednodeVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			OutcomingCommunicator src = link.getOutcomingCommunicator();
			result.add(new AffixednodeLinkDescriptor(src, target, link, AffixednodeElementTypes.Communication_4001, CommunicationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<AffixednodeLinkDescriptor> getOutgoingTypeModelFacetLinks_Communication_4001(OutcomingCommunicator source) {
		Canvas container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Canvas) {
				container = (Canvas) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<AffixednodeLinkDescriptor> result = new LinkedList<AffixednodeLinkDescriptor>();
		for (Iterator<?> links = container.getCommunications().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Communication) {
				continue;
			}
			Communication link = (Communication) linkObject;
			if (CommunicationEditPart.VISUAL_ID != AffixednodeVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			IncomingCommunicator dst = link.getIncomingCommunicator();
			OutcomingCommunicator src = link.getOutcomingCommunicator();
			if (src != source) {
				continue;
			}
			result.add(new AffixednodeLinkDescriptor(src, dst, link, AffixednodeElementTypes.Communication_4001, CommunicationEditPart.VISUAL_ID));
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
		public List<AffixednodeNodeDescriptor> getSemanticChildren(View view) {
			return AffixednodeDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<AffixednodeLinkDescriptor> getContainedLinks(View view) {
			return AffixednodeDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<AffixednodeLinkDescriptor> getIncomingLinks(View view) {
			return AffixednodeDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<AffixednodeLinkDescriptor> getOutgoingLinks(View view) {
			return AffixednodeDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
