package org.eclipse.gmf.examples.ocldriven.toe.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.ocldriven.toe.AllHolder;
import org.eclipse.gmf.examples.ocldriven.toe.Employee;
import org.eclipse.gmf.examples.ocldriven.toe.TOEPackage;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.AllHolderEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ContributionEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Department2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentDepartment_staff2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentDepartment_staffEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentName2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Employee2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.EmployeeEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.EmployeeName2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.EmployeeNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ProjectEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ProjectNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabel2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabel3EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabel4EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabel5EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabel6EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabelEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.expressions.TOEOCLFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
* This registry is used to determine which type of visual object should be
* created for the corresponding Diagram, Node, ChildNode or Link represented
* by a domain model object.
* 
* @generated
*/
public class TOEVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "org.eclipse.gmf.examples.ocldriven.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (AllHolderEditPart.MODEL_ID.equals(view.getType())) {
				return AllHolderEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry.getVisualID(view.getType());
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
				TOEDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
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
		if (TOEPackage.eINSTANCE.getAllHolder().isSuperTypeOf(domainElement.eClass()) && isDiagram((AllHolder) domainElement)) {
			return AllHolderEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry.getModelID(containerView);
		if (!AllHolderEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (AllHolderEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = AllHolderEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case AllHolderEditPart.VISUAL_ID:
			if (TOEPackage.eINSTANCE.getEmployee().isSuperTypeOf(domainElement.eClass()) && isEmployee_2001((Employee) domainElement)) {
				return EmployeeEditPart.VISUAL_ID;
			}
			if (TOEPackage.eINSTANCE.getDepartment().isSuperTypeOf(domainElement.eClass())) {
				return DepartmentEditPart.VISUAL_ID;
			}
			if (TOEPackage.eINSTANCE.getProject().isSuperTypeOf(domainElement.eClass())) {
				return ProjectEditPart.VISUAL_ID;
			}
			if (TOEPackage.eINSTANCE.getManager().isSuperTypeOf(domainElement.eClass())) {
				return ManagerEditPart.VISUAL_ID;
			}
			break;
		case DepartmentDepartment_staffEditPart.VISUAL_ID:
			if (TOEPackage.eINSTANCE.getEmployee().isSuperTypeOf(domainElement.eClass()) && isEmployee_3001((Employee) domainElement)) {
				return Employee2EditPart.VISUAL_ID;
			}
			if (TOEPackage.eINSTANCE.getDepartment().isSuperTypeOf(domainElement.eClass())) {
				return Department2EditPart.VISUAL_ID;
			}
			break;
		case DepartmentDepartment_staff2EditPart.VISUAL_ID:
			if (TOEPackage.eINSTANCE.getEmployee().isSuperTypeOf(domainElement.eClass()) && isEmployee_3001((Employee) domainElement)) {
				return Employee2EditPart.VISUAL_ID;
			}
			if (TOEPackage.eINSTANCE.getDepartment().isSuperTypeOf(domainElement.eClass())) {
				return Department2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry.getModelID(containerView);
		if (!AllHolderEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (AllHolderEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = AllHolderEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case AllHolderEditPart.VISUAL_ID:
			if (EmployeeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DepartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProjectEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ManagerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EmployeeEditPart.VISUAL_ID:
			if (EmployeeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DepartmentEditPart.VISUAL_ID:
			if (DepartmentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DepartmentDepartment_staffEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProjectEditPart.VISUAL_ID:
			if (ProjectNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ManagerEditPart.VISUAL_ID:
			if (ManagerNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Employee2EditPart.VISUAL_ID:
			if (EmployeeName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Department2EditPart.VISUAL_ID:
			if (DepartmentName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DepartmentDepartment_staff2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DepartmentDepartment_staffEditPart.VISUAL_ID:
			if (Employee2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Department2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DepartmentDepartment_staff2EditPart.VISUAL_ID:
			if (Employee2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Department2EditPart.VISUAL_ID == nodeVisualID) {
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
		if (TOEPackage.eINSTANCE.getContribution().isSuperTypeOf(domainElement.eClass())) {
			return ContributionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(AllHolder element) {
		return true;
	}

	/**
	* @generated
	*/
	private static boolean isEmployee_2001(Employee domainElement) {
		Object result = TOEOCLFactory.getExpression(0, TOEPackage.eINSTANCE.getEmployee(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	* @generated
	*/
	private static boolean isEmployee_3001(Employee domainElement) {
		Object result = TOEOCLFactory.getExpression(0, TOEPackage.eINSTANCE.getEmployee(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
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
		case DepartmentDepartment_staffEditPart.VISUAL_ID:
		case DepartmentDepartment_staff2EditPart.VISUAL_ID:
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
		case AllHolderEditPart.VISUAL_ID:
			return false;
		case EmployeeEditPart.VISUAL_ID:
		case ProjectEditPart.VISUAL_ID:
		case ManagerEditPart.VISUAL_ID:
		case Employee2EditPart.VISUAL_ID:
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
			return org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override
		public String getModelID(View view) {
			return org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		* @generated
		*/
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
