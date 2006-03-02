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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.BorderLayout;
import org.eclipse.gmf.gmfgraph.BorderLayoutData;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Layout;
import org.eclipse.gmf.gmfgraph.LayoutData;
import org.eclipse.gmf.gmfgraph.RGBColor;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;

public class RTFigureTest extends TestCase {

	public void testRTGeneration() {
		StandaloneGenerator.Config config = new StandaloneGenerator.ConfigImpl(
				"com.test.plugin." + getName() + ".t" + System.currentTimeMillis(), 
				"com.test.figures");
		FigureGallery fg = GMFGraphFactory.eINSTANCE.createFigureGallery();
		fg.setName("fg");
		fg.getFigures().add(createSampleFigure());
		StandaloneGenerator generator = new StandaloneGenerator(fg, config, new RuntimeFQNSwitch());
		generator.run();
		IStatus status = generator.getRunStatus();
		assertTrue(status.getMessage(), status.isOK());
	}
	
	private Figure createSampleFigure() {
		Figure parent = GMFGraphFactory.eINSTANCE.createRectangle();
		parent.setName("Parent");
		parent.setLayout(createLayout());

		Figure leftGreenFilled = GMFGraphFactory.eINSTANCE.createRectangle();
		leftGreenFilled.setName("LeftGreen");
		RGBColor green = GMFGraphFactory.eINSTANCE.createRGBColor();
		green.setGreen(255);
		leftGreenFilled.setBackgroundColor(green);
		leftGreenFilled.setLayoutData(createLayoutData(Alignment.BEGINNING_LITERAL, false));

		Figure rightRedOutline = GMFGraphFactory.eINSTANCE.createRectangle();
		rightRedOutline.setName("CenterRed");
		RGBColor red = GMFGraphFactory.eINSTANCE.createRGBColor();
		red.setRed(255);
		rightRedOutline.setForegroundColor(green);
		rightRedOutline.setLayoutData(createLayoutData(Alignment.FILL_LITERAL, true));
		
		CustomFigure bottomCustom = GMFGraphFactory.eINSTANCE.createCustomFigure();
		bottomCustom.setName("BottomCustom");
		bottomCustom.setBundleName("org.eclipse.gmf.runtime.diagram.ui.geoshapes");
		bottomCustom.setQualifiedClassName("org.eclipse.gmf.runtime.diagram.ui.geoshapes.internal.draw2d.figures.GeoShapeCylinderFigure");
		RGBColor blue = GMFGraphFactory.eINSTANCE.createRGBColor();
		red.setBlue(255);
		bottomCustom.setForegroundColor(blue);
		
		parent.getChildren().add(leftGreenFilled);
		parent.getChildren().add(rightRedOutline);
		parent.getChildren().add(bottomCustom);
		
		return parent;
	}

	private Layout createLayout() {
		BorderLayout layout = GMFGraphFactory.eINSTANCE.createBorderLayout();
		Dimension spacing = GMFGraphFactory.eINSTANCE.createDimension();
		spacing.setDx(7);
		spacing.setDy(8);
		layout.setSpacing(spacing);
		return layout;
	}

	private LayoutData createLayoutData(Alignment alignment, boolean isVerticalAlignment) {
		BorderLayoutData data = GMFGraphFactory.eINSTANCE.createBorderLayoutData();
		data.setAlignment(alignment);
		data.setVertical(isVerticalAlignment);
		return data;
	}

}
