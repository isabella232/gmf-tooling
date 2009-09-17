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

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.gmfgraph.BorderLayout;
import org.eclipse.gmf.gmfgraph.BorderLayoutData;
import org.eclipse.gmf.graphdef.editor.edit.parts.AbstractFigureEditPart;

public class BorderLayoutHelper {

	private Rectangle myCenterBounds;

	private Rectangle myLeftBounds;

	private Rectangle myTopBounds;

	private Rectangle myBottomBounds;

	private Rectangle myRightBounds;

	public BorderLayoutHelper(AbstractFigureEditPart host) {
		this(host.getChildren(), host.getContentPane().getClientArea(), (BorderLayout) host.getRealFigure().getLayout());
	}

	private BorderLayoutHelper(List<AbstractFigureEditPart> childEditParts, Rectangle clientArea, BorderLayout borderLayout) {
		// detecting figures associated with top/bottom/... layout
		// constraints in this container
		IFigure left = null;
		IFigure right = null;
		IFigure top = null;
		IFigure bottom = null;
		for (AbstractFigureEditPart childEditPart : childEditParts) {
			if (childEditPart.getRealFigure().getLayoutData() instanceof BorderLayoutData && childEditPart.getFigure().isVisible()) {
				BorderLayoutData layoutData = (BorderLayoutData) childEditPart.getRealFigure().getLayoutData();
				switch (layoutData.getAlignment()) {
				case BEGINNING_LITERAL:
					if (layoutData.isVertical()) {
						top = childEditPart.getFigure();
					} else {
						left = childEditPart.getFigure();
					}
					break;
				case END_LITERAL:
					if (layoutData.isVertical()) {
						bottom = childEditPart.getFigure();
					} else {
						right = childEditPart.getFigure();
					}
					break;
				}
			}
		}

		// Calculating preferred size of all visible child figures
		Rectangle area = clientArea;
		int vGap = borderLayout.getSpacing().getDy();
		int hGap = borderLayout.getSpacing().getDx();

		myTopBounds = new Rectangle();
		Dimension preferredSize = top != null ? top.getPreferredSize(area.width, -1) : new Dimension(0, (int) Math.min(10, 0.3 * clientArea.width));
		myTopBounds.setLocation(area.x, area.y);
		myTopBounds.setSize(preferredSize);
		myTopBounds.width = area.width;
		area.y += myTopBounds.height + vGap;
		area.height -= myTopBounds.height + vGap;

		myBottomBounds = new Rectangle();
		preferredSize = bottom != null ? bottom.getPreferredSize(Math.max(area.width, 0), -1) : new Dimension(0, (int) Math.min(10, 0.3 * clientArea.width));
		myBottomBounds.setSize(preferredSize);
		myBottomBounds.width = area.width;
		myBottomBounds.setLocation(area.x, area.y + area.height - myBottomBounds.height);
		area.height -= preferredSize.height + vGap;

		myLeftBounds = new Rectangle();
		preferredSize = left != null ? left.getPreferredSize(-1, Math.max(0, area.height)) : new Dimension((int) Math.min(10, 0.3 * clientArea.height), 0);
		myLeftBounds.setLocation(area.x, area.y);
		myLeftBounds.width = preferredSize.width;
		myLeftBounds.height = Math.max(0, area.height);
		area.x += preferredSize.width + hGap;
		area.width -= preferredSize.width + hGap;

		myRightBounds = new Rectangle();
		preferredSize = right != null ? right.getPreferredSize(-1, Math.max(0, area.height)) : new Dimension((int) Math.min(10, 0.3 * clientArea.height), 0);
		;
		myRightBounds.width = preferredSize.width;
		myRightBounds.height = Math.max(0, area.height);
		myRightBounds.setLocation(area.x + area.width - myRightBounds.width, area.y);
		area.width -= preferredSize.width + hGap;

		if (area.width < 0) {
			area.width = 0;
		}
		if (area.height < 0) {
			area.height = 0;
		}
		myCenterBounds = area;
	}

	public Integer getConstraintFor(Point point) {
		if (myBottomBounds.contains(point)) {
			return org.eclipse.draw2d.BorderLayout.BOTTOM;
		}
		if (myTopBounds.contains(point)) {
			return org.eclipse.draw2d.BorderLayout.TOP;
		}
		if (myLeftBounds.contains(point)) {
			return org.eclipse.draw2d.BorderLayout.LEFT;
		}
		if (myRightBounds.contains(point)) {
			return org.eclipse.draw2d.BorderLayout.RIGHT;
		}
		return org.eclipse.draw2d.BorderLayout.CENTER;
	}

	public Rectangle getFeedbackBounds(Point point) {
		Integer constraint = getConstraintFor(point);
		if (constraint == org.eclipse.draw2d.BorderLayout.BOTTOM) {
			return myBottomBounds.getCopy();
		} else if (constraint == org.eclipse.draw2d.BorderLayout.TOP) {
			return myTopBounds.getCopy();
		} else if (constraint == org.eclipse.draw2d.BorderLayout.LEFT) {
			return myLeftBounds.getCopy();
		} else if (constraint == org.eclipse.draw2d.BorderLayout.RIGHT) {
			return myRightBounds.getCopy();
		} else {
			return myCenterBounds.getCopy();
		}
	}

}
