/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.Warship;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EmptyBoxEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipLargeCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipSmallCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipLargeCargoEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TaiPanDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return view.getEAnnotation("Shortcut") != null && view.isSetElement() && (view.getElement() == null || view.getElement().eIsProxy()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case ShipSmallCargoEditPart.VISUAL_ID:
			return getShipSmallCargo_7001SemanticChildren(view);
		case ShipLargeCargoEditPart.VISUAL_ID:
			return getShipLargeCargo_7002SemanticChildren(view);
		case WarshipLargeCargoEditPart.VISUAL_ID:
			return getWarshipLargeCargo_7003SemanticChildren(view);
		case AquatoryEditPart.VISUAL_ID:
			return getAquatory_1SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getShipSmallCargo_7001SemanticChildren(View view) {
		Ship modelElement = (Ship) view.getElement();
		List result = new LinkedList();
		for (Iterator semanticIterator = getShipSmallCargo_7001SemanticChildren(modelElement).iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, nextElement);
			if (isShipSmallCargo_7001DomainMetaChild(visualID)) {
				result.add(new TaiPanNodeDescriptor(nextElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getShipLargeCargo_7002SemanticChildren(View view) {
		Ship modelElement = (Ship) view.getElement();
		List result = new LinkedList();
		for (Iterator semanticIterator = getShipLargeCargo_7002SemanticChildren(modelElement).iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, nextElement);
			if (isShipLargeCargo_7002DomainMetaChild(visualID)) {
				result.add(new TaiPanNodeDescriptor(nextElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getWarshipLargeCargo_7003SemanticChildren(View view) {
		Warship modelElement = (Warship) view.getElement();
		List result = new LinkedList();
		for (Iterator semanticIterator = getWarshipLargeCargo_7003SemanticChildren(modelElement).iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, nextElement);
			if (isWarshipLargeCargo_7003DomainMetaChild(visualID)) {
				result.add(new TaiPanNodeDescriptor(nextElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAquatory_1SemanticChildren(View view) {
		Aquatory modelElement = (Aquatory) view.getElement();
		List result = new LinkedList();
		for (Iterator semanticIterator = getAquatory_1SemanticChildren(modelElement).iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, nextElement);
			if (isAquatory_1DomainMetaChild(visualID)) {
				result.add(new TaiPanNodeDescriptor(nextElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static List getShipSmallCargo_7001SemanticChildren(Ship modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getCargo());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getShipLargeCargo_7002SemanticChildren(Ship modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getCargo());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getWarshipLargeCargo_7003SemanticChildren(Warship modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getCargo());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getAquatory_1SemanticChildren(Aquatory modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getPorts());
		allValues.addAll(modelElement.getShips());
		return allValues;
	}

	/**
	 * @generated
	 */
	public static boolean isShipSmallCargo_7001DomainMetaChild(int visualID) {
		switch (visualID) {
		case SmallItemsEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isShipLargeCargo_7002DomainMetaChild(int visualID) {
		switch (visualID) {
		case LargeItemEditPart.VISUAL_ID:
		case EmptyBoxEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isWarshipLargeCargo_7003DomainMetaChild(int visualID) {
		switch (visualID) {
		case LargeItemEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isAquatory_1DomainMetaChild(int visualID) {
		switch (visualID) {
		case PortEditPart.VISUAL_ID:
		case ShipEditPart.VISUAL_ID:
		case WarshipEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

}
