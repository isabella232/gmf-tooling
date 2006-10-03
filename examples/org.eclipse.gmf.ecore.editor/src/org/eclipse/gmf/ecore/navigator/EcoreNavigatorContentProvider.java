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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassESuperTypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;

import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;

import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
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
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EAttributeEditPart.VISUAL_ID), navigatorItem));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EOperationEditPart.VISUAL_ID), navigatorItem));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID), navigatorItem));
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID), false, incominglinks));
					EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					outgoinglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID), true, outgoinglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID), false, incominglinks));
					outgoinglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID), true, outgoinglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID), false, incominglinks));
					outgoinglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID), true, outgoinglinks));
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
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID), navigatorItem));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EPackage3EditPart.VISUAL_ID), navigatorItem));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID), navigatorItem));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID), navigatorItem));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID), navigatorItem));
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EAnnotation2EditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EStringToStringMapEntryEditPart.VISUAL_ID), navigatorItem));
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					outgoinglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), true, outgoinglinks));
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
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID), navigatorItem));
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID), false, incominglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID), false, incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EEnum2EditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EEnumLiteralEditPart.VISUAL_ID), navigatorItem));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID), navigatorItem));
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID), false, incominglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID), false, incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EAttributeEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EOperationEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EAnnotationEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					outgoinglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), true, outgoinglinks));
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
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID), false, incominglinks));
					EcoreNavigatorGroup outgoinglinks = new EcoreNavigatorGroup("outgoing links", "icons/outgoingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					outgoinglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID), true, outgoinglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID), false, incominglinks));
					outgoinglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID), true, outgoinglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID), false, incominglinks));
					outgoinglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID), true, outgoinglinks));
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
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EDataTypeEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID), false, incominglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID), false, incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EEnumEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID), false, incominglinks));
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EReference2EditPart.VISUAL_ID), false, incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EEnumLiteralEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					EcoreNavigatorGroup incominglinks = new EcoreNavigatorGroup("incoming links", "icons/incomingLinksNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					incominglinks.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationReferencesEditPart.VISUAL_ID), false, incominglinks));
					if (!incominglinks.isEmpty()) {
						result.add(incominglinks);
					}
					return result.toArray();
				}
				case EPackageEditPart.VISUAL_ID: {
					Collection result = new ArrayList();
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID), navigatorItem));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EPackage2EditPart.VISUAL_ID), navigatorItem));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EAnnotation2EditPart.VISUAL_ID), navigatorItem));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID), navigatorItem));
					result.addAll(getChildByType(navigatorItem.getView().getChildren(), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID), navigatorItem));
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
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EPackage2EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotation2EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAttributeEditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EOperationEditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EPackage3EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EEnumLiteralEditPart.VISUAL_ID), true, target));
					EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotation2EditPart.VISUAL_ID), false, source));
					source.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EAnnotationEditPart.VISUAL_ID), false, source));
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
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID), true, target));
					EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID), false, source));
					source.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID), false, source));
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
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EEnum2EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EDataTypeEditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EEnumEditPart.VISUAL_ID), true, target));
					EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID), false, source));
					source.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID), false, source));
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
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID), true, target));
					target.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID), true, target));
					EcoreNavigatorGroup source = new EcoreNavigatorGroup("source", "icons/linkSourceNavigatorGroup.gif", EPackageEditPart.MODEL_ID, navigatorItem);
					source.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClassEditPart.VISUAL_ID), false, source));
					source.addChildren(getConnectedViews(navigatorItem.getView(), EcoreVisualIDRegistry.getType(EClass2EditPart.VISUAL_ID), false, source));
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

			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString());
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
	private Collection getChildByType(Collection childViews, String type, Object parent) {
		Collection result = new ArrayList();
		List children = new ArrayList(childViews);
		for (int i = 0; i < children.size(); i++) {
			if (false == children.get(i) instanceof View) {
				continue;
			}
			View nextChild = (View) children.get(i);
			if (type.equals(nextChild.getType())) {
				result.add(new EcoreNavigatorItem(nextChild, parent));
			} else if (!stopGettingChildren(nextChild, type)) {
				children.addAll(nextChild.getChildren());
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean stopGettingChildren(View child, String type) {
		return false;
	}

	/**
	 * @generated
	 */
	private Collection getConnectedViews(View rootView, String type, boolean isOutTarget, Object parent) {
		Collection result = new ArrayList();
		List connectedViews = new ArrayList();
		connectedViews.add(rootView);
		Set visitedViews = new HashSet();
		for (int i = 0; i < connectedViews.size(); i++) {
			View nextView = (View) connectedViews.get(i);
			if (visitedViews.contains(nextView)) {
				continue;
			}
			visitedViews.add(nextView);
			if (type.equals(nextView.getType()) && nextView != rootView) {
				result.add(new EcoreNavigatorItem(nextView, parent));
			} else {
				if (isOutTarget && !stopGettingOutTarget(nextView, rootView, type)) {
					connectedViews.addAll(nextView.getSourceEdges());
					if (nextView instanceof Edge) {
						connectedViews.add(((Edge) nextView).getTarget());
					}
				}
				if (!isOutTarget && !stopGettingInSource(nextView, rootView, type)) {
					connectedViews.addAll(nextView.getTargetEdges());
					if (nextView instanceof Edge) {
						connectedViews.add(((Edge) nextView).getSource());
					}
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean stopGettingInSource(View nextView, View rootView, String type) {
		return !isOneHopConnection(nextView, rootView);
	}

	/**
	 * @generated
	 */
	private boolean stopGettingOutTarget(View nextView, View rootView, String type) {
		return !isOneHopConnection(nextView, rootView);
	}

	/**
	 * @generated
	 */
	private boolean isOneHopConnection(View targetView, View sourceView) {
		if (sourceView == targetView) {
			return true;
		}
		if (sourceView instanceof Node) {
			return targetView instanceof Edge;
		}
		if (sourceView instanceof Edge) {
			return targetView instanceof Node;
		}
		return false;
	}

}
