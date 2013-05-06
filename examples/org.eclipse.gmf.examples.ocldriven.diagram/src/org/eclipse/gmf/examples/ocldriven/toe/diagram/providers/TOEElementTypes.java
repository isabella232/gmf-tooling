package org.eclipse.gmf.examples.ocldriven.toe.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.examples.ocldriven.toe.TOEPackage;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.AllHolderEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ContributionEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Department2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Employee2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.EmployeeEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerLeadsEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerManagedDepartmentEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ProjectEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEDiagramEditorPlugin;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DefaultElementTypeImages;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class TOEElementTypes {

	/**
	* @generated
	*/
	private TOEElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DefaultElementTypeImages elementTypeImages = new DefaultElementTypeImages(TOEDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType AllHolder_1000 = getElementType("org.eclipse.gmf.examples.ocldriven.diagram.AllHolder_1000"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Employee_2001 = getElementType("org.eclipse.gmf.examples.ocldriven.diagram.Employee_2001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Department_2002 = getElementType("org.eclipse.gmf.examples.ocldriven.diagram.Department_2002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Project_2003 = getElementType("org.eclipse.gmf.examples.ocldriven.diagram.Project_2003"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Manager_2004 = getElementType("org.eclipse.gmf.examples.ocldriven.diagram.Manager_2004"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Employee_3001 = getElementType("org.eclipse.gmf.examples.ocldriven.diagram.Employee_3001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Department_3002 = getElementType("org.eclipse.gmf.examples.ocldriven.diagram.Department_3002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ManagerManagedDepartment_4001 = getElementType("org.eclipse.gmf.examples.ocldriven.diagram.ManagerManagedDepartment_4001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ManagerLeads_4002 = getElementType("org.eclipse.gmf.examples.ocldriven.diagram.ManagerLeads_4002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Contribution_4003 = getElementType("org.eclipse.gmf.examples.ocldriven.diagram.Contribution_4003"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(AllHolder_1000, TOEPackage.eINSTANCE.getAllHolder());

			elements.put(Employee_2001, TOEPackage.eINSTANCE.getEmployee());

			elements.put(Department_2002, TOEPackage.eINSTANCE.getDepartment());

			elements.put(Project_2003, TOEPackage.eINSTANCE.getProject());

			elements.put(Manager_2004, TOEPackage.eINSTANCE.getManager());

			elements.put(Employee_3001, TOEPackage.eINSTANCE.getEmployee());

			elements.put(Department_3002, TOEPackage.eINSTANCE.getDepartment());

			elements.put(ManagerManagedDepartment_4001, TOEPackage.eINSTANCE.getManager_ManagedDepartment());

			elements.put(ManagerLeads_4002, TOEPackage.eINSTANCE.getManager_Leads());

			elements.put(Contribution_4003, TOEPackage.eINSTANCE.getContribution());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(AllHolder_1000);
			KNOWN_ELEMENT_TYPES.add(Employee_2001);
			KNOWN_ELEMENT_TYPES.add(Department_2002);
			KNOWN_ELEMENT_TYPES.add(Project_2003);
			KNOWN_ELEMENT_TYPES.add(Manager_2004);
			KNOWN_ELEMENT_TYPES.add(Employee_3001);
			KNOWN_ELEMENT_TYPES.add(Department_3002);
			KNOWN_ELEMENT_TYPES.add(ManagerManagedDepartment_4001);
			KNOWN_ELEMENT_TYPES.add(ManagerLeads_4002);
			KNOWN_ELEMENT_TYPES.add(Contribution_4003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case AllHolderEditPart.VISUAL_ID:
			return AllHolder_1000;
		case EmployeeEditPart.VISUAL_ID:
			return Employee_2001;
		case DepartmentEditPart.VISUAL_ID:
			return Department_2002;
		case ProjectEditPart.VISUAL_ID:
			return Project_2003;
		case ManagerEditPart.VISUAL_ID:
			return Manager_2004;
		case Employee2EditPart.VISUAL_ID:
			return Employee_3001;
		case Department2EditPart.VISUAL_ID:
			return Department_3002;
		case ManagerManagedDepartmentEditPart.VISUAL_ID:
			return ManagerManagedDepartment_4001;
		case ManagerLeadsEditPart.VISUAL_ID:
			return ManagerLeads_4002;
		case ContributionEditPart.VISUAL_ID:
			return Contribution_4003;
		}
		return null;
	}

}
