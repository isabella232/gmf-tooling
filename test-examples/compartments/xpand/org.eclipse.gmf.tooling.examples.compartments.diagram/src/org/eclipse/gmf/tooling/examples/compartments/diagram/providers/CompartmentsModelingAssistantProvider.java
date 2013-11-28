package org.eclipse.gmf.tooling.examples.compartments.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_CEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_DEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_EEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeAEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeANodeCCompartmentEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsDiagramEditorPlugin;
import org.eclipse.gmf.tooling.examples.compartments.diagram.part.Messages;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class CompartmentsModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	* @generated
	*/
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof CanvasEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(CompartmentsElementTypes.TopNodeA_2001);
			types.add(CompartmentsElementTypes.TopNodeB_2002);
			return types;
		}
		if (editPart instanceof TopNodeAEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(CompartmentsElementTypes.ChildOfA_D_3002);
			return types;
		}
		if (editPart instanceof TopNodeBEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(CompartmentsElementTypes.ChildOfB_G_3004);
			types.add(CompartmentsElementTypes.ChildOfB_E_3003);
			types.add(CompartmentsElementTypes.ChildOfB_F_3006);
			return types;
		}
		if (editPart instanceof ChildOfB_GEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(CompartmentsElementTypes.ChildOfAffixed_3005);
			return types;
		}
		if (editPart instanceof TopNodeANodeCCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(CompartmentsElementTypes.ChildOfA_C_3001);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ChildOfB_EEditPart) {
			return ((ChildOfB_EEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ChildOfB_FEditPart) {
			return ((ChildOfB_FEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ChildOfA_CEditPart) {
			return ((ChildOfA_CEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ChildOfA_DEditPart) {
			return ((ChildOfA_DEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ChildOfB_EEditPart) {
			return ((ChildOfB_EEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ChildOfB_FEditPart) {
			return ((ChildOfB_FEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ChildOfA_CEditPart) {
			return ((ChildOfA_CEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ChildOfA_DEditPart) {
			return ((ChildOfA_DEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ChildOfB_EEditPart) {
			return ((ChildOfB_EEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ChildOfB_FEditPart) {
			return ((ChildOfB_FEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	* @generated
	*/
	public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}

	/**
	* @generated
	*/
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));
	}

	/**
	* @generated
	*/
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		return types.contains(type);
	}

	/**
	* @generated
	*/
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(CompartmentsDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
		dialog.setMessage(Messages.CompartmentsModelingAssistantProviderMessage);
		dialog.setTitle(Messages.CompartmentsModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
