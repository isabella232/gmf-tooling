/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
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

import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil;
import org.eclipse.gmf.tests.setup.figures.FigureLayoutSetup;

public class FigureLayoutTest extends FigureCodegenTestBase<FigureLayoutSetup> {
	public FigureLayoutTest(String name){
		super(name);
	}
	
	public void testGridLayout(){
		doPerformTests(getSessionSetup().getParent4());
	}
	
	public void testConcreteShapeLayoutAllProperties(){
		doPerformTests(getSessionSetup().getParent5());
	}
	
	public void testCustomFigureLayoutAllProperties(){
		doPerformTests(getSessionSetup().getParent6());
	}
	
	public void testDeepChildrenLayout(){
		doPerformTests(getSessionSetup().getParent());
	}
	
	public void testLayoutDefaults(){
		doPerformTests(getSessionSetup().getParent7());
	}
	
	public void off_UnlessSupportFigureRef_testLayoutForReferencedChild(){
		doPerformTests(getSessionSetup().getParent8());
	}
	
	public void testMissedLayoutPresentLayoutData(){
		doPerformTests(getSessionSetup().getParent1());
	}
	
	public void testBorderLayout(){
		doPerformTests(getSessionSetup().getParent2());
	}
	
	public void testBorderLayoutDataCenter(){
		doPerformTests(getSessionSetup().getParent3());
	}
	
	public void testCustomLayout(){
		//generate code will be incompilable due to the absence of the TheBestLayoutManagerForever
		FigureGeneratorUtil.generateAndParse(getSessionSetup().getParent9());
	}

	public void testCustomLayoutData(){
		doPerformTests(getSessionSetup().getFigureWithCustomLayoutData());
	}

	public void testStackLayout(){
		doPerformTests(getSessionSetup().getGroup());
	}
	
	public void testFlowLayout(){
		doPerformTests(getSessionSetup().getGroup1());
	}

	public void testToolbarLayoutUnusedAndIncorrectValues(){
		doPerformTests(getSessionSetup().getGroup2());
	}

	public void testToolbarLayout(){
		doPerformTests(getSessionSetup().getGroup3());
	}
	
	public void testXYLayout(){
		doPerformTests(getSessionSetup().getGroup4());
	}
	
	public void testXYLayoutForCustomFigure(){
		doPerformTests(getSessionSetup().getGroup5());
	}
	
	protected void doPerformTests(RealFigure f) {
		super.performTests(f, new LayoutAwareCheck(f));
	}
	
}
