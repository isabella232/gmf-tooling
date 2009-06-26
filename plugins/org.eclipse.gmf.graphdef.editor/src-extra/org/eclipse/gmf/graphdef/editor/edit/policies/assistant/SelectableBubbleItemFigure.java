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
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Handle;

public class SelectableBubbleItemFigure extends Shape implements Handle {

	private static final Insets SELECTION_OUTER_INSETS = new Insets(3, 3, 3, 3);

	private static final Insets SELECTION_INNER_INSETS = new Insets(3, 3, 3, 3);

	private SelectionBorder border = new SelectionBorder(ColorConstants.darkGray, 1, Graphics.LINE_DOT, SELECTION_OUTER_INSETS, SELECTION_INNER_INSETS);

	private DragTracker myDragTracker;

	private boolean mySelected;

	public SelectableBubbleItemFigure(DragTracker dragTracker) {
		myDragTracker = dragTracker;
		setBorder(border);
		setOutline(false);
		setLayoutManager(new StackLayout());
	}

	@Override
	protected void fillShape(Graphics graphics) {
	}

	@Override
	protected void outlineShape(Graphics graphics) {
	}

	public Point getAccessibleLocation() {
		return null;
	}

	public DragTracker getDragTracker() {
		return myDragTracker;
	}

	public void setSelected(boolean selected) {
		if (mySelected == selected) {
			return;
		}
		mySelected = selected;
		border.setShowBorder(selected);
		repaint();
	}

	public boolean isSelected() {
		return mySelected;
	}

	/**
	 * Don't go deeper - it is important to return this figure (and use it as a
	 * Handle) if mouse was pressed in any points inside this figure or it's
	 * children.
	 */
	@Override
	protected IFigure findDescendantAtExcluding(int x, int y, TreeSearch search) {
		return null;
	}

}
