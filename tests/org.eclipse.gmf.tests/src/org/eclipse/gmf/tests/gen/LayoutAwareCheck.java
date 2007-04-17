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

package org.eclipse.gmf.tests.gen;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.BorderLayout;
import org.eclipse.gmf.gmfgraph.BorderLayoutData;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FlowLayout;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.GridLayout;
import org.eclipse.gmf.gmfgraph.GridLayoutData;
import org.eclipse.gmf.gmfgraph.Layout;
import org.eclipse.gmf.gmfgraph.LayoutData;
import org.eclipse.gmf.gmfgraph.StackLayout;
import org.eclipse.gmf.gmfgraph.XYLayout;
import org.eclipse.gmf.gmfgraph.XYLayoutData;
import org.eclipse.gmf.tests.setup.figures.GenericFigureCheck;

public class LayoutAwareCheck extends GenericFigureCheck {
	//the names are different but the values are the same
	public static AlignmentCheck FLOW_AND_TOOLBAR = new AlignmentCheck(ToolbarLayout.ALIGN_TOPLEFT, ToolbarLayout.ALIGN_CENTER, ToolbarLayout.ALIGN_BOTTOMRIGHT, ToolbarLayout.ALIGN_CENTER);
	public static AlignmentCheck BORDER_VERTICAL = new AlignmentCheck(
			org.eclipse.draw2d.BorderLayout.TOP, 
			org.eclipse.draw2d.BorderLayout.CENTER, 
			org.eclipse.draw2d.BorderLayout.BOTTOM, 
			org.eclipse.draw2d.BorderLayout.CENTER);
	
	public static AlignmentCheck BORDER_HORIZONTAL = new AlignmentCheck(
			org.eclipse.draw2d.BorderLayout.LEFT, 
			org.eclipse.draw2d.BorderLayout.CENTER, 
			org.eclipse.draw2d.BorderLayout.RIGHT, 
			org.eclipse.draw2d.BorderLayout.CENTER);

	public LayoutAwareCheck(Figure eFigure) {
		super(eFigure);
	}
	
	protected void checkFigureItself(Figure gmfFigure, IFigure d2dFigure) {
		super.checkFigureItself(gmfFigure, d2dFigure);
		checkLayout(gmfFigure.getLayout(), d2dFigure.getLayoutManager());
		checkLayoutData(gmfFigure.getLayoutData(), d2dFigure);
	}

	protected void checkLayoutData(LayoutData gmf, IFigure d2dFigure) {
		if (gmf == null || d2dFigure.getParent() == null){
			return;
		}
		LayoutManager layouter = d2dFigure.getParent().getLayoutManager(); 
		if (layouter == null){
			//ok -- there is no GMF layout for parent
			return;
		}
		Object constraint = layouter.getConstraint(d2dFigure);
		//XXX: it does not work for BorderLayout -- getConstraint() always return null;
		assertTrue(gmf instanceof BorderLayoutData || constraint != null);
		
		if (gmf instanceof BorderLayoutData){
			/*
			assertTrue(constraint instanceof Integer);
			BorderLayoutData gmfData = (BorderLayoutData)gmf;
			AlignmentCheck alignmentCheck = gmfData.isVertical() ? BORDER_VERTICAL : BORDER_HORIZONTAL;
			alignmentCheck.checkAlignment(gmfData.getAlignment(), (Integer)constraint);
			*/
			//so we will just implicitly check that it has _some_ constraint
			if (d2dFigure.isVisible()){
				assertTrue(layouter instanceof org.eclipse.draw2d.BorderLayout);
				org.eclipse.draw2d.BorderLayout borderLayout = (org.eclipse.draw2d.BorderLayout)layouter;
				d2dFigure.getParent().invalidate();
				Dimension on = borderLayout.getPreferredSize(d2dFigure, 1000000, 1000000);
				d2dFigure.setVisible(false);
				d2dFigure.getParent().invalidate();
				Dimension off = borderLayout.getPreferredSize(d2dFigure, 1000000, 1000000);

				assertFalse(on.equals(off));
				
				d2dFigure.setVisible(true);
				d2dFigure.getParent().invalidate();
			}
		} else if (gmf instanceof XYLayoutData){
			assertTrue(constraint instanceof Rectangle);
			Rectangle d2dBounds = (Rectangle)constraint;
			XYLayoutData gmfData = (XYLayoutData)gmf;
			checkDimension(gmfData.getSize(), d2dBounds.getSize());
			checkPoint(gmfData.getTopLeft(), d2dBounds.getTopLeft());
		} else if (gmf instanceof GridLayoutData){
			assertTrue(constraint instanceof GridData);
			GridLayoutData gmfData = (GridLayoutData)gmf;
			GridData d2dData = (GridData)constraint;
			
			assertEquals(gmfData.isGrabExcessHorizontalSpace(), d2dData.grabExcessHorizontalSpace);
			assertEquals(gmfData.isGrabExcessVerticalSpace(), d2dData.grabExcessVerticalSpace);
			
			assertEquals(gmfData.getHorizontalSpan(), d2dData.horizontalSpan);
			assertEquals(gmfData.getVerticalSpan(), d2dData.verticalSpan);
			assertEquals(gmfData.getHorizontalIndent(), d2dData.horizontalIndent);

			if (gmfData.getSizeHint() != null) {
				checkDimension(gmfData.getSizeHint(), new Dimension(d2dData.widthHint, d2dData.heightHint));
			}

			AlignmentCheck alignmentChecker = new AlignmentCheck(GridData.BEGINNING, GridData.CENTER, GridData.END, GridData.FILL);
			alignmentChecker.checkAlignment(gmfData.getHorizontalAlignment(), d2dData.horizontalAlignment);
			alignmentChecker.checkAlignment(gmfData.getVerticalAlignment(), d2dData.verticalAlignment);
		}
	}

	protected void checkLayout(Layout gmfLayout, LayoutManager d2dLayout) {
		if (gmfLayout == null){
			//there may be d2dLayout
			return;
		}
		assertNotNull(d2dLayout);
		if (gmfLayout instanceof XYLayout){
			assertTrue(d2dLayout instanceof org.eclipse.draw2d.XYLayout);
		} else if (gmfLayout instanceof StackLayout){
			assertTrue(d2dLayout instanceof org.eclipse.draw2d.StackLayout);
		} else if (gmfLayout instanceof BorderLayout){
			assertTrue(d2dLayout instanceof org.eclipse.draw2d.BorderLayout);
			//no chance to check spacing
		} else if (gmfLayout instanceof FlowLayout){
			FlowLayout gmfFlow = (FlowLayout)gmfLayout;
			if (gmfFlow.isForceSingleLine()){
				assertTrue(d2dLayout instanceof ToolbarLayout); 
				checkToolbarLayout(gmfFlow, (ToolbarLayout)d2dLayout);
			} else {
				assertTrue(d2dLayout instanceof org.eclipse.draw2d.FlowLayout);
				checkFlowLayout(gmfFlow, (org.eclipse.draw2d.FlowLayout)d2dLayout);
			}
		} else if (gmfLayout instanceof GridLayout){
			assertTrue(d2dLayout instanceof org.eclipse.draw2d.GridLayout);
			checkGridLayout((GridLayout)gmfLayout, (org.eclipse.draw2d.GridLayout)d2dLayout);
		}
	}

	protected void checkGridLayout(GridLayout gmfLayout, org.eclipse.draw2d.GridLayout d2dLayout) {
		assertEquals(gmfLayout.isEqualWidth(), d2dLayout.makeColumnsEqualWidth);
		assertEquals(gmfLayout.getNumColumns(), d2dLayout.numColumns);
		if (gmfLayout.getMargins() != null) {
			checkDimension(gmfLayout.getMargins(), new Dimension(d2dLayout.marginWidth, d2dLayout.marginHeight));
		}
		if (gmfLayout.getSpacing() != null) {
			checkDimension(gmfLayout.getSpacing(), new Dimension(d2dLayout.horizontalSpacing, d2dLayout.verticalSpacing));
		}
	}

	protected void checkToolbarLayout(FlowLayout gmfFlow, ToolbarLayout layout) {
		if (gmfFlow.eIsSet(GMFGraphPackage.eINSTANCE.getFlowLayout_MajorSpacing())){
			assertEquals(gmfFlow.getMajorSpacing(), layout.getSpacing());
		}
		assertEquals(gmfFlow.isVertical(), !layout.isHorizontal());
		assertEquals(gmfFlow.isMatchMinorSize(), layout.getStretchMinorAxis());
		FLOW_AND_TOOLBAR.checkAlignment(gmfFlow.getMinorAlignment(), layout.getMinorAlignment());
	}
	
	protected void checkFlowLayout(FlowLayout gmfFlow, org.eclipse.draw2d.FlowLayout layout) {
		assertEquals(gmfFlow.getMajorSpacing(), layout.getMajorSpacing());
		assertEquals(gmfFlow.getMinorSpacing(), layout.getMinorSpacing());
		assertEquals(gmfFlow.isVertical(), !layout.isHorizontal());
		FLOW_AND_TOOLBAR.checkAlignment(gmfFlow.getMinorAlignment(), layout.getMinorAlignment());
		FLOW_AND_TOOLBAR.checkAlignment(gmfFlow.getMajorAlignment(), layout.getMajorAlignment());
	}

	private static class AlignmentCheck {
		private final Integer[] myExpectedValues;
		
		public AlignmentCheck(int beginning, int center, int end, int fill){
			myExpectedValues = new Integer[] {new Integer(beginning), new Integer(center), new Integer(end), new Integer(fill)};
		}
		
		public AlignmentCheck(Integer beginning, Integer center, Integer end, Integer fill){
			myExpectedValues = new Integer[] {beginning, center, end, fill};
		}

		public void checkAlignment(Alignment gmf, int actual){
			checkAlignment(gmf, new Integer(actual));
		}
		
		public void checkAlignment(Alignment gmf, Integer actual){
			if (gmf != null){
				assertEquals(myExpectedValues[gmf.getValue()], actual);
			}
		}
	}

}
