/*
 * Copyright (c) 2006, 2007 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.providers;

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
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;

import org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin;

/**
 * @generated
 */
public class EcoreModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof EClassEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAttribute_3001);
			types.add(EcoreElementTypes.EOperation_3002);
			types.add(EcoreElementTypes.EAnnotation_3003);
			return types;
		}
		if (editPart instanceof EPackage2EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EClass_3004);
			types.add(EcoreElementTypes.EPackage_3005);
			types.add(EcoreElementTypes.EDataType_3006);
			types.add(EcoreElementTypes.EEnum_3007);
			types.add(EcoreElementTypes.EAnnotation_3003);
			return types;
		}
		if (editPart instanceof EAnnotationEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EStringToStringMapEntry_3008);
			return types;
		}
		if (editPart instanceof EDataTypeEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotation_3003);
			return types;
		}
		if (editPart instanceof EEnumEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EEnumLiteral_3009);
			types.add(EcoreElementTypes.EAnnotation_3003);
			return types;
		}
		if (editPart instanceof EPackageEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EClass_2001);
			types.add(EcoreElementTypes.EPackage_2002);
			types.add(EcoreElementTypes.EAnnotation_2003);
			types.add(EcoreElementTypes.EDataType_2004);
			types.add(EcoreElementTypes.EEnum_2005);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof EAnnotationEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotationReferences_4001);
			return types;
		}
		if (sourceEditPart instanceof EAnnotation2EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EAnnotationReferences_4001);
			return types;
		}
		if (sourceEditPart instanceof EClassEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EReference_4002);
			types.add(EcoreElementTypes.EReference_4003);
			types.add(EcoreElementTypes.EClassESuperTypes_4004);
			return types;
		}
		if (sourceEditPart instanceof EClass2EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EReference_4002);
			types.add(EcoreElementTypes.EReference_4003);
			types.add(EcoreElementTypes.EClassESuperTypes_4004);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof EClassEditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EClassESuperTypes_4004);
			return types;
		}
		if (targetEditPart instanceof EClass2EditPart) {
			List types = new ArrayList();
			types.add(EcoreElementTypes.EClassESuperTypes_4004);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof EAnnotationEditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EAnnotation2EditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EClassEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof EClassEditPart) {
				types.add(EcoreElementTypes.EClassESuperTypes_4004);
			}
			if (targetEditPart instanceof EClass2EditPart) {
				types.add(EcoreElementTypes.EClassESuperTypes_4004);
			}
			return types;
		}
		if (sourceEditPart instanceof EClass2EditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof EClassEditPart) {
				types.add(EcoreElementTypes.EClassESuperTypes_4004);
			}
			if (targetEditPart instanceof EClass2EditPart) {
				types.add(EcoreElementTypes.EClassESuperTypes_4004);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof EClassEditPart) {
			List types = new ArrayList();
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_4004) {
				types.add(EcoreElementTypes.EClass_2001);
			}
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_4004) {
				types.add(EcoreElementTypes.EClass_3004);
			}
			return types;
		}
		if (targetEditPart instanceof EClass2EditPart) {
			List types = new ArrayList();
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_4004) {
				types.add(EcoreElementTypes.EClass_2001);
			}
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_4004) {
				types.add(EcoreElementTypes.EClass_3004);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof EAnnotationEditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EAnnotation2EditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof EClassEditPart) {
			List types = new ArrayList();
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_4004) {
				types.add(EcoreElementTypes.EClass_2001);
			}
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_4004) {
				types.add(EcoreElementTypes.EClass_3004);
			}
			return types;
		}
		if (sourceEditPart instanceof EClass2EditPart) {
			List types = new ArrayList();
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_4004) {
				types.add(EcoreElementTypes.EClass_2001);
			}
			if (relationshipType == EcoreElementTypes.EClassESuperTypes_4004) {
				types.add(EcoreElementTypes.EClass_3004);
			}
			return types;
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
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(EcoreDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
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
