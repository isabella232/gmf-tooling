package org.eclipse.gmf.examples.ocldriven.toe.diagram.navigator;

import org.eclipse.gmf.examples.ocldriven.toe.Contribution;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.AllHolderEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ContributionEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Department2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentName2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.Employee2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.EmployeeEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.EmployeeName2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.EmployeeNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerLeadsEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerManagedDepartmentEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ProjectEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ProjectNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEDiagramEditorPlugin;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class TOENavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		TOEDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		TOEDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof TOENavigatorItem && !isOwnView(((TOENavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof TOENavigatorGroup) {
			TOENavigatorGroup group = (TOENavigatorGroup) element;
			return TOEDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof TOENavigatorItem) {
			TOENavigatorItem navigatorItem = (TOENavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (TOEVisualIDRegistry.getVisualID(view)) {
		case ContributionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/examples/gmf/ocldriven/table-of-organization-and-equipment?Contribution", TOEElementTypes.Contribution_4003); //$NON-NLS-1$
		case ManagerManagedDepartmentEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/examples/gmf/ocldriven/table-of-organization-and-equipment?Manager?managedDepartment", TOEElementTypes.ManagerManagedDepartment_4001); //$NON-NLS-1$
		case ManagerLeadsEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/examples/gmf/ocldriven/table-of-organization-and-equipment?Manager?leads", TOEElementTypes.ManagerLeads_4002); //$NON-NLS-1$
		case Department2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/examples/gmf/ocldriven/table-of-organization-and-equipment?Department", TOEElementTypes.Department_3002); //$NON-NLS-1$
		case AllHolderEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/examples/gmf/ocldriven/table-of-organization-and-equipment?AllHolder", TOEElementTypes.AllHolder_1000); //$NON-NLS-1$
		case ManagerEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/examples/gmf/ocldriven/table-of-organization-and-equipment?Manager", TOEElementTypes.Manager_2004); //$NON-NLS-1$
		case ProjectEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/examples/gmf/ocldriven/table-of-organization-and-equipment?Project", TOEElementTypes.Project_2003); //$NON-NLS-1$
		case DepartmentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/examples/gmf/ocldriven/table-of-organization-and-equipment?Department", TOEElementTypes.Department_2002); //$NON-NLS-1$
		case Employee2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/examples/gmf/ocldriven/table-of-organization-and-equipment?Employee", TOEElementTypes.Employee_3001); //$NON-NLS-1$
		case EmployeeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/examples/gmf/ocldriven/table-of-organization-and-equipment?Employee", TOEElementTypes.Employee_2001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = TOEDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && TOEElementTypes.isKnownElementType(elementType)) {
			image = TOEElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof TOENavigatorGroup) {
			TOENavigatorGroup group = (TOENavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof TOENavigatorItem) {
			TOENavigatorItem navigatorItem = (TOENavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (TOEVisualIDRegistry.getVisualID(view)) {
		case ContributionEditPart.VISUAL_ID:
			return getContribution_4003Text(view);
		case ManagerManagedDepartmentEditPart.VISUAL_ID:
			return getManagerManagedDepartment_4001Text(view);
		case ManagerLeadsEditPart.VISUAL_ID:
			return getManagerLeads_4002Text(view);
		case Department2EditPart.VISUAL_ID:
			return getDepartment_3002Text(view);
		case AllHolderEditPart.VISUAL_ID:
			return getAllHolder_1000Text(view);
		case ManagerEditPart.VISUAL_ID:
			return getManager_2004Text(view);
		case ProjectEditPart.VISUAL_ID:
			return getProject_2003Text(view);
		case DepartmentEditPart.VISUAL_ID:
			return getDepartment_2002Text(view);
		case Employee2EditPart.VISUAL_ID:
			return getEmployee_3001Text(view);
		case EmployeeEditPart.VISUAL_ID:
			return getEmployee_2001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getContribution_4003Text(View view) {
		Contribution domainModelElement = (Contribution) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getDescription();
		} else {
			TOEDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDepartment_3002Text(View view) {
		IParser parser = TOEParserProvider.getParser(TOEElementTypes.Department_3002, view.getElement() != null ? view.getElement() : view,
				TOEVisualIDRegistry.getType(DepartmentName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TOEDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAllHolder_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getEmployee_2001Text(View view) {
		IParser parser = TOEParserProvider.getParser(TOEElementTypes.Employee_2001, view.getElement() != null ? view.getElement() : view, TOEVisualIDRegistry.getType(EmployeeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TOEDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getManager_2004Text(View view) {
		IParser parser = TOEParserProvider.getParser(TOEElementTypes.Manager_2004, view.getElement() != null ? view.getElement() : view, TOEVisualIDRegistry.getType(ManagerNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TOEDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDepartment_2002Text(View view) {
		IParser parser = TOEParserProvider.getParser(TOEElementTypes.Department_2002, view.getElement() != null ? view.getElement() : view,
				TOEVisualIDRegistry.getType(DepartmentNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TOEDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getManagerLeads_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getManagerManagedDepartment_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getEmployee_3001Text(View view) {
		IParser parser = TOEParserProvider.getParser(TOEElementTypes.Employee_3001, view.getElement() != null ? view.getElement() : view, TOEVisualIDRegistry.getType(EmployeeName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TOEDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getProject_2003Text(View view) {
		IParser parser = TOEParserProvider.getParser(TOEElementTypes.Project_2003, view.getElement() != null ? view.getElement() : view, TOEVisualIDRegistry.getType(ProjectNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TOEDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return AllHolderEditPart.MODEL_ID.equals(TOEVisualIDRegistry.getModelID(view));
	}

}
