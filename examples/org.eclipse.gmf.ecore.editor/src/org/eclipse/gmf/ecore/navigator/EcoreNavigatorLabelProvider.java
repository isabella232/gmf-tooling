/*
 * Copyright (c) 2006, 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EPackage;
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
import org.eclipse.gmf.ecore.providers.EcoreParserProvider;
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
public class EcoreNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		EcoreDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		EcoreDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
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
		case EPackageEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/emf/2002/Ecore?EPackage", EcoreElementTypes.EPackage_1000); //$NON-NLS-1$
		case EClassEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EClass", EcoreElementTypes.EClass_2001); //$NON-NLS-1$
		case EPackage2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EPackage", EcoreElementTypes.EPackage_2002); //$NON-NLS-1$
		case EAnnotationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EAnnotation", EcoreElementTypes.EAnnotation_2003); //$NON-NLS-1$
		case EDataTypeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EDataType", EcoreElementTypes.EDataType_2004); //$NON-NLS-1$
		case EEnumEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EEnum", EcoreElementTypes.EEnum_2005); //$NON-NLS-1$
		case EAttributeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EAttribute", EcoreElementTypes.EAttribute_3001); //$NON-NLS-1$
		case EOperationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EOperation", EcoreElementTypes.EOperation_3002); //$NON-NLS-1$
		case EAnnotation2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EAnnotation", EcoreElementTypes.EAnnotation_3003); //$NON-NLS-1$
		case EClass2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EClass", EcoreElementTypes.EClass_3004); //$NON-NLS-1$
		case EPackage3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EPackage", EcoreElementTypes.EPackage_3005); //$NON-NLS-1$
		case EDataType2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EDataType", EcoreElementTypes.EDataType_3006); //$NON-NLS-1$
		case EEnum2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EEnum", EcoreElementTypes.EEnum_3007); //$NON-NLS-1$
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EStringToStringMapEntry", EcoreElementTypes.EStringToStringMapEntry_3008); //$NON-NLS-1$
		case EEnumLiteralEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EEnumLiteral", EcoreElementTypes.EEnumLiteral_3009); //$NON-NLS-1$
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/emf/2002/Ecore?EAnnotation?references", EcoreElementTypes.EAnnotationReferences_4001); //$NON-NLS-1$
		case EReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/emf/2002/Ecore?EReference", EcoreElementTypes.EReference_4002); //$NON-NLS-1$
		case EReference2EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/emf/2002/Ecore?EReference", EcoreElementTypes.EReference_4003); //$NON-NLS-1$
		case EClassESuperTypesEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/emf/2002/Ecore?EClass?eSuperTypes", EcoreElementTypes.EClassESuperTypes_4004); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
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
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
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
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EPackageEditPart.VISUAL_ID:
			return getEPackage_1000Text(view);
		case EClassEditPart.VISUAL_ID:
			return getEClass_2001Text(view);
		case EPackage2EditPart.VISUAL_ID:
			return getEPackage_2002Text(view);
		case EAnnotationEditPart.VISUAL_ID:
			return getEAnnotation_2003Text(view);
		case EDataTypeEditPart.VISUAL_ID:
			return getEDataType_2004Text(view);
		case EEnumEditPart.VISUAL_ID:
			return getEEnum_2005Text(view);
		case EAttributeEditPart.VISUAL_ID:
			return getEAttribute_3001Text(view);
		case EOperationEditPart.VISUAL_ID:
			return getEOperation_3002Text(view);
		case EAnnotation2EditPart.VISUAL_ID:
			return getEAnnotation_3003Text(view);
		case EClass2EditPart.VISUAL_ID:
			return getEClass_3004Text(view);
		case EPackage3EditPart.VISUAL_ID:
			return getEPackage_3005Text(view);
		case EDataType2EditPart.VISUAL_ID:
			return getEDataType_3006Text(view);
		case EEnum2EditPart.VISUAL_ID:
			return getEEnum_3007Text(view);
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getEStringToStringMapEntry_3008Text(view);
		case EEnumLiteralEditPart.VISUAL_ID:
			return getEEnumLiteral_3009Text(view);
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return getEAnnotationReferences_4001Text(view);
		case EReferenceEditPart.VISUAL_ID:
			return getEReference_4002Text(view);
		case EReference2EditPart.VISUAL_ID:
			return getEReference_4003Text(view);
		case EClassESuperTypesEditPart.VISUAL_ID:
			return getEClassESuperTypes_4004Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getEPackage_1000Text(View view) {
		EPackage domainModelElement = (EPackage) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEClass_2001Text(View view) {
		IParser parser = EcoreParserProvider
				.getParser(EcoreElementTypes.EClass_2001, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry.getType(EClassNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEPackage_2002Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EPackage_2002, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EPackageNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEAnnotation_2003Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EAnnotation_2003, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EAnnotationSourceEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEDataType_2004Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EDataType_2004, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EDataTypeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEEnum_2005Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EEnum_2005, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry.getType(EEnumNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEAttribute_3001Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EAttribute_3001, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EAttributeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEOperation_3002Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EOperation_3002, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EOperationEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEAnnotation_3003Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EAnnotation_3003, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EAnnotation2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEClass_3004Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EClass_3004, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEPackage_3005Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EPackage_3005, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EPackage3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEDataType_3006Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EDataType_3006, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EDataType2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEEnum_3007Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EEnum_3007, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEStringToStringMapEntry_3008Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EStringToStringMapEntry_3008, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EStringToStringMapEntryEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEEnumLiteral_3009Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EEnumLiteral_3009, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EEnumLiteralEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEAnnotationReferences_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEReference_4002Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EReference_4002, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EReferenceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEReference_4003Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EReference_4003, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EReferenceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEClassESuperTypes_4004Text(View view) {
		return ""; //$NON-NLS-1$
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
		return EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(view));
	}

}
