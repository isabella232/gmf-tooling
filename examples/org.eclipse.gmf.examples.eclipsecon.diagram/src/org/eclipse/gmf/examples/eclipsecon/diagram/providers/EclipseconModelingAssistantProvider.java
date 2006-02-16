package org.eclipse.gmf.examples.eclipsecon.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.ConferenceEditPart;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.PresenterEditPart;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.ScheduleEditPart;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.TimeSlotEditPart;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.TutorialEditPart;

import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconDiagramEditorPlugin;

/**
 * @generated
 */
public class EclipseconModelingAssistantProvider extends
		ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof ScheduleEditPart) {
			List types = new ArrayList();
			types.add(EclipseconElementTypes.TimeSlot_2001);
			return types;
		}
		if (editPart instanceof ConferenceEditPart) {
			List types = new ArrayList();
			types.add(EclipseconElementTypes.Presenter_1001);
			types.add(EclipseconElementTypes.Schedule_1002);
			types.add(EclipseconElementTypes.Tutorial_1003);
			types.add(EclipseconElementTypes.Resource_1004);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof TutorialEditPart) {
			List types = new ArrayList();
			types.add(EclipseconElementTypes.Handout_3001);
			types.add(EclipseconElementTypes.TutorialPresenters_3002);
			types.add(EclipseconElementTypes.TutorialAssigned_3003);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ResourceEditPart) {
			List types = new ArrayList();
			types.add(EclipseconElementTypes.Handout_3001);
			return types;
		}
		if (targetEditPart instanceof PresenterEditPart) {
			List types = new ArrayList();
			types.add(EclipseconElementTypes.TutorialPresenters_3002);
			return types;
		}
		if (targetEditPart instanceof TimeSlotEditPart) {
			List types = new ArrayList();
			types.add(EclipseconElementTypes.TutorialAssigned_3003);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof TutorialEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof ResourceEditPart) {
				types.add(EclipseconElementTypes.Handout_3001);
			}
			if (targetEditPart instanceof PresenterEditPart) {
				types.add(EclipseconElementTypes.TutorialPresenters_3002);
			}
			if (targetEditPart instanceof TimeSlotEditPart) {
				types.add(EclipseconElementTypes.TutorialAssigned_3003);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ResourceEditPart) {
			List types = new ArrayList();
			if (relationshipType == EclipseconElementTypes.Handout_3001) {
				types.add(EclipseconElementTypes.Tutorial_1003);
			}
			return types;
		}
		if (targetEditPart instanceof PresenterEditPart) {
			List types = new ArrayList();
			if (relationshipType == EclipseconElementTypes.TutorialPresenters_3002) {
				types.add(EclipseconElementTypes.Tutorial_1003);
			}
			return types;
		}
		if (targetEditPart instanceof TimeSlotEditPart) {
			List types = new ArrayList();
			if (relationshipType == EclipseconElementTypes.TutorialAssigned_3003) {
				types.add(EclipseconElementTypes.Tutorial_1003);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof TutorialEditPart) {
			List types = new ArrayList();
			if (relationshipType == EclipseconElementTypes.Handout_3001) {
				types.add(EclipseconElementTypes.Resource_1004);
			}
			if (relationshipType == EclipseconElementTypes.TutorialPresenters_3002) {
				types.add(EclipseconElementTypes.Presenter_1001);
			}
			if (relationshipType == EclipseconElementTypes.TutorialAssigned_3003) {
				types.add(EclipseconElementTypes.TimeSlot_2001);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target,
				relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source,
				relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				EclipseconDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage("Available domain model elements:");
		dialog.setTitle("Select domain model element");
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
