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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScaledGraphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.gmf.runtime.notation.View;

public class PreviewFigure extends Figure {

	private boolean myValid;

	private IFigure myActualFigure;

	private double myScale;

	private int myHorizontalShift;

	private int myVerticalShift;

	public PreviewFigure(View view, HeadlessDiagramGraphicalViewer viewer) {
		myActualFigure = viewer.addChild(view);
		myValid = myActualFigure != null;
	}

	/**
	 * Figure is unusable in invalid state.
	 * 
	 * TODO: looks like it is not necessary now.
	 */
	public boolean isPreviewValid() {
		return myValid;
	}

	@Override
	protected boolean useLocalCoordinates() {
		return true;
	}

	@Override
	public void invalidateTree() {
		super.invalidateTree();
		myActualFigure.invalidateTree();
	}

	@Override
	public void validate() {
		super.validate();
		myActualFigure.validate();
	}

	@Override
	public void setPreferredSize(Dimension size) {
		Dimension figurePreferredSize = myActualFigure.getPreferredSize();
		if (figurePreferredSize.width == 0 && figurePreferredSize.height == 0) {
			figurePreferredSize.width = figurePreferredSize.height = 15;
		} else if (figurePreferredSize.width == 0) {
			figurePreferredSize.width = figurePreferredSize.height;
		} else if (figurePreferredSize.height == 0) {
			figurePreferredSize.height = figurePreferredSize.width;
		}
		myActualFigure.setSize(figurePreferredSize);
		myActualFigure.setLocation(new Point(0, 0));
		myScale = Math.min(size.width / (double) figurePreferredSize.width, size.height / (double) figurePreferredSize.height);
		myHorizontalShift = (int) ((size.width - figurePreferredSize.width * myScale) / 2);
		myVerticalShift = (int) ((size.height - figurePreferredSize.height * myScale) / 2);
		super.setPreferredSize(size);
	}

	public void translateFromParent(Translatable t) {
		super.translateFromParent(t);
		t.performScale(1 / myScale);
	}

	public void translateToParent(Translatable t) {
		t.performScale(myScale);
		super.translateFromParent(t);
	}

	@Override
	protected void paintClientArea(Graphics graphics) {
		graphics.pushState();
		boolean optimizeClip = getBorder() == null || getBorder().isOpaque();
		graphics.translate(getBounds().x + getInsets().left + myHorizontalShift, getBounds().y + getInsets().top + myVerticalShift);
		if (!optimizeClip) {
			graphics.clipRect(getClientArea(Rectangle.SINGLETON));
		}
		if (myScale == 1.0) {
			myActualFigure.paint(graphics);
		} else {
			ScaledGraphics g = new ScaledGraphics(graphics);
			g.scale(myScale);
			g.pushState();
			myActualFigure.paint(g);
			g.dispose();
			graphics.restoreState();
		}

		graphics.popState();
	}

}
