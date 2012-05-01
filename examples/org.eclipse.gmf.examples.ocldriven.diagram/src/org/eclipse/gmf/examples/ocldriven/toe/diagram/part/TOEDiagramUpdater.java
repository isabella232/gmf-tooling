package org.eclipse.gmf.examples.ocldriven.toe.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.examples.ocldriven.toe.AllBase;
import org.eclipse.gmf.examples.ocldriven.toe.AllHolder;
import org.eclipse.gmf.examples.ocldriven.toe.Contribution;
import org.eclipse.gmf.examples.ocldriven.toe.Department;
import org.eclipse.gmf.examples.ocldriven.toe.Employee;
import org.eclipse.gmf.examples.ocldriven.toe.Manager;
import org.eclipse.gmf.examples.ocldriven.toe.Project;
import org.eclipse.gmf.examples.ocldriven.toe.TOEPackage;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.AllHolderEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ContributionEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Department2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentDepartment_staff2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentDepartment_staffEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Employee2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.EmployeeEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerLeadsEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerManagedDepartmentEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ProjectEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
* @generated
*/
public class TOEDiagramUpdater {

	/**
	* @generated
	*/
	public static List<TOENodeDescriptor> getSemanticChildren(View view) {
		switch (TOEVisualIDRegistry.getVisualID(view)) {
		case AllHolderEditPart.VISUAL_ID:
			return getAllHolder_1000SemanticChildren(view);
		case DepartmentDepartment_staffEditPart.VISUAL_ID:
			return getDepartmentDepartment_staff_7001SemanticChildren(view);
		case DepartmentDepartment_staff2EditPart.VISUAL_ID:
			return getDepartmentDepartment_staff_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<TOENodeDescriptor> getAllHolder_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		AllHolder modelElement = (AllHolder) view.getElement();
		LinkedList<TOENodeDescriptor> result = new LinkedList<TOENodeDescriptor>();
		for (Iterator<?> it = modelElement.getAll().iterator(); it.hasNext();) {
			AllBase childElement = (AllBase) it.next();
			int visualID = TOEVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EmployeeEditPart.VISUAL_ID) {
				result.add(new TOENodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DepartmentEditPart.VISUAL_ID) {
				result.add(new TOENodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ProjectEditPart.VISUAL_ID) {
				result.add(new TOENodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ManagerEditPart.VISUAL_ID) {
				result.add(new TOENodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<TOENodeDescriptor> getDepartmentDepartment_staff_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Department modelElement = (Department) containerView.getElement();
		LinkedList<TOENodeDescriptor> result = new LinkedList<TOENodeDescriptor>();
		for (Iterator<?> it = modelElement.getEmployees().iterator(); it.hasNext();) {
			Employee childElement = (Employee) it.next();
			int visualID = TOEVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Employee2EditPart.VISUAL_ID) {
				result.add(new TOENodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getSubDepartments().iterator(); it.hasNext();) {
			Department childElement = (Department) it.next();
			int visualID = TOEVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Department2EditPart.VISUAL_ID) {
				result.add(new TOENodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<TOENodeDescriptor> getDepartmentDepartment_staff_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Department modelElement = (Department) containerView.getElement();
		LinkedList<TOENodeDescriptor> result = new LinkedList<TOENodeDescriptor>();
		for (Iterator<?> it = modelElement.getEmployees().iterator(); it.hasNext();) {
			Employee childElement = (Employee) it.next();
			int visualID = TOEVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Employee2EditPart.VISUAL_ID) {
				result.add(new TOENodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getSubDepartments().iterator(); it.hasNext();) {
			Department childElement = (Department) it.next();
			int visualID = TOEVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Department2EditPart.VISUAL_ID) {
				result.add(new TOENodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<TOELinkDescriptor> getContainedLinks(View view) {
		switch (TOEVisualIDRegistry.getVisualID(view)) {
		case AllHolderEditPart.VISUAL_ID:
			return getAllHolder_1000ContainedLinks(view);
		case EmployeeEditPart.VISUAL_ID:
			return getEmployee_2001ContainedLinks(view);
		case DepartmentEditPart.VISUAL_ID:
			return getDepartment_2002ContainedLinks(view);
		case ProjectEditPart.VISUAL_ID:
			return getProject_2003ContainedLinks(view);
		case ManagerEditPart.VISUAL_ID:
			return getManager_2004ContainedLinks(view);
		case Employee2EditPart.VISUAL_ID:
			return getEmployee_3001ContainedLinks(view);
		case Department2EditPart.VISUAL_ID:
			return getDepartment_3002ContainedLinks(view);
		case ContributionEditPart.VISUAL_ID:
			return getContribution_4003ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<TOELinkDescriptor> getIncomingLinks(View view) {
		switch (TOEVisualIDRegistry.getVisualID(view)) {
		case EmployeeEditPart.VISUAL_ID:
			return getEmployee_2001IncomingLinks(view);
		case DepartmentEditPart.VISUAL_ID:
			return getDepartment_2002IncomingLinks(view);
		case ProjectEditPart.VISUAL_ID:
			return getProject_2003IncomingLinks(view);
		case ManagerEditPart.VISUAL_ID:
			return getManager_2004IncomingLinks(view);
		case Employee2EditPart.VISUAL_ID:
			return getEmployee_3001IncomingLinks(view);
		case Department2EditPart.VISUAL_ID:
			return getDepartment_3002IncomingLinks(view);
		case ContributionEditPart.VISUAL_ID:
			return getContribution_4003IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<TOELinkDescriptor> getOutgoingLinks(View view) {
		switch (TOEVisualIDRegistry.getVisualID(view)) {
		case EmployeeEditPart.VISUAL_ID:
			return getEmployee_2001OutgoingLinks(view);
		case DepartmentEditPart.VISUAL_ID:
			return getDepartment_2002OutgoingLinks(view);
		case ProjectEditPart.VISUAL_ID:
			return getProject_2003OutgoingLinks(view);
		case ManagerEditPart.VISUAL_ID:
			return getManager_2004OutgoingLinks(view);
		case Employee2EditPart.VISUAL_ID:
			return getEmployee_3001OutgoingLinks(view);
		case Department2EditPart.VISUAL_ID:
			return getDepartment_3002OutgoingLinks(view);
		case ContributionEditPart.VISUAL_ID:
			return getContribution_4003OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getAllHolder_1000ContainedLinks(View view) {
		AllHolder modelElement = (AllHolder) view.getElement();
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Contribution_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getEmployee_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getDepartment_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getProject_2003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getManager_2004ContainedLinks(View view) {
		Manager modelElement = (Manager) view.getElement();
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Manager_ManagedDepartment_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Manager_Leads_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getEmployee_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getDepartment_3002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getContribution_4003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getEmployee_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getDepartment_2002IncomingLinks(View view) {
		Department modelElement = (Department) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Manager_ManagedDepartment_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getProject_2003IncomingLinks(View view) {
		Project modelElement = (Project) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Manager_Leads_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getManager_2004IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getEmployee_3001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getDepartment_3002IncomingLinks(View view) {
		Department modelElement = (Department) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Manager_ManagedDepartment_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getContribution_4003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getEmployee_2001OutgoingLinks(View view) {
		Employee modelElement = (Employee) view.getElement();
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Contribution_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getDepartment_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getProject_2003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getManager_2004OutgoingLinks(View view) {
		Manager modelElement = (Manager) view.getElement();
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Manager_ManagedDepartment_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Manager_Leads_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Contribution_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getEmployee_3001OutgoingLinks(View view) {
		Employee modelElement = (Employee) view.getElement();
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Contribution_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getDepartment_3002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TOELinkDescriptor> getContribution_4003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<TOELinkDescriptor> getContainedTypeModelFacetLinks_Contribution_4003(AllHolder container) {
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		for (Iterator<?> links = container.getAll().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Contribution) {
				continue;
			}
			Contribution link = (Contribution) linkObject;
			if (ContributionEditPart.VISUAL_ID != TOEVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Project dst = link.getProject();
			Employee src = link.getEmployee();
			result.add(new TOELinkDescriptor(src, dst, link, TOEElementTypes.Contribution_4003, ContributionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<TOELinkDescriptor> getIncomingFeatureModelFacetLinks_Manager_ManagedDepartment_4001(Department target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == TOEPackage.eINSTANCE.getManager_ManagedDepartment()) {
				result.add(new TOELinkDescriptor(setting.getEObject(), target, TOEElementTypes.ManagerManagedDepartment_4001, ManagerManagedDepartmentEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<TOELinkDescriptor> getIncomingFeatureModelFacetLinks_Manager_Leads_4002(Project target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == TOEPackage.eINSTANCE.getManager_Leads()) {
				result.add(new TOELinkDescriptor(setting.getEObject(), target, TOEElementTypes.ManagerLeads_4002, ManagerLeadsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<TOELinkDescriptor> getIncomingTypeModelFacetLinks_Contribution_4003(Project target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != TOEPackage.eINSTANCE.getContribution_Project() || false == setting.getEObject() instanceof Contribution) {
				continue;
			}
			Contribution link = (Contribution) setting.getEObject();
			if (ContributionEditPart.VISUAL_ID != TOEVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Employee src = link.getEmployee();
			result.add(new TOELinkDescriptor(src, target, link, TOEElementTypes.Contribution_4003, ContributionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<TOELinkDescriptor> getOutgoingFeatureModelFacetLinks_Manager_ManagedDepartment_4001(Manager source) {
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		Department destination = source.getManagedDepartment();
		if (destination == null) {
			return result;
		}
		result.add(new TOELinkDescriptor(source, destination, TOEElementTypes.ManagerManagedDepartment_4001, ManagerManagedDepartmentEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<TOELinkDescriptor> getOutgoingFeatureModelFacetLinks_Manager_Leads_4002(Manager source) {
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		for (Iterator<?> destinations = source.getLeads().iterator(); destinations.hasNext();) {
			Project destination = (Project) destinations.next();
			result.add(new TOELinkDescriptor(source, destination, TOEElementTypes.ManagerLeads_4002, ManagerLeadsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<TOELinkDescriptor> getOutgoingTypeModelFacetLinks_Contribution_4003(Employee source) {
		AllHolder container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof AllHolder) {
				container = (AllHolder) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<TOELinkDescriptor> result = new LinkedList<TOELinkDescriptor>();
		for (Iterator<?> links = container.getAll().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Contribution) {
				continue;
			}
			Contribution link = (Contribution) linkObject;
			if (ContributionEditPart.VISUAL_ID != TOEVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Project dst = link.getProject();
			Employee src = link.getEmployee();
			if (src != source) {
				continue;
			}
			result.add(new TOELinkDescriptor(src, dst, link, TOEElementTypes.Contribution_4003, ContributionEditPart.VISUAL_ID));
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
		public List<TOENodeDescriptor> getSemanticChildren(View view) {
			return TOEDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<TOELinkDescriptor> getContainedLinks(View view) {
			return TOEDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<TOELinkDescriptor> getIncomingLinks(View view) {
			return TOEDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override
		public List<TOELinkDescriptor> getOutgoingLinks(View view) {
			return TOEDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
