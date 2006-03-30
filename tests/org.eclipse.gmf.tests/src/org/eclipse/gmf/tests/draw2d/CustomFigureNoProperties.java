/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.gmf.tests.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;

public class CustomFigureNoProperties extends RectangleFigure {
	protected void outlineShape(Graphics graphics) {
		super.outlineShape(graphics);

		Rectangle r = getBounds();
		graphics.drawLine(r.getBottomLeft(), r.getTopRight());
		graphics.drawLine(r.getBottomRight(), r.getTopLeft());
	}
}
