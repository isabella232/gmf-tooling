/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.figures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IPolygonAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;

/**
 * @author dstadnik
 */
public abstract class AnchorableShapeConnection extends ShapeConnection implements IPolygonAnchorableFigure {

	private static final String DEFAULT_ANCHOR_ID = ""; //$NON-NLS-1$

	private Map connectionAnchors;

	protected Map getConnectionAnchors() {
		if (connectionAnchors == null) {
			connectionAnchors = new HashMap(1);
		}
		return connectionAnchors;
	}

	public ConnectionAnchor getConnectionAnchor(String terminal) {
		ConnectionAnchor connectAnchor = (ConnectionAnchor) getConnectionAnchors().get(terminal);
		if (connectAnchor == null) {
			connectAnchor = createDefaultConnectionAnchor();
			getConnectionAnchors().put(terminal, connectAnchor);
		}
		return connectAnchor;
	}

	public String getConnectionAnchorTerminal(ConnectionAnchor c) {
		if (getConnectionAnchors().containsValue(c)) {
			Iterator iter = getConnectionAnchors().keySet().iterator();
			String key;
			while (iter.hasNext()) {
				key = (String) iter.next();
				if (getConnectionAnchors().get(key).equals(c)) {
					return key;
				}
			}
		}
		return DEFAULT_ANCHOR_ID;
	}

	public ConnectionAnchor getSourceConnectionAnchorAt(Point p) {
		return createConnectionAnchor(p);
	}

	public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
		return createConnectionAnchor(p);
	}

	protected ConnectionAnchor createConnectionAnchor(Point p) {
		if (p == null) {
			return getConnectionAnchor(DEFAULT_ANCHOR_ID);
		} else {
			return createDefaultConnectionAnchor();
		}
	}

	protected ConnectionAnchor createDefaultConnectionAnchor() {
		return new AbstractConnectionAnchor(this) {

			public Point getLocation(Point reference) {
				Point location = getOwner().getBounds().getCenter();
				getOwner().getParent().translateToAbsolute(location);
				return location;
			}
		};
	}

	public PointList getPolygonPoints() {
		return PointListUtilities.copyPoints(getPoints());
	}
}
