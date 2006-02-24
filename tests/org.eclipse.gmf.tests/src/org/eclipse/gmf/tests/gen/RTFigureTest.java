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

import junit.framework.TestCase;

import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.GridLayout;
import org.eclipse.gmf.gmfgraph.GridLayoutData;
import org.eclipse.gmf.gmfgraph.RGBColor;

public class RTFigureTest extends TestCase {

	public void testRTGeneration() {
		GMFGraphGenerator.Config config = new GMFGraphGenerator.ConfigImpl(
				"com.test.plugin." + getName() + ".t" + System.currentTimeMillis(), 
				"com.test.figures");
		GMFGraphGenerator.GMFGraphTree tree = new GMFGraphGenerator.GMFGraphTree.EObjectAdapter(createSampleFigure());
		GMFGraphGenerator generator = new GMFGraphGenerator(tree, config);
		generator.run();
		assertTrue(generator.getRunStatus().isOK());
	}
	
	private Figure createSampleFigure() {
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setName("Parent");
		parent.setLayout(createGridLayout());

		Figure leftGreenFilled = GMFGraphFactory.eINSTANCE.createRectangle();
		leftGreenFilled.setName("LeftGreen");
		RGBColor green = GMFGraphFactory.eINSTANCE.createRGBColor();
		green.setGreen(255);
		leftGreenFilled.setBackgroundColor(green);
		leftGreenFilled.setLayoutData(createGridLayoutData(true));

		Figure rightRedOutline = GMFGraphFactory.eINSTANCE.createRectangle();
		rightRedOutline.setName("RightRed");
		RGBColor red = GMFGraphFactory.eINSTANCE.createRGBColor();
		red.setRed(255);
		rightRedOutline.setForegroundColor(green);
		rightRedOutline.setLayoutData(createGridLayoutData(false));
		
		parent.getChildren().add(leftGreenFilled);
		parent.getChildren().add(rightRedOutline);
		
		return parent;
	}

	private GridLayout createGridLayout() {
		GridLayout layout = GMFGraphFactory.eINSTANCE.createGridLayout();
		layout.setEqualWidth(true);
		layout.setNumColumns(2);

		Dimension margins = GMFGraphFactory.eINSTANCE.createDimension();
		margins.setDx(5);
		margins.setDy(10);
		layout.setMargins(margins);

		Dimension spacing = GMFGraphFactory.eINSTANCE.createDimension();
		spacing.setDx(7);
		spacing.setDy(8);
		layout.setSpacing(spacing);

		return layout;
	}

	private GridLayoutData createGridLayoutData(boolean horizontalBeginningNotEnd) {
		GridLayoutData data = GMFGraphFactory.eINSTANCE.createGridLayoutData();
		data.setGrabExcessHorizontalSpace(true);
		data.setGrabExcessVerticalSpace(false);
		data.setHorizontalAlignment(horizontalBeginningNotEnd ? Alignment.BEGINNING_LITERAL : Alignment.END_LITERAL);
		data.setVerticalAlignment(Alignment.CENTER_LITERAL);
		data.setHorizontalIndent(5);
		data.setHorizontalSpan(1);
		data.setVerticalSpan(1);
		return data;
	}

}
