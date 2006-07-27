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
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil;
import org.eclipse.gmf.tests.setup.figures.FigureLayoutSetup;

public class FigureLayoutTest extends FigureCodegenTestBase {
	public FigureLayoutTest(String name){
		super(name);
	}
	
	private FigureLayoutSetup getSessionSetup() {
		Assert.assertTrue("Incorrect session setup was used, use FigureLayoutSetup instead of: " + mySessionSetup, mySessionSetup instanceof FigureLayoutSetup);
		return (FigureLayoutSetup) mySessionSetup;
	}
	
	public void disabled_XXX_testGridLayout(){
		//XXX: This test now fails due to absence of the GridLayout.
		//However, some less restictive checks done for grid layout in the performGridLayputTests() method    	
		//If this test passes, it is safe to replace performGridLayputTests() with perfromTests() in the whole class.
		performTests(getSessionSetup().getParent4());
	}
	
	public void testConcreteShapeLayoutAllProperties(){
		performGridLayoutTests(getSessionSetup().getParent5());
	}
	
	public void testCustomFigureLayoutAllProperties(){
		performGridLayoutTests(getSessionSetup().getParent6());
	}
	
	public void testDeepChildrenLayout(){
		performTests(getSessionSetup().getParent());
	}
	
	public void testLayoutDefaults(){
		performGridLayoutTests(getSessionSetup().getParent7());
	}
	
	public void off_UnlessSupportFigureRef_testLayoutForReferencedChild(){
		performGridLayoutTests(getSessionSetup().getParent8());
	}
	
	public void testMissedLayoutPresentLayoutData(){
		performTests(getSessionSetup().getParent1());
	}
	
	public void testBorderLayout(){
		performTests(getSessionSetup().getParent2());
	}
	
	public void testBorderLayoutDataCenter(){
		performTests(getSessionSetup().getParent3());
	}
	
	public void testCustomLayout(){
		//generate code will be incompilable due to the absence of the TheBestLayoutManagerForever
		FigureGeneratorUtil.generateAndParse(getSessionSetup().getParent9());
	}
	
	public void testStackLayout(){
		performTests(getSessionSetup().getGroup());
	}
	
	public void testFlowLayout(){
		performTests(getSessionSetup().getGroup1());
	}

	public void testToolbarLayoutUnusedAndIncorrectValues(){
		performTests(getSessionSetup().getGroup2());
	}

	public void testToolbarLayout(){
		performTests(getSessionSetup().getGroup3());
	}
	
	public void testXYLayout(){
		Figure group = getSessionSetup().getGroup4();
// [AS]: Removed because child figures will be "checked" in any case and
// it does not makes sence to generate code for these figures separately 
// in this test.
//		Figure left = (Figure) group.getChildren().get(0);
//		Figure right = (Figure) group.getChildren().get(1);
		
		performTests(group);
//		performTests(right);
//		performTests(left);
	}
	
	public void testXYLayoutForCustomFigure(){
		performTests(getSessionSetup().getGroup5());
	}
	
	private void performGridLayoutTests(Figure figure){
		FigureGeneratorUtil.generateAndParse(figure);
	}
	
	protected void performTests(Figure f) {
		super.performTests(f, new LayoutAwareCheck(f));
	}
	
}
