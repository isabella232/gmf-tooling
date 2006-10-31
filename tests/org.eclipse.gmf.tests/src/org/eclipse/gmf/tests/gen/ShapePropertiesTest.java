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

import junit.framework.Assert;

import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.tests.setup.figures.GenericFigureCheck;
import org.eclipse.gmf.tests.setup.figures.ShapePropertiesSetup;

public class ShapePropertiesTest extends FigureCodegenTestBase {
	
	public ShapePropertiesTest(String name) {
		super(name);
	}
	
	private ShapePropertiesSetup getSessionSetup() {
		if (mySessionSetup == null){
			configure(new ShapePropertiesSetup());
		}
		Assert.assertTrue("Incorrect session setup was used, use ShapePropertiesSetup instead of: " + mySessionSetup, mySessionSetup instanceof ShapePropertiesSetup);
		return (ShapePropertiesSetup) mySessionSetup;
	}
	
	public void testShapeLineStyle() {
		doPerformTests(getSessionSetup().getContainer());
	}

	public void testShapeLineWidth() {
		doPerformTests(getSessionSetup().getShape());
	}
	
	public void testShapeFont(){
		doPerformTests(getSessionSetup().getShape1());
	}

	public void testShapeInsets() {
		doPerformTests(getSessionSetup().getWithInsets());
	}

	public void testLineBorder() {
		doPerformTests(getSessionSetup().getContainer1());
	}
	
	public void testCompoundBorder(){
		doPerformTests(getSessionSetup().getTester());
	}
	
	public void testMarginBorder(){
		doPerformTests(getSessionSetup().getMarginTester());
	}
	
	public void testCustomBorder(){
		doPerformTests(getSessionSetup().getCustomBorderTester());
	}
	
	public void testConstantColors(){
		doPerformTests(getSessionSetup().getRainbow());
	}
	
	public void testMaxAndMinSize(){
		doPerformTests(getSessionSetup().getWithMinAndMaxSize());
	}
	
	public void testDefaultFontName(){
		doPerformTests(getSessionSetup().getRoot());
	}
	
	public void testScalablePolygon(){
		doPerformTests(getSessionSetup().getScalablePolygon());
		doPerformTests(getSessionSetup().getInnerScalablePolygonTester());
	}

	protected void doPerformTests(Figure f) {
		super.performTests(f, new GenericFigureCheck(f));
	}
}
