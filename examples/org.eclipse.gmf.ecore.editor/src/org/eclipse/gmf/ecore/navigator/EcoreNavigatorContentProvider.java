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
		if (parentElement instanceof EcoreAbstractNavigatorItem) {
			EcoreAbstractNavigatorItem abstractNavigatorItem = (EcoreAbstractNavigatorItem) parentElement;
			if (!EPackageEditPart.MODEL_ID.equals(abstractNavigatorItem.getModelID())) {
				return EMPTY_ARRAY;
			}

			if (abstractNavigatorItem instanceof EcoreNavigatorItem) {
				EcoreNavigatorItem navigatorItem = (EcoreNavigatorItem) abstractNavigatorItem;
				switch (navigatorItem.getVisualID()) {
				case EClassEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getEClass_2001ToEAttribute_3001Children(navigatorItem.getView(), navigatorItem));
					result.addAll(getEClass_2001ToEOperation_3002Children(navigatorItem.getView(), navigatorItem));
					result.addAll(getEClass_2001ToEAnnotation_3003Children(navigatorItem.getView(), navigatorItem));
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEClass_2001ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					incominglinks.addChildren(getEClass_2001ToEReference_4002InSource(navigatorItem.getView(), incominglinks));
					EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					outgoinglinks.addChildren(getEClass_2001ToEReference_4002OutTarget(navigatorItem.getView(), outgoinglinks));
					incominglinks.addChildren(getEClass_2001ToEReference_4003InSource(navigatorItem.getView(), incominglinks));
					outgoinglinks.addChildren(getEClass_2001ToEReference_4003OutTarget(navigatorItem.getView(), outgoinglinks));
					incominglinks.addChildren(getEClass_2001ToEClassESuperTypes_4004InSource(navigatorItem.getView(), incominglinks));
					outgoinglinks.addChildren(getEClass_2001ToEClassESuperTypes_4004OutTarget(navigatorItem.getView(), outgoinglinks));
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
					result.addAll(getEPackage_2002ToEClass_3004Children(navigatorItem.getView(), navigatorItem));
					result.addAll(getEPackage_2002ToEPackage_3005Children(navigatorItem.getView(), navigatorItem));
					result.addAll(getEPackage_2002ToEDataType_3006Children(navigatorItem.getView(), navigatorItem));
					result.addAll(getEPackage_2002ToEEnum_3007Children(navigatorItem.getView(), navigatorItem));
					result.addAll(getEPackage_2002ToEAnnotation_3003Children(navigatorItem.getView(), navigatorItem));
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEPackage_2002ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EAnnotation2EditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getEAnnotation_2003ToEStringToStringMapEntry_3008Children(navigatorItem.getView(), navigatorItem));
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEAnnotation_2003ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					outgoinglinks.addChildren(getEAnnotation_2003ToEAnnotationReferences_4001OutTarget(navigatorItem.getView(), outgoinglinks));
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
					result.addAll(getEDataType_2004ToEAnnotation_3003Children(navigatorItem.getView(), navigatorItem));
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEDataType_2004ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					incominglinks.addChildren(getEDataType_2004ToEReference_4002InSource(navigatorItem.getView(), incominglinks));
					incominglinks.addChildren(getEDataType_2004ToEReference_4003InSource(navigatorItem.getView(), incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EEnum2EditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getEEnum_2005ToEEnumLiteral_3009Children(navigatorItem.getView(), navigatorItem));
					result.addAll(getEEnum_2005ToEAnnotation_3003Children(navigatorItem.getView(), navigatorItem));
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEEnum_2005ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					incominglinks.addChildren(getEEnum_2005ToEReference_4002InSource(navigatorItem.getView(), incominglinks));
					incominglinks.addChildren(getEEnum_2005ToEReference_4003InSource(navigatorItem.getView(), incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EAttributeEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEAttribute_3001ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EOperationEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEOperation_3002ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EAnnotationEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEAnnotation_3003ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					outgoinglinks.addChildren(getEAnnotation_3003ToEAnnotationReferences_4001OutTarget(navigatorItem.getView(), outgoinglinks));
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
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEClass_3004ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					incominglinks.addChildren(getEClass_3004ToEReference_4002InSource(navigatorItem.getView(), incominglinks));
					EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					outgoinglinks.addChildren(getEClass_3004ToEReference_4002OutTarget(navigatorItem.getView(), outgoinglinks));
					incominglinks.addChildren(getEClass_3004ToEReference_4003InSource(navigatorItem.getView(), incominglinks));
					outgoinglinks.addChildren(getEClass_3004ToEReference_4003OutTarget(navigatorItem.getView(), outgoinglinks));
					incominglinks.addChildren(getEClass_3004ToEClassESuperTypes_4004InSource(navigatorItem.getView(), incominglinks));
					outgoinglinks.addChildren(getEClass_3004ToEClassESuperTypes_4004OutTarget(navigatorItem.getView(), outgoinglinks));
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
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEPackage_3005ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EDataTypeEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEDataType_3006ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					incominglinks.addChildren(getEDataType_3006ToEReference_4002InSource(navigatorItem.getView(), incominglinks));
					incominglinks.addChildren(getEDataType_3006ToEReference_4003InSource(navigatorItem.getView(), incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EEnumEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEEnum_3007ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					incominglinks.addChildren(getEEnum_3007ToEReference_4002InSource(navigatorItem.getView(), incominglinks));
					incominglinks.addChildren(getEEnum_3007ToEReference_4003InSource(navigatorItem.getView(), incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EEnumLiteralEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getEEnumLiteral_3009ToEAnnotationReferences_4001InSource(navigatorItem.getView(), incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EPackageEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getEPackage_1000ToEClass_2001Children(navigatorItem.getView(), navigatorItem));
					result.addAll(getEPackage_1000ToEPackage_2002Children(navigatorItem.getView(), navigatorItem));
					result.addAll(getEPackage_1000ToEAnnotation_2003Children(navigatorItem.getView(), navigatorItem));
					result.addAll(getEPackage_1000ToEDataType_2004Children(navigatorItem.getView(), navigatorItem));
					result.addAll(getEPackage_1000ToEEnum_2005Children(navigatorItem.getView(), navigatorItem));
					EcoreNavigatorGroup links = new EcoreNavigatorGroup("links", "icons/linksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					links.addChildren(getViewByType(navigatorItem.getView().getDiagram().getEdges(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), links));
					links.addChildren(getViewByType(navigatorItem.getView().getDiagram().getEdges(), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID), links));
					links.addChildren(getViewByType(navigatorItem.getView().getDiagram().getEdges(), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID), links));
					links.addChildren(getViewByType(navigatorItem.getView().getDiagram().getEdges(), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID), links));
					if (!links.isEmpty()) {
						result.add(links);
					}
					return result.toArray();
				}
				case EAnnotationReferencesEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup target = new EcoreNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					target.addChildren(getEAnnotationReferences_4001ToEClass_2001OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEPackage_2002OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEAnnotation_2003OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEDataType_2004OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEEnum_2005OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEAttribute_3001OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEOperation_3002OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEAnnotation_3003OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEClass_3004OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEPackage_3005OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEDataType_3006OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEEnum_3007OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEAnnotationReferences_4001ToEEnumLiteral_3009OutTarget((Edge) navigatorItem.getView(), target));
					EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getEAnnotationReferences_4001ToEAnnotation_2003InSource((Edge) navigatorItem.getView(), source));
					source.addChildren(getEAnnotationReferences_4001ToEAnnotation_3003InSource((Edge) navigatorItem.getView(), source));
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
					EcoreNavigatorGroup target = new EcoreNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					target.addChildren(getEReference_4002ToEClass_2001OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEReference_4002ToEDataType_2004OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEReference_4002ToEEnum_2005OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEReference_4002ToEClass_3004OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEReference_4002ToEDataType_3006OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEReference_4002ToEEnum_3007OutTarget((Edge) navigatorItem.getView(), target));
					EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getEReference_4002ToEClass_2001InSource((Edge) navigatorItem.getView(), source));
					source.addChildren(getEReference_4002ToEClass_3004InSource((Edge) navigatorItem.getView(), source));
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
					EcoreNavigatorGroup target = new EcoreNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					target.addChildren(getEReference_4003ToEClass_2001OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEReference_4003ToEDataType_2004OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEReference_4003ToEEnum_2005OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEReference_4003ToEClass_3004OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEReference_4003ToEDataType_3006OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEReference_4003ToEEnum_3007OutTarget((Edge) navigatorItem.getView(), target));
					EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getEReference_4003ToEClass_2001InSource((Edge) navigatorItem.getView(), source));
					source.addChildren(getEReference_4003ToEClass_3004InSource((Edge) navigatorItem.getView(), source));
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
					EcoreNavigatorGroup target = new EcoreNavigatorGroup("target", "icons/linkTargetNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					target.addChildren(getEClassESuperTypes_4004ToEClass_2001OutTarget((Edge) navigatorItem.getView(), target));
					target.addChildren(getEClassESuperTypes_4004ToEClass_3004OutTarget((Edge) navigatorItem.getView(), target));
					EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getEClassESuperTypes_4004ToEClass_2001InSource((Edge) navigatorItem.getView(), source));
					source.addChildren(getEClassESuperTypes_4004ToEClass_3004InSource((Edge) navigatorItem.getView(), source));
					if (!target.isEmpty()) {
						result.add(target);
					}
					if (!source.isEmpty()) {
						result.add(source);
					}
					return result.toArray();
				}
				}
			} else if (abstractNavigatorItem instanceof EcoreNavigatorGroup) {
				EcoreNavigatorGroup group = (EcoreNavigatorGroup) parentElement;
				return group.getChildren();
			}
		} else if (parentElement instanceof IFile) {
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
			result.addAll(getViewByType(resource.getContents(), EPackageEditPart.MODEL_ID, file));
			return result.toArray();
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof EcoreAbstractNavigatorItem) {
			EcoreAbstractNavigatorItem abstractNavigatorItem = (EcoreAbstractNavigatorItem) element;
			if (!EPackageEditPart.MODEL_ID.equals(abstractNavigatorItem.getModelID())) {
				return null;
			}
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
	private Collection getViewByType(Collection childViews, String type, Object parent) {
		Collection result = new ArrayList();
		for (Iterator it = childViews.iterator(); it.hasNext();) {
			Object next = it.next();
			if (false == next instanceof View) {
				continue;
			}
			View nextView = (View) next;
			if (type.equals(nextView.getType())) {
				result.add(new EcoreNavigatorItem(nextView, parent));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClassESuperTypes_4004ToEClass_3004OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_2005ToEReference_4003InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEOperation_3002Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassOperationsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EOperationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotation_3003ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEAnnotation_2003InSource(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EAnnotation2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEClass_2001OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEEnum_3007OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEClass_2001InSource(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEAnnotation_3003Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassClassAnnotationsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEClassESuperTypes_4004OutTarget(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotation_2003ToEStringToStringMapEntry_3008Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationDetailsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EStringToStringMapEntryEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEReference_4002InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEClass_2001Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClassESuperTypes_4004ToEClass_3004InSource(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEReference_4003InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_2005ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEAttribute_3001Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassAttributesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EAttributeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEClassESuperTypes_4004InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEEnum_3007OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEClass_3004InSource(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEPackage_3005Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackagePackagesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EPackage3EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEPackage_2002Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackage2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEDataType_3006OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEClass_3004InSource(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_2004ToEReference_4002InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEPackage_2002OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EPackage2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEReference_4003OutTarget(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEOperation_3002ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEEnum_3007Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackageEnumsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_3006ToEReference_4002InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEEnum_2005Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEReference_4002InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEEnum_2005OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEEnumLiteral_3009OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnumLiteralEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEDataType_2004OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEEnum_2005OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotation_2003ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEDataType_3006Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackageDataTypesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEDataType_2004OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEDataType_2004Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEClass_2001InSource(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEEnum_2005OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEEnumLiteral_3009ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEReference_4002OutTarget(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEAnnotation_3003OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClassESuperTypes_4004ToEClass_2001InSource(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_2004ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEAnnotation_3003InSource(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksSourceByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEAnnotation_2003OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EAnnotation2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEDataType_2004OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEClass_3004OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_3006ToEReference_4003InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_3007ToEReference_4003InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEClass_2001OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_2005ToEReference_4002InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEClass_2001OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEClass_3004OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEClass_3004Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackageClassesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_3007ToEReference_4002InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEReference_4003InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClassESuperTypes_4004ToEClass_2001OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4003ToEDataType_3006OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEOperation_3002OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EOperationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_1000ToEAnnotation_2003Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotation2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEDataType_3006OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_2002ToEAnnotation_3003Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EPackagePackageAnnotationsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotation_3003ToEAnnotationReferences_4001OutTarget(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_2005ToEEnumLiteral_3009Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EEnumLiteralsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EEnumLiteralEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEClassESuperTypes_4004OutTarget(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEEnum_3007OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAttribute_3001ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_3007ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_2004ToEAnnotation_3003Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EDataTypeDataTypeAnnotationsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEClassESuperTypes_4004InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_3006ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotation_2003ToEAnnotationReferences_4001OutTarget(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEDataType_2004ToEReference_4003InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_2001ToEReference_4003OutTarget(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEPackage_3005OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EPackage3EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEClass_3004ToEReference_4002OutTarget(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEAnnotationReferences_4001ToEAttribute_3001OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EAttributeEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEEnum_2005ToEAnnotation_3003Children(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getChildrenByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EEnumEnumAnnotationsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEPackage_3005ToEAnnotationReferences_4001InSource(View view, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getEReference_4002ToEClass_3004OutTarget(Edge edge, EcoreAbstractNavigatorItem parent) {
		Collection result = new ArrayList();
		Collection connectedViews = getLinksTargetByType(Collections.singleton(edge), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID));
		createNavigatorItems(connectedViews, parent, result);
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())) {
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
			if (type.equals(nextEdgeSource.getType())) {
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
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (type.equals(nextView.getType())) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private void createNavigatorItems(Collection views, EcoreAbstractNavigatorItem parent, Collection result) {
		for (Iterator it = views.iterator(); it.hasNext();) {
			result.add(new EcoreNavigatorItem((View) it.next(), parent));
		}
	}

}
