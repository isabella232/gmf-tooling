package org.eclipse.gmf.example.lesscode.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.example.lesscode.ElementBasedLink;
import org.eclipse.gmf.example.lesscode.LesscodePackage;
import org.eclipse.gmf.example.lesscode.MultiContainmentGroup;
import org.eclipse.gmf.example.lesscode.OneContainmentGroup;
import org.eclipse.gmf.example.lesscode.RootContainer;
import org.eclipse.gmf.example.lesscode.Subject;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.ElementBasedLinkEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.MultiContainmentGroupEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.MultiContainmentGroupInGroupManyEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.OneContainmentGroupEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.OneContainmentGroupInGroupOneEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.RootContainerEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject2EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject3EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject4EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject5EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectInSubject2EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectInSubject3EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectInSubject4EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectInSubject5EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectInSubjectEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectReferenceBasedLinkTargetEditPart;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
* @generated
*/
public class LesscodeDiagramUpdater {

	/**
	* @generated
	*/
	public static List<LesscodeNodeDescriptor> getSemanticChildren(View view) {
		switch (LesscodeVisualIDRegistry.getVisualID(view)) {
		case RootContainerEditPart.VISUAL_ID:
			return getRootContainer_1000SemanticChildren(view);
		case SubjectInSubjectEditPart.VISUAL_ID:
			return getSubjectInSubject_7001SemanticChildren(view);
		case SubjectInSubject2EditPart.VISUAL_ID:
			return getSubjectInSubject_7002SemanticChildren(view);
		case OneContainmentGroupInGroupOneEditPart.VISUAL_ID:
			return getOneContainmentGroupInGroupOne_7003SemanticChildren(view);
		case SubjectInSubject3EditPart.VISUAL_ID:
			return getSubjectInSubject_7004SemanticChildren(view);
		case MultiContainmentGroupInGroupManyEditPart.VISUAL_ID:
			return getMultiContainmentGroupInGroupMany_7005SemanticChildren(view);
		case SubjectInSubject4EditPart.VISUAL_ID:
			return getSubjectInSubject_7006SemanticChildren(view);
		case SubjectInSubject5EditPart.VISUAL_ID:
			return getSubjectInSubject_7007SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<LesscodeNodeDescriptor> getRootContainer_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		RootContainer modelElement = (RootContainer) view.getElement();
		LinkedList<LesscodeNodeDescriptor> result = new LinkedList<LesscodeNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRootSubjects().iterator(); it.hasNext();) {
			Subject childElement = (Subject) it.next();
			int visualID = LesscodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SubjectEditPart.VISUAL_ID) {
				result.add(new LesscodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOneContainmentGroups().iterator(); it.hasNext();) {
			OneContainmentGroup childElement = (OneContainmentGroup) it.next();
			int visualID = LesscodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OneContainmentGroupEditPart.VISUAL_ID) {
				result.add(new LesscodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getMultiContainmentGroups().iterator(); it.hasNext();) {
			MultiContainmentGroup childElement = (MultiContainmentGroup) it.next();
			int visualID = LesscodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MultiContainmentGroupEditPart.VISUAL_ID) {
				result.add(new LesscodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<LesscodeNodeDescriptor> getSubjectInSubject_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Subject modelElement = (Subject) containerView.getElement();
		LinkedList<LesscodeNodeDescriptor> result = new LinkedList<LesscodeNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRecursiveContainment().iterator(); it.hasNext();) {
			Subject childElement = (Subject) it.next();
			int visualID = LesscodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Subject2EditPart.VISUAL_ID) {
				result.add(new LesscodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<LesscodeNodeDescriptor> getSubjectInSubject_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Subject modelElement = (Subject) containerView.getElement();
		LinkedList<LesscodeNodeDescriptor> result = new LinkedList<LesscodeNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRecursiveContainment().iterator(); it.hasNext();) {
			Subject childElement = (Subject) it.next();
			int visualID = LesscodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Subject2EditPart.VISUAL_ID) {
				result.add(new LesscodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<LesscodeNodeDescriptor> getOneContainmentGroupInGroupOne_7003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		OneContainmentGroup modelElement = (OneContainmentGroup) containerView.getElement();
		LinkedList<LesscodeNodeDescriptor> result = new LinkedList<LesscodeNodeDescriptor>();
		for (Iterator<?> it = modelElement.getSubjects().iterator(); it.hasNext();) {
			Subject childElement = (Subject) it.next();
			int visualID = LesscodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Subject3EditPart.VISUAL_ID) {
				result.add(new LesscodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<LesscodeNodeDescriptor> getSubjectInSubject_7004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Subject modelElement = (Subject) containerView.getElement();
		LinkedList<LesscodeNodeDescriptor> result = new LinkedList<LesscodeNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRecursiveContainment().iterator(); it.hasNext();) {
			Subject childElement = (Subject) it.next();
			int visualID = LesscodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Subject2EditPart.VISUAL_ID) {
				result.add(new LesscodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<LesscodeNodeDescriptor> getMultiContainmentGroupInGroupMany_7005SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MultiContainmentGroup modelElement = (MultiContainmentGroup) containerView.getElement();
		LinkedList<LesscodeNodeDescriptor> result = new LinkedList<LesscodeNodeDescriptor>();
		for (Iterator<?> it = modelElement.getSubjectsTypeA().iterator(); it.hasNext();) {
			Subject childElement = (Subject) it.next();
			int visualID = LesscodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Subject4EditPart.VISUAL_ID) {
				result.add(new LesscodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getSubjectsTypeB().iterator(); it.hasNext();) {
			Subject childElement = (Subject) it.next();
			int visualID = LesscodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Subject5EditPart.VISUAL_ID) {
				result.add(new LesscodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<LesscodeNodeDescriptor> getSubjectInSubject_7006SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Subject modelElement = (Subject) containerView.getElement();
		LinkedList<LesscodeNodeDescriptor> result = new LinkedList<LesscodeNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRecursiveContainment().iterator(); it.hasNext();) {
			Subject childElement = (Subject) it.next();
			int visualID = LesscodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Subject2EditPart.VISUAL_ID) {
				result.add(new LesscodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<LesscodeNodeDescriptor> getSubjectInSubject_7007SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Subject modelElement = (Subject) containerView.getElement();
		LinkedList<LesscodeNodeDescriptor> result = new LinkedList<LesscodeNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRecursiveContainment().iterator(); it.hasNext();) {
			Subject childElement = (Subject) it.next();
			int visualID = LesscodeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Subject2EditPart.VISUAL_ID) {
				result.add(new LesscodeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<LesscodeLinkDescriptor> getContainedLinks(View view) {
		switch (LesscodeVisualIDRegistry.getVisualID(view)) {
		case RootContainerEditPart.VISUAL_ID:
			return getRootContainer_1000ContainedLinks(view);
		case SubjectEditPart.VISUAL_ID:
			return getSubject_2001ContainedLinks(view);
		case OneContainmentGroupEditPart.VISUAL_ID:
			return getOneContainmentGroup_2002ContainedLinks(view);
		case MultiContainmentGroupEditPart.VISUAL_ID:
			return getMultiContainmentGroup_2003ContainedLinks(view);
		case Subject2EditPart.VISUAL_ID:
			return getSubject_3001ContainedLinks(view);
		case Subject3EditPart.VISUAL_ID:
			return getSubject_3002ContainedLinks(view);
		case Subject4EditPart.VISUAL_ID:
			return getSubject_3003ContainedLinks(view);
		case Subject5EditPart.VISUAL_ID:
			return getSubject_3004ContainedLinks(view);
		case ElementBasedLinkEditPart.VISUAL_ID:
			return getElementBasedLink_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<LesscodeLinkDescriptor> getIncomingLinks(View view) {
		switch (LesscodeVisualIDRegistry.getVisualID(view)) {
		case SubjectEditPart.VISUAL_ID:
			return getSubject_2001IncomingLinks(view);
		case OneContainmentGroupEditPart.VISUAL_ID:
			return getOneContainmentGroup_2002IncomingLinks(view);
		case MultiContainmentGroupEditPart.VISUAL_ID:
			return getMultiContainmentGroup_2003IncomingLinks(view);
		case Subject2EditPart.VISUAL_ID:
			return getSubject_3001IncomingLinks(view);
		case Subject3EditPart.VISUAL_ID:
			return getSubject_3002IncomingLinks(view);
		case Subject4EditPart.VISUAL_ID:
			return getSubject_3003IncomingLinks(view);
		case Subject5EditPart.VISUAL_ID:
			return getSubject_3004IncomingLinks(view);
		case ElementBasedLinkEditPart.VISUAL_ID:
			return getElementBasedLink_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<LesscodeLinkDescriptor> getOutgoingLinks(View view) {
		switch (LesscodeVisualIDRegistry.getVisualID(view)) {
		case SubjectEditPart.VISUAL_ID:
			return getSubject_2001OutgoingLinks(view);
		case OneContainmentGroupEditPart.VISUAL_ID:
			return getOneContainmentGroup_2002OutgoingLinks(view);
		case MultiContainmentGroupEditPart.VISUAL_ID:
			return getMultiContainmentGroup_2003OutgoingLinks(view);
		case Subject2EditPart.VISUAL_ID:
			return getSubject_3001OutgoingLinks(view);
		case Subject3EditPart.VISUAL_ID:
			return getSubject_3002OutgoingLinks(view);
		case Subject4EditPart.VISUAL_ID:
			return getSubject_3003OutgoingLinks(view);
		case Subject5EditPart.VISUAL_ID:
			return getSubject_3004OutgoingLinks(view);
		case ElementBasedLinkEditPart.VISUAL_ID:
			return getElementBasedLink_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getRootContainer_1000ContainedLinks(View view) {
		RootContainer modelElement = (RootContainer) view.getElement();
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ElementBasedLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_2001ContainedLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getOneContainmentGroup_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getMultiContainmentGroup_2003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3001ContainedLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3002ContainedLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3003ContainedLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3004ContainedLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement));
		return result;
	}

	/**
	* @generated
	*/
	public static List<LesscodeLinkDescriptor> getElementBasedLink_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_2001IncomingLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ElementBasedLink_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getOneContainmentGroup_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getMultiContainmentGroup_2003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3001IncomingLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ElementBasedLink_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3002IncomingLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ElementBasedLink_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3003IncomingLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ElementBasedLink_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3004IncomingLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ElementBasedLink_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement, crossReferences));
		return result;
	}

	/**
	* @generated
	*/
	public static List<LesscodeLinkDescriptor> getElementBasedLink_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_2001OutgoingLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ElementBasedLink_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getOneContainmentGroup_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getMultiContainmentGroup_2003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3001OutgoingLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ElementBasedLink_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3002OutgoingLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ElementBasedLink_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3003OutgoingLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ElementBasedLink_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<LesscodeLinkDescriptor> getSubject_3004OutgoingLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ElementBasedLink_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(modelElement));
		return result;
	}

	/**
	* @generated
	*/
	public static List<LesscodeLinkDescriptor> getElementBasedLink_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<LesscodeLinkDescriptor> getContainedTypeModelFacetLinks_ElementBasedLink_4001(RootContainer container) {
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		for (Iterator<?> links = container.getElementBasedLinks().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ElementBasedLink) {
				continue;
			}
			ElementBasedLink link = (ElementBasedLink) linkObject;
			if (ElementBasedLinkEditPart.VISUAL_ID != LesscodeVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Subject dst = link.getLinkTarget();
			Subject src = link.getLinkSource();
			result.add(new LesscodeLinkDescriptor(src, dst, link, LesscodeElementTypes.ElementBasedLink_4001, ElementBasedLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<LesscodeLinkDescriptor> getIncomingTypeModelFacetLinks_ElementBasedLink_4001(Subject target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != LesscodePackage.eINSTANCE.getElementBasedLink_LinkTarget() || false == setting.getEObject() instanceof ElementBasedLink) {
				continue;
			}
			ElementBasedLink link = (ElementBasedLink) setting.getEObject();
			if (ElementBasedLinkEditPart.VISUAL_ID != LesscodeVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Subject src = link.getLinkSource();
			result.add(new LesscodeLinkDescriptor(src, target, link, LesscodeElementTypes.ElementBasedLink_4001, ElementBasedLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<LesscodeLinkDescriptor> getIncomingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(Subject target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == LesscodePackage.eINSTANCE.getSubject_ReferenceBasedLinkTarget()) {
				result.add(new LesscodeLinkDescriptor(setting.getEObject(), target, LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002, SubjectReferenceBasedLinkTargetEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<LesscodeLinkDescriptor> getOutgoingTypeModelFacetLinks_ElementBasedLink_4001(Subject source) {
		RootContainer container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof RootContainer) {
				container = (RootContainer) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		for (Iterator<?> links = container.getElementBasedLinks().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ElementBasedLink) {
				continue;
			}
			ElementBasedLink link = (ElementBasedLink) linkObject;
			if (ElementBasedLinkEditPart.VISUAL_ID != LesscodeVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Subject dst = link.getLinkTarget();
			Subject src = link.getLinkSource();
			if (src != source) {
				continue;
			}
			result.add(new LesscodeLinkDescriptor(src, dst, link, LesscodeElementTypes.ElementBasedLink_4001, ElementBasedLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<LesscodeLinkDescriptor> getOutgoingFeatureModelFacetLinks_Subject_ReferenceBasedLinkTarget_4002(Subject source) {
		LinkedList<LesscodeLinkDescriptor> result = new LinkedList<LesscodeLinkDescriptor>();
		for (Iterator<?> destinations = source.getReferenceBasedLinkTarget().iterator(); destinations.hasNext();) {
			Subject destination = (Subject) destinations.next();
			result.add(new LesscodeLinkDescriptor(source, destination, LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002, SubjectReferenceBasedLinkTargetEditPart.VISUAL_ID));
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
		public List<LesscodeNodeDescriptor> getSemanticChildren(View view) {
			return LesscodeDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<LesscodeLinkDescriptor> getContainedLinks(View view) {
			return LesscodeDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<LesscodeLinkDescriptor> getIncomingLinks(View view) {
			return LesscodeDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<LesscodeLinkDescriptor> getOutgoingLinks(View view) {
			return LesscodeDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
