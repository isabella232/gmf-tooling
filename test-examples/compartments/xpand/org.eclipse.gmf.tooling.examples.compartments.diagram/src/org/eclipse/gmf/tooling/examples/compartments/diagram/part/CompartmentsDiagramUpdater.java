package org.eclipse.gmf.tooling.examples.compartments.diagram.part;

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
import org.eclipse.gmf.tooling.examples.compartments.Canvas;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfA_C;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfA_D;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfAffixed;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_G;
import org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage;
import org.eclipse.gmf.tooling.examples.compartments.TopNode;
import org.eclipse.gmf.tooling.examples.compartments.TopNodeA;
import org.eclipse.gmf.tooling.examples.compartments.TopNodeB;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_CEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_DEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfAffixedEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_ECNodeRelationEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_EEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FDNodeRelationEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GAffixedChildrenCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeAEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeANodeCCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeANodeDCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBNodeECompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBNodeFCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
* @generated
*/
public class CompartmentsDiagramUpdater {

	/**
	* @generated
	*/
	public static List<CompartmentsNodeDescriptor> getSemanticChildren(View view) {
		switch (CompartmentsVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getCanvas_1000SemanticChildren(view);
		case TopNodeBEditPart.VISUAL_ID:
			return getTopNodeB_2002SemanticChildren(view);
		case TopNodeANodeCCompartmentEditPart.VISUAL_ID:
			return getTopNodeANodeCCompartment_7001SemanticChildren(view);
		case TopNodeANodeDCompartmentEditPart.VISUAL_ID:
			return getTopNodeANodeDCompartment_7002SemanticChildren(view);
		case TopNodeBNodeECompartmentEditPart.VISUAL_ID:
			return getTopNodeBNodeECompartment_7003SemanticChildren(view);
		case TopNodeBNodeFCompartmentEditPart.VISUAL_ID:
			return getTopNodeBNodeFCompartment_7004SemanticChildren(view);
		case ChildOfB_GAffixedChildrenCompartmentEditPart.VISUAL_ID:
			return getChildOfB_GAffixedChildrenCompartment_7005SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<CompartmentsNodeDescriptor> getCanvas_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Canvas modelElement = (Canvas) view.getElement();
		LinkedList<CompartmentsNodeDescriptor> result = new LinkedList<CompartmentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElements().iterator(); it.hasNext();) {
			TopNode childElement = (TopNode) it.next();
			int visualID = CompartmentsVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TopNodeAEditPart.VISUAL_ID) {
				result.add(new CompartmentsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TopNodeBEditPart.VISUAL_ID) {
				result.add(new CompartmentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<CompartmentsNodeDescriptor> getTopNodeB_2002SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		TopNodeB modelElement = (TopNodeB) view.getElement();
		LinkedList<CompartmentsNodeDescriptor> result = new LinkedList<CompartmentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildrenG().iterator(); it.hasNext();) {
			ChildOfB_G childElement = (ChildOfB_G) it.next();
			int visualID = CompartmentsVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ChildOfB_GEditPart.VISUAL_ID) {
				result.add(new CompartmentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<CompartmentsNodeDescriptor> getTopNodeANodeCCompartment_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		TopNodeA modelElement = (TopNodeA) containerView.getElement();
		LinkedList<CompartmentsNodeDescriptor> result = new LinkedList<CompartmentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildrenC().iterator(); it.hasNext();) {
			ChildOfA_C childElement = (ChildOfA_C) it.next();
			int visualID = CompartmentsVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ChildOfA_CEditPart.VISUAL_ID) {
				result.add(new CompartmentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<CompartmentsNodeDescriptor> getTopNodeANodeDCompartment_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		TopNodeA modelElement = (TopNodeA) containerView.getElement();
		LinkedList<CompartmentsNodeDescriptor> result = new LinkedList<CompartmentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildrenD().iterator(); it.hasNext();) {
			ChildOfA_D childElement = (ChildOfA_D) it.next();
			int visualID = CompartmentsVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ChildOfA_DEditPart.VISUAL_ID) {
				result.add(new CompartmentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<CompartmentsNodeDescriptor> getTopNodeBNodeECompartment_7003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		TopNodeB modelElement = (TopNodeB) containerView.getElement();
		LinkedList<CompartmentsNodeDescriptor> result = new LinkedList<CompartmentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildrenE().iterator(); it.hasNext();) {
			ChildOfB_E childElement = (ChildOfB_E) it.next();
			int visualID = CompartmentsVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ChildOfB_EEditPart.VISUAL_ID) {
				result.add(new CompartmentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<CompartmentsNodeDescriptor> getTopNodeBNodeFCompartment_7004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		TopNodeB modelElement = (TopNodeB) containerView.getElement();
		LinkedList<CompartmentsNodeDescriptor> result = new LinkedList<CompartmentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildrenF().iterator(); it.hasNext();) {
			ChildOfB_F childElement = (ChildOfB_F) it.next();
			int visualID = CompartmentsVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ChildOfB_FEditPart.VISUAL_ID) {
				result.add(new CompartmentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<CompartmentsNodeDescriptor> getChildOfB_GAffixedChildrenCompartment_7005SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ChildOfB_G modelElement = (ChildOfB_G) containerView.getElement();
		LinkedList<CompartmentsNodeDescriptor> result = new LinkedList<CompartmentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildrenOfAffixed().iterator(); it.hasNext();) {
			ChildOfAffixed childElement = (ChildOfAffixed) it.next();
			int visualID = CompartmentsVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ChildOfAffixedEditPart.VISUAL_ID) {
				result.add(new CompartmentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<CompartmentsLinkDescriptor> getContainedLinks(View view) {
		switch (CompartmentsVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getCanvas_1000ContainedLinks(view);
		case TopNodeAEditPart.VISUAL_ID:
			return getTopNodeA_2001ContainedLinks(view);
		case TopNodeBEditPart.VISUAL_ID:
			return getTopNodeB_2002ContainedLinks(view);
		case ChildOfA_CEditPart.VISUAL_ID:
			return getChildOfA_C_3001ContainedLinks(view);
		case ChildOfA_DEditPart.VISUAL_ID:
			return getChildOfA_D_3002ContainedLinks(view);
		case ChildOfB_EEditPart.VISUAL_ID:
			return getChildOfB_E_3003ContainedLinks(view);
		case ChildOfB_GEditPart.VISUAL_ID:
			return getChildOfB_G_3004ContainedLinks(view);
		case ChildOfAffixedEditPart.VISUAL_ID:
			return getChildOfAffixed_3005ContainedLinks(view);
		case ChildOfB_FEditPart.VISUAL_ID:
			return getChildOfB_F_3006ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<CompartmentsLinkDescriptor> getIncomingLinks(View view) {
		switch (CompartmentsVisualIDRegistry.getVisualID(view)) {
		case TopNodeAEditPart.VISUAL_ID:
			return getTopNodeA_2001IncomingLinks(view);
		case TopNodeBEditPart.VISUAL_ID:
			return getTopNodeB_2002IncomingLinks(view);
		case ChildOfA_CEditPart.VISUAL_ID:
			return getChildOfA_C_3001IncomingLinks(view);
		case ChildOfA_DEditPart.VISUAL_ID:
			return getChildOfA_D_3002IncomingLinks(view);
		case ChildOfB_EEditPart.VISUAL_ID:
			return getChildOfB_E_3003IncomingLinks(view);
		case ChildOfB_GEditPart.VISUAL_ID:
			return getChildOfB_G_3004IncomingLinks(view);
		case ChildOfAffixedEditPart.VISUAL_ID:
			return getChildOfAffixed_3005IncomingLinks(view);
		case ChildOfB_FEditPart.VISUAL_ID:
			return getChildOfB_F_3006IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<CompartmentsLinkDescriptor> getOutgoingLinks(View view) {
		switch (CompartmentsVisualIDRegistry.getVisualID(view)) {
		case TopNodeAEditPart.VISUAL_ID:
			return getTopNodeA_2001OutgoingLinks(view);
		case TopNodeBEditPart.VISUAL_ID:
			return getTopNodeB_2002OutgoingLinks(view);
		case ChildOfA_CEditPart.VISUAL_ID:
			return getChildOfA_C_3001OutgoingLinks(view);
		case ChildOfA_DEditPart.VISUAL_ID:
			return getChildOfA_D_3002OutgoingLinks(view);
		case ChildOfB_EEditPart.VISUAL_ID:
			return getChildOfB_E_3003OutgoingLinks(view);
		case ChildOfB_GEditPart.VISUAL_ID:
			return getChildOfB_G_3004OutgoingLinks(view);
		case ChildOfAffixedEditPart.VISUAL_ID:
			return getChildOfAffixed_3005OutgoingLinks(view);
		case ChildOfB_FEditPart.VISUAL_ID:
			return getChildOfB_F_3006OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getCanvas_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getTopNodeA_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getTopNodeB_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfA_C_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfA_D_3002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfB_E_3003ContainedLinks(View view) {
		ChildOfB_E modelElement = (ChildOfB_E) view.getElement();
		LinkedList<CompartmentsLinkDescriptor> result = new LinkedList<CompartmentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ChildOfB_E_CNodeRelation_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfB_G_3004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfAffixed_3005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfB_F_3006ContainedLinks(View view) {
		ChildOfB_F modelElement = (ChildOfB_F) view.getElement();
		LinkedList<CompartmentsLinkDescriptor> result = new LinkedList<CompartmentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ChildOfB_F_DNodeRelation_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getTopNodeA_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getTopNodeB_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfA_C_3001IncomingLinks(View view) {
		ChildOfA_C modelElement = (ChildOfA_C) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<CompartmentsLinkDescriptor> result = new LinkedList<CompartmentsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ChildOfB_E_CNodeRelation_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfA_D_3002IncomingLinks(View view) {
		ChildOfA_D modelElement = (ChildOfA_D) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<CompartmentsLinkDescriptor> result = new LinkedList<CompartmentsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ChildOfB_F_DNodeRelation_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfB_E_3003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfB_G_3004IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfAffixed_3005IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfB_F_3006IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getTopNodeA_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getTopNodeB_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfA_C_3001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfA_D_3002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfB_E_3003OutgoingLinks(View view) {
		ChildOfB_E modelElement = (ChildOfB_E) view.getElement();
		LinkedList<CompartmentsLinkDescriptor> result = new LinkedList<CompartmentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ChildOfB_E_CNodeRelation_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfB_G_3004OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfAffixed_3005OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<CompartmentsLinkDescriptor> getChildOfB_F_3006OutgoingLinks(View view) {
		ChildOfB_F modelElement = (ChildOfB_F) view.getElement();
		LinkedList<CompartmentsLinkDescriptor> result = new LinkedList<CompartmentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ChildOfB_F_DNodeRelation_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<CompartmentsLinkDescriptor> getIncomingFeatureModelFacetLinks_ChildOfB_E_CNodeRelation_4001(ChildOfA_C target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<CompartmentsLinkDescriptor> result = new LinkedList<CompartmentsLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == CompartmentsPackage.eINSTANCE.getChildOfB_E_CNodeRelation()) {
				result.add(new CompartmentsLinkDescriptor(setting.getEObject(), target, CompartmentsElementTypes.ChildOfB_ECNodeRelation_4001, ChildOfB_ECNodeRelationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<CompartmentsLinkDescriptor> getIncomingFeatureModelFacetLinks_ChildOfB_F_DNodeRelation_4002(ChildOfA_D target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<CompartmentsLinkDescriptor> result = new LinkedList<CompartmentsLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == CompartmentsPackage.eINSTANCE.getChildOfB_F_DNodeRelation()) {
				result.add(new CompartmentsLinkDescriptor(setting.getEObject(), target, CompartmentsElementTypes.ChildOfB_FDNodeRelation_4002, ChildOfB_FDNodeRelationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<CompartmentsLinkDescriptor> getOutgoingFeatureModelFacetLinks_ChildOfB_E_CNodeRelation_4001(ChildOfB_E source) {
		LinkedList<CompartmentsLinkDescriptor> result = new LinkedList<CompartmentsLinkDescriptor>();
		ChildOfA_C destination = source.getCNodeRelation();
		if (destination == null) {
			return result;
		}
		result.add(new CompartmentsLinkDescriptor(source, destination, CompartmentsElementTypes.ChildOfB_ECNodeRelation_4001, ChildOfB_ECNodeRelationEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<CompartmentsLinkDescriptor> getOutgoingFeatureModelFacetLinks_ChildOfB_F_DNodeRelation_4002(ChildOfB_F source) {
		LinkedList<CompartmentsLinkDescriptor> result = new LinkedList<CompartmentsLinkDescriptor>();
		ChildOfA_D destination = source.getDNodeRelation();
		if (destination == null) {
			return result;
		}
		result.add(new CompartmentsLinkDescriptor(source, destination, CompartmentsElementTypes.ChildOfB_FDNodeRelation_4002, ChildOfB_FDNodeRelationEditPart.VISUAL_ID));
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
		public List<CompartmentsNodeDescriptor> getSemanticChildren(View view) {
			return CompartmentsDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<CompartmentsLinkDescriptor> getContainedLinks(View view) {
			return CompartmentsDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<CompartmentsLinkDescriptor> getIncomingLinks(View view) {
			return CompartmentsDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<CompartmentsLinkDescriptor> getOutgoingLinks(View view) {
			return CompartmentsDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
