/*
 *  Copyright (c) 2006, 2007 Borland Software Corp.
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
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
	public void init(ICommonContentExtensionSite aConfig) {
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

			org.eclipse.emf.common.util.URI fileURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = resourceSet.getResource(fileURI, true);
			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), EPackageEditPart.MODEL_ID), file, false));
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

		/*
		 * Due to plugin.xml restrictions this code will be called only for views representing
		 * shortcuts to this diagram elements created on other diagrams. 
		 */
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

		case EPackageEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			EcoreNavigatorGroup links = new EcoreNavigatorGroup("links", "icons/linksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getChildrenByType(Collections.singleton(view), EClassEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), EPackage2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), EAnnotation2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), EDataType2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), EEnum2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), EReferenceEditPart.VISUAL_ID);
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), EReference2EditPart.VISUAL_ID);
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), EClassESuperTypesEditPart.VISUAL_ID);
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case EClassEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getChildrenByType(Collections.singleton(view), EClassAttributesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EAttributeEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), EClassOperationsEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EOperationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), EClassClassAnnotationsEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EAnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReferenceEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), EReferenceEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReference2EditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), EReference2EditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EClassESuperTypesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), EClassESuperTypesEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EPackage2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getChildrenByType(Collections.singleton(view), EPackageClassesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EClass2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), EPackagePackagesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EPackage3EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), EPackageDataTypesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EDataTypeEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), EPackageEnumsEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EEnumEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), EPackagePackageAnnotationsEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EAnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EAnnotation2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getChildrenByType(Collections.singleton(view), EAnnotationDetailsEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EStringToStringMapEntryEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EDataType2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getChildrenByType(Collections.singleton(view), EDataTypeDataTypeAnnotationsEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EAnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReferenceEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReference2EditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EEnum2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getChildrenByType(Collections.singleton(view), EEnumLiteralsEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EEnumLiteralEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), EEnumEnumAnnotationsEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews, EAnnotationEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReferenceEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReference2EditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EAttributeEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EOperationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EAnnotationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EClass2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReferenceEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), EReferenceEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReference2EditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), EReference2EditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EClassESuperTypesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), EClassESuperTypesEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EPackage3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EDataTypeEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReferenceEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReference2EditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EEnumEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReferenceEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), EReference2EditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EEnumLiteralEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", parentElement);
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EAnnotationReferencesEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EAnnotationReferencesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			EcoreNavigatorGroup target = new EcoreNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", parentElement);
			EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), EClassEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EPackage2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EAnnotation2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EDataType2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EEnum2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EAttributeEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EOperationEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EAnnotationEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EClass2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EPackage3EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EDataTypeEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EEnumEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EEnumLiteralEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), EAnnotation2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), EAnnotationEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source, true));
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
			EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), EClassEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EDataType2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EEnum2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EClass2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EDataTypeEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EEnumEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), EClassEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), EClass2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source, true));
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
			EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), EClassEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EDataType2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EEnum2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EClass2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EDataTypeEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EEnumEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), EClassEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), EClass2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source, true));
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
			EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", parentElement);
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), EClassEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), EClass2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), EClassEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), EClass2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source, true));
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
	private Collection getLinksSourceByType(Collection edges, int visualID) {
		Collection result = new ArrayList();
		String type = EcoreVisualIDRegistry.getType(visualID);
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, int visualID) {
		Collection result = new ArrayList();
		String type = EcoreVisualIDRegistry.getType(visualID);
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = EcoreVisualIDRegistry.getType(visualID);
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = EcoreVisualIDRegistry.getType(visualID);
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = EcoreVisualIDRegistry.getType(visualID);
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, int visualID) {
		Collection result = new ArrayList();
		String type = EcoreVisualIDRegistry.getType(visualID);
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
	private boolean isOwnView(View view) {
		return EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent, boolean isLeafs) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			result.add(new EcoreNavigatorItem((View) it.next(), parent, isLeafs));
		}
		return result;
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
		return createNavigatorItems(result, parent, false);
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

}
