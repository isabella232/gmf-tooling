/*****************************************************************************
 * Copyright (c) 2014-15 CEA LIST, Montages AG and others
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Anatoly Tishenko (tishenko@montages.com) - Initial API and implementation
 */
package org.eclipse.gmf.tooling.runtime.linklf;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RangeModel;
import org.eclipse.draw2d.ScrollBar;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.layout.FreeFormLayoutEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.AnimatableScrollPane;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.OverlayScrollPaneLayout;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @since 3.3
 */
public class LinkLFShapeCompartmentEditPart extends ShapeCompartmentEditPart {

	private final PropertyChangeListener myGridListener = new PropertyChangeListener() {

		public void propertyChange(PropertyChangeEvent evt) {
			String propertyName = evt.getPropertyName();
			if (SnapToGrid.PROPERTY_GRID_ORIGIN.equals(propertyName) || //
					SnapToGrid.PROPERTY_GRID_ENABLED.equals(propertyName) || //
					SnapToGrid.PROPERTY_GRID_SPACING.equals(propertyName)) {

				updateGridBehavior();
			}
		}
	};

	public LinkLFShapeCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	public IFigure createFigure() {
		ShapeCompartmentFigure result = new ShapeCompartmentFigureEx(
				getCompartmentName(), getMapMode());
		result.getContentPane().setLayoutManager(getLayoutManager());
		result.getContentPane().addLayoutListener(LayoutAnimator.getDefault());
		return result;
	}

	@Override
	public void addNotify() {
		super.addNotify();
		getViewer().addPropertyChangeListener(myGridListener);
		updateGridBehavior();
	}

	@Override
	public void removeNotify() {
		getViewer().removePropertyChangeListener(myGridListener);
		super.removeNotify();
	}

	protected void updateGridBehavior() {
		Rectangle gridSpec = getGridSpec(getViewer());
		if (gridSpec != null) {
			setScrollGridBehaviour((ResizableCompartmentFigure) getFigure());
		}
	}

	protected void setScrollGridBehaviour(
			ResizableCompartmentFigure compartmentFigure) {
		ScrollPane sp = compartmentFigure.getScrollPane();
		decorateHorizontalRange(sp);
		decorateVerticalRange(sp);
		updateStepIncrements(sp);
	}

	private void updateStepIncrements(ScrollPane pane) {
		Rectangle gridSpec = getGridSpec(getViewer());
		if (gridSpec == null) {
			return;
		}
		ScrollBar hScroll = pane.getHorizontalScrollBar();
		hScroll.setStepIncrement(gridSpec.height);
		ScrollBar wScroll = pane.getVerticalScrollBar();
		wScroll.setStepIncrement(gridSpec.width);
	}

	private void decorateVerticalRange(ScrollPane pane) {
		ScrollBar scroll = pane.getVerticalScrollBar();
		RangeModel model = scroll.getRangeModel();
		if (false == model instanceof SnapToGridRangeModel) {
			SnapToGridRangeModel range = new SnapToGridRangeModel(model);
			scroll.setRangeModel(range);
			pane.getViewport().setVerticalRangeModel(range);
		}
	}

	private void decorateHorizontalRange(ScrollPane pane) {
		ScrollBar scroll = pane.getHorizontalScrollBar();
		RangeModel model = scroll.getRangeModel();
		if (false == model instanceof SnapToGridRangeModel) {
			SnapToGridRangeModel range = new SnapToGridRangeModel(model);
			scroll.setRangeModel(range);
			pane.getViewport().setHorizontalRangeModel(range);
		}
	}

	protected static Rectangle getGridSpec(EditPartViewer viewer) {
		Boolean enabled = (Boolean) viewer
				.getProperty(SnapToGrid.PROPERTY_GRID_ENABLED);
		if (enabled == null || !enabled) {
			return null;
		}
		int gridX = 0;
		int gridY = 0;
		Point origin;
		Dimension spacing = (Dimension) viewer
				.getProperty(SnapToGrid.PROPERTY_GRID_SPACING);
		if (spacing != null) {
			gridX = spacing.width;
			gridY = spacing.height;
		}
		if (gridX == 0) {
			gridX = SnapToGrid.DEFAULT_GRID_SIZE;
		}
		if (gridY == 0) {
			gridY = SnapToGrid.DEFAULT_GRID_SIZE;
		}
		Point loc = (Point) viewer.getProperty(SnapToGrid.PROPERTY_GRID_ORIGIN);
		if (loc != null) {
			origin = loc;
		} else {
			origin = new Point();
		}

		return new Rectangle(origin.x, origin.y, gridX, gridY);

	}

	private class SnapToGridRangeModel implements RangeModel {

		private final RangeModel myBaseRangeModel;

		public SnapToGridRangeModel(RangeModel rangeModel) {
			myBaseRangeModel = rangeModel;
		}

		public void setValue(int value) {
			Rectangle gridSpec = getGridSpec(getViewer());
			if (gridSpec != null) {
				value = Math.max(value, 0);
				value = gridSpec.height * (value / gridSpec.height);
			}
			if (value + getMinimum() <= getMaximum()) {
				myBaseRangeModel.setValue(value);
			}
		}

		public void setMinimum(int min) {
			myBaseRangeModel.setMinimum(min);
		}

		public void setMaximum(int max) {
			myBaseRangeModel.setMaximum(max);
		}

		public void setExtent(int extent) {
			myBaseRangeModel.setExtent(extent);
		}

		public void setAll(int min, int extent, int max) {
			myBaseRangeModel.setAll(min, extent, max);
		}

		public void removePropertyChangeListener(PropertyChangeListener listener) {
			myBaseRangeModel.removePropertyChangeListener(listener);
		}

		public boolean isEnabled() {
			return true;
		}

		public int getValue() {
			return myBaseRangeModel.getValue();
		}

		public int getMinimum() {
			return myBaseRangeModel.getMinimum();
		}

		public int getMaximum() {
			return myBaseRangeModel.getMaximum();
		}

		public int getExtent() {
			return myBaseRangeModel.getExtent();
		}

		public void addPropertyChangeListener(PropertyChangeListener listener) {
			myBaseRangeModel.addPropertyChangeListener(listener);
		}
	}

	public static class ShapeCompartmentFigureEx extends ShapeCompartmentFigure {

		public ShapeCompartmentFigureEx(String title, IMapMode mm) {
			super(title, mm);
		}

		@Override
		protected void configureFigure(IMapMode mm) {
			ScrollPane scrollpane = getScrollPane();
			if (scrollpane == null) {
				scrollpane = scrollPane = new AnimatableScrollPaneWithMM(mm);
			}
			scrollpane.setViewport(new FreeformViewport());
			scrollPane.setScrollBarVisibility(ScrollPane.AUTOMATIC);
			scrollpane.setLayoutManager(new OverlayScrollPaneLayout());

			IFigure contents = new BorderItemsAwareFreeFormLayer();
			contents.setLayoutManager(new FreeFormLayoutEx());
			scrollpane.setContents(contents);

			int MB = mm.DPtoLP(5);
			scrollpane.setBorder(new MarginBorder(MB, MB, MB, MB));
			int SZ = mm.DPtoLP(10);
			scrollpane.setMinimumSize(new Dimension(SZ, SZ));

			this.setFont(FONT_TITLE);
		}

	}

	private static class AnimatableScrollPaneWithMM extends
			AnimatableScrollPane implements IMapMode {

		private IMapMode myMapMode;

		public AnimatableScrollPaneWithMM(IMapMode mm) {
			myMapMode = mm;
		}

		public int LPtoDP(int logicalUnit) {
			return myMapMode.LPtoDP(logicalUnit);
		}

		public int DPtoLP(int deviceUnit) {
			return myMapMode.DPtoLP(deviceUnit);
		}

		public Translatable LPtoDP(Translatable t) {
			return myMapMode.LPtoDP(t);
		}

		public Translatable DPtoLP(Translatable t) {
			return myMapMode.DPtoLP(t);
		}
	}

}
