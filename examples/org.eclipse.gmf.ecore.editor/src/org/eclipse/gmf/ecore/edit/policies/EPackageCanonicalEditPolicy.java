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
package org.eclipse.gmf.ecore.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
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
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;
import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.ecore.providers.EcoreElementTypes;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EPackageCanonicalEditPolicy extends CanonicalConnectionEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		View viewObject = (View) getHost().getModel();
		EPackage modelObject = (EPackage) viewObject.getElement();
		List allValues = new LinkedList();
		allValues.addAll(modelObject.getEClassifiers());
		allValues.addAll(modelObject.getESubpackages());
		allValues.addAll(modelObject.getEAnnotations());
		for (Iterator valuesIterator = allValues.iterator(); valuesIterator.hasNext();) {
			EObject nextValue = (EObject) valuesIterator.next();
			switch (EcoreVisualIDRegistry.getNodeVisualID(viewObject, nextValue)) {
			case EClassEditPart.VISUAL_ID:
			case EPackage2EditPart.VISUAL_ID:
			case EAnnotationEditPart.VISUAL_ID:
			case EDataTypeEditPart.VISUAL_ID:
			case EEnumEditPart.VISUAL_ID:
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			return view.isSetElement() && (view.getElement() == null || view.getElement().eIsProxy());
		}
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EClassEditPart.VISUAL_ID:
		case EPackage2EditPart.VISUAL_ID:
		case EAnnotationEditPart.VISUAL_ID:
		case EDataTypeEditPart.VISUAL_ID:
		case EEnumEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected List getSemanticConnectionsList() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	protected EObject getSourceElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject getTargetElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected boolean shouldIncludeConnection(Edge connector, Collection children) {
		return false;
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		List createdViews = new LinkedList();
		createdViews.addAll(refreshSemanticChildren());
		List createdConnectionViews = new LinkedList();
		createdConnectionViews.addAll(refreshSemanticConnections());
		createdConnectionViews.addAll(refreshConnections());

		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		createdViews.addAll(createdConnectionViews);
		makeViewsImmutable(createdViews);
	}

	/**
	 * @generated
	 */
	private Diagram getDiagram() {
		return ((View) getHost().getModel()).getDiagram();
	}

	/**
	 * @generated
	 */
	private Collection refreshConnections() {
		Map domain2NotationMap = new HashMap();
		Collection linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
			Edge nextDiagramLink = (Edge) linksIterator.next();
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			int diagramLinkVisualID = EcoreVisualIDRegistry.getVisualID(nextDiagramLink);
			for (Iterator LinkDescriptorsIterator = linkDescriptors.iterator(); LinkDescriptorsIterator.hasNext();) {
				LinkDescriptor nextLinkDescriptor = (LinkDescriptor) LinkDescriptorsIterator.next();
				if (diagramLinkObject == nextLinkDescriptor.getLinkElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination()
						&& diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
					linksIterator.remove();
					LinkDescriptorsIterator.remove();
				}
			}
		}
		deleteViews(existingLinks.iterator());
		return createConnections(linkDescriptors, domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private Collection collectAllLinks(View view, Map domain2NotationMap) {
		Collection result = new LinkedList();
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EClassEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			EClass modelElement = (EClass) view.getElement();
			result.addAll(getContainedTypeModelFacetLinks_EReference_4002(modelElement));
			result.addAll(getContainedTypeModelFacetLinks_EReference_4003(modelElement));
			result.addAll(getContainedFeatureModelFacetLinks_EClass_ESuperTypes_4004(modelElement));
			break;
		}
		case EPackage2EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case EAnnotationEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			EAnnotation modelElement = (EAnnotation) view.getElement();
			result.addAll(getContainedFeatureModelFacetLinks_EAnnotation_References_4001(modelElement));
			break;
		}
		case EDataTypeEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case EEnumEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case EAttributeEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case EOperationEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case EAnnotation2EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			EAnnotation modelElement = (EAnnotation) view.getElement();
			result.addAll(getContainedFeatureModelFacetLinks_EAnnotation_References_4001(modelElement));
			break;
		}
		case EClass2EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			EClass modelElement = (EClass) view.getElement();
			result.addAll(getContainedTypeModelFacetLinks_EReference_4002(modelElement));
			result.addAll(getContainedTypeModelFacetLinks_EReference_4003(modelElement));
			result.addAll(getContainedFeatureModelFacetLinks_EClass_ESuperTypes_4004(modelElement));
			break;
		}
		case EPackage3EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case EDataType2EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case EEnum2EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case EStringToStringMapEntryEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case EEnumLiteralEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		}
		for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
			result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getContainedFeatureModelFacetLinks_EAnnotation_References_4001(EAnnotation container) {
		Collection result = new LinkedList();
		for (Iterator destinations = container.getReferences().iterator(); destinations.hasNext();) {
			EObject destination = (EObject) destinations.next();
			result.add(new LinkDescriptor(container, destination, EcoreElementTypes.EAnnotationReferences_4001, EAnnotationReferencesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getContainedTypeModelFacetLinks_EReference_4002(EClass container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getEStructuralFeatures().iterator(); links.hasNext();) {
			EStructuralFeature link = (EStructuralFeature) links.next();
			int linkVID = EcoreVisualIDRegistry.getLinkWithClassVisualID(link);
			if (linkVID == EReferenceEditPart.VISUAL_ID) {
				EClassifier dst = link.getEType();
				result.add(new LinkDescriptor(container, dst, link, EcoreElementTypes.EReference_4002, linkVID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getContainedTypeModelFacetLinks_EReference_4003(EClass container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getEStructuralFeatures().iterator(); links.hasNext();) {
			EStructuralFeature link = (EStructuralFeature) links.next();
			int linkVID = EcoreVisualIDRegistry.getLinkWithClassVisualID(link);
			if (linkVID == EReference2EditPart.VISUAL_ID) {
				EClassifier dst = link.getEType();
				result.add(new LinkDescriptor(container, dst, link, EcoreElementTypes.EReference_4003, linkVID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getContainedFeatureModelFacetLinks_EClass_ESuperTypes_4004(EClass container) {
		Collection result = new LinkedList();
		for (Iterator destinations = container.getESuperTypes().iterator(); destinations.hasNext();) {
			EClass destination = (EClass) destinations.next();
			result.add(new LinkDescriptor(container, destination, EcoreElementTypes.EClassESuperTypes_4004, EClassESuperTypesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection createConnections(Collection linkDescriptors, Map domain2NotationMap) {
		List adapters = new LinkedList();
		for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
			final LinkDescriptor nextLinkDescriptor = (LinkDescriptor) linkDescriptorsIterator.next();
			EditPart sourceEditPart = getEditPart(nextLinkDescriptor.getSource(), domain2NotationMap);
			EditPart targetEditPart = getEditPart(nextLinkDescriptor.getDestination(), domain2NotationMap);
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), null, ViewUtil.APPEND,
					false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if (cmd != null && cmd.canExecute()) {
				executeCommand(cmd);
				IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
				if (viewAdapter != null) {
					adapters.add(viewAdapter);
				}
			}
		}
		return adapters;
	}

	/**
	 * @generated
	 */
	private EditPart getEditPart(EObject domainModelElement, Map domain2NotationMap) {
		View view = (View) domain2NotationMap.get(domainModelElement);
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private class LinkDescriptor {

		/**
		 * @generated
		 */
		private EObject mySource;

		/**
		 * @generated
		 */
		private EObject myDestination;

		/**
		 * @generated
		 */
		private EObject myLinkElement;

		/**
		 * @generated
		 */
		private int myVisualID;

		/**
		 * @generated
		 */
		private IAdaptable mySemanticAdapter;

		/**
		 * @generated
		 */
		private LinkDescriptor(EObject source, EObject destination, int linkVID) {
			mySource = source;
			myDestination = destination;
			myVisualID = linkVID;
		}

		/**
		 * @generated
		 */
		protected LinkDescriptor(EObject source, EObject destination, IElementType elementType, int linkVID) {
			this(source, destination, linkVID);
			final IElementType elementTypeCopy = elementType;
			myLinkElement = null;
			mySemanticAdapter = new IAdaptable() {

				public Object getAdapter(Class adapter) {
					if (IElementType.class.equals(adapter)) {
						return elementTypeCopy;
					}
					return null;
				}
			};
		}

		/**
		 * @generated
		 */
		protected LinkDescriptor(EObject source, EObject destination, EObject linkElement, IElementType elementType, int linkVID) {
			this(source, destination, linkVID);
			final IElementType elementTypeCopy = elementType;
			myLinkElement = linkElement;
			mySemanticAdapter = new EObjectAdapter(linkElement) {

				public Object getAdapter(Class adapter) {
					if (IElementType.class.equals(adapter)) {
						return elementTypeCopy;
					}
					return super.getAdapter(adapter);
				}
			};
		}

		/**
		 * @generated
		 */
		protected EObject getSource() {
			return mySource;
		}

		/**
		 * @generated
		 */
		protected EObject getDestination() {
			return myDestination;
		}

		/**
		 * @generated
		 */
		protected EObject getLinkElement() {
			return myLinkElement;
		}

		/**
		 * @generated
		 */
		protected int getVisualID() {
			return myVisualID;
		}

		/**
		 * @generated
		 */
		protected IAdaptable getSemanticAdapter() {
			return mySemanticAdapter;
		}

	}
}
