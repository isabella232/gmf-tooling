/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.port.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.BuildingEditPart;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.PortEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PortDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (PortVisualIDRegistry.getVisualID(view)) {
		case PortEditPart.VISUAL_ID:
			return getPort_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPort_1000SemanticChildren(View view) {
		Port modelElement = (Port) view.getElement();
		List result = new LinkedList();
		for (Iterator semanticIterator = getPort_1000SemanticChildren(modelElement).iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			int visualID = PortVisualIDRegistry.getNodeVisualID(view, nextElement);
			if (isPort_1000DomainMetaChild(visualID)) {
				result.add(new PortNodeDescriptor(nextElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static List getPort_1000SemanticChildren(Port modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getBuildings());
		return allValues;
	}

	/**
	 * @generated
	 */
	public static boolean isPort_1000DomainMetaChild(int visualID) {
		switch (visualID) {
		case BuildingEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (PortVisualIDRegistry.getVisualID(view)) {
		case BuildingEditPart.VISUAL_ID:
			return getBuilding_2001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (PortVisualIDRegistry.getVisualID(view)) {
		case BuildingEditPart.VISUAL_ID:
			return getBuilding_2001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (PortVisualIDRegistry.getVisualID(view)) {
		case BuildingEditPart.VISUAL_ID:
			return getBuilding_2001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBuilding_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBuilding_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBuilding_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

}
