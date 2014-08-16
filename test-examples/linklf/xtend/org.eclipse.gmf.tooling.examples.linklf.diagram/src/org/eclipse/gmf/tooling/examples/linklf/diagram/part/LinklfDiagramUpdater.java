package org.eclipse.gmf.tooling.examples.linklf.diagram.part;

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
import org.eclipse.gmf.tooling.examples.linklf.Canvas;
import org.eclipse.gmf.tooling.examples.linklf.CanvasElement;
import org.eclipse.gmf.tooling.examples.linklf.CanvasElementContainer;
import org.eclipse.gmf.tooling.examples.linklf.Circle;
import org.eclipse.gmf.tooling.examples.linklf.Container;
import org.eclipse.gmf.tooling.examples.linklf.LabeledLink;
import org.eclipse.gmf.tooling.examples.linklf.Link;
import org.eclipse.gmf.tooling.examples.linklf.LinklfPackage;
import org.eclipse.gmf.tooling.examples.linklf.Node;
import org.eclipse.gmf.tooling.examples.linklf.Port;
import org.eclipse.gmf.tooling.examples.linklf.Rectangle;
import org.eclipse.gmf.tooling.examples.linklf.Rhombus;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Circle2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.CircleEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Container2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerContainerCompartment2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerContainerCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LabeledLinkEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LinkEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.PortEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Rectangle2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.RectangleEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Rhombus2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.RhombusEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfElementTypes;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
 * @generated
 */
public class LinklfDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<LinklfNodeDescriptor> getSemanticChildren(View view) {
		switch (LinklfVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getCanvas_1000SemanticChildren(view);
		case ContainerEditPart.VISUAL_ID:
			return getContainer_2003SemanticChildren(view);
		case Container2EditPart.VISUAL_ID:
			return getContainer_3002SemanticChildren(view);
		case ContainerContainerCompartmentEditPart.VISUAL_ID:
			return getContainerContainerCompartment_7001SemanticChildren(view);
		case ContainerContainerCompartment2EditPart.VISUAL_ID:
			return getContainerContainerCompartment_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfNodeDescriptor> getCanvas_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Canvas modelElement = (Canvas) view.getElement();
		LinkedList<LinklfNodeDescriptor> result = new LinkedList<LinklfNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElements().iterator(); it.hasNext();) {
			CanvasElement childElement = (CanvasElement) it.next();
			int visualID = LinklfVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CircleEditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RectangleEditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ContainerEditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RhombusEditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfNodeDescriptor> getContainer_2003SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Container modelElement = (Container) view.getElement();
		LinkedList<LinklfNodeDescriptor> result = new LinkedList<LinklfNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPorst().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = LinklfVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PortEditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfNodeDescriptor> getContainer_3002SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Container modelElement = (Container) view.getElement();
		LinkedList<LinklfNodeDescriptor> result = new LinkedList<LinklfNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPorst().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = LinklfVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PortEditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfNodeDescriptor> getContainerContainerCompartment_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Container modelElement = (Container) containerView.getElement();
		LinkedList<LinklfNodeDescriptor> result = new LinkedList<LinklfNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElements().iterator(); it.hasNext();) {
			CanvasElement childElement = (CanvasElement) it.next();
			int visualID = LinklfVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Circle2EditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Container2EditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Rectangle2EditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Rhombus2EditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfNodeDescriptor> getContainerContainerCompartment_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Container modelElement = (Container) containerView.getElement();
		LinkedList<LinklfNodeDescriptor> result = new LinkedList<LinklfNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElements().iterator(); it.hasNext();) {
			CanvasElement childElement = (CanvasElement) it.next();
			int visualID = LinklfVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Circle2EditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Container2EditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Rectangle2EditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Rhombus2EditPart.VISUAL_ID) {
				result.add(new LinklfNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getContainedLinks(View view) {
		switch (LinklfVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getCanvas_1000ContainedLinks(view);
		case CircleEditPart.VISUAL_ID:
			return getCircle_2001ContainedLinks(view);
		case RectangleEditPart.VISUAL_ID:
			return getRectangle_2002ContainedLinks(view);
		case ContainerEditPart.VISUAL_ID:
			return getContainer_2003ContainedLinks(view);
		case RhombusEditPart.VISUAL_ID:
			return getRhombus_2004ContainedLinks(view);
		case Circle2EditPart.VISUAL_ID:
			return getCircle_3001ContainedLinks(view);
		case Container2EditPart.VISUAL_ID:
			return getContainer_3002ContainedLinks(view);
		case Rectangle2EditPart.VISUAL_ID:
			return getRectangle_3003ContainedLinks(view);
		case Rhombus2EditPart.VISUAL_ID:
			return getRhombus_3004ContainedLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3005ContainedLinks(view);
		case LinkEditPart.VISUAL_ID:
			return getLink_4001ContainedLinks(view);
		case LabeledLinkEditPart.VISUAL_ID:
			return getLabeledLink_4002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getIncomingLinks(View view) {
		switch (LinklfVisualIDRegistry.getVisualID(view)) {
		case CircleEditPart.VISUAL_ID:
			return getCircle_2001IncomingLinks(view);
		case RectangleEditPart.VISUAL_ID:
			return getRectangle_2002IncomingLinks(view);
		case ContainerEditPart.VISUAL_ID:
			return getContainer_2003IncomingLinks(view);
		case RhombusEditPart.VISUAL_ID:
			return getRhombus_2004IncomingLinks(view);
		case Circle2EditPart.VISUAL_ID:
			return getCircle_3001IncomingLinks(view);
		case Container2EditPart.VISUAL_ID:
			return getContainer_3002IncomingLinks(view);
		case Rectangle2EditPart.VISUAL_ID:
			return getRectangle_3003IncomingLinks(view);
		case Rhombus2EditPart.VISUAL_ID:
			return getRhombus_3004IncomingLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3005IncomingLinks(view);
		case LinkEditPart.VISUAL_ID:
			return getLink_4001IncomingLinks(view);
		case LabeledLinkEditPart.VISUAL_ID:
			return getLabeledLink_4002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getOutgoingLinks(View view) {
		switch (LinklfVisualIDRegistry.getVisualID(view)) {
		case CircleEditPart.VISUAL_ID:
			return getCircle_2001OutgoingLinks(view);
		case RectangleEditPart.VISUAL_ID:
			return getRectangle_2002OutgoingLinks(view);
		case ContainerEditPart.VISUAL_ID:
			return getContainer_2003OutgoingLinks(view);
		case RhombusEditPart.VISUAL_ID:
			return getRhombus_2004OutgoingLinks(view);
		case Circle2EditPart.VISUAL_ID:
			return getCircle_3001OutgoingLinks(view);
		case Container2EditPart.VISUAL_ID:
			return getContainer_3002OutgoingLinks(view);
		case Rectangle2EditPart.VISUAL_ID:
			return getRectangle_3003OutgoingLinks(view);
		case Rhombus2EditPart.VISUAL_ID:
			return getRhombus_3004OutgoingLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3005OutgoingLinks(view);
		case LinkEditPart.VISUAL_ID:
			return getLink_4001OutgoingLinks(view);
		case LabeledLinkEditPart.VISUAL_ID:
			return getLabeledLink_4002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getCanvas_1000ContainedLinks(View view) {
		Canvas modelElement = (Canvas) view.getElement();
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Link_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_LabeledLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getCircle_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRectangle_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getContainer_2003ContainedLinks(View view) {
		Container modelElement = (Container) view.getElement();
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Link_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_LabeledLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRhombus_2004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getCircle_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getContainer_3002ContainedLinks(View view) {
		Container modelElement = (Container) view.getElement();
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Link_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_LabeledLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRectangle_3003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRhombus_3004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getPort_3005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getLink_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getLabeledLink_4002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getCircle_2001IncomingLinks(View view) {
		Circle modelElement = (Circle) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Link_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_LabeledLink_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRectangle_2002IncomingLinks(View view) {
		Rectangle modelElement = (Rectangle) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Link_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_LabeledLink_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getContainer_2003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRhombus_2004IncomingLinks(View view) {
		Rhombus modelElement = (Rhombus) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Link_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_LabeledLink_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getCircle_3001IncomingLinks(View view) {
		Circle modelElement = (Circle) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Link_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_LabeledLink_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getContainer_3002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRectangle_3003IncomingLinks(View view) {
		Rectangle modelElement = (Rectangle) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Link_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_LabeledLink_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRhombus_3004IncomingLinks(View view) {
		Rhombus modelElement = (Rhombus) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Link_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_LabeledLink_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getPort_3005IncomingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Link_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_LabeledLink_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getLink_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getLabeledLink_4002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getCircle_2001OutgoingLinks(View view) {
		Circle modelElement = (Circle) view.getElement();
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_LabeledLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRectangle_2002OutgoingLinks(View view) {
		Rectangle modelElement = (Rectangle) view.getElement();
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_LabeledLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getContainer_2003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRhombus_2004OutgoingLinks(View view) {
		Rhombus modelElement = (Rhombus) view.getElement();
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_LabeledLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getCircle_3001OutgoingLinks(View view) {
		Circle modelElement = (Circle) view.getElement();
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_LabeledLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getContainer_3002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRectangle_3003OutgoingLinks(View view) {
		Rectangle modelElement = (Rectangle) view.getElement();
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_LabeledLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getRhombus_3004OutgoingLinks(View view) {
		Rhombus modelElement = (Rhombus) view.getElement();
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_LabeledLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getPort_3005OutgoingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_LabeledLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getLink_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LinklfLinkDescriptor> getLabeledLink_4002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<LinklfLinkDescriptor> getContainedTypeModelFacetLinks_Link_4001(CanvasElementContainer container) {
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		for (Iterator<?> links = container.getElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Link) {
				continue;
			}
			Link link = (Link) linkObject;
			if (LinkEditPart.VISUAL_ID != LinklfVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			result.add(new LinklfLinkDescriptor(src, dst, link, LinklfElementTypes.Link_4001, LinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<LinklfLinkDescriptor> getContainedTypeModelFacetLinks_LabeledLink_4002(CanvasElementContainer container) {
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		for (Iterator<?> links = container.getElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof LabeledLink) {
				continue;
			}
			LabeledLink link = (LabeledLink) linkObject;
			if (LabeledLinkEditPart.VISUAL_ID != LinklfVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			result.add(new LinklfLinkDescriptor(src, dst, link, LinklfElementTypes.LabeledLink_4002, LabeledLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<LinklfLinkDescriptor> getIncomingTypeModelFacetLinks_Link_4001(Node target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != LinklfPackage.eINSTANCE.getLink_Target() || false == setting.getEObject() instanceof Link) {
				continue;
			}
			Link link = (Link) setting.getEObject();
			if (LinkEditPart.VISUAL_ID != LinklfVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node src = link.getSource();
			result.add(new LinklfLinkDescriptor(src, target, link, LinklfElementTypes.Link_4001, LinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<LinklfLinkDescriptor> getIncomingTypeModelFacetLinks_LabeledLink_4002(Node target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != LinklfPackage.eINSTANCE.getLabeledLink_Target() || false == setting.getEObject() instanceof LabeledLink) {
				continue;
			}
			LabeledLink link = (LabeledLink) setting.getEObject();
			if (LabeledLinkEditPart.VISUAL_ID != LinklfVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node src = link.getSource();
			result.add(new LinklfLinkDescriptor(src, target, link, LinklfElementTypes.LabeledLink_4002, LabeledLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<LinklfLinkDescriptor> getOutgoingTypeModelFacetLinks_Link_4001(Node source) {
		CanvasElementContainer container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof CanvasElementContainer) {
				container = (CanvasElementContainer) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		for (Iterator<?> links = container.getElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Link) {
				continue;
			}
			Link link = (Link) linkObject;
			if (LinkEditPart.VISUAL_ID != LinklfVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new LinklfLinkDescriptor(src, dst, link, LinklfElementTypes.Link_4001, LinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<LinklfLinkDescriptor> getOutgoingTypeModelFacetLinks_LabeledLink_4002(Node source) {
		CanvasElementContainer container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof CanvasElementContainer) {
				container = (CanvasElementContainer) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<LinklfLinkDescriptor> result = new LinkedList<LinklfLinkDescriptor>();
		for (Iterator<?> links = container.getElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof LabeledLink) {
				continue;
			}
			LabeledLink link = (LabeledLink) linkObject;
			if (LabeledLinkEditPart.VISUAL_ID != LinklfVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new LinklfLinkDescriptor(src, dst, link, LinklfElementTypes.LabeledLink_4002, LabeledLinkEditPart.VISUAL_ID));
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
		public List<LinklfNodeDescriptor> getSemanticChildren(View view) {
			return LinklfDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<LinklfLinkDescriptor> getContainedLinks(View view) {
			return LinklfDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<LinklfLinkDescriptor> getIncomingLinks(View view) {
			return LinklfDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<LinklfLinkDescriptor> getOutgoingLinks(View view) {
			return LinklfDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
