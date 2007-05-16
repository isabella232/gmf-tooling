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

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
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

	private boolean working;

	/**
	 * Returns true when layout is arranging buildings.
	 */
	public final boolean isWorking() {
		return working;
	}

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
		return layoutPort((PortEditPart) containerEditPart);
	}

	protected Command layoutPort(PortEditPart portEditPart) {
		if (working) {
			throw new IllegalStateException("Recursive layout invocation"); //$NON-NLS-1$
		}
		CompoundCommand cc = new CompoundCommand("Port Layout"); //$NON-NLS-1$
		try {
			working = true;

			// separate buildings by streets
			Map rows = new TreeMap(); // street -> Collection:BuildingEditPart
			for (Iterator it = portEditPart.getChildren().iterator(); it.hasNext();) {
				GraphicalEditPart editPart = (GraphicalEditPart) it.next();
				if (editPart instanceof BuildingEditPart) {
					Building building = (Building) ((BuildingEditPart) editPart).resolveSemanticElement();
					String street = building.getStreet() == null ? "" : building.getStreet(); //$NON-NLS-1$
					Collection editParts = (Collection) rows.get(street);
					if (editParts == null) {
						editParts = new TreeSet(new XComparator());
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
				int thickness = getStreetThickness(editParts);
				layoutStreet(editParts, offset, thickness, cc);
				offset += thickness + GAP;
			}
		} finally {
			working = false;
		}
		return cc.isEmpty() ? new Command("Nothing to layout") {} : cc; //$NON-NLS-1$
	}

	protected void layoutStreet(Collection editParts, int yOffset, int thickness, CompoundCommand cc) {
		int xOffset = GAP;
		for (Iterator it = editParts.iterator(); it.hasNext();) {
			BuildingEditPart editPart = (BuildingEditPart) it.next();
			Rectangle bounds = editPart.getFigure().getBounds();
			Point newLocation = new Point(xOffset, yOffset);
			editPart.getFigure().translateToAbsolute(newLocation);
			Point oldLocation = bounds.getLocation();
			editPart.getFigure().translateToAbsolute(oldLocation);
			Dimension delta = newLocation.getDifference(oldLocation);
			if (delta.width != 0 || delta.height != 0) {
				ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
				request.setEditParts(editPart);
				request.setMoveDelta(new Point(delta.width, delta.height));
				request.setLocation(newLocation);
				Command cmd = editPart.getCommand(request);
				if (cmd != null && cmd.canExecute()) {
					cc.add(cmd);
				}
			}
			xOffset += bounds.width + GAP;
		}
	}

	protected int getStreetThickness(Collection editParts) {
		int thickness = 0;
		for (Iterator it = editParts.iterator(); it.hasNext();) {
			BuildingEditPart editPart = (BuildingEditPart) it.next();
			int height = editPart.getFigure().getBounds().height;
			if (height > thickness) {
				thickness = height;
			}
		}
		return thickness;
	}

	protected static class XComparator implements Comparator {

		public int compare(Object o1, Object o2) {
			IGraphicalEditPart p1 = (IGraphicalEditPart) o1;
			IGraphicalEditPart p2 = (IGraphicalEditPart) o2;
			int x1 = p1.getFigure().getBounds().x;
			int x2 = p2.getFigure().getBounds().x;
			return x1 - x2;
		}
	}
}
