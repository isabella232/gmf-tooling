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
package org.eclipse.gmf.examples.taipan.port.diagram.layout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.examples.taipan.Building;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.BuildingEditPart;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.PortEditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.AbstractLayoutEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNodeOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Places buildings in rows by streets.
 * 
 * @author dstadnik
 */
public class PortLayoutProvider extends AbstractLayoutEditPartProvider {

	protected static final int GAP = 20;

	public boolean provides(IOperation operation) {
		View cview = getContainer(operation);
		if (cview == null) {
			return false;
		}
		IAdaptable layoutHint = ((ILayoutNodeOperation) operation).getLayoutHint();
		String layoutType = (String) layoutHint.getAdapter(String.class);
		return LayoutType.DEFAULT.equals(layoutType);
	}

	public Command layoutEditParts(List selectedObjects, IAdaptable layoutHint) {
		GraphicalEditPart editPart = (GraphicalEditPart) selectedObjects.get(0);
		GraphicalEditPart containerEditPart = (GraphicalEditPart) editPart.getParent();
		return layoutEditParts(containerEditPart, layoutHint);
	}

	public Command layoutEditParts(GraphicalEditPart containerEditPart, IAdaptable layoutHint) {
		PortEditPart portEditPart = ((PortEditPart) containerEditPart);
		CompoundCommand cc = new CompoundCommand("Port Layout"); //$NON-NLS-1$

		// separate buildings by streets
		Map rows = new TreeMap(); // street -> Collection:BuildingEditPart
		for (Iterator it = portEditPart.getChildren().iterator(); it.hasNext();) {
			GraphicalEditPart editPart = (GraphicalEditPart) it.next();
			if (editPart instanceof BuildingEditPart) {
				Building building = (Building) ((BuildingEditPart) editPart).resolveSemanticElement();
				String street = building.getStreet() == null ? "" : building.getStreet(); //$NON-NLS-1$
				Collection editParts = (Collection) rows.get(street);
				if (editParts == null) {
					editParts = new ArrayList();
					rows.put(street, editParts);
				}
				editParts.add(editPart);
			}
		}

		// layout streets
		int offset = GAP;
		for (Iterator it = rows.keySet().iterator(); it.hasNext();) {
			String street = (String) it.next();
			Collection editParts = (Collection) rows.get(street);
			int thinkness = getStreetThickness(editParts);
			layoutStreet(editParts, offset, thinkness, cc);
			offset += thinkness + GAP;
		}

		return cc;
	}

	protected int getStreetThickness(Collection editParts) {
		int x = 0;
		for (Iterator it = editParts.iterator(); it.hasNext();) {
			BuildingEditPart editPart = (BuildingEditPart) it.next();
			int h = editPart.getFigure().getBounds().height;
			if (h > x) {
				x = h;
			}
		}
		return x;
	}

	protected void layoutStreet(Collection editParts, int yOffset, int thickness, CompoundCommand cc) {
		int xOffset = GAP;
		for (Iterator it = editParts.iterator(); it.hasNext();) {
			BuildingEditPart editPart = (BuildingEditPart) it.next();
			Rectangle bounds = editPart.getFigure().getBounds();
			Point location = new Point(xOffset, yOffset);
			editPart.getFigure().translateToAbsolute(location);
			Point oldLocation = bounds.getLocation();
			editPart.getFigure().translateToAbsolute(oldLocation);
			Dimension delta = location.getDifference(oldLocation);
			if (delta.width != 0 || delta.height != 0) {
				ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
				request.setEditParts(editPart);
				request.setMoveDelta(new Point(delta.width, delta.height));
				request.setLocation(location);
				Command cmd = editPart.getCommand(request);
				if (cmd != null && cmd.canExecute()) {
					cc.add(cmd);
				}
			}
			xOffset += bounds.width + GAP;
		}
	}
}
