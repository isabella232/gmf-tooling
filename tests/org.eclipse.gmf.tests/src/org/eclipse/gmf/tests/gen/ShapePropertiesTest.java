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

import org.eclipse.gmf.tests.setup.figures.ShapePropertiesSetup;

public class ShapePropertiesTest extends FigureCodegenTestBase {
	
	public ShapePropertiesTest(String name) {
		super(name);
	}
	
	private ShapePropertiesSetup getSessionSetup() {
		Assert.assertTrue("Incorrect session setup was used, use FigureCodegenSetup instead of: " + mySessionSetup, mySessionSetup instanceof ShapePropertiesSetup);
		return (ShapePropertiesSetup) mySessionSetup;
	}
	
	public void testShapeLineStyle() {
		performTests(getSessionSetup().getContainer());
	}

	public void testShapeLineWidth() {
		performTests(getSessionSetup().getShape());
	}
	
	public void testShapeFont(){
		performTests(getSessionSetup().getShape1());
	}

	public void testShapeInsets() {
		performTests(getSessionSetup().getWithInsets());
	}

	public void testLineBorder() {
		performTests(getSessionSetup().getContainer1());
	}
	
	public void testCompoundBorder(){
		performTests(getSessionSetup().getTester());
	}
	
	public void testMarginBorder(){
		performTests(getSessionSetup().getMarginTester());
	}
	
	public void testConstantColors(){
		performTests(getSessionSetup().getRainbow());
	}
	
	public void testMaxAndMinSize(){
		performTests(getSessionSetup().getWithMinAndMaxSize());
	}
	
	public void testDefaultFontName(){
		performTests(getSessionSetup().getRoot());
	}
	
}
