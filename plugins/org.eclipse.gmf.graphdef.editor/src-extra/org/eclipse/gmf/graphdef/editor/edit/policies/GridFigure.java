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
package org.eclipse.gmf.graphdef.editor.edit.policies;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class GridFigure extends Shape {

	private static final Rectangle INNER_FIGURE_BOUNDS = new Rectangle();

	private int[] myHeights;

	private int[] myWidths;

	private IFigure[][] myGrid;

	private Color myInnerFigureColor;

	private GridLayout myGridLayout;

	public GridFigure(int[] heights, int[] widths) {
		myHeights = new int[heights.length - 1];
		System.arraycopy(heights, 0, myHeights, 0, myHeights.length);
		myWidths = widths;
	}

	public GridFigure(IFigure[][] grid, int[] heights, int[] widths, GridLayout gridLayout) {
		this(heights, widths);
		myGrid = grid;
		myGridLayout = gridLayout;
	}

	public void setInnerFigureBoundsColor(Color color) {
		myInnerFigureColor = color;
	}

	@Override
	protected void fillShape(Graphics graphics) {
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
		int inset1 = (int) Math.floor(lineInset);
		int inset2 = (int) Math.ceil(lineInset);

		Rectangle r = Rectangle.SINGLETON;
		r.x = getBounds().x + inset1 + myGridLayout.marginWidth;
		r.y = getBounds().y + inset1 + myGridLayout.marginHeight;
		int acc = 0;
		for (int i = 0; i < myWidths.length; i++) {
			acc += myWidths[i] + myGridLayout.horizontalSpacing;
		}
		r.width = Math.min(acc, getBounds().width - inset1 - inset2);
		acc = 0;
		for (int i = 0; i < myHeights.length; i++) {
			acc += myHeights[i] + myGridLayout.verticalSpacing;
		}
		r.height = Math.min(acc, getBounds().height - inset1 - inset2);

		graphics.drawRectangle(r);
		acc = r.y - myGridLayout.verticalSpacing/2;
		for (int i = 0; i < myHeights.length - 1; i++) {
			acc += myHeights[i] + myGridLayout.verticalSpacing;
			graphics.drawLine(r.x, acc, r.right(), acc);
		}
		acc = r.x - myGridLayout.horizontalSpacing/2;
		for (int i = 0; i < myWidths.length - 1; i++) {
			acc += myWidths[i] + myGridLayout.horizontalSpacing;
			graphics.drawLine(acc, r.y, acc, r.bottom());
		}

		for (int i = 0; i < myHeights.length; i++) {
			for (int j = 0; j < myWidths.length; ) {
				if (myGrid[i][j] == null || i > 0 && myGrid[i - 1][j] == myGrid[i][j]) {
					j++;
					continue;
				}
				int width = 1;
				while (j + width < myWidths.length && myGrid[i][j] == myGrid[i][j + width]) {
					width++;
				}
				int height = 1;
				while (j + height < myHeights.length && myGrid[i][j] == myGrid[i + height][j]) {
					height++;
				}
				drawInnerFigureBounds(graphics, r, i, j, width, height);
				j += width;
			}
		}
	}

	private void drawInnerFigureBounds(Graphics graphics, Rectangle figureBounds, int row, int column, int width, int height) {
		graphics.pushState();
		if (myInnerFigureColor != null) {
			graphics.setForegroundColor(myInnerFigureColor);
		}
		INNER_FIGURE_BOUNDS.x = figureBounds.x - myGridLayout.horizontalSpacing/2;
		for (int k = 0; k < column; k++) {
			INNER_FIGURE_BOUNDS.x += myWidths[k] + myGridLayout.horizontalSpacing;
		}
		INNER_FIGURE_BOUNDS.width = 0;
		for (int k = column; k < column + width; k++) {
			INNER_FIGURE_BOUNDS.width += myWidths[k] + myGridLayout.horizontalSpacing;
		}
		INNER_FIGURE_BOUNDS.y = figureBounds.y - myGridLayout.verticalSpacing/2;
		for (int k = 0; k < row; k++) {
			INNER_FIGURE_BOUNDS.y += myHeights[k] + myGridLayout.verticalSpacing;
		}
		INNER_FIGURE_BOUNDS.height = 0;
		for (int k = row; k < row + height; k++) {
			INNER_FIGURE_BOUNDS.height += myHeights[k]  + myGridLayout.verticalSpacing;
		}
		graphics.drawRoundRectangle(INNER_FIGURE_BOUNDS, 10, 10);
		graphics.popState();
	}

}
