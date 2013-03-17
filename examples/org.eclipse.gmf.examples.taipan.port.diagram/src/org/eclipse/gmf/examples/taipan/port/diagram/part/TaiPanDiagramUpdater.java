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

import org.eclipse.gmf.examples.taipan.Building;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.BuildingEditPart;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.PortEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TaiPanDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<TaiPanNodeDescriptor> getSemanticChildren(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case PortEditPart.VISUAL_ID:
			return getPort_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TaiPanNodeDescriptor> getPort_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Port modelElement = (Port) view.getElement();
		LinkedList<TaiPanNodeDescriptor> result = new LinkedList<TaiPanNodeDescriptor>();
		for (Iterator<?> it = modelElement.getBuildings().iterator(); it.hasNext();) {
			Building childElement = (Building) it.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == BuildingEditPart.VISUAL_ID) {
				result.add(new TaiPanNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TaiPanLinkDescriptor> getContainedLinks(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case PortEditPart.VISUAL_ID:
			return getPort_1000ContainedLinks(view);
		case BuildingEditPart.VISUAL_ID:
			return getBuilding_2001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TaiPanLinkDescriptor> getIncomingLinks(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case BuildingEditPart.VISUAL_ID:
			return getBuilding_2001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TaiPanLinkDescriptor> getOutgoingLinks(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case BuildingEditPart.VISUAL_ID:
			return getBuilding_2001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TaiPanLinkDescriptor> getPort_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TaiPanLinkDescriptor> getBuilding_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TaiPanLinkDescriptor> getBuilding_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TaiPanLinkDescriptor> getBuilding_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

}
