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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationDetailsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassAttributesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassClassAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassESuperTypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassOperationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeDataTypeAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEnumAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageClassesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageDataTypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEnumsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackagePackageAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackagePackagesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;

import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.viewers.Viewer;

import org.eclipse.ui.IMemento;

import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @generated
 */
public class EcoreNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	public void dispose() {
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) GMFEditingDomainFactory.INSTANCE.createEditingDomain();
			editingDomain.setResourceToReadOnlyMap(new HashMap() {

				public Object get(Object key) {
					if (!containsKey(key)) {
						put(key, Boolean.TRUE);
					}
					return super.get(key);
				}
			});
			ResourceSet resourceSet = editingDomain.getResourceSet();

			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = resourceSet.getResource(fileURI, true);

			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), EPackageEditPart.MODEL_ID), file));
			return result.toArray();
		}

		if (parentElement instanceof EcoreNavigatorGroup) {
			EcoreNavigatorGroup group = (EcoreNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof EcoreNavigatorItem) {
			EcoreNavigatorItem navigatorItem = (EcoreNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		// Due to plugin.xml content will be called only for "own" views
		if (parentElement instanceof IAdaptable) {
			View view = (View) ((IAdaptable) parentElement).getAdapter(View.class);
			if (view != null) {
				return getViewChildren(view, parentElement);
			}
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EClassEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getEClass_2001ToEAttribute_3001Children(view, parentElement));
			result.addAll(getEClass_2001ToEOperation_3002Children(view, parentElement));
			result.addAll(getEClass_2001ToEAnnotation_3003Children(view, parentElement));
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEClass_2001ToEAnnotationReferences_4001InSource(view, incominglinks));
			incominglinks.addChildren(getEClass_2001ToEReference_4002InSource(view, incominglinks));
			EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			outgoinglinks.addChildren(getEClass_2001ToEReference_4002OutTarget(view, outgoinglinks));
			incominglinks.addChildren(getEClass_2001ToEReference_4003InSource(view, incominglinks));
			outgoinglinks.addChildren(getEClass_2001ToEReference_4003OutTarget(view, outgoinglinks));
			incominglinks.addChildren(getEClass_2001ToEClassESuperTypes_4004InSource(view, incominglinks));
			outgoinglinks.addChildren(getEClass_2001ToEClassESuperTypes_4004OutTarget(view, outgoinglinks));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EPackage2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getEPackage_2002ToEClass_3004Children(view, parentElement));
			result.addAll(getEPackage_2002ToEPackage_3005Children(view, parentElement));
			result.addAll(getEPackage_2002ToEDataType_3006Children(view, parentElement));
			result.addAll(getEPackage_2002ToEEnum_3007Children(view, parentElement));
			result.addAll(getEPackage_2002ToEAnnotation_3003Children(view, parentElement));
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEPackage_2002ToEAnnotationReferences_4001InSource(view, incominglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EAnnotation2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getEAnnotation_2003ToEStringToStringMapEntry_3008Children(view, parentElement));
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEAnnotation_2003ToEAnnotationReferences_4001InSource(view, incominglinks));
			EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			outgoinglinks.addChildren(getEAnnotation_2003ToEAnnotationReferences_4001OutTarget(view, outgoinglinks));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EDataType2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getEDataType_2004ToEAnnotation_3003Children(view, parentElement));
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEDataType_2004ToEAnnotationReferences_4001InSource(view, incominglinks));
			incominglinks.addChildren(getEDataType_2004ToEReference_4002InSource(view, incominglinks));
			incominglinks.addChildren(getEDataType_2004ToEReference_4003InSource(view, incominglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EEnum2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getEEnum_2005ToEEnumLiteral_3009Children(view, parentElement));
			result.addAll(getEEnum_2005ToEAnnotation_3003Children(view, parentElement));
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEEnum_2005ToEAnnotationReferences_4001InSource(view, incominglinks));
			incominglinks.addChildren(getEEnum_2005ToEReference_4002InSource(view, incominglinks));
			incominglinks.addChildren(getEEnum_2005ToEReference_4003InSource(view, incominglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EAttributeEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEAttribute_3001ToEAnnotationReferences_4001InSource(view, incominglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EOperationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEOperation_3002ToEAnnotationReferences_4001InSource(view, incominglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EAnnotationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEAnnotation_3003ToEAnnotationReferences_4001InSource(view, incominglinks));
			EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			outgoinglinks.addChildren(getEAnnotation_3003ToEAnnotationReferences_4001OutTarget(view, outgoinglinks));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EClass2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEClass_3004ToEAnnotationReferences_4001InSource(view, incominglinks));
			incominglinks.addChildren(getEClass_3004ToEReference_4002InSource(view, incominglinks));
			EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			outgoinglinks.addChildren(getEClass_3004ToEReference_4002OutTarget(view, outgoinglinks));
			incominglinks.addChildren(getEClass_3004ToEReference_4003InSource(view, incominglinks));
			outgoinglinks.addChildren(getEClass_3004ToEReference_4003OutTarget(view, outgoinglinks));
			incominglinks.addChildren(getEClass_3004ToEClassESuperTypes_4004InSource(view, incominglinks));
			outgoinglinks.addChildren(getEClass_3004ToEClassESuperTypes_4004OutTarget(view, outgoinglinks));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EPackage3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEPackage_3005ToEAnnotationReferences_4001InSource(view, incominglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EDataTypeEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEDataType_3006ToEAnnotationReferences_4001InSource(view, incominglinks));
			incominglinks.addChildren(getEDataType_3006ToEReference_4002InSource(view, incominglinks));
			incominglinks.addChildren(getEDataType_3006ToEReference_4003InSource(view, incominglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EEnumEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEEnum_3007ToEAnnotationReferences_4001InSource(view, incominglinks));
			incominglinks.addChildren(getEEnum_3007ToEReference_4002InSource(view, incominglinks));
			incominglinks.addChildren(getEEnum_3007ToEReference_4003InSource(view, incominglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EEnumLiteralEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			incominglinks.addChildren(getEEnumLiteral_3009ToEAnnotationReferences_4001InSource(view, incominglinks));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}
		case EPackageEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			result.addAll(getEPackage_1000ToEClass_2001Children(view, parentElement));
			result.addAll(getEPackage_1000ToEPackage_2002Children(view, parentElement));
			result.addAll(getEPackage_1000ToEAnnotation_2003Children(view, parentElement));
			result.addAll(getEPackage_1000ToEDataType_2004Children(view, parentElement));
			result.addAll(getEPackage_1000ToEEnum_2005Children(view, parentElement));
			EcoreNavigatorGroup links = new EcoreNavigatorGroup("links", "icons/linksNavigatorGroup.gif", parentElement);
			links.addChildren(getEPackage_1000ToEAnnotationReferences_4001Children(view, links));
			links.addChildren(getEPackage_1000ToEReference_4002Children(view, links));
			links.addChildren(getEPackage_1000ToEReference_4003Children(view, links));
			links.addChildren(getEPackage_1000ToEClassESuperTypes_4004Children(view, links));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}
		case EAnnotationReferencesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup target = new EcoreNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", parentElement);
			target.addChildren(getEAnnotationReferences_4001ToEClass_2001OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEPackage_2002OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEAnnotation_2003OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEDataType_2004OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEEnum_2005OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEAttribute_3001OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEOperation_3002OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEAnnotation_3003OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEClass_3004OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEPackage_3005OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEDataType_3006OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEEnum_3007OutTarget((Edge) view, target));
			target.addChildren(getEAnnotationReferences_4001ToEEnumLiteral_3009OutTarget((Edge) view, target));
			EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			source.addChildren(getEAnnotationReferences_4001ToEAnnotation_2003InSource((Edge) view, source));
			source.addChildren(getEAnnotationReferences_4001ToEAnnotation_3003InSource((Edge) view, source));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		case EReferenceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup target = new EcoreNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", parentElement);
			target.addChildren(getEReference_4002ToEClass_2001OutTarget((Edge) view, target));
			target.addChildren(getEReference_4002ToEDataType_2004OutTarget((Edge) view, target));
			target.addChildren(getEReference_4002ToEEnum_2005OutTarget((Edge) view, target));
			target.addChildren(getEReference_4002ToEClass_3004OutTarget((Edge) view, target));
			target.addChildren(getEReference_4002ToEDataType_3006OutTarget((Edge) view, target));
			target.addChildren(getEReference_4002ToEEnum_3007OutTarget((Edge) view, target));
			EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			source.addChildren(getEReference_4002ToEClass_2001InSource((Edge) view, source));
			source.addChildren(getEReference_4002ToEClass_3004InSource((Edge) view, source));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		case EReference2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup target = new EcoreNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", parentElement);
			target.addChildren(getEReference_4003ToEClass_2001OutTarget((Edge) view, target));
			target.addChildren(getEReference_4003ToEDataType_2004OutTarget((Edge) view, target));
			target.addChildren(getEReference_4003ToEEnum_2005OutTarget((Edge) view, target));
			target.addChildren(getEReference_4003ToEClass_3004OutTarget((Edge) view, target));
			target.addChildren(getEReference_4003ToEDataType_3006OutTarget((Edge) view, target));
			target.addChildren(getEReference_4003ToEEnum_3007OutTarget((Edge) view, target));
			EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			source.addChildren(getEReference_4003ToEClass_2001InSource((Edge) view, source));
			source.addChildren(getEReference_4003ToEClass_3004InSource((Edge) view, source));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		case EClassESuperTypesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup target = new EcoreNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", parentElement);
			target.addChildren(getEClassESuperTypes_4004ToEClass_2001OutTarget((Edge) view, target));
			target.addChildren(getEClassESuperTypes_4004ToEClass_3004OutTarget((Edge) view, target));
			EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			source.addChildren(getEClassESuperTypes_4004ToEClass_2001InSource((Edge) view, source));
			source.addChildren(getEClassESuperTypes_4004ToEClass_3004InSource((Edge) view, source));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof EcoreAbstractNavigatorItem) {
			EcoreAbstractNavigatorItem abstractNavigatorItem = (EcoreAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
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
	private Collection getEAnnotationReferences_4001ToEDataType_2004OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEDataType_2004OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEDataType_2004OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEClassESuperTypes_4004OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_2001ToEClassESuperTypes_4004OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_2001ToEClassESuperTypes_4004OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEClass_3004InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4003ToEClass_3004InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4003ToEClass_3004InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEAttribute_3001OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EAttributeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEAttribute_3001OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEAttribute_3001OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_2005ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEEnum_2005ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEEnum_2005ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEOperation_3002Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassOperationsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EOperationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_2001ToEOperation_3002ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_2001ToEOperation_3002ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEClassESuperTypes_4004ToEClass_2001InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClassESuperTypes_4004ToEClass_2001InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClassESuperTypes_4004ToEClass_2001InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotation_2003ToEAnnotationReferences_4001OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotation_2003ToEAnnotationReferences_4001OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotation_2003ToEAnnotationReferences_4001OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEDataType_3006Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackageDataTypesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_2002ToEDataType_3006ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_2002ToEDataType_3006ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEAttribute_3001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassAttributesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EAttributeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_2001ToEAttribute_3001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_2001ToEAttribute_3001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEClassESuperTypes_4004InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_3004ToEClassESuperTypes_4004InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_3004ToEClassESuperTypes_4004InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEReference_4002InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_2001ToEReference_4002InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_2001ToEReference_4002InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEClass_3004OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEClass_3004OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEClass_3004OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_2004ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEDataType_2004ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEDataType_2004ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_2005ToEReference_4003InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEEnum_2005ToEReference_4003InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEEnum_2005ToEReference_4003InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_2004ToEReference_4002InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEDataType_2004ToEReference_4002InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEDataType_2004ToEReference_4002InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_3006ToEReference_4003InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEDataType_3006ToEReference_4003InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEDataType_3006ToEReference_4003InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEDataType_3006OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4003ToEDataType_3006OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4003ToEDataType_3006OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEAnnotation_2003Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotation2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_1000ToEAnnotation_2003ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_1000ToEAnnotation_2003ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEPackage_3005Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackagePackagesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EPackage3EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_2002ToEPackage_3005ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_2002ToEPackage_3005ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEReference_4003InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_3004ToEReference_4003InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_3004ToEReference_4003InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotation_3003ToEAnnotationReferences_4001OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotation_3003ToEAnnotationReferences_4001OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotation_3003ToEAnnotationReferences_4001OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_3007ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEEnum_3007ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEEnum_3007ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEAnnotation_3003Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassClassAnnotationsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_2001ToEAnnotation_3003ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_2001ToEAnnotation_3003ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEClass_2001InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4002ToEClass_2001InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4002ToEClass_2001InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEDataType_2004OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4003ToEDataType_2004OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4003ToEDataType_2004OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEEnum_2005OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4002ToEEnum_2005OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4002ToEEnum_2005OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEEnum_3007OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEEnum_3007OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEEnum_3007OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEEnumLiteral_3009ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEEnumLiteral_3009ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEEnumLiteral_3009ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEEnum_3007OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4003ToEEnum_3007OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4003ToEEnum_3007OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_3004ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_3004ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotation_3003ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotation_3003ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotation_3003ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEEnum_2005OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4003ToEEnum_2005OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4003ToEEnum_2005OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEEnum_3007OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4002ToEEnum_3007OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4002ToEEnum_3007OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEAnnotation_3003Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackagePackageAnnotationsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_2002ToEAnnotation_3003ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_2002ToEAnnotation_3003ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEReference_4002OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_3004ToEReference_4002OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_3004ToEReference_4002OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEOperation_3002ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEOperation_3002ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEOperation_3002ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEAnnotationReferences_4001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getDiagramLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_1000ToEAnnotationReferences_4001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_1000ToEAnnotationReferences_4001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEReference_4003InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_2001ToEReference_4003InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_2001ToEReference_4003InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_2005ToEReference_4002InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEEnum_2005ToEReference_4002InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEEnum_2005ToEReference_4002InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEReference_4002Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getDiagramLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_1000ToEReference_4002ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_1000ToEReference_4002ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEClass_2001OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEClass_2001OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEClass_2001OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEAnnotation_2003OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EAnnotation2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEAnnotation_2003OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEAnnotation_2003OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEClass_3004OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4002ToEClass_3004OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4002ToEClass_3004OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEOperation_3002OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EOperationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEOperation_3002OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEOperation_3002OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEClassESuperTypes_4004OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_3004ToEClassESuperTypes_4004OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_3004ToEClassESuperTypes_4004OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClassESuperTypes_4004ToEClass_3004OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClassESuperTypes_4004ToEClass_3004OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClassESuperTypes_4004ToEClass_3004OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEDataType_2004Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_1000ToEDataType_2004ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_1000ToEDataType_2004ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEClass_2001OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4003ToEClass_2001OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4003ToEClass_2001OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClassESuperTypes_4004ToEClass_2001OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClassESuperTypes_4004ToEClass_2001OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClassESuperTypes_4004ToEClass_2001OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEReference_4002InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_3004ToEReference_4002InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_3004ToEReference_4002InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEClass_3004Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackageClassesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_2002ToEClass_3004ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_2002ToEClass_3004ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_2005ToEEnumLiteral_3009Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EEnumLiteralsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EEnumLiteralEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEEnum_2005ToEEnumLiteral_3009ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEEnum_2005ToEEnumLiteral_3009ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEReference_4003OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_3004ToEReference_4003OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_3004ToEReference_4003OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEPackage_2002Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackage2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_1000ToEPackage_2002ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_1000ToEPackage_2002ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEEnum_2005Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_1000ToEEnum_2005ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_1000ToEEnum_2005ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEReference_4003OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_2001ToEReference_4003OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_2001ToEReference_4003OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_2004ToEReference_4003InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEDataType_2004ToEReference_4003InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEDataType_2004ToEReference_4003InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEAnnotation_2003InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EAnnotation2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEAnnotation_2003InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEAnnotation_2003InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEEnumLiteral_3009OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnumLiteralEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEEnumLiteral_3009OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEEnumLiteral_3009OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEEnum_2005OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEEnum_2005OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEEnum_2005OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEAnnotation_3003InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEAnnotation_3003InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEAnnotation_3003InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEEnum_3007Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackageEnumsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_2002ToEEnum_3007ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_2002ToEEnum_3007ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_3007ToEReference_4002InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEEnum_3007ToEReference_4002InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEEnum_3007ToEReference_4002InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEPackage_2002OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EPackage2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEPackage_2002OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEPackage_2002OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEReference_4003Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getDiagramLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_1000ToEReference_4003ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_1000ToEReference_4003ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEDataType_3006OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEDataType_3006OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEDataType_3006OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEClass_3004InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4002ToEClass_3004InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4002ToEClass_3004InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEDataType_2004OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4002ToEDataType_2004OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4002ToEDataType_2004OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEClass_2001Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_1000ToEClass_2001ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_1000ToEClass_2001ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_3006ToEReference_4002InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEDataType_3006ToEReference_4002InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEDataType_3006ToEReference_4002InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEPackage_3005OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EPackage3EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEPackage_3005OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEPackage_3005OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_3007ToEReference_4003InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEEnum_3007ToEReference_4003InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEEnum_3007ToEReference_4003InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotation_2003ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotation_2003ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotation_2003ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_2004ToEAnnotation_3003Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EDataTypeDataTypeAnnotationsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEDataType_2004ToEAnnotation_3003ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEDataType_2004ToEAnnotation_3003ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEAnnotation_3003OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotationReferences_4001ToEAnnotation_3003OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotationReferences_4001ToEAnnotation_3003OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEClassESuperTypes_4004InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_2001ToEClassESuperTypes_4004InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_2001ToEClassESuperTypes_4004InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotation_2003ToEStringToStringMapEntry_3008Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationDetailsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EStringToStringMapEntryEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAnnotation_2003ToEStringToStringMapEntry_3008ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAnnotation_2003ToEStringToStringMapEntry_3008ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEClassESuperTypes_4004Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getDiagramLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_1000ToEClassESuperTypes_4004ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_1000ToEClassESuperTypes_4004ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEClassESuperTypes_4004ToEClass_3004InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClassESuperTypes_4004ToEClass_3004InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClassESuperTypes_4004ToEClass_3004InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_2005ToEAnnotation_3003Children(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EEnumEnumAnnotationsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEEnum_2005ToEAnnotation_3003ChildrenLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEEnum_2005ToEAnnotation_3003ChildrenLeaf(View view) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEClass_2001InSource(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4003ToEClass_2001InSourceLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4003ToEClass_2001InSourceLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEClass_3004OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4003ToEClass_3004OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4003ToEClass_3004OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_2001ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_2001ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_2002ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_2002ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEReference_4002OutTarget(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEClass_2001ToEReference_4002OutTargetLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEClass_2001ToEReference_4002OutTargetLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_3005ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEPackage_3005ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEPackage_3005ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_3006ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEDataType_3006ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEDataType_3006ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEDataType_3006OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4002ToEDataType_3006OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4002ToEDataType_3006OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEAttribute_3001ToEAnnotationReferences_4001InSource(View view, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEAttribute_3001ToEAnnotationReferences_4001InSourceLeaf(view));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEAttribute_3001ToEAnnotationReferences_4001InSourceLeaf(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEClass_2001OutTarget(Edge edge, Object parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result, isEReference_4002ToEClass_2001OutTargetLeaf(edge));
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isEReference_4002ToEClass_2001OutTargetLeaf(Edge edge) {
		return true;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && !isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getTarget();
			if (type.equals(nextEdgeSource.getType()) && !isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, String type) {
		Collection result = new ArrayList();
		for (Iterator it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram) it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent) {
		Collection result = new ArrayList();
		createNavigatorItems(views, parent, result, false);
		return result;
	}

	/**
	 * @generated
	 */
	private void createNavigatorItems(Collection views, Object parent, Collection result, boolean isLeafs) {
		for (Iterator it = views.iterator(); it.hasNext();) {
			result.add(new EcoreNavigatorItem((View) it.next(), parent, isLeafs));
		}
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection getForeignShortcuts(Diagram diagram, Object parent) {
		Collection result = new ArrayList();
		for (Iterator it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (!isOwnView(nextView) && nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent);
	}

}
