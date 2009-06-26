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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.graphics.GCUtilities;
import org.eclipse.swt.SWT;

public class BubbleFigure extends Shape {

	private static final int CORNER_SIZE = 8;

	private static final int TAIL_WIDTH = 5;

	private static final int TAIL_HEIGHT = 5;

	private static final int HORIZONTAL_CHILDREN_INSET = 2;

	public BubbleFigure() {
		setRequestFocusEnabled(true);
		setLineStyle(SWT.LINE_DASH);
		setForegroundColor(ColorConstants.lightGray);
		setBackgroundColor(ColorConstants.white);
		FlowLayout layout = new FlowLayout();
		layout.setMinorSpacing(0);
		setLayoutManager(layout);
		setBorder(new MarginBorder(0, TAIL_WIDTH + HORIZONTAL_CHILDREN_INSET, TAIL_HEIGHT, HORIZONTAL_CHILDREN_INSET));
	}

	// TODO: move to EditPolicy?
	public void selectChild(SelectableBubbleItemFigure child) {
		for (Object childFigure : getChildren()) {
			if (childFigure instanceof SelectableBubbleItemFigure) {
				if (childFigure == child) {
					((SelectableBubbleItemFigure) childFigure).setSelected(true);
				} else {
					((SelectableBubbleItemFigure) childFigure).setSelected(false);
				}
			}
		}
	}

	@Override
	protected void fillShape(Graphics graphics) {
		Rectangle bubbleBounds = getBubbleBounds();
		graphics.fillRoundRectangle(bubbleBounds, CORNER_SIZE, CORNER_SIZE);
		PointList tailPoints = getTailPoints(bubbleBounds);
		graphics.fillPolygon(tailPoints);
	}

	private Rectangle getBubbleBounds() {
		Rectangle bubbleBounds = Rectangle.SINGLETON.setBounds(getBounds());
		bubbleBounds.resize(-TAIL_WIDTH, -TAIL_HEIGHT);
		bubbleBounds.translate(TAIL_WIDTH, 0);
		return bubbleBounds;
	}

	private PointList getTailPoints(Rectangle bubbleBounds) {
		PointList points = new PointList();
		points.addPoint(bubbleBounds.getBottomLeft().translate(0, -CORNER_SIZE));
		points.addPoint(getBounds().getBottomLeft());
		points.addPoint(bubbleBounds.getBottomLeft().translate(CORNER_SIZE, 0));
		return points;
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
		int inset1 = (int) Math.floor(lineInset);
		int inset2 = (int) Math.ceil(lineInset);

		Rectangle bubbleBounds = getBubbleBounds();
		PointList tailPoints = getTailPoints(bubbleBounds);
		bubbleBounds.x += inset1;
		bubbleBounds.y += inset1;
		bubbleBounds.width -= inset1 + inset2;
		bubbleBounds.height -= inset1 + inset2;
		int cornerSize = Math.max(0, CORNER_SIZE - (int) lineInset);
		tailPoints.performTranslate(inset1, -inset1 - inset2);

		tailPoints.insertPoint(new Point(bubbleBounds.x, bubbleBounds.y + cornerSize), 0);
		tailPoints.addPoint(new Point(bubbleBounds.x + bubbleBounds.width - cornerSize, bubbleBounds.y + bubbleBounds.height));
		graphics.drawPolyline(tailPoints);

		graphics.drawLine(bubbleBounds.x + bubbleBounds.width, bubbleBounds.y + bubbleBounds.height - cornerSize, bubbleBounds.x + bubbleBounds.width, bubbleBounds.y + cornerSize);
		graphics.drawLine(bubbleBounds.x + bubbleBounds.width - cornerSize, bubbleBounds.y, bubbleBounds.x + cornerSize, bubbleBounds.y);

		graphics.drawArc(bubbleBounds.x, bubbleBounds.y, 2 * cornerSize, 2 * cornerSize, 90, 90);
		graphics.drawArc(bubbleBounds.x + bubbleBounds.width - 2 * cornerSize, bubbleBounds.y, 2 * cornerSize, 2 * cornerSize, 0, 90);
		graphics.drawArc(bubbleBounds.x + bubbleBounds.width - 2 * cornerSize, bubbleBounds.y + bubbleBounds.height - 2 * cornerSize, 2 * cornerSize, 2 * cornerSize, 270, 90);
	}

	@Override
	public void paint(Graphics graphics) {
		graphics.pushState();
		try {
			if ((graphics instanceof SWTGraphics) && GCUtilities.supportsAdvancedGraphics()) {
				graphics.setAntialias(SWT.ON);
			}
			super.paint(graphics);
		} finally {
			graphics.popState();
		}
	}

}
