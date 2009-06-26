/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.policies.assistant;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Color;

public class SelectionBorder extends LineBorder {

	private static final int CORNER_SIZE = 5;

	private boolean myShowBorder = false;

	private Insets myOuterInsets;

	private Insets myInnerInsets;

	public SelectionBorder(Color borderColor, int lineWidth, int lineStyle, Insets outerInsets, Insets innerInsets) {
		super(borderColor, lineWidth, lineStyle);
		myOuterInsets = outerInsets;
		myInnerInsets = innerInsets;
	}

	public void setShowBorder(boolean show) {
		myShowBorder = show;
	}

	public Insets getInsets(IFigure figure) {
		return super.getInsets(figure).add(myOuterInsets).add(myInnerInsets);
	}

	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		if (!myShowBorder) {
			return;
		}
		tempRect.setBounds(getPaintRectangle(figure, insets));
		tempRect.crop(myOuterInsets);
		if (getWidth() % 2 == 1) {
			tempRect.width--;
			tempRect.height--;
		}
		tempRect.shrink(getWidth() / 2, getWidth() / 2);
		graphics.setLineWidth(getWidth());
		graphics.setLineStyle(getStyle());
		if (getColor() != null)
			graphics.setForegroundColor(getColor());
		graphics.drawRoundRectangle(tempRect, CORNER_SIZE, CORNER_SIZE);
	}

}
