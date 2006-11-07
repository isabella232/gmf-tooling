/*
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.ecore.navigator;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationSourceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassESuperTypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceName2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;

import org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin;
import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

import org.eclipse.gmf.ecore.providers.EcoreElementTypes;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;

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
public class EcoreNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		EcoreDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?InvalidElement", ImageDescriptor.getMissingImageDescriptor());
		EcoreDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor());
		EcoreDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof EcoreNavigatorItem && !isOwnView(((EcoreNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof EcoreNavigatorGroup) {
			EcoreNavigatorGroup group = (EcoreNavigatorGroup) element;
			return EcoreDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof EcoreNavigatorItem) {
			EcoreNavigatorItem navigatorItem = (EcoreNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}
		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EClassEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EClass", EcoreElementTypes.EClass_2001);
		case EPackage2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EPackage", EcoreElementTypes.EPackage_2002);
		case EAnnotation2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EAnnotation", EcoreElementTypes.EAnnotation_2003);
		case EDataType2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EDataType", EcoreElementTypes.EDataType_2004);
		case EEnum2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EEnum", EcoreElementTypes.EEnum_2005);
		case EAttributeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EAttribute", EcoreElementTypes.EAttribute_3001);
		case EOperationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EOperation", EcoreElementTypes.EOperation_3002);
		case EAnnotationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EAnnotation", EcoreElementTypes.EAnnotation_3003);
		case EClass2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EClass", EcoreElementTypes.EClass_3004);
		case EPackage3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EPackage", EcoreElementTypes.EPackage_3005);
		case EDataTypeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EDataType", EcoreElementTypes.EDataType_3006);
		case EEnumEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EEnum", EcoreElementTypes.EEnum_3007);
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EStringToStringMapEntry", EcoreElementTypes.EStringToStringMapEntry_3008);
		case EEnumLiteralEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EEnumLiteral", EcoreElementTypes.EEnumLiteral_3009);
		case EPackageEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/emf/2002/Ecore?EPackage", EcoreElementTypes.EPackage_1000);
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/emf/2002/Ecore?EAnnotation?references", EcoreElementTypes.EAnnotationReferences_4001);
		case EReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/emf/2002/Ecore?EReference", EcoreElementTypes.EReference_4002);
		case EReference2EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/emf/2002/Ecore?EReference", EcoreElementTypes.EReference_4003);
		case EClassESuperTypesEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/emf/2002/Ecore?EClass?eSuperTypes", EcoreElementTypes.EClassESuperTypes_4004);
		default:
			return getImage("Navigator?UnknownElement", null);
		}
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = EcoreDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && EcoreElementTypes.isKnownElementType(elementType)) {
			image = EcoreElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound");
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof EcoreNavigatorGroup) {
			EcoreNavigatorGroup group = (EcoreNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof EcoreNavigatorItem) {
			EcoreNavigatorItem navigatorItem = (EcoreNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}
		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EClassEditPart.VISUAL_ID:
			return getEClass_2001Text(view);
		case EPackage2EditPart.VISUAL_ID:
			return getEPackage_2002Text(view);
		case EAnnotation2EditPart.VISUAL_ID:
			return getEAnnotation_2003Text(view);
		case EDataType2EditPart.VISUAL_ID:
			return getEDataType_2004Text(view);
		case EEnum2EditPart.VISUAL_ID:
			return getEEnum_2005Text(view);
		case EAttributeEditPart.VISUAL_ID:
			return getEAttribute_3001Text(view);
		case EOperationEditPart.VISUAL_ID:
			return getEOperation_3002Text(view);
		case EAnnotationEditPart.VISUAL_ID:
			return getEAnnotation_3003Text(view);
		case EClass2EditPart.VISUAL_ID:
			return getEClass_3004Text(view);
		case EPackage3EditPart.VISUAL_ID:
			return getEPackage_3005Text(view);
		case EDataTypeEditPart.VISUAL_ID:
			return getEDataType_3006Text(view);
		case EEnumEditPart.VISUAL_ID:
			return getEEnum_3007Text(view);
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getEStringToStringMapEntry_3008Text(view);
		case EEnumLiteralEditPart.VISUAL_ID:
			return getEEnumLiteral_3009Text(view);
		case EPackageEditPart.VISUAL_ID:
			return getEPackage_1000Text(view);
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return getEAnnotationReferences_4001Text(view);
		case EReferenceEditPart.VISUAL_ID:
			return getEReference_4002Text(view);
		case EReference2EditPart.VISUAL_ID:
			return getEReference_4003Text(view);
		case EClassESuperTypesEditPart.VISUAL_ID:
			return getEClassESuperTypes_4004Text(view);
		default:
			return getUnknownElementText(view);
		}
	}

	/**
	 * @generated
	 */
	private String getEClass_2001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EClassNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EClass_2001;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEPackage_2002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EPackageNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EPackage_2002;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEAnnotation_2003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EAnnotationSourceEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EAnnotation_2003;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEDataType_2004Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EDataTypeNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EDataType_2004;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEEnum_2005Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EEnumNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EEnum_2005;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEAttribute_3001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EAttributeEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EAttribute_3001;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEOperation_3002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EOperationEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EOperation_3002;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEAnnotation_3003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EAnnotation_3003;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEClass_3004Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EClass_3004;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3004);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEPackage_3005Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EPackage3EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EPackage_3005;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3005);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEDataType_3006Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EDataType_3006;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3006);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEEnum_3007Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EEnum_3007;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3007);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEStringToStringMapEntry_3008Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EStringToStringMapEntryEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EStringToStringMapEntry_3008;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3008);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEEnumLiteral_3009Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EEnumLiteralEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EEnumLiteral_3009;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3009);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEPackage_1000Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((ENamedElement) domainModelElement).getName();
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEAnnotationReferences_4001Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getEReference_4002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EReferenceNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EReference_4002;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEReference_4003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return EcoreVisualIDRegistry.getType(EReferenceName2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return EcoreElementTypes.EReference_4003;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEClassESuperTypes_4004Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">";
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
		return EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(view));
	}

}
