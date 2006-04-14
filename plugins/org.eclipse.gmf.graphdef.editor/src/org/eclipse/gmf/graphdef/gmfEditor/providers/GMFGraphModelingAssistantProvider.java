package org.eclipse.gmf.graphdef.gmfEditor.providers;

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
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.CanvasEditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.Ellipse2EditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.EllipseEditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.FigureGallery_FiguresEditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.Rectangle2EditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.RectangleEditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.RoundedRectangle2EditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.RoundedRectangleEditPart;

import org.eclipse.gmf.graphdef.gmfEditor.part.GMFGraphDiagramEditorPlugin;

/**
 * @generated
 */
public class GMFGraphModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof RectangleEditPart) {
			List types = new ArrayList();
			types.add(GMFGraphElementTypes.Rectangle_2002);
			types.add(GMFGraphElementTypes.Ellipse_2003);
			types.add(GMFGraphElementTypes.RoundedRectangle_2004);
			types.add(GMFGraphElementTypes.Polyline_2005);
			return types;
		}
		if (editPart instanceof Rectangle2EditPart) {
			List types = new ArrayList();
			types.add(GMFGraphElementTypes.Rectangle_2002);
			types.add(GMFGraphElementTypes.Ellipse_2003);
			types.add(GMFGraphElementTypes.RoundedRectangle_2004);
			types.add(GMFGraphElementTypes.Polyline_2005);
			return types;
		}
		if (editPart instanceof EllipseEditPart) {
			List types = new ArrayList();
			types.add(GMFGraphElementTypes.Rectangle_2002);
			types.add(GMFGraphElementTypes.Ellipse_2003);
			types.add(GMFGraphElementTypes.RoundedRectangle_2004);
			types.add(GMFGraphElementTypes.Polyline_2005);
			return types;
		}
		if (editPart instanceof RoundedRectangleEditPart) {
			List types = new ArrayList();
			types.add(GMFGraphElementTypes.Rectangle_2002);
			types.add(GMFGraphElementTypes.Ellipse_2003);
			types.add(GMFGraphElementTypes.RoundedRectangle_2004);
			types.add(GMFGraphElementTypes.Polyline_2005);
			return types;
		}
		if (editPart instanceof Ellipse2EditPart) {
			List types = new ArrayList();
			types.add(GMFGraphElementTypes.Rectangle_2002);
			types.add(GMFGraphElementTypes.Ellipse_2003);
			types.add(GMFGraphElementTypes.RoundedRectangle_2004);
			types.add(GMFGraphElementTypes.Polyline_2005);
			return types;
		}
		if (editPart instanceof RoundedRectangle2EditPart) {
			List types = new ArrayList();
			types.add(GMFGraphElementTypes.Rectangle_2002);
			types.add(GMFGraphElementTypes.Ellipse_2003);
			types.add(GMFGraphElementTypes.RoundedRectangle_2004);
			types.add(GMFGraphElementTypes.Polyline_2005);
			return types;
		}
		if (editPart instanceof FigureGallery_FiguresEditPart) {
			List types = new ArrayList();
			types.add(GMFGraphElementTypes.Rectangle_2001);
			types.add(GMFGraphElementTypes.Ellipse_2006);
			types.add(GMFGraphElementTypes.RoundedRectangle_2007);
			types.add(GMFGraphElementTypes.Polyline_2008);
			return types;
		}
		if (editPart instanceof CanvasEditPart) {
			List types = new ArrayList();
			types.add(GMFGraphElementTypes.Compartment_1001);
			types.add(GMFGraphElementTypes.Node_1002);
			types.add(GMFGraphElementTypes.Connection_1003);
			types.add(GMFGraphElementTypes.FigureGallery_1004);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
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
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(GMFGraphDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
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
